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

public class GCM2Kin extends EmpiricalKin {

    private Handler handler = new Handler();
    private TextView Reactant1Label;
    private TextView Reactant2Label;
    private TextView DistanceLabel;
    private TextView Product1Label;
    private TextView Product2Label;
    private EditText Reactant1;
    private EditText Reactant2;
    private EditText Distance;
    private EditText Product1;
    private EditText Product2;
    Button Run;
    Button Quit;
    private ProgressDialog progressDialog;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gcm2kin);

        Reactant1Label = (TextView) findViewById(R.id.Reactant1Label);
        Reactant2Label = (TextView) findViewById(R.id.Reactant2Label);
        DistanceLabel = (TextView) findViewById(R.id.DistanceLabel);
        Product1Label = (TextView) findViewById(R.id.Product1Label);
        Product2Label = (TextView) findViewById(R.id.Product2Label);
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
        Distance = (EditText) findViewById(R.id.Distance);
        Distance.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Distance.addTextChangedListener(new TextWatcher() {
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
                Distance.removeTextChangedListener(this);
                String text = Distance.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Distance.getText().clear();
                Distance.append(colorized_numbers(text));
                // place the cursor at the original position
                Distance.setSelection(startChanged+countChanged);
                Distance.addTextChangedListener(this);
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
        Run = (Button) findViewById(R.id.Run);
        Run.setOnClickListener(RunClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);

    }


    public void onStart()
    // definováno zobrazení obecného vzorového vstupního souboru
    {
        super.onStart();
        R1(exec("cat "+getFilesDir()+"/GCM2Kin-R1.txt"));
        R2(exec("cat "+getFilesDir()+"/GCM2Kin-R2.txt"));
        D(exec("cat "+getFilesDir()+"/GCM2Kin-D.txt"));
        P1(exec("cat "+getFilesDir()+"/GCM2Kin-P1.txt"));
        P2(exec("cat "+getFilesDir()+"/GCM2Kin-P2.txt"));
    }

    private View.OnClickListener RunClick; {

        RunClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String R1 = Reactant1.getText().toString();
                String R2 = Reactant2.getText().toString();
                String D = Distance.getText().toString();
                String P1 = Product1.getText().toString();
                String P2 = Product2.getText().toString();
                String Dataset = exec("cat "+getFilesDir()+"/dataset-name.txt");
                try {
                    FileOutputStream fileout = openFileOutput("GCM2Kin-R1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(R1);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("GCM2Kin-R2.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(R2);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("GCM2Kin-D.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(D);
                    outputWriter3.close();
                    FileOutputStream fileout4 = openFileOutput("GCM2Kin-P1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(P1);
                    outputWriter4.close();
                    FileOutputStream fileout5 = openFileOutput("GCM2Kin-P2.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(P2);
                    outputWriter5.close();
                    FileOutputStream fileout6 = openFileOutput("GCM2Kin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(R1+",");
                    outputWriter6.write(R2+",");
                    outputWriter6.write(D+",");
                    outputWriter6.write(P1+",");
                    outputWriter6.write(P2+",");
                    outputWriter6.write(Dataset);
                    outputWriter6.close();
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
//        progressDialog = new ProgressDialog(GCM2Kin.this);
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
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM2Kin.b "+getFilesDir()+"/GCM2Kin.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/GCM2Kin.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM2Kin.b");
                    exec("chmod 755 "+getFilesDir()+"/GCM2Kin.b");
                    try {
                        R1(exec("cat "+getFilesDir()+"/GCM2Kin-R1.txt"));
                        R2(exec("cat "+getFilesDir()+"/GCM2Kin-R2.txt"));
                        D(exec("cat "+getFilesDir()+"/GCM2Kin-D.txt"));
                        P1(exec("cat "+getFilesDir()+"/GCM2Kin-P1.txt"));
                        P2(exec("cat "+getFilesDir()+"/GCM2Kin-P2.txt"));
                        Toast.makeText(getApplicationContext(), "Calculation finished", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                    String Dataset = exec("cat "+getFilesDir()+"/dataset-name.txt");

                    exec("cp "+getFilesDir()+"/GCM2Kin_R.out "+getFilesDir()+"/GCM2Kin_R_0.out");
                    exec("cp "+getFilesDir()+"/GCM2Kin_K.out "+getFilesDir()+"/GCM2Kin_K_0.out");
                    exec("cp "+getFilesDir()+"/GCM2Kin_SMS.out "+getFilesDir()+"/GCM2Kin_SMS_0.out");
                    exec("cp "+getFilesDir()+"/GCM2Kin_SS.out "+getFilesDir()+"/GCM2Kin_SS_0.out");

                    String R = exec("cat "+getFilesDir()+"/GCM2Kin_R_0.out");
                    R = R.replace("[H2O]", "H2O");
                    R = R.replace("[H+]+", "H+");
                    R = R.replace("[OH-]-", "OH-");
                    FileOutputStream R_stream = openFileOutput("GCM2Kin_R_w.out", MODE_PRIVATE);
                    OutputStreamWriter R_writer = new OutputStreamWriter(R_stream);
                    R_writer.write(R);
                    R_writer.close();
                    exec("mv "+getFilesDir()+"/GCM2Kin_R_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_RATES_w.txt");
                    exec("rm "+getFilesDir()+"/GCM2Kin_R_0.out");

                    String K = exec("cat "+getFilesDir()+"/GCM2Kin_K_0.out");
                    K = K.replace("[H2O]", "H2O");
                    K = K.replace("[H+]+", "H+");
                    K = K.replace("[OH-]-", "OH-");
                    FileOutputStream K_stream = openFileOutput("GCM2Kin_K_w.out", MODE_PRIVATE);
                    OutputStreamWriter K_writer = new OutputStreamWriter(K_stream);
                    K_writer.write(K);
                    K_writer.close();
                    exec("mv "+getFilesDir()+"/GCM2Kin_K_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_KINETICS_w.txt");
                    exec("rm "+getFilesDir()+"/GCM2Kin_K_0.out");

                    String SMS = exec("cat "+getFilesDir()+"/GCM2Kin_SMS_0.out");
                    SMS = SMS.replace("[H2O]\t[H2O]\t0\t[H2O]\t1", "");
                    SMS = SMS.replace("[H+]\t[H+]+\t0\t[H+]\t1", "");
                    SMS = SMS.replace("[OH-]\t[OH-]-\t0\t[OH-]\t1", "");
                    FileOutputStream SMS_stream = openFileOutput("GCM2Kin_SMS_w.out", MODE_PRIVATE);
                    OutputStreamWriter SMS_writer = new OutputStreamWriter(SMS_stream);
                    SMS_writer.write(SMS);
                    SMS_writer.close();
                    exec("mv "+getFilesDir()+"/GCM2Kin_SMS_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_MASTER_SPECIES_w.txt");
                    exec("rm "+getFilesDir()+"/GCM2Kin_SMS_0.out");

                    String SS = exec("cat "+getFilesDir()+"/GCM2Kin_SS_0.out");
                    SS = SS.replace("[H2O] = [H2O]", "");
                    SS = SS.replace("[H+]+ = [H+]+", "");
                    SS = SS.replace("[OH-]- = [OH-]-", "");
                    FileOutputStream SS_stream = openFileOutput("GCM2Kin_SS_w.out", MODE_PRIVATE);
                    OutputStreamWriter SS_writer = new OutputStreamWriter(SS_stream);
                    SS_writer.write(SS);
                    SS_writer.close();
                    exec("mv "+getFilesDir()+"/GCM2Kin_SS_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_SPECIES_w.txt");
                    exec("rm "+getFilesDir()+"/GCM2Kin_SS_0.out");

                    exec("mv "+getFilesDir()+"/GCM2Kin_R.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_RATES_anhydr.txt");
                    exec("mv "+getFilesDir()+"/GCM2Kin_K.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_KINETICS_anhydr.txt");
                    exec("mv "+getFilesDir()+"/GCM2Kin_SMS.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_MASTER_SPECIES_anhydr.txt");
                    exec("mv "+getFilesDir()+"/GCM2Kin_SS.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_SPECIES_anhydr.txt");

                } catch (Exception e) {
                }
//                onFinish();
//            }
//            public void onFinish() {
//                progressDialog.dismiss();
//            }
//        }.start();
        Intent intent = new Intent(GCM2Kin.this, ResumeActivityKin.class);
        startActivity(intent);
    }


    private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(GCM2Kin.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


    @Override
    protected void onResume() {
        super.onResume();
        R1(exec("cat "+getFilesDir()+"/GCM2Kin-R1.txt"));
        R2(exec("cat "+getFilesDir()+"/GCM2Kin-R2.txt"));
        D(exec("cat "+getFilesDir()+"/GCM2Kin-D.txt"));
        P1(exec("cat "+getFilesDir()+"/GCM2Kin-P1.txt"));
        P2(exec("cat "+getFilesDir()+"/GCM2Kin-P2.txt"));
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
    public void D(final String strD) {
        Runnable procD = new Runnable() {
            public void run() {
                Distance.setText(colorized_numbers(strD), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procD);
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
