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
    private TextView AlertLabel;
    private EditText Alert;
    private TextView AtomBorderLabel;
    private EditText AtomBorder;
    private TextView AtomLabelLabel;
    private EditText AtomLabel;
    private TextView AtomLabelShiftXLabel;
    private EditText AtomLabelShiftX;
    private TextView AtomLabelShiftYLabel;
    private EditText AtomLabelShiftY;
    private TextView BondScaleLabel;
    private EditText BondScale;
    private TextView BondSizeLabel;
    private EditText BondSize;
    private TextView ColorAtomLabel;
    private EditText ColorAtom;
    private TextView ColorAtomBorderLabel;
    private EditText ColorAtomBorder;
    private TextView ColorAtomBorderSelectedLabel;
    private EditText ColorAtomBorderSelected;
    private TextView ColorCanvasLabel;
    private EditText ColorCanvas;
    private TextView ColorTestLabel;
    private EditText ColorTest;
    private TextView ColorTextLabel;
    private EditText ColorText;
    private TextView ElmntLabel;
    private EditText Elmnt;
    private TextView ElmntsLabel;
    private EditText Elmnts;
    private TextView ForegroundShiftBondsLabel;
    private EditText ForegroundShiftBonds;
    private TextView ForegroundShiftTextLabel;
    private EditText ForegroundShiftText;
    private TextView HNLabel;
    private EditText HN;
    private TextView HOLabel;
    private EditText HO;
    private TextView HFLabel;
    private EditText HF;
    private TextView HClLabel;
    private EditText HCl;
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
    private TextView TouchDistanceLimitLabel;
    private EditText TouchDistanceLimit;
    private TextView TranslLabel;
    private EditText Transl;
    private TextView ZoomLabel;
    private EditText Zoom;
    private TextView ZoomStepLabel;
    private EditText ZoomStep;
    private TextView HBondSizeLabel;
    private EditText HBondSize;
    private TextView coordLabel;
    private EditText coord;
    private TextView coordXLabel;
    private EditText coordX;
    private TextView coordXYZLabel;
    private EditText coordXYZ;
    private TextView coordGJFLabel;
    private EditText coordGJF;




    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas3d_preferences);

        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(saveClick);
        AlertLabel = (TextView) findViewById(R.id.AlertLabel);
        Alert = (EditText) findViewById(R.id.Alert);
        Alert.addTextChangedListener(new TextWatcher() {
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
                Alert.removeTextChangedListener(this);
                String text = Alert.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                Alert.getText().clear();
                Alert.append(colorized_numbers(text));
                // place the cursor at the original position
                Alert.setSelection(startChanged+countChanged);
                Alert.addTextChangedListener(this);
            }
        });
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
        AtomLabelShiftXLabel = (TextView) findViewById(R.id.AtomLabelShiftXLabel);
        AtomLabelShiftX = (EditText) findViewById(R.id.AtomLabelShiftX);
        AtomLabelShiftX.addTextChangedListener(new TextWatcher() {
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
                AtomLabelShiftX.removeTextChangedListener(this);
                String text = AtomLabelShiftX.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                AtomLabelShiftX.getText().clear();
                AtomLabelShiftX.append(colorized_numbers(text));
                // place the cursor at the original position
                AtomLabelShiftX.setSelection(startChanged+countChanged);
                AtomLabelShiftX.addTextChangedListener(this);
            }
        });
        AtomLabelShiftYLabel = (TextView) findViewById(R.id.AtomLabelShiftYLabel);
        AtomLabelShiftY = (EditText) findViewById(R.id.AtomLabelShiftY);
        AtomLabelShiftY.addTextChangedListener(new TextWatcher() {
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
                AtomLabelShiftY.removeTextChangedListener(this);
                String text = AtomLabelShiftY.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                AtomLabelShiftY.getText().clear();
                AtomLabelShiftY.append(colorized_numbers(text));
                // place the cursor at the original position
                AtomLabelShiftY.setSelection(startChanged+countChanged);
                AtomLabelShiftY.addTextChangedListener(this);
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
        ColorAtomBorderSelectedLabel = (TextView) findViewById(R.id.ColorAtomBorderSelectedLabel);
        ColorAtomBorderSelected = (EditText) findViewById(R.id.ColorAtomBorderSelected);
        ColorAtomBorderSelected.addTextChangedListener(new TextWatcher() {
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
                ColorAtomBorderSelected.removeTextChangedListener(this);
                String text = ColorAtomBorderSelected.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                ColorAtomBorderSelected.getText().clear();
                ColorAtomBorderSelected.append(colorized_numbers(text));
                // place the cursor at the original position
                ColorAtomBorderSelected.setSelection(startChanged+countChanged);
                ColorAtomBorderSelected.addTextChangedListener(this);
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
        HNLabel = (TextView) findViewById(R.id.HNLabel);
        HN = (EditText) findViewById(R.id.HN);
        HN.addTextChangedListener(new TextWatcher() {
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
                HN.removeTextChangedListener(this);
                String text = HN.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                HN.getText().clear();
                HN.append(colorized_numbers(text));
                // place the cursor at the original position
                HN.setSelection(startChanged+countChanged);
                HN.addTextChangedListener(this);
            }
        });
        HOLabel = (TextView) findViewById(R.id.HOLabel);
        HO = (EditText) findViewById(R.id.HO);
        HO.addTextChangedListener(new TextWatcher() {
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
                HO.removeTextChangedListener(this);
                String text = HO.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                HO.getText().clear();
                HO.append(colorized_numbers(text));
                // place the cursor at the original position
                HO.setSelection(startChanged+countChanged);
                HO.addTextChangedListener(this);
            }
        });
        HFLabel = (TextView) findViewById(R.id.HFLabel);
        HF = (EditText) findViewById(R.id.HF);
        HF.addTextChangedListener(new TextWatcher() {
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
                HF.removeTextChangedListener(this);
                String text = HF.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                HF.getText().clear();
                HF.append(colorized_numbers(text));
                // place the cursor at the original position
                HF.setSelection(startChanged+countChanged);
                HF.addTextChangedListener(this);
            }
        });
        HClLabel = (TextView) findViewById(R.id.HClLabel);
        HCl = (EditText) findViewById(R.id.HCl);
        HCl.addTextChangedListener(new TextWatcher() {
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
                HCl.removeTextChangedListener(this);
                String text = HCl.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                HCl.getText().clear();
                HCl.append(colorized_numbers(text));
                // place the cursor at the original position
                HCl.setSelection(startChanged+countChanged);
                HCl.addTextChangedListener(this);
            }
        });
        HBondSizeLabel = (TextView) findViewById(R.id.HBondSizeLabel);
        HBondSize = (EditText) findViewById(R.id.HBondSize);
        HBondSize.addTextChangedListener(new TextWatcher() {
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
                HBondSize.removeTextChangedListener(this);
                String text = HBondSize.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                HBondSize.getText().clear();
                HBondSize.append(colorized_numbers(text));
                // place the cursor at the original position
                HBondSize.setSelection(startChanged+countChanged);
                HBondSize.addTextChangedListener(this);
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
        TouchDistanceLimitLabel = (TextView) findViewById(R.id.TouchDistanceLimitLabel);
        TouchDistanceLimit = (EditText) findViewById(R.id.TouchDistanceLimit);
        TouchDistanceLimit.addTextChangedListener(new TextWatcher() {
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
                TouchDistanceLimit.removeTextChangedListener(this);
                String text = TouchDistanceLimit.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                TouchDistanceLimit.getText().clear();
                TouchDistanceLimit.append(colorized_numbers(text));
                // place the cursor at the original position
                TouchDistanceLimit.setSelection(startChanged+countChanged);
                TouchDistanceLimit.addTextChangedListener(this);
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
        coordLabel = (TextView) findViewById(R.id.coordLabel);
        coord = (EditText) findViewById(R.id.coord);
        coord.addTextChangedListener(new TextWatcher() {
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
                coord.removeTextChangedListener(this);
                String text = coord.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                coord.getText().clear();
                coord.append(colorized_numbers(text));
                // place the cursor at the original position
                coord.setSelection(startChanged+countChanged);
                coord.addTextChangedListener(this);
            }
        });
        coordXLabel = (TextView) findViewById(R.id.coordXLabel);
        coordX = (EditText) findViewById(R.id.coordX);
        coordX.addTextChangedListener(new TextWatcher() {
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
                coordX.removeTextChangedListener(this);
                String text = coordX.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                coordX.getText().clear();
                coordX.append(colorized_numbers(text));
                // place the cursor at the original position
                coordX.setSelection(startChanged+countChanged);
                coordX.addTextChangedListener(this);
            }
        });
        coordXYZLabel = (TextView) findViewById(R.id.coordXYZLabel);
        coordXYZ = (EditText) findViewById(R.id.coordXYZ);
        coordXYZ.addTextChangedListener(new TextWatcher() {
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
                coordXYZ.removeTextChangedListener(this);
                String text = coordXYZ.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                coordXYZ.getText().clear();
                coordXYZ.append(colorized_numbers(text));
                // place the cursor at the original position
                coordXYZ.setSelection(startChanged+countChanged);
                coordXYZ.addTextChangedListener(this);
            }
        });
        coordGJFLabel = (TextView) findViewById(R.id.coordGJFLabel);
        coordGJF = (EditText) findViewById(R.id.coordGJF);
        coordGJF.addTextChangedListener(new TextWatcher() {
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
                coordGJF.removeTextChangedListener(this);
                String text = coordGJF.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                coordGJF.getText().clear();
                coordGJF.append(colorized_numbers(text));
                // place the cursor at the original position
                coordGJF.setSelection(startChanged+countChanged);
                coordGJF.addTextChangedListener(this);
            }
        });

    }






    public void onStart()
    {
        super.onStart();
        AlertDisplay(exec("cat "+getFilesDir()+"/canvas3d/AlertDialogMaxLines.tmp"));
        AtomBorderDisplay(exec("cat "+getFilesDir()+"/canvas3d/AtomBorder.tmp"));
        AtomLabelDisplay(exec("cat "+getFilesDir()+"/canvas3d/AtomLabel.tmp"));
        AtomLabelShiftXDisplay(exec("cat "+getFilesDir()+"/canvas3d/AtomLabelShiftX.tmp"));
        AtomLabelShiftYDisplay(exec("cat "+getFilesDir()+"/canvas3d/AtomLabelShiftY.tmp"));
        BondScaleDisplay(exec("cat "+getFilesDir()+"/canvas3d/BondScale.tmp"));
        BondSizeDisplay(exec("cat "+getFilesDir()+"/canvas3d/BondSize.tmp"));
        ColorAtomDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorAtom.tmp"));
        ColorAtomBorderDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorAtomBorder.tmp"));
        ColorAtomBorderSelectedDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorAtomBorderSelected.tmp"));
        ColorCanvasDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorCanvas.tmp"));
        ColorTestDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorTest.tmp"));
        ColorTextDisplay(exec("cat "+getFilesDir()+"/canvas3d/ColorText.tmp"));
        ElmntDisplay(exec("cat "+getFilesDir()+"/canvas3d/Elmnt.tmp"));
        ElmntsDisplay(exec("cat "+getFilesDir()+"/canvas3d/Elmnts.dat"));
        ForegroundShiftBondsDisplay(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftBonds.tmp"));
        ForegroundShiftTextDisplay(exec("cat "+getFilesDir()+"/canvas3d/ForegroundShiftText.tmp"));
        HNDisplay(exec("cat "+getFilesDir()+"/canvas3d/HBondHN.tmp"));
        HODisplay(exec("cat "+getFilesDir()+"/canvas3d/HBondHO.tmp"));
        HFDisplay(exec("cat "+getFilesDir()+"/canvas3d/HBondHF.tmp"));
        HClDisplay(exec("cat "+getFilesDir()+"/canvas3d/HBondHCl.tmp"));
        HBondSizeDisplay(exec("cat "+getFilesDir()+"/canvas3d/HBondSize.tmp"));
        ModeDisplay(exec("cat "+getFilesDir()+"/canvas3d/Mode.tmp"));
        PerspScaleDisplay(exec("cat "+getFilesDir()+"/canvas3d/PerspScale.tmp"));
        RadDisplay(exec("cat "+getFilesDir()+"/canvas3d/Rad.tmp"));
        RadiusScaleDisplay(exec("cat "+getFilesDir()+"/canvas3d/RadiusScale.tmp"));
        RotAngleDisplay(exec("cat "+getFilesDir()+"/canvas3d/RotAngle.tmp"));
        TextSizeDisplay(exec("cat "+getFilesDir()+"/canvas3d/TextSize.tmp"));
        TouchDistanceLimitDisplay(exec("cat "+getFilesDir()+"/canvas3d/TouchDistanceLimit.tmp"));
        TranslDisplay(exec("cat "+getFilesDir()+"/canvas3d/Transl.tmp"));
        ZoomDisplay(exec("cat "+getFilesDir()+"/canvas3d/Zoom.tmp"));
        ZoomStepDisplay(exec("cat "+getFilesDir()+"/canvas3d/ZoomStep.tmp"));
        CoordDisplay(exec("cat "+getFilesDir()+"/canvas3d/Coordinates.tmp"));
        CoordXDisplay(exec("cat "+getFilesDir()+"/canvas3d/Coordinates.x.tmp"));
        CoordXYZDisplay(exec("cat "+getFilesDir()+"/canvas3d/Coordinates.xyz.tmp"));
        CoordGJFDisplay(exec("cat "+getFilesDir()+"/canvas3d/Coordinates.gjf.tmp"));
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
                String F26 = AtomLabelShiftX.getText().toString();
                String F27 = AtomLabelShiftY.getText().toString();
                String F28 = ColorAtomBorderSelected.getText().toString();
                String F29 = TouchDistanceLimit.getText().toString();
                String F30 = HN.getText().toString();
                String F31 = HO.getText().toString();
                String F32 = HF.getText().toString();
                String F33 = HCl.getText().toString();
                String F34 = HBondSize.getText().toString();
                String F35 = coord.getText().toString();
                String F36 = coordX.getText().toString();
                String F37 = coordXYZ.getText().toString();
                String F38 = coordGJF.getText().toString();
                String F39 = Alert.getText().toString();
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
                    FileOutputStream Fos26 = openFileOutput("AtomLabelShiftX.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow26 = new OutputStreamWriter(Fos26);
                    Fow26.write(F26);
                    Fow26.close();
                    FileOutputStream Fos27 = openFileOutput("AtomLabelShiftY.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow27 = new OutputStreamWriter(Fos27);
                    Fow27.write(F27);
                    Fow27.close();
                    FileOutputStream Fos28 = openFileOutput("ColorAtomBorderSelected.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow28 = new OutputStreamWriter(Fos28);
                    Fow28.write(F28);
                    Fow28.close();
                    FileOutputStream Fos29 = openFileOutput("TouchDistanceLimit.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow29 = new OutputStreamWriter(Fos29);
                    Fow29.write(F29);
                    Fow29.close();
                    FileOutputStream Fos30 = openFileOutput("HBondHN.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow30 = new OutputStreamWriter(Fos30);
                    Fow30.write(F30);
                    Fow30.close();
                    FileOutputStream Fos31 = openFileOutput("HBondHO.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow31 = new OutputStreamWriter(Fos31);
                    Fow31.write(F31);
                    Fow31.close();
                    FileOutputStream Fos32 = openFileOutput("HBondHF.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow32 = new OutputStreamWriter(Fos32);
                    Fow32.write(F32);
                    Fow32.close();
                    FileOutputStream Fos33 = openFileOutput("HBondHCl.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow33 = new OutputStreamWriter(Fos33);
                    Fow33.write(F33);
                    Fow33.close();
                    FileOutputStream Fos34 = openFileOutput("HBondSize.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow34 = new OutputStreamWriter(Fos34);
                    Fow34.write(F34);
                    Fow34.close();
                    FileOutputStream Fos35 = openFileOutput("Coordinates.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow35 = new OutputStreamWriter(Fos35);
                    Fow35.write(F35);
                    Fow35.close();
                    FileOutputStream Fos36 = openFileOutput("Coordinates.x.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow36 = new OutputStreamWriter(Fos36);
                    Fow36.write(F36);
                    Fow36.close();
                    FileOutputStream Fos37 = openFileOutput("Coordinates.xyz.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow37 = new OutputStreamWriter(Fos37);
                    Fow37.write(F37);
                    Fow37.close();
                    FileOutputStream Fos38 = openFileOutput("Coordinates.gjf.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow38 = new OutputStreamWriter(Fos38);
                    Fow38.write(F38);
                    Fow38.close();
                    FileOutputStream Fos39 = openFileOutput("AlertDialogMaxLines.tmp", MODE_PRIVATE);
                    OutputStreamWriter Fow39 = new OutputStreamWriter(Fos39);
                    Fow39.write(F39);
                    Fow39.close();
                } catch (Exception e) {
                }
                exec("mv "+getFilesDir()+"/AlertDialogMaxLines.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/AtomBorder.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/AtomLabel.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/BondScale.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/BondSize.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ColorAtomBorder.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ColorCanvas.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ColorTest.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
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
                exec("mv "+getFilesDir()+"/AtomLabelShiftX.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/AtomLabelShiftY.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/ColorAtomBorderSelected.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/TouchDistanceLimit.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/HBondHN.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/HBondHO.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/HBondHF.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/HBondHCl.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/HBondSize.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/Coordinates.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/Coordinates.x.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/Coordinates.xyz.tmp "+getFilesDir()+"/canvas3d/");
                exec("mv "+getFilesDir()+"/Coordinates.gjf.tmp "+getFilesDir()+"/canvas3d/");
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
    private void AtomLabelShiftXDisplay(final String str26) {
        Runnable proc26 = new Runnable() {
            public void run() {
                AtomLabelShiftX.setText(colorized_numbers(str26));
            }
        };
        handler.post(proc26);
    }
    private void AtomLabelShiftYDisplay(final String str27) {
        Runnable proc27 = new Runnable() {
            public void run() {
                AtomLabelShiftY.setText(colorized_numbers(str27));
            }
        };
        handler.post(proc27);
    }
    private void ColorAtomBorderSelectedDisplay(final String str28) {
        Runnable proc28 = new Runnable() {
            public void run() {
                ColorAtomBorderSelected.setText(colorized_numbers(str28));
            }
        };
        handler.post(proc28);
    }
    private void TouchDistanceLimitDisplay(final String str29) {
        Runnable proc29 = new Runnable() {
            public void run() {
                TouchDistanceLimit.setText(colorized_numbers(str29));
            }
        };
        handler.post(proc29);
    }
    private void HNDisplay(final String str30) {
        Runnable proc30 = new Runnable() {
            public void run() {
                HN.setText(colorized_numbers(str30));
            }
        };
        handler.post(proc30);
    }
    private void HODisplay(final String str31) {
        Runnable proc31 = new Runnable() {
            public void run() {
                HO.setText(colorized_numbers(str31));
            }
        };
        handler.post(proc31);
    }
    private void HFDisplay(final String str32) {
        Runnable proc32 = new Runnable() {
            public void run() {
                HF.setText(colorized_numbers(str32));
            }
        };
        handler.post(proc32);
    }
    private void HClDisplay(final String str33) {
        Runnable proc33 = new Runnable() {
            public void run() {
                HCl.setText(colorized_numbers(str33));
            }
        };
        handler.post(proc33);
    }
    private void HBondSizeDisplay(final String str34) {
        Runnable proc34 = new Runnable() {
            public void run() {
                HBondSize.setText(colorized_numbers(str34));
            }
        };
        handler.post(proc34);
    }
    private void CoordDisplay(final String str35) {
        Runnable proc35 = new Runnable() {
            public void run() {
                coord.setText(colorized_numbers(str35));
            }
        };
        handler.post(proc35);
    }
    private void CoordXDisplay(final String str36) {
        Runnable proc36 = new Runnable() {
            public void run() {
                coordX.setText(colorized_numbers(str36));
            }
        };
        handler.post(proc36);
    }
    private void CoordXYZDisplay(final String str37) {
        Runnable proc37 = new Runnable() {
            public void run() {
                coordXYZ.setText(colorized_numbers(str37));
            }
        };
        handler.post(proc37);
    }
    private void CoordGJFDisplay(final String str38) {
        Runnable proc38 = new Runnable() {
            public void run() {
                coordGJF.setText(colorized_numbers(str38));
            }
        };
        handler.post(proc38);
    }
    private void AlertDisplay(final String str39) {
        Runnable proc39 = new Runnable() {
            public void run() {
                Alert.setText(colorized_numbers(str39));
            }
        };
        handler.post(proc39);
    }
}
