package cz.p;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MolCanvas_multi_settings extends MolCanvas_multi {
    private Handler handler = new Handler();

    private TextView introLabel;
    private Button backB;
    private Button defaultB;
    private Button backgroundB;
    private TextView backgroundColor;
    private TextView colorBanner1;
    private TextView colorBanner2;
    private TextView colorBanner3;
    MolCanvas_canvasView molCanvasView;

    private TextView zoomLabel;
    private TextView convLabel;
    private TextView zoomScaleLabel;
    private TextView perspScaleLabel;
    private TextView radiusScaleLabel;
    private TextView angleScaleLabel;
    private TextView zAngleScaleLabel;
    private TextView translScaleLabel;
    private TextView ZtranslScaleLabel;
    private TextView bondScaleLabel;
    private TextView hydrBondScaleLabel;
    private TextView minDistCritPixLabel;
    private TextView textSizeLabel;
    private TextView textShiftZAngLabel;
    private TextView textShiftXpixLabel;
    private TextView textShiftYpixLabel;
    private TextView bondsStrokeWidthLabel;
    private TextView bordersStrokeWidthLabel;
    private TextView zmatLinesLabel;

    private EditText zoomEdit;
    private EditText convEdit;
    private EditText zoomScaleEdit;
    private EditText perspScaleEdit;
    private EditText radiusScaleEdit;
    private EditText angleScaleEdit;
    private EditText zAngleScaleEdit;
    private EditText translScaleEdit;
    private EditText ZtranslScaleEdit;
    private EditText bondScaleEdit;
    private EditText hydrBondScaleEdit;
    private EditText minDistCritPixEdit;
    private EditText textSizeEdit;
    private EditText textShiftZAngEdit;
    private EditText textShiftXpixEdit;
    private EditText textShiftYpixEdit;
    private EditText bondsStrokeWidthEdit;
    private EditText bordersStrokeWidthEdit;
    private EditText zmatLinesEdit;

    private TextView zoomExpl;
    private TextView convExpl;
    private TextView zoomScaleExpl;
    private TextView perspScaleExpl;
    private TextView radiusScaleExpl;
    private TextView angleScaleExpl;
    private TextView zAngleScaleExpl;
    private TextView translScaleExpl;
    private TextView ZtranslScaleExpl;
    private TextView bondScaleExpl;
    private TextView hydrBondScaleExpl;
    private TextView minDistCritPixExpl;
    private TextView textSizeExpl;
    private TextView textShiftZAngExpl;
    private TextView textShiftXpixExpl;
    private TextView textShiftYpixExpl;
    private TextView bondsStrokeWidthExpl;
    private TextView bordersStrokeWidthExpl;
    private TextView zmatLinesExpl;

    private TextView El_H;
    private TextView El_He;
    private TextView El_Li;
    private TextView El_Be;
    private TextView El_B;
    private TextView El_C;
    private TextView El_N;
    private TextView El_O;
    private TextView El_F;
    private TextView El_Ne;
    private TextView El_Na;
    private TextView El_Mg;
    private TextView El_Al;
    private TextView El_Si;
    private TextView El_P;
    private TextView El_S;
    private TextView El_Cl;
    private TextView El_Ar;
    private TextView El_K;
    private TextView El_Ca;
    private TextView El_Sc;
    private TextView El_Ti;
    private TextView El_V;
    private TextView El_Cr;
    private TextView El_Mn;
    private TextView El_Fe;
    private TextView El_Co;
    private TextView El_Ni;
    private TextView El_Cu;
    private TextView El_Zn;
    private TextView El_Ga;
    private TextView El_Ge;
    private TextView El_As;
    private TextView El_Se;
    private TextView El_Br;
    private TextView El_Kr;
    private TextView El_Rb;
    private TextView El_Sr;
    private TextView El_Y;
    private TextView El_Zr;
    private TextView El_Nb;
    private TextView El_Mo;
    private TextView El_Tc;
    private TextView El_Ru;
    private TextView El_Rh;
    private TextView El_Pd;
    private TextView El_Ag;
    private TextView El_Cd;
    private TextView El_In;
    private TextView El_Sn;
    private TextView El_Sb;
    private TextView El_Te;
    private TextView El_I;
    private TextView El_Xe;
    private TextView El_Cs;
    private TextView El_Ba;
    private TextView El_La;
    private TextView El_Ce;
    private TextView El_Pr;
    private TextView El_Nd;
    private TextView El_Pm;
    private TextView El_Sm;
    private TextView El_Eu;
    private TextView El_Gd;
    private TextView El_Tb;
    private TextView El_Dy;
    private TextView El_Ho;
    private TextView El_Er;
    private TextView El_Tm;
    private TextView El_Yb;
    private TextView El_Lu;
    private TextView El_Hf;
    private TextView El_Ta;
    private TextView El_W;
    private TextView El_Re;
    private TextView El_Os;
    private TextView El_Ir;
    private TextView El_Pt;
    private TextView El_Au;
    private TextView El_Hg;
    private TextView El_Tl;
    private TextView El_Pb;
    private TextView El_Bi;
    private TextView El_Po;
    private TextView El_At;
    private TextView El_Rn;
    private TextView El_Fr;
    private TextView El_Ra;
    private TextView El_Ac;
    private TextView El_Th;
    private TextView El_Pa;
    private TextView El_U;
    private TextView El_Np;
    private TextView El_Pu;
    private TextView El_Am;
    private TextView El_Cm;
    private TextView El_Bk;
    private TextView El_Cf;
    private TextView El_Es;
    private TextView El_Fm;
    private TextView El_Md;
    private TextView El_No;
    private TextView El_Lr;
    private TextView El_Rf;
    private TextView El_Db;
    private TextView El_Sg;
    private TextView El_Bh;
    private TextView El_Hs;
    private TextView El_Mt;
    private TextView El_Ds;
    private TextView El_Rg;
    private TextView El_Cn;
    private TextView El_Nh;
    private TextView El_Fl;
    private TextView El_Mc;
    private TextView El_Lv;
    private TextView El_Ts;
    private TextView El_Og;

    private EditText Rad_H;
    private EditText Rad_He;
    private EditText Rad_Li;
    private EditText Rad_Be;
    private EditText Rad_B;
    private EditText Rad_C;
    private EditText Rad_N;
    private EditText Rad_O;
    private EditText Rad_F;
    private EditText Rad_Ne;
    private EditText Rad_Na;
    private EditText Rad_Mg;
    private EditText Rad_Al;
    private EditText Rad_Si;
    private EditText Rad_P;
    private EditText Rad_S;
    private EditText Rad_Cl;
    private EditText Rad_Ar;
    private EditText Rad_K;
    private EditText Rad_Ca;
    private EditText Rad_Sc;
    private EditText Rad_Ti;
    private EditText Rad_V;
    private EditText Rad_Cr;
    private EditText Rad_Mn;
    private EditText Rad_Fe;
    private EditText Rad_Co;
    private EditText Rad_Ni;
    private EditText Rad_Cu;
    private EditText Rad_Zn;
    private EditText Rad_Ga;
    private EditText Rad_Ge;
    private EditText Rad_As;
    private EditText Rad_Se;
    private EditText Rad_Br;
    private EditText Rad_Kr;
    private EditText Rad_Rb;
    private EditText Rad_Sr;
    private EditText Rad_Y;
    private EditText Rad_Zr;
    private EditText Rad_Nb;
    private EditText Rad_Mo;
    private EditText Rad_Tc;
    private EditText Rad_Ru;
    private EditText Rad_Rh;
    private EditText Rad_Pd;
    private EditText Rad_Ag;
    private EditText Rad_Cd;
    private EditText Rad_In;
    private EditText Rad_Sn;
    private EditText Rad_Sb;
    private EditText Rad_Te;
    private EditText Rad_I;
    private EditText Rad_Xe;
    private EditText Rad_Cs;
    private EditText Rad_Ba;
    private EditText Rad_La;
    private EditText Rad_Ce;
    private EditText Rad_Pr;
    private EditText Rad_Nd;
    private EditText Rad_Pm;
    private EditText Rad_Sm;
    private EditText Rad_Eu;
    private EditText Rad_Gd;
    private EditText Rad_Tb;
    private EditText Rad_Dy;
    private EditText Rad_Ho;
    private EditText Rad_Er;
    private EditText Rad_Tm;
    private EditText Rad_Yb;
    private EditText Rad_Lu;
    private EditText Rad_Hf;
    private EditText Rad_Ta;
    private EditText Rad_W;
    private EditText Rad_Re;
    private EditText Rad_Os;
    private EditText Rad_Ir;
    private EditText Rad_Pt;
    private EditText Rad_Au;
    private EditText Rad_Hg;
    private EditText Rad_Tl;
    private EditText Rad_Pb;
    private EditText Rad_Bi;
    private EditText Rad_Po;
    private EditText Rad_At;
    private EditText Rad_Rn;
    private EditText Rad_Fr;
    private EditText Rad_Ra;
    private EditText Rad_Ac;
    private EditText Rad_Th;
    private EditText Rad_Pa;
    private EditText Rad_U;
    private EditText Rad_Np;
    private EditText Rad_Pu;
    private EditText Rad_Am;
    private EditText Rad_Cm;
    private EditText Rad_Bk;
    private EditText Rad_Cf;
    private EditText Rad_Es;
    private EditText Rad_Fm;
    private EditText Rad_Md;
    private EditText Rad_No;
    private EditText Rad_Lr;
    private EditText Rad_Rf;
    private EditText Rad_Db;
    private EditText Rad_Sg;
    private EditText Rad_Bh;
    private EditText Rad_Hs;
    private EditText Rad_Mt;
    private EditText Rad_Ds;
    private EditText Rad_Rg;
    private EditText Rad_Cn;
    private EditText Rad_Nh;
    private EditText Rad_Fl;
    private EditText Rad_Mc;
    private EditText Rad_Lv;
    private EditText Rad_Ts;
    private EditText Rad_Og;

    private Button Col_H;
    private Button Col_He;
    private Button Col_Li;
    private Button Col_Be;
    private Button Col_B;
    private Button Col_C;
    private Button Col_N;
    private Button Col_O;
    private Button Col_F;
    private Button Col_Ne;
    private Button Col_Na;
    private Button Col_Mg;
    private Button Col_Al;
    private Button Col_Si;
    private Button Col_P;
    private Button Col_S;
    private Button Col_Cl;
    private Button Col_Ar;
    private Button Col_K;
    private Button Col_Ca;
    private Button Col_Sc;
    private Button Col_Ti;
    private Button Col_V;
    private Button Col_Cr;
    private Button Col_Mn;
    private Button Col_Fe;
    private Button Col_Co;
    private Button Col_Ni;
    private Button Col_Cu;
    private Button Col_Zn;
    private Button Col_Ga;
    private Button Col_Ge;
    private Button Col_As;
    private Button Col_Se;
    private Button Col_Br;
    private Button Col_Kr;
    private Button Col_Rb;
    private Button Col_Sr;
    private Button Col_Y;
    private Button Col_Zr;
    private Button Col_Nb;
    private Button Col_Mo;
    private Button Col_Tc;
    private Button Col_Ru;
    private Button Col_Rh;
    private Button Col_Pd;
    private Button Col_Ag;
    private Button Col_Cd;
    private Button Col_In;
    private Button Col_Sn;
    private Button Col_Sb;
    private Button Col_Te;
    private Button Col_I;
    private Button Col_Xe;
    private Button Col_Cs;
    private Button Col_Ba;
    private Button Col_La;
    private Button Col_Ce;
    private Button Col_Pr;
    private Button Col_Nd;
    private Button Col_Pm;
    private Button Col_Sm;
    private Button Col_Eu;
    private Button Col_Gd;
    private Button Col_Tb;
    private Button Col_Dy;
    private Button Col_Ho;
    private Button Col_Er;
    private Button Col_Tm;
    private Button Col_Yb;
    private Button Col_Lu;
    private Button Col_Hf;
    private Button Col_Ta;
    private Button Col_W;
    private Button Col_Re;
    private Button Col_Os;
    private Button Col_Ir;
    private Button Col_Pt;
    private Button Col_Au;
    private Button Col_Hg;
    private Button Col_Tl;
    private Button Col_Pb;
    private Button Col_Bi;
    private Button Col_Po;
    private Button Col_At;
    private Button Col_Rn;
    private Button Col_Fr;
    private Button Col_Ra;
    private Button Col_Ac;
    private Button Col_Th;
    private Button Col_Pa;
    private Button Col_U;
    private Button Col_Np;
    private Button Col_Pu;
    private Button Col_Am;
    private Button Col_Cm;
    private Button Col_Bk;
    private Button Col_Cf;
    private Button Col_Es;
    private Button Col_Fm;
    private Button Col_Md;
    private Button Col_No;
    private Button Col_Lr;
    private Button Col_Rf;
    private Button Col_Db;
    private Button Col_Sg;
    private Button Col_Bh;
    private Button Col_Hs;
    private Button Col_Mt;
    private Button Col_Ds;
    private Button Col_Rg;
    private Button Col_Cn;
    private Button Col_Nh;
    private Button Col_Fl;
    private Button Col_Mc;
    private Button Col_Lv;
    private Button Col_Ts;
    private Button Col_Og;

    private Button Text_H;
    private Button Text_He;
    private Button Text_Li;
    private Button Text_Be;
    private Button Text_B;
    private Button Text_C;
    private Button Text_N;
    private Button Text_O;
    private Button Text_F;
    private Button Text_Ne;
    private Button Text_Na;
    private Button Text_Mg;
    private Button Text_Al;
    private Button Text_Si;
    private Button Text_P;
    private Button Text_S;
    private Button Text_Cl;
    private Button Text_Ar;
    private Button Text_K;
    private Button Text_Ca;
    private Button Text_Sc;
    private Button Text_Ti;
    private Button Text_V;
    private Button Text_Cr;
    private Button Text_Mn;
    private Button Text_Fe;
    private Button Text_Co;
    private Button Text_Ni;
    private Button Text_Cu;
    private Button Text_Zn;
    private Button Text_Ga;
    private Button Text_Ge;
    private Button Text_As;
    private Button Text_Se;
    private Button Text_Br;
    private Button Text_Kr;
    private Button Text_Rb;
    private Button Text_Sr;
    private Button Text_Y;
    private Button Text_Zr;
    private Button Text_Nb;
    private Button Text_Mo;
    private Button Text_Tc;
    private Button Text_Ru;
    private Button Text_Rh;
    private Button Text_Pd;
    private Button Text_Ag;
    private Button Text_Cd;
    private Button Text_In;
    private Button Text_Sn;
    private Button Text_Sb;
    private Button Text_Te;
    private Button Text_I;
    private Button Text_Xe;
    private Button Text_Cs;
    private Button Text_Ba;
    private Button Text_La;
    private Button Text_Ce;
    private Button Text_Pr;
    private Button Text_Nd;
    private Button Text_Pm;
    private Button Text_Sm;
    private Button Text_Eu;
    private Button Text_Gd;
    private Button Text_Tb;
    private Button Text_Dy;
    private Button Text_Ho;
    private Button Text_Er;
    private Button Text_Tm;
    private Button Text_Yb;
    private Button Text_Lu;
    private Button Text_Hf;
    private Button Text_Ta;
    private Button Text_W;
    private Button Text_Re;
    private Button Text_Os;
    private Button Text_Ir;
    private Button Text_Pt;
    private Button Text_Au;
    private Button Text_Hg;
    private Button Text_Tl;
    private Button Text_Pb;
    private Button Text_Bi;
    private Button Text_Po;
    private Button Text_At;
    private Button Text_Rn;
    private Button Text_Fr;
    private Button Text_Ra;
    private Button Text_Ac;
    private Button Text_Th;
    private Button Text_Pa;
    private Button Text_U;
    private Button Text_Np;
    private Button Text_Pu;
    private Button Text_Am;
    private Button Text_Cm;
    private Button Text_Bk;
    private Button Text_Cf;
    private Button Text_Es;
    private Button Text_Fm;
    private Button Text_Md;
    private Button Text_No;
    private Button Text_Lr;
    private Button Text_Rf;
    private Button Text_Db;
    private Button Text_Sg;
    private Button Text_Bh;
    private Button Text_Hs;
    private Button Text_Mt;
    private Button Text_Ds;
    private Button Text_Rg;
    private Button Text_Cn;
    private Button Text_Nh;
    private Button Text_Fl;
    private Button Text_Mc;
    private Button Text_Lv;
    private Button Text_Ts;
    private Button Text_Og;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.molcanvassettings);


        introLabel = (TextView) findViewById(R.id.introLabel);

        El_H = (TextView) findViewById(R.id.El_H);
        El_He = (TextView) findViewById(R.id.El_He);
        El_Li = (TextView) findViewById(R.id.El_Li);
        El_Be = (TextView) findViewById(R.id.El_Be);
        El_B = (TextView) findViewById(R.id.El_B);
        El_C = (TextView) findViewById(R.id.El_C);
        El_N = (TextView) findViewById(R.id.El_N);
        El_O = (TextView) findViewById(R.id.El_O);
        El_F = (TextView) findViewById(R.id.El_F);
        El_Ne = (TextView) findViewById(R.id.El_Ne);
        El_Na = (TextView) findViewById(R.id.El_Na);
        El_Mg = (TextView) findViewById(R.id.El_Mg);
        El_Al = (TextView) findViewById(R.id.El_Al);
        El_Si = (TextView) findViewById(R.id.El_Si);
        El_P = (TextView) findViewById(R.id.El_P);
        El_S = (TextView) findViewById(R.id.El_S);
        El_Cl = (TextView) findViewById(R.id.El_Cl);
        El_Ar = (TextView) findViewById(R.id.El_Ar);
        El_K = (TextView) findViewById(R.id.El_K);
        El_Ca = (TextView) findViewById(R.id.El_Ca);
        El_Sc = (TextView) findViewById(R.id.El_Sc);
        El_Ti = (TextView) findViewById(R.id.El_Ti);
        El_V = (TextView) findViewById(R.id.El_V);
        El_Cr = (TextView) findViewById(R.id.El_Cr);
        El_Mn = (TextView) findViewById(R.id.El_Mn);
        El_Fe = (TextView) findViewById(R.id.El_Fe);
        El_Co = (TextView) findViewById(R.id.El_Co);
        El_Ni = (TextView) findViewById(R.id.El_Ni);
        El_Cu = (TextView) findViewById(R.id.El_Cu);
        El_Zn = (TextView) findViewById(R.id.El_Zn);
        El_Ga = (TextView) findViewById(R.id.El_Ga);
        El_Ge = (TextView) findViewById(R.id.El_Ge);
        El_As = (TextView) findViewById(R.id.El_As);
        El_Se = (TextView) findViewById(R.id.El_Se);
        El_Br = (TextView) findViewById(R.id.El_Br);
        El_Kr = (TextView) findViewById(R.id.El_Kr);
        El_Rb = (TextView) findViewById(R.id.El_Rb);
        El_Sr = (TextView) findViewById(R.id.El_Sr);
        El_Y = (TextView) findViewById(R.id.El_Y);
        El_Zr = (TextView) findViewById(R.id.El_Zr);
        El_Nb = (TextView) findViewById(R.id.El_Nb);
        El_Mo = (TextView) findViewById(R.id.El_Mo);
        El_Tc = (TextView) findViewById(R.id.El_Tc);
        El_Ru = (TextView) findViewById(R.id.El_Ru);
        El_Rh = (TextView) findViewById(R.id.El_Rh);
        El_Pd = (TextView) findViewById(R.id.El_Pd);
        El_Ag = (TextView) findViewById(R.id.El_Ag);
        El_Cd = (TextView) findViewById(R.id.El_Cd);
        El_In = (TextView) findViewById(R.id.El_In);
        El_Sn = (TextView) findViewById(R.id.El_Sn);
        El_Sb = (TextView) findViewById(R.id.El_Sb);
        El_Te = (TextView) findViewById(R.id.El_Te);
        El_I = (TextView) findViewById(R.id.El_I);
        El_Xe = (TextView) findViewById(R.id.El_Xe);
        El_Cs = (TextView) findViewById(R.id.El_Cs);
        El_Ba = (TextView) findViewById(R.id.El_Ba);
        El_La = (TextView) findViewById(R.id.El_La);
        El_Ce = (TextView) findViewById(R.id.El_Ce);
        El_Pr = (TextView) findViewById(R.id.El_Pr);
        El_Nd = (TextView) findViewById(R.id.El_Nd);
        El_Pm = (TextView) findViewById(R.id.El_Pm);
        El_Sm = (TextView) findViewById(R.id.El_Sm);
        El_Eu = (TextView) findViewById(R.id.El_Eu);
        El_Gd = (TextView) findViewById(R.id.El_Gd);
        El_Tb = (TextView) findViewById(R.id.El_Tb);
        El_Dy = (TextView) findViewById(R.id.El_Dy);
        El_Ho = (TextView) findViewById(R.id.El_Ho);
        El_Er = (TextView) findViewById(R.id.El_Er);
        El_Tm = (TextView) findViewById(R.id.El_Tm);
        El_Yb = (TextView) findViewById(R.id.El_Yb);
        El_Lu = (TextView) findViewById(R.id.El_Lu);
        El_Hf = (TextView) findViewById(R.id.El_Hf);
        El_Ta = (TextView) findViewById(R.id.El_Ta);
        El_W = (TextView) findViewById(R.id.El_W);
        El_Re = (TextView) findViewById(R.id.El_Re);
        El_Os = (TextView) findViewById(R.id.El_Os);
        El_Ir = (TextView) findViewById(R.id.El_Ir);
        El_Pt = (TextView) findViewById(R.id.El_Pt);
        El_Au = (TextView) findViewById(R.id.El_Au);
        El_Hg = (TextView) findViewById(R.id.El_Hg);
        El_Tl = (TextView) findViewById(R.id.El_Tl);
        El_Pb = (TextView) findViewById(R.id.El_Pb);
        El_Bi = (TextView) findViewById(R.id.El_Bi);
        El_Po = (TextView) findViewById(R.id.El_Po);
        El_At = (TextView) findViewById(R.id.El_At);
        El_Rn = (TextView) findViewById(R.id.El_Rn);
        El_Fr = (TextView) findViewById(R.id.El_Fr);
        El_Ra = (TextView) findViewById(R.id.El_Ra);
        El_Ac = (TextView) findViewById(R.id.El_Ac);
        El_Th = (TextView) findViewById(R.id.El_Th);
        El_Pa = (TextView) findViewById(R.id.El_Pa);
        El_U = (TextView) findViewById(R.id.El_U);
        El_Np = (TextView) findViewById(R.id.El_Np);
        El_Pu = (TextView) findViewById(R.id.El_Pu);
        El_Am = (TextView) findViewById(R.id.El_Am);
        El_Cm = (TextView) findViewById(R.id.El_Cm);
        El_Bk = (TextView) findViewById(R.id.El_Bk);
        El_Cf = (TextView) findViewById(R.id.El_Cf);
        El_Es = (TextView) findViewById(R.id.El_Es);
        El_Fm = (TextView) findViewById(R.id.El_Fm);
        El_Md = (TextView) findViewById(R.id.El_Md);
        El_No = (TextView) findViewById(R.id.El_No);
        El_Lr = (TextView) findViewById(R.id.El_Lr);
        El_Rf = (TextView) findViewById(R.id.El_Rf);
        El_Db = (TextView) findViewById(R.id.El_Db);
        El_Sg = (TextView) findViewById(R.id.El_Sg);
        El_Bh = (TextView) findViewById(R.id.El_Bh);
        El_Hs = (TextView) findViewById(R.id.El_Hs);
        El_Mt = (TextView) findViewById(R.id.El_Mt);
        El_Ds = (TextView) findViewById(R.id.El_Ds);
        El_Rg = (TextView) findViewById(R.id.El_Rg);
        El_Cn = (TextView) findViewById(R.id.El_Cn);
        El_Nh = (TextView) findViewById(R.id.El_Nh);
        El_Fl = (TextView) findViewById(R.id.El_Fl);
        El_Mc = (TextView) findViewById(R.id.El_Mc);
        El_Lv = (TextView) findViewById(R.id.El_Lv);
        El_Ts = (TextView) findViewById(R.id.El_Ts);
        El_Og = (TextView) findViewById(R.id.El_Og);

        zoomLabel = (TextView) findViewById(R.id.zoomLabel);
        convLabel = (TextView) findViewById(R.id.convLabel);
        zoomScaleLabel = (TextView) findViewById(R.id.zoomScaleLabel);
        perspScaleLabel = (TextView) findViewById(R.id.perspScaleLabel);
        radiusScaleLabel = (TextView) findViewById(R.id.radiusScaleLabel);
        angleScaleLabel = (TextView) findViewById(R.id.angleScaleLabel);
        zAngleScaleLabel = (TextView) findViewById(R.id.zAngleScaleLabel);
        translScaleLabel = (TextView) findViewById(R.id.translScaleLabel);
        ZtranslScaleLabel = (TextView) findViewById(R.id.ZtranslScaleLabel);
        bondScaleLabel = (TextView) findViewById(R.id.bondScaleLabel);
        hydrBondScaleLabel = (TextView) findViewById(R.id.hydrBondScaleLabel);
        minDistCritPixLabel = (TextView) findViewById(R.id.minDistCritPixLabel);
        textSizeLabel = (TextView) findViewById(R.id.textSizeLabel);
        textShiftZAngLabel = (TextView) findViewById(R.id.textShiftZAngLabel);
        textShiftXpixLabel = (TextView) findViewById(R.id.textShiftXpixLabel);
        textShiftYpixLabel = (TextView) findViewById(R.id.textShiftYpixLabel);
        bondsStrokeWidthLabel = (TextView) findViewById(R.id.bondsStrokeWidthLabel);
        bordersStrokeWidthLabel = (TextView) findViewById(R.id.bordersStrokeWidthLabel);
        zmatLinesLabel = (TextView) findViewById(R.id.zmatLinesLabel);

        zoomExpl = (TextView) findViewById(R.id.zoomExpl);
        convExpl = (TextView) findViewById(R.id.convExpl);
        zoomScaleExpl = (TextView) findViewById(R.id.zoomScaleExpl);
        perspScaleExpl = (TextView) findViewById(R.id.perspScaleExpl);
        radiusScaleExpl = (TextView) findViewById(R.id.radiusScaleExpl);
        angleScaleExpl = (TextView) findViewById(R.id.angleScaleExpl);
        zAngleScaleExpl = (TextView) findViewById(R.id.zAngleScaleExpl);
        translScaleExpl = (TextView) findViewById(R.id.translScaleExpl);
        ZtranslScaleExpl = (TextView) findViewById(R.id.ZtranslScaleExpl);
        bondScaleExpl = (TextView) findViewById(R.id.bondScaleExpl);
        hydrBondScaleExpl = (TextView) findViewById(R.id.hydrBondScaleExpl);
        minDistCritPixExpl = (TextView) findViewById(R.id.minDistCritPixExpl);
        textSizeExpl = (TextView) findViewById(R.id.textSizeExpl);
        textShiftZAngExpl = (TextView) findViewById(R.id.textShiftZAngExpl);
        textShiftXpixExpl = (TextView) findViewById(R.id.textShiftXpixExpl);
        textShiftYpixExpl = (TextView) findViewById(R.id.textShiftYpixExpl);
        bondsStrokeWidthExpl = (TextView) findViewById(R.id.bondsStrokeWidthExpl);
        bordersStrokeWidthExpl = (TextView) findViewById(R.id.bordersStrokeWidthExpl);
        zmatLinesExpl = (TextView) findViewById(R.id.zmatLinesExpl);

        backgroundColor = (TextView) findViewById(R.id.backgroundColor);
        colorBanner1 = (TextView) findViewById(R.id.colorBanner1);
        colorBanner2 = (TextView) findViewById(R.id.colorBanner2);
        colorBanner3 = (TextView) findViewById(R.id.colorBanner3);

        backgroundB = (Button) findViewById(R.id.backgroundB);
        backgroundB.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_background"));
        backgroundB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_background");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        defaultB = (Button) findViewById(R.id.defaultB);
        defaultB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_main.setDefaultValues();
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_settings.class);
                startActivity(intent);
            }
        });

        backB = (Button) findViewById(R.id.backB);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi.class);
                startActivity(intent);
            }
        });

        zoomEdit = (EditText) findViewById(R.id.zoomEdit);
        zoomEdit.setTextSize(20);
        zoomEdit.addTextChangedListener(new TextWatcher() {
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
                zoomEdit.removeTextChangedListener(this);
                String text = zoomEdit.getText().toString();
                zoomEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("zoom",Float.valueOf(text));
                }
                zoomEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                zoomEdit.setSelection(startChanged+countChanged);
                zoomEdit.addTextChangedListener(this);
            }
        });

        convEdit = (EditText) findViewById(R.id.convEdit);
        convEdit.setTextSize(20);
        convEdit.addTextChangedListener(new TextWatcher() {
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
                convEdit.removeTextChangedListener(this);
                String text = convEdit.getText().toString();
                convEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("conv",Float.valueOf(text));
                }
                convEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                convEdit.setSelection(startChanged+countChanged);
                convEdit.addTextChangedListener(this);
            }
        });
        zoomScaleEdit = (EditText) findViewById(R.id.zoomScaleEdit);
        zoomScaleEdit.setTextSize(20);
        zoomScaleEdit.addTextChangedListener(new TextWatcher() {
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
                zoomScaleEdit.removeTextChangedListener(this);
                String text = zoomScaleEdit.getText().toString();
                zoomScaleEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("zoom_scale",Float.valueOf(text));
                }
                zoomScaleEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                zoomScaleEdit.setSelection(startChanged+countChanged);
                zoomScaleEdit.addTextChangedListener(this);
            }
        });
        perspScaleEdit = (EditText) findViewById(R.id.perspScaleEdit);
        perspScaleEdit.setTextSize(20);
        perspScaleEdit.addTextChangedListener(new TextWatcher() {
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
                perspScaleEdit.removeTextChangedListener(this);
                String text = perspScaleEdit.getText().toString();
                perspScaleEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("persp_scale",Float.valueOf(text));
                }
                perspScaleEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                perspScaleEdit.setSelection(startChanged+countChanged);
                perspScaleEdit.addTextChangedListener(this);
            }
        });
        radiusScaleEdit = (EditText) findViewById(R.id.radiusScaleEdit);
        radiusScaleEdit.setTextSize(20);
        radiusScaleEdit.addTextChangedListener(new TextWatcher() {
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
                radiusScaleEdit.removeTextChangedListener(this);
                String text = radiusScaleEdit.getText().toString();
                radiusScaleEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("radius_scale",Float.valueOf(text));
                }
                radiusScaleEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                radiusScaleEdit.setSelection(startChanged+countChanged);
                radiusScaleEdit.addTextChangedListener(this);
            }
        });
        angleScaleEdit = (EditText) findViewById(R.id.angleScaleEdit);
        angleScaleEdit.setTextSize(20);
        angleScaleEdit.addTextChangedListener(new TextWatcher() {
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
                angleScaleEdit.removeTextChangedListener(this);
                String text = angleScaleEdit.getText().toString();
                angleScaleEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("angle_scale",Float.valueOf(text));
                }
                angleScaleEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                angleScaleEdit.setSelection(startChanged+countChanged);
                angleScaleEdit.addTextChangedListener(this);
            }
        });
        zAngleScaleEdit = (EditText) findViewById(R.id.zAngleScaleEdit);
        zAngleScaleEdit.setTextSize(20);
        zAngleScaleEdit.addTextChangedListener(new TextWatcher() {
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
                zAngleScaleEdit.removeTextChangedListener(this);
                String text = zAngleScaleEdit.getText().toString();
                zAngleScaleEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("z_angle_scale",Float.valueOf(text));
                }
                zAngleScaleEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                zAngleScaleEdit.setSelection(startChanged+countChanged);
                zAngleScaleEdit.addTextChangedListener(this);
            }
        });
        translScaleEdit = (EditText) findViewById(R.id.translScaleEdit);
        translScaleEdit.setTextSize(20);
        translScaleEdit.addTextChangedListener(new TextWatcher() {
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
                translScaleEdit.removeTextChangedListener(this);
                String text = translScaleEdit.getText().toString();
                translScaleEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("transl_scale",Float.valueOf(text));
                }
                translScaleEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                translScaleEdit.setSelection(startChanged+countChanged);
                translScaleEdit.addTextChangedListener(this);
            }
        });
        ZtranslScaleEdit = (EditText) findViewById(R.id.ZtranslScaleEdit);
        ZtranslScaleEdit.setTextSize(20);
        ZtranslScaleEdit.addTextChangedListener(new TextWatcher() {
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
                ZtranslScaleEdit.removeTextChangedListener(this);
                String text = ZtranslScaleEdit.getText().toString();
                ZtranslScaleEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("z_transl_scale",Float.valueOf(text));
                }
                ZtranslScaleEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                ZtranslScaleEdit.setSelection(startChanged+countChanged);
                ZtranslScaleEdit.addTextChangedListener(this);
            }
        });
        bondScaleEdit = (EditText) findViewById(R.id.bondScaleEdit);
        bondScaleEdit.setTextSize(20);
        bondScaleEdit.addTextChangedListener(new TextWatcher() {
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
                bondScaleEdit.removeTextChangedListener(this);
                String text = bondScaleEdit.getText().toString();
                bondScaleEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("bond_scale",Float.valueOf(text));
                }
                bondScaleEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                bondScaleEdit.setSelection(startChanged+countChanged);
                bondScaleEdit.addTextChangedListener(this);
            }
        });
        hydrBondScaleEdit = (EditText) findViewById(R.id.hydrBondScaleEdit);
        hydrBondScaleEdit.setTextSize(20);
        hydrBondScaleEdit.addTextChangedListener(new TextWatcher() {
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
                hydrBondScaleEdit.removeTextChangedListener(this);
                String text = hydrBondScaleEdit.getText().toString();
                hydrBondScaleEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("hydr_bond_scale",Float.valueOf(text));
                }
                hydrBondScaleEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                hydrBondScaleEdit.setSelection(startChanged+countChanged);
                hydrBondScaleEdit.addTextChangedListener(this);
            }
        });
        minDistCritPixEdit = (EditText) findViewById(R.id.minDistCritPixEdit);
        minDistCritPixEdit.setTextSize(20);
        minDistCritPixEdit.addTextChangedListener(new TextWatcher() {
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
                minDistCritPixEdit.removeTextChangedListener(this);
                String text = minDistCritPixEdit.getText().toString();
                minDistCritPixEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("minDistCrit_pix",Float.valueOf(text));
                }
                minDistCritPixEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                minDistCritPixEdit.setSelection(startChanged+countChanged);
                minDistCritPixEdit.addTextChangedListener(this);
            }
        });
        textSizeEdit = (EditText) findViewById(R.id.textSizeEdit);
        textSizeEdit.setTextSize(20);
        textSizeEdit.addTextChangedListener(new TextWatcher() {
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
                textSizeEdit.removeTextChangedListener(this);
                String text = textSizeEdit.getText().toString();
                textSizeEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("text_size",Float.valueOf(text));
                }
                textSizeEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                textSizeEdit.setSelection(startChanged+countChanged);
                textSizeEdit.addTextChangedListener(this);
            }
        });
        textShiftZAngEdit = (EditText) findViewById(R.id.textShiftZAngEdit);
        textShiftZAngEdit.setTextSize(20);
        textShiftZAngEdit.addTextChangedListener(new TextWatcher() {
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
                textShiftZAngEdit.removeTextChangedListener(this);
                String text = textShiftZAngEdit.getText().toString();
                textShiftZAngEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("text_shift_z_Ang",Float.valueOf(text));
                }
                textShiftZAngEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                textShiftZAngEdit.setSelection(startChanged+countChanged);
                textShiftZAngEdit.addTextChangedListener(this);
            }
        });
        textShiftXpixEdit = (EditText) findViewById(R.id.textShiftXpixEdit);
        textShiftXpixEdit.setTextSize(20);
        textShiftXpixEdit.addTextChangedListener(new TextWatcher() {
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
                textShiftXpixEdit.removeTextChangedListener(this);
                String text = textShiftXpixEdit.getText().toString();
                textShiftXpixEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("text_shift_x_pix",Float.valueOf(text));
                }
                textShiftXpixEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                textShiftXpixEdit.setSelection(startChanged+countChanged);
                textShiftXpixEdit.addTextChangedListener(this);
            }
        });
        textShiftYpixEdit = (EditText) findViewById(R.id.textShiftYpixEdit);
        textShiftYpixEdit.setTextSize(20);
        textShiftYpixEdit.addTextChangedListener(new TextWatcher() {
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
                textShiftYpixEdit.removeTextChangedListener(this);
                String text = textShiftYpixEdit.getText().toString();
                textShiftYpixEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("text_shift_y_pix",Float.valueOf(text));
                }
                textShiftYpixEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                textShiftYpixEdit.setSelection(startChanged+countChanged);
                textShiftYpixEdit.addTextChangedListener(this);
            }
        });
        bondsStrokeWidthEdit = (EditText) findViewById(R.id.bondsStrokeWidthEdit);
        bondsStrokeWidthEdit.setTextSize(20);
        bondsStrokeWidthEdit.addTextChangedListener(new TextWatcher() {
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
                bondsStrokeWidthEdit.removeTextChangedListener(this);
                String text = bondsStrokeWidthEdit.getText().toString();
                bondsStrokeWidthEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("bondsStrokeWidth",Float.valueOf(text));
                }
                bondsStrokeWidthEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                bondsStrokeWidthEdit.setSelection(startChanged+countChanged);
                bondsStrokeWidthEdit.addTextChangedListener(this);
            }
        });
        bordersStrokeWidthEdit = (EditText) findViewById(R.id.bordersStrokeWidthEdit);
        bordersStrokeWidthEdit.setTextSize(20);
        bordersStrokeWidthEdit.addTextChangedListener(new TextWatcher() {
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
                bordersStrokeWidthEdit.removeTextChangedListener(this);
                String text = bordersStrokeWidthEdit.getText().toString();
                bordersStrokeWidthEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("bordersStrokeWidth",Float.valueOf(text));
                }
                bordersStrokeWidthEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                bordersStrokeWidthEdit.setSelection(startChanged+countChanged);
                bordersStrokeWidthEdit.addTextChangedListener(this);
            }
        });
        zmatLinesEdit = (EditText) findViewById(R.id.zmatLinesEdit);
        zmatLinesEdit.setTextSize(20);
        zmatLinesEdit.addTextChangedListener(new TextWatcher() {
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
                zmatLinesEdit.removeTextChangedListener(this);
                String text = zmatLinesEdit.getText().toString();
                zmatLinesEdit.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setIntValue("zmat_max_lines",Integer.valueOf(text));
                }
                zmatLinesEdit.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                zmatLinesEdit.setSelection(startChanged+countChanged);
                zmatLinesEdit.addTextChangedListener(this);
            }
        });

        Rad_H = (EditText) findViewById(R.id.Rad_H);
        Rad_H.setTextSize(20);
        Rad_H.addTextChangedListener(new TextWatcher() {
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
                Rad_H.removeTextChangedListener(this);
                String text = Rad_H.getText().toString();
                Rad_H.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_H",Float.valueOf(text));
                }
                Rad_H.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_H.setSelection(startChanged+countChanged);
                Rad_H.addTextChangedListener(this);
            }
        });

        Col_H = (Button) findViewById(R.id.Col_H);
        Col_H.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_H"));
        Col_H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_H");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_H = (Button) findViewById(R.id.Text_H);
        Text_H.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_H"));
        Text_H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_H");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_He = (EditText) findViewById(R.id.Rad_He);
        Rad_He.setTextSize(20);
        Rad_He.addTextChangedListener(new TextWatcher() {
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
                Rad_He.removeTextChangedListener(this);
                String text = Rad_He.getText().toString();
                Rad_He.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_He",Float.valueOf(text));
                }
                Rad_He.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_He.setSelection(startChanged+countChanged);
                Rad_He.addTextChangedListener(this);
            }
        });

        Col_He = (Button) findViewById(R.id.Col_He);
        Col_He.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_He"));
        Col_He.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_He");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_He = (Button) findViewById(R.id.Text_He);
        Text_He.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_He"));
        Text_He.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_He");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Li = (EditText) findViewById(R.id.Rad_Li);
        Rad_Li.setTextSize(20);
        Rad_Li.addTextChangedListener(new TextWatcher() {
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
                Rad_Li.removeTextChangedListener(this);
                String text = Rad_Li.getText().toString();
                Rad_Li.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Li",Float.valueOf(text));
                }
                Rad_Li.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Li.setSelection(startChanged+countChanged);
                Rad_Li.addTextChangedListener(this);
            }
        });

        Col_Li = (Button) findViewById(R.id.Col_Li);
        Col_Li.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Li"));
        Col_Li.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Li");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Li = (Button) findViewById(R.id.Text_Li);
        Text_Li.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Li"));
        Text_Li.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Li");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Be = (EditText) findViewById(R.id.Rad_Be);
        Rad_Be.setTextSize(20);
        Rad_Be.addTextChangedListener(new TextWatcher() {
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
                Rad_Be.removeTextChangedListener(this);
                String text = Rad_Be.getText().toString();
                Rad_Be.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Be",Float.valueOf(text));
                }
                Rad_Be.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Be.setSelection(startChanged+countChanged);
                Rad_Be.addTextChangedListener(this);
            }
        });

        Col_Be = (Button) findViewById(R.id.Col_Be);
        Col_Be.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Be"));
        Col_Be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Be");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Be = (Button) findViewById(R.id.Text_Be);
        Text_Be.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Be"));
        Text_Be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Be");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_B = (EditText) findViewById(R.id.Rad_B);
        Rad_B.setTextSize(20);
        Rad_B.addTextChangedListener(new TextWatcher() {
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
                Rad_B.removeTextChangedListener(this);
                String text = Rad_B.getText().toString();
                Rad_B.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_B",Float.valueOf(text));
                }
                Rad_B.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_B.setSelection(startChanged+countChanged);
                Rad_B.addTextChangedListener(this);
            }
        });

        Col_B = (Button) findViewById(R.id.Col_B);
        Col_B.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_B"));
        Col_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_B");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_B = (Button) findViewById(R.id.Text_B);
        Text_B.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_B"));
        Text_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_B");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_C = (EditText) findViewById(R.id.Rad_C);
        Rad_C.setTextSize(20);
        Rad_C.addTextChangedListener(new TextWatcher() {
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
                Rad_C.removeTextChangedListener(this);
                String text = Rad_C.getText().toString();
                Rad_C.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_C",Float.valueOf(text));
                }
                Rad_C.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_C.setSelection(startChanged+countChanged);
                Rad_C.addTextChangedListener(this);
            }
        });

        Col_C = (Button) findViewById(R.id.Col_C);
        Col_C.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_C"));
        Col_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_C");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_C = (Button) findViewById(R.id.Text_C);
        Text_C.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_C"));
        Text_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_C");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_N = (EditText) findViewById(R.id.Rad_N);
        Rad_N.setTextSize(20);
        Rad_N.addTextChangedListener(new TextWatcher() {
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
                Rad_N.removeTextChangedListener(this);
                String text = Rad_N.getText().toString();
                Rad_N.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_N",Float.valueOf(text));
                }
                Rad_N.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_N.setSelection(startChanged+countChanged);
                Rad_N.addTextChangedListener(this);
            }
        });

        Col_N = (Button) findViewById(R.id.Col_N);
        Col_N.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_N"));
        Col_N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_N");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_N = (Button) findViewById(R.id.Text_N);
        Text_N.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_N"));
        Text_N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_N");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_O = (EditText) findViewById(R.id.Rad_O);
        Rad_O.setTextSize(20);
        Rad_O.addTextChangedListener(new TextWatcher() {
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
                Rad_O.removeTextChangedListener(this);
                String text = Rad_O.getText().toString();
                Rad_O.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_O",Float.valueOf(text));
                }
                Rad_O.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_O.setSelection(startChanged+countChanged);
                Rad_O.addTextChangedListener(this);
            }
        });

        Col_O = (Button) findViewById(R.id.Col_O);
        Col_O.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_O"));
        Col_O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_O");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_O = (Button) findViewById(R.id.Text_O);
        Text_O.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_O"));
        Text_O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_O");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_F = (EditText) findViewById(R.id.Rad_F);
        Rad_F.setTextSize(20);
        Rad_F.addTextChangedListener(new TextWatcher() {
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
                Rad_F.removeTextChangedListener(this);
                String text = Rad_F.getText().toString();
                Rad_F.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_F",Float.valueOf(text));
                }
                Rad_F.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_F.setSelection(startChanged+countChanged);
                Rad_F.addTextChangedListener(this);
            }
        });

        Col_F = (Button) findViewById(R.id.Col_F);
        Col_F.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_F"));
        Col_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_F");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_F = (Button) findViewById(R.id.Text_F);
        Text_F.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_F"));
        Text_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_F");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ne = (EditText) findViewById(R.id.Rad_Ne);
        Rad_Ne.setTextSize(20);
        Rad_Ne.addTextChangedListener(new TextWatcher() {
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
                Rad_Ne.removeTextChangedListener(this);
                String text = Rad_Ne.getText().toString();
                Rad_Ne.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ne",Float.valueOf(text));
                }
                Rad_Ne.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ne.setSelection(startChanged+countChanged);
                Rad_Ne.addTextChangedListener(this);
            }
        });

        Col_Ne = (Button) findViewById(R.id.Col_Ne);
        Col_Ne.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ne"));
        Col_Ne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ne");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ne = (Button) findViewById(R.id.Text_Ne);
        Text_Ne.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ne"));
        Text_Ne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ne");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Na = (EditText) findViewById(R.id.Rad_Na);
        Rad_Na.setTextSize(20);
        Rad_Na.addTextChangedListener(new TextWatcher() {
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
                Rad_Na.removeTextChangedListener(this);
                String text = Rad_Na.getText().toString();
                Rad_Na.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Na",Float.valueOf(text));
                }
                Rad_Na.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Na.setSelection(startChanged+countChanged);
                Rad_Na.addTextChangedListener(this);
            }
        });

        Col_Na = (Button) findViewById(R.id.Col_Na);
        Col_Na.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Na"));
        Col_Na.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Na");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Na = (Button) findViewById(R.id.Text_Na);
        Text_Na.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Na"));
        Text_Na.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Na");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Mg = (EditText) findViewById(R.id.Rad_Mg);
        Rad_Mg.setTextSize(20);
        Rad_Mg.addTextChangedListener(new TextWatcher() {
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
                Rad_Mg.removeTextChangedListener(this);
                String text = Rad_Mg.getText().toString();
                Rad_Mg.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Mg",Float.valueOf(text));
                }
                Rad_Mg.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Mg.setSelection(startChanged+countChanged);
                Rad_Mg.addTextChangedListener(this);
            }
        });

        Col_Mg = (Button) findViewById(R.id.Col_Mg);
        Col_Mg.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Mg"));
        Col_Mg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Mg");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Mg = (Button) findViewById(R.id.Text_Mg);
        Text_Mg.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Mg"));
        Text_Mg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Mg");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Al = (EditText) findViewById(R.id.Rad_Al);
        Rad_Al.setTextSize(20);
        Rad_Al.addTextChangedListener(new TextWatcher() {
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
                Rad_Al.removeTextChangedListener(this);
                String text = Rad_Al.getText().toString();
                Rad_Al.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Al",Float.valueOf(text));
                }
                Rad_Al.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Al.setSelection(startChanged+countChanged);
                Rad_Al.addTextChangedListener(this);
            }
        });

        Col_Al = (Button) findViewById(R.id.Col_Al);
        Col_Al.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Al"));
        Col_Al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Al");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Al = (Button) findViewById(R.id.Text_Al);
        Text_Al.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Al"));
        Text_Al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Al");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Si = (EditText) findViewById(R.id.Rad_Si);
        Rad_Si.setTextSize(20);
        Rad_Si.addTextChangedListener(new TextWatcher() {
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
                Rad_Si.removeTextChangedListener(this);
                String text = Rad_Si.getText().toString();
                Rad_Si.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Si",Float.valueOf(text));
                }
                Rad_Si.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Si.setSelection(startChanged+countChanged);
                Rad_Si.addTextChangedListener(this);
            }
        });

        Col_Si = (Button) findViewById(R.id.Col_Si);
        Col_Si.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Si"));
        Col_Si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Si");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Si = (Button) findViewById(R.id.Text_Si);
        Text_Si.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Si"));
        Text_Si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Si");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_P = (EditText) findViewById(R.id.Rad_P);
        Rad_P.setTextSize(20);
        Rad_P.addTextChangedListener(new TextWatcher() {
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
                Rad_P.removeTextChangedListener(this);
                String text = Rad_P.getText().toString();
                Rad_P.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_P",Float.valueOf(text));
                }
                Rad_P.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_P.setSelection(startChanged+countChanged);
                Rad_P.addTextChangedListener(this);
            }
        });

        Col_P = (Button) findViewById(R.id.Col_P);
        Col_P.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_P"));
        Col_P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_P");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_P = (Button) findViewById(R.id.Text_P);
        Text_P.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_P"));
        Text_P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_P");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_S = (EditText) findViewById(R.id.Rad_S);
        Rad_S.setTextSize(20);
        Rad_S.addTextChangedListener(new TextWatcher() {
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
                Rad_S.removeTextChangedListener(this);
                String text = Rad_S.getText().toString();
                Rad_S.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_S",Float.valueOf(text));
                }
                Rad_S.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_S.setSelection(startChanged+countChanged);
                Rad_S.addTextChangedListener(this);
            }
        });

        Col_S = (Button) findViewById(R.id.Col_S);
        Col_S.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_S"));
        Col_S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_S");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_S = (Button) findViewById(R.id.Text_S);
        Text_S.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_S"));
        Text_S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_S");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Cl = (EditText) findViewById(R.id.Rad_Cl);
        Rad_Cl.setTextSize(20);
        Rad_Cl.addTextChangedListener(new TextWatcher() {
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
                Rad_Cl.removeTextChangedListener(this);
                String text = Rad_Cl.getText().toString();
                Rad_Cl.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Cl",Float.valueOf(text));
                }
                Rad_Cl.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Cl.setSelection(startChanged+countChanged);
                Rad_Cl.addTextChangedListener(this);
            }
        });

        Col_Cl = (Button) findViewById(R.id.Col_Cl);
        Col_Cl.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Cl"));
        Col_Cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Cl");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Cl = (Button) findViewById(R.id.Text_Cl);
        Text_Cl.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Cl"));
        Text_Cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Cl");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ar = (EditText) findViewById(R.id.Rad_Ar);
        Rad_Ar.setTextSize(20);
        Rad_Ar.addTextChangedListener(new TextWatcher() {
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
                Rad_Ar.removeTextChangedListener(this);
                String text = Rad_Ar.getText().toString();
                Rad_Ar.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ar",Float.valueOf(text));
                }
                Rad_Ar.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ar.setSelection(startChanged+countChanged);
                Rad_Ar.addTextChangedListener(this);
            }
        });

        Col_Ar = (Button) findViewById(R.id.Col_Ar);
        Col_Ar.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ar"));
        Col_Ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ar");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ar = (Button) findViewById(R.id.Text_Ar);
        Text_Ar.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ar"));
        Text_Ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ar");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_K = (EditText) findViewById(R.id.Rad_K);
        Rad_K.setTextSize(20);
        Rad_K.addTextChangedListener(new TextWatcher() {
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
                Rad_K.removeTextChangedListener(this);
                String text = Rad_K.getText().toString();
                Rad_K.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_K",Float.valueOf(text));
                }
                Rad_K.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_K.setSelection(startChanged+countChanged);
                Rad_K.addTextChangedListener(this);
            }
        });

        Col_K = (Button) findViewById(R.id.Col_K);
        Col_K.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_K"));
        Col_K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_K");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_K = (Button) findViewById(R.id.Text_K);
        Text_K.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_K"));
        Text_K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_K");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ca = (EditText) findViewById(R.id.Rad_Ca);
        Rad_Ca.setTextSize(20);
        Rad_Ca.addTextChangedListener(new TextWatcher() {
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
                Rad_Ca.removeTextChangedListener(this);
                String text = Rad_Ca.getText().toString();
                Rad_Ca.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ca",Float.valueOf(text));
                }
                Rad_Ca.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ca.setSelection(startChanged+countChanged);
                Rad_Ca.addTextChangedListener(this);
            }
        });

        Col_Ca = (Button) findViewById(R.id.Col_Ca);
        Col_Ca.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ca"));
        Col_Ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ca");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ca = (Button) findViewById(R.id.Text_Ca);
        Text_Ca.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ca"));
        Text_Ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ca");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Sc = (EditText) findViewById(R.id.Rad_Sc);
        Rad_Sc.setTextSize(20);
        Rad_Sc.addTextChangedListener(new TextWatcher() {
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
                Rad_Sc.removeTextChangedListener(this);
                String text = Rad_Sc.getText().toString();
                Rad_Sc.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Sc",Float.valueOf(text));
                }
                Rad_Sc.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Sc.setSelection(startChanged+countChanged);
                Rad_Sc.addTextChangedListener(this);
            }
        });

        Col_Sc = (Button) findViewById(R.id.Col_Sc);
        Col_Sc.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Sc"));
        Col_Sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Sc");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Sc = (Button) findViewById(R.id.Text_Sc);
        Text_Sc.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Sc"));
        Text_Sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Sc");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ti = (EditText) findViewById(R.id.Rad_Ti);
        Rad_Ti.setTextSize(20);
        Rad_Ti.addTextChangedListener(new TextWatcher() {
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
                Rad_Ti.removeTextChangedListener(this);
                String text = Rad_Ti.getText().toString();
                Rad_Ti.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ti",Float.valueOf(text));
                }
                Rad_Ti.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ti.setSelection(startChanged+countChanged);
                Rad_Ti.addTextChangedListener(this);
            }
        });

        Col_Ti = (Button) findViewById(R.id.Col_Ti);
        Col_Ti.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ti"));
        Col_Ti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ti");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ti = (Button) findViewById(R.id.Text_Ti);
        Text_Ti.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ti"));
        Text_Ti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ti");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_V = (EditText) findViewById(R.id.Rad_V);
        Rad_V.setTextSize(20);
        Rad_V.addTextChangedListener(new TextWatcher() {
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
                Rad_V.removeTextChangedListener(this);
                String text = Rad_V.getText().toString();
                Rad_V.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_V",Float.valueOf(text));
                }
                Rad_V.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_V.setSelection(startChanged+countChanged);
                Rad_V.addTextChangedListener(this);
            }
        });

        Col_V = (Button) findViewById(R.id.Col_V);
        Col_V.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_V"));
        Col_V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_V");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_V = (Button) findViewById(R.id.Text_V);
        Text_V.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_V"));
        Text_V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_V");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Cr = (EditText) findViewById(R.id.Rad_Cr);
        Rad_Cr.setTextSize(20);
        Rad_Cr.addTextChangedListener(new TextWatcher() {
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
                Rad_Cr.removeTextChangedListener(this);
                String text = Rad_Cr.getText().toString();
                Rad_Cr.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Cr",Float.valueOf(text));
                }
                Rad_Cr.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Cr.setSelection(startChanged+countChanged);
                Rad_Cr.addTextChangedListener(this);
            }
        });

        Col_Cr = (Button) findViewById(R.id.Col_Cr);
        Col_Cr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Cr"));
        Col_Cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Cr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Cr = (Button) findViewById(R.id.Text_Cr);
        Text_Cr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Cr"));
        Text_Cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Cr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Mn = (EditText) findViewById(R.id.Rad_Mn);
        Rad_Mn.setTextSize(20);
        Rad_Mn.addTextChangedListener(new TextWatcher() {
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
                Rad_Mn.removeTextChangedListener(this);
                String text = Rad_Mn.getText().toString();
                Rad_Mn.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Mn",Float.valueOf(text));
                }
                Rad_Mn.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Mn.setSelection(startChanged+countChanged);
                Rad_Mn.addTextChangedListener(this);
            }
        });

        Col_Mn = (Button) findViewById(R.id.Col_Mn);
        Col_Mn.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Mn"));
        Col_Mn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Mn");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Mn = (Button) findViewById(R.id.Text_Mn);
        Text_Mn.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Mn"));
        Text_Mn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Mn");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Fe = (EditText) findViewById(R.id.Rad_Fe);
        Rad_Fe.setTextSize(20);
        Rad_Fe.addTextChangedListener(new TextWatcher() {
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
                Rad_Fe.removeTextChangedListener(this);
                String text = Rad_Fe.getText().toString();
                Rad_Fe.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Fe",Float.valueOf(text));
                }
                Rad_Fe.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Fe.setSelection(startChanged+countChanged);
                Rad_Fe.addTextChangedListener(this);
            }
        });

        Col_Fe = (Button) findViewById(R.id.Col_Fe);
        Col_Fe.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Fe"));
        Col_Fe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Fe");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Fe = (Button) findViewById(R.id.Text_Fe);
        Text_Fe.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Fe"));
        Text_Fe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Fe");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Co = (EditText) findViewById(R.id.Rad_Co);
        Rad_Co.setTextSize(20);
        Rad_Co.addTextChangedListener(new TextWatcher() {
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
                Rad_Co.removeTextChangedListener(this);
                String text = Rad_Co.getText().toString();
                Rad_Co.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Co",Float.valueOf(text));
                }
                Rad_Co.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Co.setSelection(startChanged+countChanged);
                Rad_Co.addTextChangedListener(this);
            }
        });

        Col_Co = (Button) findViewById(R.id.Col_Co);
        Col_Co.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Co"));
        Col_Co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Co");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Co = (Button) findViewById(R.id.Text_Co);
        Text_Co.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Co"));
        Text_Co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Co");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ni = (EditText) findViewById(R.id.Rad_Ni);
        Rad_Ni.setTextSize(20);
        Rad_Ni.addTextChangedListener(new TextWatcher() {
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
                Rad_Ni.removeTextChangedListener(this);
                String text = Rad_Ni.getText().toString();
                Rad_Ni.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ni",Float.valueOf(text));
                }
                Rad_Ni.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ni.setSelection(startChanged+countChanged);
                Rad_Ni.addTextChangedListener(this);
            }
        });

        Col_Ni = (Button) findViewById(R.id.Col_Ni);
        Col_Ni.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ni"));
        Col_Ni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ni");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ni = (Button) findViewById(R.id.Text_Ni);
        Text_Ni.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ni"));
        Text_Ni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ni");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Cu = (EditText) findViewById(R.id.Rad_Cu);
        Rad_Cu.setTextSize(20);
        Rad_Cu.addTextChangedListener(new TextWatcher() {
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
                Rad_Cu.removeTextChangedListener(this);
                String text = Rad_Cu.getText().toString();
                Rad_Cu.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Cu",Float.valueOf(text));
                }
                Rad_Cu.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Cu.setSelection(startChanged+countChanged);
                Rad_Cu.addTextChangedListener(this);
            }
        });

        Col_Cu = (Button) findViewById(R.id.Col_Cu);
        Col_Cu.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Cu"));
        Col_Cu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Cu");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Cu = (Button) findViewById(R.id.Text_Cu);
        Text_Cu.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Cu"));
        Text_Cu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Cu");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Zn = (EditText) findViewById(R.id.Rad_Zn);
        Rad_Zn.setTextSize(20);
        Rad_Zn.addTextChangedListener(new TextWatcher() {
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
                Rad_Zn.removeTextChangedListener(this);
                String text = Rad_Zn.getText().toString();
                Rad_Zn.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Zn",Float.valueOf(text));
                }
                Rad_Zn.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Zn.setSelection(startChanged+countChanged);
                Rad_Zn.addTextChangedListener(this);
            }
        });

        Col_Zn = (Button) findViewById(R.id.Col_Zn);
        Col_Zn.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Zn"));
        Col_Zn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Zn");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Zn = (Button) findViewById(R.id.Text_Zn);
        Text_Zn.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Zn"));
        Text_Zn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Zn");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ga = (EditText) findViewById(R.id.Rad_Ga);
        Rad_Ga.setTextSize(20);
        Rad_Ga.addTextChangedListener(new TextWatcher() {
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
                Rad_Ga.removeTextChangedListener(this);
                String text = Rad_Ga.getText().toString();
                Rad_Ga.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ga",Float.valueOf(text));
                }
                Rad_Ga.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ga.setSelection(startChanged+countChanged);
                Rad_Ga.addTextChangedListener(this);
            }
        });

        Col_Ga = (Button) findViewById(R.id.Col_Ga);
        Col_Ga.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ga"));
        Col_Ga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ga");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ga = (Button) findViewById(R.id.Text_Ga);
        Text_Ga.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ga"));
        Text_Ga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ga");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ge = (EditText) findViewById(R.id.Rad_Ge);
        Rad_Ge.setTextSize(20);
        Rad_Ge.addTextChangedListener(new TextWatcher() {
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
                Rad_Ge.removeTextChangedListener(this);
                String text = Rad_Ge.getText().toString();
                Rad_Ge.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ge",Float.valueOf(text));
                }
                Rad_Ge.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ge.setSelection(startChanged+countChanged);
                Rad_Ge.addTextChangedListener(this);
            }
        });

        Col_Ge = (Button) findViewById(R.id.Col_Ge);
        Col_Ge.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ge"));
        Col_Ge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ge");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ge = (Button) findViewById(R.id.Text_Ge);
        Text_Ge.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ge"));
        Text_Ge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ge");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_As = (EditText) findViewById(R.id.Rad_As);
        Rad_As.setTextSize(20);
        Rad_As.addTextChangedListener(new TextWatcher() {
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
                Rad_As.removeTextChangedListener(this);
                String text = Rad_As.getText().toString();
                Rad_As.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_As",Float.valueOf(text));
                }
                Rad_As.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_As.setSelection(startChanged+countChanged);
                Rad_As.addTextChangedListener(this);
            }
        });

        Col_As = (Button) findViewById(R.id.Col_As);
        Col_As.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_As"));
        Col_As.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_As");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_As = (Button) findViewById(R.id.Text_As);
        Text_As.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_As"));
        Text_As.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_As");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Se = (EditText) findViewById(R.id.Rad_Se);
        Rad_Se.setTextSize(20);
        Rad_Se.addTextChangedListener(new TextWatcher() {
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
                Rad_Se.removeTextChangedListener(this);
                String text = Rad_Se.getText().toString();
                Rad_Se.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Se",Float.valueOf(text));
                }
                Rad_Se.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Se.setSelection(startChanged+countChanged);
                Rad_Se.addTextChangedListener(this);
            }
        });

        Col_Se = (Button) findViewById(R.id.Col_Se);
        Col_Se.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Se"));
        Col_Se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Se");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Se = (Button) findViewById(R.id.Text_Se);
        Text_Se.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Se"));
        Text_Se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Se");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });


        Rad_Br = (EditText) findViewById(R.id.Rad_Br);
        Rad_Br.setTextSize(20);
        Rad_Br.addTextChangedListener(new TextWatcher() {
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
                Rad_Br.removeTextChangedListener(this);
                String text = Rad_Br.getText().toString();
                Rad_Br.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Br",Float.valueOf(text));
                }
                Rad_Br.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Br.setSelection(startChanged+countChanged);
                Rad_Br.addTextChangedListener(this);
            }
        });

        Col_Br = (Button) findViewById(R.id.Col_Br);
        Col_Br.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Br"));
        Col_Br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Br");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Br = (Button) findViewById(R.id.Text_Br);
        Text_Br.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Br"));
        Text_Br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Br");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Kr = (EditText) findViewById(R.id.Rad_Kr);
        Rad_Kr.setTextSize(20);
        Rad_Kr.addTextChangedListener(new TextWatcher() {
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
                Rad_Kr.removeTextChangedListener(this);
                String text = Rad_Kr.getText().toString();
                Rad_Kr.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Kr",Float.valueOf(text));
                }
                Rad_Kr.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Kr.setSelection(startChanged+countChanged);
                Rad_Kr.addTextChangedListener(this);
            }
        });

        Col_Kr = (Button) findViewById(R.id.Col_Kr);
        Col_Kr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Kr"));
        Col_Kr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Kr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Kr = (Button) findViewById(R.id.Text_Kr);
        Text_Kr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Kr"));
        Text_Kr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Kr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Rb = (EditText) findViewById(R.id.Rad_Rb);
        Rad_Rb.setTextSize(20);
        Rad_Rb.addTextChangedListener(new TextWatcher() {
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
                Rad_Rb.removeTextChangedListener(this);
                String text = Rad_Rb.getText().toString();
                Rad_Rb.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Rb",Float.valueOf(text));
                }
                Rad_Rb.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Rb.setSelection(startChanged+countChanged);
                Rad_Rb.addTextChangedListener(this);
            }
        });

        Col_Rb = (Button) findViewById(R.id.Col_Rb);
        Col_Rb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Rb"));
        Col_Rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Rb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Rb = (Button) findViewById(R.id.Text_Rb);
        Text_Rb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Rb"));
        Text_Rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Rb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Sr = (EditText) findViewById(R.id.Rad_Sr);
        Rad_Sr.setTextSize(20);
        Rad_Sr.addTextChangedListener(new TextWatcher() {
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
                Rad_Sr.removeTextChangedListener(this);
                String text = Rad_Sr.getText().toString();
                Rad_Sr.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Sr",Float.valueOf(text));
                }
                Rad_Sr.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Sr.setSelection(startChanged+countChanged);
                Rad_Sr.addTextChangedListener(this);
            }
        });

        Col_Sr = (Button) findViewById(R.id.Col_Sr);
        Col_Sr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Sr"));
        Col_Sr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Sr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Sr = (Button) findViewById(R.id.Text_Sr);
        Text_Sr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Sr"));
        Text_Sr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Sr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Y = (EditText) findViewById(R.id.Rad_Y);
        Rad_Y.setTextSize(20);
        Rad_Y.addTextChangedListener(new TextWatcher() {
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
                Rad_Y.removeTextChangedListener(this);
                String text = Rad_Y.getText().toString();
                Rad_Y.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Y",Float.valueOf(text));
                }
                Rad_Y.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Y.setSelection(startChanged+countChanged);
                Rad_Y.addTextChangedListener(this);
            }
        });

        Col_Y = (Button) findViewById(R.id.Col_Y);
        Col_Y.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Y"));
        Col_Y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Y");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Y = (Button) findViewById(R.id.Text_Y);
        Text_Y.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Y"));
        Text_Y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Y");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Zr = (EditText) findViewById(R.id.Rad_Zr);
        Rad_Zr.setTextSize(20);
        Rad_Zr.addTextChangedListener(new TextWatcher() {
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
                Rad_Zr.removeTextChangedListener(this);
                String text = Rad_Zr.getText().toString();
                Rad_Zr.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Zr",Float.valueOf(text));
                }
                Rad_Zr.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Zr.setSelection(startChanged+countChanged);
                Rad_Zr.addTextChangedListener(this);
            }
        });

        Col_Zr = (Button) findViewById(R.id.Col_Zr);
        Col_Zr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Zr"));
        Col_Zr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Zr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Zr = (Button) findViewById(R.id.Text_Zr);
        Text_Zr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Zr"));
        Text_Zr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Zr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Nb = (EditText) findViewById(R.id.Rad_Nb);
        Rad_Nb.setTextSize(20);
        Rad_Nb.addTextChangedListener(new TextWatcher() {
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
                Rad_Nb.removeTextChangedListener(this);
                String text = Rad_Nb.getText().toString();
                Rad_Nb.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Nb",Float.valueOf(text));
                }
                Rad_Nb.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Nb.setSelection(startChanged+countChanged);
                Rad_Nb.addTextChangedListener(this);
            }
        });

        Col_Nb = (Button) findViewById(R.id.Col_Nb);
        Col_Nb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Nb"));
        Col_Nb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Nb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Nb = (Button) findViewById(R.id.Text_Nb);
        Text_Nb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Nb"));
        Text_Nb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Nb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Mo = (EditText) findViewById(R.id.Rad_Mo);
        Rad_Mo.setTextSize(20);
        Rad_Mo.addTextChangedListener(new TextWatcher() {
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
                Rad_Mo.removeTextChangedListener(this);
                String text = Rad_Mo.getText().toString();
                Rad_Mo.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Mo",Float.valueOf(text));
                }
                Rad_Mo.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Mo.setSelection(startChanged+countChanged);
                Rad_Mo.addTextChangedListener(this);
            }
        });

        Col_Mo = (Button) findViewById(R.id.Col_Mo);
        Col_Mo.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Mo"));
        Col_Mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Mo");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Mo = (Button) findViewById(R.id.Text_Mo);
        Text_Mo.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Mo"));
        Text_Mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Mo");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Tc = (EditText) findViewById(R.id.Rad_Tc);
        Rad_Tc.setTextSize(20);
        Rad_Tc.addTextChangedListener(new TextWatcher() {
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
                Rad_Tc.removeTextChangedListener(this);
                String text = Rad_Tc.getText().toString();
                Rad_Tc.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Tc",Float.valueOf(text));
                }
                Rad_Tc.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Tc.setSelection(startChanged+countChanged);
                Rad_Tc.addTextChangedListener(this);
            }
        });

        Col_Tc = (Button) findViewById(R.id.Col_Tc);
        Col_Tc.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Tc"));
        Col_Tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Tc");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Tc = (Button) findViewById(R.id.Text_Tc);
        Text_Tc.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Tc"));
        Text_Tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Tc");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ru = (EditText) findViewById(R.id.Rad_Ru);
        Rad_Ru.setTextSize(20);
        Rad_Ru.addTextChangedListener(new TextWatcher() {
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
                Rad_Ru.removeTextChangedListener(this);
                String text = Rad_Ru.getText().toString();
                Rad_Ru.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ru",Float.valueOf(text));
                }
                Rad_Ru.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ru.setSelection(startChanged+countChanged);
                Rad_Ru.addTextChangedListener(this);
            }
        });

        Col_Ru = (Button) findViewById(R.id.Col_Ru);
        Col_Ru.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ru"));
        Col_Ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ru");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ru = (Button) findViewById(R.id.Text_Ru);
        Text_Ru.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ru"));
        Text_Ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ru");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Rh = (EditText) findViewById(R.id.Rad_Rh);
        Rad_Rh.setTextSize(20);
        Rad_Rh.addTextChangedListener(new TextWatcher() {
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
                Rad_Rh.removeTextChangedListener(this);
                String text = Rad_Rh.getText().toString();
                Rad_Rh.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Rh",Float.valueOf(text));
                }
                Rad_Rh.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Rh.setSelection(startChanged+countChanged);
                Rad_Rh.addTextChangedListener(this);
            }
        });

        Col_Rh = (Button) findViewById(R.id.Col_Rh);
        Col_Rh.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Rh"));
        Col_Rh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Rh");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Rh = (Button) findViewById(R.id.Text_Rh);
        Text_Rh.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Rh"));
        Text_Rh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Rh");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Pd = (EditText) findViewById(R.id.Rad_Pd);
        Rad_Pd.setTextSize(20);
        Rad_Pd.addTextChangedListener(new TextWatcher() {
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
                Rad_Pd.removeTextChangedListener(this);
                String text = Rad_Pd.getText().toString();
                Rad_Pd.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Pd",Float.valueOf(text));
                }
                Rad_Pd.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Pd.setSelection(startChanged+countChanged);
                Rad_Pd.addTextChangedListener(this);
            }
        });

        Col_Pd = (Button) findViewById(R.id.Col_Pd);
        Col_Pd.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Pd"));
        Col_Pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Pd");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Pd = (Button) findViewById(R.id.Text_Pd);
        Text_Pd.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Pd"));
        Text_Pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Pd");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ag = (EditText) findViewById(R.id.Rad_Ag);
        Rad_Ag.setTextSize(20);
        Rad_Ag.addTextChangedListener(new TextWatcher() {
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
                Rad_Ag.removeTextChangedListener(this);
                String text = Rad_Ag.getText().toString();
                Rad_Ag.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ag",Float.valueOf(text));
                }
                Rad_Ag.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ag.setSelection(startChanged+countChanged);
                Rad_Ag.addTextChangedListener(this);
            }
        });

        Col_Ag = (Button) findViewById(R.id.Col_Ag);
        Col_Ag.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ag"));
        Col_Ag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ag");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ag = (Button) findViewById(R.id.Text_Ag);
        Text_Ag.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ag"));
        Text_Ag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ag");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Cd = (EditText) findViewById(R.id.Rad_Cd);
        Rad_Cd.setTextSize(20);
        Rad_Cd.addTextChangedListener(new TextWatcher() {
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
                Rad_Cd.removeTextChangedListener(this);
                String text = Rad_Cd.getText().toString();
                Rad_Cd.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Cd",Float.valueOf(text));
                }
                Rad_Cd.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Cd.setSelection(startChanged+countChanged);
                Rad_Cd.addTextChangedListener(this);
            }
        });

        Col_Cd = (Button) findViewById(R.id.Col_Cd);
        Col_Cd.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Cd"));
        Col_Cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Cd");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Cd = (Button) findViewById(R.id.Text_Cd);
        Text_Cd.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Cd"));
        Text_Cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Cd");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_In = (EditText) findViewById(R.id.Rad_In);
        Rad_In.setTextSize(20);
        Rad_In.addTextChangedListener(new TextWatcher() {
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
                Rad_In.removeTextChangedListener(this);
                String text = Rad_In.getText().toString();
                Rad_In.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_In",Float.valueOf(text));
                }
                Rad_In.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_In.setSelection(startChanged+countChanged);
                Rad_In.addTextChangedListener(this);
            }
        });

        Col_In = (Button) findViewById(R.id.Col_In);
        Col_In.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_In"));
        Col_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_In");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_In = (Button) findViewById(R.id.Text_In);
        Text_In.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_In"));
        Text_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_In");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Sn = (EditText) findViewById(R.id.Rad_Sn);
        Rad_Sn.setTextSize(20);
        Rad_Sn.addTextChangedListener(new TextWatcher() {
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
                Rad_Sn.removeTextChangedListener(this);
                String text = Rad_Sn.getText().toString();
                Rad_Sn.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Sn",Float.valueOf(text));
                }
                Rad_Sn.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Sn.setSelection(startChanged+countChanged);
                Rad_Sn.addTextChangedListener(this);
            }
        });

        Col_Sn = (Button) findViewById(R.id.Col_Sn);
        Col_Sn.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Sn"));
        Col_Sn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Sn");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Sn = (Button) findViewById(R.id.Text_Sn);
        Text_Sn.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Sn"));
        Text_Sn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Sn");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Sb = (EditText) findViewById(R.id.Rad_Sb);
        Rad_Sb.setTextSize(20);
        Rad_Sb.addTextChangedListener(new TextWatcher() {
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
                Rad_Sb.removeTextChangedListener(this);
                String text = Rad_Sb.getText().toString();
                Rad_Sb.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Sb",Float.valueOf(text));
                }
                Rad_Sb.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Sb.setSelection(startChanged+countChanged);
                Rad_Sb.addTextChangedListener(this);
            }
        });

        Col_Sb = (Button) findViewById(R.id.Col_Sb);
        Col_Sb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Sb"));
        Col_Sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Sb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Sb = (Button) findViewById(R.id.Text_Sb);
        Text_Sb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Sb"));
        Text_Sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Sb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Te = (EditText) findViewById(R.id.Rad_Te);
        Rad_Te.setTextSize(20);
        Rad_Te.addTextChangedListener(new TextWatcher() {
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
                Rad_Te.removeTextChangedListener(this);
                String text = Rad_Te.getText().toString();
                Rad_Te.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Te",Float.valueOf(text));
                }
                Rad_Te.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Te.setSelection(startChanged+countChanged);
                Rad_Te.addTextChangedListener(this);
            }
        });

        Col_Te = (Button) findViewById(R.id.Col_Te);
        Col_Te.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Te"));
        Col_Te.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Te");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Te = (Button) findViewById(R.id.Text_Te);
        Text_Te.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Te"));
        Text_Te.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Te");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_I = (EditText) findViewById(R.id.Rad_I);
        Rad_I.setTextSize(20);
        Rad_I.addTextChangedListener(new TextWatcher() {
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
                Rad_I.removeTextChangedListener(this);
                String text = Rad_I.getText().toString();
                Rad_I.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_I",Float.valueOf(text));
                }
                Rad_I.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_I.setSelection(startChanged+countChanged);
                Rad_I.addTextChangedListener(this);
            }
        });

        Col_I = (Button) findViewById(R.id.Col_I);
        Col_I.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_I"));
        Col_I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_I");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_I = (Button) findViewById(R.id.Text_I);
        Text_I.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_I"));
        Text_I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_I");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Xe = (EditText) findViewById(R.id.Rad_Xe);
        Rad_Xe.setTextSize(20);
        Rad_Xe.addTextChangedListener(new TextWatcher() {
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
                Rad_Xe.removeTextChangedListener(this);
                String text = Rad_Xe.getText().toString();
                Rad_Xe.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Xe",Float.valueOf(text));
                }
                Rad_Xe.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Xe.setSelection(startChanged+countChanged);
                Rad_Xe.addTextChangedListener(this);
            }
        });

        Col_Xe = (Button) findViewById(R.id.Col_Xe);
        Col_Xe.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Xe"));
        Col_Xe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Xe");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Xe = (Button) findViewById(R.id.Text_Xe);
        Text_Xe.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Xe"));
        Text_Xe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Xe");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Cs = (EditText) findViewById(R.id.Rad_Cs);
        Rad_Cs.setTextSize(20);
        Rad_Cs.addTextChangedListener(new TextWatcher() {
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
                Rad_Cs.removeTextChangedListener(this);
                String text = Rad_Cs.getText().toString();
                Rad_Cs.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Cs",Float.valueOf(text));
                }
                Rad_Cs.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Cs.setSelection(startChanged+countChanged);
                Rad_Cs.addTextChangedListener(this);
            }
        });

        Col_Cs = (Button) findViewById(R.id.Col_Cs);
        Col_Cs.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Cs"));
        Col_Cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Cs");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Cs = (Button) findViewById(R.id.Text_Cs);
        Text_Cs.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Cs"));
        Text_Cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Cs");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ba = (EditText) findViewById(R.id.Rad_Ba);
        Rad_Ba.setTextSize(20);
        Rad_Ba.addTextChangedListener(new TextWatcher() {
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
                Rad_Ba.removeTextChangedListener(this);
                String text = Rad_Ba.getText().toString();
                Rad_Ba.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ba",Float.valueOf(text));
                }
                Rad_Ba.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ba.setSelection(startChanged+countChanged);
                Rad_Ba.addTextChangedListener(this);
            }
        });

        Col_Ba = (Button) findViewById(R.id.Col_Ba);
        Col_Ba.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ba"));
        Col_Ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ba");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ba = (Button) findViewById(R.id.Text_Ba);
        Text_Ba.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ba"));
        Text_Ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ba");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_La = (EditText) findViewById(R.id.Rad_La);
        Rad_La.setTextSize(20);
        Rad_La.addTextChangedListener(new TextWatcher() {
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
                Rad_La.removeTextChangedListener(this);
                String text = Rad_La.getText().toString();
                Rad_La.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_La",Float.valueOf(text));
                }
                Rad_La.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_La.setSelection(startChanged+countChanged);
                Rad_La.addTextChangedListener(this);
            }
        });

        Col_La = (Button) findViewById(R.id.Col_La);
        Col_La.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_La"));
        Col_La.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_La");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_La = (Button) findViewById(R.id.Text_La);
        Text_La.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_La"));
        Text_La.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_La");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ce = (EditText) findViewById(R.id.Rad_Ce);
        Rad_Ce.setTextSize(20);
        Rad_Ce.addTextChangedListener(new TextWatcher() {
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
                Rad_Ce.removeTextChangedListener(this);
                String text = Rad_Ce.getText().toString();
                Rad_Ce.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ce",Float.valueOf(text));
                }
                Rad_Ce.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ce.setSelection(startChanged+countChanged);
                Rad_Ce.addTextChangedListener(this);
            }
        });

        Col_Ce = (Button) findViewById(R.id.Col_Ce);
        Col_Ce.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ce"));
        Col_Ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ce");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ce = (Button) findViewById(R.id.Text_Ce);
        Text_Ce.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ce"));
        Text_Ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ce");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Pr = (EditText) findViewById(R.id.Rad_Pr);
        Rad_Pr.setTextSize(20);
        Rad_Pr.addTextChangedListener(new TextWatcher() {
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
                Rad_Pr.removeTextChangedListener(this);
                String text = Rad_Pr.getText().toString();
                Rad_Pr.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Pr",Float.valueOf(text));
                }
                Rad_Pr.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Pr.setSelection(startChanged+countChanged);
                Rad_Pr.addTextChangedListener(this);
            }
        });

        Col_Pr = (Button) findViewById(R.id.Col_Pr);
        Col_Pr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Pr"));
        Col_Pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Pr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Pr = (Button) findViewById(R.id.Text_Pr);
        Text_Pr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Pr"));
        Text_Pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Pr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Nd = (EditText) findViewById(R.id.Rad_Nd);
        Rad_Nd.setTextSize(20);
        Rad_Nd.addTextChangedListener(new TextWatcher() {
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
                Rad_Nd.removeTextChangedListener(this);
                String text = Rad_Nd.getText().toString();
                Rad_Nd.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Nd",Float.valueOf(text));
                }
                Rad_Nd.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Nd.setSelection(startChanged+countChanged);
                Rad_Nd.addTextChangedListener(this);
            }
        });

        Col_Nd = (Button) findViewById(R.id.Col_Nd);
        Col_Nd.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Nd"));
        Col_Nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Nd");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Nd = (Button) findViewById(R.id.Text_Nd);
        Text_Nd.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Nd"));
        Text_Nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Nd");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Pm = (EditText) findViewById(R.id.Rad_Pm);
        Rad_Pm.setTextSize(20);
        Rad_Pm.addTextChangedListener(new TextWatcher() {
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
                Rad_Pm.removeTextChangedListener(this);
                String text = Rad_Pm.getText().toString();
                Rad_Pm.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Pm",Float.valueOf(text));
                }
                Rad_Pm.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Pm.setSelection(startChanged+countChanged);
                Rad_Pm.addTextChangedListener(this);
            }
        });

        Col_Pm = (Button) findViewById(R.id.Col_Pm);
        Col_Pm.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Pm"));
        Col_Pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Pm");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Pm = (Button) findViewById(R.id.Text_Pm);
        Text_Pm.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Pm"));
        Text_Pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Pm");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Sm = (EditText) findViewById(R.id.Rad_Sm);
        Rad_Sm.setTextSize(20);
        Rad_Sm.addTextChangedListener(new TextWatcher() {
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
                Rad_Sm.removeTextChangedListener(this);
                String text = Rad_Sm.getText().toString();
                Rad_Sm.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Sm",Float.valueOf(text));
                }
                Rad_Sm.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Sm.setSelection(startChanged+countChanged);
                Rad_Sm.addTextChangedListener(this);
            }
        });

        Col_Sm = (Button) findViewById(R.id.Col_Sm);
        Col_Sm.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Sm"));
        Col_Sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Sm");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Sm = (Button) findViewById(R.id.Text_Sm);
        Text_Sm.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Sm"));
        Text_Sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Sm");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Eu = (EditText) findViewById(R.id.Rad_Eu);
        Rad_Eu.setTextSize(20);
        Rad_Eu.addTextChangedListener(new TextWatcher() {
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
                Rad_Eu.removeTextChangedListener(this);
                String text = Rad_Eu.getText().toString();
                Rad_Eu.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Eu",Float.valueOf(text));
                }
                Rad_Eu.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Eu.setSelection(startChanged+countChanged);
                Rad_Eu.addTextChangedListener(this);
            }
        });

        Col_Eu = (Button) findViewById(R.id.Col_Eu);
        Col_Eu.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Eu"));
        Col_Eu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Eu");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Eu = (Button) findViewById(R.id.Text_Eu);
        Text_Eu.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Eu"));
        Text_Eu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Eu");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Gd = (EditText) findViewById(R.id.Rad_Gd);
        Rad_Gd.setTextSize(20);
        Rad_Gd.addTextChangedListener(new TextWatcher() {
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
                Rad_Gd.removeTextChangedListener(this);
                String text = Rad_Gd.getText().toString();
                Rad_Gd.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Gd",Float.valueOf(text));
                }
                Rad_Gd.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Gd.setSelection(startChanged+countChanged);
                Rad_Gd.addTextChangedListener(this);
            }
        });

        Col_Gd = (Button) findViewById(R.id.Col_Gd);
        Col_Gd.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Gd"));
        Col_Gd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Gd");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Gd = (Button) findViewById(R.id.Text_Gd);
        Text_Gd.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Gd"));
        Text_Gd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Gd");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Tb = (EditText) findViewById(R.id.Rad_Tb);
        Rad_Tb.setTextSize(20);
        Rad_Tb.addTextChangedListener(new TextWatcher() {
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
                Rad_Tb.removeTextChangedListener(this);
                String text = Rad_Tb.getText().toString();
                Rad_Tb.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Tb",Float.valueOf(text));
                }
                Rad_Tb.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Tb.setSelection(startChanged+countChanged);
                Rad_Tb.addTextChangedListener(this);
            }
        });

        Col_Tb = (Button) findViewById(R.id.Col_Tb);
        Col_Tb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Tb"));
        Col_Tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Tb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Tb = (Button) findViewById(R.id.Text_Tb);
        Text_Tb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Tb"));
        Text_Tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Tb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Dy = (EditText) findViewById(R.id.Rad_Dy);
        Rad_Dy.setTextSize(20);
        Rad_Dy.addTextChangedListener(new TextWatcher() {
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
                Rad_Dy.removeTextChangedListener(this);
                String text = Rad_Dy.getText().toString();
                Rad_Dy.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Dy",Float.valueOf(text));
                }
                Rad_Dy.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Dy.setSelection(startChanged+countChanged);
                Rad_Dy.addTextChangedListener(this);
            }
        });

        Col_Dy = (Button) findViewById(R.id.Col_Dy);
        Col_Dy.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Dy"));
        Col_Dy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Dy");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Dy = (Button) findViewById(R.id.Text_Dy);
        Text_Dy.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Dy"));
        Text_Dy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Dy");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ho = (EditText) findViewById(R.id.Rad_Ho);
        Rad_Ho.setTextSize(20);
        Rad_Ho.addTextChangedListener(new TextWatcher() {
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
                Rad_Ho.removeTextChangedListener(this);
                String text = Rad_Ho.getText().toString();
                Rad_Ho.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ho",Float.valueOf(text));
                }
                Rad_Ho.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ho.setSelection(startChanged+countChanged);
                Rad_Ho.addTextChangedListener(this);
            }
        });

        Col_Ho = (Button) findViewById(R.id.Col_Ho);
        Col_Ho.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ho"));
        Col_Ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ho");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ho = (Button) findViewById(R.id.Text_Ho);
        Text_Ho.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ho"));
        Text_Ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ho");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Er = (EditText) findViewById(R.id.Rad_Er);
        Rad_Er.setTextSize(20);
        Rad_Er.addTextChangedListener(new TextWatcher() {
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
                Rad_Er.removeTextChangedListener(this);
                String text = Rad_Er.getText().toString();
                Rad_Er.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Er",Float.valueOf(text));
                }
                Rad_Er.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Er.setSelection(startChanged+countChanged);
                Rad_Er.addTextChangedListener(this);
            }
        });

        Col_Er = (Button) findViewById(R.id.Col_Er);
        Col_Er.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Er"));
        Col_Er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Er");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Er = (Button) findViewById(R.id.Text_Er);
        Text_Er.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Er"));
        Text_Er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Er");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Tm = (EditText) findViewById(R.id.Rad_Tm);
        Rad_Tm.setTextSize(20);
        Rad_Tm.addTextChangedListener(new TextWatcher() {
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
                Rad_Tm.removeTextChangedListener(this);
                String text = Rad_Tm.getText().toString();
                Rad_Tm.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Tm",Float.valueOf(text));
                }
                Rad_Tm.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Tm.setSelection(startChanged+countChanged);
                Rad_Tm.addTextChangedListener(this);
            }
        });

        Col_Tm = (Button) findViewById(R.id.Col_Tm);
        Col_Tm.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Tm"));
        Col_Tm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Tm");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Tm = (Button) findViewById(R.id.Text_Tm);
        Text_Tm.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Tm"));
        Text_Tm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Tm");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Yb = (EditText) findViewById(R.id.Rad_Yb);
        Rad_Yb.setTextSize(20);
        Rad_Yb.addTextChangedListener(new TextWatcher() {
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
                Rad_Yb.removeTextChangedListener(this);
                String text = Rad_Yb.getText().toString();
                Rad_Yb.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Yb",Float.valueOf(text));
                }
                Rad_Yb.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Yb.setSelection(startChanged+countChanged);
                Rad_Yb.addTextChangedListener(this);
            }
        });

        Col_Yb = (Button) findViewById(R.id.Col_Yb);
        Col_Yb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Yb"));
        Col_Yb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Yb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Yb = (Button) findViewById(R.id.Text_Yb);
        Text_Yb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Yb"));
        Text_Yb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Yb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Lu = (EditText) findViewById(R.id.Rad_Lu);
        Rad_Lu.setTextSize(20);
        Rad_Lu.addTextChangedListener(new TextWatcher() {
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
                Rad_Lu.removeTextChangedListener(this);
                String text = Rad_Lu.getText().toString();
                Rad_Lu.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Lu",Float.valueOf(text));
                }
                Rad_Lu.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Lu.setSelection(startChanged+countChanged);
                Rad_Lu.addTextChangedListener(this);
            }
        });

        Col_Lu = (Button) findViewById(R.id.Col_Lu);
        Col_Lu.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Lu"));
        Col_Lu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Lu");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Lu = (Button) findViewById(R.id.Text_Lu);
        Text_Lu.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Lu"));
        Text_Lu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Lu");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Hf = (EditText) findViewById(R.id.Rad_Hf);
        Rad_Hf.setTextSize(20);
        Rad_Hf.addTextChangedListener(new TextWatcher() {
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
                Rad_Hf.removeTextChangedListener(this);
                String text = Rad_Hf.getText().toString();
                Rad_Hf.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Hf",Float.valueOf(text));
                }
                Rad_Hf.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Hf.setSelection(startChanged+countChanged);
                Rad_Hf.addTextChangedListener(this);
            }
        });

        Col_Hf = (Button) findViewById(R.id.Col_Hf);
        Col_Hf.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Hf"));
        Col_Hf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Hf");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Hf = (Button) findViewById(R.id.Text_Hf);
        Text_Hf.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Hf"));
        Text_Hf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Hf");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ta = (EditText) findViewById(R.id.Rad_Ta);
        Rad_Ta.setTextSize(20);
        Rad_Ta.addTextChangedListener(new TextWatcher() {
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
                Rad_Ta.removeTextChangedListener(this);
                String text = Rad_Ta.getText().toString();
                Rad_Ta.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ta",Float.valueOf(text));
                }
                Rad_Ta.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ta.setSelection(startChanged+countChanged);
                Rad_Ta.addTextChangedListener(this);
            }
        });

        Col_Ta = (Button) findViewById(R.id.Col_Ta);
        Col_Ta.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ta"));
        Col_Ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ta");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ta = (Button) findViewById(R.id.Text_Ta);
        Text_Ta.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ta"));
        Text_Ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ta");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_W = (EditText) findViewById(R.id.Rad_W);
        Rad_W.setTextSize(20);
        Rad_W.addTextChangedListener(new TextWatcher() {
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
                Rad_W.removeTextChangedListener(this);
                String text = Rad_W.getText().toString();
                Rad_W.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_W",Float.valueOf(text));
                }
                Rad_W.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_W.setSelection(startChanged+countChanged);
                Rad_W.addTextChangedListener(this);
            }
        });

        Col_W = (Button) findViewById(R.id.Col_W);
        Col_W.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_W"));
        Col_W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_W");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_W = (Button) findViewById(R.id.Text_W);
        Text_W.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_W"));
        Text_W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_W");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Re = (EditText) findViewById(R.id.Rad_Re);
        Rad_Re.setTextSize(20);
        Rad_Re.addTextChangedListener(new TextWatcher() {
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
                Rad_Re.removeTextChangedListener(this);
                String text = Rad_Re.getText().toString();
                Rad_Re.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Re",Float.valueOf(text));
                }
                Rad_Re.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Re.setSelection(startChanged+countChanged);
                Rad_Re.addTextChangedListener(this);
            }
        });

        Col_Re = (Button) findViewById(R.id.Col_Re);
        Col_Re.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Re"));
        Col_Re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Re");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Re = (Button) findViewById(R.id.Text_Re);
        Text_Re.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Re"));
        Text_Re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Re");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Os = (EditText) findViewById(R.id.Rad_Os);
        Rad_Os.setTextSize(20);
        Rad_Os.addTextChangedListener(new TextWatcher() {
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
                Rad_Os.removeTextChangedListener(this);
                String text = Rad_Os.getText().toString();
                Rad_Os.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Os",Float.valueOf(text));
                }
                Rad_Os.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Os.setSelection(startChanged+countChanged);
                Rad_Os.addTextChangedListener(this);
            }
        });

        Col_Os = (Button) findViewById(R.id.Col_Os);
        Col_Os.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Os"));
        Col_Os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Os");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Os = (Button) findViewById(R.id.Text_Os);
        Text_Os.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Os"));
        Text_Os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Os");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ir = (EditText) findViewById(R.id.Rad_Ir);
        Rad_Ir.setTextSize(20);
        Rad_Ir.addTextChangedListener(new TextWatcher() {
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
                Rad_Ir.removeTextChangedListener(this);
                String text = Rad_Ir.getText().toString();
                Rad_Ir.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ir",Float.valueOf(text));
                }
                Rad_Ir.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ir.setSelection(startChanged+countChanged);
                Rad_Ir.addTextChangedListener(this);
            }
        });

        Col_Ir = (Button) findViewById(R.id.Col_Ir);
        Col_Ir.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ir"));
        Col_Ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ir");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ir = (Button) findViewById(R.id.Text_Ir);
        Text_Ir.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ir"));
        Text_Ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ir");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Pt = (EditText) findViewById(R.id.Rad_Pt);
        Rad_Pt.setTextSize(20);
        Rad_Pt.addTextChangedListener(new TextWatcher() {
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
                Rad_Pt.removeTextChangedListener(this);
                String text = Rad_Pt.getText().toString();
                Rad_Pt.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Pt",Float.valueOf(text));
                }
                Rad_Pt.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Pt.setSelection(startChanged+countChanged);
                Rad_Pt.addTextChangedListener(this);
            }
        });

        Col_Pt = (Button) findViewById(R.id.Col_Pt);
        Col_Pt.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Pt"));
        Col_Pt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Pt");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Pt = (Button) findViewById(R.id.Text_Pt);
        Text_Pt.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Pt"));
        Text_Pt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Pt");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Au = (EditText) findViewById(R.id.Rad_Au);
        Rad_Au.setTextSize(20);
        Rad_Au.addTextChangedListener(new TextWatcher() {
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
                Rad_Au.removeTextChangedListener(this);
                String text = Rad_Au.getText().toString();
                Rad_Au.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Au",Float.valueOf(text));
                }
                Rad_Au.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Au.setSelection(startChanged+countChanged);
                Rad_Au.addTextChangedListener(this);
            }
        });

        Col_Au = (Button) findViewById(R.id.Col_Au);
        Col_Au.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Au"));
        Col_Au.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Au");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Au = (Button) findViewById(R.id.Text_Au);
        Text_Au.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Au"));
        Text_Au.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Au");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Hg = (EditText) findViewById(R.id.Rad_Hg);
        Rad_Hg.setTextSize(20);
        Rad_Hg.addTextChangedListener(new TextWatcher() {
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
                Rad_Hg.removeTextChangedListener(this);
                String text = Rad_Hg.getText().toString();
                Rad_Hg.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Hg",Float.valueOf(text));
                }
                Rad_Hg.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Hg.setSelection(startChanged+countChanged);
                Rad_Hg.addTextChangedListener(this);
            }
        });

        Col_Hg = (Button) findViewById(R.id.Col_Hg);
        Col_Hg.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Hg"));
        Col_Hg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Hg");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Hg = (Button) findViewById(R.id.Text_Hg);
        Text_Hg.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Hg"));
        Text_Hg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Hg");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Tl = (EditText) findViewById(R.id.Rad_Tl);
        Rad_Tl.setTextSize(20);
        Rad_Tl.addTextChangedListener(new TextWatcher() {
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
                Rad_Tl.removeTextChangedListener(this);
                String text = Rad_Tl.getText().toString();
                Rad_Tl.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Tl",Float.valueOf(text));
                }
                Rad_Tl.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Tl.setSelection(startChanged+countChanged);
                Rad_Tl.addTextChangedListener(this);
            }
        });

        Col_Tl = (Button) findViewById(R.id.Col_Tl);
        Col_Tl.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Tl"));
        Col_Tl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Tl");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Tl = (Button) findViewById(R.id.Text_Tl);
        Text_Tl.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Tl"));
        Text_Tl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Tl");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Pb = (EditText) findViewById(R.id.Rad_Pb);
        Rad_Pb.setTextSize(20);
        Rad_Pb.addTextChangedListener(new TextWatcher() {
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
                Rad_Pb.removeTextChangedListener(this);
                String text = Rad_Pb.getText().toString();
                Rad_Pb.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Pb",Float.valueOf(text));
                }
                Rad_Pb.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Pb.setSelection(startChanged+countChanged);
                Rad_Pb.addTextChangedListener(this);
            }
        });

        Col_Pb = (Button) findViewById(R.id.Col_Pb);
        Col_Pb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Pb"));
        Col_Pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Pb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Pb = (Button) findViewById(R.id.Text_Pb);
        Text_Pb.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Pb"));
        Text_Pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Pb");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Bi = (EditText) findViewById(R.id.Rad_Bi);
        Rad_Bi.setTextSize(20);
        Rad_Bi.addTextChangedListener(new TextWatcher() {
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
                Rad_Bi.removeTextChangedListener(this);
                String text = Rad_Bi.getText().toString();
                Rad_Bi.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Bi",Float.valueOf(text));
                }
                Rad_Bi.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Bi.setSelection(startChanged+countChanged);
                Rad_Bi.addTextChangedListener(this);
            }
        });

        Col_Bi = (Button) findViewById(R.id.Col_Bi);
        Col_Bi.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Bi"));
        Col_Bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Bi");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Bi = (Button) findViewById(R.id.Text_Bi);
        Text_Bi.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Bi"));
        Text_Bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Bi");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Po = (EditText) findViewById(R.id.Rad_Po);
        Rad_Po.setTextSize(20);
        Rad_Po.addTextChangedListener(new TextWatcher() {
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
                Rad_Po.removeTextChangedListener(this);
                String text = Rad_Po.getText().toString();
                Rad_Po.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Po",Float.valueOf(text));
                }
                Rad_Po.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Po.setSelection(startChanged+countChanged);
                Rad_Po.addTextChangedListener(this);
            }
        });

        Col_Po = (Button) findViewById(R.id.Col_Po);
        Col_Po.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Po"));
        Col_Po.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Po");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Po = (Button) findViewById(R.id.Text_Po);
        Text_Po.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Po"));
        Text_Po.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Po");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_At = (EditText) findViewById(R.id.Rad_At);
        Rad_At.setTextSize(20);
        Rad_At.addTextChangedListener(new TextWatcher() {
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
                Rad_At.removeTextChangedListener(this);
                String text = Rad_At.getText().toString();
                Rad_At.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_At",Float.valueOf(text));
                }
                Rad_At.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_At.setSelection(startChanged+countChanged);
                Rad_At.addTextChangedListener(this);
            }
        });

        Col_At = (Button) findViewById(R.id.Col_At);
        Col_At.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_At"));
        Col_At.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_At");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_At = (Button) findViewById(R.id.Text_At);
        Text_At.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_At"));
        Text_At.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_At");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Rn = (EditText) findViewById(R.id.Rad_Rn);
        Rad_Rn.setTextSize(20);
        Rad_Rn.addTextChangedListener(new TextWatcher() {
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
                Rad_Rn.removeTextChangedListener(this);
                String text = Rad_Rn.getText().toString();
                Rad_Rn.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Rn",Float.valueOf(text));
                }
                Rad_Rn.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Rn.setSelection(startChanged+countChanged);
                Rad_Rn.addTextChangedListener(this);
            }
        });

        Col_Rn = (Button) findViewById(R.id.Col_Rn);
        Col_Rn.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Rn"));
        Col_Rn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Rn");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Rn = (Button) findViewById(R.id.Text_Rn);
        Text_Rn.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Rn"));
        Text_Rn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Rn");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Fr = (EditText) findViewById(R.id.Rad_Fr);
        Rad_Fr.setTextSize(20);
        Rad_Fr.addTextChangedListener(new TextWatcher() {
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
                Rad_Fr.removeTextChangedListener(this);
                String text = Rad_Fr.getText().toString();
                Rad_Fr.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Fr",Float.valueOf(text));
                }
                Rad_Fr.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Fr.setSelection(startChanged+countChanged);
                Rad_Fr.addTextChangedListener(this);
            }
        });

        Col_Fr = (Button) findViewById(R.id.Col_Fr);
        Col_Fr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Fr"));
        Col_Fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Fr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Fr = (Button) findViewById(R.id.Text_Fr);
        Text_Fr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Fr"));
        Text_Fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Fr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ra = (EditText) findViewById(R.id.Rad_Ra);
        Rad_Ra.setTextSize(20);
        Rad_Ra.addTextChangedListener(new TextWatcher() {
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
                Rad_Ra.removeTextChangedListener(this);
                String text = Rad_Ra.getText().toString();
                Rad_Ra.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ra",Float.valueOf(text));
                }
                Rad_Ra.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ra.setSelection(startChanged+countChanged);
                Rad_Ra.addTextChangedListener(this);
            }
        });

        Col_Ra = (Button) findViewById(R.id.Col_Ra);
        Col_Ra.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ra"));
        Col_Ra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ra");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ra = (Button) findViewById(R.id.Text_Ra);
        Text_Ra.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ra"));
        Text_Ra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ra");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ac = (EditText) findViewById(R.id.Rad_Ac);
        Rad_Ac.setTextSize(20);
        Rad_Ac.addTextChangedListener(new TextWatcher() {
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
                Rad_Ac.removeTextChangedListener(this);
                String text = Rad_Ac.getText().toString();
                Rad_Ac.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ac",Float.valueOf(text));
                }
                Rad_Ac.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ac.setSelection(startChanged+countChanged);
                Rad_Ac.addTextChangedListener(this);
            }
        });

        Col_Ac = (Button) findViewById(R.id.Col_Ac);
        Col_Ac.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ac"));
        Col_Ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ac");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ac = (Button) findViewById(R.id.Text_Ac);
        Text_Ac.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ac"));
        Text_Ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ac");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Th = (EditText) findViewById(R.id.Rad_Th);
        Rad_Th.setTextSize(20);
        Rad_Th.addTextChangedListener(new TextWatcher() {
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
                Rad_Th.removeTextChangedListener(this);
                String text = Rad_Th.getText().toString();
                Rad_Th.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Th",Float.valueOf(text));
                }
                Rad_Th.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Th.setSelection(startChanged+countChanged);
                Rad_Th.addTextChangedListener(this);
            }
        });

        Col_Th = (Button) findViewById(R.id.Col_Th);
        Col_Th.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Th"));
        Col_Th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Th");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Th = (Button) findViewById(R.id.Text_Th);
        Text_Th.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Th"));
        Text_Th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Th");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Pa = (EditText) findViewById(R.id.Rad_Pa);
        Rad_Pa.setTextSize(20);
        Rad_Pa.addTextChangedListener(new TextWatcher() {
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
                Rad_Pa.removeTextChangedListener(this);
                String text = Rad_Pa.getText().toString();
                Rad_Pa.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Pa",Float.valueOf(text));
                }
                Rad_Pa.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Pa.setSelection(startChanged+countChanged);
                Rad_Pa.addTextChangedListener(this);
            }
        });

        Col_Pa = (Button) findViewById(R.id.Col_Pa);
        Col_Pa.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Pa"));
        Col_Pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Pa");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Pa = (Button) findViewById(R.id.Text_Pa);
        Text_Pa.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Pa"));
        Text_Pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Pa");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_U = (EditText) findViewById(R.id.Rad_U);
        Rad_U.setTextSize(20);
        Rad_U.addTextChangedListener(new TextWatcher() {
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
                Rad_U.removeTextChangedListener(this);
                String text = Rad_U.getText().toString();
                Rad_U.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_U",Float.valueOf(text));
                }
                Rad_U.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_U.setSelection(startChanged+countChanged);
                Rad_U.addTextChangedListener(this);
            }
        });

        Col_U = (Button) findViewById(R.id.Col_U);
        Col_U.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_U"));
        Col_U.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_U");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_U = (Button) findViewById(R.id.Text_U);
        Text_U.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_U"));
        Text_U.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_U");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Np = (EditText) findViewById(R.id.Rad_Np);
        Rad_Np.setTextSize(20);
        Rad_Np.addTextChangedListener(new TextWatcher() {
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
                Rad_Np.removeTextChangedListener(this);
                String text = Rad_Np.getText().toString();
                Rad_Np.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Np",Float.valueOf(text));
                }
                Rad_Np.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Np.setSelection(startChanged+countChanged);
                Rad_Np.addTextChangedListener(this);
            }
        });

        Col_Np = (Button) findViewById(R.id.Col_Np);
        Col_Np.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Np"));
        Col_Np.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Np");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Np = (Button) findViewById(R.id.Text_Np);
        Text_Np.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Np"));
        Text_Np.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Np");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Pu = (EditText) findViewById(R.id.Rad_Pu);
        Rad_Pu.setTextSize(20);
        Rad_Pu.addTextChangedListener(new TextWatcher() {
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
                Rad_Pu.removeTextChangedListener(this);
                String text = Rad_Pu.getText().toString();
                Rad_Pu.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Pu",Float.valueOf(text));
                }
                Rad_Pu.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Pu.setSelection(startChanged+countChanged);
                Rad_Pu.addTextChangedListener(this);
            }
        });

        Col_Pu = (Button) findViewById(R.id.Col_Pu);
        Col_Pu.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Pu"));
        Col_Pu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Pu");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Pu = (Button) findViewById(R.id.Text_Pu);
        Text_Pu.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Pu"));
        Text_Pu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Pu");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Am = (EditText) findViewById(R.id.Rad_Am);
        Rad_Am.setTextSize(20);
        Rad_Am.addTextChangedListener(new TextWatcher() {
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
                Rad_Am.removeTextChangedListener(this);
                String text = Rad_Am.getText().toString();
                Rad_Am.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Am",Float.valueOf(text));
                }
                Rad_Am.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Am.setSelection(startChanged+countChanged);
                Rad_Am.addTextChangedListener(this);
            }
        });

        Col_Am = (Button) findViewById(R.id.Col_Am);
        Col_Am.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Am"));
        Col_Am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Am");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Am = (Button) findViewById(R.id.Text_Am);
        Text_Am.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Am"));
        Text_Am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Am");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Cm = (EditText) findViewById(R.id.Rad_Cm);
        Rad_Cm.setTextSize(20);
        Rad_Cm.addTextChangedListener(new TextWatcher() {
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
                Rad_Cm.removeTextChangedListener(this);
                String text = Rad_Cm.getText().toString();
                Rad_Cm.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Cm",Float.valueOf(text));
                }
                Rad_Cm.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Cm.setSelection(startChanged+countChanged);
                Rad_Cm.addTextChangedListener(this);
            }
        });

        Col_Cm = (Button) findViewById(R.id.Col_Cm);
        Col_Cm.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Cm"));
        Col_Cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Cm");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Cm = (Button) findViewById(R.id.Text_Cm);
        Text_Cm.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Cm"));
        Text_Cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Cm");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Bk = (EditText) findViewById(R.id.Rad_Bk);
        Rad_Bk.setTextSize(20);
        Rad_Bk.addTextChangedListener(new TextWatcher() {
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
                Rad_Bk.removeTextChangedListener(this);
                String text = Rad_Bk.getText().toString();
                Rad_Bk.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Bk",Float.valueOf(text));
                }
                Rad_Bk.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Bk.setSelection(startChanged+countChanged);
                Rad_Bk.addTextChangedListener(this);
            }
        });

        Col_Bk = (Button) findViewById(R.id.Col_Bk);
        Col_Bk.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Bk"));
        Col_Bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Bk");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Bk = (Button) findViewById(R.id.Text_Bk);
        Text_Bk.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Bk"));
        Text_Bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Bk");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Cf = (EditText) findViewById(R.id.Rad_Cf);
        Rad_Cf.setTextSize(20);
        Rad_Cf.addTextChangedListener(new TextWatcher() {
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
                Rad_Cf.removeTextChangedListener(this);
                String text = Rad_Cf.getText().toString();
                Rad_Cf.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Cf",Float.valueOf(text));
                }
                Rad_Cf.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Cf.setSelection(startChanged+countChanged);
                Rad_Cf.addTextChangedListener(this);
            }
        });

        Col_Cf = (Button) findViewById(R.id.Col_Cf);
        Col_Cf.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Cf"));
        Col_Cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Cf");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Cf = (Button) findViewById(R.id.Text_Cf);
        Text_Cf.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Cf"));
        Text_Cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Cf");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Es = (EditText) findViewById(R.id.Rad_Es);
        Rad_Es.setTextSize(20);
        Rad_Es.addTextChangedListener(new TextWatcher() {
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
                Rad_Es.removeTextChangedListener(this);
                String text = Rad_Es.getText().toString();
                Rad_Es.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Es",Float.valueOf(text));
                }
                Rad_Es.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Es.setSelection(startChanged+countChanged);
                Rad_Es.addTextChangedListener(this);
            }
        });

        Col_Es = (Button) findViewById(R.id.Col_Es);
        Col_Es.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Es"));
        Col_Es.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Es");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Es = (Button) findViewById(R.id.Text_Es);
        Text_Es.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Es"));
        Text_Es.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Es");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Fm = (EditText) findViewById(R.id.Rad_Fm);
        Rad_Fm.setTextSize(20);
        Rad_Fm.addTextChangedListener(new TextWatcher() {
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
                Rad_Fm.removeTextChangedListener(this);
                String text = Rad_Fm.getText().toString();
                Rad_Fm.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Fm",Float.valueOf(text));
                }
                Rad_Fm.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Fm.setSelection(startChanged+countChanged);
                Rad_Fm.addTextChangedListener(this);
            }
        });

        Col_Fm = (Button) findViewById(R.id.Col_Fm);
        Col_Fm.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Fm"));
        Col_Fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Fm");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Fm = (Button) findViewById(R.id.Text_Fm);
        Text_Fm.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Fm"));
        Text_Fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Fm");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Md = (EditText) findViewById(R.id.Rad_Md);
        Rad_Md.setTextSize(20);
        Rad_Md.addTextChangedListener(new TextWatcher() {
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
                Rad_Md.removeTextChangedListener(this);
                String text = Rad_Md.getText().toString();
                Rad_Md.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Md",Float.valueOf(text));
                }
                Rad_Md.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Md.setSelection(startChanged+countChanged);
                Rad_Md.addTextChangedListener(this);
            }
        });

        Col_Md = (Button) findViewById(R.id.Col_Md);
        Col_Md.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Md"));
        Col_Md.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Md");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Md = (Button) findViewById(R.id.Text_Md);
        Text_Md.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Md"));
        Text_Md.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Md");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_No = (EditText) findViewById(R.id.Rad_No);
        Rad_No.setTextSize(20);
        Rad_No.addTextChangedListener(new TextWatcher() {
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
                Rad_No.removeTextChangedListener(this);
                String text = Rad_No.getText().toString();
                Rad_No.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_No",Float.valueOf(text));
                }
                Rad_No.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_No.setSelection(startChanged+countChanged);
                Rad_No.addTextChangedListener(this);
            }
        });

        Col_No = (Button) findViewById(R.id.Col_No);
        Col_No.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_No"));
        Col_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_No");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_No = (Button) findViewById(R.id.Text_No);
        Text_No.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_No"));
        Text_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_No");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Lr = (EditText) findViewById(R.id.Rad_Lr);
        Rad_Lr.setTextSize(20);
        Rad_Lr.addTextChangedListener(new TextWatcher() {
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
                Rad_Lr.removeTextChangedListener(this);
                String text = Rad_Lr.getText().toString();
                Rad_Lr.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Lr",Float.valueOf(text));
                }
                Rad_Lr.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Lr.setSelection(startChanged+countChanged);
                Rad_Lr.addTextChangedListener(this);
            }
        });

        Col_Lr = (Button) findViewById(R.id.Col_Lr);
        Col_Lr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Lr"));
        Col_Lr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Lr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Lr = (Button) findViewById(R.id.Text_Lr);
        Text_Lr.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Lr"));
        Text_Lr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Lr");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Rf = (EditText) findViewById(R.id.Rad_Rf);
        Rad_Rf.setTextSize(20);
        Rad_Rf.addTextChangedListener(new TextWatcher() {
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
                Rad_Rf.removeTextChangedListener(this);
                String text = Rad_Rf.getText().toString();
                Rad_Rf.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Rf",Float.valueOf(text));
                }
                Rad_Rf.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Rf.setSelection(startChanged+countChanged);
                Rad_Rf.addTextChangedListener(this);
            }
        });

        Col_Rf = (Button) findViewById(R.id.Col_Rf);
        Col_Rf.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Rf"));
        Col_Rf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Rf");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Rf = (Button) findViewById(R.id.Text_Rf);
        Text_Rf.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Rf"));
        Text_Rf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Rf");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Db = (EditText) findViewById(R.id.Rad_Db);
        Rad_Db.setTextSize(20);
        Rad_Db.addTextChangedListener(new TextWatcher() {
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
                Rad_Db.removeTextChangedListener(this);
                String text = Rad_Db.getText().toString();
                Rad_Db.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Db",Float.valueOf(text));
                }
                Rad_Db.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Db.setSelection(startChanged+countChanged);
                Rad_Db.addTextChangedListener(this);
            }
        });

        Col_Db = (Button) findViewById(R.id.Col_Db);
        Col_Db.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Db"));
        Col_Db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Db");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Db = (Button) findViewById(R.id.Text_Db);
        Text_Db.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Db"));
        Text_Db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Db");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Sg = (EditText) findViewById(R.id.Rad_Sg);
        Rad_Sg.setTextSize(20);
        Rad_Sg.addTextChangedListener(new TextWatcher() {
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
                Rad_Sg.removeTextChangedListener(this);
                String text = Rad_Sg.getText().toString();
                Rad_Sg.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Sg",Float.valueOf(text));
                }
                Rad_Sg.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Sg.setSelection(startChanged+countChanged);
                Rad_Sg.addTextChangedListener(this);
            }
        });

        Col_Sg = (Button) findViewById(R.id.Col_Sg);
        Col_Sg.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Sg"));
        Col_Sg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Sg");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Sg = (Button) findViewById(R.id.Text_Sg);
        Text_Sg.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Sg"));
        Text_Sg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Sg");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Bh = (EditText) findViewById(R.id.Rad_Bh);
        Rad_Bh.setTextSize(20);
        Rad_Bh.addTextChangedListener(new TextWatcher() {
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
                Rad_Bh.removeTextChangedListener(this);
                String text = Rad_Bh.getText().toString();
                Rad_Bh.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Bh",Float.valueOf(text));
                }
                Rad_Bh.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Bh.setSelection(startChanged+countChanged);
                Rad_Bh.addTextChangedListener(this);
            }
        });

        Col_Bh = (Button) findViewById(R.id.Col_Bh);
        Col_Bh.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Bh"));
        Col_Bh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Bh");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Bh = (Button) findViewById(R.id.Text_Bh);
        Text_Bh.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Bh"));
        Text_Bh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Bh");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Hs = (EditText) findViewById(R.id.Rad_Hs);
        Rad_Hs.setTextSize(20);
        Rad_Hs.addTextChangedListener(new TextWatcher() {
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
                Rad_Hs.removeTextChangedListener(this);
                String text = Rad_Hs.getText().toString();
                Rad_Hs.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Hs",Float.valueOf(text));
                }
                Rad_Hs.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Hs.setSelection(startChanged+countChanged);
                Rad_Hs.addTextChangedListener(this);
            }
        });

        Col_Hs = (Button) findViewById(R.id.Col_Hs);
        Col_Hs.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Hs"));
        Col_Hs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Hs");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Hs = (Button) findViewById(R.id.Text_Hs);
        Text_Hs.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Hs"));
        Text_Hs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Hs");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Mt = (EditText) findViewById(R.id.Rad_Mt);
        Rad_Mt.setTextSize(20);
        Rad_Mt.addTextChangedListener(new TextWatcher() {
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
                Rad_Mt.removeTextChangedListener(this);
                String text = Rad_Mt.getText().toString();
                Rad_Mt.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Mt",Float.valueOf(text));
                }
                Rad_Mt.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Mt.setSelection(startChanged+countChanged);
                Rad_Mt.addTextChangedListener(this);
            }
        });

        Col_Mt = (Button) findViewById(R.id.Col_Mt);
        Col_Mt.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Mt"));
        Col_Mt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Mt");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Mt = (Button) findViewById(R.id.Text_Mt);
        Text_Mt.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Mt"));
        Text_Mt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Mt");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ds = (EditText) findViewById(R.id.Rad_Ds);
        Rad_Ds.setTextSize(20);
        Rad_Ds.addTextChangedListener(new TextWatcher() {
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
                Rad_Ds.removeTextChangedListener(this);
                String text = Rad_Ds.getText().toString();
                Rad_Ds.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ds",Float.valueOf(text));
                }
                Rad_Ds.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ds.setSelection(startChanged+countChanged);
                Rad_Ds.addTextChangedListener(this);
            }
        });

        Col_Ds = (Button) findViewById(R.id.Col_Ds);
        Col_Ds.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ds"));
        Col_Ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ds");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ds = (Button) findViewById(R.id.Text_Ds);
        Text_Ds.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ds"));
        Text_Ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ds");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Rg = (EditText) findViewById(R.id.Rad_Rg);
        Rad_Rg.setTextSize(20);
        Rad_Rg.addTextChangedListener(new TextWatcher() {
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
                Rad_Rg.removeTextChangedListener(this);
                String text = Rad_Rg.getText().toString();
                Rad_Rg.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Rg",Float.valueOf(text));
                }
                Rad_Rg.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Rg.setSelection(startChanged+countChanged);
                Rad_Rg.addTextChangedListener(this);
            }
        });

        Col_Rg = (Button) findViewById(R.id.Col_Rg);
        Col_Rg.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Rg"));
        Col_Rg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Rg");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Rg = (Button) findViewById(R.id.Text_Rg);
        Text_Rg.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Rg"));
        Text_Rg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Rg");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Cn = (EditText) findViewById(R.id.Rad_Cn);
        Rad_Cn.setTextSize(20);
        Rad_Cn.addTextChangedListener(new TextWatcher() {
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
                Rad_Cn.removeTextChangedListener(this);
                String text = Rad_Cn.getText().toString();
                Rad_Cn.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Cn",Float.valueOf(text));
                }
                Rad_Cn.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Cn.setSelection(startChanged+countChanged);
                Rad_Cn.addTextChangedListener(this);
            }
        });

        Col_Cn = (Button) findViewById(R.id.Col_Cn);
        Col_Cn.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Cn"));
        Col_Cn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Cn");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Cn = (Button) findViewById(R.id.Text_Cn);
        Text_Cn.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Cn"));
        Text_Cn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Cn");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Nh = (EditText) findViewById(R.id.Rad_Nh);
        Rad_Nh.setTextSize(20);
        Rad_Nh.addTextChangedListener(new TextWatcher() {
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
                Rad_Nh.removeTextChangedListener(this);
                String text = Rad_Nh.getText().toString();
                Rad_Nh.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Nh",Float.valueOf(text));
                }
                Rad_Nh.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Nh.setSelection(startChanged+countChanged);
                Rad_Nh.addTextChangedListener(this);
            }
        });

        Col_Nh = (Button) findViewById(R.id.Col_Nh);
        Col_Nh.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Nh"));
        Col_Nh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Nh");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Nh = (Button) findViewById(R.id.Text_Nh);
        Text_Nh.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Nh"));
        Text_Nh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Nh");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Fl = (EditText) findViewById(R.id.Rad_Fl);
        Rad_Fl.setTextSize(20);
        Rad_Fl.addTextChangedListener(new TextWatcher() {
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
                Rad_Fl.removeTextChangedListener(this);
                String text = Rad_Fl.getText().toString();
                Rad_Fl.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Fl",Float.valueOf(text));
                }
                Rad_Fl.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Fl.setSelection(startChanged+countChanged);
                Rad_Fl.addTextChangedListener(this);
            }
        });

        Col_Fl = (Button) findViewById(R.id.Col_Fl);
        Col_Fl.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Fl"));
        Col_Fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Fl");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Fl = (Button) findViewById(R.id.Text_Fl);
        Text_Fl.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Fl"));
        Text_Fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Fl");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Mc = (EditText) findViewById(R.id.Rad_Mc);
        Rad_Mc.setTextSize(20);
        Rad_Mc.addTextChangedListener(new TextWatcher() {
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
                Rad_Mc.removeTextChangedListener(this);
                String text = Rad_Mc.getText().toString();
                Rad_Mc.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Mc",Float.valueOf(text));
                }
                Rad_Mc.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Mc.setSelection(startChanged+countChanged);
                Rad_Mc.addTextChangedListener(this);
            }
        });

        Col_Mc = (Button) findViewById(R.id.Col_Mc);
        Col_Mc.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Mc"));
        Col_Mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Mc");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Mc = (Button) findViewById(R.id.Text_Mc);
        Text_Mc.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Mc"));
        Text_Mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Mc");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Lv = (EditText) findViewById(R.id.Rad_Lv);
        Rad_Lv.setTextSize(20);
        Rad_Lv.addTextChangedListener(new TextWatcher() {
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
                Rad_Lv.removeTextChangedListener(this);
                String text = Rad_Lv.getText().toString();
                Rad_Lv.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Lv",Float.valueOf(text));
                }
                Rad_Lv.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Lv.setSelection(startChanged+countChanged);
                Rad_Lv.addTextChangedListener(this);
            }
        });

        Col_Lv = (Button) findViewById(R.id.Col_Lv);
        Col_Lv.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Lv"));
        Col_Lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Lv");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Lv = (Button) findViewById(R.id.Text_Lv);
        Text_Lv.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Lv"));
        Text_Lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Lv");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Ts = (EditText) findViewById(R.id.Rad_Ts);
        Rad_Ts.setTextSize(20);
        Rad_Ts.addTextChangedListener(new TextWatcher() {
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
                Rad_Ts.removeTextChangedListener(this);
                String text = Rad_Ts.getText().toString();
                Rad_Ts.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Ts",Float.valueOf(text));
                }
                Rad_Ts.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Ts.setSelection(startChanged+countChanged);
                Rad_Ts.addTextChangedListener(this);
            }
        });

        Col_Ts = (Button) findViewById(R.id.Col_Ts);
        Col_Ts.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Ts"));
        Col_Ts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Ts");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Ts = (Button) findViewById(R.id.Text_Ts);
        Text_Ts.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Ts"));
        Text_Ts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Ts");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Rad_Og = (EditText) findViewById(R.id.Rad_Og);
        Rad_Og.setTextSize(20);
        Rad_Og.addTextChangedListener(new TextWatcher() {
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
                Rad_Og.removeTextChangedListener(this);
                String text = Rad_Og.getText().toString();
                Rad_Og.getText().clear();
                int countDots = MolCanvas_methods.getCharOcc(text,'.');
                int countDashes = MolCanvas_methods.getCharOcc(text,'-');
                if (text.length() > 0 && text.length() > countDots+countDashes){
                    MolCanvas_preferences.get().setValue("r_Og",Float.valueOf(text));
                }
                Rad_Og.append(Spannables.colorized_numbers(text));
                // place the cursor at the original position
                Rad_Og.setSelection(startChanged+countChanged);
                Rad_Og.addTextChangedListener(this);
            }
        });

        Col_Og = (Button) findViewById(R.id.Col_Og);
        Col_Og.setBackgroundColor(MolCanvas_preferences.get().getIntValue("color_Og"));
        Col_Og.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","color_Og");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });

        Text_Og = (Button) findViewById(R.id.Text_Og);
        Text_Og.setBackgroundColor(MolCanvas_preferences.get().getIntValue("text_color_Og"));
        Text_Og.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MolCanvas_preferences.get().setStringValue("changed_variable","text_color_Og");
                Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        display_zoom(String.valueOf(MolCanvas_preferences.get().getValue("zoom")));
        display_conv(String.valueOf(MolCanvas_preferences.get().getValue("conv")));
        display_zoom_scale(String.valueOf(MolCanvas_preferences.get().getValue("zoom_scale")));
        display_persp_scale(String.valueOf(MolCanvas_preferences.get().getValue("persp_scale")));
        display_radius_scale(String.valueOf(MolCanvas_preferences.get().getValue("radius_scale")));
        display_angle_scale(String.valueOf(MolCanvas_preferences.get().getValue("angle_scale")));
        display_z_angle_scale(String.valueOf(MolCanvas_preferences.get().getValue("z_angle_scale")));
        display_transl_scale(String.valueOf(MolCanvas_preferences.get().getValue("transl_scale")));
        display_z_transl_scale(String.valueOf(MolCanvas_preferences.get().getValue("z_transl_scale")));
        display_bond_scale(String.valueOf(MolCanvas_preferences.get().getValue("bond_scale")));
        display_hydr_bond_scale(String.valueOf(MolCanvas_preferences.get().getValue("hydr_bond_scale")));
        display_minDistCrit_pix(String.valueOf(MolCanvas_preferences.get().getValue("minDistCrit_pix")));
        display_text_size(String.valueOf(MolCanvas_preferences.get().getValue("text_size")));
        display_text_shift_z_Ang(String.valueOf(MolCanvas_preferences.get().getValue("text_shift_z_Ang")));
        display_text_shift_x_pix(String.valueOf(MolCanvas_preferences.get().getValue("text_shift_x_pix")));
        display_text_shift_y_pix(String.valueOf(MolCanvas_preferences.get().getValue("text_shift_y_pix")));
        display_bondsStrokeWidth(String.valueOf(MolCanvas_preferences.get().getValue("bondsStrokeWidth")));
        display_bordersStrokeWidth(String.valueOf(MolCanvas_preferences.get().getValue("bordersStrokeWidth")));
        display_H(String.valueOf(MolCanvas_preferences.get().getValue("r_H")));
        display_He(String.valueOf(MolCanvas_preferences.get().getValue("r_He")));
        display_Li(String.valueOf(MolCanvas_preferences.get().getValue("r_Li")));
        display_Be(String.valueOf(MolCanvas_preferences.get().getValue("r_Be")));
        display_B(String.valueOf(MolCanvas_preferences.get().getValue("r_B")));
        display_C(String.valueOf(MolCanvas_preferences.get().getValue("r_C")));
        display_N(String.valueOf(MolCanvas_preferences.get().getValue("r_N")));
        display_O(String.valueOf(MolCanvas_preferences.get().getValue("r_O")));
        display_F(String.valueOf(MolCanvas_preferences.get().getValue("r_F")));
        display_Ne(String.valueOf(MolCanvas_preferences.get().getValue("r_Ne")));
        display_Na(String.valueOf(MolCanvas_preferences.get().getValue("r_Na")));
        display_Mg(String.valueOf(MolCanvas_preferences.get().getValue("r_Mg")));
        display_Al(String.valueOf(MolCanvas_preferences.get().getValue("r_Al")));
        display_Si(String.valueOf(MolCanvas_preferences.get().getValue("r_Si")));
        display_P(String.valueOf(MolCanvas_preferences.get().getValue("r_P")));
        display_S(String.valueOf(MolCanvas_preferences.get().getValue("r_S")));
        display_Cl(String.valueOf(MolCanvas_preferences.get().getValue("r_Cl")));
        display_Ar(String.valueOf(MolCanvas_preferences.get().getValue("r_Ar")));
        display_K(String.valueOf(MolCanvas_preferences.get().getValue("r_K")));
        display_Ca(String.valueOf(MolCanvas_preferences.get().getValue("r_Ca")));
        display_Sc(String.valueOf(MolCanvas_preferences.get().getValue("r_Sc")));
        display_Ti(String.valueOf(MolCanvas_preferences.get().getValue("r_Ti")));
        display_V(String.valueOf(MolCanvas_preferences.get().getValue("r_V")));
        display_Cr(String.valueOf(MolCanvas_preferences.get().getValue("r_Cr")));
        display_Mn(String.valueOf(MolCanvas_preferences.get().getValue("r_Mn")));
        display_Fe(String.valueOf(MolCanvas_preferences.get().getValue("r_Fe")));
        display_Co(String.valueOf(MolCanvas_preferences.get().getValue("r_Co")));
        display_Ni(String.valueOf(MolCanvas_preferences.get().getValue("r_Ni")));
        display_Cu(String.valueOf(MolCanvas_preferences.get().getValue("r_Cu")));
        display_Zn(String.valueOf(MolCanvas_preferences.get().getValue("r_Zn")));
        display_Ga(String.valueOf(MolCanvas_preferences.get().getValue("r_Ga")));
        display_Ge(String.valueOf(MolCanvas_preferences.get().getValue("r_Ge")));
        display_As(String.valueOf(MolCanvas_preferences.get().getValue("r_As")));
        display_Se(String.valueOf(MolCanvas_preferences.get().getValue("r_Se")));
        display_Br(String.valueOf(MolCanvas_preferences.get().getValue("r_Br")));
        display_Kr(String.valueOf(MolCanvas_preferences.get().getValue("r_Kr")));
        display_Rb(String.valueOf(MolCanvas_preferences.get().getValue("r_Rb")));
        display_Sr(String.valueOf(MolCanvas_preferences.get().getValue("r_Sr")));
        display_Y(String.valueOf(MolCanvas_preferences.get().getValue("r_Y")));
        display_Zr(String.valueOf(MolCanvas_preferences.get().getValue("r_Zr")));
        display_Nb(String.valueOf(MolCanvas_preferences.get().getValue("r_Nb")));
        display_Mo(String.valueOf(MolCanvas_preferences.get().getValue("r_Mo")));
        display_Tc(String.valueOf(MolCanvas_preferences.get().getValue("r_Tc")));
        display_Ru(String.valueOf(MolCanvas_preferences.get().getValue("r_Ru")));
        display_Rh(String.valueOf(MolCanvas_preferences.get().getValue("r_Rh")));
        display_Pd(String.valueOf(MolCanvas_preferences.get().getValue("r_Pd")));
        display_Ag(String.valueOf(MolCanvas_preferences.get().getValue("r_Ag")));
        display_Cd(String.valueOf(MolCanvas_preferences.get().getValue("r_Cd")));
        display_In(String.valueOf(MolCanvas_preferences.get().getValue("r_In")));
        display_Sn(String.valueOf(MolCanvas_preferences.get().getValue("r_Sn")));
        display_Sb(String.valueOf(MolCanvas_preferences.get().getValue("r_Sb")));
        display_Te(String.valueOf(MolCanvas_preferences.get().getValue("r_Te")));
        display_I(String.valueOf(MolCanvas_preferences.get().getValue("r_I")));
        display_Xe(String.valueOf(MolCanvas_preferences.get().getValue("r_Xe")));
        display_Cs(String.valueOf(MolCanvas_preferences.get().getValue("r_Cs")));
        display_Ba(String.valueOf(MolCanvas_preferences.get().getValue("r_Ba")));
        display_La(String.valueOf(MolCanvas_preferences.get().getValue("r_La")));
        display_Ce(String.valueOf(MolCanvas_preferences.get().getValue("r_Ce")));
        display_Pr(String.valueOf(MolCanvas_preferences.get().getValue("r_Pr")));
        display_Nd(String.valueOf(MolCanvas_preferences.get().getValue("r_Nd")));
        display_Pm(String.valueOf(MolCanvas_preferences.get().getValue("r_Pm")));
        display_Sm(String.valueOf(MolCanvas_preferences.get().getValue("r_Sm")));
        display_Eu(String.valueOf(MolCanvas_preferences.get().getValue("r_Eu")));
        display_Gd(String.valueOf(MolCanvas_preferences.get().getValue("r_Gd")));
        display_Tb(String.valueOf(MolCanvas_preferences.get().getValue("r_Tb")));
        display_Dy(String.valueOf(MolCanvas_preferences.get().getValue("r_Dy")));
        display_Ho(String.valueOf(MolCanvas_preferences.get().getValue("r_Ho")));
        display_Er(String.valueOf(MolCanvas_preferences.get().getValue("r_Er")));
        display_Tm(String.valueOf(MolCanvas_preferences.get().getValue("r_Tm")));
        display_Yb(String.valueOf(MolCanvas_preferences.get().getValue("r_Yb")));
        display_Lu(String.valueOf(MolCanvas_preferences.get().getValue("r_Lu")));
        display_Hf(String.valueOf(MolCanvas_preferences.get().getValue("r_Hf")));
        display_Ta(String.valueOf(MolCanvas_preferences.get().getValue("r_Ta")));
        display_W(String.valueOf(MolCanvas_preferences.get().getValue("r_W")));
        display_Re(String.valueOf(MolCanvas_preferences.get().getValue("r_Re")));
        display_Os(String.valueOf(MolCanvas_preferences.get().getValue("r_Os")));
        display_Ir(String.valueOf(MolCanvas_preferences.get().getValue("r_Ir")));
        display_Pt(String.valueOf(MolCanvas_preferences.get().getValue("r_Pt")));
        display_Au(String.valueOf(MolCanvas_preferences.get().getValue("r_Au")));
        display_Hg(String.valueOf(MolCanvas_preferences.get().getValue("r_Hg")));
        display_Tl(String.valueOf(MolCanvas_preferences.get().getValue("r_Tl")));
        display_Pb(String.valueOf(MolCanvas_preferences.get().getValue("r_Pb")));
        display_Bi(String.valueOf(MolCanvas_preferences.get().getValue("r_Bi")));
        display_Po(String.valueOf(MolCanvas_preferences.get().getValue("r_Po")));
        display_At(String.valueOf(MolCanvas_preferences.get().getValue("r_At")));
        display_Rn(String.valueOf(MolCanvas_preferences.get().getValue("r_Rn")));
        display_Fr(String.valueOf(MolCanvas_preferences.get().getValue("r_Fr")));
        display_Ra(String.valueOf(MolCanvas_preferences.get().getValue("r_Ra")));
        display_Ac(String.valueOf(MolCanvas_preferences.get().getValue("r_Ac")));
        display_Th(String.valueOf(MolCanvas_preferences.get().getValue("r_Th")));
        display_Pa(String.valueOf(MolCanvas_preferences.get().getValue("r_Pa")));
        display_U(String.valueOf(MolCanvas_preferences.get().getValue("r_U")));
        display_Np(String.valueOf(MolCanvas_preferences.get().getValue("r_Np")));
        display_Pu(String.valueOf(MolCanvas_preferences.get().getValue("r_Pu")));
        display_Am(String.valueOf(MolCanvas_preferences.get().getValue("r_Am")));
        display_Cm(String.valueOf(MolCanvas_preferences.get().getValue("r_Cm")));
        display_Bk(String.valueOf(MolCanvas_preferences.get().getValue("r_Bk")));
        display_Cf(String.valueOf(MolCanvas_preferences.get().getValue("r_Cf")));
        display_Es(String.valueOf(MolCanvas_preferences.get().getValue("r_Es")));
        display_Fm(String.valueOf(MolCanvas_preferences.get().getValue("r_Fm")));
        display_Md(String.valueOf(MolCanvas_preferences.get().getValue("r_Md")));
        display_No(String.valueOf(MolCanvas_preferences.get().getValue("r_No")));
        display_Lr(String.valueOf(MolCanvas_preferences.get().getValue("r_Lr")));
        display_Rf(String.valueOf(MolCanvas_preferences.get().getValue("r_Rf")));
        display_Db(String.valueOf(MolCanvas_preferences.get().getValue("r_Db")));
        display_Sg(String.valueOf(MolCanvas_preferences.get().getValue("r_Sg")));
        display_Bh(String.valueOf(MolCanvas_preferences.get().getValue("r_Bh")));
        display_Hs(String.valueOf(MolCanvas_preferences.get().getValue("r_Hs")));
        display_Mt(String.valueOf(MolCanvas_preferences.get().getValue("r_Mt")));
        display_Ds(String.valueOf(MolCanvas_preferences.get().getValue("r_Ds")));
        display_Rg(String.valueOf(MolCanvas_preferences.get().getValue("r_Rg")));
        display_Cn(String.valueOf(MolCanvas_preferences.get().getValue("r_Cn")));
        display_Nh(String.valueOf(MolCanvas_preferences.get().getValue("r_Nh")));
        display_Fl(String.valueOf(MolCanvas_preferences.get().getValue("r_Fl")));
        display_Mc(String.valueOf(MolCanvas_preferences.get().getValue("r_Mc")));
        display_Lv(String.valueOf(MolCanvas_preferences.get().getValue("r_Lv")));
        display_Ts(String.valueOf(MolCanvas_preferences.get().getValue("r_Ts")));
        display_Og(String.valueOf(MolCanvas_preferences.get().getValue("r_Og")));
    }
    @Override
    public void onResume() {
        super.onResume();
        display_zoom(String.valueOf(MolCanvas_preferences.get().getValue("zoom")));
        display_conv(String.valueOf(MolCanvas_preferences.get().getValue("conv")));
        display_zoom_scale(String.valueOf(MolCanvas_preferences.get().getValue("zoom_scale")));
        display_persp_scale(String.valueOf(MolCanvas_preferences.get().getValue("persp_scale")));
        display_radius_scale(String.valueOf(MolCanvas_preferences.get().getValue("radius_scale")));
        display_angle_scale(String.valueOf(MolCanvas_preferences.get().getValue("angle_scale")));
        display_z_angle_scale(String.valueOf(MolCanvas_preferences.get().getValue("z_angle_scale")));
        display_transl_scale(String.valueOf(MolCanvas_preferences.get().getValue("transl_scale")));
        display_bond_scale(String.valueOf(MolCanvas_preferences.get().getValue("bond_scale")));
        display_hydr_bond_scale(String.valueOf(MolCanvas_preferences.get().getValue("hydr_bond_scale")));
        display_minDistCrit_pix(String.valueOf(MolCanvas_preferences.get().getValue("minDistCrit_pix")));
        display_text_size(String.valueOf(MolCanvas_preferences.get().getValue("text_size")));
        display_text_shift_z_Ang(String.valueOf(MolCanvas_preferences.get().getValue("text_shift_z_Ang")));
        display_text_shift_x_pix(String.valueOf(MolCanvas_preferences.get().getValue("text_shift_x_pix")));
        display_text_shift_y_pix(String.valueOf(MolCanvas_preferences.get().getValue("text_shift_y_pix")));
        display_bondsStrokeWidth(String.valueOf(MolCanvas_preferences.get().getValue("bondsStrokeWidth")));
        display_bordersStrokeWidth(String.valueOf(MolCanvas_preferences.get().getValue("bordersStrokeWidth")));
        display_zmatLines(String.valueOf(MolCanvas_preferences.get().getIntValue("zmat_max_lines")));
        display_H(String.valueOf(MolCanvas_preferences.get().getValue("r_H")));
        display_He(String.valueOf(MolCanvas_preferences.get().getValue("r_He")));
        display_Li(String.valueOf(MolCanvas_preferences.get().getValue("r_Li")));
        display_Be(String.valueOf(MolCanvas_preferences.get().getValue("r_Be")));
        display_B(String.valueOf(MolCanvas_preferences.get().getValue("r_B")));
        display_C(String.valueOf(MolCanvas_preferences.get().getValue("r_C")));
        display_N(String.valueOf(MolCanvas_preferences.get().getValue("r_N")));
        display_O(String.valueOf(MolCanvas_preferences.get().getValue("r_O")));
        display_F(String.valueOf(MolCanvas_preferences.get().getValue("r_F")));
        display_Ne(String.valueOf(MolCanvas_preferences.get().getValue("r_Ne")));
        display_Na(String.valueOf(MolCanvas_preferences.get().getValue("r_Na")));
        display_Mg(String.valueOf(MolCanvas_preferences.get().getValue("r_Mg")));
        display_Al(String.valueOf(MolCanvas_preferences.get().getValue("r_Al")));
        display_Si(String.valueOf(MolCanvas_preferences.get().getValue("r_Si")));
        display_P(String.valueOf(MolCanvas_preferences.get().getValue("r_P")));
        display_S(String.valueOf(MolCanvas_preferences.get().getValue("r_S")));
        display_Cl(String.valueOf(MolCanvas_preferences.get().getValue("r_Cl")));
        display_Ar(String.valueOf(MolCanvas_preferences.get().getValue("r_Ar")));
        display_K(String.valueOf(MolCanvas_preferences.get().getValue("r_K")));
        display_Ca(String.valueOf(MolCanvas_preferences.get().getValue("r_Ca")));
        display_Sc(String.valueOf(MolCanvas_preferences.get().getValue("r_Sc")));
        display_Ti(String.valueOf(MolCanvas_preferences.get().getValue("r_Ti")));
        display_V(String.valueOf(MolCanvas_preferences.get().getValue("r_V")));
        display_Cr(String.valueOf(MolCanvas_preferences.get().getValue("r_Cr")));
        display_Mn(String.valueOf(MolCanvas_preferences.get().getValue("r_Mn")));
        display_Fe(String.valueOf(MolCanvas_preferences.get().getValue("r_Fe")));
        display_Co(String.valueOf(MolCanvas_preferences.get().getValue("r_Co")));
        display_Ni(String.valueOf(MolCanvas_preferences.get().getValue("r_Ni")));
        display_Cu(String.valueOf(MolCanvas_preferences.get().getValue("r_Cu")));
        display_Zn(String.valueOf(MolCanvas_preferences.get().getValue("r_Zn")));
        display_Ga(String.valueOf(MolCanvas_preferences.get().getValue("r_Ga")));
        display_Ge(String.valueOf(MolCanvas_preferences.get().getValue("r_Ge")));
        display_As(String.valueOf(MolCanvas_preferences.get().getValue("r_As")));
        display_Se(String.valueOf(MolCanvas_preferences.get().getValue("r_Se")));
        display_Br(String.valueOf(MolCanvas_preferences.get().getValue("r_Br")));
        display_Kr(String.valueOf(MolCanvas_preferences.get().getValue("r_Kr")));
        display_Rb(String.valueOf(MolCanvas_preferences.get().getValue("r_Rb")));
        display_Sr(String.valueOf(MolCanvas_preferences.get().getValue("r_Sr")));
        display_Y(String.valueOf(MolCanvas_preferences.get().getValue("r_Y")));
        display_Zr(String.valueOf(MolCanvas_preferences.get().getValue("r_Zr")));
        display_Nb(String.valueOf(MolCanvas_preferences.get().getValue("r_Nb")));
        display_Mo(String.valueOf(MolCanvas_preferences.get().getValue("r_Mo")));
        display_Tc(String.valueOf(MolCanvas_preferences.get().getValue("r_Tc")));
        display_Ru(String.valueOf(MolCanvas_preferences.get().getValue("r_Ru")));
        display_Rh(String.valueOf(MolCanvas_preferences.get().getValue("r_Rh")));
        display_Pd(String.valueOf(MolCanvas_preferences.get().getValue("r_Pd")));
        display_Ag(String.valueOf(MolCanvas_preferences.get().getValue("r_Ag")));
        display_Cd(String.valueOf(MolCanvas_preferences.get().getValue("r_Cd")));
        display_In(String.valueOf(MolCanvas_preferences.get().getValue("r_In")));
        display_Sn(String.valueOf(MolCanvas_preferences.get().getValue("r_Sn")));
        display_Sb(String.valueOf(MolCanvas_preferences.get().getValue("r_Sb")));
        display_Te(String.valueOf(MolCanvas_preferences.get().getValue("r_Te")));
        display_I(String.valueOf(MolCanvas_preferences.get().getValue("r_I")));
        display_Xe(String.valueOf(MolCanvas_preferences.get().getValue("r_Xe")));
        display_Cs(String.valueOf(MolCanvas_preferences.get().getValue("r_Cs")));
        display_Ba(String.valueOf(MolCanvas_preferences.get().getValue("r_Ba")));
        display_La(String.valueOf(MolCanvas_preferences.get().getValue("r_La")));
        display_Ce(String.valueOf(MolCanvas_preferences.get().getValue("r_Ce")));
        display_Pr(String.valueOf(MolCanvas_preferences.get().getValue("r_Pr")));
        display_Nd(String.valueOf(MolCanvas_preferences.get().getValue("r_Nd")));
        display_Pm(String.valueOf(MolCanvas_preferences.get().getValue("r_Pm")));
        display_Sm(String.valueOf(MolCanvas_preferences.get().getValue("r_Sm")));
        display_Eu(String.valueOf(MolCanvas_preferences.get().getValue("r_Eu")));
        display_Gd(String.valueOf(MolCanvas_preferences.get().getValue("r_Gd")));
        display_Tb(String.valueOf(MolCanvas_preferences.get().getValue("r_Tb")));
        display_Dy(String.valueOf(MolCanvas_preferences.get().getValue("r_Dy")));
        display_Ho(String.valueOf(MolCanvas_preferences.get().getValue("r_Ho")));
        display_Er(String.valueOf(MolCanvas_preferences.get().getValue("r_Er")));
        display_Tm(String.valueOf(MolCanvas_preferences.get().getValue("r_Tm")));
        display_Yb(String.valueOf(MolCanvas_preferences.get().getValue("r_Yb")));
        display_Lu(String.valueOf(MolCanvas_preferences.get().getValue("r_Lu")));
        display_Hf(String.valueOf(MolCanvas_preferences.get().getValue("r_Hf")));
        display_Ta(String.valueOf(MolCanvas_preferences.get().getValue("r_Ta")));
        display_W(String.valueOf(MolCanvas_preferences.get().getValue("r_W")));
        display_Re(String.valueOf(MolCanvas_preferences.get().getValue("r_Re")));
        display_Os(String.valueOf(MolCanvas_preferences.get().getValue("r_Os")));
        display_Ir(String.valueOf(MolCanvas_preferences.get().getValue("r_Ir")));
        display_Pt(String.valueOf(MolCanvas_preferences.get().getValue("r_Pt")));
        display_Au(String.valueOf(MolCanvas_preferences.get().getValue("r_Au")));
        display_Hg(String.valueOf(MolCanvas_preferences.get().getValue("r_Hg")));
        display_Tl(String.valueOf(MolCanvas_preferences.get().getValue("r_Tl")));
        display_Pb(String.valueOf(MolCanvas_preferences.get().getValue("r_Pb")));
        display_Bi(String.valueOf(MolCanvas_preferences.get().getValue("r_Bi")));
        display_Po(String.valueOf(MolCanvas_preferences.get().getValue("r_Po")));
        display_At(String.valueOf(MolCanvas_preferences.get().getValue("r_At")));
        display_Rn(String.valueOf(MolCanvas_preferences.get().getValue("r_Rn")));
        display_Fr(String.valueOf(MolCanvas_preferences.get().getValue("r_Fr")));
        display_Ra(String.valueOf(MolCanvas_preferences.get().getValue("r_Ra")));
        display_Ac(String.valueOf(MolCanvas_preferences.get().getValue("r_Ac")));
        display_Th(String.valueOf(MolCanvas_preferences.get().getValue("r_Th")));
        display_Pa(String.valueOf(MolCanvas_preferences.get().getValue("r_Pa")));
        display_U(String.valueOf(MolCanvas_preferences.get().getValue("r_U")));
        display_Np(String.valueOf(MolCanvas_preferences.get().getValue("r_Np")));
        display_Pu(String.valueOf(MolCanvas_preferences.get().getValue("r_Pu")));
        display_Am(String.valueOf(MolCanvas_preferences.get().getValue("r_Am")));
        display_Cm(String.valueOf(MolCanvas_preferences.get().getValue("r_Cm")));
        display_Bk(String.valueOf(MolCanvas_preferences.get().getValue("r_Bk")));
        display_Cf(String.valueOf(MolCanvas_preferences.get().getValue("r_Cf")));
        display_Es(String.valueOf(MolCanvas_preferences.get().getValue("r_Es")));
        display_Fm(String.valueOf(MolCanvas_preferences.get().getValue("r_Fm")));
        display_Md(String.valueOf(MolCanvas_preferences.get().getValue("r_Md")));
        display_No(String.valueOf(MolCanvas_preferences.get().getValue("r_No")));
        display_Lr(String.valueOf(MolCanvas_preferences.get().getValue("r_Lr")));
        display_Rf(String.valueOf(MolCanvas_preferences.get().getValue("r_Rf")));
        display_Db(String.valueOf(MolCanvas_preferences.get().getValue("r_Db")));
        display_Sg(String.valueOf(MolCanvas_preferences.get().getValue("r_Sg")));
        display_Bh(String.valueOf(MolCanvas_preferences.get().getValue("r_Bh")));
        display_Hs(String.valueOf(MolCanvas_preferences.get().getValue("r_Hs")));
        display_Mt(String.valueOf(MolCanvas_preferences.get().getValue("r_Mt")));
        display_Ds(String.valueOf(MolCanvas_preferences.get().getValue("r_Ds")));
        display_Rg(String.valueOf(MolCanvas_preferences.get().getValue("r_Rg")));
        display_Cn(String.valueOf(MolCanvas_preferences.get().getValue("r_Cn")));
        display_Nh(String.valueOf(MolCanvas_preferences.get().getValue("r_Nh")));
        display_Fl(String.valueOf(MolCanvas_preferences.get().getValue("r_Fl")));
        display_Mc(String.valueOf(MolCanvas_preferences.get().getValue("r_Mc")));
        display_Lv(String.valueOf(MolCanvas_preferences.get().getValue("r_Lv")));
        display_Ts(String.valueOf(MolCanvas_preferences.get().getValue("r_Ts")));
        display_Og(String.valueOf(MolCanvas_preferences.get().getValue("r_Og")));
    }

    //	private View.OnClickListener testButton;
    //	{
    //		testButton = new View.OnClickListener() {
    //			public void onClick(View v) {
    //				// TODO Auto-generated method stub //
    //				changed_variable = "color_H";
    //				Intent intent = new Intent(MolCanvas_multi_settings.this, MolCanvas_multi_colorPicker.class);
    //				startActivity(intent);
    //			}
    //		};
    //	}

    public void display_zoom(final String str_zoom) {
        Runnable proc_zoom = new Runnable() {
            public void run() {
                zoomEdit.setText(Spannables.colorized_numbers(str_zoom), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_zoom);
    }
    public void display_conv(final String str_conv) {
        Runnable proc_conv = new Runnable() {
            public void run() {
                convEdit.setText(Spannables.colorized_numbers(str_conv), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_conv);
    }
    public void display_zoom_scale(final String str_zoom_scale) {
        Runnable proc_zoom_scale = new Runnable() {
            public void run() {
                zoomScaleEdit.setText(Spannables.colorized_numbers(str_zoom_scale), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_zoom_scale);
    }
    public void display_persp_scale(final String str_persp_scale) {
        Runnable proc_persp_scale = new Runnable() {
            public void run() {
                perspScaleEdit.setText(Spannables.colorized_numbers(str_persp_scale), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_persp_scale);
    }
    public void display_radius_scale(final String str_radius_scale) {
        Runnable proc_radius_scale = new Runnable() {
            public void run() {
                radiusScaleEdit.setText(Spannables.colorized_numbers(str_radius_scale), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_radius_scale);
    }
    public void display_angle_scale(final String str_angle_scale) {
        Runnable proc_angle_scale = new Runnable() {
            public void run() {
                angleScaleEdit.setText(Spannables.colorized_numbers(str_angle_scale), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_angle_scale);
    }
    public void display_z_angle_scale(final String str_z_angle_scale) {
        Runnable proc_z_angle_scale = new Runnable() {
            public void run() {
                zAngleScaleEdit.setText(Spannables.colorized_numbers(str_z_angle_scale), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_z_angle_scale);
    }
    public void display_transl_scale(final String str_transl_scale) {
        Runnable proc_transl_scale = new Runnable() {
            public void run() {
                translScaleEdit.setText(Spannables.colorized_numbers(str_transl_scale), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_transl_scale);
    }
    public void display_z_transl_scale(final String str_z_transl_scale) {
        Runnable proc_z_transl_scale = new Runnable() {
            public void run() {
                ZtranslScaleEdit.setText(Spannables.colorized_numbers(str_z_transl_scale), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_z_transl_scale);
    }
    public void display_bond_scale(final String str_bond_scale) {
        Runnable proc_bond_scale = new Runnable() {
            public void run() {
                bondScaleEdit.setText(Spannables.colorized_numbers(str_bond_scale), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_bond_scale);
    }
    public void display_hydr_bond_scale(final String str_hydr_bond_scale) {
        Runnable proc_hydr_bond_scale = new Runnable() {
            public void run() {
                hydrBondScaleEdit.setText(Spannables.colorized_numbers(str_hydr_bond_scale), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_hydr_bond_scale);
    }
    public void display_minDistCrit_pix(final String str_minDistCrit_pix) {
        Runnable proc_minDistCrit_pix = new Runnable() {
            public void run() {
                minDistCritPixEdit.setText(Spannables.colorized_numbers(str_minDistCrit_pix), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_minDistCrit_pix);
    }
    public void display_text_size(final String str_text_size) {
        Runnable proc_text_size = new Runnable() {
            public void run() {
                textSizeEdit.setText(Spannables.colorized_numbers(str_text_size), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_text_size);
    }
    public void display_text_shift_z_Ang(final String str_text_shift_z_Ang) {
        Runnable proc_text_shift_z_Ang = new Runnable() {
            public void run() {
                textShiftZAngEdit.setText(Spannables.colorized_numbers(str_text_shift_z_Ang), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_text_shift_z_Ang);
    }
    public void display_text_shift_x_pix(final String str_text_shift_x_pix) {
        Runnable proc_text_shift_x_pix = new Runnable() {
            public void run() {
                textShiftXpixEdit.setText(Spannables.colorized_numbers(str_text_shift_x_pix), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_text_shift_x_pix);
    }
    public void display_text_shift_y_pix(final String str_text_shift_y_pix) {
        Runnable proc_text_shift_y_pix = new Runnable() {
            public void run() {
                textShiftYpixEdit.setText(Spannables.colorized_numbers(str_text_shift_y_pix), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_text_shift_y_pix);
    }
    public void display_bondsStrokeWidth(final String str_bondsStrokeWidth) {
        Runnable proc_bondsStrokeWidth = new Runnable() {
            public void run() {
                bondsStrokeWidthEdit.setText(Spannables.colorized_numbers(str_bondsStrokeWidth), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_bondsStrokeWidth);
    }
    public void display_bordersStrokeWidth(final String str_bordersStrokeWidth) {
        Runnable proc_bordersStrokeWidth = new Runnable() {
            public void run() {
                bordersStrokeWidthEdit.setText(Spannables.colorized_numbers(str_bordersStrokeWidth), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_bordersStrokeWidth);
    }
    public void display_zmatLines(final String str_zmatLines) {
        Runnable proc_zmatLines = new Runnable() {
            public void run() {
                zmatLinesEdit.setText(Spannables.colorized_numbers(str_zmatLines), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_zmatLines);
    }
    public void display_H(final String str_H) {
        Runnable proc_H = new Runnable() {
            public void run() {
                Rad_H.setText(Spannables.colorized_numbers(str_H), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_H);
    }
    public void display_He(final String str_He) {
        Runnable proc_He = new Runnable() {
            public void run() {
                Rad_He.setText(Spannables.colorized_numbers(str_He), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_He);
    }
    public void display_Li(final String str_Li) {
        Runnable proc_Li = new Runnable() {
            public void run() {
                Rad_Li.setText(Spannables.colorized_numbers(str_Li), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Li);
    }
    public void display_Be(final String str_Be) {
        Runnable proc_Be = new Runnable() {
            public void run() {
                Rad_Be.setText(Spannables.colorized_numbers(str_Be), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Be);
    }
    public void display_B(final String str_B) {
        Runnable proc_B = new Runnable() {
            public void run() {
                Rad_B.setText(Spannables.colorized_numbers(str_B), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_B);
    }
    public void display_C(final String str_C) {
        Runnable proc_C = new Runnable() {
            public void run() {
                Rad_C.setText(Spannables.colorized_numbers(str_C), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_C);
    }
    public void display_N(final String str_N) {
        Runnable proc_N = new Runnable() {
            public void run() {
                Rad_N.setText(Spannables.colorized_numbers(str_N), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_N);
    }
    public void display_O(final String str_O) {
        Runnable proc_O = new Runnable() {
            public void run() {
                Rad_O.setText(Spannables.colorized_numbers(str_O), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_O);
    }
    public void display_F(final String str_F) {
        Runnable proc_F = new Runnable() {
            public void run() {
                Rad_F.setText(Spannables.colorized_numbers(str_F), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_F);
    }
    public void display_Ne(final String str_Ne) {
        Runnable proc_Ne = new Runnable() {
            public void run() {
                Rad_Ne.setText(Spannables.colorized_numbers(str_Ne), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ne);
    }
    public void display_Na(final String str_Na) {
        Runnable proc_Na = new Runnable() {
            public void run() {
                Rad_Na.setText(Spannables.colorized_numbers(str_Na), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Na);
    }
    public void display_Mg(final String str_Mg) {
        Runnable proc_Mg = new Runnable() {
            public void run() {
                Rad_Mg.setText(Spannables.colorized_numbers(str_Mg), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Mg);
    }
    public void display_Al(final String str_Al) {
        Runnable proc_Al = new Runnable() {
            public void run() {
                Rad_Al.setText(Spannables.colorized_numbers(str_Al), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Al);
    }
    public void display_Si(final String str_Si) {
        Runnable proc_Si = new Runnable() {
            public void run() {
                Rad_Si.setText(Spannables.colorized_numbers(str_Si), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Si);
    }
    public void display_P(final String str_P) {
        Runnable proc_P = new Runnable() {
            public void run() {
                Rad_P.setText(Spannables.colorized_numbers(str_P), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_P);
    }
    public void display_S(final String str_S) {
        Runnable proc_S = new Runnable() {
            public void run() {
                Rad_S.setText(Spannables.colorized_numbers(str_S), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_S);
    }
    public void display_Cl(final String str_Cl) {
        Runnable proc_Cl = new Runnable() {
            public void run() {
                Rad_Cl.setText(Spannables.colorized_numbers(str_Cl), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Cl);
    }
    public void display_Ar(final String str_Ar) {
        Runnable proc_Ar = new Runnable() {
            public void run() {
                Rad_Ar.setText(Spannables.colorized_numbers(str_Ar), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ar);
    }
    public void display_K(final String str_K) {
        Runnable proc_K = new Runnable() {
            public void run() {
                Rad_K.setText(Spannables.colorized_numbers(str_K), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_K);
    }
    public void display_Ca(final String str_Ca) {
        Runnable proc_Ca = new Runnable() {
            public void run() {
                Rad_Ca.setText(Spannables.colorized_numbers(str_Ca), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ca);
    }
    public void display_Sc(final String str_Sc) {
        Runnable proc_Sc = new Runnable() {
            public void run() {
                Rad_Sc.setText(Spannables.colorized_numbers(str_Sc), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Sc);
    }
    public void display_Ti(final String str_Ti) {
        Runnable proc_Ti = new Runnable() {
            public void run() {
                Rad_Ti.setText(Spannables.colorized_numbers(str_Ti), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ti);
    }
    public void display_V(final String str_V) {
        Runnable proc_V = new Runnable() {
            public void run() {
                Rad_V.setText(Spannables.colorized_numbers(str_V), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_V);
    }
    public void display_Cr(final String str_Cr) {
        Runnable proc_Cr = new Runnable() {
            public void run() {
                Rad_Cr.setText(Spannables.colorized_numbers(str_Cr), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Cr);
    }
    public void display_Mn(final String str_Mn) {
        Runnable proc_Mn = new Runnable() {
            public void run() {
                Rad_Mn.setText(Spannables.colorized_numbers(str_Mn), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Mn);
    }
    public void display_Fe(final String str_Fe) {
        Runnable proc_Fe = new Runnable() {
            public void run() {
                Rad_Fe.setText(Spannables.colorized_numbers(str_Fe), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Fe);
    }
    public void display_Co(final String str_Co) {
        Runnable proc_Co = new Runnable() {
            public void run() {
                Rad_Co.setText(Spannables.colorized_numbers(str_Co), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Co);
    }
    public void display_Ni(final String str_Ni) {
        Runnable proc_Ni = new Runnable() {
            public void run() {
                Rad_Ni.setText(Spannables.colorized_numbers(str_Ni), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ni);
    }
    public void display_Cu(final String str_Cu) {
        Runnable proc_Cu = new Runnable() {
            public void run() {
                Rad_Cu.setText(Spannables.colorized_numbers(str_Cu), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Cu);
    }
    public void display_Zn(final String str_Zn) {
        Runnable proc_Zn = new Runnable() {
            public void run() {
                Rad_Zn.setText(Spannables.colorized_numbers(str_Zn), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Zn);
    }
    public void display_Ga(final String str_Ga) {
        Runnable proc_Ga = new Runnable() {
            public void run() {
                Rad_Ga.setText(Spannables.colorized_numbers(str_Ga), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ga);
    }
    public void display_Ge(final String str_Ge) {
        Runnable proc_Ge = new Runnable() {
            public void run() {
                Rad_Ge.setText(Spannables.colorized_numbers(str_Ge), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ge);
    }
    public void display_As(final String str_As) {
        Runnable proc_As = new Runnable() {
            public void run() {
                Rad_As.setText(Spannables.colorized_numbers(str_As), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_As);
    }
    public void display_Se(final String str_Se) {
        Runnable proc_Se = new Runnable() {
            public void run() {
                Rad_Se.setText(Spannables.colorized_numbers(str_Se), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Se);
    }
    public void display_Br(final String str_Br) {
        Runnable proc_Br = new Runnable() {
            public void run() {
                Rad_Br.setText(Spannables.colorized_numbers(str_Br), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Br);
    }
    public void display_Kr(final String str_Kr) {
        Runnable proc_Kr = new Runnable() {
            public void run() {
                Rad_Kr.setText(Spannables.colorized_numbers(str_Kr), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Kr);
    }
    public void display_Rb(final String str_Rb) {
        Runnable proc_Rb = new Runnable() {
            public void run() {
                Rad_Rb.setText(Spannables.colorized_numbers(str_Rb), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Rb);
    }
    public void display_Sr(final String str_Sr) {
        Runnable proc_Sr = new Runnable() {
            public void run() {
                Rad_Sr.setText(Spannables.colorized_numbers(str_Sr), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Sr);
    }
    public void display_Y(final String str_Y) {
        Runnable proc_Y = new Runnable() {
            public void run() {
                Rad_Y.setText(Spannables.colorized_numbers(str_Y), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Y);
    }
    public void display_Zr(final String str_Zr) {
        Runnable proc_Zr = new Runnable() {
            public void run() {
                Rad_Zr.setText(Spannables.colorized_numbers(str_Zr), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Zr);
    }
    public void display_Nb(final String str_Nb) {
        Runnable proc_Nb = new Runnable() {
            public void run() {
                Rad_Nb.setText(Spannables.colorized_numbers(str_Nb), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Nb);
    }
    public void display_Mo(final String str_Mo) {
        Runnable proc_Mo = new Runnable() {
            public void run() {
                Rad_Mo.setText(Spannables.colorized_numbers(str_Mo), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Mo);
    }
    public void display_Tc(final String str_Tc) {
        Runnable proc_Tc = new Runnable() {
            public void run() {
                Rad_Tc.setText(Spannables.colorized_numbers(str_Tc), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Tc);
    }
    public void display_Ru(final String str_Ru) {
        Runnable proc_Ru = new Runnable() {
            public void run() {
                Rad_Ru.setText(Spannables.colorized_numbers(str_Ru), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ru);
    }
    public void display_Rh(final String str_Rh) {
        Runnable proc_Rh = new Runnable() {
            public void run() {
                Rad_Rh.setText(Spannables.colorized_numbers(str_Rh), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Rh);
    }
    public void display_Pd(final String str_Pd) {
        Runnable proc_Pd = new Runnable() {
            public void run() {
                Rad_Pd.setText(Spannables.colorized_numbers(str_Pd), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Pd);
    }
    public void display_Ag(final String str_Ag) {
        Runnable proc_Ag = new Runnable() {
            public void run() {
                Rad_Ag.setText(Spannables.colorized_numbers(str_Ag), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ag);
    }
    public void display_Cd(final String str_Cd) {
        Runnable proc_Cd = new Runnable() {
            public void run() {
                Rad_Cd.setText(Spannables.colorized_numbers(str_Cd), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Cd);
    }
    public void display_In(final String str_In) {
        Runnable proc_In = new Runnable() {
            public void run() {
                Rad_In.setText(Spannables.colorized_numbers(str_In), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_In);
    }
    public void display_Sn(final String str_Sn) {
        Runnable proc_Sn = new Runnable() {
            public void run() {
                Rad_Sn.setText(Spannables.colorized_numbers(str_Sn), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Sn);
    }
    public void display_Sb(final String str_Sb) {
        Runnable proc_Sb = new Runnable() {
            public void run() {
                Rad_Sb.setText(Spannables.colorized_numbers(str_Sb), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Sb);
    }
    public void display_Te(final String str_Te) {
        Runnable proc_Te = new Runnable() {
            public void run() {
                Rad_Te.setText(Spannables.colorized_numbers(str_Te), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Te);
    }
    public void display_I(final String str_I) {
        Runnable proc_I = new Runnable() {
            public void run() {
                Rad_I.setText(Spannables.colorized_numbers(str_I), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_I);
    }
    public void display_Xe(final String str_Xe) {
        Runnable proc_Xe = new Runnable() {
            public void run() {
                Rad_Xe.setText(Spannables.colorized_numbers(str_Xe), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Xe);
    }
    public void display_Cs(final String str_Cs) {
        Runnable proc_Cs = new Runnable() {
            public void run() {
                Rad_Cs.setText(Spannables.colorized_numbers(str_Cs), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Cs);
    }
    public void display_Ba(final String str_Ba) {
        Runnable proc_Ba = new Runnable() {
            public void run() {
                Rad_Ba.setText(Spannables.colorized_numbers(str_Ba), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ba);
    }
    public void display_La(final String str_La) {
        Runnable proc_La = new Runnable() {
            public void run() {
                Rad_La.setText(Spannables.colorized_numbers(str_La), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_La);
    }
    public void display_Ce(final String str_Ce) {
        Runnable proc_Ce = new Runnable() {
            public void run() {
                Rad_Ce.setText(Spannables.colorized_numbers(str_Ce), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ce);
    }
    public void display_Pr(final String str_Pr) {
        Runnable proc_Pr = new Runnable() {
            public void run() {
                Rad_Pr.setText(Spannables.colorized_numbers(str_Pr), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Pr);
    }
    public void display_Nd(final String str_Nd) {
        Runnable proc_Nd = new Runnable() {
            public void run() {
                Rad_Nd.setText(Spannables.colorized_numbers(str_Nd), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Nd);
    }
    public void display_Pm(final String str_Pm) {
        Runnable proc_Pm = new Runnable() {
            public void run() {
                Rad_Pm.setText(Spannables.colorized_numbers(str_Pm), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Pm);
    }
    public void display_Sm(final String str_Sm) {
        Runnable proc_Sm = new Runnable() {
            public void run() {
                Rad_Sm.setText(Spannables.colorized_numbers(str_Sm), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Sm);
    }
    public void display_Eu(final String str_Eu) {
        Runnable proc_Eu = new Runnable() {
            public void run() {
                Rad_Eu.setText(Spannables.colorized_numbers(str_Eu), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Eu);
    }
    public void display_Gd(final String str_Gd) {
        Runnable proc_Gd = new Runnable() {
            public void run() {
                Rad_Gd.setText(Spannables.colorized_numbers(str_Gd), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Gd);
    }
    public void display_Tb(final String str_Tb) {
        Runnable proc_Tb = new Runnable() {
            public void run() {
                Rad_Tb.setText(Spannables.colorized_numbers(str_Tb), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Tb);
    }
    public void display_Dy(final String str_Dy) {
        Runnable proc_Dy = new Runnable() {
            public void run() {
                Rad_Dy.setText(Spannables.colorized_numbers(str_Dy), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Dy);
    }
    public void display_Ho(final String str_Ho) {
        Runnable proc_Ho = new Runnable() {
            public void run() {
                Rad_Ho.setText(Spannables.colorized_numbers(str_Ho), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ho);
    }
    public void display_Er(final String str_Er) {
        Runnable proc_Er = new Runnable() {
            public void run() {
                Rad_Er.setText(Spannables.colorized_numbers(str_Er), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Er);
    }
    public void display_Tm(final String str_Tm) {
        Runnable proc_Tm = new Runnable() {
            public void run() {
                Rad_Tm.setText(Spannables.colorized_numbers(str_Tm), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Tm);
    }
    public void display_Yb(final String str_Yb) {
        Runnable proc_Yb = new Runnable() {
            public void run() {
                Rad_Yb.setText(Spannables.colorized_numbers(str_Yb), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Yb);
    }
    public void display_Lu(final String str_Lu) {
        Runnable proc_Lu = new Runnable() {
            public void run() {
                Rad_Lu.setText(Spannables.colorized_numbers(str_Lu), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Lu);
    }
    public void display_Hf(final String str_Hf) {
        Runnable proc_Hf = new Runnable() {
            public void run() {
                Rad_Hf.setText(Spannables.colorized_numbers(str_Hf), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Hf);
    }
    public void display_Ta(final String str_Ta) {
        Runnable proc_Ta = new Runnable() {
            public void run() {
                Rad_Ta.setText(Spannables.colorized_numbers(str_Ta), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ta);
    }
    public void display_W(final String str_W) {
        Runnable proc_W = new Runnable() {
            public void run() {
                Rad_W.setText(Spannables.colorized_numbers(str_W), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_W);
    }
    public void display_Re(final String str_Re) {
        Runnable proc_Re = new Runnable() {
            public void run() {
                Rad_Re.setText(Spannables.colorized_numbers(str_Re), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Re);
    }
    public void display_Os(final String str_Os) {
        Runnable proc_Os = new Runnable() {
            public void run() {
                Rad_Os.setText(Spannables.colorized_numbers(str_Os), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Os);
    }
    public void display_Ir(final String str_Ir) {
        Runnable proc_Ir = new Runnable() {
            public void run() {
                Rad_Ir.setText(Spannables.colorized_numbers(str_Ir), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ir);
    }
    public void display_Pt(final String str_Pt) {
        Runnable proc_Pt = new Runnable() {
            public void run() {
                Rad_Pt.setText(Spannables.colorized_numbers(str_Pt), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Pt);
    }
    public void display_Au(final String str_Au) {
        Runnable proc_Au = new Runnable() {
            public void run() {
                Rad_Au.setText(Spannables.colorized_numbers(str_Au), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Au);
    }
    public void display_Hg(final String str_Hg) {
        Runnable proc_Hg = new Runnable() {
            public void run() {
                Rad_Hg.setText(Spannables.colorized_numbers(str_Hg), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Hg);
    }
    public void display_Tl(final String str_Tl) {
        Runnable proc_Tl = new Runnable() {
            public void run() {
                Rad_Tl.setText(Spannables.colorized_numbers(str_Tl), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Tl);
    }
    public void display_Pb(final String str_Pb) {
        Runnable proc_Pb = new Runnable() {
            public void run() {
                Rad_Pb.setText(Spannables.colorized_numbers(str_Pb), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Pb);
    }
    public void display_Bi(final String str_Bi) {
        Runnable proc_Bi = new Runnable() {
            public void run() {
                Rad_Bi.setText(Spannables.colorized_numbers(str_Bi), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Bi);
    }
    public void display_Po(final String str_Po) {
        Runnable proc_Po = new Runnable() {
            public void run() {
                Rad_Po.setText(Spannables.colorized_numbers(str_Po), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Po);
    }
    public void display_At(final String str_At) {
        Runnable proc_At = new Runnable() {
            public void run() {
                Rad_At.setText(Spannables.colorized_numbers(str_At), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_At);
    }
    public void display_Rn(final String str_Rn) {
        Runnable proc_Rn = new Runnable() {
            public void run() {
                Rad_Rn.setText(Spannables.colorized_numbers(str_Rn), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Rn);
    }
    public void display_Fr(final String str_Fr) {
        Runnable proc_Fr = new Runnable() {
            public void run() {
                Rad_Fr.setText(Spannables.colorized_numbers(str_Fr), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Fr);
    }
    public void display_Ra(final String str_Ra) {
        Runnable proc_Ra = new Runnable() {
            public void run() {
                Rad_Ra.setText(Spannables.colorized_numbers(str_Ra), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ra);
    }
    public void display_Ac(final String str_Ac) {
        Runnable proc_Ac = new Runnable() {
            public void run() {
                Rad_Ac.setText(Spannables.colorized_numbers(str_Ac), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ac);
    }
    public void display_Th(final String str_Th) {
        Runnable proc_Th = new Runnable() {
            public void run() {
                Rad_Th.setText(Spannables.colorized_numbers(str_Th), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Th);
    }
    public void display_Pa(final String str_Pa) {
        Runnable proc_Pa = new Runnable() {
            public void run() {
                Rad_Pa.setText(Spannables.colorized_numbers(str_Pa), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Pa);
    }
    public void display_U(final String str_U) {
        Runnable proc_U = new Runnable() {
            public void run() {
                Rad_U.setText(Spannables.colorized_numbers(str_U), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_U);
    }
    public void display_Np(final String str_Np) {
        Runnable proc_Np = new Runnable() {
            public void run() {
                Rad_Np.setText(Spannables.colorized_numbers(str_Np), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Np);
    }
    public void display_Pu(final String str_Pu) {
        Runnable proc_Pu = new Runnable() {
            public void run() {
                Rad_Pu.setText(Spannables.colorized_numbers(str_Pu), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Pu);
    }
    public void display_Am(final String str_Am) {
        Runnable proc_Am = new Runnable() {
            public void run() {
                Rad_Am.setText(Spannables.colorized_numbers(str_Am), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Am);
    }
    public void display_Cm(final String str_Cm) {
        Runnable proc_Cm = new Runnable() {
            public void run() {
                Rad_Cm.setText(Spannables.colorized_numbers(str_Cm), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Cm);
    }
    public void display_Bk(final String str_Bk) {
        Runnable proc_Bk = new Runnable() {
            public void run() {
                Rad_Bk.setText(Spannables.colorized_numbers(str_Bk), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Bk);
    }
    public void display_Cf(final String str_Cf) {
        Runnable proc_Cf = new Runnable() {
            public void run() {
                Rad_Cf.setText(Spannables.colorized_numbers(str_Cf), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Cf);
    }
    public void display_Es(final String str_Es) {
        Runnable proc_Es = new Runnable() {
            public void run() {
                Rad_Es.setText(Spannables.colorized_numbers(str_Es), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Es);
    }
    public void display_Fm(final String str_Fm) {
        Runnable proc_Fm = new Runnable() {
            public void run() {
                Rad_Fm.setText(Spannables.colorized_numbers(str_Fm), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Fm);
    }
    public void display_Md(final String str_Md) {
        Runnable proc_Md = new Runnable() {
            public void run() {
                Rad_Md.setText(Spannables.colorized_numbers(str_Md), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Md);
    }
    public void display_No(final String str_No) {
        Runnable proc_No = new Runnable() {
            public void run() {
                Rad_No.setText(Spannables.colorized_numbers(str_No), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_No);
    }
    public void display_Lr(final String str_Lr) {
        Runnable proc_Lr = new Runnable() {
            public void run() {
                Rad_Lr.setText(Spannables.colorized_numbers(str_Lr), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Lr);
    }
    public void display_Rf(final String str_Rf) {
        Runnable proc_Rf = new Runnable() {
            public void run() {
                Rad_Rf.setText(Spannables.colorized_numbers(str_Rf), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Rf);
    }
    public void display_Db(final String str_Db) {
        Runnable proc_Db = new Runnable() {
            public void run() {
                Rad_Db.setText(Spannables.colorized_numbers(str_Db), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Db);
    }
    public void display_Sg(final String str_Sg) {
        Runnable proc_Sg = new Runnable() {
            public void run() {
                Rad_Sg.setText(Spannables.colorized_numbers(str_Sg), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Sg);
    }
    public void display_Bh(final String str_Bh) {
        Runnable proc_Bh = new Runnable() {
            public void run() {
                Rad_Bh.setText(Spannables.colorized_numbers(str_Bh), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Bh);
    }
    public void display_Hs(final String str_Hs) {
        Runnable proc_Hs = new Runnable() {
            public void run() {
                Rad_Hs.setText(Spannables.colorized_numbers(str_Hs), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Hs);
    }
    public void display_Mt(final String str_Mt) {
        Runnable proc_Mt = new Runnable() {
            public void run() {
                Rad_Mt.setText(Spannables.colorized_numbers(str_Mt), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Mt);
    }
    public void display_Ds(final String str_Ds) {
        Runnable proc_Ds = new Runnable() {
            public void run() {
                Rad_Ds.setText(Spannables.colorized_numbers(str_Ds), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ds);
    }
    public void display_Rg(final String str_Rg) {
        Runnable proc_Rg = new Runnable() {
            public void run() {
                Rad_Rg.setText(Spannables.colorized_numbers(str_Rg), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Rg);
    }
    public void display_Cn(final String str_Cn) {
        Runnable proc_Cn = new Runnable() {
            public void run() {
                Rad_Cn.setText(Spannables.colorized_numbers(str_Cn), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Cn);
    }
    public void display_Nh(final String str_Nh) {
        Runnable proc_Nh = new Runnable() {
            public void run() {
                Rad_Nh.setText(Spannables.colorized_numbers(str_Nh), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Nh);
    }
    public void display_Fl(final String str_Fl) {
        Runnable proc_Fl = new Runnable() {
            public void run() {
                Rad_Fl.setText(Spannables.colorized_numbers(str_Fl), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Fl);
    }
    public void display_Mc(final String str_Mc) {
        Runnable proc_Mc = new Runnable() {
            public void run() {
                Rad_Mc.setText(Spannables.colorized_numbers(str_Mc), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Mc);
    }
    public void display_Lv(final String str_Lv) {
        Runnable proc_Lv = new Runnable() {
            public void run() {
                Rad_Lv.setText(Spannables.colorized_numbers(str_Lv), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Lv);
    }
    public void display_Ts(final String str_Ts) {
        Runnable proc_Ts = new Runnable() {
            public void run() {
                Rad_Ts.setText(Spannables.colorized_numbers(str_Ts), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Ts);
    }
    public void display_Og(final String str_Og) {
        Runnable proc_Og = new Runnable() {
            public void run() {
                Rad_Og.setText(Spannables.colorized_numbers(str_Og), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(proc_Og);
    }
}
