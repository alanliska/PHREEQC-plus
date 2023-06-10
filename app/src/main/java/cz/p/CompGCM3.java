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


public class CompGCM3 extends DevMode {



    private Button Quit;
    private Button CompileButton;
    private TextView ContentLabel;
    private EditText Content;
    private TextView ContentLabel2;
    private EditText Content2;
    private TextView ContentLabel3;
    private EditText Content3;
    private TextView ContentLabel4;
    private EditText Content4;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compgcm3);

        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        CompileButton = (Button) findViewById(R.id.CompileButton);
        CompileButton.setOnClickListener(CompileClick);
        ContentLabel = (TextView) findViewById(R.id.ContentLabel);
        Content = (EditText) findViewById(R.id.Content);
        ContentLabel2 = (TextView) findViewById(R.id.ContentLabel2);
        Content2 = (EditText) findViewById(R.id.Content2);
        ContentLabel3 = (TextView) findViewById(R.id.ContentLabel3);
        Content3 = (EditText) findViewById(R.id.Content3);
        ContentLabel4 = (TextView) findViewById(R.id.ContentLabel4);
        Content4 = (EditText) findViewById(R.id.Content4);
    }






    public void onStart()
    {
        super.onStart();
        ContentDisplay(exec("cat "+getFilesDir()+"/GCM3/Comp_GCM3_g.par"));
        ContentDisplay2(exec("cat "+getFilesDir()+"/GCM3/Comp_GCM3_l.par"));
        ContentDisplay3(exec("cat "+getFilesDir()+"/GCM3/Comp_GCM3_c.par"));
        ContentDisplay4(exec("cat "+getFilesDir()+"/GCM3.par"));
    }

    private View.OnClickListener CompileClick; {
        CompileClick = new View.OnClickListener() {
            public void onClick(View v) {
                String BasFile30 = Content.getText().toString();
                String BasFile31 = Content2.getText().toString();
                String BasFile32 = Content3.getText().toString();
                String BasFile33 = Content4.getText().toString();
                // TODO Auto-generated method stub //
                try {
                    FileOutputStream fileout30 = openFileOutput("Comp_GCM3_g.par", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout30);
                    outputWriter.write(BasFile30);
                    outputWriter.close();
                    FileOutputStream fileout31 = openFileOutput("Comp_GCM3_l.par", MODE_PRIVATE);
                    OutputStreamWriter outputWriter1 = new OutputStreamWriter(fileout31);
                    outputWriter1.write(BasFile31);
                    outputWriter1.close();
                    FileOutputStream fileout32 = openFileOutput("Comp_GCM3_c.par", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout32);
                    outputWriter2.write(BasFile32);
                    outputWriter2.close();
                    FileOutputStream fileout33 = openFileOutput("GCM3.par", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout33);
                    outputWriter3.write(BasFile33);
                    outputWriter3.close();
                } catch (Exception e) {
                }
                exec("mv "+getFilesDir()+"/Comp_GCM3_g.par "+getFilesDir()+"/GCM3");
                exec("mv "+getFilesDir()+"/Comp_GCM3_l.par "+getFilesDir()+"/GCM3");
                exec("mv "+getFilesDir()+"/Comp_GCM3_c.par "+getFilesDir()+"/GCM3");
            }
        };
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(CompGCM3.this, DevMode.class);
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


    private void ContentDisplay(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                Content.setText(str2);
            }
        };
        handler.post(proc2);
    }
    private void ContentDisplay2(final String str22) {
        Runnable proc22 = new Runnable() {
            public void run() {
                Content2.setText(str22);
            }
        };
        handler.post(proc22);
    }
    private void ContentDisplay3(final String str23) {
        Runnable proc23 = new Runnable() {
            public void run() {
                Content3.setText(str23);
            }
        };
        handler.post(proc23);
    }
    private void ContentDisplay4(final String str24) {
        Runnable proc24 = new Runnable() {
            public void run() {
                Content4.setText(str24);
            }
        };
        handler.post(proc24);
    }
}
