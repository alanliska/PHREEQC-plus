package cz.p;

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

public class KineticsUniUni extends MainActivity {

    private TextView methodA_label;
    private TextView methodB_label;
    private TextView methodTS_label;

    private EditText methodA;
    private EditText methodB;
    private EditText methodTS;

    private TextView keywA_label;
    private TextView keywB_label;
    private TextView keywTS_label;

    private EditText keywA;
    private EditText keywB;
    private EditText keywTS;

    private TextView iupacA_label;
    private TextView iupacB_label;

    private EditText iupacA;
    private EditText iupacB;

    private TextView formulaA_label;
    private TextView formulaB_label;

    private EditText formulaA;
    private EditText formulaB;

    private TextView smiA_label;
    private TextView smiB_label;

    private EditText smiA;
    private EditText smiB;

    private Button AddTS;
    private Button ResetTS;
    private Button processUniUni;
    private Button quit;

    private TextView TSLabel;
    private TextView TS;

    private Handler handler = new Handler();

    private static final int READ_FILE1 = 1;
    private Uri documentUri1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kineticsuniuni);

        methodA_label = (TextView) findViewById(R.id.methodA_label);
        methodB_label = (TextView) findViewById(R.id.methodB_label);
        methodTS_label = (TextView) findViewById(R.id.methodTS_label);

        methodA = (EditText) findViewById(R.id.methodA);
        methodB = (EditText) findViewById(R.id.methodB);
        methodTS = (EditText) findViewById(R.id.methodTS);

        keywA_label = (TextView) findViewById(R.id.keywA_label);
        keywB_label = (TextView) findViewById(R.id.keywB_label);
        keywTS_label = (TextView) findViewById(R.id.keywTS_label);

        keywA = (EditText) findViewById(R.id.keywA);
        keywB = (EditText) findViewById(R.id.keywB);
        keywTS = (EditText) findViewById(R.id.keywTS);

        iupacA_label = (TextView) findViewById(R.id.iupacA_label);
        iupacB_label = (TextView) findViewById(R.id.iupacB_label);

        iupacA = (EditText) findViewById(R.id.iupacA);
        iupacB = (EditText) findViewById(R.id.iupacB);

        formulaA_label = (TextView) findViewById(R.id.formulaA_label);
        formulaB_label = (TextView) findViewById(R.id.formulaB_label);

        formulaA = (EditText) findViewById(R.id.formulaA);
        formulaB = (EditText) findViewById(R.id.formulaB);

        smiA_label = (TextView) findViewById(R.id.smiA_label);
        smiB_label = (TextView) findViewById(R.id.smiB_label);

        smiA = (EditText) findViewById(R.id.smiA);
        smiB = (EditText) findViewById(R.id.smiB);

        TSLabel = (TextView) findViewById(R.id.TSLabel);
        TS = (TextView) findViewById(R.id.TS);

        AddTS = (Button) findViewById(R.id.AddTS);
        AddTS.setOnClickListener(AddTSClick);
        ResetTS = (Button) findViewById(R.id.ResetTS);
        ResetTS.setOnClickListener(ResetTSClick);
        processUniUni = (Button) findViewById(R.id.processUniUni);
        processUniUni.setOnClickListener(processUniUniClick);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(QuitClick);

    }

    public void onStart()
    {
        super.onStart();
        MethodADisplay(exec("cat "+getFilesDir()+"/UniUni_methodA.txt"));
        MethodBDisplay(exec("cat "+getFilesDir()+"/UniUni_methodB.txt"));
        MethodTSDisplay(exec("cat "+getFilesDir()+"/UniUni_methodTS.txt"));
        KeywADisplay(exec("cat "+getFilesDir()+"/UniUni_keywA.txt"));
        KeywBDisplay(exec("cat "+getFilesDir()+"/UniUni_keywB.txt"));
        KeywTSDisplay(exec("cat "+getFilesDir()+"/UniUni_keywTS.txt"));
        IupacADisplay(exec("cat "+getFilesDir()+"/UniUni_iupacA.txt"));
        IupacBDisplay(exec("cat "+getFilesDir()+"/UniUni_iupacB.txt"));
        FormulaADisplay(exec("cat "+getFilesDir()+"/UniUni_formulaA.txt"));
        FormulaBDisplay(exec("cat "+getFilesDir()+"/UniUni_formulaB.txt"));
        SmilesADisplay(exec("cat "+getFilesDir()+"/UniUni_smilesA.txt"));
        SmilesBDisplay(exec("cat "+getFilesDir()+"/UniUni_smilesB.txt"));

        File filePathTS = new File(getFilesDir()+File.separator+"UniUni_TS.txt");
        if (!filePathTS.exists()) {
            try {
                FileOutputStream fileoutTS = openFileOutput("UniUni_TS_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                outputWriterTS.write("Transition state XYZ coordinate file not selected.");
                outputWriterTS.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutTS = openFileOutput("UniUni_TS_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                outputWriterTS.write("Transition state XYZ coordinate file is available.");
                outputWriterTS.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        TS_StatusDisplay(exec("cat "+getFilesDir()+"/UniUni_TS_status.txt"));
    }

    private View.OnClickListener AddTSClick; {

        AddTSClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                /////////////////////////// SAVE EVERYTHING PRE-SET ////////////////////////////////
                String InputfileA = smiA.getText().toString();
                String InputfileName0A = iupacA.getText().toString();
                String MethodfileA = methodA.getText().toString();
                String KeywordsfileA = keywA.getText().toString();
                String FormulafileA = formulaA.getText().toString();

                String InputfileB = smiB.getText().toString();
                String InputfileName0B = iupacB.getText().toString();
                String MethodfileB = methodB.getText().toString();
                String KeywordsfileB = keywB.getText().toString();
                String FormulafileB = formulaB.getText().toString();

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("UniUni_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("UniUni_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("UniUni_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("UniUni_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("UniUni_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("UniUni_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("UniUni_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("UniUni_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("UniUni_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("UniUni_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout42 = openFileOutput("UniUni_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("UniUni_keywTS.txt", MODE_PRIVATE);
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

                FileOutputStream fileout = openFileOutput("UniUni_TS.txt", MODE_PRIVATE);
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
                exec("rm "+getFilesDir()+"/UniUni_TS.txt");

                MethodADisplay(exec("cat "+getFilesDir()+"/UniUni_methodA.txt"));
                MethodBDisplay(exec("cat "+getFilesDir()+"/UniUni_methodB.txt"));
                MethodTSDisplay(exec("cat "+getFilesDir()+"/UniUni_methodTS.txt"));
                KeywADisplay(exec("cat "+getFilesDir()+"/UniUni_keywA.txt"));
                KeywBDisplay(exec("cat "+getFilesDir()+"/UniUni_keywB.txt"));
                KeywTSDisplay(exec("cat "+getFilesDir()+"/UniUni_keywTS.txt"));
                IupacADisplay(exec("cat "+getFilesDir()+"/UniUni_iupacA.txt"));
                IupacBDisplay(exec("cat "+getFilesDir()+"/UniUni_iupacB.txt"));
                FormulaADisplay(exec("cat "+getFilesDir()+"/UniUni_formulaA.txt"));
                FormulaBDisplay(exec("cat "+getFilesDir()+"/UniUni_formulaB.txt"));
                SmilesADisplay(exec("cat "+getFilesDir()+"/UniUni_smilesA.txt"));
                SmilesBDisplay(exec("cat "+getFilesDir()+"/UniUni_smilesB.txt"));

                File filePathTS = new File(getFilesDir()+File.separator+"UniUni_TS.txt");
                if (!filePathTS.exists()) {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("UniUni_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file not selected.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("UniUni_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file is available.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                TS_StatusDisplay(exec("cat "+getFilesDir()+"/UniUni_TS_status.txt"));
            }
        };
    }

    private View.OnClickListener processUniUniClick; {

        processUniUniClick = new View.OnClickListener() {
            public void onClick(View v) {

//                String DatasetName = exec("cat "+getFilesDir()+"/dataset-name.txt");
//                progressDialog = new ProgressDialog(KineticsBiBi.this);
//                progressDialog.setTitle("Please wait...");
//                progressDialog.setMessage("Performing MOPAC calculations on species contained in dataset: "+DatasetName);
//                progressDialog.setCancelable(false);
//                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//                progressDialog.show();
//                new Thread() {
//                    public void run() {
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
                    FileOutputStream fileout = openFileOutput("UniUni_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("UniUni_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("UniUni_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("UniUni_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("UniUni_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    String InputfileNameA = InputfileName0A.replace(" ","_");
                    exec("cp "+getFilesDir()+"/UniUni_smilesA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".smi");
                    exec("cp "+getFilesDir()+"/UniUni_iupacA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".iupac");
                    exec("cp "+getFilesDir()+"/UniUni_formulaA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".formula");
                    exec("chmod 755 -R "+getFilesDir());
                    String ObabelOutputA = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+File.separator+"openbabel"+File.separator+InputfileNameA+".smi -oxyz --gen3d");
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

                    /////////////////////////////////// B ///////////////////////////////////////////////
                    String InputfileB = smiB.getText().toString();
                    String InputfileName0B = iupacB.getText().toString();
                    String MethodfileB = methodB.getText().toString();
                    String KeywordsfileB = keywB.getText().toString();
                    String FormulafileB = formulaB.getText().toString();

                    FileOutputStream fileout10 = openFileOutput("UniUni_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("UniUni_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("UniUni_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("UniUni_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("UniUni_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();


                    String InputfileNameB = InputfileName0B.replace(" ","_");
                    exec("cp "+getFilesDir()+"/UniUni_smilesB.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameB+".smi");
                    exec("cp "+getFilesDir()+"/UniUni_iupacB.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameB+".iupac");
                    exec("cp "+getFilesDir()+"/UniUni_formulaB.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameB+".formula");
                    exec("chmod 755 -R "+getFilesDir());
                    String ObabelOutputB = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+File.separator+"openbabel"+File.separator+InputfileNameB+".smi -oxyz --gen3d");
                    FileOutputStream fileout14 = openFileOutput(InputfileNameB+".xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter14 = new OutputStreamWriter(fileout14);
                    outputWriter14.write(ObabelOutputB);
                    outputWriter14.close();
                    String KeyB = MethodfileB+" "+KeywordsfileB;

                    try {
                        String Sed12 = exec("sed -e 1,2d "+getFilesDir()+"/"+InputfileNameB+".xyz");
                        FileOutputStream fileout118 = openFileOutput(InputfileNameB+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter118 = new OutputStreamWriter(fileout118);
                        outputWriter118.write(KeyB);
                        outputWriter118.write("\n");
                        outputWriter118.write("\n");
                        outputWriter118.write("\n");
                        outputWriter118.write(Sed12);
                        outputWriter118.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/"+InputfileNameB+".mop "+getFilesDir()+File.separator+"openbabel/solv/opt/"+InputfileNameB);
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameB+".smi "+getFilesDir()+File.separator+"openbabel/smiles");
                    exec("mv "+getFilesDir()+"/"+InputfileNameB+".xyz "+getFilesDir()+File.separator+"openbabel/xyz");
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameB+".iupac "+getFilesDir()+File.separator+"openbabel/iupac");
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameB+".formula "+getFilesDir()+File.separator+"openbabel/formula");

                    /////////////////////////////////// TS ///////////////////////////////////////////////
                    String MethodfileTS = methodTS.getText().toString();
                    String KeywordsfileTS = keywTS.getText().toString();

                    FileOutputStream fileout42 = openFileOutput("UniUni_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("UniUni_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();


                    String InputfileNameTS0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                    String InputfileNameTS = InputfileNameTS0+"_TS";
                    exec("chmod 755 -R "+getFilesDir());
                    String KeyTS = MethodfileTS+" "+KeywordsfileTS;

                    try {
                        String Sed42 = exec("sed -e 1,2d "+getFilesDir()+"/UniUni_TS.txt");
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
                    exec("mv "+getFilesDir()+"/UniUni_TS.txt "+getFilesDir()+File.separator+"openbabel/xyz/"+InputfileNameTS+".xyz");
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameTS+".iupac "+getFilesDir()+File.separator+"openbabel/iupac");
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameTS+".formula "+getFilesDir()+File.separator+"openbabel/formula");

                    /////////////////////////////////// Calculate A ///////////////////////////////////////////////

                    try {
                        exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameA+" "+getFilesDir()+"/"+InputfileNameA+".mop");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameA);
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
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameA);
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
                        FileOutputStream fileout10016 = openFileOutput("thermo_s_R1.txt",MODE_PRIVATE);
                        OutputStreamWriter outputWriter10016 = new OutputStreamWriter(fileout10016);
                        outputWriter10016.write(RawOutput_s);
                        outputWriter10016.close();

                        exec("mv "+getFilesDir()+"/"+InputfileNameA+".out "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameA+".arc "+getFilesDir()+"/openbabel/solv/thermo/results/");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    /////////////////////////////////// Calculate B ///////////////////////////////////////////////

                    try {
                        exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameB+" "+getFilesDir()+"/"+InputfileNameB+".mop");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameB);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileNameB+".mop "+getFilesDir()+"/openbabel/solv/opt/results/");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameB+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameB+".arc");
                        exec("cp "+getFilesDir()+"/"+InputfileNameB+".arc "+getFilesDir()+"/openbabel/solv/thermo");
                        exec("mv "+getFilesDir()+"/"+InputfileNameB+".out "+getFilesDir()+"/openbabel/solv/opt/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameB+".arc "+getFilesDir()+"/openbabel/solv/opt/results/");
                        String Sed11003 = exec("sed -n 1p "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameB);
                        String Sed11004 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameB+".arc");
                        FileOutputStream fileout11009 = openFileOutput(InputfileNameB+".mops", MODE_PRIVATE);
                        OutputStreamWriter outputWriter11009 = new OutputStreamWriter(fileout11009);
                        outputWriter11009.write(Sed11004);
                        outputWriter11009.close();
                        exec("cp "+getFilesDir()+"/"+InputfileNameB+".mops "+getFilesDir()+"/openbabel/solv/thermo");
                        String Sed11005 = exec("sed -e 1,3d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameB+".mops");
                        FileOutputStream fileout11010 = openFileOutput(InputfileNameB+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter11010 = new OutputStreamWriter(fileout11010);
                        outputWriter11010.write("THERMO(298,298) LET "+Sed11003);
                        outputWriter11010.write("\n");
                        outputWriter11010.write("\n");
                        outputWriter11010.write(Sed11005);
                        outputWriter11010.close();
                        exec("rm "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameB+".mops");
                        exec("rm "+getFilesDir()+"/"+InputfileNameB+".mops");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameB);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileNameB+".mop "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameB+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameB+".arc");

                        String Grep11002 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileNameB+".out");
                        FileOutputStream fileout11013 = openFileOutput(InputfileNameB+"_s.temp",MODE_PRIVATE);
                        OutputStreamWriter outputWriter11013 = new OutputStreamWriter(fileout11013);
                        outputWriter11013.write(Grep11002);
                        outputWriter11013.close();
                        String Sed11006 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileNameB+"_s.temp");
                        String FormulaB = formulaB.getText().toString();
                        String MethodB = methodB.getText().toString();
                        FileOutputStream fileout11014 = openFileOutput(InputfileNameB+"_s.txt",MODE_APPEND);
                        OutputStreamWriter outputWriter11014 = new OutputStreamWriter(fileout11014);
                        outputWriter11014.write(InputfileNameB+" ");
                        outputWriter11014.write(FormulaB+" ");
                        outputWriter11014.write(MethodB+" ");
                        outputWriter11014.write(Sed11006);
                        outputWriter11014.close();
                        exec("rm "+getFilesDir()+"/"+InputfileNameB+"_s.temp");

                        String RawOutput_s2 = exec("cat "+getFilesDir()+"/"+InputfileNameB+"_s.txt");
                        while (RawOutput_s2.contains("  ")){  //2 spaces
                            RawOutput_s2 = RawOutput_s2.replace("  ", " "); //(2 spaces, 1 space)
                        }
                        FileOutputStream fileout11016 = openFileOutput("thermo_s_P1.txt",MODE_PRIVATE);
                        OutputStreamWriter outputWriter11016 = new OutputStreamWriter(fileout11016);
                        outputWriter11016.write(RawOutput_s2);
                        outputWriter11016.close();

                        exec("mv "+getFilesDir()+"/"+InputfileNameB+".out "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameB+".arc "+getFilesDir()+"/openbabel/solv/thermo/results/");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    /////////////////////////////////// Calculate TS ///////////////////////////////////////////////

                    try {
                        exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameTS+" "+getFilesDir()+"/"+InputfileNameTS+".mop");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameTS);
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
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameTS);
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
                        String DatasetName = exec("cat "+getFilesDir()+"/dataset-name.txt");
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
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/UniUni.b "+getFilesDir()+"/UniUni.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/UniUni.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/UniUni.b");

                    /////////////////////////////////// Export results ///////////////////////////////////////////////

                    String DatasetName = exec("cat "+getFilesDir()+"/dataset-name.txt");
                    File filePathExt = new File(getFilesDir()+"/openbabel/kinetics");
                    if (!filePathExt.exists()) {
                        filePathExt.mkdirs();
                    }
                    exec("mv "+getFilesDir()+"/thermo_s_KINETICS.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_KINETICS.txt");
                    exec("mv "+getFilesDir()+"/thermo_s_RATES.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_RATES.txt");
                    exec("mv "+getFilesDir()+"/thermo_s_SMS.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_SMS.txt");
                    exec("mv "+getFilesDir()+"/thermo_s_SS.txt "+getFilesDir()+"/openbabel/kinetics/"+DatasetName+"_SS.txt");

                    /////////////////////////////////// Display fields ///////////////////////////////////////////////

                    MethodADisplay(exec("cat "+getFilesDir()+"/UniUni_methodA.txt"));
                    MethodBDisplay(exec("cat "+getFilesDir()+"/UniUni_methodB.txt"));
                    MethodTSDisplay(exec("cat "+getFilesDir()+"/UniUni_methodTS.txt"));
                    KeywADisplay(exec("cat "+getFilesDir()+"/UniUni_keywA.txt"));
                    KeywBDisplay(exec("cat "+getFilesDir()+"/UniUni_keywB.txt"));
                    KeywTSDisplay(exec("cat "+getFilesDir()+"/UniUni_keywTS.txt"));
                    IupacADisplay(exec("cat "+getFilesDir()+"/UniUni_iupacA.txt"));
                    IupacBDisplay(exec("cat "+getFilesDir()+"/UniUni_iupacB.txt"));
                    FormulaADisplay(exec("cat "+getFilesDir()+"/UniUni_formulaA.txt"));
                    FormulaBDisplay(exec("cat "+getFilesDir()+"/UniUni_formulaB.txt"));
                    SmilesADisplay(exec("cat "+getFilesDir()+"/UniUni_smilesA.txt"));
                    SmilesBDisplay(exec("cat "+getFilesDir()+"/UniUni_smilesB.txt"));

                    File filePathTS = new File(getFilesDir()+File.separator+"UniUni_TS.txt");
                    if (!filePathTS.exists()) {
                        try {
                            FileOutputStream fileoutTS = openFileOutput("UniUni_TS_status.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                            outputWriterTS.write("Transition state XYZ coordinate file not selected.");
                            outputWriterTS.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            FileOutputStream fileoutTS = openFileOutput("UniUni_TS_status.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                            outputWriterTS.write("Transition state XYZ coordinate file is available.");
                            outputWriterTS.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    TS_StatusDisplay(exec("cat "+getFilesDir()+"/UniUni_TS_status.txt"));





                } catch (Exception e) {
                }



//                        onFinish();
//                    }
//                    public void onFinish(){
//                        progressDialog.dismiss();
//                    }
//                }.start();


                Intent intent = new Intent(KineticsUniUni.this, MainActivity.class);
                startActivity(intent);
                String DatasetName = exec("cat "+getFilesDir()+"/dataset-name.txt");
                exec("rm "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_g.txt");
                exec("rm "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_s.txt");
            }
        };
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(KineticsUniUni.this, MainActivity.class);
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


    private void MethodADisplay(final String strMA) {
        Runnable procMA = new Runnable() {
            public void run() {
                methodA.setText(strMA);
            }
        };
        handler.post(procMA);
    }
    private void MethodBDisplay(final String strMB) {
        Runnable procMB = new Runnable() {
            public void run() {
                methodB.setText(strMB);
            }
        };
        handler.post(procMB);
    }
    private void MethodTSDisplay(final String strMTS) {
        Runnable procMTS = new Runnable() {
            public void run() {
                methodTS.setText(strMTS);
            }
        };
        handler.post(procMTS);
    }
    private void KeywADisplay(final String strKA) {
        Runnable procKA = new Runnable() {
            public void run() {
                keywA.setText(strKA);
            }
        };
        handler.post(procKA);
    }
    private void KeywBDisplay(final String strKB) {
        Runnable procKB = new Runnable() {
            public void run() {
                keywB.setText(strKB);
            }
        };
        handler.post(procKB);
    }
    private void KeywTSDisplay(final String strKTS) {
        Runnable procKTS = new Runnable() {
            public void run() {
                keywTS.setText(strKTS);
            }
        };
        handler.post(procKTS);
    }
    private void IupacADisplay(final String strIA) {
        Runnable procIA = new Runnable() {
            public void run() {
                iupacA.setText(strIA);
            }
        };
        handler.post(procIA);
    }
    private void IupacBDisplay(final String strIB) {
        Runnable procIB = new Runnable() {
            public void run() {
                iupacB.setText(strIB);
            }
        };
        handler.post(procIB);
    }
    private void FormulaADisplay(final String strFA) {
        Runnable procFA = new Runnable() {
            public void run() {
                formulaA.setText(strFA);
            }
        };
        handler.post(procFA);
    }
    private void FormulaBDisplay(final String strFB) {
        Runnable procFB = new Runnable() {
            public void run() {
                formulaB.setText(strFB);
            }
        };
        handler.post(procFB);
    }
    private void SmilesADisplay(final String strSA) {
        Runnable procSA = new Runnable() {
            public void run() {
                smiA.setText(strSA);
            }
        };
        handler.post(procSA);
    }
    private void SmilesBDisplay(final String strSB) {
        Runnable procSB = new Runnable() {
            public void run() {
                smiB.setText(strSB);
            }
        };
        handler.post(procSB);
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
