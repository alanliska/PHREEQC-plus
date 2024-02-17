package cz.p;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.renderscript.RenderScript;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Canvas3d_main extends MainActivity {

    Canvas3d_CanvasView molCanvasView;
    Button perTable;
    Button exportXYZ;
    Button importXYZ;
    Button clear;
    Button zoom;
    Button unzoom;
    Button rotateX;
    Button unrotateX;
    Button rotateY;
    Button unrotateY;
    Button rotateZ;
    Button unrotateZ;
    Button translateX;
    Button untranslateX;
    Button translateY;
    Button untranslateY;
    Button translateZ;
    Button untranslateZ;
    Button colorTest;
    Button atomLabel;
    Button mode;
    Button preferences;
    private static final int READ_FILE = 1;
    private Uri documentUri1;
    private static final int CREATE_FILE = 2;
    private Uri documentUri2;
    Button toMOPAC;
    Button toDFTB;
    Button toXTB;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas3d_main);
        molCanvasView = (Canvas3d_CanvasView) findViewById(R.id.molCanvasView);
        perTable = (Button) findViewById(R.id.perTable);
        perTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Canvas3d_main.this, Canvas3d_PerTable.class);
                startActivity(intent);
            }
        });
        colorTest = (Button) findViewById(R.id.colorTest);
        colorTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Canvas3d_main.this, Canvas3d_ColorTest.class);
                startActivity(intent);
            }
        });
        preferences = (Button) findViewById(R.id.preferences);
        preferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Canvas3d_main.this, Canvas3d_Preferences.class);
                startActivity(intent);
            }
        });
        exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Canvas3d_main.this, MainActivity.class);
                startActivity(intent);
            }
        });
        toMOPAC = (Button) findViewById(R.id.toMOPAC);
        toMOPAC.setOnClickListener(toMOPACClick);
        toDFTB = (Button) findViewById(R.id.toDFTB);
        toDFTB.setOnClickListener(toDFTBClick);
        toXTB = (Button) findViewById(R.id.toXTB);
        toXTB.setOnClickListener(toXTBClick);
        exportXYZ = (Button) findViewById(R.id.exportXYZ);
        exportXYZ.setOnClickListener(exportXYZClick);
        importXYZ = (Button) findViewById(R.id.importXYZ);
        importXYZ.setOnClickListener(importXYZClick);
        clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(clearClick);
        zoom = (Button) findViewById(R.id.zoom);
        zoom.setOnClickListener(zoomClick);
        unzoom = (Button) findViewById(R.id.unzoom);
        unzoom.setOnClickListener(unzoomClick);
        rotateX = (Button) findViewById(R.id.rotateX);
        rotateX.setOnClickListener(rotateXClick);
        unrotateX = (Button) findViewById(R.id.unrotateX);
        unrotateX.setOnClickListener(unrotateXClick);
        rotateY = (Button) findViewById(R.id.rotateY);
        rotateY.setOnClickListener(rotateYClick);
        unrotateY = (Button) findViewById(R.id.unrotateY);
        unrotateY.setOnClickListener(unrotateYClick);
        rotateZ = (Button) findViewById(R.id.rotateZ);
        rotateZ.setOnClickListener(rotateZClick);
        unrotateZ = (Button) findViewById(R.id.unrotateZ);
        unrotateZ.setOnClickListener(unrotateZClick);
        translateX = (Button) findViewById(R.id.translateX);
        translateX.setOnClickListener(translateXClick);
        untranslateX = (Button) findViewById(R.id.untranslateX);
        untranslateX.setOnClickListener(untranslateXClick);
        translateY = (Button) findViewById(R.id.translateY);
        translateY.setOnClickListener(translateYClick);
        untranslateY = (Button) findViewById(R.id.untranslateY);
        untranslateY.setOnClickListener(untranslateYClick);
        translateZ = (Button) findViewById(R.id.translateZ);
        translateZ.setOnClickListener(translateZClick);
        untranslateZ = (Button) findViewById(R.id.untranslateZ);
        untranslateZ.setOnClickListener(untranslateZClick);
        atomLabel = (Button) findViewById(R.id.atomLabel);
        atomLabel.setOnClickListener(atomLabelClick);
        mode = (Button) findViewById(R.id.mode);
        mode.setOnClickListener(modeClick);
        perTable.setText(exec("cat "+getFilesDir()+"/canvas3d/Elmnt.tmp"));
        String ModeState = exec("cat "+getFilesDir()+"/canvas3d/Mode.tmp");
        if (Integer.valueOf(ModeState) > 0){
            mode.setText("Draw");
        } else if (Integer.valueOf(ModeState) == 0){
            mode.setText("Select");
        }
        String AtomLabelState = exec("cat "+getFilesDir()+"/canvas3d/AtomLabel.tmp");
        if (Integer.valueOf(AtomLabelState) > 0){
            atomLabel.setText("Labels on");
        } else if (Integer.valueOf(AtomLabelState) == 0){
            atomLabel.setText("Labels off");
        }
        //////////////////////////////////////////////////////////////////////////////
        exec("chmod -R 755 "+getFilesDir()+"/");
    }

    public void onStart()
    {
        super.onStart();
        perTable.setText(exec("cat "+getFilesDir()+"/canvas3d/Elmnt.tmp"));
// tady nemusí být nic - důležité je, že v onDraw je definováno vykreslování obsahu souboru Coordinates.x.tmp - ty se zobrazí na začátku, kdykoliv jindy i po zavření/otevření
    }

    private View.OnClickListener toXTBClick; {
        toXTBClick = new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Scanner scan3 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));

                    // get knowledge on number of already existing lines in the file
                    InputStream inputStream = new FileInputStream(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    LineNumberReader lineNumberReader = new LineNumberReader(bufferedReader);
                    try {
                        lineNumberReader.skip(Long.MAX_VALUE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                            int linesInFile = lineNumberReader.getLineNumber() + 1;  // because line numbers starts from 0
                    // but we add one more blank line
                    int linesInFile = lineNumberReader.getLineNumber();
                    String AtomNumber = String.valueOf(linesInFile);
                    FileOutputStream fileout0 = openFileOutput("Coordinates.xyz.tmp_", MODE_PRIVATE);
                    OutputStreamWriter outputWriter0 = new OutputStreamWriter(fileout0);
                    outputWriter0.write(AtomNumber);
                    outputWriter0.write("\n");
                    outputWriter0.write("\n");
                    outputWriter0.close();

                    while (scan3.hasNext()) {
                        String curLine = scan3.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_double = Double.valueOf(x_coord);
                        double y_double = Double.valueOf(y_coord);
                        double z_double = Double.valueOf(z_coord);
                        String x_formatted = String.format("%.4f", x_double);
                        String y_formatted = String.format("%.4f", y_double);
                        String z_formatted = String.format("%.4f", z_double);
                        while (x_formatted.contains(",")){
                            x_formatted = x_formatted.replace(",", ".");
                        }
                        while (y_formatted.contains(",")){
                            y_formatted = y_formatted.replace(",", ".");
                        }
                        while (z_formatted.contains(",")){
                            z_formatted = z_formatted.replace(",", ".");
                        }
                        // finish writing the file
                        FileOutputStream fileout = openFileOutput("Coordinates.xyz.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+" "+x_formatted+" "+y_formatted+" "+z_formatted+"\n");
                        outputWriter.close();
                    }
                    scan3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.xyz.tmp_ "+getFilesDir()+"/xtb/Input-xtb.xyz");
                Intent intent = new Intent(Canvas3d_main.this, Xtb.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener toDFTBClick; {
        toDFTBClick = new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Scanner scan3 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));

                    // get knowledge on number of already existing lines in the file
                    InputStream inputStream = new FileInputStream(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    LineNumberReader lineNumberReader = new LineNumberReader(bufferedReader);
                    try {
                        lineNumberReader.skip(Long.MAX_VALUE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                            int linesInFile = lineNumberReader.getLineNumber() + 1;  // because line numbers starts from 0
                    // but we add one more blank line
                    int linesInFile = lineNumberReader.getLineNumber();
                    String AtomNumber = String.valueOf(linesInFile);
                    FileOutputStream fileout0 = openFileOutput("Coordinates.xyz.tmp_", MODE_PRIVATE);
                    OutputStreamWriter outputWriter0 = new OutputStreamWriter(fileout0);
                    outputWriter0.write(AtomNumber);
                    outputWriter0.write("\n");
                    outputWriter0.write("\n");
                    outputWriter0.close();

                    while (scan3.hasNext()) {
                        String curLine = scan3.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_double = Double.valueOf(x_coord);
                        double y_double = Double.valueOf(y_coord);
                        double z_double = Double.valueOf(z_coord);
                        String x_formatted = String.format("%.4f", x_double);
                        String y_formatted = String.format("%.4f", y_double);
                        String z_formatted = String.format("%.4f", z_double);
                        while (x_formatted.contains(",")){
                            x_formatted = x_formatted.replace(",", ".");
                        }
                        while (y_formatted.contains(",")){
                            y_formatted = y_formatted.replace(",", ".");
                        }
                        while (z_formatted.contains(",")){
                            z_formatted = z_formatted.replace(",", ".");
                        }
                        // finish writing the file
                        FileOutputStream fileout = openFileOutput("Coordinates.xyz.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+" "+x_formatted+" "+y_formatted+" "+z_formatted+"\n");
                        outputWriter.close();
                    }
                    scan3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.xyz.tmp_ "+getFilesDir()+"/dftb/Input.xyz");
                Intent intent = new Intent(Canvas3d_main.this, Dftb.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener toMOPACClick; {
        toMOPACClick = new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Scanner scan3 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan3.hasNext()) {
                        String curLine = scan3.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_double = Double.valueOf(x_coord);
                        double y_double = Double.valueOf(y_coord);
                        double z_double = Double.valueOf(z_coord);
                        String x_formatted = String.format("%.4f", x_double);
                        String y_formatted = String.format("%.4f", y_double);
                        String z_formatted = String.format("%.4f", z_double);
                        while (x_formatted.contains(",")){
                            x_formatted = x_formatted.replace(",", ".");
                        }
                        while (y_formatted.contains(",")){
                            y_formatted = y_formatted.replace(",", ".");
                        }
                        while (z_formatted.contains(",")){
                            z_formatted = z_formatted.replace(",", ".");
                        }
                        // finish writing the file
                        FileOutputStream fileout = openFileOutput("Input-mopac.txt", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+" "+x_formatted+" "+y_formatted+" "+z_formatted+"\n");
                        outputWriter.close();
                    }
                    scan3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Canvas3d_main.this, Mopac.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener rotateXClick; {
        rotateXClick = new View.OnClickListener() {
            public void onClick(View v) {
                String RotAngle = exec("cat "+getFilesDir()+"/canvas3d/RotAngle.tmp");
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double theta = Double.valueOf(RotAngle);
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig;
                        double y_new = y_orig*Math.cos(theta) - z_orig*Math.sin(theta);
                        double z_new = y_orig*Math.sin(theta) + z_orig*Math.cos(theta);
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                    exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
                } catch (Exception e) {
                    e.printStackTrace();
                }
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener unrotateXClick; {
        unrotateXClick = new View.OnClickListener() {
            public void onClick(View v) {
                String RotAngle = exec("cat "+getFilesDir()+"/canvas3d/RotAngle.tmp");
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double theta = Double.valueOf(RotAngle);
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig;
                        double y_new = y_orig*Math.cos(-theta) - z_orig*Math.sin(-theta);
                        double z_new = y_orig*Math.sin(-theta) + z_orig*Math.cos(-theta);
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener rotateYClick; {
        rotateYClick = new View.OnClickListener() {
            public void onClick(View v) {
                String RotAngle = exec("cat "+getFilesDir()+"/canvas3d/RotAngle.tmp");
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double theta = Double.valueOf(RotAngle);
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig*Math.cos(theta) + z_orig*Math.sin(theta);
                        double y_new = y_orig;
                        double z_new = -x_orig*Math.sin(theta) + z_orig*Math.cos(theta);
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener unrotateYClick; {
        unrotateYClick = new View.OnClickListener() {
            public void onClick(View v) {
                String RotAngle = exec("cat "+getFilesDir()+"/canvas3d/RotAngle.tmp");
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double theta = Double.valueOf(RotAngle);
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig*Math.cos(-theta) + z_orig*Math.sin(-theta);
                        double y_new = y_orig;
                        double z_new = -x_orig*Math.sin(-theta) + z_orig*Math.cos(-theta);
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener rotateZClick; {
        rotateZClick = new View.OnClickListener() {
            public void onClick(View v) {
                String RotAngle = exec("cat "+getFilesDir()+"/canvas3d/RotAngle.tmp");
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double theta = Double.valueOf(RotAngle);
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig*Math.cos(theta) - y_orig*Math.sin(theta);
                        double y_new = x_orig*Math.sin(theta) + y_orig*Math.cos(theta);
                        double z_new = z_orig;
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener unrotateZClick; {
        unrotateZClick = new View.OnClickListener() {
            public void onClick(View v) {
                String RotAngle = exec("cat "+getFilesDir()+"/canvas3d/RotAngle.tmp");
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double theta = Double.valueOf(RotAngle);
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig*Math.cos(-theta) - y_orig*Math.sin(-theta);
                        double y_new = x_orig*Math.sin(-theta) + y_orig*Math.cos(-theta);
                        double z_new = z_orig;
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener translateXClick; {
        translateXClick = new View.OnClickListener() {
            public void onClick(View v) {
                double transl = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/Transl.tmp"));
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig + transl;
                        double y_new = y_orig;
                        double z_new = z_orig;
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener untranslateXClick; {
        untranslateXClick = new View.OnClickListener() {
            public void onClick(View v) {
                double transl = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/Transl.tmp"));
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig - transl;
                        double y_new = y_orig;
                        double z_new = z_orig;
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener translateYClick; {
        translateYClick = new View.OnClickListener() {
            public void onClick(View v) {
                double transl = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/Transl.tmp"));
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig;
                        double y_new = y_orig + transl;
                        double z_new = z_orig;
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener untranslateYClick; {
        untranslateYClick = new View.OnClickListener() {
            public void onClick(View v) {
                double transl = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/Transl.tmp"));
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig;
                        double y_new = y_orig - transl;
                        double z_new = z_orig;
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener translateZClick; {
        translateZClick = new View.OnClickListener() {
            public void onClick(View v) {
                double transl = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/Transl.tmp"));
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig;
                        double y_new = y_orig;
                        double z_new = z_orig + transl;
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener untranslateZClick; {
        untranslateZClick = new View.OnClickListener() {
            public void onClick(View v) {
                double transl = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/Transl.tmp"));
                double BondScale = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
                double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                try {
                    Scanner scan2 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
// file No. 2
                    while (scan2.hasNext()) {
                        String curLine = scan2.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();

                        double x_orig = Double.valueOf(x_coord);
                        double y_orig = Double.valueOf(y_coord);
                        double z_orig = Double.valueOf(z_coord);

                        double x_new = x_orig;
                        double y_new = y_orig;
                        double z_new = z_orig - transl;
                        // write the file
                        FileOutputStream fileout = openFileOutput("Coordinates.x.tmp_", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(atom+"\t"+x_new+"\t"+y_new+"\t"+z_new+"\t"+radius+"\t"+atom_color+"\t"+text_color+"\t"+atom_number+"\n");
                        outputWriter.close();
                    }
                    scan2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
// file No. 1
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                try {
                    Scanner scan = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String atom = splitted[0].trim();
                        String x_coord = splitted[1].trim();
                        String y_coord = splitted[2].trim();
                        String z_coord = splitted[3].trim();
                        String radius = splitted[4].trim();
                        String atom_color = splitted[5].trim();
                        String text_color = splitted[6].trim();
                        String atom_number = splitted[7].trim();
                        int radius_pix = (int) (Double.valueOf(radius)*100);
                        // project 3D geometry to z = 0
                        double A = 0;
                        double B = 0;
                        double C = 1;
                        double D = 0;
                        double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                        // because of canvas - input variables x&y have to be integers, not doubles
                        int x_projection = (int) (x_proj*100);
                        int y_projection = (int) (y_proj*100);
                        int z_projection = (int) (z_proj*100);
                        // text in front of circles = with less negative z coord
//                        double z_text = 100*(Double.valueOf(z_coord)+0.01);
                        double z_text = Double.valueOf(z_coord)+ForegroundShiftText;
                        // write the file
                        FileOutputStream fileout_atoms = openFileOutput("Coordinates.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                        outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
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

                            double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                            // investigate all distances
                            double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord)-Double.valueOf(x_coord2)),2)+Math.pow((Double.valueOf(y_coord)-Double.valueOf(y_coord2)),2)+Math.pow((Double.valueOf(z_coord)-Double.valueOf(z_coord2)),2));

                            if((dist_scan1_scan2 < BondingDistance)&&(dist_scan1_scan2 > 0)){

                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A*(Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                                double x_bond1 = 100*x_proj1;
                                double y_bond1 = 100*y_proj1;
                                double x_bond2 = 100*x_proj2;
                                double y_bond2 = 100*y_proj2;

//                                int bond_color = Color.GRAY;
                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5*(Double.valueOf(z_coord) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom+"\t"+atom2+"\t"+x_bond1+"\t"+y_bond1+"\t"+x_bond2+"\t"+y_bond2+"\t"+z_bond_average+"\t"+bond_color1+"\t"+bond_color2+"\t"+"0"+"\t"+"L"+"\n");
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
            }
        };
    }

    private View.OnClickListener zoomClick; {
        zoomClick = new View.OnClickListener() {
            public void onClick(View v) {
                double ZoomExtent = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/Zoom.tmp"));
                double ZoomStep = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ZoomStep.tmp"));
                double newZoomExtent = ZoomExtent+ZoomStep;
                try {
                    FileOutputStream fileout = openFileOutput("Zoom.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(String.valueOf(newZoomExtent));
                    outputWriter.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Zoom.tmp "+getFilesDir()+"/canvas3d/");
            }
        };
    }

    private View.OnClickListener unzoomClick; {
        unzoomClick = new View.OnClickListener() {
            public void onClick(View v) {
                double ZoomExtent = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/Zoom.tmp"));
                double ZoomStep = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ZoomStep.tmp"));
                double newZoomExtent = ZoomExtent-ZoomStep;
                try {
                    FileOutputStream fileout = openFileOutput("Zoom.tmp", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(String.valueOf(newZoomExtent));
                    outputWriter.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                exec("mv "+getFilesDir()+"/Zoom.tmp "+getFilesDir()+"/canvas3d/");
            }
        };
    }

    private View.OnClickListener atomLabelClick; {
        atomLabelClick = new View.OnClickListener() {
            public void onClick(View v) {
                final String AtomLabelState = exec("cat "+getFilesDir()+"/canvas3d/AtomLabel.tmp");
                // create another file to allow two conditions independently for the first file
                if (Integer.valueOf(AtomLabelState) > 0){
                    try {
                        FileOutputStream fileout = openFileOutput("AtomLabel.tmp_", MODE_PRIVATE);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write("0");
                        outputWriter.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    atomLabel.setText("Labels off");
                } else if (Integer.valueOf(AtomLabelState) == 0){
                    try {
                        FileOutputStream fileout = openFileOutput("AtomLabel.tmp_", MODE_PRIVATE);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write("1");
                        outputWriter.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    atomLabel.setText("Labels on");
                }
                // do not remove - otherwise none of the two files will be present any more
//                exec("rm "+getFilesDir()+"/AtomLabel.tmp");
                exec("mv "+getFilesDir()+"/AtomLabel.tmp_ "+getFilesDir()+"/canvas3d/AtomLabel.tmp");
            }
        };
    }

    private View.OnClickListener modeClick; {
        modeClick = new View.OnClickListener() {
            public void onClick(View v) {
                final String ModeState = exec("cat "+getFilesDir()+"/canvas3d/Mode.tmp");
                // create another file to allow two conditions independently for the first file
                if (Integer.valueOf(ModeState) > 0){
                    try {
                        FileOutputStream fileout = openFileOutput("Mode.tmp_", MODE_PRIVATE);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write("0");
                        outputWriter.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mode.setText("Select");
                } else if (Integer.valueOf(ModeState) == 0){
                    try {
                        FileOutputStream fileout = openFileOutput("Mode.tmp_", MODE_PRIVATE);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write("1");
                        outputWriter.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mode.setText("Draw");
//                    exec("rm "+getFilesDir()+"/CursorPos.tmp");
//                    exec("touch "+getFilesDir()+"/CursorPos.tmp");
//                    CursorDisplay(exec("rm "+getFilesDir()+"/CursorPos.tmp"));
                }
                // do not remove - otherwise none of the two files will be present any more
//                exec("rm "+getFilesDir()+"/Mode.tmp");
                exec("mv "+getFilesDir()+"/Mode.tmp_ "+getFilesDir()+"/canvas3d/Mode.tmp");
            }
        };
    }

    private View.OnClickListener clearClick; {
        clearClick = new View.OnClickListener() {
            public void onClick(View v) {
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.tmp");
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.x.tmp");
                exec("rm "+getFilesDir()+"/canvas3d/Coordinates.xyz.tmp");
                exec("touch "+getFilesDir()+"/canvas3d/Coordinates.xyz.tmp");
            }
        };
    }


    private View.OnClickListener importXYZClick;

    {
        importXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read(getApplicationContext());
// all the other has to be inside of onActivityResult - otherwise it starts to work with (at the moment) non-existent file before loading it
            }
        };
    }

    private View.OnClickListener exportXYZClick; {
        exportXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                write(getApplicationContext());
            }
        };
    }

    private void read(Context context) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
        startActivityForResult(intent, READ_FILE);
    }

    private void write(Context context) {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent, CREATE_FILE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE && data != null) {
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
//                while (myData.contains("\\s\\s")){  //2 spaces
//                    myData = myData.replace("\\s\\s", " "); //(2 spaces, 1 space)
//                }
                while (myData.contains("\t")){  //2 spaces
                    myData = myData.replace("\t", " "); //(2 spaces, 1 space)
                }
                while (myData.contains("  ")){  //2 spaces
                    myData = myData.replace("  ", " "); //(2 spaces, 1 space)
                }
                while (myData.contains("\n ")){  //2 spaces
                    myData = myData.replace("\n ", "\n"); //(2 spaces, 1 space)
                }

                FileOutputStream fileout = openFileOutput("Coordinates.xyz.tmp", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd.close();


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
                    double ForegroundShiftBonds = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                    double ForegroundShiftText = Double.valueOf(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
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
                            String text_colorX = splittedX[6].trim();
                            String atom_numberX = splittedX[7].trim();
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
                            double z_textX = Double.valueOf(z_coordX)+ForegroundShiftText;
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

                                    double z_bond_average = 0.5*(Double.valueOf(z_coordX) + Double.valueOf(z_coord2))+ForegroundShiftBonds;

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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
            perTable.setText(exec("cat "+getFilesDir()+"/canvas3d/Elmnt.tmp"));
        }

        if (requestCode == CREATE_FILE && data != null) {
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            try {
                Scanner scan3 = new Scanner(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));

                // get knowledge on number of already existing lines in the file
                InputStream inputStream = new FileInputStream(new File(getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                LineNumberReader lineNumberReader = new LineNumberReader(bufferedReader);
                try {
                    lineNumberReader.skip(Long.MAX_VALUE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                            int linesInFile = lineNumberReader.getLineNumber() + 1;  // because line numbers starts from 0
                // but we add one more blank line
                int linesInFile = lineNumberReader.getLineNumber();
                String AtomNumber = String.valueOf(linesInFile);
                FileOutputStream fileout0 = openFileOutput("Coordinates.xyz.tmp_", MODE_PRIVATE);
                OutputStreamWriter outputWriter0 = new OutputStreamWriter(fileout0);
                outputWriter0.write(AtomNumber);
                outputWriter0.write("\n");
                outputWriter0.write("\n");
                outputWriter0.close();

                while (scan3.hasNext()) {
                    String curLine = scan3.nextLine();
                    String[] splitted = curLine.split("\\s");
                    String atom = splitted[0].trim();
                    String x_coord = splitted[1].trim();
                    String y_coord = splitted[2].trim();
                    String z_coord = splitted[3].trim();
                    String radius = splitted[4].trim();
                    String atom_color = splitted[5].trim();
                    String text_color = splitted[6].trim();
                    String atom_number = splitted[7].trim();

                    double x_double = Double.valueOf(x_coord);
                    double y_double = Double.valueOf(y_coord);
                    double z_double = Double.valueOf(z_coord);
                    String x_formatted = String.format("%.4f", x_double);
                    String y_formatted = String.format("%.4f", y_double);
                    String z_formatted = String.format("%.4f", z_double);
                    // finish writing the file
                    FileOutputStream fileout = openFileOutput("Coordinates.xyz.tmp_", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(atom+" "+x_formatted+" "+y_formatted+" "+z_formatted+"\n");
                    outputWriter.close();
                }
                scan3.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            exec("mv "+getFilesDir()+"/Coordinates.xyz.tmp_ "+getFilesDir()+"/canvas3d/Coordinates.xyz.tmp");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            try {
                documentUri2 = data.getData();
                ParcelFileDescriptor pfd = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(pfd.getFileDescriptor());
                String fileContents = exec("cat "+getFilesDir()+"/canvas3d/Coordinates.xyz.tmp");
                fileOutputStream.write((fileContents).getBytes());
                fileOutputStream.close();
                pfd.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        perTable.setText(exec("cat "+getFilesDir()+"/canvas3d/Elmnt.tmp"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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

    protected void copyFromAssetsToInternalStorage(String filename){
        AssetManager assetManager = getAssets();

        try {
            InputStream input = assetManager.open(filename);
            OutputStream output = openFileOutput(filename, Context.MODE_PRIVATE);

            copyFile(input, output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}