package cz.p;

import static cz.p.Spannables.colorized_numbers;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GCM3Kin extends EmpiricalKin {

    private Handler handler = new Handler();
    private TextView Reactant1Label;
    private TextView Reactant2Label;
    private TextView Reactant3Label;
    private TextView Product1Label;
    private TextView Product2Label;
    private TextView Product3Label;
    private TextView StoichR1Label;
    private TextView StoichR2Label;
    private TextView StoichR3Label;
    private TextView StoichP1Label;
    private TextView StoichP2Label;
    private TextView StoichP3Label;
    private TextView ElectronLabel;
    private EditText Reactant1;
    private EditText Reactant2;
    private EditText Reactant3;
    private EditText Product1;
    private EditText Product2;
    private EditText Product3;
    private EditText StoichR1;
    private EditText StoichR2;
    private EditText StoichR3;
    private EditText StoichP1;
    private EditText StoichP2;
    private EditText StoichP3;
    private EditText Electron;
    Button Run;
    Button Quit;
    private ProgressDialog progressDialog;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gcm3kin);

        Reactant1Label = (TextView) findViewById(R.id.Reactant1Label);
        Reactant2Label = (TextView) findViewById(R.id.Reactant2Label);
        Reactant3Label = (TextView) findViewById(R.id.Reactant3Label);
        Product1Label = (TextView) findViewById(R.id.Product1Label);
        Product2Label = (TextView) findViewById(R.id.Product2Label);
        Product3Label = (TextView) findViewById(R.id.Product3Label);
        StoichR1Label = (TextView) findViewById(R.id.StoichR1Label);
        StoichR2Label = (TextView) findViewById(R.id.StoichR2Label);
        StoichR3Label = (TextView) findViewById(R.id.StoichR3Label);
        StoichP1Label = (TextView) findViewById(R.id.StoichP1Label);
        StoichP2Label = (TextView) findViewById(R.id.StoichP2Label);
        StoichP3Label = (TextView) findViewById(R.id.StoichP3Label);
        ElectronLabel = (TextView) findViewById(R.id.ElectronLabel);
        Reactant1 = (EditText) findViewById(R.id.Reactant1);
        Reactant1.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Reactant1.addTextChangedListener(new TextWatcher() {
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
                Reactant1.removeTextChangedListener(this);
                String text = Reactant1.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Reactant1.getText().clear();
                Reactant1.append(colorized_numbers(text));
                // place the cursor at the original position
                Reactant1.setSelection(startChanged+countChanged);
                Reactant1.addTextChangedListener(this);
            }
        });
        Reactant2 = (EditText) findViewById(R.id.Reactant2);
        Reactant2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Reactant2.addTextChangedListener(new TextWatcher() {
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
                Reactant2.removeTextChangedListener(this);
                String text = Reactant2.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Reactant2.getText().clear();
                Reactant2.append(colorized_numbers(text));
                // place the cursor at the original position
                Reactant2.setSelection(startChanged+countChanged);
                Reactant2.addTextChangedListener(this);
            }
        });
        Reactant3 = (EditText) findViewById(R.id.Reactant3);
        Reactant3.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Reactant3.addTextChangedListener(new TextWatcher() {
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
                Reactant3.removeTextChangedListener(this);
                String text = Reactant3.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Reactant3.getText().clear();
                Reactant3.append(colorized_numbers(text));
                // place the cursor at the original position
                Reactant3.setSelection(startChanged+countChanged);
                Reactant3.addTextChangedListener(this);
            }
        });
        Product1 = (EditText) findViewById(R.id.Product1);
        Product1.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Product1.addTextChangedListener(new TextWatcher() {
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
                Product1.removeTextChangedListener(this);
                String text = Product1.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Product1.getText().clear();
                Product1.append(colorized_numbers(text));
                // place the cursor at the original position
                Product1.setSelection(startChanged+countChanged);
                Product1.addTextChangedListener(this);
            }
        });
        Product2 = (EditText) findViewById(R.id.Product2);
        Product2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Product2.addTextChangedListener(new TextWatcher() {
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
                Product2.removeTextChangedListener(this);
                String text = Product2.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Product2.getText().clear();
                Product2.append(colorized_numbers(text));
                // place the cursor at the original position
                Product2.setSelection(startChanged+countChanged);
                Product2.addTextChangedListener(this);
            }
        });
        Product3 = (EditText) findViewById(R.id.Product3);
        Product3.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Product3.addTextChangedListener(new TextWatcher() {
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
                Product3.removeTextChangedListener(this);
                String text = Product3.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Product3.getText().clear();
                Product3.append(colorized_numbers(text));
                // place the cursor at the original position
                Product3.setSelection(startChanged+countChanged);
                Product3.addTextChangedListener(this);
            }
        });
        StoichR1 = (EditText) findViewById(R.id.StoichR1);
        StoichR1.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        StoichR1.addTextChangedListener(new TextWatcher() {
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
                StoichR1.removeTextChangedListener(this);
                String text = StoichR1.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                StoichR1.getText().clear();
                StoichR1.append(colorized_numbers(text));
                // place the cursor at the original position
                StoichR1.setSelection(startChanged+countChanged);
                StoichR1.addTextChangedListener(this);
            }
        });
        StoichR2 = (EditText) findViewById(R.id.StoichR2);
        StoichR2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        StoichR2.addTextChangedListener(new TextWatcher() {
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
                StoichR2.removeTextChangedListener(this);
                String text = StoichR2.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                StoichR2.getText().clear();
                StoichR2.append(colorized_numbers(text));
                // place the cursor at the original position
                StoichR2.setSelection(startChanged+countChanged);
                StoichR2.addTextChangedListener(this);
            }
        });
        StoichR3 = (EditText) findViewById(R.id.StoichR3);
        StoichR3.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        StoichR3.addTextChangedListener(new TextWatcher() {
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
                StoichR3.removeTextChangedListener(this);
                String text = StoichR3.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                StoichR3.getText().clear();
                StoichR3.append(colorized_numbers(text));
                // place the cursor at the original position
                StoichR3.setSelection(startChanged+countChanged);
                StoichR3.addTextChangedListener(this);
            }
        });
        StoichP1 = (EditText) findViewById(R.id.StoichP1);
        StoichP1.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        StoichP1.addTextChangedListener(new TextWatcher() {
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
                StoichP1.removeTextChangedListener(this);
                String text = StoichP1.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                StoichP1.getText().clear();
                StoichP1.append(colorized_numbers(text));
                // place the cursor at the original position
                StoichP1.setSelection(startChanged+countChanged);
                StoichP1.addTextChangedListener(this);
            }
        });
        StoichP2 = (EditText) findViewById(R.id.StoichP2);
        StoichP2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        StoichP2.addTextChangedListener(new TextWatcher() {
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
                StoichP2.removeTextChangedListener(this);
                String text = StoichP2.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                StoichP2.getText().clear();
                StoichP2.append(colorized_numbers(text));
                // place the cursor at the original position
                StoichP2.setSelection(startChanged+countChanged);
                StoichP2.addTextChangedListener(this);
            }
        });
        StoichP3 = (EditText) findViewById(R.id.StoichP3);
        StoichP3.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        StoichP3.addTextChangedListener(new TextWatcher() {
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
                StoichP3.removeTextChangedListener(this);
                String text = StoichP3.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                StoichP3.getText().clear();
                StoichP3.append(colorized_numbers(text));
                // place the cursor at the original position
                StoichP3.setSelection(startChanged+countChanged);
                StoichP3.addTextChangedListener(this);
            }
        });
        Electron = (EditText) findViewById(R.id.Electron);
        Electron.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Electron.addTextChangedListener(new TextWatcher() {
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
                Electron.removeTextChangedListener(this);
                String text = Electron.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Electron.getText().clear();
                Electron.append(colorized_numbers(text));
                // place the cursor at the original position
                Electron.setSelection(startChanged+countChanged);
                Electron.addTextChangedListener(this);
            }
        });
        Run = (Button) findViewById(R.id.Run);
        Run.setOnClickListener(RunClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);

    }


    public void onStart()
    // definováno zobrazení obecného vzorového vstupního souboru
    {
        super.onStart();
        R1(exec("cat "+getFilesDir()+"/GCM3Kin-R1.txt"));
        R2(exec("cat "+getFilesDir()+"/GCM3Kin-R2.txt"));
        R3(exec("cat "+getFilesDir()+"/GCM3Kin-R3.txt"));
        P1(exec("cat "+getFilesDir()+"/GCM3Kin-P1.txt"));
        P2(exec("cat "+getFilesDir()+"/GCM3Kin-P2.txt"));
        P3(exec("cat "+getFilesDir()+"/GCM3Kin-P3.txt"));
        SR1(exec("cat "+getFilesDir()+"/GCM3Kin-SR1.txt"));
        SR2(exec("cat "+getFilesDir()+"/GCM3Kin-SR2.txt"));
        SR3(exec("cat "+getFilesDir()+"/GCM3Kin-SR3.txt"));
        SP1(exec("cat "+getFilesDir()+"/GCM3Kin-SP1.txt"));
        SP2(exec("cat "+getFilesDir()+"/GCM3Kin-SP2.txt"));
        SP3(exec("cat "+getFilesDir()+"/GCM3Kin-SP3.txt"));
        E(exec("cat "+getFilesDir()+"/GCM3Kin-E.txt"));
    }

    private View.OnClickListener RunClick; {

        RunClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String R1 = Reactant1.getText().toString();
                String R2 = Reactant2.getText().toString();
                String R3 = Reactant3.getText().toString();
                String P1 = Product1.getText().toString();
                String P2 = Product2.getText().toString();
                String P3 = Product3.getText().toString();
                String SR1 = StoichR1.getText().toString();
                String SR2 = StoichR2.getText().toString();
                String SR3 = StoichR3.getText().toString();
                String SP1 = StoichP1.getText().toString();
                String SP2 = StoichP2.getText().toString();
                String SP3 = StoichP3.getText().toString();
                String E = Electron.getText().toString();
                String Dataset = exec("cat "+getFilesDir()+"/dataset-name.txt");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3Kin-R1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(R1);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("GCM3Kin-R2.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(R2);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("GCM3Kin-R3.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(R3);
                    outputWriter3.close();
                    FileOutputStream fileout4 = openFileOutput("GCM3Kin-P1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(P1);
                    outputWriter4.close();
                    FileOutputStream fileout5 = openFileOutput("GCM3Kin-P2.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(P2);
                    outputWriter5.close();
                    FileOutputStream fileout6 = openFileOutput("GCM3Kin-P3.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(P3);
                    outputWriter6.close();
                    FileOutputStream fileout7 = openFileOutput("GCM3Kin-SR1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter7 = new OutputStreamWriter(fileout7);
                    outputWriter7.write(SR1);
                    outputWriter7.close();
                    FileOutputStream fileout8 = openFileOutput("GCM3Kin-SR2.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                    outputWriter8.write(SR2);
                    outputWriter8.close();
                    FileOutputStream fileout9 = openFileOutput("GCM3Kin-SR3.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter9 = new OutputStreamWriter(fileout9);
                    outputWriter9.write(SR3);
                    outputWriter9.close();
                    FileOutputStream fileout10 = openFileOutput("GCM3Kin-SP1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                    outputWriter10.write(SP1);
                    outputWriter10.close();
                    FileOutputStream fileout11 = openFileOutput("GCM3Kin-SP2.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter11 = new OutputStreamWriter(fileout11);
                    outputWriter11.write(SP2);
                    outputWriter11.close();
                    FileOutputStream fileout12 = openFileOutput("GCM3Kin-SP3.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                    outputWriter12.write(SP3);
                    outputWriter12.close();
                    FileOutputStream fileoutE = openFileOutput("GCM3Kin-E.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterE = new OutputStreamWriter(fileoutE);
                    outputWriterE.write(E);
                    outputWriterE.close();
                    FileOutputStream fileout13 = openFileOutput("GCM3Kin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                    outputWriter13.write(R1+";");
                    outputWriter13.write(SR1+";");
                    outputWriter13.write(R2+";");
                    outputWriter13.write(SR2+";");
                    outputWriter13.write(R3+";");
                    outputWriter13.write(SR3+";");
                    outputWriter13.write(P1+";");
                    outputWriter13.write(SP1+";");
                    outputWriter13.write(P2+";");
                    outputWriter13.write(SP2+";");
                    outputWriter13.write(P3+";");
                    outputWriter13.write(SP3+";");
                    outputWriter13.write(E+";");
                    outputWriter13.write(Dataset);
                    outputWriter13.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                openprogressdialog();
            }
        };
    }

    private void openprogressdialog() {
        // TODO Auto-generated method stub //
//        progressDialog = new ProgressDialog(GCM3Kin.this);
//        progressDialog.setTitle("Please wait...");
//        progressDialog.setMessage("Calculation is running...");
//        progressDialog.setCancelable(false);
//        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        progressDialog.show();
//        new Thread() {
//            public void run() {
                try {
                    exec("chmod 755 -R "+getFilesDir());
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM3Kin.b "+getFilesDir()+"/GCM3Kin.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/GCM3Kin.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM3Kin.b");
                    exec("chmod 755 "+getFilesDir()+"/GCM3Kin.b");
                    try {
                        R1(exec("cat "+getFilesDir()+"/GCM3Kin-R1.txt"));
                        R2(exec("cat "+getFilesDir()+"/GCM3Kin-R2.txt"));
                        R3(exec("cat "+getFilesDir()+"/GCM3Kin-R3.txt"));
                        P1(exec("cat "+getFilesDir()+"/GCM3Kin-P1.txt"));
                        P2(exec("cat "+getFilesDir()+"/GCM3Kin-P2.txt"));
                        P3(exec("cat "+getFilesDir()+"/GCM3Kin-P3.txt"));
                        SR1(exec("cat "+getFilesDir()+"/GCM3Kin-SR1.txt"));
                        SR2(exec("cat "+getFilesDir()+"/GCM3Kin-SR2.txt"));
                        SR3(exec("cat "+getFilesDir()+"/GCM3Kin-SR3.txt"));
                        SP1(exec("cat "+getFilesDir()+"/GCM3Kin-SP1.txt"));
                        SP2(exec("cat "+getFilesDir()+"/GCM3Kin-SP2.txt"));
                        SP3(exec("cat "+getFilesDir()+"/GCM3Kin-SP3.txt"));
                        E(exec("cat "+getFilesDir()+"/GCM3Kin-E.txt"));
                        Toast.makeText(getApplicationContext(), "Calculation finished", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                    String Dataset = exec("cat "+getFilesDir()+"/dataset-name.txt");

                    exec("cp "+getFilesDir()+"/GCM3Kin_R.out "+getFilesDir()+"/GCM3Kin_R_0.out");
                    exec("cp "+getFilesDir()+"/GCM3Kin_K.out "+getFilesDir()+"/GCM3Kin_K_0.out");
                    exec("cp "+getFilesDir()+"/GCM3Kin_SMS.out "+getFilesDir()+"/GCM3Kin_SMS_0.out");
                    exec("cp "+getFilesDir()+"/GCM3Kin_SS.out "+getFilesDir()+"/GCM3Kin_SS_0.out");

                    String R = exec("cat "+getFilesDir()+"/GCM3Kin_R_0.out");
                    R = R.replace("[H2O]", "H2O");
                    R = R.replace("[H+]+", "H+");
                    R = R.replace("[OH-]-", "OH-");
                    FileOutputStream R_stream = openFileOutput("GCM3Kin_R_w.out", MODE_PRIVATE);
                    OutputStreamWriter R_writer = new OutputStreamWriter(R_stream);
                    R_writer.write(R);
                    R_writer.close();
                    exec("mv "+getFilesDir()+"/GCM3Kin_R_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_RATES_w.txt");
                    exec("rm "+getFilesDir()+"/GCM3Kin_R_0.out");

                    String K = exec("cat "+getFilesDir()+"/GCM3Kin_K_0.out");
                    K = K.replace("[H2O]", "H2O");
                    K = K.replace("[H+]+", "H+");
                    K = K.replace("[OH-]-", "OH-");
                    FileOutputStream K_stream = openFileOutput("GCM3Kin_K_w.out", MODE_PRIVATE);
                    OutputStreamWriter K_writer = new OutputStreamWriter(K_stream);
                    K_writer.write(K);
                    K_writer.close();
                    exec("mv "+getFilesDir()+"/GCM3Kin_K_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_KINETICS_w.txt");
                    exec("rm "+getFilesDir()+"/GCM3Kin_K_0.out");

                    String SMS = exec("cat "+getFilesDir()+"/GCM3Kin_SMS_0.out");
                    SMS = SMS.replace("[H2O]\t[H2O]\t0\t[H2O]\t1", "");
                    SMS = SMS.replace("[H+]\t[H+]+\t0\t[H+]\t1", "");
                    SMS = SMS.replace("[OH-]\t[OH-]-\t0\t[OH-]\t1", "");
                    FileOutputStream SMS_stream = openFileOutput("GCM3Kin_SMS_w.out", MODE_PRIVATE);
                    OutputStreamWriter SMS_writer = new OutputStreamWriter(SMS_stream);
                    SMS_writer.write(SMS);
                    SMS_writer.close();
                    exec("mv "+getFilesDir()+"/GCM3Kin_SMS_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_MASTER_SPECIES_w.txt");
                    exec("rm "+getFilesDir()+"/GCM3Kin_SMS_0.out");

                    String SS = exec("cat "+getFilesDir()+"/GCM3Kin_SS_0.out");
                    SS = SS.replace("[H2O] = [H2O]", "");
                    SS = SS.replace("[H+]+ = [H+]+", "");
                    SS = SS.replace("[OH-]- = [OH-]-", "");
                    FileOutputStream SS_stream = openFileOutput("GCM3Kin_SS_w.out", MODE_PRIVATE);
                    OutputStreamWriter SS_writer = new OutputStreamWriter(SS_stream);
                    SS_writer.write(SS);
                    SS_writer.close();
                    exec("mv "+getFilesDir()+"/GCM3Kin_SS_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_SPECIES_w.txt");
                    exec("rm "+getFilesDir()+"/GCM3Kin_SS_0.out");

                    exec("mv "+getFilesDir()+"/GCM3Kin_R.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_RATES_anhydr.txt");
                    exec("mv "+getFilesDir()+"/GCM3Kin_K.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_KINETICS_anhydr.txt");
                    exec("mv "+getFilesDir()+"/GCM3Kin_SMS.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_MASTER_SPECIES_anhydr.txt");
                    exec("mv "+getFilesDir()+"/GCM3Kin_SS.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_SPECIES_anhydr.txt");

                } catch (Exception e) {
                }
//                onFinish();
//            }
//            public void onFinish() {
//                progressDialog.dismiss();
//            }
//        }.start();
        Intent intent = new Intent(GCM3Kin.this, ResumeActivityKin.class);
        startActivity(intent);
    }


    private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(GCM3Kin.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


    @Override
    protected void onResume() {
        super.onResume();
        R1(exec("cat "+getFilesDir()+"/GCM3Kin-R1.txt"));
        R2(exec("cat "+getFilesDir()+"/GCM3Kin-R2.txt"));
        R3(exec("cat "+getFilesDir()+"/GCM3Kin-R3.txt"));
        P1(exec("cat "+getFilesDir()+"/GCM3Kin-P1.txt"));
        P2(exec("cat "+getFilesDir()+"/GCM3Kin-P2.txt"));
        P3(exec("cat "+getFilesDir()+"/GCM3Kin-P3.txt"));
        SR1(exec("cat "+getFilesDir()+"/GCM3Kin-SR1.txt"));
        SR2(exec("cat "+getFilesDir()+"/GCM3Kin-SR2.txt"));
        SR3(exec("cat "+getFilesDir()+"/GCM3Kin-SR3.txt"));
        SP1(exec("cat "+getFilesDir()+"/GCM3Kin-SP1.txt"));
        SP2(exec("cat "+getFilesDir()+"/GCM3Kin-SP2.txt"));
        SP3(exec("cat "+getFilesDir()+"/GCM3Kin-SP3.txt"));
        E(exec("cat "+getFilesDir()+"/GCM3Kin-E.txt"));
    }

    public void R1(final String str1) {
        Runnable proc1 = new Runnable() {
            public void run() {
                Reactant1.setText(colorized_numbers(str1), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc1);
    }
    public void R2(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                Reactant2.setText(colorized_numbers(str2), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc2);
    }
    public void R3(final String str5) {
        Runnable proc5 = new Runnable() {
            public void run() {
                Reactant3.setText(colorized_numbers(str5), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc5);
    }
    public void P1(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                Product1.setText(colorized_numbers(str3), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc3);
    }
    public void P2(final String str4) {
        Runnable proc4 = new Runnable() {
            public void run() {
                Product2.setText(colorized_numbers(str4), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc4);
    }
    public void P3(final String str6) {
        Runnable proc6 = new Runnable() {
            public void run() {
                Product3.setText(colorized_numbers(str6), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc6);
    }
    public void SR1(final String str7) {
        Runnable proc7 = new Runnable() {
            public void run() {
                StoichR1.setText(colorized_numbers(str7), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc7);
    }
    public void SR2(final String str8) {
        Runnable proc8 = new Runnable() {
            public void run() {
                StoichR2.setText(colorized_numbers(str8), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc8);
    }
    public void SR3(final String str9) {
        Runnable proc9 = new Runnable() {
            public void run() {
                StoichR3.setText(colorized_numbers(str9), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc9);
    }
    public void SP1(final String str10) {
        Runnable proc10 = new Runnable() {
            public void run() {
                StoichP1.setText(colorized_numbers(str10), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc10);
    }
    public void SP2(final String str11) {
        Runnable proc11 = new Runnable() {
            public void run() {
                StoichP2.setText(colorized_numbers(str11), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc11);
    }
    public void SP3(final String str12) {
        Runnable proc12 = new Runnable() {
            public void run() {
                StoichP3.setText(colorized_numbers(str12), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc12);
    }
    public void E(final String str13) {
        Runnable proc13 = new Runnable() {
            public void run() {
                Electron.setText(colorized_numbers(str13), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc13);
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
