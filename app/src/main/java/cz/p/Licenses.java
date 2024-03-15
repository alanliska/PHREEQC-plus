package cz.p;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Licenses extends MainActivity {
    TextView license_label;
    Button license0;
    Button license1;
    Button license2;
    Button license3;
    Button license4;
    Button license5;
    Button license6;
    Button license_6;
    Button license7;
    Button license8;
    Button license9;
    Button license10;
    Button license11;
//    Button license12;
//    Button license13;
//    Button license14;
    Button license15;
//    Button license16;
    Button licenseGV;
    Button license_arpack;
    Button license_dftb;
    Button license_sk;
    Button lt_dftb;
    Button lt_sk;
    Button opsin;
    Button android_shell;
//    Button license_busybox1;
//    Button license_busybox2;
//    Button license_busybox3;
    Button license1_dftd4;
    Button license2_dftd4;
    Button license_gbsa;
    Button license_mctc;
    Button license_mstore;
    Button license_multicharge;
    Button license1_plotms;
    Button license2_plotms;
    Button license_python;
    Button license1_qcxms;
    Button license2_qcxms;
    Button license1_sdftd3;
    Button license2_sdftd3;
    Button license1_stda;
    Button license2_stda;
    Button license1_tblite;
    Button license2_tblite;
    Button license1_testdrive;
    Button license2_testdrive;
    Button license1_tomlf;
    Button license2_tomlf;
    Button license1_xtb;
    Button license2_xtb;
    Button license1_xtb4stda;
    Button license2_xtb4stda;
    Button eigen3;
    Button eigen3_lt;
    Button license_cpcmx;
    Button license1_numsa;
    Button license2_numsa;
    Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.licenses);

        license_label = (TextView) findViewById(R.id.license_label);

        license0 = (Button) findViewById(R.id.license0);
        license0.setOnClickListener(license0Click);
        license1 = (Button) findViewById(R.id.license1);
        license1.setOnClickListener(license1Click);
        license2 = (Button) findViewById(R.id.license2);
        license2.setOnClickListener(license2Click);
        license3 = (Button) findViewById(R.id.license3);
        license3.setOnClickListener(license3Click);
        license4 = (Button) findViewById(R.id.license4);
        license4.setOnClickListener(license4Click);
        license5 = (Button) findViewById(R.id.license5);
        license5.setOnClickListener(license5Click);
        license6 = (Button) findViewById(R.id.license6);
        license6.setOnClickListener(license6Click);
        license_6 = (Button) findViewById(R.id.license_6);
        license_6.setOnClickListener(license_6Click);
        license7 = (Button) findViewById(R.id.license7);
        license7.setOnClickListener(license7Click);
        license8 = (Button) findViewById(R.id.license8);
        license8.setOnClickListener(license8Click);
        license9 = (Button) findViewById(R.id.license9);
        license9.setOnClickListener(license9Click);
        license10 = (Button) findViewById(R.id.license10);
        license10.setOnClickListener(license10Click);
        license11 = (Button) findViewById(R.id.license11);
        license11.setOnClickListener(license11Click);
//        license12 = (Button) findViewById(R.id.license12);
//        license12.setOnClickListener(license12Click);
//        license13 = (Button) findViewById(R.id.license13);
//        license13.setOnClickListener(license13Click);
//        license14 = (Button) findViewById(R.id.license14);
//        license14.setOnClickListener(license14Click);
        license15 = (Button) findViewById(R.id.license15);
        license15.setOnClickListener(license15Click);
//        license16 = (Button) findViewById(R.id.license16);
//        license16.setOnClickListener(license16Click);
        licenseGV = (Button) findViewById(R.id.licenseGV);
        licenseGV.setOnClickListener(licenseGVClick);
        license_dftb = (Button) findViewById(R.id.license_dftb);
        license_dftb.setOnClickListener(license_dftbClick);
        license_sk = (Button) findViewById(R.id.license_sk);
        license_sk.setOnClickListener(license_skClick);
        license_arpack = (Button) findViewById(R.id.license_arpack);
        license_arpack.setOnClickListener(license_arpackClick);
        lt_dftb = (Button) findViewById(R.id.lt_dftb);
        lt_dftb.setOnClickListener(lt_dftbClick);
        lt_sk = (Button) findViewById(R.id.lt_sk);
        lt_sk.setOnClickListener(lt_skClick);
        opsin = (Button) findViewById(R.id.opsin);
        opsin.setOnClickListener(opsinClick);
        android_shell = (Button) findViewById(R.id.android_shell);
        android_shell.setOnClickListener(android_shellClick);
//        license_busybox1 = (Button) findViewById(R.id.license_busybox1);
//        license_busybox1.setOnClickListener(license_busybox1Click);
//        license_busybox2 = (Button) findViewById(R.id.license_busybox2);
//        license_busybox2.setOnClickListener(license_busybox2Click);
//        license_busybox3 = (Button) findViewById(R.id.license_busybox3);
//        license_busybox3.setOnClickListener(license_busybox3Click);
        license1_dftd4 = (Button) findViewById(R.id.license1_dftd4);
        license1_dftd4.setOnClickListener(license1_dftd4Click);
        license2_dftd4 = (Button) findViewById(R.id.license2_dftd4);
        license2_dftd4.setOnClickListener(license2_dftd4Click);
        license_gbsa = (Button) findViewById(R.id.license_gbsa);
        license_gbsa.setOnClickListener(license_gbsaClick);
        license_mctc = (Button) findViewById(R.id.license_mctc);
        license_mctc.setOnClickListener(license_mctcClick);
        license_mstore = (Button) findViewById(R.id.license_mstore);
        license_mstore.setOnClickListener(license_mstoreClick);
        license_multicharge = (Button) findViewById(R.id.license_multicharge);
        license_multicharge.setOnClickListener(license_multichargeClick);
        license1_plotms = (Button) findViewById(R.id.license1_plotms);
        license1_plotms.setOnClickListener(license1_plotmsClick);
        license2_plotms = (Button) findViewById(R.id.license2_plotms);
        license2_plotms.setOnClickListener(license2_plotmsClick);
        license_python = (Button) findViewById(R.id.license_python);
        license_python.setOnClickListener(license_pythonClick);
        license1_qcxms = (Button) findViewById(R.id.license1_qcxms);
        license1_qcxms.setOnClickListener(license1_qcxmsClick);
        license2_qcxms = (Button) findViewById(R.id.license2_qcxms);
        license2_qcxms.setOnClickListener(license2_qcxmsClick);
        license1_sdftd3 = (Button) findViewById(R.id.license1_sdftd3);
        license1_sdftd3.setOnClickListener(license1_sdftd3Click);
        license2_sdftd3 = (Button) findViewById(R.id.license2_sdftd3);
        license2_sdftd3.setOnClickListener(license2_sdftd3Click);
        license1_stda = (Button) findViewById(R.id.license1_stda);
        license1_stda.setOnClickListener(license1_stdaClick);
        license2_stda = (Button) findViewById(R.id.license2_stda);
        license2_stda.setOnClickListener(license2_stdaClick);
        license1_tblite = (Button) findViewById(R.id.license1_tblite);
        license1_tblite.setOnClickListener(license1_tbliteClick);
        license2_tblite = (Button) findViewById(R.id.license2_tblite);
        license2_tblite.setOnClickListener(license2_tbliteClick);
        license1_testdrive = (Button) findViewById(R.id.license1_testdrive);
        license1_testdrive.setOnClickListener(license1_testdriveClick);
        license2_testdrive = (Button) findViewById(R.id.license2_testdrive);
        license2_testdrive.setOnClickListener(license2_testdriveClick);
        license1_tomlf = (Button) findViewById(R.id.license1_tomlf);
        license1_tomlf.setOnClickListener(license1_tomlfClick);
        license2_tomlf = (Button) findViewById(R.id.license2_tomlf);
        license2_tomlf.setOnClickListener(license2_tomlfClick);
        license1_xtb = (Button) findViewById(R.id.license1_xtb);
        license1_xtb.setOnClickListener(license1_xtbClick);
        license2_xtb = (Button) findViewById(R.id.license2_xtb);
        license2_xtb.setOnClickListener(license2_xtbClick);
        license1_xtb4stda = (Button) findViewById(R.id.license1_xtb4stda);
        license1_xtb4stda.setOnClickListener(license1_xtb4stdaClick);
        license2_xtb4stda = (Button) findViewById(R.id.license2_xtb4stda);
        license2_xtb4stda.setOnClickListener(license2_xtb4stdaClick);
        eigen3 = (Button) findViewById(R.id.eigen3);
        eigen3.setOnClickListener(eigen3Click);
        eigen3_lt = (Button) findViewById(R.id.eigen3_lt);
        eigen3_lt.setOnClickListener(eigen3_ltClick);
        license_cpcmx = (Button) findViewById(R.id.license_cpcmx);
        license_cpcmx.setOnClickListener(license_cpcmxClick);
        license1_numsa = (Button) findViewById(R.id.license1_numsa);
        license1_numsa.setOnClickListener(license1_numsaClick);
        license2_numsa = (Button) findViewById(R.id.license2_numsa);
        license2_numsa.setOnClickListener(license2_numsaClick);

        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Licenses.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

//    private View.OnClickListener license_busybox1Click; {
//        license_busybox1Click = new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub //
//                alertBusybox1();
//            }
//        };
//    }
//
//    public void alertBusybox1() {
//        new AlertDialog.Builder(Licenses.this)
//                .setTitle("LICENSE-BUSYBOX")
//                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-BUSYBOX.txt"))
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                }).show();
//    }
//
//    private View.OnClickListener license_busybox2Click; {
//        license_busybox2Click = new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub //
//                alertBusybox2();
//            }
//        };
//    }
//
//    public void alertBusybox2() {
//        new AlertDialog.Builder(Licenses.this)
//                .setTitle("LICENSING TERMS-BUSYBOX")
//                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSING_TERMS-BUSYBOX.txt"))
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                }).show();
//    }
//
//    private View.OnClickListener license_busybox3Click; {
//        license_busybox3Click = new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub //
//                alertBusybox3();
//            }
//        };
//    }
//
//    public void alertBusybox3() {
//        new AlertDialog.Builder(Licenses.this)
//                .setTitle("LICENSE NOTE-BUSYBOX")
//                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE_NOTE-BUSYBOX.txt"))
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                }).show();
//    }

    private View.OnClickListener license_cpcmxClick; {
        license_cpcmxClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1cpcmx();
            }
        };
    }

    public void alert1cpcmx() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-CPCM-X")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-CPCMX.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_numsaClick; {
        license1_numsaClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1numsa();
            }
        };
    }

    public void alert1numsa() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-NUMSA")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-NUMSA.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_numsaClick; {
        license2_numsaClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2numsa();
            }
        };
    }

    public void alert2numsa() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-NUMSA")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-NUMSA.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener eigen3Click; {
        eigen3Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1eigen3();
            }
        };
    }

    public void alert1eigen3() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-EIGEN3")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-EIGEN3.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener eigen3_ltClick; {
        eigen3_ltClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2eigen3();
            }
        };
    }

    public void alert2eigen3() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSING-TERMS-EIGEN3")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSING-TERMS-EIGEN3.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_pythonClick; {
        license_pythonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1python();
            }
        };
    }

    public void alert1python() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-PYTHON")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-PYTHON.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_dftd4Click; {
        license1_dftd4Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1dftd4();
            }
        };
    }

    public void alert1dftd4() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-DFTD4")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-DFTD4.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_dftd4Click; {
        license2_dftd4Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2dftd4();
            }
        };
    }

    public void alert2dftd4() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-DFTD4")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-DFTD4.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_gbsaClick; {
        license_gbsaClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertGbsa();
            }
        };
    }

    public void alertGbsa() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-GBSA-PARAMETERS")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-GBSA-PARAMETERS.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_mctcClick; {
        license_mctcClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertmctc();
            }
        };
    }

    public void alertmctc() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-MCTC-LIB")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-MCTC-LIB.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_mstoreClick; {
        license_mstoreClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertmstore();
            }
        };
    }

    public void alertmstore() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-MSTORE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-MSTORE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_multichargeClick; {
        license_multichargeClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertmc();
            }
        };
    }

    public void alertmc() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-MULTICHARGE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-MULTICHARGE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_plotmsClick; {
        license1_plotmsClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1plotms();
            }
        };
    }

    public void alert1plotms() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-PLOTMS")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-PLOTMS.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_plotmsClick; {
        license2_plotmsClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2plotms();
            }
        };
    }

    public void alert2plotms() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-PLOTMS")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-PLOTMS.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_qcxmsClick; {
        license1_qcxmsClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1qcxms();
            }
        };
    }

    public void alert1qcxms() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-QCxMS")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-QCXMS.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_qcxmsClick; {
        license2_qcxmsClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2qcxms();
            }
        };
    }

    public void alert2qcxms() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-QCxMS")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-QCXMS.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_sdftd3Click; {
        license1_sdftd3Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1sdftd3();
            }
        };
    }

    public void alert1sdftd3() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-s-DFTD3")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-S-DFTD3.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_sdftd3Click; {
        license2_sdftd3Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2sdftd3();
            }
        };
    }

    public void alert2sdftd3() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-s-DFTD3")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-S-DFTD3.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_stdaClick; {
        license1_stdaClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1stda();
            }
        };
    }

    public void alert1stda() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-STDA")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-STDA.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_stdaClick; {
        license2_stdaClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2stda();
            }
        };
    }

    public void alert2stda() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-STDA")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-STDA.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_tbliteClick; {
        license1_tbliteClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1tblite();
            }
        };
    }

    public void alert1tblite() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-TBLITE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-TBLITE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_tbliteClick; {
        license2_tbliteClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2tblite();
            }
        };
    }

    public void alert2tblite() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-TBLITE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-TBLITE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_testdriveClick; {
        license1_testdriveClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1td();
            }
        };
    }

    public void alert1td() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-TEST-DRIVE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-TEST-DRIVE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_testdriveClick; {
        license2_testdriveClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2td();
            }
        };
    }

    public void alert2td() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-TEST-DRIVE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-TEST-DRIVE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_tomlfClick; {
        license1_tomlfClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1tomlf();
            }
        };
    }

    public void alert1tomlf() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-TOML-F")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-TOML-F.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_tomlfClick; {
        license2_tomlfClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2tomlf();
            }
        };
    }

    public void alert2tomlf() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-TOML-F")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-TOML-F.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_xtbClick; {
        license1_xtbClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1xtb();
            }
        };
    }

    public void alert1xtb() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-XTB")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-XTB.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_xtbClick; {
        license2_xtbClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2xtb();
            }
        };
    }

    public void alert2xtb() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-XTB")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-XTB.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_xtb4stdaClick; {
        license1_xtb4stdaClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1xtb4stda();
            }
        };
    }

    public void alert1xtb4stda() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-XTB4STDA")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-XTB4STDA.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_xtb4stdaClick; {
        license2_xtb4stdaClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2xtb4stda();
            }
        };
    }

    public void alert2xtb4stda() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-XTB4STDA")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-XTB4STDA.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }























    private View.OnClickListener android_shellClick; {
        android_shellClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertAS();
            }
        };
    }

    public void alertAS() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-ANDROID-SHELL")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-ANDROID_SHELL.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener opsinClick; {
        opsinClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertOpsin();
            }
        };
    }

    public void alertOpsin() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-OPSIN")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-OPSIN.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener licenseGVClick; {
        licenseGVClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertGV();
            }
        };
    }

    public void alertGV() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-GRAPHVIEW")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-GRAPHVIEW.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license0Click; {
        license0Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert0();
            }
        };
    }

    public void alert0() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-ACPDFVIEW")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-ACPDFVIEW.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1Click; {
        license1Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1();
            }
        };
    }

    public void alert1() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-CHEMSOL")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-CHEMSOL.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2Click; {
        license2Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2();
            }
        };
    }

    public void alert2() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-FASTCHEM")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-FASTCHEM.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license3Click; {
        license3Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert3();
            }
        };
    }

    public void alert3() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-GMP")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-GMP.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license4Click; {
        license4Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert4();
            }
        };
    }

    public void alert4() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-GMP")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-GMP.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license5Click; {
        license5Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert5();
            }
        };
    }

    public void alert5() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-LAPACK")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-LAPACK.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license6Click; {
        license6Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert6();
            }
        };
    }

    public void alert6() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-MOPAC")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-MOPAC.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_6Click; {
        license_6Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert_6();
            }
        };
    }

    public void alert_6() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-MOPAC")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-MOPAC.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license7Click; {
        license7Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert7();
            }
        };
    }

    public void alert7() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-OPENBABEL")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-OPENBABEL.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license8Click; {
        license8Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert8();
            }
        };
    }

    public void alert8() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSING TERMS-PHREEQC")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSING_TERMS-PHREEQC.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license9Click; {
        license9Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert9();
            }
        };
    }

    public void alert9() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-TRANSPOSE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-TRANSPOSE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license10Click; {
        license10Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert10();
            }
        };
    }

    public void alert10() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-X11-BASIC")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-X11-BASIC.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license11Click; {
        license11Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert11();
            }
        };
    }

    public void alert11() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSING_TERMS_X11-BASIC")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSING_TERMS-X11-BASIC.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

//    private View.OnClickListener license12Click; {
//        license12Click = new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub //
//                alert12();
//            }
//        };
//    }
//
//    public void alert12() {
//        new AlertDialog.Builder(Licenses.this)
//                .setTitle("LICENSE-FFTW")
//                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-FFTW.txt"))
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                }).show();
//    }
//
//    private View.OnClickListener license13Click; {
//        license13Click = new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub //
//                alert13();
//            }
//        };
//    }
//
//    public void alert13() {
//        new AlertDialog.Builder(Licenses.this)
//                .setTitle("LICENSE-LIBINT")
//                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-LIBINT.txt"))
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                }).show();
//    }
//
//    private View.OnClickListener license14Click; {
//        license14Click = new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub //
//                alert14();
//            }
//        };
//    }
//
//    public void alert14() {
//        new AlertDialog.Builder(Licenses.this)
//                .setTitle("LICENSE-LIBXC")
//                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-LIBXC.txt"))
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                }).show();
//    }

    private View.OnClickListener license15Click; {
        license15Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert15();
            }
        };
    }

    public void alert15() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-OPENBLAS")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-OPENBLAS.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

//    private View.OnClickListener license16Click; {
//        license16Click = new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub //
//                alert16();
//            }
//        };
//    }
//
//    public void alert16() {
//        new AlertDialog.Builder(Licenses.this)
//                .setTitle("LICENSE-CP2K")
//                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-CP2K.txt"))
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                }).show();
//    }

    private View.OnClickListener license_dftbClick; {
        license_dftbClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert17();
            }
        };
    }

    public void alert17() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-DFTB+")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-DFTB+.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_arpackClick; {
        license_arpackClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert18();
            }
        };
    }

    public void alert18() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-ARPACK")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-ARPACK.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_skClick; {
        license_skClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert19();
            }
        };
    }

    public void alert19() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-SLATER_KOSTER_FILES")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-SK.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener lt_skClick; {
        lt_skClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert20();
            }
        };
    }

    public void alert20() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSING TERMS-SLATER_KOSTER_FILES")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSING_TERMS-SK.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener lt_dftbClick; {
        lt_dftbClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert21();
            }
        };
    }

    public void alert21() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSING TERMS-DFTB+")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSING_TERMS-DFTB+.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
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

}
