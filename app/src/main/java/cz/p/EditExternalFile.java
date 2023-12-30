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
    Button quit;
    private static final int READ_FILE101 = 101;
    private static final int CREATE_FILE102 = 102;
    private Uri documentUri101;
    private Uri documentUri102;



    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.editexternalfile);

        fileLabel = (TextView) findViewById(R.id.fileLabel);
        fileInput = (EditText) findViewById(R.id.fileInput);
        fileInput.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        openfile = (Button) findViewById(R.id.openfile);
        openfile.setOnClickListener(openfileClick);
        savefile = (Button) findViewById(R.id.savefile);
        savefile.setOnClickListener(savefileClick);
        quit = (Button) findViewById(R.id.quit);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exec("rm -rf "+getFilesDir()+"/EditInput.txt");
                Intent intent = new Intent(EditExternalFile.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


    public void onStart()
    {
        super.onStart();

        outputInput(exec("cat "+getFilesDir()+"/EditInput.txt"));
    }


    private View.OnClickListener openfileClick; {

        openfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read101(getApplicationContext());
                outputInput(exec("cat "+getFilesDir()+"/EditInput.txt"));
            }
        };
    }

    private View.OnClickListener savefileClick; {

        savefileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String FileContent = fileInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("EditInput.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(FileContent);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                write102(getApplicationContext());

                outputInput(exec("cat "+getFilesDir()+"/EditInput.txt"));
//                Intent intent = new Intent(EditExternalFile.this, MainActivity.class);
//                startActivity(intent);
            }
        };
    }

    private void read101(Context context101) {
        Intent intent101 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent101.addCategory(Intent.CATEGORY_OPENABLE);
        intent101.setType("text/plain");
        startActivityForResult(intent101, READ_FILE101);
    }

    private void write102(Context context102) {
        Intent intent102 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent102.addCategory(Intent.CATEGORY_OPENABLE);
        intent102.setType("text/plain");
        intent102.putExtra(Intent.EXTRA_TITLE,"MyFile.txt");
        startActivityForResult(intent102, CREATE_FILE102);
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

        if (requestCode == CREATE_FILE102 && data != null) {
            // save the file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                String fileContents = fileInput.getText().toString();
                documentUri102 = data.getData();
                ParcelFileDescriptor pfd102 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd102.getFileDescriptor());
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd102.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

    }







    @Override
    protected void onResume() {
        super.onResume();
        outputInput(exec("cat "+getFilesDir()+"/EditInput.txt"));
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
