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

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

public class Dftb1 extends MainActivity {

    private Handler handler = new Handler();
    //    public TextView cp2k;
    public TextView dftb_ref_label;
    public TextView dftb_begin_label;
    public EditText dftb_begin;
    public TextView dftb_solvation_label;
    public EditText dftb_solvation;
    public TextView dftb_end_label;
    public EditText dftb_end;
    public TextView iupac_label;
    public EditText iupac;
    public TextView formula_label;
    public EditText formula;
    public TextView smiles_label;
    public EditText smiles;
    public Button dftb_opsin;
    public Button dftb_continue;
    public Button dftb_exit;
    public Button quit;
    public TextView dftb_label;
    public TextView dftb_input;
    public TextView dftb_filelist_label;
    public TextView dftb_filelist;
    public Button reference;
//    public EditText reference_level;
    public TextView referenceView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dftb1);
//        cp2k = (TextView) findViewById(R.id.cp2k);
        dftb_ref_label = (TextView) findViewById(R.id.dftb_ref_label);
        dftb_begin_label = (TextView) findViewById(R.id.dftb_begin_label);
        dftb_begin = (EditText) findViewById(R.id.dftb_begin);
        dftb_solvation_label = (TextView) findViewById(R.id.dftb_solvation_label);
        dftb_solvation = (EditText) findViewById(R.id.dftb_solvation);
        dftb_end_label = (TextView) findViewById(R.id.dftb_end_label);
        dftb_end = (EditText) findViewById(R.id.dftb_end);
        iupac_label = (TextView) findViewById(R.id.iupac_label);
        iupac = (EditText) findViewById(R.id.iupac);
        formula_label = (TextView) findViewById(R.id.formula_label);
        formula = (EditText) findViewById(R.id.formula);
        smiles_label = (TextView) findViewById(R.id.smiles_label);
        smiles = (EditText) findViewById(R.id.smiles);
        dftb_opsin = (Button) findViewById(R.id.dftb_opsin);
        dftb_opsin.setOnClickListener(dftb_opsin_click);
        dftb_continue = (Button) findViewById(R.id.dftb_continue);
        dftb_continue.setOnClickListener(dftb_continue_click);
        dftb_exit = (Button) findViewById(R.id.dftb_exit);
        dftb_exit.setOnClickListener(dftb_exit_click);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(quit_click);
        dftb_label = (TextView) findViewById(R.id.dftb_label);
        dftb_input = (TextView) findViewById(R.id.dftb_input);
        dftb_filelist_label = (TextView) findViewById(R.id.dftb_filelist_label);
        dftb_filelist = (TextView) findViewById(R.id.dftb_filelist);
//        reference_level = (EditText) findViewById(R.id.reference_level);
        referenceView = (TextView) findViewById(R.id.referenceView);

        reference = (Button) findViewById(R.id.reference);
        reference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File filePath = new File(getFilesDir()+File.separator+"openbabel");
                String Inputfile = smiles.getText().toString();
                String InputfileName0 = iupac.getText().toString();
                String Begin = dftb_begin.getText().toString();
                String Solv = dftb_solvation.getText().toString();
                String End = dftb_end.getText().toString();
                String Formulafile = formula.getText().toString();
                String ReferenceLevel = exec("cat "+getFilesDir()+"/ref-level.txt");
                try {
                    if (!filePath.exists()) {
                        filePath.mkdirs();
                    }
                    FileOutputStream fileout = openFileOutput("smiles.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout20 = openFileOutput("dftb-begin.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(Begin);
                    outputWriter20.close();
                    FileOutputStream fileout21 = openFileOutput("dftb-solv.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter21 = new OutputStreamWriter(fileout21);
                    outputWriter21.write(Solv);
                    outputWriter21.close();
                    FileOutputStream fileout22 = openFileOutput("dftb-end.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(End);
                    outputWriter22.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("formula.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(Formulafile);
                    outputWriter8.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Dftb1.this, Dftb1SelectRef.class);
                startActivity(intent);

            }
        });
    }

    public void onStart()
    {
        super.onStart();
        String Refg = exec("cat "+getFilesDir()+"/ref-level-g.txt");
        String Refs = exec("cat "+getFilesDir()+"/ref-level-s.txt");
        String Refss = exec("cat "+getFilesDir()+"/ref-level-ss.txt");
        try {
            FileOutputStream fileoutX = openFileOutput("ref-level.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriterX = new OutputStreamWriter(fileoutX);
            outputWriterX.write(Refg+"\n");
            outputWriterX.write(Refs+"\n");
            outputWriterX.write(Refss+"\n");
            outputWriterX.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        view_begin(exec("cat "+getFilesDir()+"/dftb-begin.txt"));
        view_solv(exec("cat "+getFilesDir()+"/dftb-solv.txt"));
        view_end(exec("cat "+getFilesDir()+"/dftb-end.txt"));
        iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
        formula_view(exec("cat "+getFilesDir()+"/formula.txt"));
        smiles_view(exec("cat "+getFilesDir()+"/smiles.txt"));
        reference_view(exec("cat "+getFilesDir()+"/ref-level.txt"));
    }

    private View.OnClickListener dftb_opsin_click; {

        dftb_opsin_click = new View.OnClickListener() {
            public void onClick(View v) {
                String Inputfile = smiles.getText().toString();
                String InputfileName0 = iupac.getText().toString();
                String Begin = dftb_begin.getText().toString();
                String Solv = dftb_solvation.getText().toString();
                String End = dftb_end.getText().toString();
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
                    FileOutputStream fileout20 = openFileOutput("dftb-begin.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(Begin);
                    outputWriter20.close();
                    FileOutputStream fileout21 = openFileOutput("dftb-solv.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter21 = new OutputStreamWriter(fileout21);
                    outputWriter21.write(Solv);
                    outputWriter21.close();
                    FileOutputStream fileout22 = openFileOutput("dftb-end.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(End);
                    outputWriter22.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("formula.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(Formulafile);
                    outputWriter8.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                progressDialog = new ProgressDialog(Dftb1.this);
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
                            view_begin(exec("cat "+getFilesDir()+"/dftb-begin.txt"));
                            view_solv(exec("cat "+getFilesDir()+"/dftb-solv.txt"));
                            view_end(exec("cat "+getFilesDir()+"/dftb-end.txt"));
                            iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                            formula_view(exec("cat "+getFilesDir()+"/formula.txt"));
                            smiles_view(exec("cat "+getFilesDir()+"/smiles.txt"));
                            reference_view(exec("cat "+getFilesDir()+"/ref-level.txt"));
                            dftb_view(exec("cat "+getFilesDir()+File.separator+"openbabel/gas/opt/"+InputfileName));
                            dftb_filelist_view(exec("ls -l "+getFilesDir()+"/openbabel/xyz"));

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

    private View.OnClickListener dftb_continue_click; {

        dftb_continue_click = new View.OnClickListener() {
            public void onClick(View v) {
                String Inputfile = smiles.getText().toString();
                String InputfileName0 = iupac.getText().toString();
                String Begin = dftb_begin.getText().toString();
                String Solv = dftb_solvation.getText().toString();
                String End = dftb_end.getText().toString();
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
                    FileOutputStream fileout20 = openFileOutput("dftb-begin.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(Begin);
                    outputWriter20.close();
                    FileOutputStream fileout21 = openFileOutput("dftb-solv.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter21 = new OutputStreamWriter(fileout21);
                    outputWriter21.write(Solv);
                    outputWriter21.close();
                    FileOutputStream fileout22 = openFileOutput("dftb-end.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(End);
                    outputWriter22.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("formula.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(Formulafile);
                    outputWriter8.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                try {

                    String InputfileName1 = InputfileName0.replace(" ","_");
                    String InputfileName = InputfileName1.replace(",",".");
                    exec("cp "+getFilesDir()+"/smiles.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".smi");
                    exec("cp "+getFilesDir()+"/iupac.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".iupac");
                    exec("cp "+getFilesDir()+"/formula.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileName+".formula");
                    exec("chmod 755 -R "+getFilesDir());
                    String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+File.separator+"openbabel"+File.separator+InputfileName+".smi -oxyz --gen3d");
                    FileOutputStream fileout4 = openFileOutput(InputfileName+".xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(ObabelOutput);
                    outputWriter4.close();
                    File filePath1 = new File(getFilesDir()+File.separator+"openbabel/gas/opt");
                    try {
                        if (!filePath1.exists()) {
                            filePath1.mkdirs();
                        }
                        String Xyz1 = exec("cat "+getFilesDir()+"/"+InputfileName+".xyz");
                        FileOutputStream fileout7 = openFileOutput(InputfileName+".inp", MODE_PRIVATE);
                        OutputStreamWriter outputWriter7 = new OutputStreamWriter(fileout7);
                        outputWriter7.write("Geometry = XyzFormat {\n");
                        outputWriter7.write(Xyz1);
                        outputWriter7.write("\n");
                        outputWriter7.write("}");
                        outputWriter7.write("\n");
                        outputWriter7.write(Begin);
                        outputWriter7.write("\n");
                        outputWriter7.write(End);
//                        outputWriter7.write("\n");
                        outputWriter7.write("\n");
                        outputWriter7.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/"+InputfileName+".inp "+getFilesDir()+File.separator+"openbabel/gas/opt/"+InputfileName);

                    File filePath2 = new File(getFilesDir()+File.separator+"openbabel/solv/opt");
                    try {
                        if (!filePath2.exists()) {
                            filePath2.mkdirs();
                        }
                        String Xyz2 = exec("cat "+getFilesDir()+"/"+InputfileName+".xyz");
                        FileOutputStream fileout8 = openFileOutput(InputfileName+".inp", MODE_PRIVATE);
                        OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                        outputWriter8.write("Geometry = XyzFormat {\n");
                        outputWriter8.write(Xyz2);
                        outputWriter8.write("\n");
                        outputWriter8.write("}");
                        outputWriter8.write("\n");
                        outputWriter8.write(Begin);
                        outputWriter8.write("\n");
                        outputWriter8.write(Solv);
                        outputWriter8.write("\n");
                        outputWriter8.write(End);
                        outputWriter8.write("\n");
                        outputWriter8.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/"+InputfileName+".inp "+getFilesDir()+File.separator+"openbabel/solv/opt/"+InputfileName);

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

                    view_begin(exec("cat "+getFilesDir()+"/dftb-begin.txt"));
                    view_solv(exec("cat "+getFilesDir()+"/dftb-solv.txt"));
                    view_end(exec("cat "+getFilesDir()+"/dftb-end.txt"));
                    iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                    formula_view(exec("cat "+getFilesDir()+"/formula.txt"));
                    smiles_view(exec("cat "+getFilesDir()+"/smiles.txt"));
                    reference_view(exec("cat "+getFilesDir()+"/ref-level.txt"));
                    dftb_view(exec("cat "+getFilesDir()+File.separator+"openbabel/gas/opt/"+InputfileName));
                    dftb_filelist_view(exec("ls -l "+getFilesDir()+"/openbabel/xyz"));

                } catch (Exception e) {
                }
            }
        };
    }

    public void view_begin(final String view_begin_str) {
        Runnable view_begin_proc = new Runnable() {
            public void run() {
                dftb_begin.setText(view_begin_str);
            }
        };
        handler.post(view_begin_proc);
    }

    public void view_solv(final String view_solv_str) {
        Runnable view_solv_proc = new Runnable() {
            public void run() {
                dftb_solvation.setText(view_solv_str);
            }
        };
        handler.post(view_solv_proc);
    }

    public void view_end(final String view_end_str) {
        Runnable view_end_proc = new Runnable() {
            public void run() {
                dftb_end.setText(view_end_str);
            }
        };
        handler.post(view_end_proc);
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

    public void dftb_view(final String dftb_view_str) {
        Runnable dftb_view_proc = new Runnable() {
            public void run() {
                dftb_input.setText(dftb_view_str);
            }
        };
        handler.post(dftb_view_proc);
    }

    public void dftb_filelist_view(final String dftb_filelist_str) {
        Runnable dftb_filelist_proc = new Runnable() {
            public void run() {
                dftb_filelist.setText(dftb_filelist_str);
            }
        };
        handler.post(dftb_filelist_proc);
    }

    public void reference_view(final String reference_str) {
        Runnable reference_proc = new Runnable() {
            public void run() {
                referenceView.setText(reference_str);
            }
        };
        handler.post(reference_proc);
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

    private View.OnClickListener dftb_exit_click; {

        dftb_exit_click = new View.OnClickListener() {
            public void onClick(View v) {

                String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                String DatasetName1 = DatasetName0.replace(" ","_");
                String DatasetName = DatasetName1.replace(",",".");
                String Begin = dftb_begin.getText().toString();
                String Solv = dftb_solvation.getText().toString();
                String End = dftb_end.getText().toString();
                String Formulafile = formula.getText().toString();

                progressDialog = new ProgressDialog(Dftb1.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Performing DFTB+ calculations on species contained in dataset: "+DatasetName0);
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
                            Formula = Formula.replace("C", "[C]");
                            Formula = Formula.replace("[C]a", "Ca");
                            Formula = Formula.replace("[C]b", "Cb");
                            Formula = Formula.replace("[C]c", "Cc");
                            Formula = Formula.replace("[C]d", "Cd");
                            Formula = Formula.replace("[C]e", "Ce");
                            Formula = Formula.replace("[C]f", "Cf");
                            Formula = Formula.replace("[C]g", "Cg");
                            Formula = Formula.replace("[C]h", "Ch");
                            Formula = Formula.replace("[C]i", "Ci");
                            Formula = Formula.replace("[C]j", "Cj");
                            Formula = Formula.replace("[C]k", "Ck");
                            Formula = Formula.replace("[C]l", "Cl");
                            Formula = Formula.replace("[C]m", "Cm");
                            Formula = Formula.replace("[C]n", "Cn");
                            Formula = Formula.replace("[C]o", "Co");
                            Formula = Formula.replace("[C]p", "Cp");
                            Formula = Formula.replace("[C]q", "Cq");
                            Formula = Formula.replace("[C]r", "Cr");
                            Formula = Formula.replace("[C]s", "Cs");
                            Formula = Formula.replace("[C]t", "Ct");
                            Formula = Formula.replace("[C]u", "Cu");
                            Formula = Formula.replace("[C]v", "Cv");
                            Formula = Formula.replace("[C]w", "Cw");
                            Formula = Formula.replace("[C]x", "Cx");
                            Formula = Formula.replace("[C]y", "Cy");
                            Formula = Formula.replace("[C]z", "Cz");
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
                            Formula = Formula.replace("N", "[N]");
                            Formula = Formula.replace("[N]a", "Na");
                            Formula = Formula.replace("[N]b", "Nb");
                            Formula = Formula.replace("[N]c", "Nc");
                            Formula = Formula.replace("[N]d", "Nd");
                            Formula = Formula.replace("[N]e", "Ne");
                            Formula = Formula.replace("[N]f", "Nf");
                            Formula = Formula.replace("[N]g", "Ng");
                            Formula = Formula.replace("[N]h", "Nh");
                            Formula = Formula.replace("[N]i", "Ni");
                            Formula = Formula.replace("[N]j", "Nj");
                            Formula = Formula.replace("[N]k", "Nk");
                            Formula = Formula.replace("[N]l", "Nl");
                            Formula = Formula.replace("[N]m", "Nm");
                            Formula = Formula.replace("[N]n", "Nn");
                            Formula = Formula.replace("[N]o", "No");
                            Formula = Formula.replace("[N]p", "Np");
                            Formula = Formula.replace("[N]q", "Nq");
                            Formula = Formula.replace("[N]r", "Nr");
                            Formula = Formula.replace("[N]s", "Ns");
                            Formula = Formula.replace("[N]t", "Nt");
                            Formula = Formula.replace("[N]u", "Nu");
                            Formula = Formula.replace("[N]v", "Nv");
                            Formula = Formula.replace("[N]w", "Nw");
                            Formula = Formula.replace("[N]x", "Nx");
                            Formula = Formula.replace("[N]y", "Ny");
                            Formula = Formula.replace("[N]z", "Nz");
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
                            Formula = Formula.replace("S", "[S]");
                            Formula = Formula.replace("[S]a", "Sa");
                            Formula = Formula.replace("[S]b", "Sb");
                            Formula = Formula.replace("[S]c", "Sc");
                            Formula = Formula.replace("[S]d", "Sd");
                            Formula = Formula.replace("[S]e", "Se");
                            Formula = Formula.replace("[S]f", "Sf");
                            Formula = Formula.replace("[S]g", "Sg");
                            Formula = Formula.replace("[S]h", "Sh");
                            Formula = Formula.replace("[S]i", "Si");
                            Formula = Formula.replace("[S]j", "Sj");
                            Formula = Formula.replace("[S]k", "Sk");
                            Formula = Formula.replace("[S]l", "Sl");
                            Formula = Formula.replace("[S]m", "Sm");
                            Formula = Formula.replace("[S]n", "Sn");
                            Formula = Formula.replace("[S]o", "So");
                            Formula = Formula.replace("[S]p", "Sp");
                            Formula = Formula.replace("[S]q", "Sq");
                            Formula = Formula.replace("[S]r", "Sr");
                            Formula = Formula.replace("[S]s", "Ss");
                            Formula = Formula.replace("[S]t", "St");
                            Formula = Formula.replace("[S]u", "Su");
                            Formula = Formula.replace("[S]v", "Sv");
                            Formula = Formula.replace("[S]w", "Sw");
                            Formula = Formula.replace("[S]x", "Sx");
                            Formula = Formula.replace("[S]y", "Sy");
                            Formula = Formula.replace("[S]z", "Sz");
//                    }
//                    while (Formula.contains("F")){
                            Formula = Formula.replace("F", "[F]");
                            Formula = Formula.replace("[F]a", "Fa");
                            Formula = Formula.replace("[F]b", "Fb");
                            Formula = Formula.replace("[F]c", "Fc");
                            Formula = Formula.replace("[F]d", "Fd");
                            Formula = Formula.replace("[F]e", "Fe");
                            Formula = Formula.replace("[F]f", "Ff");
                            Formula = Formula.replace("[F]g", "Fg");
                            Formula = Formula.replace("[F]h", "Fh");
                            Formula = Formula.replace("[F]i", "Fi");
                            Formula = Formula.replace("[F]j", "Fj");
                            Formula = Formula.replace("[F]k", "Fk");
                            Formula = Formula.replace("[F]l", "Fl");
                            Formula = Formula.replace("[F]m", "Fm");
                            Formula = Formula.replace("[F]n", "Fn");
                            Formula = Formula.replace("[F]o", "Fo");
                            Formula = Formula.replace("[F]p", "Fp");
                            Formula = Formula.replace("[F]q", "Fq");
                            Formula = Formula.replace("[F]r", "Fr");
                            Formula = Formula.replace("[F]s", "Fs");
                            Formula = Formula.replace("[F]t", "Ft");
                            Formula = Formula.replace("[F]u", "Fu");
                            Formula = Formula.replace("[F]v", "Fv");
                            Formula = Formula.replace("[F]w", "Fw");
                            Formula = Formula.replace("[F]x", "Fx");
                            Formula = Formula.replace("[F]y", "Fy");
                            Formula = Formula.replace("[F]z", "Fz");
//                    }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                            try {
                                exec("cp "+getFilesDir()+"/openbabel/gas/opt/"+InputfileName+" "+getFilesDir()+"/dftb/dftb_in.hsd");
                                exec("chmod 755 -R "+getFilesDir());
                                try {
                                    FileOutputStream fileoutZZZ00 = openFileOutput(InputfileName+".out", MODE_PRIVATE);
                                    OutputStreamWriter outputWriterZZZ00 = new OutputStreamWriter(fileoutZZZ00);
                                    outputWriterZZZ00.write(exec(getApplicationInfo().nativeLibraryDir+"/libdftb.so"));
                                    outputWriterZZZ00.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                exec("mv "+getFilesDir()+"/dftb/dftb_in.hsd "+getFilesDir()+"/openbabel/gas/opt/results/"+InputfileName+".inp");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/gas/opt/results");
                                exec("mv "+getFilesDir()+"/dftb/detailed.out "+getFilesDir()+"/openbabel/gas/thermo/results/"+InputfileName+".out");
                                exec("rm "+getFilesDir()+"/dftb/band.out");
                                exec("rm "+getFilesDir()+"/dftb/results.tag");
                                exec("rm "+getFilesDir()+"/dftb/hamsqrN.dat");
                                exec("rm "+getFilesDir()+"/dftb/oversqr.dat");
                                exec("rm "+getFilesDir()+"/dftb/hamrealN.dat");
                                exec("rm "+getFilesDir()+"/dftb/overreal.dat");
                                exec("rm "+getFilesDir()+"/dftb/eigenvec.out");
                                exec("rm "+getFilesDir()+"/dftb/eigenvec.bin");
                                exec("rm "+getFilesDir()+"/dftb/charges.bin");
                                exec("rm "+getFilesDir()+"/dftb/charges.dat");
                                exec("rm "+getFilesDir()+"/dftb/md.out");
                                exec("rm "+getFilesDir()+"/dftb/ARPACK.DAT");
                                exec("rm "+getFilesDir()+"/dftb/COEF.DAT");
                                exec("rm "+getFilesDir()+"/dftb/EXC.DAT");
                                exec("rm "+getFilesDir()+"/dftb/SPX.DAT");
                                exec("rm "+getFilesDir()+"/dftb/TDP.DAT");
                                exec("rm "+getFilesDir()+"/dftb/TRA.DAT");
                                exec("rm "+getFilesDir()+"/dftb/TEST_ARPACK.DAT");
                                exec("rm "+getFilesDir()+"/dftb/XCH.DAT");
                                exec("rm "+getFilesDir()+"/dftb/XplusY.DAT");
                                exec("rm "+getFilesDir()+"/dftb/XREST.DAT");
                                exec("rm "+getFilesDir()+"/dftb/geo_end.gen");
                                exec("rm "+getFilesDir()+"/dftb/geo_end.xyz");
                                exec("rm "+getFilesDir()+"/dftb/dftb_pin.hsd");
                                exec("rm "+getFilesDir()+"/dftb/autotest.tag");
                                exec("rm "+getFilesDir()+"/dftb/dftbp.cosmo");


//                                String Sed4 = exec("sed -n /TS:/h;//!H;$!d;x;//p "+getFilesDir()+"/openbabel/gas/thermo/results/"+InputfileName+".out");
//                                String Sed5 = exec("sed -n /Mermin/h;//!H;$!d;x;//p "+getFilesDir()+"/openbabel/gas/thermo/results/"+InputfileName+".out");
                                String Grep4 = exec("grep -e TS: "+getFilesDir()+"/openbabel/gas/thermo/results/"+InputfileName+".out");
                                FileOutputStream fileout10a = openFileOutput(InputfileName+"_ga.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter10a = new OutputStreamWriter(fileout10a);
                                outputWriter10a.write(Grep4);
                                outputWriter10a.close();
                                // TS appears twice in radicals - both lines are relevant
//                                String Sed4 = exec("sed -n $p "+getFilesDir()+"/"+InputfileName+"_ga.temp");
//                                FileOutputStream fileout11a = openFileOutput(InputfileName+"_ga2.temp",MODE_PRIVATE);
//                                OutputStreamWriter outputWriter11a = new OutputStreamWriter(fileout11a);
//                                outputWriter11a.write(Sed4);
//                                outputWriter11a.close();
                                String Grep5 = exec("grep -e Mermin "+getFilesDir()+"/openbabel/gas/thermo/results/"+InputfileName+".out");
                                FileOutputStream fileout10b = openFileOutput(InputfileName+"_gb.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter10b = new OutputStreamWriter(fileout10b);
                                outputWriter10b.write(Grep5);
                                outputWriter10b.close();
                                String Sed5 = exec("sed -n $p "+getFilesDir()+"/"+InputfileName+"_gb.temp");
                                FileOutputStream fileout11b = openFileOutput(InputfileName+"_gb2.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter11b = new OutputStreamWriter(fileout11b);
                                outputWriter11b.write(Sed5);
                                outputWriter11b.close();
                                FileOutputStream fileout11 = openFileOutput(InputfileName+"_g.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter11 = new OutputStreamWriter(fileout11);
//                                outputWriter11.write(exec("cat "+getFilesDir()+"/"+InputfileName+"_ga2.temp"));
                                outputWriter11.write(exec("cat "+getFilesDir()+"/"+InputfileName+"_ga.temp"));
                                outputWriter11.write(exec("cat "+getFilesDir()+"/"+InputfileName+"_gb2.temp"));
                                outputWriter11.close();
                                String UHG = exec("cat "+getFilesDir()+"/"+InputfileName+"_g.temp");
                                UHG = UHG.replace("\n", " ");
                                FileOutputStream fileout12 = openFileOutput(DatasetName+"_g.txt",MODE_APPEND);
                                OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                                outputWriter12.write(InputfileName+" ");
                                outputWriter12.write(Formula+" ");
                                outputWriter12.write(UHG);
                                outputWriter12.write("\n");
                                outputWriter12.close();
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_g.temp");
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_ga.temp");
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_gb.temp");
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_gb2.temp");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }






















                        File[] files_solv = new File(getFilesDir()+"/openbabel/solv/opt").listFiles();
                        for (File file : files_solv) {
                            if (!file.isFile()) continue;


                            String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                            String DatasetName1 = DatasetName0.replace(" ","_");
                            String DatasetName = DatasetName1.replace(",",".");
                            String Begin = dftb_begin.getText().toString();
                            String Solv = dftb_solvation.getText().toString();
                            String End = dftb_end.getText().toString();
                            String Formulafile = formula.getText().toString();
                            String InputfileName = file.getName();
                            String Formula = exec("cat "+getFilesDir()+"/openbabel/formula/"+InputfileName+".formula");
                            String Method = exec("cat "+getFilesDir()+"/method.txt");


                            Formula = Formula.replace(",", ".");

                            ///////////////// introduce [C], [H], [N], [O], [S], [F] to formula programatically /////////////////////////
//                    try {
//                    while (Formula.contains("C")){
                            Formula = Formula.replace("C", "[C]");
                            Formula = Formula.replace("[C]a", "Ca");
                            Formula = Formula.replace("[C]b", "Cb");
                            Formula = Formula.replace("[C]c", "Cc");
                            Formula = Formula.replace("[C]d", "Cd");
                            Formula = Formula.replace("[C]e", "Ce");
                            Formula = Formula.replace("[C]f", "Cf");
                            Formula = Formula.replace("[C]g", "Cg");
                            Formula = Formula.replace("[C]h", "Ch");
                            Formula = Formula.replace("[C]i", "Ci");
                            Formula = Formula.replace("[C]j", "Cj");
                            Formula = Formula.replace("[C]k", "Ck");
                            Formula = Formula.replace("[C]l", "Cl");
                            Formula = Formula.replace("[C]m", "Cm");
                            Formula = Formula.replace("[C]n", "Cn");
                            Formula = Formula.replace("[C]o", "Co");
                            Formula = Formula.replace("[C]p", "Cp");
                            Formula = Formula.replace("[C]q", "Cq");
                            Formula = Formula.replace("[C]r", "Cr");
                            Formula = Formula.replace("[C]s", "Cs");
                            Formula = Formula.replace("[C]t", "Ct");
                            Formula = Formula.replace("[C]u", "Cu");
                            Formula = Formula.replace("[C]v", "Cv");
                            Formula = Formula.replace("[C]w", "Cw");
                            Formula = Formula.replace("[C]x", "Cx");
                            Formula = Formula.replace("[C]y", "Cy");
                            Formula = Formula.replace("[C]z", "Cz");
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
                            Formula = Formula.replace("N", "[N]");
                            Formula = Formula.replace("[N]a", "Na");
                            Formula = Formula.replace("[N]b", "Nb");
                            Formula = Formula.replace("[N]c", "Nc");
                            Formula = Formula.replace("[N]d", "Nd");
                            Formula = Formula.replace("[N]e", "Ne");
                            Formula = Formula.replace("[N]f", "Nf");
                            Formula = Formula.replace("[N]g", "Ng");
                            Formula = Formula.replace("[N]h", "Nh");
                            Formula = Formula.replace("[N]i", "Ni");
                            Formula = Formula.replace("[N]j", "Nj");
                            Formula = Formula.replace("[N]k", "Nk");
                            Formula = Formula.replace("[N]l", "Nl");
                            Formula = Formula.replace("[N]m", "Nm");
                            Formula = Formula.replace("[N]n", "Nn");
                            Formula = Formula.replace("[N]o", "No");
                            Formula = Formula.replace("[N]p", "Np");
                            Formula = Formula.replace("[N]q", "Nq");
                            Formula = Formula.replace("[N]r", "Nr");
                            Formula = Formula.replace("[N]s", "Ns");
                            Formula = Formula.replace("[N]t", "Nt");
                            Formula = Formula.replace("[N]u", "Nu");
                            Formula = Formula.replace("[N]v", "Nv");
                            Formula = Formula.replace("[N]w", "Nw");
                            Formula = Formula.replace("[N]x", "Nx");
                            Formula = Formula.replace("[N]y", "Ny");
                            Formula = Formula.replace("[N]z", "Nz");
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
                            Formula = Formula.replace("S", "[S]");
                            Formula = Formula.replace("[S]a", "Sa");
                            Formula = Formula.replace("[S]b", "Sb");
                            Formula = Formula.replace("[S]c", "Sc");
                            Formula = Formula.replace("[S]d", "Sd");
                            Formula = Formula.replace("[S]e", "Se");
                            Formula = Formula.replace("[S]f", "Sf");
                            Formula = Formula.replace("[S]g", "Sg");
                            Formula = Formula.replace("[S]h", "Sh");
                            Formula = Formula.replace("[S]i", "Si");
                            Formula = Formula.replace("[S]j", "Sj");
                            Formula = Formula.replace("[S]k", "Sk");
                            Formula = Formula.replace("[S]l", "Sl");
                            Formula = Formula.replace("[S]m", "Sm");
                            Formula = Formula.replace("[S]n", "Sn");
                            Formula = Formula.replace("[S]o", "So");
                            Formula = Formula.replace("[S]p", "Sp");
                            Formula = Formula.replace("[S]q", "Sq");
                            Formula = Formula.replace("[S]r", "Sr");
                            Formula = Formula.replace("[S]s", "Ss");
                            Formula = Formula.replace("[S]t", "St");
                            Formula = Formula.replace("[S]u", "Su");
                            Formula = Formula.replace("[S]v", "Sv");
                            Formula = Formula.replace("[S]w", "Sw");
                            Formula = Formula.replace("[S]x", "Sx");
                            Formula = Formula.replace("[S]y", "Sy");
                            Formula = Formula.replace("[S]z", "Sz");
//                    }
//                    while (Formula.contains("F")){
                            Formula = Formula.replace("F", "[F]");
                            Formula = Formula.replace("[F]a", "Fa");
                            Formula = Formula.replace("[F]b", "Fb");
                            Formula = Formula.replace("[F]c", "Fc");
                            Formula = Formula.replace("[F]d", "Fd");
                            Formula = Formula.replace("[F]e", "Fe");
                            Formula = Formula.replace("[F]f", "Ff");
                            Formula = Formula.replace("[F]g", "Fg");
                            Formula = Formula.replace("[F]h", "Fh");
                            Formula = Formula.replace("[F]i", "Fi");
                            Formula = Formula.replace("[F]j", "Fj");
                            Formula = Formula.replace("[F]k", "Fk");
                            Formula = Formula.replace("[F]l", "Fl");
                            Formula = Formula.replace("[F]m", "Fm");
                            Formula = Formula.replace("[F]n", "Fn");
                            Formula = Formula.replace("[F]o", "Fo");
                            Formula = Formula.replace("[F]p", "Fp");
                            Formula = Formula.replace("[F]q", "Fq");
                            Formula = Formula.replace("[F]r", "Fr");
                            Formula = Formula.replace("[F]s", "Fs");
                            Formula = Formula.replace("[F]t", "Ft");
                            Formula = Formula.replace("[F]u", "Fu");
                            Formula = Formula.replace("[F]v", "Fv");
                            Formula = Formula.replace("[F]w", "Fw");
                            Formula = Formula.replace("[F]x", "Fx");
                            Formula = Formula.replace("[F]y", "Fy");
                            Formula = Formula.replace("[F]z", "Fz");
//                    }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                            try {

                                exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileName+" "+getFilesDir()+"/dftb/dftb_in.hsd");
                                exec("chmod 755 -R "+getFilesDir());
                                try {
                                    FileOutputStream fileoutZZZ22 = openFileOutput(InputfileName+".out", MODE_PRIVATE);
                                    OutputStreamWriter outputWriterZZZ22 = new OutputStreamWriter(fileoutZZZ22);
                                    outputWriterZZZ22.write(exec(getApplicationInfo().nativeLibraryDir+"/libdftb.so"));
                                    outputWriterZZZ22.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                exec("mv "+getFilesDir()+"/dftb/dftb_in.hsd "+getFilesDir()+"/openbabel/solv/opt/results/"+InputfileName+".inp");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/solv/opt/results");
                                exec("mv "+getFilesDir()+"/dftb/detailed.out "+getFilesDir()+"/openbabel/solv/thermo/results/"+InputfileName+".out");
                                exec("rm "+getFilesDir()+"/dftb/band.out");
                                exec("rm "+getFilesDir()+"/dftb/results.tag");
                                exec("rm "+getFilesDir()+"/dftb/hamsqrN.dat");
                                exec("rm "+getFilesDir()+"/dftb/oversqr.dat");
                                exec("rm "+getFilesDir()+"/dftb/hamrealN.dat");
                                exec("rm "+getFilesDir()+"/dftb/overreal.dat");
                                exec("rm "+getFilesDir()+"/dftb/eigenvec.out");
                                exec("rm "+getFilesDir()+"/dftb/eigenvec.bin");
                                exec("rm "+getFilesDir()+"/dftb/charges.bin");
                                exec("rm "+getFilesDir()+"/dftb/charges.dat");
                                exec("rm "+getFilesDir()+"/dftb/md.out");
                                exec("rm "+getFilesDir()+"/dftb/ARPACK.DAT");
                                exec("rm "+getFilesDir()+"/dftb/COEF.DAT");
                                exec("rm "+getFilesDir()+"/dftb/EXC.DAT");
                                exec("rm "+getFilesDir()+"/dftb/SPX.DAT");
                                exec("rm "+getFilesDir()+"/dftb/TDP.DAT");
                                exec("rm "+getFilesDir()+"/dftb/TRA.DAT");
                                exec("rm "+getFilesDir()+"/dftb/TEST_ARPACK.DAT");
                                exec("rm "+getFilesDir()+"/dftb/XCH.DAT");
                                exec("rm "+getFilesDir()+"/dftb/XplusY.DAT");
                                exec("rm "+getFilesDir()+"/dftb/XREST.DAT");
                                exec("rm "+getFilesDir()+"/dftb/geo_end.gen");
                                exec("rm "+getFilesDir()+"/dftb/geo_end.xyz");
                                exec("rm "+getFilesDir()+"/dftb/dftb_pin.hsd");
                                exec("rm "+getFilesDir()+"/dftb/autotest.tag");
                                exec("rm "+getFilesDir()+"/dftb/dftbp.cosmo");


//                                String Sed334 = exec("sed -n /TS:/h;//!H;$!d;x;//p "+getFilesDir()+"/openbabel/solv/thermo/results/"+InputfileName+".out");
//                                String Sed335 = exec("sed -n /Mermin/h;//!H;$!d;x;//p "+getFilesDir()+"/openbabel/solv/thermo/results/"+InputfileName+".out");

                                String Grep334 = exec("grep -e TS: "+getFilesDir()+"/openbabel/solv/thermo/results/"+InputfileName+".out");
                                FileOutputStream fileout3310a = openFileOutput(InputfileName+"_sa.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter3310a = new OutputStreamWriter(fileout3310a);
                                outputWriter3310a.write(Grep334);
                                outputWriter3310a.close();
                                // TS appears twice in radicals - both lines are relevant
//                                String Sed334 = exec("sed -n $p "+getFilesDir()+"/"+InputfileName+"_sa.temp");
//                                FileOutputStream fileout3311a = openFileOutput(InputfileName+"_sa2.temp",MODE_PRIVATE);
//                                OutputStreamWriter outputWriter3311a = new OutputStreamWriter(fileout3311a);
//                                outputWriter3311a.write(Sed334);
//                                outputWriter3311a.close();
                                String Grep335 = exec("grep -e Mermin "+getFilesDir()+"/openbabel/solv/thermo/results/"+InputfileName+".out");
                                FileOutputStream fileout3310b = openFileOutput(InputfileName+"_sb.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter3310b = new OutputStreamWriter(fileout3310b);
                                outputWriter3310b.write(Grep335);
                                outputWriter3310b.close();
                                String Sed335 = exec("sed -n $p "+getFilesDir()+"/"+InputfileName+"_sb.temp");
                                FileOutputStream fileout3311b = openFileOutput(InputfileName+"_sb2.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter3311b = new OutputStreamWriter(fileout3311b);
                                outputWriter3311b.write(Sed335);
                                outputWriter3311b.close();
                                FileOutputStream fileout3311 = openFileOutput(InputfileName+"_s.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter3311 = new OutputStreamWriter(fileout3311);
//                                outputWriter3311.write(exec("cat "+getFilesDir()+"/"+InputfileName+"_sa2.temp"));
                                outputWriter3311.write(exec("cat "+getFilesDir()+"/"+InputfileName+"_sa.temp"));
                                outputWriter3311.write(exec("cat "+getFilesDir()+"/"+InputfileName+"_sb2.temp"));
                                outputWriter3311.close();
                                String UHG_ = exec("cat "+getFilesDir()+"/"+InputfileName+"_s.temp");
                                UHG_ = UHG_.replace("\n", " ");
                                FileOutputStream fileout3312 = openFileOutput(DatasetName+"_s.txt",MODE_APPEND);
                                OutputStreamWriter outputWriter3312 = new OutputStreamWriter(fileout3312);
                                outputWriter3312.write(InputfileName+" ");
                                outputWriter3312.write(Formula+" ");
                                outputWriter3312.write(UHG_);
                                outputWriter3312.write("\n");
                                outputWriter3312.close();
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_s.temp");
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_sa.temp");
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_sb.temp");
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_sb2.temp");

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
//for case of fall down - the same as in MainActivity.java in OnResume:
//                        exec("chmod 755 "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");


                        exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhasesDFTB.b "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhasesDFTB.bas");
                        exec("chmod -R 755 "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhasesDFTB.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhasesDFTB.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_solDFTB.b "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_solDFTB.bas");
//            exec("chmod -R 755 "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_solDFTB.b");
                        exec("chmod 755 "+getFilesDir()+"/PSEUDOPHASES/Database_solid_solDFTB.dat");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhaseDFTB.b "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhaseDFTB.bas");
                        exec("chmod -R 755 "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhaseDFTB.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhaseDFTB.b");


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

//                            exec("chmod 755 "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
//                            exec("sed -i '$d' "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
//                            exec("cp "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat "+getFilesDir()+"/Database_solid_sol2.dat");



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

                            exec("chmod 755 "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");

                            String Raw_ss01 = exec("cat "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
                            while (Raw_ss01.contains("= + e- =")){  //2 spaces
                                Raw_ss01 = Raw_ss01.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            while (Raw_ss01.contains("=  + e- =")){  //2 spaces
                                Raw_ss01 = Raw_ss01.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout2216 = openFileOutput("Database_solid_sol1.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter2216 = new OutputStreamWriter(fileout2216);
                            outputWriter2216.write(Raw_ss01);
                            outputWriter2216.close();

                            String Raw_ss02 = exec("cat "+getFilesDir()+"/Database_solid_sol1.dat");
                            while (Raw_ss02.contains("(solv) ;  = ")){  //2 spaces
                                Raw_ss02 = Raw_ss02.replace("(solv) ;  = ", ""); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout2217 = openFileOutput("Database_solid_sol2.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter2217 = new OutputStreamWriter(fileout2217);
                            outputWriter2217.write(Raw_ss02);
                            outputWriter2217.close();

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

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                        String DatasetName1 = DatasetName0.replace(" ","_");
                        String DatasetName = DatasetName1.replace(",",".");
                        exec("mv "+getFilesDir()+"/Database_g2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_g.txt");
                        exec("mv "+getFilesDir()+"/Database_g4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_g.txt");
                        exec("chmod -R 755 "+getFilesDir()+"/PHASES");
//                        exec("mv "+getFilesDir()+"/PHASES/Fastchem_g.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+DatasetName+"_g.txt");
                        // temporary solution:
//                        exec("chmod -R 755 "+getFilesDir()+"/PHASES");
//                        exec("mv "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_solid_sol.txt");
                        //
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
// end of repetiton



// this must be inside of ProgressDialog, otherwise the produced database will not be copied outside and the calculation ends unexpectedly
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
////            exec("chmod -R 755 "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
//            exec("chmod 755 "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.bas");
//            exec("chmod -R 755 "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
            Intent intent = new Intent(Dftb1.this, ResumeActivity.class);
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
                    exec("mkdir "+getFilesDir()+File.separator+"openbabel");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                cp2k_exit_click();
            }
        };
    }

    private void cp2k_exit_click() {

        Intent intent = new Intent(Dftb1.this, MainActivity.class);
        startActivity(intent);
    }




}

