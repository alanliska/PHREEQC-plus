package cz.p;

import static cz.p.Spannables.colorized_dftb;
import static cz.p.Spannables.colorized_numbers;
import static cz.p.Spannables.colorized_phreeqc;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import android.content.Context;
import android.util.Log;

import com.jrummyapps.android.shell.CommandResult;
import com.jrummyapps.android.shell.Shell;

public class Dftb extends MainActivity {

    private Handler handler = new Handler();
    private TextView ContentLabel;
    private EditText Content;
    private TextView CommandLabel;
    private EditText Command;
    Button openCommandfile;
    Button openIntCommandfile;
    Button saveCommandfile;
    Button saveExtCommandfile;
    private TextView InputLabel;
    private EditText InputFile;
    Button openInputfile;
    Button openIntInputfile;
    Button saveInputfile;
    Button saveExtInputfile;
    private TextView CoordLabel;
    private EditText CoordFile;
    Button openCoordfile;
    Button openIntCoordfile;
    Button saveCoordfile;
    Button saveExtCoordfile;
    Button generateXYZ;
    Button opsinXYZ;
    Button RunProgram;
    Button saveOutputfile;
    Button saveExtOutputfile;
    Button Highlight;
    Button Graph;
    Button Quit;

    private TextView textViewX;
    private TextView outputView;
    private EditText outputView2;
    private static final int READ_FILE6 = 6;
    private Uri documentUri6;
    private static final int READ_FILE26 = 26;
    private Uri documentUri26;
    private static final int CREATE_FILE20 = 20;
    private Uri documentUri20;
    private static final int CREATE_FILE01 = 1;
    private Uri documentUri0;
    private static final int CREATE_FILE21 = 21;
    private Uri documentUri21;
    private static final int READ_FILE60 = 60;
    private Uri documentUri60;
    private static final int CREATE_FILE200 = 200;
    private Uri documentUri200;
    Button manual_dftb;
    Button recipes_dftb;
    Button manual_modes;
    Button inToCanvas;
    Button outToCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dftb);

        ContentLabel = (TextView) findViewById(R.id.ContentLabel);
        Content = (EditText) findViewById(R.id.Content);
        Content.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/OutputTextSize.txt")).intValue());
        Content.setMovementMethod(new ScrollingMovementMethod());
        Content.addTextChangedListener(new TextWatcher() {
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
                Content.removeTextChangedListener(this);
                String text = Content.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Content.getText().clear();
                Content.append(colorized_dftb(text));
                // place the cursor at the original position
                Content.setSelection(startChanged+countChanged);
                Content.addTextChangedListener(this);
            }
        });
        CommandLabel = (TextView) findViewById(R.id.CommandLabel);
        Command = (EditText) findViewById(R.id.Command);
        Command.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        Command.addTextChangedListener(new TextWatcher() {
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
                Command.removeTextChangedListener(this);
                String text = Command.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Command.getText().clear();
                Command.append(colorized_dftb(text));
                // place the cursor at the original position
                Command.setSelection(startChanged+countChanged);
                Command.addTextChangedListener(this);
            }
        });
        openCommandfile = (Button) findViewById(R.id.openCommandfile);
        openCommandfile.setOnClickListener(openCommandfileClick);
        openIntCommandfile = (Button) findViewById(R.id.openIntCommandfile);
        saveCommandfile = (Button) findViewById(R.id.saveCommandfile);
        saveCommandfile.setOnClickListener(saveCommandfileClick);
        saveExtCommandfile = (Button) findViewById(R.id.saveExtCommandfile);
        saveExtCommandfile.setOnClickListener(saveExtCommandfileClick);
        InputLabel = (TextView) findViewById(R.id.InputLabel);
        InputFile = (EditText) findViewById(R.id.InputFile);
        InputFile.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        InputFile.addTextChangedListener(new TextWatcher() {
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
                InputFile.removeTextChangedListener(this);
                String text = InputFile.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                InputFile.getText().clear();
                InputFile.append(colorized_dftb(text));
                // place the cursor at the original position
                InputFile.setSelection(startChanged+countChanged);
                InputFile.addTextChangedListener(this);
            }
        });
        openInputfile = (Button) findViewById(R.id.openInputfile);
        openInputfile.setOnClickListener(openInputfileClick);
        openIntInputfile = (Button) findViewById(R.id.openIntInputfile);
        saveInputfile = (Button) findViewById(R.id.saveInputfile);
        saveInputfile.setOnClickListener(saveInputfileClick);
        saveExtInputfile = (Button) findViewById(R.id.saveExtInputfile);
        saveExtInputfile.setOnClickListener(saveExtInputfileClick);
        CoordLabel = (TextView) findViewById(R.id.CoordLabel);
        CoordFile = (EditText) findViewById(R.id.CoordFile);
        CoordFile.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        CoordFile.addTextChangedListener(new TextWatcher() {
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
                CoordFile.removeTextChangedListener(this);
                String text = CoordFile.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                CoordFile.getText().clear();
                CoordFile.append(colorized_dftb(text));
                // place the cursor at the original position
                CoordFile.setSelection(startChanged+countChanged);
                CoordFile.addTextChangedListener(this);
            }
        });
        openCoordfile = (Button) findViewById(R.id.openCoordfile);
        openCoordfile.setOnClickListener(openCoordfileClick);
        openIntCoordfile = (Button) findViewById(R.id.openIntCoordfile);
        saveCoordfile = (Button) findViewById(R.id.saveCoordfile);
        saveCoordfile.setOnClickListener(saveCoordfileClick);
        saveExtCoordfile = (Button) findViewById(R.id.saveExtCoordfile);
        saveExtCoordfile.setOnClickListener(saveExtCoordfileClick);
        generateXYZ = (Button) findViewById(R.id.generateXYZ);
        generateXYZ.setOnClickListener(GenerateXYZClick);
        opsinXYZ = (Button) findViewById(R.id.opsinXYZ);
        opsinXYZ.setOnClickListener(opsinXYZClick);
        RunProgram = (Button) findViewById(R.id.RunProgram);
        RunProgram.setOnClickListener(RunProgramClick);
        saveOutputfile = (Button) findViewById(R.id.saveOutputfile);
        saveOutputfile.setOnClickListener(saveOutputfileClick);
        saveExtOutputfile = (Button) findViewById(R.id.saveExtOutputfile);
        saveExtOutputfile.setOnClickListener(saveExtOutputfileClick);
        Highlight = (Button) findViewById(R.id.Highlight);
        Highlight.setOnClickListener(HighlightClick);
        textViewX = (TextView) findViewById(R.id.textViewX);
        outputView = (TextView) findViewById(R.id.outputView);
        outputView2 = (EditText) findViewById(R.id.outputView2);
        outputView2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/OutputTextSize.txt")).intValue());
        Graph = (Button) findViewById(R.id.Graph);
        Graph.setOnClickListener(GraphClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);

        manual_modes = (Button) findViewById(R.id.manual_modes);
        manual_modes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dftb.this, ManualModes.class);
                startActivity(intent);
            }
        });

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

        openIntCoordfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dftb.this, DftbWork1.class);
                startActivity(intent);
            }
        });

        openIntCommandfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dftb.this, DftbCommand.class);
                startActivity(intent);
            }
        });
        inToCanvas = (Button) findViewById(R.id.inToCanvas);
        inToCanvas.setOnClickListener(inToCanvasClick);
        outToCanvas = (Button) findViewById(R.id.outToCanvas);
        outToCanvas.setOnClickListener(outToCanvasClick);
    }

    public void onStart()
    {
        super.onStart();

        output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
        output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
        output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
        output(exec("ls -la "+getFilesDir()+"/dftb/"));
    }

    private View.OnClickListener GenerateXYZClick; {

        GenerateXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                alertGenerateXYZ();
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }


    public void alertGenerateXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(Dftb.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Dftb.this)
                .setMessage("Please write the SMILES string to be converted to XYZ. ")
                .setTitle("OpenBABEL conversion")
                .setView(editText100)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String SmilesString = editText100.getText().toString();
//                        String InputFile = MopacInput.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput("temp.smi", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(SmilesString);
                            outputWriter.close();

                            // String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+"/temp.smi -oxyz --gen3d");
			    com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi temp.smi -oxyz --gen3d > ObabelOutput.txt");
			    String ObabelOutput = exec("cat "+getFilesDir()+"/ObabelOutput.txt");

                            FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();


//                            String SedXyz = exec("sed -e 1,2d "+getFilesDir()+"/temp.xyz");

//                            FileOutputStream fileout4 = openFileOutput("dftb_in.hsd", MODE_APPEND);
//                            OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
////                            outputWriter4.write(InputFile);
//                            outputWriter4.write("\n");
//                            outputWriter4.write(SedXyz);
//                            outputWriter4.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
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
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                alertOpsinXYZ();
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }


    public void alertOpsinXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(Dftb.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Dftb.this)
                .setMessage("Please write the chemical name according to IUPAC to XYZ conversion. The result will be appended to the actual input file.")
                .setTitle("OPSIN+OpenBABEL conversion")
                .setView(editText100)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String SmilesString = editText100.getText().toString();
//                        String InputFile = MopacInput.getText().toString();
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
                            FileOutputStream fileout2 = openFileOutput("temp.smi", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(smiles);
                            outputWriter2.close();

                            // String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+"/temp.smi -oxyz --gen3d");
			    com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi temp.smi -oxyz --gen3d > ObabelOutput.txt");
			    String ObabelOutput = exec("cat "+getFilesDir()+"/ObabelOutput.txt");

                            FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();

//                            String SedXyz = exec("sed -e 1,2d "+getFilesDir()+"/temp.xyz");
//
//                            FileOutputStream fileout4 = openFileOutput("dftb_in.hsd", MODE_APPEND);
//                            OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
////                            outputWriter4.write(InputFile);
//                            outputWriter4.write("\n");
//                            outputWriter4.write(SedXyz);
//                            outputWriter4.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                        output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                        output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                        output(exec("ls -la "+getFilesDir()+"/dftb/"));
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

    private View.OnClickListener GraphClick; {

        GraphClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                Intent intent = new Intent(Dftb.this, SpectrumDftb.class);
                startActivity(intent);
            }
        };
    }


    private View.OnClickListener openInputfileClick; {

        openInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                read6(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }

    private View.OnClickListener openCoordfileClick; {

        openCoordfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                read26(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }

    private View.OnClickListener openCommandfileClick; {

        openCommandfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                read60(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }

    private View.OnClickListener saveExtInputfileClick; {

        saveExtInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                write1(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }

    private View.OnClickListener saveExtCoordfileClick; {

        saveExtCoordfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                write01(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }

    private View.OnClickListener saveExtCommandfileClick; {

        saveExtCommandfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                write10(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }

    private View.OnClickListener saveExtOutputfileClick; {

        saveExtOutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                write2(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }

    private void read6(Context context6) {
        Intent intent6 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent6.addCategory(Intent.CATEGORY_OPENABLE);
        intent6.setType("text/plain");
        startActivityForResult(intent6, READ_FILE6);
    }

    private void read26(Context context26) {
        Intent intent26 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent26.addCategory(Intent.CATEGORY_OPENABLE);
        intent26.setType("text/plain");
        startActivityForResult(intent26, READ_FILE26);
    }

    private void write1(Context context1) {
        Intent intent1 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        intent1.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent1, CREATE_FILE20);
    }

    private void write01(Context context01) {
        Intent intent01 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent01.addCategory(Intent.CATEGORY_OPENABLE);
        intent01.setType("text/plain");
        intent01.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent01, CREATE_FILE01);
    }

    private void write2(Context context2) {
        Intent intent2 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent2.addCategory(Intent.CATEGORY_OPENABLE);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TITLE,"MyOutputFile");
        startActivityForResult(intent2, CREATE_FILE21);
    }

    private void read60(Context context60) {
        Intent intent60 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent60.addCategory(Intent.CATEGORY_OPENABLE);
        intent60.setType("text/plain");
        startActivityForResult(intent60, READ_FILE60);
    }

    private void write10(Context context10) {
        Intent intent10 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent10.addCategory(Intent.CATEGORY_OPENABLE);
        intent10.setType("text/plain");
        intent10.putExtra(Intent.EXTRA_TITLE,"MyCommand");
        startActivityForResult(intent10, CREATE_FILE200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE6 && data != null) {
            try {
                documentUri6 = data.getData();
                String myData6 = "";
                ParcelFileDescriptor pfd6 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd6.getFileDescriptor());
                DataInputStream inp6 = new DataInputStream(fileInputStream);
                BufferedReader br6 = new BufferedReader(new InputStreamReader(inp6));
                String strLine6;
                while ((strLine6 = br6.readLine()) != null) {
                    myData6 = myData6 + strLine6 + "\n";
                }
                inp6.close();

                FileOutputStream fileout6 = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                outputWriter6.write(myData6);
                outputWriter6.close();
                fileInputStream.close();
                pfd6.close();
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE26 && data != null) {
            try {
                documentUri26 = data.getData();
                String myData26 = "";
                ParcelFileDescriptor pfd26 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd26.getFileDescriptor());
                DataInputStream inp26 = new DataInputStream(fileInputStream);
                BufferedReader br26 = new BufferedReader(new InputStreamReader(inp26));
                String strLine26;
                while ((strLine26 = br26.readLine()) != null) {
                    myData26 = myData26 + strLine26 + "\n";
                }
                inp26.close();

                FileOutputStream fileout26 = openFileOutput("Input.xyz", MODE_PRIVATE);
                OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                outputWriter26.write(myData26);
                outputWriter26.close();
                fileInputStream.close();
                pfd26.close();
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE20 && data != null) {
            // save input file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                String fileContents20X = InputFile.getText().toString();
                FileOutputStream fileout20 = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                outputWriter20.write(fileContents20X + "\n");
                outputWriter20.close();

                documentUri20 = data.getData();
                ParcelFileDescriptor pfd20 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream20 = new FileOutputStream(pfd20.getFileDescriptor());
//                String fileContents20 = InputFile.getText().toString();
                String fileContents20 = exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd");
                fileOutputStream20.write((fileContents20 + "\n").getBytes());
                fileOutputStream20.close();
                pfd20.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE01 && data != null) {
            // save coordinate file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                String fileContents0X = CoordFile.getText().toString();
                FileOutputStream fileout0 = openFileOutput("Input.xyz", MODE_PRIVATE);
                OutputStreamWriter outputWriter0 = new OutputStreamWriter(fileout0);
                outputWriter0.write(fileContents0X + "\n");
                outputWriter0.close();
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");

                documentUri0 = data.getData();
                ParcelFileDescriptor pfd0 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream0 = new FileOutputStream(pfd0.getFileDescriptor());
//                String fileContents20 = InputFile.getText().toString();
                String fileContents0 = exec("cat "+getFilesDir()+"/dftb/Input.xyz");
                fileOutputStream0.write((fileContents0 + "\n").getBytes());
                fileOutputStream0.close();
                pfd0.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE21 && data != null) {
            // save output file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri21 = data.getData();
                ParcelFileDescriptor pfd21 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream21 = new FileOutputStream(pfd21.getFileDescriptor());
                String fileContents21 = outputView2.getText().toString();
                fileOutputStream21.write((fileContents21 + "\n").getBytes());
                fileOutputStream21.close();
                pfd21.close();
                FileOutputStream fileout21 = openFileOutput("Input.out", MODE_PRIVATE);
                OutputStreamWriter outputWriter21 = new OutputStreamWriter(fileout21);
                outputWriter21.write(fileContents21 + "\n");
                outputWriter21.close();
                exec("mv "+getFilesDir()+"/Input.out "+getFilesDir()+"/dftb/");
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE60 && data != null) {
            try {
                documentUri60 = data.getData();
                String myData60 = "";
                ParcelFileDescriptor pfd60 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream60 = new FileInputStream(pfd60.getFileDescriptor());
                DataInputStream inp60 = new DataInputStream(fileInputStream60);
                BufferedReader br60 = new BufferedReader(new InputStreamReader(inp60));
                String strLine60;
                while ((strLine60 = br60.readLine()) != null) {
                    myData60 = myData60 + strLine60 + "\n";
                }
                inp60.close();

                FileOutputStream fileout60 = openFileOutput("Command.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter60 = new OutputStreamWriter(fileout60);
                outputWriter60.write(myData60);
                outputWriter60.close();
                fileInputStream60.close();
                pfd60.close();
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE200 && data != null) {
            // save command file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri200 = data.getData();
                ParcelFileDescriptor pfd200 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream200 = new FileOutputStream(pfd200.getFileDescriptor());
                String fileContents200 = Command.getText().toString();
                fileOutputStream200.write((fileContents200 + "\n").getBytes());
                fileOutputStream200.close();
                pfd200.close();
                FileOutputStream fileout200 = openFileOutput("Command.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter200 = new OutputStreamWriter(fileout200);
                outputWriter200.write(fileContents200);
                outputWriter200.close();
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
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
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                alertSaveInput();
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }


    public void alertSaveInput(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Dftb.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Dftb.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/dftb_work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = InputFile.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile+"\n");
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/dftb_work");
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


    private View.OnClickListener saveCoordfileClick; {

        saveCoordfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                alertSaveCoord();
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }


    public void alertSaveCoord(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Dftb.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Dftb.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/dftb_work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = CoordFile.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile+"\n");
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/dftb_work");
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


    private View.OnClickListener saveCommandfileClick; {

        saveCommandfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                alertSaveCommand();
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }


    public void alertSaveCommand(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Dftb.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Dftb.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/dftb_commands")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = Command.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/dftb_commands");
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


    private View.OnClickListener RunProgramClick; {

        RunProgramClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");

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

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(InputFile.getWindowToken(), 0);
//                String command = ErgoInput.getText().toString();
                String command = Arguments;
//                String command = " export HOME="+getFilesDir()+"/ ; cd $HOME ; "+getApplicationInfo().nativeLibraryDir+"/"+NameOfProgram+" "+Arguments;

                new RunCommandTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, command);

                // TODO Auto-generated method stub //
//                openprogressdialog();
            }
        };
    }

    // Ignore the bad AsyncTask usage.
    final class RunCommandTask extends AsyncTask<String, Void, CommandResult> {

        private ProgressDialog dialog;

        @Override protected void onPreExecute() {

            // this is cancellable progress dialog
            dialog = new ProgressDialog(Dftb.this);
            dialog.setTitle("Please wait...");
            dialog.setMessage("Calculation is in progress.");
            dialog.setCancelable(false);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog2, int which) {
                    dialog2.dismiss();
                }
            });
            dialog.show();

            // this was the original non-cancellable progress dialog
//            dialog = ProgressDialog.show(MainActivity.this, "Please wait...", "Calculation is in progress.");
//            dialog.setCancelable(false);
        }

        @Override protected CommandResult doInBackground(String... commands) {
            return com.jrummyapps.android.shell.Shell.SH.run(commands);
        }

        @Override protected void onPostExecute(CommandResult result) {
            if (!isFinishing()) {
                dialog.dismiss();
//                outputView2.setText(resultToHtml(result));
                String OutputofExecution = resultToHtml(result).toString();
                try {
                    FileOutputStream fileout = openFileOutput("LastExecutionOutput.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(OutputofExecution);
                    outputWriter.close();
                    exec("mv "+getFilesDir()+"/LastExecutionOutput.txt "+getFilesDir()+"/dftb/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                outputView2.setText(OutputofExecution);
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));}
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
                output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/dftb/"));
            }
        };
    }





    public void alertSaveOutput(){
        // creating the EditText widget programatically
        EditText editText15 = new EditText(Dftb.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Dftb.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/dftb_work")
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
                        exec("mv "+getFilesDir()+"/"+SaveOutputName+" "+getFilesDir()+"/dftb_work");
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
    private View.OnClickListener inToCanvasClick; {

        inToCanvasClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                String XYZfile = exec("cat "+getFilesDir()+"/dftb/Input.xyz");
                try {
                    while (XYZfile.contains("\t")){  //2 spaces
                        XYZfile = XYZfile.replace("\t", " "); //(2 spaces, 1 space)
                    }
                    while (XYZfile.contains("  ")){  //2 spaces
                        XYZfile = XYZfile.replace("  ", " "); //(2 spaces, 1 space)
                    }
                    while (XYZfile.contains("\n ")){  //2 spaces
                        XYZfile = XYZfile.replace("\n ", "\n"); //(2 spaces, 1 space)
                    }

                    FileOutputStream fileout = openFileOutput("Coordinates.xyz.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XYZfile);
                    outputWriter.close();


                    exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                    exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                    exec("rm "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
                    exec("touch "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");

                    // in Angstroms, in 0;0, without zoom
                    exec("mv "+getFilesDir()+"/Coordinates.xyz.tmp "+getFilesDir()+"/canvas3d/Coordinates_headless.xyz.tmp");
                    exec("sed -i 1,2d "+getFilesDir()+"/canvas3d/Coordinates_headless.xyz.tmp");
                    try {
                        Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates_headless.xyz.tmp"));
                        double radius = 0;
                        int atom_color = 0;
                        int text_color = 0;
                        int atom_number = 0;
                        int atomNumber = 0;
                        // now in Angstroms
                        double radius_Ang = 0;

                        while (scan.hasNext()) {
                            atomNumber++;

                            String curLine = scan.nextLine();
                            String[] splitted = curLine.split(" ");
                            String atom = splitted[0].trim();
                            String x_coord = splitted[1].trim();
                            String y_coord = splitted[2].trim();
                            String z_coord = splitted[3].trim();

                            atom_number = atomNumber;

//                        Log.println(Log.INFO, "atom = ", atom);

                            try {
                                Scanner scanElmnt = new Scanner(new File(getFilesDir()+"/canvas3d/Elmnts.dat"));
                                while (scanElmnt.hasNext()) {
                                    String curLineElmnt = scanElmnt.nextLine();
                                    String[] splittedElmnt = curLineElmnt.split(" ");
                                    String elementElmnt = splittedElmnt[0].trim();
                                    String radiusElmnt = splittedElmnt[1].trim();
                                    String atom_colorElmnt = splittedElmnt[2].trim();
                                    String text_colorElmnt = splittedElmnt[3].trim();

                                    radius = Double.valueOf(radiusElmnt);
                                    atom_color = Integer.valueOf(atom_colorElmnt);
                                    text_color = Integer.valueOf(text_colorElmnt);
                                    radius_Ang = radius/100;

                                    if (atom.equals(elementElmnt)) {

                                        // write in Angstroms, in 0;0, without zoom
                                        FileOutputStream fileout3 = openFileOutput("Coordinates.x.tmp", MODE_APPEND);
                                        OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                                        outputWriter3.write(elementElmnt +"\t"+x_coord+"\t"+y_coord+"\t"+z_coord+"\t"+radius_Ang+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                                        outputWriter3.close();
                                    }
                                }
                                scanElmnt.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                        // až tady: (za smyčkou)
                        scan.close();
                        exec("rm "+getFilesDir()+"/canvas3d/Coordinates_headless.xyz.tmp");
                        exec("mv "+getFilesDir()+"/Coordinates.x.tmp "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                        exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                        double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                        try {
                            Scanner scanX = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                            while (scanX.hasNext()) {
                                String curLineX = scanX.nextLine();
                                String[] splittedX = curLineX.split("\\s");
                                String atomX = splittedX[0].trim();
                                String x_coordX = splittedX[1].trim();
                                String y_coordX = splittedX[2].trim();
                                String z_coordX = splittedX[3].trim();
                                String radiusX = splittedX[4].trim();
                                String atom_colorX = splittedX[5].trim();
                                String atom_numberX = splittedX[6].trim();
                                int radius_pixX = (int) (Double.valueOf(radiusX)*100);
                                // project 3D geometry to z = 0
                                double A = 0;
                                double B = 0;
                                double C = 1;
                                double D = 0;
                                double x_projX = Double.valueOf(x_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_projX = Double.valueOf(y_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_projX = Double.valueOf(z_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                // because of canvas - input variables x&y have to be integers, not doubles
                                int x_projection = (int) (x_projX*100);
                                int y_projection = (int) (y_projX*100);
                                int z_projection = (int) (z_projX*100);
                                // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                                double z_textX = Double.valueOf(z_coordX)+0.01;
                                int text_colorX;
                                if(Integer.valueOf(atom_colorX) != -1){
                                    text_colorX = Color.BLACK;
                                } else {
                                    text_colorX = Color.WHITE;
                                }
                                // write the file
                                FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                                outputWriter_atoms.write(atomX+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coordX+"\t"+radius_pixX+"\t"+atom_colorX+"\t"+atom_numberX+"\t"+"C"+"\n");
                                outputWriter_atoms.write(atomX+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_textX+"\t"+"0"+"\t"+text_colorX+"\t"+atom_numberX+"\t"+"T"+"\n");
                                outputWriter_atoms.close();

                                // second loop - to reveal the bonds
                                Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                                while (scan2.hasNext()) {
                                    String curLine2 = scan2.nextLine();
                                    String[] splitted2 = curLine2.split("\\s");
                                    String atom2 = splitted2[0].trim();
                                    String x_coord2 = splitted2[1].trim();
                                    String y_coord2 = splitted2[2].trim();
                                    String z_coord2 = splitted2[3].trim();
                                    String radius2 = splitted2[4].trim();
                                    String atom_color2 = splitted2[5].trim();
                                    String text_color2 = splitted2[6].trim();
                                    String atom_number2 = splitted2[7].trim();

                                    // investigate all distances
                                    double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coordX)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coordX)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coordX)-Double.valueOf(z_coord2)),2));
                                    double BondingDistance = BondScale * (Double.valueOf(radiusX) + Double.valueOf(radius2));
                                    if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                        double A2 = 0;
                                        double B2 = 0;
                                        double C2 = 1;
                                        double D2 = 0;
                                        double x_proj1 = Double.valueOf(x_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                        double y_proj1 = Double.valueOf(y_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                        double z_proj1 = Double.valueOf(z_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                        double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                        double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                        double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                        double x_bond1 = 100*x_proj1;
                                        double y_bond1 = 100*y_proj1;
                                        double x_bond2 = 100*x_proj2;
                                        double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                        int bond_color1 = Integer.valueOf(atom_colorX);
                                        int bond_color2 = Integer.valueOf(atom_color2);

                                        // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                        double z_bond_average = 0.5*(Double.valueOf(z_coordX) + Double.valueOf(z_coord2))-0.01;

                                        // write the file
                                        FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                        OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                        outputWriter_bonds.write(atomX+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
                                        outputWriter_bonds.close();
                                    }
                                }
                                scan2.close();
                            }
                            scan.close();
                            exec("mv "+getFilesDir()+"/Coordinates.tmp "+getFilesDir()+"/canvas3d/");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // at the moment, the file Coordinates.tmp has to be sorted by the z_coord value:
                        try {
                            String Z_sort = exec("sort -g -k7 "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                            FileOutputStream fileout_sort = openFileOutput("Coordinates.tmp_", MODE_PRIVATE);
                            OutputStreamWriter outputWriter_sort = new OutputStreamWriter(fileout_sort);
                            outputWriter_sort.write(Z_sort);
                            outputWriter_sort.close();
                            exec("mv "+getFilesDir()+"/Coordinates.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(Dftb.this, Canvas3d_main.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener outToCanvasClick; {

        outToCanvasClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/dftb_in.hsd "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Command.txt "+getFilesDir()+"/dftb/");
                exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                String XYZfile = exec("cat "+getFilesDir()+"/dftb/geom.out.xyz");
                try {
                    while (XYZfile.contains("\t")){  //2 spaces
                        XYZfile = XYZfile.replace("\t", " "); //(2 spaces, 1 space)
                    }
                    while (XYZfile.contains("  ")){  //2 spaces
                        XYZfile = XYZfile.replace("  ", " "); //(2 spaces, 1 space)
                    }
                    while (XYZfile.contains("\n ")){  //2 spaces
                        XYZfile = XYZfile.replace("\n ", "\n"); //(2 spaces, 1 space)
                    }

                    FileOutputStream fileout = openFileOutput("Coordinates.xyz.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XYZfile);
                    outputWriter.close();


                    exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                    exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                    exec("rm "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
                    exec("touch "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");

                    // in Angstroms, in 0;0, without zoom
                    exec("mv "+getFilesDir()+"/Coordinates.xyz.tmp "+getFilesDir()+"/canvas3d/Coordinates_headless.xyz.tmp");
                    exec("sed -i 1,2d "+getFilesDir()+"/canvas3d/Coordinates_headless.xyz.tmp");
                    try {
                        Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates_headless.xyz.tmp"));
                        double radius = 0;
                        int atom_color = 0;
                        int text_color = 0;
                        int atom_number = 0;
                        int atomNumber = 0;
                        // now in Angstroms
                        double radius_Ang = 0;

                        while (scan.hasNext()) {
                            atomNumber++;

                            String curLine = scan.nextLine();
                            String[] splitted = curLine.split(" ");
                            String atom = splitted[0].trim();
                            String x_coord = splitted[1].trim();
                            String y_coord = splitted[2].trim();
                            String z_coord = splitted[3].trim();
                            String charge = splitted[4].trim();

                            atom_number = atomNumber;

//                        Log.println(Log.INFO, "atom = ", atom);

                            try {
                                Scanner scanElmnt = new Scanner(new File(getFilesDir()+"/canvas3d/Elmnts.dat"));
                                while (scanElmnt.hasNext()) {
                                    String curLineElmnt = scanElmnt.nextLine();
                                    String[] splittedElmnt = curLineElmnt.split(" ");
                                    String elementElmnt = splittedElmnt[0].trim();
                                    String radiusElmnt = splittedElmnt[1].trim();
                                    String atom_colorElmnt = splittedElmnt[2].trim();
                                    String text_colorElmnt = splittedElmnt[3].trim();

                                    radius = Double.valueOf(radiusElmnt);
                                    atom_color = Integer.valueOf(atom_colorElmnt);
                                    text_color = Integer.valueOf(text_colorElmnt);
                                    radius_Ang = radius/100;

                                    if (atom.equals(elementElmnt)) {

                                        // write in Angstroms, in 0;0, without zoom
                                        FileOutputStream fileout3 = openFileOutput("Coordinates.x.tmp", MODE_APPEND);
                                        OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                                        outputWriter3.write(elementElmnt +"\t"+x_coord+"\t"+y_coord+"\t"+z_coord+"\t"+radius_Ang+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                                        outputWriter3.close();
                                    }
                                }
                                scanElmnt.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                        // až tady: (za smyčkou)
                        scan.close();
                        exec("rm "+getFilesDir()+"/canvas3d/Coordinates_headless.xyz.tmp");
                        exec("mv "+getFilesDir()+"/Coordinates.x.tmp "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                        exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                        double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                        try {
                            Scanner scanX = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                            while (scanX.hasNext()) {
                                String curLineX = scanX.nextLine();
                                String[] splittedX = curLineX.split("\\s");
                                String atomX = splittedX[0].trim();
                                String x_coordX = splittedX[1].trim();
                                String y_coordX = splittedX[2].trim();
                                String z_coordX = splittedX[3].trim();
                                String radiusX = splittedX[4].trim();
                                String atom_colorX = splittedX[5].trim();
                                String atom_numberX = splittedX[6].trim();
                                int radius_pixX = (int) (Double.valueOf(radiusX)*100);
                                // project 3D geometry to z = 0
                                double A = 0;
                                double B = 0;
                                double C = 1;
                                double D = 0;
                                double x_projX = Double.valueOf(x_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_projX = Double.valueOf(y_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_projX = Double.valueOf(z_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                // because of canvas - input variables x&y have to be integers, not doubles
                                int x_projection = (int) (x_projX*100);
                                int y_projection = (int) (y_projX*100);
                                int z_projection = (int) (z_projX*100);
                                // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                                double z_textX = Double.valueOf(z_coordX)+0.01;
                                int text_colorX;
                                if(Integer.valueOf(atom_colorX) != -1){
                                    text_colorX = Color.BLACK;
                                } else {
                                    text_colorX = Color.WHITE;
                                }
                                // write the file
                                FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                                outputWriter_atoms.write(atomX+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coordX+"\t"+radius_pixX+"\t"+atom_colorX+"\t"+atom_numberX+"\t"+"C"+"\n");
                                outputWriter_atoms.write(atomX+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_textX+"\t"+"0"+"\t"+text_colorX+"\t"+atom_numberX+"\t"+"T"+"\n");
                                outputWriter_atoms.close();

                                // second loop - to reveal the bonds
                                Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                                while (scan2.hasNext()) {
                                    String curLine2 = scan2.nextLine();
                                    String[] splitted2 = curLine2.split("\\s");
                                    String atom2 = splitted2[0].trim();
                                    String x_coord2 = splitted2[1].trim();
                                    String y_coord2 = splitted2[2].trim();
                                    String z_coord2 = splitted2[3].trim();
                                    String radius2 = splitted2[4].trim();
                                    String atom_color2 = splitted2[5].trim();
                                    String text_color2 = splitted2[6].trim();
                                    String atom_number2 = splitted2[7].trim();

                                    // investigate all distances
                                    double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coordX)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coordX)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coordX)-Double.valueOf(z_coord2)),2));
                                    double BondingDistance = BondScale * (Double.valueOf(radiusX) + Double.valueOf(radius2));
                                    if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                        double A2 = 0;
                                        double B2 = 0;
                                        double C2 = 1;
                                        double D2 = 0;
                                        double x_proj1 = Double.valueOf(x_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                        double y_proj1 = Double.valueOf(y_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                        double z_proj1 = Double.valueOf(z_coordX) - A*(Double.valueOf(x_coordX) * A + Double.valueOf(y_coordX) * B + Double.valueOf(z_coordX) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                        double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                        double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                        double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                        double x_bond1 = 100*x_proj1;
                                        double y_bond1 = 100*y_proj1;
                                        double x_bond2 = 100*x_proj2;
                                        double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                        int bond_color1 = Integer.valueOf(atom_colorX);
                                        int bond_color2 = Integer.valueOf(atom_color2);

                                        // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                        double z_bond_average = 0.5*(Double.valueOf(z_coordX) + Double.valueOf(z_coord2))-0.01;

                                        // write the file
                                        FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                        OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                        outputWriter_bonds.write(atomX+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
                                        outputWriter_bonds.close();
                                    }
                                }
                                scan2.close();
                            }
                            scan.close();
                            exec("mv "+getFilesDir()+"/Coordinates.tmp "+getFilesDir()+"/canvas3d/");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // at the moment, the file Coordinates.tmp has to be sorted by the z_coord value:
                        try {
                            String Z_sort = exec("sort -g -k7 "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                            FileOutputStream fileout_sort = openFileOutput("Coordinates.tmp_", MODE_PRIVATE);
                            OutputStreamWriter outputWriter_sort = new OutputStreamWriter(fileout_sort);
                            outputWriter_sort.write(Z_sort);
                            outputWriter_sort.close();
                            exec("mv "+getFilesDir()+"/Coordinates.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(Dftb.this, Canvas3d_main.class);
                startActivity(intent);
            }
        };
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
        ProgressDialog progressDialog = new ProgressDialog(Dftb.this);
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
                    outputX(exec("cat "+getFilesDir()+"/dftb/LastExecutionOutput.txt"));
                    output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
                    output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
                    output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
                    output(exec("ls -la "+getFilesDir()+"/dftb/"));
                    Toast.makeText(getApplicationContext(), "Numbers highlighted.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }

                onFinish();
            }

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void outputX(final String strX) {
                Runnable procX = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized_dftb(strX), EditText.BufferType.SPANNABLE);
                    }
                };
                handler.post(procX);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }


    @Override
    protected void onResume() {
        super.onResume();
        output3(exec("cat "+getFilesDir()+"/dftb/dftb_in.hsd"));
        output4(exec("cat "+getFilesDir()+"/dftb/Input.xyz"));
        output5(exec("cat "+getFilesDir()+"/dftb/Command.txt"));
        output(exec("ls -la "+getFilesDir()+"/dftb/"));
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                InputFile.setText(colorized_dftb(str3), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc3);
    }
    public void output4(final String str4) {
        Runnable proc4 = new Runnable() {
            public void run() {
                CoordFile.setText(colorized_dftb(str4), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc4);
    }
    public void output5(final String str5) {
        Runnable proc5 = new Runnable() {
            public void run() {
                Command.setText(colorized_dftb(str5), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc5);
    }
    public void output(final String str) {
        Runnable proc = new Runnable() {
            public void run() {
                Content.setText(colorized_dftb(str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc);
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

    private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Dftb.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


}