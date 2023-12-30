package cz.p;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.text.Spannable;
import android.text.SpannableString;
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

public class GCM3 extends MainActivity {

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
    private ImageButton gr_ch3;
    private ImageButton gr_ch2;
    private ImageButton gr_ch;
    private ImageButton gr_c;
    private ImageButton gr_c5h9;
    private ImageButton gr_c6h11;
    private ImageButton gr_p_c6h10;
    private ImageButton dummy2;
    private ImageButton dummy216;
    private ImageButton dummy217;
    private TextView label1002;
    private ImageButton gr_ch_double;
    private ImageButton gr_ch2_double;
    private ImageButton gr_ch_double_arom_ring;
    private ImageButton gr_c_double_arom_ring;
    private ImageButton gr_ch_triple;
    private ImageButton gr_c_triple;
    private ImageButton gr_c_double_cis;
    private ImageButton gr_c_double_trans;
    private ImageButton gr_chch;
    private ImageButton gr_c_2double;
    private ImageButton gr_c6h5;
    private ImageButton gr_o_c6h4;
    private ImageButton gr_m_c6h4;
    private ImageButton gr_p_c6h4;
    private ImageButton gr_124_c6h3;
    private ImageButton gr_1235_c6h2;
    private ImageButton gr_25_c6h3ch3;
    private ImageButton gr_25_c6h2ch3ch3;
    private ImageButton gr_p_c6h4_ch2;
    private ImageButton gr_p_c6h4_ch;
    private ImageButton gr_p_c6h4_c;
    private ImageButton dummy218;
    private ImageButton dummy219;
    private ImageButton dummy220;
    private ImageButton dummy221;
    private TextView label1003;
    private ImageButton gr_cho;
    private ImageButton gr_cooh;
    private ImageButton gr_oh_prim;
    private ImageButton gr_oh_sec;
    private ImageButton gr_oh_tert;
    private ImageButton gr_och3;
    private ImageButton gr_coch3;
    private ImageButton gr_cooch3;
    private ImageButton gr_cooch2ch3;
    private ImageButton gr_ococh3;
    private ImageButton gr_ocooch3;
    private ImageButton gr_p_c6h4_oh;
    private ImageButton gr_o_aliph;
    private ImageButton gr_o_arom;
    private ImageButton gr_o_acetals;
    private ImageButton gr_och2o;
    private ImageButton gr_co_aliph;
    private ImageButton gr_co_arom;
    private ImageButton gr_coo_aliph;
    private ImageButton gr_coo_arom;
    private ImageButton gr_coo_conj;
    private ImageButton gr_ocoo;
    private ImageButton dummy213;
    private ImageButton dummy214;
    private ImageButton dummy215;
    private ImageButton gr_nh2;
    private ImageButton gr_no2;
    private ImageButton gr_cn;
    private ImageButton gr_p_c6h4_nh2;
    private ImageButton gr_conh;
    private ImageButton gr_oconh;
    private ImageButton gr_nh;
    private ImageButton gr_n;
    private ImageButton gr_n_ar;
    private ImageButton gr_p_c6h4_nh;
    private ImageButton gr_p_c6h4_n;
    private ImageButton gr_p_c6h4_conh;
    private ImageButton dummy206;
    private ImageButton dummy207;
    private ImageButton dummy208;
    private TextView label1006;
    private ImageButton gr_sh_prim;
    private ImageButton gr_sh_sec;
    private ImageButton gr_sh_tert;
    private ImageButton gr_so2;
    private ImageButton gr_s;
    private ImageButton gr_ss;
    private ImageButton dummy202;
    private ImageButton dummy203;
    private ImageButton dummy204;
    private ImageButton dummy205;
    private TextView label1008;
    private ImageButton gr_f_mono;
    private ImageButton gr_f_per;
    private ImageButton gr_cl_prim;
    private ImageButton gr_cl_sec;
    private ImageButton gr_cl_tert;
    private ImageButton gr_br_prim;
    private ImageButton gr_br_sec;
    private ImageButton gr_br_tert;
    private ImageButton gr_i;
    private ImageButton gr_chf;
    private ImageButton gr_cf2;
    private ImageButton gr_cfcl;
    private ImageButton gr_chcl;
    private ImageButton gr_ccl2;
    private ImageButton gr_chbr;
    private ImageButton gr_p_c6h4_cl;
    private ImageButton dummy209;
    private ImageButton dummy210;
    private ImageButton dummy211;
    private ImageButton dummy212;
    private TextView label1009;
    private ImageButton corr_3ring;
    private ImageButton corr_4ring;
    private ImageButton corr_5ring;
    private ImageButton corr_6ring;
    private ImageButton corr_conj_cccc;

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
        setContentView(R.layout.gcm3);

        iupac_label = (TextView) findViewById(R.id.iupac_label);
        iupac = (EditText) findViewById(R.id.iupac);
        iupac.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
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
        label1006 = (TextView) findViewById(R.id.label1006);
        label1008 = (TextView) findViewById(R.id.label1008);
        label1009 = (TextView) findViewById(R.id.label1009);
        dummy2 = (ImageButton) findViewById(R.id.dummy2);
        dummy202 = (ImageButton) findViewById(R.id.dummy202);
        dummy203 = (ImageButton) findViewById(R.id.dummy203);
        dummy204 = (ImageButton) findViewById(R.id.dummy204);
        dummy205 = (ImageButton) findViewById(R.id.dummy205);
        dummy206 = (ImageButton) findViewById(R.id.dummy206);
        dummy207 = (ImageButton) findViewById(R.id.dummy207);
        dummy208 = (ImageButton) findViewById(R.id.dummy208);
        dummy209 = (ImageButton) findViewById(R.id.dummy209);
        dummy210 = (ImageButton) findViewById(R.id.dummy210);
        dummy211 = (ImageButton) findViewById(R.id.dummy211);
        dummy212 = (ImageButton) findViewById(R.id.dummy212);
        dummy213 = (ImageButton) findViewById(R.id.dummy213);
        dummy214 = (ImageButton) findViewById(R.id.dummy214);
        dummy215 = (ImageButton) findViewById(R.id.dummy215);
        dummy216 = (ImageButton) findViewById(R.id.dummy216);
        dummy217 = (ImageButton) findViewById(R.id.dummy217);
        dummy218 = (ImageButton) findViewById(R.id.dummy218);
        dummy219 = (ImageButton) findViewById(R.id.dummy219);
        dummy220 = (ImageButton) findViewById(R.id.dummy220);
        dummy221 = (ImageButton) findViewById(R.id.dummy221);
        gr_ch3 = (ImageButton) findViewById(R.id.gr_ch3);
        gr_ch2 = (ImageButton) findViewById(R.id.gr_ch2);
        gr_ch = (ImageButton) findViewById(R.id.gr_ch);
        gr_c = (ImageButton) findViewById(R.id.gr_c);
        gr_c5h9 = (ImageButton) findViewById(R.id.gr_c5h9);
        gr_c6h11 = (ImageButton) findViewById(R.id.gr_c6h11);
        gr_p_c6h10 = (ImageButton) findViewById(R.id.gr_p_c6h10);
        gr_ch_double = (ImageButton) findViewById(R.id.gr_ch_double);
        gr_ch2_double = (ImageButton) findViewById(R.id.gr_ch2_double);
        gr_ch_double_arom_ring = (ImageButton) findViewById(R.id.gr_ch_double_arom_ring);
        gr_c_double_arom_ring = (ImageButton) findViewById(R.id.gr_c_double_arom_ring);
        gr_ch_triple = (ImageButton) findViewById(R.id.gr_ch_triple);
        gr_c_triple = (ImageButton) findViewById(R.id.gr_c_triple);
        gr_c_double_cis = (ImageButton) findViewById(R.id.gr_c_double_cis);
        gr_c_double_trans = (ImageButton) findViewById(R.id.gr_c_double_trans);
        gr_chch = (ImageButton) findViewById(R.id.gr_chch);
        gr_c_2double = (ImageButton) findViewById(R.id.gr_c_2double);
        gr_c6h5 = (ImageButton) findViewById(R.id.gr_c6h5);
        gr_o_c6h4 = (ImageButton) findViewById(R.id.gr_o_c6h4);
        gr_m_c6h4 = (ImageButton) findViewById(R.id.gr_m_c6h4);
        gr_p_c6h4 = (ImageButton) findViewById(R.id.gr_p_c6h4);
        gr_124_c6h3 = (ImageButton) findViewById(R.id.gr_124_c6h3);
        gr_1235_c6h2 = (ImageButton) findViewById(R.id.gr_1235_c6h2);
        gr_25_c6h3ch3 = (ImageButton) findViewById(R.id.gr_25_c6h3ch3);
        gr_25_c6h2ch3ch3 = (ImageButton) findViewById(R.id.gr_25_c6h2ch3ch3);
        gr_p_c6h4_ch2 = (ImageButton) findViewById(R.id.gr_p_c6h4_ch2);
        gr_p_c6h4_ch = (ImageButton) findViewById(R.id.gr_p_c6h4_ch);
        gr_p_c6h4_c = (ImageButton) findViewById(R.id.gr_p_c6h4_c);
        gr_cho = (ImageButton) findViewById(R.id.gr_cho);
        gr_cooh = (ImageButton) findViewById(R.id.gr_cooh);
        gr_oh_prim = (ImageButton) findViewById(R.id.gr_oh_prim);
        gr_oh_sec = (ImageButton) findViewById(R.id.gr_oh_sec);
        gr_oh_tert = (ImageButton) findViewById(R.id.gr_oh_tert);
        gr_och3 = (ImageButton) findViewById(R.id.gr_och3);
        gr_coch3 = (ImageButton) findViewById(R.id.gr_coch3);
        gr_cooch3 = (ImageButton) findViewById(R.id.gr_cooch3);
        gr_cooch2ch3 = (ImageButton) findViewById(R.id.gr_cooch2ch3);
        gr_ococh3 = (ImageButton) findViewById(R.id.gr_ococh3);
        gr_ocooch3 = (ImageButton) findViewById(R.id.gr_ocooch3);
        gr_p_c6h4_oh = (ImageButton) findViewById(R.id.gr_p_c6h4_oh);
        gr_o_aliph = (ImageButton) findViewById(R.id.gr_o_aliph);
        gr_o_arom = (ImageButton) findViewById(R.id.gr_o_arom);
        gr_o_acetals = (ImageButton) findViewById(R.id.gr_o_acetals);
        gr_och2o = (ImageButton) findViewById(R.id.gr_och2o);
        gr_co_aliph = (ImageButton) findViewById(R.id.gr_co_aliph);
        gr_co_arom = (ImageButton) findViewById(R.id.gr_co_arom);
        gr_coo_aliph = (ImageButton) findViewById(R.id.gr_coo_aliph);
        gr_coo_arom = (ImageButton) findViewById(R.id.gr_coo_arom);
        gr_coo_conj = (ImageButton) findViewById(R.id.gr_coo_conj);
        gr_ocoo = (ImageButton) findViewById(R.id.gr_ocoo);
        gr_nh2 = (ImageButton) findViewById(R.id.gr_nh2);
        gr_no2 = (ImageButton) findViewById(R.id.gr_no2);
        gr_cn = (ImageButton) findViewById(R.id.gr_cn);
        gr_p_c6h4_nh2 = (ImageButton) findViewById(R.id.gr_p_c6h4_nh2);
        gr_conh = (ImageButton) findViewById(R.id.gr_conh);
        gr_oconh = (ImageButton) findViewById(R.id.gr_oconh);
        gr_nh = (ImageButton) findViewById(R.id.gr_nh);
        gr_n = (ImageButton) findViewById(R.id.gr_n);
        gr_n_ar = (ImageButton) findViewById(R.id.gr_n_ar);
        gr_p_c6h4_nh = (ImageButton) findViewById(R.id.gr_p_c6h4_nh);
        gr_p_c6h4_n = (ImageButton) findViewById(R.id.gr_p_c6h4_n);
        gr_p_c6h4_conh = (ImageButton) findViewById(R.id.gr_p_c6h4_conh);
        gr_sh_prim = (ImageButton) findViewById(R.id.gr_sh_prim);
        gr_sh_sec = (ImageButton) findViewById(R.id.gr_sh_sec);
        gr_sh_tert = (ImageButton) findViewById(R.id.gr_sh_tert);
        gr_so2 = (ImageButton) findViewById(R.id.gr_so2);
        gr_s = (ImageButton) findViewById(R.id.gr_s);
        gr_ss = (ImageButton) findViewById(R.id.gr_ss);
        gr_f_mono = (ImageButton) findViewById(R.id.gr_f_mono);
        gr_f_per = (ImageButton) findViewById(R.id.gr_f_per);
        gr_cl_prim = (ImageButton) findViewById(R.id.gr_cl_prim);
        gr_cl_sec = (ImageButton) findViewById(R.id.gr_cl_sec);
        gr_cl_tert = (ImageButton) findViewById(R.id.gr_cl_tert);
        gr_br_prim = (ImageButton) findViewById(R.id.gr_br_prim);
        gr_br_sec = (ImageButton) findViewById(R.id.gr_br_sec);
        gr_br_tert = (ImageButton) findViewById(R.id.gr_br_tert);
        gr_i = (ImageButton) findViewById(R.id.gr_i);
        gr_chf = (ImageButton) findViewById(R.id.gr_chf);
        gr_cf2 = (ImageButton) findViewById(R.id.gr_cf2);
        gr_cfcl = (ImageButton) findViewById(R.id.gr_cfcl);
        gr_chcl = (ImageButton) findViewById(R.id.gr_chcl);
        gr_ccl2 = (ImageButton) findViewById(R.id.gr_ccl2);
        gr_chbr = (ImageButton) findViewById(R.id.gr_chbr);
        gr_p_c6h4_cl = (ImageButton) findViewById(R.id.gr_p_c6h4_cl);
        corr_3ring = (ImageButton) findViewById(R.id.corr_3ring);
        corr_4ring = (ImageButton) findViewById(R.id.corr_4ring);
        corr_5ring = (ImageButton) findViewById(R.id.corr_5ring);
        corr_6ring = (ImageButton) findViewById(R.id.corr_6ring);
        corr_conj_cccc = (ImageButton) findViewById(R.id.corr_conj_cccc);

        next_structure.setOnClickListener(click_next_structure);
        exit.setOnClickListener(click_exit);
        quit.setOnClickListener(click_quit);
        reset.setOnClickListener(click_reset);
        gr_ch3.setOnClickListener(ch3);
        gr_ch2.setOnClickListener(ch2);
        gr_ch.setOnClickListener(ch);
        gr_c.setOnClickListener(c);
        gr_c5h9.setOnClickListener(c5h9);
        gr_c6h11.setOnClickListener(c6h11);
        gr_p_c6h10.setOnClickListener(p_c6h10);
        gr_ch_double.setOnClickListener(ch_double);
        gr_ch2_double.setOnClickListener(ch2_double);
        gr_ch_double_arom_ring.setOnClickListener(ch_double_arom_ring);
        gr_c_double_arom_ring.setOnClickListener(c_double_arom_ring);
        gr_ch_triple.setOnClickListener(ch_triple);
        gr_c_triple.setOnClickListener(c_triple);
        gr_c_double_cis.setOnClickListener(c_double_cis);
        gr_c_double_trans.setOnClickListener(c_double_trans);
        gr_chch.setOnClickListener(chch);
        gr_c_2double.setOnClickListener(c_2double);
        gr_c6h5.setOnClickListener(c6h5);
        gr_o_c6h4.setOnClickListener(o_c6h4);
        gr_m_c6h4.setOnClickListener(m_c6h4);
        gr_p_c6h4.setOnClickListener(p_c6h4);
        gr_124_c6h3.setOnClickListener(_124_c6h3);
        gr_1235_c6h2.setOnClickListener(_1235_c6h2);
        gr_25_c6h3ch3.setOnClickListener(_25_c6h3ch3);
        gr_25_c6h2ch3ch3.setOnClickListener(_25_c6h2ch3ch3);
        gr_p_c6h4_ch2.setOnClickListener(p_c6h4_ch2);
        gr_p_c6h4_ch.setOnClickListener(p_c6h4_ch);
        gr_p_c6h4_c.setOnClickListener(p_c6h4_c);
        gr_cho.setOnClickListener(cho);
        gr_cooh.setOnClickListener(cooh);
        gr_oh_prim.setOnClickListener(oh_prim);
        gr_oh_sec.setOnClickListener(oh_sec);
        gr_oh_tert.setOnClickListener(oh_tert);
        gr_och3.setOnClickListener(och3);
        gr_coch3.setOnClickListener(coch3);
        gr_cooch3.setOnClickListener(cooch3);
        gr_cooch2ch3.setOnClickListener(cooch2ch3);
        gr_ococh3.setOnClickListener(ococh3);
        gr_ocooch3.setOnClickListener(ocooch3);
        gr_p_c6h4_oh.setOnClickListener(p_c6h4_oh);
        gr_o_aliph.setOnClickListener(o_aliph);
        gr_o_arom.setOnClickListener(o_arom);
        gr_o_acetals.setOnClickListener(o_acetals);
        gr_och2o.setOnClickListener(och2o);
        gr_co_aliph.setOnClickListener(co_aliph);
        gr_co_arom.setOnClickListener(co_arom);
        gr_coo_aliph.setOnClickListener(coo_aliph);
        gr_coo_arom.setOnClickListener(coo_arom);
        gr_coo_conj.setOnClickListener(coo_conj);
        gr_ocoo.setOnClickListener(ocoo);
        gr_nh2.setOnClickListener(nh2);
        gr_no2.setOnClickListener(no2);
        gr_cn.setOnClickListener(cn);
        gr_p_c6h4_nh2.setOnClickListener(p_c6h4_nh2);
        gr_conh.setOnClickListener(conh);
        gr_oconh.setOnClickListener(oconh);
        gr_nh.setOnClickListener(nh);
        gr_n.setOnClickListener(n);
        gr_n_ar.setOnClickListener(n_ar);
        gr_p_c6h4_nh.setOnClickListener(p_c6h4_nh);
        gr_p_c6h4_n.setOnClickListener(p_c6h4_n);
        gr_p_c6h4_conh.setOnClickListener(p_c6h4_conh);
        gr_sh_prim.setOnClickListener(sh_prim);
        gr_sh_sec.setOnClickListener(sh_sec);
        gr_sh_tert.setOnClickListener(sh_tert);
        gr_so2.setOnClickListener(so2);
        gr_s.setOnClickListener(s);
        gr_ss.setOnClickListener(ss);
        gr_f_mono.setOnClickListener(f_mono);
        gr_f_per.setOnClickListener(f_per);
        gr_cl_prim.setOnClickListener(cl_prim);
        gr_cl_sec.setOnClickListener(cl_sec);
        gr_cl_tert.setOnClickListener(cl_tert);
        gr_br_prim.setOnClickListener(br_prim);
        gr_br_sec.setOnClickListener(br_sec);
        gr_br_tert.setOnClickListener(br_tert);
        gr_i.setOnClickListener(i);
        gr_chf.setOnClickListener(chf);
        gr_cf2.setOnClickListener(cf2);
        gr_cfcl.setOnClickListener(cfcl);
        gr_chcl.setOnClickListener(chcl);
        gr_ccl2.setOnClickListener(ccl2);
        gr_chbr.setOnClickListener(chbr);
        gr_p_c6h4_cl.setOnClickListener(p_c6h4_cl);
        corr_3ring.setOnClickListener(three_ring);
        corr_4ring.setOnClickListener(four_ring);
        corr_5ring.setOnClickListener(five_ring);
        corr_6ring.setOnClickListener(six_ring);
        corr_conj_cccc.setOnClickListener(conj_cccc);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        exec("rm "+getFilesDir()+"/gcm3formula.txt");
        exec("touch "+getFilesDir()+"/gcm3formula.txt");
        exec("rm "+getFilesDir()+"/GCM3-input.txt");
        exec("touch "+getFilesDir()+"/GCM3-input.txt");
        input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
        iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
        formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
    }

    private View.OnClickListener click_reset; {
        click_reset = new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    exec("rm "+getFilesDir()+"/gcm3formula.txt");
                    exec("touch "+getFilesDir()+"/gcm3formula.txt");
                    exec("rm "+getFilesDir()+"/GCM3-input.txt");
                    exec("touch "+getFilesDir()+"/GCM3-input.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CH3;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CH2-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CH<;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C<;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener c5h9; {
        c5h9 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-cyclo-C5H9;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C5[H]9");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener c6h11; {
        c6h11 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-cyclo-C6H11;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]11");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener p_c6h10; {
        p_c6h10 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H10-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]10");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=CH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=CH2;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=CH-_arom.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=C<_arom.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("#CH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("#C-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener c_double_cis; {
        c_double_cis = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=C<_cis;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener c_double_trans; {
        c_double_trans = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=C<_trans;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener chch; {
        chch = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CH=CH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener c_2double; {
        c_2double = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=C=;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener c6h5; {
        c6h5 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-C6H5;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]5");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener o_c6h4; {
        o_c6h4 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-o-C6H4-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener m_c6h4; {
        m_c6h4 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-m-C6H4-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener p_c6h4; {
        p_c6h4 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H4-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener _124_c6h3; {
        _124_c6h3 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-o.p-C6H3-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener _1235_c6h2; {
        _1235_c6h2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-o.o.p-C6H2-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener _25_c6h3ch3; {
        _25_c6h3ch3 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H3CH3-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]3C[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener _25_c6h2ch3ch3; {
        _25_c6h2ch3ch3 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-o.o-(CH3)2C6H2-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]3C6[H]2C[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener p_c6h4_ch2; {
        p_c6h4_ch2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H4-CH2-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4C[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener p_c6h4_ch; {
        p_c6h4_ch = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H4-CH<;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4C[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener p_c6h4_c; {
        p_c6h4_c = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H4-C%;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4C");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CH=O;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H][O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener cooh; {
        cooh = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-COOH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O][O][H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener oh_prim; {
        oh_prim = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OH_prim.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O][H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener oh_sec; {
        oh_sec = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OH_sec.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O][H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener oh_tert; {
        oh_tert = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OH_tert.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O][H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener och3; {
        och3 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-CH3;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]C[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener coch3; {
        coch3 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CO-CH3;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O]C[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener cooch3; {
        cooch3 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-COO-CH3;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O][O]C[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener cooch2ch3; {
        cooch2ch3 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-COO-CH2CH3;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O][O]C[H]2C[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener ococh3; {
        ococh3 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-CO-CH3;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]C[O]C[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener ocooch3; {
        ocooch3 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-CO-O-CH3;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]C[O][O]C[H]3");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener p_c6h4_oh; {
        p_c6h4_oh = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H4-OH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4[O][H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener o_aliph; {
        o_aliph = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-_aliph.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener o_arom; {
        o_arom = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-_arom.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener o_acetals; {
        o_acetals = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-_acetals;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener och2o; {
        och2o = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-CH2-O-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]C[H]2[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener co_aliph; {
        co_aliph = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CO-_aliph.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener co_arom; {
        co_arom = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CO-_arom.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener coo_aliph; {
        coo_aliph = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-COO-_aliph.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O][O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener coo_arom; {
        coo_arom = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-COO-_arom.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O][O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener coo_conj; {
        coo_conj = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-COO-_C=C;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O][O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener ocoo; {
        ocoo = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-CO-O-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]C[O][O]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-NH2;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener no2; {
        no2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-NO2;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[O]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener cn; {
        cn = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CN;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("CN");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener p_c6h4_nh2; {
        p_c6h4_nh2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H4-NH2;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4N[H]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CO-NH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O]N[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener oconh; {
        oconh = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-CO-NH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("[O]C[O]N[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-NH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-N<;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener n_ar; {
        n_ar = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=N-_arom.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener p_c6h4_nh; {
        p_c6h4_nh = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H4-NH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4N[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener p_c6h4_n; {
        p_c6h4_n = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H4-N<;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4N");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener p_c6h4_conh; {
        p_c6h4_conh = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H4-CO-NH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4C[O]N[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener sh_prim; {
        sh_prim = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-SH_prim.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("S[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener sh_sec; {
        sh_sec = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-SH_sec.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("S[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener sh_tert; {
        sh_tert = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-SH_tert.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("S[H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener so2; {
        so2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-SO2-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("S[O]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-S-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("S");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-S-S-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("SS");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener f_mono; {
        f_mono = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-F_mono;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("F");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener f_per; {
        f_per = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-F_per;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("F");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Cl_prim.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Cl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Cl_sec.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Cl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Cl_tert.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Cl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener br_prim; {
        br_prim = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Br_prim.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Br");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener br_sec; {
        br_sec = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Br_sec.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Br");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener br_tert; {
        br_tert = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Br_tert.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("Br");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener i; {
        i = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-I;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("I");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener chf; {
        chf = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CHF-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]F");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener cf2; {
        cf2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CF2-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("CF2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener cfcl; {
        cfcl = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CFCl-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("CFCl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener chcl; {
        chcl = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CHCl-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]Cl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener ccl2; {
        ccl2 = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CCl2-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("CCl2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener chbr; {
        chbr = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CHBr-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[H]Br");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener p_c6h4_cl; {
        p_c6h4_cl = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-p-C6H4-Cl;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C6[H]4Cl");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("3ring;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener four_ring; {
        four_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("4ring;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener five_ring; {
        five_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("5ring;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }

    private View.OnClickListener six_ring; {
        six_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("6ring;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM3-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("conjug.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm3formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac-polymer.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
            }
        };
    }



    private View.OnClickListener click_next_structure; {
        click_next_structure = new View.OnClickListener() {
            public void onClick(View v) {

                try {

                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM3.b "+getFilesDir()+"/GCM3.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/GCM3.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM3.b");

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
                input_content.setText(colorized(input_str,"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
            }
        };
        handler.post(method_proc);
    }

    public void iupac_view(final String iupac_str) {
        Runnable iupac_proc = new Runnable() {
            public void run() {
                iupac.setText(iupac_str);
            }
        };
        handler.post(iupac_proc);
    }

    public void formula_view(final String formula_str) {
        Runnable formula_proc = new Runnable() {
            public void run() {
                formula.setText(colorized(formula_str, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
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

                progressDialog = new ProgressDialog(GCM3.this);
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
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM3.b "+getFilesDir()+"/GCM3.bas");
                            exec("chmod -R 755 "+getFilesDir()+"/GCM3.b");
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM3.b");

////////// process results ///////////////
                            exec("cp "+getFilesDir()+"/GCM3_c.out "+getFilesDir()+"/GCM3/Thermochemistry_c.txt");
                            exec("cp "+getFilesDir()+"/GCM3_c.out "+getFilesDir()+"/openbabel/cryst/"+DatasetName+"_thermochemistry_c.txt");
                            exec("chmod -R 755 "+getFilesDir());
                            exec("mv "+getFilesDir()+"/GCM3_c.out "+DatasetName+"_c.dat ");
                            exec("cp "+getFilesDir()+"/"+DatasetName+"_c.dat "+getFilesDir()+"/openbabel/cryst");
                            exec("rm "+getFilesDir()+"/"+DatasetName+"_c.txt");
//for case of fall down - the same as in MainActivity.java in OnResume:
//                        exec("chmod 755 "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
//                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_c.b "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_c.bas");
                            exec("chmod -R 755 "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_c.b");
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_c.b");
                            exec("chmod 755 "+getFilesDir()+"/GCM3/Database_c.dat");
//                exec("cp "+getFilesDir()+"/GCM3/Database_s.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_s.txt");
//                exec("rm "+getFilesDir()+"/GCM3/Database_s.dat");
                            exec("rm "+getFilesDir()+"/GCM3_c.out");


                            String Raw_c = exec("cat "+getFilesDir()+"/GCM3/Database_c.dat");
                            while (Raw_c.contains("= + e- =")){  //2 spaces
                                Raw_c = Raw_c.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
			    while (Raw_c.contains("=  + e- =")){  //2 spaces
                                Raw_c = Raw_c.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout315 = openFileOutput("Database_c1.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter315 = new OutputStreamWriter(fileout315);
                            outputWriter315.write(Raw_c);
                            outputWriter315.close();

                            String Raw_c2 = exec("cat "+getFilesDir()+"/Database_c1.dat");
                            while (Raw_c2.contains("(c) ;  = ")){  //2 spaces
                                Raw_c2 = Raw_c2.replace("(c) ;  = ", ""); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout415 = openFileOutput("Database_c2.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter415 = new OutputStreamWriter(fileout415);
                            outputWriter415.write(Raw_c2);
                            outputWriter415.close();

                            /// new piece of code:
                            String Raw_c3 = exec("cat "+getFilesDir()+"/Database_c2.dat");
                            while (Raw_c3.contains("[H]")){
                                Raw_c3 = Raw_c3.replace("[H]", "H");
                            }
                            FileOutputStream fileout4155 = openFileOutput("Database_c3.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter4155 = new OutputStreamWriter(fileout4155);
                            outputWriter4155.write(Raw_c3);
                            outputWriter4155.close();

                            String Raw_c4 = exec("cat "+getFilesDir()+"/Database_c3.dat");
                            while (Raw_c4.contains("[O]")){
                                Raw_c4 = Raw_c4.replace("[O]", "O");
                            }
                            FileOutputStream fileout4156 = openFileOutput("Database_c4.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter4156 = new OutputStreamWriter(fileout4156);
                            outputWriter4156.write(Raw_c4);
                            outputWriter4156.close();
                            ///

                            exec("rm "+getFilesDir()+"/Database_c.dat");
                            exec("rm "+getFilesDir()+"/Database_c1.dat");
                            exec("rm "+getFilesDir()+"/Database_c3.dat");



















                            exec("cp "+getFilesDir()+"/GCM3_l.out "+getFilesDir()+"/GCM3/Thermochemistry_l.txt");
                            exec("cp "+getFilesDir()+"/GCM3_l.out "+getFilesDir()+"/openbabel/liq/"+DatasetName+"_thermochemistry_l.txt");
                            exec("chmod -R 755 "+getFilesDir());
                            exec("mv "+getFilesDir()+"/GCM3_l.out "+DatasetName+"_l.dat ");
                            exec("cp "+getFilesDir()+"/"+DatasetName+"_l.dat "+getFilesDir()+"/openbabel/liq");
                            exec("rm "+getFilesDir()+"/"+DatasetName+"_l.txt");
//for case of fall down - the same as in MainActivity.java in OnResume:
//                        exec("chmod 755 "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
//                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_l.b "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_l.bas");
                            exec("chmod -R 755 "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_l.b");
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_l.b");
                            exec("chmod 755 "+getFilesDir()+"/GCM3/Database_l.dat");
//                exec("cp "+getFilesDir()+"/GCM3/Database_s.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_s.txt");
//                exec("rm "+getFilesDir()+"/GCM3/Database_s.dat");
                            exec("rm "+getFilesDir()+"/GCM3_l.out");


                            String Raw_l = exec("cat "+getFilesDir()+"/GCM3/Database_l.dat");
                            while (Raw_l.contains("= + e- =")){  //2 spaces
                                Raw_l = Raw_l.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
			    while (Raw_l.contains("=  + e- =")){  //2 spaces
                                Raw_l = Raw_l.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout315l = openFileOutput("Database_l1.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter315l = new OutputStreamWriter(fileout315l);
                            outputWriter315l.write(Raw_l);
                            outputWriter315l.close();

                            String Raw_l2 = exec("cat "+getFilesDir()+"/Database_l1.dat");
                            while (Raw_l2.contains("(l) ;  = ")){  //2 spaces
                                Raw_l2 = Raw_l2.replace("(l) ;  = ", ""); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout415l = openFileOutput("Database_l2.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter415l = new OutputStreamWriter(fileout415l);
                            outputWriter415l.write(Raw_l2);
                            outputWriter415l.close();

                            /// new piece of code:
                            String Raw_l3 = exec("cat "+getFilesDir()+"/Database_l2.dat");
                            while (Raw_l3.contains("[H]")){
                                Raw_l3 = Raw_l3.replace("[H]", "H");
                            }
                            FileOutputStream fileout4155l = openFileOutput("Database_l3.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter4155l = new OutputStreamWriter(fileout4155l);
                            outputWriter4155l.write(Raw_l3);
                            outputWriter4155l.close();

                            String Raw_l4 = exec("cat "+getFilesDir()+"/Database_l3.dat");
                            while (Raw_l4.contains("[O]")){
                                Raw_l4 = Raw_l4.replace("[O]", "O");
                            }
                            FileOutputStream fileout4156l = openFileOutput("Database_l4.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter4156l = new OutputStreamWriter(fileout4156l);
                            outputWriter4156l.write(Raw_l4);
                            outputWriter4156l.close();
                            ///

                            exec("rm "+getFilesDir()+"/Database_l.dat");
                            exec("rm "+getFilesDir()+"/Database_l1.dat");
                            exec("rm "+getFilesDir()+"/Database_l3.dat");
























                            exec("cp "+getFilesDir()+"/GCM3_g.out "+getFilesDir()+"/GCM3/Thermochemistry_g.txt");
                            exec("cp "+getFilesDir()+"/GCM3_g.out "+getFilesDir()+"/openbabel/gas/"+DatasetName+"_thermochemistry_g.txt");
                            exec("chmod -R 755 "+getFilesDir());
                            exec("mv "+getFilesDir()+"/GCM3_g.out "+DatasetName+"_g.dat ");
                            exec("cp "+getFilesDir()+"/"+DatasetName+"_g.dat "+getFilesDir()+"/openbabel/gas");
                            exec("rm "+getFilesDir()+"/"+DatasetName+"_g.txt");
//for case of fall down - the same as in MainActivity.java in OnResume:
//                        exec("chmod 755 "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
//                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_g.b "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_g.bas");
                            exec("chmod -R 755 "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_g.b");
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM3/DatabaseMakerGCM3_g.b");
                            exec("chmod 755 "+getFilesDir()+"/GCM3/Database_g.dat");
//                exec("cp "+getFilesDir()+"/GCM3/Database_s.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_s.txt");
//                exec("rm "+getFilesDir()+"/GCM3/Database_s.dat");
                            exec("rm "+getFilesDir()+"/GCM3_g.out");


                            String Raw_g = exec("cat "+getFilesDir()+"/GCM3/Database_g.dat");
                            while (Raw_g.contains("= + e- =")){  //2 spaces
                                Raw_g = Raw_g.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
			    while (Raw_g.contains("=  + e- =")){  //2 spaces
                                Raw_g = Raw_g.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout315g = openFileOutput("Database_g1.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter315g = new OutputStreamWriter(fileout315g);
                            outputWriter315g.write(Raw_g);
                            outputWriter315g.close();

                            String Raw_g2 = exec("cat "+getFilesDir()+"/Database_g1.dat");
                            while (Raw_g2.contains("(g) ;  = ")){  //2 spaces
                                Raw_g2 = Raw_g2.replace("(g) ;  = ", ""); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout415g = openFileOutput("Database_g2.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter415g = new OutputStreamWriter(fileout415g);
                            outputWriter415g.write(Raw_g2);
                            outputWriter415g.close();

                            /// new piece of code:
                            String Raw_g3 = exec("cat "+getFilesDir()+"/Database_g2.dat");
                            while (Raw_g3.contains("[H]")){
                                Raw_g3 = Raw_g3.replace("[H]", "H");
                            }
                            FileOutputStream fileout4155g = openFileOutput("Database_g3.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter4155g = new OutputStreamWriter(fileout4155g);
                            outputWriter4155g.write(Raw_g3);
                            outputWriter4155g.close();

                            String Raw_g4 = exec("cat "+getFilesDir()+"/Database_g3.dat");
                            while (Raw_g4.contains("[O]")){
                                Raw_g4 = Raw_g4.replace("[O]", "O");
                            }
                            FileOutputStream fileout4156g = openFileOutput("Database_g4.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter4156g = new OutputStreamWriter(fileout4156g);
                            outputWriter4156g.write(Raw_g4);
                            outputWriter4156g.close();
                            ///

                            exec("rm "+getFilesDir()+"/Database_g.dat");
                            exec("rm "+getFilesDir()+"/Database_g1.dat");
                            exec("rm "+getFilesDir()+"/Database_g3.dat");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

//                        } catch (Exception e) {
//                            Toast.makeText(GCM3.this, exec("cat "+getFilesDir()+"/GCM3/Database_s.dat"), Toast.LENGTH_SHORT).show();
//                            e.printStackTrace();
//                        }

//                        try {
//                            String Raw_s = exec("cat "+getFilesDir()+"/GCM3/Database_s.dat");
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

                        try {
                            String Fastchem_database_content = exec("cat "+getFilesDir()+"/GCM3/Fastchem_g.dat");

                            Fastchem_database_content = Fastchem_database_content.replace("[H]", "H");
                            Fastchem_database_content = Fastchem_database_content.replace("[O]", "O");
                            Fastchem_database_content = Fastchem_database_content.replace("C", "C");
                            Fastchem_database_content = Fastchem_database_content.replace("N", "N");
                            Fastchem_database_content = Fastchem_database_content.replace("S", "S");
                            Fastchem_database_content = Fastchem_database_content.replace("F", "F");

                            FileOutputStream fileoutFCH = openFileOutput("Fastchem_g.tmp",MODE_PRIVATE);
                            OutputStreamWriter outputWriterFCH = new OutputStreamWriter(fileoutFCH);
                            outputWriterFCH.write(Fastchem_database_content);
                            outputWriterFCH.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("rm "+getFilesDir()+"/GCM3/Fastchem_g.dat");
                        exec("mv "+getFilesDir()+"/Fastchem_g.tmp "+getFilesDir()+"/GCM3/Fastchem_g.dat");

                        try {
                            String Fastchem_database_content = exec("cat "+getFilesDir()+"/GCM3/Fastchem_l.dat");

                            Fastchem_database_content = Fastchem_database_content.replace("[H]", "H");
                            Fastchem_database_content = Fastchem_database_content.replace("[O]", "O");
                            Fastchem_database_content = Fastchem_database_content.replace("C", "C");
                            Fastchem_database_content = Fastchem_database_content.replace("N", "N");
                            Fastchem_database_content = Fastchem_database_content.replace("S", "S");
                            Fastchem_database_content = Fastchem_database_content.replace("F", "F");

                            FileOutputStream fileoutFCH = openFileOutput("Fastchem_l.tmp",MODE_PRIVATE);
                            OutputStreamWriter outputWriterFCH = new OutputStreamWriter(fileoutFCH);
                            outputWriterFCH.write(Fastchem_database_content);
                            outputWriterFCH.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("rm "+getFilesDir()+"/GCM3/Fastchem_l.dat");
                        exec("mv "+getFilesDir()+"/Fastchem_l.tmp "+getFilesDir()+"/GCM3/Fastchem_l.dat");

                        try {
                            String Fastchem_database_content = exec("cat "+getFilesDir()+"/GCM3/Fastchem_c.dat");

                            Fastchem_database_content = Fastchem_database_content.replace("[H]", "H");
                            Fastchem_database_content = Fastchem_database_content.replace("[O]", "O");
                            Fastchem_database_content = Fastchem_database_content.replace("C", "C");
                            Fastchem_database_content = Fastchem_database_content.replace("N", "N");
                            Fastchem_database_content = Fastchem_database_content.replace("S", "S");
                            Fastchem_database_content = Fastchem_database_content.replace("F", "F");

                            FileOutputStream fileoutFCH = openFileOutput("Fastchem_c.tmp",MODE_PRIVATE);
                            OutputStreamWriter outputWriterFCH = new OutputStreamWriter(fileoutFCH);
                            outputWriterFCH.write(Fastchem_database_content);
                            outputWriterFCH.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("rm "+getFilesDir()+"/GCM3/Fastchem_c.dat");
                        exec("mv "+getFilesDir()+"/Fastchem_c.tmp "+getFilesDir()+"/GCM3/Fastchem_c.dat");


		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");


                        exec("mv "+getFilesDir()+"/Database_g2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_g.txt");
                        exec("mv "+getFilesDir()+"/Database_g4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_g.txt");
                        exec("mv "+getFilesDir()+"/Database_l2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_l.txt");
                        exec("mv "+getFilesDir()+"/Database_l4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_l.txt");
                        exec("mv "+getFilesDir()+"/Database_c2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_c.txt");
                        exec("mv "+getFilesDir()+"/Database_c4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_c.txt");
                        exec("mv "+getFilesDir()+"/GCM3/Fastchem_g.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+DatasetName+"_g.txt");
                        exec("mv "+getFilesDir()+"/GCM3/Fastchem_l.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+DatasetName+"_l.txt");
                        exec("mv "+getFilesDir()+"/GCM3/Fastchem_c.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+DatasetName+"_c.txt");
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
            Intent intent = new Intent(GCM3.this, ResumeActivity.class);
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
                Intent intent = new Intent(GCM3.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


    @Override
    public void onResume()
    {
        super.onResume();
        exec("rm "+getFilesDir()+"/gcm3formula.txt");
        exec("touch "+getFilesDir()+"/gcm3formula.txt");
        exec("rm "+getFilesDir()+"/GCM3-input.txt");
        exec("touch "+getFilesDir()+"/GCM3-input.txt");
        input_view(exec("cat "+getFilesDir()+"/GCM3-input.txt"));
        iupac_view(exec("cat "+getFilesDir()+"/iupac-polymer.txt"));
        formula_view(exec("cat "+getFilesDir()+"/gcm3formula.txt"));
    }



}

