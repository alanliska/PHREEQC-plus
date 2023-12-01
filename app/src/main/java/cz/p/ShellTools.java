package cz.p;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
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
    private EditText RunX11Output;
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
    private EditText ExecuteOutput;
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
        RunX11Output = (EditText) findViewById(R.id.RunX11Output);
        RunX11Output.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/TextSize.txt")).intValue());
        RunX11Output.setMovementMethod(new ScrollingMovementMethod());
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
        ExecuteOutput = (EditText) findViewById(R.id.ExecuteOutput);
        ExecuteOutput.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/TextSize.txt")).intValue());
        ExecuteOutput.setMovementMethod(new ScrollingMovementMethod());
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




        X11NameDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Name.txt"));
        X11ContentDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Content.txt"));
        CatDisplay1(exec("cat "+getFilesDir()+"/ShellToolsCat1.txt"));
        DeleteDisplay(exec("cat "+getFilesDir()+"/ShellToolsDelete.txt"));
        Shell0Display(exec("cat "+getFilesDir()+"/ShellToolsShell0.txt"));
        ShellDisplay(exec("cat "+getFilesDir()+"/ShellToolsShell.txt"));
    }


    private View.OnClickListener RunX11ButtonClick; {
        RunX11ButtonClick = new View.OnClickListener() {
            public void onClick(View v) {

                String ShellTX11Name = X11Name.getText().toString();
                String ShellTX11Content = RunX11.getText().toString();
                String ShellTCat1 = CatOutput.getText().toString();
                String ShellTDelete = Delete.getText().toString();
                String ShellTShell0 = Shell0.getText().toString();
                String ShellTShell = Shell.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("ShellToolsX11Name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(ShellTX11Name);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("ShellToolsX11Content.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(ShellTX11Content);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("ShellToolsCat1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(ShellTCat1);
                    outputWriter3.close();
                    FileOutputStream fileout4 = openFileOutput("ShellToolsDelete.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(ShellTDelete);
                    outputWriter4.close();
                    FileOutputStream fileout5 = openFileOutput("ShellToolsShell0.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(ShellTShell0);
                    outputWriter5.close();
                    FileOutputStream fileout6 = openFileOutput("ShellToolsShell.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(ShellTShell);
                    outputWriter6.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

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
                X11NameDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Name.txt"));
                X11ContentDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Content.txt"));
                CatDisplay1(exec("cat "+getFilesDir()+"/ShellToolsCat1.txt"));
                DeleteDisplay(exec("cat "+getFilesDir()+"/ShellToolsDelete.txt"));
                Shell0Display(exec("cat "+getFilesDir()+"/ShellToolsShell0.txt"));
                ShellDisplay(exec("cat "+getFilesDir()+"/ShellToolsShell.txt"));
            }
        };
    }

    private View.OnClickListener CatButtonClick; {
        CatButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String ShellTX11Name = X11Name.getText().toString();
                String ShellTX11Content = RunX11.getText().toString();
                String ShellTCat1 = CatOutput.getText().toString();
                String ShellTDelete = Delete.getText().toString();
                String ShellTShell0 = Shell0.getText().toString();
                String ShellTShell = Shell.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("ShellToolsX11Name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(ShellTX11Name);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("ShellToolsX11Content.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(ShellTX11Content);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("ShellToolsCat1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(ShellTCat1);
                    outputWriter3.close();
                    FileOutputStream fileout4 = openFileOutput("ShellToolsDelete.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(ShellTDelete);
                    outputWriter4.close();
                    FileOutputStream fileout5 = openFileOutput("ShellToolsShell0.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(ShellTShell0);
                    outputWriter5.close();
                    FileOutputStream fileout6 = openFileOutput("ShellToolsShell.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(ShellTShell);
                    outputWriter6.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                X11NameDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Name.txt"));
                X11ContentDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Content.txt"));
                CatDisplay1(exec("cat "+getFilesDir()+"/ShellToolsCat1.txt"));
                DeleteDisplay(exec("cat "+getFilesDir()+"/ShellToolsDelete.txt"));
                Shell0Display(exec("cat "+getFilesDir()+"/ShellToolsShell0.txt"));
                ShellDisplay(exec("cat "+getFilesDir()+"/ShellToolsShell.txt"));
            }
        };
    }

    private View.OnClickListener DeleteButtonClick; {
        DeleteButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String ShellTX11Name = X11Name.getText().toString();
                String ShellTX11Content = RunX11.getText().toString();
                String ShellTCat1 = CatOutput.getText().toString();
                String ShellTDelete = Delete.getText().toString();
                String ShellTShell0 = Shell0.getText().toString();
                String ShellTShell = Shell.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("ShellToolsX11Name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(ShellTX11Name);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("ShellToolsX11Content.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(ShellTX11Content);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("ShellToolsCat1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(ShellTCat1);
                    outputWriter3.close();
                    FileOutputStream fileout4 = openFileOutput("ShellToolsDelete.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(ShellTDelete);
                    outputWriter4.close();
                    FileOutputStream fileout5 = openFileOutput("ShellToolsShell0.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(ShellTShell0);
                    outputWriter5.close();
                    FileOutputStream fileout6 = openFileOutput("ShellToolsShell.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(ShellTShell);
                    outputWriter6.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                X11NameDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Name.txt"));
                X11ContentDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Content.txt"));
                CatDisplay1(exec("cat "+getFilesDir()+"/ShellToolsCat1.txt"));
                DeleteDisplay(exec("cat "+getFilesDir()+"/ShellToolsDelete.txt"));
                Shell0Display(exec("cat "+getFilesDir()+"/ShellToolsShell0.txt"));
                ShellDisplay(exec("cat "+getFilesDir()+"/ShellToolsShell.txt"));
            }
        };
    }

    // original simple code
    private View.OnClickListener Shell0ButtonClick; {
        Shell0ButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String ShellTX11Name = X11Name.getText().toString();
                String ShellTX11Content = RunX11.getText().toString();
                String ShellTCat1 = CatOutput.getText().toString();
                String ShellTDelete = Delete.getText().toString();
                String ShellTShell0 = Shell0.getText().toString();
                String ShellTShell = Shell.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("ShellToolsX11Name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(ShellTX11Name);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("ShellToolsX11Content.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(ShellTX11Content);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("ShellToolsCat1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(ShellTCat1);
                    outputWriter3.close();
                    FileOutputStream fileout4 = openFileOutput("ShellToolsDelete.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(ShellTDelete);
                    outputWriter4.close();
                    FileOutputStream fileout5 = openFileOutput("ShellToolsShell0.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(ShellTShell0);
                    outputWriter5.close();
                    FileOutputStream fileout6 = openFileOutput("ShellToolsShell.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(ShellTShell);
                    outputWriter6.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    exec("chmod -R 755 "+getFilesDir());
                    try {
                        String OutputExec = exec(Shell0.getText().toString());
                        ExecuteOutput.setText(colorized(OutputExec, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                        String Filename = X11Name.getText().toString();
                        RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
                X11NameDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Name.txt"));
                X11ContentDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Content.txt"));
                CatDisplay1(exec("cat "+getFilesDir()+"/ShellToolsCat1.txt"));
                DeleteDisplay(exec("cat "+getFilesDir()+"/ShellToolsDelete.txt"));
                Shell0Display(exec("cat "+getFilesDir()+"/ShellToolsShell0.txt"));
                ShellDisplay(exec("cat "+getFilesDir()+"/ShellToolsShell.txt"));
            }
        };
    }

    // more advanced shell code with cd, <, >, env variables, export, ./ etc.
    private View.OnClickListener ShellButtonClick; {

        ShellButtonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String ShellTX11Name = X11Name.getText().toString();
                String ShellTX11Content = RunX11.getText().toString();
                String ShellTCat1 = CatOutput.getText().toString();
                String ShellTDelete = Delete.getText().toString();
                String ShellTShell0 = Shell0.getText().toString();
                String ShellTShell = Shell.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("ShellToolsX11Name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(ShellTX11Name);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("ShellToolsX11Content.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(ShellTX11Content);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("ShellToolsCat1.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(ShellTCat1);
                    outputWriter3.close();
                    FileOutputStream fileout4 = openFileOutput("ShellToolsDelete.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(ShellTDelete);
                    outputWriter4.close();
                    FileOutputStream fileout5 = openFileOutput("ShellToolsShell0.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                    outputWriter5.write(ShellTShell0);
                    outputWriter5.close();
                    FileOutputStream fileout6 = openFileOutput("ShellToolsShell.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                    outputWriter6.write(ShellTShell);
                    outputWriter6.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Shell.getWindowToken(), 0);
                String Arguments = Shell.getText().toString();


                Arguments = Arguments.replace(" obabel ", " "+getApplicationInfo().nativeLibraryDir+"/libobabel.so ");
                Arguments = Arguments.replace(" dftb ", " "+getApplicationInfo().nativeLibraryDir+"/libdftb.so ");
                Arguments = Arguments.replace(" qcxms ", " "+getApplicationInfo().nativeLibraryDir+"/libqcxms.so ");
                Arguments = Arguments.replace(" modes ", " "+getApplicationInfo().nativeLibraryDir+"/libmodes.so ");
                Arguments = Arguments.replace(" xbbc ", " "+getApplicationInfo().nativeLibraryDir+"/libxbbc.so ");
                Arguments = Arguments.replace(" xbvm ", " "+getApplicationInfo().nativeLibraryDir+"/libxbvm.so ");
                Arguments = Arguments.replace(" plotms ", " "+getApplicationInfo().nativeLibraryDir+"/libplotms.so ");
                Arguments = Arguments.replace(" stda ", " "+getApplicationInfo().nativeLibraryDir+"/libstda.so ");
                Arguments = Arguments.replace(" xtb ", " "+getApplicationInfo().nativeLibraryDir+"/libxtb.so ");
                Arguments = Arguments.replace(" xtb4stda ", " "+getApplicationInfo().nativeLibraryDir+"/libxtb4stda.so ");
                Arguments = Arguments.replace(" waveplot ", " "+getApplicationInfo().nativeLibraryDir+"/libwaveplot.so ");
                Arguments = Arguments.replace(" buildwire ", " "+getApplicationInfo().nativeLibraryDir+"/libbuildwire.so ");
                Arguments = Arguments.replace(" flux ", " "+getApplicationInfo().nativeLibraryDir+"/libflux.so ");
                Arguments = Arguments.replace(" makecube ", " "+getApplicationInfo().nativeLibraryDir+"/libmakecube.so ");
                Arguments = Arguments.replace(" phonons ", " "+getApplicationInfo().nativeLibraryDir+"/libphonons.so ");
                Arguments = Arguments.replace(" setupgeom ", " "+getApplicationInfo().nativeLibraryDir+"/libsetupgeom.so ");
                Arguments = Arguments.replace(" chemsol ", " "+getApplicationInfo().nativeLibraryDir+"/libchemsol.so ");
                Arguments = Arguments.replace(" fastchem ", " "+getApplicationInfo().nativeLibraryDir+"/libfastchem.so ");
                Arguments = Arguments.replace(" mopac ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac.so ");
		        Arguments = Arguments.replace(" mopac-makpol ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac-makpol.so ");
		        Arguments = Arguments.replace(" mopac-param ", " "+getApplicationInfo().nativeLibraryDir+"/libmopac-param.so ");
                Arguments = Arguments.replace(" phreeqc ", " "+getApplicationInfo().nativeLibraryDir+"/libphreeqc.so ");
//                Arguments = Arguments.replace(" phreeqc-prepare ", " "+getApplicationInfo().nativeLibraryDir+"/libphreeqc-prepare.so ");
                Arguments = Arguments.replace(" transpose ", " "+getApplicationInfo().nativeLibraryDir+"/libtranspose.so ");


                new RunCommandTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Arguments);
                String Filename = X11Name.getText().toString();
                RunX11Display(exec("cat "+getFilesDir()+"/"+Filename+".bas"));
                LibDisplay(getApplicationInfo().nativeLibraryDir);

                X11NameDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Name.txt"));
                X11ContentDisplay(exec("cat "+getFilesDir()+"/ShellToolsX11Content.txt"));
                CatDisplay1(exec("cat "+getFilesDir()+"/ShellToolsCat1.txt"));
                DeleteDisplay(exec("cat "+getFilesDir()+"/ShellToolsDelete.txt"));
                Shell0Display(exec("cat "+getFilesDir()+"/ShellToolsShell0.txt"));
                ShellDisplay(exec("cat "+getFilesDir()+"/ShellToolsShell.txt"));
            }
        };
    }

    // Ignore the bad AsyncTask usage.
    final class RunCommandTask extends AsyncTask<String, Void, CommandResult> {

//        private ProgressDialog dialog;
        private ProgressDialog progressDialog = new ProgressDialog(ShellTools.this);

        @Override protected void onPreExecute() {
//            dialog = ProgressDialog.show(ShellTools.this, "Running Command", "Please Wait...");
//            dialog.setCancelable(false);
//            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog2, int which) {
//                    dialog2.dismiss();
//                }
//            });
            progressDialog.setTitle("Please wait...");
            progressDialog.setMessage("Running command...");
            progressDialog.setCancelable(false);
            progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            progressDialog.show();
        }

        @Override protected CommandResult doInBackground(String... commands) {
            return com.jrummyapps.android.shell.Shell.SH.run(commands);
        }

        @Override protected void onPostExecute(CommandResult result) {
            if (!isFinishing()) {
//                dialog.dismiss();
                progressDialog.dismiss();
//                ExecuteOutput.setText(resultToHtml(result));
                String OutputofExecution = resultToHtml(result).toString();
                try {
                    FileOutputStream fileout = openFileOutput("LastExecutionOutput.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(OutputofExecution);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ExecuteOutput.setText(colorized(OutputofExecution, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));

            }
        }

        private Spanned resultToHtml(CommandResult result) {
            StringBuilder html = new StringBuilder();
            // exit status
            html.append("<p><strong>Exit Code:</strong> ");
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




    private void X11NameDisplay(final String str996) {
        Runnable proc996 = new Runnable() {
            public void run() {
                X11Name.setText(str996);
            }
        };
        handler.post(proc996);
    }

    private void X11ContentDisplay(final String str997) {
        Runnable proc997 = new Runnable() {
            public void run() {
                RunX11.setText(str997);
            }
        };
        handler.post(proc997);
    }

    private void CatDisplay1(final String str998) {
        Runnable proc998 = new Runnable() {
            public void run() {
                CatOutput.setText(str998);
            }
        };
        handler.post(proc998);
    }

    private void DeleteDisplay(final String str999) {
        Runnable proc999 = new Runnable() {
            public void run() {
                Delete.setText(str999);
            }
        };
        handler.post(proc999);
    }

    private void Shell0Display(final String str1001) {
        Runnable proc1001 = new Runnable() {
            public void run() {
                Shell0.setText(str1001);
            }
        };
        handler.post(proc1001);
    }

    private void ShellDisplay(final String str1002) {
        Runnable proc1002 = new Runnable() {
            public void run() {
                Shell.setText(str1002);
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
