package cz.p;

import static cz.p.Spannables.colorized_mopac;
import static cz.p.Spannables.colorized_numbers;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

public class Chemsol1 extends MainActivity {

    private Handler handler = new Handler();
    public TextView method_label;
    public EditText method;
    public TextView solvation_label;
    public EditText solvation;
    public TextView keywords_label;
    public EditText keywords;
    public TextView iupac_label;
    public EditText iupac;
    public TextView formula_label;
    public EditText formula;
    public TextView smiles_label;
    public EditText smiles;
    public Button openbabel_opsin;
    public Button openbabel_continue;
    public Button openbabel_exit;
    public Button quit;
    public TextView mopac_label;
    public TextView mopac_input;
    public TextView mopac_filelist_label;
    public TextView mopac_filelist;
    public Button databasemakers;
    public TextView tautomers_label;
    public EditText tautomers;
    public TextView damp_label;
    public EditText damping_factor;
//    private TextView solvent_corr_label;
//    private EditText solvent_corr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.chemsol1);

        method_label = (TextView) findViewById(R.id.method_label);
        method = (EditText) findViewById(R.id.method);
        method.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        method.addTextChangedListener(new TextWatcher() {
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
                method.removeTextChangedListener(this);
                String text = method.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                method.getText().clear();
                method.append(colorized_mopac(text));
                // place the cursor at the original position
                method.setSelection(startChanged+countChanged);
                method.addTextChangedListener(this);
            }
        });
        solvation_label = (TextView) findViewById(R.id.solvation_label);
        solvation = (EditText) findViewById(R.id.solvation);
        solvation.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        solvation.addTextChangedListener(new TextWatcher() {
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
                solvation.removeTextChangedListener(this);
                String text = solvation.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                solvation.getText().clear();
                solvation.append(colorized_mopac(text));
                // place the cursor at the original position
                solvation.setSelection(startChanged+countChanged);
                solvation.addTextChangedListener(this);
            }
        });
        keywords_label = (TextView) findViewById(R.id.keywords_label);
        keywords = (EditText) findViewById(R.id.keywords);
        keywords.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        keywords.addTextChangedListener(new TextWatcher() {
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
                keywords.removeTextChangedListener(this);
                String text = keywords.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                keywords.getText().clear();
                keywords.append(colorized_mopac(text));
                // place the cursor at the original position
                keywords.setSelection(startChanged+countChanged);
                keywords.addTextChangedListener(this);
            }
        });
        tautomers_label = (TextView) findViewById(R.id.tautomers_label);
        tautomers = (EditText) findViewById(R.id.tautomers);
        tautomers.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        tautomers.addTextChangedListener(new TextWatcher() {
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
                tautomers.removeTextChangedListener(this);
                String text = tautomers.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                tautomers.getText().clear();
                tautomers.append(colorized_mopac(text));
                // place the cursor at the original position
                tautomers.setSelection(startChanged+countChanged);
                tautomers.addTextChangedListener(this);
            }
        });
        damp_label = (TextView) findViewById(R.id.damp_label);
        damping_factor = (EditText) findViewById(R.id.damping_factor);
        damping_factor.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        damping_factor.addTextChangedListener(new TextWatcher() {
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
                damping_factor.removeTextChangedListener(this);
                String text = damping_factor.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                damping_factor.getText().clear();
                damping_factor.append(colorized_mopac(text));
                // place the cursor at the original position
                damping_factor.setSelection(startChanged+countChanged);
                damping_factor.addTextChangedListener(this);
            }
        });
        iupac_label = (TextView) findViewById(R.id.iupac_label);
        iupac = (EditText) findViewById(R.id.iupac);
        iupac.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        iupac.addTextChangedListener(new TextWatcher() {
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
                iupac.removeTextChangedListener(this);
                String text = iupac.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                iupac.getText().clear();
                iupac.append(colorized_mopac(text));
                // place the cursor at the original position
                iupac.setSelection(startChanged+countChanged);
                iupac.addTextChangedListener(this);
            }
        });
        formula_label = (TextView) findViewById(R.id.formula_label);
        formula = (EditText) findViewById(R.id.formula);
        formula.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        formula.addTextChangedListener(new TextWatcher() {
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
                formula.removeTextChangedListener(this);
                String text = formula.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                formula.getText().clear();
                formula.append(colorized_mopac(text));
                // place the cursor at the original position
                formula.setSelection(startChanged+countChanged);
                formula.addTextChangedListener(this);
            }
        });
        smiles_label = (TextView) findViewById(R.id.smiles_label);
        smiles = (EditText) findViewById(R.id.smiles);
        smiles.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        smiles.addTextChangedListener(new TextWatcher() {
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
                smiles.removeTextChangedListener(this);
                String text = smiles.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                smiles.getText().clear();
                smiles.append(colorized_mopac(text));
                // place the cursor at the original position
                smiles.setSelection(startChanged+countChanged);
                smiles.addTextChangedListener(this);
            }
        });
        openbabel_opsin = (Button) findViewById(R.id.openbabel_opsin);
        openbabel_opsin.setOnClickListener(openbabel_opsin_click);
        openbabel_continue = (Button) findViewById(R.id.openbabel_continue);
        openbabel_continue.setOnClickListener(openbabel_continue_click);
        openbabel_exit = (Button) findViewById(R.id.openbabel_exit);
        openbabel_exit.setOnClickListener(openbabel_exit_click);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(quit_click);
        mopac_label = (TextView) findViewById(R.id.mopac_label);
        mopac_input = (TextView) findViewById(R.id.mopac_input);
        mopac_filelist_label = (TextView) findViewById(R.id.mopac_filelist_label);
        mopac_filelist = (TextView) findViewById(R.id.mopac_filelist);
//        solvent_corr_label = (TextView) findViewById(R.id.solvent_corr_label);
//        solvent_corr = (EditText) findViewById(R.id.solvent_corr);
//        solvent_corr.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
//        solvent_corr.addTextChangedListener(new TextWatcher() {
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
//                solvent_corr.removeTextChangedListener(this);
//                String text = solvent_corr.getText().toString();
//                // important - not setText() - otherwise the keyboard would be reset after each type
//                solvent_corr.getText().clear();
//                solvent_corr.append(colorized_numbers(text));
//                // place the cursor at the original position
//                solvent_corr.setSelection(startChanged+countChanged);
//                solvent_corr.addTextChangedListener(this);
//            }
//        });

    }

    public void onStart()
    {
        super.onStart();
        method_view(exec("cat "+getFilesDir()+"/method.txt"));
        solvation_view(exec("cat "+getFilesDir()+"/solvation.txt"));
        keywords_view(exec("cat "+getFilesDir()+"/keywords.txt"));
        tautomers_view(exec("cat "+getFilesDir()+"/tautomers.txt"));
        damp_view(exec("cat "+getFilesDir()+"/damping-factor.txt"));
        iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
        formula_view(exec("cat "+getFilesDir()+"/formula.txt"));
        smiles_view(exec("cat "+getFilesDir()+"/smiles.txt"));
        mopac_filelist_view(exec("ls -l "+getFilesDir()+"/openbabel/xyz"));
//        solvent_corr_view(exec("cat "+getFilesDir()+"/solvent_moles.txt"));
    }

    private View.OnClickListener openbabel_opsin_click; {

        openbabel_opsin_click = new View.OnClickListener() {
            public void onClick(View v) {
                String Inputfile = smiles.getText().toString();
                String InputfileName0 = iupac.getText().toString();
                String Solvationfile = solvation.getText().toString();
                String Methodfile = method.getText().toString();
                String Keywordsfile = keywords.getText().toString();
                String Tautomers = tautomers.getText().toString();
                String Formulafile = formula.getText().toString();
                String DampingFactor = damping_factor.getText().toString();
//                String SolventCorr = solvent_corr.getText().toString();

                File filePath = new File(getFilesDir()+File.separator+"openbabel");
                try {
                    if (!filePath.exists()) {
                        filePath.mkdirs();
                    }
                    FileOutputStream fileout = openFileOutput("smiles.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("method.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Methodfile);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("formula.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(Formulafile);
                    outputWriter8.close();
                    FileOutputStream fileout5 = openFileOutput("solvation.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(Solvationfile);
                    outputWriter5.close();
                    FileOutputStream fileout6 = openFileOutput("keywords.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Keywordsfile);
                    outputWriter6.close();
                    FileOutputStream fileout0 = openFileOutput("tautomers.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter0 = new OutputStreamWriter(fileout0);
                    outputWriter0.write(Tautomers);
                    outputWriter0.close();
                    FileOutputStream fileout11 = openFileOutput("damping-factor.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter11 = new OutputStreamWriter(fileout11);
                    outputWriter11.write(DampingFactor);
                    outputWriter11.close();
//                    FileOutputStream fileout7 = openFileOutput("solvent-moles.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter7 = new OutputStreamWriter(fileout7);
//                    outputWriter7.write(SolventCorr);
//                    outputWriter7.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                progressDialog = new ProgressDialog(Chemsol1.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Conversion is running...");
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
                            exec("chmod 755 -R "+getFilesDir());
                            String InputfileName1 = InputfileName0.replace(" ","_");
                            String InputfileName = InputfileName1.replace(",",".");
                            String NameToConvert = iupac.getText().toString();
                            ////////////////////////////////////
                            NameToStructure nts = NameToStructure.getInstance();
                            NameToStructureConfig ntsconfig = new NameToStructureConfig();
//a new NameToStructureConfig starts as a copy of OPSIN's default configuration
                            ntsconfig.setAllowRadicals(true);
//                OpsinResult result = nts.parseChemicalName("acetamide", ntsconfig);
                            OpsinResult result = nts.parseChemicalName(NameToConvert+"", ntsconfig);
                            String smiles = result.getSmiles();
                            /////////////////////////////////////
                            FileOutputStream fileout3 = openFileOutput("smiles.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(smiles);
                            outputWriter3.close();
//                            FileOutputStream fileoutNts = openFileOutput("iupac.txt", MODE_PRIVATE);
//                            OutputStreamWriter outputWriterNts = new OutputStreamWriter(fileoutNts);
//                            outputWriterNts.write(NameToConvert);
//                            outputWriterNts.close();
                            method_view(exec("cat "+getFilesDir()+"/method.txt"));
                            solvation_view(exec("cat "+getFilesDir()+"/solvation.txt"));
                            keywords_view(exec("cat "+getFilesDir()+"/keywords.txt"));
                            tautomers_view(exec("cat "+getFilesDir()+"/tautomers.txt"));
                            damp_view(exec("cat "+getFilesDir()+"/damping-factor.txt"));
                            iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                            formula_view(exec("cat "+getFilesDir()+"/formula.txt"));
                            smiles_view(exec("cat "+getFilesDir()+"/smiles.txt"));
                            mopac_view(exec("cat "+getFilesDir()+File.separator+"openbabel/gas/opt/"+InputfileName));
                            mopac_filelist_view(exec("ls -l "+getFilesDir()+"/openbabel/xyz"));
//                            solvent_corr_view(exec("cat "+getFilesDir()+"/solvent_moles.txt"));

                        } catch (Exception e) {
                        }
                        onFinish();
                    }

                    public void onFinish() {
                        progressDialog.dismiss();
                    }
                }.start();
            }
        };
    }

    private View.OnClickListener openbabel_continue_click; {

        openbabel_continue_click = new View.OnClickListener() {
            public void onClick(View v) {
                String Inputfile = smiles.getText().toString();
                String InputfileName0 = iupac.getText().toString();
                String Solvationfile = solvation.getText().toString();
                String Methodfile = method.getText().toString();
                String Keywordsfile = keywords.getText().toString();
                String Tautomers = tautomers.getText().toString();
                String Formulafile = formula.getText().toString();
                String DampingFactor = damping_factor.getText().toString();
//                String SolventCorr = solvent_corr.getText().toString();

                File filePath = new File(getFilesDir()+File.separator+"openbabel");
                try {
                    if (!filePath.exists()) {
                        filePath.mkdirs();
                    }
                    FileOutputStream fileout = openFileOutput("smiles.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("method.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Methodfile);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("formula.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(Formulafile);
                    outputWriter8.close();
                    FileOutputStream fileout5 = openFileOutput("solvation.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(Solvationfile);
                    outputWriter5.close();
                    FileOutputStream fileout6 = openFileOutput("keywords.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(Keywordsfile);
                    outputWriter6.close();
                    FileOutputStream fileout0 = openFileOutput("tautomers.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter0 = new OutputStreamWriter(fileout0);
                    outputWriter0.write(Tautomers);
                    outputWriter0.close();
                    FileOutputStream fileout11 = openFileOutput("damping-factor.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter11 = new OutputStreamWriter(fileout11);
                    outputWriter11.write(DampingFactor);
                    outputWriter11.close();
//                    FileOutputStream fileout7 = openFileOutput("solvent-moles.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter7 = new OutputStreamWriter(fileout7);
//                    outputWriter7.write(SolventCorr);
//                    outputWriter7.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                try {

                    String InputfileName1 = InputfileName0.replace(" ","_");
                    String InputfileName = InputfileName1.replace(",",".");
//                    exec("cp "+getFilesDir()+"/solvent-moles.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".smoles");
                    exec("cp "+getFilesDir()+"/smiles.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".smi");
                    exec("cp "+getFilesDir()+"/iupac.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".iupac");
                    exec("cp "+getFilesDir()+"/formula.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".formula");
                    exec("cp "+getFilesDir()+"/tautomers.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".taut");
                    exec("cp "+getFilesDir()+"/damping-factor.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".damp");
                    exec("chmod 755 -R "+getFilesDir());
                    // String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+File.separator+"openbabel"+File.separator+InputfileName+".smi -oxyz --gen3d");
                    com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi ./openbabel/"+InputfileName+".smi -oxyz --gen3d > ObabelOutput.txt");
                    String ObabelOutput = exec("cat "+getFilesDir()+"/ObabelOutput.txt");

                    FileOutputStream fileout4 = openFileOutput(InputfileName+".xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(ObabelOutput);
                    outputWriter4.close();
                    String KeyWithoutSolv = Methodfile+" "+Keywordsfile;
                    String KeyWithSolv = Methodfile+" "+Keywordsfile+" "+Solvationfile;
                    File filePath1 = new File(getFilesDir()+File.separator+"openbabel/gas/opt");
                    try {
                        if (!filePath1.exists()) {
                            filePath1.mkdirs();
                        }
                        String Sed1 = exec("sed -e 1,2d "+getFilesDir()+"/"+InputfileName+".xyz");
                        FileOutputStream fileout7 = openFileOutput(InputfileName+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter7 = new OutputStreamWriter(fileout7);
                        outputWriter7.write(KeyWithoutSolv);
                        outputWriter7.write("\n");
                        outputWriter7.write("\n");
                        outputWriter7.write("\n");
                        outputWriter7.write(Sed1);
                        outputWriter7.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+File.separator+"openbabel/gas/opt/"+InputfileName);

                    File filePath02 = new File(getFilesDir()+File.separator+"openbabel/solv/opt");
                    try {
                        if (!filePath02.exists()) {
                            filePath02.mkdirs();
                        }
                        String Sed2 = exec("sed -e 1,2d "+getFilesDir()+"/"+InputfileName+".xyz");
                        FileOutputStream fileout8 = openFileOutput(InputfileName+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                        outputWriter8.write(KeyWithSolv);
                        outputWriter8.write("\n");
                        outputWriter8.write("\n");
                        outputWriter8.write("\n");
                        outputWriter8.write(Sed2);
                        outputWriter8.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+File.separator+"openbabel/solv/opt/"+InputfileName);

                    File filePath2 = new File(getFilesDir()+File.separator+"openbabel/solv/thermo");
                    try {
                        if (!filePath2.exists()) {
                            filePath2.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("cp "+getFilesDir()+"/"+InputfileName+".xyz "+getFilesDir()+File.separator+"openbabel/solv/thermo/"+InputfileName);

                    File filePath3 = new File(getFilesDir()+File.separator+"openbabel/smiles");
                    try {
                        if (!filePath3.exists()) {
                            filePath3.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileName+".smi "+getFilesDir()+File.separator+"openbabel/smiles");

                    File filePath4 = new File(getFilesDir()+File.separator+"openbabel/xyz");
                    try {
                        if (!filePath4.exists()) {
                            filePath4.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/"+InputfileName+".xyz "+getFilesDir()+File.separator+"openbabel/xyz");

                    File filePath5 = new File(getFilesDir()+File.separator+"openbabel/iupac");
                    try {
                        if (!filePath5.exists()) {
                            filePath5.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileName+".iupac "+getFilesDir()+File.separator+"openbabel/iupac");

                    File filePath7 = new File(getFilesDir()+File.separator+"openbabel/formula");
                    try {
                        if (!filePath7.exists()) {
                            filePath7.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileName+".formula "+getFilesDir()+File.separator+"openbabel/formula");

                    File filePath0 = new File(getFilesDir()+File.separator+"openbabel/tautomers");
                    try {
                        if (!filePath0.exists()) {
                            filePath0.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileName+".taut "+getFilesDir()+File.separator+"openbabel/tautomers");

                    File filePath11 = new File(getFilesDir()+File.separator+"openbabel/damping_factor");
                    try {
                        if (!filePath11.exists()) {
                            filePath11.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileName+".damp "+getFilesDir()+File.separator+"openbabel/damping_factor");

                    method_view(exec("cat "+getFilesDir()+"/method.txt"));
                    solvation_view(exec("cat "+getFilesDir()+"/solvation.txt"));
                    keywords_view(exec("cat "+getFilesDir()+"/keywords.txt"));
                    tautomers_view(exec("cat "+getFilesDir()+"/tautomers.txt"));
                    damp_view(exec("cat "+getFilesDir()+"/damping-factor.txt"));
                    iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                    formula_view(exec("cat "+getFilesDir()+"/formula.txt"));
                    smiles_view(exec("cat "+getFilesDir()+"/smiles.txt"));
                    mopac_view(exec("cat "+getFilesDir()+File.separator+"openbabel/gas/opt/"+InputfileName));
                    mopac_filelist_view(exec("ls -l "+getFilesDir()+"/openbabel/xyz"));
//                    solvent_corr_view(exec("cat "+getFilesDir()+"/solvent_moles.txt"));

                } catch (Exception e) {
                }
            }
        };
    }

    public void method_view(final String method_str) {
        Runnable method_proc = new Runnable() {
            public void run() {
                method.setText(colorized_mopac(method_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(method_proc);
    }

    public void solvation_view(final String solvation_str) {
        Runnable solvation_proc = new Runnable() {
            public void run() {
                solvation.setText(colorized_mopac(solvation_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(solvation_proc);
    }

    public void keywords_view(final String keywords_str) {
        Runnable keywords_proc = new Runnable() {
            public void run() {
                keywords.setText(colorized_mopac(keywords_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(keywords_proc);
    }

    public void iupac_view(final String iupac_str) {
        Runnable iupac_proc = new Runnable() {
            public void run() {
                iupac.setText(colorized_mopac(iupac_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(iupac_proc);
    }

    public void formula_view(final String formula_str) {
        Runnable formula_proc = new Runnable() {
            public void run() {
                formula.setText(colorized_mopac(formula_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(formula_proc);
    }

    public void smiles_view(final String smiles_str) {
        Runnable smiles_proc = new Runnable() {
            public void run() {
                smiles.setText(colorized_mopac(smiles_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(smiles_proc);
    }

    public void mopac_view(final String mopac_str) {
        Runnable mopac_proc = new Runnable() {
            public void run() {
                mopac_input.setText(colorized_mopac(mopac_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(mopac_proc);
    }

    public void mopac_filelist_view(final String mopac_filelist_str) {
        Runnable mopac_filelist_proc = new Runnable() {
            public void run() {
                mopac_filelist.setText(colorized_mopac(mopac_filelist_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(mopac_filelist_proc);
    }

//    public void solvent_corr_view(final String solvent_corr_str) {
//        Runnable solvent_corr_proc = new Runnable() {
//            public void run() {
//                solvent_corr.setText(colorized_numbers(solvent_corr_str), EditText.BufferType.SPANNABLE);
//            }
//        };
//        handler.post(solvent_corr_proc);
//    }

    public void tautomers_view(final String tautomers_str) {
        Runnable tautomers_proc = new Runnable() {
            public void run() {
                tautomers.setText(colorized_mopac(tautomers_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(tautomers_proc);
    }

    public void damp_view(final String damp_str) {
        Runnable damp_proc = new Runnable() {
            public void run() {
                damping_factor.setText(colorized_mopac(damp_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(damp_proc);
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

    private View.OnClickListener openbabel_exit_click; {

        openbabel_exit_click = new View.OnClickListener() {
            public void onClick(View v) {

                String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                String DatasetName1 = DatasetName0.replace(" ","_");
                String DatasetName = DatasetName1.replace(",",".");

                progressDialog = new ProgressDialog(Chemsol1.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Performing MOPAC and CHEMSOL calculations on species contained in dataset: "+DatasetName);
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

                        File filePath6 = new File(getFilesDir()+File.separator+"openbabel/gas/opt/results");
                        try {
                            if (!filePath6.exists()) {
                                filePath6.mkdirs();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        File filePath8 = new File(getFilesDir()+File.separator+"openbabel/gas/thermo/results");
                        try {
                            if (!filePath8.exists()) {
                                filePath8.mkdirs();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        File filePath9 = new File(getFilesDir()+File.separator+"openbabel/solv/opt/results");
                        try {
                            if (!filePath9.exists()) {
                                filePath9.mkdirs();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        File filePath10 = new File(getFilesDir()+File.separator+"openbabel/solv/thermo/results");
                        try {
                            if (!filePath10.exists()) {
                                filePath10.mkdirs();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        File[] files = new File(getFilesDir()+"/openbabel/gas/opt").listFiles();
                        for (File file : files) {
                            if (!file.isFile()) continue;


                            String InputfileName = file.getName();
                            String Formula = exec("cat "+getFilesDir()+"/openbabel/formula/"+InputfileName+".formula");
                            String Method = exec("cat "+getFilesDir()+"/method.txt");

                            Formula = Formula.replace(",", ".");

                            ///////////////// introduce [C], [H], [N], [O], [S], [F] to formula programatically /////////////////////////
                            //                    try {
//                    while (Formula.contains("C")){
//                            Formula = Formula.replace("C", "[C]");
//                            Formula = Formula.replace("[C]a", "Ca");
//                            Formula = Formula.replace("[C]b", "Cb");
//                            Formula = Formula.replace("[C]c", "Cc");
//                            Formula = Formula.replace("[C]d", "Cd");
//                            Formula = Formula.replace("[C]e", "Ce");
//                            Formula = Formula.replace("[C]f", "Cf");
//                            Formula = Formula.replace("[C]g", "Cg");
//                            Formula = Formula.replace("[C]h", "Ch");
//                            Formula = Formula.replace("[C]i", "Ci");
//                            Formula = Formula.replace("[C]j", "Cj");
//                            Formula = Formula.replace("[C]k", "Ck");
//                            Formula = Formula.replace("[C]l", "Cl");
//                            Formula = Formula.replace("[C]m", "Cm");
//                            Formula = Formula.replace("[C]n", "Cn");
//                            Formula = Formula.replace("[C]o", "Co");
//                            Formula = Formula.replace("[C]p", "Cp");
//                            Formula = Formula.replace("[C]q", "Cq");
//                            Formula = Formula.replace("[C]r", "Cr");
//                            Formula = Formula.replace("[C]s", "Cs");
//                            Formula = Formula.replace("[C]t", "Ct");
//                            Formula = Formula.replace("[C]u", "Cu");
//                            Formula = Formula.replace("[C]v", "Cv");
//                            Formula = Formula.replace("[C]w", "Cw");
//                            Formula = Formula.replace("[C]x", "Cx");
//                            Formula = Formula.replace("[C]y", "Cy");
//                            Formula = Formula.replace("[C]z", "Cz");
//                    }
//                    while (Formula.contains("H")){
                            Formula = Formula.replace("H", "[H]");
                            Formula = Formula.replace("[H]a", "Ha");
                            Formula = Formula.replace("[H]b", "Hb");
                            Formula = Formula.replace("[H]c", "Hc");
                            Formula = Formula.replace("[H]d", "Hd");
                            Formula = Formula.replace("[H]e", "He");
                            Formula = Formula.replace("[H]f", "Hf");
                            Formula = Formula.replace("[H]g", "Hg");
                            Formula = Formula.replace("[H]h", "Hh");
                            Formula = Formula.replace("[H]i", "Hi");
                            Formula = Formula.replace("[H]j", "Hj");
                            Formula = Formula.replace("[H]k", "Hk");
                            Formula = Formula.replace("[H]l", "Hl");
                            Formula = Formula.replace("[H]m", "Hm");
                            Formula = Formula.replace("[H]n", "Hn");
                            Formula = Formula.replace("[H]o", "Ho");
                            Formula = Formula.replace("[H]p", "Hp");
                            Formula = Formula.replace("[H]q", "Hq");
                            Formula = Formula.replace("[H]r", "Hr");
                            Formula = Formula.replace("[H]s", "Hs");
                            Formula = Formula.replace("[H]t", "Ht");
                            Formula = Formula.replace("[H]u", "Hu");
                            Formula = Formula.replace("[H]v", "Hv");
                            Formula = Formula.replace("[H]w", "Hw");
                            Formula = Formula.replace("[H]x", "Hx");
                            Formula = Formula.replace("[H]y", "Hy");
                            Formula = Formula.replace("[H]z", "Hz");
//                    }
//                    while (Formula.contains("N")){
//                            Formula = Formula.replace("N", "[N]");
//                            Formula = Formula.replace("[N]a", "Na");
//                            Formula = Formula.replace("[N]b", "Nb");
//                            Formula = Formula.replace("[N]c", "Nc");
//                            Formula = Formula.replace("[N]d", "Nd");
//                            Formula = Formula.replace("[N]e", "Ne");
//                            Formula = Formula.replace("[N]f", "Nf");
//                            Formula = Formula.replace("[N]g", "Ng");
//                            Formula = Formula.replace("[N]h", "Nh");
//                            Formula = Formula.replace("[N]i", "Ni");
//                            Formula = Formula.replace("[N]j", "Nj");
//                            Formula = Formula.replace("[N]k", "Nk");
//                            Formula = Formula.replace("[N]l", "Nl");
//                            Formula = Formula.replace("[N]m", "Nm");
//                            Formula = Formula.replace("[N]n", "Nn");
//                            Formula = Formula.replace("[N]o", "No");
//                            Formula = Formula.replace("[N]p", "Np");
//                            Formula = Formula.replace("[N]q", "Nq");
//                            Formula = Formula.replace("[N]r", "Nr");
//                            Formula = Formula.replace("[N]s", "Ns");
//                            Formula = Formula.replace("[N]t", "Nt");
//                            Formula = Formula.replace("[N]u", "Nu");
//                            Formula = Formula.replace("[N]v", "Nv");
//                            Formula = Formula.replace("[N]w", "Nw");
//                            Formula = Formula.replace("[N]x", "Nx");
//                            Formula = Formula.replace("[N]y", "Ny");
//                            Formula = Formula.replace("[N]z", "Nz");
//                    }
//                    while (Formula.contains("O")){
                            Formula = Formula.replace("O", "[O]");
                            Formula = Formula.replace("[O]a", "Oa");
                            Formula = Formula.replace("[O]b", "Ob");
                            Formula = Formula.replace("[O]c", "Oc");
                            Formula = Formula.replace("[O]d", "Od");
                            Formula = Formula.replace("[O]e", "Oe");
                            Formula = Formula.replace("[O]f", "Of");
                            Formula = Formula.replace("[O]g", "Og");
                            Formula = Formula.replace("[O]h", "Oh");
                            Formula = Formula.replace("[O]i", "Oi");
                            Formula = Formula.replace("[O]j", "Oj");
                            Formula = Formula.replace("[O]k", "Ok");
                            Formula = Formula.replace("[O]l", "Ol");
                            Formula = Formula.replace("[O]m", "Om");
                            Formula = Formula.replace("[O]n", "On");
                            Formula = Formula.replace("[O]o", "Oo");
                            Formula = Formula.replace("[O]p", "Op");
                            Formula = Formula.replace("[O]q", "Oq");
                            Formula = Formula.replace("[O]r", "Or");
                            Formula = Formula.replace("[O]s", "Os");
                            Formula = Formula.replace("[O]t", "Ot");
                            Formula = Formula.replace("[O]u", "Ou");
                            Formula = Formula.replace("[O]v", "Ov");
                            Formula = Formula.replace("[O]w", "Ow");
                            Formula = Formula.replace("[O]x", "Ox");
                            Formula = Formula.replace("[O]y", "Oy");
                            Formula = Formula.replace("[O]z", "Oz");
//                    }
//                    while (Formula.contains("S")){
//                            Formula = Formula.replace("S", "[S]");
//                            Formula = Formula.replace("[S]a", "Sa");
//                            Formula = Formula.replace("[S]b", "Sb");
//                            Formula = Formula.replace("[S]c", "Sc");
//                            Formula = Formula.replace("[S]d", "Sd");
//                            Formula = Formula.replace("[S]e", "Se");
//                            Formula = Formula.replace("[S]f", "Sf");
//                            Formula = Formula.replace("[S]g", "Sg");
//                            Formula = Formula.replace("[S]h", "Sh");
//                            Formula = Formula.replace("[S]i", "Si");
//                            Formula = Formula.replace("[S]j", "Sj");
//                            Formula = Formula.replace("[S]k", "Sk");
//                            Formula = Formula.replace("[S]l", "Sl");
//                            Formula = Formula.replace("[S]m", "Sm");
//                            Formula = Formula.replace("[S]n", "Sn");
//                            Formula = Formula.replace("[S]o", "So");
//                            Formula = Formula.replace("[S]p", "Sp");
//                            Formula = Formula.replace("[S]q", "Sq");
//                            Formula = Formula.replace("[S]r", "Sr");
//                            Formula = Formula.replace("[S]s", "Ss");
//                            Formula = Formula.replace("[S]t", "St");
//                            Formula = Formula.replace("[S]u", "Su");
//                            Formula = Formula.replace("[S]v", "Sv");
//                            Formula = Formula.replace("[S]w", "Sw");
//                            Formula = Formula.replace("[S]x", "Sx");
//                            Formula = Formula.replace("[S]y", "Sy");
//                            Formula = Formula.replace("[S]z", "Sz");
//                    }
//                    while (Formula.contains("F")){
//                            Formula = Formula.replace("F", "[F]");
//                            Formula = Formula.replace("[F]a", "Fa");
//                            Formula = Formula.replace("[F]b", "Fb");
//                            Formula = Formula.replace("[F]c", "Fc");
//                            Formula = Formula.replace("[F]d", "Fd");
//                            Formula = Formula.replace("[F]e", "Fe");
//                            Formula = Formula.replace("[F]f", "Ff");
//                            Formula = Formula.replace("[F]g", "Fg");
//                            Formula = Formula.replace("[F]h", "Fh");
//                            Formula = Formula.replace("[F]i", "Fi");
//                            Formula = Formula.replace("[F]j", "Fj");
//                            Formula = Formula.replace("[F]k", "Fk");
//                            Formula = Formula.replace("[F]l", "Fl");
//                            Formula = Formula.replace("[F]m", "Fm");
//                            Formula = Formula.replace("[F]n", "Fn");
//                            Formula = Formula.replace("[F]o", "Fo");
//                            Formula = Formula.replace("[F]p", "Fp");
//                            Formula = Formula.replace("[F]q", "Fq");
//                            Formula = Formula.replace("[F]r", "Fr");
//                            Formula = Formula.replace("[F]s", "Fs");
//                            Formula = Formula.replace("[F]t", "Ft");
//                            Formula = Formula.replace("[F]u", "Fu");
//                            Formula = Formula.replace("[F]v", "Fv");
//                            Formula = Formula.replace("[F]w", "Fw");
//                            Formula = Formula.replace("[F]x", "Fx");
//                            Formula = Formula.replace("[F]y", "Fy");
//                            Formula = Formula.replace("[F]z", "Fz");
//                    }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                            try {
                                exec("cp "+getFilesDir()+"/openbabel/gas/opt/"+InputfileName+" "+getFilesDir()+"/"+InputfileName+".mop");
                                try {
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
                                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileName);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+"/openbabel/gas/opt/results");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".arc");
                                exec("cp "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/gas/thermo/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/gas/opt/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/gas/opt/results");
                                String Sed3 = exec("sed -n 1p "+getFilesDir()+"/openbabel/gas/opt/"+InputfileName);
                                String Sed4 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/gas/thermo/results/"+InputfileName+".arc");
                                FileOutputStream fileout9 = openFileOutput(InputfileName+".mopg", MODE_PRIVATE);
                                OutputStreamWriter outputWriter9 = new OutputStreamWriter(fileout9);
                                outputWriter9.write(Sed4);
                                outputWriter9.close();
                                exec("rm "+getFilesDir()+"/openbabel/gas/thermo/results/"+InputfileName+".arc");
                                exec("cp "+getFilesDir()+"/"+InputfileName+".mopg "+getFilesDir()+"/openbabel/gas/thermo");
                                String Sed5 = exec("sed -e 1,3d "+getFilesDir()+"/openbabel/gas/thermo/"+InputfileName+".mopg");
                                FileOutputStream fileout10 = openFileOutput(InputfileName+".mop", MODE_PRIVATE);
                                OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                                outputWriter10.write("THERMO(298,298) LET "+Sed3);
                                outputWriter10.write("\n");
                                outputWriter10.write("\n");
                                outputWriter10.write(Sed5);
                                outputWriter10.close();
                                exec("rm "+getFilesDir()+"/openbabel/gas/thermo/"+InputfileName+".mopg");
                                exec("rm "+getFilesDir()+"/"+InputfileName+".mopg");
                                try {
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
                                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileName);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+"/openbabel/gas/thermo/results");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".arc");
                                String Grep1 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileName+".out");
                                FileOutputStream fileout11 = openFileOutput(InputfileName+"_g.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter11 = new OutputStreamWriter(fileout11);
                                outputWriter11.write(Grep1);
                                outputWriter11.close();
                                String Sed7 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileName+"_g.temp");
                                FileOutputStream fileout12 = openFileOutput(DatasetName+"_g.txt",MODE_APPEND);
                                OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                                outputWriter12.write(InputfileName+" ");
                                outputWriter12.write(Formula+" ");
                                outputWriter12.write(Method+" ");
                                outputWriter12.write(Sed7);
                                outputWriter12.close();
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_g.temp");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/gas/thermo/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/gas/thermo/results");

                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                        }


                        File[] files_solv0 = new File(getFilesDir()+"/openbabel/solv/opt").listFiles();
                        for (File file : files_solv0) {
                            if (!file.isFile()) continue;


                            String InputfileName = file.getName();
                            String Formula = exec("cat "+getFilesDir()+"/openbabel/formula/"+InputfileName+".formula");
                            String Method = exec("cat "+getFilesDir()+"/method.txt");

                            Formula = Formula.replace(",", ".");

                            ///////////////// introduce [C], [H], [N], [O], [S], [F] to formula programatically /////////////////////////
                            //                    try {
//                    while (Formula.contains("C")){
//                            Formula = Formula.replace("C", "[C]");
//                            Formula = Formula.replace("[C]a", "Ca");
//                            Formula = Formula.replace("[C]b", "Cb");
//                            Formula = Formula.replace("[C]c", "Cc");
//                            Formula = Formula.replace("[C]d", "Cd");
//                            Formula = Formula.replace("[C]e", "Ce");
//                            Formula = Formula.replace("[C]f", "Cf");
//                            Formula = Formula.replace("[C]g", "Cg");
//                            Formula = Formula.replace("[C]h", "Ch");
//                            Formula = Formula.replace("[C]i", "Ci");
//                            Formula = Formula.replace("[C]j", "Cj");
//                            Formula = Formula.replace("[C]k", "Ck");
//                            Formula = Formula.replace("[C]l", "Cl");
//                            Formula = Formula.replace("[C]m", "Cm");
//                            Formula = Formula.replace("[C]n", "Cn");
//                            Formula = Formula.replace("[C]o", "Co");
//                            Formula = Formula.replace("[C]p", "Cp");
//                            Formula = Formula.replace("[C]q", "Cq");
//                            Formula = Formula.replace("[C]r", "Cr");
//                            Formula = Formula.replace("[C]s", "Cs");
//                            Formula = Formula.replace("[C]t", "Ct");
//                            Formula = Formula.replace("[C]u", "Cu");
//                            Formula = Formula.replace("[C]v", "Cv");
//                            Formula = Formula.replace("[C]w", "Cw");
//                            Formula = Formula.replace("[C]x", "Cx");
//                            Formula = Formula.replace("[C]y", "Cy");
//                            Formula = Formula.replace("[C]z", "Cz");
//                    }
//                    while (Formula.contains("H")){
                            Formula = Formula.replace("H", "[H]");
                            Formula = Formula.replace("[H]a", "Ha");
                            Formula = Formula.replace("[H]b", "Hb");
                            Formula = Formula.replace("[H]c", "Hc");
                            Formula = Formula.replace("[H]d", "Hd");
                            Formula = Formula.replace("[H]e", "He");
                            Formula = Formula.replace("[H]f", "Hf");
                            Formula = Formula.replace("[H]g", "Hg");
                            Formula = Formula.replace("[H]h", "Hh");
                            Formula = Formula.replace("[H]i", "Hi");
                            Formula = Formula.replace("[H]j", "Hj");
                            Formula = Formula.replace("[H]k", "Hk");
                            Formula = Formula.replace("[H]l", "Hl");
                            Formula = Formula.replace("[H]m", "Hm");
                            Formula = Formula.replace("[H]n", "Hn");
                            Formula = Formula.replace("[H]o", "Ho");
                            Formula = Formula.replace("[H]p", "Hp");
                            Formula = Formula.replace("[H]q", "Hq");
                            Formula = Formula.replace("[H]r", "Hr");
                            Formula = Formula.replace("[H]s", "Hs");
                            Formula = Formula.replace("[H]t", "Ht");
                            Formula = Formula.replace("[H]u", "Hu");
                            Formula = Formula.replace("[H]v", "Hv");
                            Formula = Formula.replace("[H]w", "Hw");
                            Formula = Formula.replace("[H]x", "Hx");
                            Formula = Formula.replace("[H]y", "Hy");
                            Formula = Formula.replace("[H]z", "Hz");
//                    }
//                    while (Formula.contains("N")){
//                            Formula = Formula.replace("N", "[N]");
//                            Formula = Formula.replace("[N]a", "Na");
//                            Formula = Formula.replace("[N]b", "Nb");
//                            Formula = Formula.replace("[N]c", "Nc");
//                            Formula = Formula.replace("[N]d", "Nd");
//                            Formula = Formula.replace("[N]e", "Ne");
//                            Formula = Formula.replace("[N]f", "Nf");
//                            Formula = Formula.replace("[N]g", "Ng");
//                            Formula = Formula.replace("[N]h", "Nh");
//                            Formula = Formula.replace("[N]i", "Ni");
//                            Formula = Formula.replace("[N]j", "Nj");
//                            Formula = Formula.replace("[N]k", "Nk");
//                            Formula = Formula.replace("[N]l", "Nl");
//                            Formula = Formula.replace("[N]m", "Nm");
//                            Formula = Formula.replace("[N]n", "Nn");
//                            Formula = Formula.replace("[N]o", "No");
//                            Formula = Formula.replace("[N]p", "Np");
//                            Formula = Formula.replace("[N]q", "Nq");
//                            Formula = Formula.replace("[N]r", "Nr");
//                            Formula = Formula.replace("[N]s", "Ns");
//                            Formula = Formula.replace("[N]t", "Nt");
//                            Formula = Formula.replace("[N]u", "Nu");
//                            Formula = Formula.replace("[N]v", "Nv");
//                            Formula = Formula.replace("[N]w", "Nw");
//                            Formula = Formula.replace("[N]x", "Nx");
//                            Formula = Formula.replace("[N]y", "Ny");
//                            Formula = Formula.replace("[N]z", "Nz");
//                    }
//                    while (Formula.contains("O")){
                            Formula = Formula.replace("O", "[O]");
                            Formula = Formula.replace("[O]a", "Oa");
                            Formula = Formula.replace("[O]b", "Ob");
                            Formula = Formula.replace("[O]c", "Oc");
                            Formula = Formula.replace("[O]d", "Od");
                            Formula = Formula.replace("[O]e", "Oe");
                            Formula = Formula.replace("[O]f", "Of");
                            Formula = Formula.replace("[O]g", "Og");
                            Formula = Formula.replace("[O]h", "Oh");
                            Formula = Formula.replace("[O]i", "Oi");
                            Formula = Formula.replace("[O]j", "Oj");
                            Formula = Formula.replace("[O]k", "Ok");
                            Formula = Formula.replace("[O]l", "Ol");
                            Formula = Formula.replace("[O]m", "Om");
                            Formula = Formula.replace("[O]n", "On");
                            Formula = Formula.replace("[O]o", "Oo");
                            Formula = Formula.replace("[O]p", "Op");
                            Formula = Formula.replace("[O]q", "Oq");
                            Formula = Formula.replace("[O]r", "Or");
                            Formula = Formula.replace("[O]s", "Os");
                            Formula = Formula.replace("[O]t", "Ot");
                            Formula = Formula.replace("[O]u", "Ou");
                            Formula = Formula.replace("[O]v", "Ov");
                            Formula = Formula.replace("[O]w", "Ow");
                            Formula = Formula.replace("[O]x", "Ox");
                            Formula = Formula.replace("[O]y", "Oy");
                            Formula = Formula.replace("[O]z", "Oz");
//                    }
//                    while (Formula.contains("S")){
//                            Formula = Formula.replace("S", "[S]");
//                            Formula = Formula.replace("[S]a", "Sa");
//                            Formula = Formula.replace("[S]b", "Sb");
//                            Formula = Formula.replace("[S]c", "Sc");
//                            Formula = Formula.replace("[S]d", "Sd");
//                            Formula = Formula.replace("[S]e", "Se");
//                            Formula = Formula.replace("[S]f", "Sf");
//                            Formula = Formula.replace("[S]g", "Sg");
//                            Formula = Formula.replace("[S]h", "Sh");
//                            Formula = Formula.replace("[S]i", "Si");
//                            Formula = Formula.replace("[S]j", "Sj");
//                            Formula = Formula.replace("[S]k", "Sk");
//                            Formula = Formula.replace("[S]l", "Sl");
//                            Formula = Formula.replace("[S]m", "Sm");
//                            Formula = Formula.replace("[S]n", "Sn");
//                            Formula = Formula.replace("[S]o", "So");
//                            Formula = Formula.replace("[S]p", "Sp");
//                            Formula = Formula.replace("[S]q", "Sq");
//                            Formula = Formula.replace("[S]r", "Sr");
//                            Formula = Formula.replace("[S]s", "Ss");
//                            Formula = Formula.replace("[S]t", "St");
//                            Formula = Formula.replace("[S]u", "Su");
//                            Formula = Formula.replace("[S]v", "Sv");
//                            Formula = Formula.replace("[S]w", "Sw");
//                            Formula = Formula.replace("[S]x", "Sx");
//                            Formula = Formula.replace("[S]y", "Sy");
//                            Formula = Formula.replace("[S]z", "Sz");
//                    }
//                    while (Formula.contains("F")){
//                            Formula = Formula.replace("F", "[F]");
//                            Formula = Formula.replace("[F]a", "Fa");
//                            Formula = Formula.replace("[F]b", "Fb");
//                            Formula = Formula.replace("[F]c", "Fc");
//                            Formula = Formula.replace("[F]d", "Fd");
//                            Formula = Formula.replace("[F]e", "Fe");
//                            Formula = Formula.replace("[F]f", "Ff");
//                            Formula = Formula.replace("[F]g", "Fg");
//                            Formula = Formula.replace("[F]h", "Fh");
//                            Formula = Formula.replace("[F]i", "Fi");
//                            Formula = Formula.replace("[F]j", "Fj");
//                            Formula = Formula.replace("[F]k", "Fk");
//                            Formula = Formula.replace("[F]l", "Fl");
//                            Formula = Formula.replace("[F]m", "Fm");
//                            Formula = Formula.replace("[F]n", "Fn");
//                            Formula = Formula.replace("[F]o", "Fo");
//                            Formula = Formula.replace("[F]p", "Fp");
//                            Formula = Formula.replace("[F]q", "Fq");
//                            Formula = Formula.replace("[F]r", "Fr");
//                            Formula = Formula.replace("[F]s", "Fs");
//                            Formula = Formula.replace("[F]t", "Ft");
//                            Formula = Formula.replace("[F]u", "Fu");
//                            Formula = Formula.replace("[F]v", "Fv");
//                            Formula = Formula.replace("[F]w", "Fw");
//                            Formula = Formula.replace("[F]x", "Fx");
//                            Formula = Formula.replace("[F]y", "Fy");
//                            Formula = Formula.replace("[F]z", "Fz");
//                    }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                            try {
                                exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileName+" "+getFilesDir()+"/"+InputfileName+".mop");
                                try {
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
                                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileName);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+"/openbabel/solv/opt/results");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".arc");

                                exec("cp "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/solv/thermo/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/solv/opt/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/solv/opt/results");
                                String Sed3 = exec("sed -n 1p "+getFilesDir()+"/openbabel/solv/opt/"+InputfileName);
                                String Sed4 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/solv/thermo/results/"+InputfileName+".arc");
                                FileOutputStream fileout9 = openFileOutput(InputfileName+".mops", MODE_PRIVATE);
                                OutputStreamWriter outputWriter9 = new OutputStreamWriter(fileout9);
                                outputWriter9.write(Sed4);
                                outputWriter9.close();
                                exec("cp "+getFilesDir()+"/"+InputfileName+".mops "+getFilesDir()+"/openbabel/solv/thermo");
                                String Sed5 = exec("sed -e 1,3d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileName+".mops");
                                FileOutputStream fileout10 = openFileOutput(InputfileName+".mop", MODE_PRIVATE);
                                OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                                outputWriter10.write("THERMO(298,298) LET "+Sed3);
                                outputWriter10.write("\n");
                                outputWriter10.write("\n");
                                outputWriter10.write(Sed5);
                                outputWriter10.close();
                                // arc file would collide with later Chemsol calculation
                                exec("rm "+getFilesDir()+"/openbabel/solv/thermo/results/"+InputfileName+".arc");

                                exec("rm "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileName+".mops");
                                exec("rm "+getFilesDir()+"/"+InputfileName+".mops");
                                try {
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
                                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileName);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+"/openbabel/solv/thermo/results");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".arc");
                                String Grep2 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileName+".out");
                                FileOutputStream fileout13 = openFileOutput(InputfileName+"_s1.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                                outputWriter13.write(Grep2);
                                outputWriter13.close();
                                String Sed6 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileName+"_s1.temp");
                                FileOutputStream fileout14 = openFileOutput(DatasetName+"_s1.txt",MODE_APPEND);
                                OutputStreamWriter outputWriter14 = new OutputStreamWriter(fileout14);
                                outputWriter14.write(InputfileName+" ");
                                outputWriter14.write(Formula+" ");
                                outputWriter14.write(Method+" ");
                                outputWriter14.write(Sed6);
                                outputWriter14.close();
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_s1.temp");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/solv/thermo/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/solv/thermo/results");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }


                        File[] files_solv = new File(getFilesDir()+"/openbabel/solv/thermo").listFiles();
                        for (File file : files_solv) {
                            if (!file.isFile()) continue;


                            String InputfileName = file.getName();
                            String Formula = exec("cat "+getFilesDir()+"/openbabel/formula/"+InputfileName+".formula");
                            String Method = exec("cat "+getFilesDir()+"/method.txt");
                            String NumberOfTautomers = exec("cat "+getFilesDir()+"/openbabel/tautomers/"+InputfileName+".taut");
                            String NumberOfAtoms0 = exec("sed -n 1p "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileName);
                            String NumberOfAtoms = NumberOfAtoms0.trim().replaceAll("\\s+", "");

                            Formula = Formula.replace(",", ".");

                            ///////////////// introduce [C], [H], [N], [O], [S], [F] to formula programatically /////////////////////////
                            //                    try {
//                    while (Formula.contains("C")){
//                            Formula = Formula.replace("C", "[C]");
//                            Formula = Formula.replace("[C]a", "Ca");
//                            Formula = Formula.replace("[C]b", "Cb");
//                            Formula = Formula.replace("[C]c", "Cc");
//                            Formula = Formula.replace("[C]d", "Cd");
//                            Formula = Formula.replace("[C]e", "Ce");
//                            Formula = Formula.replace("[C]f", "Cf");
//                            Formula = Formula.replace("[C]g", "Cg");
//                            Formula = Formula.replace("[C]h", "Ch");
//                            Formula = Formula.replace("[C]i", "Ci");
//                            Formula = Formula.replace("[C]j", "Cj");
//                            Formula = Formula.replace("[C]k", "Ck");
//                            Formula = Formula.replace("[C]l", "Cl");
//                            Formula = Formula.replace("[C]m", "Cm");
//                            Formula = Formula.replace("[C]n", "Cn");
//                            Formula = Formula.replace("[C]o", "Co");
//                            Formula = Formula.replace("[C]p", "Cp");
//                            Formula = Formula.replace("[C]q", "Cq");
//                            Formula = Formula.replace("[C]r", "Cr");
//                            Formula = Formula.replace("[C]s", "Cs");
//                            Formula = Formula.replace("[C]t", "Ct");
//                            Formula = Formula.replace("[C]u", "Cu");
//                            Formula = Formula.replace("[C]v", "Cv");
//                            Formula = Formula.replace("[C]w", "Cw");
//                            Formula = Formula.replace("[C]x", "Cx");
//                            Formula = Formula.replace("[C]y", "Cy");
//                            Formula = Formula.replace("[C]z", "Cz");
//                    }
//                    while (Formula.contains("H")){
                            Formula = Formula.replace("H", "[H]");
                            Formula = Formula.replace("[H]a", "Ha");
                            Formula = Formula.replace("[H]b", "Hb");
                            Formula = Formula.replace("[H]c", "Hc");
                            Formula = Formula.replace("[H]d", "Hd");
                            Formula = Formula.replace("[H]e", "He");
                            Formula = Formula.replace("[H]f", "Hf");
                            Formula = Formula.replace("[H]g", "Hg");
                            Formula = Formula.replace("[H]h", "Hh");
                            Formula = Formula.replace("[H]i", "Hi");
                            Formula = Formula.replace("[H]j", "Hj");
                            Formula = Formula.replace("[H]k", "Hk");
                            Formula = Formula.replace("[H]l", "Hl");
                            Formula = Formula.replace("[H]m", "Hm");
                            Formula = Formula.replace("[H]n", "Hn");
                            Formula = Formula.replace("[H]o", "Ho");
                            Formula = Formula.replace("[H]p", "Hp");
                            Formula = Formula.replace("[H]q", "Hq");
                            Formula = Formula.replace("[H]r", "Hr");
                            Formula = Formula.replace("[H]s", "Hs");
                            Formula = Formula.replace("[H]t", "Ht");
                            Formula = Formula.replace("[H]u", "Hu");
                            Formula = Formula.replace("[H]v", "Hv");
                            Formula = Formula.replace("[H]w", "Hw");
                            Formula = Formula.replace("[H]x", "Hx");
                            Formula = Formula.replace("[H]y", "Hy");
                            Formula = Formula.replace("[H]z", "Hz");
//                    }
//                    while (Formula.contains("N")){
//                            Formula = Formula.replace("N", "[N]");
//                            Formula = Formula.replace("[N]a", "Na");
//                            Formula = Formula.replace("[N]b", "Nb");
//                            Formula = Formula.replace("[N]c", "Nc");
//                            Formula = Formula.replace("[N]d", "Nd");
//                            Formula = Formula.replace("[N]e", "Ne");
//                            Formula = Formula.replace("[N]f", "Nf");
//                            Formula = Formula.replace("[N]g", "Ng");
//                            Formula = Formula.replace("[N]h", "Nh");
//                            Formula = Formula.replace("[N]i", "Ni");
//                            Formula = Formula.replace("[N]j", "Nj");
//                            Formula = Formula.replace("[N]k", "Nk");
//                            Formula = Formula.replace("[N]l", "Nl");
//                            Formula = Formula.replace("[N]m", "Nm");
//                            Formula = Formula.replace("[N]n", "Nn");
//                            Formula = Formula.replace("[N]o", "No");
//                            Formula = Formula.replace("[N]p", "Np");
//                            Formula = Formula.replace("[N]q", "Nq");
//                            Formula = Formula.replace("[N]r", "Nr");
//                            Formula = Formula.replace("[N]s", "Ns");
//                            Formula = Formula.replace("[N]t", "Nt");
//                            Formula = Formula.replace("[N]u", "Nu");
//                            Formula = Formula.replace("[N]v", "Nv");
//                            Formula = Formula.replace("[N]w", "Nw");
//                            Formula = Formula.replace("[N]x", "Nx");
//                            Formula = Formula.replace("[N]y", "Ny");
//                            Formula = Formula.replace("[N]z", "Nz");
//                    }
//                    while (Formula.contains("O")){
                            Formula = Formula.replace("O", "[O]");
                            Formula = Formula.replace("[O]a", "Oa");
                            Formula = Formula.replace("[O]b", "Ob");
                            Formula = Formula.replace("[O]c", "Oc");
                            Formula = Formula.replace("[O]d", "Od");
                            Formula = Formula.replace("[O]e", "Oe");
                            Formula = Formula.replace("[O]f", "Of");
                            Formula = Formula.replace("[O]g", "Og");
                            Formula = Formula.replace("[O]h", "Oh");
                            Formula = Formula.replace("[O]i", "Oi");
                            Formula = Formula.replace("[O]j", "Oj");
                            Formula = Formula.replace("[O]k", "Ok");
                            Formula = Formula.replace("[O]l", "Ol");
                            Formula = Formula.replace("[O]m", "Om");
                            Formula = Formula.replace("[O]n", "On");
                            Formula = Formula.replace("[O]o", "Oo");
                            Formula = Formula.replace("[O]p", "Op");
                            Formula = Formula.replace("[O]q", "Oq");
                            Formula = Formula.replace("[O]r", "Or");
                            Formula = Formula.replace("[O]s", "Os");
                            Formula = Formula.replace("[O]t", "Ot");
                            Formula = Formula.replace("[O]u", "Ou");
                            Formula = Formula.replace("[O]v", "Ov");
                            Formula = Formula.replace("[O]w", "Ow");
                            Formula = Formula.replace("[O]x", "Ox");
                            Formula = Formula.replace("[O]y", "Oy");
                            Formula = Formula.replace("[O]z", "Oz");
//                    }
//                    while (Formula.contains("S")){
//                            Formula = Formula.replace("S", "[S]");
//                            Formula = Formula.replace("[S]a", "Sa");
//                            Formula = Formula.replace("[S]b", "Sb");
//                            Formula = Formula.replace("[S]c", "Sc");
//                            Formula = Formula.replace("[S]d", "Sd");
//                            Formula = Formula.replace("[S]e", "Se");
//                            Formula = Formula.replace("[S]f", "Sf");
//                            Formula = Formula.replace("[S]g", "Sg");
//                            Formula = Formula.replace("[S]h", "Sh");
//                            Formula = Formula.replace("[S]i", "Si");
//                            Formula = Formula.replace("[S]j", "Sj");
//                            Formula = Formula.replace("[S]k", "Sk");
//                            Formula = Formula.replace("[S]l", "Sl");
//                            Formula = Formula.replace("[S]m", "Sm");
//                            Formula = Formula.replace("[S]n", "Sn");
//                            Formula = Formula.replace("[S]o", "So");
//                            Formula = Formula.replace("[S]p", "Sp");
//                            Formula = Formula.replace("[S]q", "Sq");
//                            Formula = Formula.replace("[S]r", "Sr");
//                            Formula = Formula.replace("[S]s", "Ss");
//                            Formula = Formula.replace("[S]t", "St");
//                            Formula = Formula.replace("[S]u", "Su");
//                            Formula = Formula.replace("[S]v", "Sv");
//                            Formula = Formula.replace("[S]w", "Sw");
//                            Formula = Formula.replace("[S]x", "Sx");
//                            Formula = Formula.replace("[S]y", "Sy");
//                            Formula = Formula.replace("[S]z", "Sz");
//                    }
//                    while (Formula.contains("F")){
//                            Formula = Formula.replace("F", "[F]");
//                            Formula = Formula.replace("[F]a", "Fa");
//                            Formula = Formula.replace("[F]b", "Fb");
//                            Formula = Formula.replace("[F]c", "Fc");
//                            Formula = Formula.replace("[F]d", "Fd");
//                            Formula = Formula.replace("[F]e", "Fe");
//                            Formula = Formula.replace("[F]f", "Ff");
//                            Formula = Formula.replace("[F]g", "Fg");
//                            Formula = Formula.replace("[F]h", "Fh");
//                            Formula = Formula.replace("[F]i", "Fi");
//                            Formula = Formula.replace("[F]j", "Fj");
//                            Formula = Formula.replace("[F]k", "Fk");
//                            Formula = Formula.replace("[F]l", "Fl");
//                            Formula = Formula.replace("[F]m", "Fm");
//                            Formula = Formula.replace("[F]n", "Fn");
//                            Formula = Formula.replace("[F]o", "Fo");
//                            Formula = Formula.replace("[F]p", "Fp");
//                            Formula = Formula.replace("[F]q", "Fq");
//                            Formula = Formula.replace("[F]r", "Fr");
//                            Formula = Formula.replace("[F]s", "Fs");
//                            Formula = Formula.replace("[F]t", "Ft");
//                            Formula = Formula.replace("[F]u", "Fu");
//                            Formula = Formula.replace("[F]v", "Fv");
//                            Formula = Formula.replace("[F]w", "Fw");
//                            Formula = Formula.replace("[F]x", "Fx");
//                            Formula = Formula.replace("[F]y", "Fy");
//                            Formula = Formula.replace("[F]z", "Fz");
//                    }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                            try {
                                exec("cp "+getFilesDir()+"/openbabel/damping_factor/"+InputfileName+".damp "+getFilesDir()+"/dampfile.txt");

                                // !!!(?) optimized structure is read from the gas phase
//                                exec("cp "+getFilesDir()+"/openbabel/gas/opt/results/"+InputfileName+".arc "+getFilesDir()+"/arcfile0.txt");
                                // or from the solution phase
                                exec("cp "+getFilesDir()+"/openbabel/solv/opt/results/"+InputfileName+".arc "+getFilesDir()+"/arcfile0.txt");

                                String Sed444 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/arcfile0.txt");
                                FileOutputStream fileout944 = openFileOutput("arcfile00.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriter944 = new OutputStreamWriter(fileout944);
                                outputWriter944.write(Sed444);
                                outputWriter944.close();

                                String Sed544 = exec("sed -e 1,3d "+getFilesDir()+"/arcfile00.txt");
                                FileOutputStream fileout1044 = openFileOutput("arcfile000.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriter1044 = new OutputStreamWriter(fileout1044);
                                outputWriter1044.write(Sed544);
                                outputWriter1044.close();

                                String Sed1545 = exec("sed -e $d "+getFilesDir()+"/arcfile000.txt");
                                FileOutputStream fileout1145 = openFileOutput("arcfile1.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriter1145 = new OutputStreamWriter(fileout1145);
                                outputWriter1145.write(Sed1545);
                                outputWriter1145.close();

//                                exec("cp "+getFilesDir()+"/openbabel/gas/opt/results/"+InputfileName+".out "+getFilesDir()+"/mopoutfile0.txt");
                                // !!!(?) charges are read from the aqueous phase
                                exec("cp "+getFilesDir()+"/openbabel/solv/opt/results/"+InputfileName+".out "+getFilesDir()+"/mopoutfile0.txt");

                                String Sed445 = exec("sed -e 1,/CONTRIBUTIONS/d "+getFilesDir()+"/mopoutfile0.txt");
                                FileOutputStream fileout945 = openFileOutput("mopoutfile00.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriter945 = new OutputStreamWriter(fileout945);
                                outputWriter945.write(Sed445);
                                outputWriter945.close();

                                String Sed545 = exec("sed -e 1,2d "+getFilesDir()+"/mopoutfile00.txt");
                                FileOutputStream fileout1045 = openFileOutput("mopoutfile000.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriter1045 = new OutputStreamWriter(fileout1045);
                                outputWriter1045.write(Sed545);
                                outputWriter1045.close();

                                String Sed546 = exec("sed /DIPOLE/,$d "+getFilesDir()+"/mopoutfile000.txt");
                                FileOutputStream fileout1046 = openFileOutput("mopoutfile.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriter1046 = new OutputStreamWriter(fileout1046);
                                outputWriter1046.write(Sed546);
                                outputWriter1046.close();
                                try {
                                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/chemsol-prepare-mulliken.b "+getFilesDir()+"/chemsol-prepare-mulliken.bas");
                                    exec("chmod -R 755 "+getFilesDir()+"/chemsol-prepare-mulliken.b");
                                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/chemsol-prepare-mulliken.b");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                exec("mv "+getFilesDir()+"/chemsolinput.txt "+getFilesDir()+"/chemsolinput0.txt");

                                String Chemsolinput = exec("cat "+getFilesDir()+"/chemsolinput0.txt");
                                FileOutputStream fileout2547 = openFileOutput("chemsolinput.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriter2547 = new OutputStreamWriter(fileout2547);
                                outputWriter2547.write("X1234567890XX");
                                outputWriter2547.write("\n");
                                outputWriter2547.write(NumberOfAtoms+" "+NumberOfTautomers);
                                outputWriter2547.write("\n");
                                outputWriter2547.write("\n");
                                outputWriter2547.write(Chemsolinput);
                                outputWriter2547.write("\n");
                                outputWriter2547.write("\n");
                                outputWriter2547.close();


                                exec("cp "+getFilesDir()+"/vdw.par "+getFilesDir()+"/vdw_name");
                                exec("cp "+getFilesDir()+"/chemsolinput.txt "+getFilesDir()+"/input_file_name");
                                String output_chemsol = exec(getApplicationInfo().nativeLibraryDir+"/libchemsol.so "+getFilesDir()+"/vdw_name "+getFilesDir()+"/input_file_name");
                                FileOutputStream fileout114 = openFileOutput(InputfileName+".log", MODE_PRIVATE);
                                OutputStreamWriter outputWriter114 = new OutputStreamWriter(fileout114);
                                outputWriter114.write(output_chemsol);
                                outputWriter114.close();


                                exec("mv "+getFilesDir()+"/chemsolinput.txt "+getFilesDir()+"/openbabel/solv/thermo/results/"+InputfileName+".inp");

                                // the file in given directory does not exist any more
//                                String Grep2 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileName+".out");
                                String Grep2 = exec("grep -e TOT. "+getFilesDir()+"/openbabel/solv/thermo/results/"+InputfileName+".out");
                                FileOutputStream fileout13 = openFileOutput(InputfileName+"_s1.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                                outputWriter13.write(Grep2);
                                outputWriter13.close();
                                String Sed6 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileName+"_s1.temp");
                                FileOutputStream fileout14 = openFileOutput("thermo_s0.txt",MODE_PRIVATE);
                                OutputStreamWriter outputWriter14 = new OutputStreamWriter(fileout14);
                                outputWriter14.write(InputfileName+" ");
                                outputWriter14.write(Formula+" ");
                                outputWriter14.write(Method+" ");
                                outputWriter14.write(Sed6);
                                outputWriter14.close();

                                String Despaced = exec("cat "+getFilesDir()+"/thermo_s0.txt");
                                while (Despaced.contains("  ")){  //2 spaces
                                    Despaced = Despaced.replace("  ", " "); //(2 spaces, 1 space)
                                }
                                FileOutputStream despac = openFileOutput("thermo_s1.txt",MODE_PRIVATE);
                                OutputStreamWriter outputWriterDesp = new OutputStreamWriter(despac);
                                outputWriterDesp.write(Despaced);
                                outputWriterDesp.close();

                                exec("mv "+getFilesDir()+"/"+InputfileName+".log "+getFilesDir()+"/chemsoloutfile0.txt");

                                String Sed3546 = exec("grep -e X1234567890XX "+getFilesDir()+"/chemsoloutfile0.txt");
                                FileOutputStream fileout3546 = openFileOutput("chemsoloutfile00.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriter3546 = new OutputStreamWriter(fileout3546);
                                outputWriter3546.write(Sed3546);
                                outputWriter3546.close();

                                String Sed3547 = exec("sed -n 2p "+getFilesDir()+"/chemsoloutfile00.txt");
                                FileOutputStream fileout3547 = openFileOutput("chemsoloutfile000.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriter3547 = new OutputStreamWriter(fileout3547);
                                outputWriter3547.write(Sed3547);
                                outputWriter3547.close();

                                exec("mv "+getFilesDir()+"/chemsoloutfile000.txt "+getFilesDir()+"/chemsoloutfile.txt");

                                try {
                                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/chemsol-results.b "+getFilesDir()+"/chemsol-results.bas");
                                    exec("chmod -R 755 "+getFilesDir()+"/chemsol-results.b");
                                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/chemsol-results.b");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                String Sed116 = exec("cat "+getFilesDir()+"/thermo_s2.txt");
                                FileOutputStream fileout116 = openFileOutput(DatasetName+"_s.txt",MODE_APPEND);
                                OutputStreamWriter outputWriter116 = new OutputStreamWriter(fileout116);
                                outputWriter116.write(Sed116);
                                outputWriter116.close();

                                exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/gas/thermo/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/gas/thermo/results");
                                exec("mv "+getFilesDir()+"/chemsoloutfile0.txt "+getFilesDir()+"/openbabel/solv/thermo/results/"+InputfileName+".log");


                                exec("rm "+getFilesDir()+"/vdw_name");
                                exec("rm "+getFilesDir()+"/input_file_name");
                                exec("rm "+getFilesDir()+"/arcfile1.txt");
                                exec("rm "+getFilesDir()+"/arcfile0.txt");
                                exec("rm "+getFilesDir()+"/arcfile00.txt");
                                exec("rm "+getFilesDir()+"/arcfile000.txt");
                                exec("rm "+getFilesDir()+"/mopoutfile.txt");
                                exec("rm "+getFilesDir()+"/mopoutfile0.txt");
                                exec("rm "+getFilesDir()+"/mopoutfile00.txt");
                                exec("rm "+getFilesDir()+"/mopoutfile000.txt");
                                exec("rm "+getFilesDir()+"/chemsoloutfile.txt");
                                exec("rm "+getFilesDir()+"/chemsoloutfile0.txt");
                                exec("rm "+getFilesDir()+"/chemsoloutfile00.txt");
                                exec("rm "+getFilesDir()+"/chemsoloutfile000.txt");
                                exec("rm "+getFilesDir()+"/thermo_s0.txt");
                                exec("rm "+getFilesDir()+"/dampfile.txt");

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }


                        try {

                            String RawOutput_g = exec("cat "+getFilesDir()+"/"+DatasetName+"_g.txt");
                            while (RawOutput_g.contains("  ")){  //2 spaces
                                RawOutput_g = RawOutput_g.replace("  ", " "); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout15 = openFileOutput(DatasetName+"_thermochemistry_g.txt",MODE_PRIVATE);
                            OutputStreamWriter outputWriter15 = new OutputStreamWriter(fileout15);
                            outputWriter15.write(RawOutput_g);
                            outputWriter15.close();

                            String RawOutput_s = exec("cat "+getFilesDir()+"/"+DatasetName+"_s.txt");
                            while (RawOutput_s.contains("  ")){  //2 spaces
                                RawOutput_s = RawOutput_s.replace("  ", " "); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout16 = openFileOutput(DatasetName+"_thermochemistry_s.txt",MODE_PRIVATE);
                            OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                            outputWriter16.write(RawOutput_s);
                            outputWriter16.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        exec("cp "+getFilesDir()+"/"+DatasetName+"_thermochemistry_g.txt "+getFilesDir()+"/PHASES/Thermochemistry_g.txt");
                        exec("cp "+getFilesDir()+"/"+DatasetName+"_thermochemistry_s.txt "+getFilesDir()+"/SOLUTION_SPECIES/Thermochemistry_s.txt");
                        exec("cp "+getFilesDir()+"/"+DatasetName+"_thermochemistry_s.txt "+getFilesDir()+"/PSEUDOPHASES/Thermochemistry_s.txt");

                        try {

                            exec("chmod -R 755 "+getFilesDir());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        exec("mv "+getFilesDir()+"/"+DatasetName+"_g.dat "+getFilesDir()+"/openbabel/gas");
                        exec("mv "+getFilesDir()+"/"+DatasetName+"_s.dat "+getFilesDir()+"/openbabel/solv");

                        exec("mv "+getFilesDir()+"/"+DatasetName+"_thermochemistry_g.txt "+getFilesDir()+"/openbabel/gas");
                        exec("mv "+getFilesDir()+"/"+DatasetName+"_thermochemistry_s.txt "+getFilesDir()+"/openbabel/solv");

//for sure:
                        exec("rm "+getFilesDir()+"/"+DatasetName+"_g.txt");
                        exec("rm "+getFilesDir()+"/"+DatasetName+"_s.txt");
//for case of fall down - the same what already is in MainActivity.java in OnResume:

                        exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhasesMOPAC.b "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhasesMOPAC.bas");
                        exec("chmod -R 755 "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhasesMOPAC.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhasesMOPAC.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_solMOPAC.b "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_solMOPAC.bas");
                        exec("chmod -R 755 "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_solMOPAC.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_solMOPAC.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhaseMOPAC.b "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhaseMOPAC.bas");
                        exec("chmod -R 755 "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhaseMOPAC.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhaseMOPAC.b");

                        try {
                            String Raw_g = exec("cat "+getFilesDir()+"/PHASES/Database_g.dat");
                            while (Raw_g.contains("= + e- =")){  //2 spaces
                                Raw_g = Raw_g.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            while (Raw_g.contains("=  + e- =")){  //2 spaces
                                Raw_g = Raw_g.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout115 = openFileOutput("Database_g1.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter115 = new OutputStreamWriter(fileout115);
                            outputWriter115.write(Raw_g);
                            outputWriter115.close();

                            String Raw_g2 = exec("cat "+getFilesDir()+"/Database_g1.dat");
                            while (Raw_g2.contains("(g) ;  = ")){  //2 spaces
                                Raw_g2 = Raw_g2.replace("(g) ;  = ", ""); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout215 = openFileOutput("Database_g2.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter215 = new OutputStreamWriter(fileout215);
                            outputWriter215.write(Raw_g2);
                            outputWriter215.close();

                            /// new piece of code:
                            String Raw_g3 = exec("cat "+getFilesDir()+"/Database_g2.dat");
                            while (Raw_g3.contains("[H]")){
                                Raw_g3 = Raw_g3.replace("[H]", "H");
                            }
                            FileOutputStream fileout2155 = openFileOutput("Database_g3.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter2155 = new OutputStreamWriter(fileout2155);
                            outputWriter2155.write(Raw_g3);
                            outputWriter2155.close();

                            String Raw_g4 = exec("cat "+getFilesDir()+"/Database_g3.dat");
                            while (Raw_g4.contains("[O]")){
                                Raw_g4 = Raw_g4.replace("[O]", "O");
                            }
                            FileOutputStream fileout2156 = openFileOutput("Database_g4.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter2156 = new OutputStreamWriter(fileout2156);
                            outputWriter2156.write(Raw_g4);
                            outputWriter2156.close();
                            ///

                            String Raw_ss = exec("cat "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
                            while (Raw_ss.contains("= + e- =")){  //2 spaces
                                Raw_ss = Raw_ss.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            while (Raw_ss.contains("=  + e- =")){  //2 spaces
                                Raw_ss = Raw_ss.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout216 = openFileOutput("Database_solid_sol1.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter216 = new OutputStreamWriter(fileout216);
                            outputWriter216.write(Raw_ss);
                            outputWriter216.close();

                            String Raw_ss2 = exec("cat "+getFilesDir()+"/Database_solid_sol1.dat");
                            while (Raw_ss2.contains("(solv) ;  = ")){  //2 spaces
                                Raw_ss2 = Raw_ss2.replace("(solv) ;  = ", ""); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout217 = openFileOutput("Database_solid_sol2.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter217 = new OutputStreamWriter(fileout217);
                            outputWriter217.write(Raw_ss2);
                            outputWriter217.close();

                            /// new piece of code:
                            String Raw_ss03 = exec("cat "+getFilesDir()+"/Database_solid_sol2.dat");
                            while (Raw_ss03.contains("[H]")){
                                Raw_ss03 = Raw_ss03.replace("[H]", "H");
                            }
                            FileOutputStream fileout6155 = openFileOutput("Database_solid_sol3.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter6155 = new OutputStreamWriter(fileout6155);
                            outputWriter6155.write(Raw_ss03);
                            outputWriter6155.close();

                            String Raw_ss04 = exec("cat "+getFilesDir()+"/Database_solid_sol3.dat");
                            while (Raw_ss04.contains("[O]")){
                                Raw_ss04 = Raw_ss04.replace("[O]", "O");
                            }
                            FileOutputStream fileout6156 = openFileOutput("Database_solid_sol4.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter6156 = new OutputStreamWriter(fileout6156);
                            outputWriter6156.write(Raw_ss04);
                            outputWriter6156.close();
                            ///

                            String Raw_s = exec("cat "+getFilesDir()+"/SOLUTION_SPECIES/Database_s.dat");
                            while (Raw_s.contains("= + e- =")){  //2 spaces
                                Raw_s = Raw_s.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            while (Raw_s.contains("=  + e- =")){  //2 spaces
                                Raw_s = Raw_s.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout315 = openFileOutput("Database_s1.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter315 = new OutputStreamWriter(fileout315);
                            outputWriter315.write(Raw_s);
                            outputWriter315.close();

                            String Raw_s2 = exec("cat "+getFilesDir()+"/Database_s1.dat");
                            while (Raw_s2.contains("(g) ;  = ")){  //2 spaces
                                Raw_s2 = Raw_s2.replace("(g) ;  = ", ""); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout415 = openFileOutput("Database_s2.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter415 = new OutputStreamWriter(fileout415);
                            outputWriter415.write(Raw_s2);
                            outputWriter415.close();

                            /// new piece of code:
                            String Raw_s3 = exec("cat "+getFilesDir()+"/Database_s2.dat");
                            while (Raw_s3.contains("[H]")){
                                Raw_s3 = Raw_s3.replace("[H]", "H");
                            }
                            FileOutputStream fileout4155 = openFileOutput("Database_s3.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter4155 = new OutputStreamWriter(fileout4155);
                            outputWriter4155.write(Raw_s3);
                            outputWriter4155.close();

                            String Raw_s4 = exec("cat "+getFilesDir()+"/Database_s3.dat");
                            while (Raw_s4.contains("[O]")){
                                Raw_s4 = Raw_s4.replace("[O]", "O");
                            }
                            FileOutputStream fileout4156 = openFileOutput("Database_s4.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter4156 = new OutputStreamWriter(fileout4156);
                            outputWriter4156.write(Raw_s4);
                            outputWriter4156.close();
                            ///

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            String Fastchem_database_content = exec("cat "+getFilesDir()+"/PHASES/Fastchem_g.dat");

                            Fastchem_database_content = Fastchem_database_content.replace("[H]", "H");
                            Fastchem_database_content = Fastchem_database_content.replace("[O]", "O");
//                            Fastchem_database_content = Fastchem_database_content.replace("[C]", "C");
//                            Fastchem_database_content = Fastchem_database_content.replace("[N]", "N");
//                            Fastchem_database_content = Fastchem_database_content.replace("[S]", "S");
//                            Fastchem_database_content = Fastchem_database_content.replace("[F]", "F");

                            FileOutputStream fileoutFCH = openFileOutput("Fastchem_g.tmp",MODE_PRIVATE);
                            OutputStreamWriter outputWriterFCH = new OutputStreamWriter(fileoutFCH);
                            outputWriterFCH.write(Fastchem_database_content);
                            outputWriterFCH.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("rm "+getFilesDir()+"/PHASES/Fastchem_g.dat");
                        exec("mv "+getFilesDir()+"/Fastchem_g.tmp "+getFilesDir()+"/PHASES/Fastchem_g.dat");

                        try {
                            String Fastchem_database_content2 = exec("cat "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat");

                            Fastchem_database_content2 = Fastchem_database_content2.replace("[H]", "H");
                            Fastchem_database_content2 = Fastchem_database_content2.replace("[O]", "O");
//                            Fastchem_database_content2 = Fastchem_database_content2.replace("[C]", "C");
//                            Fastchem_database_content2 = Fastchem_database_content2.replace("[N]", "N");
//                            Fastchem_database_content2 = Fastchem_database_content2.replace("[S]", "S");
//                            Fastchem_database_content2 = Fastchem_database_content2.replace("[F]", "F");

                            FileOutputStream fileoutFCH2 = openFileOutput("Fastchem_solid_sol.tmp",MODE_PRIVATE);
                            OutputStreamWriter outputWriterFCH2 = new OutputStreamWriter(fileoutFCH2);
                            outputWriterFCH2.write(Fastchem_database_content2);
                            outputWriterFCH2.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("rm "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat");
                        exec("mv "+getFilesDir()+"/Fastchem_solid_sol.tmp "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat");

                        String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                        String DatasetName1 = DatasetName0.replace(" ","_");
                        String DatasetName = DatasetName1.replace(",",".");
                        exec("mv "+getFilesDir()+"/Database_g2.dat "+ getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_g.txt");
                        exec("mv "+getFilesDir()+"/Database_g4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_g.txt");
                        exec("chmod -R 755 "+getFilesDir()+"/PHASES");
                        exec("mv "+getFilesDir()+"/PHASES/Fastchem_g.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+DatasetName+"_g.txt");
                        exec("mv "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+DatasetName+"_solid_sol.txt");
                        exec("mv "+getFilesDir()+"/Database_solid_sol2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_solid_sol.txt");
                        exec("mv "+getFilesDir()+"/Database_solid_sol4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_solid_sol.txt");
                        exec("mv "+getFilesDir()+"/Database_s2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_s.txt");
                        exec("mv "+getFilesDir()+"/Database_s4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_s.txt");
                        exec("rm "+getFilesDir()+"/Database_g.dat");
                        exec("rm "+getFilesDir()+"/Database_g1.dat");
                        exec("rm "+getFilesDir()+"/Database_g3.dat");
                        exec("rm "+getFilesDir()+"/Database_s.dat");
                        exec("rm "+getFilesDir()+"/Database_s1.dat");
                        exec("rm "+getFilesDir()+"/Database_s3.dat");
                        exec("rm "+getFilesDir()+"/Database_solid_sol.dat");
                        exec("rm "+getFilesDir()+"/Database_solid_sol1.dat");
                        exec("rm "+getFilesDir()+"/Database_solid_sol3.dat");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/xyz "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/smiles "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/gas "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/solv "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/iupac "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/formula "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/damping_factor "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/kinetics "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/tautomers "+getFilesDir()+File.separator+"output");
// end of repetition
// inside of ProgressDialog!!!:
                        postActivity();
//                        exec("rm -rf "+getFilesDir()+"/openbabel");
                        onFinish();
                    }
                    public void onFinish(){
                        progressDialog.dismiss();
                    }
                }.start();

            }
        };
    }

    public void postActivity() {

        // TODO Auto-generated method stub //
        try {

//            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.bas");
//            exec("chmod -R 755 "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.bas");
//            exec("chmod -R 755 "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.bas");
//            exec("chmod -R 755 "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
            Intent intent = new Intent(Chemsol1.this, ResumeActivity.class);
            startActivity(intent);
            onResume();
        } catch (Exception e) {
        }
    }



    private View.OnClickListener quit_click; {

        quit_click = new View.OnClickListener() {
            public void onClick(View v) {
//                try {
//                //                     problematic, after that, new calculations do not terminate properly
//                exec("rm -rf "+getFilesDir()+"/openbabel");
//                exec("mkdir "+getFilesDir()+"/openbabel");
//                exec("mkdir "+getFilesDir()+"/openbabel/formula");
//                exec("mkdir "+getFilesDir()+"/openbabel/gas");
//                exec("mkdir "+getFilesDir()+"/openbabel/gas/opt");
//                exec("mkdir "+getFilesDir()+"/openbabel/gas/opt/results");
//                exec("mkdir "+getFilesDir()+"/openbabel/gas/thermo");
//                exec("mkdir "+getFilesDir()+"/openbabel/gas/thermo/results");
//                exec("mkdir "+getFilesDir()+"/openbabel/iupac");
//                exec("mkdir "+getFilesDir()+"/openbabel/smiles");
//                exec("mkdir "+getFilesDir()+"/openbabel/solv");
//                exec("mkdir "+getFilesDir()+"/openbabel/solv/opt");
//                exec("mkdir "+getFilesDir()+"/openbabel/solv/opt/results");
//                exec("mkdir "+getFilesDir()+"/openbabel/solv/thermo");
//                exec("mkdir "+getFilesDir()+"/openbabel/solv/thermo/results");
//                exec("mkdir "+getFilesDir()+"/openbabel/xyz");
//                exec("mkdir "+getFilesDir()+"/openbabel/formula");
//                exec("mkdir "+getFilesDir()+"/openbabel/xtb_comm");
//                exec("mkdir "+getFilesDir()+"/openbabel/xtb_solv");
//                exec("chmod 755 -R "+getFilesDir()+"/openbabel");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

                File[] files_gas = new File(getFilesDir()+"/openbabel/gas/opt").listFiles();
                for (File file : files_gas) {
                    if (!file.isFile()) continue;

                    try{
                        String InputfileName = file.getName();
                        exec("rm "+getFilesDir()+"/openbabel/gas/opt/formula/"+InputfileName+".formula");
                        exec("rm "+getFilesDir()+"/openbabel/gas/opt/smiles/"+InputfileName+".smi");
                        exec("rm "+getFilesDir()+"/openbabel/gas/opt/xyz/"+InputfileName+".xyz");
                        exec("rm "+getFilesDir()+"/openbabel/gas/opt/iupac/"+InputfileName+".iupac");
                        exec("rm "+getFilesDir()+"/openbabel/gas/opt/"+InputfileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                File[] files_solv = new File(getFilesDir()+"/openbabel/solv/opt").listFiles();
                for (File file : files_solv) {
                    if (!file.isFile()) continue;

                    try{
                        String InputfileName = file.getName();
                        exec("rm "+getFilesDir()+"/openbabel/solv/opt/formula/"+InputfileName+".formula");
                        exec("rm "+getFilesDir()+"/openbabel/solv/opt/smiles/"+InputfileName+".smi");
                        exec("rm "+getFilesDir()+"/openbabel/solv/opt/xyz/"+InputfileName+".xyz");
                        exec("rm "+getFilesDir()+"/openbabel/solv/opt/iupac/"+InputfileName+".iupac");
                        exec("rm "+getFilesDir()+"/openbabel/solv/opt/"+InputfileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // TODO Auto-generated method stub //
                openbabel_exit_click();
            }
        };
    }

    private void openbabel_exit_click() {

        Intent intent = new Intent(Chemsol1.this, MainActivity.class);
        startActivity(intent);
    }




}

