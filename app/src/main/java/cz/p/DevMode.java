package cz.p;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DevMode extends MainActivity {

    Button start_shelltools;

    Button start_xbasic1;
    Button start_xbasic2;
    Button start_xbasic3;
    Button start_xbasic4;
    Button start_compg;
    Button start_compl;
    Button start_compc;
    Button start_comps;
    Button start_refg;
    Button start_refl;
    Button start_refc;
    Button start_refs;
    Button start_vdw;
    Button modify_mulliken;
    Button modify_esp;
    Button modify_solvation;
    Button modify_uniuni;
    Button modify_unibi;
    Button modify_bibi;
    Button modify_bitri;
    Button Quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.devmode);

        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        start_xbasic1 = (Button) findViewById(R.id.start_xbasic1);
        start_xbasic2 = (Button) findViewById(R.id.start_xbasic2);
        start_xbasic3 = (Button) findViewById(R.id.start_xbasic3);
        start_xbasic4 = (Button) findViewById(R.id.start_xbasic4);
        start_compg = (Button) findViewById(R.id.start_compg);
        start_compl = (Button) findViewById(R.id.start_compl);
        start_compc = (Button) findViewById(R.id.start_compc);
        start_comps = (Button) findViewById(R.id.start_comps);
        start_refg = (Button) findViewById(R.id.start_refg);
        start_refl = (Button) findViewById(R.id.start_refl);
        start_refc = (Button) findViewById(R.id.start_refc);
        start_refs = (Button) findViewById(R.id.start_refs);
        start_shelltools = (Button) findViewById(R.id.start_shelltools);

        modify_mulliken = (Button) findViewById(R.id.modify_mulliken);
        modify_esp = (Button) findViewById(R.id.modify_esp);
        modify_solvation = (Button) findViewById(R.id.modify_solvation);

        start_shelltools = (Button) findViewById(R.id.start_shelltools);
        start_shelltools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, ShellTools.class);
                startActivity(intent);
            }
        });



        start_xbasic1 = (Button) findViewById(R.id.start_xbasic1);
        start_xbasic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic1.class);
                startActivity(intent);
            }
        });

        start_xbasic2 = (Button) findViewById(R.id.start_xbasic2);
        start_xbasic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic2.class);
                startActivity(intent);
            }
        });

        start_xbasic3 = (Button) findViewById(R.id.start_xbasic3);
        start_xbasic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic3.class);
                startActivity(intent);
            }
        });

        start_xbasic4 = (Button) findViewById(R.id.start_xbasic4);
        start_xbasic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic4.class);
                startActivity(intent);
            }
        });

        start_refg = (Button) findViewById(R.id.start_refg);
        start_refg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Refg.class);
                startActivity(intent);
            }
        });

        start_refl = (Button) findViewById(R.id.start_refl);
        start_refl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Refl.class);
                startActivity(intent);
            }
        });

        start_refc = (Button) findViewById(R.id.start_refc);
        start_refc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Refc.class);
                startActivity(intent);
            }
        });

        start_refs = (Button) findViewById(R.id.start_refs);
        start_refs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Refs.class);
                startActivity(intent);
            }
        });

        start_compg = (Button) findViewById(R.id.start_compg);
        start_compg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Compg.class);
                startActivity(intent);
            }
        });

        start_compl = (Button) findViewById(R.id.start_compl);
        start_compl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Compl.class);
                startActivity(intent);
            }
        });

        start_compc = (Button) findViewById(R.id.start_compc);
        start_compc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Compc.class);
                startActivity(intent);
            }
        });

        start_comps = (Button) findViewById(R.id.start_comps);
        start_comps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Comps.class);
                startActivity(intent);
            }
        });

        start_vdw = (Button) findViewById(R.id.start_vdw);
        start_vdw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Vdw.class);
                startActivity(intent);
            }
        });

        modify_mulliken = (Button) findViewById(R.id.modify_mulliken);
        modify_mulliken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Mulliken.class);
                startActivity(intent);
            }
        });

        modify_esp = (Button) findViewById(R.id.modify_esp);
        modify_esp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Esp.class);
                startActivity(intent);
            }
        });

        modify_solvation = (Button) findViewById(R.id.modify_solvation);
        modify_solvation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Solvation.class);
                startActivity(intent);
            }
        });

        modify_uniuni = (Button) findViewById(R.id.modify_uniuni);
        modify_uniuni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, UniUni.class);
                startActivity(intent);
            }
        });

        modify_unibi = (Button) findViewById(R.id.modify_unibi);
        modify_unibi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, UniBi.class);
                startActivity(intent);
            }
        });

        modify_bibi = (Button) findViewById(R.id.modify_bibi);
        modify_bibi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, BiBi.class);
                startActivity(intent);
            }
        });

        modify_bitri = (Button) findViewById(R.id.modify_bitri);
        modify_bitri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, BiTri.class);
                startActivity(intent);
            }
        });

    }






    public void onStart()
    {
        super.onStart();

    }


    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(DevMode.this, MainActivity.class);
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
            char[] buffer = new char[4096];
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
