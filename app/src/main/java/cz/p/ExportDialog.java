package cz.p;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExportDialog extends CustomPicker {

private TextView export_label;
private TextView export_description;
private Button start_export;
private Button quit;
private static final int CREATE_FILE100 = 21100;
private Uri documentUri100;
private Handler handler = new Handler();

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.exportdialog);

        export_label = (TextView) findViewById(R.id.export_label);
        export_description = (TextView) findViewById(R.id.export_description);
        start_export = (Button) findViewById(R.id.start_export);
        start_export.setOnClickListener(start_exportClick);

        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExportDialog.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private View.OnClickListener start_exportClick; {

        start_exportClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                write100(getApplicationContext());
//                Intent intent = new Intent(ExportDialog.this, MainActivity.class);
//                startActivity(intent);
            }
        };
    }


    private void write100(Context context100) {
        String NameOfTheFile = exec("cat "+getFilesDir()+"/ExportedFileName.txt");
        Intent intent100 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent100.addCategory(Intent.CATEGORY_OPENABLE);
        intent100.setType("text/plain");
        intent100.putExtra(Intent.EXTRA_TITLE,NameOfTheFile);
        startActivityForResult(intent100, CREATE_FILE100);
    }

    @Override
    protected void onResume() {
        super.onResume();
        output(exec("cat "+getFilesDir()+"/ExportedFileName.txt"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_FILE100 && data != null) {
            // save the selected file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri100 = data.getData();
                ParcelFileDescriptor pfd100 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd100.getFileDescriptor());
                String fileContents = exec("cat "+getFilesDir()+"/ExportedFile.txt");
//                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.write((fileContents).getBytes());
                fileOutputStream.close();
                pfd100.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }
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

    public void output(final String str) {
        Runnable proc = new Runnable() {
            public void run() {
                export_description.setText(str);
            }
        };
        handler.post(proc);
    }

}
