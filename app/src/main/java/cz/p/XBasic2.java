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


public class XBasic2 extends DevMode {



    private Button Quit;
    private Button CompileButton;
    private TextView ContentLabel;
    private EditText Content;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.xbasic2);

        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        CompileButton = (Button) findViewById(R.id.CompileButton);
        CompileButton.setOnClickListener(CompileClick);
        ContentLabel = (TextView) findViewById(R.id.ContentLabel);
        Content = (EditText) findViewById(R.id.Content);
        Content.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());

    }






    public void onStart()
    {
        super.onStart();
        ContentDisplay(exec("cat "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.bas"));
    }

    private View.OnClickListener CompileClick; {
        CompileClick = new View.OnClickListener() {
            public void onClick(View v) {
                String BasFile70 = Content.getText().toString();
                // TODO Auto-generated method stub //
                try {
                    FileOutputStream fileout70 = openFileOutput("DatabaseMakerPseudoPhases.bas", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout70);
                    outputWriter.write(BasFile70);
                    outputWriter.close();
                } catch (Exception e) {
                }
                exec("mv "+getFilesDir()+"/DatabaseMakerPseudoPhases.bas "+getFilesDir()+"/PHASES");
                try {
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b");
                } catch (Exception e) {
                }
            }
        };
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(XBasic2.this, DevMode.class);
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


    private void ContentDisplay(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                Content.setText(str2);
            }
        };
        handler.post(proc2);
    }

}
