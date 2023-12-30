package cz.p;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class KineticsQuery extends MainActivity {



    private Button Quit;
    private Button ReactantMOPAC;
    private Button ProductMOPAC;
    private Button ReactantData;
    private Button ProductData;
    private Button CalcTS;
    private TextView LabelMOPAC;
    private TextView LabelData;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kineticsquery);

        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        ReactantMOPAC = (Button) findViewById(R.id.ReactantMOPAC);
        ReactantMOPAC.setOnClickListener(ReactantMOPACClick);
        ProductMOPAC = (Button) findViewById(R.id.ProductMOPAC);
        ProductMOPAC.setOnClickListener(ProductMOPACClick);
        ReactantData = (Button) findViewById(R.id.ReactantData);
        ReactantData.setOnClickListener(ReactantDataClick);
        ProductData = (Button) findViewById(R.id.ProductData);
        ProductData.setOnClickListener(ProductDataClick);
        CalcTS = (Button) findViewById(R.id.Finalize);
        CalcTS.setOnClickListener(CalcTSClick);

        LabelMOPAC = (TextView) findViewById(R.id.LabelMOPAC);
        LabelData = (TextView) findViewById(R.id.LabelData);

    }

    private View.OnClickListener ReactantMOPACClick; {
        ReactantMOPACClick = new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream fileout = openFileOutput("GeneralStatus.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("Reactant");
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // TODO Auto-generated method stub //
                Intent intent = new Intent(KineticsQuery.this, GeneralMOPAC.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener ProductMOPACClick; {
        ProductMOPACClick = new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream fileout = openFileOutput("GeneralStatus.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("Product");
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // TODO Auto-generated method stub //
                Intent intent = new Intent(KineticsQuery.this, GeneralMOPAC.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener ReactantDataClick; {
        ReactantDataClick = new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream fileout = openFileOutput("GeneralStatus.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("Reactant");
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // TODO Auto-generated method stub //
                Intent intent = new Intent(KineticsQuery.this, GeneralData.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener ProductDataClick; {
        ProductDataClick = new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream fileout = openFileOutput("GeneralStatus.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("Product");
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // TODO Auto-generated method stub //
                Intent intent = new Intent(KineticsQuery.this, GeneralData.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener CalcTSClick; {
        CalcTSClick = new View.OnClickListener() {
            public void onClick(View v) {try {
                FileOutputStream fileout = openFileOutput("GeneralStatus.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write("");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
                // TODO Auto-generated method stub //
                Intent intent = new Intent(KineticsQuery.this, GeneralTS.class);
                startActivity(intent);
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
                Intent intent = new Intent(KineticsQuery.this, MainActivity.class);
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

}
