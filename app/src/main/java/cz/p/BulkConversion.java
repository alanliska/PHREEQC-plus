package cz.p;

import static cz.p.Spannables.colorized_dftb;
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
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.TextWatcher;
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
    private static final int READ_FILE100 = 11100;
    private Uri documentUri100;
    public Button help_bulk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.bulkconversion);

        method_label = (TextView) findViewById(R.id.method_label);
        method = (EditText) findViewById(R.id.method);
        method.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        method.addTextChangedListener(new TextWatcher() {
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
                method.removeTextChangedListener(this);
                String text = method.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                method.getText().clear();
                method.append(colorized_numbers(text));
                // place the cursor at the original position
                method.setSelection(startChanged+countChanged);
                method.addTextChangedListener(this);
            }
        });
        solvation_label = (TextView) findViewById(R.id.solvation_label);
        solvation = (EditText) findViewById(R.id.solvation);
        solvation.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        solvation.addTextChangedListener(new TextWatcher() {
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
                solvation.removeTextChangedListener(this);
                String text = solvation.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                solvation.getText().clear();
                solvation.append(colorized_numbers(text));
                // place the cursor at the original position
                solvation.setSelection(startChanged+countChanged);
                solvation.addTextChangedListener(this);
            }
        });
        keywords_label = (TextView) findViewById(R.id.keywords_label);
        keywords = (EditText) findViewById(R.id.keywords);
        keywords.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        keywords.addTextChangedListener(new TextWatcher() {
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
                keywords.removeTextChangedListener(this);
                String text = keywords.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                keywords.getText().clear();
                keywords.append(colorized_numbers(text));
                // place the cursor at the original position
                keywords.setSelection(startChanged+countChanged);
                keywords.addTextChangedListener(this);
            }
        });
        openbabel_select = (Button) findViewById(R.id.openbabel_select);
        openbabel_select.setOnClickListener(openbabel_select_click);
        openbabel_exit = (Button) findViewById(R.id.openbabel_exit);
        openbabel_exit.setOnClickListener(openbabel_exit_click);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(quit_click);
        BulkView = (EditText) findViewById(R.id.BulkView);
        BulkView.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/OutputTextSize.txt")).intValue());
        BulkView.addTextChangedListener(new TextWatcher() {
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
                BulkView.removeTextChangedListener(this);
                String text = BulkView.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                BulkView.getText().clear();
                BulkView.append(colorized_numbers(text));
                // place the cursor at the original position
                BulkView.setSelection(startChanged+countChanged);
                BulkView.addTextChangedListener(this);
            }
        });
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
                method.setText(colorized_numbers(method_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(method_proc);
    }

    public void solvation_view(final String solvation_str) {
        Runnable solvation_proc = new Runnable() {
            public void run() {
                solvation.setText(colorized_numbers(solvation_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(solvation_proc);
    }

    public void keywords_view(final String keywords_str) {
        Runnable keywords_proc = new Runnable() {
            public void run() {
                keywords.setText(colorized_numbers(keywords_str), EditText.BufferType.SPANNABLE);
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
//                            Formula = Formula.replace("C", "[C]");
//                            Formula = Formula.replace("[C]a", "Ca");
//                            Formula = Formula.replace("[C]b", "Cb");
//                            Formula = Formula.replace("[C]c", "Cc");
//                            Formula = Formula.replace("[C]d", "Cd");
//                            Formula = Formula.replace("[C]e", "Ce");
//                            Formula = Formula.replace("[C]f", "Cf");
//                            Formula = Formula.replace("[C]g", "Cg");
//                            Formula = Formula.replace("[C]h", "Ch");
//                            Formula = Formula.replace("[C]i", "Ci");
//                            Formula = Formula.replace("[C]j", "Cj");
//                            Formula = Formula.replace("[C]k", "Ck");
//                            Formula = Formula.replace("[C]l", "Cl");
//                            Formula = Formula.replace("[C]m", "Cm");
//                            Formula = Formula.replace("[C]n", "Cn");
//                            Formula = Formula.replace("[C]o", "Co");
//                            Formula = Formula.replace("[C]p", "Cp");
//                            Formula = Formula.replace("[C]q", "Cq");
//                            Formula = Formula.replace("[C]r", "Cr");
//                            Formula = Formula.replace("[C]s", "Cs");
//                            Formula = Formula.replace("[C]t", "Ct");
//                            Formula = Formula.replace("[C]u", "Cu");
//                            Formula = Formula.replace("[C]v", "Cv");
//                            Formula = Formula.replace("[C]w", "Cw");
//                            Formula = Formula.replace("[C]x", "Cx");
//                            Formula = Formula.replace("[C]y", "Cy");
//                            Formula = Formula.replace("[C]z", "Cz");
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
//                            Formula = Formula.replace("N", "[N]");
//                            Formula = Formula.replace("[N]a", "Na");
//                            Formula = Formula.replace("[N]b", "Nb");
//                            Formula = Formula.replace("[N]c", "Nc");
//                            Formula = Formula.replace("[N]d", "Nd");
//                            Formula = Formula.replace("[N]e", "Ne");
//                            Formula = Formula.replace("[N]f", "Nf");
//                            Formula = Formula.replace("[N]g", "Ng");
//                            Formula = Formula.replace("[N]h", "Nh");
//                            Formula = Formula.replace("[N]i", "Ni");
//                            Formula = Formula.replace("[N]j", "Nj");
//                            Formula = Formula.replace("[N]k", "Nk");
//                            Formula = Formula.replace("[N]l", "Nl");
//                            Formula = Formula.replace("[N]m", "Nm");
//                            Formula = Formula.replace("[N]n", "Nn");
//                            Formula = Formula.replace("[N]o", "No");
//                            Formula = Formula.replace("[N]p", "Np");
//                            Formula = Formula.replace("[N]q", "Nq");
//                            Formula = Formula.replace("[N]r", "Nr");
//                            Formula = Formula.replace("[N]s", "Ns");
//                            Formula = Formula.replace("[N]t", "Nt");
//                            Formula = Formula.replace("[N]u", "Nu");
//                            Formula = Formula.replace("[N]v", "Nv");
//                            Formula = Formula.replace("[N]w", "Nw");
//                            Formula = Formula.replace("[N]x", "Nx");
//                            Formula = Formula.replace("[N]y", "Ny");
//                            Formula = Formula.replace("[N]z", "Nz");
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
//                            Formula = Formula.replace("S", "[S]");
//                            Formula = Formula.replace("[S]a", "Sa");
//                            Formula = Formula.replace("[S]b", "Sb");
//                            Formula = Formula.replace("[S]c", "Sc");
//                            Formula = Formula.replace("[S]d", "Sd");
//                            Formula = Formula.replace("[S]e", "Se");
//                            Formula = Formula.replace("[S]f", "Sf");
//                            Formula = Formula.replace("[S]g", "Sg");
//                            Formula = Formula.replace("[S]h", "Sh");
//                            Formula = Formula.replace("[S]i", "Si");
//                            Formula = Formula.replace("[S]j", "Sj");
//                            Formula = Formula.replace("[S]k", "Sk");
//                            Formula = Formula.replace("[S]l", "Sl");
//                            Formula = Formula.replace("[S]m", "Sm");
//                            Formula = Formula.replace("[S]n", "Sn");
//                            Formula = Formula.replace("[S]o", "So");
//                            Formula = Formula.replace("[S]p", "Sp");
//                            Formula = Formula.replace("[S]q", "Sq");
//                            Formula = Formula.replace("[S]r", "Sr");
//                            Formula = Formula.replace("[S]s", "Ss");
//                            Formula = Formula.replace("[S]t", "St");
//                            Formula = Formula.replace("[S]u", "Su");
//                            Formula = Formula.replace("[S]v", "Sv");
//                            Formula = Formula.replace("[S]w", "Sw");
//                            Formula = Formula.replace("[S]x", "Sx");
//                            Formula = Formula.replace("[S]y", "Sy");
//                            Formula = Formula.replace("[S]z", "Sz");
//                    }
//                    while (Formula.contains("F")){
//                            Formula = Formula.replace("F", "[F]");
//                            Formula = Formula.replace("[F]a", "Fa");
//                            Formula = Formula.replace("[F]b", "Fb");
//                            Formula = Formula.replace("[F]c", "Fc");
//                            Formula = Formula.replace("[F]d", "Fd");
//                            Formula = Formula.replace("[F]e", "Fe");
//                            Formula = Formula.replace("[F]f", "Ff");
//                            Formula = Formula.replace("[F]g", "Fg");
//                            Formula = Formula.replace("[F]h", "Fh");
//                            Formula = Formula.replace("[F]i", "Fi");
//                            Formula = Formula.replace("[F]j", "Fj");
//                            Formula = Formula.replace("[F]k", "Fk");
//                            Formula = Formula.replace("[F]l", "Fl");
//                            Formula = Formula.replace("[F]m", "Fm");
//                            Formula = Formula.replace("[F]n", "Fn");
//                            Formula = Formula.replace("[F]o", "Fo");
//                            Formula = Formula.replace("[F]p", "Fp");
//                            Formula = Formula.replace("[F]q", "Fq");
//                            Formula = Formula.replace("[F]r", "Fr");
//                            Formula = Formula.replace("[F]s", "Fs");
//                            Formula = Formula.replace("[F]t", "Ft");
//                            Formula = Formula.replace("[F]u", "Fu");
//                            Formula = Formula.replace("[F]v", "Fv");
//                            Formula = Formula.replace("[F]w", "Fw");
//                            Formula = Formula.replace("[F]x", "Fx");
//                            Formula = Formula.replace("[F]y", "Fy");
//                            Formula = Formula.replace("[F]z", "Fz");
//                    }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                            try {
                                exec("cp "+getFilesDir()+"/openbabel/gas/opt/"+InputfileName+" "+getFilesDir()+"/"+InputfileName+".mop");
                                try {
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
				    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileName);
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
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
				    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileName);
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
//                            Formula = Formula.replace("C", "[C]");
//                            Formula = Formula.replace("[C]a", "Ca");
//                            Formula = Formula.replace("[C]b", "Cb");
//                            Formula = Formula.replace("[C]c", "Cc");
//                            Formula = Formula.replace("[C]d", "Cd");
//                            Formula = Formula.replace("[C]e", "Ce");
//                            Formula = Formula.replace("[C]f", "Cf");
//                            Formula = Formula.replace("[C]g", "Cg");
//                            Formula = Formula.replace("[C]h", "Ch");
//                            Formula = Formula.replace("[C]i", "Ci");
//                            Formula = Formula.replace("[C]j", "Cj");
//                            Formula = Formula.replace("[C]k", "Ck");
//                            Formula = Formula.replace("[C]l", "Cl");
//                            Formula = Formula.replace("[C]m", "Cm");
//                            Formula = Formula.replace("[C]n", "Cn");
//                            Formula = Formula.replace("[C]o", "Co");
//                            Formula = Formula.replace("[C]p", "Cp");
//                            Formula = Formula.replace("[C]q", "Cq");
//                            Formula = Formula.replace("[C]r", "Cr");
//                            Formula = Formula.replace("[C]s", "Cs");
//                            Formula = Formula.replace("[C]t", "Ct");
//                            Formula = Formula.replace("[C]u", "Cu");
//                            Formula = Formula.replace("[C]v", "Cv");
//                            Formula = Formula.replace("[C]w", "Cw");
//                            Formula = Formula.replace("[C]x", "Cx");
//                            Formula = Formula.replace("[C]y", "Cy");
//                            Formula = Formula.replace("[C]z", "Cz");
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
//                            Formula = Formula.replace("N", "[N]");
//                            Formula = Formula.replace("[N]a", "Na");
//                            Formula = Formula.replace("[N]b", "Nb");
//                            Formula = Formula.replace("[N]c", "Nc");
//                            Formula = Formula.replace("[N]d", "Nd");
//                            Formula = Formula.replace("[N]e", "Ne");
//                            Formula = Formula.replace("[N]f", "Nf");
//                            Formula = Formula.replace("[N]g", "Ng");
//                            Formula = Formula.replace("[N]h", "Nh");
//                            Formula = Formula.replace("[N]i", "Ni");
//                            Formula = Formula.replace("[N]j", "Nj");
//                            Formula = Formula.replace("[N]k", "Nk");
//                            Formula = Formula.replace("[N]l", "Nl");
//                            Formula = Formula.replace("[N]m", "Nm");
//                            Formula = Formula.replace("[N]n", "Nn");
//                            Formula = Formula.replace("[N]o", "No");
//                            Formula = Formula.replace("[N]p", "Np");
//                            Formula = Formula.replace("[N]q", "Nq");
//                            Formula = Formula.replace("[N]r", "Nr");
//                            Formula = Formula.replace("[N]s", "Ns");
//                            Formula = Formula.replace("[N]t", "Nt");
//                            Formula = Formula.replace("[N]u", "Nu");
//                            Formula = Formula.replace("[N]v", "Nv");
//                            Formula = Formula.replace("[N]w", "Nw");
//                            Formula = Formula.replace("[N]x", "Nx");
//                            Formula = Formula.replace("[N]y", "Ny");
//                            Formula = Formula.replace("[N]z", "Nz");
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
//                            Formula = Formula.replace("S", "[S]");
//                            Formula = Formula.replace("[S]a", "Sa");
//                            Formula = Formula.replace("[S]b", "Sb");
//                            Formula = Formula.replace("[S]c", "Sc");
//                            Formula = Formula.replace("[S]d", "Sd");
//                            Formula = Formula.replace("[S]e", "Se");
//                            Formula = Formula.replace("[S]f", "Sf");
//                            Formula = Formula.replace("[S]g", "Sg");
//                            Formula = Formula.replace("[S]h", "Sh");
//                            Formula = Formula.replace("[S]i", "Si");
//                            Formula = Formula.replace("[S]j", "Sj");
//                            Formula = Formula.replace("[S]k", "Sk");
//                            Formula = Formula.replace("[S]l", "Sl");
//                            Formula = Formula.replace("[S]m", "Sm");
//                            Formula = Formula.replace("[S]n", "Sn");
//                            Formula = Formula.replace("[S]o", "So");
//                            Formula = Formula.replace("[S]p", "Sp");
//                            Formula = Formula.replace("[S]q", "Sq");
//                            Formula = Formula.replace("[S]r", "Sr");
//                            Formula = Formula.replace("[S]s", "Ss");
//                            Formula = Formula.replace("[S]t", "St");
//                            Formula = Formula.replace("[S]u", "Su");
//                            Formula = Formula.replace("[S]v", "Sv");
//                            Formula = Formula.replace("[S]w", "Sw");
//                            Formula = Formula.replace("[S]x", "Sx");
//                            Formula = Formula.replace("[S]y", "Sy");
//                            Formula = Formula.replace("[S]z", "Sz");
//                    }
//                    while (Formula.contains("F")){
//                            Formula = Formula.replace("F", "[F]");
//                            Formula = Formula.replace("[F]a", "Fa");
//                            Formula = Formula.replace("[F]b", "Fb");
//                            Formula = Formula.replace("[F]c", "Fc");
//                            Formula = Formula.replace("[F]d", "Fd");
//                            Formula = Formula.replace("[F]e", "Fe");
//                            Formula = Formula.replace("[F]f", "Ff");
//                            Formula = Formula.replace("[F]g", "Fg");
//                            Formula = Formula.replace("[F]h", "Fh");
//                            Formula = Formula.replace("[F]i", "Fi");
//                            Formula = Formula.replace("[F]j", "Fj");
//                            Formula = Formula.replace("[F]k", "Fk");
//                            Formula = Formula.replace("[F]l", "Fl");
//                            Formula = Formula.replace("[F]m", "Fm");
//                            Formula = Formula.replace("[F]n", "Fn");
//                            Formula = Formula.replace("[F]o", "Fo");
//                            Formula = Formula.replace("[F]p", "Fp");
//                            Formula = Formula.replace("[F]q", "Fq");
//                            Formula = Formula.replace("[F]r", "Fr");
//                            Formula = Formula.replace("[F]s", "Fs");
//                            Formula = Formula.replace("[F]t", "Ft");
//                            Formula = Formula.replace("[F]u", "Fu");
//                            Formula = Formula.replace("[F]v", "Fv");
//                            Formula = Formula.replace("[F]w", "Fw");
//                            Formula = Formula.replace("[F]x", "Fx");
//                            Formula = Formula.replace("[F]y", "Fy");
//                            Formula = Formula.replace("[F]z", "Fz");
//                    }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                            try {
                                exec("cp "+getFilesDir()+"/openbabel/solv/opt/"+InputfileName+" "+getFilesDir()+"/"+InputfileName+".mop");
                                try {
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
				    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileName);
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
                                    // exec(getApplicationInfo().nativeLibraryDir+"/libmopac.so "+getFilesDir()+"/"+InputfileName);
				    com.jrummyapps.android.shell.Shell.SH.run("cd "+getFilesDir()+"/ ; "+getApplicationInfo().nativeLibraryDir+"/libmopac.so "+InputfileName);
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

                        try {
                            String Fastchem_database_content = exec("cat "+getFilesDir()+"/PHASES/Fastchem_g.dat");

                            Fastchem_database_content = Fastchem_database_content.replace("[H]", "H");
                            Fastchem_database_content = Fastchem_database_content.replace("[O]", "O");
//                            Fastchem_database_content = Fastchem_database_content.replace("[C]", "C");
//                            Fastchem_database_content = Fastchem_database_content.replace("[N]", "N");
//                            Fastchem_database_content = Fastchem_database_content.replace("[S]", "S");
//                            Fastchem_database_content = Fastchem_database_content.replace("[F]", "F");

                            FileOutputStream fileoutFCH = openFileOutput("Fastchem_g.tmp",MODE_PRIVATE);
                            OutputStreamWriter outputWriterFCH = new OutputStreamWriter(fileoutFCH);
                            outputWriterFCH.write(Fastchem_database_content);
                            outputWriterFCH.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("rm "+getFilesDir()+"/PHASES/Fastchem_g.dat");
                        exec("mv "+getFilesDir()+"/Fastchem_g.tmp "+getFilesDir()+"/PHASES/Fastchem_g.dat");

                        try {
                            String Fastchem_database_content2 = exec("cat "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat");

                            Fastchem_database_content2 = Fastchem_database_content2.replace("[H]", "H");
                            Fastchem_database_content2 = Fastchem_database_content2.replace("[O]", "O");
//                            Fastchem_database_content2 = Fastchem_database_content2.replace("[C]", "C");
//                            Fastchem_database_content2 = Fastchem_database_content2.replace("[N]", "N");
//                            Fastchem_database_content2 = Fastchem_database_content2.replace("[S]", "S");
//                            Fastchem_database_content2 = Fastchem_database_content2.replace("[F]", "F");

                            FileOutputStream fileoutFCH2 = openFileOutput("Fastchem_solid_sol.tmp",MODE_PRIVATE);
                            OutputStreamWriter outputWriterFCH2 = new OutputStreamWriter(fileoutFCH2);
                            outputWriterFCH2.write(Fastchem_database_content2);
                            outputWriterFCH2.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("rm "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat");
                        exec("mv "+getFilesDir()+"/Fastchem_solid_sol.tmp "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat");

                        String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");
                        exec("mv "+getFilesDir()+"/Database_g2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_g.txt");
                        exec("mv "+getFilesDir()+"/Database_g4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_g.txt");
                        exec("chmod -R 755 "+getFilesDir()+"/PHASES");
                        exec("mv "+getFilesDir()+"/PHASES/Fastchem_g.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+DatasetName+"_g.txt");
                        exec("mv "+getFilesDir()+"/PSEUDOPHASES/Fastchem_solid_sol.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+DatasetName+"_solid_sol.txt");
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
                    // attempt to fix the error which is unrecoverable after quitting this process
//                    exec("mkdir "+getFilesDir()+File.separator+"openbabel");

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
                    File Path71 = new File(getFilesDir()+"/openbabel/xtb_comm");
                    File Path72 = new File(getFilesDir()+"/openbabel/xtb_solv");
                    File Path73 = new File(getFilesDir()+"/output/xtb_comm");
                    File Path74 = new File(getFilesDir()+"/output/xtb_solv");
                    File Path75 = new File(getFilesDir()+"/debug");
//                    try {
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
                        if (!Path71.exists()) {
                            Path71.mkdirs();
                        }
                        if (!Path72.exists()) {
                            Path72.mkdirs();
                        }
                        if (!Path73.exists()) {
                            Path73.mkdirs();
                        }
                        if (!Path74.exists()) {
                            Path74.mkdirs();
                        }
                        if (!Path75.exists()) {
                            Path75.mkdirs();
                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
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
                BulkView.setText(colorized_numbers(str100), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc100);
    }




}

