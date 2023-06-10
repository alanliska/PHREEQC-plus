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

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

public class KineticsBiTri extends MainActivity {

    private TextView methodA_label;
    private TextView methodB_label;
    private TextView methodC_label;
    private TextView methodD_label;
    private TextView methodE_label;
    private TextView methodTS_label;

    private EditText methodA;
    private EditText methodB;
    private EditText methodC;
    private EditText methodD;
    private EditText methodE;
    private EditText methodTS;

    private TextView keywA_label;
    private TextView keywB_label;
    private TextView keywC_label;
    private TextView keywD_label;
    private TextView keywE_label;
    private TextView keywTS_label;

    private EditText keywA;
    private EditText keywB;
    private EditText keywC;
    private EditText keywD;
    private EditText keywE;
    private EditText keywTS;

    private TextView iupacA_label;
    private TextView iupacB_label;
    private TextView iupacC_label;
    private TextView iupacD_label;
    private TextView iupacE_label;

    private EditText iupacA;
    private EditText iupacB;
    private EditText iupacC;
    private EditText iupacD;
    private EditText iupacE;

    private TextView formulaA_label;
    private TextView formulaB_label;
    private TextView formulaC_label;
    private TextView formulaD_label;
    private TextView formulaE_label;

    private EditText formulaA;
    private EditText formulaB;
    private EditText formulaC;
    private EditText formulaD;
    private EditText formulaE;

    private TextView smiA_label;
    private TextView smiB_label;
    private TextView smiC_label;
    private TextView smiD_label;
    private TextView smiE_label;

    private EditText smiA;
    private EditText smiB;
    private EditText smiC;
    private EditText smiD;
    private EditText smiE;

    private Button AddTS;
    private Button AddTSi;
    private Button ResetTS;
    private Button processBiTri;
    private Button quit;
    public Button A_opsin;
    public Button B_opsin;
    public Button C_opsin;
    public Button D_opsin;
    public Button E_opsin;

    private TextView TSLabel;
    private TextView TS;

    private Handler handler = new Handler();

    private static final int READ_FILE1 = 1;
    private Uri documentUri1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kineticsbitri);

        methodA_label = (TextView) findViewById(R.id.methodA_label);
        methodB_label = (TextView) findViewById(R.id.methodB_label);
        methodC_label = (TextView) findViewById(R.id.methodC_label);
        methodD_label = (TextView) findViewById(R.id.methodD_label);
        methodE_label = (TextView) findViewById(R.id.methodE_label);
        methodTS_label = (TextView) findViewById(R.id.methodTS_label);

        methodA = (EditText) findViewById(R.id.methodA);
        methodB = (EditText) findViewById(R.id.methodB);
        methodC = (EditText) findViewById(R.id.methodC);
        methodD = (EditText) findViewById(R.id.methodD);
        methodE = (EditText) findViewById(R.id.methodE);
        methodTS = (EditText) findViewById(R.id.methodTS);

        keywA_label = (TextView) findViewById(R.id.keywA_label);
        keywB_label = (TextView) findViewById(R.id.keywB_label);
        keywC_label = (TextView) findViewById(R.id.keywC_label);
        keywD_label = (TextView) findViewById(R.id.keywD_label);
        keywE_label = (TextView) findViewById(R.id.keywE_label);
        keywTS_label = (TextView) findViewById(R.id.keywTS_label);

        keywA = (EditText) findViewById(R.id.keywA);
        keywB = (EditText) findViewById(R.id.keywB);
        keywC = (EditText) findViewById(R.id.keywC);
        keywD = (EditText) findViewById(R.id.keywD);
        keywE = (EditText) findViewById(R.id.keywE);
        keywTS = (EditText) findViewById(R.id.keywTS);

        iupacA_label = (TextView) findViewById(R.id.iupacA_label);
        iupacB_label = (TextView) findViewById(R.id.iupacB_label);
        iupacC_label = (TextView) findViewById(R.id.iupacC_label);
        iupacD_label = (TextView) findViewById(R.id.iupacD_label);
        iupacE_label = (TextView) findViewById(R.id.iupacE_label);

        iupacA = (EditText) findViewById(R.id.iupacA);
        iupacB = (EditText) findViewById(R.id.iupacB);
        iupacC = (EditText) findViewById(R.id.iupacC);
        iupacD = (EditText) findViewById(R.id.iupacD);
        iupacE = (EditText) findViewById(R.id.iupacE);

        formulaA_label = (TextView) findViewById(R.id.formulaA_label);
        formulaB_label = (TextView) findViewById(R.id.formulaB_label);
        formulaC_label = (TextView) findViewById(R.id.formulaC_label);
        formulaD_label = (TextView) findViewById(R.id.formulaD_label);
        formulaE_label = (TextView) findViewById(R.id.formulaE_label);

        formulaA = (EditText) findViewById(R.id.formulaA);
        formulaB = (EditText) findViewById(R.id.formulaB);
        formulaC = (EditText) findViewById(R.id.formulaC);
        formulaD = (EditText) findViewById(R.id.formulaD);
        formulaE = (EditText) findViewById(R.id.formulaE);

        smiA_label = (TextView) findViewById(R.id.smiA_label);
        smiB_label = (TextView) findViewById(R.id.smiB_label);
        smiC_label = (TextView) findViewById(R.id.smiC_label);
        smiD_label = (TextView) findViewById(R.id.smiD_label);
        smiE_label = (TextView) findViewById(R.id.smiE_label);

        smiA = (EditText) findViewById(R.id.smiA);
        smiB = (EditText) findViewById(R.id.smiB);
        smiC = (EditText) findViewById(R.id.smiC);
        smiD = (EditText) findViewById(R.id.smiD);
        smiE = (EditText) findViewById(R.id.smiE);

        TSLabel = (TextView) findViewById(R.id.TSLabel);
        TS = (TextView) findViewById(R.id.TS);

        AddTS = (Button) findViewById(R.id.AddTS);
        AddTS.setOnClickListener(AddTSClick);
        AddTSi = (Button) findViewById(R.id.AddTSi);
        AddTSi.setOnClickListener(AddTSiClick);
        ResetTS = (Button) findViewById(R.id.ResetTS);
        ResetTS.setOnClickListener(ResetTSClick);
        processBiTri = (Button) findViewById(R.id.processBiTri);
        processBiTri.setOnClickListener(processBiTriClick);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(QuitClick);

        A_opsin = (Button) findViewById(R.id.A_opsin);
        A_opsin.setOnClickListener(A_opsin_click);
        B_opsin = (Button) findViewById(R.id.B_opsin);
        B_opsin.setOnClickListener(B_opsin_click);
        C_opsin = (Button) findViewById(R.id.C_opsin);
        C_opsin.setOnClickListener(C_opsin_click);
        D_opsin = (Button) findViewById(R.id.D_opsin);
        D_opsin.setOnClickListener(D_opsin_click);
        E_opsin = (Button) findViewById(R.id.E_opsin);
        E_opsin.setOnClickListener(E_opsin_click);

    }

    public void onStart()
    {
        super.onStart();
        MethodADisplay(exec("cat "+getFilesDir()+"/BiTri_methodA.txt"));
        MethodBDisplay(exec("cat "+getFilesDir()+"/BiTri_methodB.txt"));
        MethodCDisplay(exec("cat "+getFilesDir()+"/BiTri_methodC.txt"));
        MethodDDisplay(exec("cat "+getFilesDir()+"/BiTri_methodD.txt"));
        MethodEDisplay(exec("cat "+getFilesDir()+"/BiTri_methodE.txt"));
        MethodTSDisplay(exec("cat "+getFilesDir()+"/BiTri_methodTS.txt"));
        KeywADisplay(exec("cat "+getFilesDir()+"/BiTri_keywA.txt"));
        KeywBDisplay(exec("cat "+getFilesDir()+"/BiTri_keywB.txt"));
        KeywCDisplay(exec("cat "+getFilesDir()+"/BiTri_keywC.txt"));
        KeywDDisplay(exec("cat "+getFilesDir()+"/BiTri_keywD.txt"));
        KeywEDisplay(exec("cat "+getFilesDir()+"/BiTri_keywE.txt"));
        KeywTSDisplay(exec("cat "+getFilesDir()+"/BiTri_keywTS.txt"));
        IupacADisplay(exec("cat "+getFilesDir()+"/BiTri_iupacA.txt"));
        IupacBDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacB.txt"));
        IupacCDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacC.txt"));
        IupacDDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacD.txt"));
        IupacEDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacE.txt"));
        FormulaADisplay(exec("cat "+getFilesDir()+"/BiTri_formulaA.txt"));
        FormulaBDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaB.txt"));
        FormulaCDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaC.txt"));
        FormulaDDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaD.txt"));
        FormulaEDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaE.txt"));
        SmilesADisplay(exec("cat "+getFilesDir()+"/BiTri_smilesA.txt"));
        SmilesBDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesB.txt"));
        SmilesCDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesC.txt"));
        SmilesDDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesD.txt"));
        SmilesEDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesE.txt"));

        File filePathTS = new File(getFilesDir()+File.separator+"BiTri_TS.txt");
        if (!filePathTS.exists()) {
            try {
                FileOutputStream fileoutTS = openFileOutput("BiTri_TS_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                outputWriterTS.write("Transition state XYZ coordinate file not selected.");
                outputWriterTS.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutTS = openFileOutput("BiTri_TS_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                outputWriterTS.write("Transition state XYZ coordinate file is available.");
                outputWriterTS.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        TS_StatusDisplay(exec("cat "+getFilesDir()+"/BiTri_TS_status.txt"));
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

                String InputfileB = smiB.getText().toString();
                String InputfileName0B = iupacB.getText().toString();
                String MethodfileB = methodB.getText().toString();
                String KeywordsfileB = keywB.getText().toString();
                String FormulafileB = formulaB.getText().toString();

                String InputfileC = smiC.getText().toString();
                String InputfileName0C = iupacC.getText().toString();
                String MethodfileC = methodC.getText().toString();
                String KeywordsfileC = keywC.getText().toString();
                String FormulafileC = formulaC.getText().toString();

                String InputfileD = smiD.getText().toString();
                String InputfileName0D = iupacD.getText().toString();
                String MethodfileD = methodD.getText().toString();
                String KeywordsfileD = keywD.getText().toString();
                String FormulafileD = formulaD.getText().toString();

                String InputfileE = smiE.getText().toString();
                String InputfileName0E = iupacE.getText().toString();
                String MethodfileE = methodE.getText().toString();
                String KeywordsfileE = keywE.getText().toString();
                String FormulafileE = formulaE.getText().toString();

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("BiTri_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("BiTri_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("BiTri_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("BiTri_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("BiTri_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("BiTri_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("BiTri_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("BiTri_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("BiTri_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("BiTri_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("BiTri_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("BiTri_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("BiTri_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("BiTri_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("BiTri_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout30 = openFileOutput("BiTri_smilesD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter30 = new OutputStreamWriter(fileout30);
                    outputWriter30.write(InputfileD);
                    outputWriter30.close();
                    FileOutputStream fileout32 = openFileOutput("BiTri_methodD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter32 = new OutputStreamWriter(fileout32);
                    outputWriter32.write(MethodfileD);
                    outputWriter32.close();
                    FileOutputStream fileout33 = openFileOutput("BiTri_iupacD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter33 = new OutputStreamWriter(fileout33);
                    outputWriter33.write(InputfileName0D);
                    outputWriter33.close();
                    FileOutputStream fileout38 = openFileOutput("BiTri_formulaD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter38 = new OutputStreamWriter(fileout38);
                    outputWriter38.write(FormulafileD);
                    outputWriter38.close();
                    FileOutputStream fileout36 = openFileOutput("BiTri_keywD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter36 = new OutputStreamWriter(fileout36);
                    outputWriter36.write(KeywordsfileD);
                    outputWriter36.close();

                    FileOutputStream fileout130 = openFileOutput("BiTri_smilesE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter130 = new OutputStreamWriter(fileout130);
                    outputWriter130.write(InputfileE);
                    outputWriter130.close();
                    FileOutputStream fileout132 = openFileOutput("BiTri_methodE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter132 = new OutputStreamWriter(fileout132);
                    outputWriter132.write(MethodfileE);
                    outputWriter132.close();
                    FileOutputStream fileout133 = openFileOutput("BiTri_iupacE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter133 = new OutputStreamWriter(fileout133);
                    outputWriter133.write(InputfileName0E);
                    outputWriter133.close();
                    FileOutputStream fileout138 = openFileOutput("BiTri_formulaE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter138 = new OutputStreamWriter(fileout138);
                    outputWriter138.write(FormulafileE);
                    outputWriter138.close();
                    FileOutputStream fileout136 = openFileOutput("BiTri_keywE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter136 = new OutputStreamWriter(fileout136);
                    outputWriter136.write(KeywordsfileE);
                    outputWriter136.close();

                    FileOutputStream fileout42 = openFileOutput("BiTri_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("BiTri_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN CONTINUE ////////////////////////////////

                // TODO Auto-generated method stub //
                progressDialog = new ProgressDialog(KineticsBiTri.this);
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
                            FileOutputStream fileout3 = openFileOutput("BiTri_smilesA.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(smiles);
                            outputWriter3.close();
//                            FileOutputStream fileoutNts = openFileOutput("BiTri_iupacA.txt", MODE_PRIVATE);
//                            OutputStreamWriter outputWriterNts = new OutputStreamWriter(fileoutNts);
//                            outputWriterNts.write(NameToConvert);
//                            outputWriterNts.close();
                            MethodADisplay(exec("cat "+getFilesDir()+"/BiTri_methodA.txt"));
                            MethodBDisplay(exec("cat "+getFilesDir()+"/BiTri_methodB.txt"));
                            MethodCDisplay(exec("cat "+getFilesDir()+"/BiTri_methodC.txt"));
                            MethodDDisplay(exec("cat "+getFilesDir()+"/BiTri_methodD.txt"));
                            MethodEDisplay(exec("cat "+getFilesDir()+"/BiTri_methodE.txt"));
                            MethodTSDisplay(exec("cat "+getFilesDir()+"/BiTri_methodTS.txt"));
                            KeywADisplay(exec("cat "+getFilesDir()+"/BiTri_keywA.txt"));
                            KeywBDisplay(exec("cat "+getFilesDir()+"/BiTri_keywB.txt"));
                            KeywCDisplay(exec("cat "+getFilesDir()+"/BiTri_keywC.txt"));
                            KeywDDisplay(exec("cat "+getFilesDir()+"/BiTri_keywD.txt"));
                            KeywEDisplay(exec("cat "+getFilesDir()+"/BiTri_keywE.txt"));
                            KeywTSDisplay(exec("cat "+getFilesDir()+"/BiTri_keywTS.txt"));
                            IupacADisplay(exec("cat "+getFilesDir()+"/BiTri_iupacA.txt"));
                            IupacBDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacB.txt"));
                            IupacCDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacC.txt"));
                            IupacDDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacD.txt"));
                            IupacEDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacE.txt"));
                            FormulaADisplay(exec("cat "+getFilesDir()+"/BiTri_formulaA.txt"));
                            FormulaBDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaB.txt"));
                            FormulaCDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaC.txt"));
                            FormulaDDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaD.txt"));
                            FormulaEDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaE.txt"));
                            SmilesADisplay(exec("cat "+getFilesDir()+"/BiTri_smilesA.txt"));
                            SmilesBDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesB.txt"));
                            SmilesCDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesC.txt"));
                            SmilesDDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesD.txt"));
                            SmilesEDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesE.txt"));

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

    private View.OnClickListener B_opsin_click; {

        B_opsin_click = new View.OnClickListener() {
            public void onClick(View v) {
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

                String InputfileC = smiC.getText().toString();
                String InputfileName0C = iupacC.getText().toString();
                String MethodfileC = methodC.getText().toString();
                String KeywordsfileC = keywC.getText().toString();
                String FormulafileC = formulaC.getText().toString();

                String InputfileD = smiD.getText().toString();
                String InputfileName0D = iupacD.getText().toString();
                String MethodfileD = methodD.getText().toString();
                String KeywordsfileD = keywD.getText().toString();
                String FormulafileD = formulaD.getText().toString();

                String InputfileE = smiE.getText().toString();
                String InputfileName0E = iupacE.getText().toString();
                String MethodfileE = methodE.getText().toString();
                String KeywordsfileE = keywE.getText().toString();
                String FormulafileE = formulaE.getText().toString();

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("BiTri_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("BiTri_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("BiTri_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("BiTri_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("BiTri_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("BiTri_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("BiTri_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("BiTri_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("BiTri_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("BiTri_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("BiTri_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("BiTri_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("BiTri_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("BiTri_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("BiTri_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout30 = openFileOutput("BiTri_smilesD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter30 = new OutputStreamWriter(fileout30);
                    outputWriter30.write(InputfileD);
                    outputWriter30.close();
                    FileOutputStream fileout32 = openFileOutput("BiTri_methodD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter32 = new OutputStreamWriter(fileout32);
                    outputWriter32.write(MethodfileD);
                    outputWriter32.close();
                    FileOutputStream fileout33 = openFileOutput("BiTri_iupacD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter33 = new OutputStreamWriter(fileout33);
                    outputWriter33.write(InputfileName0D);
                    outputWriter33.close();
                    FileOutputStream fileout38 = openFileOutput("BiTri_formulaD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter38 = new OutputStreamWriter(fileout38);
                    outputWriter38.write(FormulafileD);
                    outputWriter38.close();
                    FileOutputStream fileout36 = openFileOutput("BiTri_keywD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter36 = new OutputStreamWriter(fileout36);
                    outputWriter36.write(KeywordsfileD);
                    outputWriter36.close();

                    FileOutputStream fileout130 = openFileOutput("BiTri_smilesE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter130 = new OutputStreamWriter(fileout130);
                    outputWriter130.write(InputfileE);
                    outputWriter130.close();
                    FileOutputStream fileout132 = openFileOutput("BiTri_methodE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter132 = new OutputStreamWriter(fileout132);
                    outputWriter132.write(MethodfileE);
                    outputWriter132.close();
                    FileOutputStream fileout133 = openFileOutput("BiTri_iupacE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter133 = new OutputStreamWriter(fileout133);
                    outputWriter133.write(InputfileName0E);
                    outputWriter133.close();
                    FileOutputStream fileout138 = openFileOutput("BiTri_formulaE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter138 = new OutputStreamWriter(fileout138);
                    outputWriter138.write(FormulafileE);
                    outputWriter138.close();
                    FileOutputStream fileout136 = openFileOutput("BiTri_keywE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter136 = new OutputStreamWriter(fileout136);
                    outputWriter136.write(KeywordsfileE);
                    outputWriter136.close();

                    FileOutputStream fileout42 = openFileOutput("BiTri_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("BiTri_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN CONTINUE ////////////////////////////////

                // TODO Auto-generated method stub //
                progressDialog = new ProgressDialog(KineticsBiTri.this);
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
                            String NameToConvert = iupacB.getText().toString();
                            ////////////////////////////////////
                            NameToStructure nts = NameToStructure.getInstance();
                            NameToStructureConfig ntsconfig = new NameToStructureConfig();
//a new NameToStructureConfig starts as a copy of OPSIN's default configuration
                            ntsconfig.setAllowRadicals(true);
//                OpsinResult result = nts.parseChemicalName("acetamide", ntsconfig);
                            OpsinResult result = nts.parseChemicalName(NameToConvert+"", ntsconfig);
                            String smiles = result.getSmiles();
                            /////////////////////////////////////
                            FileOutputStream fileout3 = openFileOutput("BiTri_smilesB.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(smiles);
                            outputWriter3.close();
//                            FileOutputStream fileoutNts = openFileOutput("BiTri_iupacB.txt", MODE_PRIVATE);
//                            OutputStreamWriter outputWriterNts = new OutputStreamWriter(fileoutNts);
//                            outputWriterNts.write(NameToConvert);
//                            outputWriterNts.close();
                            MethodADisplay(exec("cat "+getFilesDir()+"/BiTri_methodA.txt"));
                            MethodBDisplay(exec("cat "+getFilesDir()+"/BiTri_methodB.txt"));
                            MethodCDisplay(exec("cat "+getFilesDir()+"/BiTri_methodC.txt"));
                            MethodDDisplay(exec("cat "+getFilesDir()+"/BiTri_methodD.txt"));
                            MethodEDisplay(exec("cat "+getFilesDir()+"/BiTri_methodE.txt"));
                            MethodTSDisplay(exec("cat "+getFilesDir()+"/BiTri_methodTS.txt"));
                            KeywADisplay(exec("cat "+getFilesDir()+"/BiTri_keywA.txt"));
                            KeywBDisplay(exec("cat "+getFilesDir()+"/BiTri_keywB.txt"));
                            KeywCDisplay(exec("cat "+getFilesDir()+"/BiTri_keywC.txt"));
                            KeywDDisplay(exec("cat "+getFilesDir()+"/BiTri_keywD.txt"));
                            KeywEDisplay(exec("cat "+getFilesDir()+"/BiTri_keywE.txt"));
                            KeywTSDisplay(exec("cat "+getFilesDir()+"/BiTri_keywTS.txt"));
                            IupacADisplay(exec("cat "+getFilesDir()+"/BiTri_iupacA.txt"));
                            IupacBDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacB.txt"));
                            IupacCDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacC.txt"));
                            IupacDDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacD.txt"));
                            IupacEDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacE.txt"));
                            FormulaADisplay(exec("cat "+getFilesDir()+"/BiTri_formulaA.txt"));
                            FormulaBDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaB.txt"));
                            FormulaCDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaC.txt"));
                            FormulaDDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaD.txt"));
                            FormulaEDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaE.txt"));
                            SmilesADisplay(exec("cat "+getFilesDir()+"/BiTri_smilesA.txt"));
                            SmilesBDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesB.txt"));
                            SmilesCDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesC.txt"));
                            SmilesDDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesD.txt"));
                            SmilesEDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesE.txt"));

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

    private View.OnClickListener C_opsin_click; {

        A_opsin_click = new View.OnClickListener() {
            public void onClick(View v) {
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

                String InputfileC = smiC.getText().toString();
                String InputfileName0C = iupacC.getText().toString();
                String MethodfileC = methodC.getText().toString();
                String KeywordsfileC = keywC.getText().toString();
                String FormulafileC = formulaC.getText().toString();

                String InputfileD = smiD.getText().toString();
                String InputfileName0D = iupacD.getText().toString();
                String MethodfileD = methodD.getText().toString();
                String KeywordsfileD = keywD.getText().toString();
                String FormulafileD = formulaD.getText().toString();

                String InputfileE = smiE.getText().toString();
                String InputfileName0E = iupacE.getText().toString();
                String MethodfileE = methodE.getText().toString();
                String KeywordsfileE = keywE.getText().toString();
                String FormulafileE = formulaE.getText().toString();

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("BiTri_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("BiTri_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("BiTri_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("BiTri_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("BiTri_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("BiTri_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("BiTri_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("BiTri_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("BiTri_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("BiTri_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("BiTri_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("BiTri_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("BiTri_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("BiTri_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("BiTri_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout30 = openFileOutput("BiTri_smilesD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter30 = new OutputStreamWriter(fileout30);
                    outputWriter30.write(InputfileD);
                    outputWriter30.close();
                    FileOutputStream fileout32 = openFileOutput("BiTri_methodD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter32 = new OutputStreamWriter(fileout32);
                    outputWriter32.write(MethodfileD);
                    outputWriter32.close();
                    FileOutputStream fileout33 = openFileOutput("BiTri_iupacD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter33 = new OutputStreamWriter(fileout33);
                    outputWriter33.write(InputfileName0D);
                    outputWriter33.close();
                    FileOutputStream fileout38 = openFileOutput("BiTri_formulaD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter38 = new OutputStreamWriter(fileout38);
                    outputWriter38.write(FormulafileD);
                    outputWriter38.close();
                    FileOutputStream fileout36 = openFileOutput("BiTri_keywD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter36 = new OutputStreamWriter(fileout36);
                    outputWriter36.write(KeywordsfileD);
                    outputWriter36.close();

                    FileOutputStream fileout130 = openFileOutput("BiTri_smilesE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter130 = new OutputStreamWriter(fileout130);
                    outputWriter130.write(InputfileE);
                    outputWriter130.close();
                    FileOutputStream fileout132 = openFileOutput("BiTri_methodE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter132 = new OutputStreamWriter(fileout132);
                    outputWriter132.write(MethodfileE);
                    outputWriter132.close();
                    FileOutputStream fileout133 = openFileOutput("BiTri_iupacE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter133 = new OutputStreamWriter(fileout133);
                    outputWriter133.write(InputfileName0E);
                    outputWriter133.close();
                    FileOutputStream fileout138 = openFileOutput("BiTri_formulaE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter138 = new OutputStreamWriter(fileout138);
                    outputWriter138.write(FormulafileE);
                    outputWriter138.close();
                    FileOutputStream fileout136 = openFileOutput("BiTri_keywE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter136 = new OutputStreamWriter(fileout136);
                    outputWriter136.write(KeywordsfileE);
                    outputWriter136.close();

                    FileOutputStream fileout42 = openFileOutput("BiTri_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("BiTri_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN CONTINUE ////////////////////////////////

                // TODO Auto-generated method stub //
                progressDialog = new ProgressDialog(KineticsBiTri.this);
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
                            String NameToConvert = iupacC.getText().toString();
                            ////////////////////////////////////
                            NameToStructure nts = NameToStructure.getInstance();
                            NameToStructureConfig ntsconfig = new NameToStructureConfig();
//a new NameToStructureConfig starts as a copy of OPSIN's default configuration
                            ntsconfig.setAllowRadicals(true);
//                OpsinResult result = nts.parseChemicalName("acetamide", ntsconfig);
                            OpsinResult result = nts.parseChemicalName(NameToConvert+"", ntsconfig);
                            String smiles = result.getSmiles();
                            /////////////////////////////////////
                            FileOutputStream fileout3 = openFileOutput("BiTri_smilesC.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(smiles);
                            outputWriter3.close();
//                            FileOutputStream fileoutNts = openFileOutput("BiTri_iupacC.txt", MODE_PRIVATE);
//                            OutputStreamWriter outputWriterNts = new OutputStreamWriter(fileoutNts);
//                            outputWriterNts.write(NameToConvert);
//                            outputWriterNts.close();
                            MethodADisplay(exec("cat "+getFilesDir()+"/BiTri_methodA.txt"));
                            MethodBDisplay(exec("cat "+getFilesDir()+"/BiTri_methodB.txt"));
                            MethodCDisplay(exec("cat "+getFilesDir()+"/BiTri_methodC.txt"));
                            MethodDDisplay(exec("cat "+getFilesDir()+"/BiTri_methodD.txt"));
                            MethodEDisplay(exec("cat "+getFilesDir()+"/BiTri_methodE.txt"));
                            MethodTSDisplay(exec("cat "+getFilesDir()+"/BiTri_methodTS.txt"));
                            KeywADisplay(exec("cat "+getFilesDir()+"/BiTri_keywA.txt"));
                            KeywBDisplay(exec("cat "+getFilesDir()+"/BiTri_keywB.txt"));
                            KeywCDisplay(exec("cat "+getFilesDir()+"/BiTri_keywC.txt"));
                            KeywDDisplay(exec("cat "+getFilesDir()+"/BiTri_keywD.txt"));
                            KeywEDisplay(exec("cat "+getFilesDir()+"/BiTri_keywE.txt"));
                            KeywTSDisplay(exec("cat "+getFilesDir()+"/BiTri_keywTS.txt"));
                            IupacADisplay(exec("cat "+getFilesDir()+"/BiTri_iupacA.txt"));
                            IupacBDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacB.txt"));
                            IupacCDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacC.txt"));
                            IupacDDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacD.txt"));
                            IupacEDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacE.txt"));
                            FormulaADisplay(exec("cat "+getFilesDir()+"/BiTri_formulaA.txt"));
                            FormulaBDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaB.txt"));
                            FormulaCDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaC.txt"));
                            FormulaDDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaD.txt"));
                            FormulaEDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaE.txt"));
                            SmilesADisplay(exec("cat "+getFilesDir()+"/BiTri_smilesA.txt"));
                            SmilesBDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesB.txt"));
                            SmilesCDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesC.txt"));
                            SmilesDDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesD.txt"));
                            SmilesEDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesE.txt"));

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

    private View.OnClickListener D_opsin_click; {

        D_opsin_click = new View.OnClickListener() {
            public void onClick(View v) {
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

                String InputfileC = smiC.getText().toString();
                String InputfileName0C = iupacC.getText().toString();
                String MethodfileC = methodC.getText().toString();
                String KeywordsfileC = keywC.getText().toString();
                String FormulafileC = formulaC.getText().toString();

                String InputfileD = smiD.getText().toString();
                String InputfileName0D = iupacD.getText().toString();
                String MethodfileD = methodD.getText().toString();
                String KeywordsfileD = keywD.getText().toString();
                String FormulafileD = formulaD.getText().toString();

                String InputfileE = smiE.getText().toString();
                String InputfileName0E = iupacE.getText().toString();
                String MethodfileE = methodE.getText().toString();
                String KeywordsfileE = keywE.getText().toString();
                String FormulafileE = formulaE.getText().toString();

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("BiTri_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("BiTri_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("BiTri_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("BiTri_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("BiTri_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("BiTri_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("BiTri_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("BiTri_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("BiTri_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("BiTri_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("BiTri_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("BiTri_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("BiTri_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("BiTri_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("BiTri_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout30 = openFileOutput("BiTri_smilesD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter30 = new OutputStreamWriter(fileout30);
                    outputWriter30.write(InputfileD);
                    outputWriter30.close();
                    FileOutputStream fileout32 = openFileOutput("BiTri_methodD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter32 = new OutputStreamWriter(fileout32);
                    outputWriter32.write(MethodfileD);
                    outputWriter32.close();
                    FileOutputStream fileout33 = openFileOutput("BiTri_iupacD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter33 = new OutputStreamWriter(fileout33);
                    outputWriter33.write(InputfileName0D);
                    outputWriter33.close();
                    FileOutputStream fileout38 = openFileOutput("BiTri_formulaD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter38 = new OutputStreamWriter(fileout38);
                    outputWriter38.write(FormulafileD);
                    outputWriter38.close();
                    FileOutputStream fileout36 = openFileOutput("BiTri_keywD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter36 = new OutputStreamWriter(fileout36);
                    outputWriter36.write(KeywordsfileD);
                    outputWriter36.close();

                    FileOutputStream fileout130 = openFileOutput("BiTri_smilesE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter130 = new OutputStreamWriter(fileout130);
                    outputWriter130.write(InputfileE);
                    outputWriter130.close();
                    FileOutputStream fileout132 = openFileOutput("BiTri_methodE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter132 = new OutputStreamWriter(fileout132);
                    outputWriter132.write(MethodfileE);
                    outputWriter132.close();
                    FileOutputStream fileout133 = openFileOutput("BiTri_iupacE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter133 = new OutputStreamWriter(fileout133);
                    outputWriter133.write(InputfileName0E);
                    outputWriter133.close();
                    FileOutputStream fileout138 = openFileOutput("BiTri_formulaE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter138 = new OutputStreamWriter(fileout138);
                    outputWriter138.write(FormulafileE);
                    outputWriter138.close();
                    FileOutputStream fileout136 = openFileOutput("BiTri_keywE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter136 = new OutputStreamWriter(fileout136);
                    outputWriter136.write(KeywordsfileE);
                    outputWriter136.close();

                    FileOutputStream fileout42 = openFileOutput("BiTri_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("BiTri_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN CONTINUE ////////////////////////////////

                // TODO Auto-generated method stub //
                progressDialog = new ProgressDialog(KineticsBiTri.this);
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
                            String NameToConvert = iupacD.getText().toString();
                            ////////////////////////////////////
                            NameToStructure nts = NameToStructure.getInstance();
                            NameToStructureConfig ntsconfig = new NameToStructureConfig();
//a new NameToStructureConfig starts as a copy of OPSIN's default configuration
                            ntsconfig.setAllowRadicals(true);
//                OpsinResult result = nts.parseChemicalName("acetamide", ntsconfig);
                            OpsinResult result = nts.parseChemicalName(NameToConvert+"", ntsconfig);
                            String smiles = result.getSmiles();
                            /////////////////////////////////////
                            FileOutputStream fileout3 = openFileOutput("BiTri_smilesD.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(smiles);
                            outputWriter3.close();
//                            FileOutputStream fileoutNts = openFileOutput("BiTri_iupacD.txt", MODE_PRIVATE);
//                            OutputStreamWriter outputWriterNts = new OutputStreamWriter(fileoutNts);
//                            outputWriterNts.write(NameToConvert);
//                            outputWriterNts.close();
                            MethodADisplay(exec("cat "+getFilesDir()+"/BiTri_methodA.txt"));
                            MethodBDisplay(exec("cat "+getFilesDir()+"/BiTri_methodB.txt"));
                            MethodCDisplay(exec("cat "+getFilesDir()+"/BiTri_methodC.txt"));
                            MethodDDisplay(exec("cat "+getFilesDir()+"/BiTri_methodD.txt"));
                            MethodEDisplay(exec("cat "+getFilesDir()+"/BiTri_methodE.txt"));
                            MethodTSDisplay(exec("cat "+getFilesDir()+"/BiTri_methodTS.txt"));
                            KeywADisplay(exec("cat "+getFilesDir()+"/BiTri_keywA.txt"));
                            KeywBDisplay(exec("cat "+getFilesDir()+"/BiTri_keywB.txt"));
                            KeywCDisplay(exec("cat "+getFilesDir()+"/BiTri_keywC.txt"));
                            KeywDDisplay(exec("cat "+getFilesDir()+"/BiTri_keywD.txt"));
                            KeywEDisplay(exec("cat "+getFilesDir()+"/BiTri_keywE.txt"));
                            KeywTSDisplay(exec("cat "+getFilesDir()+"/BiTri_keywTS.txt"));
                            IupacADisplay(exec("cat "+getFilesDir()+"/BiTri_iupacA.txt"));
                            IupacBDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacB.txt"));
                            IupacCDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacC.txt"));
                            IupacDDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacD.txt"));
                            IupacEDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacE.txt"));
                            FormulaADisplay(exec("cat "+getFilesDir()+"/BiTri_formulaA.txt"));
                            FormulaBDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaB.txt"));
                            FormulaCDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaC.txt"));
                            FormulaDDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaD.txt"));
                            FormulaEDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaE.txt"));
                            SmilesADisplay(exec("cat "+getFilesDir()+"/BiTri_smilesA.txt"));
                            SmilesBDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesB.txt"));
                            SmilesCDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesC.txt"));
                            SmilesDDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesD.txt"));
                            SmilesEDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesE.txt"));

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

    private View.OnClickListener E_opsin_click; {

        E_opsin_click = new View.OnClickListener() {
            public void onClick(View v) {
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

                String InputfileC = smiC.getText().toString();
                String InputfileName0C = iupacC.getText().toString();
                String MethodfileC = methodC.getText().toString();
                String KeywordsfileC = keywC.getText().toString();
                String FormulafileC = formulaC.getText().toString();

                String InputfileD = smiD.getText().toString();
                String InputfileName0D = iupacD.getText().toString();
                String MethodfileD = methodD.getText().toString();
                String KeywordsfileD = keywD.getText().toString();
                String FormulafileD = formulaD.getText().toString();

                String InputfileE = smiE.getText().toString();
                String InputfileName0E = iupacE.getText().toString();
                String MethodfileE = methodE.getText().toString();
                String KeywordsfileE = keywE.getText().toString();
                String FormulafileE = formulaE.getText().toString();

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("BiTri_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("BiTri_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("BiTri_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("BiTri_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("BiTri_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("BiTri_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("BiTri_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("BiTri_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("BiTri_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("BiTri_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("BiTri_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("BiTri_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("BiTri_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("BiTri_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("BiTri_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout30 = openFileOutput("BiTri_smilesD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter30 = new OutputStreamWriter(fileout30);
                    outputWriter30.write(InputfileD);
                    outputWriter30.close();
                    FileOutputStream fileout32 = openFileOutput("BiTri_methodD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter32 = new OutputStreamWriter(fileout32);
                    outputWriter32.write(MethodfileD);
                    outputWriter32.close();
                    FileOutputStream fileout33 = openFileOutput("BiTri_iupacD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter33 = new OutputStreamWriter(fileout33);
                    outputWriter33.write(InputfileName0D);
                    outputWriter33.close();
                    FileOutputStream fileout38 = openFileOutput("BiTri_formulaD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter38 = new OutputStreamWriter(fileout38);
                    outputWriter38.write(FormulafileD);
                    outputWriter38.close();
                    FileOutputStream fileout36 = openFileOutput("BiTri_keywD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter36 = new OutputStreamWriter(fileout36);
                    outputWriter36.write(KeywordsfileD);
                    outputWriter36.close();

                    FileOutputStream fileout130 = openFileOutput("BiTri_smilesE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter130 = new OutputStreamWriter(fileout130);
                    outputWriter130.write(InputfileE);
                    outputWriter130.close();
                    FileOutputStream fileout132 = openFileOutput("BiTri_methodE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter132 = new OutputStreamWriter(fileout132);
                    outputWriter132.write(MethodfileE);
                    outputWriter132.close();
                    FileOutputStream fileout133 = openFileOutput("BiTri_iupacE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter133 = new OutputStreamWriter(fileout133);
                    outputWriter133.write(InputfileName0E);
                    outputWriter133.close();
                    FileOutputStream fileout138 = openFileOutput("BiTri_formulaE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter138 = new OutputStreamWriter(fileout138);
                    outputWriter138.write(FormulafileE);
                    outputWriter138.close();
                    FileOutputStream fileout136 = openFileOutput("BiTri_keywE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter136 = new OutputStreamWriter(fileout136);
                    outputWriter136.write(KeywordsfileE);
                    outputWriter136.close();

                    FileOutputStream fileout42 = openFileOutput("BiTri_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("BiTri_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN CONTINUE ////////////////////////////////

                // TODO Auto-generated method stub //
                progressDialog = new ProgressDialog(KineticsBiTri.this);
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
                            String NameToConvert = iupacE.getText().toString();
                            ////////////////////////////////////
                            NameToStructure nts = NameToStructure.getInstance();
                            NameToStructureConfig ntsconfig = new NameToStructureConfig();
//a new NameToStructureConfig starts as a copy of OPSIN's default configuration
                            ntsconfig.setAllowRadicals(true);
//                OpsinResult result = nts.parseChemicalName("acetamide", ntsconfig);
                            OpsinResult result = nts.parseChemicalName(NameToConvert+"", ntsconfig);
                            String smiles = result.getSmiles();
                            /////////////////////////////////////
                            FileOutputStream fileout3 = openFileOutput("BiTri_smilesE.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(smiles);
                            outputWriter3.close();
//                            FileOutputStream fileoutNts = openFileOutput("BiTri_iupacE.txt", MODE_PRIVATE);
//                            OutputStreamWriter outputWriterNts = new OutputStreamWriter(fileoutNts);
//                            outputWriterNts.write(NameToConvert);
//                            outputWriterNts.close();
                            MethodADisplay(exec("cat "+getFilesDir()+"/BiTri_methodA.txt"));
                            MethodBDisplay(exec("cat "+getFilesDir()+"/BiTri_methodB.txt"));
                            MethodCDisplay(exec("cat "+getFilesDir()+"/BiTri_methodC.txt"));
                            MethodDDisplay(exec("cat "+getFilesDir()+"/BiTri_methodD.txt"));
                            MethodEDisplay(exec("cat "+getFilesDir()+"/BiTri_methodE.txt"));
                            MethodTSDisplay(exec("cat "+getFilesDir()+"/BiTri_methodTS.txt"));
                            KeywADisplay(exec("cat "+getFilesDir()+"/BiTri_keywA.txt"));
                            KeywBDisplay(exec("cat "+getFilesDir()+"/BiTri_keywB.txt"));
                            KeywCDisplay(exec("cat "+getFilesDir()+"/BiTri_keywC.txt"));
                            KeywDDisplay(exec("cat "+getFilesDir()+"/BiTri_keywD.txt"));
                            KeywEDisplay(exec("cat "+getFilesDir()+"/BiTri_keywE.txt"));
                            KeywTSDisplay(exec("cat "+getFilesDir()+"/BiTri_keywTS.txt"));
                            IupacADisplay(exec("cat "+getFilesDir()+"/BiTri_iupacA.txt"));
                            IupacBDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacB.txt"));
                            IupacCDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacC.txt"));
                            IupacDDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacD.txt"));
                            IupacEDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacE.txt"));
                            FormulaADisplay(exec("cat "+getFilesDir()+"/BiTri_formulaA.txt"));
                            FormulaBDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaB.txt"));
                            FormulaCDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaC.txt"));
                            FormulaDDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaD.txt"));
                            FormulaEDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaE.txt"));
                            SmilesADisplay(exec("cat "+getFilesDir()+"/BiTri_smilesA.txt"));
                            SmilesBDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesB.txt"));
                            SmilesCDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesC.txt"));
                            SmilesDDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesD.txt"));
                            SmilesEDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesE.txt"));

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

                String InputfileC = smiC.getText().toString();
                String InputfileName0C = iupacC.getText().toString();
                String MethodfileC = methodC.getText().toString();
                String KeywordsfileC = keywC.getText().toString();
                String FormulafileC = formulaC.getText().toString();

                String InputfileD = smiD.getText().toString();
                String InputfileName0D = iupacD.getText().toString();
                String MethodfileD = methodD.getText().toString();
                String KeywordsfileD = keywD.getText().toString();
                String FormulafileD = formulaD.getText().toString();

                String InputfileE = smiE.getText().toString();
                String InputfileName0E = iupacE.getText().toString();
                String MethodfileE = methodE.getText().toString();
                String KeywordsfileE = keywE.getText().toString();
                String FormulafileE = formulaE.getText().toString();

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("BiTri_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("BiTri_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("BiTri_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("BiTri_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("BiTri_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("BiTri_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("BiTri_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("BiTri_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("BiTri_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("BiTri_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("BiTri_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("BiTri_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("BiTri_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("BiTri_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("BiTri_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout30 = openFileOutput("BiTri_smilesD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter30 = new OutputStreamWriter(fileout30);
                    outputWriter30.write(InputfileD);
                    outputWriter30.close();
                    FileOutputStream fileout32 = openFileOutput("BiTri_methodD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter32 = new OutputStreamWriter(fileout32);
                    outputWriter32.write(MethodfileD);
                    outputWriter32.close();
                    FileOutputStream fileout33 = openFileOutput("BiTri_iupacD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter33 = new OutputStreamWriter(fileout33);
                    outputWriter33.write(InputfileName0D);
                    outputWriter33.close();
                    FileOutputStream fileout38 = openFileOutput("BiTri_formulaD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter38 = new OutputStreamWriter(fileout38);
                    outputWriter38.write(FormulafileD);
                    outputWriter38.close();
                    FileOutputStream fileout36 = openFileOutput("BiTri_keywD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter36 = new OutputStreamWriter(fileout36);
                    outputWriter36.write(KeywordsfileD);
                    outputWriter36.close();

                    FileOutputStream fileout130 = openFileOutput("BiTri_smilesE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter130 = new OutputStreamWriter(fileout130);
                    outputWriter130.write(InputfileE);
                    outputWriter130.close();
                    FileOutputStream fileout132 = openFileOutput("BiTri_methodE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter132 = new OutputStreamWriter(fileout132);
                    outputWriter132.write(MethodfileE);
                    outputWriter132.close();
                    FileOutputStream fileout133 = openFileOutput("BiTri_iupacE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter133 = new OutputStreamWriter(fileout133);
                    outputWriter133.write(InputfileName0E);
                    outputWriter133.close();
                    FileOutputStream fileout138 = openFileOutput("BiTri_formulaE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter138 = new OutputStreamWriter(fileout138);
                    outputWriter138.write(FormulafileE);
                    outputWriter138.close();
                    FileOutputStream fileout136 = openFileOutput("BiTri_keywE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter136 = new OutputStreamWriter(fileout136);
                    outputWriter136.write(KeywordsfileE);
                    outputWriter136.close();

                    FileOutputStream fileout42 = openFileOutput("BiTri_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("BiTri_keywTS.txt", MODE_PRIVATE);
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

                FileOutputStream fileout = openFileOutput("BiTri_TS.txt", MODE_PRIVATE);
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
                exec("rm "+getFilesDir()+"/BiTri_TS.txt");

                MethodADisplay(exec("cat "+getFilesDir()+"/BiTri_methodA.txt"));
                MethodBDisplay(exec("cat "+getFilesDir()+"/BiTri_methodB.txt"));
                MethodCDisplay(exec("cat "+getFilesDir()+"/BiTri_methodC.txt"));
                MethodDDisplay(exec("cat "+getFilesDir()+"/BiTri_methodD.txt"));
                MethodEDisplay(exec("cat "+getFilesDir()+"/BiTri_methodE.txt"));
                MethodTSDisplay(exec("cat "+getFilesDir()+"/BiTri_methodTS.txt"));
                KeywADisplay(exec("cat "+getFilesDir()+"/BiTri_keywA.txt"));
                KeywBDisplay(exec("cat "+getFilesDir()+"/BiTri_keywB.txt"));
                KeywCDisplay(exec("cat "+getFilesDir()+"/BiTri_keywC.txt"));
                KeywDDisplay(exec("cat "+getFilesDir()+"/BiTri_keywD.txt"));
                KeywEDisplay(exec("cat "+getFilesDir()+"/BiTri_keywE.txt"));
                KeywTSDisplay(exec("cat "+getFilesDir()+"/BiTri_keywTS.txt"));
                IupacADisplay(exec("cat "+getFilesDir()+"/BiTri_iupacA.txt"));
                IupacBDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacB.txt"));
                IupacCDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacC.txt"));
                IupacDDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacD.txt"));
                IupacEDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacE.txt"));
                FormulaADisplay(exec("cat "+getFilesDir()+"/BiTri_formulaA.txt"));
                FormulaBDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaB.txt"));
                FormulaCDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaC.txt"));
                FormulaDDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaD.txt"));
                FormulaEDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaE.txt"));
                SmilesADisplay(exec("cat "+getFilesDir()+"/BiTri_smilesA.txt"));
                SmilesBDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesB.txt"));
                SmilesCDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesC.txt"));
                SmilesDDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesD.txt"));
                SmilesEDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesE.txt"));

                File filePathTS = new File(getFilesDir()+File.separator+"BiTri_TS.txt");
                if (!filePathTS.exists()) {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("BiTri_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file not selected.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("BiTri_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file is available.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                TS_StatusDisplay(exec("cat "+getFilesDir()+"/BiTri_TS_status.txt"));
            }
        };
    }

    private View.OnClickListener processBiTriClick; {

        processBiTriClick = new View.OnClickListener() {
            public void onClick(View v) {

                String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
                progressDialog = new ProgressDialog(KineticsBiTri.this);
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
// update: resolved!, progressdialog is already working - see the comment at the end of new thread block
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
                    FileOutputStream fileout = openFileOutput("BiTri_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("BiTri_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("BiTri_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("BiTri_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("BiTri_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    String InputfileNameA1 = InputfileName0A.replace(" ","_");
		    String InputfileNameA = InputfileNameA1.replace(",",".");
                    exec("cp "+getFilesDir()+"/BiTri_smilesA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".smi");
                    exec("cp "+getFilesDir()+"/BiTri_iupacA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".iupac");
                    exec("cp "+getFilesDir()+"/BiTri_formulaA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".formula");
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

                    FileOutputStream fileout10 = openFileOutput("BiTri_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("BiTri_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("BiTri_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("BiTri_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("BiTri_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();


                    String InputfileNameB1 = InputfileName0B.replace(" ","_");
		    String InputfileNameB = InputfileNameB1.replace(",",".");
                    exec("cp "+getFilesDir()+"/BiTri_smilesB.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameB+".smi");
                    exec("cp "+getFilesDir()+"/BiTri_iupacB.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameB+".iupac");
                    exec("cp "+getFilesDir()+"/BiTri_formulaB.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameB+".formula");
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

                    /////////////////////////////////// C ///////////////////////////////////////////////
                    String InputfileC = smiC.getText().toString();
                    String InputfileName0C = iupacC.getText().toString();
                    String MethodfileC = methodC.getText().toString();
                    String KeywordsfileC = keywC.getText().toString();
                    String FormulafileC = formulaC.getText().toString();

                    FileOutputStream fileout20 = openFileOutput("BiTri_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("BiTri_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("BiTri_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("BiTri_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("BiTri_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();


                    String InputfileNameC1 = InputfileName0C.replace(" ","_");
		    String InputfileNameC = InputfileNameC1.replace(",",".");
                    exec("cp "+getFilesDir()+"/BiTri_smilesC.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameC+".smi");
                    exec("cp "+getFilesDir()+"/BiTri_iupacC.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameC+".iupac");
                    exec("cp "+getFilesDir()+"/BiTri_formulaC.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameC+".formula");
                    exec("chmod 755 -R "+getFilesDir());
                    String ObabelOutputC = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+File.separator+"openbabel"+File.separator+InputfileNameC+".smi -oxyz --gen3d");
                    FileOutputStream fileout24 = openFileOutput(InputfileNameC+".xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter24 = new OutputStreamWriter(fileout24);
                    outputWriter24.write(ObabelOutputC);
                    outputWriter24.close();
                    String KeyC = MethodfileC+" "+KeywordsfileC;

                    try {
                        String Sed22 = exec("sed -e 1,2d "+getFilesDir()+"/"+InputfileNameC+".xyz");
                        FileOutputStream fileout128 = openFileOutput(InputfileNameC+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter128 = new OutputStreamWriter(fileout128);
                        outputWriter128.write(KeyC);
                        outputWriter128.write("\n");
                        outputWriter128.write("\n");
                        outputWriter128.write("\n");
                        outputWriter128.write(Sed22);
                        outputWriter128.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/"+InputfileNameC+".mop "+getFilesDir()+File.separator+"openbabel/solv/opt/"+InputfileNameC);
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameC+".smi "+getFilesDir()+File.separator+"openbabel/smiles");
                    exec("mv "+getFilesDir()+"/"+InputfileNameC+".xyz "+getFilesDir()+File.separator+"openbabel/xyz");
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameC+".iupac "+getFilesDir()+File.separator+"openbabel/iupac");
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameC+".formula "+getFilesDir()+File.separator+"openbabel/formula");

                    /////////////////////////////////// D ///////////////////////////////////////////////
                    String InputfileD = smiD.getText().toString();
                    String InputfileName0D = iupacD.getText().toString();
                    String MethodfileD = methodD.getText().toString();
                    String KeywordsfileD = keywD.getText().toString();
                    String FormulafileD = formulaD.getText().toString();

                    FileOutputStream fileout30 = openFileOutput("BiTri_smilesD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter30 = new OutputStreamWriter(fileout30);
                    outputWriter30.write(InputfileD);
                    outputWriter30.close();
                    FileOutputStream fileout32 = openFileOutput("BiTri_methodD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter32 = new OutputStreamWriter(fileout32);
                    outputWriter32.write(MethodfileD);
                    outputWriter32.close();
                    FileOutputStream fileout33 = openFileOutput("BiTri_iupacD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter33 = new OutputStreamWriter(fileout33);
                    outputWriter33.write(InputfileName0D);
                    outputWriter33.close();
                    FileOutputStream fileout38 = openFileOutput("BiTri_formulaD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter38 = new OutputStreamWriter(fileout38);
                    outputWriter38.write(FormulafileD);
                    outputWriter38.close();
                    FileOutputStream fileout36 = openFileOutput("BiTri_keywD.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter36 = new OutputStreamWriter(fileout36);
                    outputWriter36.write(KeywordsfileD);
                    outputWriter36.close();


                    String InputfileNameD1 = InputfileName0D.replace(" ","_");
		    String InputfileNameD = InputfileNameD1.replace(",",".");
                    exec("cp "+getFilesDir()+"/BiTri_smilesD.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameD+".smi");
                    exec("cp "+getFilesDir()+"/BiTri_iupacD.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameD+".iupac");
                    exec("cp "+getFilesDir()+"/BiTri_formulaD.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameD+".formula");
                    exec("chmod 755 -R "+getFilesDir());
                    String ObabelOutputD = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+File.separator+"openbabel"+File.separator+InputfileNameD+".smi -oxyz --gen3d");
                    FileOutputStream fileout34 = openFileOutput(InputfileNameD+".xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter34 = new OutputStreamWriter(fileout34);
                    outputWriter34.write(ObabelOutputD);
                    outputWriter34.close();
                    String KeyD = MethodfileD+" "+KeywordsfileD;

                    try {
                        String Sed32 = exec("sed -e 1,2d "+getFilesDir()+"/"+InputfileNameD+".xyz");
                        FileOutputStream fileout138 = openFileOutput(InputfileNameD+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter138 = new OutputStreamWriter(fileout138);
                        outputWriter138.write(KeyD);
                        outputWriter138.write("\n");
                        outputWriter138.write("\n");
                        outputWriter138.write("\n");
                        outputWriter138.write(Sed32);
                        outputWriter138.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/"+InputfileNameD+".mop "+getFilesDir()+File.separator+"openbabel/solv/opt/"+InputfileNameD);
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameD+".smi "+getFilesDir()+File.separator+"openbabel/smiles");
                    exec("mv "+getFilesDir()+"/"+InputfileNameD+".xyz "+getFilesDir()+File.separator+"openbabel/xyz");
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameD+".iupac "+getFilesDir()+File.separator+"openbabel/iupac");
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameD+".formula "+getFilesDir()+File.separator+"openbabel/formula");

                    /////////////////////////////////// E ///////////////////////////////////////////////
                    String InputfileE = smiE.getText().toString();
                    String InputfileName0E = iupacE.getText().toString();
                    String MethodfileE = methodE.getText().toString();
                    String KeywordsfileE = keywE.getText().toString();
                    String FormulafileE = formulaE.getText().toString();

                    FileOutputStream fileout130 = openFileOutput("BiTri_smilesE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter130 = new OutputStreamWriter(fileout130);
                    outputWriter130.write(InputfileE);
                    outputWriter130.close();
                    FileOutputStream fileout132 = openFileOutput("BiTri_methodE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter132 = new OutputStreamWriter(fileout132);
                    outputWriter132.write(MethodfileE);
                    outputWriter132.close();
                    FileOutputStream fileout133 = openFileOutput("BiTri_iupacE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter133 = new OutputStreamWriter(fileout133);
                    outputWriter133.write(InputfileName0E);
                    outputWriter133.close();
                    FileOutputStream fileout138 = openFileOutput("BiTri_formulaE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter138 = new OutputStreamWriter(fileout138);
                    outputWriter138.write(FormulafileE);
                    outputWriter138.close();
                    FileOutputStream fileout136 = openFileOutput("BiTri_keywE.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter136 = new OutputStreamWriter(fileout136);
                    outputWriter136.write(KeywordsfileE);
                    outputWriter136.close();


                    String InputfileNameE1 = InputfileName0E.replace(" ","_");
		    String InputfileNameE = InputfileNameE1.replace(",",".");
                    exec("cp "+getFilesDir()+"/BiTri_smilesE.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameE+".smi");
                    exec("cp "+getFilesDir()+"/BiTri_iupacE.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameE+".iupac");
                    exec("cp "+getFilesDir()+"/BiTri_formulaE.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameE+".formula");
                    exec("chmod 755 -R "+getFilesDir());
                    String ObabelOutputE = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+File.separator+"openbabel"+File.separator+InputfileNameE+".smi -oxyz --gen3d");
                    FileOutputStream fileout134 = openFileOutput(InputfileNameE+".xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter134 = new OutputStreamWriter(fileout134);
                    outputWriter134.write(ObabelOutputE);
                    outputWriter134.close();
                    String KeyE = MethodfileE+" "+KeywordsfileE;

                    try {
                        String Sed132 = exec("sed -e 1,2d "+getFilesDir()+"/"+InputfileNameE+".xyz");
                        FileOutputStream fileout238 = openFileOutput(InputfileNameE+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter238 = new OutputStreamWriter(fileout238);
                        outputWriter238.write(KeyE);
                        outputWriter238.write("\n");
                        outputWriter238.write("\n");
                        outputWriter238.write("\n");
                        outputWriter238.write(Sed132);
                        outputWriter238.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getFilesDir()+"/"+InputfileNameE+".mop "+getFilesDir()+File.separator+"openbabel/solv/opt/"+InputfileNameE);
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameE+".smi "+getFilesDir()+File.separator+"openbabel/smiles");
                    exec("mv "+getFilesDir()+"/"+InputfileNameE+".xyz "+getFilesDir()+File.separator+"openbabel/xyz");
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameE+".iupac "+getFilesDir()+File.separator+"openbabel/iupac");
                    exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameE+".formula "+getFilesDir()+File.separator+"openbabel/formula");
                    /////////////////////////////////// TS ///////////////////////////////////////////////
                    String MethodfileTS = methodTS.getText().toString();
                    String KeywordsfileTS = keywTS.getText().toString();

                    FileOutputStream fileout42 = openFileOutput("BiTri_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("BiTri_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();


                    String InputfileNameTS0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                    String InputfileNameTS = InputfileNameTS0+"_TS";
                    exec("chmod 755 -R "+getFilesDir());
                    String KeyTS = MethodfileTS+" "+KeywordsfileTS;

                    try {
                        String Sed42 = exec("sed -e 1,2d "+getFilesDir()+"/BiTri_TS.txt");
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
                    exec("mv "+getFilesDir()+"/BiTri_TS.txt "+getFilesDir()+File.separator+"openbabel/xyz/"+InputfileNameTS+".xyz");
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
                        FileOutputStream fileout11016 = openFileOutput("thermo_s_R2.txt",MODE_PRIVATE);
                        OutputStreamWriter outputWriter11016 = new OutputStreamWriter(fileout11016);
                        outputWriter11016.write(RawOutput_s2);
                        outputWriter11016.close();

                        exec("mv "+getFilesDir()+"/"+InputfileNameB+".out "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameB+".arc "+getFilesDir()+"/openbabel/solv/thermo/results/");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }



                    /////////////////////////////////// Calculate C ///////////////////////////////////////////////



                    try {
                        exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameC+" "+getFilesDir()+"/"+InputfileNameC+".mop");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameC);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileNameC+".mop "+getFilesDir()+"/openbabel/solv/opt/results/");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameC+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameC+".arc");
                        exec("cp "+getFilesDir()+"/"+InputfileNameC+".arc "+getFilesDir()+"/openbabel/solv/thermo");
                        exec("mv "+getFilesDir()+"/"+InputfileNameC+".out "+getFilesDir()+"/openbabel/solv/opt/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameC+".arc "+getFilesDir()+"/openbabel/solv/opt/results/");
                        String Sed12003 = exec("sed -n 1p "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameC);
                        String Sed12004 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameC+".arc");
                        FileOutputStream fileout12009 = openFileOutput(InputfileNameC+".mops", MODE_PRIVATE);
                        OutputStreamWriter outputWriter12009 = new OutputStreamWriter(fileout12009);
                        outputWriter12009.write(Sed12004);
                        outputWriter12009.close();
                        exec("cp "+getFilesDir()+"/"+InputfileNameC+".mops "+getFilesDir()+"/openbabel/solv/thermo");
                        String Sed12005 = exec("sed -e 1,3d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameC+".mops");
                        FileOutputStream fileout12010 = openFileOutput(InputfileNameC+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter12010 = new OutputStreamWriter(fileout12010);
                        outputWriter12010.write("THERMO(298,298) LET "+Sed12003);
                        outputWriter12010.write("\n");
                        outputWriter12010.write("\n");
                        outputWriter12010.write(Sed12005);
                        outputWriter12010.close();
                        exec("rm "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameC+".mops");
                        exec("rm "+getFilesDir()+"/"+InputfileNameC+".mops");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameC);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileNameC+".mop "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameC+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameC+".arc");

                        String Grep12002 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileNameC+".out");
                        FileOutputStream fileout12013 = openFileOutput(InputfileNameC+"_s.temp",MODE_PRIVATE);
                        OutputStreamWriter outputWriter12013 = new OutputStreamWriter(fileout12013);
                        outputWriter12013.write(Grep12002);
                        outputWriter12013.close();
                        String Sed12006 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileNameC+"_s.temp");
                        String FormulaC = formulaC.getText().toString();
                        String MethodC = methodC.getText().toString();
                        FileOutputStream fileout12014 = openFileOutput(InputfileNameC+"_s.txt",MODE_APPEND);
                        OutputStreamWriter outputWriter12014 = new OutputStreamWriter(fileout12014);
                        outputWriter12014.write(InputfileNameC+" ");
                        outputWriter12014.write(FormulaC+" ");
                        outputWriter12014.write(MethodC+" ");
                        outputWriter12014.write(Sed12006);
                        outputWriter12014.close();
                        exec("rm "+getFilesDir()+"/"+InputfileNameC+"_s.temp");

                        String RawOutput_s2 = exec("cat "+getFilesDir()+"/"+InputfileNameC+"_s.txt");
                        while (RawOutput_s2.contains("  ")){  //2 spaces
                            RawOutput_s2 = RawOutput_s2.replace("  ", " "); //(2 spaces, 1 space)
                        }
                        FileOutputStream fileout12016 = openFileOutput("thermo_s_P1.txt",MODE_PRIVATE);
                        OutputStreamWriter outputWriter12016 = new OutputStreamWriter(fileout12016);
                        outputWriter12016.write(RawOutput_s2);
                        outputWriter12016.close();

                        exec("mv "+getFilesDir()+"/"+InputfileNameC+".out "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameC+".arc "+getFilesDir()+"/openbabel/solv/thermo/results/");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }



                    /////////////////////////////////// Calculate D ///////////////////////////////////////////////



                    try {
                        exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameD+" "+getFilesDir()+"/"+InputfileNameD+".mop");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameD);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileNameD+".mop "+getFilesDir()+"/openbabel/solv/opt/results/");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameD+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameD+".arc");
                        exec("cp "+getFilesDir()+"/"+InputfileNameD+".arc "+getFilesDir()+"/openbabel/solv/thermo");
                        exec("mv "+getFilesDir()+"/"+InputfileNameD+".out "+getFilesDir()+"/openbabel/solv/opt/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameD+".arc "+getFilesDir()+"/openbabel/solv/opt/results/");
                        String Sed13003 = exec("sed -n 1p "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameD);
                        String Sed13004 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameD+".arc");
                        FileOutputStream fileout13009 = openFileOutput(InputfileNameD+".mops", MODE_PRIVATE);
                        OutputStreamWriter outputWriter13009 = new OutputStreamWriter(fileout13009);
                        outputWriter13009.write(Sed13004);
                        outputWriter13009.close();
                        exec("cp "+getFilesDir()+"/"+InputfileNameD+".mops "+getFilesDir()+"/openbabel/solv/thermo");
                        String Sed13005 = exec("sed -e 1,3d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameD+".mops");
                        FileOutputStream fileout13010 = openFileOutput(InputfileNameD+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter13010 = new OutputStreamWriter(fileout13010);
                        outputWriter13010.write("THERMO(298,298) LET "+Sed13003);
                        outputWriter13010.write("\n");
                        outputWriter13010.write("\n");
                        outputWriter13010.write(Sed13005);
                        outputWriter13010.close();
                        exec("rm "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameD+".mops");
                        exec("rm "+getFilesDir()+"/"+InputfileNameD+".mops");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameD);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileNameD+".mop "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameD+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameD+".arc");

                        String Grep13002 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileNameD+".out");
                        FileOutputStream fileout13013 = openFileOutput(InputfileNameD+"_s.temp",MODE_PRIVATE);
                        OutputStreamWriter outputWriter13013 = new OutputStreamWriter(fileout13013);
                        outputWriter13013.write(Grep13002);
                        outputWriter13013.close();
                        String Sed13006 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileNameD+"_s.temp");
                        String FormulaD = formulaD.getText().toString();
                        String MethodD = methodD.getText().toString();
                        FileOutputStream fileout13014 = openFileOutput(InputfileNameD+"_s.txt",MODE_APPEND);
                        OutputStreamWriter outputWriter13014 = new OutputStreamWriter(fileout13014);
                        outputWriter13014.write(InputfileNameD+" ");
                        outputWriter13014.write(FormulaD+" ");
                        outputWriter13014.write(MethodD+" ");
                        outputWriter13014.write(Sed13006);
                        outputWriter13014.close();
                        exec("rm "+getFilesDir()+"/"+InputfileNameD+"_s.temp");

                        String RawOutput_s3 = exec("cat "+getFilesDir()+"/"+InputfileNameD+"_s.txt");
                        while (RawOutput_s3.contains("  ")){  //2 spaces
                            RawOutput_s3 = RawOutput_s3.replace("  ", " "); //(2 spaces, 1 space)
                        }
                        FileOutputStream fileout13016 = openFileOutput("thermo_s_P2.txt",MODE_PRIVATE);
                        OutputStreamWriter outputWriter13016 = new OutputStreamWriter(fileout13016);
                        outputWriter13016.write(RawOutput_s3);
                        outputWriter13016.close();

                        exec("mv "+getFilesDir()+"/"+InputfileNameD+".out "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameD+".arc "+getFilesDir()+"/openbabel/solv/thermo/results/");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    /////////////////////////////////// Calculate E ///////////////////////////////////////////////



                    try {
                        exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameE+" "+getFilesDir()+"/"+InputfileNameE+".mop");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileNameE+".mop "+getFilesDir()+"/openbabel/solv/opt/results/");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameE+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameE+".arc");
                        exec("cp "+getFilesDir()+"/"+InputfileNameE+".arc "+getFilesDir()+"/openbabel/solv/thermo");
                        exec("mv "+getFilesDir()+"/"+InputfileNameE+".out "+getFilesDir()+"/openbabel/solv/opt/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameE+".arc "+getFilesDir()+"/openbabel/solv/opt/results/");
                        String Sed14003 = exec("sed -n 1p "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameE);
                        String Sed14004 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameE+".arc");
                        FileOutputStream fileout14009 = openFileOutput(InputfileNameE+".mops", MODE_PRIVATE);
                        OutputStreamWriter outputWriter14009 = new OutputStreamWriter(fileout14009);
                        outputWriter14009.write(Sed14004);
                        outputWriter14009.close();
                        exec("cp "+getFilesDir()+"/"+InputfileNameE+".mops "+getFilesDir()+"/openbabel/solv/thermo");
                        String Sed14005 = exec("sed -e 1,3d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameE+".mops");
                        FileOutputStream fileout14010 = openFileOutput(InputfileNameE+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter14010 = new OutputStreamWriter(fileout14010);
                        outputWriter14010.write("THERMO(298,298) LET "+Sed14003);
                        outputWriter14010.write("\n");
                        outputWriter14010.write("\n");
                        outputWriter14010.write(Sed14005);
                        outputWriter14010.close();
                        exec("rm "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameE+".mops");
                        exec("rm "+getFilesDir()+"/"+InputfileNameD+".mops");
                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+InputfileNameE+".mop "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameE+".out");
                        exec("chmod 755 "+getFilesDir()+"/"+InputfileNameE+".arc");

                        String Grep14002 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileNameE+".out");
                        FileOutputStream fileout14013 = openFileOutput(InputfileNameE+"_s.temp",MODE_PRIVATE);
                        OutputStreamWriter outputWriter14013 = new OutputStreamWriter(fileout14013);
                        outputWriter14013.write(Grep14002);
                        outputWriter14013.close();
                        String Sed14006 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileNameE+"_s.temp");
                        String FormulaE = formulaE.getText().toString();
                        String MethodE = methodE.getText().toString();
                        FileOutputStream fileout14014 = openFileOutput(InputfileNameE+"_s.txt",MODE_APPEND);
                        OutputStreamWriter outputWriter14014 = new OutputStreamWriter(fileout14014);
                        outputWriter14014.write(InputfileNameE+" ");
                        outputWriter14014.write(FormulaE+" ");
                        outputWriter14014.write(MethodE+" ");
                        outputWriter14014.write(Sed14006);
                        outputWriter14014.close();
                        exec("rm "+getFilesDir()+"/"+InputfileNameE+"_s.temp");

                        String RawOutput_s4 = exec("cat "+getFilesDir()+"/"+InputfileNameE+"_s.txt");
                        while (RawOutput_s4.contains("  ")){  //2 spaces
                            RawOutput_s4 = RawOutput_s4.replace("  ", " "); //(2 spaces, 1 space)
                        }
                        FileOutputStream fileout14016 = openFileOutput("thermo_s_P3.txt",MODE_PRIVATE);
                        OutputStreamWriter outputWriter14016 = new OutputStreamWriter(fileout14016);
                        outputWriter14016.write(RawOutput_s4);
                        outputWriter14016.close();

                        exec("mv "+getFilesDir()+"/"+InputfileNameE+".out "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameE+".arc "+getFilesDir()+"/openbabel/solv/thermo/results/");
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
                        String Sed15003 = exec("sed -n 1p "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameTS);
                        String Sed15004 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameTS+".arc");
                        FileOutputStream fileout15009 = openFileOutput(InputfileNameTS+".mops", MODE_PRIVATE);
                        OutputStreamWriter outputWriter15009 = new OutputStreamWriter(fileout15009);
                        outputWriter15009.write(Sed15004);
                        outputWriter15009.close();
                        exec("cp "+getFilesDir()+"/"+InputfileNameTS+".mops "+getFilesDir()+"/openbabel/solv/thermo");
                        String Sed15005 = exec("sed -e 1,3d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileNameTS+".mops");
                        FileOutputStream fileout15010 = openFileOutput(InputfileNameTS+".mop", MODE_PRIVATE);
                        OutputStreamWriter outputWriter15010 = new OutputStreamWriter(fileout15010);
                        outputWriter15010.write("THERMO(298,298) LET "+Sed15003);
                        outputWriter15010.write("\n");
                        outputWriter15010.write("\n");
                        outputWriter15010.write(Sed15005);
                        outputWriter15010.close();
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

                        String Grep15002 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileNameTS+".out");
                        FileOutputStream fileout15013 = openFileOutput(InputfileNameTS+"_s.temp",MODE_PRIVATE);
                        OutputStreamWriter outputWriter15013 = new OutputStreamWriter(fileout15013);
                        outputWriter15013.write(Grep15002);
                        outputWriter15013.close();
                        String Sed15006 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileNameTS+"_s.temp");
                        String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
                        String FormulaTS = DatasetName+"_TS";
                        String MethodTS = methodTS.getText().toString();
                        FileOutputStream fileout15014 = openFileOutput(InputfileNameTS+"_s.txt",MODE_APPEND);
                        OutputStreamWriter outputWriter15014 = new OutputStreamWriter(fileout15014);
                        outputWriter15014.write(InputfileNameTS+" ");
                        outputWriter15014.write(FormulaTS+" ");
                        outputWriter15014.write(MethodTS+" ");
                        outputWriter15014.write(Sed15006);
                        outputWriter15014.close();
                        exec("rm "+getFilesDir()+"/"+InputfileNameTS+"_s.temp");

                        String RawOutput_s5 = exec("cat "+getFilesDir()+"/"+InputfileNameTS+"_s.txt");
                        while (RawOutput_s5.contains("  ")){  //2 spaces
                            RawOutput_s5 = RawOutput_s5.replace("  ", " "); //(2 spaces, 1 space)
                        }
                        FileOutputStream fileout15016 = openFileOutput("thermo_s_TS.txt",MODE_PRIVATE);
                        OutputStreamWriter outputWriter15016 = new OutputStreamWriter(fileout15016);
                        outputWriter15016.write(RawOutput_s5);
                        outputWriter15016.close();

                        exec("mv "+getFilesDir()+"/"+InputfileNameTS+".out "+getFilesDir()+"/openbabel/solv/thermo/results/");
                        exec("mv "+getFilesDir()+"/"+InputfileNameTS+".arc "+getFilesDir()+"/openbabel/solv/thermo/results/");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    /////////////////////////////////// Process results ///////////////////////////////////////////////


                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/BiTri.b "+getFilesDir()+"/BiTri.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/BiTri.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/BiTri.b");



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

                    MethodADisplay(exec("cat "+getFilesDir()+"/BiTri_methodA.txt"));
                    MethodBDisplay(exec("cat "+getFilesDir()+"/BiTri_methodB.txt"));
                    MethodCDisplay(exec("cat "+getFilesDir()+"/BiTri_methodC.txt"));
                    MethodDDisplay(exec("cat "+getFilesDir()+"/BiTri_methodD.txt"));
                    MethodEDisplay(exec("cat "+getFilesDir()+"/BiTri_methodE.txt"));
                    MethodTSDisplay(exec("cat "+getFilesDir()+"/BiTri_methodTS.txt"));
                    KeywADisplay(exec("cat "+getFilesDir()+"/BiTri_keywA.txt"));
                    KeywBDisplay(exec("cat "+getFilesDir()+"/BiTri_keywB.txt"));
                    KeywCDisplay(exec("cat "+getFilesDir()+"/BiTri_keywC.txt"));
                    KeywDDisplay(exec("cat "+getFilesDir()+"/BiTri_keywD.txt"));
                    KeywEDisplay(exec("cat "+getFilesDir()+"/BiTri_keywE.txt"));
                    KeywTSDisplay(exec("cat "+getFilesDir()+"/BiTri_keywTS.txt"));
                    IupacADisplay(exec("cat "+getFilesDir()+"/BiTri_iupacA.txt"));
                    IupacBDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacB.txt"));
                    IupacCDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacC.txt"));
                    IupacDDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacD.txt"));
                    IupacEDisplay(exec("cat "+getFilesDir()+"/BiTri_iupacE.txt"));
                    FormulaADisplay(exec("cat "+getFilesDir()+"/BiTri_formulaA.txt"));
                    FormulaBDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaB.txt"));
                    FormulaCDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaC.txt"));
                    FormulaDDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaD.txt"));
                    FormulaEDisplay(exec("cat "+getFilesDir()+"/BiTri_formulaE.txt"));
                    SmilesADisplay(exec("cat "+getFilesDir()+"/BiTri_smilesA.txt"));
                    SmilesBDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesB.txt"));
                    SmilesCDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesC.txt"));
                    SmilesDDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesD.txt"));
                    SmilesEDisplay(exec("cat "+getFilesDir()+"/BiTri_smilesE.txt"));

                    File filePathTS = new File(getFilesDir()+File.separator+"BiTri_TS.txt");
                    if (!filePathTS.exists()) {
                        try {
                            FileOutputStream fileoutTS = openFileOutput("BiTri_TS_status.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                            outputWriterTS.write("Transition state XYZ coordinate file not selected.");
                            outputWriterTS.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            FileOutputStream fileoutTS = openFileOutput("BiTri_TS_status.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                            outputWriterTS.write("Transition state XYZ coordinate file is available.");
                            outputWriterTS.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    TS_StatusDisplay(exec("cat "+getFilesDir()+"/BiTri_TS_status.txt"));


                } catch (Exception e) {
                }
//here:
                        Intent intent = new Intent(KineticsBiTri.this, ResumeActivityKin.class);
                        startActivity(intent);

                        onFinish();
                    }
                    public void onFinish(){
                        progressDialog.dismiss();
                    }
                }.start();

//not here:
//                Intent intent = new Intent(KineticsBiTri.this, ResumeActivityKin.class);
//                startActivity(intent);
            }
        };
    }

    private View.OnClickListener AddTSiClick; {
        AddTSiClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(KineticsBiTri.this, AddTSBiTri.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(KineticsBiTri.this, MainActivity.class);
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
    private void MethodCDisplay(final String strMC) {
        Runnable procMC = new Runnable() {
            public void run() {
                methodC.setText(strMC);
            }
        };
        handler.post(procMC);
    }
    private void MethodDDisplay(final String strMD) {
        Runnable procMD = new Runnable() {
            public void run() {
                methodD.setText(strMD);
            }
        };
        handler.post(procMD);
    }
    private void MethodEDisplay(final String strME) {
        Runnable procME = new Runnable() {
            public void run() {
                methodE.setText(strME);
            }
        };
        handler.post(procME);
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
    private void KeywCDisplay(final String strKC) {
        Runnable procKC = new Runnable() {
            public void run() {
                keywC.setText(strKC);
            }
        };
        handler.post(procKC);
    }
    private void KeywDDisplay(final String strKD) {
        Runnable procKD = new Runnable() {
            public void run() {
                keywD.setText(strKD);
            }
        };
        handler.post(procKD);
    }
    private void KeywEDisplay(final String strKE) {
        Runnable procKE = new Runnable() {
            public void run() {
                keywE.setText(strKE);
            }
        };
        handler.post(procKE);
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
    private void IupacCDisplay(final String strIC) {
        Runnable procIC = new Runnable() {
            public void run() {
                iupacC.setText(strIC);
            }
        };
        handler.post(procIC);
    }
    private void IupacDDisplay(final String strID) {
        Runnable procID = new Runnable() {
            public void run() {
                iupacD.setText(strID);
            }
        };
        handler.post(procID);
    }
    private void IupacEDisplay(final String strIE) {
        Runnable procIE = new Runnable() {
            public void run() {
                iupacE.setText(strIE);
            }
        };
        handler.post(procIE);
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
    private void FormulaCDisplay(final String strFC) {
        Runnable procFC = new Runnable() {
            public void run() {
                formulaC.setText(strFC);
            }
        };
        handler.post(procFC);
    }
    private void FormulaDDisplay(final String strFD) {
        Runnable procFD = new Runnable() {
            public void run() {
                formulaD.setText(strFD);
            }
        };
        handler.post(procFD);
    }
    private void FormulaEDisplay(final String strFE) {
        Runnable procFE = new Runnable() {
            public void run() {
                formulaE.setText(strFE);
            }
        };
        handler.post(procFE);
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
    private void SmilesCDisplay(final String strSC) {
        Runnable procSC = new Runnable() {
            public void run() {
                smiC.setText(strSC);
            }
        };
        handler.post(procSC);
    }
    private void SmilesDDisplay(final String strSD) {
        Runnable procSD = new Runnable() {
            public void run() {
                smiD.setText(strSD);
            }
        };
        handler.post(procSD);
    }
    private void SmilesEDisplay(final String strSE) {
        Runnable procSE = new Runnable() {
            public void run() {
                smiE.setText(strSE);
            }
        };
        handler.post(procSE);
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
