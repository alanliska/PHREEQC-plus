package cz.p;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

public class Dftb extends MainActivity {

    private Handler handler = new Handler();


    private TextView Description;
    private TextView DftbLabel;
    private EditText DftbInput;
    Button openInputfile;
    Button openIntInputfile;
    Button saveInputfile;
    Button saveExtInputfile;
    Button generateXYZ;
    Button opsinXYZ;
    Button RunDftb;
    Button saveOutputfile;
    Button saveExtOutputfile;
    Button Highlight;
    Button Spectrum;
    Button Quit;
    private TextView textViewX;
    private TextView outputView;
    private EditText outputView2;
    private static final int READ_FILE5 = 5;
    private Uri documentUri5;
    private static final int CREATE_FILE40 = 40;
    private Uri documentUri40;
    private static final int CREATE_FILE41 = 41;
    private Uri documentUri41;
    Button manual_dftb;
    Button recipes_dftb;


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
        setContentView(R.layout.dftb);

        DftbLabel = (TextView) findViewById(R.id.DftbLabel);
        DftbInput = (EditText) findViewById(R.id.DftbInput);
        openInputfile = (Button) findViewById(R.id.openInputfile);
        openInputfile.setOnClickListener(openInputfileClick);
        openIntInputfile = (Button) findViewById(R.id.openIntInputfile);
        saveInputfile = (Button) findViewById(R.id.saveInputfile);
        saveInputfile.setOnClickListener(saveInputfileClick);
        saveExtInputfile = (Button) findViewById(R.id.saveExtInputfile);
        saveExtInputfile.setOnClickListener(saveExtInputfileClick);
        generateXYZ = (Button) findViewById(R.id.generateXYZ);
        generateXYZ.setOnClickListener(GenerateXYZClick);
        opsinXYZ = (Button) findViewById(R.id.opsinXYZ);
        opsinXYZ.setOnClickListener(opsinXYZClick);
        RunDftb = (Button) findViewById(R.id.RunDftb);
        RunDftb.setOnClickListener(RunDftbClick);
        saveOutputfile = (Button) findViewById(R.id.saveOutputfile);
        saveOutputfile.setOnClickListener(saveOutputfileClick);
        saveExtOutputfile = (Button) findViewById(R.id.saveExtOutputfile);
        saveExtOutputfile.setOnClickListener(saveExtOutputfileClick);
        Highlight = (Button) findViewById(R.id.Highlight);
        Highlight.setOnClickListener(HighlightClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        Spectrum = (Button) findViewById(R.id.Spectrum);
        Spectrum.setOnClickListener(SpectrumClick);
        textViewX = (TextView) findViewById(R.id.textViewX);
        outputView = (TextView) findViewById(R.id.outputView);
        outputView2 = (EditText) findViewById(R.id.outputView2);

        manual_dftb = (Button) findViewById(R.id.manual_dftb);
        manual_dftb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dftb.this, ManualDftb.class);
                startActivity(intent);
            }
        });

        recipes_dftb = (Button) findViewById(R.id.recipes_dftb);
        recipes_dftb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dftb.this, ManualDftbRecipes.class);
                startActivity(intent);
            }
        });

        openIntInputfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dftb.this, DftbWork.class);
                startActivity(intent);
            }
        });

    }


    public void onStart()
    {
        super.onStart();

        output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
    }

    private View.OnClickListener SpectrumClick; {

        SpectrumClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = DftbInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-dftb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SpectrumDFTB.b "+getFilesDir()+"/SpectrumDFTB.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/SpectrumDFTB.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SpectrumDFTB.b");
                    exec("rm "+getFilesDir()+"/dftb/EXC.DAT");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Dftb.this, SpectrumDFTB.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener GenerateXYZClick; {

        GenerateXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = DftbInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-dftb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertGenerateXYZ();
                output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
            }
        };
    }


    public void alertGenerateXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(Dftb.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Dftb.this)
                .setMessage("Input the SMILES string and convert it to XYZ. The result will be appended to the actual input file.")
                .setTitle("OpenBABEL conversion")
                .setView(editText100)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String SmilesString = editText100.getText().toString();
//                        String InputFile = DftbInput.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput("temp.smi", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(SmilesString);
                            outputWriter.close();

                            String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+"/temp.smi -oxyz --gen3d");
                            FileOutputStream fileout4 = openFileOutput("Input-dftb.txt", MODE_APPEND);
                            OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
//                            outputWriter4.write(InputFile);
                            outputWriter4.write("\n");
                            outputWriter4.write(ObabelOutput);
                            outputWriter4.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
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
        editText100.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

    private View.OnClickListener opsinXYZClick; {

        opsinXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = DftbInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-dftb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertOpsinXYZ();
                output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
            }
        };
    }


    public void alertOpsinXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(Dftb.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Dftb.this)
                .setMessage("Input the IUPAC name and convert it to XYZ. The result will be appended to the actual input file.")
                .setTitle("OPSIN+OpenBABEL conversion")
                .setView(editText100)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String SmilesString = editText100.getText().toString();
//                        String InputFile = DftbInput.getText().toString();
                        try {
                            ////////////////////////////////////
                            NameToStructure nts = NameToStructure.getInstance();
                            NameToStructureConfig ntsconfig = new NameToStructureConfig();
//a new NameToStructureConfig starts as a copy of OPSIN's default configuration
                            ntsconfig.setAllowRadicals(true);
//                OpsinResult result = nts.parseChemicalName("acetamide", ntsconfig);
                            OpsinResult result = nts.parseChemicalName(SmilesString+"", ntsconfig);
                            String smiles = result.getSmiles();
                            /////////////////////////////////////
                            FileOutputStream fileout3 = openFileOutput("temp.smi", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(smiles);
                            outputWriter3.close();


                            String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+"/temp.smi -oxyz --gen3d");
                            FileOutputStream fileout4 = openFileOutput("Input-dftb.txt", MODE_APPEND);
                            OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
//                            outputWriter4.write(InputFile);
                            outputWriter4.write("\n");
                            outputWriter4.write(ObabelOutput);
                            outputWriter4.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
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
        editText100.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }


    private View.OnClickListener openInputfileClick; {

        openInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read5(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
            }
        };
    }

    private View.OnClickListener saveExtInputfileClick; {

        saveExtInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                write1(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
            }
        };
    }

    private View.OnClickListener saveExtOutputfileClick; {

        saveExtOutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                write2(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
            }
        };
    }

    private void read5(Context context5) {
        Intent intent5 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent5.addCategory(Intent.CATEGORY_OPENABLE);
        intent5.setType("text/plain");
        startActivityForResult(intent5, READ_FILE5);
    }

    private void write1(Context context1) {
        Intent intent1 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        intent1.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent1, CREATE_FILE40);
    }

    private void write2(Context context2) {
        Intent intent2 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent2.addCategory(Intent.CATEGORY_OPENABLE);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TITLE,"MyOutputFile");
        startActivityForResult(intent2, CREATE_FILE41);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE5 && data != null) {
            try {
                documentUri5 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd5 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd5.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("Input-dftb.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd5.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE40 && data != null) {
            // save input file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri40 = data.getData();
                ParcelFileDescriptor pfd40 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd40.getFileDescriptor());
                String fileContents = DftbInput.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd40.close();
                FileOutputStream fileout = openFileOutput("Input-dftb.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE41 && data != null) {
            // save output file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri41 = data.getData();
                ParcelFileDescriptor pfd41 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd41.getFileDescriptor());
                String fileContents = outputView2.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd41.close();
                FileOutputStream fileout = openFileOutput("Input.log", MODE_PRIVATE);
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
                String Inputfile = DftbInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-dftb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveInput();
                output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
            }
        };
    }


    public void alertSaveInput(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Dftb.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Dftb.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/dftb")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = DftbInput.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/dftb");
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


    private View.OnClickListener RunDftbClick; {

        RunDftbClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = DftbInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-dftb.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
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
        progressDialog = new ProgressDialog(Dftb.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Calculation is running...");
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
                    exec("cp "+getFilesDir()+"/Input-dftb.txt "+getFilesDir()+"/dftb/dftb_in.hsd");

                    FileOutputStream fileout2 = openFileOutput("OUTPUTFILE", MODE_PRIVATE);
                        OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                        // nevim, proc nejde:
//                        outputWriter2.write(exec("env LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/"+getFilesDir()+"/ "+getApplicationInfo().nativeLibraryDir+"/libdftb.so"));
                        outputWriter2.write(exec(getApplicationInfo().nativeLibraryDir+"/libdftb.so"));
                        outputWriter2.close();

//                    ProcessBuilder pb =
//                            new ProcessBuilder(exec(getApplicationInfo().nativeLibraryDir+"/libdftb.so"));
//                    Map<String, String> env = pb.environment();
////                    env.put("LD_LIBRARY_PATH", "$LD_LIBRARY_PATH:/"+getApplicationInfo().nativeLibraryDir+"/c");
////                    env.put("LD_LIBRARY_PATH", "$LD_LIBRARY_PATH:/"+getApplicationInfo().nativeLibraryDir+"/m");
//                    env.put("LD_LIBRARY_PATH", "$LD_LIBRARY_PATH:/"+getApplicationInfo().nativeLibraryDir+"/iconv");
////                    env.put("LD_LIBRARY_PATH", "$LD_LIBRARY_PATH:/"+getApplicationInfo().nativeLibraryDir+"/gfortran");
//                    env.put("LD_LIBRARY_PATH", "$LD_LIBRARY_PATH:/"+getApplicationInfo().nativeLibraryDir+"/gfortran.so.5");
////                    env.put("LD_LIBRARY_PATH", "$LD_LIBRARY_PATH:/"+getApplicationInfo().nativeLibraryDir+"/gfortran.so.5.0.0");
////                    env.put("LD_LIBRARY_PATH", "$LD_LIBRARY_PATH:/"+getApplicationInfo().nativeLibraryDir+"/dl");
////                    env.remove("OTHERVAR");
////                    env.put("VAR2", env.get("VAR1") + "suffix");
//                    pb.directory(new File(getFilesDir()+"/dftb"));
//                    File log = new File(getFilesDir()+"/OUTPUTFILE");
//                    pb.redirectErrorStream(true);
//                    pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
//                    Process p = pb.start();
//                    assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
//                    assert pb.redirectOutput().file() == log;
//                    assert p.getInputStream().read() == -1;

//                    try {
//                        FileOutputStream fileout2 = openFileOutput("OUTPUTFILE", MODE_PRIVATE);
//                        OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
//                        // nevim, proc nejde:
////                        outputWriter2.write(exec("env CP2K_DATA_DIR="+getFilesDir()+"/basis "+getApplicationInfo().nativeLibraryDir+"/cp2k "+getFilesDir()+"/temporary/Input"));
//                        outputWriter2.write(exec(getApplicationInfo().nativeLibraryDir+"/cp2k "+getFilesDir()+"/temporary/Input"));
//                        outputWriter2.close();
//
                        File file_orig = new File(getFilesDir()+"/OUTPUTFILE");
                        File file1 = new File(getFilesDir()+"/dftb/autotest.tag");
                        if (file1.exists())  {
                            FileWriter fw = new FileWriter(file_orig, true);
                            //BufferedWriter writer give better performance
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(" \n");
                            bw.write(">> Reading from file autotest.tag: \n");
                            bw.write(" \n");
                            //Closing BufferedWriter Stream
                            bw.close();

                            // PrintWriter object for file3.txt
                            PrintWriter pw = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                            // BufferedReader object for file1.txt
                            BufferedReader br = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                            String line = br.readLine();
                            // loop to copy each line of
                            // file1.txt to  file3.txt
                            while (line != null)
                            {
                                pw.println(line);
                                line = br.readLine();
                            }
                            br = new BufferedReader(new FileReader(file1));
                            line = br.readLine();
                            // loop to copy each line of
                            // file2.txt to  file3.txt
                            while(line != null)
                            {
                                pw.println(line);
                                line = br.readLine();
                            }
                            pw.flush();
                            // closing resources
                            br.close();
                            pw.close();

                            exec("rm "+getFilesDir()+"/OUTPUTFILE");
                            exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");

                        }


                        File file_orig2 = new File(getFilesDir()+"/OUTPUTFILE");
                        File file2 = new File(getFilesDir()+"/dftb/band.out");
                        if (file2.exists())  {
                            FileWriter fw2 = new FileWriter(file_orig2, true);
                            //BufferedWriter writer give better performance
                            BufferedWriter bw2 = new BufferedWriter(fw2);
                            bw2.write(" \n");
                            bw2.write(">> Reading from file band.out: \n");
                            bw2.write(" \n");
                            //Closing BufferedWriter Stream
                            bw2.close();

                            // PrintWriter object for file3.txt
                            PrintWriter pw2 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                            // BufferedReader object for file1.txt
                            BufferedReader br2 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                            String line2 = br2.readLine();
                            // loop to copy each line of
                            // file1.txt to  file3.txt
                            while (line2 != null)
                            {
                                pw2.println(line2);
                                line2 = br2.readLine();
                            }
                            br2 = new BufferedReader(new FileReader(file2));
                            line2 = br2.readLine();
                            // loop to copy each line of
                            // file2.txt to  file3.txt
                            while(line2 != null)
                            {
                                pw2.println(line2);
                                line2 = br2.readLine();
                            }
                            pw2.flush();
                            // closing resources
                            br2.close();
                            pw2.close();

                            exec("rm "+getFilesDir()+"/OUTPUTFILE");
                            exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");

                        }



                        File file_orig3 = new File(getFilesDir()+"/OUTPUTFILE");
                        File file3 = new File(getFilesDir()+"/dftb/detailed.out");
                        if (file3.exists())  {
                            FileWriter fw3 = new FileWriter(file_orig3, true);
                            //BufferedWriter writer give better performance
                            BufferedWriter bw3 = new BufferedWriter(fw3);
                            bw3.write(" \n");
                            bw3.write(">> Reading from file detailed.out: \n");
                            bw3.write(" \n");
                            //Closing BufferedWriter Stream
                            bw3.close();

                            // PrintWriter object for file3.txt
                            PrintWriter pw3 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                            // BufferedReader object for file1.txt
                            BufferedReader br3 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                            String line3 = br3.readLine();
                            // loop to copy each line of
                            // file1.txt to  file3.txt
                            while (line3 != null)
                            {
                                pw3.println(line3);
                                line3 = br3.readLine();
                            }
                            br3 = new BufferedReader(new FileReader(file3));
                            line3 = br3.readLine();
                            // loop to copy each line of
                            // file2.txt to  file3.txt
                            while(line3 != null)
                            {
                                pw3.println(line3);
                                line3 = br3.readLine();
                            }
                            pw3.flush();
                            // closing resources
                            br3.close();
                            pw3.close();

                            exec("rm "+getFilesDir()+"/OUTPUTFILE");
                            exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");

                        }

                        File file_orig4 = new File(getFilesDir()+"/OUTPUTFILE");
                        File file4 = new File(getFilesDir()+"/dftb/results.tag");
                        if (file4.exists())  {
                            FileWriter fw4 = new FileWriter(file_orig4, true);
                            //BufferedWriter writer give better performance
                            BufferedWriter bw4 = new BufferedWriter(fw4);
                            bw4.write(" \n");
                            bw4.write(">> Reading from file results.tag: \n");
                            bw4.write(" \n");
                            //Closing BufferedWriter Stream
                            bw4.close();

                            // PrintWriter object for file3.txt
                            PrintWriter pw4 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                            // BufferedReader object for file1.txt
                            BufferedReader br4 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                            String line4 = br4.readLine();
                            // loop to copy each line of
                            // file1.txt to  file3.txt
                            while (line4 != null)
                            {
                                pw4.println(line4);
                                line4 = br4.readLine();
                            }
                            br4 = new BufferedReader(new FileReader(file4));
                            line4 = br4.readLine();
                            // loop to copy each line of
                            // file2.txt to  file3.txt
                            while(line4 != null)
                            {
                                pw4.println(line4);
                                line4 = br4.readLine();
                            }
                            pw4.flush();
                            // closing resources
                            br4.close();
                            pw4.close();

                            exec("rm "+getFilesDir()+"/OUTPUTFILE");
                            exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");

                        }


                        File file_orig5 = new File(getFilesDir()+"/OUTPUTFILE");
                        File file5 = new File(getFilesDir()+"/dftb/hamsqrN.dat");
                        if (file5.exists())  {
                            FileWriter fw5 = new FileWriter(file_orig5, true);
                            //BufferedWriter writer give better performance
                            BufferedWriter bw5 = new BufferedWriter(fw5);
                            bw5.write(" \n");
                            bw5.write(">> Reading from file hamsqrN.dat: \n");
                            bw5.write(" \n");
                            //Closing BufferedWriter Stream
                            bw5.close();

                            // PrintWriter object for file3.txt
                            PrintWriter pw5 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                            // BufferedReader object for file1.txt
                            BufferedReader br5 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                            String line5 = br5.readLine();
                            // loop to copy each line of
                            // file1.txt to  file3.txt
                            while (line5 != null)
                            {
                                pw5.println(line5);
                                line5 = br5.readLine();
                            }
                            br5 = new BufferedReader(new FileReader(file5));
                            line5 = br5.readLine();
                            // loop to copy each line of
                            // file2.txt to  file3.txt
                            while(line5 != null)
                            {
                                pw5.println(line5);
                                line5 = br5.readLine();
                            }
                            pw5.flush();
                            // closing resources
                            br5.close();
                            pw5.close();

                            exec("rm "+getFilesDir()+"/OUTPUTFILE");
                            exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");

                        }

                        File file_orig6 = new File(getFilesDir()+"/OUTPUTFILE");
                        File file6 = new File(getFilesDir()+"/dftb/oversqr.dat");
                        if (file6.exists())  {
                            FileWriter fw6 = new FileWriter(file_orig6, true);
                            //BufferedWriter writer give better performance
                            BufferedWriter bw6 = new BufferedWriter(fw6);
                            bw6.write(" \n");
                            bw6.write(">> Reading from file oversqr.dat: \n");
                            bw6.write(" \n");
                            //Closing BufferedWriter Stream
                            bw6.close();

                            // PrintWriter object for file3.txt
                            PrintWriter pw6 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                            // BufferedReader object for file1.txt
                            BufferedReader br6 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                            String line6 = br6.readLine();
                            // loop to copy each line of
                            // file1.txt to  file3.txt
                            while (line6 != null)
                            {
                                pw6.println(line6);
                                line6 = br6.readLine();
                            }
                            br6 = new BufferedReader(new FileReader(file6));
                            line6 = br6.readLine();
                            // loop to copy each line of
                            // file2.txt to  file3.txt
                            while(line6 != null)
                            {
                                pw6.println(line6);
                                line6 = br6.readLine();
                            }
                            pw6.flush();
                            // closing resources
                            br6.close();
                            pw6.close();

                            exec("rm "+getFilesDir()+"/OUTPUTFILE");
                            exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");

                        }

                        File file_orig7 = new File(getFilesDir()+"/OUTPUTFILE");
                        File file7 = new File(getFilesDir()+"/dftb/hamrealN.dat");
                        if (file7.exists())  {
                            FileWriter fw7 = new FileWriter(file_orig7, true);
                            //BufferedWriter writer give better performance
                            BufferedWriter bw7 = new BufferedWriter(fw7);
                            bw7.write(" \n");
                            bw7.write(">> Reading from file hamrealN.dat: \n");
                            bw7.write(" \n");
                            //Closing BufferedWriter Stream
                            bw7.close();

                            // PrintWriter object for file3.txt
                            PrintWriter pw7 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                            // BufferedReader object for file1.txt
                            BufferedReader br7 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                            String line7 = br7.readLine();
                            // loop to copy each line of
                            // file1.txt to  file3.txt
                            while (line7 != null)
                            {
                                pw7.println(line7);
                                line7 = br7.readLine();
                            }
                            br7 = new BufferedReader(new FileReader(file7));
                            line7 = br7.readLine();
                            // loop to copy each line of
                            // file2.txt to  file3.txt
                            while(line7 != null)
                            {
                                pw7.println(line7);
                                line7 = br7.readLine();
                            }
                            pw7.flush();
                            // closing resources
                            br7.close();
                            pw7.close();

                            exec("rm "+getFilesDir()+"/OUTPUTFILE");
                            exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");

                        }

                        File file_orig8 = new File(getFilesDir()+"/OUTPUTFILE");
                        File file8 = new File(getFilesDir()+"/dftb/overreal.dat");
                        if (file8.exists())  {
                            FileWriter fw8 = new FileWriter(file_orig8, true);
                            //BufferedWriter writer give better performance
                            BufferedWriter bw8 = new BufferedWriter(fw8);
                            bw8.write(" \n");
                            bw8.write(">> Reading from file overreal.dat: \n");
                            bw8.write(" \n");
                            //Closing BufferedWriter Stream
                            bw8.close();

                            // PrintWriter object for file3.txt
                            PrintWriter pw8 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                            // BufferedReader object for file1.txt
                            BufferedReader br8 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                            String line8 = br8.readLine();
                            // loop to copy each line of
                            // file1.txt to  file3.txt
                            while (line8 != null)
                            {
                                pw8.println(line8);
                                line8 = br8.readLine();
                            }
                            br8 = new BufferedReader(new FileReader(file8));
                            line8 = br8.readLine();
                            // loop to copy each line of
                            // file2.txt to  file3.txt
                            while(line8 != null)
                            {
                                pw8.println(line8);
                                line8 = br8.readLine();
                            }
                            pw8.flush();
                            // closing resources
                            br8.close();
                            pw8.close();

                            exec("rm "+getFilesDir()+"/OUTPUTFILE");
                            exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");

                        }

                        File file_orig9 = new File(getFilesDir()+"/OUTPUTFILE");
                        File file9 = new File(getFilesDir()+"/dftb/eigenvec.out");
                        if (file9.exists())  {
                            FileWriter fw9 = new FileWriter(file_orig9, true);
                            //BufferedWriter writer give better performance
                            BufferedWriter bw9 = new BufferedWriter(fw9);
                            bw9.write(" \n");
                            bw9.write(">> Reading from file eigenvec.out: \n");
                            bw9.write(" \n");
                            //Closing BufferedWriter Stream
                            bw9.close();

                            // PrintWriter object for file3.txt
                            PrintWriter pw9 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                            // BufferedReader object for file1.txt
                            BufferedReader br9 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                            String line9 = br9.readLine();
                            // loop to copy each line of
                            // file1.txt to  file3.txt
                            while (line9 != null)
                            {
                                pw9.println(line9);
                                line9 = br9.readLine();
                            }
                            br9 = new BufferedReader(new FileReader(file9));
                            line9 = br9.readLine();
                            // loop to copy each line of
                            // file2.txt to  file3.txt
                            while(line9 != null)
                            {
                                pw9.println(line9);
                                line9 = br9.readLine();
                            }
                            pw9.flush();
                            // closing resources
                            br9.close();
                            pw9.close();

                            exec("rm "+getFilesDir()+"/OUTPUTFILE");
                            exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");

                        }

                        File file_orig10 = new File(getFilesDir()+"/OUTPUTFILE");
                        File file10 = new File(getFilesDir()+"/dftb/eigenvec.bin");
                        if (file10.exists())  {
                            FileWriter fw10 = new FileWriter(file_orig10, true);
                            //BufferedWriter writer give better performance
                            BufferedWriter bw10 = new BufferedWriter(fw10);
                            bw10.write(" \n");
                            bw10.write(">> Reading from file eigenvec.bin: \n");
                            bw10.write(" \n");
                            //Closing BufferedWriter Stream
                            bw10.close();

                            // PrintWriter object for file3.txt
                            PrintWriter pw10 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                            // BufferedReader object for file1.txt
                            BufferedReader br10 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                            String line10 = br10.readLine();
                            // loop to copy each line of
                            // file1.txt to  file3.txt
                            while (line10 != null)
                            {
                                pw10.println(line10);
                                line10 = br10.readLine();
                            }
                            br10 = new BufferedReader(new FileReader(file10));
                            line10 = br10.readLine();
                            // loop to copy each line of
                            // file2.txt to  file3.txt
                            while(line10 != null)
                            {
                                pw10.println(line10);
                                line10 = br10.readLine();
                            }
                            pw10.flush();
                            // closing resources
                            br10.close();
                            pw10.close();

                            exec("rm "+getFilesDir()+"/OUTPUTFILE");
                            exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                        }

                    File file_orig10a = new File(getFilesDir()+"/OUTPUTFILE");
                    File file10a = new File(getFilesDir()+"/dftb/eigenvec.bin");
                    if (file10a.exists())  {
                        FileWriter fw10a = new FileWriter(file_orig10a, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw10a = new BufferedWriter(fw10a);
                        bw10a.write(" \n");
                        bw10a.write(">> Reading from file eigenvec.bin: \n");
                        bw10a.write(" \n");
                        //Closing BufferedWriter Stream
                        bw10a.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw10a = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br10a = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line10a = br10a.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line10a != null)
                        {
                            pw10a.println(line10a);
                            line10a = br10a.readLine();
                        }
                        br10a = new BufferedReader(new FileReader(file10a));
                        line10a = br10a.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line10a != null)
                        {
                            pw10a.println(line10a);
                            line10a = br10a.readLine();
                        }
                        pw10a.flush();
                        // closing resources
                        br10a.close();
                        pw10a.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig11 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file11 = new File(getFilesDir()+"/dftb/charges.bin");
                    if (file11.exists())  {
                        FileWriter fw11 = new FileWriter(file_orig11, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw11 = new BufferedWriter(fw11);
                        bw11.write(" \n");
                        bw11.write(">> Reading from file charges.bin: \n");
                        bw11.write(" \n");
                        //Closing BufferedWriter Stream
                        bw11.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw11 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br11 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line11 = br11.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line11 != null)
                        {
                            pw11.println(line11);
                            line11 = br11.readLine();
                        }
                        br11 = new BufferedReader(new FileReader(file11));
                        line11 = br11.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line11 != null)
                        {
                            pw11.println(line11);
                            line11 = br11.readLine();
                        }
                        pw11.flush();
                        // closing resources
                        br11.close();
                        pw11.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig12 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file12 = new File(getFilesDir()+"/dftb/charges.dat");
                    if (file12.exists())  {
                        FileWriter fw12 = new FileWriter(file_orig12, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw12 = new BufferedWriter(fw12);
                        bw12.write(" \n");
                        bw12.write(">> Reading from file charges.dat: \n");
                        bw12.write(" \n");
                        //Closing BufferedWriter Stream
                        bw12.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw12 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br12 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line12 = br12.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line12 != null)
                        {
                            pw12.println(line12);
                            line12 = br12.readLine();
                        }
                        br12 = new BufferedReader(new FileReader(file12));
                        line12 = br12.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line12 != null)
                        {
                            pw12.println(line12);
                            line12 = br12.readLine();
                        }
                        pw12.flush();
                        // closing resources
                        br12.close();
                        pw12.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig13 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file13 = new File(getFilesDir()+"/dftb/md.out");
                    if (file13.exists())  {
                        FileWriter fw13 = new FileWriter(file_orig13, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw13 = new BufferedWriter(fw13);
                        bw13.write(" \n");
                        bw13.write(">> Reading from file md.out: \n");
                        bw13.write(" \n");
                        //Closing BufferedWriter Stream
                        bw13.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw13 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br13 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line13 = br13.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line13 != null)
                        {
                            pw13.println(line13);
                            line13 = br13.readLine();
                        }
                        br13 = new BufferedReader(new FileReader(file13));
                        line13 = br13.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line13 != null)
                        {
                            pw13.println(line13);
                            line13 = br13.readLine();
                        }
                        pw13.flush();
                        // closing resources
                        br13.close();
                        pw13.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig14 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file14 = new File(getFilesDir()+"/dftb/ARPACK.DAT");
                    if (file14.exists())  {
                        FileWriter fw14 = new FileWriter(file_orig14, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw14 = new BufferedWriter(fw14);
                        bw14.write(" \n");
                        bw14.write(">> Reading from file ARPACK.DAT: \n");
                        bw14.write(" \n");
                        //Closing BufferedWriter Stream
                        bw14.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw14 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br14 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line14 = br14.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line14 != null)
                        {
                            pw14.println(line14);
                            line14 = br14.readLine();
                        }
                        br14 = new BufferedReader(new FileReader(file14));
                        line14 = br14.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line14 != null)
                        {
                            pw14.println(line14);
                            line14 = br14.readLine();
                        }
                        pw14.flush();
                        // closing resources
                        br14.close();
                        pw14.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig15 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file15 = new File(getFilesDir()+"/dftb/COEF.DAT");
                    if (file15.exists())  {
                        FileWriter fw15 = new FileWriter(file_orig15, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw15 = new BufferedWriter(fw15);
                        bw15.write(" \n");
                        bw15.write(">> Reading from file COEF.DAT: \n");
                        bw15.write(" \n");
                        //Closing BufferedWriter Stream
                        bw15.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw15 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br15 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line15 = br15.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line15 != null)
                        {
                            pw15.println(line15);
                            line15 = br15.readLine();
                        }
                        br15 = new BufferedReader(new FileReader(file15));
                        line15 = br15.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line15 != null)
                        {
                            pw15.println(line15);
                            line15 = br15.readLine();
                        }
                        pw15.flush();
                        // closing resources
                        br15.close();
                        pw15.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig16 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file16 = new File(getFilesDir()+"/dftb/EXC.DAT");
                    if (file16.exists())  {
                        FileWriter fw16 = new FileWriter(file_orig16, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw16 = new BufferedWriter(fw16);
                        bw16.write(" \n");
                        bw16.write(">> Reading from file EXC.DAT: \n");
                        bw16.write(" \n");
                        //Closing BufferedWriter Stream
                        bw16.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw16 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br16 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line16 = br16.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line16 != null)
                        {
                            pw16.println(line16);
                            line16 = br16.readLine();
                        }
                        br16 = new BufferedReader(new FileReader(file16));
                        line16 = br16.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line16 != null)
                        {
                            pw16.println(line16);
                            line16 = br16.readLine();
                        }
                        pw16.flush();
                        // closing resources
                        br16.close();
                        pw16.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig17 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file17 = new File(getFilesDir()+"/dftb/SPX.DAT");
                    if (file17.exists())  {
                        FileWriter fw17 = new FileWriter(file_orig17, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw17 = new BufferedWriter(fw17);
                        bw17.write(" \n");
                        bw17.write(">> Reading from file SPX.DAT: \n");
                        bw17.write(" \n");
                        //Closing BufferedWriter Stream
                        bw17.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw17 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br17 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line17 = br17.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line17 != null)
                        {
                            pw17.println(line17);
                            line17 = br17.readLine();
                        }
                        br17 = new BufferedReader(new FileReader(file17));
                        line17 = br17.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line17 != null)
                        {
                            pw17.println(line17);
                            line17 = br17.readLine();
                        }
                        pw17.flush();
                        // closing resources
                        br17.close();
                        pw17.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig18 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file18 = new File(getFilesDir()+"/dftb/TDP.DAT");
                    if (file18.exists())  {
                        FileWriter fw18 = new FileWriter(file_orig18, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw18 = new BufferedWriter(fw18);
                        bw18.write(" \n");
                        bw18.write(">> Reading from file TDP.DAT: \n");
                        bw18.write(" \n");
                        //Closing BufferedWriter Stream
                        bw18.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw18 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br18 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line18 = br18.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line18 != null)
                        {
                            pw18.println(line18);
                            line18 = br18.readLine();
                        }
                        br18 = new BufferedReader(new FileReader(file18));
                        line18 = br18.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line18 != null)
                        {
                            pw18.println(line18);
                            line18 = br18.readLine();
                        }
                        pw18.flush();
                        // closing resources
                        br18.close();
                        pw18.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig19 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file19 = new File(getFilesDir()+"/dftb/TRA.DAT");
                    if (file19.exists())  {
                        FileWriter fw19 = new FileWriter(file_orig19, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw19 = new BufferedWriter(fw19);
                        bw19.write(" \n");
                        bw19.write(">> Reading from file TRA.DAT: \n");
                        bw19.write(" \n");
                        //Closing BufferedWriter Stream
                        bw19.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw19 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br19 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line19 = br19.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line19 != null)
                        {
                            pw19.println(line19);
                            line19 = br19.readLine();
                        }
                        br19 = new BufferedReader(new FileReader(file19));
                        line19 = br19.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line19 != null)
                        {
                            pw19.println(line19);
                            line19 = br19.readLine();
                        }
                        pw19.flush();
                        // closing resources
                        br19.close();
                        pw19.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig20 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file20 = new File(getFilesDir()+"/dftb/TEST_ARPACK.DAT");
                    if (file20.exists())  {
                        FileWriter fw20 = new FileWriter(file_orig20, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw20 = new BufferedWriter(fw20);
                        bw20.write(" \n");
                        bw20.write(">> Reading from file TEST_ARPACK.DAT: \n");
                        bw20.write(" \n");
                        //Closing BufferedWriter Stream
                        bw20.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw20 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br20 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line20 = br20.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line20 != null)
                        {
                            pw20.println(line20);
                            line20 = br20.readLine();
                        }
                        br20 = new BufferedReader(new FileReader(file20));
                        line20 = br20.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line20 != null)
                        {
                            pw20.println(line20);
                            line20 = br20.readLine();
                        }
                        pw20.flush();
                        // closing resources
                        br20.close();
                        pw20.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig21 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file21 = new File(getFilesDir()+"/dftb/XCH.DAT");
                    if (file21.exists())  {
                        FileWriter fw21 = new FileWriter(file_orig21, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw21 = new BufferedWriter(fw21);
                        bw21.write(" \n");
                        bw21.write(">> Reading from file XCH.DAT: \n");
                        bw21.write(" \n");
                        //Closing BufferedWriter Stream
                        bw21.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw21 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br21 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line21 = br21.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line21 != null)
                        {
                            pw21.println(line21);
                            line21 = br21.readLine();
                        }
                        br21 = new BufferedReader(new FileReader(file21));
                        line21 = br21.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line21 != null)
                        {
                            pw21.println(line21);
                            line21 = br21.readLine();
                        }
                        pw21.flush();
                        // closing resources
                        br21.close();
                        pw21.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig22 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file22 = new File(getFilesDir()+"/dftb/XplusY.DAT");
                    if (file22.exists())  {
                        FileWriter fw22 = new FileWriter(file_orig22, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw22 = new BufferedWriter(fw22);
                        bw22.write(" \n");
                        bw22.write(">> Reading from file XplusY.DAT: \n");
                        bw22.write(" \n");
                        //Closing BufferedWriter Stream
                        bw22.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw22 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br22 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line22 = br22.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line22 != null)
                        {
                            pw22.println(line22);
                            line22 = br22.readLine();
                        }
                        br22 = new BufferedReader(new FileReader(file22));
                        line22 = br22.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line22 != null)
                        {
                            pw22.println(line22);
                            line22 = br22.readLine();
                        }
                        pw22.flush();
                        // closing resources
                        br22.close();
                        pw22.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig23 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file23 = new File(getFilesDir()+"/dftb/XREST.DAT");
                    if (file23.exists())  {
                        FileWriter fw23 = new FileWriter(file_orig23, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw23 = new BufferedWriter(fw23);
                        bw23.write(" \n");
                        bw23.write(">> Reading from file XREST.DAT: \n");
                        bw23.write(" \n");
                        //Closing BufferedWriter Stream
                        bw23.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw23 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br23 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line23 = br23.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line23 != null)
                        {
                            pw23.println(line23);
                            line23 = br23.readLine();
                        }
                        br23 = new BufferedReader(new FileReader(file23));
                        line23 = br23.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line23 != null)
                        {
                            pw23.println(line23);
                            line23 = br23.readLine();
                        }
                        pw23.flush();
                        // closing resources
                        br23.close();
                        pw23.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig24 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file24 = new File(getFilesDir()+"/dftb/geo_end.gen");
                    if (file24.exists())  {
                        FileWriter fw24 = new FileWriter(file_orig24, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw24 = new BufferedWriter(fw24);
                        bw24.write(" \n");
                        bw24.write(">> Reading from file geo_end.gen: \n");
                        bw24.write(" \n");
                        //Closing BufferedWriter Stream
                        bw24.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw24 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br24 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line24 = br24.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line24 != null)
                        {
                            pw24.println(line24);
                            line24 = br24.readLine();
                        }
                        br24 = new BufferedReader(new FileReader(file24));
                        line24 = br24.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line24 != null)
                        {
                            pw24.println(line24);
                            line24 = br24.readLine();
                        }
                        pw24.flush();
                        // closing resources
                        br24.close();
                        pw24.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig25 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file25 = new File(getFilesDir()+"/dftb/geo_end.xyz");
                    if (file25.exists())  {
                        FileWriter fw25 = new FileWriter(file_orig25, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw25 = new BufferedWriter(fw25);
                        bw25.write(" \n");
                        bw25.write(">> Reading from file geo_end.xyz: \n");
                        bw25.write(" \n");
                        //Closing BufferedWriter Stream
                        bw25.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw25 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br25 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line25 = br25.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line25 != null)
                        {
                            pw25.println(line25);
                            line25 = br25.readLine();
                        }
                        br25 = new BufferedReader(new FileReader(file25));
                        line25 = br25.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line25 != null)
                        {
                            pw25.println(line25);
                            line25 = br25.readLine();
                        }
                        pw25.flush();
                        // closing resources
                        br25.close();
                        pw25.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    File file_orig26 = new File(getFilesDir()+"/OUTPUTFILE");
                    File file26 = new File(getFilesDir()+"/dftb/dftbp.cosmo");
                    if (file26.exists())  {
                        FileWriter fw26 = new FileWriter(file_orig26, true);
                        //BufferedWriter writer give better performance
                        BufferedWriter bw26 = new BufferedWriter(fw26);
                        bw26.write(" \n");
                        bw26.write(">> Reading from file dftbp.cosmo: \n");
                        bw26.write(" \n");
                        //Closing BufferedWriter Stream
                        bw26.close();

                        // PrintWriter object for file3.txt
                        PrintWriter pw26 = new PrintWriter(getFilesDir()+"/OUTPUTFILE3");
                        // BufferedReader object for file1.txt
                        BufferedReader br26 = new BufferedReader(new FileReader(getFilesDir()+"/OUTPUTFILE"));
                        String line26 = br26.readLine();
                        // loop to copy each line of
                        // file1.txt to  file3.txt
                        while (line26 != null)
                        {
                            pw26.println(line26);
                            line26 = br26.readLine();
                        }
                        br26 = new BufferedReader(new FileReader(file26));
                        line26 = br26.readLine();
                        // loop to copy each line of
                        // file2.txt to  file3.txt
                        while(line26 != null)
                        {
                            pw26.println(line26);
                            line26 = br26.readLine();
                        }
                        pw26.flush();
                        // closing resources
                        br26.close();
                        pw26.close();

                        exec("rm "+getFilesDir()+"/OUTPUTFILE");
                        exec("mv "+getFilesDir()+"/OUTPUTFILE3 "+getFilesDir()+"/OUTPUTFILE");
//
                    }

                    exec("rm "+getFilesDir()+"/dftb/band.out");
                    exec("rm "+getFilesDir()+"/dftb/detailed.out");
                    exec("rm "+getFilesDir()+"/dftb/results.tag");
                    exec("rm "+getFilesDir()+"/dftb/hamsqrN.dat");
                    exec("rm "+getFilesDir()+"/dftb/oversqr.dat");
                    exec("rm "+getFilesDir()+"/dftb/hamrealN.dat");
                    exec("rm "+getFilesDir()+"/dftb/overreal.dat");
                    exec("rm "+getFilesDir()+"/dftb/eigenvec.out");
                    exec("rm "+getFilesDir()+"/dftb/eigenvec.bin");
                    exec("rm "+getFilesDir()+"/dftb/charges.bin");
                    exec("rm "+getFilesDir()+"/dftb/charges.dat");
                    exec("rm "+getFilesDir()+"/dftb/md.out");
                    exec("rm "+getFilesDir()+"/dftb/ARPACK.DAT");
                    exec("rm "+getFilesDir()+"/dftb/COEF.DAT");
                    // do not delete - for plotting of the spectrum
//                    exec("rm "+getFilesDir()+"/dftb/EXC.DAT");
                    exec("rm "+getFilesDir()+"/dftb/SPX.DAT");
                    exec("rm "+getFilesDir()+"/dftb/TDP.DAT");
                    exec("rm "+getFilesDir()+"/dftb/TRA.DAT");
                    exec("rm "+getFilesDir()+"/dftb/TEST_ARPACK.DAT");
                    exec("rm "+getFilesDir()+"/dftb/XCH.DAT");
                    exec("rm "+getFilesDir()+"/dftb/XplusY.DAT");
                    exec("rm "+getFilesDir()+"/dftb/XREST.DAT");
                    exec("rm "+getFilesDir()+"/dftb/geo_end.gen");
                    exec("rm "+getFilesDir()+"/dftb/geo_end.xyz");
                    exec("rm "+getFilesDir()+"/dftb/dftb_pin.hsd");
                    exec("rm "+getFilesDir()+"/dftb/autotest.tag");
                    exec("rm "+getFilesDir()+"/dftb/dftbp.cosmo");


//
                        output2(exec("cat "+getFilesDir()+"/OUTPUTFILE"));
//                    } catch (Exception e) {
//                    }



                } catch (Exception e) {
                }
                onFinish();
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
                output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
            }
        };
    }





    public void alertSaveOutput(){
        // creating the EditText widget programatically
        EditText editText15 = new EditText(Dftb.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Dftb.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/dftb")
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
                        exec("mv "+getFilesDir()+"/"+SaveOutputName+" "+getFilesDir()+"/dftb");
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
        progressDialog = new ProgressDialog(Dftb.this);
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
                    outputX(exec("cat "+getFilesDir()+"/OUTPUTFILE"));
                    output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
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
                Intent intent = new Intent(Dftb.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


    @Override
    protected void onResume() {
        super.onResume();
        output3(exec("cat "+getFilesDir()+"/Input-dftb.txt"));
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                DftbInput.setText(str3);
            }
        };
        handler.post(proc3);
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
