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
                .setTitle("LICENSE-MOPAC")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-MOPAC.txt"))
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
