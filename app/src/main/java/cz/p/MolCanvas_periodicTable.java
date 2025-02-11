package cz.p;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MolCanvas_periodicTable extends MolCanvas_main {
    public static String Element;
    public static float ElementRadius;
    public static int ElementColor, ElementBorderColor,ElementTextColor;

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
        setContentView(R.layout.molcanvasperiodictable);

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

    public void onStart() {
        super.onStart();
    }

    private View.OnClickListener H;

    {
        H =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "H";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_H");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_H");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_H");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener He;

    {
        He =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "He";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_He");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_He");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_He");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Li;

    {
        Li =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Li";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Li");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Li");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Li");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Be;

    {
        Be =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Be";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Be");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Be");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Be");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener B;

    {
        B =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "B";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_B");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_B");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_B");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener C;

    {
        C =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "C";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_C");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_C");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_C");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener N;

    {
        N =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "N";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_N");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_N");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_N");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener O;

    {
        O =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "O";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_O");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_O");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_O");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener F;

    {
        F =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "F";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_F");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_F");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_F");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ne;

    {
        Ne =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ne";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ne");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ne");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ne");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Na;

    {
        Na =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Na";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Na");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Na");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Na");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Mg;

    {
        Mg =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Mg";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Mg");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Mg");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Mg");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Al;

    {
        Al =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Al";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Al");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Al");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Al");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Si;

    {
        Si =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Si";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Si");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Si");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Si");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener P;

    {
        P =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "P";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_P");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_P");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_P");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener S;

    {
        S =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "S";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_S");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_S");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_S");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Cl;

    {
        Cl =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Cl";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Cl");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Cl");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Cl");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ar;

    {
        Ar =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ar";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ar");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ar");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ar");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener K;

    {
        K =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "K";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_K");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_K");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_K");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ca;

    {
        Ca =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ca";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ca");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ca");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ca");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Sc;

    {
        Sc =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Sc";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Sc");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Sc");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Sc");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ti;

    {
        Ti =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ti";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ti");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ti");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ti");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener V;

    {
        V =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "V";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_V");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_V");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_V");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Cr;

    {
        Cr =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Cr";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Cr");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Cr");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Cr");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Mn;

    {
        Mn =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Mn";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Mn");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Mn");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Mn");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Fe;

    {
        Fe =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Fe";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Fe");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Fe");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Fe");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Co;

    {
        Co =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Co";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Co");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Co");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Co");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ni;

    {
        Ni =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ni";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ni");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ni");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ni");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Cu;

    {
        Cu =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Cu";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Cu");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Cu");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Cu");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Zn;

    {
        Zn =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Zn";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Zn");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Zn");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Zn");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ga;

    {
        Ga =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ga";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ga");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ga");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ga");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ge;

    {
        Ge =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ge";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ge");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ge");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ge");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener As;

    {
        As =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "As";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_As");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_As");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_As");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Se;

    {
        Se =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Se";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Se");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Se");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Se");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Br;

    {
        Br =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Br";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Br");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Br");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Br");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Kr;

    {
        Kr =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Kr";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Kr");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Kr");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Kr");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Rb;

    {
        Rb =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Rb";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Rb");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Rb");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Rb");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Sr;

    {
        Sr =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Sr";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Sr");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Sr");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Sr");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Y;

    {
        Y =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Y";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Y");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Y");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Y");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Zr;

    {
        Zr =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Zr";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Zr");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Zr");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Zr");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Nb;

    {
        Nb =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Nb";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Nb");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Nb");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Nb");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Mo;

    {
        Mo =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Mo";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Mo");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Mo");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Mo");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Tc;

    {
        Tc =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Tc";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Tc");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Tc");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Tc");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ru;

    {
        Ru =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ru";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ru");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ru");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ru");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Rh;

    {
        Rh =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Rh";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Rh");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Rh");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Rh");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Pd;

    {
        Pd =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Pd";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Pd");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Pd");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Pd");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ag;

    {
        Ag =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ag";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ag");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ag");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ag");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Cd;

    {
        Cd =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Cd";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Cd");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Cd");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Cd");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener In;

    {
        In =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "In";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_In");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_In");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_In");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Sn;

    {
        Sn =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Sn";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Sn");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Sn");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Sn");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Sb;

    {
        Sb =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Sb";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Sb");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Sb");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Sb");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Te;

    {
        Te =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Te";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Te");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Te");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Te");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener I;

    {
        I =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "I";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_I");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_I");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_I");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Xe;

    {
        Xe =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Xe";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Xe");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Xe");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Xe");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Cs;

    {
        Cs =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Cs";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Cs");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Cs");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Cs");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ba;

    {
        Ba =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ba";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ba");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ba");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ba");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener La;

    {
        La =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "La";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_La");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_La");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_La");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ce;

    {
        Ce =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ce";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ce");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ce");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ce");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Pr;

    {
        Pr =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Pr";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Pr");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Pr");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Pr");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Nd;

    {
        Nd =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Nd";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Nd");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Nd");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Nd");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Pm;

    {
        Pm =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Pm";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Pm");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Pm");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Pm");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Sm;

    {
        Sm =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Sm";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Sm");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Sm");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Sm");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Eu;

    {
        Eu =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Eu";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Eu");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Eu");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Eu");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Gd;

    {
        Gd =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Gd";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Gd");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Gd");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Gd");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Tb;

    {
        Tb =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Tb";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Tb");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Tb");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Tb");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Dy;

    {
        Dy =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Dy";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Dy");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Dy");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Dy");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ho;

    {
        Ho =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ho";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ho");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ho");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ho");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Er;

    {
        Er =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Er";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Er");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Er");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Er");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Tm;

    {
        Tm =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Tm";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Tm");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Tm");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Tm");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Yb;

    {
        Yb =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Yb";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Yb");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Yb");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Yb");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Lu;

    {
        Lu =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Lu";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Lu");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Lu");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Lu");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Hf;

    {
        Hf =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Hf";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Hf");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Hf");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Hf");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ta;

    {
        Ta =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ta";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ta");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ta");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ta");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener W;

    {
        W =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "W";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_W");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_W");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_W");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Re;

    {
        Re =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Re";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Re");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Re");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Re");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Os;

    {
        Os =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Os";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Os");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Os");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Os");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ir;

    {
        Ir =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ir";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ir");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ir");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ir");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Pt;

    {
        Pt =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Pt";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Pt");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Pt");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Pt");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Au;

    {
        Au =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Au";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Au");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Au");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Au");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Hg;

    {
        Hg =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Hg";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Hg");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Hg");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Hg");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Tl;

    {
        Tl =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Tl";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Tl");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Tl");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Tl");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Pb;

    {
        Pb =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Pb";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Pb");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Pb");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Pb");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Bi;

    {
        Bi =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Bi";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Bi");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Bi");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Bi");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Po;

    {
        Po =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Po";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Po");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Po");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Po");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener At;

    {
        At =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "At";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_At");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_At");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_At");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Rn;

    {
        Rn =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Rn";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Rn");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Rn");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Rn");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Fr;

    {
        Fr =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Fr";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Fr");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Fr");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Fr");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ra;

    {
        Ra =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ra";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ra");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ra");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ra");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ac;

    {
        Ac =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ac";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ac");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ac");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ac");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Th;

    {
        Th =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Th";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Th");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Th");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Th");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Pa;

    {
        Pa =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Pa";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Pa");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Pa");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Pa");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener U;

    {
        U =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "U";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_U");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_U");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_U");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Np;

    {
        Np =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Np";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Np");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Np");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Np");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Pu;

    {
        Pu =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Pu";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Pu");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Pu");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Pu");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Am;

    {
        Am =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Am";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Am");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Am");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Am");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Cm;

    {
        Cm =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Cm";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Cm");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Cm");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Cm");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Bk;

    {
        Bk =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Bk";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Bk");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Bk");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Bk");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Cf;

    {
        Cf =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Cf";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Cf");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Cf");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Cf");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Es;

    {
        Es =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Es";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Es");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Es");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Es");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Fm;

    {
        Fm =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Fm";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Fm");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Fm");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Fm");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Md;

    {
        Md =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Md";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Md");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Md");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Md");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener No;

    {
        No =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "No";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_No");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_No");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_No");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Lr;

    {
        Lr =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Lr";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Lr");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Lr");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Lr");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Rf;

    {
        Rf =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Rf";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Rf");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Rf");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Rf");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Db;

    {
        Db =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Db";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Db");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Db");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Db");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Sg;

    {
        Sg =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Sg";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Sg");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Sg");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Sg");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Bh;

    {
        Bh =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Bh";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Bh");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Bh");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Bh");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Hs;

    {
        Hs =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Hs";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Hs");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Hs");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Hs");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Mt;

    {
        Mt =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Mt";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Mt");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Mt");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Mt");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ds;

    {
        Ds =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ds";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ds");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ds");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ds");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Rg;

    {
        Rg =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Rg";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Rg");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Rg");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Rg");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Cn;

    {
        Cn =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Cn";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Cn");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Cn");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Cn");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Nh;

    {
        Nh =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Nh";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Nh");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Nh");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Nh");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Fl;

    {
        Fl =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Fl";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Fl");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Fl");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Fl");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Mc;

    {
        Mc =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Mc";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Mc");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Mc");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Mc");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Lv;

    {
        Lv =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Lv";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Lv");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Lv");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Lv");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Ts;

    {
        Ts =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Ts";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Ts");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Ts");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Ts");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }

    private View.OnClickListener Og;

    {
        Og =
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // TODO Auto-generated method stub //
                        Element = "Og";
                        ElementRadius = MolCanvas_preferences.get().getValue("r_Og");
                        ElementColor = MolCanvas_preferences.get().getIntValue("color_Og");
                        ElementTextColor = MolCanvas_preferences.get().getIntValue("text_color_Og");
                        Intent intent = new Intent(MolCanvas_periodicTable.this, MolCanvas_main.class);
                        startActivity(intent);
                    }
                };
    }
}
