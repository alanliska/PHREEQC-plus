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

    Button start_xbasic0001;
//    Button start_xbasic001;
    Button start_xbasic01;
    Button start_xbasic1;
    Button start_xbasic0012;
//    Button start_xbasic012;
    Button start_xbasic12;
    Button start_xbasic2;
    Button start_xbasic3;
    Button start_xbasic4;
    Button start_xbasic0045;
//    Button start_xbasic045;
    Button start_xbasic45;
    Button start_xbasic5;
    Button start_xbasic6;
    Button start_xbasic7;
    Button start_xbasic8;
    Button start_xbasic9;
    Button start_xbasic10;
    Button start_gcm1;
    Button start_gcm2;
    Button start_gcm3;
    Button start_compg;
//    Button start_compgCP2K;
    Button start_compgDFTB;
    Button start_compgMOPAC;
    Button start_compl;
    Button start_compc;
    Button start_comps;
//    Button start_compsCP2K;
    Button start_compsDFTB;
    Button start_compsMOPAC;
    Button start_compss;
//    Button start_compssCP2K;
    Button start_compssDFTB;
    Button start_compssMOPAC;
    Button start_compgcm1;
    Button start_compgcm2;
    Button start_compgcm3;
//    Button start_compgcm4;
    Button start_datgcm1;
    Button start_datgcm2;
    Button start_datgcm3;
    Button start_refg;
    Button start_refl;
    Button start_refc;
    Button start_refs;
    Button start_refss;
    Button start_refgcm1;
    Button start_refgcm2;
    Button start_refgcm3;
//    Button start_refgcm4;
    Button start_vdw;
    Button modify_mulliken;
    Button modify_esp;
    Button modify_solvation;
    Button modify_uniuni;
    Button modify_unibi;
    Button modify_bibi;
    Button modify_bitri;
    Button modify_gcm1kin;
    Button modify_gcm2kin;
    Button modify_gcm3kin;
    Button modify_gcm1kinpar;
    Button modify_gcm2kinpar;
    Button modify_gcm3kinpar;
    Button modify_generalinit;
    Button modify_generalts;
    Button modify_generalmopac;
    Button backup_restore;
//    Button start_refgcp2k;
//    Button start_refscp2k;
//    Button start_refsscp2k;
    Button start_refgdftb;
    Button start_refsdftb;
    Button start_refssdftb;
    Button modify_dftbspectrum;
    Button modify_mopacspectrum;
    Button Quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.devmode);

        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);
        start_xbasic0001 = (Button) findViewById(R.id.start_xbasic0001);
//        start_xbasic001 = (Button) findViewById(R.id.start_xbasic001);
        start_xbasic01 = (Button) findViewById(R.id.start_xbasic01);
        start_xbasic1 = (Button) findViewById(R.id.start_xbasic1);
        start_xbasic12 = (Button) findViewById(R.id.start_xbasic12);
//        start_xbasic012 = (Button) findViewById(R.id.start_xbasic012);
        start_xbasic0012 = (Button) findViewById(R.id.start_xbasic0012);
        start_xbasic2 = (Button) findViewById(R.id.start_xbasic2);
        start_xbasic3 = (Button) findViewById(R.id.start_xbasic3);
        start_xbasic4 = (Button) findViewById(R.id.start_xbasic4);
        start_xbasic45 = (Button) findViewById(R.id.start_xbasic45);
//        start_xbasic045 = (Button) findViewById(R.id.start_xbasic045);
        start_xbasic0045 = (Button) findViewById(R.id.start_xbasic0045);
        start_xbasic5 = (Button) findViewById(R.id.start_xbasic5);
        start_xbasic6 = (Button) findViewById(R.id.start_xbasic6);
        start_xbasic7 = (Button) findViewById(R.id.start_xbasic7);
        start_xbasic8 = (Button) findViewById(R.id.start_xbasic8);
        start_xbasic9 = (Button) findViewById(R.id.start_xbasic9);
        start_xbasic10 = (Button) findViewById(R.id.start_xbasic10);
        start_gcm1 = (Button) findViewById(R.id.start_gcm1);
        start_gcm2 = (Button) findViewById(R.id.start_gcm2);
        start_gcm3 = (Button) findViewById(R.id.start_gcm3);
        start_compg = (Button) findViewById(R.id.start_compg);
        start_compgMOPAC = (Button) findViewById(R.id.start_compgMOPAC);
//        start_compgCP2K = (Button) findViewById(R.id.start_compgCP2K);
        start_compgDFTB = (Button) findViewById(R.id.start_compgDFTB);
        start_compl = (Button) findViewById(R.id.start_compl);
        start_compc = (Button) findViewById(R.id.start_compc);
        start_comps = (Button) findViewById(R.id.start_comps);
        start_compsMOPAC = (Button) findViewById(R.id.start_compsMOPAC);
//        start_compsCP2K = (Button) findViewById(R.id.start_compsCP2K);
        start_compsDFTB = (Button) findViewById(R.id.start_compsDFTB);
        start_compss = (Button) findViewById(R.id.start_compss);
        start_compssMOPAC = (Button) findViewById(R.id.start_compssMOPAC);
//        start_compssCP2K = (Button) findViewById(R.id.start_compssCP2K);
        start_compssDFTB = (Button) findViewById(R.id.start_compssDFTB);
        start_compgcm1 = (Button) findViewById(R.id.start_compgcm1);
        start_compgcm2 = (Button) findViewById(R.id.start_compgcm2);
        start_compgcm3 = (Button) findViewById(R.id.start_compgcm3);
//        start_compgcm4 = (Button) findViewById(R.id.start_compgcm4);
        start_datgcm1 = (Button) findViewById(R.id.start_datgcm1);
        start_datgcm2 = (Button) findViewById(R.id.start_datgcm2);
        start_datgcm3 = (Button) findViewById(R.id.start_datgcm3);
        start_refg = (Button) findViewById(R.id.start_refg);
        start_refl = (Button) findViewById(R.id.start_refl);
        start_refc = (Button) findViewById(R.id.start_refc);
        start_refs = (Button) findViewById(R.id.start_refs);
        start_refss = (Button) findViewById(R.id.start_refss);
//        start_refgcp2k = (Button) findViewById(R.id.start_refgcp2k);
//        start_refscp2k = (Button) findViewById(R.id.start_refscp2k);
//        start_refsscp2k = (Button) findViewById(R.id.start_refsscp2k);
        start_refgdftb = (Button) findViewById(R.id.start_refgdftb);
        start_refsdftb = (Button) findViewById(R.id.start_refsdftb);
        start_refssdftb = (Button) findViewById(R.id.start_refssdftb);
        start_refgcm1 = (Button) findViewById(R.id.start_refgcm1);
        start_refgcm2 = (Button) findViewById(R.id.start_refgcm2);
        start_refgcm3 = (Button) findViewById(R.id.start_refgcm3);
//        start_refgcm4 = (Button) findViewById(R.id.start_refgcm4);
        start_shelltools = (Button) findViewById(R.id.start_shelltools);

        modify_mulliken = (Button) findViewById(R.id.modify_mulliken);
        modify_esp = (Button) findViewById(R.id.modify_esp);
        modify_solvation = (Button) findViewById(R.id.modify_solvation);

        modify_mopacspectrum = (Button) findViewById(R.id.modify_mopacspectrum);
        modify_mopacspectrum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic14.class);
                startActivity(intent);
            }
        });

        modify_dftbspectrum = (Button) findViewById(R.id.modify_dftbspectrum);
        modify_dftbspectrum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic13.class);
                startActivity(intent);
            }
        });

        backup_restore = (Button) findViewById(R.id.backup_restore);
        backup_restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, BackupRestore.class);
                startActivity(intent);
            }
        });

        start_shelltools = (Button) findViewById(R.id.start_shelltools);
        start_shelltools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, ShellTools.class);
                startActivity(intent);
            }
        });

        start_xbasic0001 = (Button) findViewById(R.id.start_xbasic0001);
        start_xbasic0001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic0001.class);
                startActivity(intent);
            }
        });

//        start_xbasic001 = (Button) findViewById(R.id.start_xbasic001);
//        start_xbasic001.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DevMode.this, XBasic001.class);
//                startActivity(intent);
//            }
//        });


        start_xbasic01 = (Button) findViewById(R.id.start_xbasic01);
        start_xbasic01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic01.class);
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

        start_xbasic0012 = (Button) findViewById(R.id.start_xbasic0012);
        start_xbasic0012.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic0012.class);
                startActivity(intent);
            }
        });

//        start_xbasic012 = (Button) findViewById(R.id.start_xbasic012);
//        start_xbasic012.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DevMode.this, XBasic012.class);
//                startActivity(intent);
//            }
//        });

        start_xbasic12 = (Button) findViewById(R.id.start_xbasic12);
        start_xbasic12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic12.class);
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

        start_xbasic0045 = (Button) findViewById(R.id.start_xbasic0045);
        start_xbasic0045.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic0045.class);
                startActivity(intent);
            }
        });

//        start_xbasic045 = (Button) findViewById(R.id.start_xbasic045);
//        start_xbasic045.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DevMode.this, XBasic045.class);
//                startActivity(intent);
//            }
//        });

        start_xbasic45 = (Button) findViewById(R.id.start_xbasic45);
        start_xbasic45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic45.class);
                startActivity(intent);
            }
        });

        start_xbasic5 = (Button) findViewById(R.id.start_xbasic5);
        start_xbasic5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic5.class);
                startActivity(intent);
            }
        });

        start_xbasic6 = (Button) findViewById(R.id.start_xbasic6);
        start_xbasic6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic6.class);
                startActivity(intent);
            }
        });

        start_xbasic7 = (Button) findViewById(R.id.start_xbasic7);
        start_xbasic7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic7.class);
                startActivity(intent);
            }
        });

        start_xbasic8 = (Button) findViewById(R.id.start_xbasic8);
        start_xbasic8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic8.class);
                startActivity(intent);
            }
        });

        start_xbasic9 = (Button) findViewById(R.id.start_xbasic9);
        start_xbasic9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic9.class);
                startActivity(intent);
            }
        });

        start_xbasic10 = (Button) findViewById(R.id.start_xbasic10);
        start_xbasic10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, XBasic10.class);
                startActivity(intent);
            }
        });

        start_gcm1 = (Button) findViewById(R.id.start_gcm1);
        start_gcm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, GCM1Sum.class);
                startActivity(intent);
            }
        });

        start_gcm2 = (Button) findViewById(R.id.start_gcm2);
        start_gcm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, GCM2Sum.class);
                startActivity(intent);
            }
        });

        start_gcm3 = (Button) findViewById(R.id.start_gcm3);
        start_gcm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, GCM3Sum.class);
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

//        start_refgcp2k = (Button) findViewById(R.id.start_refgcp2k);
//        start_refgcp2k.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DevMode.this, RefgCP2K.class);
//                startActivity(intent);
//            }
//        });

        start_refgdftb = (Button) findViewById(R.id.start_refgdftb);
        start_refgdftb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, RefgDftb.class);
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

//        start_refscp2k = (Button) findViewById(R.id.start_refscp2k);
//        start_refscp2k.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DevMode.this, RefsCP2K.class);
//                startActivity(intent);
//            }
//        });

        start_refsdftb = (Button) findViewById(R.id.start_refsdftb);
        start_refsdftb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, RefsDftb.class);
                startActivity(intent);
            }
        });

        start_refss = (Button) findViewById(R.id.start_refss);
        start_refss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Refss.class);
                startActivity(intent);
            }
        });

//        start_refsscp2k = (Button) findViewById(R.id.start_refsscp2k);
//        start_refsscp2k.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DevMode.this, RefssCP2K.class);
//                startActivity(intent);
//            }
//        });

        start_refssdftb = (Button) findViewById(R.id.start_refssdftb);
        start_refssdftb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, RefssDftb.class);
                startActivity(intent);
            }
        });

        start_refgcm1 = (Button) findViewById(R.id.start_refgcm1);
        start_refgcm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, RefGCM1.class);
                startActivity(intent);
            }
        });

        start_refgcm2 = (Button) findViewById(R.id.start_refgcm2);
        start_refgcm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, RefGCM2.class);
                startActivity(intent);
            }
        });

        start_refgcm3 = (Button) findViewById(R.id.start_refgcm3);
        start_refgcm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, RefGCM3.class);
                startActivity(intent);
            }
        });

//        start_refgcm4 = (Button) findViewById(R.id.start_refgcm4);
//        start_refgcm4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DevMode.this, RefGCM4.class);
//                startActivity(intent);
//            }
//        });

        start_compg = (Button) findViewById(R.id.start_compg);
        start_compg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Compg.class);
                startActivity(intent);
            }
        });

        start_compgMOPAC = (Button) findViewById(R.id.start_compgMOPAC);
        start_compgMOPAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, CompgMOPAC.class);
                startActivity(intent);
            }
        });

//        start_compgCP2K = (Button) findViewById(R.id.start_compgCP2K);
//        start_compgCP2K.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DevMode.this, CompgCP2K.class);
//                startActivity(intent);
//            }
//        });

        start_compgDFTB = (Button) findViewById(R.id.start_compgDFTB);
        start_compgDFTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, CompgDftb.class);
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

        start_compsMOPAC = (Button) findViewById(R.id.start_compsMOPAC);
        start_compsMOPAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, CompsMOPAC.class);
                startActivity(intent);
            }
        });

//        start_compsCP2K = (Button) findViewById(R.id.start_compsCP2K);
//        start_compsCP2K.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DevMode.this, CompsCP2K.class);
//                startActivity(intent);
//            }
//        });

        start_compsDFTB = (Button) findViewById(R.id.start_compsDFTB);
        start_compsDFTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, CompsDftb.class);
                startActivity(intent);
            }
        });

        start_compss = (Button) findViewById(R.id.start_compss);
        start_compss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, Compss.class);
                startActivity(intent);
            }
        });

        start_compssMOPAC = (Button) findViewById(R.id.start_compssMOPAC);
        start_compssMOPAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, CompssMOPAC.class);
                startActivity(intent);
            }
        });

//        start_compssCP2K = (Button) findViewById(R.id.start_compssCP2K);
//        start_compssCP2K.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DevMode.this, CompssCP2K.class);
//                startActivity(intent);
//            }
//        });

        start_compssDFTB = (Button) findViewById(R.id.start_compssDFTB);
        start_compssDFTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, CompssDftb.class);
                startActivity(intent);
            }
        });

        start_compgcm1 = (Button) findViewById(R.id.start_compgcm1);
        start_compgcm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, CompGCM1.class);
                startActivity(intent);
            }
        });

        start_compgcm2 = (Button) findViewById(R.id.start_compgcm2);
        start_compgcm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, CompGCM2.class);
                startActivity(intent);
            }
        });

        start_compgcm3 = (Button) findViewById(R.id.start_compgcm3);
        start_compgcm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, CompGCM3.class);
                startActivity(intent);
            }
        });

//        start_compgcm4 = (Button) findViewById(R.id.start_compgcm4);
//        start_compgcm4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DevMode.this, CompGCM4.class);
//                startActivity(intent);
//            }
//        });

        start_datgcm1 = (Button) findViewById(R.id.start_datgcm1);
        start_datgcm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, DatGCM1.class);
                startActivity(intent);
            }
        });

        start_datgcm2 = (Button) findViewById(R.id.start_datgcm2);
        start_datgcm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, DatGCM2.class);
                startActivity(intent);
            }
        });

        start_datgcm3 = (Button) findViewById(R.id.start_datgcm3);
        start_datgcm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, DatGCM3.class);
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

        modify_gcm1kin = (Button) findViewById(R.id.modify_gcm1kin);
        modify_gcm1kin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, ModifyGCM1Kin.class);
                startActivity(intent);
            }
        });

        modify_gcm2kin = (Button) findViewById(R.id.modify_gcm2kin);
        modify_gcm2kin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, ModifyGCM2Kin.class);
                startActivity(intent);
            }
        });

        modify_gcm3kin = (Button) findViewById(R.id.modify_gcm3kin);
        modify_gcm3kin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, ModifyGCM3Kin.class);
                startActivity(intent);
            }
        });

        modify_gcm1kinpar = (Button) findViewById(R.id.modify_gcm1kinpar);
        modify_gcm1kinpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, ModifyGCM1KinPar.class);
                startActivity(intent);
            }
        });

        modify_gcm2kinpar = (Button) findViewById(R.id.modify_gcm2kinpar);
        modify_gcm2kinpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, ModifyGCM2KinPar.class);
                startActivity(intent);
            }
        });

        modify_gcm3kinpar = (Button) findViewById(R.id.modify_gcm3kinpar);
        modify_gcm3kinpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, ModifyGCM3KinPar.class);
                startActivity(intent);
            }
        });

        modify_generalinit = (Button) findViewById(R.id.modify_generalinit);
        modify_generalinit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, ModifyGeneralInit.class);
                startActivity(intent);
            }
        });

        modify_generalts = (Button) findViewById(R.id.modify_generalts);
        modify_generalts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, ModifyGeneralTS.class);
                startActivity(intent);
            }
        });

        modify_generalmopac = (Button) findViewById(R.id.modify_generalmopac);
        modify_generalmopac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevMode.this, ModifyGeneralMOPAC.class);
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
