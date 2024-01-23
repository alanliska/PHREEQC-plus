package cz.p;

import static cz.p.Spannables.colorized_numbers;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class EmpiricalKin extends MainActivity {

    private Handler handler = new Handler();
    private TextView dataset_label;
    private EditText dataset;
    TextView label21;
    TextView label22;
    TextView label23;
    Button start_gcm1_kin;
    Button start_gcm2_kin;
    Button start_gcm3_kin;
    Button quit;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.empiricalkin);

        dataset_label = (TextView) findViewById(R.id.dataset_label);
        dataset = (EditText) findViewById(R.id.dataset);
        dataset.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        dataset.addTextChangedListener(new TextWatcher() {
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
                dataset.removeTextChangedListener(this);
                String text = dataset.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                dataset.getText().clear();
                dataset.append(colorized_numbers(text));
                // place the cursor at the original position
                dataset.setSelection(startChanged+countChanged);
                dataset.addTextChangedListener(this);
            }
        });
        label21 = (TextView) findViewById(R.id.label21);
        label22 = (TextView) findViewById(R.id.label22);
        label23 = (TextView) findViewById(R.id.label23);


        start_gcm1_kin = (Button) findViewById(R.id.start_gcm1_kin);
        start_gcm1_kin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");

                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(EmpiricalKin.this, GCM1Kin.class);
                startActivity(intent);
            }
        });

        start_gcm2_kin = (Button) findViewById(R.id.start_gcm2_kin);
        start_gcm2_kin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");

                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(EmpiricalKin.this, GCM2Kin.class);
                startActivity(intent);
            }
        });

        start_gcm3_kin = (Button) findViewById(R.id.start_gcm3_kin);
        start_gcm3_kin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");

                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(EmpiricalKin.this, GCM3Kin.class);
                startActivity(intent);
            }
        });

        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");

                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(EmpiricalKin.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }






    public void dataset_view(final String dataset_str) {
        Runnable dataset_proc = new Runnable() {
            public void run() {
                dataset.setText(colorized_numbers(dataset_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(dataset_proc);
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
