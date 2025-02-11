package cz.p;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class ChangeSize extends DevMode {

    private Button Quit;
    private TextView Label;
    private TextView ChangeInputSize;
    private TextView ChangeOutputSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.changesize);

        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        Label = (TextView) findViewById(R.id.Label);
        ChangeInputSize = (TextView) findViewById(R.id.ChangeInputSize);
        ChangeOutputSize = (TextView) findViewById(R.id.ChangeOutputSize);
        Spinner InputSpinner = (Spinner) findViewById(R.id.InputSpinner);
        Spinner OutputSpinner = (Spinner) findViewById(R.id.OutputSpinner);

        // the block with definition of the first array member ("last used") contains getFilesDir(), therefore it has to be instantiated first (present in onCreate, not before)
        String DefaultInputTextSize = exec("cat "+getFilesDir()+"/InputTextSize.txt");
        String DefaultOutputTextSize = exec("cat "+getFilesDir()+"/OutputTextSize.txt");

        String[] InputSpinnerValues = {DefaultInputTextSize,"8","9","10","11","12","13","14","15","16","17","18","19","20","21","22"};
        String[] OutputSpinnerValues = {DefaultOutputTextSize,"8","9","10","11","12","13","14","15","16","17","18","19","20","21","22"};

        ArrayAdapter<String> InputAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, InputSpinnerValues);
        InputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        InputSpinner.setAdapter(InputAdapter);
        InputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                try {
                    FileOutputStream fileout50 = openFileOutput("InputTextSize.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout50);
                    outputWriter.write(item);
                    outputWriter.close();
                } catch (Exception e) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<String> OutputAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, OutputSpinnerValues);
        OutputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        OutputSpinner.setAdapter(OutputAdapter);
        OutputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                try {
                    FileOutputStream fileout50 = openFileOutput("OutputTextSize.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout50);
                    outputWriter.write(item);
                    outputWriter.close();
                } catch (Exception e) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    public void onStart()
    {
        super.onStart();
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(ChangeSize.this, DevMode.class);
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

