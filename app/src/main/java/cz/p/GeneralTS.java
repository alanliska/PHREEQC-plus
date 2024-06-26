package cz.p;

import static cz.p.Spannables.colorized_dftb;
import static cz.p.Spannables.colorized_mopac;

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

public class GeneralTS extends KineticsQuery {

    private EditText methodTS;
    private TextView keywTS_label;
    private EditText keywTS;
    private Button AddTS;
    private Button AddTSi;
    private Button ResetTS;
    private Button process;
    private Button quit;
    private TextView TSLabel;
    private TextView TS;
    private Button generateXYZ;
    private Button opsinXYZ;

    private Handler handler = new Handler();

    private static final int READ_FILE1 = 231;
    private Uri documentUri1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generalts);

        methodTS = (EditText) findViewById(R.id.methodTS);
        methodTS.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        methodTS.addTextChangedListener(new TextWatcher() {
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
                methodTS.removeTextChangedListener(this);
                String text = methodTS.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                methodTS.getText().clear();
                methodTS.append(colorized_mopac(text));
                // place the cursor at the original position
                methodTS.setSelection(startChanged+countChanged);
                methodTS.addTextChangedListener(this);
            }
        });
        keywTS_label = (TextView) findViewById(R.id.keywTS_label);
        keywTS = (EditText) findViewById(R.id.keywTS);
        keywTS.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        keywTS.addTextChangedListener(new TextWatcher() {
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
                keywTS.removeTextChangedListener(this);
                String text = keywTS.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                keywTS.getText().clear();
                keywTS.append(colorized_mopac(text));
                // place the cursor at the original position
                keywTS.setSelection(startChanged+countChanged);
                keywTS.addTextChangedListener(this);
            }
        });
        TSLabel = (TextView) findViewById(R.id.TSLabel);
        TS = (TextView) findViewById(R.id.TS);
        AddTS = (Button) findViewById(R.id.AddTS);
        AddTS.setOnClickListener(AddTSClick);
        AddTSi = (Button) findViewById(R.id.AddTSi);
        AddTSi.setOnClickListener(AddTSiClick);
        ResetTS = (Button) findViewById(R.id.ResetTS);
        ResetTS.setOnClickListener(ResetTSClick);
        process = (Button) findViewById(R.id.process);
        process.setOnClickListener(processClick);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(QuitClick);
        generateXYZ = (Button) findViewById(R.id.generateXYZ);
        generateXYZ.setOnClickListener(GenerateXYZClick);
        opsinXYZ = (Button) findViewById(R.id.opsinXYZ);
        opsinXYZ.setOnClickListener(opsinXYZClick);

    }

    public void onStart()
    {
        super.onStart();
        MethodTSDisplay(exec("cat "+getFilesDir()+"/General_methodTS.txt"));
        KeywTSDisplay(exec("cat "+getFilesDir()+"/General_keywTS.txt"));

        File filePathTS = new File(getFilesDir()+File.separator+"General_TS.txt");
        if (!filePathTS.exists()) {
            try {
                FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                outputWriterTS.write("Transition state XYZ coordinate file is not present.");
                outputWriterTS.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                outputWriterTS.write("Transition state XYZ coordinate file is available.");
                outputWriterTS.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        TS_StatusDisplay(exec("cat "+getFilesDir()+"/General_TS_status.txt"));
    }

    private View.OnClickListener GenerateXYZClick; {

        GenerateXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                /////////////////////////// SAVE EVERYTHING PRE-SET ////////////////////////////////
                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {
                    FileOutputStream fileout42 = openFileOutput("General_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("General_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN READ THE TS-FILE ////////////////////////////////
                alertGenerateXYZ();
                MethodTSDisplay(exec("cat "+getFilesDir()+"/General_methodTS.txt"));
                KeywTSDisplay(exec("cat "+getFilesDir()+"/General_keywTS.txt"));

                File filePathTS = new File(getFilesDir()+File.separator+"General_TS.txt");
                if (!filePathTS.exists()) {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file is not present.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file is available.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                TS_StatusDisplay(exec("cat "+getFilesDir()+"/General_TS_status.txt"));
            }
        };
    }


    public void alertGenerateXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(GeneralTS.this);
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
                editText100.append(colorized_dftb(text));
                // place the cursor at the original position
                editText100.setSelection(startChanged+countChanged);
                editText100.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(GeneralTS.this)
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

                            FileOutputStream fileout3 = openFileOutput("General_TS.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                            outputWriterTS.write("Transition state XYZ coordinate file is available.");
                            outputWriterTS.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        TS_StatusDisplay(exec("cat "+getFilesDir()+"/General_TS_status.txt"));
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
                /////////////////////////// SAVE EVERYTHING PRE-SET ////////////////////////////////
                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {
                    FileOutputStream fileout42 = openFileOutput("General_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("General_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN READ THE TS-FILE ////////////////////////////////
                alertOpsinXYZ();
                MethodTSDisplay(exec("cat "+getFilesDir()+"/General_methodTS.txt"));
                KeywTSDisplay(exec("cat "+getFilesDir()+"/General_keywTS.txt"));
                TS_StatusDisplay(exec("cat "+getFilesDir()+"/General_TS_status.txt"));

                File filePathTS = new File(getFilesDir()+File.separator+"General_TS.txt");
                if (!filePathTS.exists()) {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file is not present.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file is available.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                TS_StatusDisplay(exec("cat "+getFilesDir()+"/General_TS_status.txt"));
            }
        };
    }


    public void alertOpsinXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(GeneralTS.this);
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
                editText100.append(colorized_dftb(text));
                // place the cursor at the original position
                editText100.setSelection(startChanged+countChanged);
                editText100.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(GeneralTS.this)
                .setMessage("Please write the chemical name according to IUPAC to XYZ conversion. The result will be appended to the actual input file.")
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

                            FileOutputStream fileout3 = openFileOutput("General_TS.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                            outputWriterTS.write("Transition state XYZ coordinate file is available.");
                            outputWriterTS.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        TS_StatusDisplay(exec("cat "+getFilesDir()+"/General_TS_status.txt"));
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

    private View.OnClickListener AddTSClick; {

        AddTSClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                /////////////////////////// SAVE EVERYTHING PRE-SET ////////////////////////////////
                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {
                    FileOutputStream fileout42 = openFileOutput("General_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("General_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN READ THE TS-FILE ////////////////////////////////
                read1(getApplicationContext());
            }
        };
    }

    private void read1(Context context1) {
        Intent intent1 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        startActivityForResult(intent1, READ_FILE1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE1 && data != null) {
            try {
                documentUri1 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd1 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd1.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("General_TS.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd1.close();


            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private View.OnClickListener ResetTSClick; {

        ResetTSClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                exec("rm "+getFilesDir()+"/General_TS.txt");

                MethodTSDisplay(exec("cat "+getFilesDir()+"/General_methodTS.txt"));
                KeywTSDisplay(exec("cat "+getFilesDir()+"/General_keywTS.txt"));

                File filePathTS = new File(getFilesDir()+File.separator+"General_TS.txt");
                if (!filePathTS.exists()) {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file is not present.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file is available.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                TS_StatusDisplay(exec("cat "+getFilesDir()+"/General_TS_status.txt"));
            }
        };
    }

    private View.OnClickListener processClick; {

        processClick = new View.OnClickListener() {
            public void onClick(View v) {

                String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                String DatasetName1 = DatasetName0.replace(" ","_");
                String DatasetName = DatasetName1.replace(",",".");
                progressDialog = new ProgressDialog(GeneralTS.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Performing MOPAC calculations on transition state in dataset: "+DatasetName);
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
                            /////////////////////////////////// TS ///////////////////////////////////////////////
                            String MethodfileTS = methodTS.getText().toString();
                            String KeywordsfileTS = keywTS.getText().toString();

                            FileOutputStream fileout42 = openFileOutput("General_methodTS.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                            outputWriter42.write(MethodfileTS);
                            outputWriter42.close();
                            FileOutputStream fileout46 = openFileOutput("General_keywTS.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                            outputWriter46.write(KeywordsfileTS);
                            outputWriter46.close();


                            String InputfileNameTS0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                            String InputfileNameTS = InputfileNameTS0+"_TS";
                            exec("chmod 755 -R "+getFilesDir());
                            String KeyTS = MethodfileTS+" "+KeywordsfileTS;

                            try {
                                String Sed42 = exec("sed -e 1,2d "+getFilesDir()+"/General_TS.txt");
                                FileOutputStream fileout148 = openFileOutput(InputfileNameTS+".mop", MODE_PRIVATE);
                                OutputStreamWriter outputWriter148 = new OutputStreamWriter(fileout148);
                                outputWriter148.write(KeyTS);
                                outputWriter148.write("\n");
                                outputWriter148.write("\n");
                                outputWriter148.write("\n");
                                outputWriter148.write(Sed42);
                                outputWriter148.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            exec("mv "+getFilesDir()+"/"+InputfileNameTS+".mop "+getFilesDir()+File.separator+"openbabel/solv/opt/"+InputfileNameTS);
                            exec("mv "+getFilesDir()+"/General_TS.txt "+getFilesDir()+File.separator+"openbabel/xyz/"+InputfileNameTS+".xyz");
                            exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameTS+".iupac "+getFilesDir()+File.separator+"openbabel/iupac");
                            exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameTS+".formula "+getFilesDir()+File.separator+"openbabel/formula");


                            /////////////////////////////////// Calculate TS ///////////////////////////////////////////////

                            try {
                                exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameTS+" "+getFilesDir()+"/"+InputfileNameTS+".mop");
                                try {
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameTS);
                                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileNameTS);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                exec("mv "+getFilesDir()+"/"+InputfileNameTS+".mop "+getFilesDir()+"/openbabel/solv/opt/results/");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileNameTS+".out");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileNameTS+".arc");
                                exec("cp "+getFilesDir()+"/"+InputfileNameTS+".arc "+getFilesDir()+"/openbabel/solv/thermo");
                                exec("mv "+getFilesDir()+"/"+InputfileNameTS+".out "+getFilesDir()+"/openbabel/solv/opt/results/");
                                exec("mv "+getFilesDir()+"/"+InputfileNameTS+".arc "+getFilesDir()+"/openbabel/solv/opt/results/");
                                String Sed14003 = exec("sed -n 1p "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameTS);
                                String Sed14004 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameTS+".arc");
                                FileOutputStream fileout14009 = openFileOutput(InputfileNameTS+".mops", MODE_PRIVATE);
                                OutputStreamWriter outputWriter14009 = new OutputStreamWriter(fileout14009);
                                outputWriter14009.write(Sed14004);
                                outputWriter14009.close();
                                exec("cp "+getFilesDir()+"/"+InputfileNameTS+".mops "+getFilesDir()+"/openbabel/solv/thermo");
                                String Sed14005 = exec("sed -e 1,3d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameTS+".mops");
                                FileOutputStream fileout14010 = openFileOutput(InputfileNameTS+".mop", MODE_PRIVATE);
                                OutputStreamWriter outputWriter14010 = new OutputStreamWriter(fileout14010);
                                outputWriter14010.write("THERMO(298,298) LET "+Sed14003);
                                outputWriter14010.write("\n");
                                outputWriter14010.write("\n");
                                outputWriter14010.write(Sed14005);
                                outputWriter14010.close();
                                exec("rm "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameTS+".mops");
                                exec("rm "+getFilesDir()+"/"+InputfileNameTS+".mops");
                                try {
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameTS);
                                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileNameTS);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                exec("mv "+getFilesDir()+"/"+InputfileNameTS+".mop "+getFilesDir()+"/openbabel/solv/thermo/results/");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileNameTS+".out");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileNameTS+".arc");

                                String Grep14002 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileNameTS+".out");
                                FileOutputStream fileout14013 = openFileOutput(InputfileNameTS+"_s.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter14013 = new OutputStreamWriter(fileout14013);
                                outputWriter14013.write(Grep14002);
                                outputWriter14013.close();
                                String Sed14006 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileNameTS+"_s.temp");
                                String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                                String DatasetName1 = DatasetName0.replace(" ","_");
                                String DatasetName = DatasetName1.replace(",",".");
                                String FormulaTS = DatasetName+"_TS";
                                String MethodTS = methodTS.getText().toString();
                                FileOutputStream fileout14014 = openFileOutput(InputfileNameTS+"_s.txt",MODE_APPEND);
                                OutputStreamWriter outputWriter14014 = new OutputStreamWriter(fileout14014);
                                outputWriter14014.write(InputfileNameTS+" ");
                                outputWriter14014.write(FormulaTS+" ");
                                outputWriter14014.write(MethodTS+" ");
                                outputWriter14014.write(Sed14006);
                                outputWriter14014.close();
                                exec("rm "+getFilesDir()+"/"+InputfileNameTS+"_s.temp");

                                String RawOutput_s4 = exec("cat "+getFilesDir()+"/"+InputfileNameTS+"_s.txt");
                                while (RawOutput_s4.contains("  ")){  //2 spaces
                                    RawOutput_s4 = RawOutput_s4.replace("  ", " "); //(2 spaces, 1 space)
                                }
                                FileOutputStream fileout14016 = openFileOutput("thermo_s_TS.txt",MODE_PRIVATE);
                                OutputStreamWriter outputWriter14016 = new OutputStreamWriter(fileout14016);
                                outputWriter14016.write(RawOutput_s4);
                                outputWriter14016.close();

                                exec("mv "+getFilesDir()+"/"+InputfileNameTS+".out "+getFilesDir()+"/openbabel/solv/thermo/results/");
                                exec("mv "+getFilesDir()+"/"+InputfileNameTS+".arc "+getFilesDir()+"/openbabel/solv/thermo/results/");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            /////////////////////////////////// Process results ///////////////////////////////////////////////
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GeneralTS.b "+getFilesDir()+"/GeneralTS.bas");
                            exec("chmod -R 755 "+getFilesDir()+"/GeneralTS.b");
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GeneralTS.b");

                            /////////////////////////////////// Export results ///////////////////////////////////////////////

                            String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                            String DatasetName1 = DatasetName0.replace(" ","_");
                            String DatasetName = DatasetName1.replace(",",".");
                            File filePathExt = new File(getFilesDir()+"/openbabel/kinetics");
                            if (!filePathExt.exists()) {
                                filePathExt.mkdirs();
                            }

                            String Dataset = DatasetName;

                            exec("cp "+getFilesDir()+"/thermo_s_RATES_f.txt "+getFilesDir()+"/thermo_s_RATES_f_0.txt");
                            exec("cp "+getFilesDir()+"/thermo_s_RATES_b.txt "+getFilesDir()+"/thermo_s_RATES_b_0.txt");
                            exec("cp "+getFilesDir()+"/thermo_s_KINETICS_f.txt "+getFilesDir()+"/thermo_s_KINETICS_f_0.txt");
                            exec("cp "+getFilesDir()+"/thermo_s_KINETICS_b.txt "+getFilesDir()+"/thermo_s_KINETICS_b_0.txt");
                            exec("cp "+getFilesDir()+"/thermo_s_SMS.txt "+getFilesDir()+"/thermo_s_SMS_0.txt");
                            exec("cp "+getFilesDir()+"/thermo_s_SS.txt "+getFilesDir()+"/thermo_s_SS_0.txt");

                            String Rf = exec("cat "+getFilesDir()+"/thermo_s_RATES_f_0.txt");
                            Rf = Rf.replace("[H2O]", "H2O");
                            Rf = Rf.replace("[H+]+", "H+");
                            Rf = Rf.replace("[OH-]-", "OH-");
                            FileOutputStream Rf_stream = openFileOutput("thermo_s_RATES_f_w.txt", MODE_PRIVATE);
                            OutputStreamWriter Rf_writer = new OutputStreamWriter(Rf_stream);
                            Rf_writer.write(Rf);
                            Rf_writer.close();
                            exec("mv "+getFilesDir()+"/thermo_s_RATES_f_w.txt "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_forward_RATES_w.txt");
                            exec("rm "+getFilesDir()+"/thermo_s_RATES_f_0.txt");

                            String Rb = exec("cat "+getFilesDir()+"/thermo_s_RATES_b_0.txt");
                            Rb = Rb.replace("[H2O]", "H2O");
                            Rb = Rb.replace("[H+]+", "H+");
                            Rb = Rb.replace("[OH-]-", "OH-");
                            FileOutputStream Rb_stream = openFileOutput("thermo_s_RATES_b.txt", MODE_PRIVATE);
                            OutputStreamWriter Rb_writer = new OutputStreamWriter(Rb_stream);
                            Rb_writer.write(Rb);
                            Rb_writer.close();
                            exec("mv "+getFilesDir()+"/thermo_s_RATES_b.txt "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_backward_RATES_w.txt");
                            exec("rm "+getFilesDir()+"/thermo_s_RATES_b_0.txt");

                            String Kf = exec("cat "+getFilesDir()+"/thermo_s_KINETICS_f_0.txt");
                            Kf = Kf.replace("[H2O]", "H2O");
                            Kf = Kf.replace("[H+]+", "H+");
                            Kf = Kf.replace("[OH-]-", "OH-");
                            FileOutputStream Kf_stream = openFileOutput("thermo_s_KINETICS_f.txt", MODE_PRIVATE);
                            OutputStreamWriter Kf_writer = new OutputStreamWriter(Kf_stream);
                            Kf_writer.write(Kf);
                            Kf_writer.close();
                            exec("mv "+getFilesDir()+"/thermo_s_KINETICS_f.txt "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_forward_KINETICS_w.txt");
                            exec("rm "+getFilesDir()+"/thermo_s_KINETICS_f_0.txt");

                            String Kb = exec("cat "+getFilesDir()+"/thermo_s_KINETICS_b_0.txt");
                            Kb = Kb.replace("[H2O]", "H2O");
                            Kb = Kb.replace("[H+]+", "H+");
                            Kb = Kb.replace("[OH-]-", "OH-");
                            FileOutputStream Kb_stream = openFileOutput("thermo_s_KINETICS_b.txt", MODE_PRIVATE);
                            OutputStreamWriter Kb_writer = new OutputStreamWriter(Kb_stream);
                            Kb_writer.write(Kb);
                            Kb_writer.close();
                            exec("mv "+getFilesDir()+"/thermo_s_KINETICS_b.txt "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_backward_KINETICS_w.txt");
                            exec("rm "+getFilesDir()+"/thermo_s_KINETICS_b_0.txt");

                            String SMS = exec("cat "+getFilesDir()+"/thermo_s_SMS_0.txt");
                            SMS = SMS.replace("[H2O]\t[H2O]\t0\t[H2O]\t1", "");
                            SMS = SMS.replace("[H+]\t[H+]+\t0\t[H+]\t1", "");
                            SMS = SMS.replace("[OH-]\t[OH-]-\t0\t[OH-]\t1", "");
                            FileOutputStream SMS_stream = openFileOutput("thermo_s_SMS.txt", MODE_PRIVATE);
                            OutputStreamWriter SMS_writer = new OutputStreamWriter(SMS_stream);
                            SMS_writer.write(SMS);
                            SMS_writer.close();
                            exec("mv "+getFilesDir()+"/thermo_s_SMS.txt "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_MASTER_SPECIES_w.txt");
                            exec("rm "+getFilesDir()+"/thermo_s_SMS_0.txt");

                            String SS = exec("cat "+getFilesDir()+"/thermo_s_SS_0.txt");
                            SS = SS.replace("[H2O] = [H2O]", "");
                            SS = SS.replace("[H+]+ = [H+]+", "");
                            SS = SS.replace("[OH-]- = [OH-]-", "");
                            FileOutputStream SS_stream = openFileOutput("thermo_s_SS.txt", MODE_PRIVATE);
                            OutputStreamWriter SS_writer = new OutputStreamWriter(SS_stream);
                            SS_writer.write(SS);
                            SS_writer.close();
                            exec("mv "+getFilesDir()+"/thermo_s_SS.txt "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_SPECIES_w.txt");
                            exec("rm "+getFilesDir()+"/thermo_s_SS_0.txt");

                            exec("mv "+getFilesDir()+"/thermo_s_KINETICS_f.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_forward_KINETICS_anhydr.txt");
                            exec("mv "+getFilesDir()+"/thermo_s_KINETICS_b.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_backward_KINETICS_anhydr.txt");
                            exec("mv "+getFilesDir()+"/thermo_s_RATES_f.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_forward_RATES_anhydr.txt");
                            exec("mv "+getFilesDir()+"/thermo_s_RATES_b.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_backward_RATES_anhydr.txt");
                            exec("mv "+getFilesDir()+"/thermo_s_SMS.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_SOLUTION_MASTER_SPECIES.txt");
                            exec("mv "+getFilesDir()+"/thermo_s_SS.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_SOLUTION_SPECIES.txt");

                            exec("rm "+getFilesDir()+"/thermo_s_TS.txt");
                            exec("rm "+getFilesDir()+"/thermo_s_General.txt");
                            exec("rm "+getFilesDir()+"/GeneralResults_R.txt");
                            exec("rm "+getFilesDir()+"/GeneralResults_P.txt");

//                    exec("mv "+getFilesDir()+File.separator+"openbabel/xyz "+getFilesDir()+File.separator+"output");
//                    exec("mv "+getFilesDir()+File.separator+"openbabel/smiles "+getFilesDir()+File.separator+"output");
//                    exec("mv "+getFilesDir()+File.separator+"openbabel/gas "+getFilesDir()+File.separator+"output");
//                    exec("mv "+getFilesDir()+File.separator+"openbabel/solv "+getFilesDir()+File.separator+"output");
//                    exec("mv "+getFilesDir()+File.separator+"openbabel/iupac "+getFilesDir()+File.separator+"output");
//                    exec("mv "+getFilesDir()+File.separator+"openbabel/formula "+getFilesDir()+File.separator+"output");
//                    exec("mv "+getFilesDir()+File.separator+"openbabel/damping_factor "+getFilesDir()+File.separator+"output");
//                    exec("mv "+getFilesDir()+File.separator+"openbabel/kinetics "+getFilesDir()+File.separator+"output");
//                    exec("mv "+getFilesDir()+File.separator+"openbabel/tautomers "+getFilesDir()+File.separator+"output");

                            /////////////////////////////////// Display fields ///////////////////////////////////////////////

                            MethodTSDisplay(exec("cat "+getFilesDir()+"/General_methodTS.txt"));
                            KeywTSDisplay(exec("cat "+getFilesDir()+"/General_keywTS.txt"));

                            File filePathTS = new File(getFilesDir()+File.separator+"General_TS.txt");
                            if (!filePathTS.exists()) {
                                try {
                                    FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                                    OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                                    outputWriterTS.write("Transition state XYZ coordinate file is not present.");
                                    outputWriterTS.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                try {
                                    FileOutputStream fileoutTS = openFileOutput("General_TS_status.txt", MODE_PRIVATE);
                                    OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                                    outputWriterTS.write("Transition state XYZ coordinate file is available.");
                                    outputWriterTS.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            TS_StatusDisplay(exec("cat "+getFilesDir()+"/General_TS_status.txt"));





                        } catch (Exception e) {
                        }

//here:
                        Intent intent = new Intent(GeneralTS.this, ResumeActivityKin.class);
                        startActivity(intent);
                        onFinish();
                    }
                    public void onFinish(){
                        progressDialog.dismiss();
                    }
                }.start();
//and not here:
//                Intent intent = new Intent(GeneralTS.this, ResumeActivityKin.class);
//                startActivity(intent);

            }
        };
    }

    private View.OnClickListener AddTSiClick; {
        AddTSiClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(GeneralTS.this, AddTSGeneral.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                exec("rm "+getFilesDir()+"/thermo_s_TS.txt");
                exec("rm "+getFilesDir()+"/thermo_s_General.txt");
                exec("rm "+getFilesDir()+"/thermo_s_KINETICS_f.txt");
                exec("rm "+getFilesDir()+"/thermo_s_KINETICS_b.txt");
                exec("rm "+getFilesDir()+"/thermo_s_RATES_f.txt");
                exec("rm "+getFilesDir()+"/thermo_s_RATES_b.txt");
                exec("rm "+getFilesDir()+"/thermo_s_SMS.txt");
                exec("rm "+getFilesDir()+"/thermo_s_SS.txt");
                exec("rm "+getFilesDir()+"/GeneralResults_R.txt");
                exec("rm "+getFilesDir()+"/GeneralResults_P.txt");
                // TODO Auto-generated method stub //
                Intent intent = new Intent(GeneralTS.this, MainActivity.class);
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


    private void MethodTSDisplay(final String strMTS) {
        Runnable procMTS = new Runnable() {
            public void run() {
                methodTS.setText(colorized_mopac(strMTS), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procMTS);
    }
    private void KeywTSDisplay(final String strKTS) {
        Runnable procKTS = new Runnable() {
            public void run() {
                keywTS.setText(colorized_mopac(strKTS), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procKTS);
    }
    private void TS_StatusDisplay(final String strTSSD) {
        Runnable procTSSD = new Runnable() {
            public void run() {
                TS.setText(strTSSD);
            }
        };
        handler.post(procTSSD);
    }

}
