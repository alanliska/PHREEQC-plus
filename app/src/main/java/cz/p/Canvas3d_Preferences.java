package cz.p;

import static cz.p.Spannables.colorized_numbers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import cz.p.Canvas3d_main;

public class Canvas3d_Preferences extends Canvas3d_main {



    private Button Quit;
    private Button saveButton;
    private TextView AtomBorderLabel;
    private EditText AtomBorder;
    private TextView AtomLabelLabel;
    private EditText AtomLabel;
    private TextView BondScaleLabel;
    private EditText BondScale;
    private TextView BondSizeLabel;
    private EditText BondSize;
    private TextView ColorAtomLabel;
    private EditText ColorAtom;
    private TextView ColorAtomBorderLabel;
    private EditText ColorAtomBorder;
    private TextView ColorCanvasLabel;
    private EditText ColorCanvas;
    private TextView ColorTestLabel;
    private EditText ColorTest;
    private TextView ColorTextLabel;
    private EditText ColorText;
    private TextView CursorPosLabel;
    private EditText CursorPos;
    private TextView ElmntLabel;
    private EditText Elmnt;
    private TextView ElmntsLabel;
    private EditText Elmnts;
    private TextView ForegroundShiftBondsLabel;
    private EditText ForegroundShiftBonds;
    private TextView ForegroundShiftTextLabel;
    private EditText ForegroundShiftText;
    private TextView ModeLabel;
    private EditText Mode;
    private TextView PerspScaleLabel;
    private EditText PerspScale;
    private TextView RadLabel;
    private EditText Rad;
    private TextView RadiusScaleLabel;
    private EditText RadiusScale;
    private TextView RotAngleLabel;
    private EditText RotAngle;
    private TextView TextSizeLabel;
    private EditText TextSize;
    private TextView TranslLabel;
    private EditText Transl;
    private TextView ZoomLabel;
    private EditText Zoom;
    private TextView ZoomStepLabel;
    private EditText ZoomStep;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas3d_preferences);

        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(saveClick);
        AtomBorderLabel = (TextView) findViewById(R.id.AtomBorderLabel);
        AtomBorder = (EditText) findViewById(R.id.AtomBorder);
        AtomBorder.addTextChangedListener(new TextWatcher() {
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
                AtomBorder.removeTextChangedListener(this);
                String text = AtomBorder.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                AtomBorder.getText().clear();
                AtomBorder.append(colorized_numbers(text));
                // place the cursor at the original position
                AtomBorder.setSelection(startChanged+countChanged);
                AtomBorder.addTextChangedListener(this);
            }
        });
        AtomLabelLabel = (TextView) findViewById(R.id.AtomLabelLabel);
        AtomLabel = (EditText) findViewById(R.id.AtomLabel);
        AtomLabel.addTextChangedListener(new TextWatcher() {
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
                AtomLabel.removeTextChangedListener(this);
                String text = AtomLabel.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                AtomLabel.getText().clear();
                AtomLabel.append(colorized_numbers(text));
                // place the cursor at the original position
                AtomLabel.setSelection(startChanged+countChanged);
                AtomLabel.addTextChangedListener(this);
            }
        });
        BondScaleLabel = (TextView) findViewById(R.id.BondScaleLabel);
        BondScale = (EditText) findViewById(R.id.BondScale);
        BondScale.addTextChangedListener(new TextWatcher() {
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
                BondScale.removeTextChangedListener(this);
                String text = BondScale.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                BondScale.getText().clear();
                BondScale.append(colorized_numbers(text));
                // place the cursor at the original position
                BondScale.setSelection(startChanged+countChanged);
                BondScale.addTextChangedListener(this);
            }
        });
        BondSizeLabel = (TextView) findViewById(R.id.BondSizeLabel);
        BondSize = (EditText) findViewById(R.id.BondSize);
        BondSize.addTextChangedListener(new TextWatcher() {
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
                BondSize.removeTextChangedListener(this);
                String text = BondSize.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                BondSize.getText().clear();
                BondSize.append(colorized_numbers(text));
                // place the cursor at the original position
                BondSize.setSelection(startChanged+countChanged);
                BondSize.addTextChangedListener(this);
            }
        });
        ColorAtomLabel = (TextView) findViewById(R.id.ColorAtomLabel);
        ColorAtom = (EditText) findViewById(R.id.ColorAtom);
        ColorAtom.addTextChangedListener(new TextWatcher() {
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
                ColorAtom.removeTextChangedListener(this);
                String text = ColorAtom.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ColorAtom.getText().clear();
                ColorAtom.append(colorized_numbers(text));
                // place the cursor at the original position
                ColorAtom.setSelection(startChanged+countChanged);
                ColorAtom.addTextChangedListener(this);
            }
        });
        ColorAtomBorderLabel = (TextView) findViewById(R.id.ColorAtomBorderLabel);
        ColorAtomBorder = (EditText) findViewById(R.id.ColorAtomBorder);
        ColorAtomBorder.addTextChangedListener(new TextWatcher() {
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
                ColorAtomBorder.removeTextChangedListener(this);
                String text = ColorAtomBorder.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ColorAtomBorder.getText().clear();
                ColorAtomBorder.append(colorized_numbers(text));
                // place the cursor at the original position
                ColorAtomBorder.setSelection(startChanged+countChanged);
                ColorAtomBorder.addTextChangedListener(this);
            }
        });
        ColorCanvasLabel = (TextView) findViewById(R.id.ColorCanvasLabel);
        ColorCanvas = (EditText) findViewById(R.id.ColorCanvas);
        ColorCanvas.addTextChangedListener(new TextWatcher() {
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
                ColorCanvas.removeTextChangedListener(this);
                String text = ColorCanvas.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ColorCanvas.getText().clear();
                ColorCanvas.append(colorized_numbers(text));
                // place the cursor at the original position
                ColorCanvas.setSelection(startChanged+countChanged);
                ColorCanvas.addTextChangedListener(this);
            }
        });
        ColorTestLabel = (TextView) findViewById(R.id.ColorTestLabel);
        ColorTest = (EditText) findViewById(R.id.ColorTest);
        ColorTest.addTextChangedListener(new TextWatcher() {
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
                ColorTest.removeTextChangedListener(this);
                String text = ColorTest.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ColorTest.getText().clear();
                ColorTest.append(colorized_numbers(text));
                // place the cursor at the original position
                ColorTest.setSelection(startChanged+countChanged);
                ColorTest.addTextChangedListener(this);
            }
        });
        ColorTextLabel = (TextView) findViewById(R.id.ColorTextLabel);
        ColorText = (EditText) findViewById(R.id.ColorText);
        ColorText.addTextChangedListener(new TextWatcher() {
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
                ColorText.removeTextChangedListener(this);
                String text = ColorText.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ColorText.getText().clear();
                ColorText.append(colorized_numbers(text));
                // place the cursor at the original position
                ColorText.setSelection(startChanged+countChanged);
                ColorText.addTextChangedListener(this);
            }
        });
        CursorPosLabel = (TextView) findViewById(R.id.CursorPosLabel);
        CursorPos = (EditText) findViewById(R.id.CursorPos);
        CursorPos.addTextChangedListener(new TextWatcher() {
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
                CursorPos.removeTextChangedListener(this);
                String text = CursorPos.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                CursorPos.getText().clear();
                CursorPos.append(colorized_numbers(text));
                // place the cursor at the original position
                CursorPos.setSelection(startChanged+countChanged);
                CursorPos.addTextChangedListener(this);
            }
        });
        ElmntLabel = (TextView) findViewById(R.id.ElmntLabel);
        Elmnt = (EditText) findViewById(R.id.Elmnt);
        Elmnt.addTextChangedListener(new TextWatcher() {
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
                Elmnt.removeTextChangedListener(this);
                String text = Elmnt.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Elmnt.getText().clear();
                Elmnt.append(colorized_numbers(text));
                // place the cursor at the original position
                Elmnt.setSelection(startChanged+countChanged);
                Elmnt.addTextChangedListener(this);
            }
        });
        ElmntsLabel = (TextView) findViewById(R.id.ElmntsLabel);
        Elmnts = (EditText) findViewById(R.id.Elmnts);
        Elmnts.addTextChangedListener(new TextWatcher() {
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
                Elmnts.removeTextChangedListener(this);
                String text = Elmnts.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Elmnts.getText().clear();
                Elmnts.append(colorized_numbers(text));
                // place the cursor at the original position
                Elmnts.setSelection(startChanged+countChanged);
                Elmnts.addTextChangedListener(this);
            }
        });
        ForegroundShiftBondsLabel = (TextView) findViewById(R.id.ForegroundShiftBondsLabel);
        ForegroundShiftBonds = (EditText) findViewById(R.id.ForegroundShiftBonds);
        ForegroundShiftBonds.addTextChangedListener(new TextWatcher() {
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
                ForegroundShiftBonds.removeTextChangedListener(this);
                String text = ForegroundShiftBonds.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ForegroundShiftBonds.getText().clear();
                ForegroundShiftBonds.append(colorized_numbers(text));
                // place the cursor at the original position
                ForegroundShiftBonds.setSelection(startChanged+countChanged);
                ForegroundShiftBonds.addTextChangedListener(this);
            }
        });
        ForegroundShiftTextLabel = (TextView) findViewById(R.id.ForegroundShiftTextLabel);
        ForegroundShiftText = (EditText) findViewById(R.id.ForegroundShiftText);
        ForegroundShiftText.addTextChangedListener(new TextWatcher() {
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
                ForegroundShiftText.removeTextChangedListener(this);
                String text = ForegroundShiftText.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ForegroundShiftText.getText().clear();
                ForegroundShiftText.append(colorized_numbers(text));
                // place the cursor at the original position
                ForegroundShiftText.setSelection(startChanged+countChanged);
                ForegroundShiftText.addTextChangedListener(this);
            }
        });
        ModeLabel = (TextView) findViewById(R.id.ModeLabel);
        Mode = (EditText) findViewById(R.id.Mode);
        Mode.addTextChangedListener(new TextWatcher() {
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
                Mode.removeTextChangedListener(this);
                String text = Mode.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Mode.getText().clear();
                Mode.append(colorized_numbers(text));
                // place the cursor at the original position
                Mode.setSelection(startChanged+countChanged);
                Mode.addTextChangedListener(this);
            }
        });
        PerspScaleLabel = (TextView) findViewById(R.id.PerspScaleLabel);
        PerspScale = (EditText) findViewById(R.id.PerspScale);
        PerspScale.addTextChangedListener(new TextWatcher() {
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
                PerspScale.removeTextChangedListener(this);
                String text = PerspScale.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                PerspScale.getText().clear();
                PerspScale.append(colorized_numbers(text));
                // place the cursor at the original position
                PerspScale.setSelection(startChanged+countChanged);
                PerspScale.addTextChangedListener(this);
            }
        });
        RadLabel = (TextView) findViewById(R.id.RadLabel);
        Rad = (EditText) findViewById(R.id.Rad);
        Rad.addTextChangedListener(new TextWatcher() {
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
                Rad.removeTextChangedListener(this);
                String text = Rad.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Rad.getText().clear();
                Rad.append(colorized_numbers(text));
                // place the cursor at the original position
                Rad.setSelection(startChanged+countChanged);
                Rad.addTextChangedListener(this);
            }
        });
        RadiusScaleLabel = (TextView) findViewById(R.id.RadiusScaleLabel);
        RadiusScale = (EditText) findViewById(R.id.RadiusScale);
        RadiusScale.addTextChangedListener(new TextWatcher() {
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
                RadiusScale.removeTextChangedListener(this);
                String text = RadiusScale.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                RadiusScale.getText().clear();
                RadiusScale.append(colorized_numbers(text));
                // place the cursor at the original position
                RadiusScale.setSelection(startChanged+countChanged);
                RadiusScale.addTextChangedListener(this);
            }
        });
        RotAngleLabel = (TextView) findViewById(R.id.RotAngleLabel);
        RotAngle = (EditText) findViewById(R.id.RotAngle);
        RotAngle.addTextChangedListener(new TextWatcher() {
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
                RotAngle.removeTextChangedListener(this);
                String text = RotAngle.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                RotAngle.getText().clear();
                RotAngle.append(colorized_numbers(text));
                // place the cursor at the original position
                RotAngle.setSelection(startChanged+countChanged);
                RotAngle.addTextChangedListener(this);
            }
        });
        TextSizeLabel = (TextView) findViewById(R.id.TextSizeLabel);
        TextSize = (EditText) findViewById(R.id.TextSize);
        TextSize.addTextChangedListener(new TextWatcher() {
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
                TextSize.removeTextChangedListener(this);
                String text = TextSize.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                TextSize.getText().clear();
                TextSize.append(colorized_numbers(text));
                // place the cursor at the original position
                TextSize.setSelection(startChanged+countChanged);
                TextSize.addTextChangedListener(this);
            }
        });
        TranslLabel = (TextView) findViewById(R.id.TranslLabel);
        Transl = (EditText) findViewById(R.id.Transl);
        Transl.addTextChangedListener(new TextWatcher() {
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
                Transl.removeTextChangedListener(this);
                String text = Transl.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Transl.getText().clear();
                Transl.append(colorized_numbers(text));
                // place the cursor at the original position
                Transl.setSelection(startChanged+countChanged);
                Transl.addTextChangedListener(this);
            }
        });
        ZoomLabel = (TextView) findViewById(R.id.ZoomLabel);
        Zoom = (EditText) findViewById(R.id.Zoom);
        Zoom.addTextChangedListener(new TextWatcher() {
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
                Zoom.removeTextChangedListener(this);
                String text = Zoom.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Zoom.getText().clear();
                Zoom.append(colorized_numbers(text));
                // place the cursor at the original position
                Zoom.setSelection(startChanged+countChanged);
                Zoom.addTextChangedListener(this);
            }
        });
        ZoomStepLabel = (TextView) findViewById(R.id.ZoomStepLabel);
        ZoomStep = (EditText) findViewById(R.id.ZoomStep);
        ZoomStep.addTextChangedListener(new TextWatcher() {
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
                ZoomStep.removeTextChangedListener(this);
                String text = ZoomStep.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ZoomStep.getText().clear();
                ZoomStep.append(colorized_numbers(text));
                // place the cursor at the original position
                ZoomStep.setSelection(startChanged+countChanged);
                ZoomStep.addTextChangedListener(this);
            }
        });

    }






    public void onStart()
    {
        super.onStart();
        AtomBorderDisplay(exec("cat "+getFilesDir()+"/canvas3d/AtomBorder.tmp"));
        AtomLabelDisplay(exec("cat "+getFilesDir()+"/canvas3d/AtomLabel.tmp"));
        BondScaleDisplay(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
        BondSizeDisplay(exec("cat "+getFilesDir()+"/canvas3d/BondSize.tmp"));
        ColorAtomDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorAtom.tmp"));
        ColorAtomBorderDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorAtomBorder.tmp"));
        ColorCanvasDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorCanvas.tmp"));
        ColorTestDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorTest.tmp"));
        ColorTextDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorText.tmp"));
        CursorPosDisplay(exec("cat "+getFilesDir()+"/canvas3d/CursorPos.tmp"));
        ElmntDisplay(exec("cat "+getFilesDir()+"/canvas3d/Elmnt.tmp"));
        ElmntsDisplay(exec("cat "+getFilesDir()+"/canvas3d/Elmnts.dat"));
        ForegroundShiftBondsDisplay(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
        ForegroundShiftTextDisplay(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
        ModeDisplay(exec("cat "+getFilesDir()+"/canvas3d/Mode.tmp"));
        PerspScaleDisplay(exec("cat "+getFilesDir()+"/canvas3d/PerspScale.tmp"));
        RadDisplay(exec("cat "+getFilesDir()+"/canvas3d/Rad.tmp"));
        RadiusScaleDisplay(exec("cat "+getFilesDir()+"/canvas3d/RadiusScale.tmp"));
        RotAngleDisplay(exec("cat "+getFilesDir()+"/canvas3d/RotAngle.tmp"));
        TextSizeDisplay(exec("cat "+getFilesDir()+"/canvas3d/TextSize.tmp"));
        TranslDisplay(exec("cat "+getFilesDir()+"/canvas3d/Transl.tmp"));
        ZoomDisplay(exec("cat "+getFilesDir()+"/canvas3d/Zoom.tmp"));
        ZoomStepDisplay(exec("cat "+getFilesDir()+"/canvas3d/ZoomStep.tmp"));
    }

    private View.OnClickListener saveClick; {
        saveClick = new View.OnClickListener() {
            public void onClick(View v) {
                String F1 = AtomBorder.getText().toString();
                String F2 = AtomLabel.getText().toString();
                String F3 = BondScale.getText().toString();
                String F4 = BondSize.getText().toString();
                String F6 = ColorAtom.getText().toString();
                String F7 = ColorAtomBorder.getText().toString();
                String F8 = ColorTest.getText().toString();
                String F9 = ColorText.getText().toString();
                String F10 = CursorPos.getText().toString();
                String F11 = Elmnt.getText().toString();
                String F12 = Elmnts.getText().toString();
                String F13 = Mode.getText().toString();
                String F14 = PerspScale.getText().toString();
                String F15 = Rad.getText().toString();
                String F16 = RadiusScale.getText().toString();
                String F17 = RotAngle.getText().toString();
                String F19 = TextSize.getText().toString();
                String F20 = Transl.getText().toString();
                String F21 = Zoom.getText().toString();
                String F22 = ZoomStep.getText().toString();
                String F23 = ColorCanvas.getText().toString();
                String F24 = ForegroundShiftBonds.getText().toString();
                String F25 = ForegroundShiftText.getText().toString();
                // TODO Auto-generated method stub //
                try {
                    FileOutputStream Fos1 = openFileOutput("AtomBorder.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow1 = new OutputStreamWriter(Fos1);
                    Fow1.write(F1);
                    Fow1.close();
                    FileOutputStream Fos2 = openFileOutput("AtomLabel.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow2 = new OutputStreamWriter(Fos2);
                    Fow2.write(F2);
                    Fow2.close();
                    FileOutputStream Fos3 = openFileOutput("BondScale.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow3 = new OutputStreamWriter(Fos3);
                    Fow3.write(F3);
                    Fow3.close();
                    FileOutputStream Fos4 = openFileOutput("BondSize.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow4 = new OutputStreamWriter(Fos4);
                    Fow4.write(F4);
                    Fow4.close();
                    FileOutputStream Fos6 = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow6 = new OutputStreamWriter(Fos6);
                    Fow6.write(F6);
                    Fow6.close();
                    FileOutputStream Fos7 = openFileOutput("ColorAtomBorder.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow7 = new OutputStreamWriter(Fos7);
                    Fow7.write(F7);
                    Fow7.close();
                    FileOutputStream Fos8 = openFileOutput("ColorTest.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow8 = new OutputStreamWriter(Fos8);
                    Fow8.write(F8);
                    Fow8.close();
                    FileOutputStream Fos9 = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow9 = new OutputStreamWriter(Fos9);
                    Fow9.write(F9);
                    Fow9.close();
                    FileOutputStream Fos10 = openFileOutput("CursorPos.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow10 = new OutputStreamWriter(Fos10);
                    Fow10.write(F10);
                    Fow10.close();
                    FileOutputStream Fos11 = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow11 = new OutputStreamWriter(Fos11);
                    Fow11.write(F11);
                    Fow11.close();
                    FileOutputStream Fos12 = openFileOutput("Elmnts.dat", MODE_PRIVATE);
                    OutputStreamWriter Fow12 = new OutputStreamWriter(Fos12);
                    Fow12.write(F12);
                    Fow12.close();
                    FileOutputStream Fos13 = openFileOutput("Mode.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow13 = new OutputStreamWriter(Fos13);
                    Fow13.write(F13);
                    Fow13.close();
                    FileOutputStream Fos14 = openFileOutput("PerspScale.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow14 = new OutputStreamWriter(Fos14);
                    Fow14.write(F14);
                    Fow14.close();
                    FileOutputStream Fos15 = openFileOutput("Rad.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow15 = new OutputStreamWriter(Fos15);
                    Fow15.write(F15);
                    Fow15.close();
                    FileOutputStream Fos16 = openFileOutput("RadiusScale.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow16 = new OutputStreamWriter(Fos16);
                    Fow16.write(F16);
                    Fow16.close();
                    FileOutputStream Fos17 = openFileOutput("RotAngle.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow17 = new OutputStreamWriter(Fos17);
                    Fow17.write(F17);
                    Fow17.close();
                    FileOutputStream Fos19 = openFileOutput("TextSize.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow19 = new OutputStreamWriter(Fos19);
                    Fow19.write(F19);
                    Fow19.close();
                    FileOutputStream Fos20 = openFileOutput("Transl.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow20 = new OutputStreamWriter(Fos20);
                    Fow20.write(F20);
                    Fow20.close();
                    FileOutputStream Fos21 = openFileOutput("Zoom.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow21 = new OutputStreamWriter(Fos21);
                    Fow21.write(F21);
                    Fow21.close();
                    FileOutputStream Fos22 = openFileOutput("ZoomStep.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow22 = new OutputStreamWriter(Fos22);
                    Fow22.write(F22);
                    Fow22.close();
                    FileOutputStream Fos23 = openFileOutput("ColorCanvas.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow23 = new OutputStreamWriter(Fos23);
                    Fow23.write(F23);
                    Fow23.close();
                    FileOutputStream Fos24 = openFileOutput("ForegroundShiftBonds.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow24 = new OutputStreamWriter(Fos24);
                    Fow24.write(F24);
                    Fow24.close();
                    FileOutputStream Fos25 = openFileOutput("ForegroundShiftText.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow25 = new OutputStreamWriter(Fos25);
                    Fow25.write(F25);
                    Fow25.close();
                } catch (Exception e) {
                }
                exec("mv "+getFilesDir()+"/AtomBorder.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/AtomLabel.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/BondScale.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/BondSize.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ColorAtomBorder.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ColorCanvas.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ColorTest.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/CursorPos.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/Elmnts.dat "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/Mode.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/PerspScale.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/RadiusScale.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/RotAngle.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/TextSize.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/Transl.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/Zoom.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ZoomStep.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ForegroundShiftBonds.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ForegroundShiftText.tmp "+getFilesDir()+"/canvas3d/");
            }
        };
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(Canvas3d_Preferences.this, Canvas3d_main.class);
                startActivity(intent);
            }
        };
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


    private void AtomBorderDisplay(final String str1) {
        Runnable proc1 = new Runnable() {
            public void run() {
                AtomBorder.setText(colorized_numbers(str1));
            }
        };
        handler.post(proc1);
    }
    private void AtomLabelDisplay(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                AtomLabel.setText(colorized_numbers(str2));
            }
        };
        handler.post(proc2);
    }
    private void BondScaleDisplay(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                BondScale.setText(colorized_numbers(str3));
            }
        };
        handler.post(proc3);
    }
    private void BondSizeDisplay(final String str4) {
        Runnable proc4 = new Runnable() {
            public void run() {
                BondSize.setText(colorized_numbers(str4));
            }
        };
        handler.post(proc4);
    }
    private void ColorAtomDisplay(final String str6) {
        Runnable proc6 = new Runnable() {
            public void run() {
                ColorAtom.setText(colorized_numbers(str6));
            }
        };
        handler.post(proc6);
    }
    private void ColorAtomBorderDisplay(final String str7) {
        Runnable proc7 = new Runnable() {
            public void run() {
                ColorAtomBorder.setText(colorized_numbers(str7));
            }
        };
        handler.post(proc7);
    }
    private void ColorTestDisplay(final String str8) {
        Runnable proc8 = new Runnable() {
            public void run() {
                ColorTest.setText(colorized_numbers(str8));
            }
        };
        handler.post(proc8);
    }
    private void ColorTextDisplay(final String str9) {
        Runnable proc9 = new Runnable() {
            public void run() {
                ColorText.setText(colorized_numbers(str9));
            }
        };
        handler.post(proc9);
    }
    private void CursorPosDisplay(final String str10) {
        Runnable proc10 = new Runnable() {
            public void run() {
                CursorPos.setText(colorized_numbers(str10));
            }
        };
        handler.post(proc10);
    }
    private void ElmntDisplay(final String str11) {
        Runnable proc11 = new Runnable() {
            public void run() {
                Elmnt.setText(colorized_numbers(str11));
            }
        };
        handler.post(proc11);
    }
    private void ElmntsDisplay(final String str12) {
        Runnable proc12 = new Runnable() {
            public void run() {
                Elmnts.setText(colorized_numbers(str12));
            }
        };
        handler.post(proc12);
    }
    private void ModeDisplay(final String str13) {
        Runnable proc13 = new Runnable() {
            public void run() {
                Mode.setText(colorized_numbers(str13));
            }
        };
        handler.post(proc13);
    }
    private void PerspScaleDisplay(final String str14) {
        Runnable proc14 = new Runnable() {
            public void run() {
                PerspScale.setText(colorized_numbers(str14));
            }
        };
        handler.post(proc14);
    }
    private void RadDisplay(final String str15) {
        Runnable proc15 = new Runnable() {
            public void run() {
                Rad.setText(colorized_numbers(str15));
            }
        };
        handler.post(proc15);
    }
    private void RadiusScaleDisplay(final String str16) {
        Runnable proc16 = new Runnable() {
            public void run() {
                RadiusScale.setText(colorized_numbers(str16));
            }
        };
        handler.post(proc16);
    }
    private void RotAngleDisplay(final String str17) {
        Runnable proc17 = new Runnable() {
            public void run() {
                RotAngle.setText(colorized_numbers(str17));
            }
        };
        handler.post(proc17);
    }
    private void TextSizeDisplay(final String str19) {
        Runnable proc19 = new Runnable() {
            public void run() {
                TextSize.setText(colorized_numbers(str19));
            }
        };
        handler.post(proc19);
    }
    private void TranslDisplay(final String str20) {
        Runnable proc20 = new Runnable() {
            public void run() {
                Transl.setText(colorized_numbers(str20));
            }
        };
        handler.post(proc20);
    }
    private void ZoomDisplay(final String str21) {
        Runnable proc21 = new Runnable() {
            public void run() {
                Zoom.setText(colorized_numbers(str21));
            }
        };
        handler.post(proc21);
    }
    private void ZoomStepDisplay(final String str22) {
        Runnable proc22 = new Runnable() {
            public void run() {
                ZoomStep.setText(colorized_numbers(str22));
            }
        };
        handler.post(proc22);
    }
    private void ColorCanvasDisplay(final String str23) {
        Runnable proc23 = new Runnable() {
            public void run() {
                ColorCanvas.setText(colorized_numbers(str23));
            }
        };
        handler.post(proc23);
    }
    private void ForegroundShiftBondsDisplay(final String str24) {
        Runnable proc24 = new Runnable() {
            public void run() {
                ForegroundShiftBonds.setText(colorized_numbers(str24));
            }
        };
        handler.post(proc24);
    }
    private void ForegroundShiftTextDisplay(final String str25) {
        Runnable proc25 = new Runnable() {
            public void run() {
                ForegroundShiftText.setText(colorized_numbers(str25));
            }
        };
        handler.post(proc25);
    }
}
