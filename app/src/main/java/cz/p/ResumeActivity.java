package cz.p;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class ResumeActivity extends MainActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumeactivity);

    }

    public void onStart()
    {
        super.onStart();
        cleanOpenbabel();
//        goBack();
    }

//    private View.OnClickListener moveClick; {
//
//        moveClick = new View.OnClickListener() {
//            public void onClick(View v) {
                public void cleanOpenbabel() {
                // TODO Auto-generated method stub //


                progressDialog = new ProgressDialog(ResumeActivity.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Cleaning files.");
//                progressDialog.setCancelable(false);
//                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
                progressDialog.show();
                new Thread() {
                    public void run() {

                moveDampFactor();
                moveFormula();
                moveIupac();
                moveKinetics();
                moveSmiles();
                moveXyz();
                moveGas();
                moveGasOpt();
                moveGasOptResults();
                moveGasThermo();
                moveGasThermoResults();
                moveSolv();
                moveSolvOpt();
                moveSolvOptResults();
                moveSolvThermo();
                moveSolvThermoResults();
                moveTautomers();
                moveCryst();
                moveLiq();
                cleanDummyDatasets();
                moveXtbComm();
                moveXtbSolv();
//                goBack();

                                        onFinish();
                    }
                    public void onFinish(){
                        progressDialog.dismiss();
                    }
                }.start();


            }
//        };
//    }

    public void moveXtbComm()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/xtb_comm").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()){
                // do nothing
            } else {

                try {
                    String fileName = file.getName();
                    exec("mv "+getFilesDir()+"/openbabel/xtb_comm/"+fileName+" "+getFilesDir()+"/output/xtb_comm");
//            Toast.makeText(getApplicationContext(), "Moving file: "+getFilesDir()+"/openbabel/formula/"+fileName, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }

            }
        }
    }

    public void moveXtbSolv()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/xtb_solv").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()){
                // do nothing
            } else {

                try {
                    String fileName = file.getName();
                    exec("mv "+getFilesDir()+"/openbabel/xtb_solv/"+fileName+" "+getFilesDir()+"/output/xtb_solv");
//            Toast.makeText(getApplicationContext(), "Moving file: "+getFilesDir()+"/openbabel/formula/"+fileName, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }

            }
        }
    }

    public void moveFormula()
    {
    File[] inputfiles = new File(getFilesDir()+"/openbabel/formula").listFiles();
        for (File file : inputfiles) {
        if (!file.isFile()){
            // do nothing
        } else {

        try {
            String fileName = file.getName();
            exec("mv "+getFilesDir()+"/openbabel/formula/"+fileName+" "+getFilesDir()+"/output/formula");
//            Toast.makeText(getApplicationContext(), "Moving file: "+getFilesDir()+"/openbabel/formula/"+fileName, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
        }

        }
    }
    }

    public void moveDampFactor()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/damping_factor").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/damping_factor/"+fileName+" "+getFilesDir()+"/output/damping_factor");
            } catch (Exception e) {
            }

        }
    }
    }

    public void moveIupac()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/iupac").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/iupac/"+fileName+" "+getFilesDir()+"/output/iupac");
            } catch (Exception e) {
            }
            }

        }
    }

    public void moveKinetics()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/kinetics").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/kinetics/"+fileName+" "+getFilesDir()+"/output/kinetics");
            } catch (Exception e) {
            }

        }
    }
    }

    public void moveSmiles()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/smiles").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile())  {
                // do nothing
            } else {

            }
            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/smiles/"+fileName+" "+getFilesDir()+"/output/smiles");
            } catch (Exception e) {
            }

        }
    }


    public void moveXyz()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/xyz").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/xyz/"+fileName+" "+getFilesDir()+"/output/xyz");
            } catch (Exception e) {
            }

        }
    }
    }

    public void moveGas()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/gas").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/gas/"+fileName+" "+getFilesDir()+"/output/gas");
            } catch (Exception e) {
            }

        }
    }
    }

    public void moveGasOpt()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/gas/opt").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/gas/opt/"+fileName+" "+getFilesDir()+"/output/gas/opt");
            } catch (Exception e) {
            }

        }
    }
    }

    public void moveGasOptResults()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/gas/opt/results").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/gas/opt/results/"+fileName+" "+getFilesDir()+"/output/gas/opt/results");
            } catch (Exception e) {
            }

        }
    }
    }

    public void moveGasThermo()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/gas/thermo").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/gas/thermo/"+fileName+" "+getFilesDir()+"/output/gas/thermo");
            } catch (Exception e) {
            }

        }
    }
}

    public void moveGasThermoResults()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/gas/thermo/results").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/gas/thermo/results/"+fileName+" "+getFilesDir()+"/output/gas/thermo/results");
            } catch (Exception e) {
            }

        }
    }
        }

    public void moveSolv()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/solv").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/solv/"+fileName+" "+getFilesDir()+"/output/solv");
            } catch (Exception e) {
            }

        }
    }
        }

    public void moveSolvOpt()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/solv/opt").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {
            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/solv/opt/"+fileName+" "+getFilesDir()+"/output/solv/opt");
            } catch (Exception e) {
            }

        }
    }
        }

    public void moveSolvOptResults()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/solv/opt/results").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/solv/opt/results/"+fileName+" "+getFilesDir()+"/output/solv/opt/results");
            } catch (Exception e) {
            }

        }
    }
        }

    public void moveSolvThermo()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/solv/thermo").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/solv/thermo/"+fileName+" "+getFilesDir()+"/output/solv/thermo");
            } catch (Exception e) {
            }

        }
    }
        }

    public void moveSolvThermoResults()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/solv/thermo/results").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

            try {
                String fileName = file.getName();
                exec("mv "+getFilesDir()+"/openbabel/solv/thermo/results/"+fileName+" "+getFilesDir()+"/output/solv/thermo/results");
            } catch (Exception e) {
            }
        }
    }

        }

    public void moveTautomers()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/tautomers").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

                try {
                    String fileName = file.getName();
                    exec("mv "+getFilesDir()+"/openbabel/tautomers/"+fileName+" "+getFilesDir()+"/output/tautomers");
                } catch (Exception e) {
                }
            }
        }

    }

    public void moveCryst()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/cryst").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

                try {
                    String fileName = file.getName();
                    exec("mv "+getFilesDir()+"/openbabel/cryst/"+fileName+" "+getFilesDir()+"/output/cryst");
                } catch (Exception e) {
                }

            }
        }
    }

    public void moveLiq()
    {
        File[] inputfiles = new File(getFilesDir()+"/openbabel/liq").listFiles();
        for (File file : inputfiles) {
            if (!file.isFile()) {
                // do nothing
            } else {

                try {
                    String fileName = file.getName();
                    exec("mv "+getFilesDir()+"/openbabel/liq/"+fileName+" "+getFilesDir()+"/output/liq");
                } catch (Exception e) {
                }

            }
        }
    }

    public void cleanDummyDatasets()
    {
//        exec("rm "+getFilesDir()+"/output/phreeqc_datasets"+File.separator+"hydrocarbons-PM7_s.txt");
//        exec("rm "+getFilesDir()+"/output/phreeqc_datasets"+File.separator+"hydrocarbons-PM7_g.txt");

        goBack();
    }

    public void goBack()
    {
        Intent intent = new Intent(ResumeActivity.this, MainActivity.class);
        startActivity(intent);
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
