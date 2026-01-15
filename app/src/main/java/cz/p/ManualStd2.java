package cz.p;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.acutecoder.pdf.OnActionListener;
import com.acutecoder.pdf.PdfScrollBar;
import com.acutecoder.pdf.PdfView;

import java.io.File;


public class ManualStd2 extends Xtb {

//    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.manualstd2);

        PdfView pdfView = findViewById(R.id.pdfView);
        PdfScrollBar scrollBar = findViewById(R.id.pdfScroll);
        ProgressBar progressBar = findViewById(R.id.pg);

        scrollBar.attachTo(pdfView);
        pdfView.setZoomEnabled(true);
        pdfView.setMaxZoomScale(5); //Maximum Zoom
        pdfView.setPath(new File(getFilesDir()+"/docs/std2_manual.pdf")); //Normal File loaction
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
