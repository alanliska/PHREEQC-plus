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
    private Handler handler = new Handler();
    private TextView ChangeInputSize;
    private TextView ChangeOutputSize;
    private TextView ChangePointSize;
    private TextView ChangePointColour;

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
        ChangePointSize = (TextView) findViewById(R.id.ChangePointSize);
        ChangePointColour = (TextView) findViewById(R.id.ChangePointColour);
        Spinner InputSpinner = (Spinner) findViewById(R.id.InputSpinner);
        Spinner OutputSpinner = (Spinner) findViewById(R.id.OutputSpinner);
        Spinner PointSpinner = (Spinner) findViewById(R.id.PointSpinner);
        Spinner ColourSpinner = (Spinner) findViewById(R.id.ColourSpinner);

        // the block with definition of the first array member ("last used") contains getFilesDir(), therefore it has to be instantiated first (present in onCreate, not before)
        String DefaultInputTextSize = exec("cat "+getFilesDir()+"/InputTextSize.txt");
        String DefaultOutputTextSize = exec("cat "+getFilesDir()+"/OutputTextSize.txt");
        String DefaultPointSize = exec("cat "+getFilesDir()+"/PointSize.txt");
        // for later use:
        String DefaultColour0 = exec("cat "+getFilesDir()+"/Colour.txt");
        // this string is to be changed:
        String DefaultColour = DefaultColour0;

        // colour code transformation to human readable colour info
        String[] ColourSpinnerValues = {DefaultColour.replace("-7829368","GRAY").replace("-3355444","LTGRAY").replace("-16711681","CYAN").replace("-65281","MAGENTA").replace("-16776961","BLUE").replace("-16777216","BLACK").replace("-256","YELLOW").replace("-16711936","GREEN").replace("-12303292","DKGRAY").replace("-65536","RED"),"GRAY","LTGRAY","CYAN","MAGENTA","BLUE","BLACK","YELLOW","GREEN","DKGRAY","RED"};
        String[] InputSpinnerValues = {DefaultInputTextSize,"8","9","10","11","12","13","14","15","16","17","18","19","20","21","22"};
        String[] OutputSpinnerValues = {DefaultOutputTextSize,"8","9","10","11","12","13","14","15","16","17","18","19","20","21","22"};
        String[] PointSpinnerValues = {DefaultPointSize,"1","2","3","4","5","10","15","20","25","30","35","40","45","50","55","60","65","70","75","80","85","90","95","100","105","110","115","120"};

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


        ArrayAdapter<String> PointAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, PointSpinnerValues);
        PointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PointSpinner.setAdapter(PointAdapter);
        PointSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                try {
                    FileOutputStream fileout50 = openFileOutput("PointSize.txt", MODE_PRIVATE);
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

        ArrayAdapter<String> ColourAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ColourSpinnerValues);
        ColourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ColourSpinner.setAdapter(ColourAdapter);
        ColourSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();

                // back transformation to colour codes
                try {
                    FileOutputStream fileout50 = openFileOutput("Colour.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout50);
                    if(item == "GRAY"){
                        String item_transformed = "-7829368";
                        outputWriter.write(item_transformed);
                    } else if (item == "LTGRAY"){
                        String item_transformed = "-3355444";
                        outputWriter.write(item_transformed);
                    } else if (item == "CYAN"){
                        String item_transformed = "-16711681";
                        outputWriter.write(item_transformed);
                    } else if (item == "MAGENTA"){
                        String item_transformed = "-65281";
                        outputWriter.write(item_transformed);
                    } else if (item == "BLUE"){
                        String item_transformed = "-16776961";
                        outputWriter.write(item_transformed);
                    } else if (item == "BLACK"){
                        String item_transformed = "-16777216";
                        outputWriter.write(item_transformed);
                    } else if (item == "YELLOW"){
                        String item_transformed = "-256";
                        outputWriter.write(item_transformed);
                    } else if (item == "GREEN"){
                        String item_transformed = "-16711936";
                        outputWriter.write(item_transformed);
                    } else if (item == "DKGRAY"){
                        String item_transformed = "-12303292";
                        outputWriter.write(item_transformed);
                    } else if (item == "RED"){
                        String item_transformed = "-65536";
                        outputWriter.write(item_transformed);
                    } else {
                        // important: otherwise Colour.txt will remain empty upon opening the ChangeSize activity when no colour is selected - this condition puts inside at least the previously present information
                        String item_transformed = DefaultColour0;
                        outputWriter.write(item_transformed);
                    }
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

