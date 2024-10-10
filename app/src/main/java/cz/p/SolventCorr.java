package cz.p;

import static cz.p.Spannables.colorized_dftb;
import static cz.p.Spannables.colorized_mopac;
import static cz.p.Spannables.colorized_numbers;
import static cz.p.Spannables.colorized_phreeqc;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

public class SolventCorr extends MainActivity {

    private Handler handler = new Handler();
    private TextView Description;
    private TextView Description2;
    private TextView FormulaLabel;
    private EditText Formula;
    private TextView DensityLabel;
    private EditText Density;
    Button openSolv;
    Button openIntSolv;
    Button CalcCorr;
    Button Quit;
    private TextView textViewX;
    private TextView outputView;
    private EditText outputView2;
    private static final int READ_FILE6 = 1234296;
    private Uri documentUri6;
    private TextView Solvent_corr_label;
    private EditText Solvent_corr;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.solventcorr);

        Description = (TextView) findViewById(R.id.Description);
        Description2 = (TextView) findViewById(R.id.Description2);
        FormulaLabel = (TextView) findViewById(R.id.FormulaLabel);
        Formula = (EditText) findViewById(R.id.Formula);
        Formula.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Formula.addTextChangedListener(new TextWatcher() {
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
                Formula.removeTextChangedListener(this);
                String text = Formula.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Formula.getText().clear();
                Formula.append(colorized_numbers(text));
                // place the cursor at the original position
                Formula.setSelection(startChanged+countChanged);
                Formula.addTextChangedListener(this);
            }
        });
        DensityLabel = (TextView) findViewById(R.id.DensityLabel);
        Density = (EditText) findViewById(R.id.Density);
        Density.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Density.addTextChangedListener(new TextWatcher() {
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
                Density.removeTextChangedListener(this);
                String text = Density.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Density.getText().clear();
                Density.append(colorized_numbers(text));
                // place the cursor at the original position
                Density.setSelection(startChanged+countChanged);
                Density.addTextChangedListener(this);
            }
        });
        openSolv = (Button) findViewById(R.id.openSolv);
        openSolv.setOnClickListener(openSolvClick);
        openIntSolv = (Button) findViewById(R.id.openIntSolv);
        CalcCorr = (Button) findViewById(R.id.CalcCorr);
        CalcCorr.setOnClickListener(CalcCorrClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        textViewX = (TextView) findViewById(R.id.textViewX);
        outputView = (TextView) findViewById(R.id.outputView);
        outputView2 = (EditText) findViewById(R.id.outputView2);
        outputView2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/OutputTextSize.txt")).intValue());
        // disable - otherwise the text could not be selected
//        outputView2.setMovementMethod(new ScrollingMovementMethod());

        openIntSolv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DensityVal = Density.getText().toString();
                String FormulaVal = Formula.getText().toString();
                String SolventCorr = Solvent_corr.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("SolventCorr_density.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DensityVal);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("SolventCorr_formula.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(FormulaVal);
                    outputWriter2.close();
                    FileOutputStream fileout7 = openFileOutput("solvent_moles.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter7 = new OutputStreamWriter(fileout7);
                    outputWriter7.write(SolventCorr);
                    outputWriter7.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(SolventCorr.this, SolventCorrWork.class);
                startActivity(intent);
            }
        });

        Solvent_corr_label = (TextView) findViewById(R.id.Solvent_corr_label);
        Solvent_corr = (EditText) findViewById(R.id.Solvent_corr);
        Solvent_corr.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Solvent_corr.addTextChangedListener(new TextWatcher() {
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
                Solvent_corr.removeTextChangedListener(this);
                String text = Solvent_corr.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Solvent_corr.getText().clear();
                Solvent_corr.append(colorized_numbers(text));
                // place the cursor at the original position
                Solvent_corr.setSelection(startChanged+countChanged);
                Solvent_corr.addTextChangedListener(this);
            }
        });

    }

    public void onStart()
    {
        super.onStart();

        solvent_corr_view(exec("cat "+getFilesDir()+"/solvent_moles.txt"));
        output3(exec("cat "+getFilesDir()+"/SolventCorr_formula.txt"));
        output4(exec("cat "+getFilesDir()+"/SolventCorr_density.txt"));
        String ResultOfCorr = "molar mass (g.mol-1): "+exec("cat "+getFilesDir()+"/SolventCorr_mmass.txt")+"\n\nlog_k (formation of 1 mol solvent): "+exec("cat "+getFilesDir()+"/SolventCorr_logk.txt")+"\n\ndelta_h (formation of 1 mol solvent): "+exec("cat "+getFilesDir()+"/SolventCorr_deltah.txt")+"\n\nlog_k (concentration correction): "+exec("cat "+getFilesDir()+"/SolventCorr_logk2.txt");
        outputX(ResultOfCorr);
    }

    private View.OnClickListener openSolvClick; {

        openSolvClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String DensityVal = Density.getText().toString();
                String FormulaVal = Formula.getText().toString();
                String SolventCorr = Solvent_corr.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("SolventCorr_density.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DensityVal);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("SolventCorr_formula.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(FormulaVal);
                    outputWriter2.close();
                    FileOutputStream fileout7 = openFileOutput("solvent_moles.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter7 = new OutputStreamWriter(fileout7);
                    outputWriter7.write(SolventCorr);
                    outputWriter7.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read6(getApplicationContext());
                try {
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SolventCorr1.b "+getFilesDir()+"/SolventCorr1.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/SolventCorr1.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SolventCorr1.b");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                solvent_corr_view(exec("cat "+getFilesDir()+"/solvent_moles.txt"));
                output3(exec("cat "+getFilesDir()+"/SolventCorr_formula.txt"));
                output4(exec("cat "+getFilesDir()+"/SolventCorr_density.txt"));
                String ResultOfCorr = "molar mass (g.mol-1): "+exec("cat "+getFilesDir()+"/SolventCorr_mmass.txt")+"\n\nlog_k (formation of 1 mol solvent): "+exec("cat "+getFilesDir()+"/SolventCorr_logk.txt")+"\n\ndelta_h (formation of 1 mol solvent): "+exec("cat "+getFilesDir()+"/SolventCorr_deltah.txt")+"\n\nlog_k (concentration correction): "+exec("cat "+getFilesDir()+"/SolventCorr_logk2.txt");
                outputX(ResultOfCorr);
            }
        };
    }

    private void read6(Context context6) {
        Intent intent6 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent6.addCategory(Intent.CATEGORY_OPENABLE);
        intent6.setType("text/plain");
        startActivityForResult(intent6, READ_FILE6);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

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

                FileOutputStream fileout = openFileOutput("SolventFragment.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd6.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

    }
    private View.OnClickListener CalcCorrClick; {

        CalcCorrClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String DensityVal = Density.getText().toString();
                String FormulaVal = Formula.getText().toString();
                String SolventCorr = Solvent_corr.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("SolventCorr_density.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DensityVal);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("SolventCorr_formula.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(FormulaVal);
                    outputWriter2.close();
                    FileOutputStream fileout7 = openFileOutput("solvent_moles.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter7 = new OutputStreamWriter(fileout7);
                    outputWriter7.write(SolventCorr);
                    outputWriter7.close();
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
        progressDialog = new ProgressDialog(SolventCorr.this);
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
                try {
                    exec("chmod 755 -R "+getFilesDir());
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SolventCorr1.b "+getFilesDir()+"/SolventCorr1.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/SolventCorr1.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SolventCorr1.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SolventCorr2.b "+getFilesDir()+"/SolventCorr2.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/SolventCorr2.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SolventCorr2.b");
                    try {
                        String ResultOfCorr = "molar mass (g.mol-1): "+exec("cat "+getFilesDir()+"/SolventCorr_mmass.txt")+"\n\nlog_k (formation of 1 mol solvent): "+exec("cat "+getFilesDir()+"/SolventCorr_logk.txt")+"\n\ndelta_h (formation of 1 mol solvent): "+exec("cat "+getFilesDir()+"/SolventCorr_deltah.txt")+"\n\nlog_k (concentration correction): "+exec("cat "+getFilesDir()+"/SolventCorr_logk2.txt");
                        output3(exec("cat "+getFilesDir()+"/SolventCorr_formula.txt"));
                        output4(exec("cat "+getFilesDir()+"/SolventCorr_density.txt"));
                        outputX(ResultOfCorr);
                        solvent_corr_view(exec("cat "+getFilesDir()+"/solvent_moles.txt"));
                        Toast.makeText(getApplicationContext(), "Calculation finished", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
                onFinish();
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

        public void solvent_corr_view(final String solvent_corr_str) {
        Runnable solvent_corr_proc = new Runnable() {
            public void run() {
                Solvent_corr.setText(colorized_numbers(solvent_corr_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(solvent_corr_proc);
    }

   private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(SolventCorr.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        output3(exec("cat "+getFilesDir()+"/SolventCorr_formula.txt"));
        output4(exec("cat "+getFilesDir()+"/SolventCorr_density.txt"));
        String ResultOfCorr = "molar mass (g.mol-1): "+exec("cat "+getFilesDir()+"/SolventCorr_mmass.txt")+"\n\nlog_k (formation of 1 mol solvent): "+exec("cat "+getFilesDir()+"/SolventCorr_logk.txt")+"\n\ndelta_h (formation of 1 mol solvent): "+exec("cat "+getFilesDir()+"/SolventCorr_deltah.txt")+"\n\nlog_k (concentration correction): "+exec("cat "+getFilesDir()+"/SolventCorr_logk2.txt");
        outputX(ResultOfCorr);
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                Formula.setText(colorized_numbers(str3), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc3);
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output4(final String str4) {
        Runnable proc4 = new Runnable() {
            public void run() {
                Density.setText(colorized_numbers(str4), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc4);
    }

    public void outputX(final String strX) {
        Runnable procX = new Runnable() {
            public void run() {
                outputView2.setText(colorized_numbers(strX), EditText.BufferType.SPANNABLE);
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
