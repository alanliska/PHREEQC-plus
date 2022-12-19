package cz.p;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ShellTools extends MainActivity {

//    private TextView SdcardLabel;
//    private TextView Sdcard;
//    private TextView TransferLabel;
//    private EditText Transfer;
//    private Button TransferButton;
    private TextView ContentLabel;
    private TextView Content;
    private TextView RunX11Label;
    private EditText RunX11;
    private TextView X11Content;
    private EditText X11Name;
    private Button RunX11Button;
    private TextView RunX11OutputLabel;
    private TextView RunX11Output;
    private TextView CatOutputLabel;
    private EditText CatOutput;
    private Button CatOutputButton;
    private TextView CatResponseLabel;
    private TextView CatResponse;
    private TextView DeleteLabel;
    private EditText Delete;
    private Button DeleteButton;
//    private TextView BackLabel;
//    private EditText BackOutput;
//    private Button BackButton;
    private TextView ShellLabel;
    private EditText Shell;
    private Button ShellButton;
    private TextView ExecuteOutputLabel;
    private TextView ExecuteOutput;
    private Button Quit;
    //important:
    private Handler handler = new Handler();
    //not so:!!!
    // private Handler handler;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.shelltools);

//        SdcardLabel = (TextView) findViewById(R.id.SdcardLabel);
//        Sdcard = (TextView) findViewById(R.id.Sdcard);
//        TransferLabel = (TextView) findViewById(R.id.TransferLabel);
//        Transfer = (EditText) findViewById(R.id.Transfer);
//        TransferButton = (Button) findViewById(R.id.TransferButton);
//        TransferButton.setOnClickListener(TransferButtonClick);
        ContentLabel = (TextView) findViewById(R.id.ContentLabel);
        Content = (TextView) findViewById(R.id.Content);
        RunX11Label = (TextView) findViewById(R.id.RunX11Label);
        RunX11 = (EditText) findViewById(R.id.RunX11);
        X11Content = (TextView) findViewById(R.id.X11Content);
        X11Name = (EditText) findViewById(R.id.X11Name);
        RunX11Button = (Button) findViewById(R.id.RunX11Button);
        RunX11Button.setOnClickListener(RunX11ButtonClick);
        RunX11OutputLabel = (TextView) findViewById(R.id.RunX11OutputLabel);
        RunX11Output = (TextView) findViewById(R.id.RunX11Output);
        CatOutputLabel = (TextView) findViewById(R.id.CatOutputLabel);
        CatOutput = (EditText) findViewById(R.id.CatOutput);
        CatOutputButton = (Button) findViewById(R.id.CatOutputButton);
        CatOutputButton.setOnClickListener(CatButtonClick);
        CatResponseLabel = (TextView) findViewById(R.id.CatResponseLabel);
        CatResponse = (TextView) findViewById(R.id.CatResponse);
        DeleteLabel = (TextView) findViewById(R.id.DeleteLabel);
        Delete = (EditText) findViewById(R.id.Delete);
        DeleteButton = (Button) findViewById(R.id.DeleteButton);
        DeleteButton.setOnClickListener(DeleteButtonClick);
//        BackLabel = (TextView) findViewById(R.id.BackLabel);
//        BackOutput = (EditText) findViewById(R.id.BackOutput);
//        BackButton = (Button) findViewById(R.id.BackButton);
//        BackButton.setOnClickListener(BackButtonClick);
        ShellLabel = (TextView) findViewById(R.id.ShellLabel);
        Shell = (EditText) findViewById(R.id.Shell);
        ShellButton = (Button) findViewById(R.id.ShellButton);
        ShellButton.setOnClickListener(ShellButtonClick);
        ExecuteOutputLabel = (TextView) findViewById(R.id.ExecuteOutputLabel);
        ExecuteOutput = (TextView) findViewById(R.id.ExecuteOutput);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);

    }





    public void onStart()
    {
        super.onStart();
        String Filename = X11Name.getText().toString();
        RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
//        SdcardDisplay(exec("ls -l "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"));
//        ContentDisplay(exec("ls -l "+getFilesDir()));
    }

//    private View.OnClickListener TransferButtonClick; {
//        TransferButtonClick = new View.OnClickListener() {
//            public void onClick(View v) {
////                // TODO Auto-generated method stub //
//                try {
//                    exec("cp "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus/"+Transfer.getText().toString()+" "+getFilesDir());
//                    try {
//                        String Filename = X11Name.getText().toString();
//                        RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
//                        SdcardDisplay(exec("ls -l "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"));
//                        ContentDisplay(exec("ls -l "+getFilesDir()));
//                    } catch (Exception e) {
//                    }
//                } catch (Exception e) {
//                }
//            }
//        };
//    }

    private View.OnClickListener RunX11ButtonClick; {
        RunX11ButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                String X11File = RunX11.getText().toString();
                String Filename = X11Name.getText().toString();
                // TODO Auto-generated method stub //
                try {
                    exec("chmod -R 755 "+getFilesDir());
                    FileOutputStream fileout = openFileOutput(Filename+".bas", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(X11File);
                    outputWriter.close();
                    try {

                        exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/"+Filename+".b "+getFilesDir()+"/"+Filename+".bas");
                        X11Display(exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/"+Filename+".b"));
//                        SdcardDisplay(exec("ls -l "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"));
//                        ContentDisplay(exec("ls -l "+getFilesDir()));
                        RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
            }
        };
    }

    private View.OnClickListener CatButtonClick; {
        CatButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    exec("chmod -R 755 "+getFilesDir());
                    try {
//                        SdcardDisplay(exec("ls -l "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"));
//                        ContentDisplay(exec("ls -l "+getFilesDir()));
                        CatDisplay(exec("cat "+getFilesDir()+"/"+CatOutput.getText().toString()));
                        String Filename = X11Name.getText().toString();
                        RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
            }
        };
    }

    private View.OnClickListener DeleteButtonClick; {
        DeleteButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    exec("chmod -R 755 "+getFilesDir());
                    exec("rm -rf "+getFilesDir()+"/"+Delete.getText().toString());
                    try {
//                        SdcardDisplay(exec("ls -l "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"));
//                        ContentDisplay(exec("ls -l "+getFilesDir()));
                        RunX11Display(exec("cat "+getFilesDir()+"/test.bas"));
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
            }
        };
    }

//    private View.OnClickListener BackButtonClick; {
//        BackButtonClick = new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub //
//                try {
//                    exec("chmod -R 755 "+getFilesDir());
//                    exec("cp "+getFilesDir()+"/"+BackOutput.getText().toString()+" "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
//                    try {
//                        SdcardDisplay(exec("ls -l "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"));
//                        ContentDisplay(exec("ls -l "+getFilesDir()));
//                        String Filename = X11Name.getText().toString();
//                        RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
//                    } catch (Exception e) {
//                    }
//                } catch (Exception e) {
//                }
//            }
//        };
//    }

    private View.OnClickListener ShellButtonClick; {
        ShellButtonClick = new View.OnClickListener() {
             public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    exec("chmod -R 755 "+getFilesDir());
                    try {
//                        SdcardDisplay(exec("ls -l "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"));
//                        ContentDisplay(exec("ls -l "+getFilesDir()));
                        ShellDisplay(exec(Shell.getText().toString()));
                        String Filename = X11Name.getText().toString();
                        RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
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

//    private void SdcardDisplay(final String str1001) {
//        Runnable proc1001 = new Runnable() {
//            public void run() {
//                Sdcard.setText(str1001);
//            }
//        };
//        handler.post(proc1001);
//    }

//    private void ContentDisplay(final String str1002) {
//        Runnable proc1002 = new Runnable() {
//            public void run() {
//                Content.setText(str1002);
//            }
//        };
//        handler.post(proc1002);
//    }

    private void CatDisplay(final String str1004) {
        Runnable proc1004 = new Runnable() {
            public void run() {
                CatResponse.setText(str1004);
            }
        };
        handler.post(proc1004);
    }

    private void ShellDisplay(final String str1005) {
        Runnable proc1005 = new Runnable() {
            public void run() {
                ExecuteOutput.setText(str1005);
            }
        };
        handler.post(proc1005);
    }

    private void X11Display(final String str1006) {
        Runnable proc1006 = new Runnable() {
            public void run() {
                RunX11Output.setText(str1006);
            }
        };
        handler.post(proc1006);
    }

    private void RunX11Display(final String str1007) {
        Runnable proc1007 = new Runnable() {
            public void run() {
                RunX11.setText(str1007);
            }
        };
        handler.post(proc1007);
    }












    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(ShellTools.this, DevMode.class);
                startActivity(intent);
            }
        };
    }




}
