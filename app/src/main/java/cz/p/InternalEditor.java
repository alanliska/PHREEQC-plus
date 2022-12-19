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

public class InternalEditor extends EditInternalFile {

    private Handler handler = new Handler();



    private TextView fileLabel;
    private EditText fileInput;
    private TextView filepathLabel;
    private EditText filepath;
    Button savefile;



    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.editinternalfile);

        fileLabel = (TextView) findViewById(R.id.fileLabel);
        fileInput = (EditText) findViewById(R.id.fileInput);
        savefile = (Button) findViewById(R.id.savefile);
        savefile.setOnClickListener(savefileClick);

    }


    public void onStart()
    {
        super.onStart();
        String origFilePath = exec("cat "+getFilesDir()+"/EditedFileName.txt");
        outputInput(exec("cat "+origFilePath));
    }


    private View.OnClickListener savefileClick; {

        savefileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    String EditedFileContent = fileInput.getText().toString();
                    FileOutputStream fileout = openFileOutput("EditedFile.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(EditedFileContent);
                    outputWriter.close();


                    String origFilePath = exec("cat "+getFilesDir()+"/EditedFileName.txt");
                    exec("mv "+getFilesDir()+"/EditedFile.txt "+origFilePath);

                    outputInput(exec("cat "+origFilePath));

                    Toast.makeText(getApplicationContext(), "File saved.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }
                Intent intent = new Intent(InternalEditor.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }







    @Override
    protected void onResume() {
        super.onResume();
        String origFilePath = exec("cat "+getFilesDir()+"/EditedFileName.txt");
        outputInput(exec("cat "+origFilePath));
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
