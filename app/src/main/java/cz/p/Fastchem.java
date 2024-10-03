package cz.p;

import static cz.p.Spannables.colorized_dftb;
import static cz.p.Spannables.colorized_fastchem;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.jrummyapps.android.shell.CommandResult;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fastchem extends MainActivity {

    private static final int CREATE_FILE1 = 221;
    private static final int CREATE_FILE2 = 222;
    private static final int CREATE_FILE3 = 223;
    private static final int READ_FILE1 = 224;
    private static final int READ_FILE2 = 225;
    private static final int READ_FILE3 = 226;
    private static final int READ_FILE30 = 2260;
    private Uri documentUri1;
    private Uri documentUri2;
    private Uri documentUri3;
    private Uri documentUri4;
    private Uri documentUri5;
    private Uri documentUri6;
    private Uri documentUri60;
    private TextView config_label;
    private EditText config;
    private TextView atmospheric_profile_label;
    private EditText atmospheric_profile;
    private Button openatmofile;
    private Button openatmofile2;
    private Button saveatmofile;
    private Button saveatmofile2;
    private TextView abundance_label;
    private EditText abundance;
    private Button openabundfile;
    private Button openabundfile2;
    private Button saveabundfile;
    private Button saveabundfile2;
    private Button database1;
    private Button database2;
    private Button reset;
    private Button database1cond;
    private Button database2cond;
    private Button resetcond;
    private Button run;
    private Button saveoutputfile;
    private Button saveoutputfile2;
//    private Button transpose;
    private Button highlight;
    private Button quit;
    private TextView textViewX;
    private TextView outputView;
    private EditText outputView2;
    private Handler handler = new Handler();
    private TextView DataLabel;
    private TextView Data;
    private TextView DataCond;
    Button manual_fastchem;
    private TextView filter_gas_label;
    private EditText filter_gas;
    private Button filter_gas_button;
    private TextView filter_cond_label;
    private EditText filter_cond;
    private Button filter_cond_button;
    private Button reset_gas_button;
    private Button reset_cond_button;
    private TextView delete_gas_label;
    private TextView delete_cond_label;
    private EditText delete_gas;
    private EditText delete_cond;
    private Button delete_gas_button;
    private Button delete_cond_button;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fastchem);

        config_label = (TextView) findViewById(R.id.config_label);
        config = (EditText) findViewById(R.id.config);
        config.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        config.addTextChangedListener(new TextWatcher() {
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
                config.removeTextChangedListener(this);
                String text = config.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                config.getText().clear();
                config.append(colorized_fastchem(text));
                // place the cursor at the original position
                config.setSelection(startChanged+countChanged);
                config.addTextChangedListener(this);
            }
        });
        atmospheric_profile_label = (TextView) findViewById(R.id.atmospheric_profile_label);
        atmospheric_profile = (EditText) findViewById(R.id.atmospheric_profile);
        atmospheric_profile.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        atmospheric_profile.addTextChangedListener(new TextWatcher() {
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
                atmospheric_profile.removeTextChangedListener(this);
                String text = atmospheric_profile.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                atmospheric_profile.getText().clear();
                atmospheric_profile.append(colorized_fastchem(text));
                // place the cursor at the original position
                atmospheric_profile.setSelection(startChanged+countChanged);
                atmospheric_profile.addTextChangedListener(this);
            }
        });
        openatmofile = (Button) findViewById(R.id.openatmofile);
//        openatmofile.setOnClickListener(openatmofileClick);
        openatmofile2 = (Button) findViewById(R.id.openatmofile2);
//        openatmofile2.setOnClickListener(openatmofile2Click);
        saveatmofile = (Button) findViewById(R.id.saveatmofile);
        saveatmofile.setOnClickListener(saveatmofileClick);
        saveatmofile2 = (Button) findViewById(R.id.saveatmofile2);
        saveatmofile2.setOnClickListener(saveatmofile2Click);
        abundance_label = (TextView) findViewById(R.id.abundance_label);
        abundance = (EditText) findViewById(R.id.abundance);
        abundance.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        abundance.addTextChangedListener(new TextWatcher() {
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
                abundance.removeTextChangedListener(this);
                String text = abundance.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                abundance.getText().clear();
                abundance.append(colorized_fastchem(text));
                // place the cursor at the original position
                abundance.setSelection(startChanged+countChanged);
                abundance.addTextChangedListener(this);
            }
        });
        openabundfile = (Button) findViewById(R.id.openabundfile);
//        openabundfile.setOnClickListener(openabundfileClick);
        openabundfile2 = (Button) findViewById(R.id.openabundfile2);
//        openabundfile2.setOnClickListener(openabundfile2Click);
        saveabundfile = (Button) findViewById(R.id.saveabundfile);
        saveabundfile.setOnClickListener(saveabundfileClick);
        saveabundfile2 = (Button) findViewById(R.id.saveabundfile2);
        saveabundfile2.setOnClickListener(saveabundfile2Click);
        database1 = (Button) findViewById(R.id.database1);
        database2 = (Button) findViewById(R.id.database2);
        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(resetClick);
        database1cond = (Button) findViewById(R.id.database1cond);
        database2cond = (Button) findViewById(R.id.database2cond);
        resetcond = (Button) findViewById(R.id.resetcond);
        resetcond.setOnClickListener(resetcondClick);
        run = (Button) findViewById(R.id.run);
        run.setOnClickListener(runClick);
        saveoutputfile = (Button) findViewById(R.id.saveoutputfile);
        saveoutputfile.setOnClickListener(saveoutputfileClick);
        saveoutputfile2 = (Button) findViewById(R.id.saveoutputfile2);
        saveoutputfile2.setOnClickListener(saveoutputfile2Click);
//        transpose = (Button) findViewById(R.id.transpose);
//        transpose.setOnClickListener(transposeClick);
        highlight = (Button) findViewById(R.id.highlight);
        highlight.setOnClickListener(highlightClick);
        quit = (Button) findViewById(R.id.quit);
//        quit.setOnClickListener(quitClick);
        textViewX = (TextView) findViewById(R.id.textViewX);
        outputView = (TextView) findViewById(R.id.outputView);
        outputView2 = (EditText) findViewById(R.id.outputView2);
        outputView2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/OutputTextSize.txt")).intValue());
        // disable - otherwise the text could not be selected
//        outputView2.setMovementMethod(new ScrollingMovementMethod());
        DataLabel = (TextView) findViewById(R.id.DataLabel);
        Data = (TextView) findViewById(R.id.Data);
        DataCond = (TextView) findViewById(R.id.DataCond);
        filter_gas_label = (TextView) findViewById(R.id.filter_gas_label);
        filter_cond_label = (TextView) findViewById(R.id.filter_cond_label);
        filter_gas = (EditText) findViewById(R.id.filter_gas);
        filter_gas.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        filter_gas.addTextChangedListener(new TextWatcher() {
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
                filter_gas.removeTextChangedListener(this);
                String text = filter_gas.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                filter_gas.getText().clear();
                filter_gas.append(colorized_fastchem(text));
                // place the cursor at the original position
                filter_gas.setSelection(startChanged+countChanged);
                filter_gas.addTextChangedListener(this);
            }
        });
        filter_cond = (EditText) findViewById(R.id.filter_cond);
        filter_cond.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        filter_cond.addTextChangedListener(new TextWatcher() {
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
                filter_cond.removeTextChangedListener(this);
                String text = filter_cond.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                filter_cond.getText().clear();
                filter_cond.append(colorized_fastchem(text));
                // place the cursor at the original position
                filter_cond.setSelection(startChanged+countChanged);
                filter_cond.addTextChangedListener(this);
            }
        });
        filter_gas_button = (Button) findViewById(R.id.filter_gas_button);
        filter_gas_button.setOnClickListener(filter_gasClick);
        filter_cond_button = (Button) findViewById(R.id.filter_cond_button);
        filter_cond_button.setOnClickListener(filter_condClick);
        reset_gas_button = (Button) findViewById(R.id.reset_gas_button);
        reset_gas_button.setOnClickListener(reset_gas_buttonClick);
        reset_cond_button = (Button) findViewById(R.id.reset_cond_button);
        reset_cond_button.setOnClickListener(reset_cond_buttonClick);
        delete_gas_label = (TextView) findViewById(R.id.delete_gas_label);
        delete_cond_label = (TextView) findViewById(R.id.delete_cond_label);
        delete_gas = (EditText) findViewById(R.id.delete_gas);
        delete_gas.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        delete_gas.addTextChangedListener(new TextWatcher() {
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
                delete_gas.removeTextChangedListener(this);
                String text = delete_gas.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                delete_gas.getText().clear();
                delete_gas.append(colorized_fastchem(text));
                // place the cursor at the original position
                delete_gas.setSelection(startChanged+countChanged);
                delete_gas.addTextChangedListener(this);
            }
        });
        delete_cond = (EditText) findViewById(R.id.delete_cond);
        delete_cond.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        delete_cond.addTextChangedListener(new TextWatcher() {
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
                delete_cond.removeTextChangedListener(this);
                String text = delete_cond.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                delete_cond.getText().clear();
                delete_cond.append(colorized_fastchem(text));
                // place the cursor at the original position
                delete_cond.setSelection(startChanged+countChanged);
                delete_cond.addTextChangedListener(this);
            }
        });
        delete_gas_button = (Button) findViewById(R.id.delete_gas_button);
        delete_gas_button.setOnClickListener(delete_gas_buttonClick);
        delete_cond_button = (Button) findViewById(R.id.delete_cond_button);
        delete_cond_button.setOnClickListener(delete_cond_buttonClick);

        manual_fastchem = (Button) findViewById(R.id.manual_fastchem);
        manual_fastchem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Fastchem.this, ManualFastchem.class);
                startActivity(intent);
            }
        });

        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fastchem.this, MainActivity.class);
                startActivity(intent);
            }
        });

        openatmofile = (Button) findViewById(R.id.openatmofile);
        openatmofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fastchem.this, SelectAtmoFile.class);
                startActivity(intent);
            }
        });

        openatmofile2 = (Button) findViewById(R.id.openatmofile2);
        openatmofile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read1(getApplicationContext());
            }
        });

        openabundfile = (Button) findViewById(R.id.openabundfile);
        openabundfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fastchem.this, SelectAbundFile.class);
                startActivity(intent);
            }
        });

        openabundfile2 = (Button) findViewById(R.id.openabundfile2);
        openabundfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read2(getApplicationContext());
            }
        });

        database1 = (Button) findViewById(R.id.database1);
        database1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fastchem.this, SelectDataFile.class);
                startActivity(intent);
            }
        });

        database1cond = (Button) findViewById(R.id.database1cond);
        database1cond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fastchem.this, SelectDataFileCond.class);
                startActivity(intent);
            }
        });

        database2 = (Button) findViewById(R.id.database2);
        database2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read3(getApplicationContext());

            }
        });

        database2cond = (Button) findViewById(R.id.database2cond);
        database2cond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read30(getApplicationContext());

            }
        });

    }

    @Override
    public void onStart()
    {
        super.onStart();

        File Database_check = new File(getFilesDir()+"/fastchem_database.dat");

        if (!Database_check.exists()) {
            try {
                FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                outputWriterSMS_kin.write("database for gaseous species not present");
                outputWriterSMS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                outputWriterSMS_kin.write("database for gaseous species present");
                outputWriterSMS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File Database_checkCond = new File(getFilesDir()+"/fastchem_database_cond.dat");

        if (!Database_checkCond.exists()) {
            try {
                FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                outputWriterSMS_kin.write("database for condensed species not present");
                outputWriterSMS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                outputWriterSMS_kin.write("database for condensed species present");
                outputWriterSMS_kin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        exec("chmod 755 "+getFilesDir()+"/Input.txt");
//        exec("rm "+getFilesDir()+"/Output.txt");
//        exec("rm "+getFilesDir()+"/chemistry.dat");
//        exec("rm "+getFilesDir()+"/monitor.dat");
        output_conf(exec("cat "+getFilesDir()+"/config.input"));
        output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
        output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
        dataView(exec("cat "+getFilesDir()+"/StatusFastchem.txt"));
        dataViewCond(exec("cat "+getFilesDir()+"/StatusFastchemCond.txt"));
        filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
        filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
        deleteGasView(exec("cat "+getFilesDir()+"/DeleteGas.txt"));
        deleteCondView(exec("cat "+getFilesDir()+"/DeleteCond.txt"));
        output("App prepared.");
    }

    private View.OnClickListener resetClick; {

        resetClick = new View.OnClickListener() {
            public void onClick(View v) {

                // TODO Auto-generated method stub //
                exec("rm "+getFilesDir()+"/fastchem_database.dat");
                exec("rm "+getFilesDir()+"/fastchem_database_content.dat");

                File Database_check = new File(getFilesDir()+"/fastchem_database.dat");

                if (!Database_check.exists()) {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for gaseous species not present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for gaseous species present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File Database_checkCond = new File(getFilesDir()+"/fastchem_database_cond.dat");

                if (!Database_checkCond.exists()) {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for condensed species not present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for condensed species present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                output_conf(exec("cat "+getFilesDir()+"/config.input"));
                output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
                output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
                dataView(exec("cat "+getFilesDir()+"/StatusFastchem.txt"));
                dataViewCond(exec("cat "+getFilesDir()+"/StatusFastchemCond.txt"));
                output("Database deleted.");
//                output2(exec("cat "+getFilesDir()+"/chemistry.dat"));
                filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
                filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
                deleteGasView(exec("cat "+getFilesDir()+"/DeleteGas.txt"));
                deleteCondView(exec("cat "+getFilesDir()+"/DeleteCond.txt"));
            }
        };
    }

    private View.OnClickListener resetcondClick; {

        resetcondClick = new View.OnClickListener() {
            public void onClick(View v) {

                // TODO Auto-generated method stub //
                exec("rm "+getFilesDir()+"/fastchem_database_cond.dat");
                exec("rm "+getFilesDir()+"/fastchem_database_content_cond.dat");

                File Database_check = new File(getFilesDir()+"/fastchem_database.dat");

                if (!Database_check.exists()) {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for gaseous species not present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for gaseous species present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File Database_checkCond = new File(getFilesDir()+"/fastchem_database_cond.dat");

                if (!Database_checkCond.exists()) {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for condensed species not present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for condensed species present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                output_conf(exec("cat "+getFilesDir()+"/config.input"));
                output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
                output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
                dataView(exec("cat "+getFilesDir()+"/StatusFastchem.txt"));
                dataViewCond(exec("cat "+getFilesDir()+"/StatusFastchemCond.txt"));
                output("Database deleted.");
//                output2(exec("cat "+getFilesDir()+"/chemistry.dat"));
                filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
                filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
                deleteGasView(exec("cat "+getFilesDir()+"/DeleteGas.txt"));
                deleteCondView(exec("cat "+getFilesDir()+"/DeleteCond.txt"));
            }
        };
    }

    private View.OnClickListener reset_gas_buttonClick; {

        reset_gas_buttonClick = new View.OnClickListener() {
            public void onClick(View v) {

                // TODO Auto-generated method stub //
                exec("rm "+getFilesDir()+"/fastchem_database_fragment.dat");

                File Database_check = new File(getFilesDir()+"/fastchem_database.dat");

                if (!Database_check.exists()) {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for gaseous species not present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for gaseous species present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File Database_checkCond = new File(getFilesDir()+"/fastchem_database_cond.dat");

                if (!Database_checkCond.exists()) {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for condensed species not present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for condensed species present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                output_conf(exec("cat "+getFilesDir()+"/config.input"));
                output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
                output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
                dataView(exec("cat "+getFilesDir()+"/StatusFastchem.txt"));
                dataViewCond(exec("cat "+getFilesDir()+"/StatusFastchemCond.txt"));
                output("Database deleted.");
//                output2(exec("cat "+getFilesDir()+"/chemistry.dat"));
                filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
                filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
                deleteGasView(exec("cat "+getFilesDir()+"/DeleteGas.txt"));
                deleteCondView(exec("cat "+getFilesDir()+"/DeleteCond.txt"));
            }
        };
    }

    private View.OnClickListener reset_cond_buttonClick; {

        reset_cond_buttonClick = new View.OnClickListener() {
            public void onClick(View v) {

                // TODO Auto-generated method stub //
                exec("rm "+getFilesDir()+"/fastchem_database_cond_fragment.dat");

                File Database_check = new File(getFilesDir()+"/fastchem_database.dat");

                if (!Database_check.exists()) {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for gaseous species not present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for gaseous species present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                File Database_checkCond = new File(getFilesDir()+"/fastchem_database_cond.dat");

                if (!Database_checkCond.exists()) {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for condensed species not present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                        outputWriterSMS_kin.write("database for condensed species present");
                        outputWriterSMS_kin.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                output_conf(exec("cat "+getFilesDir()+"/config.input"));
                output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
                output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
                dataView(exec("cat "+getFilesDir()+"/StatusFastchem.txt"));
                dataViewCond(exec("cat "+getFilesDir()+"/StatusFastchemCond.txt"));
                output("Database deleted.");
//                output2(exec("cat "+getFilesDir()+"/chemistry.dat"));
                filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
                filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
                deleteGasView(exec("cat "+getFilesDir()+"/DeleteGas.txt"));
                deleteCondView(exec("cat "+getFilesDir()+"/DeleteCond.txt"));
            }
        };
    }

    private View.OnClickListener delete_gas_buttonClick; {

        delete_gas_buttonClick = new View.OnClickListener() {
            public void onClick(View v) {

                String GasDelete = delete_gas.getText().toString();
                try {
                    FileOutputStream fileoutGasDel = openFileOutput("DeleteGas.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterGasDel = new OutputStreamWriter(fileoutGasDel);
                    outputWriterGasDel.write(GasDelete);
                    outputWriterGasDel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                GasDelete = GasDelete.replace("[", "\\[");
                GasDelete = GasDelete.replace("]", "\\]");

                // TODO Auto-generated method stub //
                com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; sed -i -e '/"+GasDelete+"/{N;N;d}' fastchem_database.dat ");

                output_conf(exec("cat "+getFilesDir()+"/config.input"));
                output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
                output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
                dataView(exec("cat "+getFilesDir()+"/StatusFastchem.txt"));
                dataViewCond(exec("cat "+getFilesDir()+"/StatusFastchemCond.txt"));
                output("Entry deleted from the working database.");
//                output2(exec("cat "+getFilesDir()+"/chemistry.dat"));
                filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
                filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
                deleteGasView(exec("cat "+getFilesDir()+"/DeleteGas.txt"));
                deleteCondView(exec("cat "+getFilesDir()+"/DeleteCond.txt"));
            }
        };
    }

    private View.OnClickListener delete_cond_buttonClick; {

        delete_cond_buttonClick = new View.OnClickListener() {
            public void onClick(View v) {

                String CondDelete = delete_cond.getText().toString();
                try {
                    FileOutputStream fileoutCondDel = openFileOutput("DeleteCond.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterCondDel = new OutputStreamWriter(fileoutCondDel);
                    outputWriterCondDel.write(CondDelete);
                    outputWriterCondDel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                CondDelete = CondDelete.replace("[", "\\[");
                CondDelete = CondDelete.replace("]", "\\]");

                // TODO Auto-generated method stub //
                com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; sed -i -e '/"+CondDelete+"/{N;N;N;N;d}' fastchem_database_cond.dat ");

                output_conf(exec("cat "+getFilesDir()+"/config.input"));
                output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
                output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
                dataView(exec("cat "+getFilesDir()+"/StatusFastchem.txt"));
                dataViewCond(exec("cat "+getFilesDir()+"/StatusFastchemCond.txt"));
                output("Entry deleted from the working database.");
//                output2(exec("cat "+getFilesDir()+"/chemistry.dat"));
                filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
                filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
                deleteGasView(exec("cat "+getFilesDir()+"/DeleteGas.txt"));
                deleteCondView(exec("cat "+getFilesDir()+"/DeleteCond.txt"));
            }
        };
    }

    private View.OnClickListener filter_gasClick; {

        filter_gasClick = new View.OnClickListener() {
            public void onClick(View v) {
                String configfile = config.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("config.input", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(configfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String atmofile = atmospheric_profile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(atmofile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String abundfile = abundance.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("abundances.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(abundfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String filtergasfile = filter_gas.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("filter-gas.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(filtergasfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String filtercondfile = filter_cond.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("filter-cond.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(filtercondfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }


                // TODO Auto-generated method stub //
                openfiltergasdialog();
            }
        };
    }

    private void openfiltergasdialog() {
        // TODO Auto-generated method stub //
        ProgressDialog progressDialog = new ProgressDialog(Fastchem.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Filtering the selected database...");
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

                File filterGasFile = new File(getFilesDir()+"/fastchem_database_fragment.dat");
                try {
                    if (!filterGasFile.exists()) {
                        filterGasFile.createNewFile();
                        FileOutputStream fileout = openFileOutput("fastchem_database_fragment.dat", MODE_PRIVATE);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write("#\n");
                        outputWriter.write("#\n");
                        outputWriter.write("#\n");
                        outputWriter.close();
                    }
                    try {
                        com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; echo '' >> filter-gas.txt ; cat filter-gas.txt | while read line ; do grep $line -A 2 fastchem_database.dat | sed /^--$/d >> fastchem_database_fragment.dat ; done");
//                        exec(getApplicationInfo().nativeLibraryDir+"/libfastchem.so "+getFilesDir()+"/config.input");
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
                output2(exec("cat "+getFilesDir()+"/fastchem_database_fragment.dat"));
                output("Staying idle.");
                filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
                filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
                onFinish();
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }

    private View.OnClickListener filter_condClick; {

        filter_condClick = new View.OnClickListener() {
            public void onClick(View v) {
                String configfile = config.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("config.input", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(configfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String atmofile = atmospheric_profile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(atmofile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String abundfile = abundance.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("abundances.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(abundfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String filtergasfile = filter_gas.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("filter-gas.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(filtergasfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String filtercondfile = filter_cond.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("filter-cond.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(filtercondfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }


                // TODO Auto-generated method stub //
                openfilterconddialog();
            }
        };
    }

    private void openfilterconddialog() {
        // TODO Auto-generated method stub //
        ProgressDialog progressDialog = new ProgressDialog(Fastchem.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Filtering the selected database...");
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

                File filterCondFile = new File(getFilesDir()+"/fastchem_database_cond_fragment.dat");
                try {
                    if (!filterCondFile.exists()) {
                        filterCondFile.createNewFile();
                        FileOutputStream fileout = openFileOutput("fastchem_database_cond_fragment.dat", MODE_PRIVATE);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write("#\n");
                        outputWriter.write("#\n");
                        outputWriter.write("#\n");
                        outputWriter.close();
                    }
                    try {
                        com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; echo '' >> filter-cond.txt ; cat filter-cond.txt | while read line ; do grep $line -A 4 fastchem_database_cond.dat | sed /^--$/d >> fastchem_database_cond_fragment.dat ; done");
//                        exec(getApplicationInfo().nativeLibraryDir+"/libfastchem.so "+getFilesDir()+"/config.input");
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
                output2(exec("cat "+getFilesDir()+"/fastchem_database_cond_fragment.dat"));
                output("Staying idle.");
                filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
                filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
                onFinish();
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }

    private View.OnClickListener runClick; {

        runClick = new View.OnClickListener() {
            public void onClick(View v) {
                String configfile = config.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("config.input", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(configfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String atmofile = atmospheric_profile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(atmofile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String abundfile = abundance.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("abundances.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(abundfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                // TODO Auto-generated method stub //
//                openprogressdialog();
                // substitution - much faster:
//                String FastChemCommand = "export HOME=/data/data/cz.p/files ; cd $HOME ; rm Output.txt chemistry.dat monitor.dat ; "+getApplicationInfo().nativeLibraryDir+"/libfastchem.so config.input > monitor.dat ; "+getApplicationInfo().nativeLibraryDir+"/libtranspose.so -t condensates.dat > condensates_trans.dat ; "+getApplicationInfo().nativeLibraryDir+"/libtranspose.so -t chemistry.dat > chemistry_trans.dat ; rm condensates.dat ; rm chemistry.dat ; mv chemistry_trans.dat chemistry.dat ; cat condensates_trans.dat >> chemistry.dat ; cat monitor.dat >> chemistry.dat ; rm condensates_trans.dat ; cat chemistry.dat";
                String FastChemCommand = exec("cat "+getFilesDir()+"/ProcessFastchem.txt");

                FastChemCommand = FastChemCommand.replace(" cpx ", " "+getApplicationInfo().nativeLibraryDir+"/libcpx.so ");
                FastChemCommand = FastChemCommand.replace(" dftd4 ", " "+getApplicationInfo().nativeLibraryDir+"/libdftd4.so ");
                FastChemCommand = FastChemCommand.replace(" multicharge ", " "+getApplicationInfo().nativeLibraryDir+"/libmulticharge.so ");
                FastChemCommand = FastChemCommand.replace(" numsa-exe ", " "+getApplicationInfo().nativeLibraryDir+"/libnumsa-exe.so ");
                FastChemCommand = FastChemCommand.replace(" s-dftd3 ", " "+getApplicationInfo().nativeLibraryDir+"/libs-dftd3.so ");
                FastChemCommand = FastChemCommand.replace(" tblite ", " "+getApplicationInfo().nativeLibraryDir+"/libtblite.so ");
                FastChemCommand = FastChemCommand.replace(" obabel ", " "+getApplicationInfo().nativeLibraryDir+"/libobabel.so ");
                FastChemCommand = FastChemCommand.replace(" dftb ", " "+getApplicationInfo().nativeLibraryDir+"/libdftb.so ");
                FastChemCommand = FastChemCommand.replace(" qcxms ", " "+getApplicationInfo().nativeLibraryDir+"/libqcxms.so ");
                FastChemCommand = FastChemCommand.replace(" modes ", " "+getApplicationInfo().nativeLibraryDir+"/libmodes.so ");
                FastChemCommand = FastChemCommand.replace(" xbbc ", " "+getApplicationInfo().nativeLibraryDir+"/libxbbc.so ");
                FastChemCommand = FastChemCommand.replace(" xbvm ", " "+getApplicationInfo().nativeLibraryDir+"/libxbvm.so ");
                FastChemCommand = FastChemCommand.replace(" plotms ", " "+getApplicationInfo().nativeLibraryDir+"/libplotms.so ");
                FastChemCommand = FastChemCommand.replace(" stda ", " "+getApplicationInfo().nativeLibraryDir+"/libstda.so ");
                FastChemCommand = FastChemCommand.replace(" xtb ", " "+getApplicationInfo().nativeLibraryDir+"/libxtb.so ");
                FastChemCommand = FastChemCommand.replace(" xtb4stda ", " "+getApplicationInfo().nativeLibraryDir+"/libxtb4stda.so ");
                FastChemCommand = FastChemCommand.replace(" waveplot ", " "+getApplicationInfo().nativeLibraryDir+"/libwaveplot.so ");
                FastChemCommand = FastChemCommand.replace(" chimescalc ", " "+getApplicationInfo().nativeLibraryDir+"/libchimescalc.so ");
                FastChemCommand = FastChemCommand.replace(" crest ", " "+getApplicationInfo().nativeLibraryDir+"/libcrest.so ");
//                FastChemCommand = FastChemCommand.replace(" flux ", " "+getApplicationInfo().nativeLibraryDir+"/libflux.so ");
//                FastChemCommand = FastChemCommand.replace(" makecube ", " "+getApplicationInfo().nativeLibraryDir+"/libmakecube.so ");
//                FastChemCommand = FastChemCommand.replace(" phonons ", " "+getApplicationInfo().nativeLibraryDir+"/libphonons.so ");
//                FastChemCommand = FastChemCommand.replace(" setupgeom ", " "+getApplicationInfo().nativeLibraryDir+"/libsetupgeom.so ");
                FastChemCommand = FastChemCommand.replace(" chemsol ", " "+getApplicationInfo().nativeLibraryDir+"/libchemsol.so ");
                FastChemCommand = FastChemCommand.replace(" fastchem ", " "+getApplicationInfo().nativeLibraryDir+"/libfastchem.so ");
                FastChemCommand = FastChemCommand.replace(" mopac ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac.so ");
                FastChemCommand = FastChemCommand.replace(" mopac-makpol ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac-makpol.so ");
                FastChemCommand = FastChemCommand.replace(" mopac-param ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac-param.so ");
                FastChemCommand = FastChemCommand.replace(" phreeqc ", " "+getApplicationInfo().nativeLibraryDir+"/libphreeqc.so ");
//                FastChemCommand = FastChemCommand.replace(" phreeqc-prepare ", " "+getApplicationInfo().nativeLibraryDir+"/libphreeqc-prepare.so ");
                FastChemCommand = FastChemCommand.replace(" transpose ", " "+getApplicationInfo().nativeLibraryDir+"/libtranspose.so ");

                new RunCommandTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, FastChemCommand);
            }
        };
    }

    // extremely slow: (?!)
//    private void openprogressdialog() {
//        // TODO Auto-generated method stub //
//        ProgressDialog progressDialog = new ProgressDialog(Fastchem.this);
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
//                try {
//                    exec("chmod 755 -R "+getFilesDir());
//                    exec("rm "+getFilesDir()+"/Output.txt");
//                    exec("rm "+getFilesDir()+"/chemistry.dat");
//                    exec("rm "+getFilesDir()+"/monitor.dat");
//
//                        com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; "+getApplicationInfo().nativeLibraryDir+"/libfastchem.so config.input > monitor.dat ; "+getApplicationInfo().nativeLibraryDir+"/libtranspose.so -t condensates.dat > condensates_trans.dat ; "+getApplicationInfo().nativeLibraryDir+"/libtranspose.so -t chemistry.dat > chemistry_trans.dat ; rm condensates.dat ; rm chemistry.dat ; mv chemistry_trans.dat chemistry.dat ; cat condensates_trans.dat >> chemistry.dat ; cat monitor.dat >> chemistry.dat ; rm condensates_trans.dat");
////                        exec(getApplicationInfo().nativeLibraryDir+"/libfastchem.so "+getFilesDir()+"/config.input");
//
//                    try {
//                    output2(exec("cat "+getFilesDir()+"/chemistry.dat"));
//                    output("Staying idle.");
//                    filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
//                    filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
//                    } catch (Exception e) {
//                    }
//                } catch (Exception e) {
//                }
//
//                onFinish();
//            }
//
//            // Executes UNIX command.
//            private String exec(String command) {
//                try {
//                    Process process = Runtime.getRuntime().exec(command);
//                    BufferedReader reader = new BufferedReader(
//                            new InputStreamReader(process.getInputStream()));
//                    int read;
//                    char[] buffer = new char[65536];
//                    StringBuffer output = new StringBuffer();
//                    while ((read = reader.read(buffer)) > 0) {
//                        output.append(buffer, 0, read);
//                    }
//                    reader.close();
//                    process.waitFor();
//                    return output.toString();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
//            public void output2(final String str2) {
//                Runnable proc2 = new Runnable() {
//                    public void run() {
//                        outputView2.setText(str2);
//                    }
//                };
//                handler.post(proc2);
//            }
//
//            public void onFinish() {
//                progressDialog.dismiss();
//            }
//        }.start();
//    }

    // Ignore the bad AsyncTask usage.
    final class RunCommandTask extends AsyncTask<String, Void, CommandResult> {

//        private ProgressDialog dialog;
        private ProgressDialog progressDialog = new ProgressDialog(Fastchem.this);

        @Override protected void onPreExecute() {
//            dialog = ProgressDialog.show(Fastchem.this, "Please wait...", "Calculation is running...");
//            dialog.setCancelable(false);
//            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog2, int which) {
//                    dialog2.dismiss();
//                }
//            });

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
        }

        @Override protected CommandResult doInBackground(String... commands) {
            return com.jrummyapps.android.shell.Shell.SH.run(commands);
        }

        @Override protected void onPostExecute(CommandResult result) {
            if (!isFinishing()) {
//                dialog.dissmiss();
                progressDialog.dismiss();
//                ExecuteOutput.setText(resultToHtml(result));
                String OutputofExecution = resultToHtml(result).toString();
                try {
                    FileOutputStream fileout = openFileOutput("LastExecutionOutput.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(OutputofExecution);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                outputView2.setText(OutputofExecution);

            }
        }

        private Spanned resultToHtml(CommandResult result) {
            StringBuilder html = new StringBuilder();
            // exit status
            html.append("<p><strong>Exit Code:</strong> ");
            if (result.isSuccessful()) {
                html.append("<font color='green'>").append(result.exitCode).append("</font>");
            } else {
                html.append("<font color='red'>").append(result.exitCode).append("</font>");
            }
            html.append("</p>");
            // stdout
            if (result.stdout.size() > 0) {
                html.append("<p><strong>STDOUT:</strong></p><p>")
                        .append(result.getStdout().replaceAll("\n", "<br>"))
                        .append("</p>");
            }
            // stderr
            if (result.stderr.size() > 0) {
                html.append("<p><strong>STDERR:</strong></p><p><font color='red'>")
                        .append(result.getStderr().replaceAll("\n", "<br>"))
                        .append("</font></p>");
            }
            return Html.fromHtml(html.toString());
        }

    }

    private View.OnClickListener saveatmofileClick; {

        saveatmofileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertSaveInput();
            }
        };
    }

    public void alertSaveInput(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Fastchem.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(Fastchem.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/output/atmospheric-profiles")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = atmospheric_profile.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/output/atmospheric-profiles");
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

    private View.OnClickListener saveatmofile2Click; {

        saveatmofile2Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String configfile = config.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("config.input", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(configfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String atmofile = atmospheric_profile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(atmofile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String abundfile = abundance.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("abundances.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(abundfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write1(getApplicationContext());
            }
        };
    }

    private View.OnClickListener saveabundfileClick; {

        saveabundfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertSaveInput2();
            }
        };
    }

    public void alertSaveInput2(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Fastchem.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(Fastchem.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/output/element-abundances")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = atmospheric_profile.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/output/element-abundances");
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

    private View.OnClickListener saveabundfile2Click; {

        saveabundfile2Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String configfile = config.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("config.input", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(configfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String atmofile = atmospheric_profile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(atmofile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String abundfile = abundance.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("abundances.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(abundfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write2(getApplicationContext());
            }
        };
    }

    private View.OnClickListener saveoutputfileClick; {

        saveoutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertSaveOutput();
            }
        };
    }

    public void alertSaveOutput(){
        // creating the EditText widget programatically
        EditText editText15 = new EditText(Fastchem.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(Fastchem.this)
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
                        exec("mv "+getFilesDir()+"/"+SaveOutputName+" "+getFilesDir()+"/work");
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

    private View.OnClickListener highlightClick; {

        highlightClick = new View.OnClickListener() {
            public void onClick(View v) {

                String configfile = config.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("config.input", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(configfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String atmofile = atmospheric_profile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(atmofile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String abundfile = abundance.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("abundances.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(abundfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // alternative - faster(?)
                // anyway - use LastExecutionOutput.txt instead of chemistry.dat - extremely slow (why?!)
//                String strX = exec("cat "+getFilesDir()+"/LastExecutionOutput.txt");

                // TODO Auto-generated method stub //
                openhighlightdialog();
            }
        };
    }


    private void openhighlightdialog() {
        // TODO Auto-generated method stub //
        ProgressDialog progressDialog = new ProgressDialog(Fastchem.this);
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
//                    String Results = outputView2.getText().toString();
//                    FileOutputStream fileout = openFileOutput("Output.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(Results);
//                    outputWriter.close();

                    outputX(exec("cat "+getFilesDir()+"/LastExecutionOutput.txt"));
                    output_conf(exec("cat "+getFilesDir()+"/config.input"));
                    output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
                    output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
                    output("Staying idle.");
                    filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
                    filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
                    deleteGasView(exec("cat "+getFilesDir()+"/DeleteGas.txt"));
                    deleteCondView(exec("cat "+getFilesDir()+"/DeleteCond.txt"));

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


    private View.OnClickListener saveoutputfile2Click; {

        saveoutputfile2Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String configfile = config.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("config.input", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(configfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String atmofile = atmospheric_profile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(atmofile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String abundfile = abundance.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("abundances.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(abundfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write3(getApplicationContext());
            }
        };
    }

    private void write1(Context context1) {
        Intent intent1 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        intent1.putExtra(Intent.EXTRA_TITLE,"MyAtmosphericProfileFile");
        startActivityForResult(intent1, CREATE_FILE1);
    }

    private void write2(Context context2) {
        Intent intent2 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent2.addCategory(Intent.CATEGORY_OPENABLE);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TITLE,"MyElementAbundancesFile");
        startActivityForResult(intent2, CREATE_FILE2);
    }

    private void write3(Context context3) {
        Intent intent3 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent3.addCategory(Intent.CATEGORY_OPENABLE);
        intent3.setType("text/plain");
        intent3.putExtra(Intent.EXTRA_TITLE,"MyOutput");
        startActivityForResult(intent3, CREATE_FILE3);
    }

    private void read1(Context context4) {
        Intent intent4 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent4.addCategory(Intent.CATEGORY_OPENABLE);
        intent4.setType("text/plain");
        startActivityForResult(intent4, READ_FILE1);
    }

    private void read2(Context context5) {
        Intent intent5 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent5.addCategory(Intent.CATEGORY_OPENABLE);
        intent5.setType("text/plain");
        startActivityForResult(intent5, READ_FILE2);
    }

    private void read3(Context context6) {
        Intent intent6 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent6.addCategory(Intent.CATEGORY_OPENABLE);
        intent6.setType("text/plain");
        startActivityForResult(intent6, READ_FILE3);
    }

    private void read30(Context context60) {
        Intent intent60 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent60.addCategory(Intent.CATEGORY_OPENABLE);
        intent60.setType("text/plain");
        startActivityForResult(intent60, READ_FILE30);
    }


    @Override
    protected void onResume() {
        super.onResume();
        output_conf(exec("cat "+getFilesDir()+"/config.input"));
        output_elem(exec("cat "+getFilesDir()+"/abundances.dat"));
        output_atmo(exec("cat "+getFilesDir()+"/atmospheric-profile.dat"));
        dataView(exec("cat "+getFilesDir()+"/StatusFastchem.txt"));
        dataViewCond(exec("cat "+getFilesDir()+"/StatusFastchemCond.txt"));
        output("Staying idle.");
        output2(exec("cat "+getFilesDir()+"/Output.txt"));
        filterGasView(exec("cat "+getFilesDir()+"/filter-gas.txt"));
        filterCondView(exec("cat "+getFilesDir()+"/filter-cond.txt"));
        deleteGasView(exec("cat "+getFilesDir()+"/DeleteGas.txt"));
        deleteCondView(exec("cat "+getFilesDir()+"/DeleteCond.txt"));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_FILE1 && data != null) {
            // save atmospheric profile file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri1 = data.getData();
                ParcelFileDescriptor pfd1 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd1.getFileDescriptor());
                String fileContents = atmospheric_profile.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd1.close();
                FileOutputStream fileout = openFileOutput("atmospheric-profile.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE2 && data != null) {
            // save element abundances file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri2 = data.getData();
                ParcelFileDescriptor pfd2 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd2.getFileDescriptor());
                String fileContents = abundance.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd2.close();
                FileOutputStream fileout = openFileOutput("abundances.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE3 && data != null) {
            // save output file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri3 = data.getData();
                ParcelFileDescriptor pfd3 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd3.getFileDescriptor());
                String fileContents = outputView2.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd3.close();
                FileOutputStream fileout = openFileOutput("MyOutput.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE1 && data != null) {
            // open atmospheric profile file
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
                atmospheric_profile.setText(myData);
                atmospheric_profile.setText("");
                FileOutputStream fileout = openFileOutput("atmospheric-profile.dat", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd4.close();
                Toast.makeText(getApplicationContext(), "File read successfully.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE2 && data != null) {
            // open element abundances file
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
                abundance.setText(myData);
                abundance.setText("");
                FileOutputStream fileout = openFileOutput("abundances.dat", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd5.close();
                Toast.makeText(getApplicationContext(), "File read successfully.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == READ_FILE3 && data != null) {
            // open database file
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
                FileOutputStream fileout = openFileOutput("fastchem_database.tmp", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd6.close();
                Toast.makeText(getApplicationContext(), "File read successfully.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
            String FastchemAppend = exec("cat "+getFilesDir()+"/fastchem_database.tmp");
            try {
                // header
                FileOutputStream fileout00 = openFileOutput("header.tmp", MODE_PRIVATE);
                OutputStreamWriter outputWriter00 = new OutputStreamWriter(fileout00);
                outputWriter00.write("#\n");
                outputWriter00.write("#\n");
                outputWriter00.write("#\n");
                outputWriter00.close();
                // append individual datasheets
                FileOutputStream fileout = openFileOutput("fastchem_database_content.dat", MODE_APPEND);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(FastchemAppend);
                outputWriter.close();
                // stick header and appended datasheets together
                String header = exec("cat "+getFilesDir()+"/header.tmp");
                String database_content = exec("cat "+getFilesDir()+"/fastchem_database_content.dat");
                FileOutputStream fileout01 = openFileOutput("fastchem_database.dat", MODE_PRIVATE);
                OutputStreamWriter outputWriter01 = new OutputStreamWriter(fileout01);
                outputWriter01.write(header);
                outputWriter01.write(database_content);
                outputWriter01.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            exec("rm "+getFilesDir()+"/fastchem_database.tmp");

            File Database_check = new File(getFilesDir()+"/fastchem_database.dat");

            if (!Database_check.exists()) {
                try {
                    FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                    outputWriterSMS_kin.write("database for gaseous species not present");
                    outputWriterSMS_kin.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchem.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                    outputWriterSMS_kin.write("database for gaseous species present");
                    outputWriterSMS_kin.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            dataView(exec("cat "+getFilesDir()+"/StatusFastchem.txt"));
        }

        if (requestCode == READ_FILE30 && data != null) {
            // open database file
            try {
                documentUri60 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd60 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd60.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();
                FileOutputStream fileout = openFileOutput("fastchem_database_cond.tmp", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd60.close();
                Toast.makeText(getApplicationContext(), "File read successfully.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
            String FastchemAppend = exec("cat "+getFilesDir()+"/fastchem_database_cond.tmp");
            try {
                // header
                FileOutputStream fileout00 = openFileOutput("header_cond.tmp", MODE_PRIVATE);
                OutputStreamWriter outputWriter00 = new OutputStreamWriter(fileout00);
                outputWriter00.write("#\n");
                outputWriter00.write("#\n");
                outputWriter00.write("#\n");
                outputWriter00.close();
                // append individual datasheets
                FileOutputStream fileout = openFileOutput("fastchem_database_content_cond.dat", MODE_APPEND);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(FastchemAppend);
                outputWriter.close();
                // stick header and appended datasheets together
                String header = exec("cat "+getFilesDir()+"/header.tmp_cond");
                String database_content = exec("cat "+getFilesDir()+"/fastchem_database_content_cond.dat");
                FileOutputStream fileout01 = openFileOutput("fastchem_database_cond.dat", MODE_PRIVATE);
                OutputStreamWriter outputWriter01 = new OutputStreamWriter(fileout01);
                outputWriter01.write(header);
                outputWriter01.write(database_content);
                outputWriter01.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            exec("rm "+getFilesDir()+"/fastchem_database_cond.tmp");

            File Database_checkCond = new File(getFilesDir()+"/fastchem_database_cond.dat");

            if (!Database_checkCond.exists()) {
                try {
                    FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                    outputWriterSMS_kin.write("database for condensed species not present");
                    outputWriterSMS_kin.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    FileOutputStream fileoutSMS_kin = openFileOutput("StatusFastchemCond.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterSMS_kin = new OutputStreamWriter(fileoutSMS_kin);
                    outputWriterSMS_kin.write("database for condensed species present");
                    outputWriterSMS_kin.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            dataViewCond(exec("cat "+getFilesDir()+"/StatusFastchemCond.txt"));
        }

    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output_conf(final String str_conf) {
        Runnable proc_conf = new Runnable() {
            public void run() {
                config.setText(colorized_fastchem(str_conf), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_conf);
    }
    public void output_atmo(final String str_atmo) {
        Runnable proc_atmo = new Runnable() {
            public void run() {
                atmospheric_profile.setText(colorized_fastchem(str_atmo), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_atmo);
    }
    public void output_elem(final String str_elem) {
        Runnable proc_elem = new Runnable() {
            public void run() {
                abundance.setText(colorized_fastchem(str_elem), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_elem);
    }
    public void output(final String str) {
        Runnable proc = new Runnable() {
            public void run() {
                outputView.setText(str);
            }
        };
        handler.post(proc);
    }
    public void output2(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                outputView2.setText(str2);
            }
        };
        handler.post(proc2);
    }
    public void dataView(final String strData) {
        Runnable procData = new Runnable() {
            public void run() {
                Data.setText(strData);
            }
        };
        handler.post(procData);
    }
    public void dataViewCond(final String strDataCond) {
        Runnable procDataCond = new Runnable() {
            public void run() {
                DataCond.setText(strDataCond);
            }
        };
        handler.post(procDataCond);
    }
    public void filterGasView(final String strFilterGas) {
        Runnable procFilterGas = new Runnable() {
            public void run() {
                filter_gas.setText(colorized_fastchem(strFilterGas), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procFilterGas);
    }
    public void filterCondView(final String strFilterCond) {
        Runnable procFilterCond = new Runnable() {
            public void run() {
                filter_cond.setText(colorized_fastchem(strFilterCond), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procFilterCond);
    }
    public void deleteGasView(final String strDeleteGas) {
        Runnable procDeleteGas = new Runnable() {
            public void run() {
                delete_gas.setText(colorized_fastchem(strDeleteGas), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procDeleteGas);
    }
    public void deleteCondView(final String strDeleteCond) {
        Runnable procDeleteCond = new Runnable() {
            public void run() {
                delete_cond.setText(colorized_fastchem(strDeleteCond), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procDeleteCond);
    }
    // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
    public void outputX(final String strX) {
        Runnable procX = new Runnable() {
            public void run() {
                outputView2.setText(colorized_fastchem(strX), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procX);
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
