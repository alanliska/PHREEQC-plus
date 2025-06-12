package cz.p;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MolCanvas_reactant_canvasView extends View {
    public static float x_i, x_f, y_i, y_f, z_i, z_f;
    public static float x_2i, x_2f, y_2i, y_2f, z_2i, z_2f;
    public static float x_pix, y_pix, z_pix;
    public static float x_Ang, y_Ang, z_Ang;
    public static float x_act, y_act, z_act;
    float x2 = 0.0f;
    float y2 = 0.0f;
    public static float x_angle, y_angle, z_angle;
    public static float dist_pix, minDist_pix;
    public static float dist1_pix, dist2_pix;
    private int renderMolecule;
    public static int labelSwitch;
    public long touch_time, untouch_time;
    public static int ElementNumber;
    public static int minDistAtomBorderCol;
    public Paint Atoms;
    public Paint Borders;
    public Paint Bonds;
    public Paint Symbols;
    public Paint HBonds1;
    public Paint HBonds2;
    public static Canvas molCanvas;
    public static List<MolCanvas_object> zmat = new ArrayList<>();
    public static List<MolCanvas_object> bondlist = new ArrayList<>();
    public static final int FALSE = 0, TRUE = 1, NOT_SET = 2;
    public static int createAtoms = 0;
    public static int createLabels = 0;
    public static int createBonds = 0;
    public static int createHBonds = 0;
    public static float x_hist1 = 0.0f;
    public static float y_hist1 = 0.0f;
    public static float x_hist2 = 0.0f;
    public static float y_hist2 = 0.0f;
    public static float x_hist3 = 0.0f;
    public static float y_hist3 = 0.0f;

    public static final int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static final int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static final float width_pix = (float) getScreenWidth();
    public static final float height_pix = (float) getScreenHeight();

    public MolCanvas_reactant_canvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Atoms = new Paint();
        Borders = new Paint();
        Bonds = new Paint();
        Symbols = new Paint();
        HBonds1 = new Paint();
        HBonds2 = new Paint();

//        Typeface typeface = Typeface.create(Typeface.DEFAULT,Typeface.NORMAL);
//        Symbols.setTypeface(typeface);
        Symbols.setTypeface(Typeface.MONOSPACE);
        Atoms.setStyle(Paint.Style.FILL);
        Atoms.setAntiAlias(true);
        Borders.setStyle(Paint.Style.STROKE);
        Borders.setStrokeWidth(MolCanvas_reactant.zoom_scale * MolCanvas_preferences.get().getValue("bordersStrokeWidth"));

        // to display the canvas (once)
        setMoleculeRenderer(TRUE);
    }

    protected void onDraw(Canvas canvas) {
        molCanvas = canvas;
        super.onDraw(molCanvas);
        if (renderMolecule != NOT_SET) {
            if (renderMolecule == TRUE) {
                // background
                canvas.drawColor(MolCanvas_preferences.get().getIntValue("color_background"));
                // all objects together
                for (MolCanvas_object object : zmat) {
                    // atoms depiction (and their borders)
                    if (object.getObjectType() == 1) {
                        Atoms.setColor(object.getAtomColor1());
                        canvas.drawCircle(object.getAtom1X_pix(), object.getAtom1Y_pix(), object.getAtomRadius1_pix(),
                                Atoms);
                        Borders.setColor(object.getAtomBorderColor1());
                        canvas.drawCircle(object.getAtom1X_pix(), object.getAtom1Y_pix(), object.getAtomRadius1_pix(),
                                Borders);
                        // bonds
                    } else if (object.getObjectType() == 3) {
                        Bonds.setStrokeWidth(object.getAtomRadius1_pix());
                        Bonds.setColor(object.getAtomColor1());
                        canvas.drawLine(object.getAtom1X_pix(), object.getAtom1Y_pix(), object.getAtom12X_pix(),
                                object.getAtom12Y_pix(), Bonds);
                        Bonds.setColor(object.getAtomColor2());
                        canvas.drawLine(object.getAtom12X_pix(), object.getAtom12Y_pix(), object.getAtom2X_pix(),
                                object.getAtom2Y_pix(), Bonds);
                        // hydrogen bonds
                    } else if (object.getObjectType() == 2) {
                        HBonds1.setStrokeWidth(object.getAtomRadius1_pix());
                        HBonds1.setColor(object.getAtomColor1());
                        HBonds1.setPathEffect(new DashPathEffect(new float[] { object.getAtomRadius1_pix(),
                                object.getAtomRadius1_pix(), object.getAtomRadius1_pix(), object.getAtomRadius1_pix() },
                                0.0f));
                        canvas.drawLine(object.getAtom1X_pix(), object.getAtom1Y_pix(), object.getAtom12X_pix(),
                                object.getAtom12Y_pix(), HBonds1);
                        HBonds2.setStrokeWidth(object.getAtomRadius1_pix());
                        HBonds2.setColor(object.getAtomColor2());
                        HBonds2.setPathEffect(new DashPathEffect(new float[] { object.getAtomRadius1_pix(),
                                object.getAtomRadius1_pix(), object.getAtomRadius1_pix(), object.getAtomRadius1_pix() },
                                0.5f));
                        canvas.drawLine(object.getAtom12X_pix(), object.getAtom12Y_pix(), object.getAtom2X_pix(),
                                object.getAtom2Y_pix(), HBonds2);
                        // text
                    } else if (object.getObjectType() == 4 && labelSwitch == 1) {
                        Symbols.setColor(object.getAtomColor1());
                        Symbols.setTextSize(object.getAtomRadius1_pix());
                        canvas.drawText(object.getAtomSymbol1() + object.getAtomNumber1(), object.getAtom1X_pix(),
                                object.getAtom1Y_pix(), Symbols);
                    }
                }
            } else {
                // nothing
                setMoleculeRenderer(FALSE);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Handle touch events
        float x = (float) event.getX(0);
        float y = (float) event.getY(0);
        int action = event.getAction();
        // important:
        int pureaction = action & MotionEvent.ACTION_MASK;
        touch_time = System.currentTimeMillis();
        ElementNumber = getElementNumber();
        // important:
        switch (pureaction) {
            case MotionEvent.ACTION_DOWN:
                // because of ACTION_MOVE
                x2 = (float) event.getX(0);
                y2 = (float) event.getY(0);
                x_hist1 = x2;
                y_hist1 = y2;
                //
                touch_time = System.currentTimeMillis();
                // pixels
                x_pix = x;
                y_pix = y;
                z_pix = 0.0f;
                // Angstroms
                x_Ang = MolCanvas_methods.AtomX_pix(x_pix, MolCanvas_preferences.get().getValue("conv"), width_pix, MolCanvas_reactant.zoom_scale);
                y_Ang = MolCanvas_methods.AtomY_pix(y_pix, MolCanvas_preferences.get().getValue("conv"), height_pix, MolCanvas_reactant.zoom_scale);
                z_Ang = 0.0f;
                // initial display touch coordinates
                x_i = x;
                y_i = y;
                z_i = 0.0f;
                // check if there is at least one atom
                if (zmat.size() > 0) {
                    // check the distance of the touch from all atoms
                    for (MolCanvas_object object : zmat) {
                        int object_type = object.getObjectType();
                        // later on, also bonds and labels can be selected for deletion
                        if (object_type == 1) {
                            dist_pix = MolCanvas_methods.dist2D(x_pix, y_pix, object.getAtom1X_pix(), object.getAtom1Y_pix());
                            object.setDist2D_pix(dist_pix);
                        } else if (object_type == 4) {
                            dist_pix = MolCanvas_methods.dist2D(x_pix, y_pix,
                                    object.getAtom1X_pix() - MolCanvas_preferences.get().getValue("text_shift_x_pix"),
                                    object.getAtom1Y_pix() - MolCanvas_preferences.get().getValue("text_shift_y_pix"));
                            object.setDist2D_pix(dist_pix);
                            // in the case of bonds, the closer can be either the first, or the second atom
                        } else if (object_type == 2 || object_type == 3) {
                            dist1_pix = MolCanvas_methods.dist2D(x_pix, y_pix, object.getAtom1X_pix(), object.getAtom1Y_pix());
                            dist2_pix = MolCanvas_methods.dist2D(x_pix, y_pix, object.getAtom2X_pix(), object.getAtom2Y_pix());
                            if (dist1_pix <= dist2_pix) {
                                object.setDist2D_pix(dist1_pix);
                            } else if (dist1_pix > dist2_pix) {
                                object.setDist2D_pix(dist2_pix);
                            }
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                touch_time = System.currentTimeMillis();
                x_2i = (float) event.getX(1);
                y_2i = (float) event.getY(1);
                z_2i = 0.0f;
                // because of ACTION_MOVE - 2 pointer actions
                x_hist2 = x_2i;
                y_hist2 = y_2i;
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getPointerCount() == 1) {
                    touch_time = System.currentTimeMillis();
                    x_act = x;
                    y_act = y;
                    z_act = 0.0f;
                    int hist_size = event.getHistorySize();
                    float x_hist = 0.0f;
                    float y_hist = 0.0f;
                    if (hist_size > 0) {
                        x_hist = event.getHistoricalX(0, hist_size - 1);
                        y_hist = event.getHistoricalY(0, hist_size - 1);
                    } else if (hist_size == 0) {
                        x_hist = x_i;
                        y_hist = y_i;
                    }
                    x_angle = 0.0f;
                    y_angle = 0.0f;
                    float dist_act_hist = MolCanvas_methods.dist2D(x_hist, y_hist, x_act, y_act);
                    if (dist_act_hist != 0) {
                        x_angle = MolCanvas_preferences.get().getValue("angle_scale") * (x_act - x_hist) / dist_act_hist;
                        y_angle = MolCanvas_preferences.get().getValue("angle_scale") * (y_act - y_hist) / dist_act_hist;
                    } else if (dist_act_hist == 0) {
                        x_angle = MolCanvas_preferences.get().getValue("angle_scale") * (x_act - x_hist);
                        y_angle = MolCanvas_preferences.get().getValue("angle_scale") * (y_act - y_hist);
                    }
                    for (MolCanvas_object object : zmat) {
                        if (object.getObjectType() == 1) {
                            // get in Ang
                            float x_orig = object.getAtom1X_Ang();
                            float y_orig = object.getAtom1Y_Ang();
                            float z_orig = object.getAtom1Z_Ang();
                            // calculate new positions in Ang
                            float x_new = MolCanvas_methods.rotAtomX_x(x_orig, y_orig, z_orig, y_angle);
                            float y_new = MolCanvas_methods.rotAtomY_x(x_orig, y_orig, z_orig, y_angle);
                            float z_new = MolCanvas_methods.rotAtomZ_x(x_orig, y_orig, z_orig, y_angle);
                            float x_new2 = MolCanvas_methods.rotAtomX_y(x_new, y_new, z_new, x_angle);
                            float y_new2 = MolCanvas_methods.rotAtomY_y(x_new, y_new, z_new, x_angle);
                            float z_new2 = MolCanvas_methods.rotAtomZ_y(x_new, y_new, z_new, x_angle);
                            object.setAtom1X_Ang(x_new2);
                            object.setAtom1Y_Ang(y_new2);
                            object.setAtom1Z_Ang(z_new2);
                            object.setAtom12Z_Ang(z_new2);
                            // calculate projections in pix
                            float x_proj_new = MolCanvas_methods.AtomX_pix(x_new2, MolCanvas_preferences.get().getValue("conv"), width_pix,
                                    MolCanvas_reactant.zoom_scale);
                            float y_proj_new = MolCanvas_methods.AtomY_pix(y_new2, MolCanvas_preferences.get().getValue("conv"), height_pix,
                                    MolCanvas_reactant.zoom_scale);
                            object.setAtom1X_pix(x_proj_new);
                            object.setAtom1Y_pix(y_proj_new);
                            // treat atom radii
                            float r_orig = object.getAtomRadius1_Ang();
                            float r_new = MolCanvas_methods.Radius_pix(r_orig, MolCanvas_preferences.get().getValue("conv"),
                                    MolCanvas_preferences.get().getValue("radius_scale"), MolCanvas_reactant.zoom_scale, z_new2);
                            object.setAtomRadius1_pix(r_new);
                        } else if (object.getObjectType() == 4) {
                            // get in Ang
                            float x_orig = object.getAtom1X_Ang();
                            float y_orig = object.getAtom1Y_Ang();
                            float z_orig = object.getAtom1Z_Ang();
                            // calculate new positions in Ang
                            float x_new = MolCanvas_methods.rotAtomX_x(x_orig, y_orig, z_orig, y_angle);
                            float y_new = MolCanvas_methods.rotAtomY_x(x_orig, y_orig, z_orig, y_angle);
                            float z_new = MolCanvas_methods.rotAtomZ_x(x_orig, y_orig, z_orig, y_angle);
                            float x_new2 = MolCanvas_methods.rotAtomX_y(x_new, y_new, z_new, x_angle);
                            float y_new2 = MolCanvas_methods.rotAtomY_y(x_new, y_new, z_new, x_angle);
                            float z_new2 = MolCanvas_methods.rotAtomZ_y(x_new, y_new, z_new, x_angle);
                            object.setAtom1X_Ang(x_new2);
                            object.setAtom1Y_Ang(y_new2);
                            object.setAtom1Z_Ang(z_new2);
                            object.setAtom12Z_Ang(z_new2 + MolCanvas_preferences.get().getValue("text_shift_z_Ang"));
                            // calculate projections in pix
                            float x_proj_new = MolCanvas_methods.AtomX_pix(x_new2, MolCanvas_preferences.get().getValue("conv"), width_pix,
                                    MolCanvas_reactant.zoom_scale);
                            float y_proj_new = MolCanvas_methods.AtomY_pix(y_new2, MolCanvas_preferences.get().getValue("conv"), height_pix,
                                    MolCanvas_reactant.zoom_scale);
                            object.setAtom1X_pix(x_proj_new + MolCanvas_preferences.get().getValue("text_shift_x_pix"));
                            object.setAtom1Y_pix(y_proj_new + MolCanvas_preferences.get().getValue("text_shift_y_pix"));
                            // treat symbols size
                            float size_new = MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"),
                                    MolCanvas_reactant.zoom_scale, z_new2);
                            object.setAtomRadius1_pix(size_new);
                        } else if (object.getObjectType() == 2 || object.getObjectType() == 3) {
                            // get in Ang
                            float x_orig1 = object.getAtom1X_Ang();
                            float y_orig1 = object.getAtom1Y_Ang();
                            float z_orig1 = object.getAtom1Z_Ang();
                            float x_orig2 = object.getAtom2X_Ang();
                            float y_orig2 = object.getAtom2Y_Ang();
                            float z_orig2 = object.getAtom2Z_Ang();
                            float x_orig12 = object.getAtom12X_Ang();
                            float y_orig12 = object.getAtom12Y_Ang();
                            float z_orig12 = object.getAtom12Z_Ang();
                            // calculate new positions in Ang
                            float x1_new1 = MolCanvas_methods.rotAtomX_x(x_orig1, y_orig1, z_orig1, y_angle);
                            float y1_new1 = MolCanvas_methods.rotAtomY_x(x_orig1, y_orig1, z_orig1, y_angle);
                            float z1_new1 = MolCanvas_methods.rotAtomZ_x(x_orig1, y_orig1, z_orig1, y_angle);
                            float x1_new2 = MolCanvas_methods.rotAtomX_y(x1_new1, y1_new1, z1_new1, x_angle);
                            float y1_new2 = MolCanvas_methods.rotAtomY_y(x1_new1, y1_new1, z1_new1, x_angle);
                            float z1_new2 = MolCanvas_methods.rotAtomZ_y(x1_new1, y1_new1, z1_new1, x_angle);
                            object.setAtom1X_Ang(x1_new2);
                            object.setAtom1Y_Ang(y1_new2);
                            object.setAtom1Z_Ang(z1_new2);
                            float x2_new1 = MolCanvas_methods.rotAtomX_x(x_orig2, y_orig2, z_orig2, y_angle);
                            float y2_new1 = MolCanvas_methods.rotAtomY_x(x_orig2, y_orig2, z_orig2, y_angle);
                            float z2_new1 = MolCanvas_methods.rotAtomZ_x(x_orig2, y_orig2, z_orig2, y_angle);
                            float x2_new2 = MolCanvas_methods.rotAtomX_y(x2_new1, y2_new1, z2_new1, x_angle);
                            float y2_new2 = MolCanvas_methods.rotAtomY_y(x2_new1, y2_new1, z2_new1, x_angle);
                            float z2_new2 = MolCanvas_methods.rotAtomZ_y(x2_new1, y2_new1, z2_new1, x_angle);
                            object.setAtom2X_Ang(x2_new2);
                            object.setAtom2Y_Ang(y2_new2);
                            object.setAtom2Z_Ang(z2_new2);
                            float x12_new1 = MolCanvas_methods.rotAtomX_x(x_orig12, y_orig12, z_orig12, y_angle);
                            float y12_new1 = MolCanvas_methods.rotAtomY_x(x_orig12, y_orig12, z_orig12, y_angle);
                            float z12_new1 = MolCanvas_methods.rotAtomZ_x(x_orig12, y_orig12, z_orig12, y_angle);
                            float x12_new2 = MolCanvas_methods.rotAtomX_y(x12_new1, y12_new1, z12_new1, x_angle);
                            float y12_new2 = MolCanvas_methods.rotAtomY_y(x12_new1, y12_new1, z12_new1, x_angle);
                            float z12_new2 = MolCanvas_methods.rotAtomZ_y(x12_new1, y12_new1, z12_new1, x_angle);
                            object.setAtom12X_Ang(x12_new2);
                            object.setAtom12Y_Ang(y12_new2);
                            object.setAtom12Z_Ang(z12_new2);
                            // calculate projections in pix
                            float x1_proj_new = MolCanvas_methods.AtomX_pix(x1_new2, MolCanvas_preferences.get().getValue("conv"), width_pix,
                                    MolCanvas_reactant.zoom_scale);
                            float y1_proj_new = MolCanvas_methods.AtomY_pix(y1_new2, MolCanvas_preferences.get().getValue("conv"), height_pix,
                                    MolCanvas_reactant.zoom_scale);
                            object.setAtom1X_pix(x1_proj_new);
                            object.setAtom1Y_pix(y1_proj_new);
                            float x2_proj_new = MolCanvas_methods.AtomX_pix(x2_new2, MolCanvas_preferences.get().getValue("conv"), width_pix,
                                    MolCanvas_reactant.zoom_scale);
                            float y2_proj_new = MolCanvas_methods.AtomY_pix(y2_new2, MolCanvas_preferences.get().getValue("conv"), height_pix,
                                    MolCanvas_reactant.zoom_scale);
                            object.setAtom2X_pix(x2_proj_new);
                            object.setAtom2Y_pix(y2_proj_new);
                            float x12_proj_new = MolCanvas_methods.AtomX_pix(x12_new2, MolCanvas_preferences.get().getValue("conv"), width_pix,
                                    MolCanvas_reactant.zoom_scale);
                            float y12_proj_new = MolCanvas_methods.AtomY_pix(y12_new2, MolCanvas_preferences.get().getValue("conv"), height_pix,
                                    MolCanvas_reactant.zoom_scale);
                            object.setAtom12X_pix(x12_proj_new);
                            object.setAtom12Y_pix(y12_proj_new);
                            // bond thickness
                            float thick_new = MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"),
                                    MolCanvas_reactant.zoom_scale, z12_new2);
                            object.setAtomRadius1_pix(thick_new);
                        }
                    }
                    //reorder the arraylist according to the z12 coordinate
                    zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                    setMoleculeRenderer(TRUE);
                } else if (event.getPointerCount() == 2) {
                    float x_act1 = (float) event.getX(0);
                    float y_act1 = (float) event.getY(0);
                    float x_act2 = (float) event.getX(1);
                    float y_act2 = (float) event.getY(1);
                    int hist_size = event.getHistorySize();
                    if (hist_size > 0) {
                        x_hist1 = event.getHistoricalX(0, hist_size - 1);
                        y_hist1 = event.getHistoricalY(0, hist_size - 1);
                        x_hist2 = event.getHistoricalX(1, hist_size - 1);
                        y_hist2 = event.getHistoricalY(1, hist_size - 1);
                    }
                    float centerX_hist = 0.5f * (x_hist1 + x_hist2);
                    float centerY_hist = 0.5f * (y_hist1 + y_hist2);
                    float centerX_act = 0.5f * (x_act1 + x_act2);
                    float centerY_act = 0.5f * (y_act1 + y_act2);

                    float dist_hist = MolCanvas_methods.dist2D(x_hist1, y_hist1, x_hist2, y_hist2);
                    float dist_act = MolCanvas_methods.dist2D(x_act1, y_act1, x_act2, y_act2);
                    float slope_hist = (y_hist2 - y_hist1) / (x_hist2 - x_hist1);
                    float slope_act = (y_act2 - y_act1) / (x_act2 - x_act1);

                    z_angle = 0.0f;
                    if ((x_hist1 - x_hist2) * (x_act1 - x_act2) > 0) {
                        z_angle = MolCanvas_preferences.get().getValue("z_angle_scale")
                                * (float) (-Math.atan(Double.valueOf(slope_act)) + Math.atan(Double.valueOf(slope_hist)));
                    } else {
                        z_angle = 0.0f;
                    }
                    float zoom_change = 0.0f;
                    if (dist_act != dist_hist) {
                        zoom_change = MolCanvas_preferences.get().getValue("zoom_scale") * (dist_act - dist_hist);
                    } else if (dist_act == dist_hist) {
                        zoom_change = 0.0f;
                    }
                    // 0.001f is to prevent zero underflow of FLoat
                    if (MolCanvas_reactant.zoom_scale + zoom_change > 0.001f) {
                        float zoom_scale_new = 1.0f;
                        zoom_scale_new = MolCanvas_methods.zoomReset(MolCanvas_reactant.zoom_scale, zoom_change);
                        MolCanvas_preferences.get().setValue("zoom", zoom_scale_new);
                        MolCanvas_reactant.zoom_scale = zoom_scale_new;
                    }
                    float x_transl_pix = 0.5f * (x_act1 - x_hist1 + x_act2 - x_hist2)
                            * MolCanvas_preferences.get().getValue("transl_scale");
                    float y_transl_pix = 0.5f * (y_act1 - y_hist1 + y_act2 - y_hist2)
                            * MolCanvas_preferences.get().getValue("transl_scale");
                    float x_transl_Ang = (x_transl_pix / MolCanvas_preferences.get().getValue("conv"));
                    //        * MolCanvas_preferences.get().getValue("transl_scale");
                    float y_transl_Ang = (-y_transl_pix / MolCanvas_preferences.get().getValue("conv"));
                    //        * MolCanvas_preferences.get().getValue("transl_scale");

                    for (MolCanvas_object object : zmat) {
                        if (object.getObjectType() == 1) {
                            // get in Ang
                            float x_orig = object.getAtom1X_Ang();
                            float y_orig = object.getAtom1Y_Ang();
                            float z_orig = object.getAtom1Z_Ang();
                            // calculate new positions in Ang
                            float x_new = MolCanvas_methods.rotAtomX_z(x_orig, y_orig, z_orig, z_angle);
                            float y_new = MolCanvas_methods.rotAtomY_z(x_orig, y_orig, z_orig, z_angle);
                            float x_new2 = MolCanvas_methods.translAtom_x(x_new, x_transl_Ang);
                            float y_new2 = MolCanvas_methods.translAtom_y(y_new, y_transl_Ang);
                            object.setAtom1X_Ang(x_new2);
                            object.setAtom1Y_Ang(y_new2);
                            // calculate projections in pix
                            float x_proj_new = MolCanvas_methods.AtomX_pix(x_new2, MolCanvas_preferences.get().getValue("conv"), width_pix,
                                    MolCanvas_reactant.zoom_scale);
                            float y_proj_new = MolCanvas_methods.AtomY_pix(y_new2, MolCanvas_preferences.get().getValue("conv"), height_pix,
                                    MolCanvas_reactant.zoom_scale);
                            object.setAtom1X_pix(x_proj_new);
                            object.setAtom1Y_pix(y_proj_new);
                            // treat atom radii
                            float r_orig = object.getAtomRadius1_Ang();
                            float r_proj = MolCanvas_methods.Radius_pix(r_orig, MolCanvas_preferences.get().getValue("conv"),
                                    MolCanvas_preferences.get().getValue("radius_scale"), MolCanvas_reactant.zoom_scale,
                                    object.getAtom12Z_Ang());
                            object.setAtomRadius1_pix(r_proj);
                        } else if (object.getObjectType() == 4) {
                            // get in Ang
                            float x_orig = object.getAtom1X_Ang();
                            float y_orig = object.getAtom1Y_Ang();
                            float z_orig = object.getAtom1Z_Ang();
                            // calculate new positions in Ang
                            float x_new = MolCanvas_methods.rotAtomX_z(x_orig, y_orig, z_orig, z_angle);
                            float y_new = MolCanvas_methods.rotAtomY_z(x_orig, y_orig, z_orig, z_angle);
                            float x_new2 = MolCanvas_methods.translAtom_x(x_new, x_transl_Ang);
                            float y_new2 = MolCanvas_methods.translAtom_y(y_new, y_transl_Ang);
                            object.setAtom1X_Ang(x_new2);
                            object.setAtom1Y_Ang(y_new2);
                            // calculate projections in pix
                            float x_proj_new = MolCanvas_methods.AtomX_pix(x_new2, MolCanvas_preferences.get().getValue("conv"), width_pix,
                                    MolCanvas_reactant.zoom_scale);
                            float y_proj_new = MolCanvas_methods.AtomY_pix(y_new2, MolCanvas_preferences.get().getValue("conv"), height_pix,
                                    MolCanvas_reactant.zoom_scale);
                            object.setAtom1X_pix(x_proj_new + MolCanvas_preferences.get().getValue("text_shift_x_pix"));
                            object.setAtom1Y_pix(y_proj_new + MolCanvas_preferences.get().getValue("text_shift_y_pix"));
                            // treat symbols size
                            float size_proj = MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"),
                                    MolCanvas_reactant.zoom_scale, object.getAtom1Z_Ang());
                            object.setAtomRadius1_pix(size_proj);
                        } else if (object.getObjectType() == 2 || object.getObjectType() == 3) {
                            // get in Ang
                            float x_orig1 = object.getAtom1X_Ang();
                            float y_orig1 = object.getAtom1Y_Ang();
                            float z_orig1 = object.getAtom1Z_Ang();
                            float x_orig2 = object.getAtom2X_Ang();
                            float y_orig2 = object.getAtom2Y_Ang();
                            float z_orig2 = object.getAtom2Z_Ang();
                            float z_orig12 = object.getAtom12Z_Ang();
                            // calculate new positions in Ang
                            float x1_new1 = MolCanvas_methods.rotAtomX_z(x_orig1, y_orig1, z_orig1, z_angle);
                            float y1_new1 = MolCanvas_methods.rotAtomY_z(x_orig1, y_orig1, z_orig1, z_angle);
                            float x1_new2 = MolCanvas_methods.translAtom_x(x1_new1, x_transl_Ang);
                            float y1_new2 = MolCanvas_methods.translAtom_y(y1_new1, y_transl_Ang);
                            object.setAtom1X_Ang(x1_new2);
                            object.setAtom1Y_Ang(y1_new2);
                            float x2_new1 = MolCanvas_methods.rotAtomX_z(x_orig2, y_orig2, z_orig2, z_angle);
                            float y2_new1 = MolCanvas_methods.rotAtomY_z(x_orig2, y_orig2, z_orig2, z_angle);
                            float x2_new2 = MolCanvas_methods.translAtom_x(x2_new1, x_transl_Ang);
                            float y2_new2 = MolCanvas_methods.translAtom_y(y2_new1, y_transl_Ang);
                            object.setAtom2X_Ang(x2_new2);
                            object.setAtom2Y_Ang(y2_new2);
                            float x12_new = 0.5f * (x1_new2 + x2_new2);
                            float y12_new = 0.5f * (y1_new2 + y2_new2);
                            object.setAtom12X_Ang(x12_new);
                            object.setAtom12Y_Ang(y12_new);
                            // calculate projections in pix
                            float x1_proj_new = MolCanvas_methods.AtomX_pix(x1_new2, MolCanvas_preferences.get().getValue("conv"), width_pix,
                                    MolCanvas_reactant.zoom_scale);
                            float y1_proj_new = MolCanvas_methods.AtomY_pix(y1_new2, MolCanvas_preferences.get().getValue("conv"), height_pix,
                                    MolCanvas_reactant.zoom_scale);
                            object.setAtom1X_pix(x1_proj_new);
                            object.setAtom1Y_pix(y1_proj_new);
                            float x2_proj_new = MolCanvas_methods.AtomX_pix(x2_new2, MolCanvas_preferences.get().getValue("conv"), width_pix,
                                    MolCanvas_reactant.zoom_scale);
                            float y2_proj_new = MolCanvas_methods.AtomY_pix(y2_new1, MolCanvas_preferences.get().getValue("conv"), height_pix,
                                    MolCanvas_reactant.zoom_scale);
                            object.setAtom2X_pix(x2_proj_new);
                            object.setAtom2Y_pix(y2_proj_new);
                            float x12_proj_new = MolCanvas_methods.AtomX_pix(x12_new, MolCanvas_preferences.get().getValue("conv"), width_pix,
                                    MolCanvas_reactant.zoom_scale);
                            float y12_proj_new = MolCanvas_methods.AtomY_pix(y12_new, MolCanvas_preferences.get().getValue("conv"), height_pix,
                                    MolCanvas_reactant.zoom_scale);
                            object.setAtom12X_pix(x12_proj_new);
                            object.setAtom12Y_pix(y12_proj_new);
                            // treat bond thickness
                            float thick_new = MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"),
                                    MolCanvas_reactant.zoom_scale, z_orig12);
                            object.setAtomRadius1_pix(thick_new);
                        }
                    }
                    //reorder the arraylist according to the z12 coordinate
                    zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                    //Collections.reverse(zmat);
                    setMoleculeRenderer(TRUE);
                } else if (event.getPointerCount() == 3) {
                    float x_act3 = (float) event.getX(2);
                    float y_act3 = (float) event.getY(2);

                    int hist_size = event.getHistorySize();

                    if (hist_size > 0) {
                        x_hist3 = event.getHistoricalX(2, hist_size - 1);
                        y_hist3 = event.getHistoricalY(2, hist_size - 1);
                    } else {
                        x_hist3 = x_act3;
                        y_hist3 = y_act3;
                    }

                    float z_transl_pix = 0.5f * (-y_act3 + y_hist3 + x_act3 - x_hist3)
                            * MolCanvas_preferences.get().getValue("z_transl_scale");
                    float z_transl_Ang = (z_transl_pix / MolCanvas_preferences.get().getValue("conv"));
                    //        * MolCanvas_preferences.get().getValue("z_transl_scale");

                    for (MolCanvas_object object : zmat) {
                        if (object.getObjectType() == 1) {
                            // get in Ang
                            float z_orig = object.getAtom1Z_Ang();
                            // calculate new positions in Ang
                            float z_new2 = MolCanvas_methods.translAtom_z(z_orig, z_transl_Ang);
                            object.setAtom1Z_Ang(z_new2);
                            object.setAtom12Z_Ang(z_new2);
                            // treat atom radii
                            float r_orig = object.getAtomRadius1_Ang();
                            //	float r_proj_orig = MolCanvas_methods.Radius_pix(r_orig,MolCanvas_preferences.get().getValue("conv"),MolCanvas_reactant.zoom_scale);
                            float r_proj = MolCanvas_methods.Radius_pix(r_orig, MolCanvas_preferences.get().getValue("conv"),
                                    MolCanvas_preferences.get().getValue("radius_scale"), MolCanvas_reactant.zoom_scale,
                                    object.getAtom12Z_Ang());
                            object.setAtomRadius1_pix(r_proj);
                        } else if (object.getObjectType() == 4) {
                            // get in Ang
                            float z_orig = object.getAtom1Z_Ang();
                            // calculate new positions in Ang
                            float z_new2 = MolCanvas_methods.translAtom_z(z_orig, z_transl_Ang);
                            object.setAtom1Z_Ang(z_new2);
                            object.setAtom12Z_Ang(z_new2+MolCanvas_preferences.get().getValue("text_shift_z_Ang"));
                            // treat symbols size
                            float size_proj = MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"),
                                    MolCanvas_reactant.zoom_scale, object.getAtom1Z_Ang());
                            object.setAtomRadius1_pix(size_proj);
                        } else if (object.getObjectType() == 2 || object.getObjectType() == 3) {
                            // get in Ang
                            float z_orig1 = object.getAtom1Z_Ang();
                            float z_orig2 = object.getAtom2Z_Ang();
                            // calculate new positions in Ang
                            float z1_new2 = MolCanvas_methods.translAtom_z(z_orig1, z_transl_Ang);
                            object.setAtom1Z_Ang(z1_new2);
                            float z2_new2 = MolCanvas_methods.translAtom_z(z_orig2, z_transl_Ang);
                            object.setAtom2Z_Ang(z2_new2);
                            float z12_new = 0.5f * (z1_new2 + z2_new2);
                            object.setAtom12Z_Ang(z12_new);
                            // treat bond thickness
                            float thick_new = MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"),
                                    MolCanvas_reactant.zoom_scale, z12_new);
                            object.setAtomRadius1_pix(thick_new);
                        }
                    }
                    //reorder the arraylist according to the z12 coordinate
                    zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                    setMoleculeRenderer(TRUE);
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                x_2f = x;
                y_2f = y;
                z_2f = 0.0f;
                break;
            case MotionEvent.ACTION_UP:
                // pixels
                x_pix = x;
                y_pix = y;
                z_pix = 0.0f;
                // Angstroms
                x_Ang = MolCanvas_methods.AtomX_Ang(x_pix, MolCanvas_preferences.get().getValue("conv"), width_pix, MolCanvas_reactant.zoom_scale);
                y_Ang = MolCanvas_methods.AtomY_Ang(y_pix, MolCanvas_preferences.get().getValue("conv"), height_pix, MolCanvas_reactant.zoom_scale);
                z_Ang = 0.0f;
                // untouch pixels
                x_f = x;
                y_f = y;
                z_f = 0.0f;
                untouch_time = System.currentTimeMillis();
                if (x_i == x_f & y_i == y_f) {
                    if (zmat.size() == 0) {
                        createAtoms = 1;
                        createLabels = 1;
                    } else if (zmat.size() > 0) {
                        // decide if there is already an atom present
                        zmat.sort(Comparator.comparing(a -> a.getDist2D_pix()));
                        // first element
                        int ind = 0;
                        // very important, otherwise for more than two atoms, the app crashes (here it is resolved - List must not be changed when read)
                        try {
                            for (MolCanvas_object object : zmat) {
                                minDist_pix = object.getDist2D_pix();
                                if (minDist_pix <= MolCanvas_preferences.get().getValue("minDistCrit_pix")
                                        && (object.getObjectType() == 1 || object.getObjectType() == 4)) {
                                    minDistAtomBorderCol = object.getAtomBorderColor1();

                                    switch (minDistAtomBorderCol) {
                                        case Color.BLACK:
                                            object.setAtomBorderColor1(Color.RED);
                                            object.setTouchTime(touch_time);
                                            break;
                                        case Color.RED:
                                            object.setAtomBorderColor1(Color.BLACK);
                                            object.setTouchTime(touch_time);
                                            break;
                                    }
                                }
                                // for atoms only
                                if (object.getObjectType() == 1) {
                                    ind++;
                                    if (ind == 1) {
                                        // no atom present, therefore create one at z=0
                                        if (minDist_pix > MolCanvas_preferences.get().getValue("minDistCrit_pix")) {
                                            if (getSelectedAtomsCount() == 0) {
                                                createAtoms = 1;
                                                createLabels = 1;
                                                createBonds = 1;
                                                createHBonds = 1;
                                            } else {
                                                unselectMolCanvas_objects();
                                            }
                                        }
                                    }

                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (createAtoms == 1) {
                        createNewAtom();
                        createAtoms = 0;
                    }
                    if (createLabels == 1) {
                        createNewLabel();
                        createLabels = 0;
                    }
                    if (createBonds == 1) {
                        createNewBonds();
                        createBonds = 0;
                    }
                    if (createHBonds == 1) {
                        createNewHBonds();
                        createHBonds = 0;
                    }
                    // reorder according to the z-axis (the closer atoms are drawn later than the more distant ones)
                    zmat.sort(Comparator.comparing(a -> a.getAtom12Z_Ang()));
                    invalidate();
                } else {
                    // case when untouch finger is at different point than the touch finger point
                }
                setMoleculeRenderer(TRUE);
                break;
        }
        return true;
    }

    public void createNewAtom() {
        ElementNumber = getElementNumber();
        ElementNumber++;
        zmat.add(new MolCanvas_object(ElementNumber, MolCanvas_reactant_periodicTable.Element, MolCanvas_reactant_periodicTable.ElementColor,
                MolCanvas_reactant_periodicTable.ElementBorderColor, MolCanvas_reactant_periodicTable.ElementRadius,
                MolCanvas_methods.Radius_pix(MolCanvas_reactant_periodicTable.ElementRadius, MolCanvas_preferences.get().getValue("conv"),
                        MolCanvas_preferences.get().getValue("radius_scale"), MolCanvas_reactant.zoom_scale, z_Ang),
                touch_time, x_Ang, y_Ang, z_Ang, x_f, y_f, 0, "", 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, z_Ang,
                0.0f, 0.0f, dist_pix, 1));
    }

    public void createNewLabel() {
        zmat.add(new MolCanvas_object(ElementNumber, MolCanvas_reactant_periodicTable.Element, MolCanvas_reactant_periodicTable.ElementTextColor,
                MolCanvas_reactant_periodicTable.ElementBorderColor, 0,
                MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), MolCanvas_reactant.zoom_scale, z_Ang), touch_time,
                x_Ang, y_Ang, z_Ang, x_f + MolCanvas_preferences.get().getValue("text_shift_x_pix"),
                y_f + MolCanvas_preferences.get().getValue("text_shift_y_pix"), 0, "", 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, z_Ang + MolCanvas_preferences.get().getValue("text_shift_z_Ang"), 0.0f, 0.0f, dist_pix, 4));
    }

    public void createNewBonds() {
        float distanceFromAtoms;
        for (MolCanvas_object object : zmat) {
            // for atoms only
            if (object.getObjectType() == 1) {
                distanceFromAtoms = MolCanvas_methods.dist3D(x_Ang, y_Ang, z_Ang, object.getAtom1X_Ang(), object.getAtom1Y_Ang(),
                        object.getAtom1Z_Ang());
                if (distanceFromAtoms <= (MolCanvas_preferences.get().getValue("bond_scale")
                        * (MolCanvas_reactant_periodicTable.ElementRadius + object.getAtomRadius1_Ang())) && distanceFromAtoms != 0.0f) {
                    // exclude the self distance, at the moment the next atom already is in zmat
                    bondlist.add(new MolCanvas_object(ElementNumber, MolCanvas_reactant_periodicTable.Element, MolCanvas_reactant_periodicTable.ElementColor,
                            MolCanvas_reactant_periodicTable.ElementBorderColor, 0,
                            MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"), MolCanvas_reactant.zoom_scale,
                                    0.5f * (z_Ang + object.getAtom1Z_Ang())),
                            touch_time, x_Ang, y_Ang, z_Ang, x_f, y_f, object.getAtomNumber1(), object.getAtomSymbol1(),
                            object.getAtomColor1(), object.getAtom1X_Ang(), object.getAtom1Y_Ang(),
                            object.getAtom1Z_Ang(), object.getAtom1X_pix(), object.getAtom1Y_pix(),
                            0.5f * (x_Ang + object.getAtom1X_Ang()), 0.5f * (y_Ang + object.getAtom1Y_Ang()),
                            0.5f * (z_Ang + object.getAtom1Z_Ang()), 0.5f * (x_pix + object.getAtom1X_pix()),
                            0.5f * (y_pix + object.getAtom1Y_pix()), 0.0f, 3));
                }
            }
        }
        executeNewBonds();
    }

    public void createNewHBonds() {
        float distanceFromAtoms;
        for (MolCanvas_object object : zmat) {
            // for atoms only
            if (object.getObjectType() == 1) {
                distanceFromAtoms = MolCanvas_methods.dist3D(x_Ang, y_Ang, z_Ang, object.getAtom1X_Ang(), object.getAtom1Y_Ang(),
                        object.getAtom1Z_Ang());
                if (distanceFromAtoms <= (MolCanvas_preferences.get().getValue("hydr_bond_scale")
                        * (MolCanvas_reactant_periodicTable.ElementRadius + object.getAtomRadius1_Ang()))
                        && distanceFromAtoms != 0.0f
                        && ((MolCanvas_reactant_periodicTable.Element.equals("H")
                        && (object.getAtomSymbol1().equals("F") || object.getAtomSymbol1().equals("O")
                        || object.getAtomSymbol1().equals("Cl") || object.getAtomSymbol1().equals("N")))
                        || (object.getAtomSymbol1().equals("H") && (MolCanvas_reactant_periodicTable.Element.equals("F")
                        || MolCanvas_reactant_periodicTable.Element.equals("O") || MolCanvas_reactant_periodicTable.Element.equals("Cl")
                        || MolCanvas_reactant_periodicTable.Element.equals("N"))))) {
                    // exclude the self distance, at the moment the next atom already is in zmat
                    bondlist.add(new MolCanvas_object(ElementNumber, MolCanvas_reactant_periodicTable.Element, MolCanvas_reactant_periodicTable.ElementColor, 0, 0,
                            MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"), MolCanvas_reactant.zoom_scale,
                                    0.5f * (z_Ang + object.getAtom1Z_Ang())),
                            touch_time, x_Ang, y_Ang, z_Ang, x_f, y_f, object.getAtomNumber1(), object.getAtomSymbol1(),
                            object.getAtomColor1(), object.getAtom1X_Ang(), object.getAtom1Y_Ang(),
                            object.getAtom1Z_Ang(), object.getAtom1X_pix(), object.getAtom1Y_pix(),
                            0.5f * (x_Ang + object.getAtom1X_Ang()), 0.5f * (y_Ang + object.getAtom1Y_Ang()),
                            0.5f * (z_Ang + object.getAtom1Z_Ang()), 0.5f * (x_pix + object.getAtom1X_pix()),
                            0.5f * (y_pix + object.getAtom1Y_pix()), 0.0f, 2));
                }
            }
        }
        executeNewBonds();
    }

    public void executeNewBonds() {
        // exclude the self distance, at the moment the next atom already is in zmat
        for (MolCanvas_object bondobject : bondlist) {
            zmat.add(new MolCanvas_object(ElementNumber, MolCanvas_reactant_periodicTable.Element, MolCanvas_reactant_periodicTable.ElementColor,
                    MolCanvas_reactant_periodicTable.ElementBorderColor, 0,
                    MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"), MolCanvas_reactant.zoom_scale,
                            0.5f * (z_Ang + bondobject.getAtom2Z_Ang())),
                    touch_time, x_Ang, y_Ang, z_Ang, x_f, y_f, bondobject.getAtomNumber2(), bondobject.getAtomSymbol2(),
                    bondobject.getAtomColor2(), bondobject.getAtom2X_Ang(), bondobject.getAtom2Y_Ang(),
                    bondobject.getAtom2Z_Ang(), bondobject.getAtom2X_pix(), bondobject.getAtom2Y_pix(),
                    0.5f * (x_Ang + bondobject.getAtom2X_Ang()), 0.5f * (y_Ang + bondobject.getAtom2Y_Ang()),
                    0.5f * (z_Ang + bondobject.getAtom2Z_Ang()), 0.5f * (x_pix + bondobject.getAtom2X_pix()),
                    0.5f * (y_pix + bondobject.getAtom2Y_pix()), 0.0f, bondobject.getObjectType()));
        }
        bondlist.clear();
    }

    public static int getSelectedAtomsCount() {
        int selectedAtomCount = 0;
        for (MolCanvas_object object : zmat) {
            if (object.getAtomBorderColor1() == Color.RED && object.getObjectType() == 1) {
                selectedAtomCount++;
            }
        }
        return selectedAtomCount;
    }

    public static int getAtomsCount() {
        int atomCount = 0;
        for (MolCanvas_object object : zmat) {
            if (object.getObjectType() == 1) {
                atomCount++;
            }
        }
        return atomCount;
    }

    public static int getElementNumber() {
        int index = 0;
        for (MolCanvas_object object : zmat) {
            if (object.getObjectType() == 1) {
                index++;
            }
        }
        return index;
    }

    public static void unselectMolCanvas_objects() {
        for (MolCanvas_object object : zmat) {
            if (object.getAtomBorderColor1() == MolCanvas_preferences.get().getIntValue("selectedColor")) {
                object.setAtomBorderColor1(MolCanvas_preferences.get().getIntValue("unselectedColor"));
            }
        }
    }

    public static void centerMolecule() {
        float X_min_old = (float) Integer.MAX_VALUE;
        float X_min_new = (float) Integer.MAX_VALUE;
        float Y_min_old = (float) Integer.MAX_VALUE;
        float Y_min_new = (float) Integer.MAX_VALUE;
        float Z_min_old = (float) Integer.MAX_VALUE;
        float Z_min_new = (float) Integer.MAX_VALUE;
        float X_max_old = (float) Integer.MIN_VALUE;
        float X_max_new = (float) Integer.MIN_VALUE;
        float Y_max_old = (float) Integer.MIN_VALUE;
        float Y_max_new = (float) Integer.MIN_VALUE;
        float Z_max_old = (float) Integer.MIN_VALUE;
        float Z_max_new = (float) Integer.MIN_VALUE;
        for (MolCanvas_object object : zmat) {
            if (object.getObjectType() == 1) {
                X_min_new = MolCanvas_methods.minValue(X_min_old, object.getAtom1X_Ang());
                Y_min_new = MolCanvas_methods.minValue(Y_min_old, object.getAtom1Y_Ang());
                Z_min_new = MolCanvas_methods.minValue(Z_min_old, object.getAtom1Z_Ang());
                X_max_new = MolCanvas_methods.maxValue(X_max_old, object.getAtom1X_Ang());
                Y_max_new = MolCanvas_methods.maxValue(Y_max_old, object.getAtom1Y_Ang());
                Z_max_new = MolCanvas_methods.maxValue(Z_max_old, object.getAtom1Z_Ang());
            }
            X_min_old = X_min_new;
            Y_min_old = Y_min_new;
            Z_min_old = Z_min_new;
            X_max_old = X_max_new;
            Y_max_old = Y_max_new;
            Z_max_old = Z_max_new;
        }
        float X_center = (X_max_new + X_min_new) / 2.0f;
        float Y_center = (Y_max_new + Y_min_new) / 2.0f;
        float Z_center = (Z_max_new + Z_min_new) / 2.0f;
        for (MolCanvas_object object : zmat) {
            if (object.getObjectType() == 1) {
                // get in Ang
                float x_orig = object.getAtom1X_Ang();
                float y_orig = object.getAtom1Y_Ang();
                float z_orig = object.getAtom1Z_Ang();
                // calculate new positions in Ang
                float x_new = MolCanvas_methods.translAtom_x(x_orig, -X_center);
                float y_new = MolCanvas_methods.translAtom_y(y_orig, -Y_center);
                float z_new = MolCanvas_methods.translAtom_z(z_orig, -Z_center);
                object.setAtom1X_Ang(x_new);
                object.setAtom1Y_Ang(y_new);
                object.setAtom1Z_Ang(z_new);
                object.setAtom12Z_Ang(z_new);
                // calculate projections in pix
                float x_proj_new = MolCanvas_methods.AtomX_pix(x_new, MolCanvas_preferences.get().getValue("conv"), width_pix,
                        MolCanvas_reactant.zoom_scale);
                float y_proj_new = MolCanvas_methods.AtomY_pix(y_new, MolCanvas_preferences.get().getValue("conv"), height_pix,
                        MolCanvas_reactant.zoom_scale);
                object.setAtom1X_pix(x_proj_new);
                object.setAtom1Y_pix(y_proj_new);
                // radii
                float r_orig = object.getAtomRadius1_Ang();
                float r_proj = MolCanvas_methods.Radius_pix(r_orig, MolCanvas_preferences.get().getValue("conv"),
                        MolCanvas_preferences.get().getValue("radius_scale"), MolCanvas_reactant.zoom_scale, object.getAtom12Z_Ang());
                object.setAtomRadius1_pix(r_proj);
            } else if (object.getObjectType() == 4) {
                float x_orig = object.getAtom1X_Ang();
                float y_orig = object.getAtom1Y_Ang();
                float z_orig = object.getAtom1Z_Ang();
                // calculate new positions in Ang
                float x_new = MolCanvas_methods.translAtom_x(x_orig, -X_center);
                float y_new = MolCanvas_methods.translAtom_y(y_orig, -Y_center);
                float z_new = MolCanvas_methods.translAtom_z(z_orig, -Z_center);
                object.setAtom1X_Ang(x_new);
                object.setAtom1Y_Ang(y_new);
                object.setAtom1Z_Ang(z_new);
                object.setAtom12Z_Ang(z_new + MolCanvas_preferences.get().getValue("text_shift_z_Ang"));
                // calculate projections in pix
                float x_proj_new = MolCanvas_methods.AtomX_pix(x_new, MolCanvas_preferences.get().getValue("conv"), width_pix,
                        MolCanvas_reactant.zoom_scale);
                float y_proj_new = MolCanvas_methods.AtomY_pix(y_new, MolCanvas_preferences.get().getValue("conv"), height_pix,
                        MolCanvas_reactant.zoom_scale);
                object.setAtom1X_pix(x_proj_new + MolCanvas_preferences.get().getValue("text_shift_x_pix"));
                object.setAtom1Y_pix(y_proj_new + MolCanvas_preferences.get().getValue("text_shift_y_pix"));
                // symbols
                float size_symbols = MolCanvas_methods.Text_pix(MolCanvas_preferences.get().getValue("text_size"), MolCanvas_reactant.zoom_scale,
                        z_new);
                object.setAtomRadius1_pix(size_symbols);
            } else if (object.getObjectType() == 2 || object.getObjectType() == 3) {
                // get in Ang
                float x_orig1 = object.getAtom1X_Ang();
                float y_orig1 = object.getAtom1Y_Ang();
                float z_orig1 = object.getAtom1Z_Ang();
                float x_orig2 = object.getAtom2X_Ang();
                float y_orig2 = object.getAtom2Y_Ang();
                float z_orig2 = object.getAtom2Z_Ang();
                float x_orig12 = object.getAtom12X_Ang();
                float y_orig12 = object.getAtom12Y_Ang();
                float z_orig12 = object.getAtom12Z_Ang();
                // calculate new positions in Ang
                float x1_new1 = MolCanvas_methods.translAtom_x(x_orig1, -X_center);
                float y1_new1 = MolCanvas_methods.translAtom_y(y_orig1, -Y_center);
                float z1_new1 = MolCanvas_methods.translAtom_z(z_orig1, -Z_center);
                object.setAtom1X_Ang(x1_new1);
                object.setAtom1Y_Ang(y1_new1);
                object.setAtom1Z_Ang(z1_new1);
                float x2_new1 = MolCanvas_methods.translAtom_x(x_orig2, -X_center);
                float y2_new1 = MolCanvas_methods.translAtom_y(y_orig2, -Y_center);
                float z2_new1 = MolCanvas_methods.translAtom_z(z_orig2, -Z_center);
                object.setAtom2X_Ang(x2_new1);
                object.setAtom2Y_Ang(y2_new1);
                object.setAtom2Z_Ang(z2_new1);
                float x12_new1 = MolCanvas_methods.translAtom_x(x_orig12, -X_center);
                float y12_new1 = MolCanvas_methods.translAtom_y(y_orig12, -Y_center);
                float z12_new1 = MolCanvas_methods.translAtom_z(z_orig12, -Z_center);
                object.setAtom12X_Ang(x12_new1);
                object.setAtom12Y_Ang(y12_new1);
                object.setAtom12Z_Ang(z12_new1);
                // calculate projections in pix
                float x1_proj_new = MolCanvas_methods.AtomX_pix(x1_new1, MolCanvas_preferences.get().getValue("conv"), width_pix,
                        MolCanvas_reactant.zoom_scale);
                float y1_proj_new = MolCanvas_methods.AtomY_pix(y1_new1, MolCanvas_preferences.get().getValue("conv"), height_pix,
                        MolCanvas_reactant.zoom_scale);
                object.setAtom1X_pix(x1_proj_new);
                object.setAtom1Y_pix(y1_proj_new);
                float x2_proj_new = MolCanvas_methods.AtomX_pix(x2_new1, MolCanvas_preferences.get().getValue("conv"), width_pix,
                        MolCanvas_reactant.zoom_scale);
                float y2_proj_new = MolCanvas_methods.AtomY_pix(y2_new1, MolCanvas_preferences.get().getValue("conv"), height_pix,
                        MolCanvas_reactant.zoom_scale);
                object.setAtom2X_pix(x2_proj_new);
                object.setAtom2Y_pix(y2_proj_new);
                float x12_proj_new = MolCanvas_methods.AtomX_pix(x12_new1, MolCanvas_preferences.get().getValue("conv"), width_pix,
                        MolCanvas_reactant.zoom_scale);
                float y12_proj_new = MolCanvas_methods.AtomY_pix(y12_new1, MolCanvas_preferences.get().getValue("conv"), height_pix,
                        MolCanvas_reactant.zoom_scale);
                object.setAtom12X_pix(x12_proj_new);
                object.setAtom12Y_pix(y12_proj_new);
                // thickness
                float thick_new = MolCanvas_methods.Bond_pix(MolCanvas_preferences.get().getValue("bondsStrokeWidth"),
                        MolCanvas_reactant.zoom_scale, z12_new1);
                object.setAtomRadius1_pix(thick_new);
            }
        }
    }

    public void setMoleculeRenderer(int renderMolecule) {
        this.renderMolecule = renderMolecule;
        invalidate();
    }
}
