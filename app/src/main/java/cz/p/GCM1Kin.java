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

public class GCM1Kin extends EmpiricalKin {

    private Handler handler = new Handler();
    private TextView Reactant1Label;
    private TextView Reactant2Label;
    private TextView DistanceLabel;
    private EditText Reactant1;
    private EditText Reactant2;
    private EditText Distance;
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
        setContentView(R.layout.gcm1kin);

        Reactant1Label = (TextView) findViewById(R.id.Reactant1Label);
        Reactant2Label = (TextView) findViewById(R.id.Reactant2Label);
        DistanceLabel = (TextView) findViewById(R.id.DistanceLabel);
        Reactant1 = (EditText) findViewById(R.id.Reactant1);
        Reactant1.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Reactant2 = (EditText) findViewById(R.id.Reactant2);
        Reactant2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Distance = (EditText) findViewById(R.id.Distance);
        Distance.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Run = (Button) findViewById(R.id.Run);
        Run.setOnClickListener(RunClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);

    }


    public void onStart()
    // definováno zobrazení obecného vzorového vstupního souboru
    {
        super.onStart();
        R1(exec("cat "+getFilesDir()+"/GCM1Kin-R1.txt"));
        R2(exec("cat "+getFilesDir()+"/GCM1Kin-R2.txt"));
        D(exec("cat "+getFilesDir()+"/GCM1Kin-D.txt"));
    }

    private View.OnClickListener RunClick; {

        RunClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String R1 = Reactant1.getText().toString();
                String R2 = Reactant2.getText().toString();
                String D = Distance.getText().toString();
                String Dataset = exec("cat "+getFilesDir()+"/dataset-name.txt");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1Kin-R1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(R1);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("GCM1Kin-R2.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(R2);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("GCM1Kin-D.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(D);
                    outputWriter3.close();
                    FileOutputStream fileout4 = openFileOutput("GCM1Kin.inp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(R1+",");
                    outputWriter4.write(R2+",");
                    outputWriter4.write(D+",");
                    outputWriter4.write(Dataset+"_forward,");
                    outputWriter4.write(Dataset+"_backward");
                    outputWriter4.close();
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
//        progressDialog = new ProgressDialog(GCM1Kin.this);
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
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM1Kin.b "+getFilesDir()+"/GCM1Kin.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/GCM1Kin.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM1Kin.b");
                    exec("chmod 755 "+getFilesDir()+"/GCM1Kin.b");
                    try {
                        R1(exec("cat "+getFilesDir()+"/GCM1Kin-R1.txt"));
                        R2(exec("cat "+getFilesDir()+"/GCM1Kin-R2.txt"));
                        D(exec("cat "+getFilesDir()+"/GCM1Kin-D.txt"));
                        Toast.makeText(getApplicationContext(), "Calculation finished", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }

                    String Dataset = exec("cat "+getFilesDir()+"/dataset-name.txt");

                    exec("cp "+getFilesDir()+"/GCM1Kin_Rf.out "+getFilesDir()+"/GCM1Kin_Rf_0.out");
                    exec("cp "+getFilesDir()+"/GCM1Kin_Rb.out "+getFilesDir()+"/GCM1Kin_Rb_0.out");
                    exec("cp "+getFilesDir()+"/GCM1Kin_Kf.out "+getFilesDir()+"/GCM1Kin_Kf_0.out");
                    exec("cp "+getFilesDir()+"/GCM1Kin_Kb.out "+getFilesDir()+"/GCM1Kin_Kb_0.out");
                    exec("cp "+getFilesDir()+"/GCM1Kin_SMS.out "+getFilesDir()+"/GCM1Kin_SMS_0.out");
                    exec("cp "+getFilesDir()+"/GCM1Kin_SS.out "+getFilesDir()+"/GCM1Kin_SS_0.out");

                    String Rf = exec("cat "+getFilesDir()+"/GCM1Kin_Rf_0.out");
                    Rf = Rf.replace("[H2O]", "H2O");
                    Rf = Rf.replace("[H+]+", "H+");
                    Rf = Rf.replace("[OH-]-", "OH-");
                    FileOutputStream Rf_stream = openFileOutput("GCM1Kin_Rf_w.out", MODE_PRIVATE);
                    OutputStreamWriter Rf_writer = new OutputStreamWriter(Rf_stream);
                    Rf_writer.write(Rf);
                    Rf_writer.close();
                    exec("mv "+getFilesDir()+"/GCM1Kin_Rf_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_forward_RATES_w.txt");
                    exec("rm "+getFilesDir()+"/GCM1Kin_Rf_0.out");

                    String Rb = exec("cat "+getFilesDir()+"/GCM1Kin_Rb_0.out");
                    Rb = Rb.replace("[H2O]", "H2O");
                    Rb = Rb.replace("[H+]+", "H+");
                    Rb = Rb.replace("[OH-]-", "OH-");
                    FileOutputStream Rb_stream = openFileOutput("GCM1Kin_Rb_w.out", MODE_PRIVATE);
                    OutputStreamWriter Rb_writer = new OutputStreamWriter(Rb_stream);
                    Rb_writer.write(Rb);
                    Rb_writer.close();
                    exec("mv "+getFilesDir()+"/GCM1Kin_Rb_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_backward_RATES_w.txt");
                    exec("rm "+getFilesDir()+"/GCM1Kin_Rb_0.out");

                    String Kf = exec("cat "+getFilesDir()+"/GCM1Kin_Kf_0.out");
                    Kf = Kf.replace("[H2O]", "H2O");
                    Kf = Kf.replace("[H+]+", "H+");
                    Kf = Kf.replace("[OH-]-", "OH-");
                    FileOutputStream Kf_stream = openFileOutput("GCM1Kin_Kf_w.out", MODE_PRIVATE);
                    OutputStreamWriter Kf_writer = new OutputStreamWriter(Kf_stream);
                    Kf_writer.write(Kf);
                    Kf_writer.close();
                    exec("mv "+getFilesDir()+"/GCM1Kin_Kf_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_forward_KINETICS_w.txt");
                    exec("rm "+getFilesDir()+"/GCM1Kin_Kf_0.out");

                    String Kb = exec("cat "+getFilesDir()+"/GCM1Kin_Kb_0.out");
                    Kb = Kb.replace("[H2O]", "H2O");
                    Kb = Kb.replace("[H+]+", "H+");
                    Kb = Kb.replace("[OH-]-", "OH-");
                    FileOutputStream Kb_stream = openFileOutput("GCM1Kin_Kb_w.out", MODE_PRIVATE);
                    OutputStreamWriter Kb_writer = new OutputStreamWriter(Kb_stream);
                    Kb_writer.write(Kb);
                    Kb_writer.close();
                    exec("mv "+getFilesDir()+"/GCM1Kin_Kb_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_backward_KINETICS_w.txt");
                    exec("rm "+getFilesDir()+"/GCM1Kin_Kb_0.out");

                    String SMS = exec("cat "+getFilesDir()+"/GCM1Kin_SMS_0.out");
                    SMS = SMS.replace("[H2O]\t[H2O]\t0\t[H2O]\t1", "");
                    SMS = SMS.replace("[H+]\t[H+]+\t0\t[H+]\t1", "");
                    SMS = SMS.replace("[OH-]\t[OH-]-\t0\t[OH-]\t1", "");
                    FileOutputStream SMS_stream = openFileOutput("GCM1Kin_SMS_w.out", MODE_PRIVATE);
                    OutputStreamWriter SMS_writer = new OutputStreamWriter(SMS_stream);
                    SMS_writer.write(SMS);
                    SMS_writer.close();
                    exec("mv "+getFilesDir()+"/GCM1Kin_SMS_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_MASTER_SPECIES_w.txt");
                    exec("rm "+getFilesDir()+"/GCM1Kin_SMS_0.out");

                    String SS = exec("cat "+getFilesDir()+"/GCM1Kin_SS_0.out");
                    SS = SS.replace("[H2O] = [H2O]", "");
                    SS = SS.replace("[H+]+ = [H+]+", "");
                    SS = SS.replace("[OH-]- = [OH-]-", "");
                    FileOutputStream SS_stream = openFileOutput("GCM1Kin_SS_w.out", MODE_PRIVATE);
                    OutputStreamWriter SS_writer = new OutputStreamWriter(SS_stream);
                    SS_writer.write(SS);
                    SS_writer.close();
                    exec("mv "+getFilesDir()+"/GCM1Kin_SS_w.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_SPECIES_w.txt");
                    exec("rm "+getFilesDir()+"/GCM1Kin_SS_0.out");

                    exec("mv "+getFilesDir()+"/GCM1Kin_Rf.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_forward_RATES_anhydr.txt");
                    exec("mv "+getFilesDir()+"/GCM1Kin_Rb.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_backward_RATES_anhydr.txt");
                    exec("mv "+getFilesDir()+"/GCM1Kin_Kf.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_forward_KINETICS_anhydr.txt");
                    exec("mv "+getFilesDir()+"/GCM1Kin_Kb.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_backward_KINETICS_anhydr.txt");
                    exec("mv "+getFilesDir()+"/GCM1Kin_SMS.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_MASTER_SPECIES_anhydr.txt");
                    exec("mv "+getFilesDir()+"/GCM1Kin_SS.out "+getFilesDir()+"/openbabel/kinetics/"+Dataset+"_SOLUTION_SPECIES_anhydr.txt");

                } catch (Exception e) {
                }
//                onFinish();
//            }
//            public void onFinish() {
//                progressDialog.dismiss();
//            }
//        }.start();
        Intent intent = new Intent(GCM1Kin.this, ResumeActivityKin.class);
        startActivity(intent);
    }


    private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(GCM1Kin.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


    @Override
    protected void onResume() {
        super.onResume();
        R1(exec("cat "+getFilesDir()+"/GCM1Kin-R1.txt"));
        R2(exec("cat "+getFilesDir()+"/GCM1Kin-R2.txt"));
        D(exec("cat "+getFilesDir()+"/GCM1Kin-D.txt"));
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
    public void D(final String strD) {
        Runnable procD = new Runnable() {
            public void run() {
                Distance.setText(strD);
            }
        };
        handler.post(procD);
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
