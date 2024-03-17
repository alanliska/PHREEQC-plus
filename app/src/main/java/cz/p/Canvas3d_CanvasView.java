package cz.p;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;

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
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Canvas3d_CanvasView extends View {
    public Paint Atoms;
    public Paint Bonds1;
    public Paint Bonds2;
    public Paint HBonds1;
    public Paint HBonds2;
    public Paint Atomsymbols;
    public Paint Atomborder;
    public static Canvas molCanvas;
    public static final int FALSE = 0, TRUE = 1, NOT_SET = 2;
    private int renderMolecule;
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public int width_pix = getScreenWidth();
    public int height_pix = getScreenHeight();
    // the variables used in the drawing method
    public final int ColorCanvas = Integer.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ColorCanvas.tmp"));
    public final float PerspScale = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/PerspScale.tmp"));
    public final float RadiusScale = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/RadiusScale.tmp"));
    public final float AtomBorder = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/AtomBorder.tmp"));
    public final float TextSize = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/TextSize.tmp"));
    public final float BondSize = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/BondSize.tmp"));
    public final float AtomLabelShiftX = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/AtomLabelShiftX.tmp"));
    public final float AtomLabelShiftY = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/AtomLabelShiftY.tmp"));
    public final double ForegroundShiftText = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
    public final int SizeHBond = Integer.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/HBondSize.tmp"));

    //constructor
    public Canvas3d_CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Atoms = new Paint();
        Bonds1 = new Paint();
        Bonds2 = new Paint();
        HBonds1 = new Paint();
        HBonds2 = new Paint();
        Atomsymbols = new Paint();
        Atomborder = new Paint();

        File width_file = new File(getContext().getFilesDir()+"/canvas3d/.width");
        if (width_file.exists()) {
            // do nothing
        } else {
            try {
                FileOutputStream fileout100 = getContext().openFileOutput(".width", MODE_PRIVATE);
                OutputStreamWriter outputWriter100 = new OutputStreamWriter(fileout100);
                outputWriter100.write(String.valueOf(width_pix));
                outputWriter100.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            exec("mv "+getContext().getFilesDir()+"/.width "+getContext().getFilesDir()+"/canvas3d/");
        }

        File height_file = new File(getContext().getFilesDir()+"/canvas3d/.height");
        if (height_file.exists()) {
            // do nothing
        } else {
            try {
                FileOutputStream fileout101 = getContext().openFileOutput(".height", MODE_PRIVATE);
                OutputStreamWriter outputWriter101 = new OutputStreamWriter(fileout101);
                outputWriter101.write(String.valueOf(height_pix));
                outputWriter101.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            exec("mv "+getContext().getFilesDir()+"/.height "+getContext().getFilesDir()+"/canvas3d/");
        }
// to display the canvas (once)
        setMoleculeRenderer(TRUE);
    }

    //what I want to draw is here
        protected void onDraw(Canvas canvas) {
        molCanvas = canvas;
        super.onDraw(molCanvas);
            if (renderMolecule != NOT_SET) {
                if (renderMolecule == TRUE) {

//                    int ColorCanvas = Integer.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ColorCanvas.tmp"));
//                    float PerspScale = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/PerspScale.tmp"));
//                    float RadiusScale = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/RadiusScale.tmp"));
//                    float AtomBorder = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/AtomBorder.tmp"));
//                    float TextSize = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/TextSize.tmp"));
//                    float BondSize = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/BondSize.tmp"));
//                    float AtomLabelShiftX = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/AtomLabelShiftX.tmp"));
//                    float AtomLabelShiftY = Float.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/AtomLabelShiftY.tmp"));
//                    double ForegroundShiftText = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
//                    int SizeHBond = Integer.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/HBondSize.tmp"));

                    // canvas background
                    canvas.drawColor(ColorCanvas);
                    // atoms depiction
                    Atoms.setStyle(Paint.Style.FILL);
                    Atoms.setAntiAlias(true);
                    // atom borders depiction
                    Atomborder.setStyle(Paint.Style.STROKE);
                    // hydrogen bonds (first number - length of the line solid part; second number - length of the line missing part)
                    HBonds1.setPathEffect(new DashPathEffect(new float[] {5, 10, 5, 10}, 0f));
                    HBonds2.setPathEffect(new DashPathEffect(new float[] {5, 10, 5, 10}, 0.5f));

                    try {
                        Scanner scan = new Scanner(new File(getContext().getFilesDir()+"/canvas3d/Coordinates.tmp"));
                        float z_perspective = 1;
                        while (scan.hasNext()) {
                            String curLine = scan.nextLine();
                            String[] splitted = curLine.split("\\s");
                            String atom1 = splitted[0].trim();
                            String atom2 = splitted[1].trim();
                            String x1_proj = splitted[2].trim();
                            String y1_proj = splitted[3].trim();
                            String x2_proj = splitted[4].trim();
                            String y2_proj = splitted[5].trim();
                            String z_abs = splitted[6].trim();
                            String radius = splitted[7].trim();
                            String color = splitted[8].trim();
                            String atom_number = splitted[9].trim();
                            String type = splitted[10].trim();

                            if (Float.valueOf(z_abs) == 0){
                                z_perspective = 1;
                            } else if (Float.valueOf(z_abs) > 0){
                                z_perspective = 1+((float) PerspScale)*Float.valueOf(z_abs);
                            } else if (Float.valueOf(z_abs) < 0){
                                z_perspective = 1/(1-((float) PerspScale)*Float.valueOf(z_abs));
                            }
                            double ZoomExtent = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/Zoom.tmp"));
                            String AtomLabelState = exec("cat "+getContext().getFilesDir()+"/canvas3d/AtomLabel.tmp");
                            if (type.equals("C")){
                                float x_proj_pix = (float) (((Float.valueOf(x1_proj))*ZoomExtent) + width_pix*0.5);
                                float y_proj_pix = (float) ((-(Float.valueOf(y1_proj))*ZoomExtent) + height_pix*0.5);
                                float corrRadius = (float) (RadiusScale*(Float.valueOf(radius)*ZoomExtent)*z_perspective);
                                Atoms.setColor(Integer.valueOf(color));
                                Atomborder.setStrokeWidth(AtomBorder*z_perspective);
                                Atomborder.setColor(Integer.valueOf(atom2));
                                canvas.drawCircle(x_proj_pix, y_proj_pix, corrRadius, Atoms);
                                canvas.drawCircle(x_proj_pix, y_proj_pix, corrRadius, Atomborder);
                            } else if (type.equals("T")){
                                if (Integer.valueOf(AtomLabelState) == 1){
                                    float x_proj_pix = (float) (((Float.valueOf(x1_proj)+Float.valueOf(AtomLabelShiftX))*ZoomExtent) + width_pix*0.5);
                                    float y_proj_pix = (float) ((-(Float.valueOf(y1_proj)+Float.valueOf(AtomLabelShiftY))*ZoomExtent) + height_pix*0.5);
                                    Atomsymbols.setTextSize(TextSize*z_perspective);
                                    Atomsymbols.setColor(Integer.valueOf(color));
                                    canvas.drawText(atom1+atom_number, x_proj_pix, y_proj_pix, Atomsymbols);
                                } else if (Integer.valueOf(AtomLabelState) == 2){
                                    float x_proj_pix = (float) (((Float.valueOf(x1_proj)+Float.valueOf(AtomLabelShiftX))*ZoomExtent) + width_pix*0.5);
                                    float y_proj_pix = (float) ((-(Float.valueOf(y1_proj)+Float.valueOf(AtomLabelShiftY))*ZoomExtent) + height_pix*0.5);
                                    Atomsymbols.setTextSize(TextSize*z_perspective);
                                    Atomsymbols.setColor(Integer.valueOf(color));
                                    Double z_abs_real = Double.valueOf(z_abs) - ForegroundShiftText;
                                    String z_coordinate = String.format("%.1f", z_abs_real);
                                    while (z_coordinate.contains(",")){
                                        z_coordinate = z_coordinate.replace(",", ".");
                                    }
                                    canvas.drawText(z_coordinate, x_proj_pix, y_proj_pix, Atomsymbols);
                                }
                            } else if (type.equals("L")){
                                Bonds1.setColor(Integer.valueOf(radius));
                                Bonds2.setColor(Integer.valueOf(color));
                                Bonds1.setStrokeWidth(BondSize * z_perspective);
                                Bonds2.setStrokeWidth(BondSize * z_perspective);
                                float x1_proj_pix = (float) (((Float.valueOf(x1_proj)) * ZoomExtent) + width_pix * 0.5);
                                float y1_proj_pix = (float) ((-(Float.valueOf(y1_proj)) * ZoomExtent) + height_pix * 0.5);
                                float x2_proj_pix = (float) (((Float.valueOf(x2_proj)) * ZoomExtent) + width_pix * 0.5);
                                float y2_proj_pix = (float) ((-(Float.valueOf(y2_proj)) * ZoomExtent) + height_pix * 0.5);
                                float x_proj_pix = (float) 0.5 * (x1_proj_pix + x2_proj_pix);
                                float y_proj_pix = (float) 0.5 * (y1_proj_pix + y2_proj_pix);
                                canvas.drawLine(x1_proj_pix, y1_proj_pix, x_proj_pix, y_proj_pix, Bonds1);
                                canvas.drawLine(x_proj_pix, y_proj_pix, x2_proj_pix, y2_proj_pix, Bonds2);
                            } else if (type.equals("H")){
                                HBonds1.setColor(Integer.valueOf(radius));
                                HBonds2.setColor(Integer.valueOf(color));
                                // single color for hydrogen bond
//                                HBonds1.setColor(ColorHBond);
//                                HBonds2.setColor(ColorHBond);
                                HBonds1.setStrokeWidth(SizeHBond * z_perspective);
                                HBonds2.setStrokeWidth(SizeHBond * z_perspective);
                                float x1_proj_pix = (float) (((Float.valueOf(x1_proj)) * ZoomExtent) + width_pix * 0.5);
                                float y1_proj_pix = (float) ((-(Float.valueOf(y1_proj)) * ZoomExtent) + height_pix * 0.5);
                                float x2_proj_pix = (float) (((Float.valueOf(x2_proj)) * ZoomExtent) + width_pix * 0.5);
                                float y2_proj_pix = (float) ((-(Float.valueOf(y2_proj)) * ZoomExtent) + height_pix * 0.5);
                                float x_proj_pix = (float) 0.5 * (x1_proj_pix + x2_proj_pix);
                                float y_proj_pix = (float) 0.5 * (y1_proj_pix + y2_proj_pix);
                                canvas.drawLine(x1_proj_pix, y1_proj_pix, x_proj_pix, y_proj_pix, HBonds1);
                                canvas.drawLine(x_proj_pix, y_proj_pix, x2_proj_pix, y2_proj_pix, HBonds2);
                            }
                        }
                        scan.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // do not put here - otherwise the picture will be overdrawn continuously
//        invalidate();
            } else {
               // nothing
                    setMoleculeRenderer(FALSE);
                }
            }
    }

    public void setMoleculeRenderer(int renderMolecule) {
        this.renderMolecule = renderMolecule;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String Element = exec("cat "+getContext().getFilesDir()+"/canvas3d/Elmnt.tmp");
        String AtomRadius = exec("cat "+getContext().getFilesDir()+"/canvas3d/Rad.tmp");
        String TextColor = exec("cat "+getContext().getFilesDir()+"/canvas3d/ColorText.tmp");
        String AtomColor = exec("cat "+getContext().getFilesDir()+"/canvas3d/ColorAtom.tmp");
        String ModeState = exec("cat "+getContext().getFilesDir()+"/canvas3d/Mode.tmp");

        // drawing mode
        if (Integer.valueOf(ModeState) > 0) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN: {
                    Point p = new Point();
                    p.x = (int) event.getX();
                    p.y = (int) event.getY();

                    int width_pix = getScreenWidth();
                    int heigth_pix = getScreenHeight();

                    double ZoomExtent = Double.valueOf(exec("cat " + getContext().getFilesDir() + "/canvas3d/Zoom.tmp"));

                    double x_coord_Ang = (1/ZoomExtent) * 0.01 * (p.x - width_pix * 0.5);
                    double y_coord_Ang = -(1/ZoomExtent) * 0.01 * (p.y - heigth_pix * 0.5);
                    double z_coord_Ang = (1/ZoomExtent) * 0.01 * (0);

                    double radius_Ang = Double.valueOf(AtomRadius) * 0.01;

                    int ColorAtomBorder = Integer.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ColorAtomBorder.tmp"));
                    Long time = System.currentTimeMillis();

                    try {
                        exec("mv "+getContext().getFilesDir()+"/canvas3d/Coordinates.x.tmp "+getContext().getFilesDir()+"/");
                        InputStream inputStream = new FileInputStream(getContext().getFilesDir() + "/Coordinates.x.tmp");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        LineNumberReader lineNumberReader = new LineNumberReader(bufferedReader);
                        try {
                            lineNumberReader.skip(Long.MAX_VALUE);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        int linesInFile = lineNumberReader.getLineNumber() + 1;  // because line numbers starts from 0
                        int AtomNumber = linesInFile;
                        // write the complete information - in Angstroms
                        FileOutputStream fileout = getContext().openFileOutput("Coordinates.x.tmp", MODE_APPEND);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        outputWriter.write(Element + "\t" + x_coord_Ang + "\t" + y_coord_Ang + "\t" + z_coord_Ang + "\t" + radius_Ang + "\t" + AtomColor + "\t" + TextColor + "\t" + AtomNumber + "\t"+ColorAtomBorder+"\t"+time+"\n");
                        outputWriter.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    exec("mv "+getContext().getFilesDir()+"/Coordinates.x.tmp "+getContext().getFilesDir()+"/canvas3d/");
                    update13();
//                    canvasBitmap.drawBitmap(getBitmap(),0,0,Atoms);
//                    myDraw(molCanvas);
                    // here is the appropriate position - invalidate the screen just once upon the click
//                    invalidate();
                    setMoleculeRenderer(TRUE);
                    break;
                }
                case MotionEvent.ACTION_MOVE: {
                    break;
                }
            }
            // selection / measurement mode
        } else {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN: {
                    Point p = new Point();
                    p.x = (int) event.getX();
                    p.y = (int) event.getY();

                    int width_pix = getScreenWidth();
                    int heigth_pix = getScreenHeight();

                    double ZoomExtent = Double.valueOf(exec("cat " + getContext().getFilesDir() + "/canvas3d/Zoom.tmp"));
                    double BondScale = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/BondScale.tmp"));
                    double ForegroundShiftBonds = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
                    double ForegroundShiftText = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
                    int ColorAtomBorderSelected = Integer.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ColorAtomBorderSelected.tmp"));
                    int ColorAtomBorder = Integer.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ColorAtomBorder.tmp"));
                    double TouchDistanceLimit = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/TouchDistanceLimit.tmp"));
                    HashMap<Integer,Double> distanceMap = new HashMap<Integer,Double>();

                    double x_coord_Ang = (1/ZoomExtent) * 0.01 * (p.x - width_pix * 0.5);
                    double y_coord_Ang = -(1/ZoomExtent) * 0.01 * (p.y - heigth_pix * 0.5);
                    double z_coord_Ang = (1/ZoomExtent) * 0.01 * (0);

                    double radius_Ang = Double.valueOf(AtomRadius) * 0.01;

//                    Long timeStamp = System.currentTimeMillis()/1000;
//                    int time = Integer.valueOf(String.valueOf(timeStamp));

                    // not like above - otherwise the timestamp would be rounded off too much - when selecting the atoms too quickly, the range may be incorrect (the angles and dihedral angles would be estimated randomly incorrectly - different angle from an triangle than the selected one
                    Long time = System.currentTimeMillis();

//                    exec("rm "+getContext().getFilesDir()+"/canvas3d/Coordinates.tmp");
//                    exec("touch "+getContext().getFilesDir()+"/canvas3d/Coordinates.tmp");

                    try {
                        Scanner scan = new Scanner(new File(getContext().getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
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
                            String col_at_border = splitted[8].trim();
                            String touch_time = splitted[9].trim();
                            int radius_pix = (int) (Double.valueOf(radius)*100);
                            // project 3D geometry to z = 0
                            double A = 0;
                            double B = 0;
                            double C = 1;
                            double D = 0;
                            double x_proj = Double.valueOf(x_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                            double y_proj = Double.valueOf(y_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));
                            double z_proj = Double.valueOf(z_coord) - A*(Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C)/(Math.pow(A, 2)+Math.pow(B, 2)+Math.pow(C, 2));

                            // calculate the click distance of the projected circle
                            double dist_click_atom = Math.sqrt(Math.pow((Double.valueOf(x_proj)-Double.valueOf(x_coord_Ang)),2)+Math.pow((Double.valueOf(y_proj)-Double.valueOf(y_coord_Ang)),2));
                            distanceMap.put(Integer.valueOf(atom_number),dist_click_atom);
                        }
                        scan.close();
                        // find out the atom to which the click was performed // for this function, coreLibraryDesugaring in build.gradle is required (for API 23) // when attempting to move the minimumSDK from 23 to 24, the build gets stuck in the DexBuilderRelease stage
                        Optional<Map.Entry<Integer, Double>> minEntry = distanceMap.entrySet().stream().min(Map.Entry.comparingByValue());
                        double minValue = minEntry.get().getValue();
                        int minAtom = minEntry.get().getKey();
                        // write the file No. 1 accordingly
                        Scanner scanC = new Scanner(new File(getContext().getFilesDir()+"/canvas3d/Coordinates.tmp"));
                        while (scanC.hasNext()) {
                            String curLineC = scanC.nextLine();
                            String[] splittedC = curLineC.split("\\s");
                            String atom1C = splittedC[0].trim();
                            String atom2C = splittedC[1].trim();
                            String x1_projC = splittedC[2].trim();
                            String y1_projC = splittedC[3].trim();
                            String x2_projC = splittedC[4].trim();
                            String y2_projC = splittedC[5].trim();
                            String z_coordC = splittedC[6].trim();
                            String radiusC = splittedC[7].trim();
                            String atom_colorC = splittedC[8].trim();
                            String atom_numberC = splittedC[9].trim();
                            String typeC = splittedC[10].trim();

                            // write the file
                            FileOutputStream fileout_atoms = getContext().openFileOutput("Coordinates.tmp", MODE_APPEND);
                            OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);

                            if ((minAtom == Integer.valueOf(atom_numberC))&&(minValue < TouchDistanceLimit)&&(typeC.equals("C"))) {
                                // select atom(s)
                                if (Integer.valueOf(atom2C) == ColorAtomBorder) {
                                    outputWriter_atoms.write(atom1C + "\t" + ColorAtomBorderSelected + "\t" + x1_projC + "\t" + y1_projC + "\t" + time + "\t" + y2_projC + "\t" + z_coordC + "\t" + radiusC + "\t" + atom_colorC + "\t" + atom_numberC + "\t" + typeC + "\n");
                                // unselect atom(s)
                                } else if (Integer.valueOf(atom2C) == ColorAtomBorderSelected) {
                                    outputWriter_atoms.write(atom1C + "\t" + ColorAtomBorder + "\t" + x1_projC + "\t" + y1_projC + "\t" + "0" + "\t" + y2_projC + "\t" + z_coordC + "\t" + radiusC + "\t" + atom_colorC + "\t" + atom_numberC + "\t" + typeC + "\n");
                                }
                            } else {
                                outputWriter_atoms.write(atom1C+"\t"+atom2C+"\t"+x1_projC+"\t"+y1_projC+"\t"+x2_projC+"\t"+y2_projC+"\t"+z_coordC+"\t"+radiusC+"\t"+atom_colorC+"\t"+atom_numberC+"\t"+typeC+"\n");
                            }
                            outputWriter_atoms.close();
                        }
                        scanC.close();
                        exec("mv "+getContext().getFilesDir()+"/Coordinates.tmp "+getContext().getFilesDir()+"/canvas3d/");
                        // rewrite the file No. 2 accordingly
                        exec("rm "+getContext().getFilesDir()+"/Coordinates.x.tmp");
                        exec("touch "+getContext().getFilesDir()+"/Coordinates.x.tmp");
                        Scanner scan3 = new Scanner(new File(getContext().getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                        while (scan3.hasNext()) {
                            String curLine3 = scan3.nextLine();
                            String[] splitted3 = curLine3.split("\\s");
                            String atom3 = splitted3[0].trim();
                            String x_coord3 = splitted3[1].trim();
                            String y_coord3 = splitted3[2].trim();
                            String z_coord3 = splitted3[3].trim();
                            String radius3 = splitted3[4].trim();
                            String atom_color3 = splitted3[5].trim();
                            String text_color3 = splitted3[6].trim();
                            String atom_number3 = splitted3[7].trim();
                            String col_at_border3 = splitted3[8].trim();
                            String touch_time3 = splitted3[9].trim();

                            // write the file
                            FileOutputStream fileout = getContext().openFileOutput("Coordinates.x.tmp", MODE_APPEND);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);

                            if ((minAtom == Integer.valueOf(atom_number3))&&(minValue < TouchDistanceLimit)) {
                                // select atom(s)
                                if (Integer.valueOf(col_at_border3) == ColorAtomBorder) {
                                    outputWriter.write(atom3+"\t"+x_coord3+"\t"+y_coord3+"\t"+z_coord3+"\t"+radius3+"\t"+atom_color3+"\t"+text_color3+"\t"+atom_number3+"\t"+ColorAtomBorderSelected+"\t"+touch_time3+"\n");
                                    // unselect atom(s)
                                } else if (Integer.valueOf(col_at_border3) == ColorAtomBorderSelected) {
                                    outputWriter.write(atom3+"\t"+x_coord3+"\t"+y_coord3+"\t"+z_coord3+"\t"+radius3+"\t"+atom_color3+"\t"+text_color3+"\t"+atom_number3+"\t"+ColorAtomBorder+"\t"+touch_time3+"\n");
                                }
                            } else {
                                outputWriter.write(atom3+"\t"+x_coord3+"\t"+y_coord3+"\t"+z_coord3+"\t"+radius3+"\t"+atom_color3+"\t"+text_color3+"\t"+atom_number3+"\t"+col_at_border3+"\t"+touch_time3+"\n");
                            }
                            outputWriter.close();
                        }
                        scan3.close();
                        exec("mv "+getContext().getFilesDir()+"/Coordinates.x.tmp "+getContext().getFilesDir()+"/canvas3d/");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    setMoleculeRenderer(TRUE);
                    break;
                }
                case MotionEvent.ACTION_MOVE: {
                    break;
                }
            }
        }
        return true;

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

    public void update13(){
        /////////////////////////// file No. 1 = whole info about the project to z = 0 /////////////////////////////////
        // read the file with complete info
        // and generate the project to the plane z = 0 by
        // transformation matrix (Coordinates.x.tmp -> Coordinates.tmp)
        exec("rm "+getContext().getFilesDir()+"/canvas3d/Coordinates.tmp");
        exec("touch "+getContext().getFilesDir()+"/canvas3d/Coordinates.tmp");
        double BondScale = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/BondScale.tmp"));
        double ForegroundShiftBonds = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
        double ForegroundShiftText = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
        int ColorAtomBorder = Integer.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/ColorAtomBorder.tmp"));
        double h_bond_limit_HN = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/HBondHN.tmp"));
        double h_bond_limit_HO = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/HBondHO.tmp"));
        double h_bond_limit_HF = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/HBondHF.tmp"));
        double h_bond_limit_HCl = Double.valueOf(exec("cat "+getContext().getFilesDir()+"/canvas3d/HBondHCl.tmp"));



        try {
            Scanner scan = new Scanner(new File(getContext().getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
            int lineNo1 = 0;
            while (scan.hasNext()) {
                lineNo1++;
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
                String col_at_border = splitted[8].trim();
                String touch_time = splitted[9].trim();

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

                double z_text = (Double.valueOf(z_coord)+ForegroundShiftText);
                // write the file
                FileOutputStream fileout_atoms = getContext().openFileOutput("Coordinates.tmp", MODE_APPEND);
                OutputStreamWriter outputWriter_atoms = new OutputStreamWriter(fileout_atoms);
                outputWriter_atoms.write(atom+"\t"+ColorAtomBorder+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_coord+"\t"+radius_pix+"\t"+atom_color+"\t"+atom_number+"\t"+"C"+"\n");
                outputWriter_atoms.write(atom+"\t"+"0"+"\t"+x_projection+"\t"+y_projection+"\t"+"0"+"\t"+"0"+"\t"+z_text+"\t"+"0"+"\t"+text_color+"\t"+atom_number+"\t"+"T"+"\n");
                outputWriter_atoms.close();

                // second loop - to reveal the bonds
                Scanner scan2 = new Scanner(new File(getContext().getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
                int lineNo2 = 0;
                while (scan2.hasNext()) {
                    lineNo2++;
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
                    String col_at_border2 = splitted[8].trim();
                    String touch_time2 = splitted[9].trim();

                    if (lineNo2 >= lineNo1) {
                        // investigate all distances
                        double dist_scan1_scan2 = Math.sqrt(Math.pow((Double.valueOf(x_coord) - Double.valueOf(x_coord2)), 2) + Math.pow((Double.valueOf(y_coord) - Double.valueOf(y_coord2)), 2) + Math.pow((Double.valueOf(z_coord) - Double.valueOf(z_coord2)), 2));

                        double BondingDistance = BondScale * (Double.valueOf(radius) + Double.valueOf(radius2));

                        if ((dist_scan1_scan2 < BondingDistance) && (dist_scan1_scan2 > 0)) {

                            double A2 = 0;
                            double B2 = 0;
                            double C2 = 1;
                            double D2 = 0;
                            double x_proj1 = Double.valueOf(x_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                            double y_proj1 = Double.valueOf(y_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                            double z_proj1 = Double.valueOf(z_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                            double x_proj2 = Double.valueOf(x_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                            double y_proj2 = Double.valueOf(y_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                            double z_proj2 = Double.valueOf(z_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));

                            double x_bond1 = 100 * x_proj1;
                            double y_bond1 = 100 * y_proj1;
                            double x_bond2 = 100 * x_proj2;
                            double y_bond2 = 100 * y_proj2;

                            int bond_color1 = Integer.valueOf(atom_color);
                            int bond_color2 = Integer.valueOf(atom_color2);

                            // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                            double z_bond_average = 0.5 * (Double.valueOf(z_coord) + Double.valueOf(z_coord2)) + ForegroundShiftBonds;

                            // write the file
                            FileOutputStream fileout_bonds = getContext().openFileOutput("Coordinates.tmp", MODE_APPEND);
                            OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                            outputWriter_bonds.write(atom + "\t" + atom2 + "\t" + x_bond1 + "\t" + y_bond1 + "\t" + x_bond2 + "\t" + y_bond2 + "\t" + z_bond_average + "\t" + bond_color1 + "\t" + bond_color2 + "\t" + "0" + "\t" + "L" + "\n");
                            outputWriter_bonds.close();
                        } else if ((dist_scan1_scan2 >= BondingDistance) && (atom.equals("H") || atom2.equals("H"))) {
                            if (((atom.equals("H") && atom2.equals("N")) || ((atom.equals("N") && atom2.equals("H")))) && (dist_scan1_scan2 <= h_bond_limit_HN)) {
                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));

                                double x_bond1 = 100 * x_proj1;
                                double y_bond1 = 100 * y_proj1;
                                double x_bond2 = 100 * x_proj2;
                                double y_bond2 = 100 * y_proj2;

                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5 * (Double.valueOf(z_coord) + Double.valueOf(z_coord2)) + ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = getContext().openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom + "\t" + atom2 + "\t" + x_bond1 + "\t" + y_bond1 + "\t" + x_bond2 + "\t" + y_bond2 + "\t" + z_bond_average + "\t" + bond_color1 + "\t" + bond_color2 + "\t" + "0" + "\t" + "H" + "\n");
                                outputWriter_bonds.close();
                            } else if (((atom.equals("H") && atom2.equals("O")) || ((atom.equals("O") && atom2.equals("H")))) && (dist_scan1_scan2 <= h_bond_limit_HO)) {
                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));

                                double x_bond1 = 100 * x_proj1;
                                double y_bond1 = 100 * y_proj1;
                                double x_bond2 = 100 * x_proj2;
                                double y_bond2 = 100 * y_proj2;

                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5 * (Double.valueOf(z_coord) + Double.valueOf(z_coord2)) + ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = getContext().openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom + "\t" + atom2 + "\t" + x_bond1 + "\t" + y_bond1 + "\t" + x_bond2 + "\t" + y_bond2 + "\t" + z_bond_average + "\t" + bond_color1 + "\t" + bond_color2 + "\t" + "0" + "\t" + "H" + "\n");
                                outputWriter_bonds.close();
                            } else if (((atom.equals("H") && atom2.equals("F")) || ((atom.equals("F") && atom2.equals("H")))) && (dist_scan1_scan2 <= h_bond_limit_HF)) {
                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));

                                double x_bond1 = 100 * x_proj1;
                                double y_bond1 = 100 * y_proj1;
                                double x_bond2 = 100 * x_proj2;
                                double y_bond2 = 100 * y_proj2;

                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5 * (Double.valueOf(z_coord) + Double.valueOf(z_coord2)) + ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = getContext().openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom + "\t" + atom2 + "\t" + x_bond1 + "\t" + y_bond1 + "\t" + x_bond2 + "\t" + y_bond2 + "\t" + z_bond_average + "\t" + bond_color1 + "\t" + bond_color2 + "\t" + "0" + "\t" + "H" + "\n");
                                outputWriter_bonds.close();
                            } else if (((atom.equals("H") && atom2.equals("Cl")) || ((atom.equals("Cl") && atom2.equals("H")))) && (dist_scan1_scan2 <= h_bond_limit_HCl)) {
                                double A2 = 0;
                                double B2 = 0;
                                double C2 = 1;
                                double D2 = 0;
                                double x_proj1 = Double.valueOf(x_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double y_proj1 = Double.valueOf(y_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double z_proj1 = Double.valueOf(z_coord) - A * (Double.valueOf(x_coord) * A + Double.valueOf(y_coord) * B + Double.valueOf(z_coord) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double x_proj2 = Double.valueOf(x_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double y_proj2 = Double.valueOf(y_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
                                double z_proj2 = Double.valueOf(z_coord2) - A * (Double.valueOf(x_coord2) * A + Double.valueOf(y_coord2) * B + Double.valueOf(z_coord2) * C) / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));

                                double x_bond1 = 100 * x_proj1;
                                double y_bond1 = 100 * y_proj1;
                                double x_bond2 = 100 * x_proj2;
                                double y_bond2 = 100 * y_proj2;

                                int bond_color1 = Integer.valueOf(atom_color);
                                int bond_color2 = Integer.valueOf(atom_color2);

                                // find out the "middle" z-coordinate for the bond, elucidate the case when all atoms are in plane (bonds are hidden)

                                double z_bond_average = 0.5 * (Double.valueOf(z_coord) + Double.valueOf(z_coord2)) + ForegroundShiftBonds;

                                // write the file
                                FileOutputStream fileout_bonds = getContext().openFileOutput("Coordinates.tmp", MODE_APPEND);
                                OutputStreamWriter outputWriter_bonds = new OutputStreamWriter(fileout_bonds);
                                outputWriter_bonds.write(atom + "\t" + atom2 + "\t" + x_bond1 + "\t" + y_bond1 + "\t" + x_bond2 + "\t" + y_bond2 + "\t" + z_bond_average + "\t" + bond_color1 + "\t" + bond_color2 + "\t" + "0" + "\t" + "H" + "\n");
                                outputWriter_bonds.close();
                            }
                        }
                    }
                }
                scan2.close();
            }
            scan.close();
            exec("mv "+getContext().getFilesDir()+"/Coordinates.tmp "+getContext().getFilesDir()+"/canvas3d/");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // at the moment, the file Coordinates.tmp has to be sorted by the z_coord value:
        try {
            String Z_sort = exec("sort -g -k7 "+getContext().getFilesDir()+"/canvas3d/Coordinates.tmp");
            FileOutputStream fileout_sort = getContext().openFileOutput("Coordinates.tmp_", MODE_PRIVATE);
            OutputStreamWriter outputWriter_sort = new OutputStreamWriter(fileout_sort);
            outputWriter_sort.write(Z_sort);
            outputWriter_sort.close();
            exec("rm "+getContext().getFilesDir()+"/canvas3d/Coordinates.tmp");
            exec("mv "+getContext().getFilesDir()+"/Coordinates.tmp_ "+getContext().getFilesDir()+"/canvas3d/Coordinates.tmp");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /////////////////////////// file No. 3 = standardized 3D XYZ file //////////////////////////////////////////////
        try {
            Scanner scan = new Scanner(new File(getContext().getFilesDir()+"/canvas3d/Coordinates.x.tmp"));

            // get knowledge on number of already existing lines in the file
            InputStream inputStream = new FileInputStream(new File(getContext().getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
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
            FileOutputStream fileout0 = getContext().openFileOutput("Coordinates.xyz.tmp", MODE_PRIVATE);
            OutputStreamWriter outputWriter0 = new OutputStreamWriter(fileout0);
            outputWriter0.write(AtomNumber);
            outputWriter0.write("\n");
            outputWriter0.write("\n");
            outputWriter0.close();

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
                String col_at_border = splitted[8].trim();
                String touch_time = splitted[9].trim();

                // finish writing the file
                FileOutputStream fileout = getContext().openFileOutput("Coordinates.xyz.tmp", MODE_APPEND);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(atom+"\t"+x_coord+"\t"+y_coord+"\t"+z_coord+"\n");
                outputWriter.close();
            }
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        exec("mv "+getContext().getFilesDir()+"/Coordinates.xyz.tmp "+getContext().getFilesDir()+"/canvas3d/");
    }
}

