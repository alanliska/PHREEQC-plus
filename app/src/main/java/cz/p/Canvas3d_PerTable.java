package cz.p;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import cz.p.Canvas3d_main;

public class Canvas3d_PerTable extends Canvas3d_main {

    private Button elmntH;
    private Button elmntLi;
    private Button elmntNa;
    private Button elmntK;
    private Button elmntRb;
    private Button elmntCs;
    private Button elmntFr;

    private Button elmntBe;
    private Button elmntMg;
    private Button elmntCa;
    private Button elmntSr;
    private Button elmntBa;
    private Button elmntRa;

    private Button elmntB;
    private Button elmntAl;
    private Button elmntGa;
    private Button elmntIn;
    private Button elmntTl;
    private Button elmntNh;

    private Button elmntC;
    private Button elmntSi;
    private Button elmntGe;
    private Button elmntSn;
    private Button elmntPb;
    private Button elmntFl;

    private Button elmntN;
    private Button elmntP;
    private Button elmntAs;
    private Button elmntSb;
    private Button elmntBi;
    private Button elmntMc;

    private Button elmntO;
    private Button elmntS;
    private Button elmntSe;
    private Button elmntTe;
    private Button elmntPo;
    private Button elmntLv;

    private Button elmntF;
    private Button elmntCl;
    private Button elmntBr;
    private Button elmntI;
    private Button elmntAt;
    private Button elmntTs;

    private Button elmntHe;
    private Button elmntNe;
    private Button elmntAr;
    private Button elmntKr;
    private Button elmntXe;
    private Button elmntRn;
    private Button elmntOg;

    private Button elmntSc;
    private Button elmntY;
    private Button elmntLa;
    private Button elmntAc;

    private Button elmntTi;
    private Button elmntZr;
    private Button elmntHf;
    private Button elmntRf;

    private Button elmntV;
    private Button elmntNb;
    private Button elmntTa;
    private Button elmntDb;

    private Button elmntCr;
    private Button elmntMo;
    private Button elmntW;
    private Button elmntSg;

    private Button elmntMn;
    private Button elmntTc;
    private Button elmntRe;
    private Button elmntBh;

    private Button elmntFe;
    private Button elmntRu;
    private Button elmntOs;
    private Button elmntHs;

    private Button elmntCo;
    private Button elmntRh;
    private Button elmntIr;
    private Button elmntMt;

    private Button elmntNi;
    private Button elmntPd;
    private Button elmntPt;
    private Button elmntDs;

    private Button elmntCu;
    private Button elmntAg;
    private Button elmntAu;
    private Button elmntRg;

    private Button elmntZn;
    private Button elmntCd;
    private Button elmntHg;
    private Button elmntCn;

    private Button elmntCe;
    private Button elmntPr;
    private Button elmntNd;
    private Button elmntPm;
    private Button elmntSm;
    private Button elmntEu;
    private Button elmntGd;
    private Button elmntTb;
    private Button elmntDy;
    private Button elmntHo;
    private Button elmntEr;
    private Button elmntTm;
    private Button elmntYb;
    private Button elmntLu;

    private Button elmntTh;
    private Button elmntPa;
    private Button elmntU;
    private Button elmntNp;
    private Button elmntPu;
    private Button elmntAm;
    private Button elmntCm;
    private Button elmntBk;
    private Button elmntCf;
    private Button elmntEs;
    private Button elmntFm;
    private Button elmntMd;
    private Button elmntNo;
    private Button elmntLr;

    private Button dummy102;
    private Button dummy103;
    private Button dummy104;
    private Button dummy105;
    private Button dummy106;
    private Button dummy107;
    private Button dummy108;
    private Button dummy109;
    private Button dummy110;
    private Button dummy111;
    private Button dummy112;
    private Button dummy113;
    private Button dummy114;
    private Button dummy115;
    private Button dummy116;
    private Button dummy117;

    private Button dummy203;
    private Button dummy204;
    private Button dummy205;
    private Button dummy206;
    private Button dummy207;
    private Button dummy208;
    private Button dummy209;
    private Button dummy210;
    private Button dummy211;
    private Button dummy212;

    private Button dummy303;
    private Button dummy304;
    private Button dummy305;
    private Button dummy306;
    private Button dummy307;
    private Button dummy308;
    private Button dummy309;
    private Button dummy310;
    private Button dummy311;
    private Button dummy312;

    private Button dummy603;
    private Button dummy703;
    private Button dummy801;
    private Button dummy802;
    private Button dummy901;
    private Button dummy902;

    private TextView elmnt_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.canvas3d_pertable);

        elmnt_desc = (TextView) findViewById(R.id.elmnt_desc);
        elmntH = (Button) findViewById(R.id.elmntH);
        elmntH.setOnClickListener(H);
        elmntLi = (Button) findViewById(R.id.elmntLi);
        elmntLi.setOnClickListener(Li);
        elmntNa = (Button) findViewById(R.id.elmntNa);
        elmntNa.setOnClickListener(Na);
        elmntK = (Button) findViewById(R.id.elmntK);
        elmntK.setOnClickListener(K);
        elmntRb = (Button) findViewById(R.id.elmntRb);
        elmntRb.setOnClickListener(Rb);
        elmntCs = (Button) findViewById(R.id.elmntCs);
        elmntCs.setOnClickListener(Cs);
        elmntFr = (Button) findViewById(R.id.elmntFr);
        elmntFr.setOnClickListener(Fr);

        elmntBe = (Button) findViewById(R.id.elmntBe);
        elmntBe.setOnClickListener(Be);
        elmntMg = (Button) findViewById(R.id.elmntMg);
        elmntMg.setOnClickListener(Mg);
        elmntCa = (Button) findViewById(R.id.elmntCa);
        elmntCa.setOnClickListener(Ca);
        elmntSr = (Button) findViewById(R.id.elmntSr);
        elmntSr.setOnClickListener(Sr);
        elmntBa = (Button) findViewById(R.id.elmntBa);
        elmntBa.setOnClickListener(Ba);
        elmntRa = (Button) findViewById(R.id.elmntRa);
        elmntRa.setOnClickListener(Ra);

        elmntB = (Button) findViewById(R.id.elmntB);
        elmntB.setOnClickListener(B);
        elmntAl = (Button) findViewById(R.id.elmntAl);
        elmntAl.setOnClickListener(Al);
        elmntGa = (Button) findViewById(R.id.elmntGa);
        elmntGa.setOnClickListener(Ga);
        elmntIn = (Button) findViewById(R.id.elmntIn);
        elmntIn.setOnClickListener(In);
        elmntTl = (Button) findViewById(R.id.elmntTl);
        elmntTl.setOnClickListener(Tl);
        elmntNh = (Button) findViewById(R.id.elmntNh);
        elmntNh.setOnClickListener(Nh);

        elmntC = (Button) findViewById(R.id.elmntC);
        elmntC.setOnClickListener(C);
        elmntSi = (Button) findViewById(R.id.elmntSi);
        elmntSi.setOnClickListener(Si);
        elmntGe = (Button) findViewById(R.id.elmntGe);
        elmntGe.setOnClickListener(Ge);
        elmntSn = (Button) findViewById(R.id.elmntSn);
        elmntSn.setOnClickListener(Sn);
        elmntPb = (Button) findViewById(R.id.elmntPb);
        elmntPb.setOnClickListener(Pb);
        elmntFl = (Button) findViewById(R.id.elmntFl);
        elmntFl.setOnClickListener(Fl);

        elmntN = (Button) findViewById(R.id.elmntN);
        elmntN.setOnClickListener(N);
        elmntP = (Button) findViewById(R.id.elmntP);
        elmntP.setOnClickListener(P);
        elmntAs = (Button) findViewById(R.id.elmntAs);
        elmntAs.setOnClickListener(As);
        elmntSb = (Button) findViewById(R.id.elmntSb);
        elmntSb.setOnClickListener(Sb);
        elmntBi = (Button) findViewById(R.id.elmntBi);
        elmntBi.setOnClickListener(Bi);
        elmntMc = (Button) findViewById(R.id.elmntMc);
        elmntMc.setOnClickListener(Mc);

        elmntO = (Button) findViewById(R.id.elmntO);
        elmntO.setOnClickListener(O);
        elmntS = (Button) findViewById(R.id.elmntS);
        elmntS.setOnClickListener(S);
        elmntSe = (Button) findViewById(R.id.elmntSe);
        elmntSe.setOnClickListener(Se);
        elmntTe = (Button) findViewById(R.id.elmntTe);
        elmntTe.setOnClickListener(Te);
        elmntPo = (Button) findViewById(R.id.elmntPo);
        elmntPo.setOnClickListener(Po);
        elmntLv = (Button) findViewById(R.id.elmntLv);
        elmntLv.setOnClickListener(Lv);

        elmntF = (Button) findViewById(R.id.elmntF);
        elmntF.setOnClickListener(F);
        elmntCl = (Button) findViewById(R.id.elmntCl);
        elmntCl.setOnClickListener(Cl);
        elmntBr = (Button) findViewById(R.id.elmntBr);
        elmntBr.setOnClickListener(Br);
        elmntI = (Button) findViewById(R.id.elmntI);
        elmntI.setOnClickListener(I);
        elmntAt = (Button) findViewById(R.id.elmntAt);
        elmntAt.setOnClickListener(At);
        elmntTs = (Button) findViewById(R.id.elmntTs);
        elmntTs.setOnClickListener(Ts);

        elmntHe = (Button) findViewById(R.id.elmntHe);
        elmntHe.setOnClickListener(He);
        elmntNe = (Button) findViewById(R.id.elmntNe);
        elmntNe.setOnClickListener(Ne);
        elmntAr = (Button) findViewById(R.id.elmntAr);
        elmntAr.setOnClickListener(Ar);
        elmntKr = (Button) findViewById(R.id.elmntKr);
        elmntKr.setOnClickListener(Kr);
        elmntXe = (Button) findViewById(R.id.elmntXe);
        elmntXe.setOnClickListener(Xe);
        elmntRn = (Button) findViewById(R.id.elmntRn);
        elmntRn.setOnClickListener(Rn);
        elmntOg = (Button) findViewById(R.id.elmntOg);
        elmntOg.setOnClickListener(Og);

        elmntSc = (Button) findViewById(R.id.elmntSc);
        elmntSc.setOnClickListener(Sc);
        elmntY = (Button) findViewById(R.id.elmntY);
        elmntY.setOnClickListener(Y);
        elmntLa = (Button) findViewById(R.id.elmntLa);
        elmntLa.setOnClickListener(La);
        elmntAc = (Button) findViewById(R.id.elmntAc);
        elmntAc.setOnClickListener(Ac);

        elmntTi = (Button) findViewById(R.id.elmntTi);
        elmntTi.setOnClickListener(Ti);
        elmntZr = (Button) findViewById(R.id.elmntZr);
        elmntZr.setOnClickListener(Zr);
        elmntHf = (Button) findViewById(R.id.elmntHf);
        elmntHf.setOnClickListener(Hf);
        elmntRf = (Button) findViewById(R.id.elmntRf);
        elmntRf.setOnClickListener(Rf);

        elmntV = (Button) findViewById(R.id.elmntV);
        elmntV.setOnClickListener(V);
        elmntNb = (Button) findViewById(R.id.elmntNb);
        elmntNb.setOnClickListener(Nb);
        elmntTa = (Button) findViewById(R.id.elmntTa);
        elmntTa.setOnClickListener(Ta);
        elmntDb = (Button) findViewById(R.id.elmntDb);
        elmntDb.setOnClickListener(Db);

        elmntCr = (Button) findViewById(R.id.elmntCr);
        elmntCr.setOnClickListener(Cr);
        elmntMo = (Button) findViewById(R.id.elmntMo);
        elmntMo.setOnClickListener(Mo);
        elmntW = (Button) findViewById(R.id.elmntW);
        elmntW.setOnClickListener(W);
        elmntSg = (Button) findViewById(R.id.elmntSg);
        elmntSg.setOnClickListener(Sg);

        elmntMn = (Button) findViewById(R.id.elmntMn);
        elmntMn.setOnClickListener(Mn);
        elmntTc = (Button) findViewById(R.id.elmntTc);
        elmntTc.setOnClickListener(Tc);
        elmntRe = (Button) findViewById(R.id.elmntRe);
        elmntRe.setOnClickListener(Re);
        elmntBh = (Button) findViewById(R.id.elmntBh);
        elmntBh.setOnClickListener(Bh);

        elmntFe = (Button) findViewById(R.id.elmntFe);
        elmntFe.setOnClickListener(Fe);
        elmntRu = (Button) findViewById(R.id.elmntRu);
        elmntRu.setOnClickListener(Ru);
        elmntOs = (Button) findViewById(R.id.elmntOs);
        elmntOs.setOnClickListener(Os);
        elmntHs = (Button) findViewById(R.id.elmntHs);
        elmntHs.setOnClickListener(Hs);

        elmntCo = (Button) findViewById(R.id.elmntCo);
        elmntCo.setOnClickListener(Co);
        elmntRh = (Button) findViewById(R.id.elmntRh);
        elmntRh.setOnClickListener(Rh);
        elmntIr = (Button) findViewById(R.id.elmntIr);
        elmntIr.setOnClickListener(Ir);
        elmntMt = (Button) findViewById(R.id.elmntMt);
        elmntMt.setOnClickListener(Mt);

        elmntNi = (Button) findViewById(R.id.elmntNi);
        elmntNi.setOnClickListener(Ni);
        elmntPd = (Button) findViewById(R.id.elmntPd);
        elmntPd.setOnClickListener(Pd);
        elmntPt = (Button) findViewById(R.id.elmntPt);
        elmntPt.setOnClickListener(Pt);
        elmntDs = (Button) findViewById(R.id.elmntDs);
        elmntDs.setOnClickListener(Ds);

        elmntCu = (Button) findViewById(R.id.elmntCu);
        elmntCu.setOnClickListener(Cu);
        elmntAg = (Button) findViewById(R.id.elmntAg);
        elmntAg.setOnClickListener(Ag);
        elmntAu = (Button) findViewById(R.id.elmntAu);
        elmntAu.setOnClickListener(Au);
        elmntRg = (Button) findViewById(R.id.elmntRg);
        elmntRg.setOnClickListener(Rg);

        elmntZn = (Button) findViewById(R.id.elmntZn);
        elmntZn.setOnClickListener(Zn);
        elmntCd = (Button) findViewById(R.id.elmntCd);
        elmntCd.setOnClickListener(Cd);
        elmntHg = (Button) findViewById(R.id.elmntHg);
        elmntHg.setOnClickListener(Hg);
        elmntCn = (Button) findViewById(R.id.elmntCn);
        elmntCn.setOnClickListener(Cn);

        elmntCe = (Button) findViewById(R.id.elmntCe);
        elmntCe.setOnClickListener(Ce);
        elmntPr = (Button) findViewById(R.id.elmntPr);
        elmntPr.setOnClickListener(Pr);
        elmntNd = (Button) findViewById(R.id.elmntNd);
        elmntNd.setOnClickListener(Nd);
        elmntPm = (Button) findViewById(R.id.elmntPm);
        elmntPm.setOnClickListener(Pm);
        elmntSm = (Button) findViewById(R.id.elmntSm);
        elmntSm.setOnClickListener(Sm);
        elmntEu = (Button) findViewById(R.id.elmntEu);
        elmntEu.setOnClickListener(Eu);
        elmntGd = (Button) findViewById(R.id.elmntGd);
        elmntGd.setOnClickListener(Gd);
        elmntTb = (Button) findViewById(R.id.elmntTb);
        elmntTb.setOnClickListener(Tb);
        elmntDy = (Button) findViewById(R.id.elmntDy);
        elmntDy.setOnClickListener(Dy);
        elmntHo = (Button) findViewById(R.id.elmntHo);
        elmntHo.setOnClickListener(Ho);
        elmntEr = (Button) findViewById(R.id.elmntEr);
        elmntEr.setOnClickListener(Er);
        elmntTm = (Button) findViewById(R.id.elmntTm);
        elmntTm.setOnClickListener(Tm);
        elmntYb = (Button) findViewById(R.id.elmntYb);
        elmntYb.setOnClickListener(Yb);
        elmntLu = (Button) findViewById(R.id.elmntLu);
        elmntLu.setOnClickListener(Lu);

        elmntTh = (Button) findViewById(R.id.elmntTh);
        elmntTh.setOnClickListener(Th);
        elmntPa = (Button) findViewById(R.id.elmntPa);
        elmntPa.setOnClickListener(Pa);
        elmntU = (Button) findViewById(R.id.elmntU);
        elmntU.setOnClickListener(U);
        elmntNp = (Button) findViewById(R.id.elmntNp);
        elmntNp.setOnClickListener(Np);
        elmntPu = (Button) findViewById(R.id.elmntPu);
        elmntPu.setOnClickListener(Pu);
        elmntAm = (Button) findViewById(R.id.elmntAm);
        elmntAm.setOnClickListener(Am);
        elmntCm = (Button) findViewById(R.id.elmntCm);
        elmntCm.setOnClickListener(Cm);
        elmntBk = (Button) findViewById(R.id.elmntBk);
        elmntBk.setOnClickListener(Bk);
        elmntCf = (Button) findViewById(R.id.elmntCf);
        elmntCf.setOnClickListener(Cf);
        elmntEs = (Button) findViewById(R.id.elmntEs);
        elmntEs.setOnClickListener(Es);
        elmntFm = (Button) findViewById(R.id.elmntFm);
        elmntFm.setOnClickListener(Fm);
        elmntMd = (Button) findViewById(R.id.elmntMd);
        elmntMd.setOnClickListener(Md);
        elmntNo = (Button) findViewById(R.id.elmntNo);
        elmntNo.setOnClickListener(No);
        elmntLr = (Button) findViewById(R.id.elmntLr);
        elmntLr.setOnClickListener(Lr);

        dummy102 = (Button) findViewById(R.id.dummy102);
        dummy103 = (Button) findViewById(R.id.dummy103);
        dummy104 = (Button) findViewById(R.id.dummy104);
        dummy105 = (Button) findViewById(R.id.dummy105);
        dummy106 = (Button) findViewById(R.id.dummy106);
        dummy107 = (Button) findViewById(R.id.dummy107);
        dummy108 = (Button) findViewById(R.id.dummy108);
        dummy109 = (Button) findViewById(R.id.dummy109);
        dummy110 = (Button) findViewById(R.id.dummy110);
        dummy111 = (Button) findViewById(R.id.dummy111);
        dummy112 = (Button) findViewById(R.id.dummy112);
        dummy113 = (Button) findViewById(R.id.dummy113);
        dummy114 = (Button) findViewById(R.id.dummy114);
        dummy115 = (Button) findViewById(R.id.dummy115);
        dummy116 = (Button) findViewById(R.id.dummy116);
        dummy117 = (Button) findViewById(R.id.dummy117);
        dummy203 = (Button) findViewById(R.id.dummy203);
        dummy204 = (Button) findViewById(R.id.dummy204);
        dummy205 = (Button) findViewById(R.id.dummy205);
        dummy206 = (Button) findViewById(R.id.dummy206);
        dummy207 = (Button) findViewById(R.id.dummy207);
        dummy208 = (Button) findViewById(R.id.dummy208);
        dummy209 = (Button) findViewById(R.id.dummy209);
        dummy210 = (Button) findViewById(R.id.dummy210);
        dummy211 = (Button) findViewById(R.id.dummy211);
        dummy212 = (Button) findViewById(R.id.dummy212);
        dummy303 = (Button) findViewById(R.id.dummy303);
        dummy304 = (Button) findViewById(R.id.dummy304);
        dummy305 = (Button) findViewById(R.id.dummy305);
        dummy306 = (Button) findViewById(R.id.dummy306);
        dummy307 = (Button) findViewById(R.id.dummy307);
        dummy308 = (Button) findViewById(R.id.dummy308);
        dummy309 = (Button) findViewById(R.id.dummy309);
        dummy310 = (Button) findViewById(R.id.dummy310);
        dummy311 = (Button) findViewById(R.id.dummy311);
        dummy312 = (Button) findViewById(R.id.dummy312);
        dummy603 = (Button) findViewById(R.id.dummy603);
        dummy703 = (Button) findViewById(R.id.dummy703);
        dummy801 = (Button) findViewById(R.id.dummy801);
        dummy802 = (Button) findViewById(R.id.dummy802);
        dummy901 = (Button) findViewById(R.id.dummy901);
        dummy902 = (Button) findViewById(R.id.dummy902);

    }

    public void onStart()
    {
        super.onStart();
    }

    private View.OnClickListener H; {
        H = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("H")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener He; {
        He = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("He")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Li; {
        Li = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Li")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Be; {
        Be = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Be")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener B; {
        B = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("B")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener C; {
        C = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("C")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener N; {
        N = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("N")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener O; {
        O = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("O")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener F; {
        F = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("F")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ne; {
        Ne = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ne")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Na; {
        Na = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Na")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Mg; {
        Mg = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Mg")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Al; {
        Al = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Al")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Si; {
        Si = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Si")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener P; {
        P = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("P")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener S; {
        S = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("S")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Cl; {
        Cl = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Cl")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ar; {
        Ar = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ar")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener K; {
        K = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("K")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ca; {
        Ca = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ca")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Sc; {
        Sc = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Sc")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ti; {
        Ti = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ti")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener V; {
        V = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("V")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Cr; {
        Cr = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Cr")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Mn; {
        Mn = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Mn")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Fe; {
        Fe = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Fe")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Co; {
        Co = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Co")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ni; {
        Ni = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ni")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Cu; {
        Cu = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Cu")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Zn; {
        Zn = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Zn")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ga; {
        Ga = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ga")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ge; {
        Ge = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ge")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener As; {
        As = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("As")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Se; {
        Se = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Se")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Br; {
        Br = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Br")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Kr; {
        Kr = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Kr")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Rb; {
        Rb = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Rb")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Sr; {
        Sr = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Sr")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Y; {
        Y = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("V")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Zr; {
        Zr = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Zr")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Nb; {
        Nb = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Nb")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Mo; {
        Mo = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Mo")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Tc; {
        Tc = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Tc")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ru; {
        Ru = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ru")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Rh; {
        Rh = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Rh")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Pd; {
        Pd = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Pd")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ag; {
        Ag = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ag")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Cd; {
        Cd = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Cd")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener In; {
        In = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("In")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Sn; {
        Sn = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Sn")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Sb; {
        Sb = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Sb")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Te; {
        Te = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Te")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener I; {
        I = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("I")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Xe; {
        Xe = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Xe")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Cs; {
        Cs = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Cs")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ba; {
        Ba = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ba")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener La; {
        La = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("La")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ce; {
        Ce = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ce")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Pr; {
        Pr = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Pr")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Nd; {
        Nd = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Nd")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Pm; {
        Pm = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Pm")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Sm; {
        Sm = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Sm")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Eu; {
        Eu = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Eu")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Gd; {
        Gd = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Gd")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Tb; {
        Tb = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Tb")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Dy; {
        Dy = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Dy")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ho; {
        Ho = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ho")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Er; {
        Er = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Er")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Tm; {
        Tm = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Tm")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Yb; {
        Yb = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Yb")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Lu; {
        Lu = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Lu")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Hf; {
        Hf = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Hf")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ta; {
        Ta = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ta")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener W; {
        W = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("W")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Re; {
        Re = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Re")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Os; {
        Os = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Os")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ir; {
        Ir = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ir")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Pt; {
        Pt = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Pt")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Au; {
        Au = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Au")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Hg; {
        Hg = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Hg")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Tl; {
        Tl = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Tl")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Pb; {
        Pb = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Pb")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Bi; {
        Bi = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Bi")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Po; {
        Po = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Po")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener At; {
        At = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("At")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Rn; {
        Rn = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Rn")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Fr; {
        Fr = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Fr")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ra; {
        Ra = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ra")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ac; {
        Ac = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ac")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Th; {
        Th = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Th")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Pa; {
        Pa = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Pa")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener U; {
        U = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("U")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Np; {
        Np = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Np")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Pu; {
        Pu = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Pu")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Am; {
        Am = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Am")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Cm; {
        Cm = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Cm")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Bk; {
        Bk = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Bk")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Cf; {
        Cf = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Cf")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Es; {
        Es = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Es")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Fm; {
        Fm = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Fm")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Md; {
        Md = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Md")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener No; {
        No = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("No")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Lr; {
        Lr = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Lr")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Rf; {
        Rf = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Rf")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Db; {
        Db = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Db")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Sg; {
        Sg = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Sg")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Bh; {
        Bh = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Bh")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Hs; {
        Hs = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Hs")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Mt; {
        Mt = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Mt")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ds; {
        Ds = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ds")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Rg; {
        Rg = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Rg")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Cn; {
        Cn = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Cn")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Nh; {
        Nh = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Nh")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Fl; {
        Fl = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Fl")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Mc; {
        Mc = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Mc")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Lv; {
        Lv = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Lv")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Ts; {
        Ts = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Ts")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private View.OnClickListener Og; {
        Og = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                try {
                    Scanner scan = new Scanner(new File(getFilesDir() + "/canvas3d/Elmnts.dat"));
                    while (scan.hasNext()) {
                        String curLine = scan.nextLine();
                        String[] splitted = curLine.split("\\s");
                        String element = splitted[0].trim();
                        String radius = splitted[1].trim();
                        String atom_color = splitted[2].trim();
                        String text_color = splitted[3].trim();

                        if (element.equals("Og")) {

                            try {
                                FileOutputStream fileout_elmnt = openFileOutput("Elmnt.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_elmnt = new OutputStreamWriter(fileout_elmnt);
                                outputWriter_elmnt.write(element);
                                outputWriter_elmnt.close();
                                FileOutputStream fileout_rad = openFileOutput("Rad.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_rad = new OutputStreamWriter(fileout_rad);
                                outputWriter_rad.write(radius);
                                outputWriter_rad.close();
                                FileOutputStream fileout_col = openFileOutput("ColorAtom.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_col = new OutputStreamWriter(fileout_col);
                                outputWriter_col.write(atom_color);
                                outputWriter_col.close();
                                FileOutputStream fileout_text = openFileOutput("ColorText.tmp", MODE_PRIVATE);
                                OutputStreamWriter outputWriter_text = new OutputStreamWriter(fileout_text);
                                outputWriter_text.write(text_color);
                                outputWriter_text.close();
                            } catch (Exception e) {
                            }
                            exec("mv "+getFilesDir()+"/Elmnt.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/Rad.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorAtom.tmp "+getFilesDir()+"/canvas3d/");
                            exec("mv "+getFilesDir()+"/ColorText.tmp "+getFilesDir()+"/canvas3d/");
                            Intent intent = new Intent(Canvas3d_PerTable.this, Canvas3d_main.class);
                            startActivity(intent);
                        }
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
    }

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

