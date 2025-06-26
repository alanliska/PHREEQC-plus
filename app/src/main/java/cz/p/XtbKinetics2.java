package cz.p;

import static cz.p.Spannables.colorized_elements;
import static cz.p.Spannables.colorized_numbers;
import static cz.p.Spannables.colorized_xtb;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Scanner;

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

public class XtbKinetics2 extends MainActivity {

    private TextView desc_label;
    private TextView reactant_label;
    private TextView reactant_formulas_label;
    private TextView details_label;
    private TextView product_label;
    private TextView product_formulas_label;
    private TextView process_label;

    private EditText product_formulas;
    private EditText process;
    private EditText details;
    private EditText reactant_xyz;
    private EditText reactant_formulas;
    private EditText product_xyz;

    private Button runbutton;
    private Button execbutton;
    private Button quit;
    private Button reactant_Button;
    private Button product_Button;

    Button openCommandfile;
    Button openIntCommandfile;
    Button saveCommandfile;
    Button saveExtCommandfile;

    Button openInfile;
    Button openIntInfile;
    Button saveInfile;
    Button saveExtInfile;
    Button reactant_generateXYZ;
    Button reactant_opsinXYZ;
    Button reactant_ToCanvas;
    Button product_generateXYZ;
    Button product_opsinXYZ;
    Button product_ToCanvas;

    private Handler handler = new Handler();

    private static final int READ_FILE26 = 3526;
    private Uri documentUri26;
    private static final int CREATE_FILE01 = 351;
    private Uri documentUri1;
    private static final int READ_FILE60 = 3560;
    private Uri documentUri60;
    private static final int CREATE_FILE200 = 35200;
    private Uri documentUri200;

    private static final int READ_FILE888 = 35888;
    private Uri documentUri888;
    private static final int READ_FILE999 = 35999;
    private Uri documentUri999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.xtbkinetics2);

        desc_label = (TextView) findViewById(R.id.desc_label);
        reactant_label = (TextView) findViewById(R.id.reactant_label);
        reactant_formulas_label = (TextView) findViewById(R.id.reactant_formulas_label);
        process_label = (TextView) findViewById(R.id.process_label);
        details_label = (TextView) findViewById(R.id.details_label);
        product_label = (TextView) findViewById(R.id.product_label);
        product_formulas_label = (TextView) findViewById(R.id.product_formulas_label);

        product_formulas = (EditText) findViewById(R.id.product_formulas);
        product_formulas.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        product_formulas.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                product_formulas.removeTextChangedListener(this);
                String text = product_formulas.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                product_formulas.getText().clear();
                product_formulas.append(colorized_xtb(text));
                // place the cursor at the original position
                product_formulas.setSelection(startChanged+countChanged);
                product_formulas.addTextChangedListener(this);
            }
        });
        process = (EditText) findViewById(R.id.process);
        process.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        process.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                process.removeTextChangedListener(this);
                String text = process.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                process.getText().clear();
                process.append(colorized_xtb(text));
                // place the cursor at the original position
                process.setSelection(startChanged+countChanged);
                process.addTextChangedListener(this);
            }
        });
        details = (EditText) findViewById(R.id.details);
        details.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        details.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                details.removeTextChangedListener(this);
                String text = details.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                details.getText().clear();
                details.append(colorized_xtb(text));
                // place the cursor at the original position
                details.setSelection(startChanged+countChanged);
                details.addTextChangedListener(this);
            }
        });
        reactant_xyz = (EditText) findViewById(R.id.reactant_xyz);
        reactant_xyz.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        reactant_xyz.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                reactant_xyz.removeTextChangedListener(this);
                String text = reactant_xyz.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                reactant_xyz.getText().clear();
                reactant_xyz.append(colorized_elements(text));
                // place the cursor at the original position
                reactant_xyz.setSelection(startChanged+countChanged);
                reactant_xyz.addTextChangedListener(this);
            }
        });
        reactant_formulas = (EditText) findViewById(R.id.reactant_formulas);
        reactant_formulas.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        reactant_formulas.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                reactant_formulas.removeTextChangedListener(this);
                String text = reactant_formulas.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                reactant_formulas.getText().clear();
                reactant_formulas.append(colorized_xtb(text));
                // place the cursor at the original position
                reactant_formulas.setSelection(startChanged+countChanged);
                reactant_formulas.addTextChangedListener(this);
            }
        });
        product_xyz = (EditText) findViewById(R.id.product_xyz);
        product_xyz.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        product_xyz.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                product_xyz.removeTextChangedListener(this);
                String text = product_xyz.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                product_xyz.getText().clear();
                product_xyz.append(colorized_elements(text));
                // place the cursor at the original position
                product_xyz.setSelection(startChanged+countChanged);
                product_xyz.addTextChangedListener(this);
            }
        });

        runbutton = (Button) findViewById(R.id.runbutton);
        runbutton.setOnClickListener(runbuttonClick);
        execbutton = (Button) findViewById(R.id.execbutton);
        execbutton.setOnClickListener(execbuttonClick);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(QuitClick);

        openCommandfile = (Button) findViewById(R.id.openCommandfile);
        openCommandfile.setOnClickListener(openCommandfileClick);
        openIntCommandfile = (Button) findViewById(R.id.openIntCommandfile);
        saveCommandfile = (Button) findViewById(R.id.saveCommandfile);
        saveCommandfile.setOnClickListener(saveCommandfileClick);
        saveExtCommandfile = (Button) findViewById(R.id.saveExtCommandfile);
        saveExtCommandfile.setOnClickListener(saveExtCommandfileClick);

        openInfile = (Button) findViewById(R.id.openInfile);
        openInfile.setOnClickListener(openInfileClick);
        openIntInfile = (Button) findViewById(R.id.openIntInfile);
        saveInfile = (Button) findViewById(R.id.saveInfile);
        saveInfile.setOnClickListener(saveInfileClick);
        saveExtInfile = (Button) findViewById(R.id.saveExtInfile);
        saveExtInfile.setOnClickListener(saveExtInfileClick);

        openIntInfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XtbKinetics2.this, XtbKin2Work1.class);
                startActivity(intent);
            }
        });

        openIntCommandfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XtbKinetics2.this, XtbKin2Command.class);
                startActivity(intent);
            }
        });

        reactant_Button = (Button) findViewById(R.id.reactant_Button);
        reactant_Button.setOnClickListener(reactant_ButtonClick);
        product_Button = (Button) findViewById(R.id.product_Button);
        product_Button.setOnClickListener(product_ButtonClick);

        reactant_generateXYZ = (Button) findViewById(R.id.reactant_generateXYZ);
        reactant_generateXYZ.setOnClickListener(reactant_generateXYZClick);
        reactant_opsinXYZ = (Button) findViewById(R.id.reactant_opsinXYZ);
        reactant_opsinXYZ.setOnClickListener(reactant_opsinXYZClick);
        reactant_ToCanvas = (Button) findViewById(R.id.reactant_ToCanvas);
        reactant_ToCanvas.setOnClickListener(reactant_ToCanvasClick);

        product_generateXYZ = (Button) findViewById(R.id.product_generateXYZ);
        product_generateXYZ.setOnClickListener(product_generateXYZClick);
        product_opsinXYZ = (Button) findViewById(R.id.product_opsinXYZ);
        product_opsinXYZ.setOnClickListener(product_opsinXYZClick);
        product_ToCanvas = (Button) findViewById(R.id.product_ToCanvas);
        product_ToCanvas.setOnClickListener(product_ToCanvasClick);
    }

    public void onStart()
    {
        super.onStart();
        XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
        XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
        FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
        FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
        ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
        DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));

    }

    private View.OnClickListener reactant_ToCanvasClick; {

        reactant_ToCanvasClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

//                ProgressDialog progressDialog = new ProgressDialog(XtbKinetics2.this);
//                progressDialog.setTitle("Please wait...");
//                progressDialog.setMessage("Exporting the structure...");
//                progressDialog.setCancelable(false);
//                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//                progressDialog.show();
//
//                new Thread() {
//                    public void run() {

                        try {
                            FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(XyzR);
                            outputWriter.close();
                            FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(XyzP);
                            outputWriter2.close();
                            FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(FormulaR);
                            outputWriter3.close();
                            FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                            outputWriter8.write(FormulaP);
                            outputWriter8.close();
                            FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                            outputWriter6.write(Process);
                            outputWriter6.close();
                            FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                            OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                            outputWriter10.write(Details);
                            outputWriter10.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String XYZfile = exec("cat "+getFilesDir()+"/Xtb_xyzR.txt");
                        try {
                            while (XYZfile.contains("\t")){  //2 spaces
                                XYZfile = XYZfile.replace("\t", " "); //(2 spaces, 1 space)
                            }
                            while (XYZfile.contains("  ")){  //2 spaces
                                XYZfile = XYZfile.replace("  ", " "); //(2 spaces, 1 space)
                            }
                            while (XYZfile.contains("\n ")){  //2 spaces
                                XYZfile = XYZfile.replace("\n ", "\n"); //(2 spaces, 1 space)
                            }

                            // remove first two lines
                            // XYZfile = XYZfile.substring(XYZfile.indexOf(System.getProperty("line.separator")) + 2);
                            // remove first line
                            XYZfile = XYZfile.substring(XYZfile.indexOf(System.getProperty("line.separator"))+1);
                            // remove second line
                            XYZfile = XYZfile.substring(XYZfile.indexOf(System.getProperty("line.separator"))+1);
                            MolCanvas_reactant_canvasView.zmat.clear();
                            int lineNum = 0;
                            String[] curLine = XYZfile.split("\\n");
                            for (String s : curLine) {
                                lineNum++;
                                String[] splitted = s.split("\\s");
                                String atom = splitted[0].trim();
                                String x_coord_str = splitted[1].trim();
                                String y_coord_str = splitted[2].trim();
                                String z_coord_str = splitted[3].trim();
                                float x_coord = Float.valueOf(x_coord_str);
                                float y_coord = Float.valueOf(y_coord_str);
                                float z_coord = Float.valueOf(z_coord_str);
                                // important: border color is at first run black, there is no other set yet (in MolCanvas_main nor MolCanvas_periodicTable)
                                MolCanvas_reactant_canvasView.zmat.add(new MolCanvas_object(lineNum, atom, MolCanvas_methods.getElementColor(atom),
                                        Color.BLACK, MolCanvas_methods.getElementRadius(atom),
                                        MolCanvas_methods.Radius_pix(MolCanvas_methods.getElementRadius(atom),
                                                MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_preferences.get().getValue("radius_scale"), MolCanvas_reactant.zoom_scale, z_coord),
                                        0, x_coord, y_coord, z_coord,
                                        MolCanvas_methods.AtomX_pix(x_coord, MolCanvas_preferences.get().getValue("conv"), MolCanvas_reactant_canvasView.width_pix,
                                                MolCanvas_reactant.zoom_scale),
                                        MolCanvas_methods.AtomY_pix(y_coord, MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_reactant_canvasView.height_pix, MolCanvas_reactant.zoom_scale),
                                        0, "", MolCanvas_methods.getElementTextColor(atom), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                        z_coord, 0.0f, 0.0f, 0.0f, 1));
                            }
                            for (MolCanvas_object object : MolCanvas_reactant_canvasView.zmat) {
                                if (object.getObjectType() == 1) {
                                    MolCanvas_reactant.generatedLabels.add(new MolCanvas_object(object.getAtomNumber1(), object.getAtomSymbol1(),
                                            MolCanvas_methods.getElementTextColor(object.getAtomSymbol1()),
                                            object.getAtomBorderColor1(), 0,
                                            MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), MolCanvas_reactant.zoom_scale,
                                                    object.getAtom1Z_Ang()),
                                            object.getTouchTime(), object.getAtom1X_Ang(), object.getAtom1Y_Ang(),
                                            object.getAtom1Z_Ang(),
                                            object.getAtom1X_pix() + MolCanvas_preferences.get().getValue("text_shift_x_pix"),
                                            object.getAtom1Y_pix() + MolCanvas_preferences.get().getValue("text_shift_y_pix"), 0, "",
                                            0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                            object.getAtom12Z_Ang() + MolCanvas_preferences.get().getValue("text_shift_z_Ang"), 0.0f,
                                            0.0f, object.getDist2D_pix(), 4));
                                }
                            }
                            MolCanvas_reactant_canvasView.zmat.addAll(MolCanvas_reactant.generatedLabels);
                            MolCanvas_reactant.generatedLabels.clear();
                            MolCanvas_reactant.generateAllBonds();
                            MolCanvas_reactant_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(XtbKinetics2.this, MolCanvas_reactant.class);
                        startActivity(intent);

//                        onFinish();
//                    }
//                    public void onFinish() {
//                        progressDialog.dismiss();
//                    }
//                }.start();

            }
        };
    }


    private View.OnClickListener product_ToCanvasClick; {

        product_ToCanvasClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

//                ProgressDialog progressDialog = new ProgressDialog(XtbKinetics2.this);
//                progressDialog.setTitle("Please wait...");
//                progressDialog.setMessage("Exporting the structure...");
//                progressDialog.setCancelable(false);
//                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//                progressDialog.show();
//
//                new Thread() {
//                    public void run() {

                        try {
                            FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(XyzR);
                            outputWriter.close();
                            FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(XyzP);
                            outputWriter2.close();
                            FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(FormulaR);
                            outputWriter3.close();
                            FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                            outputWriter8.write(FormulaP);
                            outputWriter8.close();
                            FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                            outputWriter6.write(Process);
                            outputWriter6.close();
                            FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                            OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                            outputWriter10.write(Details);
                            outputWriter10.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String XYZfile = exec("cat "+getFilesDir()+"/Xtb_xyzP.txt");
                        try {
                            while (XYZfile.contains("\t")){  //2 spaces
                                XYZfile = XYZfile.replace("\t", " "); //(2 spaces, 1 space)
                            }
                            while (XYZfile.contains("  ")){  //2 spaces
                                XYZfile = XYZfile.replace("  ", " "); //(2 spaces, 1 space)
                            }
                            while (XYZfile.contains("\n ")){  //2 spaces
                                XYZfile = XYZfile.replace("\n ", "\n"); //(2 spaces, 1 space)
                            }

                            // remove first two lines
                            // XYZfile = XYZfile.substring(XYZfile.indexOf(System.getProperty("line.separator")) + 2);
                            // remove first line
                            XYZfile = XYZfile.substring(XYZfile.indexOf(System.getProperty("line.separator"))+1);
                            // remove second line
                            XYZfile = XYZfile.substring(XYZfile.indexOf(System.getProperty("line.separator"))+1);
                            MolCanvas_product_canvasView.zmat.clear();
                            int lineNum = 0;
                            String[] curLine = XYZfile.split("\\n");
                            for (String s : curLine) {
                                lineNum++;
                                String[] splitted = s.split("\\s");
                                String atom = splitted[0].trim();
                                String x_coord_str = splitted[1].trim();
                                String y_coord_str = splitted[2].trim();
                                String z_coord_str = splitted[3].trim();
                                float x_coord = Float.valueOf(x_coord_str);
                                float y_coord = Float.valueOf(y_coord_str);
                                float z_coord = Float.valueOf(z_coord_str);
                                // important: border color is at first run black, there is no other set yet (in MolCanvas_main nor MolCanvas_periodicTable)
                                MolCanvas_product_canvasView.zmat.add(new MolCanvas_object(lineNum, atom, MolCanvas_methods.getElementColor(atom),
                                        Color.BLACK, MolCanvas_methods.getElementRadius(atom),
                                        MolCanvas_methods.Radius_pix(MolCanvas_methods.getElementRadius(atom),
                                                MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_preferences.get().getValue("radius_scale"), MolCanvas_product.zoom_scale, z_coord),
                                        0, x_coord, y_coord, z_coord,
                                        MolCanvas_methods.AtomX_pix(x_coord, MolCanvas_preferences.get().getValue("conv"), MolCanvas_product_canvasView.width_pix,
                                                MolCanvas_product.zoom_scale),
                                        MolCanvas_methods.AtomY_pix(y_coord, MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_product_canvasView.height_pix, MolCanvas_product.zoom_scale),
                                        0, "", MolCanvas_methods.getElementTextColor(atom), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                        z_coord, 0.0f, 0.0f, 0.0f, 1));
                            }
                            for (MolCanvas_object object : MolCanvas_product_canvasView.zmat) {
                                if (object.getObjectType() == 1) {
                                    MolCanvas_product.generatedLabels.add(new MolCanvas_object(object.getAtomNumber1(), object.getAtomSymbol1(),
                                            MolCanvas_methods.getElementTextColor(object.getAtomSymbol1()),
                                            object.getAtomBorderColor1(), 0,
                                            MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), MolCanvas_product.zoom_scale,
                                                    object.getAtom1Z_Ang()),
                                            object.getTouchTime(), object.getAtom1X_Ang(), object.getAtom1Y_Ang(),
                                            object.getAtom1Z_Ang(),
                                            object.getAtom1X_pix() + MolCanvas_preferences.get().getValue("text_shift_x_pix"),
                                            object.getAtom1Y_pix() + MolCanvas_preferences.get().getValue("text_shift_y_pix"), 0, "",
                                            0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                            object.getAtom12Z_Ang() + MolCanvas_preferences.get().getValue("text_shift_z_Ang"), 0.0f,
                                            0.0f, object.getDist2D_pix(), 4));
                                }
                            }
                            MolCanvas_product_canvasView.zmat.addAll(MolCanvas_product.generatedLabels);
                            MolCanvas_product.generatedLabels.clear();
                            MolCanvas_product.generateAllBonds();
                            MolCanvas_product_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(XtbKinetics2.this, MolCanvas_product.class);
                        startActivity(intent);

//                        onFinish();
//                    }
//                    public void onFinish() {
//                        progressDialog.dismiss();
//                    }
//                }.start();

            }
        };
    }

    private View.OnClickListener reactant_generateXYZClick; {

        reactant_generateXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                reactant_alertGenerateXYZ();
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }


    public void reactant_alertGenerateXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(XtbKinetics2.this);
        editText100.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText100.setTypeface(Typeface.MONOSPACE);
        editText100.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                editText100.removeTextChangedListener(this);
                String text = editText100.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText100.getText().clear();
                editText100.append(colorized_numbers(text));
                // place the cursor at the original position
                editText100.setSelection(startChanged+countChanged);
                editText100.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(XtbKinetics2.this)
                .setMessage("Please write the SMILES string to be converted to XYZ. ")
                .setTitle("OpenBABEL conversion")
                .setView(editText100)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String SmilesString = editText100.getText().toString();
//                        String InputFile = MopacInput.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput("temp.smi", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(SmilesString);
                            outputWriter.close();

                            // String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+"/temp.smi -oxyz --gen3d");
                            com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi temp.smi -oxyz --gen3d > ObabelOutput.txt");
                            String ObabelOutput = exec("cat "+getFilesDir()+"/ObabelOutput.txt");

                            FileOutputStream fileout3 = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText100.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

    private View.OnClickListener reactant_opsinXYZClick; {

        reactant_opsinXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                reactant_alertOpsinXYZ();
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }


    public void reactant_alertOpsinXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(XtbKinetics2.this);
        editText100.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText100.setTypeface(Typeface.MONOSPACE);
        editText100.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                editText100.removeTextChangedListener(this);
                String text = editText100.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText100.getText().clear();
                editText100.append(colorized_numbers(text));
                // place the cursor at the original position
                editText100.setSelection(startChanged+countChanged);
                editText100.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(XtbKinetics2.this)
                .setMessage("Please write the chemical name according to IUPAC to XYZ conversion. The result will be displayed as the updated reactant XYZ file.")
                .setTitle("OPSIN+OpenBABEL conversion")
                .setView(editText100)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String SmilesString = editText100.getText().toString();
//                        String InputFile = MopacInput.getText().toString();
                        try {
                            ////////////////////////////////////
                            NameToStructure nts = NameToStructure.getInstance();
                            NameToStructureConfig ntsconfig = new NameToStructureConfig();
//a new NameToStructureConfig starts as a copy of OPSIN's default configuration
                            ntsconfig.setAllowRadicals(true);
//                OpsinResult result = nts.parseChemicalName("acetamide", ntsconfig);
                            OpsinResult result = nts.parseChemicalName(SmilesString+"", ntsconfig);
                            String smiles = result.getSmiles();
                            /////////////////////////////////////
                            FileOutputStream fileout2 = openFileOutput("temp.smi", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(smiles);
                            outputWriter2.close();

                            // String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+"/temp.smi -oxyz --gen3d");
                            com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi temp.smi -oxyz --gen3d > ObabelOutput.txt");
                            String ObabelOutput = exec("cat "+getFilesDir()+"/ObabelOutput.txt");

                            FileOutputStream fileout3 = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText100.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

    private View.OnClickListener product_generateXYZClick; {

        product_generateXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                product_alertGenerateXYZ();
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }


    public void product_alertGenerateXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(XtbKinetics2.this);
        editText100.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText100.setTypeface(Typeface.MONOSPACE);
        editText100.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                editText100.removeTextChangedListener(this);
                String text = editText100.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText100.getText().clear();
                editText100.append(colorized_numbers(text));
                // place the cursor at the original position
                editText100.setSelection(startChanged+countChanged);
                editText100.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(XtbKinetics2.this)
                .setMessage("Please write the SMILES string to be converted to XYZ. ")
                .setTitle("OpenBABEL conversion")
                .setView(editText100)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String SmilesString = editText100.getText().toString();
//                        String InputFile = MopacInput.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput("temp.smi", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(SmilesString);
                            outputWriter.close();

                            // String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+"/temp.smi -oxyz --gen3d");
                            com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi temp.smi -oxyz --gen3d > ObabelOutput.txt");
                            String ObabelOutput = exec("cat "+getFilesDir()+"/ObabelOutput.txt");

                            FileOutputStream fileout3 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText100.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

    private View.OnClickListener product_opsinXYZClick; {

        product_opsinXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                product_alertOpsinXYZ();
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }


    public void product_alertOpsinXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(XtbKinetics2.this);
        editText100.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText100.setTypeface(Typeface.MONOSPACE);
        editText100.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                editText100.removeTextChangedListener(this);
                String text = editText100.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText100.getText().clear();
                editText100.append(colorized_numbers(text));
                // place the cursor at the original position
                editText100.setSelection(startChanged+countChanged);
                editText100.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(XtbKinetics2.this)
                .setMessage("Please write the chemical name according to IUPAC to XYZ conversion. The result will be displayed as the updated product XYZ file.")
                .setTitle("OPSIN+OpenBABEL conversion")
                .setView(editText100)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String SmilesString = editText100.getText().toString();
//                        String InputFile = MopacInput.getText().toString();
                        try {
                            ////////////////////////////////////
                            NameToStructure nts = NameToStructure.getInstance();
                            NameToStructureConfig ntsconfig = new NameToStructureConfig();
//a new NameToStructureConfig starts as a copy of OPSIN's default configuration
                            ntsconfig.setAllowRadicals(true);
//                OpsinResult result = nts.parseChemicalName("acetamide", ntsconfig);
                            OpsinResult result = nts.parseChemicalName(SmilesString+"", ntsconfig);
                            String smiles = result.getSmiles();
                            /////////////////////////////////////
                            FileOutputStream fileout2 = openFileOutput("temp.smi", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(smiles);
                            outputWriter2.close();

                            // String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+"/temp.smi -oxyz --gen3d");
                            com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi temp.smi -oxyz --gen3d > ObabelOutput.txt");
                            String ObabelOutput = exec("cat "+getFilesDir()+"/ObabelOutput.txt");

                            FileOutputStream fileout3 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText100.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

    private View.OnClickListener reactant_ButtonClick; {

        reactant_ButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read888(getApplicationContext());
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }

    private View.OnClickListener product_ButtonClick; {

        product_ButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read999(getApplicationContext());
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }

    private View.OnClickListener openInfileClick; {

        openInfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read26(getApplicationContext());
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }

    private View.OnClickListener openCommandfileClick; {

        openCommandfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read60(getApplicationContext());
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }

    private View.OnClickListener saveExtInfileClick; {

        saveExtInfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write0(getApplicationContext());
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }

    private View.OnClickListener saveExtCommandfileClick; {

        saveExtCommandfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write10(getApplicationContext());
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }

    private void read26(Context context26) {
        Intent intent26 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent26.addCategory(Intent.CATEGORY_OPENABLE);
        intent26.setType("text/plain");
        startActivityForResult(intent26, READ_FILE26);
    }

    private void write0(Context context0) {
        Intent intent0 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent0.addCategory(Intent.CATEGORY_OPENABLE);
        intent0.setType("text/plain");
        intent0.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent0, CREATE_FILE01);
    }

    private void read60(Context context60) {
        Intent intent60 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent60.addCategory(Intent.CATEGORY_OPENABLE);
        intent60.setType("text/plain");
        startActivityForResult(intent60, READ_FILE60);
    }

    private void write10(Context context10) {
        Intent intent10 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent10.addCategory(Intent.CATEGORY_OPENABLE);
        intent10.setType("text/plain");
        intent10.putExtra(Intent.EXTRA_TITLE,"MyCommand");
        startActivityForResult(intent10, CREATE_FILE200);
    }

    private void read888(Context context888) {
        Intent intent888 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent888.addCategory(Intent.CATEGORY_OPENABLE);
        intent888.setType("text/plain");
        startActivityForResult(intent888, READ_FILE888);
    }

    private void read999(Context context999) {
        Intent intent999 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent999.addCategory(Intent.CATEGORY_OPENABLE);
        intent999.setType("text/plain");
        startActivityForResult(intent999, READ_FILE999);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE26 && data != null) {
            try {
                documentUri26 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd26 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd26.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd26.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE01 && data != null) {
            // save input file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {

                String fileContentsX = details.getText().toString();
                FileOutputStream fileout = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContentsX + "\n");
                outputWriter.close();

                documentUri1 = data.getData();
                ParcelFileDescriptor pfd0 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd0.getFileDescriptor());
//                String fileContents = InputFile.getText().toString();
                String fileContents0 = exec("cat "+getFilesDir()+"/XtbKin.inp");
                fileOutputStream.write((fileContents0 + "\n").getBytes());
                fileOutputStream.close();
                pfd0.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE60 && data != null) {
            try {
                documentUri60 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd60 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd60.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd60.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE200 && data != null) {
            // save command file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri200 = data.getData();
                ParcelFileDescriptor pfd200 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd200.getFileDescriptor());
                String fileContents = process.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd200.close();
                FileOutputStream fileout = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents);
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE888 && data != null) {
            try {
                documentUri888 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd888 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd888.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd888.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE999 && data != null) {
            try {
                documentUri999 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd999 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd999.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd999.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private View.OnClickListener saveInfileClick; {

        saveInfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveIn();
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }


    public void alertSaveIn(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(XtbKinetics2.this);
        editText10.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText10.setTypeface(Typeface.MONOSPACE);
        editText10.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                editText10.removeTextChangedListener(this);
                String text = editText10.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText10.getText().clear();
                editText10.append(colorized_numbers(text));
                // place the cursor at the original position
                editText10.setSelection(startChanged+countChanged);
                editText10.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(XtbKinetics2.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/xtb_kin_work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = details.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile+"\n");
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/xtb_kin_work");
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }


    private View.OnClickListener saveCommandfileClick; {

        saveCommandfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XyzR = reactant_xyz.getText().toString();
                String XyzP = product_xyz.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XyzR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(XyzP);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(FormulaR);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulaP);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Process);
                    outputWriter6.close();
                    FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(Details);
                    outputWriter10.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveCommand();
                XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }


    public void alertSaveCommand(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(XtbKinetics2.this);
        editText10.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText10.setTypeface(Typeface.MONOSPACE);
        editText10.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                editText10.removeTextChangedListener(this);
                String text = editText10.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText10.getText().clear();
                editText10.append(colorized_numbers(text));
                // place the cursor at the original position
                editText10.setSelection(startChanged+countChanged);
                editText10.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(XtbKinetics2.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/xtb_kin_commands")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = process.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/xtb_kin_commands");
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

    private View.OnClickListener runbuttonClick; {

        runbuttonClick = new View.OnClickListener() {
            public void onClick(View v) {

                String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                String DatasetName1 = DatasetName0.replace(" ","_");
                String DatasetName = DatasetName1.replace(",",".");
                progressDialog = new ProgressDialog(XtbKinetics2.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Performing XTB calculations on species contained in dataset: "+DatasetName0);
                progressDialog.setCancelable(false);
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                progressDialog.show();
                new Thread() {
                    public void run() {
                        // update: resolved!, progressdialog is already working - see the comment at the end of new thread block
                        /////////////////////////// SAVE EVERYTHING PRE-SET ////////////////////////////////
                        String XyzR = reactant_xyz.getText().toString();
                        String XyzP = product_xyz.getText().toString();
                        String FormulaR = reactant_formulas.getText().toString();
                        String FormulaP = product_formulas.getText().toString();
                        String Process = process.getText().toString();
                        String Details = details.getText().toString();

                        try {

                            FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(XyzR);
                            outputWriter.close();
                            FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(XyzP);
                            outputWriter2.close();
                            FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(FormulaR);
                            outputWriter3.close();
                            FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                            outputWriter8.write(FormulaP);
                            outputWriter8.close();
                            FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                            outputWriter6.write(Process);
                            outputWriter6.close();
                            FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                            OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                            outputWriter10.write(Details);
                            outputWriter10.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        /////////////////////////// THEN CONTINUE ////////////////////////////////
                        Process = Process.replace(" cpx ", " "+getApplicationInfo().nativeLibraryDir+"/libcpx.so ");
                        Process = Process.replace(" dftd4 ", " "+getApplicationInfo().nativeLibraryDir+"/libdftd4.so ");
                        Process = Process.replace(" multicharge ", " "+getApplicationInfo().nativeLibraryDir+"/libmulticharge.so ");
                        Process = Process.replace(" numsa-exe ", " "+getApplicationInfo().nativeLibraryDir+"/libnumsa-exe.so ");
                        Process = Process.replace(" s-dftd3 ", " "+getApplicationInfo().nativeLibraryDir+"/libs-dftd3.so ");
                        Process = Process.replace(" tblite ", " "+getApplicationInfo().nativeLibraryDir+"/libtblite.so ");
                        Process = Process.replace(" obabel ", " "+getApplicationInfo().nativeLibraryDir+"/libobabel.so ");
                        Process = Process.replace(" dftb ", " "+getApplicationInfo().nativeLibraryDir+"/libdftb.so ");
                        Process = Process.replace(" qcxms ", " "+getApplicationInfo().nativeLibraryDir+"/libqcxms.so ");
                        Process = Process.replace(" modes ", " "+getApplicationInfo().nativeLibraryDir+"/libmodes.so ");
                        Process = Process.replace(" xbbc ", " "+getApplicationInfo().nativeLibraryDir+"/libxbbc.so ");
                        Process = Process.replace(" xbvm ", " "+getApplicationInfo().nativeLibraryDir+"/libxbvm.so ");
                        Process = Process.replace(" plotms ", " "+getApplicationInfo().nativeLibraryDir+"/libplotms.so ");
                        Process = Process.replace(" stda ", " "+getApplicationInfo().nativeLibraryDir+"/libstda.so ");
                        Process = Process.replace(" xtb ", " "+getApplicationInfo().nativeLibraryDir+"/libxtb.so ");
                        Process = Process.replace(" xtb4stda ", " "+getApplicationInfo().nativeLibraryDir+"/libxtb4stda.so ");
                        Process = Process.replace(" waveplot ", " "+getApplicationInfo().nativeLibraryDir+"/libwaveplot.so ");
                        Process = Process.replace(" chimescalc ", " "+getApplicationInfo().nativeLibraryDir+"/libchimescalc.so ");
                        Process = Process.replace(" crest ", " "+getApplicationInfo().nativeLibraryDir+"/libcrest.so ");
//                        Process = Process.replace(" flux ", " "+getApplicationInfo().nativeLibraryDir+"/libflux.so ");
//                        Process = Process.replace(" makecube ", " "+getApplicationInfo().nativeLibraryDir+"/libmakecube.so ");
//                        Process = Process.replace(" phonons ", " "+getApplicationInfo().nativeLibraryDir+"/libphonons.so ");
//                        Process = Process.replace(" setupgeom ", " "+getApplicationInfo().nativeLibraryDir+"/libsetupgeom.so ");
                        Process = Process.replace(" chemsol ", " "+getApplicationInfo().nativeLibraryDir+"/libchemsol.so ");
                        Process = Process.replace(" fastchem ", " "+getApplicationInfo().nativeLibraryDir+"/libfastchem.so ");
                        Process = Process.replace(" mopac ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac.so ");
                        Process = Process.replace(" mopac-makpol ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac-makpol.so ");
                        Process = Process.replace(" mopac-param ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac-param.so ");
                        Process = Process.replace(" phreeqc ", " "+getApplicationInfo().nativeLibraryDir+"/libphreeqc.so ");
                        Process = Process.replace(" transpose ", " "+getApplicationInfo().nativeLibraryDir+"/libtranspose.so ");
                        try {
                            com.jrummyapps.android.shell.Shell.SH.run(Process);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        /////////////////////////////////// Process results ///////////////////////////////////////////////
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/XtbKinetics.b "+getFilesDir()+"/XtbKinetics.bas");
                            exec("chmod -R 755 "+getFilesDir()+"/XtbKinetics.b");
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/XtbKinetics.b");

                            /////////////////////////////////// Export results ///////////////////////////////////////////////

                            String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                            String DatasetName1 = DatasetName0.replace(" ","_");
                            String DatasetName = DatasetName1.replace(",",".");
                            File filePathExt = new File(getFilesDir()+"/openbabel/kinetics");
                            if (!filePathExt.exists()) {
                                filePathExt.mkdirs();
                            }

                            String Dataset = DatasetName;

                            exec("cp "+getFilesDir()+"/thermo_s_RATES.txt "+getFilesDir()+"/thermo_s_RATES_0.txt");
                            exec("cp "+getFilesDir()+"/thermo_s_KINETICS.txt "+getFilesDir()+"/thermo_s_KINETICS_0.txt");
                            exec("cp "+getFilesDir()+"/thermo_s_SMS.txt "+getFilesDir()+"/thermo_s_SMS_0.txt");
                            exec("cp "+getFilesDir()+"/thermo_s_SS.txt "+getFilesDir()+"/thermo_s_SS_0.txt");

                            String R = exec("cat "+getFilesDir()+"/thermo_s_RATES_0.txt");
                            R = R.replace("[H2O]", "H2O");
                            R = R.replace("[H+]+", "H+");
                            R = R.replace("[OH-]-", "OH-");
                            FileOutputStream R_stream = openFileOutput("thermo_s_RATES_w.txt", MODE_PRIVATE);
                            OutputStreamWriter R_writer = new OutputStreamWriter(R_stream);
                            R_writer.write(R);
                            R_writer.close();
                            exec("mv "+getFilesDir()+"/thermo_s_RATES_w.txt "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_RATES_w.txt");
                            exec("rm "+getFilesDir()+"/thermo_s_RATES_0.txt");

                            String K = exec("cat "+getFilesDir()+"/thermo_s_KINETICS_0.txt");
                            K = K.replace("[H2O]", "H2O");
                            K = K.replace("[H+]+", "H+");
                            K = K.replace("[OH-]-", "OH-");
                            FileOutputStream K_stream = openFileOutput("thermo_s_KINETICS_w.txt", MODE_PRIVATE);
                            OutputStreamWriter K_writer = new OutputStreamWriter(K_stream);
                            K_writer.write(K);
                            K_writer.close();
                            exec("mv "+getFilesDir()+"/thermo_s_KINETICS_w.txt "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_KINETICS_w.txt");
                            exec("rm "+getFilesDir()+"/thermo_s_KINETICS_0.txt");

                            String SMS = exec("cat "+getFilesDir()+"/thermo_s_SMS_0.txt");
                            SMS = SMS.replace("[H2O]\t[H2O]\t0\t[H2O]\t1", "");
                            SMS = SMS.replace("[H+]\t[H+]+\t0\t[H+]\t1", "");
                            SMS = SMS.replace("[OH-]\t[OH-]-\t0\t[OH-]\t1", "");
                            FileOutputStream SMS_stream = openFileOutput("thermo_s_SMS_w.txt", MODE_PRIVATE);
                            OutputStreamWriter SMS_writer = new OutputStreamWriter(SMS_stream);
                            SMS_writer.write(SMS);
                            SMS_writer.close();
                            exec("mv "+getFilesDir()+"/thermo_s_SMS_w.txt "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_MASTER_SPECIES_w.txt");
                            exec("rm "+getFilesDir()+"/thermo_s_SMS_0.txt");

                            String SS = exec("cat "+getFilesDir()+"/thermo_s_SS_0.txt");
                            SS = SS.replace("[H2O] = [H2O]", "");
                            SS = SS.replace("[H+]+ = [H+]+", "");
                            SS = SS.replace("[OH-]- = [OH-]-", "");
                            FileOutputStream SS_stream = openFileOutput("thermo_s_SS_w.txt", MODE_PRIVATE);
                            OutputStreamWriter SS_writer = new OutputStreamWriter(SS_stream);
                            SS_writer.write(SS);
                            SS_writer.close();
                            exec("mv "+getFilesDir()+"/thermo_s_SS_w.txt "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_SPECIES_w.txt");
                            exec("rm "+getFilesDir()+"/thermo_s_SS_0.txt");

                            exec("mv "+getFilesDir()+"/thermo_s_KINETICS.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_KINETICS_anhydr.txt");
                            exec("mv "+getFilesDir()+"/thermo_s_RATES.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_RATES_anhydr.txt");
                            exec("mv "+getFilesDir()+"/thermo_s_SMS.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_SOLUTION_MASTER_SPECIES_anhydr.txt");
                            exec("mv "+getFilesDir()+"/thermo_s_SS.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_SOLUTION_SPECIES_anhydr.txt");
                            exec("cp "+getFilesDir()+"/XtbKin.inp "+getFilesDir()+"/openbabel/solv/thermo/results/"+DatasetName+".inp");
                            exec("mv "+getFilesDir()+"/XtbKin.out "+getFilesDir()+"/openbabel/solv/thermo/results/"+DatasetName+".out");
                            exec("mv "+getFilesDir()+"/XtbR.out "+getFilesDir()+"/openbabel/solv/thermo/results/"+DatasetName+"_R.out");
                            exec("mv "+getFilesDir()+"/XtbP.out "+getFilesDir()+"/openbabel/solv/thermo/results/"+DatasetName+"_P.out");
                            exec("mv "+getFilesDir()+"/XtbR.xyz "+getFilesDir()+"/openbabel/xyz/"+DatasetName+"_R.xyz");
                            exec("mv "+getFilesDir()+"/XtbP.xyz "+getFilesDir()+"/openbabel/xyz/"+DatasetName+"_P.xyz");
                            exec("mv "+getFilesDir()+"/xtbpath_ts.xyz "+getFilesDir()+"/openbabel/xyz/"+DatasetName+"_TS.xyz");

                            /////////////////////////////////// Display fields ///////////////////////////////////////////////

                            XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                            XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                            FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                            FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                            ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                            DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));

                        } catch (Exception e) {
                        }

//here:
                        Intent intent = new Intent(XtbKinetics2.this, ResumeActivityKin.class);
                        startActivity(intent);
                        onFinish();
                    }
                    public void onFinish(){
                        progressDialog.dismiss();
                    }
                }.start();

//not here:
//                Intent intent = new Intent(KineticsUniUni.this, ResumeActivityKin.class);
//                startActivity(intent);
            }
        };
    }

    private View.OnClickListener execbuttonClick; {

        execbuttonClick = new View.OnClickListener() {
            public void onClick(View v) {

                progressDialog = new ProgressDialog(XtbKinetics2.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Executing custom command.");
                progressDialog.setCancelable(false);
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                progressDialog.show();
                new Thread() {
                    public void run() {
                        // update: resolved!, progressdialog is already working - see the comment at the end of new thread block
                        /////////////////////////// SAVE EVERYTHING PRE-SET ////////////////////////////////
                        String XyzR = reactant_xyz.getText().toString();
                        String XyzP = product_xyz.getText().toString();
                        String FormulaR = reactant_formulas.getText().toString();
                        String FormulaP = product_formulas.getText().toString();
                        String Process = process.getText().toString();
                        String Details = details.getText().toString();

                        try {

                            FileOutputStream fileout = openFileOutput("Xtb_xyzR.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(XyzR);
                            outputWriter.close();
                            FileOutputStream fileout2 = openFileOutput("Xtb_xyzP.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(XyzP);
                            outputWriter2.close();
                            FileOutputStream fileout3 = openFileOutput("Xtb_formulaR.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(FormulaR);
                            outputWriter3.close();
                            FileOutputStream fileout8 = openFileOutput("Xtb_formulaP.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                            outputWriter8.write(FormulaP);
                            outputWriter8.close();
                            FileOutputStream fileout6 = openFileOutput("XtbKineticsCommand.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                            outputWriter6.write(Process);
                            outputWriter6.close();
                            FileOutputStream fileout10 = openFileOutput("XtbKin.inp", MODE_PRIVATE);
                            OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                            outputWriter10.write(Details);
                            outputWriter10.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        /////////////////////////// THEN CONTINUE ////////////////////////////////
                        Process = Process.replace(" cpx ", " "+getApplicationInfo().nativeLibraryDir+"/libcpx.so ");
                        Process = Process.replace(" dftd4 ", " "+getApplicationInfo().nativeLibraryDir+"/libdftd4.so ");
                        Process = Process.replace(" multicharge ", " "+getApplicationInfo().nativeLibraryDir+"/libmulticharge.so ");
                        Process = Process.replace(" numsa-exe ", " "+getApplicationInfo().nativeLibraryDir+"/libnumsa-exe.so ");
                        Process = Process.replace(" s-dftd3 ", " "+getApplicationInfo().nativeLibraryDir+"/libs-dftd3.so ");
                        Process = Process.replace(" tblite ", " "+getApplicationInfo().nativeLibraryDir+"/libtblite.so ");
                        Process = Process.replace(" obabel ", " "+getApplicationInfo().nativeLibraryDir+"/libobabel.so ");
                        Process = Process.replace(" dftb ", " "+getApplicationInfo().nativeLibraryDir+"/libdftb.so ");
                        Process = Process.replace(" qcxms ", " "+getApplicationInfo().nativeLibraryDir+"/libqcxms.so ");
                        Process = Process.replace(" modes ", " "+getApplicationInfo().nativeLibraryDir+"/libmodes.so ");
                        Process = Process.replace(" xbbc ", " "+getApplicationInfo().nativeLibraryDir+"/libxbbc.so ");
                        Process = Process.replace(" xbvm ", " "+getApplicationInfo().nativeLibraryDir+"/libxbvm.so ");
                        Process = Process.replace(" plotms ", " "+getApplicationInfo().nativeLibraryDir+"/libplotms.so ");
                        Process = Process.replace(" stda ", " "+getApplicationInfo().nativeLibraryDir+"/libstda.so ");
                        Process = Process.replace(" xtb ", " "+getApplicationInfo().nativeLibraryDir+"/libxtb.so ");
                        Process = Process.replace(" xtb4stda ", " "+getApplicationInfo().nativeLibraryDir+"/libxtb4stda.so ");
                        Process = Process.replace(" waveplot ", " "+getApplicationInfo().nativeLibraryDir+"/libwaveplot.so ");
                        Process = Process.replace(" chimescalc ", " "+getApplicationInfo().nativeLibraryDir+"/libchimescalc.so ");
                        Process = Process.replace(" crest ", " "+getApplicationInfo().nativeLibraryDir+"/libcrest.so ");
//                        Process = Process.replace(" flux ", " "+getApplicationInfo().nativeLibraryDir+"/libflux.so ");
//                        Process = Process.replace(" makecube ", " "+getApplicationInfo().nativeLibraryDir+"/libmakecube.so ");
//                        Process = Process.replace(" phonons ", " "+getApplicationInfo().nativeLibraryDir+"/libphonons.so ");
//                        Process = Process.replace(" setupgeom ", " "+getApplicationInfo().nativeLibraryDir+"/libsetupgeom.so ");
                        Process = Process.replace(" chemsol ", " "+getApplicationInfo().nativeLibraryDir+"/libchemsol.so ");
                        Process = Process.replace(" fastchem ", " "+getApplicationInfo().nativeLibraryDir+"/libfastchem.so ");
                        Process = Process.replace(" mopac ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac.so ");
                        Process = Process.replace(" mopac-makpol ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac-makpol.so ");
                        Process = Process.replace(" mopac-param ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac-param.so ");
                        Process = Process.replace(" phreeqc ", " "+getApplicationInfo().nativeLibraryDir+"/libphreeqc.so ");
                        Process = Process.replace(" transpose ", " "+getApplicationInfo().nativeLibraryDir+"/libtranspose.so ");
                        try {
                            com.jrummyapps.android.shell.Shell.SH.run(Process);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            XyzRDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzR.txt"));
                            XyzPDisplay(exec("cat "+getFilesDir()+"/Xtb_xyzP.txt"));
                            FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                            FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                            ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                            DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
                        } catch (Exception e) {
                        }

                        onFinish();
                    }
                    public void onFinish(){
                        progressDialog.dismiss();
                    }
                }.start();
            }
        };
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(XtbKinetics2.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }

    // Executes UNIX command.
    private String exec(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[65536];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();
            process.waitFor();
            return output.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private void XyzRDisplay(final String strSR) {
        Runnable procSR = new Runnable() {
            public void run() {
                reactant_xyz.setText(colorized_elements(strSR), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procSR);
    }
    private void FormulasRDisplay(final String strFR) {
        Runnable procFR = new Runnable() {
            public void run() {
                reactant_formulas.setText(colorized_xtb(strFR), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procFR);
    }
    private void XyzPDisplay(final String strSP) {
        Runnable procSP = new Runnable() {
            public void run() {
                product_xyz.setText(colorized_elements(strSP), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procSP);
    }
    private void FormulasPDisplay(final String strFP) {
        Runnable procFP = new Runnable() {
            public void run() {
                product_formulas.setText(colorized_xtb(strFP), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procFP);
    }
    private void ProcessDisplay(final String strP) {
        Runnable procP = new Runnable() {
            public void run() {
                process.setText(colorized_xtb(strP), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procP);
    }
    private void DetailsDisplay(final String strD) {
        Runnable procD = new Runnable() {
            public void run() {
                details.setText(colorized_xtb(strD), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procD);
    }

}
