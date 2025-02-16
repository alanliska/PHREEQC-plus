package cz.p;

import static cz.p.Spannables.colorized_elements;
import static cz.p.Spannables.colorized_numbers;
import static cz.p.Spannables.colorized_xtb;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import android.content.Context;
import android.util.Log;

import com.jrummyapps.android.shell.CommandResult;
import com.jrummyapps.android.shell.Shell;

public class Xtb extends MainActivity {

    private Handler handler = new Handler();
    private TextView ContentLabel;
    private EditText Content;
    private TextView CommandLabel;
    private EditText Command;
    Button openCommandfile;
    Button openIntCommandfile;
    Button saveCommandfile;
    Button saveExtCommandfile;
    private TextView InLabel;
    private EditText InFile;
    Button openInfile;
    Button openIntInfile;
    Button saveInfile;
    Button saveExtInfile;
    private TextView InputLabel;
    private EditText InputFile;
    Button openInputfile;
    Button openIntInputfile;
    Button saveInputfile;
    Button saveExtInputfile;
    Button generateXYZ;
    Button opsinXYZ;
    //    Button saveFile;
    Button RunProgram;
    Button saveOutputfile;
    Button saveExtOutputfile;
    Button Highlight;
    Button Graph;
    Button Quit;
    private TextView textViewX;
    private TextView outputView;
    private EditText outputView2;
    private static final int READ_FILE6 = 336;
    private Uri documentUri6;
    private static final int READ_FILE26 = 3326;
    private Uri documentUri26;
    private static final int CREATE_FILE20 = 3320;
    private Uri documentUri20;
    private static final int CREATE_FILE01 = 331;
    private Uri documentUri1;
    private static final int CREATE_FILE21 = 3321;
    private Uri documentUri21;
    private static final int READ_FILE60 = 3360;
    private Uri documentUri60;
    private static final int CREATE_FILE200 = 33200;
    private Uri documentUri200;
    Button manual_xtb;
    Button manual_stda;
    Button manual_crest;
    Button write_cell;
    Button inToCanvas;
    Button outToCanvas;
    Button multiToCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.xtb);

        ContentLabel = (TextView) findViewById(R.id.ContentLabel);
        Content = (EditText) findViewById(R.id.Content);
//        Content.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/OutputTextSize.txt")).intValue());
//        // disable - otherwise the text could not be selected
////        Content.setMovementMethod(new ScrollingMovementMethod());
//        Content.addTextChangedListener(new TextWatcher() {
//            int startChanged,beforeChanged,countChanged;
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                startChanged = start;
//                beforeChanged = before;
//                countChanged = count;
//            }
//            @Override
//            public void afterTextChanged(Editable s) {
//                Content.removeTextChangedListener(this);
//                String text = Content.getText().toString();
//                // important - not setText() - otherwise the keyboard would be reset after each type
//                Content.getText().clear();
//                Content.append(colorized_xtb(text));
//                // place the cursor at the original position
//                Content.setSelection(startChanged+countChanged);
//                Content.addTextChangedListener(this);
//            }
//        });
        CommandLabel = (TextView) findViewById(R.id.CommandLabel);
        Command = (EditText) findViewById(R.id.Command);
        Command.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Command.addTextChangedListener(new TextWatcher() {
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
                Command.removeTextChangedListener(this);
                String text = Command.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Command.getText().clear();
                Command.append(colorized_xtb(text));
                // place the cursor at the original position
                Command.setSelection(startChanged+countChanged);
                Command.addTextChangedListener(this);
            }
        });
        openCommandfile = (Button) findViewById(R.id.openCommandfile);
        openCommandfile.setOnClickListener(openCommandfileClick);
        openIntCommandfile = (Button) findViewById(R.id.openIntCommandfile);
        saveCommandfile = (Button) findViewById(R.id.saveCommandfile);
        saveCommandfile.setOnClickListener(saveCommandfileClick);
        saveExtCommandfile = (Button) findViewById(R.id.saveExtCommandfile);
        saveExtCommandfile.setOnClickListener(saveExtCommandfileClick);
        InLabel = (TextView) findViewById(R.id.InLabel);
        InFile = (EditText) findViewById(R.id.InFile);
        InFile.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        InFile.addTextChangedListener(new TextWatcher() {
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
                InFile.removeTextChangedListener(this);
                String text = InFile.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                InFile.getText().clear();
                InFile.append(colorized_xtb(text));
                // place the cursor at the original position
                InFile.setSelection(startChanged+countChanged);
                InFile.addTextChangedListener(this);
            }
        });
        openInfile = (Button) findViewById(R.id.openInfile);
        openInfile.setOnClickListener(openInfileClick);
        openIntInfile = (Button) findViewById(R.id.openIntInfile);
        saveInfile = (Button) findViewById(R.id.saveInfile);
        saveInfile.setOnClickListener(saveInfileClick);
        saveExtInfile = (Button) findViewById(R.id.saveExtInfile);
        saveExtInfile.setOnClickListener(saveExtInfileClick);
        InputLabel = (TextView) findViewById(R.id.InputLabel);
        InputFile = (EditText) findViewById(R.id.InputFile);
        InputFile.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        InputFile.addTextChangedListener(new TextWatcher() {
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
                InputFile.removeTextChangedListener(this);
                String text = InputFile.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                InputFile.getText().clear();
                InputFile.append(colorized_elements(text));
                // place the cursor at the original position
                InputFile.setSelection(startChanged+countChanged);
                InputFile.addTextChangedListener(this);
            }
        });
        openInputfile = (Button) findViewById(R.id.openInputfile);
        openInputfile.setOnClickListener(openInputfileClick);
        openIntInputfile = (Button) findViewById(R.id.openIntInputfile);
        saveInputfile = (Button) findViewById(R.id.saveInputfile);
        saveInputfile.setOnClickListener(saveInputfileClick);
        saveExtInputfile = (Button) findViewById(R.id.saveExtInputfile);
        saveExtInputfile.setOnClickListener(saveExtInputfileClick);
        generateXYZ = (Button) findViewById(R.id.generateXYZ);
        generateXYZ.setOnClickListener(GenerateXYZClick);
        opsinXYZ = (Button) findViewById(R.id.opsinXYZ);
        opsinXYZ.setOnClickListener(opsinXYZClick);
//        saveFile = (Button) findViewById(R.id.saveFile);
//        saveFile.setOnClickListener(saveFileClick);
        RunProgram = (Button) findViewById(R.id.RunProgram);
        RunProgram.setOnClickListener(RunProgramClick);
        saveOutputfile = (Button) findViewById(R.id.saveOutputfile);
        saveOutputfile.setOnClickListener(saveOutputfileClick);
        saveExtOutputfile = (Button) findViewById(R.id.saveExtOutputfile);
        saveExtOutputfile.setOnClickListener(saveExtOutputfileClick);
        Highlight = (Button) findViewById(R.id.Highlight);
        Highlight.setOnClickListener(HighlightClick);
        write_cell = (Button) findViewById(R.id.write_cell);
        write_cell.setOnClickListener(write_cellClick);
//        About = (Button) findViewById(R.id.About);
//        About.setOnClickListener(AboutClick);
//        License = (Button) findViewById(R.id.License);
//        License.setOnClickListener(LicenseClick);
        textViewX = (TextView) findViewById(R.id.textViewX);
        outputView = (TextView) findViewById(R.id.outputView);
        outputView2 = (EditText) findViewById(R.id.outputView2);
        outputView2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/OutputTextSize.txt")).intValue());
        // disable - otherwise the text could not be selected
//        outputView2.setMovementMethod(new ScrollingMovementMethod());
        // otherwise every time is spanned
//        outputView2.addTextChangedListener(new TextWatcher() {
//            int startChanged,beforeChanged,countChanged;
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                startChanged = start;
//                beforeChanged = before;
//                countChanged = count;
//            }
//            @Override
//            public void afterTextChanged(Editable s) {
//                outputView2.removeTextChangedListener(this);
//                String text = outputView2.getText().toString();
//                // important - not setText() - otherwise the keyboard would be reset after each type
//                outputView2.getText().clear();
//                outputView2.append(colorized_xtb(text));
//                // place the cursor at the original position
//                outputView2.setSelection(startChanged+countChanged);
//                outputView2.addTextChangedListener(this);
//            }
//        });
        Graph = (Button) findViewById(R.id.Graph);
        Graph.setOnClickListener(GraphClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);

//        manual_python = (Button) findViewById(R.id.manual_python);
//        manual_python.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(MainActivity.this, ManualPython.class);
//                startActivity(intent);
//            }
//        });

//        manual_crest = (Button) findViewById(R.id.manual_crest);
//        manual_crest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(MainActivity.this, ManualCrest.class);
//                startActivity(intent);
//            }
//        });

        manual_stda = (Button) findViewById(R.id.manual_stda);
        manual_stda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Xtb.this, ManualStda.class);
                startActivity(intent);
            }
        });

        manual_xtb = (Button) findViewById(R.id.manual_xtb);
        manual_xtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Xtb.this, ManualXtb.class);
                startActivity(intent);
            }
        });

        manual_crest = (Button) findViewById(R.id.manual_crest);
        manual_crest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Xtb.this, ManualCrest.class);
                startActivity(intent);
            }
        });

        openIntInputfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Xtb.this, XtbWork.class);
                startActivity(intent);
            }
        });

        openIntInfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Xtb.this, XtbWork1.class);
                startActivity(intent);
            }
        });

        openIntCommandfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Xtb.this, XtbCommand.class);
                startActivity(intent);
            }
        });

        inToCanvas = (Button) findViewById(R.id.inToCanvas);
        inToCanvas.setOnClickListener(inToCanvasClick);
        outToCanvas = (Button) findViewById(R.id.outToCanvas);
        outToCanvas.setOnClickListener(outToCanvasClick);
        multiToCanvas = (Button) findViewById(R.id.multiToCanvas);
        multiToCanvas.setOnClickListener(multiToCanvasClick);
    }

    public void onStart()
    {
        super.onStart();

        output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
        output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
        output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
        output(exec("ls -la "+getFilesDir()+"/xtb/"));
    }

    private View.OnClickListener inToCanvasClick; {

        inToCanvasClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();

//                ProgressDialog progressDialog = new ProgressDialog(Xtb.this);
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
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String XYZfile = exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz");
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
                            MolCanvas_canvasView.zmat.clear();
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
                                MolCanvas_canvasView.zmat.add(new MolCanvas_object(lineNum, atom, MolCanvas_methods.getElementColor(atom),
                                        Color.BLACK, MolCanvas_methods.getElementRadius(atom),
                                        MolCanvas_methods.Radius_pix(MolCanvas_methods.getElementRadius(atom),
                                                MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_preferences.get().getValue("radius_scale"), MolCanvas_main.zoom_scale, z_coord),
                                        0, x_coord, y_coord, z_coord,
                                        MolCanvas_methods.AtomX_pix(x_coord, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.width_pix,
                                                MolCanvas_main.zoom_scale),
                                        MolCanvas_methods.AtomY_pix(y_coord, MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_canvasView.height_pix, MolCanvas_main.zoom_scale),
                                        0, "", MolCanvas_methods.getElementTextColor(atom), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                        z_coord, 0.0f, 0.0f, 0.0f, 1));
                            }
                            for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                                if (object.getObjectType() == 1) {
                                    MolCanvas_main.generatedLabels.add(new MolCanvas_object(object.getAtomNumber1(), object.getAtomSymbol1(),
                                            MolCanvas_methods.getElementTextColor(object.getAtomSymbol1()),
                                            object.getAtomBorderColor1(), 0,
                                            MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), MolCanvas_main.zoom_scale,
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
                            MolCanvas_canvasView.zmat.addAll(MolCanvas_main.generatedLabels);
                            MolCanvas_main.generatedLabels.clear();
                            MolCanvas_main.generateAllBonds();
                            MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(Xtb.this, MolCanvas_main.class);
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

    private View.OnClickListener multiToCanvasClick; {

        multiToCanvasClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();

                com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME/xtb ; mkdir -p multi ; chmod -R 755 * ; "+getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o XYZ_split.b XYZ_split.bas ; "+getApplicationInfo().nativeLibraryDir+"/libxbvm.so XYZ_split.b ");

//                ProgressDialog progressDialog = new ProgressDialog(Xtb.this);
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
                            FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                            FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(Arguments);
                            outputWriter2.close();
                            FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(Infile);
                            outputWriter3.close();
                            exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                            exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                            exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String XYZfile = exec("cat "+getFilesDir()+"/xtb/multi/multistructure_1.xyz");
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
                            MolCanvas_canvasView.zmat.clear();
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
                                MolCanvas_canvasView.zmat.add(new MolCanvas_object(lineNum, atom, MolCanvas_methods.getElementColor(atom),
                                        Color.BLACK, MolCanvas_methods.getElementRadius(atom),
                                        MolCanvas_methods.Radius_pix(MolCanvas_methods.getElementRadius(atom),
                                                MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_preferences.get().getValue("radius_scale"), MolCanvas_multi.zoom_scale, z_coord),
                                        0, x_coord, y_coord, z_coord,
                                        MolCanvas_methods.AtomX_pix(x_coord, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.width_pix,
                                                MolCanvas_multi.zoom_scale),
                                        MolCanvas_methods.AtomY_pix(y_coord, MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_canvasView.height_pix, MolCanvas_multi.zoom_scale),
                                        0, "", MolCanvas_methods.getElementTextColor(atom), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                        z_coord, 0.0f, 0.0f, 0.0f, 1));
                            }
                            for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                                if (object.getObjectType() == 1) {
                                    MolCanvas_multi.generatedLabels.add(new MolCanvas_object(object.getAtomNumber1(), object.getAtomSymbol1(),
                                            MolCanvas_methods.getElementTextColor(object.getAtomSymbol1()),
                                            object.getAtomBorderColor1(), 0,
                                            MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), MolCanvas_main.zoom_scale,
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
                            MolCanvas_canvasView.zmat.addAll(MolCanvas_multi.generatedLabels);
                            MolCanvas_multi.generatedLabels.clear();
                            MolCanvas_multi.generateAllBonds();
                            MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(Xtb.this, MolCanvas_multi.class);
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

    private View.OnClickListener outToCanvasClick; {

        outToCanvasClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();

//                ProgressDialog progressDialog = new ProgressDialog(Xtb.this);
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
                            FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                            FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(Arguments);
                            outputWriter2.close();
                            FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(Infile);
                            outputWriter3.close();
                            exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                            exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                            exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String XYZfile = exec("cat "+getFilesDir()+"/xtb/xtbopt.xyz");
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
                            MolCanvas_canvasView.zmat.clear();
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
                                MolCanvas_canvasView.zmat.add(new MolCanvas_object(lineNum, atom, MolCanvas_methods.getElementColor(atom),
                                        Color.BLACK, MolCanvas_methods.getElementRadius(atom),
                                        MolCanvas_methods.Radius_pix(MolCanvas_methods.getElementRadius(atom),
                                                MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_preferences.get().getValue("radius_scale"), MolCanvas_main.zoom_scale, z_coord),
                                        0, x_coord, y_coord, z_coord,
                                        MolCanvas_methods.AtomX_pix(x_coord, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.width_pix,
                                                MolCanvas_main.zoom_scale),
                                        MolCanvas_methods.AtomY_pix(y_coord, MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_canvasView.height_pix, MolCanvas_main.zoom_scale),
                                        0, "", MolCanvas_methods.getElementTextColor(atom), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                        z_coord, 0.0f, 0.0f, 0.0f, 1));
                            }
                            for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                                if (object.getObjectType() == 1) {
                                    MolCanvas_main.generatedLabels.add(new MolCanvas_object(object.getAtomNumber1(), object.getAtomSymbol1(),
                                            MolCanvas_methods.getElementTextColor(object.getAtomSymbol1()),
                                            object.getAtomBorderColor1(), 0,
                                            MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), MolCanvas_main.zoom_scale,
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
                            MolCanvas_canvasView.zmat.addAll(MolCanvas_main.generatedLabels);
                            MolCanvas_main.generatedLabels.clear();
                            MolCanvas_main.generateAllBonds();
                            MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(Xtb.this, MolCanvas_main.class);
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

    private View.OnClickListener write_cellClick; {

        write_cellClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertCell();
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }


    public void alertCell(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(Xtb.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(Xtb.this)
                .setMessage("Please write the cell parameters. Example: 6.0 6.0 6.0 60.0 60.0 60.0 (A B C alpha beta gamma).")
                .setTitle("Cell generation")
                .setView(editText100)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String CellString = editText100.getText().toString();
//                        String InputFile = MopacInput.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput("XtbSolid.inp", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(CellString);
                            outputWriter.close();

                            // String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+"/temp.smi -oxyz --gen3d");
                            com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; sed '1,2d' ./xtb/Input-xtb.xyz > ./xtb/Input-xtb2.xyz ; "+getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o XtbSolid.b XtbSolid.bas ; chmod -R 755 XtbSolid.b ; "+getApplicationInfo().nativeLibraryDir+"/libxbvm.so XtbSolid.b ; mv reorder.xyz Input-xtb.txt ; mv Input-xtb.txt ./xtb/");

//                            String SedXyz = exec("sed -e 1,2d "+getFilesDir()+"/temp.xyz");

//                            FileOutputStream fileout4 = openFileOutput("Input-xtb.xyz", MODE_APPEND);
//                            OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
////                            outputWriter4.write(InputFile);
//                            outputWriter4.write("\n");
//                            outputWriter4.write(SedXyz);
//                            outputWriter4.close();
//                            exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        // here it should be:
                        output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                        output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
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

    private View.OnClickListener GenerateXYZClick; {

        GenerateXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertGenerateXYZ();
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }


    public void alertGenerateXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(Xtb.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(Xtb.this)
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

                            FileOutputStream fileout3 = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();

//                            String SedXyz = exec("sed -e 1,2d "+getFilesDir()+"/temp.xyz");

//                            FileOutputStream fileout4 = openFileOutput("Input-xtb.xyz", MODE_APPEND);
//                            OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
////                            outputWriter4.write(InputFile);
//                            outputWriter4.write("\n");
//                            outputWriter4.write(SedXyz);
//                            outputWriter4.close();
                            exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
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

    private View.OnClickListener opsinXYZClick; {

        opsinXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertOpsinXYZ();
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }


    public void alertOpsinXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(Xtb.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(Xtb.this)
                .setMessage("Please write the chemical name according to IUPAC to XYZ conversion. The result will be displayed as the updated input XYZ file.")
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

                            FileOutputStream fileout3 = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();

//                            String SedXyz = exec("sed -e 1,2d "+getFilesDir()+"/temp.xyz");
//
//                            FileOutputStream fileout4 = openFileOutput("Input-xtb.xyz", MODE_APPEND);
//                            OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
////                            outputWriter4.write(InputFile);
//                            outputWriter4.write("\n");
//                            outputWriter4.write(SedXyz);
//                            outputWriter4.close();
                            exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
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

    private View.OnClickListener GraphClick; {

        GraphClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Xtb.this, SpectrumXTB.class);
                startActivity(intent);
            }
        };
    }


    private View.OnClickListener openInputfileClick; {

        openInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read6(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }

    private View.OnClickListener openInfileClick; {

        openInfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read26(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }

    private View.OnClickListener openCommandfileClick; {

        openCommandfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read60(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }

    private View.OnClickListener saveExtInputfileClick; {

        saveExtInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write1(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }

    private View.OnClickListener saveExtInfileClick; {

        saveExtInfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write0(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }

    private View.OnClickListener saveExtCommandfileClick; {

        saveExtCommandfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write10(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }

    private View.OnClickListener saveExtOutputfileClick; {

        saveExtOutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write2(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }

    private void read6(Context context6) {
        Intent intent6 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent6.addCategory(Intent.CATEGORY_OPENABLE);
        intent6.setType("text/plain");
        startActivityForResult(intent6, READ_FILE6);
    }

    private void read26(Context context26) {
        Intent intent26 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent26.addCategory(Intent.CATEGORY_OPENABLE);
        intent26.setType("text/plain");
        startActivityForResult(intent26, READ_FILE26);
    }

    private void write1(Context context1) {
        Intent intent1 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        intent1.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent1, CREATE_FILE20);
    }

    private void write0(Context context0) {
        Intent intent0 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent0.addCategory(Intent.CATEGORY_OPENABLE);
        intent0.setType("text/plain");
        intent0.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent0, CREATE_FILE01);
    }

    private void write2(Context context2) {
        Intent intent2 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent2.addCategory(Intent.CATEGORY_OPENABLE);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TITLE,"MyOutputFile");
        startActivityForResult(intent2, CREATE_FILE21);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE6 && data != null) {
            try {
                documentUri6 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd6 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd6.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd6.close();
                exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

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

                FileOutputStream fileout = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd26.close();
                exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE20 && data != null) {
            // save input file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {

                String fileContentsX = InputFile.getText().toString();
                FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContentsX + "\n");
                outputWriter.close();
                exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");

                documentUri20 = data.getData();
                ParcelFileDescriptor pfd20 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd20.getFileDescriptor());
//                String fileContents = InputFile.getText().toString();
                String fileContents20 = exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz");
                fileOutputStream.write((fileContents20 + "\n").getBytes());
                fileOutputStream.close();
                pfd20.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE01 && data != null) {
            // save input file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {

                String fileContentsX = InputFile.getText().toString();
                FileOutputStream fileout = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContentsX + "\n");
                outputWriter.close();
                exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");

                documentUri1 = data.getData();
                ParcelFileDescriptor pfd0 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd0.getFileDescriptor());
//                String fileContents = InputFile.getText().toString();
                String fileContents0 = exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt");
                fileOutputStream.write((fileContents0 + "\n").getBytes());
                fileOutputStream.close();
                pfd0.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE21 && data != null) {
            // save output file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri21 = data.getData();
                ParcelFileDescriptor pfd21 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd21.getFileDescriptor());
                String fileContents = outputView2.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd21.close();
                FileOutputStream fileout = openFileOutput("Input.out", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
                exec("mv "+getFilesDir()+"/Input.out "+getFilesDir()+"/xtb/");
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

                FileOutputStream fileout = openFileOutput("Command.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd60.close();
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
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
                String fileContents = Command.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd200.close();
                FileOutputStream fileout = openFileOutput("Command.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents);
                outputWriter.close();
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

    }

//    private View.OnClickListener saveFileClick; {
//
//        saveFileClick = new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub //
//                String Inputfile = InputFile.getText().toString();
//                String Arguments = Command.getText().toString();
//                try {
//                    FileOutputStream fileout = openFileOutput("Input.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(Inputfile);
//                    outputWriter.close();
//                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
//                    outputWriter2.write(Arguments);
//                    outputWriter2.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                alertSaveInput();
//                output3(exec("cat "+getFilesDir()+"/Input.txt"));
//                output5(exec("cat "+getFilesDir()+"/Command.txt"));
//                output(exec("ls -l "+getFilesDir()+"/"));
//            }
//        };
//    }

    private View.OnClickListener saveInputfileClick; {

        saveInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveInput();
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }


    public void alertSaveInput(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Xtb.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(Xtb.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/xtb_work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = InputFile.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile+"\n");
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/xtb_work");
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


    private View.OnClickListener saveInfileClick; {

        saveInfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveIn();
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }


    public void alertSaveIn(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Xtb.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(Xtb.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/xtb_work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = InputFile.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile+"\n");
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/xtb_work");
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
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveCommand();
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }


    public void alertSaveCommand(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Xtb.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(Xtb.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/xtb_commands")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = Command.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/xtb_commands");
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


    private View.OnClickListener RunProgramClick; {

        RunProgramClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Infile = InFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input-xtb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Infile);
                    outputWriter3.close();
                    exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/xtb/");
                    exec("mv "+getFilesDir()+"/Input-xtb.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Arguments = Arguments.replace(" cpx ", " "+getApplicationInfo().nativeLibraryDir+"/libcpx.so ");
                Arguments = Arguments.replace(" dftd4 ", " "+getApplicationInfo().nativeLibraryDir+"/libdftd4.so ");
                Arguments = Arguments.replace(" multicharge ", " "+getApplicationInfo().nativeLibraryDir+"/libmulticharge.so ");
                Arguments = Arguments.replace(" numsa-exe ", " "+getApplicationInfo().nativeLibraryDir+"/libnumsa-exe.so ");
                Arguments = Arguments.replace(" s-dftd3 ", " "+getApplicationInfo().nativeLibraryDir+"/libs-dftd3.so ");
                Arguments = Arguments.replace(" tblite ", " "+getApplicationInfo().nativeLibraryDir+"/libtblite.so ");
                Arguments = Arguments.replace(" obabel ", " "+getApplicationInfo().nativeLibraryDir+"/libobabel.so ");
                Arguments = Arguments.replace(" dftb ", " "+getApplicationInfo().nativeLibraryDir+"/libdftb.so ");
                Arguments = Arguments.replace(" qcxms ", " "+getApplicationInfo().nativeLibraryDir+"/libqcxms.so ");
                Arguments = Arguments.replace(" modes ", " "+getApplicationInfo().nativeLibraryDir+"/libmodes.so ");
                Arguments = Arguments.replace(" xbbc ", " "+getApplicationInfo().nativeLibraryDir+"/libxbbc.so ");
                Arguments = Arguments.replace(" xbvm ", " "+getApplicationInfo().nativeLibraryDir+"/libxbvm.so ");
                Arguments = Arguments.replace(" plotms ", " "+getApplicationInfo().nativeLibraryDir+"/libplotms.so ");
                Arguments = Arguments.replace(" stda ", " "+getApplicationInfo().nativeLibraryDir+"/libstda.so ");
                Arguments = Arguments.replace(" xtb ", " "+getApplicationInfo().nativeLibraryDir+"/libxtb.so ");
                Arguments = Arguments.replace(" xtb4stda ", " "+getApplicationInfo().nativeLibraryDir+"/libxtb4stda.so ");
                Arguments = Arguments.replace(" waveplot ", " "+getApplicationInfo().nativeLibraryDir+"/libwaveplot.so ");
                Arguments = Arguments.replace(" chimescalc ", " "+getApplicationInfo().nativeLibraryDir+"/libchimescalc.so ");
                Arguments = Arguments.replace(" crest ", " "+getApplicationInfo().nativeLibraryDir+"/libcrest.so ");
//                Arguments = Arguments.replace(" flux ", " "+getApplicationInfo().nativeLibraryDir+"/libflux.so ");
//                Arguments = Arguments.replace(" makecube ", " "+getApplicationInfo().nativeLibraryDir+"/libmakecube.so ");
//                Arguments = Arguments.replace(" phonons ", " "+getApplicationInfo().nativeLibraryDir+"/libphonons.so ");
//                Arguments = Arguments.replace(" setupgeom ", " "+getApplicationInfo().nativeLibraryDir+"/libsetupgeom.so ");
                Arguments = Arguments.replace(" chemsol ", " "+getApplicationInfo().nativeLibraryDir+"/libchemsol.so ");
                Arguments = Arguments.replace(" fastchem ", " "+getApplicationInfo().nativeLibraryDir+"/libfastchem.so ");
                Arguments = Arguments.replace(" mopac ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac.so ");
		Arguments = Arguments.replace(" mopac-makpol ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac-makpol.so ");
		Arguments = Arguments.replace(" mopac-param ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac-param.so ");
                Arguments = Arguments.replace(" phreeqc ", " "+getApplicationInfo().nativeLibraryDir+"/libphreeqc.so ");
//                Arguments = Arguments.replace(" phreeqc-prepare ", " "+getApplicationInfo().nativeLibraryDir+"/libphreeqc-prepare.so ");
                Arguments = Arguments.replace(" transpose ", " "+getApplicationInfo().nativeLibraryDir+"/libtranspose.so ");

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(InputFile.getWindowToken(), 0);
//                String command = ErgoInput.getText().toString();
                String command = Arguments;
//                String command = " export HOME="+getFilesDir()+"/ ; cd $HOME ; "+getApplicationInfo().nativeLibraryDir+"/"+NameOfProgram+" "+Arguments;

                new RunCommandTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, command);

                // TODO Auto-generated method stub //
//                openprogressdialog();
            }
        };
    }

    // Ignore the bad AsyncTask usage.
    final class RunCommandTask extends AsyncTask<String, Void, CommandResult> {

        private ProgressDialog dialog;

        @Override protected void onPreExecute() {

            // this is cancellable progress dialog
            dialog = new ProgressDialog(Xtb.this);
            dialog.setTitle("Please wait...");
            dialog.setMessage("Calculation is in progress...");
            dialog.setCancelable(false);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog2, int which) {
                    dialog2.dismiss();
                }
            });
            dialog.show();

            // this was the original non-cancellable progress dialog
//            dialog = ProgressDialog.show(Xtb.this, "Please wait...", "Calculation is in progress.");
//            dialog.setCancelable(false);
        }

        @Override protected CommandResult doInBackground(String... commands) {
            return com.jrummyapps.android.shell.Shell.SH.run(commands);
        }

        @Override protected void onPostExecute(CommandResult result) {
            if (!isFinishing()) {
                dialog.dismiss();
//                outputView2.setText(resultToHtml(result));
                String OutputofExecution = resultToHtml(result).toString();
                try {
                    FileOutputStream fileout = openFileOutput("LastExecutionOutput.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(OutputofExecution);
                    outputWriter.close();
                    exec("mv "+getFilesDir()+"/LastExecutionOutput.txt "+getFilesDir()+"/xtb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                outputView2.setText(OutputofExecution);
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));}
        }

        private Spanned resultToHtml(CommandResult result) {
            StringBuilder html = new StringBuilder();
            // exit status
            html.append("<p><strong>Exit Code:</strong> ");
            if (result.isSuccessful()) {
                html.append("<font color='green'>").append(result.exitCode).append("</font>");
            } else {
                html.append("<font color='red'>").append(result.exitCode).append("</font>");
            }
            html.append("</p>");
            // stdout
            if (result.stdout.size() > 0) {
                html.append("<p><strong>STDOUT:</strong></p><p>")
                        .append(result.getStdout().replaceAll("\n", "<br>"))
                        .append("</p>");
            }
            // stderr
            if (result.stderr.size() > 0) {
                html.append("<p><strong>STDERR:</strong></p><p><font color='red'>")
                        .append(result.getStderr().replaceAll("\n", "<br>"))
                        .append("</font></p>");
            }
            return Html.fromHtml(html.toString());
        }

    }


    public void output2(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                outputView2.setText(str2);
            }
        };
        handler.post(proc2);
    }















    private View.OnClickListener saveOutputfileClick; {

        saveOutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertSaveOutput();
                output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/xtb/"));
            }
        };
    }





    public void alertSaveOutput(){
        // creating the EditText widget programatically
        EditText editText15 = new EditText(Xtb.this);
        editText15.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText15.setTypeface(Typeface.MONOSPACE);
        editText15.addTextChangedListener(new TextWatcher() {
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
                editText15.removeTextChangedListener(this);
                String text = editText15.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText15.getText().clear();
                editText15.append(colorized_numbers(text));
                // place the cursor at the original position
                editText15.setSelection(startChanged+countChanged);
                editText15.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Xtb.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/xtb_work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText15)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String OutputProtocol = outputView2.getText().toString();
                        String SaveOutputName = editText15.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveOutputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(OutputProtocol);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveOutputName+" "+getFilesDir()+"/xtb_work");
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
        editText15.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }















    private View.OnClickListener HighlightClick; {

        HighlightClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                openhighlightdialog();
            }
        };
    }


    private void openhighlightdialog() {
        // TODO Auto-generated method stub //
        ProgressDialog progressDialog = new ProgressDialog(Xtb.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Highlighting numbers is in progress...");
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
                try {
                    outputX(exec("cat "+getFilesDir()+"/xtb/LastExecutionOutput.txt"));
                    output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
                    output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
                    output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
                    output(exec("ls -la "+getFilesDir()+"/xtb/"));
                    Toast.makeText(getApplicationContext(), "Numbers highlighted.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }

                onFinish();
            }

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void outputX(final String strX) {
                Runnable procX = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized_xtb(strX), EditText.BufferType.SPANNABLE);
                    }
                };
                handler.post(procX);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }

    private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Xtb.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


























    @Override
    protected void onResume() {
        super.onResume();
        output3(exec("cat "+getFilesDir()+"/xtb/Input-xtb.xyz"));
        output4(exec("cat "+getFilesDir()+"/xtb/Input-xtb.txt"));
        output5(exec("cat "+getFilesDir()+"/xtb/Command.txt"));
        output(exec("ls -la "+getFilesDir()+"/xtb/"));
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                InputFile.setText(colorized_elements(str3), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc3);
    }
    public void output4(final String str4) {
        Runnable proc4 = new Runnable() {
            public void run() {
                InFile.setText(colorized_xtb(str4), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc4);
    }
    public void output5(final String str5) {
        Runnable proc5 = new Runnable() {
            public void run() {
                Command.setText(colorized_xtb(str5), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc5);
    }
    public void output(final String str) {
        Runnable proc = new Runnable() {
            public void run() {
                Content.setText(str);
            }
        };
        handler.post(proc);
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

}