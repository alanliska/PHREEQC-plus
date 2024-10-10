package cz.p;

import static cz.p.Spannables.colorized_numbers;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GCM1 extends MainActivity {

    private Handler handler = new Handler();
    private TextView iupac_label;
    private EditText iupac;
    private TextView formula_label;
    private TextView formula;
    private Button next_structure;
    private Button exit;
    private Button quit;
    private Button reset;
    private TextView input_label;
    private TextView input_content;
    private TextView label1001;
    private TextView label1002;
    private TextView label1003;
    private TextView label1004;
    private TextView label1005;
    private TextView label1006;
    //    private TextView label1007;
    private TextView label1008;
    private TextView label1009;
    private ImageButton dummy1;
    private ImageButton dummy2;
    private ImageButton dummy3;
    private ImageButton dummy4;
    private ImageButton dummy5;
    private ImageButton dummy6;
    private ImageButton dummy7;
    private ImageButton dummy8;
    private ImageButton dummy9;
    private ImageButton dummy10;
    private ImageButton dummy11;
    private ImageButton dummy12;
    private ImageButton dummy13;
    private ImageButton dummy14;
    private ImageButton dummy15;
    private ImageButton dummy16;
    private ImageButton gr_ch3;
    private ImageButton gr_ch2;
    private ImageButton gr_ch2_ring;
    private ImageButton gr_ch;
    private ImageButton gr_ch_ring;
    private ImageButton gr_ch_2rings;
    private ImageButton gr_c;
    private ImageButton gr_c_1ring;
    private ImageButton gr_c_2rings;
    private ImageButton gr_ch_double;
    private ImageButton gr_ch_double_nonarom_ring;
    private ImageButton gr_c_double;
    private ImageButton gr_ch2_double;
    private ImageButton gr_ch_double_arom_ring;
    private ImageButton gr_c_double_arom_ring;
    private ImageButton gr_c_nonarom_ring;
    private ImageButton gr_c_2nonarom_rings;
    private ImageButton gr_c_arom_and_nonarom_rings;
    private ImageButton gr_c_ring;
    private ImageButton gr_c_2arom_rings;
    private ImageButton gr_ch_triple;
    private ImageButton gr_c_triple;
    private ImageButton gr_o_minus;
    private ImageButton gr_oh;
    private ImageButton gr_o;
    private ImageButton gr_o_ring;
    private ImageButton gr_co;
    private ImageButton gr_co_ring;
    private ImageButton gr_cho;
    private ImageButton gr_coo_minus;
    private ImageButton gr_oco;
    private ImageButton gr_oco_ring;
    private ImageButton gr_nh3_plus;
    private ImageButton gr_nh2;
    private ImageButton gr_nh2_plus;
    private ImageButton gr_n;
    private ImageButton gr_n_2rings;
    private ImageButton gr_nh;
    private ImageButton gr_nh_ring;
    private ImageButton gr_nh_plus;
    private ImageButton gr_n_plus;
    private ImageButton gr_nh_double;
    private ImageButton gr_nh2_plus_double;
    private ImageButton gr_nh_plus_double_ring;
    private ImageButton gr_n_double;
    private ImageButton gr_n_double_ring;
    private ImageButton gr_n_plus_double_ring;
    private ImageButton gr_n_plus_double_2rings;
    private ImageButton gr_n_triple;
    private ImageButton dummy50;
    private ImageButton gr_opo3_minus2;
    private ImageButton gr_opo2_minus2;
    private ImageButton gr_opo2_minus;
    private ImageButton gr_opo2_minus_ring;
    private ImageButton gr_opo2_minus_o;
    private ImageButton gr_coopo3_minus2;
    private ImageButton gr_s_minus;
    private ImageButton gr_sh;
    private ImageButton gr_soh;
    private ImageButton gr_oso3_minus;
    private ImageButton gr_s;
    private ImageButton gr_s_ring;
    private ImageButton gr_ss;
    private ImageButton gr_s_plus;
    private ImageButton gr_cl_prim;
    private ImageButton gr_cl_sec;
    private ImageButton gr_cl_tert;
    private ImageButton gr_cl2_prim;
    private ImageButton gr_cl2_sec;
    private ImageButton gr_cl3_prim;
    private ImageButton gr_br_ar;
    private ImageButton gr_i_ar;
    private ImageButton gr_f_ar;
    private ImageButton corr_hetero;
    private ImageButton corr_3ring;
    private ImageButton corr_hydrocarbon;
    private ImageButton corr_conh;
    private ImageButton corr_cos;
    private ImageButton corr_viccl;
    private ImageButton corr_conj_occc;
    private ImageButton corr_conj_occo;
    private ImageButton corr_conj_occn;
    private ImageButton corr_conj_cccn;
    private ImageButton corr_conj_cccc;

    // charge
    public int charge;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.gcm1);

        charge = 0;
        iupac_label = (TextView) findViewById(R.id.iupac_label);
        iupac = (EditText) findViewById(R.id.iupac);
        iupac.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        iupac.addTextChangedListener(new TextWatcher() {
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
                iupac.removeTextChangedListener(this);
                String text = iupac.getText().toString();
                // important - not setText() - otherwise the keyboard would be reset after each type
                iupac.getText().clear();
                iupac.append(colorized_numbers(text));
                // place the cursor at the original position
                iupac.setSelection(startChanged+countChanged);
                iupac.addTextChangedListener(this);
            }
        });
        formula_label = (TextView) findViewById(R.id.formula_label);
        formula = (TextView) findViewById(R.id.formula);
        next_structure = (Button) findViewById(R.id.next_structure);
        exit = (Button) findViewById(R.id.exit);
        quit = (Button) findViewById(R.id.quit);
        reset = (Button) findViewById(R.id.reset);
        input_label = (TextView) findViewById(R.id.input_label);
        input_content = (TextView) findViewById(R.id.input_content);
        label1001 = (TextView) findViewById(R.id.label1001);
        label1002 = (TextView) findViewById(R.id.label1002);
        label1003 = (TextView) findViewById(R.id.label1003);
        label1004 = (TextView) findViewById(R.id.label1004);
        label1005 = (TextView) findViewById(R.id.label1005);
        label1006 = (TextView) findViewById(R.id.label1006);
//        label1007 = (TextView) findViewById(R.id.label1007);
        label1008 = (TextView) findViewById(R.id.label1008);
        label1009 = (TextView) findViewById(R.id.label1009);
        dummy1 = (ImageButton) findViewById(R.id.dummy1);
        dummy2 = (ImageButton) findViewById(R.id.dummy2);
        dummy3 = (ImageButton) findViewById(R.id.dummy3);
        dummy4 = (ImageButton) findViewById(R.id.dummy4);
        dummy5 = (ImageButton) findViewById(R.id.dummy5);
        dummy6 = (ImageButton) findViewById(R.id.dummy6);
        dummy7 = (ImageButton) findViewById(R.id.dummy7);
        dummy8 = (ImageButton) findViewById(R.id.dummy8);
        dummy9 = (ImageButton) findViewById(R.id.dummy9);
        dummy10 = (ImageButton) findViewById(R.id.dummy10);
        dummy11 = (ImageButton) findViewById(R.id.dummy11);
        dummy12 = (ImageButton) findViewById(R.id.dummy12);
        dummy13 = (ImageButton) findViewById(R.id.dummy13);
        dummy14 = (ImageButton) findViewById(R.id.dummy14);
        dummy15 = (ImageButton) findViewById(R.id.dummy15);
        dummy16 = (ImageButton) findViewById(R.id.dummy16);
        gr_ch3 = (ImageButton) findViewById(R.id.gr_ch3);
        gr_ch2 = (ImageButton) findViewById(R.id.gr_ch2);
        gr_ch2_ring = (ImageButton) findViewById(R.id.gr_ch2_ring);
        gr_ch = (ImageButton) findViewById(R.id.gr_ch);
        gr_ch_ring = (ImageButton) findViewById(R.id.gr_ch_ring);
        gr_ch_2rings = (ImageButton) findViewById(R.id.gr_ch_2rings);
        gr_c = (ImageButton) findViewById(R.id.gr_c);
        gr_c_1ring = (ImageButton) findViewById(R.id.gr_c_1ring);
        gr_c_2rings = (ImageButton) findViewById(R.id.gr_c_2rings);
        gr_ch_double = (ImageButton) findViewById(R.id.gr_ch_double);
        gr_ch_double_nonarom_ring = (ImageButton) findViewById(R.id.gr_ch_double_nonarom_ring);
        gr_c_double = (ImageButton) findViewById(R.id.gr_c_double);
        gr_ch2_double = (ImageButton) findViewById(R.id.gr_ch2_double);
        gr_ch_double_arom_ring = (ImageButton) findViewById(R.id.gr_ch_double_arom_ring);
        gr_c_double_arom_ring = (ImageButton) findViewById(R.id.gr_c_double_arom_ring);
        gr_c_nonarom_ring = (ImageButton) findViewById(R.id.gr_c_nonarom_ring);
        gr_c_2nonarom_rings = (ImageButton) findViewById(R.id.gr_c_2nonarom_rings);
        gr_c_arom_and_nonarom_rings = (ImageButton) findViewById(R.id.gr_c_arom_and_nonarom_rings);
        gr_c_ring = (ImageButton) findViewById(R.id.gr_c_ring);
        gr_c_2arom_rings = (ImageButton) findViewById(R.id.gr_c_2arom_rings);
        gr_ch_triple = (ImageButton) findViewById(R.id.gr_ch_triple);
        gr_c_triple = (ImageButton) findViewById(R.id.gr_c_triple);
        gr_o_minus = (ImageButton) findViewById(R.id.gr_o_minus);
        gr_oh = (ImageButton) findViewById(R.id.gr_oh);
        gr_o = (ImageButton) findViewById(R.id.gr_o);
        gr_o_ring = (ImageButton) findViewById(R.id.gr_o_ring);
        gr_co = (ImageButton) findViewById(R.id.gr_co);
        gr_co_ring = (ImageButton) findViewById(R.id.gr_co_ring);
        gr_cho = (ImageButton) findViewById(R.id.gr_cho);
        gr_coo_minus = (ImageButton) findViewById(R.id.gr_coo_minus);
        gr_oco = (ImageButton) findViewById(R.id.gr_oco);
        gr_oco_ring = (ImageButton) findViewById(R.id.gr_oco_ring);
        gr_nh3_plus = (ImageButton) findViewById(R.id.gr_nh3_plus);
        gr_nh2 = (ImageButton) findViewById(R.id.gr_nh2);
        gr_nh2_plus = (ImageButton) findViewById(R.id.gr_nh2_plus);
        gr_n = (ImageButton) findViewById(R.id.gr_n);
        gr_n_2rings = (ImageButton) findViewById(R.id.gr_n_2rings);
        gr_nh = (ImageButton) findViewById(R.id.gr_nh);
        gr_nh_ring = (ImageButton) findViewById(R.id.gr_nh_ring);
        gr_nh_plus = (ImageButton) findViewById(R.id.gr_nh_plus);
        gr_n_plus = (ImageButton) findViewById(R.id.gr_n_plus);
        gr_nh_double = (ImageButton) findViewById(R.id.gr_nh_double);
        gr_nh2_plus_double = (ImageButton) findViewById(R.id.gr_nh2_plus_double);
        gr_nh_plus_double_ring = (ImageButton) findViewById(R.id.gr_nh_plus_double_ring);
        gr_n_double = (ImageButton) findViewById(R.id.gr_n_double);
        gr_n_double_ring = (ImageButton) findViewById(R.id.gr_n_double_ring);
        gr_n_plus_double_ring = (ImageButton) findViewById(R.id.gr_n_plus_double_ring);
        gr_n_plus_double_2rings = (ImageButton) findViewById(R.id.gr_n_plus_double_2rings);
        gr_n_triple = (ImageButton) findViewById(R.id.gr_n_triple);
        dummy50 = (ImageButton) findViewById(R.id.dummy50);
        gr_opo3_minus2 = (ImageButton) findViewById(R.id.gr_opo3_minus2);
        gr_opo2_minus2 = (ImageButton) findViewById(R.id.gr_opo2_minus2);
        gr_opo2_minus = (ImageButton) findViewById(R.id.gr_opo2_minus);
        gr_opo2_minus_ring = (ImageButton) findViewById(R.id.gr_opo2_minus_ring);
        gr_opo2_minus_o = (ImageButton) findViewById(R.id.gr_opo2_minus_o);
        gr_coopo3_minus2 = (ImageButton) findViewById(R.id.gr_coopo3_minus2);
        gr_s_minus = (ImageButton) findViewById(R.id.gr_s_minus);
        gr_sh = (ImageButton) findViewById(R.id.gr_sh);
        gr_soh = (ImageButton) findViewById(R.id.gr_soh);
        gr_oso3_minus = (ImageButton) findViewById(R.id.gr_oso3_minus);
        gr_s = (ImageButton) findViewById(R.id.gr_s);
        gr_s_ring = (ImageButton) findViewById(R.id.gr_s_ring);
        gr_ss = (ImageButton) findViewById(R.id.gr_ss);
        gr_s_plus = (ImageButton) findViewById(R.id.gr_s_plus);
        gr_cl_prim = (ImageButton) findViewById(R.id.gr_cl_prim);
        gr_cl_sec = (ImageButton) findViewById(R.id.gr_cl_sec);
        gr_cl_tert = (ImageButton) findViewById(R.id.gr_cl_tert);
        gr_cl2_prim = (ImageButton) findViewById(R.id.gr_cl2_prim);
        gr_cl2_sec = (ImageButton) findViewById(R.id.gr_cl2_sec);
        gr_cl3_prim = (ImageButton) findViewById(R.id.gr_cl3_prim);
        gr_br_ar = (ImageButton) findViewById(R.id.gr_br_ar);
        gr_i_ar = (ImageButton) findViewById(R.id.gr_i_ar);
        gr_f_ar = (ImageButton) findViewById(R.id.gr_f_ar);
        corr_hetero = (ImageButton) findViewById(R.id.corr_hetero);
        corr_3ring = (ImageButton) findViewById(R.id.corr_3ring);
        corr_hydrocarbon = (ImageButton) findViewById(R.id.corr_hydrocarbon);
        corr_conh = (ImageButton) findViewById(R.id.corr_conh);
        corr_cos = (ImageButton) findViewById(R.id.corr_cos);
        corr_viccl = (ImageButton) findViewById(R.id.corr_viccl);
        corr_conj_occc = (ImageButton) findViewById(R.id.corr_conj_occc);
        corr_conj_occo = (ImageButton) findViewById(R.id.corr_conj_occo);
        corr_conj_occn = (ImageButton) findViewById(R.id.corr_conj_occn);
        corr_conj_cccn = (ImageButton) findViewById(R.id.corr_conj_cccn);
        corr_conj_cccc = (ImageButton) findViewById(R.id.corr_conj_cccc);


        next_structure.setOnClickListener(click_next_structure);
        exit.setOnClickListener(click_exit);
        quit.setOnClickListener(click_quit);
        reset.setOnClickListener(click_reset);
//        dummy1.setOnClickListener(dmm1);
//        dummy2.setOnClickListener(dmm2);
//        dummy3.setOnClickListener(dmm3);
//        dummy4.setOnClickListener(dmm4);
//        dummy5.setOnClickListener(dmm5);
//        dummy6.setOnClickListener(dmm6);
//        dummy7.setOnClickListener(dmm7);
//        dummy8.setOnClickListener(dmm8);
//        dummy9.setOnClickListener(dmm9);
//        dummy10.setOnClickListener(dmm10);
//        dummy11.setOnClickListener(dmm11);
//        dummy12.setOnClickListener(dmm12);
//        dummy13.setOnClickListener(dmm13);
//        dummy14.setOnClickListener(dmm14);
//        dummy15.setOnClickListener(dmm15);
//        dummy16.setOnClickListener(dmm16);
        gr_ch3.setOnClickListener(ch3);
        gr_ch2.setOnClickListener(ch2);
        gr_ch2_ring.setOnClickListener(ch2_ring);
        gr_ch.setOnClickListener(ch);
        gr_ch_ring.setOnClickListener(ch_ring);
        gr_ch_2rings.setOnClickListener(ch_2rings);
        gr_c.setOnClickListener(c);
        gr_c_1ring.setOnClickListener(c_1ring);
        gr_c_2rings.setOnClickListener(c_2rings);
        gr_ch_double.setOnClickListener(ch_double);
        gr_ch_double_nonarom_ring.setOnClickListener(ch_double_nonarom_ring);
        gr_c_double.setOnClickListener(c_double);
        gr_ch2_double.setOnClickListener(ch2_double);
        gr_ch_double_arom_ring.setOnClickListener(ch_double_arom_ring);
        gr_c_double_arom_ring.setOnClickListener(c_double_arom_ring);
        gr_c_nonarom_ring.setOnClickListener(c_nonarom_ring);
        gr_c_2nonarom_rings.setOnClickListener(c_2nonarom_rings);
        gr_c_arom_and_nonarom_rings.setOnClickListener(c_arom_and_nonarom_rings);
        gr_c_ring.setOnClickListener(c_ring);
        gr_c_2arom_rings.setOnClickListener(c_2arom_rings);
        gr_ch_triple.setOnClickListener(ch_triple);
        gr_c_triple.setOnClickListener(c_triple);
        gr_o_minus.setOnClickListener(o_minus);
        gr_oh.setOnClickListener(oh);
        gr_o.setOnClickListener(o);
        gr_o_ring.setOnClickListener(o_ring);
        gr_co.setOnClickListener(co);
        gr_co_ring.setOnClickListener(co_ring);
        gr_cho.setOnClickListener(cho);
        gr_coo_minus.setOnClickListener(coo_minus);
        gr_oco.setOnClickListener(oco);
        gr_oco_ring.setOnClickListener(oco_ring);
        gr_nh3_plus.setOnClickListener(nh3_plus);
        gr_nh2.setOnClickListener(nh2);
        gr_nh2_plus.setOnClickListener(nh2_plus);
        gr_n.setOnClickListener(n);
        gr_n_2rings.setOnClickListener(n_2rings);
        gr_nh.setOnClickListener(nh);
        gr_nh_ring.setOnClickListener(nh_ring);
        gr_nh_plus.setOnClickListener(nh_plus);
        gr_n_plus.setOnClickListener(n_plus);
        gr_nh_double.setOnClickListener(nh_double);
        gr_nh2_plus_double.setOnClickListener(nh2_plus_double);
        gr_nh_plus_double_ring.setOnClickListener(nh_plus_double_ring);
        gr_n_double.setOnClickListener(n_double);
        gr_n_double_ring.setOnClickListener(n_double_ring);
        gr_n_plus_double_ring.setOnClickListener(n_plus_double_ring);
        gr_n_plus_double_2rings.setOnClickListener(n_plus_double_2rings);
        gr_n_triple.setOnClickListener(n_triple);
//        dummy50.setOnClickListener(dmm50);
        gr_opo3_minus2.setOnClickListener(opo3_minus2);
        gr_opo2_minus2.setOnClickListener(opo2_minus2);
        gr_opo2_minus.setOnClickListener(opo2_minus);
        gr_opo2_minus_ring.setOnClickListener(opo2_minus_ring);
        gr_opo2_minus_o.setOnClickListener(opo2_minus_o);
        gr_coopo3_minus2.setOnClickListener(coopo3_minus2);
        gr_s_minus.setOnClickListener(s_minus);
        gr_sh.setOnClickListener(sh);
        gr_soh.setOnClickListener(soh);
        gr_oso3_minus.setOnClickListener(oso3_minus);
        gr_s.setOnClickListener(s);
        gr_s_ring.setOnClickListener(s_ring);
        gr_ss.setOnClickListener(ss);
        gr_s_plus.setOnClickListener(s_plus);
        gr_cl_prim.setOnClickListener(cl_prim);
        gr_cl_sec.setOnClickListener(cl_sec);
        gr_cl_tert.setOnClickListener(cl_tert);
        gr_cl2_prim.setOnClickListener(cl2_prim);
        gr_cl2_sec.setOnClickListener(cl2_sec);
        gr_cl3_prim.setOnClickListener(cl3_prim);
        gr_br_ar.setOnClickListener(br_ar);
        gr_i_ar.setOnClickListener(i_ar);
        gr_f_ar.setOnClickListener(f_ar);
        corr_hetero.setOnClickListener(hetero);
        corr_3ring.setOnClickListener(three_ring);
        corr_hydrocarbon.setOnClickListener(hydrocarbon);
        corr_conh.setOnClickListener(conh);
        corr_cos.setOnClickListener(cos);
        corr_viccl.setOnClickListener(viccl);
        corr_conj_occc.setOnClickListener(conj_occc);
        corr_conj_occo.setOnClickListener(conj_occo);
        corr_conj_occn.setOnClickListener(conj_occn);
        corr_conj_cccn.setOnClickListener(conj_cccn);
        corr_conj_cccc.setOnClickListener(conj_cccc);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        charge = 0;
        exec("rm "+getFilesDir()+"/gcm1formula.txt");
        exec("touch "+getFilesDir()+"/gcm1formula.txt");
        exec("rm "+getFilesDir()+"/GCM1-input.txt");
        exec("touch "+getFilesDir()+"/GCM1-input.txt");
        input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
        iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
        formula_view(exec("cat "+getFilesDir()+"/gcm1formula.txt"));
    }

    private View.OnClickListener click_reset; {
        click_reset = new View.OnClickListener() {
            public void onClick(View v) {
                charge = 0;
                try {
                    exec("rm "+getFilesDir()+"/gcm1formula.txt");
                    exec("touch "+getFilesDir()+"/gcm1formula.txt");
                    exec("rm "+getFilesDir()+"/GCM1-input.txt");
                    exec("touch "+getFilesDir()+"/GCM1-input.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm1formula.txt"));
            }
        };
    }

    private View.OnClickListener ch3; {
        ch3 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CH3;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener ch2; {
        ch2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">CH2;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener ch2_ring; {
        ch2_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">CH2(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener ch; {
        ch = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">CH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener ch_ring; {
        ch_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">CH-(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener ch_2rings; {
        ch_2rings = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">CH-(2fused_rings);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener c; {
        c = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C<;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener c_1ring; {
        c_1ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C<(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener c_2rings; {
        c_2rings = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C<(2fused_rings);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener ch_double; {
        ch_double = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=CH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener ch_double_nonarom_ring; {
        ch_double_nonarom_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=CH-(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener c_double; {
        c_double = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C=;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener ch2_double; {
        ch2_double = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=CH2;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener ch_double_arom_ring; {
        ch_double_arom_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=CH-(1arom.);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener c_double_arom_ring; {
        c_double_arom_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C=(single+double_arom.);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener c_nonarom_ring; {
        c_nonarom_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C=(2single_ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener c_2nonarom_rings; {
        c_2nonarom_rings = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C=(2fused_rings);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener c_arom_and_nonarom_rings; {
        c_arom_and_nonarom_rings = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C=(fused_arom+ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener c_ring; {
        c_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C=(double+single_ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener c_2arom_rings; {
        c_2arom_rings = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C=(2fused_arom.);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener ch_triple; {
        ch_triple = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("#CH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener c_triple; {
        c_triple = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("#C-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener o_minus; {
        o_minus = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge-1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O(-);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener oh; {
        oh = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O][H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener o; {
        o = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener o_ring; {
        o_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener co; {
        co = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">CO;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener co_ring; {
        co_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">CO(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener cho; {
        cho = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CHO;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H][O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener coo_minus; {
        coo_minus = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge-1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-COO(-);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O][O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener oco; {
        oco = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OCO-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]C[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener oco_ring; {
        oco_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OCO-(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]C[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener nh3_plus; {
        nh3_plus = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge+1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-NH3(+);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener nh2; {
        nh2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-NH2;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener nh2_plus; {
        nh2_plus = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge+1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">NH2(+);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener n; {
        n = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">N-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener n_2rings; {
        n_2rings = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">N-(2rings);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener nh; {
        nh = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-NH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener nh_ring; {
        nh_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-NH-(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener nh_plus; {
        nh_plus = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge+1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">NH(+)-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener n_plus; {
        n_plus = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge+1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">N(+)<;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener nh_double; {
        nh_double = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=NH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener nh2_plus_double; {
        nh2_plus_double = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge+1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=NH2(+);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener nh_plus_double_ring; {
        nh_plus_double_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge+1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=NH(+)-(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener n_double; {
        n_double = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=N(-);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener n_double_ring; {
        n_double_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=N-(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener n_plus_double_ring; {
        n_plus_double_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge+1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=N(+)<(double+single_ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener n_plus_double_2rings; {
        n_plus_double_2rings = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge+1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=N(+)<(2fused_rings);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener n_triple; {
        n_triple = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("#N;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener opo3_minus2; {
        opo3_minus2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge-2;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OPO3(-2);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]P[O]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener opo2_minus2; {
        opo2_minus2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge-2;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OPO2(-2);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]P[O]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener opo2_minus; {
        opo2_minus = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge-1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OPO2(-);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]P[O]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener opo2_minus_ring; {
        opo2_minus_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge-1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OPO2(-)(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]P[O]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener opo2_minus_o; {
        opo2_minus_o = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge-1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OPO2(-)O-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]P[O]2[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener coopo3_minus2; {
        coopo3_minus2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge-2;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CO-OPO3(-2);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O][O]P[O]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener s_minus; {
        s_minus = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge-1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-S(-);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("S");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener sh; {
        sh = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-SH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("S[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener soh; {
        soh = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-S-OH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("S[O][H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener oso3_minus; {
        oso3_minus = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge-1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OSO3(-);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]S[O]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener s; {
        s = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-S-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("S");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener s_ring; {
        s_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-S-(ring);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("S");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener ss; {
        ss = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-S-S-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("SS");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener s_plus; {
        s_plus = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                charge = charge+1;
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-S<(+);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("S");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener cl_prim; {
        cl_prim = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Cl(prim.);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Cl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener cl_sec; {
        cl_sec = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Cl(sec.);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Cl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener cl_tert; {
        cl_tert = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Cl(tert.);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Cl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener cl2_prim; {
        cl2_prim = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Cl(prim.+1Cl);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Cl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener cl2_sec; {
        cl2_sec = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Cl(sec.+1Cl);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Cl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener cl3_prim; {
        cl3_prim = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Cl(prim.+2Cl);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Cl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener br_ar; {
        br_ar = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Br(arom.);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Br");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener i_ar; {
        i_ar = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-I(arom.);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("I");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener f_ar; {
        f_ar = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-F(arom.);1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("F");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener hetero; {
        hetero = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("heteroarom_rings;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener three_ring; {
        three_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("3member_rings;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener hydrocarbon; {
        hydrocarbon = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("hydrocarbon;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener conh; {
        conh = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("amide;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener cos; {
        cos = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("thioester;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener viccl; {
        viccl = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("vicinal_Cl;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener conj_occc; {
        conj_occc = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("OCCC_conjugation;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener conj_occo; {
        conj_occo = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("OCCO_conjugation;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener conj_occn; {
        conj_occn = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("OCCN_conjugation;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener conj_cccn; {
        conj_cccn = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("CCCN_conjugation;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    private View.OnClickListener conj_cccc; {
        conj_cccc = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM1-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("CCCC_conjugation;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String GCM1Formula0 = exec("cat "+getFilesDir()+"/gcm1formula.txt");
                if (charge==0){
                    String GCM1Formula = GCM1Formula0;
                    formula_view(GCM1Formula);
                } else if (charge==1){
                    String GCM1Formula = GCM1Formula0+"+";
                    formula_view(GCM1Formula);
                } else if (charge==-1){
                    String GCM1Formula = GCM1Formula0+"-";
                    formula_view(GCM1Formula);
                } else if (charge>1){
                    String GCM1Formula = GCM1Formula0+"+"+charge;
                    formula_view(GCM1Formula);
                } else if (charge<-1){
                    String GCM1Formula = GCM1Formula0+charge;
                    formula_view(GCM1Formula);
                }
                input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
            }
        };
    }

    // missing: >N-(ring),
    // OCNC_conjugation,
    // NCCN_conjugation,
    // CCNC_conjugation

    private View.OnClickListener click_next_structure; {
        click_next_structure = new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    if (charge==0){
                        outputWriter2.write("");
                    } else if (charge==1){
                        outputWriter2.write("+");
                    } else if (charge==-1){
                        outputWriter2.write("-");
                    } else if (charge>1){
                        outputWriter2.write("+"+charge);
                    } else if (charge<-1){
                        outputWriter2.write(""+charge); // here must be sth before charge (""), otherwise there will be printed a not recognizable character
                    }
                    outputWriter2.close();

                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM1.b "+getFilesDir()+"/GCM1.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/GCM1.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM1.b");

                    onResume();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
    }

    public void input_view(final String input_str) {
        Runnable method_proc = new Runnable() {
            public void run() {
                input_content.setText(colorized_numbers(input_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(method_proc);
    }

    public void iupac_view(final String iupac_str) {
        Runnable iupac_proc = new Runnable() {
            public void run() {
                iupac.setText(colorized_numbers(iupac_str), EditText.BufferType.SPANNABLE);
            }
        };
        handler.post(iupac_proc);
    }

    public void formula_view(final String formula_str) {
        Runnable formula_proc = new Runnable() {
            public void run() {
                formula.setText(formula_str);
            }
        };
        handler.post(formula_proc);
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

    private View.OnClickListener click_exit; {
        click_exit = new View.OnClickListener() {
            public void onClick(View v) {

                String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");

                progressDialog = new ProgressDialog(GCM1.this);
                progressDialog.setTitle("Please wait...");
                progressDialog.setMessage("Performing empirical calculations on species contained in dataset: "+DatasetName);
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

                        try {
                            FileOutputStream fileout2 = openFileOutput("gcm1formula.txt", MODE_APPEND);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            if (charge==0){
                                outputWriter2.write("");
                            } else if (charge==1){
                                outputWriter2.write("+");
                            } else if (charge==-1){
                                outputWriter2.write("-");
                            } else if (charge>1){
                                outputWriter2.write("+"+charge);
                            } else if (charge<-1){
                                outputWriter2.write(""+charge); // here must be sth before charge (""), otherwise there will be printed a not recognizable character
                            }
                            outputWriter2.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM1.b "+getFilesDir()+"/GCM1.bas");
                            exec("chmod -R 755 "+getFilesDir()+"/GCM1.b");
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM1.b");

////////// process results ///////////////
                        exec("cp "+getFilesDir()+"/GCM1.out "+getFilesDir()+"/GCM1/Thermochemistry_s.txt");
                        exec("cp "+getFilesDir()+"/GCM1.out "+getFilesDir()+"/openbabel/solv/"+DatasetName+"_thermochemistry_s.txt");

                        exec("chmod -R 755 "+getFilesDir());


                        exec("mv "+getFilesDir()+"/GCM1.out "+DatasetName+"_s.dat ");
                        exec("cp "+getFilesDir()+"/"+DatasetName+"_s.dat "+getFilesDir()+"/openbabel/solv");
                        exec("rm "+getFilesDir()+"/"+DatasetName+"_s.txt");

//for case of fall down - the same as in MainActivity.java in OnResume:
//                        exec("chmod 755 "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
//                        try {
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM1/DatabaseMakerGCM1.b "+getFilesDir()+"/GCM1/DatabaseMakerGCM1.bas");
                        exec("chmod -R 755 "+getFilesDir()+"/GCM1/DatabaseMakerGCM1.b");
                        exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM1/DatabaseMakerGCM1.b");
                        exec("chmod 755 "+getFilesDir()+"/GCM1/Database_s.dat");
//                exec("cp "+getFilesDir()+"/GCM1/Database_s.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_s.txt");
//                exec("rm "+getFilesDir()+"/GCM1/Database_s.dat");
                exec("rm "+getFilesDir()+"/GCM1.out");


                            String Raw_s = exec("cat "+getFilesDir()+"/GCM1/Database_s.dat");
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

                            exec("rm "+getFilesDir()+"/Database_s.dat");
                            exec("rm "+getFilesDir()+"/Database_s1.dat");
                            exec("rm "+getFilesDir()+"/Database_s3.dat");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

//                        } catch (Exception e) {
//                            Toast.makeText(GCM1.this, exec("cat "+getFilesDir()+"/GCM1/Database_s.dat"), Toast.LENGTH_SHORT).show();
//                            e.printStackTrace();
//                        }

//                        try {
//                            String Raw_s = exec("cat "+getFilesDir()+"/GCM1/Database_s.dat");
//                            while (Raw_s.contains("= + e- =")){  //2 spaces
//                                Raw_s = Raw_s.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
//                            }
//                            while (Raw_s.contains("=  + e- =")){  //2 spaces
//                                Raw_s = Raw_s.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
//                            }
//                            FileOutputStream fileout315 = openFileOutput("Database_s1.dat",MODE_PRIVATE);
//                            OutputStreamWriter outputWriter315 = new OutputStreamWriter(fileout315);
//                            outputWriter315.write(Raw_s);
//                            outputWriter315.close();
//
//                            String Raw_s2 = exec("cat "+getFilesDir()+"/Database_s1.dat");
//                            while (Raw_s2.contains("(g) ;  = ")){  //2 spaces
//                                Raw_s2 = Raw_s2.replace("(g) ;  = ", ""); //(2 spaces, 1 space)
//                            }
//                            FileOutputStream fileout415 = openFileOutput("Database_s2.dat",MODE_PRIVATE);
//                            OutputStreamWriter outputWriter415 = new OutputStreamWriter(fileout415);
//                            outputWriter415.write(Raw_s2);
//                            outputWriter415.close();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        convertData();
//                        String DatasetName0 = exec("cat "+getFilesDir()+"/dataset-name.txt");
		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");


                        exec("mv "+getFilesDir()+"/Database_s2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_s.txt");
                        exec("mv "+getFilesDir()+"/Database_s4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_s.txt");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/xyz "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/smiles "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/gas "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/solv "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/iupac "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/formula "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/damping_factor "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/kinetics "+getFilesDir()+File.separator+"output");
//                        exec("mv "+getFilesDir()+File.separator+"openbabel/tautomers "+getFilesDir()+File.separator+"output");
// end of repetiton



// this must be inside of ProgressDialog, otherwise the produced database will not be copied outside and the calculation ends unexpectedly
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
////            exec("chmod -R 755 "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/PSEUDOPHASES/DatabaseMakerPseudoPhases_solid_sol.b");
//            exec("chmod 755 "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.bas");
//            exec("chmod -R 755 "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
//            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/SOLUTION_SPECIES/DatabaseMakerSolutionPhase.b");
            Intent intent = new Intent(GCM1.this, ResumeActivity.class);
            startActivity(intent);
//            onResume();
        } catch (Exception e) {
        }
    }



    private View.OnClickListener click_quit; {
        click_quit = new View.OnClickListener() {
            public void onClick(View v) {
                try {
//                    exec("rm -rf "+getFilesDir()+File.separator+"openbabel");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                Intent intent = new Intent(GCM1.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


    @Override
    public void onResume()
    {
        super.onResume();
        charge = 0;
        exec("rm "+getFilesDir()+"/gcm1formula.txt");
        exec("touch "+getFilesDir()+"/gcm1formula.txt");
        exec("rm "+getFilesDir()+"/GCM1-input.txt");
        exec("touch "+getFilesDir()+"/GCM1-input.txt");
        input_view(exec("cat "+getFilesDir()+"/GCM1-input.txt"));
        iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
        formula_view(exec("cat "+getFilesDir()+"/gcm1formula.txt"));
    }



}

