package cz.p;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import android.content.Context;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jrummyapps.android.shell.CommandResult;
import com.jrummyapps.android.shell.Shell;

public class ProjectionGraph extends MainActivity {

    private Handler handler = new Handler();
    private TextView contentXyzLabel;
    private EditText contentXyz;
    Button openExtXyz;
    Button openIntXyz;
    Button rightX;
    Button leftX;
    Button rightY;
    Button leftY;
    Button upZ;
    Button downZ;
    Button Quit;
    private static final int READ_FILE169 = 169;
    private Uri documentUri169;
    String valXY[];
    Double Xval;
    Double Yval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projectiongraph);

        contentXyzLabel = (TextView) findViewById(R.id.contentXyzLabel);
        contentXyz = (EditText) findViewById(R.id.contentXyz);

        openExtXyz = (Button) findViewById(R.id.openExtXyz);
        openExtXyz.setOnClickListener(openExtXyzClick);
        openIntXyz = (Button) findViewById(R.id.openIntXyz);
        rightX = (Button) findViewById(R.id.rightX);
        rightX.setOnClickListener(rightXClick);
        leftX = (Button) findViewById(R.id.leftX);
        leftX.setOnClickListener(leftXClick);
        rightY = (Button) findViewById(R.id.rightY);
        rightY.setOnClickListener(rightYClick);
        leftY = (Button) findViewById(R.id.leftY);
        leftY.setOnClickListener(leftYClick);
        upZ = (Button) findViewById(R.id.upZ);
        upZ.setOnClickListener(upZClick);
        downZ = (Button) findViewById(R.id.downZ);
        downZ.setOnClickListener(downZClick);
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);

        openIntXyz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectionGraph.this, ProjectionGraphSelector.class);
                startActivity(intent);
            }
        });

    }

    public void onStart()
    {
        super.onStart();
        output(exec("cat "+getFilesDir()+"/XYZ_view.xyz"));
    }

    private View.OnClickListener rightXClick; {

        rightXClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XYZcontent = contentXyz.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("XYZ_view.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XYZcontent);
                    outputWriter.close();
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/Xright.b "+getFilesDir()+"/Xright.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/Xright.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/Xright.b");
                    exec("rm "+getFilesDir()+"/XYZ_view.xyz");
                    exec("mv "+getFilesDir()+"/XYZ_view2.xyz "+getFilesDir()+"/XYZ_view.xyz");
                    String Sort = exec("sort -t, -g -k1,1 "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutG = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG = new OutputStreamWriter(fileoutG);
                    outputWriterG.write(Sort);
                    outputWriterG.close();
                    // remove blank lines in sorted file
                    String BlankLin = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutBL = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL = new OutputStreamWriter(fileoutBL);
                    outputWriterBL.write(BlankLin);
                    outputWriterBL.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                GraphView graph = (GraphView) findViewById(R.id.graph);
                graph.removeAllSeries();

                BufferedReader reader = null;
                try {
                    File GraphFile = new File(getFilesDir()+"/XYZ_view.csv");
                    FileInputStream fis = new FileInputStream(GraphFile);
                    DataInputStream in = new DataInputStream(fis);
                    reader = new BufferedReader(new InputStreamReader(in));
                    String mline;

                    ArrayList<DataPoint> arrDataPoint=new ArrayList<>();
                    arrDataPoint.clear();
                    while ((mline = reader.readLine()) != null) {
                        valXY = mline.split(",");
                        Xval = Double.parseDouble(valXY[0]);
                        Yval = Double.parseDouble(valXY[1]);
                        DataPoint dp = new DataPoint(Xval, Yval);
                        arrDataPoint.add(dp);
                    }
                    DataPoint[] listDp = new DataPoint[arrDataPoint.size()];
                    for(int i=0;i<arrDataPoint.size();i++){
                        listDp[i]=arrDataPoint.get(i);
                    }
                    PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(listDp);
                    graph.addSeries(series);
                    series.setColor(Color.GRAY);
                    series.setSize(65);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                graph.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
                graph.getViewport().setScrollable(true);  // activate horizontal scrolling
                graph.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
                graph.getViewport().setScrollableY(true);  // activate vertical scrolling

                output(exec("cat "+getFilesDir()+"/XYZ_view.xyz"));
            }
        };
    }

    private View.OnClickListener leftXClick; {

        leftXClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XYZcontent = contentXyz.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("XYZ_view.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XYZcontent);
                    outputWriter.close();
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/Xleft.b "+getFilesDir()+"/Xleft.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/Xleft.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/Xleft.b");
                    exec("rm "+getFilesDir()+"/XYZ_view.xyz");
                    exec("mv "+getFilesDir()+"/XYZ_view2.xyz "+getFilesDir()+"/XYZ_view.xyz");
                    String Sort = exec("sort -t, -g -k1,1 "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutG = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG = new OutputStreamWriter(fileoutG);
                    outputWriterG.write(Sort);
                    outputWriterG.close();
                    // remove blank lines in sorted file
                    String BlankLin = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutBL = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL = new OutputStreamWriter(fileoutBL);
                    outputWriterBL.write(BlankLin);
                    outputWriterBL.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                GraphView graph = (GraphView) findViewById(R.id.graph);
                graph.removeAllSeries();

                BufferedReader reader = null;
                try {
                    File GraphFile = new File(getFilesDir()+"/XYZ_view.csv");
                    FileInputStream fis = new FileInputStream(GraphFile);
                    DataInputStream in = new DataInputStream(fis);
                    reader = new BufferedReader(new InputStreamReader(in));
                    String mline;

                    ArrayList<DataPoint> arrDataPoint=new ArrayList<>();
                    arrDataPoint.clear();
                    while ((mline = reader.readLine()) != null) {
                        valXY = mline.split(",");
                        Xval = Double.parseDouble(valXY[0]);
                        Yval = Double.parseDouble(valXY[1]);
                        DataPoint dp = new DataPoint(Xval, Yval);
                        arrDataPoint.add(dp);
                    }
                    DataPoint[] listDp = new DataPoint[arrDataPoint.size()];
                    for(int i=0;i<arrDataPoint.size();i++){
                        listDp[i]=arrDataPoint.get(i);
                    }
                    PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(listDp);
                    graph.addSeries(series);
                    series.setColor(Color.GRAY);
                    series.setSize(65);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                graph.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
                graph.getViewport().setScrollable(true);  // activate horizontal scrolling
                graph.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
                graph.getViewport().setScrollableY(true);  // activate vertical scrolling

                output(exec("cat "+getFilesDir()+"/XYZ_view.xyz"));
            }
        };
    }

    private View.OnClickListener rightYClick; {

        rightYClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XYZcontent = contentXyz.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("XYZ_view.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XYZcontent);
                    outputWriter.close();
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/Yright.b "+getFilesDir()+"/Yright.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/Yright.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/Yright.b");
                    exec("rm "+getFilesDir()+"/XYZ_view.xyz");
                    exec("mv "+getFilesDir()+"/XYZ_view2.xyz "+getFilesDir()+"/XYZ_view.xyz");
                    String Sort = exec("sort -t, -g -k1,1 "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutG = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG = new OutputStreamWriter(fileoutG);
                    outputWriterG.write(Sort);
                    outputWriterG.close();
                    // remove blank lines in sorted file
                    String BlankLin = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutBL = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL = new OutputStreamWriter(fileoutBL);
                    outputWriterBL.write(BlankLin);
                    outputWriterBL.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                GraphView graph = (GraphView) findViewById(R.id.graph);
                graph.removeAllSeries();

                BufferedReader reader = null;
                try {
                    File GraphFile = new File(getFilesDir()+"/XYZ_view.csv");
                    FileInputStream fis = new FileInputStream(GraphFile);
                    DataInputStream in = new DataInputStream(fis);
                    reader = new BufferedReader(new InputStreamReader(in));
                    String mline;

                    ArrayList<DataPoint> arrDataPoint=new ArrayList<>();
                    arrDataPoint.clear();
                    while ((mline = reader.readLine()) != null) {
                        valXY = mline.split(",");
                        Xval = Double.parseDouble(valXY[0]);
                        Yval = Double.parseDouble(valXY[1]);
                        DataPoint dp = new DataPoint(Xval, Yval);
                        arrDataPoint.add(dp);
                    }
                    DataPoint[] listDp = new DataPoint[arrDataPoint.size()];
                    for(int i=0;i<arrDataPoint.size();i++){
                        listDp[i]=arrDataPoint.get(i);
                    }
                    PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(listDp);
                    graph.addSeries(series);
                    series.setColor(Color.GRAY);
                    series.setSize(65);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                graph.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
                graph.getViewport().setScrollable(true);  // activate horizontal scrolling
                graph.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
                graph.getViewport().setScrollableY(true);  // activate vertical scrolling

                output(exec("cat "+getFilesDir()+"/XYZ_view.xyz"));
            }
        };
    }

    private View.OnClickListener leftYClick; {

        leftYClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XYZcontent = contentXyz.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("XYZ_view.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XYZcontent);
                    outputWriter.close();
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/Yleft.b "+getFilesDir()+"/Yleft.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/Yleft.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/Yleft.b");
                    exec("rm "+getFilesDir()+"/XYZ_view.xyz");
                    exec("mv "+getFilesDir()+"/XYZ_view2.xyz "+getFilesDir()+"/XYZ_view.xyz");
                    String Sort = exec("sort -t, -g -k1,1 "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutG = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG = new OutputStreamWriter(fileoutG);
                    outputWriterG.write(Sort);
                    outputWriterG.close();
                    // remove blank lines in sorted file
                    String BlankLin = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutBL = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL = new OutputStreamWriter(fileoutBL);
                    outputWriterBL.write(BlankLin);
                    outputWriterBL.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                GraphView graph = (GraphView) findViewById(R.id.graph);
                graph.removeAllSeries();

                BufferedReader reader = null;
                try {
                    File GraphFile = new File(getFilesDir()+"/XYZ_view.csv");
                    FileInputStream fis = new FileInputStream(GraphFile);
                    DataInputStream in = new DataInputStream(fis);
                    reader = new BufferedReader(new InputStreamReader(in));
                    String mline;

                    ArrayList<DataPoint> arrDataPoint=new ArrayList<>();
                    arrDataPoint.clear();
                    while ((mline = reader.readLine()) != null) {
                        valXY = mline.split(",");
                        Xval = Double.parseDouble(valXY[0]);
                        Yval = Double.parseDouble(valXY[1]);
                        DataPoint dp = new DataPoint(Xval, Yval);
                        arrDataPoint.add(dp);
                    }
                    DataPoint[] listDp = new DataPoint[arrDataPoint.size()];
                    for(int i=0;i<arrDataPoint.size();i++){
                        listDp[i]=arrDataPoint.get(i);
                    }
                    PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(listDp);
                    graph.addSeries(series);
                    series.setColor(Color.GRAY);
                    series.setSize(65);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                graph.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
                graph.getViewport().setScrollable(true);  // activate horizontal scrolling
                graph.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
                graph.getViewport().setScrollableY(true);  // activate vertical scrolling

                output(exec("cat "+getFilesDir()+"/XYZ_view.xyz"));
            }
        };
    }

    private View.OnClickListener upZClick; {

        upZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XYZcontent = contentXyz.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("XYZ_view.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XYZcontent);
                    outputWriter.close();
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/Zup.b "+getFilesDir()+"/Zup.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/Zup.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/Zup.b");
                    exec("rm "+getFilesDir()+"/XYZ_view.xyz");
                    exec("mv "+getFilesDir()+"/XYZ_view2.xyz "+getFilesDir()+"/XYZ_view.xyz");
                    String Sort = exec("sort -t, -g -k1,1 "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutG = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG = new OutputStreamWriter(fileoutG);
                    outputWriterG.write(Sort);
                    outputWriterG.close();
                    // remove blank lines in sorted file
                    String BlankLin = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutBL = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL = new OutputStreamWriter(fileoutBL);
                    outputWriterBL.write(BlankLin);
                    outputWriterBL.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                GraphView graph = (GraphView) findViewById(R.id.graph);
                graph.removeAllSeries();

                BufferedReader reader = null;
                try {
                    File GraphFile = new File(getFilesDir()+"/XYZ_view.csv");
                    FileInputStream fis = new FileInputStream(GraphFile);
                    DataInputStream in = new DataInputStream(fis);
                    reader = new BufferedReader(new InputStreamReader(in));
                    String mline;

                    ArrayList<DataPoint> arrDataPoint=new ArrayList<>();
                    arrDataPoint.clear();
                    while ((mline = reader.readLine()) != null) {
                        valXY = mline.split(",");
                        Xval = Double.parseDouble(valXY[0]);
                        Yval = Double.parseDouble(valXY[1]);
                        DataPoint dp = new DataPoint(Xval, Yval);
                        arrDataPoint.add(dp);
                    }
                    DataPoint[] listDp = new DataPoint[arrDataPoint.size()];
                    for(int i=0;i<arrDataPoint.size();i++){
                        listDp[i]=arrDataPoint.get(i);
                    }
                    PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(listDp);
                    graph.addSeries(series);
                    series.setColor(Color.GRAY);
                    series.setSize(65);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                graph.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
                graph.getViewport().setScrollable(true);  // activate horizontal scrolling
                graph.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
                graph.getViewport().setScrollableY(true);  // activate vertical scrolling

                output(exec("cat "+getFilesDir()+"/XYZ_view.xyz"));
            }
        };
    }

    private View.OnClickListener downZClick; {

        downZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String XYZcontent = contentXyz.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("XYZ_view.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(XYZcontent);
                    outputWriter.close();
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/Zdown.b "+getFilesDir()+"/Zdown.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/Zdown.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/Zdown.b");
                    exec("rm "+getFilesDir()+"/XYZ_view.xyz");
                    exec("mv "+getFilesDir()+"/XYZ_view2.xyz "+getFilesDir()+"/XYZ_view.xyz");
                    String Sort = exec("sort -t, -g -k1,1 "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutG = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG = new OutputStreamWriter(fileoutG);
                    outputWriterG.write(Sort);
                    outputWriterG.close();
                    // remove blank lines in sorted file
                    String BlankLin = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutBL = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL = new OutputStreamWriter(fileoutBL);
                    outputWriterBL.write(BlankLin);
                    outputWriterBL.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                GraphView graph = (GraphView) findViewById(R.id.graph);
                graph.removeAllSeries();

                BufferedReader reader = null;
                try {
                    File GraphFile = new File(getFilesDir()+"/XYZ_view.csv");
                    FileInputStream fis = new FileInputStream(GraphFile);
                    DataInputStream in = new DataInputStream(fis);
                    reader = new BufferedReader(new InputStreamReader(in));
                    String mline;

                    ArrayList<DataPoint> arrDataPoint=new ArrayList<>();
                    arrDataPoint.clear();
                    while ((mline = reader.readLine()) != null) {
                        valXY = mline.split(",");
                        Xval = Double.parseDouble(valXY[0]);
                        Yval = Double.parseDouble(valXY[1]);
                        DataPoint dp = new DataPoint(Xval, Yval);
                        arrDataPoint.add(dp);
                    }
                    DataPoint[] listDp = new DataPoint[arrDataPoint.size()];
                    for(int i=0;i<arrDataPoint.size();i++){
                        listDp[i]=arrDataPoint.get(i);
                    }
                    PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(listDp);
                    graph.addSeries(series);
                    series.setColor(Color.GRAY);
                    series.setSize(65);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                graph.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
                graph.getViewport().setScrollable(true);  // activate horizontal scrolling
                graph.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
                graph.getViewport().setScrollableY(true);  // activate vertical scrolling

                output(exec("cat "+getFilesDir()+"/XYZ_view.xyz"));
            }
        };
    }

    private View.OnClickListener openExtXyzClick; {

        openExtXyzClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                exec("rm "+getFilesDir()+"/XYZ_view.csv");
                read169(getApplicationContext());
                try {
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbbc.so -o "+getFilesDir()+"/XYZdisplay.b "+getFilesDir()+"/XYZdisplay.bas");
                    exec("chmod -R 755 "+getFilesDir()+"/XYZdisplay.b");
                    exec(getApplicationInfo().nativeLibraryDir+"/libxbvm.so "+getFilesDir()+"/XYZdisplay.b");
                    exec("rm "+getFilesDir()+"/XYZ_view.xyz");
                    exec("mv "+getFilesDir()+"/XYZ_view2.xyz "+getFilesDir()+"/XYZ_view.xyz");
                    String Sort = exec("sort -t, -g -k1,1 "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutG = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterG = new OutputStreamWriter(fileoutG);
                    outputWriterG.write(Sort);
                    outputWriterG.close();
                    // remove blank lines in sorted file
                    String BlankLin = exec("sed /^[[:space:]]*$/d "+getFilesDir()+"/XYZ_view.csv");
                    exec("rm "+getFilesDir()+"/XYZ_view.csv");
                    FileOutputStream fileoutBL = openFileOutput("XYZ_view.csv", MODE_PRIVATE);
                    OutputStreamWriter outputWriterBL = new OutputStreamWriter(fileoutBL);
                    outputWriterBL.write(BlankLin);
                    outputWriterBL.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                GraphView graph = (GraphView) findViewById(R.id.graph);
//                graph.removeAllSeries();

                BufferedReader reader = null;
                try {
                    File GraphFile = new File(getFilesDir()+"/XYZ_view.csv");
                    FileInputStream fis = new FileInputStream(GraphFile);
                    DataInputStream in = new DataInputStream(fis);
                    reader = new BufferedReader(new InputStreamReader(in));
                    String mline;

                    ArrayList<DataPoint> arrDataPoint=new ArrayList<>();
                    arrDataPoint.clear();
                    while ((mline = reader.readLine()) != null) {
                        valXY = mline.split(",");
                        Xval = Double.parseDouble(valXY[0]);
                        Yval = Double.parseDouble(valXY[1]);
                        DataPoint dp = new DataPoint(Xval, Yval);
                        arrDataPoint.add(dp);
                    }
                    DataPoint[] listDp = new DataPoint[arrDataPoint.size()];
                    for(int i=0;i<arrDataPoint.size();i++){
                        listDp[i]=arrDataPoint.get(i);
                    }
                    PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(listDp);
                    graph.addSeries(series);
                    series.setColor(Color.GRAY);
                    series.setSize(65);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                graph.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
                graph.getViewport().setScrollable(true);  // activate horizontal scrolling
                graph.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
                graph.getViewport().setScrollableY(true);  // activate vertical scrolling

                output(exec("cat "+getFilesDir()+"/XYZ_view.xyz"));
            }
        };
    }

    private void read169(Context context169) {
        Intent intent169 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent169.addCategory(Intent.CATEGORY_OPENABLE);
        intent169.setType("text/plain");
        startActivityForResult(intent169, READ_FILE169);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE169 && data != null) {
            try {
                documentUri169 = data.getData();
                String myData = "";
                ParcelFileDescriptor pfd169 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd169.getFileDescriptor());
                DataInputStream inp = new DataInputStream(fileInputStream);
                BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine + "\n";
                }
                inp.close();

                FileOutputStream fileout = openFileOutput("XYZ_view.xyz", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(myData);
                outputWriter.close();
                fileInputStream.close();
                pfd169.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(ProjectionGraph.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        output(exec("cat "+getFilesDir()+"/XYZ_view.xyz"));
    }

    public void output(final String str) {
        Runnable proc = new Runnable() {
            public void run() {
                contentXyz.setText(str);
            }
        };
        handler.post(proc);
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