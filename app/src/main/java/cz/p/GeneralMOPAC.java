package cz.p;

import static cz.p.Spannables.colorized_numbers;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
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

public class GeneralMOPAC extends KineticsQuery {

    private TextView methodA_label;
    private EditText methodA;
    private TextView keywA_label;
    private EditText keywA;
    private TextView iupacA_label;
    private EditText iupacA;
    private TextView formulaA_label;
    private EditText formulaA;
    private TextView smiA_label;
    private EditText smiA;
    private Button process;
    private Button quit;
    public Button A_opsin;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generalmopac);

        methodA_label = (TextView) findViewById(R.id.methodA_label);
        methodA = (EditText) findViewById(R.id.methodA);
        methodA.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        methodA.addTextChangedListener(new TextWatcher() {
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
                methodA.removeTextChangedListener(this);
                String text = methodA.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                methodA.getText().clear();
                methodA.append(colorized_numbers(text));
                // place the cursor at the original position
                methodA.setSelection(startChanged+countChanged);
                methodA.addTextChangedListener(this);
            }
        });
        keywA_label = (TextView) findViewById(R.id.keywA_label);
        keywA = (EditText) findViewById(R.id.keywA);
        keywA.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        keywA.addTextChangedListener(new TextWatcher() {
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
                keywA.removeTextChangedListener(this);
                String text = keywA.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                keywA.getText().clear();
                keywA.append(colorized_numbers(text));
                // place the cursor at the original position
                keywA.setSelection(startChanged+countChanged);
                keywA.addTextChangedListener(this);
            }
        });
        iupacA_label = (TextView) findViewById(R.id.iupacA_label);
        iupacA = (EditText) findViewById(R.id.iupacA);
        iupacA.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        iupacA.addTextChangedListener(new TextWatcher() {
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
                iupacA.removeTextChangedListener(this);
                String text = iupacA.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                iupacA.getText().clear();
                iupacA.append(colorized_numbers(text));
                // place the cursor at the original position
                iupacA.setSelection(startChanged+countChanged);
                iupacA.addTextChangedListener(this);
            }
        });
        formulaA_label = (TextView) findViewById(R.id.formulaA_label);
        formulaA = (EditText) findViewById(R.id.formulaA);
        formulaA.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        formulaA.addTextChangedListener(new TextWatcher() {
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
                formulaA.removeTextChangedListener(this);
                String text = formulaA.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                formulaA.getText().clear();
                formulaA.append(colorized_numbers(text));
                // place the cursor at the original position
                formulaA.setSelection(startChanged+countChanged);
                formulaA.addTextChangedListener(this);
            }
        });
        smiA_label = (TextView) findViewById(R.id.smiA_label);
        smiA = (EditText) findViewById(R.id.smiA);
        smiA.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        smiA.addTextChangedListener(new TextWatcher() {
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
                smiA.removeTextChangedListener(this);
                String text = smiA.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                smiA.getText().clear();
                smiA.append(colorized_numbers(text));
                // place the cursor at the original position
                smiA.setSelection(startChanged+countChanged);
                smiA.addTextChangedListener(this);
            }
        });
        process = (Button) findViewById(R.id.process);
        process.setOnClickListener(processClick);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(QuitClick);

        A_opsin = (Button) findViewById(R.id.A_opsin);
        A_opsin.setOnClickListener(A_opsin_click);

    }

    public void onStart()
    {
        super.onStart();
        MethodADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_methodA.txt"));
        KeywADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_keywA.txt"));
        IupacADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_iupacA.txt"));
        FormulaADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_formulaA.txt"));
        SmilesADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_smilesA.txt"));
    }

    private View.OnClickListener A_opsin_click; {

        A_opsin_click = new View.OnClickListener() {
            public void onClick(View v) {
                /////////////////////////// SAVE EVERYTHING PRE-SET ////////////////////////////////
                String InputfileA = smiA.getText().toString();
                String InputfileName0A = iupacA.getText().toString();
                String MethodfileA = methodA.getText().toString();
                String KeywordsfileA = keywA.getText().toString();
                String FormulafileA = formulaA.getText().toString();

                try {
                    FileOutputStream fileout = openFileOutput("GeneralMOPAC_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("GeneralMOPAC_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("GeneralMOPAC_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("GeneralMOPAC_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("GeneralMOPAC_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN CONTINUE ////////////////////////////////

                // TODO Auto-generated method stub //
                progressDialog = new ProgressDialog(GeneralMOPAC.this);
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
                            String NameToConvert = iupacA.getText().toString();
                            ////////////////////////////////////
                            NameToStructure nts = NameToStructure.getInstance();
                            NameToStructureConfig ntsconfig = new NameToStructureConfig();
//a new NameToStructureConfig starts as a copy of OPSIN's default configuration
                            ntsconfig.setAllowRadicals(true);
//                OpsinResult result = nts.parseChemicalName("acetamide", ntsconfig);
                            OpsinResult result = nts.parseChemicalName(NameToConvert+"", ntsconfig);
                            String smiles = result.getSmiles();
                            /////////////////////////////////////
                            FileOutputStream fileout3 = openFileOutput("GeneralMOPAC_smilesA.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(smiles);
                            outputWriter3.close();
//                            FileOutputStream fileoutNts = openFileOutput("GeneralMOPAC_iupacA.txt", MODE_PRIVATE);
//                            OutputStreamWriter outputWriterNts = new OutputStreamWriter(fileoutNts);
//                            outputWriterNts.write(NameToConvert);
//                            outputWriterNts.close();
                            MethodADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_methodA.txt"));
                            KeywADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_keywA.txt"));
                            IupacADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_iupacA.txt"));
                            FormulaADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_formulaA.txt"));
                            SmilesADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_smilesA.txt"));

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

    private View.OnClickListener processClick; {

        processClick = new View.OnClickListener() {
            public void onClick(View v) {

                String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
                progressDialog = new ProgressDialog(GeneralMOPAC.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Performing MOPAC calculations on species contained in dataset: "+DatasetName0);
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
                /////////////////////////////////// A ///////////////////////////////////////////////
                String InputfileA = smiA.getText().toString();
                String InputfileName0A = iupacA.getText().toString();
                String MethodfileA = methodA.getText().toString();
                String KeywordsfileA = keywA.getText().toString();
                String FormulafileA = formulaA.getText().toString();
                File filePath = new File(getFilesDir()+File.separator+"openbabel");
                try {
                    if (!filePath.exists()) {
                        filePath.mkdirs();
                    }
                    FileOutputStream fileout = openFileOutput("GeneralMOPAC_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("GeneralMOPAC_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("GeneralMOPAC_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("GeneralMOPAC_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("GeneralMOPAC_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    String InputfileNameA1 = InputfileName0A.replace(" ","_");
		    String InputfileNameA = InputfileNameA1.replace(",",".");
                    exec("cp "+getFilesDir()+"/GeneralMOPAC_smilesA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".smi");
                    exec("cp "+getFilesDir()+"/GeneralMOPAC_iupacA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".iupac");
                    exec("cp "+getFilesDir()+"/GeneralMOPAC_formulaA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".formula");
                    exec("chmod 755 -R "+getFilesDir());
                    // String ObabelOutputA = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+File.separator+"openbabel"+File.separator+InputfileNameA+".smi -oxyz --gen3d");
		    com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi ./openbabel/"+InputfileNameA+".smi -oxyz --gen3d > ObabelOutputA.txt");
		    String ObabelOutputA = exec("cat "+getFilesDir()+"/ObabelOutputA.txt");
			    
                    FileOutputStream fileout4 = openFileOutput(InputfileNameA+".xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(ObabelOutputA);
                    outputWriter4.close();
                    String KeyA = MethodfileA+" "+KeywordsfileA;

                    File filePath2 = new File(getFilesDir()+File.separator+"openbabel/solv/opt");
                    File filePath2a = new File(getFilesDir()+File.separator+"openbabel/solv/opt/results");
                    File filePath2b = new File(getFilesDir()+File.separator+"openbabel/solv/thermo");
                    File filePath2c = new File(getFilesDir()+File.separator+"openbabel/solv/thermo/results");
                    try {
                        if (!filePath2.exists()) {
                            filePath2.mkdirs();}
                        if (!filePath2a.exists()) {
                            filePath2a.mkdirs();
                        }
                        if (!filePath2b.exists()) {
                            filePath2b.mkdirs();
                        }
                        if (!filePath2c.exists()) {
                            filePath2c.mkdirs();
                        }


                        String Sed2 = exec("sed -e 1,2d "+getFilesDir()+"/"+InputfileNameA+".xyz");
                        FileOutputStream fileout8 = openFileOutput(InputfileNameA+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                        outputWriter8.write(KeyA);
                        outputWriter8.write("\n");
                        outputWriter8.write("\n");
                        outputWriter8.write("\n");
                        outputWriter8.write(Sed2);
                        outputWriter8.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/"+InputfileNameA+".mop "+getFilesDir()+File.separator+"openbabel/solv/opt/"+InputfileNameA);

                    File filePath3 = new File(getFilesDir()+File.separator+"openbabel/smiles");
                    try {
                        if (!filePath3.exists()) {
                            filePath3.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameA+".smi "+getFilesDir()+File.separator+"openbabel/smiles");

                    File filePath4 = new File(getFilesDir()+File.separator+"openbabel/xyz");
                    try {
                        if (!filePath4.exists()) {
                            filePath4.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/"+InputfileNameA+".xyz "+getFilesDir()+File.separator+"openbabel/xyz");

                    File filePath5 = new File(getFilesDir()+File.separator+"openbabel/iupac");
                    try {
                        if (!filePath5.exists()) {
                            filePath5.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameA+".iupac "+getFilesDir()+File.separator+"openbabel/iupac");

                    File filePath7 = new File(getFilesDir()+File.separator+"openbabel/formula");
                    try {
                        if (!filePath7.exists()) {
                            filePath7.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameA+".formula "+getFilesDir()+File.separator+"openbabel/formula");


                    /////////////////////////////////// Calculate A ///////////////////////////////////////////////

                    try {
                        exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameA+" "+getFilesDir()+"/"+InputfileNameA+".mop");
                        try {
                            // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameA);
			    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileNameA);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileNameA+".mop "+getFilesDir()+"/openbabel/solv/opt/results/");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameA+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameA+".arc");
                        exec("cp "+getFilesDir()+"/"+InputfileNameA+".arc "+getFilesDir()+"/openbabel/solv/thermo");
                        exec("mv "+getFilesDir()+"/"+InputfileNameA+".out "+getFilesDir()+"/openbabel/solv/opt/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameA+".arc "+getFilesDir()+"/openbabel/solv/opt/results/");
                        String Sed10003 = exec("sed -n 1p "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameA);
                        String Sed10004 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameA+".arc");
                        FileOutputStream fileout10009 = openFileOutput(InputfileNameA+".mops", MODE_PRIVATE);
                        OutputStreamWriter outputWriter10009 = new OutputStreamWriter(fileout10009);
                        outputWriter10009.write(Sed10004);
                        outputWriter10009.close();
                        exec("cp "+getFilesDir()+"/"+InputfileNameA+".mops "+getFilesDir()+"/openbabel/solv/thermo");
                        String Sed10005 = exec("sed -e 1,3d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameA+".mops");
                        FileOutputStream fileout10010 = openFileOutput(InputfileNameA+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter10010 = new OutputStreamWriter(fileout10010);
                        outputWriter10010.write("THERMO(298,298) LET "+Sed10003);
                        outputWriter10010.write("\n");
                        outputWriter10010.write("\n");
                        outputWriter10010.write(Sed10005);
                        outputWriter10010.close();
                        exec("rm "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameA+".mops");
                        exec("rm "+getFilesDir()+"/"+InputfileNameA+".mops");
                        try {
                            // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameA);
			    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileNameA);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileNameA+".mop "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameA+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameA+".arc");

                        String Grep10002 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileNameA+".out");
                        FileOutputStream fileout10013 = openFileOutput(InputfileNameA+"_s.temp",MODE_PRIVATE);
                        OutputStreamWriter outputWriter10013 = new OutputStreamWriter(fileout10013);
                        outputWriter10013.write(Grep10002);
                        outputWriter10013.close();
                        String Sed10006 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileNameA+"_s.temp");
                        String FormulaA = formulaA.getText().toString();
                        String MethodA = methodA.getText().toString();
                        FileOutputStream fileout10014 = openFileOutput(InputfileNameA+"_s.txt",MODE_APPEND);
                        OutputStreamWriter outputWriter10014 = new OutputStreamWriter(fileout10014);
                        outputWriter10014.write(InputfileNameA+" ");
                        outputWriter10014.write(FormulaA+" ");
                        outputWriter10014.write(MethodA+" ");
                        outputWriter10014.write(Sed10006);
                        outputWriter10014.close();
                        exec("rm "+getFilesDir()+"/"+InputfileNameA+"_s.temp");

                        String RawOutput_s = exec("cat "+getFilesDir()+"/"+InputfileNameA+"_s.txt");
                        while (RawOutput_s.contains("  ")){  //2 spaces
                            RawOutput_s = RawOutput_s.replace("  ", " "); //(2 spaces, 1 space)
                        }
                        FileOutputStream fileout10016 = openFileOutput("thermo_s_General.txt",MODE_PRIVATE);
                        OutputStreamWriter outputWriter10016 = new OutputStreamWriter(fileout10016);
                        outputWriter10016.write(RawOutput_s);
                        outputWriter10016.close();

                        exec("mv "+getFilesDir()+"/"+InputfileNameA+".out "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameA+".arc "+getFilesDir()+"/openbabel/solv/thermo/results/");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    /////////////////////////////////// Process results ///////////////////////////////////////////////
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GeneralMOPAC.b "+getFilesDir()+"/GeneralMOPAC.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/GeneralMOPAC.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GeneralMOPAC.b");

                    /////////////////////////////////// Display fields ///////////////////////////////////////////////

                    MethodADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_methodA.txt"));
                    KeywADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_keywA.txt"));
                    IupacADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_iupacA.txt"));
                    FormulaADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_formulaA.txt"));
                    SmilesADisplay(exec("cat "+getFilesDir()+"/GeneralMOPAC_smilesA.txt"));


                } catch (Exception e) {
                }

//here:
                        Intent intent = new Intent(GeneralMOPAC.this, KineticsQuery.class);
                        startActivity(intent);
                        onFinish();
                    }
                    public void onFinish(){
                        progressDialog.dismiss();
                    }
                }.start();
//and not here:
//                Intent intent = new Intent(GeneralMOPAC.this, KineticsQuery.class);
//                startActivity(intent);

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
                Intent intent = new Intent(GeneralMOPAC.this, MainActivity.class);
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


    private void MethodADisplay(final String strMA) {
        Runnable procMA = new Runnable() {
            public void run() {
                methodA.setText(colorized_numbers(strMA), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procMA);
    }
    private void KeywADisplay(final String strKA) {
        Runnable procKA = new Runnable() {
            public void run() {
                keywA.setText(colorized_numbers(strKA), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procKA);
    }
    private void IupacADisplay(final String strIA) {
        Runnable procIA = new Runnable() {
            public void run() {
                iupacA.setText(colorized_numbers(strIA), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procIA);
    }
    private void FormulaADisplay(final String strFA) {
        Runnable procFA = new Runnable() {
            public void run() {
                formulaA.setText(colorized_numbers(strFA), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procFA);
    }
    private void SmilesADisplay(final String strSA) {
        Runnable procSA = new Runnable() {
            public void run() {
                smiA.setText(colorized_numbers(strSA), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procSA);
    }

}
