package cz.p;

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
import android.text.Spannable;
import android.text.SpannableString;
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
     * Colorize a specific substring in a string for TextView. Use it like this: <pre>
     * textView.setText(
     *     Strings.colorized("The some words are black some are the default.","black", Color.BLACK),
     *     TextView.BufferType.SPANNABLE
     * );
     * </pre>
     * @param text Text that contains a substring to colorize
     * @param word0 The substring to colorize
     * @param word1 The substring to colorize
     * @param word2 The substring to colorize
     * @param word3 The substring to colorize
     * @param word4 The substring to colorize
     * @param word5 The substring to colorize
     * @param word6 The substring to colorize
     * @param word7 The substring to colorize
     * @param word8 The substring to colorize
     * @param word9 The substring to colorize
     * @param word10 The substring to colorize
     * @param word11 The substring to colorize
     * @param word12 The substring to colorize
     * @param argb The color
     * @return the Spannable for TextView's consumption
     */
    public static Spannable colorized(final String text, final String word0, final String word1, final String word2, final String word3, final String word4, final String word5, final String word6, final String word7, final String word8, final String word9, final String word10, final String word11, final String word12, final int argb) {
        final Spannable spannable = new SpannableString(text);
        int substringStart0=0;
        int substringStart1=0;
        int substringStart2=0;
        int substringStart3=0;
        int substringStart4=0;
        int substringStart5=0;
        int substringStart6=0;
        int substringStart7=0;
        int substringStart8=0;
        int substringStart9=0;
        int substringStart10=0;
        int substringStart11=0;
        int substringStart12=0;
        int start0;
        int start1;
        int start2;
        int start3;
        int start4;
        int start5;
        int start6;
        int start7;
        int start8;
        int start9;
        int start10;
        int start11;
        int start12;
        while((start0=text.indexOf(word0,substringStart0))>=0){
            spannable.setSpan(
                    new ForegroundColorSpan(argb),start0,start0+word0.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            );
            while((start1=text.indexOf(word1,substringStart1))>=0) {
                spannable.setSpan(
                        new ForegroundColorSpan(argb), start1, start1 + word1.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                while((start2=text.indexOf(word2,substringStart2))>=0) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb), start2, start2 + word2.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                    while((start3=text.indexOf(word3,substringStart3))>=0) {
                        spannable.setSpan(
                                new ForegroundColorSpan(argb), start3, start3 + word3.length(),
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        );
                        while((start4=text.indexOf(word4,substringStart4))>=0) {
                            spannable.setSpan(
                                    new ForegroundColorSpan(argb), start4, start4 + word4.length(),
                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            );
                            while((start5=text.indexOf(word5,substringStart5))>=0) {
                                spannable.setSpan(
                                        new ForegroundColorSpan(argb), start5, start5 + word5.length(),
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                );
                                while((start6=text.indexOf(word6,substringStart6))>=0) {
                                    spannable.setSpan(
                                            new ForegroundColorSpan(argb), start6, start6 + word6.length(),
                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                    );
                                    while((start7=text.indexOf(word7,substringStart7))>=0) {
                                        spannable.setSpan(
                                                new ForegroundColorSpan(argb), start7, start7 + word7.length(),
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                        );
                                        while((start8=text.indexOf(word8,substringStart8))>=0) {
                                            spannable.setSpan(
                                                    new ForegroundColorSpan(argb), start8, start8 + word8.length(),
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                            );
                                            while((start9=text.indexOf(word9,substringStart9))>=0) {
                                                spannable.setSpan(
                                                        new ForegroundColorSpan(argb), start9, start9 + word9.length(),
                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                );
                                                while((start10=text.indexOf(word10,substringStart10))>=0) {
                                                    spannable.setSpan(
                                                            new ForegroundColorSpan(argb), start10, start10 + word10.length(),
                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                    );
                                                    while((start11=text.indexOf(word11,substringStart11))>=0) {
                                                        spannable.setSpan(
                                                                new ForegroundColorSpan(argb), start11, start11 + word11.length(),
                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                        );
                                                        while((start12=text.indexOf(word12,substringStart12))>=0) {
                                                            spannable.setSpan(
                                                                    new ForegroundColorSpan(argb), start12, start12 + word12.length(),
                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                            );
                                                            substringStart12 = start12 + word12.length();
                                                        }
                                                        substringStart11 = start11 + word11.length();
                                                    }
                                                    substringStart10 = start10 + word10.length();
                                                }
                                                substringStart9 = start9 + word9.length();
                                            }
                                            substringStart8 = start8+word8.length();
                                        }
                                        substringStart7 = start7+word7.length();
                                    }
                                    substringStart6 = start6+word6.length();
                                }
                                substringStart5 = start5+word5.length();
                            }
                            substringStart4 = start4+word4.length();
                        }
                        substringStart3 = start3+word3.length();
                    }
                    substringStart2 = start2+word2.length();
                }
                substringStart1 = start1+word1.length();
            }
            substringStart0 = start0+word0.length();
        }
        return spannable;
    }
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
        Reactant2 = (EditText) findViewById(R.id.Reactant2);
        Reactant3 = (EditText) findViewById(R.id.Reactant3);
        Product1 = (EditText) findViewById(R.id.Product1);
        Product2 = (EditText) findViewById(R.id.Product2);
        Product3 = (EditText) findViewById(R.id.Product3);
        StoichR1 = (EditText) findViewById(R.id.StoichR1);
        StoichR2 = (EditText) findViewById(R.id.StoichR2);
        StoichR3 = (EditText) findViewById(R.id.StoichR3);
        StoichP1 = (EditText) findViewById(R.id.StoichP1);
        StoichP2 = (EditText) findViewById(R.id.StoichP2);
        StoichP3 = (EditText) findViewById(R.id.StoichP3);
        Electron = (EditText) findViewById(R.id.Electron);
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
                Reactant1.setText(str1);
            }
        };
        handler.post(proc1);
    }
    public void R2(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                Reactant2.setText(str2);
            }
        };
        handler.post(proc2);
    }
    public void R3(final String str5) {
        Runnable proc5 = new Runnable() {
            public void run() {
                Reactant3.setText(str5);
            }
        };
        handler.post(proc5);
    }
    public void P1(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                Product1.setText(str3);
            }
        };
        handler.post(proc3);
    }
    public void P2(final String str4) {
        Runnable proc4 = new Runnable() {
            public void run() {
                Product2.setText(str4);
            }
        };
        handler.post(proc4);
    }
    public void P3(final String str6) {
        Runnable proc6 = new Runnable() {
            public void run() {
                Product3.setText(str6);
            }
        };
        handler.post(proc6);
    }
    public void SR1(final String str7) {
        Runnable proc7 = new Runnable() {
            public void run() {
                StoichR1.setText(str7);
            }
        };
        handler.post(proc7);
    }
    public void SR2(final String str8) {
        Runnable proc8 = new Runnable() {
            public void run() {
                StoichR2.setText(str8);
            }
        };
        handler.post(proc8);
    }
    public void SR3(final String str9) {
        Runnable proc9 = new Runnable() {
            public void run() {
                StoichR3.setText(str9);
            }
        };
        handler.post(proc9);
    }
    public void SP1(final String str10) {
        Runnable proc10 = new Runnable() {
            public void run() {
                StoichP1.setText(str10);
            }
        };
        handler.post(proc10);
    }
    public void SP2(final String str11) {
        Runnable proc11 = new Runnable() {
            public void run() {
                StoichP2.setText(str11);
            }
        };
        handler.post(proc11);
    }
    public void SP3(final String str12) {
        Runnable proc12 = new Runnable() {
            public void run() {
                StoichP3.setText(str12);
            }
        };
        handler.post(proc12);
    }
    public void E(final String str13) {
        Runnable proc13 = new Runnable() {
            public void run() {
                Electron.setText(str13);
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

}
