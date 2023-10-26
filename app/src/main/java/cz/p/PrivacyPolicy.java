package cz.p;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class PrivacyPolicy extends DevMode {



    private TextView hypertext;
    private TextView description;
    private Button Quit;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacypolicy);

        hypertext = (TextView) findViewById(R.id.hypertext);
        description = (TextView) findViewById(R.id.description);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);

        description.setText("The Android PHREEQC plus app does not collect, transmit, or distribute any personally identifiable information of the app users.\n");

        hypertext.setMovementMethod(LinkMovementMethod.getInstance());
        hypertext.setLinkTextColor(Color.BLUE);
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(PrivacyPolicy.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }

}
