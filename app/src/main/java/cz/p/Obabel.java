package cz.p;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Obabel extends MainActivity {

    private Handler handler = new Handler();


    private TextView Description;
    private TextView ObabelLabel;
    private EditText ObabelInput;
    private TextView ITypeSwitchLabel;
    private EditText ITypeSwitch;
    private TextView OTypeSwitchLabel;
    private EditText OTypeSwitch;
    Button openInputfile;
    Button openIntInputfile;
    Button saveInputfile;
    Button saveExtInputfile;
    Button RunObabel;
    Button saveOutputfile;
    Button saveExtOutputfile;
    Button Highlight;
    Button Quit;
    private TextView textViewX;
    private TextView outputView;
    private EditText outputView2;
    private static final int READ_FILE7 = 7;
    private Uri documentUri7;
    private static final int CREATE_FILE30 = 30;
    private Uri documentUri30;
    private static final int CREATE_FILE31 = 31;
    private Uri documentUri31;
    Button manual_openbabel;


    /**
     * Colorize a specific substring in a string for TextView. Use it like this: <pre>
     * textView.setText(
     *     Strings.colorized("The some words are black some are the default.","black", Color.BLACK),
     *     TextView.BufferType.SPANNABLE
     * );
     * </pre>
     * @param text Text that contains a substring to colorize
     * @param word0 The substring to colorize
     * @param word1 The substring to colorize
     * @param word2 The substring to colorize
     * @param word3 The substring to colorize
     * @param word4 The substring to colorize
     * @param word5 The substring to colorize
     * @param word6 The substring to colorize
     * @param word7 The substring to colorize
     * @param word8 The substring to colorize
     * @param word9 The substring to colorize
     * @param word10 The substring to colorize
     * @param word11 The substring to colorize
     * @param word12 The substring to colorize
     * @param argb The color
     * @return the Spannable for TextView's consumption
     */
    public static Spannable colorized(final String text, final String word0, final String word1, final String word2, final String word3, final String word4, final String word5, final String word6, final String word7, final String word8, final String word9, final String word10, final String word11, final String word12, final int argb) {
        final Spannable spannable = new SpannableString(text);
        int substringStart0=0;
        int substringStart1=0;
        int substringStart2=0;
        int substringStart3=0;
        int substringStart4=0;
        int substringStart5=0;
        int substringStart6=0;
        int substringStart7=0;
        int substringStart8=0;
        int substringStart9=0;
        int substringStart10=0;
        int substringStart11=0;
        int substringStart12=0;
        int start0;
        int start1;
        int start2;
        int start3;
        int start4;
        int start5;
        int start6;
        int start7;
        int start8;
        int start9;
        int start10;
        int start11;
        int start12;
        while((start0=text.indexOf(word0,substringStart0))>=0){
            spannable.setSpan(
                    new ForegroundColorSpan(argb),start0,start0+word0.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            );
            while((start1=text.indexOf(word1,substringStart1))>=0) {
                spannable.setSpan(
                        new ForegroundColorSpan(argb), start1, start1 + word1.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                while((start2=text.indexOf(word2,substringStart2))>=0) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb), start2, start2 + word2.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                    while((start3=text.indexOf(word3,substringStart3))>=0) {
                        spannable.setSpan(
                                new ForegroundColorSpan(argb), start3, start3 + word3.length(),
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        );
                        while((start4=text.indexOf(word4,substringStart4))>=0) {
                            spannable.setSpan(
                                    new ForegroundColorSpan(argb), start4, start4 + word4.length(),
                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            );
                            while((start5=text.indexOf(word5,substringStart5))>=0) {
                                spannable.setSpan(
                                        new ForegroundColorSpan(argb), start5, start5 + word5.length(),
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                );
                                while((start6=text.indexOf(word6,substringStart6))>=0) {
                                    spannable.setSpan(
                                            new ForegroundColorSpan(argb), start6, start6 + word6.length(),
                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                    );
                                    while((start7=text.indexOf(word7,substringStart7))>=0) {
                                        spannable.setSpan(
                                                new ForegroundColorSpan(argb), start7, start7 + word7.length(),
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                        );
                                        while((start8=text.indexOf(word8,substringStart8))>=0) {
                                            spannable.setSpan(
                                                    new ForegroundColorSpan(argb), start8, start8 + word8.length(),
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                            );
                                            while((start9=text.indexOf(word9,substringStart9))>=0) {
                                                spannable.setSpan(
                                                        new ForegroundColorSpan(argb), start9, start9 + word9.length(),
                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                );
                                                while((start10=text.indexOf(word10,substringStart10))>=0) {
                                                    spannable.setSpan(
                                                            new ForegroundColorSpan(argb), start10, start10 + word10.length(),
                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                    );
                                                    while((start11=text.indexOf(word11,substringStart11))>=0) {
                                                        spannable.setSpan(
                                                                new ForegroundColorSpan(argb), start11, start11 + word11.length(),
                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                        );
                                                        while((start12=text.indexOf(word12,substringStart12))>=0) {
                                                            spannable.setSpan(
                                                                    new ForegroundColorSpan(argb), start12, start12 + word12.length(),
                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                            );
                                                            substringStart12 = start12 + word12.length();
                                                        }
                                                        substringStart11 = start11 + word11.length();
                                                    }
                                                    substringStart10 = start10 + word10.length();
                                                }
                                                substringStart9 = start9 + word9.length();
                                            }
                                            substringStart8 = start8+word8.length();
                                        }
                                        substringStart7 = start7+word7.length();
                                    }
                                    substringStart6 = start6+word6.length();
                                }
                                substringStart5 = start5+word5.length();
                            }
                            substringStart4 = start4+word4.length();
                        }
                        substringStart3 = start3+word3.length();
                    }
                    substringStart2 = start2+word2.length();
                }
                substringStart1 = start1+word1.length();
            }
            substringStart0 = start0+word0.length();
        }
        return spannable;
    }
    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.obabel);

        ObabelLabel = (TextView) findViewById(R.id.ObabelLabel);
        ObabelInput = (EditText) findViewById(R.id.ObabelInput);
        ObabelInput.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        ITypeSwitchLabel = (TextView) findViewById(R.id.ITypeSwitchLabel);
        ITypeSwitch = (EditText) findViewById(R.id.ITypeSwitch);
        ITypeSwitch.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        OTypeSwitchLabel = (TextView) findViewById(R.id.OTypeSwitchLabel);
        OTypeSwitch = (EditText) findViewById(R.id.OTypeSwitch);
        OTypeSwitch.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        openInputfile = (Button) findViewById(R.id.openInputfile);
        openInputfile.setOnClickListener(openInputfileClick);
        openIntInputfile = (Button) findViewById(R.id.openIntInputfile);
        saveInputfile = (Button) findViewById(R.id.saveInputfile);
        saveInputfile.setOnClickListener(saveInputfileClick);
        saveExtInputfile = (Button) findViewById(R.id.saveExtInputfile);
        saveExtInputfile.setOnClickListener(saveExtInputfileClick);
        RunObabel = (Button) findViewById(R.id.RunObabel);
        RunObabel.setOnClickListener(RunObabelClick);
        saveOutputfile = (Button) findViewById(R.id.saveOutputfile);
        saveOutputfile.setOnClickListener(saveOutputfileClick);
        saveExtOutputfile = (Button) findViewById(R.id.saveExtOutputfile);
        saveExtOutputfile.setOnClickListener(saveExtOutputfileClick);
        Highlight = (Button) findViewById(R.id.Highlight);
        Highlight.setOnClickListener(HighlightClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        textViewX = (TextView) findViewById(R.id.textViewX);
        outputView = (TextView) findViewById(R.id.outputView);
        outputView2 = (EditText) findViewById(R.id.outputView2);
        outputView2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/OutputTextSize.txt")).intValue());
        outputView2.setMovementMethod(new ScrollingMovementMethod());
        manual_openbabel = (Button) findViewById(R.id.manual_openbabel);
        manual_openbabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Obabel.this, ManualOpenbabel.class);
                startActivity(intent);
            }
        });

        openIntInputfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Obabel.this, ObabelWork.class);
                startActivity(intent);
            }
        });

    }


    public void onStart()
    {
        super.onStart();

        output3(exec("cat "+getFilesDir()+"/Input-openbabel.txt"));
        outputI(exec("cat "+getFilesDir()+"/InputSwitch.txt"));
        outputO(exec("cat "+getFilesDir()+"/OutputSwitch.txt"));
    }


    private View.OnClickListener openInputfileClick; {

        openInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read7(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-openbabel.txt"));
                outputI(exec("cat "+getFilesDir()+"/InputSwitch.txt"));
                outputO(exec("cat "+getFilesDir()+"/OutputSwitch.txt"));
            }
        };
    }

    private View.OnClickListener saveExtInputfileClick; {

        saveExtInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = ObabelInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-openbabel.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String InputSwitch = ITypeSwitch.getText().toString();
                try {
                    FileOutputStream fileoutI = openFileOutput("InputSwitch.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterI = new OutputStreamWriter(fileoutI);
                    outputWriterI.write(InputSwitch);
                    outputWriterI.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String OutputSwitch = OTypeSwitch.getText().toString();
                try {
                    FileOutputStream fileoutO = openFileOutput("OutputSwitch.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterO = new OutputStreamWriter(fileoutO);
                    outputWriterO.write(OutputSwitch);
                    outputWriterO.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write1(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-openbabel.txt"));
                outputI(exec("cat "+getFilesDir()+"/InputSwitch.txt"));
                outputO(exec("cat "+getFilesDir()+"/OutputSwitch.txt"));
            }
        };
    }

    private View.OnClickListener saveExtOutputfileClick; {

        saveExtOutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = ObabelInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-openbabel.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String InputSwitch = ITypeSwitch.getText().toString();
                try {
                    FileOutputStream fileoutI = openFileOutput("InputSwitch.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterI = new OutputStreamWriter(fileoutI);
                    outputWriterI.write(InputSwitch);
                    outputWriterI.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String OutputSwitch = OTypeSwitch.getText().toString();
                try {
                    FileOutputStream fileoutO = openFileOutput("OutputSwitch.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterO = new OutputStreamWriter(fileoutO);
                    outputWriterO.write(OutputSwitch);
                    outputWriterO.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write2(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-openbabel.txt"));
                outputI(exec("cat "+getFilesDir()+"/InputSwitch.txt"));
                outputO(exec("cat "+getFilesDir()+"/OutputSwitch.txt"));
            }
        };
    }

    private void read7(Context context7) {
        Intent intent7 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent7.addCategory(Intent.CATEGORY_OPENABLE);
        intent7.setType("text/plain");
        startActivityForResult(intent7, READ_FILE7);
    }

    private void write1(Context context1) {
        Intent intent1 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        intent1.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent1, CREATE_FILE30);
    }

    private void write2(Context context2) {
        Intent intent2 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent2.addCategory(Intent.CATEGORY_OPENABLE);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TITLE,"MyOutputFile");
        startActivityForResult(intent2, CREATE_FILE31);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE7 && data != null) {
            try {
                documentUri7 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd7 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd7.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("Input-openbabel.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd7.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE30 && data != null) {
            // save input file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri30 = data.getData();
                ParcelFileDescriptor pfd30 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd30.getFileDescriptor());
                String fileContents = ObabelInput.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd30.close();
                FileOutputStream fileout = openFileOutput("Input-openbabel.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE31 && data != null) {
            // save output file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri31 = data.getData();
                ParcelFileDescriptor pfd31 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd31.getFileDescriptor());
                String fileContents = outputView2.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd31.close();
                FileOutputStream fileout = openFileOutput("Input.obabel", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

    }


    private View.OnClickListener saveInputfileClick; {

        saveInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = ObabelInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-openbabel.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String InputSwitch = ITypeSwitch.getText().toString();
                try {
                    FileOutputStream fileoutI = openFileOutput("InputSwitch.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterI = new OutputStreamWriter(fileoutI);
                    outputWriterI.write(InputSwitch);
                    outputWriterI.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String OutputSwitch = OTypeSwitch.getText().toString();
                try {
                    FileOutputStream fileoutO = openFileOutput("OutputSwitch.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterO = new OutputStreamWriter(fileoutO);
                    outputWriterO.write(OutputSwitch);
                    outputWriterO.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveInput();
                output3(exec("cat "+getFilesDir()+"/Input-openbabel.txt"));
                outputI(exec("cat "+getFilesDir()+"/InputSwitch.txt"));
                outputO(exec("cat "+getFilesDir()+"/OutputSwitch.txt"));
            }
        };
    }


    public void alertSaveInput(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Obabel.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Obabel.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/obabel")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = ObabelInput.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/obabel");
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }


    private View.OnClickListener RunObabelClick; {

        RunObabelClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = ObabelInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-openbabel.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String InputSwitch = ITypeSwitch.getText().toString();
                try {
                    FileOutputStream fileoutI = openFileOutput("InputSwitch.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterI = new OutputStreamWriter(fileoutI);
                    outputWriterI.write(InputSwitch);
                    outputWriterI.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String OutputSwitch = OTypeSwitch.getText().toString();
                try {
                    FileOutputStream fileoutO = openFileOutput("OutputSwitch.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriterO = new OutputStreamWriter(fileoutO);
                    outputWriterO.write(OutputSwitch);
                    outputWriterO.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                openprogressdialog();
            }
        };
    }

    private void openprogressdialog() {
        // TODO Auto-generated method stub //
        progressDialog = new ProgressDialog(Obabel.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Conversion is running...");
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        progressDialog.show();
        new Thread() {
            public void run() {
                try {
                    exec("chmod 755 -R "+getFilesDir());
                    String InputSwitch = ITypeSwitch.getText().toString();
                    String OutputSwitch = OTypeSwitch.getText().toString();
                    // String ObabelOutput123 = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -i"+InputSwitch+" "+getFilesDir()+"/Input-openbabel.txt -o"+OutputSwitch);
		    com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -i"+InputSwitch+" Input-openbabel.txt -o"+OutputSwitch+" > ObabelOutput123.txt");
		    String ObabelOutput123 = exec("cat "+getFilesDir()+"/ObabelOutput123.txt");
		    
                    FileOutputStream fileout123 = openFileOutput("Input.obabel", MODE_PRIVATE);
                    OutputStreamWriter outputWriter123 = new OutputStreamWriter(fileout123);
                    outputWriter123.write(ObabelOutput123);
                    outputWriter123.close();
                    exec("chmod 755 "+getFilesDir()+"/Input.obabel");
                    try {
                        output2(exec("cat "+getFilesDir()+"/Input.obabel"));
                        output3(exec("cat "+getFilesDir()+"/Input-openbabel.txt"));
                        outputI(exec("cat "+getFilesDir()+"/InputSwitch.txt"));
                        outputO(exec("cat "+getFilesDir()+"/OutputSwitch.txt"));
                        Toast.makeText(getApplicationContext(), "Conversion finished", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
                onFinish();
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

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void output2(final String str2) {
                Runnable proc2 = new Runnable() {
                    public void run() {
                        outputView2.setText(str2);
                    }
                };
                handler.post(proc2);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }


    public void output2(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                outputView2.setText(str2);
            }
        };
        handler.post(proc2);
    }















    private View.OnClickListener saveOutputfileClick; {

        saveOutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertSaveOutput();
                output3(exec("cat "+getFilesDir()+"/Input-openbabel.txt"));
                outputI(exec("cat "+getFilesDir()+"/InputSwitch.txt"));
                outputO(exec("cat "+getFilesDir()+"/OutputSwitch.txt"));
            }
        };
    }





    public void alertSaveOutput(){
        // creating the EditText widget programatically
        EditText editText15 = new EditText(Obabel.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Obabel.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/obabel")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText15)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String OutputProtocol = outputView2.getText().toString();
                        String SaveOutputName = editText15.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveOutputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(OutputProtocol);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveOutputName+" "+getFilesDir()+"/obabel");
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText15.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }















    private View.OnClickListener HighlightClick; {

        HighlightClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                openhighlightdialog();
            }
        };
    }


    private void openhighlightdialog() {
        // TODO Auto-generated method stub //
        progressDialog = new ProgressDialog(Obabel.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Highlighting numbers is in progress...");
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        progressDialog.show();

        new Thread() {
            public void run() {
                try {
                    outputX(exec("cat "+getFilesDir()+"/Input.obabel"));
                    output3(exec("cat "+getFilesDir()+"/Input-openbabel.txt"));
                    outputI(exec("cat "+getFilesDir()+"/InputSwitch.txt"));
                    outputO(exec("cat "+getFilesDir()+"/OutputSwitch.txt"));
                    Toast.makeText(getApplicationContext(), "Numbers highlighted.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }

                onFinish();
            }

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void outputX(final String strX) {
                Runnable procX = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized(strX, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                    }
                };
                handler.post(procX);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }



























    private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Obabel.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


    @Override
    protected void onResume() {
        super.onResume();
        output3(exec("cat "+getFilesDir()+"/Input-openbabel.txt"));
        outputI(exec("cat "+getFilesDir()+"/InputSwitch.txt"));
        outputO(exec("cat "+getFilesDir()+"/OutputSwitch.txt"));
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                ObabelInput.setText(str3);
            }
        };
        handler.post(proc3);
    }

    public void outputI(final String strI) {
        Runnable procI = new Runnable() {
            public void run() {
                ITypeSwitch.setText(strI);
            }
        };
        handler.post(procI);
    }

    public void outputO(final String strO) {
        Runnable procO = new Runnable() {
            public void run() {
                OTypeSwitch.setText(strO);
            }
        };
        handler.post(procO);
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

}
