package cz.p;

import static cz.p.Spannables.colorized_numbers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
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


public class Canvas3d_Reactant_ColorTest extends Canvas3d_Reactant {



    private Button quitButton;
    private Button colorButton;
    private TextView colorLabel;
    private EditText colorCode;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.canvas3d_colortest);

        quitButton = (Button) findViewById(R.id.quitButton);
        quitButton.setOnClickListener(quitButtonClick);
        colorButton = (Button) findViewById(R.id.colorButton);
        colorButton.setOnClickListener(colorButtonClick);
        colorLabel = (TextView) findViewById(R.id.colorLabel);
        colorCode = (EditText) findViewById(R.id.colorCode);
        colorCode.addTextChangedListener(new TextWatcher() {
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
                colorCode.removeTextChangedListener(this);
                String text = colorCode.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                colorCode.getText().clear();
                colorCode.append(colorized_numbers(text));
                // place the cursor at the original position
                colorCode.setSelection(startChanged+countChanged);
                colorCode.addTextChangedListener(this);
            }
        });
    }






    public void onStart()
    {
        super.onStart();
        colorDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorTest.tmp"));
    }

    private View.OnClickListener colorButtonClick; {
        colorButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                String ColorFile = colorCode.getText().toString();
                // TODO Auto-generated method stub //
                try {
                    FileOutputStream fileout = openFileOutput("ColorTest.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(ColorFile);
                    outputWriter.close();
                } catch (Exception e) {
                }
                colorButton.setBackgroundColor(Integer.valueOf(ColorFile));
                exec("mv "+getFilesDir()+"/ColorTest.tmp "+getFilesDir()+"/canvas3d/");
            }
        };
    }

    private View.OnClickListener quitButtonClick; {
        quitButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Canvas3d_Reactant_ColorTest.this, Canvas3d_Reactant.class);
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


    private void colorDisplay(final String str) {
        Runnable proc = new Runnable() {
            public void run() {
                colorCode.setText(colorized_numbers(str));
            }
        };
        handler.post(proc);
    }

}
