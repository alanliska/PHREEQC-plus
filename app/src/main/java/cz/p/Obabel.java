package cz.p;

import static cz.p.Spannables.colorized_dftb;
import static cz.p.Spannables.colorized_numbers;
import static cz.p.Spannables.colorized_openbabel;
import static cz.p.Spannables.colorized_phreeqc;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
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
    private static final int READ_FILE7 = 307;
    private Uri documentUri7;
    private static final int CREATE_FILE30 = 3030;
    private Uri documentUri30;
    private static final int CREATE_FILE31 = 3031;
    private Uri documentUri31;
    Button manual_openbabel;

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
        ObabelInput.addTextChangedListener(new TextWatcher() {
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
                ObabelInput.removeTextChangedListener(this);
                String text = ObabelInput.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ObabelInput.getText().clear();
                ObabelInput.append(colorized_openbabel(text));
                // place the cursor at the original position
                ObabelInput.setSelection(startChanged+countChanged);
                ObabelInput.addTextChangedListener(this);
            }
        });
        ITypeSwitchLabel = (TextView) findViewById(R.id.ITypeSwitchLabel);
        ITypeSwitch = (EditText) findViewById(R.id.ITypeSwitch);
        ITypeSwitch.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        ITypeSwitch.addTextChangedListener(new TextWatcher() {
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
                ITypeSwitch.removeTextChangedListener(this);
                String text = ITypeSwitch.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ITypeSwitch.getText().clear();
                ITypeSwitch.append(colorized_openbabel(text));
                // place the cursor at the original position
                ITypeSwitch.setSelection(startChanged+countChanged);
                ITypeSwitch.addTextChangedListener(this);
            }
        });
        OTypeSwitchLabel = (TextView) findViewById(R.id.OTypeSwitchLabel);
        OTypeSwitch = (EditText) findViewById(R.id.OTypeSwitch);
        OTypeSwitch.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        OTypeSwitch.addTextChangedListener(new TextWatcher() {
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
                OTypeSwitch.removeTextChangedListener(this);
                String text = OTypeSwitch.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                OTypeSwitch.getText().clear();
                OTypeSwitch.append(colorized_openbabel(text));
                // place the cursor at the original position
                OTypeSwitch.setSelection(startChanged+countChanged);
                OTypeSwitch.addTextChangedListener(this);
            }
        });
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
        // disable - otherwise the text could not be selected
//        outputView2.setMovementMethod(new ScrollingMovementMethod());
        // otherwise every time is spanned
//        outputView2.addTextChangedListener(new TextWatcher() {
//            int startChanged,beforeChanged,countChanged;
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                startChanged = start;
//                beforeChanged = before;
//                countChanged = count;
//            }
//            @Override
//            public void afterTextChanged(Editable s) {
//                outputView2.removeTextChangedListener(this);
//                String text = outputView2.getText().toString();
//                // important - not setText() - otherwise the keyboard would be reset after each type
//                outputView2.getText().clear();
//                outputView2.append(colorized_openbabel(text));
//                // place the cursor at the original position
//                outputView2.setSelection(startChanged+countChanged);
//                outputView2.addTextChangedListener(this);
//            }
//        });
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
        editText10.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText10.setTypeface(Typeface.MONOSPACE);
        editText10.addTextChangedListener(new TextWatcher() {
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
                editText10.removeTextChangedListener(this);
                String text = editText10.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText10.getText().clear();
                editText10.append(colorized_dftb(text));
                // place the cursor at the original position
                editText10.setSelection(startChanged+countChanged);
                editText10.addTextChangedListener(this);
            }
        });
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
        editText15.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText15.setTypeface(Typeface.MONOSPACE);
        editText15.addTextChangedListener(new TextWatcher() {
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
                editText15.removeTextChangedListener(this);
                String text = editText15.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText15.getText().clear();
                editText15.append(colorized_dftb(text));
                // place the cursor at the original position
                editText15.setSelection(startChanged+countChanged);
                editText15.addTextChangedListener(this);
            }
        });
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
                        outputView2.setText(colorized_openbabel(strX), EditText.BufferType.SPANNABLE);
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
                ObabelInput.setText(colorized_openbabel(str3), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc3);
    }

    public void outputI(final String strI) {
        Runnable procI = new Runnable() {
            public void run() {
                ITypeSwitch.setText(colorized_openbabel(strI), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procI);
    }

    public void outputO(final String strO) {
        Runnable procO = new Runnable() {
            public void run() {
                OTypeSwitch.setText(colorized_openbabel(strO), EditText.BufferType.SPANNABLE);
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
