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

public class KineticsUniBi extends MainActivity {

    private TextView methodA_label;
    private TextView methodB_label;
    private TextView methodC_label;
    private TextView methodTS_label;

    private EditText methodA;
    private EditText methodB;
    private EditText methodC;
    private EditText methodTS;

    private TextView keywA_label;
    private TextView keywB_label;
    private TextView keywC_label;
    private TextView keywTS_label;

    private EditText keywA;
    private EditText keywB;
    private EditText keywC;
    private EditText keywTS;

    private TextView iupacA_label;
    private TextView iupacB_label;
    private TextView iupacC_label;

    private EditText iupacA;
    private EditText iupacB;
    private EditText iupacC;

    private TextView formulaA_label;
    private TextView formulaB_label;
    private TextView formulaC_label;

    private EditText formulaA;
    private EditText formulaB;
    private EditText formulaC;

    private TextView smiA_label;
    private TextView smiB_label;
    private TextView smiC_label;

    private EditText smiA;
    private EditText smiB;
    private EditText smiC;

    private Button AddTS;
    private Button AddTSi;
    private Button ResetTS;
    private Button processUniBi;
    private Button quit;
    public Button A_opsin;
    public Button B_opsin;
    public Button C_opsin;

    private Button generateXYZ;
    private Button opsinXYZ;

    private TextView TSLabel;
    private TextView TS;

    private Handler handler = new Handler();

    private static final int READ_FILE1 = 1;
    private Uri documentUri1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kineticsunibi);

        methodA_label = (TextView) findViewById(R.id.methodA_label);
        methodB_label = (TextView) findViewById(R.id.methodB_label);
        methodC_label = (TextView) findViewById(R.id.methodC_label);
        methodTS_label = (TextView) findViewById(R.id.methodTS_label);

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
                methodA.append(colorized_mopac(text));
                // place the cursor at the original position
                methodA.setSelection(startChanged+countChanged);
                methodA.addTextChangedListener(this);
            }
        });
        methodB = (EditText) findViewById(R.id.methodB);
        methodB.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        methodB.addTextChangedListener(new TextWatcher() {
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
                methodB.removeTextChangedListener(this);
                String text = methodB.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                methodB.getText().clear();
                methodB.append(colorized_mopac(text));
                // place the cursor at the original position
                methodB.setSelection(startChanged+countChanged);
                methodB.addTextChangedListener(this);
            }
        });
        methodC = (EditText) findViewById(R.id.methodC);
        methodC.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        methodC.addTextChangedListener(new TextWatcher() {
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
                methodC.removeTextChangedListener(this);
                String text = methodC.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                methodC.getText().clear();
                methodC.append(colorized_mopac(text));
                // place the cursor at the original position
                methodC.setSelection(startChanged+countChanged);
                methodC.addTextChangedListener(this);
            }
        });
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

        keywA_label = (TextView) findViewById(R.id.keywA_label);
        keywB_label = (TextView) findViewById(R.id.keywB_label);
        keywC_label = (TextView) findViewById(R.id.keywC_label);
        keywTS_label = (TextView) findViewById(R.id.keywTS_label);

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
                keywA.append(colorized_mopac(text));
                // place the cursor at the original position
                keywA.setSelection(startChanged+countChanged);
                keywA.addTextChangedListener(this);
            }
        });
        keywB = (EditText) findViewById(R.id.keywB);
        keywB.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        keywB.addTextChangedListener(new TextWatcher() {
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
                keywB.removeTextChangedListener(this);
                String text = keywB.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                keywB.getText().clear();
                keywB.append(colorized_mopac(text));
                // place the cursor at the original position
                keywB.setSelection(startChanged+countChanged);
                keywB.addTextChangedListener(this);
            }
        });
        keywC = (EditText) findViewById(R.id.keywC);
        keywC.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        keywC.addTextChangedListener(new TextWatcher() {
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
                keywC.removeTextChangedListener(this);
                String text = keywC.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                keywC.getText().clear();
                keywC.append(colorized_mopac(text));
                // place the cursor at the original position
                keywC.setSelection(startChanged+countChanged);
                keywC.addTextChangedListener(this);
            }
        });
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

        iupacA_label = (TextView) findViewById(R.id.iupacA_label);
        iupacB_label = (TextView) findViewById(R.id.iupacB_label);
        iupacC_label = (TextView) findViewById(R.id.iupacC_label);

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
                iupacA.append(colorized_mopac(text));
                // place the cursor at the original position
                iupacA.setSelection(startChanged+countChanged);
                iupacA.addTextChangedListener(this);
            }
        });
        iupacB = (EditText) findViewById(R.id.iupacB);
        iupacB.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        iupacB.addTextChangedListener(new TextWatcher() {
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
                iupacB.removeTextChangedListener(this);
                String text = iupacB.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                iupacB.getText().clear();
                iupacB.append(colorized_mopac(text));
                // place the cursor at the original position
                iupacB.setSelection(startChanged+countChanged);
                iupacB.addTextChangedListener(this);
            }
        });
        iupacC = (EditText) findViewById(R.id.iupacC);
        iupacC.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        iupacC.addTextChangedListener(new TextWatcher() {
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
                iupacC.removeTextChangedListener(this);
                String text = iupacC.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                iupacC.getText().clear();
                iupacC.append(colorized_mopac(text));
                // place the cursor at the original position
                iupacC.setSelection(startChanged+countChanged);
                iupacC.addTextChangedListener(this);
            }
        });

        formulaA_label = (TextView) findViewById(R.id.formulaA_label);
        formulaB_label = (TextView) findViewById(R.id.formulaB_label);
        formulaC_label = (TextView) findViewById(R.id.formulaC_label);

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
                formulaA.append(colorized_mopac(text));
                // place the cursor at the original position
                formulaA.setSelection(startChanged+countChanged);
                formulaA.addTextChangedListener(this);
            }
        });
        formulaB = (EditText) findViewById(R.id.formulaB);
        formulaB.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        formulaB.addTextChangedListener(new TextWatcher() {
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
                formulaB.removeTextChangedListener(this);
                String text = formulaB.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                formulaB.getText().clear();
                formulaB.append(colorized_mopac(text));
                // place the cursor at the original position
                formulaB.setSelection(startChanged+countChanged);
                formulaB.addTextChangedListener(this);
            }
        });
        formulaC = (EditText) findViewById(R.id.formulaC);
        formulaC.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        formulaC.addTextChangedListener(new TextWatcher() {
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
                formulaC.removeTextChangedListener(this);
                String text = formulaC.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                formulaC.getText().clear();
                formulaC.append(colorized_mopac(text));
                // place the cursor at the original position
                formulaC.setSelection(startChanged+countChanged);
                formulaC.addTextChangedListener(this);
            }
        });

        smiA_label = (TextView) findViewById(R.id.smiA_label);
        smiB_label = (TextView) findViewById(R.id.smiB_label);
        smiC_label = (TextView) findViewById(R.id.smiC_label);

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
                smiA.append(colorized_mopac(text));
                // place the cursor at the original position
                smiA.setSelection(startChanged+countChanged);
                smiA.addTextChangedListener(this);
            }
        });
        smiB = (EditText) findViewById(R.id.smiB);
        smiB.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        smiB.addTextChangedListener(new TextWatcher() {
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
                smiB.removeTextChangedListener(this);
                String text = smiB.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                smiB.getText().clear();
                smiB.append(colorized_mopac(text));
                // place the cursor at the original position
                smiB.setSelection(startChanged+countChanged);
                smiB.addTextChangedListener(this);
            }
        });
        smiC = (EditText) findViewById(R.id.smiC);
        smiC.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        smiC.addTextChangedListener(new TextWatcher() {
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
                smiC.removeTextChangedListener(this);
                String text = smiC.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                smiC.getText().clear();
                smiC.append(colorized_mopac(text));
                // place the cursor at the original position
                smiC.setSelection(startChanged+countChanged);
                smiC.addTextChangedListener(this);
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
        processUniBi = (Button) findViewById(R.id.processUniBi);
        processUniBi.setOnClickListener(processUniBiClick);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(QuitClick);

        A_opsin = (Button) findViewById(R.id.A_opsin);
        A_opsin.setOnClickListener(A_opsin_click);
        B_opsin = (Button) findViewById(R.id.B_opsin);
        B_opsin.setOnClickListener(B_opsin_click);
        C_opsin = (Button) findViewById(R.id.C_opsin);
        C_opsin.setOnClickListener(C_opsin_click);

        generateXYZ = (Button) findViewById(R.id.generateXYZ);
        generateXYZ.setOnClickListener(GenerateXYZClick);
        opsinXYZ = (Button) findViewById(R.id.opsinXYZ);
        opsinXYZ.setOnClickListener(opsinXYZClick);

    }

    public void onStart()
    {
        super.onStart();
        MethodADisplay(exec("cat "+getFilesDir()+"/UniBi_methodA.txt"));
        MethodBDisplay(exec("cat "+getFilesDir()+"/UniBi_methodB.txt"));
        MethodCDisplay(exec("cat "+getFilesDir()+"/UniBi_methodC.txt"));
        MethodTSDisplay(exec("cat "+getFilesDir()+"/UniBi_methodTS.txt"));
        KeywADisplay(exec("cat "+getFilesDir()+"/UniBi_keywA.txt"));
        KeywBDisplay(exec("cat "+getFilesDir()+"/UniBi_keywB.txt"));
        KeywCDisplay(exec("cat "+getFilesDir()+"/UniBi_keywC.txt"));
        KeywTSDisplay(exec("cat "+getFilesDir()+"/UniBi_keywTS.txt"));
        IupacADisplay(exec("cat "+getFilesDir()+"/UniBi_iupacA.txt"));
        IupacBDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacB.txt"));
        IupacCDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacC.txt"));
        FormulaADisplay(exec("cat "+getFilesDir()+"/UniBi_formulaA.txt"));
        FormulaBDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaB.txt"));
        FormulaCDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaC.txt"));
        SmilesADisplay(exec("cat "+getFilesDir()+"/UniBi_smilesA.txt"));
        SmilesBDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesB.txt"));
        SmilesCDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesC.txt"));

        File filePathTS = new File(getFilesDir()+File.separator+"UniBi_TS.txt");
        if (!filePathTS.exists()) {
            try {
                FileOutputStream fileoutTS = openFileOutput("UniBi_TS_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                outputWriterTS.write("Transition state XYZ coordinate file is not present.");
                outputWriterTS.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutTS = openFileOutput("UniBi_TS_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                outputWriterTS.write("Transition state XYZ coordinate file is available.");
                outputWriterTS.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        TS_StatusDisplay(exec("cat "+getFilesDir()+"/UniBi_TS_status.txt"));
    }

    private View.OnClickListener GenerateXYZClick; {

        GenerateXYZClick = new View.OnClickListener() {
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

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("UniBi_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("UniBi_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("UniBi_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("UniBi_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("UniBi_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("UniBi_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("UniBi_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("UniBi_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("UniBi_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("UniBi_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("UniBi_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("UniBi_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("UniBi_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("UniBi_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("UniBi_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout42 = openFileOutput("UniBi_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("UniBi_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN CONTINUE ////////////////////////////////
                alertGenerateXYZ();
                MethodADisplay(exec("cat "+getFilesDir()+"/UniBi_methodA.txt"));
                MethodBDisplay(exec("cat "+getFilesDir()+"/UniBi_methodB.txt"));
                MethodCDisplay(exec("cat "+getFilesDir()+"/UniBi_methodC.txt"));
                MethodTSDisplay(exec("cat "+getFilesDir()+"/UniBi_methodTS.txt"));
                KeywADisplay(exec("cat "+getFilesDir()+"/UniBi_keywA.txt"));
                KeywBDisplay(exec("cat "+getFilesDir()+"/UniBi_keywB.txt"));
                KeywCDisplay(exec("cat "+getFilesDir()+"/UniBi_keywC.txt"));
                KeywTSDisplay(exec("cat "+getFilesDir()+"/UniBi_keywTS.txt"));
                IupacADisplay(exec("cat "+getFilesDir()+"/UniBi_iupacA.txt"));
                IupacBDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacB.txt"));
                IupacCDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacC.txt"));
                FormulaADisplay(exec("cat "+getFilesDir()+"/UniBi_formulaA.txt"));
                FormulaBDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaB.txt"));
                FormulaCDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaC.txt"));
                SmilesADisplay(exec("cat "+getFilesDir()+"/UniBi_smilesA.txt"));
                SmilesBDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesB.txt"));
                SmilesCDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesC.txt"));
                TS_StatusDisplay(exec("cat "+getFilesDir()+"/UniBi_TS_status.txt"));
            }
        };
    }


    public void alertGenerateXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(KineticsUniBi.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(KineticsUniBi.this)
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

                            FileOutputStream fileout3 = openFileOutput("UniBi_TS.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            FileOutputStream fileoutTS = openFileOutput("UniBi_TS_status.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                            outputWriterTS.write("Transition state XYZ coordinate file is available.");
                            outputWriterTS.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        TS_StatusDisplay(exec("cat "+getFilesDir()+"/UniBi_TS_status.txt"));
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

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("UniBi_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("UniBi_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("UniBi_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("UniBi_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("UniBi_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("UniBi_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("UniBi_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("UniBi_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("UniBi_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("UniBi_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("UniBi_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("UniBi_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("UniBi_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("UniBi_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("UniBi_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout42 = openFileOutput("UniBi_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("UniBi_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN CONTINUE ////////////////////////////////
                alertOpsinXYZ();
                MethodADisplay(exec("cat "+getFilesDir()+"/UniBi_methodA.txt"));
                MethodBDisplay(exec("cat "+getFilesDir()+"/UniBi_methodB.txt"));
                MethodCDisplay(exec("cat "+getFilesDir()+"/UniBi_methodC.txt"));
                MethodTSDisplay(exec("cat "+getFilesDir()+"/UniBi_methodTS.txt"));
                KeywADisplay(exec("cat "+getFilesDir()+"/UniBi_keywA.txt"));
                KeywBDisplay(exec("cat "+getFilesDir()+"/UniBi_keywB.txt"));
                KeywCDisplay(exec("cat "+getFilesDir()+"/UniBi_keywC.txt"));
                KeywTSDisplay(exec("cat "+getFilesDir()+"/UniBi_keywTS.txt"));
                IupacADisplay(exec("cat "+getFilesDir()+"/UniBi_iupacA.txt"));
                IupacBDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacB.txt"));
                IupacCDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacC.txt"));
                FormulaADisplay(exec("cat "+getFilesDir()+"/UniBi_formulaA.txt"));
                FormulaBDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaB.txt"));
                FormulaCDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaC.txt"));
                SmilesADisplay(exec("cat "+getFilesDir()+"/UniBi_smilesA.txt"));
                SmilesBDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesB.txt"));
                SmilesCDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesC.txt"));
                TS_StatusDisplay(exec("cat "+getFilesDir()+"/UniBi_TS_status.txt"));
            }
        };
    }


    public void alertOpsinXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(KineticsUniBi.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(KineticsUniBi.this)
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

                            FileOutputStream fileout3 = openFileOutput("UniBi_TS.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            FileOutputStream fileoutTS = openFileOutput("UniBi_TS_status.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                            outputWriterTS.write("Transition state XYZ coordinate file is available.");
                            outputWriterTS.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        TS_StatusDisplay(exec("cat "+getFilesDir()+"/UniBi_TS_status.txt"));
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

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("UniBi_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("UniBi_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("UniBi_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("UniBi_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("UniBi_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("UniBi_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("UniBi_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("UniBi_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("UniBi_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("UniBi_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("UniBi_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("UniBi_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("UniBi_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("UniBi_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("UniBi_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout42 = openFileOutput("UniBi_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("UniBi_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN CONTINUE ////////////////////////////////

                // TODO Auto-generated method stub //
                progressDialog = new ProgressDialog(KineticsUniBi.this);
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
                            FileOutputStream fileout3 = openFileOutput("UniBi_smilesA.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(smiles);
                            outputWriter3.close();
//                            FileOutputStream fileoutNts = openFileOutput("UniBi_iupacA.txt", MODE_PRIVATE);
//                            OutputStreamWriter outputWriterNts = new OutputStreamWriter(fileoutNts);
//                            outputWriterNts.write(NameToConvert);
//                            outputWriterNts.close();
                            MethodADisplay(exec("cat "+getFilesDir()+"/UniBi_methodA.txt"));
                            MethodBDisplay(exec("cat "+getFilesDir()+"/UniBi_methodB.txt"));
                            MethodCDisplay(exec("cat "+getFilesDir()+"/UniBi_methodC.txt"));
                            MethodTSDisplay(exec("cat "+getFilesDir()+"/UniBi_methodTS.txt"));
                            KeywADisplay(exec("cat "+getFilesDir()+"/UniBi_keywA.txt"));
                            KeywBDisplay(exec("cat "+getFilesDir()+"/UniBi_keywB.txt"));
                            KeywCDisplay(exec("cat "+getFilesDir()+"/UniBi_keywC.txt"));
                            KeywTSDisplay(exec("cat "+getFilesDir()+"/UniBi_keywTS.txt"));
                            IupacADisplay(exec("cat "+getFilesDir()+"/UniBi_iupacA.txt"));
                            IupacBDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacB.txt"));
                            IupacCDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacC.txt"));
                            FormulaADisplay(exec("cat "+getFilesDir()+"/UniBi_formulaA.txt"));
                            FormulaBDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaB.txt"));
                            FormulaCDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaC.txt"));
                            SmilesADisplay(exec("cat "+getFilesDir()+"/UniBi_smilesA.txt"));
                            SmilesBDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesB.txt"));
                            SmilesCDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesC.txt"));

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

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("UniBi_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("UniBi_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("UniBi_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("UniBi_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("UniBi_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("UniBi_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("UniBi_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("UniBi_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("UniBi_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("UniBi_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("UniBi_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("UniBi_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("UniBi_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("UniBi_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("UniBi_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout42 = openFileOutput("UniBi_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("UniBi_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN CONTINUE ////////////////////////////////

                // TODO Auto-generated method stub //
                progressDialog = new ProgressDialog(KineticsUniBi.this);
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
                            FileOutputStream fileout3 = openFileOutput("UniBi_smilesB.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(smiles);
                            outputWriter3.close();
//                            FileOutputStream fileoutNts = openFileOutput("UniBi_iupacB.txt", MODE_PRIVATE);
//                            OutputStreamWriter outputWriterNts = new OutputStreamWriter(fileoutNts);
//                            outputWriterNts.write(NameToConvert);
//                            outputWriterNts.close();
                            MethodADisplay(exec("cat "+getFilesDir()+"/UniBi_methodA.txt"));
                            MethodBDisplay(exec("cat "+getFilesDir()+"/UniBi_methodB.txt"));
                            MethodCDisplay(exec("cat "+getFilesDir()+"/UniBi_methodC.txt"));
                            MethodTSDisplay(exec("cat "+getFilesDir()+"/UniBi_methodTS.txt"));
                            KeywADisplay(exec("cat "+getFilesDir()+"/UniBi_keywA.txt"));
                            KeywBDisplay(exec("cat "+getFilesDir()+"/UniBi_keywB.txt"));
                            KeywCDisplay(exec("cat "+getFilesDir()+"/UniBi_keywC.txt"));
                            KeywTSDisplay(exec("cat "+getFilesDir()+"/UniBi_keywTS.txt"));
                            IupacADisplay(exec("cat "+getFilesDir()+"/UniBi_iupacA.txt"));
                            IupacBDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacB.txt"));
                            IupacCDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacC.txt"));
                            FormulaADisplay(exec("cat "+getFilesDir()+"/UniBi_formulaA.txt"));
                            FormulaBDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaB.txt"));
                            FormulaCDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaC.txt"));
                            SmilesADisplay(exec("cat "+getFilesDir()+"/UniBi_smilesA.txt"));
                            SmilesBDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesB.txt"));
                            SmilesCDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesC.txt"));

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

        C_opsin_click = new View.OnClickListener() {
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

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("UniBi_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("UniBi_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("UniBi_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("UniBi_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("UniBi_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("UniBi_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("UniBi_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("UniBi_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("UniBi_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("UniBi_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("UniBi_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("UniBi_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("UniBi_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("UniBi_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("UniBi_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout42 = openFileOutput("UniBi_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("UniBi_keywTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                    outputWriter46.write(KeywordsfileTS);
                    outputWriter46.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /////////////////////////// THEN CONTINUE ////////////////////////////////

                // TODO Auto-generated method stub //
                progressDialog = new ProgressDialog(KineticsUniBi.this);
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
                            FileOutputStream fileout3 = openFileOutput("UniBi_smilesC.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(smiles);
                            outputWriter3.close();
//                            FileOutputStream fileoutNts = openFileOutput("UniBi_iupacC.txt", MODE_PRIVATE);
//                            OutputStreamWriter outputWriterNts = new OutputStreamWriter(fileoutNts);
//                            outputWriterNts.write(NameToConvert);
//                            outputWriterNts.close();
                            MethodADisplay(exec("cat "+getFilesDir()+"/UniBi_methodA.txt"));
                            MethodBDisplay(exec("cat "+getFilesDir()+"/UniBi_methodB.txt"));
                            MethodCDisplay(exec("cat "+getFilesDir()+"/UniBi_methodC.txt"));
                            MethodTSDisplay(exec("cat "+getFilesDir()+"/UniBi_methodTS.txt"));
                            KeywADisplay(exec("cat "+getFilesDir()+"/UniBi_keywA.txt"));
                            KeywBDisplay(exec("cat "+getFilesDir()+"/UniBi_keywB.txt"));
                            KeywCDisplay(exec("cat "+getFilesDir()+"/UniBi_keywC.txt"));
                            KeywTSDisplay(exec("cat "+getFilesDir()+"/UniBi_keywTS.txt"));
                            IupacADisplay(exec("cat "+getFilesDir()+"/UniBi_iupacA.txt"));
                            IupacBDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacB.txt"));
                            IupacCDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacC.txt"));
                            FormulaADisplay(exec("cat "+getFilesDir()+"/UniBi_formulaA.txt"));
                            FormulaBDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaB.txt"));
                            FormulaCDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaC.txt"));
                            SmilesADisplay(exec("cat "+getFilesDir()+"/UniBi_smilesA.txt"));
                            SmilesBDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesB.txt"));
                            SmilesCDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesC.txt"));

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

                String MethodfileTS = methodTS.getText().toString();
                String KeywordsfileTS = keywTS.getText().toString();

                try {

                    FileOutputStream fileout = openFileOutput("UniBi_smilesA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputfileA);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("UniBi_methodA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(MethodfileA);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("UniBi_iupacA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName0A);
                    outputWriter3.close();
                    FileOutputStream fileout8 = openFileOutput("UniBi_formulaA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(FormulafileA);
                    outputWriter8.close();
                    FileOutputStream fileout6 = openFileOutput("UniBi_keywA.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(KeywordsfileA);
                    outputWriter6.close();

                    FileOutputStream fileout10 = openFileOutput("UniBi_smilesB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(InputfileB);
                    outputWriter10.close();
                    FileOutputStream fileout12 = openFileOutput("UniBi_methodB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(MethodfileB);
                    outputWriter12.close();
                    FileOutputStream fileout13 = openFileOutput("UniBi_iupacB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(InputfileName0B);
                    outputWriter13.close();
                    FileOutputStream fileout18 = openFileOutput("UniBi_formulaB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                    outputWriter18.write(FormulafileB);
                    outputWriter18.close();
                    FileOutputStream fileout16 = openFileOutput("UniBi_keywB.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                    outputWriter16.write(KeywordsfileB);
                    outputWriter16.close();

                    FileOutputStream fileout20 = openFileOutput("UniBi_smilesC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                    outputWriter20.write(InputfileC);
                    outputWriter20.close();
                    FileOutputStream fileout22 = openFileOutput("UniBi_methodC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                    outputWriter22.write(MethodfileC);
                    outputWriter22.close();
                    FileOutputStream fileout23 = openFileOutput("UniBi_iupacC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                    outputWriter23.write(InputfileName0C);
                    outputWriter23.close();
                    FileOutputStream fileout28 = openFileOutput("UniBi_formulaC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                    outputWriter28.write(FormulafileC);
                    outputWriter28.close();
                    FileOutputStream fileout26 = openFileOutput("UniBi_keywC.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                    outputWriter26.write(KeywordsfileC);
                    outputWriter26.close();

                    FileOutputStream fileout42 = openFileOutput("UniBi_methodTS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                    outputWriter42.write(MethodfileTS);
                    outputWriter42.close();
                    FileOutputStream fileout46 = openFileOutput("UniBi_keywTS.txt", MODE_PRIVATE);
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

                FileOutputStream fileout = openFileOutput("UniBi_TS.txt", MODE_PRIVATE);
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
                exec("rm "+getFilesDir()+"/UniBi_TS.txt");

                MethodADisplay(exec("cat "+getFilesDir()+"/UniBi_methodA.txt"));
                MethodBDisplay(exec("cat "+getFilesDir()+"/UniBi_methodB.txt"));
                MethodCDisplay(exec("cat "+getFilesDir()+"/UniBi_methodC.txt"));
                MethodTSDisplay(exec("cat "+getFilesDir()+"/UniBi_methodTS.txt"));
                KeywADisplay(exec("cat "+getFilesDir()+"/UniBi_keywA.txt"));
                KeywBDisplay(exec("cat "+getFilesDir()+"/UniBi_keywB.txt"));
                KeywCDisplay(exec("cat "+getFilesDir()+"/UniBi_keywC.txt"));
                KeywTSDisplay(exec("cat "+getFilesDir()+"/UniBi_keywTS.txt"));
                IupacADisplay(exec("cat "+getFilesDir()+"/UniBi_iupacA.txt"));
                IupacBDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacB.txt"));
                IupacCDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacC.txt"));
                FormulaADisplay(exec("cat "+getFilesDir()+"/UniBi_formulaA.txt"));
                FormulaBDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaB.txt"));
                FormulaCDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaC.txt"));
                SmilesADisplay(exec("cat "+getFilesDir()+"/UniBi_smilesA.txt"));
                SmilesBDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesB.txt"));
                SmilesCDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesC.txt"));

                File filePathTS = new File(getFilesDir()+File.separator+"UniBi_TS.txt");
                if (!filePathTS.exists()) {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("UniBi_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file is not present.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutTS = openFileOutput("UniBi_TS_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                        outputWriterTS.write("Transition state XYZ coordinate file is available.");
                        outputWriterTS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                TS_StatusDisplay(exec("cat "+getFilesDir()+"/UniBi_TS_status.txt"));
            }
        };
    }

    private View.OnClickListener processUniBiClick; {

        processUniBiClick = new View.OnClickListener() {
            public void onClick(View v) {

                String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                String DatasetName1 = DatasetName0.replace(" ","_");
                String DatasetName = DatasetName1.replace(",",".");
                progressDialog = new ProgressDialog(KineticsUniBi.this);
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
                            FileOutputStream fileout = openFileOutput("UniBi_smilesA.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(InputfileA);
                            outputWriter.close();
                            FileOutputStream fileout2 = openFileOutput("UniBi_methodA.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(MethodfileA);
                            outputWriter2.close();
                            FileOutputStream fileout3 = openFileOutput("UniBi_iupacA.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(InputfileName0A);
                            outputWriter3.close();
                            FileOutputStream fileout8 = openFileOutput("UniBi_formulaA.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                            outputWriter8.write(FormulafileA);
                            outputWriter8.close();
                            FileOutputStream fileout6 = openFileOutput("UniBi_keywA.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                            outputWriter6.write(KeywordsfileA);
                            outputWriter6.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {

                            String InputfileNameA1 = InputfileName0A.replace(" ","_");
                            String InputfileNameA = InputfileNameA1.replace(",",".");
                            exec("cp "+getFilesDir()+"/UniBi_smilesA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".smi");
                            exec("cp "+getFilesDir()+"/UniBi_iupacA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".iupac");
                            exec("cp "+getFilesDir()+"/UniBi_formulaA.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameA+".formula");
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

                            /////////////////////////////////// B ///////////////////////////////////////////////
                            String InputfileB = smiB.getText().toString();
                            String InputfileName0B = iupacB.getText().toString();
                            String MethodfileB = methodB.getText().toString();
                            String KeywordsfileB = keywB.getText().toString();
                            String FormulafileB = formulaB.getText().toString();

                            FileOutputStream fileout10 = openFileOutput("UniBi_smilesB.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                            outputWriter10.write(InputfileB);
                            outputWriter10.close();
                            FileOutputStream fileout12 = openFileOutput("UniBi_methodB.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                            outputWriter12.write(MethodfileB);
                            outputWriter12.close();
                            FileOutputStream fileout13 = openFileOutput("UniBi_iupacB.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                            outputWriter13.write(InputfileName0B);
                            outputWriter13.close();
                            FileOutputStream fileout18 = openFileOutput("UniBi_formulaB.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter18 = new OutputStreamWriter(fileout18);
                            outputWriter18.write(FormulafileB);
                            outputWriter18.close();
                            FileOutputStream fileout16 = openFileOutput("UniBi_keywB.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                            outputWriter16.write(KeywordsfileB);
                            outputWriter16.close();


                            String InputfileNameB1 = InputfileName0B.replace(" ","_");
                            String InputfileNameB = InputfileNameB1.replace(",",".");
                            exec("cp "+getFilesDir()+"/UniBi_smilesB.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameB+".smi");
                            exec("cp "+getFilesDir()+"/UniBi_iupacB.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameB+".iupac");
                            exec("cp "+getFilesDir()+"/UniBi_formulaB.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameB+".formula");
                            exec("chmod 755 -R "+getFilesDir());
                            // String ObabelOutputB = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+File.separator+"openbabel"+File.separator+InputfileNameB+".smi -oxyz --gen3d");
                            com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi ./openbabel/"+InputfileNameB+".smi -oxyz --gen3d > ObabelOutputB.txt");
                            String ObabelOutputB = exec("cat "+getFilesDir()+"/ObabelOutputB.txt");

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

                            FileOutputStream fileout20 = openFileOutput("UniBi_smilesC.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                            outputWriter20.write(InputfileC);
                            outputWriter20.close();
                            FileOutputStream fileout22 = openFileOutput("UniBi_methodC.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter22 = new OutputStreamWriter(fileout22);
                            outputWriter22.write(MethodfileC);
                            outputWriter22.close();
                            FileOutputStream fileout23 = openFileOutput("UniBi_iupacC.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter23 = new OutputStreamWriter(fileout23);
                            outputWriter23.write(InputfileName0C);
                            outputWriter23.close();
                            FileOutputStream fileout28 = openFileOutput("UniBi_formulaC.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter28 = new OutputStreamWriter(fileout28);
                            outputWriter28.write(FormulafileC);
                            outputWriter28.close();
                            FileOutputStream fileout26 = openFileOutput("UniBi_keywC.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                            outputWriter26.write(KeywordsfileC);
                            outputWriter26.close();


                            String InputfileNameC1 = InputfileName0C.replace(" ","_");
                            String InputfileNameC = InputfileNameC1.replace(",",".");
                            exec("cp "+getFilesDir()+"/UniBi_smilesC.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameC+".smi");
                            exec("cp "+getFilesDir()+"/UniBi_iupacC.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameC+".iupac");
                            exec("cp "+getFilesDir()+"/UniBi_formulaC.txt "+getFilesDir()+File.separator+"openbabel/"+InputfileNameC+".formula");
                            exec("chmod 755 -R "+getFilesDir());
                            // String ObabelOutputC = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+File.separator+"openbabel"+File.separator+InputfileNameC+".smi -oxyz --gen3d");
                            com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi ./openbabel/"+InputfileNameC+".smi -oxyz --gen3d > ObabelOutputC.txt");
                            String ObabelOutputC = exec("cat "+getFilesDir()+"/ObabelOutputC.txt");

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

                            /////////////////////////////////// TS ///////////////////////////////////////////////
                            String MethodfileTS = methodTS.getText().toString();
                            String KeywordsfileTS = keywTS.getText().toString();

                            FileOutputStream fileout42 = openFileOutput("UniBi_methodTS.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter42 = new OutputStreamWriter(fileout42);
                            outputWriter42.write(MethodfileTS);
                            outputWriter42.close();
                            FileOutputStream fileout46 = openFileOutput("UniBi_keywTS.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter46 = new OutputStreamWriter(fileout46);
                            outputWriter46.write(KeywordsfileTS);
                            outputWriter46.close();


                            String InputfileNameTS0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
                            String InputfileNameTS = InputfileNameTS0+"_TS";
                            exec("chmod 755 -R "+getFilesDir());
                            String KeyTS = MethodfileTS+" "+KeywordsfileTS;

                            try {
                                String Sed42 = exec("sed -e 1,2d "+getFilesDir()+"/UniBi_TS.txt");
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
                            exec("mv "+getFilesDir()+"/UniBi_TS.txt "+getFilesDir()+File.separator+"openbabel/xyz/"+InputfileNameTS+".xyz");
                            exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameTS+".iupac "+getFilesDir()+File.separator+"openbabel/iupac");
                            exec("mv "+getFilesDir()+"/openbabel/"+InputfileNameTS+".formula "+getFilesDir()+File.separator+"openbabel/formula");

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
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameB);
                                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileNameB);
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
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameB);
                                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileNameB);
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

                            /////////////////////////////////// Calculate C ///////////////////////////////////////////////

                            try {
                                exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileNameC+" "+getFilesDir()+"/"+InputfileNameC+".mop");
                                try {
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameC);
                                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileNameC);
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
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileNameC);
                                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileNameC);
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
                                FileOutputStream fileout12016 = openFileOutput("thermo_s_P2.txt",MODE_PRIVATE);
                                OutputStreamWriter outputWriter12016 = new OutputStreamWriter(fileout12016);
                                outputWriter12016.write(RawOutput_s2);
                                outputWriter12016.close();

                                exec("mv "+getFilesDir()+"/"+InputfileNameC+".out "+getFilesDir()+"/openbabel/solv/thermo/results/");
                                exec("mv "+getFilesDir()+"/"+InputfileNameC+".arc "+getFilesDir()+"/openbabel/solv/thermo/results/");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

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

                            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/UniBi.b "+getFilesDir()+"/UniBi.bas");
                            exec("chmod -R 755 "+getFilesDir()+"/UniBi.b");
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/UniBi.b");

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

                            MethodADisplay(exec("cat "+getFilesDir()+"/UniBi_methodA.txt"));
                            MethodBDisplay(exec("cat "+getFilesDir()+"/UniBi_methodB.txt"));
                            MethodCDisplay(exec("cat "+getFilesDir()+"/UniBi_methodC.txt"));
                            MethodTSDisplay(exec("cat "+getFilesDir()+"/UniBi_methodTS.txt"));
                            KeywADisplay(exec("cat "+getFilesDir()+"/UniBi_keywA.txt"));
                            KeywBDisplay(exec("cat "+getFilesDir()+"/UniBi_keywB.txt"));
                            KeywCDisplay(exec("cat "+getFilesDir()+"/UniBi_keywC.txt"));
                            KeywTSDisplay(exec("cat "+getFilesDir()+"/UniBi_keywTS.txt"));
                            IupacADisplay(exec("cat "+getFilesDir()+"/UniBi_iupacA.txt"));
                            IupacBDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacB.txt"));
                            IupacCDisplay(exec("cat "+getFilesDir()+"/UniBi_iupacC.txt"));
                            FormulaADisplay(exec("cat "+getFilesDir()+"/UniBi_formulaA.txt"));
                            FormulaBDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaB.txt"));
                            FormulaCDisplay(exec("cat "+getFilesDir()+"/UniBi_formulaC.txt"));
                            SmilesADisplay(exec("cat "+getFilesDir()+"/UniBi_smilesA.txt"));
                            SmilesBDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesB.txt"));
                            SmilesCDisplay(exec("cat "+getFilesDir()+"/UniBi_smilesC.txt"));

                            File filePathTS = new File(getFilesDir()+File.separator+"UniBi_TS.txt");
                            if (!filePathTS.exists()) {
                                try {
                                    FileOutputStream fileoutTS = openFileOutput("UniBi_TS_status.txt", MODE_PRIVATE);
                                    OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                                    outputWriterTS.write("Transition state XYZ coordinate file is not present.");
                                    outputWriterTS.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                try {
                                    FileOutputStream fileoutTS = openFileOutput("UniBi_TS_status.txt", MODE_PRIVATE);
                                    OutputStreamWriter outputWriterTS = new OutputStreamWriter(fileoutTS);
                                    outputWriterTS.write("Transition state XYZ coordinate file is available.");
                                    outputWriterTS.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            TS_StatusDisplay(exec("cat "+getFilesDir()+"/UniBi_TS_status.txt"));


                        } catch (Exception e) {
                        }
//here:
                        Intent intent = new Intent(KineticsUniBi.this, ResumeActivityKin.class);
                        startActivity(intent);

                        onFinish();
                    }
                    public void onFinish(){
                        progressDialog.dismiss();
                    }
                }.start();

//not here:
//                Intent intent = new Intent(KineticsUniBi.this, ResumeActivityKin.class);
//                startActivity(intent);
            }
        };
    }

    private View.OnClickListener AddTSiClick; {
        AddTSiClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(KineticsUniBi.this, AddTSUniBi.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(KineticsUniBi.this, MainActivity.class);
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
                methodA.setText(colorized_mopac(strMA), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procMA);
    }
    private void MethodBDisplay(final String strMB) {
        Runnable procMB = new Runnable() {
            public void run() {
                methodB.setText(colorized_mopac(strMB), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procMB);
    }
    private void MethodCDisplay(final String strMC) {
        Runnable procMC = new Runnable() {
            public void run() {
                methodC.setText(colorized_mopac(strMC), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procMC);
    }
    private void MethodTSDisplay(final String strMTS) {
        Runnable procMTS = new Runnable() {
            public void run() {
                methodTS.setText(colorized_mopac(strMTS), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procMTS);
    }
    private void KeywADisplay(final String strKA) {
        Runnable procKA = new Runnable() {
            public void run() {
                keywA.setText(colorized_mopac(strKA), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procKA);
    }
    private void KeywBDisplay(final String strKB) {
        Runnable procKB = new Runnable() {
            public void run() {
                keywB.setText(colorized_mopac(strKB), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procKB);
    }
    private void KeywCDisplay(final String strKC) {
        Runnable procKC = new Runnable() {
            public void run() {
                keywC.setText(colorized_mopac(strKC), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procKC);
    }
    private void KeywTSDisplay(final String strKTS) {
        Runnable procKTS = new Runnable() {
            public void run() {
                keywTS.setText(colorized_mopac(strKTS), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procKTS);
    }
    private void IupacADisplay(final String strIA) {
        Runnable procIA = new Runnable() {
            public void run() {
                iupacA.setText(colorized_mopac(strIA), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procIA);
    }
    private void IupacBDisplay(final String strIB) {
        Runnable procIB = new Runnable() {
            public void run() {
                iupacB.setText(colorized_mopac(strIB), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procIB);
    }
    private void IupacCDisplay(final String strIC) {
        Runnable procIC = new Runnable() {
            public void run() {
                iupacC.setText(colorized_mopac(strIC), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procIC);
    }
    private void FormulaADisplay(final String strFA) {
        Runnable procFA = new Runnable() {
            public void run() {
                formulaA.setText(colorized_mopac(strFA), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procFA);
    }
    private void FormulaBDisplay(final String strFB) {
        Runnable procFB = new Runnable() {
            public void run() {
                formulaB.setText(colorized_mopac(strFB), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procFB);
    }
    private void FormulaCDisplay(final String strFC) {
        Runnable procFC = new Runnable() {
            public void run() {
                formulaC.setText(colorized_mopac(strFC), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procFC);
    }
    private void SmilesADisplay(final String strSA) {
        Runnable procSA = new Runnable() {
            public void run() {
                smiA.setText(colorized_mopac(strSA), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procSA);
    }
    private void SmilesBDisplay(final String strSB) {
        Runnable procSB = new Runnable() {
            public void run() {
                smiB.setText(colorized_mopac(strSB), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procSB);
    }
    private void SmilesCDisplay(final String strSC) {
        Runnable procSC = new Runnable() {
            public void run() {
                smiC.setText(colorized_mopac(strSC), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procSC);
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
