package cz.p;

import static cz.p.Spannables.colorized_numbers;

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

public class GCM2 extends MainActivity {

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
    private TextView label1006;
    private TextView label1008;
    private ImageButton dummy2;
    private ImageButton dummy200;
    private ImageButton dummy201;
    private ImageButton dummy3;
    private ImageButton dummy4;
    private ImageButton dummy5;
    private ImageButton dummy11;
    private ImageButton dummy12;
    private ImageButton dummy13;
    private ImageButton gr_ch3;
    private ImageButton gr_ch2;
    private ImageButton gr_ch2_ring;
    private ImageButton gr_ch;
    private ImageButton gr_ch_ring;
    private ImageButton gr_c;
    private ImageButton gr_c_1ring;
    private ImageButton gr_ch_double;
    private ImageButton gr_c_double_any_ring;
    private ImageButton gr_c_double;
    private ImageButton gr_ch2_double;
    private ImageButton gr_ch_double_ring;
    private ImageButton gr_c_2double;
    private ImageButton gr_ch_triple;
    private ImageButton gr_c_triple;
    private ImageButton gr_oh_arom;
    private ImageButton gr_oh_aliph;
    private ImageButton gr_o;
    private ImageButton gr_o_ring;
    private ImageButton gr_co;
    private ImageButton gr_co_ring;
    private ImageButton gr_cho;
    private ImageButton gr_cooh;
    private ImageButton gr_oco;
    private ImageButton gr_o_double;
    private ImageButton gr_nh2;
    private ImageButton gr_n;
    private ImageButton gr_nh;
    private ImageButton gr_nh_ring;
    private ImageButton gr_nh_double;
    private ImageButton gr_n_double;
    private ImageButton gr_n_double_ring;
    private ImageButton gr_cn;
    private ImageButton gr_no2;
    private ImageButton dummy50;
    private ImageButton gr_sh;
    private ImageButton gr_s;
    private ImageButton gr_s_ring;
    private ImageButton gr_f;
    private ImageButton gr_cl;
    private ImageButton gr_br;
    private ImageButton gr_i;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gcm2);

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
        label1004 = (TextView) findViewById(R.id.label1004);
        label1006 = (TextView) findViewById(R.id.label1006);
        label1008 = (TextView) findViewById(R.id.label1008);
        dummy2 = (ImageButton) findViewById(R.id.dummy2);
        dummy3 = (ImageButton) findViewById(R.id.dummy3);
        dummy4 = (ImageButton) findViewById(R.id.dummy4);
        dummy50 = (ImageButton) findViewById(R.id.dummy50);
        dummy11 = (ImageButton) findViewById(R.id.dummy11);
        dummy12 = (ImageButton) findViewById(R.id.dummy12);
        dummy13 = (ImageButton) findViewById(R.id.dummy13);
        dummy200 = (ImageButton) findViewById(R.id.dummy200);
        dummy201 = (ImageButton) findViewById(R.id.dummy201);
        gr_ch3 = (ImageButton) findViewById(R.id.gr_ch3);
        gr_ch2 = (ImageButton) findViewById(R.id.gr_ch2);
        gr_ch2_ring = (ImageButton) findViewById(R.id.gr_ch2_ring);
        gr_ch = (ImageButton) findViewById(R.id.gr_ch);
        gr_ch_ring = (ImageButton) findViewById(R.id.gr_ch_ring);
        gr_c = (ImageButton) findViewById(R.id.gr_c);
        gr_c_1ring = (ImageButton) findViewById(R.id.gr_c_1ring);
        gr_ch_double = (ImageButton) findViewById(R.id.gr_ch_double);
        gr_c_double_any_ring = (ImageButton) findViewById(R.id.gr_c_double_any_ring);
        gr_c_double = (ImageButton) findViewById(R.id.gr_c_double);
        gr_ch2_double = (ImageButton) findViewById(R.id.gr_ch2_double);
        gr_ch_double_ring = (ImageButton) findViewById(R.id.gr_ch_double_ring);
        gr_c_2double = (ImageButton) findViewById(R.id.gr_c_2double);
        gr_ch_triple = (ImageButton) findViewById(R.id.gr_ch_triple);
        gr_c_triple = (ImageButton) findViewById(R.id.gr_c_triple);
        gr_oh_arom = (ImageButton) findViewById(R.id.gr_oh_arom);
        gr_oh_aliph = (ImageButton) findViewById(R.id.gr_oh_aliph);
        gr_o = (ImageButton) findViewById(R.id.gr_o);
        gr_o_ring = (ImageButton) findViewById(R.id.gr_o_ring);
        gr_co = (ImageButton) findViewById(R.id.gr_co);
        gr_co_ring = (ImageButton) findViewById(R.id.gr_co_ring);
        gr_cho = (ImageButton) findViewById(R.id.gr_cho);
        gr_cooh = (ImageButton) findViewById(R.id.gr_cooh);
        gr_oco = (ImageButton) findViewById(R.id.gr_oco);
        gr_o_double = (ImageButton) findViewById(R.id.gr_o_double);
        gr_nh2 = (ImageButton) findViewById(R.id.gr_nh2);
        gr_n = (ImageButton) findViewById(R.id.gr_n);
        gr_nh = (ImageButton) findViewById(R.id.gr_nh);
        gr_nh_ring = (ImageButton) findViewById(R.id.gr_nh_ring);
        gr_nh_double = (ImageButton) findViewById(R.id.gr_nh_double);
        gr_n_double = (ImageButton) findViewById(R.id.gr_n_double);
        gr_n_double_ring = (ImageButton) findViewById(R.id.gr_n_double_ring);
        gr_cn = (ImageButton) findViewById(R.id.gr_cn);
        gr_no2 = (ImageButton) findViewById(R.id.gr_no2);
        dummy50 = (ImageButton) findViewById(R.id.dummy50);
        gr_sh = (ImageButton) findViewById(R.id.gr_sh);
        gr_s = (ImageButton) findViewById(R.id.gr_s);
        gr_s_ring = (ImageButton) findViewById(R.id.gr_s_ring);
        gr_cl = (ImageButton) findViewById(R.id.gr_cl);
        gr_br = (ImageButton) findViewById(R.id.gr_br);
        gr_i = (ImageButton) findViewById(R.id.gr_i);
        gr_f = (ImageButton) findViewById(R.id.gr_f);

        next_structure.setOnClickListener(click_next_structure);
        exit.setOnClickListener(click_exit);
        quit.setOnClickListener(click_quit);
        reset.setOnClickListener(click_reset);
        gr_ch3.setOnClickListener(ch3);
        gr_ch2.setOnClickListener(ch2);
        gr_ch2_ring.setOnClickListener(ch2_ring);
        gr_ch.setOnClickListener(ch);
        gr_ch_ring.setOnClickListener(ch_ring);
        gr_c.setOnClickListener(c);
        gr_c_1ring.setOnClickListener(c_1ring);
        gr_ch_double.setOnClickListener(ch_double);
        gr_c_double_any_ring.setOnClickListener(c_double_any_ring);
        gr_c_double.setOnClickListener(c_double);
        gr_ch2_double.setOnClickListener(ch2_double);
        gr_ch_double_ring.setOnClickListener(ch_double_ring);
        gr_c_2double.setOnClickListener(c_2double);
        gr_ch_triple.setOnClickListener(ch_triple);
        gr_c_triple.setOnClickListener(c_triple);
        gr_oh_arom.setOnClickListener(oh_arom);
        gr_oh_aliph.setOnClickListener(oh_aliph);
        gr_o.setOnClickListener(o);
        gr_o_ring.setOnClickListener(o_ring);
        gr_co.setOnClickListener(co);
        gr_co_ring.setOnClickListener(co_ring);
        gr_cho.setOnClickListener(cho);
        gr_cooh.setOnClickListener(cooh);
        gr_oco.setOnClickListener(oco);
        gr_o_double.setOnClickListener(o_double);
        gr_nh2.setOnClickListener(nh2);
        gr_n.setOnClickListener(n);
        gr_nh.setOnClickListener(nh);
        gr_nh_ring.setOnClickListener(nh_ring);
        gr_nh_double.setOnClickListener(nh_double);
        gr_n_double.setOnClickListener(n_double);
        gr_n_double_ring.setOnClickListener(n_double_ring);
        gr_cn.setOnClickListener(cn);
        gr_no2.setOnClickListener(no2);
        gr_sh.setOnClickListener(sh);
        gr_s.setOnClickListener(s);
        gr_s_ring.setOnClickListener(s_ring);
        gr_cl.setOnClickListener(cl);
        gr_br.setOnClickListener(br);
        gr_i.setOnClickListener(i);
        gr_f.setOnClickListener(f);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        exec("rm "+getFilesDir()+"/gcm2formula.txt");
        exec("touch "+getFilesDir()+"/gcm2formula.txt");
        exec("rm "+getFilesDir()+"/GCM2-input.txt");
        exec("touch "+getFilesDir()+"/GCM2-input.txt");
        input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
        iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
        formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
    }

    private View.OnClickListener click_reset; {
        click_reset = new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    exec("rm "+getFilesDir()+"/gcm2formula.txt");
                    exec("touch "+getFilesDir()+"/gcm2formula.txt");
                    exec("rm "+getFilesDir()+"/GCM2-input.txt");
                    exec("touch "+getFilesDir()+"/GCM2-input.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CH3;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CH2-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CH2-_cycl.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CH<;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CH<_cycl.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C<;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">C<_cycl.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=CH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
            }
        };
    }

    private View.OnClickListener c_double_any_ring; {
        c_double_any_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=CH-_cycl.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=C<;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=CH2;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
            }
        };
    }

    private View.OnClickListener ch_double_ring; {
        ch_double_ring = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=CH-_cycl.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=C<_cycl.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("#CH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("#C-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
            }
        };
    }

    private View.OnClickListener oh_arom; {
        oh_arom = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OH_phen.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
            }
        };
    }

    private View.OnClickListener oh_aliph; {
        oh_aliph = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-OH_alc.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-O-_cycl.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">CO;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(">CO_cycl.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CHO;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-COOH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("C[O][O][H]");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-COO-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
            }
        };
    }

    private View.OnClickListener o_double; {
        o_double = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=O;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-NH2;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-N<;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-NH-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-NH-_cycl.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("=NH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-N=;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-N=_cycl.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-CN;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("CN");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-NO2;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write("N[O]2");
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("iupac.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(InputfileName);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-SH;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-S-;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-S-_cycl.;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
            }
        };
    }

    private View.OnClickListener cl; {
        cl = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Cl;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
            }
        };
    }

    private View.OnClickListener br; {
        br = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-Br;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
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
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-I;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
            }
        };
    }

    private View.OnClickListener f; {
        f = new View.OnClickListener() {
            public void onClick(View v) {
                String InputfileName0 = iupac.getText().toString();
                String InputfileName1 = InputfileName0.replace(" ","_");
		String InputfileName = InputfileName1.replace(",",".");
                try {
                    FileOutputStream fileout = openFileOutput("GCM2-input.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write("-F;1\n");
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("gcm2formula.txt", MODE_APPEND);
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
                input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
                iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
                formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
            }
        };
    }

    private View.OnClickListener click_next_structure; {
        click_next_structure = new View.OnClickListener() {
            public void onClick(View v) {

                try {

                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM2.b "+getFilesDir()+"/GCM2.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/GCM2.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM2.b");

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
                iupac.setText(iupac_str);
            }
        };
        handler.post(iupac_proc);
    }

    public void formula_view(final String formula_str) {
        Runnable formula_proc = new Runnable() {
            public void run() {
                formula.setText(colorized_numbers(formula_str), EditText.BufferType.SPANNABLE);
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

                progressDialog = new ProgressDialog(GCM2.this);
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
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM2.b "+getFilesDir()+"/GCM2.bas");
                            exec("chmod -R 755 "+getFilesDir()+"/GCM2.b");
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM2.b");

////////// process results ///////////////
                            exec("cp "+getFilesDir()+"/GCM2.out "+getFilesDir()+"/GCM2/Thermochemistry_g.txt");
                            exec("cp "+getFilesDir()+"/GCM2.out "+getFilesDir()+"/openbabel/gas/"+DatasetName+"_thermochemistry_g.txt");

                            exec("chmod -R 755 "+getFilesDir());


                            exec("mv "+getFilesDir()+"/GCM2.out "+DatasetName+"_g.dat ");
                            exec("cp "+getFilesDir()+"/"+DatasetName+"_g.dat "+getFilesDir()+"/openbabel/gas");
                            exec("rm "+getFilesDir()+"/"+DatasetName+"_g.txt");

//for case of fall down - the same as in MainActivity.java in OnResume:
//                        exec("chmod 755 "+getFilesDir()+"/PSEUDOPHASES/Database_solid_sol.dat");
//                        try {
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/GCM2/DatabaseMakerGCM2.b "+getFilesDir()+"/GCM2/DatabaseMakerGCM2.bas");
                            exec("chmod -R 755 "+getFilesDir()+"/GCM2/DatabaseMakerGCM2.b");
                            exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/GCM2/DatabaseMakerGCM2.b");
                            exec("chmod 755 "+getFilesDir()+"/GCM2/Database_g.dat");
//                exec("cp "+getFilesDir()+"/GCM2/Database_s.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_s.txt");
//                exec("rm "+getFilesDir()+"/GCM2/Database_s.dat");
                            exec("rm "+getFilesDir()+"/GCM2.out");


                            String Raw_g = exec("cat "+getFilesDir()+"/GCM2/Database_g.dat");
                            while (Raw_g.contains("= + e- =")){  //2 spaces
                                Raw_g = Raw_g.replace("= + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
			    while (Raw_g.contains("=  + e- =")){  //2 spaces
                                Raw_g = Raw_g.replace("=  + e- =", "+ e- ="); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout315 = openFileOutput("Database_g1.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter315 = new OutputStreamWriter(fileout315);
                            outputWriter315.write(Raw_g);
                            outputWriter315.close();

                            String Raw_g2 = exec("cat "+getFilesDir()+"/Database_g1.dat");
                            while (Raw_g2.contains("(g) ;  = ")){  //2 spaces
                                Raw_g2 = Raw_g2.replace("(g) ;  = ", ""); //(2 spaces, 1 space)
                            }
                            FileOutputStream fileout415 = openFileOutput("Database_g2.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter415 = new OutputStreamWriter(fileout415);
                            outputWriter415.write(Raw_g2);
                            outputWriter415.close();

                            /// new piece of code:
                            String Raw_g3 = exec("cat "+getFilesDir()+"/Database_g2.dat");
                            while (Raw_g3.contains("[H]")){
                                Raw_g3 = Raw_g3.replace("[H]", "H");
                            }
                            FileOutputStream fileout4155 = openFileOutput("Database_g3.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter4155 = new OutputStreamWriter(fileout4155);
                            outputWriter4155.write(Raw_g3);
                            outputWriter4155.close();

                            String Raw_g4 = exec("cat "+getFilesDir()+"/Database_g3.dat");
                            while (Raw_g4.contains("[O]")){
                                Raw_g4 = Raw_g4.replace("[O]", "O");
                            }
                            FileOutputStream fileout4156 = openFileOutput("Database_g4.dat",MODE_PRIVATE);
                            OutputStreamWriter outputWriter4156 = new OutputStreamWriter(fileout4156);
                            outputWriter4156.write(Raw_g4);
                            outputWriter4156.close();
                            ///

                            exec("rm "+getFilesDir()+"/Database_g.dat");
                            exec("rm "+getFilesDir()+"/Database_g1.dat");
                            exec("rm "+getFilesDir()+"/Database_g3.dat");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

//                        } catch (Exception e) {
//                            Toast.makeText(GCM2.this, exec("cat "+getFilesDir()+"/GCM2/Database_s.dat"), Toast.LENGTH_SHORT).show();
//                            e.printStackTrace();
//                        }

//                        try {
//                            String Raw_s = exec("cat "+getFilesDir()+"/GCM2/Database_s.dat");
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
                            String Fastchem_database_content = exec("cat "+getFilesDir()+"/GCM2/Fastchem_g.dat");

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
                        exec("rm "+getFilesDir()+"/GCM2/Fastchem_g.dat");
                        exec("mv "+getFilesDir()+"/Fastchem_g.tmp "+getFilesDir()+"/GCM2/Fastchem_g.dat");

		String DatasetName1 = DatasetName0.replace(" ","_");
		String DatasetName = DatasetName1.replace(",",".");


                        exec("mv "+getFilesDir()+"/Database_g2.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_anhydr_g.txt");
                        exec("mv "+getFilesDir()+"/Database_g4.dat "+getFilesDir()+File.separator+"output"+File.separator+"phreeqc_datasets"+File.separator+DatasetName+"_water_g.txt");
                        exec("mv "+getFilesDir()+"/GCM2/Fastchem_g.dat "+getFilesDir()+File.separator+"output"+File.separator+"fastchem_datasets"+File.separator+DatasetName+"_g.txt");

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
            Intent intent = new Intent(GCM2.this, ResumeActivity.class);
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
                Intent intent = new Intent(GCM2.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


    @Override
    public void onResume()
    {
        super.onResume();
        exec("rm "+getFilesDir()+"/gcm2formula.txt");
        exec("touch "+getFilesDir()+"/gcm2formula.txt");
        exec("rm "+getFilesDir()+"/GCM2-input.txt");
        exec("touch "+getFilesDir()+"/GCM2-input.txt");
        input_view(exec("cat "+getFilesDir()+"/GCM2-input.txt"));
        iupac_view(exec("cat "+getFilesDir()+"/iupac.txt"));
        formula_view(exec("cat "+getFilesDir()+"/gcm2formula.txt"));
    }



}

