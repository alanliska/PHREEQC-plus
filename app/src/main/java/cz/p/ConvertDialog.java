package cz.p;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ConvertDialog extends MainActivity {

    TextView convert_info;
        Button start_conversion_g;
        Button start_conversion_c;
        Button start_conversion_l;
        Button start_conversion_solv;
        Button Quit;
    private static final int READ_FILE8 = 158;
    private static final int READ_FILE9 = 159;
    private static final int READ_FILE10 = 1510;
    private static final int READ_FILE11 = 1511;
    private Uri documentUri8;
    private Uri documentUri9;
    private Uri documentUri10;
    private Uri documentUri11;
    Time t = new Time(Time.getCurrentTimezone()); String date = t.format("%Y/%m/%d");

        public ProgressDialog progressDialog;


        /**
         * Called when the activity is first created.
         */
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.convertdialog);

            Quit = (Button) findViewById(R.id.Quit);
            Quit.setOnClickListener(QuitClick);
            start_conversion_g = (Button) findViewById(R.id.start_conversion_g);
            start_conversion_g.setOnClickListener(start_conversion_gClick);
            start_conversion_c = (Button) findViewById(R.id.start_conversion_c);
            start_conversion_c.setOnClickListener(start_conversion_cClick);
            start_conversion_l = (Button) findViewById(R.id.start_conversion_l);
            start_conversion_l.setOnClickListener(start_conversion_lClick);
            start_conversion_solv = (Button) findViewById(R.id.start_conversion_solv);
            start_conversion_solv.setOnClickListener(start_conversion_solvClick);
            convert_info = (TextView) findViewById(R.id.convert_info);
}

    private View.OnClickListener start_conversion_gClick; {
        start_conversion_gClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(ConvertDialog.this, ConvertG.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener start_conversion_lClick; {
        start_conversion_lClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(ConvertDialog.this, ConvertL.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener start_conversion_cClick; {
        start_conversion_cClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(ConvertDialog.this, ConvertC.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener start_conversion_solvClick; {
        start_conversion_solvClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(ConvertDialog.this, ConvertS.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener QuitClick; {
        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(ConvertDialog.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }


}
