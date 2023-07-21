package cz.p;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
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


public class Xtb1SelectRef extends Xtb1 {



    private Button Quit;
    private Button Refg;
    private Button Refs;
    private Button Refss;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xtb1selectref);

        Refg = (Button) findViewById(R.id.Refg);
        Refg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Xtb1SelectRef.this, Xtb1SelectRefg.class);
                startActivity(intent);
            }
        });

        Refs = (Button) findViewById(R.id.Refs);
        Refs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Xtb1SelectRef.this, Xtb1SelectRefs.class);
                startActivity(intent);
            }
        });

        Refss = (Button) findViewById(R.id.Refss);
        Refss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Xtb1SelectRef.this, Xtb1SelectRefss.class);
                startActivity(intent);
            }
        });

        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Xtb1SelectRef.this, Xtb1.class);
                startActivity(intent);
            }
        });

    }





}
