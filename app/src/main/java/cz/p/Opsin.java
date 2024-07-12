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
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//import uk.ac.cam.ch.wwmm.opsin.NameToInchi;
import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

public class Opsin extends MainActivity {

    private Handler handler = new Handler();


    private TextView Description;
    private TextView OpsinLabel;
    private EditText OpsinInput;
    Button RunOpsin;
    Button Quit;
    private TextView textViewX;
    private TextView outputView;
    private EditText outputView2;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.opsin);

        OpsinLabel = (TextView) findViewById(R.id.OpsinLabel);
        OpsinInput = (EditText) findViewById(R.id.OpsinInput);
        OpsinInput.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        OpsinInput.addTextChangedListener(new TextWatcher() {
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
                OpsinInput.removeTextChangedListener(this);
                String text = OpsinInput.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                OpsinInput.getText().clear();
                OpsinInput.append(colorized_numbers(text));
                // place the cursor at the original position
                OpsinInput.setSelection(startChanged+countChanged);
                OpsinInput.addTextChangedListener(this);
            }
        });
        RunOpsin = (Button) findViewById(R.id.RunOpsin);
        RunOpsin.setOnClickListener(RunOpsinClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        textViewX = (TextView) findViewById(R.id.textViewX);
        outputView = (TextView) findViewById(R.id.outputView);
        outputView2 = (EditText) findViewById(R.id.outputView2);
        outputView2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/OutputTextSize.txt")).intValue());
        // disable - otherwise the text could not be selected
//        outputView2.setMovementMethod(new ScrollingMovementMethod());
        outputView2.addTextChangedListener(new TextWatcher() {
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
                outputView2.removeTextChangedListener(this);
                String text = outputView2.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                outputView2.getText().clear();
                outputView2.append(colorized_numbers(text));
                // place the cursor at the original position
                outputView2.setSelection(startChanged+countChanged);
                outputView2.addTextChangedListener(this);
            }
        });

    }


    public void onStart()
    {
        super.onStart();
        output3(exec("cat "+getFilesDir()+"/Input-opsin.txt"));
    }


    private View.OnClickListener RunOpsinClick; {

        RunOpsinClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = OpsinInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-opsin.txt", MODE_PRIVATE);
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
        progressDialog = new ProgressDialog(Opsin.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Conversion is running...");
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
                    exec("touch "+getFilesDir()+"/Output-opsin.txt");
                    exec("chmod 755 -R "+getFilesDir());
                    String NameToConvert = OpsinInput.getText().toString();
                    ////////////////////////////////////
                    NameToStructure nts = NameToStructure.getInstance();
                    NameToStructureConfig ntsconfig = new NameToStructureConfig();
//a new NameToStructureConfig starts as a copy of OPSIN's default configuration
                    ntsconfig.setAllowRadicals(true);
//                OpsinResult result = nts.parseChemicalName("acetamide", ntsconfig);
                    OpsinResult result = nts.parseChemicalName(NameToConvert+"", ntsconfig);
                    String cml = result.getCml();
                    String smiles = result.getSmiles();
                    // remove non-working inchi support
//                    String stdinchi = NameToInchi.convertResultToStdInChI(result);
                    /////////////////////////////////////
                    FileOutputStream fileout3 = openFileOutput("Output-opsin.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write("Chemical name:\n");
                    outputWriter3.write(NameToConvert+"\n");
                    outputWriter3.write("CML:\n");
                    outputWriter3.write(cml+"\n");
                    outputWriter3.write("SMILES:\n");
                    outputWriter3.write(smiles+"\n");
//                    outputWriter3.write("STDINCHI:\n");
//                    outputWriter3.write(stdinchi+"\n");
                    outputWriter3.close();
                    outputX(exec("cat "+getFilesDir()+"/Output-opsin.txt"));

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
                outputView2.setText(colorized_numbers(strX), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procX);
    }


    private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Opsin.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


    @Override
    protected void onResume() {
        super.onResume();
        output3(exec("cat "+getFilesDir()+"/Input-opsin.txt"));
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                OpsinInput.setText(colorized_numbers(str3), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc3);
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
