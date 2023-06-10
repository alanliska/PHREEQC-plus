package cz.p;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CustomExport extends MainActivity {

    private TextView label00;
    private TextView label000;
    private TextView label01;
    private TextView label02;
    private TextView label03;
    private TextView label03a;
    private TextView label04;
    private TextView label05;
    private TextView label06;
    private TextView label06a;
    private TextView label07;
    private TextView label08;
    private TextView label09;
    private TextView label10;
    private TextView label10a;
    private TextView label11;
    private TextView label12;
    private TextView label13;
    private TextView label14;
    private TextView label15;
    private TextView label16;
    private TextView label17;
    private TextView label18;
    private TextView label19;
    private TextView label20;
    private TextView label21;
    private TextView label22;
    private TextView label22a;
    private TextView label22b;
    private TextView label23;
    private TextView label24;
    private TextView label25;
    private TextView label26;
    private TextView label27;
    private TextView label28;
    private TextView label29;
    private TextView label30;
    private TextView label31;
//    private TextView label32;
//    private TextView label33;
//    private TextView label34;
//    private TextView label35;
//    private TextView label36;
//    private TextView label37;
    private TextView label38;
    private TextView label39;
    private TextView label40;
    private Button root;
    private Button bulk_conversion;
    private Button chemsol;
    private Button database;
    private Button mopac;
    private Button obabel;
    private Button phreeqc_work;
    private Button liquids;
    private Button phases;
    private Button solids;
    private Button solution_species;
    private Button pseudophases;
    private Button atmospheric_profiles;
    private Button damping_factor;
    private Button element_abundances;
    private Button fastchem_datasets;
    private Button formula;
    private Button iupac;
    private Button kinetics;
    private Button phreeqc_datasets;
    private Button smiles;
    private Button tautomers;
    private Button xyz;
    private Button gas;
    private Button gas_opt;
    private Button gas_opt_results;
    private Button gas_thermo;
    private Button gas_thermo_results;
    private Button liq;
    private Button cryst;
    private Button solv;
    private Button solv_opt;
    private Button solv_opt_results;
    private Button solv_thermo;
    private Button solv_thermo_results;
    private Button quit;
    private Button docs;
    private Button work;
//    private Button cp2k;
//    private Button basis;
//    private Button DFTB;
//    private Button nonscc;
//    private Button scc;
//    private Button xc_section;
    private Button dftb;
    private Button sk_files;
    private Button references;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.customexport);

        label00 = (TextView) findViewById(R.id.label00);
        label000 = (TextView) findViewById(R.id.label000);
        label01 = (TextView) findViewById(R.id.label01);
        label02 = (TextView) findViewById(R.id.label02);
        label03 = (TextView) findViewById(R.id.label03);
        label03a = (TextView) findViewById(R.id.label03a);
        label04 = (TextView) findViewById(R.id.label04);
        label05 = (TextView) findViewById(R.id.label05);
        label06 = (TextView) findViewById(R.id.label06);
        label06a = (TextView) findViewById(R.id.label06a);
        label07 = (TextView) findViewById(R.id.label07);
        label08 = (TextView) findViewById(R.id.label08);
        label09 = (TextView) findViewById(R.id.label09);
        label10 = (TextView) findViewById(R.id.label10);
        label10a = (TextView) findViewById(R.id.label10a);
        label11 = (TextView) findViewById(R.id.label11);
        label12 = (TextView) findViewById(R.id.label12);
        label13 = (TextView) findViewById(R.id.label13);
        label14 = (TextView) findViewById(R.id.label14);
        label15 = (TextView) findViewById(R.id.label15);
        label16 = (TextView) findViewById(R.id.label16);
        label17 = (TextView) findViewById(R.id.label17);
        label18 = (TextView) findViewById(R.id.label18);
        label19 = (TextView) findViewById(R.id.label19);
        label20 = (TextView) findViewById(R.id.label20);
        label21 = (TextView) findViewById(R.id.label21);
        label22 = (TextView) findViewById(R.id.label22);
        label22a = (TextView) findViewById(R.id.label22a);
        label22b = (TextView) findViewById(R.id.label22b);
        label23 = (TextView) findViewById(R.id.label23);
        label24 = (TextView) findViewById(R.id.label24);
        label25 = (TextView) findViewById(R.id.label25);
        label26 = (TextView) findViewById(R.id.label26);
        label27 = (TextView) findViewById(R.id.label27);
        label28 = (TextView) findViewById(R.id.label28);
        label29 = (TextView) findViewById(R.id.label29);
        label30 = (TextView) findViewById(R.id.label30);
        label31 = (TextView) findViewById(R.id.label31);
//        label32 = (TextView) findViewById(R.id.label32);
//        label33 = (TextView) findViewById(R.id.label33);
//        label34 = (TextView) findViewById(R.id.label34);
//        label35 = (TextView) findViewById(R.id.label35);
//        label36 = (TextView) findViewById(R.id.label36);
//        label37 = (TextView) findViewById(R.id.label37);
        label38 = (TextView) findViewById(R.id.label38);
        label39 = (TextView) findViewById(R.id.label39);
        label40 = (TextView) findViewById(R.id.label40);

        root = (Button) findViewById(R.id.root);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        bulk_conversion = (Button) findViewById(R.id.bulk_conversion);
        bulk_conversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/bulk_conversion";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        chemsol = (Button) findViewById(R.id.chemsol);
        chemsol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/chemsol";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        database = (Button) findViewById(R.id.database);
        database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/database";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        docs = (Button) findViewById(R.id.docs);
        docs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/docs";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        mopac = (Button) findViewById(R.id.mopac);
        mopac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/mopac";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        obabel = (Button) findViewById(R.id.obabel);
        obabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/obabel";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        phreeqc_work = (Button) findViewById(R.id.phreeqc_work);
        phreeqc_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/phreeqc_work";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        work = (Button) findViewById(R.id.work);
        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/work";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        liquids = (Button) findViewById(R.id.liquids);
        liquids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/LIQUIDS";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        phases = (Button) findViewById(R.id.phases);
        phases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/PHASES";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        solids = (Button) findViewById(R.id.solids);
        solids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/SOLIDS";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        solution_species = (Button) findViewById(R.id.solution_species);
        solution_species.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/SOLUTION_SPECIES";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        pseudophases = (Button) findViewById(R.id.pseudophases);
        pseudophases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/PSEUDOPHASES";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        atmospheric_profiles = (Button) findViewById(R.id.atmospheric_profiles);
        atmospheric_profiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/atmospheric-profiles";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        damping_factor = (Button) findViewById(R.id.damping_factor);
        damping_factor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/damping_factor";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        element_abundances = (Button) findViewById(R.id.element_abundances);
        element_abundances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/element-abundances";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        fastchem_datasets = (Button) findViewById(R.id.fastchem_datasets);
        fastchem_datasets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/fastchem_datasets";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        formula = (Button) findViewById(R.id.formula);
        formula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/formula";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        iupac = (Button) findViewById(R.id.iupac);
        iupac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/iupac";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        kinetics = (Button) findViewById(R.id.kinetics);
        kinetics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/kinetics";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        phreeqc_datasets = (Button) findViewById(R.id.phreeqc_datasets);
        phreeqc_datasets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/phreeqc_datasets";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        smiles = (Button) findViewById(R.id.smiles);
        smiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/smiles";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        tautomers = (Button) findViewById(R.id.tautomers);
        tautomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/tautomers";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        xyz = (Button) findViewById(R.id.xyz);
        xyz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/xyz";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        gas = (Button) findViewById(R.id.gas);
        gas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/gas";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        gas_opt = (Button) findViewById(R.id.gas_opt);
        gas_opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/gas/opt";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        gas_opt_results = (Button) findViewById(R.id.gas_opt_results);
        gas_opt_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/gas/opt/results";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        gas_thermo = (Button) findViewById(R.id.gas_thermo);
        gas_thermo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/gas/thermo";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        gas_thermo_results = (Button) findViewById(R.id.gas_thermo_results);
        gas_thermo_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/gas/thermo/results";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        liq = (Button) findViewById(R.id.liq);
        liq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/liq";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        cryst = (Button) findViewById(R.id.cryst);
        cryst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/cryst";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        solv = (Button) findViewById(R.id.solv);
        solv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/solv";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        solv_opt = (Button) findViewById(R.id.solv_opt);
        solv_opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/solv/opt";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        solv_opt_results = (Button) findViewById(R.id.solv_opt_results);
        solv_opt_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/solv/opt/results";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        solv_thermo = (Button) findViewById(R.id.solv_thermo);
        solv_thermo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/solv/thermo";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        solv_thermo_results = (Button) findViewById(R.id.solv_thermo_results);
        solv_thermo_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/output/solv/thermo/results";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

//        cp2k = (Button) findViewById(R.id.cp2k);
//        cp2k.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Path = getFilesDir()+"/cp2k";
//                try {
//                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(Path);
//                    outputWriter.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
//                startActivity(intent);
//            }
//        });
//
//        basis = (Button) findViewById(R.id.basis);
//        basis.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Path = getFilesDir()+"/basis";
//                try {
//                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(Path);
//                    outputWriter.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
//                startActivity(intent);
//            }
//        });
//
//        DFTB = (Button) findViewById(R.id.DFTB);
//        DFTB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Path = getFilesDir()+"/basis/DFTB";
//                try {
//                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(Path);
//                    outputWriter.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
//                startActivity(intent);
//            }
//        });
//
//        nonscc = (Button) findViewById(R.id.nonscc);
//        nonscc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Path = getFilesDir()+"/basis/DFTB/nonscc";
//                try {
//                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(Path);
//                    outputWriter.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
//                startActivity(intent);
//            }
//        });
//
//        scc = (Button) findViewById(R.id.scc);
//        scc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Path = getFilesDir()+"/basis/DFTB/scc";
//                try {
//                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(Path);
//                    outputWriter.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
//                startActivity(intent);
//            }
//        });
//
//        xc_section = (Button) findViewById(R.id.xc_section);
//        xc_section.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Path = getFilesDir()+"/basis/xc_section";
//                try {
//                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
//                    outputWriter.write(Path);
//                    outputWriter.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
//                startActivity(intent);
//            }
//        });

        dftb = (Button) findViewById(R.id.dftb);
        dftb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/dftb";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        sk_files = (Button) findViewById(R.id.sk_files);
        sk_files.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/sk_files";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        references = (Button) findViewById(R.id.references);
        references.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Path = getFilesDir()+"/reference";
                try {
                    FileOutputStream fileout = openFileOutput("CustomExportPath.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Path);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(CustomExport.this, CustomPicker.class);
                startActivity(intent);
            }
        });

        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomExport.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
