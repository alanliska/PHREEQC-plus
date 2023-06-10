package cz.p;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.jrummyapps.android.shell.CommandResult;
import com.jrummyapps.android.shell.Shell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class ShellTools extends DevMode {

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
    private TextView Shell0Label;
    private EditText Shell0;
    private Button Shell0Button;
    private TextView ShellLabel;
    private EditText Shell;
    private Button ShellButton;
    private TextView ExecuteOutputLabel;
    private TextView ExecuteOutput;
    private Button Quit;
    Button manual_x11basic;
    private TextView NativeLibLabel;
    private EditText NativeLibPath;
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
        Shell0Label = (TextView) findViewById(R.id.Shell0Label);
        Shell0 = (EditText) findViewById(R.id.Shell0);
        Shell0Button = (Button) findViewById(R.id.Shell0Button);
        Shell0Button.setOnClickListener(Shell0ButtonClick);
        ShellLabel = (TextView) findViewById(R.id.ShellLabel);
        Shell = (EditText) findViewById(R.id.Shell);
        ShellButton = (Button) findViewById(R.id.ShellButton);
        ShellButton.setOnClickListener(ShellButtonClick);
        ExecuteOutputLabel = (TextView) findViewById(R.id.ExecuteOutputLabel);
        ExecuteOutput = (TextView) findViewById(R.id.ExecuteOutput);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        NativeLibLabel = (TextView) findViewById(R.id.NativeLibLabel);
        NativeLibPath = (EditText) findViewById(R.id.NativeLibPath);
        manual_x11basic = (Button) findViewById(R.id.manual_x11basic);
        manual_x11basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ShellTools.this, ManualX11Basic.class);
                startActivity(intent);
            }
        });

    }

    public void onStart()
    {
        super.onStart();
        String Filename = X11Name.getText().toString();
        RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
        LibDisplay(getApplicationInfo().nativeLibraryDir);
    }


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
                        RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
                        LibDisplay(getApplicationInfo().nativeLibraryDir);
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
                        CatDisplay(exec("cat "+getFilesDir()+"/"+CatOutput.getText().toString()));
                        String Filename = X11Name.getText().toString();
                        RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
                        LibDisplay(getApplicationInfo().nativeLibraryDir);
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
                        RunX11Display(exec("cat "+getFilesDir()+"/test.bas"));
                        LibDisplay(getApplicationInfo().nativeLibraryDir);
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
            }
        };
    }

    // original simple code
    private View.OnClickListener Shell0ButtonClick; {
        Shell0ButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    exec("chmod -R 755 "+getFilesDir());
                    try {
                        ShellDisplay(exec(Shell0.getText().toString()));
                        String Filename = X11Name.getText().toString();
                        RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
            }
        };
    }

    // more advanced shell code with cd, <, >, env variables, export, ./ etc.
    private View.OnClickListener ShellButtonClick; {

        ShellButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Shell.getWindowToken(), 0);
                String command = Shell.getText().toString();
                new RunCommandTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, command);
                String Filename = X11Name.getText().toString();
                RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
                LibDisplay(getApplicationInfo().nativeLibraryDir);
            }
        };
    }

    // Ignore the bad AsyncTask usage.
    final class RunCommandTask extends AsyncTask<String, Void, CommandResult> {

        private ProgressDialog dialog;

        @Override protected void onPreExecute() {
            dialog = ProgressDialog.show(ShellTools.this, "Running Command", "Please Wait...");
            dialog.setCancelable(false);
        }

        @Override protected CommandResult doInBackground(String... commands) {
            return com.jrummyapps.android.shell.Shell.SH.run(commands);
        }

        @Override protected void onPostExecute(CommandResult result) {
            if (!isFinishing()) {
                dialog.dismiss();
                ExecuteOutput.setText(resultToHtml(result));
            }
        }

        private Spanned resultToHtml(CommandResult result) {
            StringBuilder html = new StringBuilder();
            // exit status
            html.append("<p><strong>Edit Code:</strong> ");
            if (result.isSuccessful()) {
                html.append("<font color='green'>").append(result.exitCode).append("</font>");
            } else {
                html.append("<font color='red'>").append(result.exitCode).append("</font>");
            }
            html.append("</p>");
            // stdout
            if (result.stdout.size() > 0) {
                html.append("<p><strong>STDOUT:</strong></p><p>")
                        .append(result.getStdout().replaceAll("\n", "<br>"))
                        .append("</p>");
            }
            // stderr
            if (result.stderr.size() > 0) {
                html.append("<p><strong>STDERR:</strong></p><p><font color='red'>")
                        .append(result.getStderr().replaceAll("\n", "<br>"))
                        .append("</font></p>");
            }
            return Html.fromHtml(html.toString());
        }

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

    private void ShellDisplay(final String str1002) {
        Runnable proc1002 = new Runnable() {
            public void run() {
                ExecuteOutput.setText(str1002);
            }
        };
        handler.post(proc1002);
    }

    private void LibDisplay(final String str1003) {
        Runnable proc1003 = new Runnable() {
            public void run() {
                NativeLibPath.setText(str1003);
            }
        };
        handler.post(proc1003);
    }

    private void CatDisplay(final String str1004) {
        Runnable proc1004 = new Runnable() {
            public void run() {
                CatResponse.setText(str1004);
            }
        };
        handler.post(proc1004);
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
