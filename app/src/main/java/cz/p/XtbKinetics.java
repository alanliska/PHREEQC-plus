package cz.p;

import static cz.p.Spannables.colorized_dftb;
import static cz.p.Spannables.colorized_xtb;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

public class XtbKinetics extends MainActivity {

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
    private EditText reactant_smiles;
    private EditText reactant_formulas;
    private EditText product_smiles;

    private Button runbutton;
    private Button quit;

    Button openCommandfile;
    Button openIntCommandfile;
    Button saveCommandfile;
    Button saveExtCommandfile;

    Button openInfile;
    Button openIntInfile;
    Button saveInfile;
    Button saveExtInfile;

    private Handler handler = new Handler();

    private static final int READ_FILE26 = 26;
    private Uri documentUri26;
    private static final int CREATE_FILE01 = 1;
    private Uri documentUri1;
    private static final int READ_FILE60 = 60;
    private Uri documentUri60;
    private static final int CREATE_FILE200 = 200;
    private Uri documentUri200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xtbkinetics);

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
        reactant_smiles = (EditText) findViewById(R.id.reactant_smiles);
        reactant_smiles.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        reactant_smiles.addTextChangedListener(new TextWatcher() {
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
                reactant_smiles.removeTextChangedListener(this);
                String text = reactant_smiles.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                reactant_smiles.getText().clear();
                reactant_smiles.append(colorized_xtb(text));
                // place the cursor at the original position
                reactant_smiles.setSelection(startChanged+countChanged);
                reactant_smiles.addTextChangedListener(this);
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
        product_smiles = (EditText) findViewById(R.id.product_smiles);
        product_smiles.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        product_smiles.addTextChangedListener(new TextWatcher() {
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
                product_smiles.removeTextChangedListener(this);
                String text = product_smiles.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                product_smiles.getText().clear();
                product_smiles.append(colorized_xtb(text));
                // place the cursor at the original position
                product_smiles.setSelection(startChanged+countChanged);
                product_smiles.addTextChangedListener(this);
            }
        });

        runbutton = (Button) findViewById(R.id.runbutton);
        runbutton.setOnClickListener(runbuttonClick);
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
                Intent intent = new Intent(XtbKinetics.this, XtbKinWork1.class);
                startActivity(intent);
            }
        });

        openIntCommandfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XtbKinetics.this, XtbKinCommand.class);
                startActivity(intent);
            }
        });

    }

    public void onStart()
    {
        super.onStart();
        SmilesRDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesR.txt"));
        SmilesPDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesP.txt"));
        FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
        FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
        ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
        DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));

    }

    private View.OnClickListener openInfileClick; {

        openInfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String SmilesR = reactant_smiles.getText().toString();
                String SmilesP = product_smiles.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_smilesR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(SmilesR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_smilesP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(SmilesP);
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
                SmilesRDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesR.txt"));
                SmilesPDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesP.txt"));
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
                String SmilesR = reactant_smiles.getText().toString();
                String SmilesP = product_smiles.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_smilesR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(SmilesR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_smilesP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(SmilesP);
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
                SmilesRDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesR.txt"));
                SmilesPDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesP.txt"));
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
                String SmilesR = reactant_smiles.getText().toString();
                String SmilesP = product_smiles.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_smilesR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(SmilesR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_smilesP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(SmilesP);
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
                SmilesRDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesR.txt"));
                SmilesPDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesP.txt"));
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
                String SmilesR = reactant_smiles.getText().toString();
                String SmilesP = product_smiles.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_smilesR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(SmilesR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_smilesP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(SmilesP);
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
                SmilesRDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesR.txt"));
                SmilesPDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesP.txt"));
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

    }

    private View.OnClickListener saveInfileClick; {

        saveInfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String SmilesR = reactant_smiles.getText().toString();
                String SmilesP = product_smiles.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_smilesR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(SmilesR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_smilesP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(SmilesP);
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
                SmilesRDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesR.txt"));
                SmilesPDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }


    public void alertSaveIn(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(XtbKinetics.this);
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
                editText10.append(colorized_dftb(text));
                // place the cursor at the original position
                editText10.setSelection(startChanged+countChanged);
                editText10.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(XtbKinetics.this)
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
                String SmilesR = reactant_smiles.getText().toString();
                String SmilesP = product_smiles.getText().toString();
                String FormulaR = reactant_formulas.getText().toString();
                String FormulaP = product_formulas.getText().toString();
                String Process = process.getText().toString();
                String Details = details.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("Xtb_smilesR.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(SmilesR);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Xtb_smilesP.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(SmilesP);
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
                SmilesRDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesR.txt"));
                SmilesPDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesP.txt"));
                FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));
            }
        };
    }


    public void alertSaveCommand(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(XtbKinetics.this);
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
                editText10.append(colorized_dftb(text));
                // place the cursor at the original position
                editText10.setSelection(startChanged+countChanged);
                editText10.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(XtbKinetics.this)
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
                progressDialog = new ProgressDialog(XtbKinetics.this);
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
                        String SmilesR = reactant_smiles.getText().toString();
                        String SmilesP = product_smiles.getText().toString();
                        String FormulaR = reactant_formulas.getText().toString();
                        String FormulaP = product_formulas.getText().toString();
                        String Process = process.getText().toString();
                        String Details = details.getText().toString();

                        try {

                            FileOutputStream fileout = openFileOutput("Xtb_smilesR.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(SmilesR);
                            outputWriter.close();
                            FileOutputStream fileout2 = openFileOutput("Xtb_smilesP.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(SmilesP);
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
//                        Process = Process.replace(" buildwire ", " "+getApplicationInfo().nativeLibraryDir+"/libbuildwire.so ");
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

                            SmilesRDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesR.txt"));
                            SmilesPDisplay(exec("cat "+getFilesDir()+"/Xtb_smilesP.txt"));
                            FormulasRDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaR.txt"));
                            FormulasPDisplay(exec("cat "+getFilesDir()+"/Xtb_formulaP.txt"));
                            ProcessDisplay(exec("cat "+getFilesDir()+"/XtbKineticsCommand.txt"));
                            DetailsDisplay(exec("cat "+getFilesDir()+"/XtbKin.inp"));

                        } catch (Exception e) {
                        }

//here:
                        Intent intent = new Intent(XtbKinetics.this, ResumeActivityKin.class);
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

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(XtbKinetics.this, MainActivity.class);
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


    private void SmilesRDisplay(final String strSR) {
        Runnable procSR = new Runnable() {
            public void run() {
                reactant_smiles.setText(colorized_xtb(strSR), EditText.BufferType.SPANNABLE);
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
    private void SmilesPDisplay(final String strSP) {
        Runnable procSP = new Runnable() {
            public void run() {
                product_smiles.setText(colorized_xtb(strSP), EditText.BufferType.SPANNABLE);
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
