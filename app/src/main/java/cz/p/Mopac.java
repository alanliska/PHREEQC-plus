package cz.p;

import static cz.p.Spannables.colorized_dftb;
import static cz.p.Spannables.colorized_mopac;
import static cz.p.Spannables.colorized_numbers;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Scanner;

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

public class Mopac extends MainActivity {

    private Handler handler = new Handler();
    private TextView Description;
    private TextView MopacLabel;
    private EditText MopacInput;
    Button openInputfile;
    Button openIntInputfile;
    Button saveInputfile;
    Button saveExtInputfile;
    Button generateXYZ;
    Button opsinXYZ;
    Button RunMopac;
    Button saveOutputfile;
    Button saveExtOutputfile;
    Button Highlight;
    Button Spectrum;
    Button Quit;
    private TextView textViewX;
    private TextView outputView;
    private EditText outputView2;
    private static final int READ_FILE6 = 296;
    private Uri documentUri6;
    private static final int CREATE_FILE20 = 2920;
    private Uri documentUri20;
    private static final int CREATE_FILE21 = 2921;
    private Uri documentUri21;
    Button manual_mopac;
    Button inToCanvas;
    Button outToCanvas;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.mopac);

        MopacLabel = (TextView) findViewById(R.id.MopacLabel);
        MopacInput = (EditText) findViewById(R.id.MopacInput);
        MopacInput.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        MopacInput.addTextChangedListener(new TextWatcher() {
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
                MopacInput.removeTextChangedListener(this);
                String text = MopacInput.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                MopacInput.getText().clear();
                MopacInput.append(colorized_mopac(text));
                // place the cursor at the original position
                MopacInput.setSelection(startChanged+countChanged);
                MopacInput.addTextChangedListener(this);
            }
        });
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
        RunMopac = (Button) findViewById(R.id.RunMopac);
        RunMopac.setOnClickListener(RunMopacClick);
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
        Spectrum = (Button) findViewById(R.id.Spectrum);
        Spectrum.setOnClickListener(SpectrumClick);
        manual_mopac = (Button) findViewById(R.id.manual_mopac);
        manual_mopac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Mopac.this, ManualMOPAC.class);
                startActivity(intent);
            }
        });

        openIntInputfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mopac.this, MopacWork.class);
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

        output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
    }

    private View.OnClickListener inToCanvasClick; {

        inToCanvasClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = MopacInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Mopac.this, MolCanvas_main.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener outToCanvasClick; {

        outToCanvasClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = MopacInput.getText().toString();

//                ProgressDialog progressDialog = new ProgressDialog(Mopac.this);
//                progressDialog.setTitle("Please wait...");
//                progressDialog.setMessage("Exporting the structure...");
//                progressDialog.setCancelable(false);
//                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//                progressDialog.show();
//
//                new Thread() {
//                    public void run() {

                try {
                    FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -imopout Input.out -oxyz > MopacOut.xyz");

                String XYZfile = exec("cat "+getFilesDir()+"/MopacOut.xyz");
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

                            // remove first two lines
                            // XYZfile = XYZfile.substring(XYZfile.indexOf(System.getProperty("line.separator")) + 2);
                            // remove first line
                            XYZfile = XYZfile.substring(XYZfile.indexOf(System.getProperty("line.separator"))+1);
                            // remove second line
                            XYZfile = XYZfile.substring(XYZfile.indexOf(System.getProperty("line.separator"))+1);
                            MolCanvas_canvasView.zmat.clear();
                            int lineNum = 0;
                            String[] curLine = XYZfile.split("\\n");
                            for (String s : curLine) {
                                lineNum++;
                                String[] splitted = s.split("\\s");
                                String atom = splitted[0].trim();
                                String x_coord_str = splitted[1].trim();
                                String y_coord_str = splitted[2].trim();
                                String z_coord_str = splitted[3].trim();
                                float x_coord = Float.valueOf(x_coord_str);
                                float y_coord = Float.valueOf(y_coord_str);
                                float z_coord = Float.valueOf(z_coord_str);
                                // important: border color is at first run black, there is no other set yet (in MolCanvas_main nor MolCanvas_periodicTable)
                                MolCanvas_canvasView.zmat.add(new MolCanvas_object(lineNum, atom, MolCanvas_methods.getElementColor(atom),
                                        Color.BLACK, MolCanvas_methods.getElementRadius(atom),
                                        MolCanvas_methods.Radius_pix(MolCanvas_methods.getElementRadius(atom),
                                                MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_preferences.get().getValue("radius_scale"), MolCanvas_main.zoom_scale, z_coord),
                                        0, x_coord, y_coord, z_coord,
                                        MolCanvas_methods.AtomX_pix(x_coord, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.width_pix,
                                                MolCanvas_main.zoom_scale),
                                        MolCanvas_methods.AtomY_pix(y_coord, MolCanvas_preferences.get().getValue("conv"),
                                                MolCanvas_canvasView.height_pix, MolCanvas_main.zoom_scale),
                                        0, "", MolCanvas_methods.getElementTextColor(atom), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                        z_coord, 0.0f, 0.0f, 0.0f, 1));
                            }
                            for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                                if (object.getObjectType() == 1) {
                                    MolCanvas_main.generatedLabels.add(new MolCanvas_object(object.getAtomNumber1(), object.getAtomSymbol1(),
                                            MolCanvas_methods.getElementTextColor(object.getAtomSymbol1()),
                                            object.getAtomBorderColor1(), 0,
                                            MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), MolCanvas_main.zoom_scale,
                                                    object.getAtom1Z_Ang()),
                                            object.getTouchTime(), object.getAtom1X_Ang(), object.getAtom1Y_Ang(),
                                            object.getAtom1Z_Ang(),
                                            object.getAtom1X_pix() + MolCanvas_preferences.get().getValue("text_shift_x_pix"),
                                            object.getAtom1Y_pix() + MolCanvas_preferences.get().getValue("text_shift_y_pix"), 0, "",
                                            0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                            object.getAtom12Z_Ang() + MolCanvas_preferences.get().getValue("text_shift_z_Ang"), 0.0f,
                                            0.0f, object.getDist2D_pix(), 4));
                                }
                            }
                            MolCanvas_canvasView.zmat.addAll(MolCanvas_main.generatedLabels);
                            MolCanvas_main.generatedLabels.clear();
                            MolCanvas_main.generateAllBonds();
                            MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(Mopac.this, MolCanvas_main.class);
                        startActivity(intent);

//                        onFinish();
//                    }
//                    public void onFinish() {
//                        progressDialog.dismiss();
//                    }
//                }.start();
//
            }
        };
    }

    private View.OnClickListener GenerateXYZClick; {

        GenerateXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = MopacInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertGenerateXYZ();
                output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
            }
        };
    }


    public void alertGenerateXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(Mopac.this);
        editText100.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText100.setTypeface(Typeface.MONOSPACE);
        editText100.addTextChangedListener(new TextWatcher() {
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
                editText100.removeTextChangedListener(this);
                String text = editText100.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText100.getText().clear();
                editText100.append(colorized_dftb(text));
                // place the cursor at the original position
                editText100.setSelection(startChanged+countChanged);
                editText100.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Mopac.this)
                .setMessage("Input the SMILES string and convert it to XYZ. The result will be appended to the actual input file.")
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

                            FileOutputStream fileout3 = openFileOutput("temp.xyz", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();

                            String SedXyz = exec("sed -e 1,2d "+getFilesDir()+"/temp.xyz");

                            FileOutputStream fileout4 = openFileOutput("Input-mopac.txt", MODE_APPEND);
                            OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
//                            outputWriter4.write(InputFile);
                            outputWriter4.write("\n");
                            outputWriter4.write(SedXyz);
                            outputWriter4.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
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
                String Inputfile = MopacInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertOpsinXYZ();
                output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
            }
        };
    }


    public void alertOpsinXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(Mopac.this);
        editText100.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText100.setTypeface(Typeface.MONOSPACE);
        editText100.addTextChangedListener(new TextWatcher() {
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
                editText100.removeTextChangedListener(this);
                String text = editText100.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                editText100.getText().clear();
                editText100.append(colorized_dftb(text));
                // place the cursor at the original position
                editText100.setSelection(startChanged+countChanged);
                editText100.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(Mopac.this)
                .setMessage("Input the IUPAC name and convert it to XYZ. The result will be appended to the actual input file.")
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

                            FileOutputStream fileout3 = openFileOutput("temp.xyz", MODE_PRIVATE);
                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                            outputWriter3.write(ObabelOutput);
                            outputWriter3.close();

                            String SedXyz = exec("sed -e 1,2d "+getFilesDir()+"/temp.xyz");

                            FileOutputStream fileout4 = openFileOutput("Input-mopac.txt", MODE_APPEND);
                            OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
//                            outputWriter4.write(InputFile);
                            outputWriter4.write("\n");
                            outputWriter4.write(SedXyz);
                            outputWriter4.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("rm "+getFilesDir()+"/temp.xyz");
                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
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

    private View.OnClickListener SpectrumClick; {

        SpectrumClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = MopacInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    String Sed = exec("sed -e 1,/polarization/d "+getFilesDir()+"/Input.out");
                    FileOutputStream fileout2 = openFileOutput("Input-sed.out", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Sed);
                    outputWriter2.close();
                    String Sed3 = exec("sed /Polarizability/,$d "+getFilesDir()+"/Input-sed.out");
                    FileOutputStream fileout3 = openFileOutput("Input-sed3.out", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Sed3);
                    outputWriter3.close();
                    String Sed4 = exec("sed -e 1,2d "+getFilesDir()+"/Input-sed3.out");
                    FileOutputStream fileout4 = openFileOutput("Input-sed4.out", MODE_PRIVATE);
                    OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
                    outputWriter4.write(Sed4);
                    outputWriter4.close();
                    exec("cp "+getFilesDir()+"/Input-sed4.out "+getFilesDir()+"/mopac-spectrum.dat");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SpectrumMOPAC.b "+getFilesDir()+"/SpectrumMOPAC.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/SpectrumMOPAC.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SpectrumMOPAC.b");
                    exec("rm "+getFilesDir()+"/Input-sed.out");
                    exec("rm "+getFilesDir()+"/Input-sed3.out");
                    exec("rm "+getFilesDir()+"/Input-sed4.out");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Mopac.this, SpectrumMOPAC.class);
                startActivity(intent);
            }
        };
    }


    private View.OnClickListener openInputfileClick; {

        openInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read6(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
            }
        };
    }

    private View.OnClickListener saveExtInputfileClick; {

        saveExtInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = MopacInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write1(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
            }
        };
    }

    private View.OnClickListener saveExtOutputfileClick; {

        saveExtOutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = MopacInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write2(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
            }
        };
    }

    private void read6(Context context6) {
        Intent intent6 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent6.addCategory(Intent.CATEGORY_OPENABLE);
        intent6.setType("text/plain");
        startActivityForResult(intent6, READ_FILE6);
    }

    private void write1(Context context1) {
        Intent intent1 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        intent1.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent1, CREATE_FILE20);
    }

    private void write2(Context context2) {
        Intent intent2 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent2.addCategory(Intent.CATEGORY_OPENABLE);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TITLE,"MyOutputFile");
        startActivityForResult(intent2, CREATE_FILE21);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE6 && data != null) {
            try {
                documentUri6 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd6 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd6.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd6.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE20 && data != null) {
            // save input file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri20 = data.getData();
                ParcelFileDescriptor pfd20 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd20.getFileDescriptor());
                String fileContents = MopacInput.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd20.close();
                FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(fileContents + "\n");
                outputWriter.close();
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
                FileOutputStream fileOutputStream = new FileOutputStream(pfd21.getFileDescriptor());
                String fileContents = outputView2.getText().toString();
                fileOutputStream.write((fileContents + "\n").getBytes());
                fileOutputStream.close();
                pfd21.close();
                FileOutputStream fileout = openFileOutput("Input.out", MODE_PRIVATE);
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
                String Inputfile = MopacInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveInput();
                output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
            }
        };
    }


    public void alertSaveInput(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(Mopac.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(Mopac.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/mopac")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = MopacInput.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/mopac");
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


    private View.OnClickListener RunMopacClick; {

        RunMopacClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = MopacInput.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_PRIVATE);
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
        progressDialog = new ProgressDialog(Mopac.this);
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
                    exec("cp "+getFilesDir()+"/Input-mopac.txt "+getFilesDir()+"/Input.mop");
                    exec("chmod 755 -R "+getFilesDir());
                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/Input");
		    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so Input");
                    exec("chmod 755 "+getFilesDir()+"/Input.out");
                    try {
                        output2(exec("cat "+getFilesDir()+"/Input.out"));
                        output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
                        Toast.makeText(getApplicationContext(), "Calculation finished", Toast.LENGTH_SHORT).show();
                        exec("rm "+getFilesDir()+"/Input.mop");
                        exec("rm "+getFilesDir()+"/Input.arc");
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
                output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
            }
        };
    }





    public void alertSaveOutput(){
        // creating the EditText widget programatically
        EditText editText15 = new EditText(Mopac.this);
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
        final AlertDialog dialog = new AlertDialog.Builder(Mopac.this)
                .setMessage("The file will be saved in the folder /data/data/cz.p/files/mopac")
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
                        exec("mv "+getFilesDir()+"/"+SaveOutputName+" "+getFilesDir()+"/mopac");
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
        progressDialog = new ProgressDialog(Mopac.this);
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
                    outputX(exec("cat "+getFilesDir()+"/Input.out"));
                    output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
                    Toast.makeText(getApplicationContext(), "Numbers highlighted.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }

                onFinish();
            }

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void outputX(final String strX) {
                Runnable procX = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized_mopac(strX), EditText.BufferType.SPANNABLE);
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
                Intent intent = new Intent(Mopac.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


    @Override
    protected void onResume() {
        super.onResume();
        output3(exec("cat "+getFilesDir()+"/Input-mopac.txt"));
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                MopacInput.setText(colorized_mopac(str3), EditText.BufferType.SPANNABLE);
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
