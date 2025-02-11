package cz.p;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MolCanvas_reactant_colorPicker extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    SeekBar SeekBarAlpha;
    SeekBar SeekBarRed;
    SeekBar SeekBarGreen;
    SeekBar SeekBarBlue;
    TextView colorArea;
    Button ConfirmColor;
    public int Alpha;
    public int Red;
    public int Green;
    public int Blue;
    public int selCol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.molcanvascolorpicker);

        SeekBarAlpha = (SeekBar) findViewById(R.id.seekBarAlpha);
        SeekBarRed = (SeekBar) findViewById(R.id.seekBarRed);
        SeekBarGreen = (SeekBar) findViewById(R.id.seekBarGreen);
        SeekBarBlue = (SeekBar) findViewById(R.id.seekBarBlue);
        colorArea = (TextView) findViewById(R.id.colorArea);
        SeekBarAlpha.setOnSeekBarChangeListener(this);
        SeekBarRed.setOnSeekBarChangeListener(this);
        SeekBarGreen.setOnSeekBarChangeListener(this);
        SeekBarBlue.setOnSeekBarChangeListener(this);

        ConfirmColor = (Button) findViewById(R.id.confirmColor);
        ConfirmColor.setOnClickListener(confirmButton);

        // the case when the initially displayed white color is picked but the seekbar position not changed
        selCol = Color.WHITE;
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
        Alpha = SeekBarAlpha.getProgress();
        Red = SeekBarRed.getProgress();
        Green = SeekBarGreen.getProgress();
        Blue = SeekBarBlue.getProgress();
        colorArea.setBackgroundColor(Color.argb(Alpha, Red, Green, Blue));
        selCol = Color.argb(Alpha,Red,Green,Blue);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        // nothing
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        // nothing
    }
    private View.OnClickListener confirmButton;

    {
        confirmButton = new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub //
                MolCanvas_preferences.get().setIntValue(MolCanvas_preferences.get().getStringValue("changed_variable"),selCol);
                Intent intent = new Intent(MolCanvas_reactant_colorPicker.this, MolCanvas_reactant_settings.class);
                startActivity(intent);
            }
        };
    }
}
