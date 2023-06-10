package cz.p;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

import java.io.BufferedOutputStream;
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
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION;


public class MainActivity extends AppCompatActivity {

    // very important - each code must be different!!!
    private static final int MY_PERMISSION_REQUEST_STORAGE = 1;
//    private static final int MANAGE_ALL_FILES_ACCESS_PERMISSION = 2;
    private Uri documentUri1;
    private Uri documentUri2;
    private Uri documentUri3;
    private Uri documentUri4;
    private Uri documentUri5;
    private TextView outputView;
    private EditText outputView2;
    private EditText outputView4;
    private TextView ModifyLabel;
    private TextView ModifyLabel2;
    private Handler handler = new Handler();
    private boolean isCanceled;
    Button start_openbabel;
    Button start_opsin;
    Button start_phreeqc;
    Button start_fastchem;
    Button start_convert;
    private static final int READ_FILE10 = 10;
    private Uri documentUri10;
    private TextView dataset_label;
    private EditText dataset;
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
    Button start_cp2k;
    TextView label0;
    TextView label1;
    TextView label2;
    TextView label100;
    TextView label101;
    TextView label3;
    TextView label4;
    TextView label5;
    TextView label_kin;
    Button start_mopac_chemsol_mulliken;
    Button start_mopac_chemsol_esp;
    Button start_mopac;
    Button start_chemsol;
    Button start_obabel;
    Button start_empirical;
    Button start_empirical_kin;
    TextView labelKin;
    TextView temperature_label;
    EditText temperature;
    Button start_kin11;
    Button start_kin12;
    Button start_kin22;
    Button start_kin23;
    Button start_kin;
    Button start_editor;
    Button start_editor_int;
    Button custom_export;
    Button custom_import;
    Button delete_file;
    Button Licenses;
    Button manual_phreeqc_plus;
//    TextView label_cp2k_all;
//    Button start_cp2k_all;
    TextView label_dftb_all;
    Button start_dftb_all;
    Button start_dftb;


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

        start_editor = (Button) findViewById(R.id.start_editor);
        start_editor_int = (Button) findViewById(R.id.start_editor_int);

        About = (Button) findViewById(R.id.About);
        About.setOnClickListener(onAboutClick);

        label0 = (TextView) findViewById(R.id.label0);
        label1 = (TextView) findViewById(R.id.label1);
        label2 = (TextView) findViewById(R.id.label2);
        label3 = (TextView) findViewById(R.id.label3);
        label4 = (TextView) findViewById(R.id.label4);
        label5 = (TextView) findViewById(R.id.label5);
        label100 = (TextView) findViewById(R.id.label100);
        label101 = (TextView) findViewById(R.id.label101);
        label_kin = (TextView) findViewById(R.id.label_kin);

        custom_export = (Button) findViewById(R.id.custom_export);

        custom_import = (Button) findViewById(R.id.custom_import);
        custom_import.setOnClickListener(custom_importClick);

        delete_file = (Button) findViewById(R.id.delete_file);
//        delete_file.setOnClickListener(onDeleteClick);

        labelKin = (TextView) findViewById(R.id.labelKin);
        temperature_label = (TextView) findViewById(R.id.temperature_label);
        temperature = (EditText) findViewById((R.id.temperature));
        start_kin11 = (Button) findViewById(R.id.start_kin11);
        start_kin12 = (Button) findViewById(R.id.start_kin12);
        start_kin22 = (Button) findViewById(R.id.start_kin22);
        start_kin23 = (Button) findViewById(R.id.start_kin23);
        start_kin = (Button) findViewById(R.id.start_kin);
        manual_phreeqc_plus = (Button) findViewById(R.id.manual_phreeqc_plus);
//        label_cp2k_all = (TextView) findViewById(R.id.label_cp2k_all);
        label_dftb_all = (TextView) findViewById(R.id.label_dftb_all);

        start_opsin = (Button) findViewById(R.id.start_opsin);
        start_opsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DatasetName0 = dataset.getText().toString();
                String DatasetName1 = DatasetName0.replace(" ","_");
                String DatasetName = DatasetName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, Opsin.class);
                startActivity(intent);
            }
        });

        start_dftb = (Button) findViewById(R.id.start_dftb);
        start_dftb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DatasetName0 = dataset.getText().toString();
                String DatasetName1 = DatasetName0.replace(" ","_");
                String DatasetName = DatasetName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, Dftb.class);
                startActivity(intent);
            }
        });

//        start_cp2k_all = (Button) findViewById(R.id.start_cp2k_all);
//        start_cp2k_all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String DatasetName0 = dataset.getText().toString();
//                String DatasetName1 = DatasetName0.replace(" ","_");
//                String DatasetName = DatasetName1.replace(",",".");
//                try {
//                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(DatasetName);
//                    outputWriter.close();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                Intent intent = new Intent(MainActivity.this, Cp2k1.class);
//                startActivity(intent);
//            }
//        });

        start_dftb_all = (Button) findViewById(R.id.start_dftb_all);
        start_dftb_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DatasetName0 = dataset.getText().toString();
                String DatasetName1 = DatasetName0.replace(" ","_");
                String DatasetName = DatasetName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, Dftb1.class);
                startActivity(intent);
            }
        });

//        start_cp2k = (Button) findViewById(R.id.start_cp2k);
//        start_cp2k.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String DatasetName0 = dataset.getText().toString();
//                String DatasetName1 = DatasetName0.replace(" ","_");
//                String DatasetName = DatasetName1.replace(",",".");
//                try {
//                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(DatasetName);
//                    outputWriter.close();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                Intent intent = new Intent(MainActivity.this, Cp2k.class);
//                startActivity(intent);
//            }
//        });

        manual_phreeqc_plus = (Button) findViewById(R.id.manual_phreeqc_plus);
        manual_phreeqc_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DatasetName0 = dataset.getText().toString();
                String DatasetName1 = DatasetName0.replace(" ","_");
                String DatasetName = DatasetName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, ManualPHREEQCplus.class);
                startActivity(intent);
            }
        });


        start_kin = (Button) findViewById(R.id.start_kin);
        start_kin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GeneralInit.b "+getFilesDir()+"/GeneralInit.bas");
                exec("chmod -R 755 "+getFilesDir()+"/GeneralInit.b");
                exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GeneralInit.b");

                Intent intent = new Intent(MainActivity.this, KineticsQuery.class);
                startActivity(intent);
            }
        });

        start_empirical = (Button) findViewById(R.id.start_empirical);
        start_empirical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this, Empirical.class);
                startActivity(intent);
            }
        });

        start_empirical_kin = (Button) findViewById(R.id.start_empirical_kin);
        start_empirical_kin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this, EmpiricalKin.class);
                startActivity(intent);
            }
        });


//        export_file = (Button) findViewById(R.id.export_file);
//        export_file.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(MainActivity.this, ExportFile.class);
//                startActivity(intent);
//            }
//        });

        custom_export = (Button) findViewById(R.id.custom_export);
        custom_export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomExport.class);
                startActivity(intent);
            }
        });

        delete_file = (Button) findViewById(R.id.delete_file);
        delete_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeleteFile.class);
                startActivity(intent);
            }
        });

        Licenses = (Button) findViewById(R.id.Licenses);
        Licenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Licenses.class);
                startActivity(intent);
            }
        });

        start_openbabel = (Button) findViewById(R.id.start_openbabel);
        start_openbabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");

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

        start_fastchem = (Button) findViewById(R.id.start_fastchem);
        start_fastchem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Fastchem.class);
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

        start_editor = (Button) findViewById(R.id.start_editor);
        start_editor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditExternalFile.class);
                startActivity(intent);
            }
        });

        start_editor_int = (Button) findViewById(R.id.start_editor_int);
        start_editor_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditInternalFile.class);
                startActivity(intent);
            }
        });

        start_convert = (Button) findViewById(R.id.start_convert);
        start_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("dataset-name.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(DatasetName);
                    outputWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this, ConvertDialog.class);
                startActivity(intent);
            }
        });

        start_bulk = (Button) findViewById(R.id.start_bulk);
        start_bulk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");

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

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");

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

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");

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

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
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

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
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

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
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

                String DatasetName0 = dataset.getText().toString();
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
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




        // give the app permissions to access the storage
        {
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST_STORAGE);

                } else {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST_STORAGE);
                }
                ;
            } else {
                // do nothing
            }
            ;
        }

        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        SharedPreferences.Editor editor = wmbPreference.edit();

        if (isFirstRun){

            // just already here - otherwise it will not appear during the first run
            copyFromAssetsToInternalStorage("dataset-name.txt");
            // without this file the kinetics calculations would not work
            copyFromAssetsToInternalStorage("temperature.txt");

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Please wait...");
            progressDialog.setMessage("Installing PHREEQC plus. It may take a while.");
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

            // Code to run once

            exec("mkdir "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+"/phreeqc_plus");


                    File Path000 = new File(getFilesDir()+"/output");
                    File Path00 = new File(getFilesDir()+"/bulk_conversion");
                    File Path01 = new File(getFilesDir()+"/chemsol");
                    File Path02 = new File(getFilesDir()+"/database");
                    File Path03 = new File(getFilesDir()+"/mopac");
                    File Path04 = new File(getFilesDir()+"/obabel");
                    File Path05 = new File(getFilesDir()+"/phreeqc_work");
                    File Path06 = new File(getFilesDir()+"/LIQUIDS");
                    File Path07 = new File(getFilesDir()+"/PHASES");
                    File Path08 = new File(getFilesDir()+"/SOLIDS");
                    File Path09 = new File(getFilesDir()+"/SOLUTION_SPECIES");
                    File Path10 = new File(getFilesDir()+"/output/atmospheric-profiles");
                    File Path11 = new File(getFilesDir()+"/output/damping_factor");
                    File Path12 = new File(getFilesDir()+"/output/element-abundances");
                    File Path13 = new File(getFilesDir()+"/output/fastchem_datasets");
                    File Path14 = new File(getFilesDir()+"/output/formula");
                    File Path15 = new File(getFilesDir()+"/output/iupac");
                    File Path16 = new File(getFilesDir()+"/output/kinetics");
                    File Path17 = new File(getFilesDir()+"/output/phreeqc_datasets");
                    File Path18 = new File(getFilesDir()+"/output/smiles");
//            File Path19 = new File(getFilesDir()+"/output/chemsol");
                    File Path20 = new File(getFilesDir()+"/output/xyz");
                    File Path21 = new File(getFilesDir()+"/output/gas");
                    File Path22 = new File(getFilesDir()+"/output/gas/opt");
                    File Path23 = new File(getFilesDir()+"/output/gas/opt/results");
                    File Path24 = new File(getFilesDir()+"/output/gas/thermo");
                    File Path25 = new File(getFilesDir()+"/output/gas/thermo/results");
                    File Path26 = new File(getFilesDir()+"/output/solv");
                    File Path27 = new File(getFilesDir()+"/output/solv/opt");
                    File Path28 = new File(getFilesDir()+"/output/solv/opt/results");
                    File Path29 = new File(getFilesDir()+"/output/solv/thermo");
                    File Path30 = new File(getFilesDir()+"/output/solv/thermo/results");
                    File Path31 = new File(getFilesDir()+"/openbabel");
                    File Path32 = new File(getFilesDir()+"/openbabel/formula");
                    File Path33 = new File(getFilesDir()+"/openbabel/damping_factor");
                    File Path34 = new File(getFilesDir()+"/openbabel/iupac");
                    File Path35 = new File(getFilesDir()+"/openbabel/kinetics");
                    File Path36 = new File(getFilesDir()+"/openbabel/smiles");
                    File Path37 = new File(getFilesDir()+"/openbabel/xyz");
                    File Path38 = new File(getFilesDir()+"/openbabel/gas");
                    File Path39 = new File(getFilesDir()+"/openbabel/gas/opt");
                    File Path40 = new File(getFilesDir()+"/openbabel/gas/opt/results");
                    File Path41 = new File(getFilesDir()+"/openbabel/gas/thermo");
                    File Path42 = new File(getFilesDir()+"/openbabel/gas/thermo/results");
                    File Path43 = new File(getFilesDir()+"/openbabel/solv");
                    File Path44 = new File(getFilesDir()+"/openbabel/solv/opt");
                    File Path45 = new File(getFilesDir()+"/openbabel/solv/opt/results");
                    File Path46 = new File(getFilesDir()+"/openbabel/solv/thermo");
                    File Path47 = new File(getFilesDir()+"/openbabel/solv/thermo/results");
                    File Path48 = new File(getFilesDir()+"/openbabel/tautomers");
                    File Path49 = new File(getFilesDir()+"/output/tautomers");
                    // due to phreeqc-prepare
                    File Path50 = new File(getFilesDir()+"/work");
                    File Path51 = new File(getFilesDir()+"/PSEUDOPHASES");
                    File Path52 = new File(getFilesDir()+"/docs");
                    File Path53 = new File(getFilesDir()+"/GCM1");
                    File Path54 = new File(getFilesDir()+"/GCM2");
                    File Path55 = new File(getFilesDir()+"/GCM3");
                    File Path56 = new File(getFilesDir()+"/GCM4");
                    File Path57 = new File(getFilesDir()+"/openbabel/liq");
                    File Path58 = new File(getFilesDir()+"/openbabel/cryst");
//            File Path59 = new File(getFilesDir()+"/openbabel/solv");
                    File Path60 = new File(getFilesDir()+"/output/cryst");
                    File Path61 = new File(getFilesDir()+"/output/liq");
//            File Path62 = new File(getFilesDir()+"/cp2k");
//            File Path63 = new File(getFilesDir()+"/basis");
//            File Path64 = new File(getFilesDir()+"/basis/DFTB");
//            File Path65 = new File(getFilesDir()+"/basis/DFTB/nonscc");
//            File Path66 = new File(getFilesDir()+"/basis/DFTB/scc");
//            File Path67 = new File(getFilesDir()+"/basis/xc_section");
                    File Path68 = new File(getFilesDir()+"/dftb");
                    File Path69 = new File(getFilesDir()+"/sk_files");
                    File Path70 = new File(getFilesDir()+"/reference");
                    try {
                        if (!Path00.exists()) {
                            Path00.mkdirs();
                        }
                        if (!Path000.exists()) {
                            Path000.mkdirs();
                        }
                        if (!Path01.exists()) {
                            Path01.mkdirs();
                        }
                        if (!Path02.exists()) {
                            Path02.mkdirs();
                        }
                        if (!Path03.exists()) {
                            Path03.mkdirs();
                        }
                        if (!Path04.exists()) {
                            Path04.mkdirs();
                        }
                        if (!Path05.exists()) {
                            Path05.mkdirs();
                        }
                        if (!Path06.exists()) {
                            Path06.mkdirs();
                        }
                        if (!Path07.exists()) {
                            Path07.mkdirs();
                        }
                        if (!Path08.exists()) {
                            Path08.mkdirs();
                        }
                        if (!Path09.exists()) {
                            Path09.mkdirs();
                        }
                        if (!Path10.exists()) {
                            Path10.mkdirs();
                        }
                        if (!Path11.exists()) {
                            Path11.mkdirs();
                        }
                        if (!Path12.exists()) {
                            Path12.mkdirs();
                        }
                        if (!Path13.exists()) {
                            Path13.mkdirs();
                        }
                        if (!Path14.exists()) {
                            Path14.mkdirs();
                        }
                        if (!Path15.exists()) {
                            Path15.mkdirs();
                        }
                        if (!Path16.exists()) {
                            Path16.mkdirs();
                        }
                        if (!Path17.exists()) {
                            Path17.mkdirs();
                        }
                        if (!Path18.exists()) {
                            Path18.mkdirs();
                        }
//                if (!Path19.exists()) {
//                    Path19.mkdirs();
//                }
                        if (!Path20.exists()) {
                            Path20.mkdirs();
                        }
                        if (!Path21.exists()) {
                            Path21.mkdirs();
                        }
                        if (!Path22.exists()) {
                            Path22.mkdirs();
                        }
                        if (!Path23.exists()) {
                            Path23.mkdirs();
                        }
                        if (!Path24.exists()) {
                            Path24.mkdirs();
                        }
                        if (!Path25.exists()) {
                            Path25.mkdirs();
                        }
                        if (!Path26.exists()) {
                            Path26.mkdirs();
                        }
                        if (!Path27.exists()) {
                            Path27.mkdirs();
                        }
                        if (!Path28.exists()) {
                            Path28.mkdirs();
                        }
                        if (!Path29.exists()) {
                            Path29.mkdirs();
                        }
                        if (!Path30.exists()) {
                            Path30.mkdirs();
                        }
                        if (!Path31.exists()) {
                            Path31.mkdirs();
                        }
                        if (!Path32.exists()) {
                            Path32.mkdirs();
                        }
                        if (!Path33.exists()) {
                            Path33.mkdirs();
                        }
                        if (!Path34.exists()) {
                            Path34.mkdirs();
                        }
                        if (!Path35.exists()) {
                            Path35.mkdirs();
                        }
                        if (!Path36.exists()) {
                            Path36.mkdirs();
                        }
                        if (!Path37.exists()) {
                            Path37.mkdirs();
                        }
                        if (!Path38.exists()) {
                            Path38.mkdirs();
                        }
                        if (!Path39.exists()) {
                            Path39.mkdirs();
                        }
                        if (!Path40.exists()) {
                            Path40.mkdirs();
                        }
                        if (!Path41.exists()) {
                            Path41.mkdirs();
                        }
                        if (!Path42.exists()) {
                            Path42.mkdirs();
                        }
                        if (!Path43.exists()) {
                            Path43.mkdirs();
                        }
                        if (!Path44.exists()) {
                            Path44.mkdirs();
                        }
                        if (!Path45.exists()) {
                            Path45.mkdirs();
                        }
                        if (!Path46.exists()) {
                            Path46.mkdirs();
                        }
                        if (!Path47.exists()) {
                            Path47.mkdirs();
                        }
                        if (!Path48.exists()) {
                            Path48.mkdirs();
                        }
                        if (!Path49.exists()) {
                            Path49.mkdirs();
                        }
                        if (!Path50.exists()) {
                            Path50.mkdirs();
                        }
                        if (!Path51.exists()) {
                            Path51.mkdirs();
                        }
                        if (!Path52.exists()) {
                            Path52.mkdirs();
                        }
                        if (!Path53.exists()) {
                            Path53.mkdirs();
                        }
                        if (!Path54.exists()) {
                            Path54.mkdirs();
                        }
                        if (!Path55.exists()) {
                            Path55.mkdirs();
                        }
                        if (!Path56.exists()) {
                            Path56.mkdirs();
                        }
                        if (!Path57.exists()) {
                            Path57.mkdirs();
                        }
                        if (!Path58.exists()) {
                            Path58.mkdirs();
                        }
//                if (!Path59.exists()) {
//                    Path59.mkdirs();
//                }
                        if (!Path60.exists()) {
                            Path60.mkdirs();
                        }
                        if (!Path61.exists()) {
                            Path61.mkdirs();
                        }
//                if (!Path62.exists()) {
//                    Path62.mkdirs();
//                }
//                if (!Path63.exists()) {
//                    Path63.mkdirs();
//                }
//                if (!Path64.exists()) {
//                    Path64.mkdirs();
//                }
//                if (!Path65.exists()) {
//                    Path65.mkdirs();
//                }
//                if (!Path66.exists()) {
//                    Path66.mkdirs();
//                }
//                if (!Path67.exists()) {
//                    Path67.mkdirs();
//                }
                        if (!Path68.exists()) {
                            Path68.mkdirs();
                        }
                        if (!Path69.exists()) {
                            Path69.mkdirs();
                        }
                        if (!Path70.exists()) {
                            Path70.mkdirs();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    copyFromAssetsToInternalStorage("assets.zip");
                    String zipFilePath = getFilesDir()+"/assets.zip";
                    String destDir = getFilesDir()+"/" ;
                    try {
                        unzip(new File(zipFilePath),destDir);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    exec("rm "+getFilesDir()+"/assets.zip");
                    exec("chmod -R 755 "+getFilesDir()+"/");

            onFinish();
        }
        public void onFinish(){
            progressDialog.dismiss();
        }
    }.start();

            editor.putBoolean("FIRSTRUN", false);
            editor.apply();
        }
        // here it must not be!!! otherwise ShellTools crashes
//        onStart();


    }




    @Override
    public void onStart()
    {
        super.onStart();
        dataset_view(exec("cat "+getFilesDir()+"/dataset-name.txt"));
        temperature_view(exec("cat "+getFilesDir()+"/temperature.txt"));
    }


//    private View.OnClickListener onExportClick; {
//
//        onExportClick = new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub //
//                exec("mv "+getFilesDir()+"/phreeqc_plus "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/chemsol "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/fastchem "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/mopac "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/openbabel "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/phreeqc_datasets "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/phreeqc_work "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/LICENSE-FASTCHEM.txt "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/LICENSE-LAPACK.txt "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/LICENSE-MOPAC.txt "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/LICENSE-OPENBABEL.txt "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/LICENSE-TRANSPOSE.txt "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/LICENSE-X11-BASIC.txt "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/LICENSE1-GMP.txt "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/LICENSE2-GMP.txt "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/LICENSING_TERMS-PHREEQC.txt "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("mv "+getFilesDir()+"/phreeqc_plus/LICENSING_TERMS-X11-BASIC.txt "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus");
////                exec("rm -rf "+getFilesDir()+"/phreeqc_plus");
//
//            }
//        };
//    }

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
//        try {
//
//            String Raw_g = exec("cat "+getFilesDir()+"/PHASES/Database_g.dat");
//            while (Raw_g.contains("= + e- =")){  //2 spaces
//                Raw_g = Raw_g.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
//            }
//            while (Raw_g.contains("=  + e- =")){  //2 spaces
//                Raw_g = Raw_g.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
//            }
//            FileOutputStream fileout115 = openFileOutput("Database_g1.dat",MODE_PRIVATE);
//            OutputStreamWriter outputWriter115 = new OutputStreamWriter(fileout115);
//            outputWriter115.write(Raw_g);
//            outputWriter115.close();
//
//            String Raw_g2 = exec("cat "+getFilesDir()+"/Database_g1.dat");
//            while (Raw_g2.contains("(g) ;  = ")){  //2 spaces
//                Raw_g2 = Raw_g2.replace("(g) ;  = ", ""); //(2 spaces, 1 space)
//            }
//            FileOutputStream fileout215 = openFileOutput("Database_g2.dat",MODE_PRIVATE);
//            OutputStreamWriter outputWriter215 = new OutputStreamWriter(fileout215);
//            outputWriter215.write(Raw_g2);
//            outputWriter215.close();
//
//
//            String Raw_s = exec("cat "+getFilesDir()+"/SOLUTION_SPECIES/Database_s.dat");
//            while (Raw_s.contains("= + e- =")){  //2 spaces
//                Raw_s = Raw_s.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
//            }
//            while (Raw_s.contains("=  + e- =")){  //2 spaces
//                Raw_s = Raw_s.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
//            }
//            FileOutputStream fileout315 = openFileOutput("Database_s1.dat",MODE_PRIVATE);
//            OutputStreamWriter outputWriter315 = new OutputStreamWriter(fileout315);
//            outputWriter315.write(Raw_s);
//            outputWriter315.close();
//
//            String Raw_s2 = exec("cat "+getFilesDir()+"/Database_s1.dat");
//            while (Raw_s2.contains("(g) ;  = ")){  //2 spaces
//                Raw_s2 = Raw_s2.replace("(g) ;  = ", ""); //(2 spaces, 1 space)
//            }
//            FileOutputStream fileout415 = openFileOutput("Database_s2.dat",MODE_PRIVATE);
//            OutputStreamWriter outputWriter415 = new OutputStreamWriter(fileout415);
//            outputWriter415.write(Raw_s2);
//            outputWriter415.close();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

// tyhle dva bloky jsou snad uz ted opravdu k nicemu a spis skodi - po skonceni vypoctu prepisuji existujici soubory prazdnymi - ale treba overit, prezkouset vsechny funkce

//        String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
//		String DatasetName1 = DatasetName0.replace(" ","_");
//		String DatasetName = DatasetName1.replace(",",".");
//        exec("mv "+getFilesDir()+"/Database_g2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_g.txt");
//        exec("chmod -R 755 "+getFilesDir()+"/PHASES");
//        exec("mv "+getFilesDir()+"/PHASES/Fastchem_g.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+DatasetName+"_g.txt");
//        exec("mv "+getFilesDir()+"/Database_s2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_s.txt");


//        exec("mv "+getFilesDir()+File.separator+"openbabel/xyz "+getFilesDir()+File.separator+"output");
//        exec("mv "+getFilesDir()+File.separator+"openbabel/smiles "+getFilesDir()+File.separator+"output");
//        exec("mv "+getFilesDir()+File.separator+"openbabel/gas "+getFilesDir()+File.separator+"output");
//        exec("mv "+getFilesDir()+File.separator+"openbabel/solv "+getFilesDir()+File.separator+"output");
//        exec("mv "+getFilesDir()+File.separator+"openbabel/iupac "+getFilesDir()+File.separator+"output");
//        exec("mv "+getFilesDir()+File.separator+"openbabel/formula "+getFilesDir()+File.separator+"output");
//        exec("mv "+getFilesDir()+File.separator+"openbabel/damping_factor "+getFilesDir()+File.separator+"output");
//        exec("mv "+getFilesDir()+File.separator+"openbabel/kinetics "+getFilesDir()+File.separator+"output");
//        exec("mv "+getFilesDir()+File.separator+"openbabel/tautomers "+getFilesDir()+File.separator+"output");
//        exec("rm -rf "+getFilesDir()+"/openbabel");


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



    private View.OnClickListener custom_importClick; {

        custom_importClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read10(getApplicationContext());
            }
        };
    }

    private void read10(Context context10) {
        Intent intent10 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent10.addCategory(Intent.CATEGORY_OPENABLE);
        intent10.setType("text/plain");
        startActivityForResult(intent10, READ_FILE10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE10 && data != null) {
            // open atmospheric profile file
            try {
                documentUri10 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd10 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd10.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("ImportedFile.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd10.close();
                Toast.makeText(getApplicationContext(), "File read successfully.", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this, CustomImport.class);
                startActivity(intent);



            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

}

    protected void copyFromAssetsToInternalStorage(String filename){
        AssetManager assetManager = getAssets();

        try {
            InputStream input = assetManager.open(filename);
            OutputStream output = openFileOutput(filename, Context.MODE_PRIVATE);

            copyFile(input, output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    public static void unzip(File source, String out) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(source))) {

            ZipEntry entry = zis.getNextEntry();

            while (entry != null) {

                File file = new File(out, entry.getName());

                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    File parent = file.getParentFile();

                    if (!parent.exists()) {
                        parent.mkdirs();
                    }

                    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {

                        int bufferSize = Math.toIntExact(entry.getSize());
                        byte[] buffer = new byte[bufferSize > 0 ? bufferSize : 1];
                        int location;

                        while ((location = zis.read(buffer)) != -1) {
                            bos.write(buffer, 0, location);
                        }
                    }
                }
                entry = zis.getNextEntry();
            }
        }
    }



}
