package cz.p;

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
import android.text.Spannable;
import android.text.SpannableString;
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

public class ConvertG extends MainActivity {

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
    private static final int READ_FILE8 = 8;
    private Uri documentUri8;


    /**
     * Colorize a specific substring in a string for TextView. Use it like this: <pre>
     * textView.setText(
     *     Strings.colorized("The some words are black some are the default.","black", Color.BLACK),
     *     TextView.BufferType.SPANNABLE
     * );
     * </pre>
     * @param text Text that contains a substring to colorize
     * @param word0 The substring to colorize
     * @param word1 The substring to colorize
     * @param word2 The substring to colorize
     * @param word3 The substring to colorize
     * @param word4 The substring to colorize
     * @param word5 The substring to colorize
     * @param word6 The substring to colorize
     * @param word7 The substring to colorize
     * @param word8 The substring to colorize
     * @param word9 The substring to colorize
     * @param word10 The substring to colorize
     * @param word11 The substring to colorize
     * @param word12 The substring to colorize
     * @param argb The color
     * @return the Spannable for TextView's consumption
     */
    public static Spannable colorized(final String text, final String word0, final String word1, final String word2, final String word3, final String word4, final String word5, final String word6, final String word7, final String word8, final String word9, final String word10, final String word11, final String word12, final int argb) {
        final Spannable spannable = new SpannableString(text);
        int substringStart0=0;
        int substringStart1=0;
        int substringStart2=0;
        int substringStart3=0;
        int substringStart4=0;
        int substringStart5=0;
        int substringStart6=0;
        int substringStart7=0;
        int substringStart8=0;
        int substringStart9=0;
        int substringStart10=0;
        int substringStart11=0;
        int substringStart12=0;
        int start0;
        int start1;
        int start2;
        int start3;
        int start4;
        int start5;
        int start6;
        int start7;
        int start8;
        int start9;
        int start10;
        int start11;
        int start12;
        while((start0=text.indexOf(word0,substringStart0))>=0){
            spannable.setSpan(
                    new ForegroundColorSpan(argb),start0,start0+word0.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            );
            while((start1=text.indexOf(word1,substringStart1))>=0) {
                spannable.setSpan(
                        new ForegroundColorSpan(argb), start1, start1 + word1.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                while((start2=text.indexOf(word2,substringStart2))>=0) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb), start2, start2 + word2.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                    while((start3=text.indexOf(word3,substringStart3))>=0) {
                        spannable.setSpan(
                                new ForegroundColorSpan(argb), start3, start3 + word3.length(),
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        );
                        while((start4=text.indexOf(word4,substringStart4))>=0) {
                            spannable.setSpan(
                                    new ForegroundColorSpan(argb), start4, start4 + word4.length(),
                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            );
                            while((start5=text.indexOf(word5,substringStart5))>=0) {
                                spannable.setSpan(
                                        new ForegroundColorSpan(argb), start5, start5 + word5.length(),
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                );
                                while((start6=text.indexOf(word6,substringStart6))>=0) {
                                    spannable.setSpan(
                                            new ForegroundColorSpan(argb), start6, start6 + word6.length(),
                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                    );
                                    while((start7=text.indexOf(word7,substringStart7))>=0) {
                                        spannable.setSpan(
                                                new ForegroundColorSpan(argb), start7, start7 + word7.length(),
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                        );
                                        while((start8=text.indexOf(word8,substringStart8))>=0) {
                                            spannable.setSpan(
                                                    new ForegroundColorSpan(argb), start8, start8 + word8.length(),
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                            );
                                            while((start9=text.indexOf(word9,substringStart9))>=0) {
                                                spannable.setSpan(
                                                        new ForegroundColorSpan(argb), start9, start9 + word9.length(),
                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                );
                                                while((start10=text.indexOf(word10,substringStart10))>=0) {
                                                    spannable.setSpan(
                                                            new ForegroundColorSpan(argb), start10, start10 + word10.length(),
                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                    );
                                                    while((start11=text.indexOf(word11,substringStart11))>=0) {
                                                        spannable.setSpan(
                                                                new ForegroundColorSpan(argb), start11, start11 + word11.length(),
                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                        );
                                                        while((start12=text.indexOf(word12,substringStart12))>=0) {
                                                            spannable.setSpan(
                                                                    new ForegroundColorSpan(argb), start12, start12 + word12.length(),
                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                            );
                                                            substringStart12 = start12 + word12.length();
                                                        }
                                                        substringStart11 = start11 + word11.length();
                                                    }
                                                    substringStart10 = start10 + word10.length();
                                                }
                                                substringStart9 = start9 + word9.length();
                                            }
                                            substringStart8 = start8+word8.length();
                                        }
                                        substringStart7 = start7+word7.length();
                                    }
                                    substringStart6 = start6+word6.length();
                                }
                                substringStart5 = start5+word5.length();
                            }
                            substringStart4 = start4+word4.length();
                        }
                        substringStart3 = start3+word3.length();
                    }
                    substringStart2 = start2+word2.length();
                }
                substringStart1 = start1+word1.length();
            }
            substringStart0 = start0+word0.length();
        }
        return spannable;
    }
    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.convertg);

        TabDataLabel = (TextView) findViewById(R.id.TabDataLabel);
        TabData = (EditText) findViewById(R.id.TabData);
        SaveName = (EditText) findViewById(R.id.SaveName);
        openInputfile = (Button) findViewById(R.id.openInputfile);
        openInputfile.setOnClickListener(openInputfileClick);
        openInputfile2 = (Button) findViewById(R.id.openInputfile2);
        openInputfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String InputData = TabData.getText().toString();

                try {
                    FileOutputStream fileout = openFileOutput("Thermochemistry_g.txt", MODE_PRIVATE);
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
                Intent intent = new Intent(ConvertG.this, ConvertPickerG.class);
                startActivity(intent);
            }
        });
        Convert = (Button) findViewById(R.id.Convert);
        Convert.setOnClickListener(ConvertClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        ConvertedDataLabel = (TextView) findViewById(R.id.ConvertedDataLabel);
        ConvertedData = (EditText) findViewById(R.id.ConvertedData);

    }


    public void onStart()
    {
        super.onStart();
        output2(exec("cat "+getFilesDir()+"/dataset-name.txt"));
        output3(exec("cat "+getFilesDir()+"/Thermochemistry_g.txt"));
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
                read8(getApplicationContext());
                output2(exec("cat "+getFilesDir()+"/dataset-name.txt"));
                output3(exec("cat "+getFilesDir()+"/Thermochemistry_g.txt"));
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
                InputData = InputData.replace("C", "[C]");
                InputData = InputData.replace("[C]a", "Ca");
                InputData = InputData.replace("[C]b", "Cb");
                InputData = InputData.replace("[C]c", "Cc");
                InputData = InputData.replace("[C]d", "Cd");
                InputData = InputData.replace("[C]e", "Ce");
                InputData = InputData.replace("[C]f", "Cf");
                InputData = InputData.replace("[C]g", "Cg");
                InputData = InputData.replace("[C]h", "Ch");
                InputData = InputData.replace("[C]i", "Ci");
                InputData = InputData.replace("[C]j", "Cj");
                InputData = InputData.replace("[C]k", "Ck");
                InputData = InputData.replace("[C]l", "Cl");
                InputData = InputData.replace("[C]m", "Cm");
                InputData = InputData.replace("[C]n", "Cn");
                InputData = InputData.replace("[C]o", "Co");
                InputData = InputData.replace("[C]p", "Cp");
                InputData = InputData.replace("[C]q", "Cq");
                InputData = InputData.replace("[C]r", "Cr");
                InputData = InputData.replace("[C]s", "Cs");
                InputData = InputData.replace("[C]t", "Ct");
                InputData = InputData.replace("[C]u", "Cu");
                InputData = InputData.replace("[C]v", "Cv");
                InputData = InputData.replace("[C]w", "Cw");
                InputData = InputData.replace("[C]x", "Cx");
                InputData = InputData.replace("[C]y", "Cy");
                InputData = InputData.replace("[C]z", "Cz");
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
                InputData = InputData.replace("N", "[N]");
                InputData = InputData.replace("[N]a", "Na");
                InputData = InputData.replace("[N]b", "Nb");
                InputData = InputData.replace("[N]c", "Nc");
                InputData = InputData.replace("[N]d", "Nd");
                InputData = InputData.replace("[N]e", "Ne");
                InputData = InputData.replace("[N]f", "Nf");
                InputData = InputData.replace("[N]g", "Ng");
                InputData = InputData.replace("[N]h", "Nh");
                InputData = InputData.replace("[N]i", "Ni");
                InputData = InputData.replace("[N]j", "Nj");
                InputData = InputData.replace("[N]k", "Nk");
                InputData = InputData.replace("[N]l", "Nl");
                InputData = InputData.replace("[N]m", "Nm");
                InputData = InputData.replace("[N]n", "Nn");
                InputData = InputData.replace("[N]o", "No");
                InputData = InputData.replace("[N]p", "Np");
                InputData = InputData.replace("[N]q", "Nq");
                InputData = InputData.replace("[N]r", "Nr");
                InputData = InputData.replace("[N]s", "Ns");
                InputData = InputData.replace("[N]t", "Nt");
                InputData = InputData.replace("[N]u", "Nu");
                InputData = InputData.replace("[N]v", "Nv");
                InputData = InputData.replace("[N]w", "Nw");
                InputData = InputData.replace("[N]x", "Nx");
                InputData = InputData.replace("[N]y", "Ny");
                InputData = InputData.replace("[N]z", "Nz");
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
                InputData = InputData.replace("S", "[S]");
                InputData = InputData.replace("[S]a", "Sa");
                InputData = InputData.replace("[S]b", "Sb");
                InputData = InputData.replace("[S]c", "Sc");
                InputData = InputData.replace("[S]d", "Sd");
                InputData = InputData.replace("[S]e", "Se");
                InputData = InputData.replace("[S]f", "Sf");
                InputData = InputData.replace("[S]g", "Sg");
                InputData = InputData.replace("[S]h", "Sh");
                InputData = InputData.replace("[S]i", "Si");
                InputData = InputData.replace("[S]j", "Sj");
                InputData = InputData.replace("[S]k", "Sk");
                InputData = InputData.replace("[S]l", "Sl");
                InputData = InputData.replace("[S]m", "Sm");
                InputData = InputData.replace("[S]n", "Sn");
                InputData = InputData.replace("[S]o", "So");
                InputData = InputData.replace("[S]p", "Sp");
                InputData = InputData.replace("[S]q", "Sq");
                InputData = InputData.replace("[S]r", "Sr");
                InputData = InputData.replace("[S]s", "Ss");
                InputData = InputData.replace("[S]t", "St");
                InputData = InputData.replace("[S]u", "Su");
                InputData = InputData.replace("[S]v", "Sv");
                InputData = InputData.replace("[S]w", "Sw");
                InputData = InputData.replace("[S]x", "Sx");
                InputData = InputData.replace("[S]y", "Sy");
                InputData = InputData.replace("[S]z", "Sz");
//                    }
//                    while (InputData.contains("F")){
                InputData = InputData.replace("F", "[F]");
                InputData = InputData.replace("[F]a", "Fa");
                InputData = InputData.replace("[F]b", "Fb");
                InputData = InputData.replace("[F]c", "Fc");
                InputData = InputData.replace("[F]d", "Fd");
                InputData = InputData.replace("[F]e", "Fe");
                InputData = InputData.replace("[F]f", "Ff");
                InputData = InputData.replace("[F]g", "Fg");
                InputData = InputData.replace("[F]h", "Fh");
                InputData = InputData.replace("[F]i", "Fi");
                InputData = InputData.replace("[F]j", "Fj");
                InputData = InputData.replace("[F]k", "Fk");
                InputData = InputData.replace("[F]l", "Fl");
                InputData = InputData.replace("[F]m", "Fm");
                InputData = InputData.replace("[F]n", "Fn");
                InputData = InputData.replace("[F]o", "Fo");
                InputData = InputData.replace("[F]p", "Fp");
                InputData = InputData.replace("[F]q", "Fq");
                InputData = InputData.replace("[F]r", "Fr");
                InputData = InputData.replace("[F]s", "Fs");
                InputData = InputData.replace("[F]t", "Ft");
                InputData = InputData.replace("[F]u", "Fu");
                InputData = InputData.replace("[F]v", "Fv");
                InputData = InputData.replace("[F]w", "Fw");
                InputData = InputData.replace("[F]x", "Fx");
                InputData = InputData.replace("[F]y", "Fy");
                InputData = InputData.replace("[F]z", "Fz");
//                    }
                InputData = InputData.replace("T[O]T", "TOT");
                InputData = InputData.replace("[C][H][O][N][S]Z", "CHONSZ");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                try {
                    FileOutputStream fileout = openFileOutput("Thermochemistry_g.txt", MODE_PRIVATE);
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
//                read8(getApplicationContext());
                exec("cp "+getFilesDir()+"/Thermochemistry_g.txt "+getFilesDir()+"/PHASES/Thermochemistry_g.txt");
                progressDialog = new ProgressDialog(ConvertG.this);
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



                        makeDatabase_g();
                        modifyOutput_g();
                        Toast.makeText(getApplicationContext(), "Conversion has finished.", Toast.LENGTH_SHORT).show();
                        onFinishG();
                    }
                    public void onFinishG(){
                        progressDialog.dismiss();
                    }
                }.start();
//                Intent intent = new Intent(ConvertG.this, ResumeActivity.class);
//                startActivity(intent);
                onStart();
            }
        };
    }

    public void makeDatabase_g(){
        try {
            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.bas");
            exec("chmod -R 755 "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b");
            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void modifyOutput_g() {
        try {
            String Raw_g = exec("cat "+getFilesDir()+"/PHASES/Database_g.dat");
            while (Raw_g.contains("= + e- =")){  //2 spaces
                Raw_g = Raw_g.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
            }
	    while (Raw_g.contains("=  + e- =")){  //2 spaces
                Raw_g = Raw_g.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
            }
            FileOutputStream fileout115 = openFileOutput("Database_g1.dat",MODE_PRIVATE);
            OutputStreamWriter outputWriter115 = new OutputStreamWriter(fileout115);
            outputWriter115.write(Raw_g);
            outputWriter115.close();

            String Raw_g2 = exec("cat "+getFilesDir()+"/Database_g1.dat");
            while (Raw_g2.contains("(g) ;  = ")){  //2 spaces
                Raw_g2 = Raw_g2.replace("(g) ;  = ", ""); //(2 spaces, 1 space)
            }
            FileOutputStream fileout215 = openFileOutput("Database_g2.dat",MODE_PRIVATE);
            OutputStreamWriter outputWriter215 = new OutputStreamWriter(fileout215);
            outputWriter215.write(Raw_g2);
            outputWriter215.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String SaveOutputName = SaveName.getText().toString();
        exec("cp "+getFilesDir()+"/Database_g2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+SaveOutputName+"_g.txt");
        exec("rm "+getFilesDir()+"/Database_g2.dat");
        exec("chmod -R 755 "+getFilesDir()+"/PHASES");
        exec("mv "+getFilesDir()+"/PHASES/Fastchem_g.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+SaveOutputName+"_g.txt");
    }

    private void read8(Context context8) {
        Intent intent8 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent8.addCategory(Intent.CATEGORY_OPENABLE);
        intent8.setType("text/plain");
        startActivityForResult(intent8, READ_FILE8);
    }

    @Override
    protected void onResume() {
        super.onResume();
        output2(exec("cat "+getFilesDir()+"/dataset-name.txt"));
        output3(exec("cat "+getFilesDir()+"/Thermochemistry_g.txt"));
        outputX(exec("cat "+getFilesDir()+"/Database_g2.dat"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == READ_FILE8 && data != null) {
            try {
                documentUri8 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd8 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd8.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("Thermochemistry_g.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd8.close();

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
                Intent intent = new Intent(ConvertG.this, ConvertDialog.class);
                startActivity(intent);
            }
        };
    }


    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output2(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                SaveName.setText(str2);
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
//                        outputView4.setText(strX);
                ConvertedData.setText(colorized(strX, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
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
