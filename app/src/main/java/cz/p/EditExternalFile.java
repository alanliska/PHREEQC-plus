package cz.p;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Path;
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

public class EditExternalFile extends MainActivity {

    private Handler handler = new Handler();



    private TextView fileLabel;
    private EditText fileInput;
    private TextView filepathLabel;
    private EditText filepath;
    Button openfile;
    Button savefile;
    private static final int READ_FILE101 = 101;
    private Uri documentUri101;



    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.editexternalfile);

        fileLabel = (TextView) findViewById(R.id.fileLabel);
        fileInput = (EditText) findViewById(R.id.fileInput);
        filepathLabel = (TextView) findViewById(R.id.filepathLabel);
        filepath = (EditText) findViewById(R.id.filepath);
        openfile = (Button) findViewById(R.id.openfile);
        openfile.setOnClickListener(openfileClick);
        savefile = (Button) findViewById(R.id.savefile);
        savefile.setOnClickListener(savefileClick);

    }


    public void onStart()
    {
        super.onStart();

        outputInput(exec("cat "+getFilesDir()+"/EditInput.txt"));
        outputPath(exec("cat "+getFilesDir()+"/ExternalOutput.txt"));
    }


    private View.OnClickListener openfileClick; {

        openfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read101(getApplicationContext());
                outputInput(exec("cat "+getFilesDir()+"/EditInput.txt"));
                outputPath(exec("cat "+getFilesDir()+"/ExternalOutput.txt"));
            }
        };
    }

    private void read101(Context context101) {
        Intent intent101 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent101.addCategory(Intent.CATEGORY_OPENABLE);
        intent101.setType("text/plain");
        startActivityForResult(intent101, READ_FILE101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE101 && data != null) {
            try {
                documentUri101 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd101 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd101.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("EditInput.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd101.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

    }


    private View.OnClickListener savefileClick; {

        savefileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = fileInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("EditInput.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String PathFile = filepath.getText().toString();
                try {
                    FileOutputStream fileoutI = openFileOutput("ExternalOutput.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterI = new OutputStreamWriter(fileoutI);
                    outputWriterI.write(PathFile);
                    outputWriterI.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                alertSaveInput();
                outputInput(exec("cat "+getFilesDir()+"/EditInput.txt"));
                outputPath(exec("cat "+getFilesDir()+"/ExternalOutput.txt"));
            }
        };
    }


    public void alertSaveInput(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(EditExternalFile.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(EditExternalFile.this)
                .setMessage("The file will be saved in the folder /storage/emulated/0/Documents/phreeqc_plus/"+exec("cat "+getFilesDir()+"/ExternalOutput.txt"))
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = fileInput.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+exec("cat "+getFilesDir()+"/ExternalOutput.txt"));

                        Intent intent = new Intent(EditExternalFile.this, MainActivity.class);
                        startActivity(intent);
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





    @Override
    protected void onResume() {
        super.onResume();
        outputInput(exec("cat "+getFilesDir()+"/EditInput.txt"));
        outputPath(exec("cat "+getFilesDir()+"/ExternalOutput.txt"));
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void outputInput(final String strInput) {
        Runnable procInput = new Runnable() {
            public void run() {
                fileInput.setText(strInput);
            }
        };
        handler.post(procInput);
    }

    public void outputPath(final String strOutput) {
        Runnable procOutput = new Runnable() {
            public void run() {
                filepath.setText(strOutput);
            }
        };
        handler.post(procOutput);
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
