package cz.p;

import static cz.p.Spannables.colorized_dftb;
import static cz.p.Spannables.colorized_phreeqc;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
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
    private static final int READ_FILE1 = 311;
    private static final int READ_FILE2 = 312;
    private static final int READ_FILE3 = 313;
    private static final int READ_FILE4 = 314;
    private static final int READ_FILE5 = 315;
    private static final int READ_FILE6 = 316;
    private static final int READ_FILE7 = 317;
    private static final int READ_FILE8 = 318;
    private static final int CREATE_FILE1250 = 311250;
    private static final int CREATE_FILE1260 = 311260;
    private Uri documentUri01;
    private Uri documentUri02;
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
    Button openIntInputfile;
    Button saveInputfile;
    Button saveExtInputfile;
    Button RunPhreeqc;
    Button RunPhreeqcSilent;
    Button saveOutputfile;
    Button saveExtOutputfile;
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
    private Button ResetSMSKin;
    private Button ResetSSKin;
    private Button ResetRKin;
    private Button ResetKKin;
    private Button Help;

    private Button AddSSi;
    private Button AddPi;
    private Button AddSMS_kini;
    private Button AddSS_kini;
    private Button AddR_kini;
    private Button AddK_kini;

    private TextView ModifyLabelSMS;
    private EditText ModifyEditSMS;
    private Button modifybuttonSMS;
    private TextView ModifyLabelSS;
    private EditText ModifyEditSS;
    private Button modifybuttonSS;
    private TextView ModifyLabelR;
    private EditText ModifyEditR;
    private Button modifybuttonR;
    private TextView ModifyLabelK;
    private EditText ModifyEditK;
    private Button modifybuttonK;
    Button manual_phreeqc_isotopes;
    Button manual_phreeqc2;
    Button manual_phreeqc3;
    Button Graph;
    Button Scatter;
    Button ResetGraphs;

    private TextView delete_label;
    private EditText delete;
    private Button delete_button;

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
        ModifyEdit.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        ModifyEdit.addTextChangedListener(new TextWatcher() {
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
                ModifyEdit.removeTextChangedListener(this);
                String text = ModifyEdit.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ModifyEdit.getText().clear();
                ModifyEdit.append(colorized_phreeqc(text));
                // place the cursor at the original position
                ModifyEdit.setSelection(startChanged+countChanged);
                ModifyEdit.addTextChangedListener(this);
            }
        });
        modifybutton = (Button) findViewById(R.id.modifybutton);
        modifybutton.setOnClickListener(modifybuttonClick);
        ModifyLabel2 = (TextView) findViewById(R.id.ModifyLabel2);
        ModifyEdit12 = (EditText) findViewById(R.id.ModifyEdit12);
        ModifyEdit12.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        ModifyEdit12.addTextChangedListener(new TextWatcher() {
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
                ModifyEdit12.removeTextChangedListener(this);
                String text = ModifyEdit12.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ModifyEdit12.getText().clear();
                ModifyEdit12.append(colorized_phreeqc(text));
                // place the cursor at the original position
                ModifyEdit12.setSelection(startChanged+countChanged);
                ModifyEdit12.addTextChangedListener(this);
            }
        });
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
        ResetSMSKin = (Button) findViewById(R.id.ResetSMSKin);
        ResetSMSKin.setOnClickListener(ResetSMSKinClick);
        ResetSSKin = (Button) findViewById(R.id.ResetSSKin);
        ResetSSKin.setOnClickListener(ResetSSKinClick);
        ResetRKin = (Button) findViewById(R.id.ResetRKin);
        ResetRKin.setOnClickListener(ResetRKinClick);
        ResetKKin = (Button) findViewById(R.id.ResetKKin);
        ResetKKin.setOnClickListener(ResetKKinClick);
        PhreeqcLabel = (TextView) findViewById(R.id.PhreeqcLabel);
        PhreeqcInput = (EditText) findViewById(R.id.PhreeqcInput);
        PhreeqcInput.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        PhreeqcInput.addTextChangedListener(new TextWatcher() {
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
                PhreeqcInput.removeTextChangedListener(this);
                String text = PhreeqcInput.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                PhreeqcInput.getText().clear();
                PhreeqcInput.append(colorized_phreeqc(text));
                // place the cursor at the original position
                PhreeqcInput.setSelection(startChanged+countChanged);
                PhreeqcInput.addTextChangedListener(this);
            }
        });
        openInputfile = (Button) findViewById(R.id.openInputfile);
        openInputfile.setOnClickListener(openInputfileClick);
        openIntInputfile = (Button) findViewById(R.id.openIntInputfile);
        saveInputfile = (Button) findViewById(R.id.saveInputfile);
        saveInputfile.setOnClickListener(saveInputfileClick);
        saveExtInputfile = (Button) findViewById(R.id.saveExtInputfile);
        saveExtInputfile.setOnClickListener(saveExtInputfileClick);
        RunPhreeqc = (Button) findViewById(R.id.RunPhreeqc);
        RunPhreeqc.setOnClickListener(RunPhreeqcClick);
        RunPhreeqcSilent = (Button) findViewById(R.id.RunPhreeqcSilent);
        RunPhreeqcSilent.setOnClickListener(RunPhreeqcSilentClick);
        saveOutputfile = (Button) findViewById(R.id.saveOutputfile);
        saveOutputfile.setOnClickListener(saveOutputfileClick);
        saveExtOutputfile = (Button) findViewById(R.id.saveExtOutputfile);
        saveExtOutputfile.setOnClickListener(saveExtOutputfileClick);
        Highlight = (Button) findViewById(R.id.Highlight);
        Highlight.setOnClickListener(HighlightClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        textViewX = (TextView) findViewById(R.id.textViewX);
        outputView = (TextView) findViewById(R.id.outputView);
        outputView2 = (EditText) findViewById(R.id.outputView2);
        outputView2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/OutputTextSize.txt")).intValue());
        // disable - otherwise the text could not be selected
//        outputView2.setMovementMethod(new ScrollingMovementMethod());
        // otherwise every time is spanned
//        outputView2.addTextChangedListener(new TextWatcher() {
//            int startChanged,beforeChanged,countChanged;
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                startChanged = start;
//                beforeChanged = before;
//                countChanged = count;
//            }
//            @Override
//            public void afterTextChanged(Editable s) {
//                outputView2.removeTextChangedListener(this);
//                String text = outputView2.getText().toString();
//                // important - not setText() - otherwise the keyboard would be reset after each type
//                outputView2.getText().clear();
//                outputView2.append(colorized_phreeqc(text));
//                // place the cursor at the original position
//                outputView2.setSelection(startChanged+countChanged);
//                outputView2.addTextChangedListener(this);
//            }
//        });

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

        Help = (Button) findViewById(R.id.Help);
        Help.setOnClickListener(onHelpClick);


        AddSSi = (Button) findViewById(R.id.AddSSi);
        AddSSi.setOnClickListener(AddSSiClick);
        AddPi = (Button) findViewById(R.id.AddPi);
        AddPi.setOnClickListener(AddPiClick);
        AddSMS_kini = (Button) findViewById(R.id.AddSMS_kini);
        AddSMS_kini.setOnClickListener(AddSMS_kiniClick);
        AddSS_kini = (Button) findViewById(R.id.AddSS_kini);
        AddSS_kini.setOnClickListener(AddSS_kiniClick);
        AddR_kini = (Button) findViewById(R.id.AddR_kini);
        AddR_kini.setOnClickListener(AddR_kiniClick);
        AddK_kini = (Button) findViewById(R.id.AddK_kini);
        AddK_kini.setOnClickListener(AddK_kiniClick);

        ModifyLabelSMS = (TextView) findViewById(R.id.ModifyLabelSMS);
        ModifyEditSMS = (EditText) findViewById(R.id.ModifyEditSMS);
        ModifyEditSMS.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        ModifyEditSMS.addTextChangedListener(new TextWatcher() {
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
                ModifyEditSMS.removeTextChangedListener(this);
                String text = ModifyEditSMS.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ModifyEditSMS.getText().clear();
                ModifyEditSMS.append(colorized_phreeqc(text));
                // place the cursor at the original position
                ModifyEditSMS.setSelection(startChanged+countChanged);
                ModifyEditSMS.addTextChangedListener(this);
            }
        });
        modifybuttonSMS = (Button) findViewById(R.id.modifybuttonSMS);
        modifybuttonSMS.setOnClickListener(modifybuttonSMSClick);

        ModifyLabelSS = (TextView) findViewById(R.id.ModifyLabelSS);
        ModifyEditSS = (EditText) findViewById(R.id.ModifyEditSS);
        ModifyEditSS.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        ModifyEditSS.addTextChangedListener(new TextWatcher() {
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
                ModifyEditSS.removeTextChangedListener(this);
                String text = ModifyEditSS.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ModifyEditSS.getText().clear();
                ModifyEditSS.append(colorized_phreeqc(text));
                // place the cursor at the original position
                ModifyEditSS.setSelection(startChanged+countChanged);
                ModifyEditSS.addTextChangedListener(this);
            }
        });
        modifybuttonSS = (Button) findViewById(R.id.modifybuttonSS);
        modifybuttonSS.setOnClickListener(modifybuttonSSClick);

        ModifyLabelR = (TextView) findViewById(R.id.ModifyLabelR);
        ModifyEditR = (EditText) findViewById(R.id.ModifyEditR);
        ModifyEditR.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        ModifyEditR.addTextChangedListener(new TextWatcher() {
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
                ModifyEditR.removeTextChangedListener(this);
                String text = ModifyEditR.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ModifyEditR.getText().clear();
                ModifyEditR.append(colorized_phreeqc(text));
                // place the cursor at the original position
                ModifyEditR.setSelection(startChanged+countChanged);
                ModifyEditR.addTextChangedListener(this);
            }
        });
        modifybuttonR = (Button) findViewById(R.id.modifybuttonR);
        modifybuttonR.setOnClickListener(modifybuttonRClick);

        ModifyLabelK = (TextView) findViewById(R.id.ModifyLabelK);
        ModifyEditK = (EditText) findViewById(R.id.ModifyEditK);
        ModifyEditK.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        ModifyEditK.addTextChangedListener(new TextWatcher() {
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
                ModifyEditK.removeTextChangedListener(this);
                String text = ModifyEditK.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ModifyEditK.getText().clear();
                ModifyEditK.append(colorized_phreeqc(text));
                // place the cursor at the original position
                ModifyEditK.setSelection(startChanged+countChanged);
                ModifyEditK.addTextChangedListener(this);
            }
        });
        modifybuttonK = (Button) findViewById(R.id.modifybuttonK);
        modifybuttonK.setOnClickListener(modifybuttonKClick);

        delete_label = (TextView) findViewById(R.id.delete_label);
        delete = (EditText) findViewById(R.id.delete);
        delete.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        delete.addTextChangedListener(new TextWatcher() {
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
                delete.removeTextChangedListener(this);
                String text = delete.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                delete.getText().clear();
                delete.append(colorized_phreeqc(text));
                // place the cursor at the original position
                delete.setSelection(startChanged+countChanged);
                delete.addTextChangedListener(this);
            }
        });
        delete_button = (Button) findViewById(R.id.delete_button);
        delete_button.setOnClickListener(delete_buttonClick);


        ResetGraphs = (Button) findViewById(R.id.ResetGraphs);
        ResetGraphs.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {

                                               // TODO Auto-generated method stub //
                    exec("rm "+getFilesDir()+"/graph-series1.csv");
                    exec("rm "+getFilesDir()+"/graph-series2.csv");
                    exec("rm "+getFilesDir()+"/graph-series3.csv");
                    exec("rm "+getFilesDir()+"/graph-series4.csv");
                    exec("rm "+getFilesDir()+"/graph-series5.csv");
                                               exec("rm "+getFilesDir()+"/graph-series6.csv");
                                               exec("rm "+getFilesDir()+"/graph-series7.csv");
                                               exec("rm "+getFilesDir()+"/graph-series8.csv");
                                               exec("rm "+getFilesDir()+"/graph-series9.csv");
                                               exec("rm "+getFilesDir()+"/graph-series10.csv");
                    exec("touch "+getFilesDir()+"/graph-series1.csv");
                    exec("touch "+getFilesDir()+"/graph-series2.csv");
                    exec("touch "+getFilesDir()+"/graph-series3.csv");
                    exec("touch "+getFilesDir()+"/graph-series4.csv");
                    exec("touch "+getFilesDir()+"/graph-series5.csv");
                                               exec("touch "+getFilesDir()+"/graph-series6.csv");
                                               exec("touch "+getFilesDir()+"/graph-series7.csv");
                                               exec("touch "+getFilesDir()+"/graph-series8.csv");
                                               exec("touch "+getFilesDir()+"/graph-series9.csv");
                                               exec("touch "+getFilesDir()+"/graph-series10.csv");

                    Toast.makeText(getApplicationContext(), "All graph files have been deleted", Toast.LENGTH_SHORT).show();

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
                    sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                    ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                    r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                    k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                    delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
                }
        });

        Graph = (Button) findViewById(R.id.Graph);
        Graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    // remove the header
                    String Sed = exec("sed -e 1d "+getFilesDir()+"/graph-series1.csv");
                    FileOutputStream fileoutS = openFileOutput("graph-series1.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS = new OutputStreamWriter(fileoutS);
                    outputWriterS.write(Sed);
                    outputWriterS.close();
                    exec("rm "+getFilesDir()+"/graph-series1.csv");
                    exec("mv "+getFilesDir()+"/graph-series1.tmp "+getFilesDir()+"/graph-series1.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series1.csv");
                    FileOutputStream fileoutG = openFileOutput("graph-series1.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG = new OutputStreamWriter(fileoutG);
                    outputWriterG.write(Sort);
                    outputWriterG.close();
                    exec("rm "+getFilesDir()+"/graph-series1.csv");
                    exec("mv "+getFilesDir()+"/graph-series1.tmp "+getFilesDir()+"/graph-series1.csv");
                    // remove blank lines in sorted file
                    String BlankLin = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series1.csv");
                    FileOutputStream fileoutBL = openFileOutput("graph-series1.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL = new OutputStreamWriter(fileoutBL);
                    outputWriterBL.write(BlankLin);
                    outputWriterBL.close();
                    exec("rm "+getFilesDir()+"/graph-series1.csv");
                    exec("mv "+getFilesDir()+"/graph-series1.tmp "+getFilesDir()+"/graph-series1.csv");

                    // remove the header
                    String Sed2 = exec("sed -e 1d "+getFilesDir()+"/graph-series2.csv");
                    FileOutputStream fileoutS2 = openFileOutput("graph-series2.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS2 = new OutputStreamWriter(fileoutS2);
                    outputWriterS2.write(Sed2);
                    outputWriterS2.close();
                    exec("rm "+getFilesDir()+"/graph-series2.csv");
                    exec("mv "+getFilesDir()+"/graph-series2.tmp "+getFilesDir()+"/graph-series2.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort2 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series2.csv");
                    FileOutputStream fileoutG2 = openFileOutput("graph-series2.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG2 = new OutputStreamWriter(fileoutG2);
                    outputWriterG2.write(Sort2);
                    outputWriterG2.close();
                    exec("rm "+getFilesDir()+"/graph-series2.csv");
                    exec("mv "+getFilesDir()+"/graph-series2.tmp "+getFilesDir()+"/graph-series2.csv");
                    // remove blank lines in sorted file
                    String BlankLin2 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series2.csv");
                    FileOutputStream fileoutBL2 = openFileOutput("graph-series2.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL2 = new OutputStreamWriter(fileoutBL2);
                    outputWriterBL2.write(BlankLin2);
                    outputWriterBL2.close();
                    exec("rm "+getFilesDir()+"/graph-series2.csv");
                    exec("mv "+getFilesDir()+"/graph-series2.tmp "+getFilesDir()+"/graph-series2.csv");

                    // remove the header
                    String Sed3 = exec("sed -e 1d "+getFilesDir()+"/graph-series3.csv");
                    FileOutputStream fileoutS3 = openFileOutput("graph-series3.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS3 = new OutputStreamWriter(fileoutS3);
                    outputWriterS3.write(Sed3);
                    outputWriterS3.close();
                    exec("rm "+getFilesDir()+"/graph-series3.csv");
                    exec("mv "+getFilesDir()+"/graph-series3.tmp "+getFilesDir()+"/graph-series3.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort3 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series3.csv");
                    FileOutputStream fileoutG3 = openFileOutput("graph-series3.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG3 = new OutputStreamWriter(fileoutG3);
                    outputWriterG3.write(Sort3);
                    outputWriterG3.close();
                    exec("rm "+getFilesDir()+"/graph-series3.csv");
                    exec("mv "+getFilesDir()+"/graph-series3.tmp "+getFilesDir()+"/graph-series3.csv");
                    // remove blank lines in sorted file
                    String BlankLin3 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series3.csv");
                    FileOutputStream fileoutBL3 = openFileOutput("graph-series3.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL3 = new OutputStreamWriter(fileoutBL3);
                    outputWriterBL3.write(BlankLin3);
                    outputWriterBL3.close();
                    exec("rm "+getFilesDir()+"/graph-series3.csv");
                    exec("mv "+getFilesDir()+"/graph-series3.tmp "+getFilesDir()+"/graph-series3.csv");

                    // remove the header
                    String Sed4 = exec("sed -e 1d "+getFilesDir()+"/graph-series4.csv");
                    FileOutputStream fileoutS4 = openFileOutput("graph-series4.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS4 = new OutputStreamWriter(fileoutS4);
                    outputWriterS4.write(Sed4);
                    outputWriterS4.close();
                    exec("rm "+getFilesDir()+"/graph-series4.csv");
                    exec("mv "+getFilesDir()+"/graph-series4.tmp "+getFilesDir()+"/graph-series4.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort4 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series4.csv");
                    FileOutputStream fileoutG4 = openFileOutput("graph-series4.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG4 = new OutputStreamWriter(fileoutG4);
                    outputWriterG4.write(Sort4);
                    outputWriterG4.close();
                    exec("rm "+getFilesDir()+"/graph-series4.csv");
                    exec("mv "+getFilesDir()+"/graph-series4.tmp "+getFilesDir()+"/graph-series4.csv");
                    // remove blank lines in sorted file
                    String BlankLin4 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series4.csv");
                    FileOutputStream fileoutBL4 = openFileOutput("graph-series4.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL4 = new OutputStreamWriter(fileoutBL4);
                    outputWriterBL4.write(BlankLin4);
                    outputWriterBL4.close();
                    exec("rm "+getFilesDir()+"/graph-series4.csv");
                    exec("mv "+getFilesDir()+"/graph-series4.tmp "+getFilesDir()+"/graph-series4.csv");

                    // remove the header
                    String Sed5 = exec("sed -e 1d "+getFilesDir()+"/graph-series5.csv");
                    FileOutputStream fileoutS5 = openFileOutput("graph-series5.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS5 = new OutputStreamWriter(fileoutS5);
                    outputWriterS5.write(Sed5);
                    outputWriterS5.close();
                    exec("rm "+getFilesDir()+"/graph-series5.csv");
                    exec("mv "+getFilesDir()+"/graph-series5.tmp "+getFilesDir()+"/graph-series5.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort5 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series5.csv");
                    FileOutputStream fileoutG5 = openFileOutput("graph-series5.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG5 = new OutputStreamWriter(fileoutG5);
                    outputWriterG5.write(Sort5);
                    outputWriterG5.close();
                    exec("rm "+getFilesDir()+"/graph-series5.csv");
                    exec("mv "+getFilesDir()+"/graph-series5.tmp "+getFilesDir()+"/graph-series5.csv");
                    // remove blank lines in sorted file
                    String BlankLin5 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series5.csv");
                    FileOutputStream fileoutBL5 = openFileOutput("graph-series5.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL5 = new OutputStreamWriter(fileoutBL5);
                    outputWriterBL5.write(BlankLin5);
                    outputWriterBL5.close();
                    exec("rm "+getFilesDir()+"/graph-series5.csv");
                    exec("mv "+getFilesDir()+"/graph-series5.tmp "+getFilesDir()+"/graph-series5.csv");

                    // remove the header
                    String Sed6 = exec("sed -e 1d "+getFilesDir()+"/graph-series6.csv");
                    FileOutputStream fileoutS6 = openFileOutput("graph-series6.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS6 = new OutputStreamWriter(fileoutS6);
                    outputWriterS6.write(Sed6);
                    outputWriterS6.close();
                    exec("rm "+getFilesDir()+"/graph-series6.csv");
                    exec("mv "+getFilesDir()+"/graph-series6.tmp "+getFilesDir()+"/graph-series6.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort6 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series6.csv");
                    FileOutputStream fileoutG6 = openFileOutput("graph-series6.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG6 = new OutputStreamWriter(fileoutG6);
                    outputWriterG6.write(Sort6);
                    outputWriterG6.close();
                    exec("rm "+getFilesDir()+"/graph-series6.csv");
                    exec("mv "+getFilesDir()+"/graph-series6.tmp "+getFilesDir()+"/graph-series6.csv");
                    // remove blank lines in sorted file
                    String BlankLin6 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series6.csv");
                    FileOutputStream fileoutBL6 = openFileOutput("graph-series6.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL6 = new OutputStreamWriter(fileoutBL6);
                    outputWriterBL6.write(BlankLin6);
                    outputWriterBL6.close();
                    exec("rm "+getFilesDir()+"/graph-series6.csv");
                    exec("mv "+getFilesDir()+"/graph-series6.tmp "+getFilesDir()+"/graph-series6.csv");

                    // remove the header
                    String Sed7 = exec("sed -e 1d "+getFilesDir()+"/graph-series7.csv");
                    FileOutputStream fileoutS7 = openFileOutput("graph-series7.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS7 = new OutputStreamWriter(fileoutS7);
                    outputWriterS7.write(Sed7);
                    outputWriterS7.close();
                    exec("rm "+getFilesDir()+"/graph-series7.csv");
                    exec("mv "+getFilesDir()+"/graph-series7.tmp "+getFilesDir()+"/graph-series7.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort7 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series7.csv");
                    FileOutputStream fileoutG7 = openFileOutput("graph-series7.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG7 = new OutputStreamWriter(fileoutG7);
                    outputWriterG7.write(Sort7);
                    outputWriterG7.close();
                    exec("rm "+getFilesDir()+"/graph-series7.csv");
                    exec("mv "+getFilesDir()+"/graph-series7.tmp "+getFilesDir()+"/graph-series7.csv");
                    // remove blank lines in sorted file
                    String BlankLin7 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series7.csv");
                    FileOutputStream fileoutBL7 = openFileOutput("graph-series7.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL7 = new OutputStreamWriter(fileoutBL7);
                    outputWriterBL7.write(BlankLin7);
                    outputWriterBL7.close();
                    exec("rm "+getFilesDir()+"/graph-series7.csv");
                    exec("mv "+getFilesDir()+"/graph-series7.tmp "+getFilesDir()+"/graph-series7.csv");

                    // remove the header
                    String Sed8 = exec("sed -e 1d "+getFilesDir()+"/graph-series8.csv");
                    FileOutputStream fileoutS8 = openFileOutput("graph-series8.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS8 = new OutputStreamWriter(fileoutS8);
                    outputWriterS8.write(Sed8);
                    outputWriterS8.close();
                    exec("rm "+getFilesDir()+"/graph-series8.csv");
                    exec("mv "+getFilesDir()+"/graph-series8.tmp "+getFilesDir()+"/graph-series8.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort8 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series8.csv");
                    FileOutputStream fileoutG8 = openFileOutput("graph-series8.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG8 = new OutputStreamWriter(fileoutG8);
                    outputWriterG8.write(Sort8);
                    outputWriterG8.close();
                    exec("rm "+getFilesDir()+"/graph-series8.csv");
                    exec("mv "+getFilesDir()+"/graph-series8.tmp "+getFilesDir()+"/graph-series8.csv");
                    // remove blank lines in sorted file
                    String BlankLin8 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series8.csv");
                    FileOutputStream fileoutBL8 = openFileOutput("graph-series8.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL8 = new OutputStreamWriter(fileoutBL8);
                    outputWriterBL8.write(BlankLin8);
                    outputWriterBL8.close();
                    exec("rm "+getFilesDir()+"/graph-series8.csv");
                    exec("mv "+getFilesDir()+"/graph-series8.tmp "+getFilesDir()+"/graph-series8.csv");

                    // remove the header
                    String Sed9 = exec("sed -e 1d "+getFilesDir()+"/graph-series9.csv");
                    FileOutputStream fileoutS9 = openFileOutput("graph-series9.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS9 = new OutputStreamWriter(fileoutS9);
                    outputWriterS9.write(Sed9);
                    outputWriterS9.close();
                    exec("rm "+getFilesDir()+"/graph-series9.csv");
                    exec("mv "+getFilesDir()+"/graph-series9.tmp "+getFilesDir()+"/graph-series9.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort9 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series9.csv");
                    FileOutputStream fileoutG9 = openFileOutput("graph-series9.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG9 = new OutputStreamWriter(fileoutG9);
                    outputWriterG9.write(Sort9);
                    outputWriterG9.close();
                    exec("rm "+getFilesDir()+"/graph-series9.csv");
                    exec("mv "+getFilesDir()+"/graph-series9.tmp "+getFilesDir()+"/graph-series9.csv");
                    // remove blank lines in sorted file
                    String BlankLin9 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series9.csv");
                    FileOutputStream fileoutBL9 = openFileOutput("graph-series9.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL9 = new OutputStreamWriter(fileoutBL9);
                    outputWriterBL9.write(BlankLin9);
                    outputWriterBL9.close();
                    exec("rm "+getFilesDir()+"/graph-series9.csv");
                    exec("mv "+getFilesDir()+"/graph-series9.tmp "+getFilesDir()+"/graph-series9.csv");

                    // remove the header
                    String Sed10 = exec("sed -e 1d "+getFilesDir()+"/graph-series10.csv");
                    FileOutputStream fileoutS10 = openFileOutput("graph-series10.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS10 = new OutputStreamWriter(fileoutS10);
                    outputWriterS10.write(Sed10);
                    outputWriterS10.close();
                    exec("rm "+getFilesDir()+"/graph-series10.csv");
                    exec("mv "+getFilesDir()+"/graph-series10.tmp "+getFilesDir()+"/graph-series10.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort10 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series10.csv");
                    FileOutputStream fileoutG10 = openFileOutput("graph-series10.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG10 = new OutputStreamWriter(fileoutG10);
                    outputWriterG10.write(Sort10);
                    outputWriterG10.close();
                    exec("rm "+getFilesDir()+"/graph-series10.csv");
                    exec("mv "+getFilesDir()+"/graph-series10.tmp "+getFilesDir()+"/graph-series10.csv");
                    // remove blank lines in sorted file
                    String BlankLin10 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series10.csv");
                    FileOutputStream fileoutBL10 = openFileOutput("graph-series10.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL10 = new OutputStreamWriter(fileoutBL10);
                    outputWriterBL10.write(BlankLin10);
                    outputWriterBL10.close();
                    exec("rm "+getFilesDir()+"/graph-series10.csv");
                    exec("mv "+getFilesDir()+"/graph-series10.tmp "+getFilesDir()+"/graph-series10.csv");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Phreeqc.this, Graph.class);
                startActivity(intent);
            }
        });

        Scatter = (Button) findViewById(R.id.Scatter);
        Scatter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    // remove the header
                    String Sed = exec("sed -e 1d "+getFilesDir()+"/graph-series1.csv");
                    FileOutputStream fileoutS = openFileOutput("graph-series1.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS = new OutputStreamWriter(fileoutS);
                    outputWriterS.write(Sed);
                    outputWriterS.close();
                    exec("rm "+getFilesDir()+"/graph-series1.csv");
                    exec("mv "+getFilesDir()+"/graph-series1.tmp "+getFilesDir()+"/graph-series1.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series1.csv");
                    FileOutputStream fileoutG = openFileOutput("graph-series1.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG = new OutputStreamWriter(fileoutG);
                    outputWriterG.write(Sort);
                    outputWriterG.close();
                    exec("rm "+getFilesDir()+"/graph-series1.csv");
                    exec("mv "+getFilesDir()+"/graph-series1.tmp "+getFilesDir()+"/graph-series1.csv");
                    // remove blank lines in sorted file
                    String BlankLin = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series1.csv");
                    FileOutputStream fileoutBL = openFileOutput("graph-series1.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL = new OutputStreamWriter(fileoutBL);
                    outputWriterBL.write(BlankLin);
                    outputWriterBL.close();
                    exec("rm "+getFilesDir()+"/graph-series1.csv");
                    exec("mv "+getFilesDir()+"/graph-series1.tmp "+getFilesDir()+"/graph-series1.csv");

                    // remove the header
                    String Sed2 = exec("sed -e 1d "+getFilesDir()+"/graph-series2.csv");
                    FileOutputStream fileoutS2 = openFileOutput("graph-series2.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS2 = new OutputStreamWriter(fileoutS2);
                    outputWriterS2.write(Sed2);
                    outputWriterS2.close();
                    exec("rm "+getFilesDir()+"/graph-series2.csv");
                    exec("mv "+getFilesDir()+"/graph-series2.tmp "+getFilesDir()+"/graph-series2.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort2 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series2.csv");
                    FileOutputStream fileoutG2 = openFileOutput("graph-series2.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG2 = new OutputStreamWriter(fileoutG2);
                    outputWriterG2.write(Sort2);
                    outputWriterG2.close();
                    exec("rm "+getFilesDir()+"/graph-series2.csv");
                    exec("mv "+getFilesDir()+"/graph-series2.tmp "+getFilesDir()+"/graph-series2.csv");
                    // remove blank lines in sorted file
                    String BlankLin2 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series2.csv");
                    FileOutputStream fileoutBL2 = openFileOutput("graph-series2.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL2 = new OutputStreamWriter(fileoutBL2);
                    outputWriterBL2.write(BlankLin2);
                    outputWriterBL2.close();
                    exec("rm "+getFilesDir()+"/graph-series2.csv");
                    exec("mv "+getFilesDir()+"/graph-series2.tmp "+getFilesDir()+"/graph-series2.csv");

                    // remove the header
                    String Sed3 = exec("sed -e 1d "+getFilesDir()+"/graph-series3.csv");
                    FileOutputStream fileoutS3 = openFileOutput("graph-series3.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS3 = new OutputStreamWriter(fileoutS3);
                    outputWriterS3.write(Sed3);
                    outputWriterS3.close();
                    exec("rm "+getFilesDir()+"/graph-series3.csv");
                    exec("mv "+getFilesDir()+"/graph-series3.tmp "+getFilesDir()+"/graph-series3.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort3 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series3.csv");
                    FileOutputStream fileoutG3 = openFileOutput("graph-series3.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG3 = new OutputStreamWriter(fileoutG3);
                    outputWriterG3.write(Sort3);
                    outputWriterG3.close();
                    exec("rm "+getFilesDir()+"/graph-series3.csv");
                    exec("mv "+getFilesDir()+"/graph-series3.tmp "+getFilesDir()+"/graph-series3.csv");
                    // remove blank lines in sorted file
                    String BlankLin3 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series3.csv");
                    FileOutputStream fileoutBL3 = openFileOutput("graph-series3.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL3 = new OutputStreamWriter(fileoutBL3);
                    outputWriterBL3.write(BlankLin3);
                    outputWriterBL3.close();
                    exec("rm "+getFilesDir()+"/graph-series3.csv");
                    exec("mv "+getFilesDir()+"/graph-series3.tmp "+getFilesDir()+"/graph-series3.csv");

                    // remove the header
                    String Sed4 = exec("sed -e 1d "+getFilesDir()+"/graph-series4.csv");
                    FileOutputStream fileoutS4 = openFileOutput("graph-series4.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS4 = new OutputStreamWriter(fileoutS4);
                    outputWriterS4.write(Sed4);
                    outputWriterS4.close();
                    exec("rm "+getFilesDir()+"/graph-series4.csv");
                    exec("mv "+getFilesDir()+"/graph-series4.tmp "+getFilesDir()+"/graph-series4.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort4 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series4.csv");
                    FileOutputStream fileoutG4 = openFileOutput("graph-series4.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG4 = new OutputStreamWriter(fileoutG4);
                    outputWriterG4.write(Sort4);
                    outputWriterG4.close();
                    exec("rm "+getFilesDir()+"/graph-series4.csv");
                    exec("mv "+getFilesDir()+"/graph-series4.tmp "+getFilesDir()+"/graph-series4.csv");
                    // remove blank lines in sorted file
                    String BlankLin4 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series4.csv");
                    FileOutputStream fileoutBL4 = openFileOutput("graph-series4.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL4 = new OutputStreamWriter(fileoutBL4);
                    outputWriterBL4.write(BlankLin4);
                    outputWriterBL4.close();
                    exec("rm "+getFilesDir()+"/graph-series4.csv");
                    exec("mv "+getFilesDir()+"/graph-series4.tmp "+getFilesDir()+"/graph-series4.csv");

                    // remove the header
                    String Sed5 = exec("sed -e 1d "+getFilesDir()+"/graph-series5.csv");
                    FileOutputStream fileoutS5 = openFileOutput("graph-series5.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS5 = new OutputStreamWriter(fileoutS5);
                    outputWriterS5.write(Sed5);
                    outputWriterS5.close();
                    exec("rm "+getFilesDir()+"/graph-series5.csv");
                    exec("mv "+getFilesDir()+"/graph-series5.tmp "+getFilesDir()+"/graph-series5.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort5 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series5.csv");
                    FileOutputStream fileoutG5 = openFileOutput("graph-series5.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG5 = new OutputStreamWriter(fileoutG5);
                    outputWriterG5.write(Sort5);
                    outputWriterG5.close();
                    exec("rm "+getFilesDir()+"/graph-series5.csv");
                    exec("mv "+getFilesDir()+"/graph-series5.tmp "+getFilesDir()+"/graph-series5.csv");
                    // remove blank lines in sorted file
                    String BlankLin5 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series5.csv");
                    FileOutputStream fileoutBL5 = openFileOutput("graph-series5.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL5 = new OutputStreamWriter(fileoutBL5);
                    outputWriterBL5.write(BlankLin5);
                    outputWriterBL5.close();
                    exec("rm "+getFilesDir()+"/graph-series5.csv");
                    exec("mv "+getFilesDir()+"/graph-series5.tmp "+getFilesDir()+"/graph-series5.csv");

                    // remove the header
                    String Sed6 = exec("sed -e 1d "+getFilesDir()+"/graph-series6.csv");
                    FileOutputStream fileoutS6 = openFileOutput("graph-series6.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS6 = new OutputStreamWriter(fileoutS6);
                    outputWriterS6.write(Sed6);
                    outputWriterS6.close();
                    exec("rm "+getFilesDir()+"/graph-series6.csv");
                    exec("mv "+getFilesDir()+"/graph-series6.tmp "+getFilesDir()+"/graph-series6.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort6 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series6.csv");
                    FileOutputStream fileoutG6 = openFileOutput("graph-series6.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG6 = new OutputStreamWriter(fileoutG6);
                    outputWriterG6.write(Sort6);
                    outputWriterG6.close();
                    exec("rm "+getFilesDir()+"/graph-series6.csv");
                    exec("mv "+getFilesDir()+"/graph-series6.tmp "+getFilesDir()+"/graph-series6.csv");
                    // remove blank lines in sorted file
                    String BlankLin6 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series6.csv");
                    FileOutputStream fileoutBL6 = openFileOutput("graph-series6.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL6 = new OutputStreamWriter(fileoutBL6);
                    outputWriterBL6.write(BlankLin6);
                    outputWriterBL6.close();
                    exec("rm "+getFilesDir()+"/graph-series6.csv");
                    exec("mv "+getFilesDir()+"/graph-series6.tmp "+getFilesDir()+"/graph-series6.csv");

                    // remove the header
                    String Sed7 = exec("sed -e 1d "+getFilesDir()+"/graph-series7.csv");
                    FileOutputStream fileoutS7 = openFileOutput("graph-series7.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS7 = new OutputStreamWriter(fileoutS7);
                    outputWriterS7.write(Sed7);
                    outputWriterS7.close();
                    exec("rm "+getFilesDir()+"/graph-series7.csv");
                    exec("mv "+getFilesDir()+"/graph-series7.tmp "+getFilesDir()+"/graph-series7.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort7 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series7.csv");
                    FileOutputStream fileoutG7 = openFileOutput("graph-series7.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG7 = new OutputStreamWriter(fileoutG7);
                    outputWriterG7.write(Sort7);
                    outputWriterG7.close();
                    exec("rm "+getFilesDir()+"/graph-series7.csv");
                    exec("mv "+getFilesDir()+"/graph-series7.tmp "+getFilesDir()+"/graph-series7.csv");
                    // remove blank lines in sorted file
                    String BlankLin7 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series7.csv");
                    FileOutputStream fileoutBL7 = openFileOutput("graph-series7.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL7 = new OutputStreamWriter(fileoutBL7);
                    outputWriterBL7.write(BlankLin7);
                    outputWriterBL7.close();
                    exec("rm "+getFilesDir()+"/graph-series7.csv");
                    exec("mv "+getFilesDir()+"/graph-series7.tmp "+getFilesDir()+"/graph-series7.csv");

                    // remove the header
                    String Sed8 = exec("sed -e 1d "+getFilesDir()+"/graph-series8.csv");
                    FileOutputStream fileoutS8 = openFileOutput("graph-series8.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS8 = new OutputStreamWriter(fileoutS8);
                    outputWriterS8.write(Sed8);
                    outputWriterS8.close();
                    exec("rm "+getFilesDir()+"/graph-series8.csv");
                    exec("mv "+getFilesDir()+"/graph-series8.tmp "+getFilesDir()+"/graph-series8.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort8 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series8.csv");
                    FileOutputStream fileoutG8 = openFileOutput("graph-series8.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG8 = new OutputStreamWriter(fileoutG8);
                    outputWriterG8.write(Sort8);
                    outputWriterG8.close();
                    exec("rm "+getFilesDir()+"/graph-series8.csv");
                    exec("mv "+getFilesDir()+"/graph-series8.tmp "+getFilesDir()+"/graph-series8.csv");
                    // remove blank lines in sorted file
                    String BlankLin8 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series8.csv");
                    FileOutputStream fileoutBL8 = openFileOutput("graph-series8.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL8 = new OutputStreamWriter(fileoutBL8);
                    outputWriterBL8.write(BlankLin8);
                    outputWriterBL8.close();
                    exec("rm "+getFilesDir()+"/graph-series8.csv");
                    exec("mv "+getFilesDir()+"/graph-series8.tmp "+getFilesDir()+"/graph-series8.csv");

                    // remove the header
                    String Sed9 = exec("sed -e 1d "+getFilesDir()+"/graph-series9.csv");
                    FileOutputStream fileoutS9 = openFileOutput("graph-series9.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS9 = new OutputStreamWriter(fileoutS9);
                    outputWriterS9.write(Sed9);
                    outputWriterS9.close();
                    exec("rm "+getFilesDir()+"/graph-series9.csv");
                    exec("mv "+getFilesDir()+"/graph-series9.tmp "+getFilesDir()+"/graph-series9.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort9 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series9.csv");
                    FileOutputStream fileoutG9 = openFileOutput("graph-series9.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG9 = new OutputStreamWriter(fileoutG9);
                    outputWriterG9.write(Sort9);
                    outputWriterG9.close();
                    exec("rm "+getFilesDir()+"/graph-series9.csv");
                    exec("mv "+getFilesDir()+"/graph-series9.tmp "+getFilesDir()+"/graph-series9.csv");
                    // remove blank lines in sorted file
                    String BlankLin9 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series9.csv");
                    FileOutputStream fileoutBL9 = openFileOutput("graph-series9.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL9 = new OutputStreamWriter(fileoutBL9);
                    outputWriterBL9.write(BlankLin9);
                    outputWriterBL9.close();
                    exec("rm "+getFilesDir()+"/graph-series9.csv");
                    exec("mv "+getFilesDir()+"/graph-series9.tmp "+getFilesDir()+"/graph-series9.csv");

                    // remove the header
                    String Sed10 = exec("sed -e 1d "+getFilesDir()+"/graph-series10.csv");
                    FileOutputStream fileoutS10 = openFileOutput("graph-series10.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterS10 = new OutputStreamWriter(fileoutS10);
                    outputWriterS10.write(Sed10);
                    outputWriterS10.close();
                    exec("rm "+getFilesDir()+"/graph-series10.csv");
                    exec("mv "+getFilesDir()+"/graph-series10.tmp "+getFilesDir()+"/graph-series10.csv");
                    // sort file by first column, it must not contain header
                    // sort file by first column, it must not contain header
                    // original command - without extended shell, using Android built in toybox
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // such a command would work in extended shell, not in simple:
                    // String Sort = exec("sort -t',' -k1n,1 "+getFilesDir()+"/graph.csv");
                    // working:
                    String Sort10 = exec("sort -t, -g -k1,1 "+getFilesDir()+"/graph-series10.csv");
                    FileOutputStream fileoutG10 = openFileOutput("graph-series10.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG10 = new OutputStreamWriter(fileoutG10);
                    outputWriterG10.write(Sort10);
                    outputWriterG10.close();
                    exec("rm "+getFilesDir()+"/graph-series10.csv");
                    exec("mv "+getFilesDir()+"/graph-series10.tmp "+getFilesDir()+"/graph-series10.csv");
                    // remove blank lines in sorted file
                    String BlankLin10 = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/graph-series10.csv");
                    FileOutputStream fileoutBL10 = openFileOutput("graph-series10.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL10 = new OutputStreamWriter(fileoutBL10);
                    outputWriterBL10.write(BlankLin10);
                    outputWriterBL10.close();
                    exec("rm "+getFilesDir()+"/graph-series10.csv");
                    exec("mv "+getFilesDir()+"/graph-series10.tmp "+getFilesDir()+"/graph-series10.csv");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Phreeqc.this, Scatter.class);
                startActivity(intent);
            }
        });

        manual_phreeqc2 = (Button) findViewById(R.id.manual_phreeqc2);
        manual_phreeqc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Phreeqc.this, ManualPHREEQC2.class);
                startActivity(intent);
            }
        });

        manual_phreeqc3 = (Button) findViewById(R.id.manual_phreeqc3);
        manual_phreeqc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Phreeqc.this, ManualPHREEQC3.class);
                startActivity(intent);
            }
        });

        manual_phreeqc_isotopes = (Button) findViewById(R.id.manual_phreeqc_isotopes);
        manual_phreeqc_isotopes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Phreeqc.this, ManualPHREEQCisotopes.class);
                startActivity(intent);
            }
        });


        openIntInputfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Phreeqc.this, PhreeqcWork.class);
                startActivity(intent);
            }
        });
    }


    public void onStart()
    {
        super.onStart();
        // for now - from MainActivity - there it is not working
        exec("rm "+getFilesDir()+"/Database_g2.dat");
        exec("rm "+getFilesDir()+"/Database_g1.dat");

        exec("rm "+getFilesDir()+"/Database_s2.dat");
        exec("rm "+getFilesDir()+"/Database_s1.dat");

        exec("rm "+getFilesDir()+"/Database_solid_sol2.dat");
        exec("rm "+getFilesDir()+"/Database_solid_sol1.dat");

        // not optimal here:
//        exec("rm "+getFilesDir()+"/DisplayCurrentFile.txt");

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
        sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
        ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
        r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
        k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
        delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
    }

    private View.OnClickListener AddSSClick; {

        AddSSClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read1(getApplicationContext());
//                outputX(exec("cat "+getFilesDir()+"/Solution.dat"));
                output2(exec("cat "+getFilesDir()+"/Solution.dat"));
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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
            }
        };
    }

    private View.OnClickListener AddPClick; {

        AddPClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read2(getApplicationContext());
//                outputX(exec("cat "+getFilesDir()+"/Gas.dat"));
                output2(exec("cat "+getFilesDir()+"/Gas.dat"));
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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
            }
        };
    }

    private View.OnClickListener saveExtInputfileClick; {

        saveExtInputfileClick = new View.OnClickListener() {
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
                write1(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
            }
        };
    }

    private View.OnClickListener saveExtOutputfileClick; {

        saveExtOutputfileClick = new View.OnClickListener() {
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
                write2(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-phreeqc.txt"));
                output4(exec("cat "+getFilesDir()+"/Keywords.phr"));
                pView(exec("cat "+getFilesDir()+"/P.txt"));
                ssView(exec("cat "+getFilesDir()+"/SS.txt"));
                dataView(exec("cat "+getFilesDir()+"/Database.txt"));
                sms_kin_View(exec("cat "+getFilesDir()+"/SMS_kin_status.txt"));
                ss_kin_View(exec("cat "+getFilesDir()+"/SS_kin_status.txt"));
                r_kin_View(exec("cat "+getFilesDir()+"/R_kin_status.txt"));
                k_kin_View(exec("cat "+getFilesDir()+"/K_kin_status.txt"));
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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

    private void write1(Context context1) {
        Intent intent1 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        intent1.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent1, CREATE_FILE1250);
    }

    private void write2(Context context2) {
        Intent intent2 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent2.addCategory(Intent.CATEGORY_OPENABLE);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TITLE,"MyOutputFile");
        startActivityForResult(intent2, CREATE_FILE1260);
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
//                outputX(exec("cat "+getFilesDir()+"/Solution.dat"));
                try {
                    FileOutputStream fileout50 = openFileOutput("DisplayCurrentFile.txt",MODE_PRIVATE);
                    OutputStreamWriter outputWriter50 = new OutputStreamWriter(fileout50);
                    outputWriter50.write("Solution.dat");
                    outputWriter50.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String DisplayedFieldFile = exec("cat "+getFilesDir()+"/DisplayCurrentFile.txt");
                outputX(exec("cat "+getFilesDir()+"/"+DisplayedFieldFile));
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
//                outputX(exec("cat "+getFilesDir()+"/Gas.dat"));
                try {
                    FileOutputStream fileout50 = openFileOutput("DisplayCurrentFile.txt",MODE_PRIVATE);
                    OutputStreamWriter outputWriter50 = new OutputStreamWriter(fileout50);
                    outputWriter50.write("Gas.dat");
                    outputWriter50.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String DisplayedFieldFile = exec("cat "+getFilesDir()+"/DisplayCurrentFile.txt");
                outputX(exec("cat "+getFilesDir()+"/"+DisplayedFieldFile));
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
//                outputX(exec("cat "+getFilesDir()+"/SMS_kin.txt"));
                try {
                    FileOutputStream fileout50 = openFileOutput("DisplayCurrentFile.txt",MODE_PRIVATE);
                    OutputStreamWriter outputWriter50 = new OutputStreamWriter(fileout50);
                    outputWriter50.write("SMS_kin.txt");
                    outputWriter50.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String DisplayedFieldFile = exec("cat "+getFilesDir()+"/DisplayCurrentFile.txt");
                outputX(exec("cat "+getFilesDir()+"/"+DisplayedFieldFile));
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
//                outputX(exec("cat "+getFilesDir()+"/SS_kin.txt"));
                try {
                    FileOutputStream fileout50 = openFileOutput("DisplayCurrentFile.txt",MODE_PRIVATE);
                    OutputStreamWriter outputWriter50 = new OutputStreamWriter(fileout50);
                    outputWriter50.write("SS_kin.txt");
                    outputWriter50.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String DisplayedFieldFile = exec("cat "+getFilesDir()+"/DisplayCurrentFile.txt");
                outputX(exec("cat "+getFilesDir()+"/"+DisplayedFieldFile));
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
                // important!
//                outputX(exec("cat "+getFilesDir()+"/R_kin.txt"));
                try {
                    FileOutputStream fileout50 = openFileOutput("DisplayCurrentFile.txt",MODE_PRIVATE);
                    OutputStreamWriter outputWriter50 = new OutputStreamWriter(fileout50);
                    outputWriter50.write("R_kin.txt");
                    outputWriter50.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String DisplayedFieldFile = exec("cat "+getFilesDir()+"/DisplayCurrentFile.txt");
                outputX(exec("cat "+getFilesDir()+"/"+DisplayedFieldFile));
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
//                outputX(exec("cat "+getFilesDir()+"/K_kin.txt"));
                try {
                    FileOutputStream fileout50 = openFileOutput("DisplayCurrentFile.txt",MODE_PRIVATE);
                    OutputStreamWriter outputWriter50 = new OutputStreamWriter(fileout50);
                    outputWriter50.write("K_kin.txt");
                    outputWriter50.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String DisplayedFieldFile = exec("cat "+getFilesDir()+"/DisplayCurrentFile.txt");
                outputX(exec("cat "+getFilesDir()+"/"+DisplayedFieldFile));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE1250 && data != null) {
            // save input file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri01 = data.getData();
                ParcelFileDescriptor pfd01 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd01.getFileDescriptor());
                String fileContents = PhreeqcInput.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd01.close();
                FileOutputStream fileout = openFileOutput("Input-phreeqc.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE1260 && data != null) {
            // save output file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri02 = data.getData();
                ParcelFileDescriptor pfd02 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd02.getFileDescriptor());
                String fileContents = outputView2.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd02.close();
                FileOutputStream fileout = openFileOutput("Input.phr.out", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private View.OnClickListener ResetSSClick; {

        ResetSSClick = new View.OnClickListener() {
            public void onClick(View v) {



                // TODO Auto-generated method stub //
                exec("rm "+getFilesDir()+"/FragmentSS.dat");
                exec("rm "+getFilesDir()+"/Solution.dat");
                exec("rm "+getFilesDir()+"/DisplayCurrentFile.txt");

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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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
//                    exec("mv "+getFilesDir()+"/Solution_species.dat "+getFilesDir()+"/work");
                    exec("chmod 755 -R "+getFilesDir()+"/work");
//                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc-prepare.so");
                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; grep -f Solution_species.dat Selected.dat > DatabaseFragment.dat");
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
//                        output2(exec("cat "+getFilesDir()+"/Solution.dat"));
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
                        sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                        ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                        r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                        k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                        delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2highlighted(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized_phreeqc(str2), EditText.BufferType.SPANNABLE);
                    }
                };
                handler.post(proc2);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }



    private View.OnClickListener delete_buttonClick; {

        delete_buttonClick = new View.OnClickListener() {
            public void onClick(View v) {

                String Delete = delete.getText().toString();
                try {
                    FileOutputStream fileoutDel = openFileOutput("Delete.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterDel = new OutputStreamWriter(fileoutDel);
                    outputWriterDel.write(Delete);
                    outputWriterDel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

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

                Delete = Delete.replace("[", "\\[");
                Delete = Delete.replace("]", "\\]");

                // TODO Auto-generated method stub //
                com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; sed -i -e '/"+Delete+"/d' Database.dat ");

                output2("Entry deleted from the working database.");
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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
            }
        };
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
//                    exec("mv "+getFilesDir()+"/Solution_species.dat "+getFilesDir()+"/work");
                    exec("chmod 755 -R "+getFilesDir()+"/work");
//                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc-prepare.so");
                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; grep -f Solution_species.dat Selected.dat > DatabaseFragment.dat");
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
//                        output2(exec("cat "+getFilesDir()+"/Solution.dat"));
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
                        sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                        ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                        r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                        k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                        delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2highlighted(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized_phreeqc(str2), EditText.BufferType.SPANNABLE);
                    }
                };
                handler.post(proc2);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }

    private View.OnClickListener modifybuttonSMSClick; {

        modifybuttonSMSClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Keywordfile = ModifyEditSMS.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("KeywordsSMS.phr", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Keywordfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("cp "+getFilesDir()+"/KeywordsSMS.phr "+getFilesDir()+"/Solution_species.dat");
                exec("cp "+getFilesDir()+"/SMS_kin.txt "+getFilesDir()+"/Selected.dat");
                // TODO Auto-generated method stub //
                openprogressdialogSMS();

            }
        };
    }

    private void openprogressdialogSMS() {
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
//                    exec("mv "+getFilesDir()+"/Solution_species.dat "+getFilesDir()+"/work");
                    exec("chmod 755 -R "+getFilesDir()+"/work");
//                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc-prepare.so");
                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; grep -f Solution_species.dat Selected.dat > DatabaseFragment.dat");
                    exec("chmod 755 "+getFilesDir()+"/DatabaseFragment.dat");
                    exec("mv "+getFilesDir()+"/DatabaseFragment.dat "+getFilesDir()+"/SMS_kin.txt");

                    try {
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
                        output2highlighted(exec("cat "+getFilesDir()+"/SMS_kin.txt"));
//                        output2(exec("cat "+getFilesDir()+"/SMS_kin.txt"));
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
                        sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                        ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                        r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                        k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                        delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2highlighted(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized_phreeqc(str2), EditText.BufferType.SPANNABLE);
                    }
                };
                handler.post(proc2);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }

    private View.OnClickListener modifybuttonSSClick; {

        modifybuttonSSClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Keywordfile = ModifyEditSS.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("KeywordsSS.phr", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Keywordfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("cp "+getFilesDir()+"/KeywordsSS.phr "+getFilesDir()+"/Solution_species.dat");
                exec("cp "+getFilesDir()+"/SS_kin.txt "+getFilesDir()+"/Selected.dat");
                // TODO Auto-generated method stub //
                openprogressdialogSS();

            }
        };
    }

    private void openprogressdialogSS() {
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
//                    exec("mv "+getFilesDir()+"/Solution_species.dat "+getFilesDir()+"/work");
                    exec("chmod 755 -R "+getFilesDir()+"/work");
//                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc-prepare.so");
                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; grep -f Solution_species.dat Selected.dat > DatabaseFragment.dat");
                    exec("chmod 755 "+getFilesDir()+"/DatabaseFragment.dat");
                    exec("mv "+getFilesDir()+"/DatabaseFragment.dat "+getFilesDir()+"/SS_kin.txt");

                    try {
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
                        output2highlighted(exec("cat "+getFilesDir()+"/SS_kin.txt"));
//                        output2(exec("cat "+getFilesDir()+"/SS_kin.txt"));
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
                        sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                        ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                        r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                        k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                        delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2highlighted(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized_phreeqc(str2), EditText.BufferType.SPANNABLE);
                    }
                };
                handler.post(proc2);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }

    private View.OnClickListener modifybuttonRClick; {

        modifybuttonRClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Keywordfile = ModifyEditR.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("KeywordsR.phr", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Keywordfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("cp "+getFilesDir()+"/KeywordsR.phr "+getFilesDir()+"/Solution_species.dat");
                exec("cp "+getFilesDir()+"/R_kin.txt "+getFilesDir()+"/Selected.dat");
                // TODO Auto-generated method stub //
                openprogressdialogR();

            }
        };
    }

    private void openprogressdialogR() {
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
//                    exec("mv "+getFilesDir()+"/Solution_species.dat "+getFilesDir()+"/work");
                    exec("chmod 755 -R "+getFilesDir()+"/work");
//                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc-prepare.so");
                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; grep -f Solution_species.dat Selected.dat > DatabaseFragment.dat");
                    exec("chmod 755 "+getFilesDir()+"/DatabaseFragment.dat");
                    exec("mv "+getFilesDir()+"/DatabaseFragment.dat "+getFilesDir()+"/R_kin.txt");

                    try {
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
                        output2highlighted(exec("cat "+getFilesDir()+"/R_kin.txt"));
//                        output2(exec("cat "+getFilesDir()+"/R_kin.txt"));
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
                        sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                        ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                        r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                        k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                        delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2highlighted(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized_phreeqc(str2), EditText.BufferType.SPANNABLE);
                    }
                };
                handler.post(proc2);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }

    private View.OnClickListener modifybuttonKClick; {

        modifybuttonKClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Keywordfile = ModifyEditK.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("KeywordsK.phr", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Keywordfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("cp "+getFilesDir()+"/KeywordsK.phr "+getFilesDir()+"/Solution_species.dat");
                exec("cp "+getFilesDir()+"/K_kin.txt "+getFilesDir()+"/Selected.dat");
                // TODO Auto-generated method stub //
                openprogressdialogK();

            }
        };
    }

    private void openprogressdialogK() {
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
//                    exec("mv "+getFilesDir()+"/Solution_species.dat "+getFilesDir()+"/work");
                    exec("chmod 755 -R "+getFilesDir()+"/work");
//                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc-prepare.so");
                    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; grep -f Solution_species.dat Selected.dat > DatabaseFragment.dat");
                    exec("chmod 755 "+getFilesDir()+"/DatabaseFragment.dat");
                    exec("mv "+getFilesDir()+"/DatabaseFragment.dat "+getFilesDir()+"/K_kin.txt");

                    try {
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
                        output2highlighted(exec("cat "+getFilesDir()+"/K_kin.txt"));
//                        output2(exec("cat "+getFilesDir()+"/K_kin.txt"));
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
                        sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                        ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                        r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                        k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                        delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2highlighted(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized_phreeqc(str2), EditText.BufferType.SPANNABLE);
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
                exec("rm "+getFilesDir()+"/DisplayCurrentFile.txt");

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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
            }
        };
    }

    private View.OnClickListener ResetSMSKinClick; {

        ResetSMSKinClick = new View.OnClickListener() {
            public void onClick(View v) {

                // TODO Auto-generated method stub //
                exec("rm "+getFilesDir()+"/SMS_kin.txt");
//                exec("rm "+getFilesDir()+"/SS_kin.txt");
//                exec("rm "+getFilesDir()+"/R_kin.txt");
//                exec("rm "+getFilesDir()+"/K_kin.txt");
                exec("rm "+getFilesDir()+"/DisplayCurrentFile.txt");

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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
            }
        };
    }

    private View.OnClickListener ResetSSKinClick; {

        ResetSSKinClick = new View.OnClickListener() {
            public void onClick(View v) {

                // TODO Auto-generated method stub //
//                exec("rm "+getFilesDir()+"/SMS_kin.txt");
                exec("rm "+getFilesDir()+"/SS_kin.txt");
//                exec("rm "+getFilesDir()+"/R_kin.txt");
//                exec("rm "+getFilesDir()+"/K_kin.txt");
                exec("rm "+getFilesDir()+"/DisplayCurrentFile.txt");

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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
            }
        };
    }

    private View.OnClickListener ResetRKinClick; {

        ResetRKinClick = new View.OnClickListener() {
            public void onClick(View v) {

                // TODO Auto-generated method stub //
//                exec("rm "+getFilesDir()+"/SMS_kin.txt");
//                exec("rm "+getFilesDir()+"/SS_kin.txt");
                exec("rm "+getFilesDir()+"/R_kin.txt");
//                exec("rm "+getFilesDir()+"/K_kin.txt");
                exec("rm "+getFilesDir()+"/DisplayCurrentFile.txt");

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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
            }
        };
    }

    private View.OnClickListener ResetKKinClick; {

        ResetKKinClick = new View.OnClickListener() {
            public void onClick(View v) {

                // TODO Auto-generated method stub //
//                exec("rm "+getFilesDir()+"/SMS_kin.txt");
//                exec("rm "+getFilesDir()+"/SS_kin.txt");
//                exec("rm "+getFilesDir()+"/R_kin.txt");
                exec("rm "+getFilesDir()+"/K_kin.txt");
                exec("rm "+getFilesDir()+"/DisplayCurrentFile.txt");

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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
            }
        };
    }


    public void alertSaveInput(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Phreeqc.this);
        editText10.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText10.setTypeface(Typeface.MONOSPACE);
        editText10.addTextChangedListener(new TextWatcher() {
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
                editText10.removeTextChangedListener(this);
                String text = editText10.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText10.getText().clear();
                editText10.append(colorized_dftb(text));
                // place the cursor at the original position
                editText10.setSelection(startChanged+countChanged);
                editText10.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Phreeqc.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/phreeqc_work")
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
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/phreeqc_work");
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
//                exec("cp "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+ File.separator+"phreeqc_plus"+File.separator+"phreeqc_datasets"+File.separator+"Database.dat "+getFilesDir()+"");
                try {
                    exec("chmod 755 -R "+getFilesDir()+"/work");
                    exec("chmod 755 -R "+getFilesDir());
//                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc.so "+getFilesDir()+"/Input-phreeqc.txt "+getFilesDir()+"/Input.phr.out "+getFilesDir()+"/Database.dat");
                    com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; "+getApplicationInfo().nativeLibraryDir+"/libphreeqc.so Input-phreeqc.txt Input.phr.out Database.dat");
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
                        sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                        ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                        r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                        k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                        delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
                        exec("rm "+getFilesDir()+"/DisplayCurrentFile.txt");
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




    private View.OnClickListener RunPhreeqcSilentClick; {

        RunPhreeqcSilentClick = new View.OnClickListener() {
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
                openprogressdialogS();
            }
        };
    }

    private void openprogressdialogS() {
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
//                exec("cp "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+ File.separator+"phreeqc_plus"+File.separator+"phreeqc_datasets"+File.separator+"Database.dat "+getFilesDir()+"");
                try {
                    exec("chmod 755 -R "+getFilesDir()+"/work");
                    exec("chmod 755 -R "+getFilesDir());
//                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc.so "+getFilesDir()+"/Input-phreeqc.txt "+getFilesDir()+"/Input.phr.out "+getFilesDir()+"/Database.dat");
                    com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; "+getApplicationInfo().nativeLibraryDir+"/libphreeqc.so Input-phreeqc.txt Input.phr.out Database.dat");
                    exec("chmod 755 "+getFilesDir()+"/Input.phr.out");

                    try {
                        output2("Silent mode: PHREEQC output is in file /data/data/cz.p/files/Input.phr.out");
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
                        sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                        ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                        r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                        k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                        delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
                        exec("rm "+getFilesDir()+"/DisplayCurrentFile.txt");
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

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
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
                sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
            }
        };
    }





    public void alertSaveOutput(){
        // creating the EditText widget programatically
        EditText editText15 = new EditText(Phreeqc.this);
        editText15.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText15.setTypeface(Typeface.MONOSPACE);
        editText15.addTextChangedListener(new TextWatcher() {
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
                editText15.removeTextChangedListener(this);
                String text = editText15.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText15.getText().clear();
                editText15.append(colorized_dftb(text));
                // place the cursor at the original position
                editText15.setSelection(startChanged+countChanged);
                editText15.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Phreeqc.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/phreeqc_work")
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
                        exec("mv "+getFilesDir()+"/"+SaveOutputName+" "+getFilesDir()+"/phreeqc_work");
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
                    sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
                    ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
                    r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
                    k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
                    delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
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
                outputView2.setText(colorized_phreeqc(strX), EditText.BufferType.SPANNABLE);
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

    private View.OnClickListener AddSSiClick; {
        AddSSiClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Phreeqc.this, AddSolutionSpecies.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener AddPiClick; {
        AddPiClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Phreeqc.this, AddPhases.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener AddSMS_kiniClick; {
        AddSMS_kiniClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Phreeqc.this, AddKinSolutionMasterSpecies.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener AddSS_kiniClick; {
        AddSS_kiniClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Phreeqc.this, AddKinSolutionSpecies.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener AddR_kiniClick; {
        AddR_kiniClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Phreeqc.this, AddKinRates.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener AddK_kiniClick; {
        AddK_kiniClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Phreeqc.this, AddKinKinetics.class);
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

        String DisplayedFieldFile = exec("cat "+getFilesDir()+"/DisplayCurrentFile.txt");
//        outputX(exec("cat "+getFilesDir()+"/"+DisplayedFieldFile));
        output2(exec("cat "+getFilesDir()+"/"+DisplayedFieldFile));
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
        sms_filter_View(exec("cat "+getFilesDir()+"/KeywordsSMS.phr"));
        ss_filter_View(exec("cat "+getFilesDir()+"/KeywordsSS.phr"));
        r_filter_View(exec("cat "+getFilesDir()+"/KeywordsR.phr"));
        k_filter_View(exec("cat "+getFilesDir()+"/KeywordsK.phr"));
        delete_View(exec("cat "+getFilesDir()+"/Delete.txt"));
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                PhreeqcInput.setText(colorized_phreeqc(str3), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc3);
    }
    public void output4(final String str4) {
        Runnable proc4 = new Runnable() {
            public void run() {
                ModifyEdit.setText(colorized_phreeqc(str4), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc4);
    }
    public void output42(final String str42) {
        Runnable proc42 = new Runnable() {
            public void run() {
                ModifyEdit12.setText(colorized_phreeqc(str42), EditText.BufferType.SPANNABLE);
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
    public void sms_filter_View(final String sms_filter_Data) {
        Runnable procsms_filter = new Runnable() {
            public void run() {
                ModifyEditSMS.setText(colorized_phreeqc(sms_filter_Data), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procsms_filter);
    }
    public void ss_filter_View(final String ss_filter_Data) {
        Runnable procss_filter = new Runnable() {
            public void run() {
                ModifyEditSS.setText(colorized_phreeqc(ss_filter_Data), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procss_filter);
    }
    public void r_filter_View(final String r_filter_Data) {
        Runnable procr_filter = new Runnable() {
            public void run() {
                ModifyEditR.setText(colorized_phreeqc(r_filter_Data), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procr_filter);
    }
    public void k_filter_View(final String k_filter_Data) {
        Runnable prock_filter = new Runnable() {
            public void run() {
                ModifyEditK.setText(colorized_phreeqc(k_filter_Data), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(prock_filter);
    }
    public void delete_View(final String delete_Data) {
        Runnable procdelete = new Runnable() {
            public void run() {
                delete.setText(colorized_phreeqc(delete_Data), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procdelete);
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
