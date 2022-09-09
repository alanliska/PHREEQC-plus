package cz.p;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
/*import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;*/

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.PrintWriter;
import static android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION;

public class MainActivity extends AppCompatActivity {

    // very important - each code must be different!!!
    private static final int MY_PERMISSION_REQUEST_STORAGE = 1;
    private static final int MANAGE_ALL_FILES_ACCESS_PERMISSION = 2;
    private Uri documentUri1;
    private Uri documentUri2;
    private Uri documentUri3;
    private Uri documentUri4;
    private Uri documentUri5;
    private TextView outputView;
    private EditText outputView2;
    private EditText outputView4;
    private TextView dataset_label;
    private EditText dataset;
    private TextView ModifyLabel;
    private TextView ModifyLabel2;
    private Handler handler = new Handler();
    private boolean isCanceled;
    Button start_openbabel;
    Button start_phreeqc;
    Button start_convert;

    Button databasebutton;
    Button selectdatabasebutton;
    Button selectdatabasebutton2;
    Button openInputfile;
    Button openInputfile2;
    Button saveInputfile;
    Button saveInputfile2;
    Button saveOutputfile;
    Button saveOutputfile2;
    Button saveDatabasefile;
    Button saveDatabasefile2;
    Button About;
    Button modifybutton;
    Button Highlight;
    public ProgressDialog progressDialog;
    Button Manual;
    Button start_devmode;
    Button start_bulk;
    TextView label0;
    TextView label1;
    TextView label2;
    TextView label3;
    TextView label4;
    Button start_mopac_chemsol_mulliken;
    Button start_mopac_chemsol_esp;
    Button start_mopac;
    Button start_chemsol;
    Button start_obabel;
    TextView labelKin;
    TextView temperature_label;
    EditText temperature;
    Button start_kin11;
    Button start_kin12;
    Button start_kin22;
    Button start_kin23;



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
        setContentView(R.layout.activity_main);

        dataset_label = (TextView) findViewById(R.id.dataset_label);
        dataset = (EditText) findViewById(R.id.dataset);

        start_openbabel = (Button) findViewById(R.id.start_openbabel);

        start_phreeqc = (Button) findViewById(R.id.start_phreeqc);
        start_convert = (Button) findViewById(R.id.start_convert);
        start_devmode = (Button) findViewById(R.id.start_devmode);

        About = (Button) findViewById(R.id.About);
        About.setOnClickListener(onAboutClick);

        label0 = (TextView) findViewById(R.id.label0);
        label1 = (TextView) findViewById(R.id.label1);
        label2 = (TextView) findViewById(R.id.label2);
        label3 = (TextView) findViewById(R.id.label3);
        label4 = (TextView) findViewById(R.id.label4);

        labelKin = (TextView) findViewById(R.id.labelKin);
        temperature_label = (TextView) findViewById(R.id.temperature_label);
        temperature = (EditText) findViewById((R.id.temperature));
        start_kin11 = (Button) findViewById(R.id.start_kin11);
        start_kin12 = (Button) findViewById(R.id.start_kin12);
        start_kin22 = (Button) findViewById(R.id.start_kin22);
        start_kin23 = (Button) findViewById(R.id.start_kin23);







        start_openbabel = (Button) findViewById(R.id.start_openbabel);
        start_openbabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String DatasetName = dataset.getText().toString();

                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(MainActivity.this, OpenBabel.class);
                startActivity(intent);
            }
        });



        start_phreeqc = (Button) findViewById(R.id.start_phreeqc);
        start_phreeqc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Phreeqc.class);
                startActivity(intent);
            }
        });

        start_devmode = (Button) findViewById(R.id.start_devmode);
        start_devmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DevMode.class);
                startActivity(intent);
            }
        });

        start_convert = (Button) findViewById(R.id.start_convert);
        start_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConvertDialog.class);
                startActivity(intent);
            }
        });

        start_bulk = (Button) findViewById(R.id.start_bulk);
        start_bulk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String DatasetName = dataset.getText().toString();

                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, BulkConversion.class);
                startActivity(intent);
            }
        });

        start_mopac_chemsol_mulliken = (Button) findViewById(R.id.start_mopac_chemsol_mulliken);
        start_mopac_chemsol_mulliken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String DatasetName = dataset.getText().toString();

                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, Chemsol1.class);
                startActivity(intent);
            }
        });

        start_mopac_chemsol_esp = (Button) findViewById(R.id.start_mopac_chemsol_esp);
        start_mopac_chemsol_esp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String DatasetName = dataset.getText().toString();

                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(MainActivity.this, Chemsol2.class);
                startActivity(intent);
            }
        });

        start_mopac = (Button) findViewById(R.id.start_mopac);
        start_mopac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Mopac.class);
                startActivity(intent);
            }
        });

        start_chemsol = (Button) findViewById(R.id.start_chemsol);
        start_chemsol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Chemsol.class);
                startActivity(intent);
            }
        });

        start_obabel = (Button) findViewById(R.id.start_obabel);
        start_obabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Obabel.class);
                startActivity(intent);
            }
        });

        start_kin11 = (Button) findViewById(R.id.start_kin11);
        start_kin11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Temperature = temperature.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("temperature.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Temperature);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String DatasetName = dataset.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, KineticsUniUni.class);
                startActivity(intent);
            }
        });

        start_kin12 = (Button) findViewById(R.id.start_kin12);
        start_kin12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Temperature = temperature.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("temperature.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Temperature);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String DatasetName = dataset.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, KineticsUniBi.class);
                startActivity(intent);
            }
        });

        start_kin22 = (Button) findViewById(R.id.start_kin22);
        start_kin22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Temperature = temperature.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("temperature.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Temperature);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String DatasetName = dataset.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, KineticsBiBi.class);
                startActivity(intent);
            }
        });

        start_kin23 = (Button) findViewById(R.id.start_kin23);
        start_kin23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Temperature = temperature.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("temperature.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Temperature);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String DatasetName = dataset.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, KineticsBiTri.class);
                startActivity(intent);
            }
        });

        copyAsset("About.txt");

        copyAsset("UniUni.bas");copyAsset("UniBi.bas");copyAsset("BiBi.bas");copyAsset("BiTri.bas");

        copyAsset("BiTri_formulaA.txt");copyAsset("BiTri_iupacA.txt");copyAsset("BiTri_keywA.txt");copyAsset("BiTri_smilesA.txt");copyAsset("BiTri_methodA.txt");
        copyAsset("BiTri_formulaB.txt");copyAsset("BiTri_iupacB.txt");copyAsset("BiTri_keywB.txt");copyAsset("BiTri_smilesB.txt");copyAsset("BiTri_methodB.txt");
        copyAsset("BiTri_formulaC.txt");copyAsset("BiTri_iupacC.txt");copyAsset("BiTri_keywC.txt");copyAsset("BiTri_smilesC.txt");copyAsset("BiTri_methodC.txt");
        copyAsset("BiTri_formulaD.txt");copyAsset("BiTri_iupacD.txt");copyAsset("BiTri_keywD.txt");copyAsset("BiTri_smilesD.txt");copyAsset("BiTri_methodD.txt");
        copyAsset("BiTri_formulaE.txt");copyAsset("BiTri_iupacE.txt");copyAsset("BiTri_keywE.txt");copyAsset("BiTri_smilesE.txt");copyAsset("BiTri_methodE.txt");
        copyAsset("BiTri_keywTS.txt");copyAsset("BiTri_methodTS.txt");copyAsset("BiTri_TS_status.txt");

        copyAsset("BiBi_formulaA.txt");copyAsset("BiBi_iupacA.txt");copyAsset("BiBi_keywA.txt");copyAsset("BiBi_smilesA.txt");copyAsset("BiBi_methodA.txt");
        copyAsset("BiBi_formulaB.txt");copyAsset("BiBi_iupacB.txt");copyAsset("BiBi_keywB.txt");copyAsset("BiBi_smilesB.txt");copyAsset("BiBi_methodB.txt");
        copyAsset("BiBi_formulaC.txt");copyAsset("BiBi_iupacC.txt");copyAsset("BiBi_keywC.txt");copyAsset("BiBi_smilesC.txt");copyAsset("BiBi_methodC.txt");
        copyAsset("BiBi_formulaD.txt");copyAsset("BiBi_iupacD.txt");copyAsset("BiBi_keywD.txt");copyAsset("BiBi_smilesD.txt");copyAsset("BiBi_methodD.txt");
        copyAsset("BiBi_keywTS.txt");copyAsset("BiBi_methodTS.txt");copyAsset("BiBi_TS_status.txt");

        copyAsset("UniBi_formulaA.txt");copyAsset("UniBi_formulaB.txt");copyAsset("UniBi_formulaC.txt");
        copyAsset("UniBi_iupacA.txt");copyAsset("UniBi_iupacB.txt");copyAsset("UniBi_iupacC.txt");
        copyAsset("UniBi_keywA.txt");copyAsset("UniBi_keywB.txt");copyAsset("UniBi_keywC.txt");copyAsset("UniBi_keywTS.txt");
        copyAsset("UniBi_methodA.txt");copyAsset("UniBi_methodB.txt");copyAsset("UniBi_methodC.txt");copyAsset("UniBi_methodTS.txt");
        copyAsset("UniBi_smilesA.txt");copyAsset("UniBi_smilesB.txt");copyAsset("UniBi_smilesC.txt");
        copyAsset("UniBi_TS.txt");copyAsset("UniBi_TS_status.txt");

        copyAsset("UniUni_formulaA.txt");copyAsset("UniUni_formulaB.txt");
        copyAsset("UniUni_iupacA.txt");copyAsset("UniUni_iupacB.txt");
        copyAsset("UniUni_keywA.txt");copyAsset("UniUni_keywB.txt");copyAsset("UniUni_keywTS.txt");
        copyAsset("UniUni_methodA.txt");copyAsset("UniUni_methodB.txt");copyAsset("UniUni_methodTS.txt");
        copyAsset("UniUni_smilesA.txt");copyAsset("UniUni_smilesB.txt");
        copyAsset("UniUni_TS.txt");copyAsset("UniUni_TS_status.txt");

        copyAsset("SMS_kin_status.txt");copyAsset("SS_kin_status.txt");copyAsset("R_kin_status.txt");copyAsset("K_kin_status.txt");

        copyAsset("temperature.txt");

        copyAsset("iupac.txt");copyAsset("method.txt");copyAsset("method-esp.txt");copyAsset("smiles.txt");
        copyAsset("keywords.txt");copyAsset("keywords-esp.txt");copyAsset("solvation.txt");copyAsset("formula.txt");
        copyAsset("dataset-name.txt");copyAsset("xbasic-bas.txt");copyAsset("xbasic-output.txt");
        copyAsset("Keywords.phr");copyAsset("Keywords2.phr");copyAsset("damping-factor.txt");
        copyAsset("Input-phreeqc.txt");copyAsset("Database.dat");copyAsset("Database.txt");copyAsset("test.bas");copyAsset("vdw.par");copyAsset("tautomers.txt");
        copyAsset("chemsol-prepare-mulliken.bas");copyAsset("chemsol-prepare-esp.bas");copyAsset("chemsol-results.bas");
        copyAsset("Input-chemsol.txt");copyAsset("Input-mopac.txt");copyAsset("Input-openbabel.txt");
        copyAsset("InputSwitch.txt");copyAsset("OutputSwitch.txt");copyAsset("P.txt");copyAsset("SS.txt");
        {
        copyAsset2("atomization-energies.txt");copyAsset2("atomtyp.txt");copyAsset2("bondtyp.txt");copyAsset2("eem.txt");
        copyAsset2("eem2015ba.txt");copyAsset2("eem2015bm.txt");copyAsset2("eem2015bn.txt");copyAsset2("eem2015ha.txt");
        copyAsset2("eem2015hm.txt");copyAsset2("eem2015hn.txt");copyAsset2("eqeqIonizations.txt");copyAsset2("gaff.dat");
        copyAsset2("gaff.prm");copyAsset2("ghemical.prm");copyAsset2("logp.txt");copyAsset2("MACCS.txt");
        copyAsset2("mm2.prm");copyAsset2("mmff94.ff");copyAsset2("mmff94s.ff");copyAsset2("mmffang.par");
        copyAsset2("mmffbndk.par");copyAsset2("mmffbond.par");copyAsset2("mmffchg.par");copyAsset2("mmffdef.par");
        copyAsset2("mmffdfsb.par");copyAsset2("mmffoop.par");copyAsset2("mmffpbci.par");copyAsset2("mmffprop.par");
        copyAsset2("mmffs_oop.par");copyAsset2("mmffs_tor.par");copyAsset2("mmffstbn.par");copyAsset2("mmfftor.par");
        copyAsset2("mmffvdw.par");copyAsset2("mpC.txt");copyAsset2("mr.txt");copyAsset2("patterns.txt");copyAsset2("patty.rules");
        copyAsset2("phmodel.txt");copyAsset2("plugindefines.txt");copyAsset2("psa.txt");copyAsset2("qeq.txt");
        copyAsset2("resdata.txt");copyAsset2("rigid-fragments.txt");copyAsset2("rigid-fragments-index.txt");
        copyAsset2("ring-fragments.txt");copyAsset2("ringtyp.txt");copyAsset2("SMARTS_InteLigand.txt");
        copyAsset2("space-groups.txt");copyAsset2("superatom.txt");copyAsset2("templates.sdf");copyAsset2("torlib.txt");
        copyAsset2("torsion.txt");copyAsset2("types.txt");copyAsset2("UFF.prm");
        }
        {
            copyAsset3("example-mopac.txt");
        }
        {
            copyAsset4("manuals.zip");
            copyAsset4("ref_data.zip");
        }
        {
            copyAsset6("Ref_g.txt");copyAsset6("Comp_g.par");copyAsset6("DatabaseMakerPseudoPhases.bas");
        }
        {
            copyAsset7("Ref_s.txt");copyAsset7("Comp_s.par");copyAsset7("DatabaseMakerSolutionPhase.bas");
        }
        {
            copyAsset8("pKa.txt");
            //for now - later delete:
            copyAsset8("Database_anhydr.txt");copyAsset8("Database_water.txt");copyAsset13("Database_kin.txt");
            copyAsset8("Amm.txt");copyAsset8("ColdChem.txt");copyAsset8("core10.txt");
            copyAsset8("frezchem.txt");copyAsset8("iso.txt");copyAsset8("llnl.txt");
            copyAsset8("minteq.txt");copyAsset8("minteq.v4.txt");copyAsset8("phreeqc.txt");
            copyAsset8("pitzer.txt");copyAsset8("sit.txt");copyAsset8("Tipping_Hurley.txt");
            copyAsset8("wateq4f.txt");copyAsset8("Kotrly-Sucha_2021-05-17.txt");
            copyAsset8("PHREEQC_ThermoddemV1.10_15Dec2020.txt");
            copyAsset8("CHNOSZ+ModelSEED_2021-07-24.txt");copyAsset8("CHNOSZ+ModelSEED_2021-07-24_mod.txt");
            copyAsset8("CHNOSZ+ModelSEED_2021-07-24w.txt");copyAsset8("CHNOSZ+ModelSEED_2021-07-24w_mod.txt");
            copyAsset8("Alexandria-b3lyp_2021-07-24.txt");copyAsset8("Alexandria-b3lyp_2021-07-24w.txt");
            copyAsset8("Alexandria-cbs_2021-07-24.txt");copyAsset8("Alexandria-cbs_2021-07-24w.txt");
            copyAsset8("Alexandria-g2_2021-07-24.txt");copyAsset8("Alexandria-g2_2021-07-24w.txt");
            copyAsset8("Alexandria-g3_2021-07-24.txt");copyAsset8("Alexandria-g3_2021-07-24w.txt");
            copyAsset8("Alexandria-g4_2021-07-24.txt");copyAsset8("Alexandria-g4_2021-07-24w.txt");
            copyAsset8("Alexandria-hf_2021-07-24.txt");copyAsset8("Alexandria-hf_2021-07-24w.txt");
            copyAsset8("Alexandria-w1bd_2021-07-24.txt");copyAsset8("Alexandria-w1bd_2021-07-24w.txt");
            copyAsset8("Alexandria-w1u_2021-07-24.txt");copyAsset8("Alexandria-w1u_2021-07-24w.txt");
            copyAsset8("Basic_2021-09-23.txt");copyAsset8("Basic_2021-09-23w.txt");
            copyAsset8("Basic_2021-09-23_mod.txt");copyAsset8("Basic_2021-09-23w_mod.txt");
        }
        {
            copyAsset10("Ref_c.txt");copyAsset10("Comp_c.par");copyAsset10("DatabaseMakerPseudoPhases_c.bas");
        }
        {
            copyAsset11("Ref_l.txt");copyAsset11("Comp_l.par");copyAsset11("DatabaseMakerPseudoPhases_l.bas");
        }
        {
            copyAsset9("Input-phreeqc.txt");copyAsset9("CHNOSZ_gas.txt");copyAsset9("CHNOSZ_liquid.txt");copyAsset9("CHNOSZ_solid.txt");
            copyAsset9("CHNOSZ_water.txt");copyAsset9("Binneweis-Milke_gas.txt");copyAsset9("Input-phreeqc-kin.txt");
            copyAsset9("BiBi_TS.txt");copyAsset9("UniBi_TS.txt");copyAsset9("UniUni_TS.txt");copyAsset9("BiTri_TS.txt");
        }
        {
            copyAsset12("cesium_iodide.txt");copyAsset12("dimethyl_cadmium.txt");copyAsset12("chromium_trioxide.txt");
        }
        {
            copyAsset13("Database_anhydr.txt");copyAsset13("Database_water.txt");copyAsset13("Database_kin.txt");
            copyAsset13("Amm.txt");copyAsset13("ColdChem.txt");copyAsset13("core10.txt");
            copyAsset13("frezchem.txt");copyAsset13("iso.txt");copyAsset13("llnl.txt");
            copyAsset13("minteq.txt");copyAsset13("minteq.v4.txt");copyAsset13("phreeqc.txt");
            copyAsset13("pitzer.txt");copyAsset13("sit.txt");copyAsset13("Tipping_Hurley.txt");
            copyAsset13("wateq4f.txt");copyAsset13("Kotrly-Sucha_2021-05-17.txt");
            copyAsset13("PHREEQC_ThermoddemV1.10_15Dec2020.txt");
            copyAsset13("CHNOSZ+ModelSEED_2021-07-24.txt");copyAsset13("CHNOSZ+ModelSEED_2021-07-24_mod.txt");
            copyAsset13("CHNOSZ+ModelSEED_2021-07-24w.txt");copyAsset13("CHNOSZ+ModelSEED_2021-07-24w_mod.txt");
            copyAsset13("Alexandria-b3lyp_2021-07-24.txt");copyAsset13("Alexandria-b3lyp_2021-07-24w.txt");
            copyAsset13("Alexandria-cbs_2021-07-24.txt");copyAsset13("Alexandria-cbs_2021-07-24w.txt");
            copyAsset13("Alexandria-g2_2021-07-24.txt");copyAsset13("Alexandria-g2_2021-07-24w.txt");
            copyAsset13("Alexandria-g3_2021-07-24.txt");copyAsset13("Alexandria-g3_2021-07-24w.txt");
            copyAsset13("Alexandria-g4_2021-07-24.txt");copyAsset13("Alexandria-g4_2021-07-24w.txt");
            copyAsset13("Alexandria-hf_2021-07-24.txt");copyAsset13("Alexandria-hf_2021-07-24w.txt");
            copyAsset13("Alexandria-w1bd_2021-07-24.txt");copyAsset13("Alexandria-w1bd_2021-07-24w.txt");
            copyAsset13("Alexandria-w1u_2021-07-24.txt");copyAsset13("Alexandria-w1u_2021-07-24w.txt");
            copyAsset13("Basic_2021-09-23.txt");copyAsset13("Basic_2021-09-23w.txt");
            copyAsset13("Basic_2021-09-23_mod.txt");copyAsset13("Basic_2021-09-23w_mod.txt");
        }
        {
            copyAsset14("Input-chemsol.txt");
        }
        {
            copyAsset15("Input-mopac.txt");
        }
        {
            copyAsset16("Input-openbabel.txt");
        }
        ///last copyAsset!!! not put anything behind it (condition - LICENSE...)
        {
            copyAsset5("LICENSE-MOPAC.txt");copyAsset5("LICENSE-OPENBABEL.txt");
            copyAsset5("LICENSE-X11-BASIC.txt");copyAsset5("LICENSING_TERMS-PHREEQC.txt");copyAsset5("LICENSING_TERMS-X11-BASIC.txt");
            copyAsset5("LICENSE1-GMP.txt");copyAsset5("LICENSE2-GMP.txt");copyAsset5("LICENSE-BLAS.txt");copyAsset5("LICENSE-LAPACK.txt");
            //last - see conditions in copyAssetX
        }


        // give the app permissions to access the storage
        {
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MANAGE_ALL_FILES_ACCESS_PERMISSION);

                } else {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MANAGE_ALL_FILES_ACCESS_PERMISSION);
                }
                ;
            } else {
                // do nothing
            }

    }
    }

    public void onStart()
    {
        super.onStart();
        dataset_view(exec("cat "+getFilesDir()+"/dataset-name.txt"));
        temperature_view(exec("cat "+getFilesDir()+"/temperature.txt"));
    }

    private void copyAsset(String filename) {
        File filePath = new File(getFilesDir()+"");
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        if (!check.exists()) {
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(filePath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset2(String filename) {
        String dirPath = getFilesDir()+"/database";
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        File dir = new File(dirPath);
        if (!check.exists()) {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(dirPath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset3(String filename) {
        String dirPath = getFilesDir()+"/work";
        String path = getFilesDir()+"/work/example-mopac.txt";
        File check = new File(path);
        File dir = new File(dirPath);
        if (!check.exists()) {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(dirPath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset4(String filename) {
        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
        String path = filePath+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        if (!check.exists()) {
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(filePath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset6(String filename) {
        String dirPath = getFilesDir()+"/PHASES";
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        File dir = new File(dirPath);
        if (!check.exists()) {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(dirPath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset7(String filename) {
        String dirPath = getFilesDir()+"/SOLUTION_SPECIES";
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        File dir = new File(dirPath);
        if (!check.exists()) {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(dirPath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset8(String filename) {
        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"phreeqc_datasets");
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        if (!check.exists()) {
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(filePath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset9(String filename) {
        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"phreeqc_work");
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        if (!check.exists()) {
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(filePath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset10(String filename) {
        String dirPath = getFilesDir()+"/SOLIDS";
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        File dir = new File(dirPath);
        if (!check.exists()) {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(dirPath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset11(String filename) {
        String dirPath = getFilesDir()+"/LIQUIDS";
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        File dir = new File(dirPath);
        if (!check.exists()) {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(dirPath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset12(String filename) {
        String dirPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"bulk_conversion";
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        File dir = new File(dirPath);
        if (!check.exists()) {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(dirPath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset13(String filename) {
        String dirPath = getFilesDir()+"/phreeqc_database";
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        File dir = new File(dirPath);
        if (!check.exists()) {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(dirPath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset14(String filename) {
        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"chemsol");
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        if (!check.exists()) {
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(filePath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset15(String filename) {
        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"mopac");
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        if (!check.exists()) {
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(filePath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyAsset16(String filename) {
        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"openbabel");
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        if (!check.exists()) {
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(filePath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }


    ///this is the last copyAsset!!! (file LICENSE.txt is as a condition of (un)packing of the other assets)
    private void copyAsset5(String filename) {
        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
        String path = filePath+File.separator+"LICENSE-MOPAC.txt";
        File check = new File(path);
        if (!check.exists()) {
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            AssetManager assetManager = getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(filePath, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
                Toast.makeText(this, "Installing, please wait...", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "App prepared!", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // do nothing
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    private View.OnClickListener onAboutClick; {

        onAboutClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertAbout();
            }
        };
    }

    public void alertAbout() {

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("About the PHREEQC_PLUS app")
                .setMessage(exec("cat "+getFilesDir()+"/About.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {

            String Raw_g = exec("cat "+getFilesDir()+"/PHASES/Database_g.dat");
            while (Raw_g.contains("= + e- =")){  //2 spaces
                Raw_g = Raw_g.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
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


            String Raw_s = exec("cat "+getFilesDir()+"/SOLUTION_SPECIES/Database_s.dat");
            while (Raw_s.contains("= + e- =")){  //2 spaces
                Raw_s = Raw_s.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
            }
            FileOutputStream fileout315 = openFileOutput("Database_s1.dat",MODE_PRIVATE);
            OutputStreamWriter outputWriter315 = new OutputStreamWriter(fileout315);
            outputWriter315.write(Raw_s);
            outputWriter315.close();

            String Raw_s2 = exec("cat "+getFilesDir()+"/Database_s1.dat");
            while (Raw_s2.contains("(g) ;  = ")){  //2 spaces
                Raw_s2 = Raw_s2.replace("(g) ;  = ", ""); //(2 spaces, 1 space)
            }
            FileOutputStream fileout415 = openFileOutput("Database_s2.dat",MODE_PRIVATE);
            OutputStreamWriter outputWriter415 = new OutputStreamWriter(fileout415);
            outputWriter415.write(Raw_s2);
            outputWriter415.close();


        } catch (Exception e) {
            e.printStackTrace();
        }



        String DatasetName = exec("cat "+getFilesDir()+"/dataset-name.txt");
        exec("mv "+getFilesDir()+"/Database_g2.dat "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_g.txt");
        exec("mv "+getFilesDir()+"/Database_s2.dat "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_s.txt");


        exec("mv "+getFilesDir()+File.separator+"openbabel/xyz "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
        exec("mv "+getFilesDir()+File.separator+"openbabel/smiles "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
        exec("mv "+getFilesDir()+File.separator+"openbabel/gas "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
        exec("mv "+getFilesDir()+File.separator+"openbabel/solv "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
        exec("mv "+getFilesDir()+File.separator+"openbabel/iupac "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
        exec("mv "+getFilesDir()+File.separator+"openbabel/formula "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
        exec("mv "+getFilesDir()+File.separator+"openbabel/damping_factor "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
        exec("mv "+getFilesDir()+File.separator+"openbabel/kinetics "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
        exec("mv "+getFilesDir()+File.separator+"openbabel/tautomers "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");

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



    public void dataset_view(final String dataset_str) {
        Runnable dataset_proc = new Runnable() {
            public void run() {
                dataset.setText(dataset_str);
            }
        };
        handler.post(dataset_proc);
    }

    public void temperature_view(final String temperature_str) {
        Runnable temperature_proc = new Runnable() {
            public void run() {
                temperature.setText(temperature_str);
            }
        };
        handler.post(temperature_proc);
    }

}