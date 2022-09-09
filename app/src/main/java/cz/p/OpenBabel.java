package cz.p;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OpenBabel extends MainActivity {

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
    public Button openbabel_continue;
    public Button openbabel_exit;
    public Button quit;
    public TextView mopac_label;
    public TextView mopac_input;
    public TextView mopac_filelist_label;
    public TextView mopac_filelist;
    public Button databasemakers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.openbabel);

        method_label = (TextView) findViewById(R.id.method_label);
        method = (EditText) findViewById(R.id.method);
        solvation_label = (TextView) findViewById(R.id.solvation_label);
        solvation = (EditText) findViewById(R.id.solvation);
        keywords_label = (TextView) findViewById(R.id.keywords_label);
        keywords = (EditText) findViewById(R.id.keywords);
        iupac_label = (TextView) findViewById(R.id.iupac_label);
        iupac = (EditText) findViewById(R.id.iupac);
        formula_label = (TextView) findViewById(R.id.formula_label);
        formula = (EditText) findViewById(R.id.formula);
        smiles_label = (TextView) findViewById(R.id.smiles_label);
        smiles = (EditText) findViewById(R.id.smiles);
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

    }

    public void onStart()
    {
        super.onStart();
        method_view(exec("cat "+getFilesDir()+"/method.txt"));
        solvation_view(exec("cat "+getFilesDir()+"/solvation.txt"));
        keywords_view(exec("cat "+getFilesDir()+"/keywords.txt"));
        iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
        formula_view(exec("cat "+getFilesDir()+"/formula.txt"));
        smiles_view(exec("cat "+getFilesDir()+"/smiles.txt"));
        mopac_filelist_view(exec("ls -l "+getFilesDir()+"/openbabel/xyz"));
    }

    private View.OnClickListener openbabel_continue_click; {

        openbabel_continue_click = new View.OnClickListener() {
            public void onClick(View v) {
                String Inputfile = smiles.getText().toString();
                String InputfileName0 = iupac.getText().toString();
                String Methodfile = method.getText().toString();
                String Solvationfile = solvation.getText().toString();
                String Keywordsfile = keywords.getText().toString();
                String Formulafile = formula.getText().toString();
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
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                try {

                    String InputfileName = InputfileName0.replace(" ","_");
                exec("cp "+getFilesDir()+"/smiles.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".smi");
                exec("cp "+getFilesDir()+"/iupac.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".iupac");
                exec("cp "+getFilesDir()+"/formula.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".formula");
                exec("chmod 755 -R "+getFilesDir());
                String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+File.separator+"openbabel"+File.separator+InputfileName+".smi -oxyz --gen3d");
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

                    File filePath2 = new File(getFilesDir()+File.separator+"openbabel/solv/opt");
                    try {
                        if (!filePath2.exists()) {
                            filePath2.mkdirs();
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

                method_view(exec("cat "+getFilesDir()+"/method.txt"));
                solvation_view(exec("cat "+getFilesDir()+"/solvation.txt"));
                keywords_view(exec("cat "+getFilesDir()+"/keywords.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/formula.txt"));
                smiles_view(exec("cat "+getFilesDir()+"/smiles.txt"));
                mopac_view(exec("cat "+getFilesDir()+File.separator+"openbabel/gas/opt/"+InputfileName));
                mopac_filelist_view(exec("ls -l "+getFilesDir()+"/openbabel/xyz"));

                } catch (Exception e) {
                }
            }
        };
    }

    public void method_view(final String method_str) {
        Runnable method_proc = new Runnable() {
            public void run() {
                method.setText(method_str);
            }
        };
        handler.post(method_proc);
    }

    public void solvation_view(final String solvation_str) {
        Runnable solvation_proc = new Runnable() {
            public void run() {
                solvation.setText(solvation_str);
            }
        };
        handler.post(solvation_proc);
    }

    public void keywords_view(final String keywords_str) {
        Runnable keywords_proc = new Runnable() {
            public void run() {
                keywords.setText(keywords_str);
            }
        };
        handler.post(keywords_proc);
    }

    public void iupac_view(final String iupac_str) {
        Runnable iupac_proc = new Runnable() {
            public void run() {
                iupac.setText(iupac_str);
            }
        };
        handler.post(iupac_proc);
    }

    public void formula_view(final String formula_str) {
        Runnable formula_proc = new Runnable() {
            public void run() {
                formula.setText(formula_str);
            }
        };
        handler.post(formula_proc);
    }

    public void smiles_view(final String smiles_str) {
        Runnable smiles_proc = new Runnable() {
            public void run() {
                smiles.setText(smiles_str);
            }
        };
        handler.post(smiles_proc);
    }

    public void mopac_view(final String mopac_str) {
        Runnable mopac_proc = new Runnable() {
            public void run() {
                mopac_input.setText(mopac_str);
            }
        };
        handler.post(mopac_proc);
    }

    public void mopac_filelist_view(final String mopac_filelist_str) {
        Runnable mopac_filelist_proc = new Runnable() {
            public void run() {
                mopac_filelist.setText(mopac_filelist_str);
            }
        };
        handler.post(mopac_filelist_proc);
    }

    // Executes UNIX command.
    private String exec(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
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

                String DatasetName = exec("cat "+getFilesDir()+"/dataset-name.txt");

                progressDialog = new ProgressDialog(OpenBabel.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Performing MOPAC calculations on species contained in dataset: "+DatasetName);
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

                    try {
                        exec("cp "+getFilesDir()+"/openbabel/gas/opt/"+InputfileName+" "+getFilesDir()+"/"+InputfileName+".mop");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+"/openbabel/gas/opt/results");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".arc");
                        exec("cp "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/gas/thermo");
                        exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/gas/opt/results");
                        exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/gas/opt/results");
                        String Sed3 = exec("sed -n 1p "+getFilesDir()+"/openbabel/gas/opt/"+InputfileName);
                        String Sed4 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/gas/thermo/"+InputfileName+".arc");
                        FileOutputStream fileout9 = openFileOutput(InputfileName+".mopg", MODE_PRIVATE);
                        OutputStreamWriter outputWriter9 = new OutputStreamWriter(fileout9);
                        outputWriter9.write(Sed4);
                        outputWriter9.close();
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
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
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

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }






















                File[] files_solv = new File(getFilesDir()+"/openbabel/solv/opt").listFiles();
                for (File file : files_solv) {
                    if (!file.isFile()) continue;


                    String InputfileName = file.getName();
                    String Formula = exec("cat "+getFilesDir()+"/openbabel/formula/"+InputfileName+".formula");
                    String Method = exec("cat "+getFilesDir()+"/method.txt");

                    try {
                        exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileName+" "+getFilesDir()+"/"+InputfileName+".mop");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+"/openbabel/solv/opt/results");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".arc");
                        exec("cp "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/solv/thermo");
                        exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/solv/opt/results");
                        exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/solv/opt/results");
                        String Sed3 = exec("sed -n 1p "+getFilesDir()+"/openbabel/solv/opt/"+InputfileName);
                        String Sed4 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileName+".arc");
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
                        exec("rm "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileName+".mops");
                        exec("rm "+getFilesDir()+"/"+InputfileName+".mops");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+"/openbabel/solv/thermo/results");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".arc");
                        String Grep2 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileName+".out");
                        FileOutputStream fileout13 = openFileOutput(InputfileName+"_s.temp",MODE_PRIVATE);
                        OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                        outputWriter13.write(Grep2);
                        outputWriter13.close();
                        String Sed6 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileName+"_s.temp");
                        FileOutputStream fileout14 = openFileOutput(DatasetName+"_s.txt",MODE_APPEND);
                        OutputStreamWriter outputWriter14 = new OutputStreamWriter(fileout14);
                        outputWriter14.write(InputfileName+" ");
                        outputWriter14.write(Formula+" ");
                        outputWriter14.write(Method+" ");
                        outputWriter14.write(Sed6);
                        outputWriter14.close();
                        exec("rm "+getFilesDir()+"/"+InputfileName+"_s.temp");
                        exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/solv/thermo/results");
                        exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/solv/thermo/results");
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
//for case of fall down - the same as in MainActivity.java in OnResume:
                        try {
                            String Raw_g = exec("cat "+getFilesDir()+"/PHASES/Database_g.dat");
                            while (Raw_g.contains("= + e- =")){  //2 spaces
                                Raw_g = Raw_g.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
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

                            String Raw_s = exec("cat "+getFilesDir()+"/SOLUTION_SPECIES/Database_s.dat");
                            while (Raw_s.contains("= + e- =")){  //2 spaces
                                Raw_s = Raw_s.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
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

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        String DatasetName = exec("cat "+getFilesDir()+"/dataset-name.txt");
                        exec("mv "+getFilesDir()+"/Database_g2.dat "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_g.txt");
                        exec("mv "+getFilesDir()+"/Database_s2.dat "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_s.txt");

                        exec("mv "+getFilesDir()+File.separator+"openbabel/xyz "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
                        exec("mv "+getFilesDir()+File.separator+"openbabel/smiles "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
                        exec("mv "+getFilesDir()+File.separator+"openbabel/gas "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
                        exec("mv "+getFilesDir()+File.separator+"openbabel/solv "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
                        exec("mv "+getFilesDir()+File.separator+"openbabel/iupac "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
                        exec("mv "+getFilesDir()+File.separator+"openbabel/formula "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
                        exec("mv "+getFilesDir()+File.separator+"openbabel/damping_factor "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
                        exec("mv "+getFilesDir()+File.separator+"openbabel/kinetics "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
                        exec("mv "+getFilesDir()+File.separator+"openbabel/tautomers "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
// end of repetiton



// this must be inside of ProgressDialog, otherwise the produced database will not be copied outside and the calculation ends unexpectedly
                        postActivity();



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

            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.bas");
            exec("chmod -R 755 "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b");
            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b");
            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.bas");
            exec("chmod -R 755 "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
            Intent intent = new Intent(OpenBabel.this, MainActivity.class);
            startActivity(intent);
            onResume();
        } catch (Exception e) {
        }
    }



    private View.OnClickListener quit_click; {

        quit_click = new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    exec("rm -rf "+getFilesDir()+File.separator+"openbabel");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                openbabel_exit_click();
            }
        };
    }

    private void openbabel_exit_click() {

        Intent intent = new Intent(OpenBabel.this, MainActivity.class);
        startActivity(intent);
    }




}

