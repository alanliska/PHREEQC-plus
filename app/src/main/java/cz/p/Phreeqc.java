package cz.p;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
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

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Phreeqc extends MainActivity {

    // very important - each code must be different!!!
    private static final int READ_FILE1 = 1;
    private static final int READ_FILE2 = 2;
    private static final int READ_FILE3 = 3;
    private static final int READ_FILE4 = 4;
    private static final int READ_FILE5 = 5;
    private static final int READ_FILE6 = 6;
    private static final int READ_FILE7 = 7;
    private static final int READ_FILE8 = 8;
    private Uri documentUri1;
    private Uri documentUri2;
    private Uri documentUri3;
    private Uri documentUri4;
    private Uri documentUri5;
    private Uri documentUri6;
    private Uri documentUri7;
    private Uri documentUri8;
    private Handler handler = new Handler();
    private boolean isCanceled;


private TextView Description;
Button AddSS;
Button ResetSS;
private TextView ModifyLabel;
private EditText ModifyEdit;
Button modifybutton;
private TextView ModifyLabel12;
private EditText ModifyEdit12;
Button modifybutton12;
private TextView ModifyLabel2;
Button saveDatabasefile;
Button AddP;
Button ResetP;
private TextView PhreeqcLabel;
private EditText PhreeqcInput;
Button openInputfile;
Button saveInputfile;
Button RunPhreeqc;
Button saveOutputfile;
Button Highlight;
Button Quit;
private TextView textViewX;
private TextView outputView;
private EditText outputView2;
Button SelectDatabase;
private TextView DataLabel;
private TextView Data;
private TextView SSLabel;
private TextView SS;
private TextView PLabel;
private TextView P;
private Button AddSMS_kin;
private TextView SMSLabel_kin;
private TextView SMS_kin;
private Button AddSS_kin;
private TextView SSLabel_kin;
private TextView SS_kin;
private Button AddR_kin;
private TextView RLabel_kin;
private TextView R_kin;
private Button AddK_kin;
private TextView KLabel_kin;
private TextView K_kin;
private TextView Label0;
private TextView Label1;
private TextView Label2;
private Button ResetKin;
Button Help;




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
        setContentView(R.layout.phreeqc);

        AddSS = (Button) findViewById(R.id.AddSS);
        AddSS.setOnClickListener(AddSSClick);
        ResetSS = (Button) findViewById(R.id.ResetSS);
        ResetSS.setOnClickListener(ResetSSClick);
        ModifyLabel = (TextView) findViewById(R.id.ModifyLabel);
        ModifyEdit = (EditText) findViewById(R.id.ModifyEdit);
        modifybutton = (Button) findViewById(R.id.modifybutton);
        modifybutton.setOnClickListener(modifybuttonClick);
        ModifyLabel2 = (TextView) findViewById(R.id.ModifyLabel2);
        ModifyEdit12 = (EditText) findViewById(R.id.ModifyEdit12);
        modifybutton12 = (Button) findViewById(R.id.modifybutton12);
        modifybutton12.setOnClickListener(modifybutton12Click);
        ModifyLabel12 = (TextView) findViewById(R.id.ModifyLabel12);
        AddP = (Button) findViewById(R.id.AddP);
        AddP.setOnClickListener(AddPClick);
        SelectDatabase = (Button) findViewById(R.id.SelectDatabase);
        SelectDatabase.setOnClickListener(SelectDatabaseClick);
        DataLabel = (TextView) findViewById(R.id.DataLabel);
        Data = (TextView) findViewById(R.id.Data);
        SSLabel = (TextView) findViewById(R.id.SSLabel);
        SS = (TextView) findViewById(R.id.SS);
        PLabel = (TextView) findViewById(R.id.PLabel);
        P = (TextView) findViewById(R.id.P);
        ResetP = (Button) findViewById(R.id.ResetP);
        ResetP.setOnClickListener(ResetPClick);
        ResetKin = (Button) findViewById(R.id.ResetKin);
        ResetKin.setOnClickListener(ResetKinClick);
        PhreeqcLabel = (TextView) findViewById(R.id.PhreeqcLabel);
        PhreeqcInput = (EditText) findViewById(R.id.PhreeqcInput);
        openInputfile = (Button) findViewById(R.id.openInputfile);
        openInputfile.setOnClickListener(openInputfileClick);
        saveInputfile = (Button) findViewById(R.id.saveInputfile);
        saveInputfile.setOnClickListener(saveInputfileClick);
        RunPhreeqc = (Button) findViewById(R.id.RunPhreeqc);
        RunPhreeqc.setOnClickListener(RunPhreeqcClick);
        saveOutputfile = (Button) findViewById(R.id.saveOutputfile);
        saveOutputfile.setOnClickListener(saveOutputfileClick);
        Highlight = (Button) findViewById(R.id.Highlight);
        Highlight.setOnClickListener(HighlightClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        textViewX = (TextView) findViewById(R.id.textViewX);
        outputView = (TextView) findViewById(R.id.outputView);
        outputView2 = (EditText) findViewById(R.id.outputView2);

        AddSMS_kin = (Button) findViewById(R.id.AddSMS_kin);
        AddSMS_kin.setOnClickListener(AddSMS_kinClick);
        SMSLabel_kin = (TextView) findViewById(R.id.SMSLabel_kin);
        SMS_kin = (TextView) findViewById(R.id.SMS_kin);

        AddSS_kin = (Button) findViewById(R.id.AddSS_kin);
        AddSS_kin.setOnClickListener(AddSS_kinClick);
        SSLabel_kin = (TextView) findViewById(R.id.SSLabel_kin);
        SS_kin = (TextView) findViewById(R.id.SS_kin);

        AddR_kin = (Button) findViewById(R.id.AddR_kin);
        AddR_kin.setOnClickListener(AddR_kinClick);
        RLabel_kin = (TextView) findViewById(R.id.RLabel_kin);
        R_kin = (TextView) findViewById(R.id.R_kin);

        AddK_kin = (Button) findViewById(R.id.AddK_kin);
        AddK_kin.setOnClickListener(AddK_kinClick);
        KLabel_kin = (TextView) findViewById(R.id.KLabel_kin);
        K_kin = (TextView) findViewById(R.id.K_kin);

        Label0 = (TextView) findViewById(R.id.Label0);
        Label1 = (TextView) findViewById(R.id.Label1);
        Label2 = (TextView) findViewById(R.id.Label2);

        ResetKin = (Button) findViewById(R.id.ResetKin);

        Help = (Button) findViewById(R.id.Help);
        Help.setOnClickListener(onHelpClick);

    }


    public void onStart()
    {
        super.onStart();
        // for now - from MainActivity - there it is not working
        exec("rm "+getFilesDir()+"/Database_g2.dat");
        exec("rm "+getFilesDir()+"/Database_g1.dat");

        exec("rm "+getFilesDir()+"/Database_s2.dat");
        exec("rm "+getFilesDir()+"/Database_s1.dat");

        File filePathP = new File(getFilesDir()+File.separator+"Gas.dat");

            if (!filePathP.exists()) {
                try {
                FileOutputStream fileoutP = openFileOutput("P.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterP = new OutputStreamWriter(fileoutP);
                outputWriterP.write("Phases fragment Gas.dat does not exist.");
                outputWriterP.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                    try {
                FileOutputStream fileoutP = openFileOutput("P.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterP = new OutputStreamWriter(fileoutP);
                outputWriterP.write("Phases fragment Gas.dat is available.");
                outputWriterP.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }

            File filePathSS = new File(getFilesDir()+File.separator+"Solution.dat");
                if (!filePathSS.exists()) {
                    try {
                    FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                    outputWriterSS.write("Solution species fragment Solution.dat does not exist.");
                    outputWriterSS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                        try {
                    FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                    outputWriterSS.write("Solution species fragment Solution.dat is available.");
                    outputWriterSS.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }

        File filePathSMS_kin = new File(getFilesDir()+"/SMS_kin.txt");

        if (!filePathSMS_kin.exists()) {
            try {
                FileOutputStream fileoutSMS_kin = openFileOutput("SMS_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                outputWriterSMS_kin.write("Solution master species fragment SMS_kin.txt does not exist.");
                outputWriterSMS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutSMS_kin = openFileOutput("SMS_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                outputWriterSMS_kin.write("Solution master species fragment SMS_kin.txt is available.");
                outputWriterSMS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File filePathSS_kin = new File(getFilesDir()+"/SS_kin.txt");
        if (!filePathSS_kin.exists()) {
            try {
                FileOutputStream fileoutSS_kin = openFileOutput("SS_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSS_kin = new OutputStreamWriter(fileoutSS_kin);
                outputWriterSS_kin.write("Solution species fragment SS_kin.txt does not exist.");
                outputWriterSS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutSS_kin = openFileOutput("SS_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSS_kin = new OutputStreamWriter(fileoutSS_kin);
                outputWriterSS_kin.write("Solution species fragment SS_kin.txt is available.");
                outputWriterSS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File filePathR_kin = new File(getFilesDir()+"/R_kin.txt");
        if (!filePathR_kin.exists()) {
            try {
                FileOutputStream fileoutR_kin = openFileOutput("R_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterR_kin = new OutputStreamWriter(fileoutR_kin);
                outputWriterR_kin.write("Rates fragment R_kin.txt does not exist.");
                outputWriterR_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutR_kin = openFileOutput("R_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterR_kin = new OutputStreamWriter(fileoutR_kin);
                outputWriterR_kin.write("Rates fragment R_kin.txt is available.");
                outputWriterR_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File filePathK_kin = new File(getFilesDir()+"/K_kin.txt");
        if (!filePathK_kin.exists()) {
            try {
                FileOutputStream fileoutK_kin = openFileOutput("K_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterK_kin = new OutputStreamWriter(fileoutK_kin);
                outputWriterK_kin.write("Kinetics fragment K_kin.txt does not exist.");
                outputWriterK_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutK_kin = openFileOutput("K_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterK_kin = new OutputStreamWriter(fileoutK_kin);
                outputWriterK_kin.write("Kinetics fragment K_kin.txt is available.");
                outputWriterK_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
        output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
        output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
        pView(exec("cat "+getFilesDir()+"/P.txt"));
        ssView(exec("cat "+getFilesDir()+"/SS.txt"));
        dataView(exec("cat "+getFilesDir()+"/Database.txt"));
        sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
        ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
        r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
        k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
    }

    private View.OnClickListener AddSSClick; {

        AddSSClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read1(getApplicationContext());
                outputX(exec("cat "+getFilesDir()+"/Solution.dat"));
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }

    private View.OnClickListener AddPClick; {

        AddPClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read2(getApplicationContext());
                outputX(exec("cat "+getFilesDir()+"/Gas.dat"));
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }

    private View.OnClickListener SelectDatabaseClick; {

        SelectDatabaseClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Phreeqc.this, SelectDatabase.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener openInputfileClick; {

        openInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read4(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }

    private View.OnClickListener AddSMS_kinClick; {

        AddSMS_kinClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read5(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }

    private View.OnClickListener AddSS_kinClick; {

        AddSS_kinClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read6(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }

    private View.OnClickListener AddR_kinClick; {

        AddR_kinClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read7(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }

    private View.OnClickListener AddK_kinClick; {

        AddK_kinClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read8(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }



    private void read1(Context context1) {
        Intent intent1 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        startActivityForResult(intent1, READ_FILE1);
    }

    private void read2(Context context2) {
        Intent intent2 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent2.addCategory(Intent.CATEGORY_OPENABLE);
        intent2.setType("text/plain");
        startActivityForResult(intent2, READ_FILE2);
    }


    private void read4(Context context4) {
        Intent intent4 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent4.addCategory(Intent.CATEGORY_OPENABLE);
        intent4.setType("text/plain");
        startActivityForResult(intent4, READ_FILE4);
    }

    private void read5(Context context5) {
        Intent intent5 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent5.addCategory(Intent.CATEGORY_OPENABLE);
        intent5.setType("text/plain");
        startActivityForResult(intent5, READ_FILE5);
    }

    private void read6(Context context6) {
        Intent intent6 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent6.addCategory(Intent.CATEGORY_OPENABLE);
        intent6.setType("text/plain");
        startActivityForResult(intent6, READ_FILE6);
    }

    private void read7(Context context7) {
        Intent intent7 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent7.addCategory(Intent.CATEGORY_OPENABLE);
        intent7.setType("text/plain");
        startActivityForResult(intent7, READ_FILE7);
    }

    private void read8(Context context8) {
        Intent intent8 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent8.addCategory(Intent.CATEGORY_OPENABLE);
        intent8.setType("text/plain");
        startActivityForResult(intent8, READ_FILE8);
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

                FileOutputStream fileout = openFileOutput("FragmentSS.dat", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd1.close();

                exec("chmod 755 "+getFilesDir()+"/FragmentSS.dat");
                String SelectedSolFragment = exec("cat "+getFilesDir()+"/FragmentSS.dat");
                try {
                    FileOutputStream fileout80 = openFileOutput("Solution.dat",MODE_APPEND);
                    OutputStreamWriter outputWriter15 = new OutputStreamWriter(fileout80);
                    outputWriter15.write(SelectedSolFragment);
                    outputWriter15.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // important!
                outputX(exec("cat "+getFilesDir()+"/Solution.dat"));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE2 && data != null) {
            try {
                documentUri2 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd2 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd2.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("FragmentP.dat", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd2.close();

                exec("chmod 755 "+getFilesDir()+"/FragmentP.dat");
                String SelectedSolFragment = exec("cat "+getFilesDir()+"/FragmentP.dat");
                try {
                    FileOutputStream fileout90 = openFileOutput("Gas.dat",MODE_APPEND);
                    OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout90);
                    outputWriter16.write(SelectedSolFragment);
                    outputWriter16.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // important!
                outputX(exec("cat "+getFilesDir()+"/Gas.dat"));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE4 && data != null) {
            try {
                documentUri4 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd4 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd4.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("Input-phreeqc.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd4.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE5 && data != null) {
            try {
                documentUri5 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd5 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd5.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("SMS_kin.tmp", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd5.close();

                exec("chmod 755 "+getFilesDir()+"/SMS_kin.tmp");
                String SelectedAppendedFragment = exec("cat "+getFilesDir()+"/SMS_kin.tmp");
                try {
                    FileOutputStream fileout5 = openFileOutput("SMS_kin.txt",MODE_APPEND);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(SelectedAppendedFragment);
                    outputWriter5.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // important!
                outputX(exec("cat "+getFilesDir()+"/SMS_kin.txt"));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE6 && data != null) {
            try {
                documentUri6 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd6 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd6.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("SS_kin.tmp", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd6.close();

                exec("chmod 755 "+getFilesDir()+"/SS_kin.tmp");
                String SelectedAppendedFragment = exec("cat "+getFilesDir()+"/SS_kin.tmp");
                try {
                    FileOutputStream fileout5 = openFileOutput("SS_kin.txt",MODE_APPEND);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(SelectedAppendedFragment);
                    outputWriter5.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // important!
                outputX(exec("cat "+getFilesDir()+"/SS_kin.txt"));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE7 && data != null) {
            // select database
            try {
                documentUri7 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd7 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd7.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("R_kin.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd7.close();

                exec("chmod 755 "+getFilesDir()+"/R_kin.tmp");
                String SelectedAppendedFragment = exec("cat "+getFilesDir()+"/R_kin.tmp");
                try {
                    FileOutputStream fileout5 = openFileOutput("R_kin.txt",MODE_APPEND);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(SelectedAppendedFragment);
                    outputWriter5.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // tady to je dulezite!
                outputX(exec("cat "+getFilesDir()+"/R_kin.txt"));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE8 && data != null) {
            try {
                documentUri8 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd8 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd8.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("K_kin.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd8.close();

                exec("chmod 755 "+getFilesDir()+"/K_kin.tmp");
                String SelectedAppendedFragment = exec("cat "+getFilesDir()+"/K_kin.tmp");
                try {
                    FileOutputStream fileout5 = openFileOutput("K_kin.txt",MODE_APPEND);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(SelectedAppendedFragment);
                    outputWriter5.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // important!
                outputX(exec("cat "+getFilesDir()+"/K_kin.txt"));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private View.OnClickListener ResetSSClick; {

        ResetSSClick = new View.OnClickListener() {
            public void onClick(View v) {



                // TODO Auto-generated method stub //
            exec("rm "+getFilesDir()+"/FragmentSS.dat");
            exec("rm "+getFilesDir()+"/Solution.dat");

                File filePathP = new File(getFilesDir()+File.separator+"Gas.dat");

                if (!filePathP.exists()) {
                    try {
                        FileOutputStream fileoutP = openFileOutput("P.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterP = new OutputStreamWriter(fileoutP);
                        outputWriterP.write("Phases fragment Gas.dat does not exist.");
                        outputWriterP.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutP = openFileOutput("P.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterP = new OutputStreamWriter(fileoutP);
                        outputWriterP.write("Phases fragment Gas.dat is available.");
                        outputWriterP.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathSS = new File(getFilesDir()+File.separator+"Solution.dat");
                if (!filePathSS.exists()) {
                    try {
                        FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                        outputWriterSS.write("Solution species fragment Solution.dat does not exist.");
                        outputWriterSS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                        outputWriterSS.write("Solution species fragment Solution.dat is available.");
                        outputWriterSS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathSMS_kin = new File(getFilesDir()+"/SMS_kin.txt");

                if (!filePathSMS_kin.exists()) {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("SMS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("Solution master species fragment SMS_kin.txt does not exist.");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("SMS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("Solution master species fragment SMS_kin.txt is available.");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathSS_kin = new File(getFilesDir()+"/SS_kin.txt");
                if (!filePathSS_kin.exists()) {
                    try {
                        FileOutputStream fileoutSS_kin = openFileOutput("SS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS_kin = new OutputStreamWriter(fileoutSS_kin);
                        outputWriterSS_kin.write("Solution species fragment SS_kin.txt does not exist.");
                        outputWriterSS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSS_kin = openFileOutput("SS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS_kin = new OutputStreamWriter(fileoutSS_kin);
                        outputWriterSS_kin.write("Solution species fragment SS_kin.txt is available.");
                        outputWriterSS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathR_kin = new File(getFilesDir()+"/R_kin.txt");
                if (!filePathR_kin.exists()) {
                    try {
                        FileOutputStream fileoutR_kin = openFileOutput("R_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterR_kin = new OutputStreamWriter(fileoutR_kin);
                        outputWriterR_kin.write("Rates fragment R_kin.txt does not exist.");
                        outputWriterR_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutR_kin = openFileOutput("R_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterR_kin = new OutputStreamWriter(fileoutR_kin);
                        outputWriterR_kin.write("Rates fragment R_kin.txt is available.");
                        outputWriterR_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathK_kin = new File(getFilesDir()+"/K_kin.txt");
                if (!filePathK_kin.exists()) {
                    try {
                        FileOutputStream fileoutK_kin = openFileOutput("K_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterK_kin = new OutputStreamWriter(fileoutK_kin);
                        outputWriterK_kin.write("Kinetics fragment K_kin.txt does not exist.");
                        outputWriterK_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutK_kin = openFileOutput("K_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterK_kin = new OutputStreamWriter(fileoutK_kin);
                        outputWriterK_kin.write("Kinetics fragment K_kin.txt is available.");
                        outputWriterK_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                output2(""); // not to show content of yet deleted file Solution.dat
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }

    private View.OnClickListener modifybuttonClick; {

        modifybuttonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Keywordfile = ModifyEdit.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Keywords.phr", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Keywordfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("cp "+getFilesDir()+"/Keywords.phr "+getFilesDir()+"/Solution_species.dat");
                //here must be cp and not mv - we want to sort the first created Dolution.dat (contains appended MOPAC results) and then to create the second file Solution.dat, to which add sth else in modifyedit12
                exec("mv "+getFilesDir()+"/Solution.dat "+getFilesDir()+"/Selected.dat");
                // TODO Auto-generated method stub //
                openprogressdialog4();

            }
        };
    }

    private void openprogressdialog4() {
        // TODO Auto-generated method stub //
        progressDialog = new ProgressDialog(Phreeqc.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Retrieving data...");
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
                    exec("mv "+getFilesDir()+"/Solution_species.dat "+getFilesDir()+"/work");
                    exec("chmod 755 -R "+getFilesDir()+"/work");
                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc-prepare.so");
                    exec("chmod 755 "+getFilesDir()+"/DatabaseFragment.dat");
                    exec("mv "+getFilesDir()+"/DatabaseFragment.dat "+getFilesDir()+"/Solution0.dat");

                    String PHREEQCexportedFragment = exec("cat "+getFilesDir()+"/Solution0.dat");
                    try {
                        FileOutputStream fileout1112 = openFileOutput("Solution.dat",MODE_APPEND);
                        OutputStreamWriter outputWriter1112 = new OutputStreamWriter(fileout1112);
                        outputWriter1112.write(PHREEQCexportedFragment);
                        outputWriter1112.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {

                        File filePathSS = new File(getFilesDir()+File.separator+"Solution.dat");
                        if (!filePathSS.exists()) {
                            try {
                                FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                                outputWriterSS.write("Solution species fragment Solution.dat does not exist.");
                                outputWriterSS.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                                outputWriterSS.write("Solution species fragment Solution.dat is available.");
                                outputWriterSS.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        output2highlighted(exec("cat "+getFilesDir()+"/Solution.dat"));
                        output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                        output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                        output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                        pView(exec("cat "+getFilesDir()+"/P.txt"));
                        ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                        dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                        sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                        ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                        r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                        k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
                        Toast.makeText(getApplicationContext(), "External include file /data/data/cz.p/files/Solution.dat generated successfully.", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
                onFinish();
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

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2highlighted(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized(str2, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                    }
                };
                handler.post(proc2);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }










    private View.OnClickListener modifybutton12Click; {

        modifybutton12Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Keywordfile = ModifyEdit12.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Keywords2.phr", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Keywordfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("cp "+getFilesDir()+"/Keywords2.phr "+getFilesDir()+"/Solution_species.dat");
                exec("cp "+getFilesDir()+"/Database.dat "+getFilesDir()+"/Selected.dat");
                // TODO Auto-generated method stub //
                openprogressdialog14();

            }
        };
    }

    private void openprogressdialog14() {
        // TODO Auto-generated method stub //
        progressDialog = new ProgressDialog(Phreeqc.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Retrieving data...");
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
                    exec("mv "+getFilesDir()+"/Solution_species.dat "+getFilesDir()+"/work");
                    exec("chmod 755 -R "+getFilesDir()+"/work");
                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc-prepare.so");
                    exec("chmod 755 "+getFilesDir()+"/DatabaseFragment.dat");
                    exec("mv "+getFilesDir()+"/DatabaseFragment.dat "+getFilesDir()+"/Solution0.dat");
                    // (from the PHREEQC database - tnow it is needed to add it to Solution.dat from MOPAC calculation:
                    String PHREEQCexportedFragment = exec("cat "+getFilesDir()+"/Solution0.dat");
                    try {
                        FileOutputStream fileout1111 = openFileOutput("Solution.dat",MODE_APPEND);
                        OutputStreamWriter outputWriter1111 = new OutputStreamWriter(fileout1111);
                        outputWriter1111.write(PHREEQCexportedFragment);
                        outputWriter1111.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        File filePathSS = new File(getFilesDir()+File.separator+"Solution.dat");
                        if (!filePathSS.exists()) {
                            try {
                                FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                                outputWriterSS.write("Solution species fragment Solution.dat does not exist.");
                                outputWriterSS.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                                OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                                outputWriterSS.write("Solution species fragment Solution.dat is available.");
                                outputWriterSS.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        output2highlighted(exec("cat "+getFilesDir()+"/Solution.dat"));
                        output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                        output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                        output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                        pView(exec("cat "+getFilesDir()+"/P.txt"));
                        ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                        dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                        sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                        ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                        r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                        k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
                        Toast.makeText(getApplicationContext(), "External include file /data/data/cz.p/files/Solution.dat generated successfully.", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
                onFinish();
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

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2highlighted(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized(str2, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                    }
                };
                handler.post(proc2);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }



    private View.OnClickListener ResetPClick; {

        ResetPClick = new View.OnClickListener() {
            public void onClick(View v) {



                // TODO Auto-generated method stub //
                exec("rm "+getFilesDir()+"/FragmentP.dat");
                exec("rm "+getFilesDir()+"/Gas.dat");

                File filePathP = new File(getFilesDir()+File.separator+"Gas.dat");

                if (!filePathP.exists()) {
                    try {
                        FileOutputStream fileoutP = openFileOutput("P.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterP = new OutputStreamWriter(fileoutP);
                        outputWriterP.write("Phases fragment Gas.dat does not exist.");
                        outputWriterP.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutP = openFileOutput("P.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterP = new OutputStreamWriter(fileoutP);
                        outputWriterP.write("Phases fragment Gas.dat is available.");
                        outputWriterP.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathSS = new File(getFilesDir()+File.separator+"Solution.dat");
                if (!filePathSS.exists()) {
                    try {
                        FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                        outputWriterSS.write("Solution species fragment Solution.dat does not exist.");
                        outputWriterSS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                        outputWriterSS.write("Solution species fragment Solution.dat is available.");
                        outputWriterSS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathSMS_kin = new File(getFilesDir()+"/SMS_kin.txt");

                if (!filePathSMS_kin.exists()) {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("SMS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("Solution master species fragment SMS_kin.txt does not exist.");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("SMS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("Solution master species fragment SMS_kin.txt is available.");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathSS_kin = new File(getFilesDir()+"/SS_kin.txt");
                if (!filePathSS_kin.exists()) {
                    try {
                        FileOutputStream fileoutSS_kin = openFileOutput("SS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS_kin = new OutputStreamWriter(fileoutSS_kin);
                        outputWriterSS_kin.write("Solution species fragment SS_kin.txt does not exist.");
                        outputWriterSS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSS_kin = openFileOutput("SS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS_kin = new OutputStreamWriter(fileoutSS_kin);
                        outputWriterSS_kin.write("Solution species fragment SS_kin.txt is available.");
                        outputWriterSS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathR_kin = new File(getFilesDir()+"/R_kin.txt");
                if (!filePathR_kin.exists()) {
                    try {
                        FileOutputStream fileoutR_kin = openFileOutput("R_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterR_kin = new OutputStreamWriter(fileoutR_kin);
                        outputWriterR_kin.write("Rates fragment R_kin.txt does not exist.");
                        outputWriterR_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutR_kin = openFileOutput("R_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterR_kin = new OutputStreamWriter(fileoutR_kin);
                        outputWriterR_kin.write("Rates fragment R_kin.txt is available.");
                        outputWriterR_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathK_kin = new File(getFilesDir()+"/K_kin.txt");
                if (!filePathK_kin.exists()) {
                    try {
                        FileOutputStream fileoutK_kin = openFileOutput("K_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterK_kin = new OutputStreamWriter(fileoutK_kin);
                        outputWriterK_kin.write("Kinetics fragment K_kin.txt does not exist.");
                        outputWriterK_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutK_kin = openFileOutput("K_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterK_kin = new OutputStreamWriter(fileoutK_kin);
                        outputWriterK_kin.write("Kinetics fragment K_kin.txt is available.");
                        outputWriterK_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }

    private View.OnClickListener ResetKinClick; {

        ResetKinClick = new View.OnClickListener() {
            public void onClick(View v) {

                // TODO Auto-generated method stub //
                exec("rm "+getFilesDir()+"/SMS_kin.txt");
                exec("rm "+getFilesDir()+"/SS_kin.txt");
                exec("rm "+getFilesDir()+"/R_kin.txt");
                exec("rm "+getFilesDir()+"/K_kin.txt");

                File filePathP = new File(getFilesDir()+File.separator+"Gas.dat");

                if (!filePathP.exists()) {
                    try {
                        FileOutputStream fileoutP = openFileOutput("P.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterP = new OutputStreamWriter(fileoutP);
                        outputWriterP.write("Phases fragment Gas.dat does not exist.");
                        outputWriterP.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutP = openFileOutput("P.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterP = new OutputStreamWriter(fileoutP);
                        outputWriterP.write("Phases fragment Gas.dat is available.");
                        outputWriterP.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathSS = new File(getFilesDir()+File.separator+"Solution.dat");
                if (!filePathSS.exists()) {
                    try {
                        FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                        outputWriterSS.write("Solution species fragment Solution.dat does not exist.");
                        outputWriterSS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                        outputWriterSS.write("Solution species fragment Solution.dat is available.");
                        outputWriterSS.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathSMS_kin = new File(getFilesDir()+"/SMS_kin.txt");

                if (!filePathSMS_kin.exists()) {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("SMS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("Solution master species fragment SMS_kin.txt does not exist.");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("SMS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("Solution master species fragment SMS_kin.txt is available.");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathSS_kin = new File(getFilesDir()+"/SS_kin.txt");
                if (!filePathSS_kin.exists()) {
                    try {
                        FileOutputStream fileoutSS_kin = openFileOutput("SS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS_kin = new OutputStreamWriter(fileoutSS_kin);
                        outputWriterSS_kin.write("Solution species fragment SS_kin.txt does not exist.");
                        outputWriterSS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSS_kin = openFileOutput("SS_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSS_kin = new OutputStreamWriter(fileoutSS_kin);
                        outputWriterSS_kin.write("Solution species fragment SS_kin.txt is available.");
                        outputWriterSS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathR_kin = new File(getFilesDir()+"/R_kin.txt");
                if (!filePathR_kin.exists()) {
                    try {
                        FileOutputStream fileoutR_kin = openFileOutput("R_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterR_kin = new OutputStreamWriter(fileoutR_kin);
                        outputWriterR_kin.write("Rates fragment R_kin.txt does not exist.");
                        outputWriterR_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutR_kin = openFileOutput("R_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterR_kin = new OutputStreamWriter(fileoutR_kin);
                        outputWriterR_kin.write("Rates fragment R_kin.txt is available.");
                        outputWriterR_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File filePathK_kin = new File(getFilesDir()+"/K_kin.txt");
                if (!filePathK_kin.exists()) {
                    try {
                        FileOutputStream fileoutK_kin = openFileOutput("K_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterK_kin = new OutputStreamWriter(fileoutK_kin);
                        outputWriterK_kin.write("Kinetics fragment K_kin.txt does not exist.");
                        outputWriterK_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutK_kin = openFileOutput("K_kin_status.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterK_kin = new OutputStreamWriter(fileoutK_kin);
                        outputWriterK_kin.write("Kinetics fragment K_kin.txt is available.");
                        outputWriterK_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }

    private View.OnClickListener saveInputfileClick; {

        saveInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = PhreeqcInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-phreeqc.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveInput();
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }


    public void alertSaveInput(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Phreeqc.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Phreeqc.this)
                .setMessage("The file will be saved in the folder /work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = PhreeqcInput.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"phreeqc_work");
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
        editText10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }



    private View.OnClickListener RunPhreeqcClick; {

        RunPhreeqcClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = PhreeqcInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-phreeqc.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
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
        progressDialog = new ProgressDialog(Phreeqc.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Calculation is running...");
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
                exec("cp "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+ File.separator+"phreeqc_plus"+File.separator+"phreeqc_datasets"+File.separator+"Database.dat "+getFilesDir()+"");
                try {
                    exec("chmod 755 -R "+getFilesDir()+"/work");
                    exec("chmod 755 -R "+getFilesDir());
                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc.so "+getFilesDir()+"/Input-phreeqc.txt "+getFilesDir()+"/Input.phr.out "+getFilesDir()+"/Database.dat");
                    exec("chmod 755 "+getFilesDir()+"/Input.phr.out");
                    try {
                        output2(exec("cat "+getFilesDir()+"/Input.phr.out"));
                        output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                        output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                        output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                        pView(exec("cat "+getFilesDir()+"/P.txt"));
                        ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                        dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                        sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                        ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                        r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                        k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
                        Toast.makeText(getApplicationContext(), "Calculation finished", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
                onFinish();
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

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        outputView2.setText(str2);
                    }
                };
                handler.post(proc2);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }


    public void output2(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                outputView2.setText(str2);
            }
        };
        handler.post(proc2);
    }















    private View.OnClickListener saveOutputfileClick; {

        saveOutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertSaveOutput();
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
            }
        };
    }





    public void alertSaveOutput(){
        // creating the EditText widget programatically
        EditText editText15 = new EditText(Phreeqc.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Phreeqc.this)
                .setMessage("The file will be saved in the folder /work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText15)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String OutputProtocol = outputView2.getText().toString();
                        String SaveOutputName = editText15.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveOutputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(OutputProtocol);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveOutputName+" "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"phreeqc_work");
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
        // this part will make the soft keyboard automaticall visible
        editText15.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }



    private View.OnClickListener HighlightClick; {

        HighlightClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                openhighlightdialog();
            }
        };
    }


    private void openhighlightdialog() {
        // TODO Auto-generated method stub //
        progressDialog = new ProgressDialog(Phreeqc.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Highlighting numbers is in progress...");
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
                    outputX(exec("cat "+getFilesDir()+"/Input.phr.out"));
                    output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                    output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                    output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
                    pView(exec("cat "+getFilesDir()+"/P.txt"));
                    ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                    dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                    sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                    ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                    r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                    k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
                    Toast.makeText(getApplicationContext(), "Numbers highlighted.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }

                onFinish();
            }



            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }




    // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
    public void outputX(final String strX) {
        Runnable procX = new Runnable() {
            public void run() {
//                        outputView4.setText(strX);
                outputView2.setText(colorized(strX, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
            }
        };
        handler.post(procX);
    }






















    private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Phreeqc.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onHelpClick; {

        onHelpClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertHelp();
            }
        };
    }

    public void alertHelp() {

        new AlertDialog.Builder(Phreeqc.this)
                .setTitle("How to use the PHREEQC interface")
                .setMessage("A. Thermodynamic calculation\n\nAfter MOPAC calculation, click (1) to append individual results files to a temporary file Solution.dat. Then, filter (2) the desired entries from this file to create a new file Solution.dat. If needed, add (multiple times) desired entries (3) from already existing (pre-selected) PHREEQC database (_mod types contain one species per line) to the file Solution.dat created in the previous step (2). Regarding the PHASES block, it is also possible to combine several results in a file named Gas.dat. To include the files into your PHREEQC input, add SOLUTION_SPECIES and INCLUDE$ /data/data/cz.p/files/Solution.dat, or PHASES and INCLUDE$ /data/data/cz.p/files/Gas.dat lines, respectively. \n\nB. Kinetic calculation\n\nAfter MOPAC calculation, add SOLUTION_MASTER_SPECIES, SOLUTION_SPECIES, RATES and KINETICS files (in append mode, i.e. it is possible to combine the results from several MOPAC calculations). To include the files into your PHREEQC input, add SOLUTION_MASTER_SPECIES and INCLUDE$ /data/data/cz.p/files/SMS_kin.txt, SOLUTION_SPECIES and INCLUDE$ /data/data/cz.p/files/SS_kin.txt, RATES and INCLUDE$ /data/data/cz.p/files/R_kin.txt, KINETICS and INCLUDE$ /data/data/cz.p/files/K_kin.txt lines respectively.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }


    @Override
    protected void onResume() {
        super.onResume();

        File filePathP = new File(getFilesDir()+File.separator+"Gas.dat");

        if (!filePathP.exists()) {
            try {
                FileOutputStream fileoutP = openFileOutput("P.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterP = new OutputStreamWriter(fileoutP);
                outputWriterP.write("Phases fragment Gas.dat does not exist.");
                outputWriterP.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutP = openFileOutput("P.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterP = new OutputStreamWriter(fileoutP);
                outputWriterP.write("Phases fragment Gas.dat is available.");
                outputWriterP.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File filePathSS = new File(getFilesDir()+File.separator+"Solution.dat");
        if (!filePathSS.exists()) {
            try {
                FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                outputWriterSS.write("Solution species fragment Solution.dat does not exist.");
                outputWriterSS.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutSS = openFileOutput("SS.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSS = new OutputStreamWriter(fileoutSS);
                outputWriterSS.write("Solution species fragment Solution.dat is available.");
                outputWriterSS.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File filePathSMS_kin = new File(getFilesDir()+"/SMS_kin.txt");

        if (!filePathSMS_kin.exists()) {
            try {
                FileOutputStream fileoutSMS_kin = openFileOutput("SMS_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                outputWriterSMS_kin.write("Solution master species fragment SMS_kin.txt does not exist.");
                outputWriterSMS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutSMS_kin = openFileOutput("SMS_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                outputWriterSMS_kin.write("Solution master species fragment SMS_kin.txt is available.");
                outputWriterSMS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File filePathSS_kin = new File(getFilesDir()+"/SS_kin.txt");
        if (!filePathSS_kin.exists()) {
            try {
                FileOutputStream fileoutSS_kin = openFileOutput("SS_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSS_kin = new OutputStreamWriter(fileoutSS_kin);
                outputWriterSS_kin.write("Solution species fragment SS_kin.txt does not exist.");
                outputWriterSS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutSS_kin = openFileOutput("SS_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSS_kin = new OutputStreamWriter(fileoutSS_kin);
                outputWriterSS_kin.write("Solution species fragment SS_kin.txt is available.");
                outputWriterSS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File filePathR_kin = new File(getFilesDir()+"/R_kin.txt");
        if (!filePathR_kin.exists()) {
            try {
                FileOutputStream fileoutR_kin = openFileOutput("R_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterR_kin = new OutputStreamWriter(fileoutR_kin);
                outputWriterR_kin.write("Rates fragment R_kin.txt does not exist.");
                outputWriterR_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutR_kin = openFileOutput("R_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterR_kin = new OutputStreamWriter(fileoutR_kin);
                outputWriterR_kin.write("Rates fragment R_kin.txt is available.");
                outputWriterR_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File filePathK_kin = new File(getFilesDir()+"/K_kin.txt");
        if (!filePathK_kin.exists()) {
            try {
                FileOutputStream fileoutK_kin = openFileOutput("K_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterK_kin = new OutputStreamWriter(fileoutK_kin);
                outputWriterK_kin.write("Kinetics fragment K_kin.txt does not exist.");
                outputWriterK_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutK_kin = openFileOutput("K_kin_status.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterK_kin = new OutputStreamWriter(fileoutK_kin);
                outputWriterK_kin.write("Kinetics fragment K_kin.txt is available.");
                outputWriterK_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
        output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
        output42(exec("cat "+getFilesDir()+"/Keywords2.phr"));
        pView(exec("cat "+getFilesDir()+"/P.txt"));
        ssView(exec("cat "+getFilesDir()+"/SS.txt"));
        dataView(exec("cat "+getFilesDir()+"/Database.txt"));
        sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
        ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
        r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
        k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));

    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                PhreeqcInput.setText(str3);
            }
        };
        handler.post(proc3);
    }
    public void output4(final String str4) {
        Runnable proc4 = new Runnable() {
            public void run() {
                ModifyEdit.setText(str4);
            }
        };
        handler.post(proc4);
    }
    public void output42(final String str42) {
        Runnable proc42 = new Runnable() {
            public void run() {
                ModifyEdit12.setText(str42);
            }
        };
        handler.post(proc42);
    }
    public void dataView(final String strData) {
        Runnable procData = new Runnable() {
            public void run() {
                Data.setText(strData);
            }
        };
        handler.post(procData);
    }
    public void pView(final String pData) {
        Runnable procP = new Runnable() {
            public void run() {
                P.setText(pData);
            }
        };
        handler.post(procP);
    }
    public void ssView(final String ssData) {
        Runnable procSS = new Runnable() {
            public void run() {
                SS.setText(ssData);
            }
        };
        handler.post(procSS);
    }
    public void sms_kin_View(final String sms_kin_Data) {
        Runnable procSMS_kin = new Runnable() {
            public void run() {
                SMS_kin.setText(sms_kin_Data);
            }
        };
        handler.post(procSMS_kin);
    }
    public void ss_kin_View(final String ss_kin_Data) {
        Runnable procSS_kin = new Runnable() {
            public void run() {
                SS_kin.setText(ss_kin_Data);
            }
        };
        handler.post(procSS_kin);
    }
    public void r_kin_View(final String r_kin_Data) {
        Runnable procR_kin = new Runnable() {
            public void run() {
                R_kin.setText(r_kin_Data);
            }
        };
        handler.post(procR_kin);
    }
    public void k_kin_View(final String k_kin_Data) {
        Runnable procK_kin = new Runnable() {
            public void run() {
                K_kin.setText(k_kin_Data);
            }
        };
        handler.post(procK_kin);
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
