package cz.p;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.acutecoder.pdf.OnActionListener;
import com.acutecoder.pdf.PdfScrollBar;
import com.acutecoder.pdf.PdfView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class ManualXtb extends Xtb {

//    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manualxtb);

        PdfView pdfView = findViewById(R.id.pdfView);
        PdfScrollBar scrollBar = findViewById(R.id.pdfScroll);
        ProgressBar progressBar = findViewById(R.id.pg);

        scrollBar.attachTo(pdfView);
        pdfView.setZoomEnabled(true);
        pdfView.setMaxZoomScale(5); //Maximum Zoom
        pdfView.setPath(new File(getFilesDir()+"/docs/xtb_manual.pdf")); //Normal File loaction
        // pdfView.setPath(new TemporaryFile(R.raw.pdf)); //Raw File
        // pdfView.setPath(new TemporaryFile("pdfs/MyPdfFile.pdf")); //Asset File
        pdfView.setQuality(1f); //80%
        pdfView.setModFlingLimit(0);
        pdfView.addOnActionListener(new OnActionListener() {
            @Override
            public void onLoaded() {
                progressBar.setVisibility(View.GONE);
            }
        });
        pdfView.load();
    }

}
