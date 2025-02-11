package cz.p;

import static cz.p.Spannables.colorized_zmat_elements;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MolCanvas_main extends AppCompatActivity {
    static MolCanvas_canvasView molCanvasView;
    private Button elmnt;
    private Button clear;
    private Button labels;
    private Button delete;
    private Button replace;
    private Button importB;
    private Button exportB;
    private Button distB;
    private Button angB;
    private Button dihB;
    private Button reorderB;
    private Button settingsB;
    private Button centerB;
    private Button toDftb;
    private Button toMopac;
    private Button toXtb;
    private Button exitButton;
    private Button zmat;

    public static List<MolCanvas_object> generatedLabels = new ArrayList<>();
    public static List<MolCanvas_object> generatedBonds = new ArrayList<>();
    public static List<MolCanvas_renumber> renumberList = new ArrayList<>();

    // file input, output
    private static final int READ_FILE = 10;
    private Uri documentUri1;
    private static final int CREATE_FILE = 20;
    private Uri documentUri2;

    public static float zoom_scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        zoom_scale = MolCanvas_preferences.get().getValue("zoom");
        setContentView(R.layout.molcanvasmain);

        if (MolCanvas_periodicTable.Element == null) {
            MolCanvas_periodicTable.Element = "C";
            MolCanvas_periodicTable.ElementRadius = MolCanvas_preferences.get().getValue("r_C");
            MolCanvas_periodicTable.ElementColor = MolCanvas_preferences.get().getIntValue("color_C");
            MolCanvas_periodicTable.ElementBorderColor = MolCanvas_preferences.get().getIntValue("unselectedColor");
            MolCanvas_periodicTable.ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_C");
            MolCanvas_canvasView.labelSwitch = 1;
            MolCanvas_preferences.get().setValue("conv", 100.0f);
        }

        molCanvasView = (MolCanvas_canvasView) findViewById(R.id.molCanvasView);
        elmnt = (Button) findViewById(R.id.elmnt);
        elmnt.setOnClickListener(elmntButton);
        elmnt.setText(MolCanvas_periodicTable.Element);
        clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(clearButton);
        labels = (Button) findViewById(R.id.labels);
        labels.setOnClickListener(labelsButton);
        if (MolCanvas_canvasView.labelSwitch == 1) {
            labels.setText("Labels on");
        } else {
            labels.setText("Labels off");
        }
        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(deleteButton);
        replace = (Button) findViewById(R.id.replace);
        replace.setOnClickListener(replaceButton);
        importB = (Button) findViewById(R.id.importB);
        importB.setOnClickListener(importButton);
        exportB = (Button) findViewById(R.id.exportB);
        exportB.setOnClickListener(exportButton);
        distB = (Button) findViewById(R.id.distB);
        distB.setOnClickListener(distButton);
        angB = (Button) findViewById(R.id.angB);
        angB.setOnClickListener(angButton);
        dihB = (Button) findViewById(R.id.dihB);
        dihB.setOnClickListener(dihButton);
        reorderB = (Button) findViewById(R.id.reorderB);
        reorderB.setOnClickListener(reorderButton);
        settingsB = (Button) findViewById(R.id.settingsB);
        settingsB.setOnClickListener(settingsButton);
        centerB = (Button) findViewById(R.id.centerB);
        centerB.setOnClickListener(centerButton);

        exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(MolCanvas_main.this, MainActivity.class);
                startActivity(intent);
            }
        });
        toDftb = (Button) findViewById(R.id.toDftb);
        toDftb.setOnClickListener(toDftbClick);
        toMopac = (Button) findViewById(R.id.toMopac);
        toMopac.setOnClickListener(toMopacClick);
        toXtb = (Button) findViewById(R.id.toXtb);
        toXtb.setOnClickListener(toXtbClick);
        zmat = (Button) findViewById(R.id.zmat);
        zmat.setOnClickListener(zmatClick);
    }

    @Override
    protected void onStart() {
        super.onStart();
        zoom_scale = MolCanvas_preferences.get().getValue("zoom");
    }

    private View.OnClickListener zmatClick; {

        zmatClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                // create XYZ structure
                String XYZstructure = getStructureXYZ();
                // save the structure as XYZ file
                try {
                    FileOutputStream fileout = openFileOutput("Coordinates.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XYZstructure);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // convert XYZ to GJF ; edited - to maintain the compatibility also for Android 9 and Android 8 devices, it is not possible to use the sed /XYZ/Q command
                com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ixyz Coordinates.xyz -ogzmat > Coordinates.gjf.tmp ; sed -i 1,6d Coordinates.gjf.tmp ; sed /Variables/q Coordinates.gjf.tmp > Coordinates1.gjf.tmp ; sed -i '$d' Coordinates1.gjf.tmp ; sed 1,/^Variables/d Coordinates.gjf.tmp > Coordinates2.gjf.tmp ; cd .. ; touch Coordinates3.gjf.tmp");
                // replace the string variables by the corresponding values
                String Coordinates1 = exec("cat "+getFilesDir()+"/Coordinates1.gjf.tmp");
                String Coordinates2 = exec("cat "+getFilesDir()+"/Coordinates2.gjf.tmp");
                while (Coordinates2.contains("=")){  //2 spaces
                    Coordinates2 = Coordinates2.replace("=", " "); //(2 spaces, 1 space)
                }
                while (Coordinates2.contains("\t")){  //2 spaces
                    Coordinates2 = Coordinates2.replace("\t", " "); //(2 spaces, 1 space)
                }
                while (Coordinates2.contains("  ")){  //2 spaces
                    Coordinates2 = Coordinates2.replace("  ", " "); //(2 spaces, 1 space)
                }
                while (Coordinates2.contains("\n ")){  //2 spaces
                    Coordinates2 = Coordinates2.replace("\n ", "\n"); //(2 spaces, 1 space)
                }
                try {
                    Scanner scan = new Scanner(Coordinates2);
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String var = splitted[0].trim();
                        String value = splitted[1].trim();
                        // whole words (r2, r20, ...), not substrings (r2 in r20, ...)
                        Coordinates1 = Coordinates1.replaceAll("\\b"+var+"\\b", value);
                    }
                    scan.close();
                    // write the file
                    FileOutputStream fileout = openFileOutput("Coordinates3.gjf.tmp", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Coordinates1);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates3.gjf.tmp "+getFilesDir()+"/Coordinates.gjf.tmp");
                exec("rm "+getFilesDir()+"/Coordinates1.gjf.tmp");
                exec("rm "+getFilesDir()+"/Coordinates2.gjf.tmp");
                // edit
                alertZmat();
            }
        };
    }

    public void alertZmat(){
        int maxLines = MolCanvas_preferences.get().getIntValue("zmat_max_lines");
        // creating the EditText widget programatically
        EditText editText100 = new EditText(MolCanvas_main.this);
        editText100.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        editText100.setTypeface(Typeface.MONOSPACE);
        editText100.setText(colorized_zmat_elements(exec("cat "+getFilesDir()+"/Coordinates.gjf.tmp")), EditText.BufferType.SPANNABLE);
        editText100.setMaxLines(maxLines);
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
                editText100.append(colorized_zmat_elements(text));
                // place the cursor at the original position
                editText100.setSelection(startChanged+countChanged);
                editText100.addTextChangedListener(this);
            }
        });
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(MolCanvas_main.this)
                .setMessage("Edit the internal coordinates")
                .setTitle("Gaussian Z-matrix")
//                .setView(scrollview)
                .setView(editText100)
                // Set the action buttons
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String GaussianZMatrix = editText100.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput("Coordinates_.gjf.tmp", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(GaussianZMatrix);
                            outputWriter.close();
                            FileOutputStream fileout2 = openFileOutput("Coordinates.gjf.tmp", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write("# method\n");
                            outputWriter2.write("\n");
                            outputWriter2.write("description\n");
                            outputWriter2.write("\n");
                            outputWriter2.write("0 1\n");
                            outputWriter2.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // convert back to XYZ
                        com.jrummyapps.android.shell.Shell.SH.run("export HOME=/data/data/cz.p/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; cat Coordinates_.gjf.tmp >> Coordinates.gjf.tmp ; rm Coordinates_.gjf.tmp ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -igzmat Coordinates.gjf.tmp -oxyz > Coordinates.xyz.tmp");
                            ProgressDialog progressDialog2 = new ProgressDialog(MolCanvas_main.this);
                            progressDialog2.setTitle("Please wait...");
                            progressDialog2.setMessage("Regenerating the cartesian files...");
                            progressDialog2.setCancelable(false);
                            progressDialog2.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            progressDialog2.show();

                            new Thread() {
                                public void run() {
                                    String XYZfile = exec("cat "+getFilesDir()+"/Coordinates.xyz.tmp");
                                    try {
                                        // content of the XYZ file may contain spaces, tabs in any number and combination
                                        while (XYZfile.contains("\t")) {
                                            XYZfile = XYZfile.replace("\t", " ");
                                        }
                                        while (XYZfile.contains("  ")) {
                                            XYZfile = XYZfile.replace("  ", " ");
                                        }
                                        while (XYZfile.contains("\n ")) {
                                            XYZfile = XYZfile.replace("\n ", "\n");
                                        }
                                        // remove first two lines
                                        // XYZfile = XYZfile.substring(XYZfile.indexOf(System.getProperty("line.separator")) + 2);
                                        // the above solution does not work when there is more than exactly two characters in the beginning of file
                                        // remove first lilne
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
                                            MolCanvas_canvasView.zmat.add(new MolCanvas_object(lineNum, atom, MolCanvas_methods.getElementColor(atom),
                                                    MolCanvas_periodicTable.ElementBorderColor, MolCanvas_methods.getElementRadius(atom),
                                                    MolCanvas_methods.Radius_pix(MolCanvas_methods.getElementRadius(atom),
                                                            MolCanvas_preferences.get().getValue("conv"),
                                                            MolCanvas_preferences.get().getValue("radius_scale"), zoom_scale, z_coord),
                                                    0, x_coord, y_coord, z_coord,
                                                    MolCanvas_methods.AtomX_pix(x_coord, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.width_pix,
                                                            zoom_scale),
                                                    MolCanvas_methods.AtomY_pix(y_coord, MolCanvas_preferences.get().getValue("conv"),
                                                            MolCanvas_canvasView.height_pix, zoom_scale),
                                                    0, "", MolCanvas_methods.getElementTextColor(atom), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                                    z_coord, 0.0f, 0.0f, 0.0f, 1));
                                        }
                                        for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                                            if (object.getObjectType() == 1) {
                                                generatedLabels.add(new MolCanvas_object(object.getAtomNumber1(), object.getAtomSymbol1(),
                                                        MolCanvas_methods.getElementTextColor(object.getAtomSymbol1()),
                                                        object.getAtomBorderColor1(), 0,
                                                        MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), zoom_scale,
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
                                        MolCanvas_canvasView.zmat.addAll(generatedLabels);
                                        generatedLabels.clear();
                                        generateAllBonds();
                                        MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    molCanvasView.setMoleculeRenderer(MolCanvas_canvasView.TRUE);
                                    exec("rm "+getFilesDir()+"/Coordinates.gjf.tmp");
                                    exec("rm "+getFilesDir()+"/Coordinates.xyz");
                                    exec("rm "+getFilesDir()+"/Coordinates.xyz.tmp");
                                    onFinish();
                                }
                                public void onFinish() {
                                    progressDialog2.dismiss();
                                }
                            }.start();
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

    private View.OnClickListener toDftbClick; {
        toDftbClick = new View.OnClickListener() {
            public void onClick(View v) {
                    ProgressDialog progressDialog = new ProgressDialog(MolCanvas_main.this);
                    progressDialog.setTitle("Please wait...");
                    progressDialog.setMessage("Generating the XYZ file...");
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
                            String fileContents = getStructureXYZ();
                            try {
                            FileOutputStream fileout = openFileOutput("Input.xyz", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(fileContents);
                            outputWriter.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            exec("mv "+getFilesDir()+"/Input.xyz "+getFilesDir()+"/dftb/");
                            Intent intent = new Intent(MolCanvas_main.this, Dftb.class);
                            startActivity(intent);
                            molCanvasView.setMoleculeRenderer(MolCanvas_canvasView.TRUE);
                            onFinish();
                        }
                        public void onFinish() {
                            progressDialog.dismiss();
                        }
                    }.start();
                }
        };
    }

    private View.OnClickListener toMopacClick; {
        toMopacClick = new View.OnClickListener() {
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(MolCanvas_main.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Generating the XYZ file...");
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
                        String fileContents = getStructureXYZ();
                        try {
                            FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_APPEND);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(fileContents);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(MolCanvas_main.this, Mopac.class);
                        startActivity(intent);
                        molCanvasView.setMoleculeRenderer(MolCanvas_canvasView.TRUE);
                        onFinish();
                    }
                    public void onFinish() {
                        progressDialog.dismiss();
                    }
                }.start();
            }
        };
    }

    private View.OnClickListener toXtbClick; {
        toXtbClick = new View.OnClickListener() {
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(MolCanvas_main.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Generating the XYZ file...");
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
                        String fileContents = getStructureXYZ();
                        try {
                            FileOutputStream fileout = openFileOutput("Input-xtb.xyz", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(fileContents);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/Input-xtb.xyz "+getFilesDir()+"/xtb/");
                        Intent intent = new Intent(MolCanvas_main.this, Xtb.class);
                        startActivity(intent);
                        molCanvasView.setMoleculeRenderer(MolCanvas_canvasView.TRUE);
                        onFinish();
                    }
                    public void onFinish() {
                        progressDialog.dismiss();
                    }
                }.start();
            }
        };
    }

    private View.OnClickListener elmntButton;

    {
        elmntButton = new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(MolCanvas_main.this, MolCanvas_periodicTable.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener clearButton;

    {
        clearButton = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                MolCanvas_canvasView.zmat.clear();
                MolCanvas_canvasView.ElementNumber = 0;
                molCanvasView.invalidate();
            }
        };
    }

    private View.OnClickListener labelsButton;

    {
        labelsButton = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                switch (MolCanvas_canvasView.labelSwitch) {
                    case 0:
                        MolCanvas_canvasView.labelSwitch = 1;
                        labels.setText("Labels on");
                        molCanvasView.invalidate();
                        break;
                    case 1:
                        MolCanvas_canvasView.labelSwitch = 0;
                        labels.setText("Labels off");
                        molCanvasView.invalidate();
                        break;
                }
            }
        };
    }

    private View.OnClickListener settingsButton;

    {
        settingsButton = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(MolCanvas_main.this, MolCanvas_settings.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener centerButton;

    {
        centerButton = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                MolCanvas_canvasView.centerMolecule();
                molCanvasView.invalidate();
            };
        };
    }

    private View.OnClickListener deleteButton;

    {
        deleteButton = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                deleteAtoms();
                molCanvasView.invalidate();
            };
        };
    }

    private View.OnClickListener replaceButton;
    // problem: if the same element is replaced by itself, the bonds around disappear
    // the same problem: when at least one selected atom is the same as the replaced
    // therefore - it must be examined first, if there is some atom to be replaced by the same element
    // if yes, all the bonds should be re-created
    // if no, more efficient code can be applied which uses the already existing bonds, and adds the new ones to them
    {
        replaceButton = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                int atomBorderCol;
                int selectedBorderCol = Color.RED;
                int ind = 0;
                // new arraylist containing the indices of zmat to be replaced
                List<Integer> deleteAtoms = new ArrayList<>();
                List<MolCanvas_object> replacedAtoms = new ArrayList<>();
                List<MolCanvas_object> newBonds = new ArrayList<>();
                List<Integer> bondsColor = new ArrayList<>();
                int replacedAtomsCount = MolCanvas_canvasView.getSelectedAtomsCount();
                for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                    atomBorderCol = object.getAtomBorderColor1();
                    if (atomBorderCol == selectedBorderCol) {
                        if (object.getObjectType() == 1) {
                            bondsColor.add(object.getAtomNumber1());
                            replacedAtoms.add(new MolCanvas_object(object.getAtomNumber1(), object.getAtomSymbol1(),
                                    object.getAtomColor1(), object.getAtomBorderColor1(), object.getAtomRadius1_Ang(),
                                    object.getAtomRadius1_pix(), object.getTouchTime(), object.getAtom1X_Ang(),
                                    object.getAtom1Y_Ang(), object.getAtom1Z_Ang(), object.getAtom1X_pix(),
                                    object.getAtom1Y_pix(), object.getAtomNumber2(), object.getAtomSymbol2(),
                                    object.getAtomColor2(), object.getAtom2X_Ang(), object.getAtom2Y_Ang(),
                                    object.getAtom2Z_Ang(), object.getAtom2X_pix(), object.getAtom2Y_pix(),
                                    object.getAtom12X_Ang(), object.getAtom12Y_Ang(), object.getAtom12Z_Ang(),
                                    object.getAtom12X_pix(), object.getAtom12Y_pix(), object.getDist2D_pix(),
                                    object.getObjectType()));
                        }
                    }
                }
                bondsColor.sort(Comparator.comparing(a -> a.intValue()));
                for (MolCanvas_object object1 : MolCanvas_canvasView.zmat) {
                    if (object1.getObjectType() == 2 || object1.getObjectType() == 3) {
                        for (int atN : bondsColor) {
                            if (object1.getAtomNumber1() == atN || object1.getAtomNumber2() == atN) {
                                object1.setAtomBorderColor1(selectedBorderCol);
                            }
                        }
                    }
                }
                bondsColor.clear();
                // collect the indices to be deleted
                for (MolCanvas_object object2 : MolCanvas_canvasView.zmat) {
                    atomBorderCol = object2.getAtomBorderColor1();
                    if (atomBorderCol == selectedBorderCol) {
                        deleteAtoms.add(ind);
                        if (object2.getObjectType() == 1) {
                            bondsColor.add(object2.getAtomNumber1());
                        }
                    }
                    ind++;
                }
                // in order not to shift the indices of zmat when removing the lines,
                // the arraylist deleteAtoms with the indices to be removed from zmat should be reversed first
                Collections.reverse(deleteAtoms);
                // the selected entries are removed from zmat from the end to beginning
                for (int a : deleteAtoms) {
                    MolCanvas_canvasView.zmat.remove(a);
                }
                for (MolCanvas_object repl : replacedAtoms) {
                    newBonds.add(new MolCanvas_object(repl.getAtomNumber1(), MolCanvas_periodicTable.Element, MolCanvas_periodicTable.ElementColor,
                            MolCanvas_periodicTable.ElementBorderColor, MolCanvas_periodicTable.ElementRadius,
                            MolCanvas_methods.Radius_pix(MolCanvas_periodicTable.ElementRadius, MolCanvas_preferences.get().getValue("conv"),
                                    MolCanvas_preferences.get().getValue("radius_scale"), zoom_scale, repl.getAtom12Z_Ang()),
                            repl.getTouchTime(), repl.getAtom1X_Ang(), repl.getAtom1Y_Ang(), repl.getAtom1Z_Ang(),
                            repl.getAtom1X_pix(), repl.getAtom1Y_pix(), 0, "", 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                            0.0f, repl.getAtom1Z_Ang(), 0.0f, 0.0f, 0.0f, 1));

                    newBonds.add(new MolCanvas_object(repl.getAtomNumber1(), MolCanvas_periodicTable.Element,
                            MolCanvas_methods.getElementTextColor(MolCanvas_periodicTable.Element), MolCanvas_periodicTable.ElementBorderColor, 0,
                            MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), zoom_scale,
                                    repl.getAtom1Z_Ang()),
                            repl.getTouchTime(), repl.getAtom1X_Ang(), repl.getAtom1Y_Ang(), repl.getAtom1Z_Ang(),
                            repl.getAtom1X_pix() + MolCanvas_preferences.get().getValue("text_shift_x_pix"),
                            repl.getAtom1Y_pix() + MolCanvas_preferences.get().getValue("text_shift_y_pix"), 0, "", 0, 0.0f, 0.0f,
                            0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                            repl.getAtom1Z_Ang() + MolCanvas_preferences.get().getValue("text_shift_z_Ang"), 0.0f, 0.0f, 0.0f,
                            4));
                    // this less power demanding routine works only if there is one atom being replaced
                    if (replacedAtomsCount == 1){
                        for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                            if (object.getObjectType() == 1) {
                                float distanceFromAtoms = MolCanvas_methods.dist3D(repl.getAtom1X_Ang(), repl.getAtom1Y_Ang(),
                                        repl.getAtom1Z_Ang(), object.getAtom1X_Ang(), object.getAtom1Y_Ang(),
                                        object.getAtom1Z_Ang());
                                if (distanceFromAtoms <= (MolCanvas_preferences.get().getValue("bond_scale")
                                        * (MolCanvas_periodicTable.ElementRadius + object.getAtomRadius1_Ang()))
                                        && distanceFromAtoms != 0.0f) {
                                    // exclude the self distance, at the moment the next atom already is in zmat
                                    newBonds.add(new MolCanvas_object(repl.getAtomNumber1(), MolCanvas_periodicTable.Element,
                                            MolCanvas_periodicTable.ElementColor, MolCanvas_periodicTable.ElementBorderColor, 0,
                                            MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"), zoom_scale,
                                                    0.5f * (repl.getAtom1Z_Ang() + object.getAtom1Z_Ang())),
                                            object.getTouchTime(), repl.getAtom1X_Ang(), repl.getAtom1Y_Ang(),
                                            repl.getAtom1Z_Ang(), repl.getAtom1X_pix(), repl.getAtom1Y_pix(),
                                            object.getAtomNumber1(), object.getAtomSymbol1(), object.getAtomColor1(),
                                            object.getAtom1X_Ang(), object.getAtom1Y_Ang(), object.getAtom1Z_Ang(),
                                            object.getAtom1X_pix(), object.getAtom1Y_pix(),
                                            0.5f * (repl.getAtom1X_Ang() + object.getAtom1X_Ang()),
                                            0.5f * (repl.getAtom1Y_Ang() + object.getAtom1Y_Ang()),
                                            0.5f * (repl.getAtom1Z_Ang() + object.getAtom1Z_Ang()),
                                            0.5f * (repl.getAtom1X_pix() + object.getAtom1X_pix()),
                                            0.5f * (repl.getAtom1Y_pix() + object.getAtom1Y_pix()), 0.0f, 3));
                                } else if (distanceFromAtoms <= (MolCanvas_preferences.get().getValue("hydr_bond_scale")
                                        * (MolCanvas_periodicTable.ElementRadius + object.getAtomRadius1_Ang()))
                                        && distanceFromAtoms != 0.0f
                                        && ((MolCanvas_periodicTable.Element.equals("H") && (object.getAtomSymbol1().equals("F")
                                        || object.getAtomSymbol1().equals("O")
                                        || object.getAtomSymbol1().equals("Cl")
                                        || object.getAtomSymbol1().equals("N")))
                                        || (object.getAtomSymbol1().equals("H")
                                        && (MolCanvas_periodicTable.Element.equals("F")
                                        || MolCanvas_periodicTable.Element.equals("O")
                                        || MolCanvas_periodicTable.Element.equals("Cl")
                                        || MolCanvas_periodicTable.Element.equals("N"))))) {
                                    // exclude the self distance, at the moment the next atom already is in zmat
                                    newBonds.add(new MolCanvas_object(repl.getAtomNumber1(), MolCanvas_periodicTable.Element,
                                            MolCanvas_periodicTable.ElementColor, MolCanvas_periodicTable.ElementBorderColor, 0,
                                            MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"), zoom_scale,
                                                    0.5f * (repl.getAtom1Z_Ang() + object.getAtom1Z_Ang())),
                                            object.getTouchTime(), repl.getAtom1X_Ang(), repl.getAtom1Y_Ang(),
                                            repl.getAtom1Z_Ang(), repl.getAtom1X_pix(), repl.getAtom1Y_pix(),
                                            object.getAtomNumber1(), object.getAtomSymbol1(), object.getAtomColor1(),
                                            object.getAtom1X_Ang(), object.getAtom1Y_Ang(), object.getAtom1Z_Ang(),
                                            object.getAtom1X_pix(), object.getAtom1Y_pix(),
                                            0.5f * (repl.getAtom1X_Ang() + object.getAtom1X_Ang()),
                                            0.5f * (repl.getAtom1Y_Ang() + object.getAtom1Y_Ang()),
                                            0.5f * (repl.getAtom1Z_Ang() + object.getAtom1Z_Ang()),
                                            0.5f * (repl.getAtom1X_pix() + object.getAtom1X_pix()),
                                            0.5f * (repl.getAtom1Y_pix() + object.getAtom1Y_pix()), 0.0f, 2));
                                }
                            }
                        }
                    }
                }
                replacedAtoms.clear();
                MolCanvas_canvasView.zmat.addAll(newBonds);
                newBonds.clear();
                // the case when there is more atoms being replaced
                if (replacedAtomsCount > 1){
                    generateAllBonds();
                }
                MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtomNumber1()));
                // prevent the button to do sth when no atom is selected
                deleteAtoms.clear();
                // for correct displaying, the more distant objects are drawn first
                MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));

                molCanvasView.invalidate();
            }
        };
    }

    private View.OnClickListener importButton;

    {
        importButton = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read(getApplicationContext());
            }
        };
    }

    private View.OnClickListener exportButton;

    {
        exportButton = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                write(getApplicationContext());
            }
        };
    }

    private View.OnClickListener distButton;

    {
        distButton = new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub //
                int counter = 1;
                String result;
                float x1 = 0.0f;
                float y1 = 0.0f;
                float z1 = 0.0f;
                float x2 = 0.0f;
                float y2 = 0.0f;
                float z2 = 0.0f;
                int selectedAtomsCount = MolCanvas_canvasView.getSelectedAtomsCount();
                if (selectedAtomsCount == 2) {
                    MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getTouchTime()));
                    Collections.reverse(MolCanvas_canvasView.zmat);
                    for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                        if (object.getObjectType() == 1 && object.getAtomBorderColor1() == Color.RED) {
                            if (counter == 1) {
                                x1 = object.getAtom1X_Ang();
                                y1 = object.getAtom1Y_Ang();
                                z1 = object.getAtom1Z_Ang();
                            } else if (counter == 2) {
                                x2 = object.getAtom1X_Ang();
                                y2 = object.getAtom1Y_Ang();
                                z2 = object.getAtom1Z_Ang();
                            }
                            counter++;
                        }
                    }
                    result = calculateDist(x1, y1, z1, x2, y2, z2);
                    final AlertDialog dialog = new AlertDialog.Builder(MolCanvas_main.this)
                            .setMessage("distance = " + result + " Ang").setTitle("Distance measurement")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            }).create();
                    dialog.show();
                    MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                } else {
                    final AlertDialog dialog = new AlertDialog.Builder(MolCanvas_main.this)
                            .setMessage("Error: select 2 atoms.").setTitle("Distance measurement")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            }).create();
                    dialog.show();
                }
                MolCanvas_canvasView.unselectMolCanvas_objects();
                molCanvasView.setMoleculeRenderer(MolCanvas_canvasView.TRUE);
            }
        };
    }

    private View.OnClickListener angButton;

    {
        angButton = new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub //
                int counter = 1;
                String result;
                float x1 = 0.0f;
                float y1 = 0.0f;
                float z1 = 0.0f;
                float x2 = 0.0f;
                float y2 = 0.0f;
                float z2 = 0.0f;
                float x3 = 0.0f;
                float y3 = 0.0f;
                float z3 = 0.0f;
                int selectedAtomsCount = MolCanvas_canvasView.getSelectedAtomsCount();
                if (selectedAtomsCount == 3) {
                    MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getTouchTime()));
                    Collections.reverse(MolCanvas_canvasView.zmat);
                    for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                        if (object.getObjectType() == 1 && object.getAtomBorderColor1() == Color.RED) {
                            if (counter == 1) {
                                x1 = object.getAtom1X_Ang();
                                y1 = object.getAtom1Y_Ang();
                                z1 = object.getAtom1Z_Ang();
                            } else if (counter == 2) {
                                x2 = object.getAtom1X_Ang();
                                y2 = object.getAtom1Y_Ang();
                                z2 = object.getAtom1Z_Ang();
                            } else if (counter == 3) {
                                x3 = object.getAtom1X_Ang();
                                y3 = object.getAtom1Y_Ang();
                                z3 = object.getAtom1Z_Ang();
                            }
                            counter++;
                        }
                    }
                    result = calculateAng(x1, y1, z1, x2, y2, z2, x3, y3, z3);
                    final AlertDialog dialog = new AlertDialog.Builder(MolCanvas_main.this)
                            .setMessage("angle = " + result + " deg").setTitle("Angle measurement")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            }).create();
                    dialog.show();
                    MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                } else {
                    final AlertDialog dialog = new AlertDialog.Builder(MolCanvas_main.this)
                            .setMessage("Error: select 3 atoms.").setTitle("Angle measurement")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            }).create();
                    dialog.show();
                }
                MolCanvas_canvasView.unselectMolCanvas_objects();
                molCanvasView.setMoleculeRenderer(MolCanvas_canvasView.TRUE);
            }
        };
    }

    private View.OnClickListener dihButton;

    {
        dihButton = new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub //
                int counter = 1;
                String result;
                float x1 = 0.0f;
                float y1 = 0.0f;
                float z1 = 0.0f;
                float x2 = 0.0f;
                float y2 = 0.0f;
                float z2 = 0.0f;
                float x3 = 0.0f;
                float y3 = 0.0f;
                float z3 = 0.0f;
                float x4 = 0.0f;
                float y4 = 0.0f;
                float z4 = 0.0f;
                int selectedAtomsCount = MolCanvas_canvasView.getSelectedAtomsCount();
                if (selectedAtomsCount == 4) {
                    MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getTouchTime()));
                    Collections.reverse(MolCanvas_canvasView.zmat);
                    for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                        if (object.getObjectType() == 1 && object.getAtomBorderColor1() == Color.RED) {
                            if (counter == 1) {
                                x1 = object.getAtom1X_Ang();
                                y1 = object.getAtom1Y_Ang();
                                z1 = object.getAtom1Z_Ang();
                            } else if (counter == 2) {
                                x2 = object.getAtom1X_Ang();
                                y2 = object.getAtom1Y_Ang();
                                z2 = object.getAtom1Z_Ang();
                            } else if (counter == 3) {
                                x3 = object.getAtom1X_Ang();
                                y3 = object.getAtom1Y_Ang();
                                z3 = object.getAtom1Z_Ang();
                            } else if (counter == 4) {
                                x4 = object.getAtom1X_Ang();
                                y4 = object.getAtom1Y_Ang();
                                z4 = object.getAtom1Z_Ang();
                            }
                            counter++;
                        }
                    }
                    result = calculateDih(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
                    final AlertDialog dialog = new AlertDialog.Builder(MolCanvas_main.this)
                            .setMessage("dihedral angle = " + result + " deg").setTitle("Dihedral angle measurement")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            }).create();
                    dialog.show();
                    MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                } else {
                    final AlertDialog dialog = new AlertDialog.Builder(MolCanvas_main.this)
                            .setMessage("Error: select 4 atoms.").setTitle("Dihedral angle measurement")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            }).create();
                    dialog.show();
                }
                MolCanvas_canvasView.unselectMolCanvas_objects();
                molCanvasView.setMoleculeRenderer(MolCanvas_canvasView.TRUE);
            }
        };
    }

    private View.OnClickListener reorderButton;

    {
        reorderButton = new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub //
                int counter = 1;
                int selectedAtomsCount = MolCanvas_canvasView.getSelectedAtomsCount();
                int atomsCount = MolCanvas_canvasView.getElementNumber();
                if (selectedAtomsCount == atomsCount) {
                    MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getTouchTime()));
                    for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                        if (object.getObjectType() == 1) {
                            renumberList.add(new MolCanvas_renumber(object.getAtomNumber1(), counter));
                            counter++;
                        }
                    }
                    for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                        int at1_old = object.getAtomNumber1();
                        int at2_old = object.getAtomNumber2();
                        for (MolCanvas_renumber renumber : renumberList) {
                            if (at1_old == renumber.AtomNumber_old) {
                                object.setAtomNumber1(renumber.AtomNumber_new);
                            }
                            if (at2_old == renumber.AtomNumber_old) {
                                object.setAtomNumber2(renumber.AtomNumber_new);
                            }
                        }
                    }
                    renumberList.clear();
                    MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                } else if (selectedAtomsCount != atomsCount) {
                    final AlertDialog dialog = new AlertDialog.Builder(MolCanvas_main.this)
                            .setMessage("Error: select all atoms.").setTitle("Reorder Z-matrix")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            }).create();
                    dialog.show();
                }
                MolCanvas_canvasView.unselectMolCanvas_objects();
                molCanvasView.setMoleculeRenderer(MolCanvas_canvasView.TRUE);
            }
        };
    }

    public static String calculateDist(float x1, float y1, float z1, float x2, float y2, float z2) {
        double distanceAng = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2));
        String distanceAng_formatted = String.format("%.4f", distanceAng);
        while (distanceAng_formatted.contains(",")) {
            distanceAng_formatted = distanceAng_formatted.replace(",", ".");
        }
        return distanceAng_formatted;
    }

    public static String calculateAng(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3,
                                      float z3) {
        double vect_a_len = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2));
        double vect_a_x = (x1 - x2) / vect_a_len;
        double vect_a_y = (y1 - y2) / vect_a_len;
        double vect_a_z = (z1 - z2) / vect_a_len;

        double vect_b_len = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2) + Math.pow((z2 - z3), 2));
        double vect_b_x = (x3 - x2) / vect_b_len;
        double vect_b_y = (y3 - y2) / vect_b_len;
        double vect_b_z = (z3 - z2) / vect_b_len;

        double dot_product_a_b = vect_a_x * vect_b_x + vect_a_y * vect_b_y + vect_a_z * vect_b_z;

        double angleDeg = (360 / (2 * 3.14159265359)) * Math.acos(dot_product_a_b);

        String angleDeg_formatted = String.format("%.4f", angleDeg);
        while (angleDeg_formatted.contains(",")) {
            angleDeg_formatted = angleDeg_formatted.replace(",", ".");
        }
        return angleDeg_formatted;
    }

    public static String calculateDih(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3,
                                      float z3, float x4, float y4, float z4) {
        double vect_a_len = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2));
        double vect_a_x = (x2 - x1) / vect_a_len;
        double vect_a_y = (y2 - y1) / vect_a_len;
        double vect_a_z = (z2 - z1) / vect_a_len;

        double vect_b_len = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2) + Math.pow((z2 - z3), 2));
        double vect_b_x = (x2 - x3) / vect_b_len;
        double vect_b_y = (y2 - y3) / vect_b_len;
        double vect_b_z = (z2 - z3) / vect_b_len;

        double vect_c_len = Math.sqrt(Math.pow((x3 - x4), 2) + Math.pow((y3 - y4), 2) + Math.pow((z3 - z4), 2));
        double vect_c_x = (x4 - x3) / vect_c_len;
        double vect_c_y = (y4 - y3) / vect_c_len;
        double vect_c_z = (z4 - z3) / vect_c_len;

        double n1_x = vect_a_y * vect_b_z - vect_a_z * vect_b_y;
        double n1_y = vect_a_z * vect_b_x - vect_a_x * vect_b_z;
        double n1_z = vect_a_x * vect_b_y - vect_a_y * vect_b_x;

        double n2_x = vect_b_y * vect_c_z - vect_b_z * vect_c_y;
        double n2_y = vect_b_z * vect_c_x - vect_b_x * vect_c_z;
        double n2_z = vect_b_x * vect_c_y - vect_b_y * vect_c_x;

        double m_x = n1_y * vect_b_z - n1_z * vect_b_y;
        double m_y = n1_z * vect_b_x - n1_x * vect_b_z;
        double m_z = n1_x * vect_b_y - n1_y * vect_b_x;

        double dot_product_n1_n2 = n1_x * n2_x + n1_y * n2_y + n1_z * n2_z;
        double dot_product_m_n2 = m_x * n2_x + m_y * n2_y + m_z * n2_z;

        double dihDeg = (360 / (2 * 3.14159265359)) * Math.atan2(dot_product_m_n2, dot_product_n1_n2);

        String dihDeg_formatted = String.format("%.4f", dihDeg);
        while (dihDeg_formatted.contains(",")) {
            dihDeg_formatted = dihDeg_formatted.replace(",", ".");
        }
        return dihDeg_formatted;
    }

    public void deleteAtoms() {
        int atomBorderCol;
        int selectedBorderCol = Color.RED;
        int ind = 0;
        int counter = 1;
        // new arraylist containing the indices of zmat to be removed
        List<Integer> deleteAtoms = new ArrayList<>();
        List<MolCanvas_renumber> renumberAtoms = new ArrayList<>();
        List<Integer> bondsColor = new ArrayList<>();
        for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
            atomBorderCol = object.getAtomBorderColor1();
            if (atomBorderCol == selectedBorderCol) {
                if (object.getObjectType() == 1) {
                    bondsColor.add(object.getAtomNumber1());
                }
            }
        }
        bondsColor.sort(Comparator.comparing(a -> a.intValue()));
        for (MolCanvas_object object1 : MolCanvas_canvasView.zmat) {
            if (object1.getObjectType() == 2 || object1.getObjectType() == 3) {
                for (int atN : bondsColor) {
                    if (object1.getAtomNumber1() == atN || object1.getAtomNumber2() == atN) {
                        object1.setAtomBorderColor1(selectedBorderCol);
                    }
                }
            }
        }
        bondsColor.clear();
        // collect the indices to be deleted
        for (MolCanvas_object object2 : MolCanvas_canvasView.zmat) {
            atomBorderCol = object2.getAtomBorderColor1();
            if (atomBorderCol == selectedBorderCol) {
                deleteAtoms.add(ind);
                if (object2.getObjectType() == 1) {
                    bondsColor.add(object2.getAtomNumber1());
                }
            }
            ind++;
            if (atomBorderCol != selectedBorderCol && object2.getObjectType() == 1) {
                renumberAtoms.add(new MolCanvas_renumber(object2.getAtomNumber1(), counter));
                counter++;
            }
        }
        // in order not to shift the indices of zmat when removing the lines,
        // the arraylist deleteAtoms with the indices to be removed from zmat should be reversed first
        Collections.reverse(deleteAtoms);
        // the selected entries are removed from zmat from the end to beginning
        for (int a : deleteAtoms) {
            MolCanvas_canvasView.zmat.remove(a);
        }
        MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtomNumber1()));
        // prevent the button to do sth when no atom is selected
        if (deleteAtoms.size() > 0) {
            for (MolCanvas_object object3 : MolCanvas_canvasView.zmat) {
                int atom1_old = object3.getAtomNumber1();
                int atom2_old = object3.getAtomNumber2();
                for (MolCanvas_renumber renumberAt : renumberAtoms) {
                    if (atom1_old == renumberAt.AtomNumber_old) {
                        object3.setAtomNumber1(renumberAt.AtomNumber_new);
                    }
                    if (atom2_old == renumberAt.AtomNumber_old) {
                        object3.setAtomNumber2(renumberAt.AtomNumber_new);
                    }
                }
            }
            renumberList.clear();
        }
        deleteAtoms.clear();
        // for correct displaying, the more distant objects are drawn first
        MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
    }

    private void read(Context context) {
        Intent intent1 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        startActivityForResult(intent1, READ_FILE);
    }

    private void write(Context context) {
        Intent intent2 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent2.addCategory(Intent.CATEGORY_OPENABLE);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TITLE, "Structure");
        startActivityForResult(intent2, CREATE_FILE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE && data != null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Please wait...");
            progressDialog.setMessage("Importing the structure...");
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
                        documentUri1 = data.getData();
                        String myData = "";
                        ParcelFileDescriptor pfd = getContentResolver().openFileDescriptor(data.getData(), "r");
                        FileInputStream fileInputStream = new FileInputStream(pfd.getFileDescriptor());
                        DataInputStream inp = new DataInputStream(fileInputStream);
                        BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                        String strLine;
                        while ((strLine = br.readLine()) != null) {
                            myData = myData + strLine + "\n";
                        }
                        inp.close();
                        // content of the XYZ file may contain spaces, tabs in any number and combination
                        while (myData.contains("\t")) {
                            myData = myData.replace("\t", " ");
                        }
                        while (myData.contains("  ")) {
                            myData = myData.replace("  ", " ");
                        }
                        while (myData.contains("\n ")) {
                            myData = myData.replace("\n ", "\n");
                        }
                        br.close();
                        pfd.close();
                        // remove first two lines
                        // myData = myData.substring(myData.indexOf(System.getProperty("line.separator")) + 2);
                        // remove first line
                        myData = myData.substring(myData.indexOf(System.getProperty("line.separator"))+1);
                        // remove second line
                        myData = myData.substring(myData.indexOf(System.getProperty("line.separator"))+1);
                        MolCanvas_canvasView.zmat.clear();
                        int lineNum = 0;
                        String[] curLine = myData.split("\\n");
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
                            MolCanvas_canvasView.zmat.add(new MolCanvas_object(lineNum, atom, MolCanvas_methods.getElementColor(atom),
                                    MolCanvas_periodicTable.ElementBorderColor, MolCanvas_methods.getElementRadius(atom),
                                    MolCanvas_methods.Radius_pix(MolCanvas_methods.getElementRadius(atom),
                                            MolCanvas_preferences.get().getValue("conv"),
                                            MolCanvas_preferences.get().getValue("radius_scale"), zoom_scale, z_coord),
                                    0, x_coord, y_coord, z_coord,
                                    MolCanvas_methods.AtomX_pix(x_coord, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.width_pix,
                                            zoom_scale),
                                    MolCanvas_methods.AtomY_pix(y_coord, MolCanvas_preferences.get().getValue("conv"),
                                            MolCanvas_canvasView.height_pix, zoom_scale),
                                    0, "", MolCanvas_methods.getElementTextColor(atom), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                    z_coord, 0.0f, 0.0f, 0.0f, 1));
                        }
                        for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
                            if (object.getObjectType() == 1) {
                                generatedLabels.add(new MolCanvas_object(object.getAtomNumber1(), object.getAtomSymbol1(),
                                        MolCanvas_methods.getElementTextColor(object.getAtomSymbol1()),
                                        object.getAtomBorderColor1(), 0,
                                        MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), zoom_scale,
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
                        MolCanvas_canvasView.zmat.addAll(generatedLabels);
                        generatedLabels.clear();
                        generateAllBonds();
                        MolCanvas_canvasView.zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    molCanvasView.setMoleculeRenderer(MolCanvas_canvasView.TRUE);
                    onFinish();
                }

                public void onFinish() {
                    progressDialog.dismiss();
                }
            }.start();
        }

        if (requestCode == CREATE_FILE && data != null) {
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();

            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Please wait...");
            progressDialog.setMessage("Exporting the structure...");
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
                        documentUri2 = data.getData();
                        ParcelFileDescriptor pfd = getContentResolver().openFileDescriptor(data.getData(), "w");
                        FileOutputStream fileOutputStream = new FileOutputStream(pfd.getFileDescriptor());
                        String fileContents = getStructureXYZ();
                        fileOutputStream.write((fileContents).getBytes());
                        fileOutputStream.close();
                        pfd.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
                    }

                    molCanvasView.setMoleculeRenderer(MolCanvas_canvasView.TRUE);
                    onFinish();
                }

                public void onFinish() {
                    progressDialog.dismiss();
                }
            }.start();
        }
    }

    public String getStructureXYZ() {
        int atomCount = MolCanvas_canvasView.getElementNumber();
        String XYZ_content = String.valueOf(atomCount) + "\n\n";
        float x_coord = 0;
        float y_coord = 0;
        float z_coord = 0;

        for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
            if (object.getObjectType() == 1) {
                String objSymbol = object.getAtomSymbol1();
                x_coord = object.getAtom1X_Ang();
                y_coord = object.getAtom1Y_Ang();
                z_coord = object.getAtom1Z_Ang();
                double x_double = Double.valueOf(x_coord);
                double y_double = Double.valueOf(y_coord);
                double z_double = Double.valueOf(z_coord);
                String x_formatted = String.format("%.4f", x_double);
                String y_formatted = String.format("%.4f", y_double);
                String z_formatted = String.format("%.4f", z_double);
                while (x_formatted.contains(",")) {
                    x_formatted = x_formatted.replace(",", ".");
                }
                while (y_formatted.contains(",")) {
                    y_formatted = y_formatted.replace(",", ".");
                }
                while (z_formatted.contains(",")) {
                    z_formatted = z_formatted.replace(",", ".");
                }
                XYZ_content = XYZ_content + objSymbol + " " + x_formatted + " " + y_formatted + " "
                        + z_formatted + "\n";
            }
        }
        return XYZ_content;
    }

    @Override
    protected void onPause() {
        super.onPause();
        zoom_scale = MolCanvas_preferences.get().getValue("zoom");
    }

    @Override
    protected void onResume() {
        super.onResume();
        zoom_scale = MolCanvas_preferences.get().getValue("zoom");
        for (MolCanvas_object object : MolCanvas_canvasView.zmat) {
            float x1_Ang = object.getAtom1X_Ang();
            float y1_Ang = object.getAtom1Y_Ang();
            float z1_Ang = object.getAtom1Z_Ang();
            float x2_Ang = object.getAtom2X_Ang();
            float y2_Ang = object.getAtom2Y_Ang();
            float z2_Ang = object.getAtom2Z_Ang();
            float x12_Ang = object.getAtom12X_Ang();
            float y12_Ang = object.getAtom12Y_Ang();
            float x1_proj = MolCanvas_methods.AtomX_pix(x1_Ang, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.width_pix,
                    zoom_scale);
            float y1_proj = MolCanvas_methods.AtomY_pix(y1_Ang, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.height_pix,
                    zoom_scale);
            float x2_proj = MolCanvas_methods.AtomX_pix(x2_Ang, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.width_pix,
                    zoom_scale);
            float y2_proj = MolCanvas_methods.AtomY_pix(y2_Ang, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.height_pix,
                    zoom_scale);
            float x12_proj = MolCanvas_methods.AtomX_pix(x12_Ang, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.width_pix,
                    zoom_scale);
            float y12_proj = MolCanvas_methods.AtomY_pix(y12_Ang, MolCanvas_preferences.get().getValue("conv"), MolCanvas_canvasView.height_pix,
                    zoom_scale);
            if (object.getObjectType() == 4) {
                object.setAtomColor1(MolCanvas_methods.getElementTextColor(object.getAtomSymbol1()));
                object.setAtom1X_pix(x1_proj + MolCanvas_preferences.get().getValue("text_shift_x_pix"));
                object.setAtom1Y_pix(y1_proj + MolCanvas_preferences.get().getValue("text_shift_y_pix"));
                object.setAtom12Z_Ang(z1_Ang + MolCanvas_preferences.get().getValue("text_shift_z_Ang"));
                object.setAtomRadius1_pix(
                        MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), zoom_scale, z1_Ang));
            } else {
                object.setAtom1X_pix(x1_proj);
                object.setAtom1Y_pix(y1_proj);
            }
            if (object.getObjectType() == 1) {
                object.setAtomColor1(MolCanvas_methods.getElementColor(object.getAtomSymbol1()));
                float r_Ang = MolCanvas_methods.getElementRadius(object.getAtomSymbol1());
                object.setAtomRadius1_Ang(r_Ang);
                float r_proj = MolCanvas_methods.Radius_pix(r_Ang, MolCanvas_preferences.get().getValue("conv"),
                        MolCanvas_preferences.get().getValue("radius_scale"), zoom_scale, object.getAtom12Z_Ang());
                object.setAtomRadius1_pix(r_proj);
            }
            object.setAtom2X_pix(x2_proj);
            object.setAtom2Y_pix(y2_proj);
            object.setAtom12X_pix(x12_proj);
            object.setAtom12Y_pix(y12_proj);
            if (object.getObjectType() == 3) {
                float thickness = MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"), zoom_scale,
                        0.5f * (z1_Ang + z2_Ang));
                object.setAtomRadius1_pix(thickness);
                object.setAtomColor1(MolCanvas_methods.getElementColor(object.getAtomSymbol1()));
                object.setAtomColor2(MolCanvas_methods.getElementColor(object.getAtomSymbol2()));
            }
        }
        molCanvasView.setMoleculeRenderer(MolCanvas_canvasView.TRUE);
    }

    public static void generateAllBonds() {
        int ind1 = 1;
        float distanceFromAtoms;
        for (MolCanvas_object object1 : MolCanvas_canvasView.zmat) {
            if (object1.getObjectType() == 1) {
                int ind2 = 1;
                for (MolCanvas_object object2 : MolCanvas_canvasView.zmat) {
                    if (ind2 < ind1) {
                        if (object2.getObjectType() == 1) {
                            distanceFromAtoms = MolCanvas_methods.dist3D(object1.getAtom1X_Ang(), object1.getAtom1Y_Ang(),
                                    object1.getAtom1Z_Ang(), object2.getAtom1X_Ang(), object2.getAtom1Y_Ang(),
                                    object2.getAtom1Z_Ang());
                            if (distanceFromAtoms <= (MolCanvas_preferences.get().getValue("bond_scale")
                                    * (object1.getAtomRadius1_Ang() + object2.getAtomRadius1_Ang()))
                                    && distanceFromAtoms != 0.0f) {
                                generatedBonds.add(new MolCanvas_object(object1.getAtomNumber1(), object1.getAtomSymbol1(),
                                        object1.getAtomColor1(), object1.getAtomBorderColor1(), 0,
                                        MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"), zoom_scale,
                                                0.5f * (object1.getAtom1Z_Ang() + object2.getAtom1Z_Ang())),
                                        object1.getTouchTime(), object1.getAtom1X_Ang(), object1.getAtom1Y_Ang(),
                                        object1.getAtom1Z_Ang(), object1.getAtom1X_pix(), object1.getAtom1Y_pix(),
                                        object2.getAtomNumber1(), object2.getAtomSymbol1(), object2.getAtomColor1(),
                                        object2.getAtom1X_Ang(), object2.getAtom1Y_Ang(), object2.getAtom1Z_Ang(),
                                        object2.getAtom1X_pix(), object2.getAtom1Y_pix(),
                                        0.5f * (object1.getAtom1X_Ang() + object2.getAtom1X_Ang()),
                                        0.5f * (object1.getAtom1Y_Ang() + object2.getAtom1Y_Ang()),
                                        0.5f * (object1.getAtom1Z_Ang() + object2.getAtom1Z_Ang()),
                                        0.5f * (object1.getAtom1X_pix() + object2.getAtom1X_pix()),
                                        0.5f * (object1.getAtom1Y_pix() + object2.getAtom1Y_pix()), 0.0f, 3));
                            } else if (distanceFromAtoms <= (MolCanvas_preferences.get().getValue("hydr_bond_scale")
                                    * (object1.getAtomRadius1_Ang() + object2.getAtomRadius1_Ang()))
                                    && distanceFromAtoms != 0.0f
                                    && ((object1.getAtomSymbol1().equals("H") && (object2.getAtomSymbol1().equals("F")
                                    || object2.getAtomSymbol1().equals("O")
                                    || object2.getAtomSymbol1().equals("Cl")
                                    || object2.getAtomSymbol1().equals("N")))
                                    || (object2.getAtomSymbol1().equals("H")
                                    && (object1.getAtomSymbol1().equals("F")
                                    || object1.getAtomSymbol1().equals("O")
                                    || object1.getAtomSymbol1().equals("Cl")
                                    || object1.getAtomSymbol1().equals("N"))))) {
                                generatedBonds.add(new MolCanvas_object(object1.getAtomNumber1(), object1.getAtomSymbol1(),
                                        object1.getAtomColor1(), object1.getAtomBorderColor1(), 0,
                                        MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"), zoom_scale,
                                                0.5f * (object1.getAtom1Z_Ang() + object2.getAtom1Z_Ang())),
                                        object1.getTouchTime(), object1.getAtom1X_Ang(), object1.getAtom1Y_Ang(),
                                        object1.getAtom1Z_Ang(), object1.getAtom1X_pix(), object1.getAtom1Y_pix(),
                                        object2.getAtomNumber1(), object2.getAtomSymbol1(), object2.getAtomColor1(),
                                        object2.getAtom1X_Ang(), object2.getAtom1Y_Ang(), object2.getAtom1Z_Ang(),
                                        object2.getAtom1X_pix(), object2.getAtom1Y_pix(),
                                        0.5f * (object1.getAtom1X_Ang() + object2.getAtom1X_Ang()),
                                        0.5f * (object1.getAtom1Y_Ang() + object2.getAtom1Y_Ang()),
                                        0.5f * (object1.getAtom1Z_Ang() + object2.getAtom1Z_Ang()),
                                        0.5f * (object1.getAtom1X_pix() + object2.getAtom1X_pix()),
                                        0.5f * (object1.getAtom1Y_pix() + object2.getAtom1Y_pix()), 0.0f, 2));
                            }
                        }
                    }
                    ind2++;
                }
            }
            ind1++;
        }
        MolCanvas_canvasView.zmat.addAll(generatedBonds);
        generatedBonds.clear();
    }

    public static void setDefaultValues() {
        MolCanvas_preferences.get().setIntValue("color_background", Color.BLACK);

        MolCanvas_preferences.get().setValue("zoom", 1.0f);
        MolCanvas_preferences.get().setValue("conv", 100.0f);
        MolCanvas_preferences.get().setValue("zoom_scale", 0.01f);
        MolCanvas_preferences.get().setValue("persp_scale", 0.1f);
        MolCanvas_preferences.get().setValue("radius_scale", 0.5f);
        MolCanvas_preferences.get().setValue("angle_scale", 0.15f);
        MolCanvas_preferences.get().setValue("z_angle_scale", 4.0f);
        MolCanvas_preferences.get().setValue("transl_scale", 1.0f);
        MolCanvas_preferences.get().setValue("z_transl_scale", 3.0f);
        MolCanvas_preferences.get().setValue("bond_scale", 1.2f);
        MolCanvas_preferences.get().setValue("hydr_bond_scale", 1.5f);
        MolCanvas_preferences.get().setValue("minDistCrit_pix", 50.0f);
        MolCanvas_preferences.get().setValue("text_size", 40.0f);
        MolCanvas_preferences.get().setValue("text_shift_z_Ang", 1.0f);
        MolCanvas_preferences.get().setValue("text_shift_x_pix", -0.5f * MolCanvas_preferences.get().getValue("text_size"));
        MolCanvas_preferences.get().setValue("text_shift_y_pix", 0.5f * MolCanvas_preferences.get().getValue("text_size"));
        MolCanvas_preferences.get().setValue("bondsStrokeWidth", 15.0f);
        MolCanvas_preferences.get().setValue("bordersStrokeWidth", 2.0f);
        MolCanvas_preferences.get().setIntValue("selectedColor", Color.RED);
        MolCanvas_preferences.get().setIntValue("unselectedColor", Color.BLACK);

        MolCanvas_preferences.get().setValue("r_H", 0.37f);
        MolCanvas_preferences.get().setValue("r_He", 1.20f);
        MolCanvas_preferences.get().setValue("r_Li", 1.45f);
        MolCanvas_preferences.get().setValue("r_Be", 1.05f);
        MolCanvas_preferences.get().setValue("r_B", 0.85f);
        MolCanvas_preferences.get().setValue("r_C", 0.70f);
        MolCanvas_preferences.get().setValue("r_N", 0.65f);
        MolCanvas_preferences.get().setValue("r_O", 0.60f);
        MolCanvas_preferences.get().setValue("r_F", 0.50f);
        MolCanvas_preferences.get().setValue("r_Ne", 1.60f);
        MolCanvas_preferences.get().setValue("r_Na", 1.80f);
        MolCanvas_preferences.get().setValue("r_Mg", 1.50f);
        MolCanvas_preferences.get().setValue("r_Al", 1.25f);
        MolCanvas_preferences.get().setValue("r_Si", 1.10f);
        MolCanvas_preferences.get().setValue("r_P", 1.00f);
        MolCanvas_preferences.get().setValue("r_S", 1.00f);
        MolCanvas_preferences.get().setValue("r_Cl", 1.00f);
        MolCanvas_preferences.get().setValue("r_Ar", 0.71f);
        MolCanvas_preferences.get().setValue("r_K", 2.20f);
        MolCanvas_preferences.get().setValue("r_Ca", 1.80f);
        MolCanvas_preferences.get().setValue("r_Sc", 1.60f);
        MolCanvas_preferences.get().setValue("r_Ti", 1.40f);
        MolCanvas_preferences.get().setValue("r_V", 1.35f);
        MolCanvas_preferences.get().setValue("r_Cr", 1.40f);
        MolCanvas_preferences.get().setValue("r_Mn", 1.40f);
        MolCanvas_preferences.get().setValue("r_Fe", 1.40f);
        MolCanvas_preferences.get().setValue("r_Co", 1.35f);
        MolCanvas_preferences.get().setValue("r_Ni", 1.35f);
        MolCanvas_preferences.get().setValue("r_Cu", 1.35f);
        MolCanvas_preferences.get().setValue("r_Zn", 1.35f);
        MolCanvas_preferences.get().setValue("r_Ga", 1.30f);
        MolCanvas_preferences.get().setValue("r_Ge", 1.25f);
        MolCanvas_preferences.get().setValue("r_As", 1.15f);
        MolCanvas_preferences.get().setValue("r_Se", 1.15f);
        MolCanvas_preferences.get().setValue("r_Br", 1.15f);
        MolCanvas_preferences.get().setValue("r_Kr", 1.00f);
        MolCanvas_preferences.get().setValue("r_Rb", 2.35f);
        MolCanvas_preferences.get().setValue("r_Sr", 2.00f);
        MolCanvas_preferences.get().setValue("r_Y", 1.80f);
        MolCanvas_preferences.get().setValue("r_Zr", 1.55f);
        MolCanvas_preferences.get().setValue("r_Nb", 1.45f);
        MolCanvas_preferences.get().setValue("r_Mo", 1.45f);
        MolCanvas_preferences.get().setValue("r_Tc", 1.35f);
        MolCanvas_preferences.get().setValue("r_Ru", 1.30f);
        MolCanvas_preferences.get().setValue("r_Rh", 1.35f);
        MolCanvas_preferences.get().setValue("r_Pd", 1.40f);
        MolCanvas_preferences.get().setValue("r_Ag", 1.60f);
        MolCanvas_preferences.get().setValue("r_Cd", 1.55f);
        MolCanvas_preferences.get().setValue("r_In", 1.45f);
        MolCanvas_preferences.get().setValue("r_Sn", 1.45f);
        MolCanvas_preferences.get().setValue("r_Sb", 1.45f);
        MolCanvas_preferences.get().setValue("r_Te", 1.40f);
        MolCanvas_preferences.get().setValue("r_I", 1.40f);
        MolCanvas_preferences.get().setValue("r_Xe", 1.20f);
        MolCanvas_preferences.get().setValue("r_Cs", 2.60f);
        MolCanvas_preferences.get().setValue("r_Ba", 2.15f);
        MolCanvas_preferences.get().setValue("r_La", 1.95f);
        MolCanvas_preferences.get().setValue("r_Ce", 1.85f);
        MolCanvas_preferences.get().setValue("r_Pr", 1.85f);
        MolCanvas_preferences.get().setValue("r_Nd", 1.85f);
        MolCanvas_preferences.get().setValue("r_Pm", 1.85f);
        MolCanvas_preferences.get().setValue("r_Sm", 1.85f);
        MolCanvas_preferences.get().setValue("r_Eu", 1.85f);
        MolCanvas_preferences.get().setValue("r_Gd", 1.80f);
        MolCanvas_preferences.get().setValue("r_Tb", 1.75f);
        MolCanvas_preferences.get().setValue("r_Dy", 1.75f);
        MolCanvas_preferences.get().setValue("r_Ho", 1.75f);
        MolCanvas_preferences.get().setValue("r_Er", 1.75f);
        MolCanvas_preferences.get().setValue("r_Tm", 1.75f);
        MolCanvas_preferences.get().setValue("r_Yb", 1.75f);
        MolCanvas_preferences.get().setValue("r_Lu", 1.75f);
        MolCanvas_preferences.get().setValue("r_Hf", 1.55f);
        MolCanvas_preferences.get().setValue("r_Ta", 1.45f);
        MolCanvas_preferences.get().setValue("r_W", 1.35f);
        MolCanvas_preferences.get().setValue("r_Re", 1.35f);
        MolCanvas_preferences.get().setValue("r_Os", 1.30f);
        MolCanvas_preferences.get().setValue("r_Ir", 1.35f);
        MolCanvas_preferences.get().setValue("r_Pt", 1.35f);
        MolCanvas_preferences.get().setValue("r_Au", 1.35f);
        MolCanvas_preferences.get().setValue("r_Hg", 1.50f);
        MolCanvas_preferences.get().setValue("r_Tl", 1.90f);
        MolCanvas_preferences.get().setValue("r_Pb", 1.80f);
        MolCanvas_preferences.get().setValue("r_Bi", 1.60f);
        MolCanvas_preferences.get().setValue("r_Po", 1.90f);
        MolCanvas_preferences.get().setValue("r_At", 1.60f);
        MolCanvas_preferences.get().setValue("r_Rn", 1.60f);
        MolCanvas_preferences.get().setValue("r_Fr", 2.20f);
        MolCanvas_preferences.get().setValue("r_Ra", 2.15f);
        MolCanvas_preferences.get().setValue("r_Ac", 1.95f);
        MolCanvas_preferences.get().setValue("r_Th", 1.80f);
        MolCanvas_preferences.get().setValue("r_Pa", 1.80f);
        MolCanvas_preferences.get().setValue("r_U", 1.75f);
        MolCanvas_preferences.get().setValue("r_Np", 1.75f);
        MolCanvas_preferences.get().setValue("r_Pu", 1.75f);
        MolCanvas_preferences.get().setValue("r_Am", 1.75f);
        MolCanvas_preferences.get().setValue("r_Cm", 1.76f);
        MolCanvas_preferences.get().setValue("r_Bk", 1.70f);
        MolCanvas_preferences.get().setValue("r_Cf", 1.70f);
        MolCanvas_preferences.get().setValue("r_Es", 1.70f);
        MolCanvas_preferences.get().setValue("r_Fm", 1.70f);
        MolCanvas_preferences.get().setValue("r_Md", 1.70f);
        MolCanvas_preferences.get().setValue("r_No", 1.70f);
        MolCanvas_preferences.get().setValue("r_Lr", 1.70f);
        MolCanvas_preferences.get().setValue("r_Rf", 1.70f);
        MolCanvas_preferences.get().setValue("r_Db", 1.70f);
        MolCanvas_preferences.get().setValue("r_Sg", 1.70f);
        MolCanvas_preferences.get().setValue("r_Bh", 1.70f);
        MolCanvas_preferences.get().setValue("r_Hs", 1.70f);
        MolCanvas_preferences.get().setValue("r_Mt", 1.70f);
        MolCanvas_preferences.get().setValue("r_Ds", 1.70f);
        MolCanvas_preferences.get().setValue("r_Rg", 1.70f);
        MolCanvas_preferences.get().setValue("r_Cn", 1.70f);
        MolCanvas_preferences.get().setValue("r_Nh", 1.70f);
        MolCanvas_preferences.get().setValue("r_Fl", 1.70f);
        MolCanvas_preferences.get().setValue("r_Mc", 1.70f);
        MolCanvas_preferences.get().setValue("r_Lv", 1.70f);
        MolCanvas_preferences.get().setValue("r_Ts", 1.70f);
        MolCanvas_preferences.get().setValue("r_Og", 1.70f);

        MolCanvas_preferences.get().setIntValue("color_H", Color.LTGRAY);
        MolCanvas_preferences.get().setIntValue("color_He", Color.parseColor("#27d9ca"));
        MolCanvas_preferences.get().setIntValue("color_Li", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("color_Be", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("color_B", Color.parseColor("#ad39ad"));
        MolCanvas_preferences.get().setIntValue("color_C", Color.parseColor("#915336"));
        MolCanvas_preferences.get().setIntValue("color_N", Color.parseColor("#aedcf5"));
        MolCanvas_preferences.get().setIntValue("color_O", Color.parseColor("#bf2225"));
        MolCanvas_preferences.get().setIntValue("color_F", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ne", Color.parseColor("#e89b48"));
        MolCanvas_preferences.get().setIntValue("color_Na", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("color_Mg", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("color_Al", Color.parseColor("#aac0e3"));
        MolCanvas_preferences.get().setIntValue("color_Si", Color.parseColor("#f0e6b9"));
        MolCanvas_preferences.get().setIntValue("color_P", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_S", Color.YELLOW);
        MolCanvas_preferences.get().setIntValue("color_Cl", Color.GREEN);
        MolCanvas_preferences.get().setIntValue("color_Ar", Color.parseColor("#e89b48"));
        MolCanvas_preferences.get().setIntValue("color_K", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ca", Color.parseColor("#bf2225"));
        MolCanvas_preferences.get().setIntValue("color_Sc", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ti", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_V", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Cr", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Mn", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Fe", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Co", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ni", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Cu", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Zn", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ga", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ge", Color.parseColor("#bf2225"));
        MolCanvas_preferences.get().setIntValue("color_As", Color.parseColor("#bf2225"));
        MolCanvas_preferences.get().setIntValue("color_Se", Color.parseColor("#bf2225"));
        MolCanvas_preferences.get().setIntValue("color_Br", Color.parseColor("#bf2225"));
        MolCanvas_preferences.get().setIntValue("color_Kr", Color.parseColor("#e89b48"));
        MolCanvas_preferences.get().setIntValue("color_Rb", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Sr", Color.parseColor("#bf2225"));
        MolCanvas_preferences.get().setIntValue("color_Y", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Zr", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Nb", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Mo", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Tc", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ru", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Rh", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Pd", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ag", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Cd", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_In", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Sn", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Sb", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Te", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_I", Color.parseColor("#bf2225"));
        MolCanvas_preferences.get().setIntValue("color_Xe", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Cs", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ba", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_La", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ce", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Pr", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Nd", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Pm", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Sm", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Eu", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Gd", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Tb", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Dy", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ho", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Er", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Tm", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Yb", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Lu", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Hf", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ta", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_W", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Re", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Os", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ir", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Pt", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Au", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Hg", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Tl", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Pb", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Bi", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Po", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_At", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Rn", Color.parseColor("#27d9ca"));
        MolCanvas_preferences.get().setIntValue("color_Fr", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ra", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ac", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Th", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Pa", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_U", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Np", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Pu", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Am", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Cm", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Bk", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Cf", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Es", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Fm", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Md", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_No", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Lr", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Rf", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Db", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Sg", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Bh", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Hs", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Mt", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ds", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Rg", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Cn", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Nh", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Fl", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Mc", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Lv", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Ts", Color.parseColor("#c2a748"));
        MolCanvas_preferences.get().setIntValue("color_Og", Color.parseColor("#c2a748"));

        MolCanvas_preferences.get().setIntValue("text_color_H", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_He", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Li", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_Be", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_B", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_C", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_N", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_O", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_F", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ne", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Na", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_Mg", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_Al", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Si", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_P", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_S", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Cl", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ar", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_K", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ca", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_Sc", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ti", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_V", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Cr", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Mn", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Fe", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Co", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ni", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Cu", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Zn", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ga", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ge", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_As", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_Se", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_Br", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_Kr", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Rb", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Sr", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_Y", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Zr", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Nb", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Mo", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Tc", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ru", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Rh", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Pd", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ag", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Cd", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_In", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Sn", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Sb", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Te", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_I", Color.WHITE);
        MolCanvas_preferences.get().setIntValue("text_color_Xe", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Cs", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ba", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_La", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ce", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Pr", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Nd", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Pm", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Sm", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Eu", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Gd", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Tb", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Dy", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ho", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Er", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Tm", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Yb", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Lu", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Hf", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ta", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_W", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Re", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Os", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ir", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Pt", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Au", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Hg", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Tl", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Pb", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Bi", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Po", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_At", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Rn", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Fr", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ra", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ac", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Th", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Pa", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_U", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Np", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Pu", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Am", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Cm", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Bk", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Cf", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Es", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Fm", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Md", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_No", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Lr", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Rf", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Db", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Sg", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Bh", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Hs", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Mt", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ds", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Rg", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Cn", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Nh", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Fl", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Mc", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Lv", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Ts", Color.DKGRAY);
        MolCanvas_preferences.get().setIntValue("text_color_Og", Color.DKGRAY);

        MolCanvas_preferences.get().setIntValue("zmat_max_lines", 20);
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
