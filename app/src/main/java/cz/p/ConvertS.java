package cz.p;

import static cz.p.Spannables.colorized_numbers;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ConvertS extends MainActivity {

    private Handler handler = new Handler();


    private TextView Description;
    private TextView TabDataLabel;
    private EditText TabData;
    private EditText SaveName;
    Button openInputfile;
    Button openInputfile2;
    Button Convert;
    Button Quit;
    private TextView ConvertedDataLabel;
    private EditText ConvertedData;
    private static final int READ_FILE11 = 1811;
    private Uri documentUri11;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.converts);

        TabDataLabel = (TextView) findViewById(R.id.TabDataLabel);
        TabData = (EditText) findViewById(R.id.TabData);
        TabData.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        SaveName = (EditText) findViewById(R.id.SaveName);
        SaveName.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        SaveName.addTextChangedListener(new TextWatcher() {
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
                SaveName.removeTextChangedListener(this);
                String text = SaveName.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                SaveName.getText().clear();
                SaveName.append(colorized_numbers(text));
                // place the cursor at the original position
                SaveName.setSelection(startChanged+countChanged);
                SaveName.addTextChangedListener(this);
            }
        });
        openInputfile = (Button) findViewById(R.id.openInputfile);
        openInputfile.setOnClickListener(openInputfileClick);
        openInputfile2 = (Button) findViewById(R.id.openInputfile2);
        openInputfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String InputData = TabData.getText().toString();

                try {
                    FileOutputStream fileout = openFileOutput("Thermochemistry_s.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputData);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String SaveOutputName = SaveName.getText().toString();

                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(SaveOutputName);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(ConvertS.this, ConvertPickerS.class);
                startActivity(intent);
            }
        });
        Convert = (Button) findViewById(R.id.Convert);
        Convert.setOnClickListener(ConvertClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        ConvertedDataLabel = (TextView) findViewById(R.id.ConvertedDataLabel);
        ConvertedData = (EditText) findViewById(R.id.ConvertedData);
        ConvertedData.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());

    }


    public void onStart()
    {
        super.onStart();
        output2(exec("cat "+getFilesDir()+"/dataset-name.txt"));
        output3(exec("cat "+getFilesDir()+"/Thermochemistry_s.txt"));
    }

    private View.OnClickListener openInputfileClick; {

        openInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String SaveOutputName = SaveName.getText().toString();

                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(SaveOutputName);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read11(getApplicationContext());
                output2(exec("cat "+getFilesDir()+"/dataset-name.txt"));
                output3(exec("cat "+getFilesDir()+"/Thermochemistry_s.txt"));
            }
        };
    }

    private View.OnClickListener ConvertClick; {

        ConvertClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String InputData = TabData.getText().toString();

                InputData = InputData.replace(",", ".");
                ///////////////// introduce [C], [H], [N], [O], [S], [F] to formula programatically /////////////////////////
                //                try {
//                    while (InputData.contains("C")){
//                InputData = InputData.replace("C", "[C]");
//                InputData = InputData.replace("[C]a", "Ca");
//                InputData = InputData.replace("[C]b", "Cb");
//                InputData = InputData.replace("[C]c", "Cc");
//                InputData = InputData.replace("[C]d", "Cd");
//                InputData = InputData.replace("[C]e", "Ce");
//                InputData = InputData.replace("[C]f", "Cf");
//                InputData = InputData.replace("[C]g", "Cg");
//                InputData = InputData.replace("[C]h", "Ch");
//                InputData = InputData.replace("[C]i", "Ci");
//                InputData = InputData.replace("[C]j", "Cj");
//                InputData = InputData.replace("[C]k", "Ck");
//                InputData = InputData.replace("[C]l", "Cl");
//                InputData = InputData.replace("[C]m", "Cm");
//                InputData = InputData.replace("[C]n", "Cn");
//                InputData = InputData.replace("[C]o", "Co");
//                InputData = InputData.replace("[C]p", "Cp");
//                InputData = InputData.replace("[C]q", "Cq");
//                InputData = InputData.replace("[C]r", "Cr");
//                InputData = InputData.replace("[C]s", "Cs");
//                InputData = InputData.replace("[C]t", "Ct");
//                InputData = InputData.replace("[C]u", "Cu");
//                InputData = InputData.replace("[C]v", "Cv");
//                InputData = InputData.replace("[C]w", "Cw");
//                InputData = InputData.replace("[C]x", "Cx");
//                InputData = InputData.replace("[C]y", "Cy");
//                InputData = InputData.replace("[C]z", "Cz");
//                    }
//                    while (InputData.contains("H")){
                InputData = InputData.replace("H", "[H]");
                InputData = InputData.replace("[H]a", "Ha");
                InputData = InputData.replace("[H]b", "Hb");
                InputData = InputData.replace("[H]c", "Hc");
                InputData = InputData.replace("[H]d", "Hd");
                InputData = InputData.replace("[H]e", "He");
                InputData = InputData.replace("[H]f", "Hf");
                InputData = InputData.replace("[H]g", "Hg");
                InputData = InputData.replace("[H]h", "Hh");
                InputData = InputData.replace("[H]i", "Hi");
                InputData = InputData.replace("[H]j", "Hj");
                InputData = InputData.replace("[H]k", "Hk");
                InputData = InputData.replace("[H]l", "Hl");
                InputData = InputData.replace("[H]m", "Hm");
                InputData = InputData.replace("[H]n", "Hn");
                InputData = InputData.replace("[H]o", "Ho");
                InputData = InputData.replace("[H]p", "Hp");
                InputData = InputData.replace("[H]q", "Hq");
                InputData = InputData.replace("[H]r", "Hr");
                InputData = InputData.replace("[H]s", "Hs");
                InputData = InputData.replace("[H]t", "Ht");
                InputData = InputData.replace("[H]u", "Hu");
                InputData = InputData.replace("[H]v", "Hv");
                InputData = InputData.replace("[H]w", "Hw");
                InputData = InputData.replace("[H]x", "Hx");
                InputData = InputData.replace("[H]y", "Hy");
                InputData = InputData.replace("[H]z", "Hz");
//                    }
//                    while (InputData.contains("N")){
//                InputData = InputData.replace("N", "[N]");
//                InputData = InputData.replace("[N]a", "Na");
//                InputData = InputData.replace("[N]b", "Nb");
//                InputData = InputData.replace("[N]c", "Nc");
//                InputData = InputData.replace("[N]d", "Nd");
//                InputData = InputData.replace("[N]e", "Ne");
//                InputData = InputData.replace("[N]f", "Nf");
//                InputData = InputData.replace("[N]g", "Ng");
//                InputData = InputData.replace("[N]h", "Nh");
//                InputData = InputData.replace("[N]i", "Ni");
//                InputData = InputData.replace("[N]j", "Nj");
//                InputData = InputData.replace("[N]k", "Nk");
//                InputData = InputData.replace("[N]l", "Nl");
//                InputData = InputData.replace("[N]m", "Nm");
//                InputData = InputData.replace("[N]n", "Nn");
//                InputData = InputData.replace("[N]o", "No");
//                InputData = InputData.replace("[N]p", "Np");
//                InputData = InputData.replace("[N]q", "Nq");
//                InputData = InputData.replace("[N]r", "Nr");
//                InputData = InputData.replace("[N]s", "Ns");
//                InputData = InputData.replace("[N]t", "Nt");
//                InputData = InputData.replace("[N]u", "Nu");
//                InputData = InputData.replace("[N]v", "Nv");
//                InputData = InputData.replace("[N]w", "Nw");
//                InputData = InputData.replace("[N]x", "Nx");
//                InputData = InputData.replace("[N]y", "Ny");
//                InputData = InputData.replace("[N]z", "Nz");
//                    }
//                    while (InputData.contains("O")){
                InputData = InputData.replace("O", "[O]");
                InputData = InputData.replace("[O]a", "Oa");
                InputData = InputData.replace("[O]b", "Ob");
                InputData = InputData.replace("[O]c", "Oc");
                InputData = InputData.replace("[O]d", "Od");
                InputData = InputData.replace("[O]e", "Oe");
                InputData = InputData.replace("[O]f", "Of");
                InputData = InputData.replace("[O]g", "Og");
                InputData = InputData.replace("[O]h", "Oh");
                InputData = InputData.replace("[O]i", "Oi");
                InputData = InputData.replace("[O]j", "Oj");
                InputData = InputData.replace("[O]k", "Ok");
                InputData = InputData.replace("[O]l", "Ol");
                InputData = InputData.replace("[O]m", "Om");
                InputData = InputData.replace("[O]n", "On");
                InputData = InputData.replace("[O]o", "Oo");
                InputData = InputData.replace("[O]p", "Op");
                InputData = InputData.replace("[O]q", "Oq");
                InputData = InputData.replace("[O]r", "Or");
                InputData = InputData.replace("[O]s", "Os");
                InputData = InputData.replace("[O]t", "Ot");
                InputData = InputData.replace("[O]u", "Ou");
                InputData = InputData.replace("[O]v", "Ov");
                InputData = InputData.replace("[O]w", "Ow");
                InputData = InputData.replace("[O]x", "Ox");
                InputData = InputData.replace("[O]y", "Oy");
                InputData = InputData.replace("[O]z", "Oz");
//                    }
//                    while (InputData.contains("S")){
//                InputData = InputData.replace("S", "[S]");
//                InputData = InputData.replace("[S]a", "Sa");
//                InputData = InputData.replace("[S]b", "Sb");
//                InputData = InputData.replace("[S]c", "Sc");
//                InputData = InputData.replace("[S]d", "Sd");
//                InputData = InputData.replace("[S]e", "Se");
//                InputData = InputData.replace("[S]f", "Sf");
//                InputData = InputData.replace("[S]g", "Sg");
//                InputData = InputData.replace("[S]h", "Sh");
//                InputData = InputData.replace("[S]i", "Si");
//                InputData = InputData.replace("[S]j", "Sj");
//                InputData = InputData.replace("[S]k", "Sk");
//                InputData = InputData.replace("[S]l", "Sl");
//                InputData = InputData.replace("[S]m", "Sm");
//                InputData = InputData.replace("[S]n", "Sn");
//                InputData = InputData.replace("[S]o", "So");
//                InputData = InputData.replace("[S]p", "Sp");
//                InputData = InputData.replace("[S]q", "Sq");
//                InputData = InputData.replace("[S]r", "Sr");
//                InputData = InputData.replace("[S]s", "Ss");
//                InputData = InputData.replace("[S]t", "St");
//                InputData = InputData.replace("[S]u", "Su");
//                InputData = InputData.replace("[S]v", "Sv");
//                InputData = InputData.replace("[S]w", "Sw");
//                InputData = InputData.replace("[S]x", "Sx");
//                InputData = InputData.replace("[S]y", "Sy");
//                InputData = InputData.replace("[S]z", "Sz");
//                    }
//                    while (InputData.contains("F")){
//                InputData = InputData.replace("F", "[F]");
//                InputData = InputData.replace("[F]a", "Fa");
//                InputData = InputData.replace("[F]b", "Fb");
//                InputData = InputData.replace("[F]c", "Fc");
//                InputData = InputData.replace("[F]d", "Fd");
//                InputData = InputData.replace("[F]e", "Fe");
//                InputData = InputData.replace("[F]f", "Ff");
//                InputData = InputData.replace("[F]g", "Fg");
//                InputData = InputData.replace("[F]h", "Fh");
//                InputData = InputData.replace("[F]i", "Fi");
//                InputData = InputData.replace("[F]j", "Fj");
//                InputData = InputData.replace("[F]k", "Fk");
//                InputData = InputData.replace("[F]l", "Fl");
//                InputData = InputData.replace("[F]m", "Fm");
//                InputData = InputData.replace("[F]n", "Fn");
//                InputData = InputData.replace("[F]o", "Fo");
//                InputData = InputData.replace("[F]p", "Fp");
//                InputData = InputData.replace("[F]q", "Fq");
//                InputData = InputData.replace("[F]r", "Fr");
//                InputData = InputData.replace("[F]s", "Fs");
//                InputData = InputData.replace("[F]t", "Ft");
//                InputData = InputData.replace("[F]u", "Fu");
//                InputData = InputData.replace("[F]v", "Fv");
//                InputData = InputData.replace("[F]w", "Fw");
//                InputData = InputData.replace("[F]x", "Fx");
//                InputData = InputData.replace("[F]y", "Fy");
//                InputData = InputData.replace("[F]z", "Fz");
//                    }
                InputData = InputData.replace("T[O]T", "TOT");
                InputData = InputData.replace("C[H]N[O]SZ", "CHNOSZ");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                try {
                    FileOutputStream fileout = openFileOutput("Thermochemistry_s.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(InputData);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String SaveOutputName = SaveName.getText().toString();

                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(SaveOutputName);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                read11(getApplicationContext());
                exec("cp "+getFilesDir()+"/Thermochemistry_s.txt "+getFilesDir()+"/SOLUTION_SPECIES/Thermochemistry_s.txt");
                exec("cp "+getFilesDir()+"/Thermochemistry_s.txt "+getFilesDir()+"/PSEUDOPHASES/Thermochemistry_s.txt");

                progressDialog = new ProgressDialog(ConvertS.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Converting data to database.");
                progressDialog.setCancelable(false);
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                progressDialog.show();
                new Thread() {
                    public void run() {



                        makeDatabase_solv();
                        modifyOutput_solv();
//                        Toast.makeText(getApplicationContext(), "Conversion has finished.", Toast.LENGTH_SHORT).show();
                        postActivity();
                        onFinishS();
                    }
                    public void onFinishS(){
                        progressDialog.dismiss();
                    }
                }.start();
//                Intent intent = new Intent(ConvertS.this, ResumeActivity.class);
//                startActivity(intent);
                onStart();
            }
        };
    }

    public void makeDatabase_solv(){
        try {
            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.bas");
            exec("chmod -R 755 "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.bas");
            exec("chmod -R 755 "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void modifyOutput_solv() {
        try {
            String Raw_g = exec("cat "+getFilesDir()+"/SOLUTION_SPECIES/Database_s.dat");
            while (Raw_g.contains("= + e- =")){  //2 spaces
                Raw_g = Raw_g.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
            }
	     while (Raw_g.contains("=  + e- =")){  //2 spaces
                Raw_g = Raw_g.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
            }
            FileOutputStream fileout115 = openFileOutput("Database_s1.dat",MODE_PRIVATE);
            OutputStreamWriter outputWriter115 = new OutputStreamWriter(fileout115);
            outputWriter115.write(Raw_g);
            outputWriter115.close();

            String Raw_g2 = exec("cat "+getFilesDir()+"/Database_s1.dat");
            while (Raw_g2.contains("(s) ;  = ")){  //2 spaces
                Raw_g2 = Raw_g2.replace("(s) ;  = ", ""); //(2 spaces, 1 space)
            }
            FileOutputStream fileout215 = openFileOutput("Database_s2.dat",MODE_PRIVATE);
            OutputStreamWriter outputWriter215 = new OutputStreamWriter(fileout215);
            outputWriter215.write(Raw_g2);
            outputWriter215.close();

            /// new piece of code:
            String Raw_s3 = exec("cat "+getFilesDir()+"/Database_s2.dat");
            while (Raw_s3.contains("[H]")){
                Raw_s3 = Raw_s3.replace("[H]", "H");
            }
            FileOutputStream fileout4155 = openFileOutput("Database_s3.dat",MODE_PRIVATE);
            OutputStreamWriter outputWriter4155 = new OutputStreamWriter(fileout4155);
            outputWriter4155.write(Raw_s3);
            outputWriter4155.close();

            String Raw_s4 = exec("cat "+getFilesDir()+"/Database_s3.dat");
            while (Raw_s4.contains("[O]")){
                Raw_s4 = Raw_s4.replace("[O]", "O");
            }
            FileOutputStream fileout4156 = openFileOutput("Database_s4.dat",MODE_PRIVATE);
            OutputStreamWriter outputWriter4156 = new OutputStreamWriter(fileout4156);
            outputWriter4156.write(Raw_s4);
            outputWriter4156.close();
            ///

            String Raw_ss = exec("cat "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
            while (Raw_ss.contains("= + e- =")){  //2 spaces
                Raw_ss = Raw_ss.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
            }
	    while (Raw_ss.contains("=  + e- =")){  //2 spaces
                Raw_ss = Raw_ss.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
            }
            FileOutputStream fileout216 = openFileOutput("Database_solid_sol1.dat",MODE_PRIVATE);
            OutputStreamWriter outputWriter216 = new OutputStreamWriter(fileout216);
            outputWriter216.write(Raw_ss);
            outputWriter216.close();

            String Raw_ss2 = exec("cat "+getFilesDir()+"/Database_solid_sol1.dat");
            while (Raw_ss2.contains("(solv) ;  = ")){  //2 spaces
                Raw_ss2 = Raw_ss2.replace("(solv) ;  = ", ""); //(2 spaces, 1 space)
            }
            FileOutputStream fileout217 = openFileOutput("Database_solid_sol2.dat",MODE_PRIVATE);
            OutputStreamWriter outputWriter217 = new OutputStreamWriter(fileout217);
            outputWriter217.write(Raw_ss2);
            outputWriter217.close();


        /// new piece of code:
        String Raw_ss03 = exec("cat "+getFilesDir()+"/Database_solid_sol2.dat");
        while (Raw_ss03.contains("[H]")){
            Raw_ss03 = Raw_ss03.replace("[H]", "H");
        }
        FileOutputStream fileout6155 = openFileOutput("Database_solid_sol3.dat",MODE_PRIVATE);
        OutputStreamWriter outputWriter6155 = new OutputStreamWriter(fileout6155);
        outputWriter6155.write(Raw_ss03);
        outputWriter6155.close();

        String Raw_ss04 = exec("cat "+getFilesDir()+"/Database_solid_sol3.dat");
        while (Raw_ss04.contains("[O]")){
            Raw_ss04 = Raw_ss04.replace("[O]", "O");
        }
        FileOutputStream fileout6156 = openFileOutput("Database_solid_sol4.dat",MODE_PRIVATE);
        OutputStreamWriter outputWriter6156 = new OutputStreamWriter(fileout6156);
        outputWriter6156.write(Raw_ss04);
        outputWriter6156.close();
        ///
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String Fastchem_database_content = exec("cat "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat");

            Fastchem_database_content = Fastchem_database_content.replace("[H]", "H");
            Fastchem_database_content = Fastchem_database_content.replace("[O]", "O");
//            Fastchem_database_content = Fastchem_database_content.replace("[C]", "C");
//            Fastchem_database_content = Fastchem_database_content.replace("[N]", "N");
//            Fastchem_database_content = Fastchem_database_content.replace("[S]", "S");
//            Fastchem_database_content = Fastchem_database_content.replace("[F]", "F");

            FileOutputStream fileoutFCH = openFileOutput("Fastchem_solid_sol.tmp",MODE_PRIVATE);
            OutputStreamWriter outputWriterFCH = new OutputStreamWriter(fileoutFCH);
            outputWriterFCH.write(Fastchem_database_content);
            outputWriterFCH.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        exec("rm "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat");
        exec("mv "+getFilesDir()+"/Fastchem_solid_sol.tmp "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat");

        String SaveOutputName = SaveName.getText().toString();
        exec("mv "+getFilesDir()+"/Database_s2.dat "+getFilesDir()+"/output/phreeqc_datasets/"+File.separator+SaveOutputName+"_anhydr_s.txt");
        exec("mv "+getFilesDir()+"/Database_s4.dat "+getFilesDir()+"/output/phreeqc_datasets/"+File.separator+SaveOutputName+"_water_s.txt");
        exec("mv "+getFilesDir()+"/Database_solid_sol2.dat "+getFilesDir()+"/output/phreeqc_datasets/"+File.separator+SaveOutputName+"_anhydr_solid_sol.txt");
        exec("mv "+getFilesDir()+"/Database_solid_sol4.dat "+getFilesDir()+"/output/phreeqc_datasets/"+File.separator+SaveOutputName+"_water_solid_sol.txt");
        exec("rm "+getFilesDir()+"/Database_s.dat");
        exec("rm "+getFilesDir()+"/Database_s1.dat");
        exec("rm "+getFilesDir()+"/Database_s3.dat");
        exec("rm "+getFilesDir()+"/Database_solid_sol.dat");
        exec("rm "+getFilesDir()+"/Database_solid_sol1.dat");
        exec("rm "+getFilesDir()+"/Database_solid_sol3.dat");
        exec("mv "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+SaveOutputName+"_solid_sol.txt");
    }

    public void postActivity() {

        // TODO Auto-generated method stub //
        try {
            Intent intent = new Intent(ConvertS.this, ResumeActivity.class);
            startActivity(intent);
            onResume();
        } catch (Exception e) {
        }
    }

    private void read11(Context context11) {
        Intent intent11 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent11.addCategory(Intent.CATEGORY_OPENABLE);
        intent11.setType("text/plain");
        startActivityForResult(intent11, READ_FILE11);
    }

    @Override
    protected void onResume() {
        super.onResume();
        output2(exec("cat "+getFilesDir()+"/dataset-name.txt"));
        output3(exec("cat "+getFilesDir()+"/Thermochemistry_s.txt"));
        outputX(exec("cat "+getFilesDir()+"/Database_s2.dat"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == READ_FILE11 && data != null) {
            try {
                documentUri11 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd11 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd11.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("Thermochemistry_s.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd11.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(ConvertS.this, ConvertDialog.class);
                startActivity(intent);
            }
        };
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output2(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                SaveName.setText(colorized_numbers(str2), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc2);
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                TabData.setText(str3);
            }
        };
        handler.post(proc3);
    }

    // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
    public void outputX(final String strX) {
        Runnable procX = new Runnable() {
            public void run() {
                ConvertedData.setText(colorized_numbers(strX), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(procX);
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
