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
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BulkConversion extends MainActivity {

    private Handler handler = new Handler();
    public TextView method_label;
    public EditText method;
    public TextView solvation_label;
    public EditText solvation;
    public TextView keywords_label;
    public EditText keywords;
    public Button openbabel_exit;
    public Button openbabel_select;
    public Button quit;
    public EditText BulkView;
    private static final int READ_FILE100 = 100;
    private Uri documentUri100;
    public Button help_bulk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulkconversion);

        method_label = (TextView) findViewById(R.id.method_label);
        method = (EditText) findViewById(R.id.method);
        solvation_label = (TextView) findViewById(R.id.solvation_label);
        solvation = (EditText) findViewById(R.id.solvation);
        keywords_label = (TextView) findViewById(R.id.keywords_label);
        keywords = (EditText) findViewById(R.id.keywords);
        openbabel_select = (Button) findViewById(R.id.openbabel_select);
        openbabel_select.setOnClickListener(openbabel_select_click);
        openbabel_exit = (Button) findViewById(R.id.openbabel_exit);
        openbabel_exit.setOnClickListener(openbabel_exit_click);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(quit_click);
        BulkView = (EditText) findViewById(R.id.BulkView);
        help_bulk = (Button) findViewById(R.id.help_bulk);
        help_bulk.setOnClickListener(help_bulkClick);

    }

    public void onStart()
    {
        super.onStart();

        File filePath100 = new File(getFilesDir()+File.separator+"bulk_conversion");
        if (!filePath100.exists()) {
            filePath100.mkdirs();
        }

        method_view(exec("cat "+getFilesDir()+"/method.txt"));
        solvation_view(exec("cat "+getFilesDir()+"/solvation.txt"));
        keywords_view(exec("cat "+getFilesDir()+"/keywords.txt"));
        output100(exec("ls -l "+getFilesDir()+"/bulk_conversion"));
    }

    private View.OnClickListener help_bulkClick; {
        help_bulkClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert_bulk();
            }
        };
    }

    public void alert_bulk() {
        new AlertDialog.Builder(BulkConversion.this)
                .setTitle("Input format description")
                .setMessage(exec("cat "+getFilesDir()+"/BulkFormat.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener openbabel_select_click; {

        openbabel_select_click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                read100(getApplicationContext());
                output100(exec("ls -l "+getFilesDir()+"/bulk_conversion"));
            }
        };
    }

    private void read100(Context context100) {
        Intent intent100 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent100.addCategory(Intent.CATEGORY_OPENABLE);
        intent100.setType("text/plain");
        startActivityForResult(intent100, READ_FILE100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE100 && data != null) {
            try {

                documentUri100 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd100 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd100.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("BulkConversion.tmp", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd100.close();

                String Sed100 = exec("sed -n 6p "+getFilesDir()+"/BulkConversion.tmp");
                String BulkConvName1 = Sed100.replace(" ","_");
		String BulkConvName = BulkConvName1.replace(",",".");
                exec("mv "+getFilesDir()+"/BulkConversion.tmp "+getFilesDir()+"/bulk_conversion/"+BulkConvName);


            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private View.OnClickListener openbabel_continue_click; {

        openbabel_continue_click = new View.OnClickListener() {
            public void onClick(View v) {

            }
        };
    }

    public void method_view(final String method_str) {
        Runnable method_proc = new Runnable() {
            public void run() {
                method.setText(method_str);
            }
        };
        handler.post(method_proc);
    }

    public void solvation_view(final String solvation_str) {
        Runnable solvation_proc = new Runnable() {
            public void run() {
                solvation.setText(solvation_str);
            }
        };
        handler.post(solvation_proc);
    }

    public void keywords_view(final String keywords_str) {
        Runnable keywords_proc = new Runnable() {
            public void run() {
                keywords.setText(keywords_str);
            }
        };
        handler.post(keywords_proc);
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

    private View.OnClickListener openbabel_exit_click; {

        openbabel_exit_click = new View.OnClickListener() {
            public void onClick(View v) {

                String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");

                progressDialog = new ProgressDialog(BulkConversion.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Performing MOPAC calculations on species contained in dataset: "+DatasetName0);
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

                        String Methodfile = method.getText().toString();
                        String Solvationfile = solvation.getText().toString();
                        String Keywordsfile = keywords.getText().toString();

                        File filePath = new File(getFilesDir()+File.separator+"openbabel");
                        try {
                            if (!filePath.exists()) {
                                filePath.mkdirs();
                            }

                            FileOutputStream fileout2 = openFileOutput("method.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(Methodfile);
                            outputWriter2.close();

                            FileOutputStream fileout5 = openFileOutput("solvation.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter5 = new OutputStreamWriter(fileout5);
                            outputWriter5.write(Solvationfile);
                            outputWriter5.close();

                            FileOutputStream fileout6 = openFileOutput("keywords.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                            outputWriter6.write(Keywordsfile);
                            outputWriter6.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }




//                        File[] inputfiles = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"bulk_conversion").listFiles();
                        File[] inputfiles = new File(getFilesDir()+File.separator+"bulk_conversion").listFiles();
                        for (File file : inputfiles) {
                            if (!file.isFile()) continue;
                        try {
                            String InputfileName = file.getName();
                            FileOutputStream fileout200 = openFileOutput(InputfileName+".iupac", MODE_PRIVATE);
                            OutputStreamWriter outputWriter200 = new OutputStreamWriter(fileout200);
                            outputWriter200.write(InputfileName);
                            outputWriter200.close();

//                            exec("mv "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"phreeqc_plus"+File.separator+"bulk_conversion"+File.separator+InputfileName+" "+getFilesDir()+"/"+InputfileName+".orig");
                            exec("mv "+getFilesDir()+File.separator+"bulk_conversion"+File.separator+InputfileName+" "+getFilesDir()+"/"+InputfileName+".orig");

                            String Formula0 = exec("sed -n 1p "+getFilesDir()+"/"+InputfileName+".orig");
                            FileOutputStream fileout1007 = openFileOutput(InputfileName+".formula0", MODE_PRIVATE);
                            OutputStreamWriter outputWriter1007 = new OutputStreamWriter(fileout1007);
                            outputWriter1007.write(Formula0);
                            outputWriter1007.close();

                            String Formula1 = exec("cat "+getFilesDir()+"/"+InputfileName+".formula0");
                            String Formula = Formula1.replaceAll("\\r", "").replaceAll("\\n", ""); // timhle se odstrani konec radku spolehlive
                            FileOutputStream fileout1008 = openFileOutput(InputfileName+".formula", MODE_PRIVATE);
                            OutputStreamWriter outputWriter1008 = new OutputStreamWriter(fileout1008);
                            outputWriter1008.write(Formula);
                            outputWriter1008.close();

                            exec("chmod 755 -R "+getFilesDir());
                            String KeyWithoutSolv = Methodfile+" "+Keywordsfile;
                            String KeyWithSolv = Methodfile+" "+Keywordsfile+" "+Solvationfile;
                            File filePath1 = new File(getFilesDir()+File.separator+"openbabel/gas/opt");
                            try {
                                if (!filePath1.exists()) {
                                    filePath1.mkdirs();
                                }
                                String Coordinates = exec("sed -e 1,7d "+getFilesDir()+"/"+InputfileName+".orig");
                                FileOutputStream fileout7 = openFileOutput(InputfileName+".mop", MODE_PRIVATE);
                                OutputStreamWriter outputWriter7 = new OutputStreamWriter(fileout7);
                                outputWriter7.write(KeyWithoutSolv);
                                outputWriter7.write("\n");
                                outputWriter7.write("\n");
                                outputWriter7.write("\n");
                                outputWriter7.write(Coordinates);
                                outputWriter7.close();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+File.separator+"openbabel/gas/opt/"+InputfileName);


                            File filePath2 = new File(getFilesDir()+File.separator+"openbabel/solv/opt");
                            try {
                                if (!filePath2.exists()) {
                                    filePath2.mkdirs();
                                }
                                String Coordinates2 = exec("sed -e 1,7d "+getFilesDir()+"/"+InputfileName+".orig");
                                FileOutputStream fileout8 = openFileOutput(InputfileName+".mop", MODE_PRIVATE);
                                OutputStreamWriter outputWriter8 = new OutputStreamWriter(fileout8);
                                outputWriter8.write(KeyWithSolv);
                                outputWriter8.write("\n");
                                outputWriter8.write("\n");
                                outputWriter8.write("\n");
                                outputWriter8.write(Coordinates2);
                                outputWriter8.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+File.separator+"openbabel/solv/opt/"+InputfileName);

                            exec("rm "+getFilesDir()+"/"+InputfileName+".orig ");

                            File filePath5 = new File(getFilesDir()+File.separator+"openbabel/iupac");
                            try {
                                if (!filePath5.exists()) {
                                    filePath5.mkdirs();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            exec("mv "+getFilesDir()+"/"+InputfileName+".iupac "+getFilesDir()+File.separator+"openbabel/iupac");

                            File filePath7 = new File(getFilesDir()+File.separator+"openbabel/formula");
                            try {
                                if (!filePath7.exists()) {
                                    filePath7.mkdirs();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            exec("mv "+getFilesDir()+"/"+InputfileName+".formula "+getFilesDir()+File.separator+"openbabel/formula");

                            method_view(exec("cat "+getFilesDir()+"/method.txt"));
                            solvation_view(exec("cat "+getFilesDir()+"/solvation.txt"));
                            keywords_view(exec("cat "+getFilesDir()+"/keywords.txt"));

                        } catch (Exception e) {
                        }

                        }




                        File filePath6 = new File(getFilesDir()+File.separator+"openbabel/gas/opt/results");
                        try {
                            if (!filePath6.exists()) {
                                filePath6.mkdirs();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        File filePath8 = new File(getFilesDir()+File.separator+"openbabel/gas/thermo/results");
                        try {
                            if (!filePath8.exists()) {
                                filePath8.mkdirs();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        File filePath9 = new File(getFilesDir()+File.separator+"openbabel/solv/opt/results");
                        try {
                            if (!filePath9.exists()) {
                                filePath9.mkdirs();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        File filePath10 = new File(getFilesDir()+File.separator+"openbabel/solv/thermo/results");
                        try {
                            if (!filePath10.exists()) {
                                filePath10.mkdirs();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        File[] files = new File(getFilesDir()+"/openbabel/gas/opt").listFiles();
                        for (File file : files) {
                            if (!file.isFile()) continue;


                            String InputfileName = file.getName();
                            String Formula = exec("sed -n 1p "+getFilesDir()+"/openbabel/formula/"+InputfileName+".formula");
                            String Method = exec("cat "+getFilesDir()+"/method.txt");

                            Formula = Formula.replace(",", ".");

                            ///////////////// introduce [C], [H], [N], [O], [S], [F] to formula programatically /////////////////////////
                            //                    try {
//                    while (Formula.contains("C")){
                            Formula = Formula.replace("C", "[C]");
                            Formula = Formula.replace("[C]a", "Ca");
                            Formula = Formula.replace("[C]b", "Cb");
                            Formula = Formula.replace("[C]c", "Cc");
                            Formula = Formula.replace("[C]d", "Cd");
                            Formula = Formula.replace("[C]e", "Ce");
                            Formula = Formula.replace("[C]f", "Cf");
                            Formula = Formula.replace("[C]g", "Cg");
                            Formula = Formula.replace("[C]h", "Ch");
                            Formula = Formula.replace("[C]i", "Ci");
                            Formula = Formula.replace("[C]j", "Cj");
                            Formula = Formula.replace("[C]k", "Ck");
                            Formula = Formula.replace("[C]l", "Cl");
                            Formula = Formula.replace("[C]m", "Cm");
                            Formula = Formula.replace("[C]n", "Cn");
                            Formula = Formula.replace("[C]o", "Co");
                            Formula = Formula.replace("[C]p", "Cp");
                            Formula = Formula.replace("[C]q", "Cq");
                            Formula = Formula.replace("[C]r", "Cr");
                            Formula = Formula.replace("[C]s", "Cs");
                            Formula = Formula.replace("[C]t", "Ct");
                            Formula = Formula.replace("[C]u", "Cu");
                            Formula = Formula.replace("[C]v", "Cv");
                            Formula = Formula.replace("[C]w", "Cw");
                            Formula = Formula.replace("[C]x", "Cx");
                            Formula = Formula.replace("[C]y", "Cy");
                            Formula = Formula.replace("[C]z", "Cz");
//                    }
//                    while (Formula.contains("H")){
                            Formula = Formula.replace("H", "[H]");
                            Formula = Formula.replace("[H]a", "Ha");
                            Formula = Formula.replace("[H]b", "Hb");
                            Formula = Formula.replace("[H]c", "Hc");
                            Formula = Formula.replace("[H]d", "Hd");
                            Formula = Formula.replace("[H]e", "He");
                            Formula = Formula.replace("[H]f", "Hf");
                            Formula = Formula.replace("[H]g", "Hg");
                            Formula = Formula.replace("[H]h", "Hh");
                            Formula = Formula.replace("[H]i", "Hi");
                            Formula = Formula.replace("[H]j", "Hj");
                            Formula = Formula.replace("[H]k", "Hk");
                            Formula = Formula.replace("[H]l", "Hl");
                            Formula = Formula.replace("[H]m", "Hm");
                            Formula = Formula.replace("[H]n", "Hn");
                            Formula = Formula.replace("[H]o", "Ho");
                            Formula = Formula.replace("[H]p", "Hp");
                            Formula = Formula.replace("[H]q", "Hq");
                            Formula = Formula.replace("[H]r", "Hr");
                            Formula = Formula.replace("[H]s", "Hs");
                            Formula = Formula.replace("[H]t", "Ht");
                            Formula = Formula.replace("[H]u", "Hu");
                            Formula = Formula.replace("[H]v", "Hv");
                            Formula = Formula.replace("[H]w", "Hw");
                            Formula = Formula.replace("[H]x", "Hx");
                            Formula = Formula.replace("[H]y", "Hy");
                            Formula = Formula.replace("[H]z", "Hz");
//                    }
//                    while (Formula.contains("N")){
                            Formula = Formula.replace("N", "[N]");
                            Formula = Formula.replace("[N]a", "Na");
                            Formula = Formula.replace("[N]b", "Nb");
                            Formula = Formula.replace("[N]c", "Nc");
                            Formula = Formula.replace("[N]d", "Nd");
                            Formula = Formula.replace("[N]e", "Ne");
                            Formula = Formula.replace("[N]f", "Nf");
                            Formula = Formula.replace("[N]g", "Ng");
                            Formula = Formula.replace("[N]h", "Nh");
                            Formula = Formula.replace("[N]i", "Ni");
                            Formula = Formula.replace("[N]j", "Nj");
                            Formula = Formula.replace("[N]k", "Nk");
                            Formula = Formula.replace("[N]l", "Nl");
                            Formula = Formula.replace("[N]m", "Nm");
                            Formula = Formula.replace("[N]n", "Nn");
                            Formula = Formula.replace("[N]o", "No");
                            Formula = Formula.replace("[N]p", "Np");
                            Formula = Formula.replace("[N]q", "Nq");
                            Formula = Formula.replace("[N]r", "Nr");
                            Formula = Formula.replace("[N]s", "Ns");
                            Formula = Formula.replace("[N]t", "Nt");
                            Formula = Formula.replace("[N]u", "Nu");
                            Formula = Formula.replace("[N]v", "Nv");
                            Formula = Formula.replace("[N]w", "Nw");
                            Formula = Formula.replace("[N]x", "Nx");
                            Formula = Formula.replace("[N]y", "Ny");
                            Formula = Formula.replace("[N]z", "Nz");
//                    }
//                    while (Formula.contains("O")){
                            Formula = Formula.replace("O", "[O]");
                            Formula = Formula.replace("[O]a", "Oa");
                            Formula = Formula.replace("[O]b", "Ob");
                            Formula = Formula.replace("[O]c", "Oc");
                            Formula = Formula.replace("[O]d", "Od");
                            Formula = Formula.replace("[O]e", "Oe");
                            Formula = Formula.replace("[O]f", "Of");
                            Formula = Formula.replace("[O]g", "Og");
                            Formula = Formula.replace("[O]h", "Oh");
                            Formula = Formula.replace("[O]i", "Oi");
                            Formula = Formula.replace("[O]j", "Oj");
                            Formula = Formula.replace("[O]k", "Ok");
                            Formula = Formula.replace("[O]l", "Ol");
                            Formula = Formula.replace("[O]m", "Om");
                            Formula = Formula.replace("[O]n", "On");
                            Formula = Formula.replace("[O]o", "Oo");
                            Formula = Formula.replace("[O]p", "Op");
                            Formula = Formula.replace("[O]q", "Oq");
                            Formula = Formula.replace("[O]r", "Or");
                            Formula = Formula.replace("[O]s", "Os");
                            Formula = Formula.replace("[O]t", "Ot");
                            Formula = Formula.replace("[O]u", "Ou");
                            Formula = Formula.replace("[O]v", "Ov");
                            Formula = Formula.replace("[O]w", "Ow");
                            Formula = Formula.replace("[O]x", "Ox");
                            Formula = Formula.replace("[O]y", "Oy");
                            Formula = Formula.replace("[O]z", "Oz");
//                    }
//                    while (Formula.contains("S")){
                            Formula = Formula.replace("S", "[S]");
                            Formula = Formula.replace("[S]a", "Sa");
                            Formula = Formula.replace("[S]b", "Sb");
                            Formula = Formula.replace("[S]c", "Sc");
                            Formula = Formula.replace("[S]d", "Sd");
                            Formula = Formula.replace("[S]e", "Se");
                            Formula = Formula.replace("[S]f", "Sf");
                            Formula = Formula.replace("[S]g", "Sg");
                            Formula = Formula.replace("[S]h", "Sh");
                            Formula = Formula.replace("[S]i", "Si");
                            Formula = Formula.replace("[S]j", "Sj");
                            Formula = Formula.replace("[S]k", "Sk");
                            Formula = Formula.replace("[S]l", "Sl");
                            Formula = Formula.replace("[S]m", "Sm");
                            Formula = Formula.replace("[S]n", "Sn");
                            Formula = Formula.replace("[S]o", "So");
                            Formula = Formula.replace("[S]p", "Sp");
                            Formula = Formula.replace("[S]q", "Sq");
                            Formula = Formula.replace("[S]r", "Sr");
                            Formula = Formula.replace("[S]s", "Ss");
                            Formula = Formula.replace("[S]t", "St");
                            Formula = Formula.replace("[S]u", "Su");
                            Formula = Formula.replace("[S]v", "Sv");
                            Formula = Formula.replace("[S]w", "Sw");
                            Formula = Formula.replace("[S]x", "Sx");
                            Formula = Formula.replace("[S]y", "Sy");
                            Formula = Formula.replace("[S]z", "Sz");
//                    }
//                    while (Formula.contains("F")){
                            Formula = Formula.replace("F", "[F]");
                            Formula = Formula.replace("[F]a", "Fa");
                            Formula = Formula.replace("[F]b", "Fb");
                            Formula = Formula.replace("[F]c", "Fc");
                            Formula = Formula.replace("[F]d", "Fd");
                            Formula = Formula.replace("[F]e", "Fe");
                            Formula = Formula.replace("[F]f", "Ff");
                            Formula = Formula.replace("[F]g", "Fg");
                            Formula = Formula.replace("[F]h", "Fh");
                            Formula = Formula.replace("[F]i", "Fi");
                            Formula = Formula.replace("[F]j", "Fj");
                            Formula = Formula.replace("[F]k", "Fk");
                            Formula = Formula.replace("[F]l", "Fl");
                            Formula = Formula.replace("[F]m", "Fm");
                            Formula = Formula.replace("[F]n", "Fn");
                            Formula = Formula.replace("[F]o", "Fo");
                            Formula = Formula.replace("[F]p", "Fp");
                            Formula = Formula.replace("[F]q", "Fq");
                            Formula = Formula.replace("[F]r", "Fr");
                            Formula = Formula.replace("[F]s", "Fs");
                            Formula = Formula.replace("[F]t", "Ft");
                            Formula = Formula.replace("[F]u", "Fu");
                            Formula = Formula.replace("[F]v", "Fv");
                            Formula = Formula.replace("[F]w", "Fw");
                            Formula = Formula.replace("[F]x", "Fx");
                            Formula = Formula.replace("[F]y", "Fy");
                            Formula = Formula.replace("[F]z", "Fz");
//                    }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                            try {
                                exec("cp "+getFilesDir()+"/openbabel/gas/opt/"+InputfileName+" "+getFilesDir()+"/"+InputfileName+".mop");
                                try {
                                    exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+"/openbabel/gas/opt/results");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".arc");
                                exec("cp "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/gas/thermo/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/gas/opt/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/gas/opt/results");
                                String Sed3 = exec("sed -n 1p "+getFilesDir()+"/openbabel/gas/opt/"+InputfileName);
                                String Sed4 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/gas/thermo/results/"+InputfileName+".arc");
                                FileOutputStream fileout9 = openFileOutput(InputfileName+".mopg", MODE_PRIVATE);
                                OutputStreamWriter outputWriter9 = new OutputStreamWriter(fileout9);
                                outputWriter9.write(Sed4);
                                outputWriter9.close();
                                exec("cp "+getFilesDir()+"/"+InputfileName+".mopg "+getFilesDir()+"/openbabel/gas/thermo");
                                String Sed5 = exec("sed -e 1,3d "+getFilesDir()+"/openbabel/gas/thermo/"+InputfileName+".mopg");
                                FileOutputStream fileout10 = openFileOutput(InputfileName+".mop", MODE_PRIVATE);
                                OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                                outputWriter10.write("THERMO(298,298) LET "+Sed3);
                                outputWriter10.write("\n");
                                outputWriter10.write("\n");
                                outputWriter10.write(Sed5);
                                outputWriter10.close();
                                exec("rm "+getFilesDir()+"/openbabel/gas/thermo/"+InputfileName+".mopg");
                                exec("rm "+getFilesDir()+"/"+InputfileName+".mopg");
                                try {
                                    exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+"/openbabel/gas/thermo/results");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".arc");
                                String Grep1 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileName+".out");
                                FileOutputStream fileout11 = openFileOutput(InputfileName+"_g.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter11 = new OutputStreamWriter(fileout11);
                                outputWriter11.write(Grep1);
                                outputWriter11.close();
                                String Sed7 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileName+"_g.temp");
                                FileOutputStream fileout12 = openFileOutput(DatasetName+"_g.txt",MODE_APPEND);
                                OutputStreamWriter outputWriter12 = new OutputStreamWriter(fileout12);
                                outputWriter12.write(InputfileName+" ");
                                outputWriter12.write(Formula+" ");
                                outputWriter12.write(Method+" ");
                                outputWriter12.write(Sed7);
                                outputWriter12.close();
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_g.temp");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/gas/thermo/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/gas/thermo/results");

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }


                        File[] files_solv = new File(getFilesDir()+"/openbabel/solv/opt").listFiles();
                        for (File file : files_solv) {
                            if (!file.isFile()) continue;


                            String InputfileName = file.getName();
                            String Formula = exec("sed -n 1p "+getFilesDir()+"/openbabel/formula/"+InputfileName+".formula");
                            String Method = exec("cat "+getFilesDir()+"/method.txt");

                            Formula = Formula.replace(",", ".");

                            ///////////////// introduce [C], [H], [N], [O], [S], [F] to formula programatically /////////////////////////
                            //                    try {
//                    while (Formula.contains("C")){
                            Formula = Formula.replace("C", "[C]");
                            Formula = Formula.replace("[C]a", "Ca");
                            Formula = Formula.replace("[C]b", "Cb");
                            Formula = Formula.replace("[C]c", "Cc");
                            Formula = Formula.replace("[C]d", "Cd");
                            Formula = Formula.replace("[C]e", "Ce");
                            Formula = Formula.replace("[C]f", "Cf");
                            Formula = Formula.replace("[C]g", "Cg");
                            Formula = Formula.replace("[C]h", "Ch");
                            Formula = Formula.replace("[C]i", "Ci");
                            Formula = Formula.replace("[C]j", "Cj");
                            Formula = Formula.replace("[C]k", "Ck");
                            Formula = Formula.replace("[C]l", "Cl");
                            Formula = Formula.replace("[C]m", "Cm");
                            Formula = Formula.replace("[C]n", "Cn");
                            Formula = Formula.replace("[C]o", "Co");
                            Formula = Formula.replace("[C]p", "Cp");
                            Formula = Formula.replace("[C]q", "Cq");
                            Formula = Formula.replace("[C]r", "Cr");
                            Formula = Formula.replace("[C]s", "Cs");
                            Formula = Formula.replace("[C]t", "Ct");
                            Formula = Formula.replace("[C]u", "Cu");
                            Formula = Formula.replace("[C]v", "Cv");
                            Formula = Formula.replace("[C]w", "Cw");
                            Formula = Formula.replace("[C]x", "Cx");
                            Formula = Formula.replace("[C]y", "Cy");
                            Formula = Formula.replace("[C]z", "Cz");
//                    }
//                    while (Formula.contains("H")){
                            Formula = Formula.replace("H", "[H]");
                            Formula = Formula.replace("[H]a", "Ha");
                            Formula = Formula.replace("[H]b", "Hb");
                            Formula = Formula.replace("[H]c", "Hc");
                            Formula = Formula.replace("[H]d", "Hd");
                            Formula = Formula.replace("[H]e", "He");
                            Formula = Formula.replace("[H]f", "Hf");
                            Formula = Formula.replace("[H]g", "Hg");
                            Formula = Formula.replace("[H]h", "Hh");
                            Formula = Formula.replace("[H]i", "Hi");
                            Formula = Formula.replace("[H]j", "Hj");
                            Formula = Formula.replace("[H]k", "Hk");
                            Formula = Formula.replace("[H]l", "Hl");
                            Formula = Formula.replace("[H]m", "Hm");
                            Formula = Formula.replace("[H]n", "Hn");
                            Formula = Formula.replace("[H]o", "Ho");
                            Formula = Formula.replace("[H]p", "Hp");
                            Formula = Formula.replace("[H]q", "Hq");
                            Formula = Formula.replace("[H]r", "Hr");
                            Formula = Formula.replace("[H]s", "Hs");
                            Formula = Formula.replace("[H]t", "Ht");
                            Formula = Formula.replace("[H]u", "Hu");
                            Formula = Formula.replace("[H]v", "Hv");
                            Formula = Formula.replace("[H]w", "Hw");
                            Formula = Formula.replace("[H]x", "Hx");
                            Formula = Formula.replace("[H]y", "Hy");
                            Formula = Formula.replace("[H]z", "Hz");
//                    }
//                    while (Formula.contains("N")){
                            Formula = Formula.replace("N", "[N]");
                            Formula = Formula.replace("[N]a", "Na");
                            Formula = Formula.replace("[N]b", "Nb");
                            Formula = Formula.replace("[N]c", "Nc");
                            Formula = Formula.replace("[N]d", "Nd");
                            Formula = Formula.replace("[N]e", "Ne");
                            Formula = Formula.replace("[N]f", "Nf");
                            Formula = Formula.replace("[N]g", "Ng");
                            Formula = Formula.replace("[N]h", "Nh");
                            Formula = Formula.replace("[N]i", "Ni");
                            Formula = Formula.replace("[N]j", "Nj");
                            Formula = Formula.replace("[N]k", "Nk");
                            Formula = Formula.replace("[N]l", "Nl");
                            Formula = Formula.replace("[N]m", "Nm");
                            Formula = Formula.replace("[N]n", "Nn");
                            Formula = Formula.replace("[N]o", "No");
                            Formula = Formula.replace("[N]p", "Np");
                            Formula = Formula.replace("[N]q", "Nq");
                            Formula = Formula.replace("[N]r", "Nr");
                            Formula = Formula.replace("[N]s", "Ns");
                            Formula = Formula.replace("[N]t", "Nt");
                            Formula = Formula.replace("[N]u", "Nu");
                            Formula = Formula.replace("[N]v", "Nv");
                            Formula = Formula.replace("[N]w", "Nw");
                            Formula = Formula.replace("[N]x", "Nx");
                            Formula = Formula.replace("[N]y", "Ny");
                            Formula = Formula.replace("[N]z", "Nz");
//                    }
//                    while (Formula.contains("O")){
                            Formula = Formula.replace("O", "[O]");
                            Formula = Formula.replace("[O]a", "Oa");
                            Formula = Formula.replace("[O]b", "Ob");
                            Formula = Formula.replace("[O]c", "Oc");
                            Formula = Formula.replace("[O]d", "Od");
                            Formula = Formula.replace("[O]e", "Oe");
                            Formula = Formula.replace("[O]f", "Of");
                            Formula = Formula.replace("[O]g", "Og");
                            Formula = Formula.replace("[O]h", "Oh");
                            Formula = Formula.replace("[O]i", "Oi");
                            Formula = Formula.replace("[O]j", "Oj");
                            Formula = Formula.replace("[O]k", "Ok");
                            Formula = Formula.replace("[O]l", "Ol");
                            Formula = Formula.replace("[O]m", "Om");
                            Formula = Formula.replace("[O]n", "On");
                            Formula = Formula.replace("[O]o", "Oo");
                            Formula = Formula.replace("[O]p", "Op");
                            Formula = Formula.replace("[O]q", "Oq");
                            Formula = Formula.replace("[O]r", "Or");
                            Formula = Formula.replace("[O]s", "Os");
                            Formula = Formula.replace("[O]t", "Ot");
                            Formula = Formula.replace("[O]u", "Ou");
                            Formula = Formula.replace("[O]v", "Ov");
                            Formula = Formula.replace("[O]w", "Ow");
                            Formula = Formula.replace("[O]x", "Ox");
                            Formula = Formula.replace("[O]y", "Oy");
                            Formula = Formula.replace("[O]z", "Oz");
//                    }
//                    while (Formula.contains("S")){
                            Formula = Formula.replace("S", "[S]");
                            Formula = Formula.replace("[S]a", "Sa");
                            Formula = Formula.replace("[S]b", "Sb");
                            Formula = Formula.replace("[S]c", "Sc");
                            Formula = Formula.replace("[S]d", "Sd");
                            Formula = Formula.replace("[S]e", "Se");
                            Formula = Formula.replace("[S]f", "Sf");
                            Formula = Formula.replace("[S]g", "Sg");
                            Formula = Formula.replace("[S]h", "Sh");
                            Formula = Formula.replace("[S]i", "Si");
                            Formula = Formula.replace("[S]j", "Sj");
                            Formula = Formula.replace("[S]k", "Sk");
                            Formula = Formula.replace("[S]l", "Sl");
                            Formula = Formula.replace("[S]m", "Sm");
                            Formula = Formula.replace("[S]n", "Sn");
                            Formula = Formula.replace("[S]o", "So");
                            Formula = Formula.replace("[S]p", "Sp");
                            Formula = Formula.replace("[S]q", "Sq");
                            Formula = Formula.replace("[S]r", "Sr");
                            Formula = Formula.replace("[S]s", "Ss");
                            Formula = Formula.replace("[S]t", "St");
                            Formula = Formula.replace("[S]u", "Su");
                            Formula = Formula.replace("[S]v", "Sv");
                            Formula = Formula.replace("[S]w", "Sw");
                            Formula = Formula.replace("[S]x", "Sx");
                            Formula = Formula.replace("[S]y", "Sy");
                            Formula = Formula.replace("[S]z", "Sz");
//                    }
//                    while (Formula.contains("F")){
                            Formula = Formula.replace("F", "[F]");
                            Formula = Formula.replace("[F]a", "Fa");
                            Formula = Formula.replace("[F]b", "Fb");
                            Formula = Formula.replace("[F]c", "Fc");
                            Formula = Formula.replace("[F]d", "Fd");
                            Formula = Formula.replace("[F]e", "Fe");
                            Formula = Formula.replace("[F]f", "Ff");
                            Formula = Formula.replace("[F]g", "Fg");
                            Formula = Formula.replace("[F]h", "Fh");
                            Formula = Formula.replace("[F]i", "Fi");
                            Formula = Formula.replace("[F]j", "Fj");
                            Formula = Formula.replace("[F]k", "Fk");
                            Formula = Formula.replace("[F]l", "Fl");
                            Formula = Formula.replace("[F]m", "Fm");
                            Formula = Formula.replace("[F]n", "Fn");
                            Formula = Formula.replace("[F]o", "Fo");
                            Formula = Formula.replace("[F]p", "Fp");
                            Formula = Formula.replace("[F]q", "Fq");
                            Formula = Formula.replace("[F]r", "Fr");
                            Formula = Formula.replace("[F]s", "Fs");
                            Formula = Formula.replace("[F]t", "Ft");
                            Formula = Formula.replace("[F]u", "Fu");
                            Formula = Formula.replace("[F]v", "Fv");
                            Formula = Formula.replace("[F]w", "Fw");
                            Formula = Formula.replace("[F]x", "Fx");
                            Formula = Formula.replace("[F]y", "Fy");
                            Formula = Formula.replace("[F]z", "Fz");
//                    }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                            try {
                                exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileName+" "+getFilesDir()+"/"+InputfileName+".mop");
                                try {
                                    exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+"/openbabel/solv/opt/results");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".arc");
                                exec("cp "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/solv/thermo/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/solv/opt/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/solv/opt/results");
                                String Sed3 = exec("sed -n 1p "+getFilesDir()+"/openbabel/solv/opt/"+InputfileName);
                                String Sed4 = exec("sed -e 1,/FINAL/d "+getFilesDir()+"/openbabel/solv/thermo/results/"+InputfileName+".arc");
                                FileOutputStream fileout9 = openFileOutput(InputfileName+".mops", MODE_PRIVATE);
                                OutputStreamWriter outputWriter9 = new OutputStreamWriter(fileout9);
                                outputWriter9.write(Sed4);
                                outputWriter9.close();
                                exec("cp "+getFilesDir()+"/"+InputfileName+".mops "+getFilesDir()+"/openbabel/solv/thermo");
                                String Sed5 = exec("sed -e 1,3d "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileName+".mops");
                                FileOutputStream fileout10 = openFileOutput(InputfileName+".mop", MODE_PRIVATE);
                                OutputStreamWriter outputWriter10 = new OutputStreamWriter(fileout10);
                                outputWriter10.write("THERMO(298,298) LET "+Sed3);
                                outputWriter10.write("\n");
                                outputWriter10.write("\n");
                                outputWriter10.write(Sed5);
                                outputWriter10.close();
                                exec("rm "+getFilesDir()+"/openbabel/solv/thermo/"+InputfileName+".mops");
                                exec("rm "+getFilesDir()+"/"+InputfileName+".mops");
                                try {
                                    exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                exec("mv "+getFilesDir()+"/"+InputfileName+".mop "+getFilesDir()+"/openbabel/solv/thermo/results");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".out");
                                exec("chmod 755 "+getFilesDir()+"/"+InputfileName+".arc");
                                String Grep2 = exec("grep -e TOT. "+getFilesDir()+"/"+InputfileName+".out");
                                FileOutputStream fileout13 = openFileOutput(InputfileName+"_s.temp",MODE_PRIVATE);
                                OutputStreamWriter outputWriter13 = new OutputStreamWriter(fileout13);
                                outputWriter13.write(Grep2);
                                outputWriter13.close();
                                String Sed6 = exec("sed -e 2d "+getFilesDir()+"/"+InputfileName+"_s.temp");
                                FileOutputStream fileout14 = openFileOutput(DatasetName+"_s.txt",MODE_APPEND);
                                OutputStreamWriter outputWriter14 = new OutputStreamWriter(fileout14);
                                outputWriter14.write(InputfileName+" ");
                                outputWriter14.write(Formula+" ");
                                outputWriter14.write(Method+" ");
                                outputWriter14.write(Sed6);
                                outputWriter14.close();
                                exec("rm "+getFilesDir()+"/"+InputfileName+"_s.temp");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".out "+getFilesDir()+"/openbabel/solv/thermo/results");
                                exec("mv "+getFilesDir()+"/"+InputfileName+".arc "+getFilesDir()+"/openbabel/solv/thermo/results");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }


                        try {

                            String RawOutput_g = exec("cat "+getFilesDir()+"/"+DatasetName+"_g.txt");
                            while (RawOutput_g.contains("  ")){  //2 spaces
                                RawOutput_g = RawOutput_g.replace("  ", " "); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout15 = openFileOutput(DatasetName+"_thermochemistry_g.txt",MODE_PRIVATE);
                            OutputStreamWriter outputWriter15 = new OutputStreamWriter(fileout15);
                            outputWriter15.write(RawOutput_g);
                            outputWriter15.close();

                            String RawOutput_s = exec("cat "+getFilesDir()+"/"+DatasetName+"_s.txt");
                            while (RawOutput_s.contains("  ")){  //2 spaces
                                RawOutput_s = RawOutput_s.replace("  ", " "); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout16 = openFileOutput(DatasetName+"_thermochemistry_s.txt",MODE_PRIVATE);
                            OutputStreamWriter outputWriter16 = new OutputStreamWriter(fileout16);
                            outputWriter16.write(RawOutput_s);
                            outputWriter16.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        exec("cp "+getFilesDir()+"/"+DatasetName+"_thermochemistry_g.txt "+getFilesDir()+"/PHASES/Thermochemistry_g.txt");
                        exec("cp "+getFilesDir()+"/"+DatasetName+"_thermochemistry_s.txt "+getFilesDir()+"/SOLUTION_SPECIES/Thermochemistry_s.txt");
                        exec("cp "+getFilesDir()+"/"+DatasetName+"_thermochemistry_s.txt "+getFilesDir()+"/PSEUDOPHASES/Thermochemistry_s.txt");

                        try {

                            exec("chmod -R 755 "+getFilesDir());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        exec("mv "+getFilesDir()+"/"+DatasetName+"_g.dat "+getFilesDir()+"/openbabel/gas");
                        exec("mv "+getFilesDir()+"/"+DatasetName+"_s.dat "+getFilesDir()+"/openbabel/solv");

                        exec("mv "+getFilesDir()+"/"+DatasetName+"_thermochemistry_g.txt "+getFilesDir()+"/openbabel/gas");
                        exec("mv "+getFilesDir()+"/"+DatasetName+"_thermochemistry_s.txt "+getFilesDir()+"/openbabel/solv");

//for sure:
                        exec("rm "+getFilesDir()+"/"+DatasetName+"_g.txt");
                        exec("rm "+getFilesDir()+"/"+DatasetName+"_s.txt");
//for case of fall down - the same code as already exists in MainActivity.java in OnResume:

                        exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.bas");
                        exec("chmod -R 755 "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.bas");
                        exec("chmod -R 755 "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.bas");
                        exec("chmod -R 755 "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");

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

                            /// new piece of code:
                            String Raw_g3 = exec("cat "+getFilesDir()+"/Database_g2.dat");
                            while (Raw_g3.contains("[H]")){
                                Raw_g3 = Raw_g3.replace("[H]", "H");
                            }
                            FileOutputStream fileout2155 = openFileOutput("Database_g3.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter2155 = new OutputStreamWriter(fileout2155);
                            outputWriter2155.write(Raw_g3);
                            outputWriter2155.close();

                            String Raw_g4 = exec("cat "+getFilesDir()+"/Database_g3.dat");
                            while (Raw_g4.contains("[O]")){
                                Raw_g4 = Raw_g4.replace("[O]", "O");
                            }
                            FileOutputStream fileout2156 = openFileOutput("Database_g4.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter2156 = new OutputStreamWriter(fileout2156);
                            outputWriter2156.write(Raw_g4);
                            outputWriter2156.close();
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

                            String Raw_s = exec("cat "+getFilesDir()+"/SOLUTION_SPECIES/Database_s.dat");
                            while (Raw_s.contains("= + e- =")){  //2 spaces
                                Raw_s = Raw_s.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
			     while (Raw_s.contains("=  + e- =")){  //2 spaces
                                Raw_s = Raw_s.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
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

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
                        exec("mv "+getFilesDir()+"/Database_g2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_g.txt");
                        exec("mv "+getFilesDir()+"/Database_g4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_g.txt");
                        exec("chmod -R 755 "+getFilesDir()+"/PHASES");
                        exec("mv "+getFilesDir()+"/PHASES/Fastchem_g.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+DatasetName+"_g.txt");
                        exec("mv "+getFilesDir()+"/Database_solid_sol2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_solid_sol.txt");
                        exec("mv "+getFilesDir()+"/Database_solid_sol4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_solid_sol.txt");
                        exec("mv "+getFilesDir()+"/Database_s2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_s.txt");
                        exec("mv "+getFilesDir()+"/Database_s4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_s.txt");
                        exec("rm "+getFilesDir()+"/Database_g.dat");
                        exec("rm "+getFilesDir()+"/Database_g1.dat");
                        exec("rm "+getFilesDir()+"/Database_g3.dat");
                        exec("rm "+getFilesDir()+"/Database_s.dat");
                        exec("rm "+getFilesDir()+"/Database_s1.dat");
                        exec("rm "+getFilesDir()+"/Database_s3.dat");
                        exec("rm "+getFilesDir()+"/Database_solid_sol.dat");
                        exec("rm "+getFilesDir()+"/Database_solid_sol1.dat");
                        exec("rm "+getFilesDir()+"/Database_solid_sol3.dat");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/xyz "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/smiles "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/gas "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/solv "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/iupac "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/formula "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/damping_factor "+getFilesDir()+File.separator+"output");
// end of repetition
// inside of ProgressDialog!:
                        postActivity();
//                        exec("rm -rf "+getFilesDir()+"/openbabel");
                        onFinish();
                    }
                    public void onFinish(){
                        progressDialog.dismiss();
                    }
                }.start();

            }
        };
    }


    public void postActivity() {

        // TODO Auto-generated method stub //
        try {

//            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.bas");
//            exec("chmod -R 755 "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PHASES/DatabaseMakerPseudoPhases.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.bas");
//            exec("chmod -R 755 "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.bas");
//            exec("chmod -R 755 "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
            Intent intent = new Intent(BulkConversion.this, ResumeActivity.class);
            startActivity(intent);
            onResume();
        } catch (Exception e) {
        }
    }



    private View.OnClickListener quit_click; {

        quit_click = new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    exec("rm -rf "+getFilesDir()+File.separator+"openbabel");
                    exec("mkdir "+getFilesDir()+File.separator+"openbabel");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                openbabel_exit_click();
            }
        };
    }

    private void openbabel_exit_click() {

        Intent intent = new Intent(BulkConversion.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        method_view(exec("cat "+getFilesDir()+"/method.txt"));
        solvation_view(exec("cat "+getFilesDir()+"/solvation.txt"));
        keywords_view(exec("cat "+getFilesDir()+"/keywords.txt"));
        output100(exec("ls -l "+getFilesDir()+"/bulk_conversion"));
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output100(final String str100) {
        Runnable proc100 = new Runnable() {
            public void run() {
                BulkView.setText(str100);
            }
        };
        handler.post(proc100);
    }




}

