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

public class GeneralData extends KineticsQuery {

    private Button selectdatabase;
    private TextView datalabel;
    private TextView data;
    private TextView modifylabel;
    private EditText modifyedit;
    private Button modifybutton;
    private TextView previewlabel;
    private EditText preview;
    private Button reset;
    private Button process;
    private Button quit;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generaldata);

        selectdatabase = (Button) findViewById(R.id.selectdatabase);
        selectdatabase.setOnClickListener(selectdatabaseClick);
        datalabel = (TextView) findViewById(R.id.datalabel);
        data = (TextView) findViewById(R.id.data);
        modifylabel = (TextView) findViewById(R.id.modifylabel);
        modifyedit = (EditText) findViewById(R.id.modifyedit);
        modifyedit.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        modifybutton = (Button) findViewById(R.id.modifybutton);
        modifybutton.setOnClickListener(modifybuttonClick);
        previewlabel = (TextView) findViewById(R.id.previewlabel);
        preview = (EditText) findViewById(R.id.preview);
        preview.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(resetClick);
        process = (Button) findViewById(R.id.process);
        process.setOnClickListener(processClick);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(QuitClick);

    }

    public void onStart()
    {
        super.onStart();
        dataView(exec("cat "+getFilesDir()+"/Database-kinetics.txt"));
        modifyView(exec("cat "+getFilesDir()+"/KeywordsG.phr"));
    }

    private View.OnClickListener modifybuttonClick; {

        modifybuttonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Keywordfile = modifyedit.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("KeywordsG.phr", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Keywordfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("cp "+getFilesDir()+"/KeywordsG.phr "+getFilesDir()+"/Solution_species.dat");
                exec("cp "+getFilesDir()+"/Database-kinetics.dat "+getFilesDir()+"/Selected.dat");
                // TODO Auto-generated method stub //
                openprogressdialogG();

            }
        };
    }

    private void openprogressdialogG() {
        // TODO Auto-generated method stub //
        progressDialog = new ProgressDialog(GeneralData.this);
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
                    exec("mv "+getFilesDir()+"/DatabaseFragment.dat "+getFilesDir()+"/thermo_s_General.txt");

                    try {

                        output2highlighted(exec("cat "+getFilesDir()+"/thermo_s_General.txt"));
                        dataView(exec("cat "+getFilesDir()+"/Database-kinetics.txt"));
                        modifyView(exec("cat "+getFilesDir()+"/KeywordsG.phr"));
//                        Toast.makeText(getApplicationContext(), "External include file /data/data/cz.p/files/Solution.dat generated successfully.", Toast.LENGTH_SHORT).show();
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
                        preview.setText(colorized(str2, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                    }
                };
                handler.post(proc2);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }

    private View.OnClickListener selectdatabaseClick; {

        selectdatabaseClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(GeneralData.this, SelectDatabaseKin.class);
                startActivity(intent);
            }
        };
    }


    private View.OnClickListener processClick; {

        processClick = new View.OnClickListener() {
            public void onClick(View v) {
//               try {
//                   Toast.makeText(getApplicationContext(), "BEFORE", Toast.LENGTH_SHORT).show();

                   /////////////////////////////////// Process results ///////////////////////////////////////////////
                exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GeneralMOPAC.b "+getFilesDir()+"/GeneralMOPAC.bas");
                exec("chmod -R 755 "+getFilesDir()+"/GeneralMOPAC.b");
                exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GeneralMOPAC.b");
                    /////////////////////////////////// Display fields ///////////////////////////////////////////////
//                   Toast.makeText(getApplicationContext(), "AFTER", Toast.LENGTH_SHORT).show();

//                   dataView(exec("cat "+getFilesDir()+"/Database-kinetics.txt"));
//                   modifyView(exec("cat "+getFilesDir()+"/KeywordsG.phr"));


//                } catch (Exception e) {
//                }


                Intent intent = new Intent(GeneralData.this, KineticsQuery.class);
                startActivity(intent);
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
        };
    }

    private View.OnClickListener resetClick; {
        resetClick = new View.OnClickListener() {
            public void onClick(View v) {
                exec("rm "+getFilesDir()+"/thermo_s_General.txt");
                output2highlighted("");
                dataView(exec("cat "+getFilesDir()+"/Database-kinetics.txt"));
                modifyView(exec("cat "+getFilesDir()+"/KeywordsG.phr"));
            }
            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2highlighted(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        preview.setText(colorized(str2, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                    }
                };
                handler.post(proc2);
            }
        };
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                exec("rm "+getFilesDir()+"/thermo_s_TS.txt");
                exec("rm "+getFilesDir()+"/thermo_s_General.txt");
                exec("rm "+getFilesDir()+"/thermo_s_KINETICS_f.txt");
                exec("rm "+getFilesDir()+"/thermo_s_KINETICS_b.txt");
                exec("rm "+getFilesDir()+"/thermo_s_RATES_f.txt");
                exec("rm "+getFilesDir()+"/thermo_s_RATES_b.txt");
                exec("rm "+getFilesDir()+"/thermo_s_SMS.txt");
                exec("rm "+getFilesDir()+"/thermo_s_SS.txt");
                exec("rm "+getFilesDir()+"/GeneralResults_R.txt");
                exec("rm "+getFilesDir()+"/GeneralResults_P.txt");
                // TODO Auto-generated method stub //
                Intent intent = new Intent(GeneralData.this, MainActivity.class);
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


    public void modifyView(final String modifyData) {
        Runnable procData = new Runnable() {
            public void run() {
                modifyedit.setText(modifyData);
            }
        };
        handler.post(procData);
    }
    public void dataView(final String strData) {
        Runnable procData = new Runnable() {
            public void run() {
                data.setText(strData);
            }
        };
        handler.post(procData);
    }

}
