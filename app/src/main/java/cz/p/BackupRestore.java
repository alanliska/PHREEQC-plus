package cz.p;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class BackupRestore extends DevMode {

    private TextView export_label;
    private Button start_export;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.backuprestore);

        export_label = (TextView) findViewById(R.id.export_label);
        start_export = (Button) findViewById(R.id.start_export);
        start_export.setOnClickListener(start_exportClick);

    }

    public void onStart()
    {
        super.onStart();
        backupOutput();
//        goBack();
    }

    //    private View.OnClickListener moveClick; {
//
//        moveClick = new View.OnClickListener() {
//            public void onClick(View v) {
    public void backupOutput() {
        // TODO Auto-generated method stub //


        progressDialog = new ProgressDialog(BackupRestore.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Creating backup of selected internal files.");
        progressDialog.show();
        new Thread() {
            public void run() {

                initializeBackup();
//                appendFastchem();
//                appendPhreeqc();
                appendGasOpt();
                appendGasThermo();
                appendSolvOpt();
                appendSolvThermo();
//                onResume();

                onFinish();
            }
            public void onFinish(){
                progressDialog.dismiss();
            }
        }.start();


    }
//        };
//    }

    public void initializeBackup()
    {
        // this piece of code is not working at the moment: the file Backup.txt contains only header - probably due to MODE_PRIVATE overwriting

//        File Path100 = new File(getFilesDir()+"/backup");
//
//        try {
//            if (!Path100.exists()) {
//                Path100.mkdirs();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
//        String currentDateandTime = sdf.format(new Date());
//        exec("touch "+getFilesDir()+"/Backup.txt");
//        try {
//            FileOutputStream fileout1 = openFileOutput("Backup.txt", MODE_PRIVATE);
//            OutputStreamWriter outputWriter1 = new OutputStreamWriter(fileout1);
////            outputWriter.write("Backup of the internal MOPAC/CHEMSOL files ("+currentDateandTime+")");
//            outputWriter1.write("Backup of the internal MOPAC/CHEMSOL files");
//            outputWriter1.write("\n");
//            outputWriter1.write("----------");
//            outputWriter1.write("\n");
//            outputWriter1.write("\n");
//            outputWriter1.close();
//        } catch (Exception e) {
//        }

    }
//
//    public void appendFastchem()
//    {
//    }
//
//    public void appendPhreeqc()
//    {
//    }

    public void appendGasOpt()
    {
        File[] inputfiles = new File(getFilesDir()+"/output/gas/opt/results").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

                try {
                    String fileName = file.getName();

                    String AppendedText = exec("cat "+getFilesDir()+"/output/gas/opt/results/"+fileName);
                    FileOutputStream fileout2 = openFileOutput("Backup.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Content of the file: /data/data/cz.p/files/output/gas/opt/results/"+fileName);
                    outputWriter2.write("\n");
                    outputWriter2.write("\n");
                    outputWriter2.write(AppendedText);
                    outputWriter2.write("\n");
                    outputWriter2.write("\n");
                    outputWriter2.write("----------");
                    outputWriter2.write("\n");
                    outputWriter2.write("\n");
                    outputWriter2.close();
                    exec("rm "+getFilesDir()+"/output/gas/opt/results/"+fileName);
                } catch (Exception e) {
                }

            }
        }
    }

    public void appendGasThermo()
    {
        File[] inputfiles = new File(getFilesDir()+"/output/gas/thermo/results").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

                try {
                    String fileName = file.getName();

                    String AppendedText = exec("cat "+getFilesDir()+"/output/gas/thermo/results/"+fileName);
                    FileOutputStream fileout3 = openFileOutput("Backup.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write("Content of the file: /data/data/cz.p/files/output/gas/thermo/results/"+fileName);
                    outputWriter3.write("\n");
                    outputWriter3.write("\n");
                    outputWriter3.write(AppendedText);
                    outputWriter3.write("\n");
                    outputWriter3.write("\n");
                    outputWriter3.write("----------");
                    outputWriter3.write("\n");
                    outputWriter3.write("\n");
                    outputWriter3.close();
                    exec("rm "+getFilesDir()+"/output/gas/thermo/results/"+fileName);
                } catch (Exception e) {
                }

            }
        }
    }


    public void appendSolvOpt()
    {
        File[] inputfiles = new File(getFilesDir()+"/output/solv/opt/results").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

                try {
                    String fileName = file.getName();

                    String AppendedText = exec("cat "+getFilesDir()+"/output/solv/opt/results/"+fileName);
                    FileOutputStream fileout4 = openFileOutput("Backup.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write("Content of the file: /data/data/cz.p/files/output/solv/opt/results/"+fileName);
                    outputWriter4.write("\n");
                    outputWriter4.write("\n");
                    outputWriter4.write(AppendedText);
                    outputWriter4.write("\n");
                    outputWriter4.write("\n");
                    outputWriter4.write("----------");
                    outputWriter4.write("\n");
                    outputWriter4.write("\n");
                    outputWriter4.close();
                    exec("rm "+getFilesDir()+"/output/solv/opt/results/"+fileName);
                } catch (Exception e) {
                }

            }
        }
    }

    public void appendSolvThermo()
    {
        File[] inputfiles = new File(getFilesDir()+"/output/solv/thermo/results").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

                try {
                    String fileName = file.getName();

                    String AppendedText = exec("cat "+getFilesDir()+"/output/solv/thermo/results/"+fileName);
                    FileOutputStream fileout5 = openFileOutput("Backup.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write("Content of the file: /data/data/cz.p/files/output/solv/thermo/results/"+fileName);
                    outputWriter5.write("\n");
                    outputWriter5.write("\n");
                    outputWriter5.write(AppendedText);
                    outputWriter5.write("\n");
                    outputWriter5.write("\n");
                    outputWriter5.write("----------");
                    outputWriter5.write("\n");
                    outputWriter5.write("\n");
                    outputWriter5.close();
                    exec("rm "+getFilesDir()+"/output/solv/thermo/results/"+fileName);
                } catch (Exception e) {
                }

            }
        }
    }

//    public void resumeBackup()
//    {
//        goToExport();
//    }

//    public void goToExport()
//    {
//        }

    private View.OnClickListener start_exportClick; {

        start_exportClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(BackupRestore.this, BackupRestoreDialog.class);
                startActivity(intent);
            }
        };
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        Intent intent = new Intent(BackupRestore.this, MainActivity.class);
//        startActivity(intent);
//
//    }



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
