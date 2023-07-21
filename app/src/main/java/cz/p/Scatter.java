package cz.p;

import android.graphics.Color;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Scatter extends Phreeqc {

    String valXY1[];
    Double X1val;
    Double Y1val;
    String valXY2[];
    Double X2val;
    Double Y2val;
    String valXY3[];
    Double X3val;
    Double Y3val;
    String valXY4[];
    Double X4val;
    Double Y4val;
    String valXY5[];
    Double X5val;
    Double Y5val;
    String valXY6[];
    Double X6val;
    Double Y6val;
    String valXY7[];
    Double X7val;
    Double Y7val;
    String valXY8[];
    Double X8val;
    Double Y8val;
    String valXY9[];
    Double X9val;
    Double Y9val;
    String valXY10[];
    Double X10val;
    Double Y10val;
    GraphView scatter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scatter);

        GraphView scatter = (GraphView) findViewById(R.id.scatter);

        BufferedReader reader = null;
        try {
            File GraphFile = new File(getFilesDir()+"/graph-series1.csv");
            FileInputStream fis = new FileInputStream(GraphFile);
            DataInputStream in = new DataInputStream(fis);
            reader = new BufferedReader(new InputStreamReader(in));
            // comment - otherwise it ignores first two lines (here, the csv file is intended to exist without headers)
//            reader.readLine();  //skip first line of file
//            reader.readLine();  //skip second line of file
            String mline;

            ArrayList<DataPoint> arrDataPoint=new ArrayList<>();
            while ((mline = reader.readLine()) != null) {
                valXY1 = mline.split(",");
                X1val = Double.parseDouble(valXY1[0]);
                Y1val = Double.parseDouble(valXY1[1]);
                DataPoint dp = new DataPoint(X1val, Y1val);
                arrDataPoint.add(dp);
            }
            DataPoint[] listDp = new DataPoint[arrDataPoint.size()];
            for(int i=0;i<arrDataPoint.size();i++){
                listDp[i]=arrDataPoint.get(i);
            }
            PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(listDp);
            scatter.addSeries(series);
//            series.setColor(Color.BLUE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader2 = null;
        try {
            File GraphFile2 = new File(getFilesDir()+"/graph-series2.csv");
            FileInputStream fis2 = new FileInputStream(GraphFile2);
            DataInputStream in2 = new DataInputStream(fis2);
            reader2 = new BufferedReader(new InputStreamReader(in2));
            // comment - otherwise it ignores first two lines (here, the csv file is intended to exist without headers)
//            reader.readLine();  //skip first line of file
//            reader.readLine();  //skip second line of file
            String mline2;

            ArrayList<DataPoint> arrDataPoint2=new ArrayList<>();
            while ((mline2 = reader2.readLine()) != null) {
                valXY2 = mline2.split(",");
                X2val = Double.parseDouble(valXY2[0]);
                Y2val = Double.parseDouble(valXY2[1]);
                DataPoint dp2 = new DataPoint(X2val, Y2val);
                arrDataPoint2.add(dp2);
            }
            DataPoint[] listDp2 = new DataPoint[arrDataPoint2.size()];
            for(int i=0;i<arrDataPoint2.size();i++){
                listDp2[i]=arrDataPoint2.get(i);
            }
            PointsGraphSeries<DataPoint> series2 = new PointsGraphSeries<>(listDp2);
            scatter.addSeries(series2);
            series2.setColor(Color.RED);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader3 = null;
        try {
            File GraphFile3 = new File(getFilesDir()+"/graph-series3.csv");
            FileInputStream fis3 = new FileInputStream(GraphFile3);
            DataInputStream in3 = new DataInputStream(fis3);
            reader3 = new BufferedReader(new InputStreamReader(in3));
            // comment - otherwise it ignores first two lines (here, the csv file is intended to exist without headers)
//            reader.readLine();  //skip first line of file
//            reader.readLine();  //skip second line of file
            String mline3;

            ArrayList<DataPoint> arrDataPoint3=new ArrayList<>();
            while ((mline3 = reader3.readLine()) != null) {
                valXY3 = mline3.split(",");
                X3val = Double.parseDouble(valXY3[0]);
                Y3val = Double.parseDouble(valXY3[1]);
                DataPoint dp3 = new DataPoint(X3val, Y3val);
                arrDataPoint3.add(dp3);
            }
            DataPoint[] listDp3 = new DataPoint[arrDataPoint3.size()];
            for(int i=0;i<arrDataPoint3.size();i++){
                listDp3[i]=arrDataPoint3.get(i);
            }
            PointsGraphSeries<DataPoint> series3 = new PointsGraphSeries<>(listDp3);
            scatter.addSeries(series3);
            series3.setColor(Color.GREEN);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader4 = null;
        try {
            File GraphFile4 = new File(getFilesDir()+"/graph-series4.csv");
            FileInputStream fis4 = new FileInputStream(GraphFile4);
            DataInputStream in4 = new DataInputStream(fis4);
            reader4 = new BufferedReader(new InputStreamReader(in4));
            // comment - otherwise it ignores first two lines (here, the csv file is intended to exist without headers)
//            reader.readLine();  //skip first line of file
//            reader.readLine();  //skip second line of file
            String mline4;

            ArrayList<DataPoint> arrDataPoint4=new ArrayList<>();
            while ((mline4 = reader4.readLine()) != null) {
                valXY4 = mline4.split(",");
                X4val = Double.parseDouble(valXY4[0]);
                Y4val = Double.parseDouble(valXY4[1]);
                DataPoint dp4 = new DataPoint(X4val, Y4val);
                arrDataPoint4.add(dp4);
            }
            DataPoint[] listDp4 = new DataPoint[arrDataPoint4.size()];
            for(int i=0;i<arrDataPoint4.size();i++){
                listDp4[i]=arrDataPoint4.get(i);
            }
            PointsGraphSeries<DataPoint> series4 = new PointsGraphSeries<>(listDp4);
            scatter.addSeries(series4);
            series4.setColor(Color.GRAY);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader5 = null;
        try {
            File GraphFile5 = new File(getFilesDir()+"/graph-series5.csv");
            FileInputStream fis5 = new FileInputStream(GraphFile5);
            DataInputStream in5 = new DataInputStream(fis5);
            reader5 = new BufferedReader(new InputStreamReader(in5));
            // comment - otherwise it ignores first two lines (here, the csv file is intended to exist without headers)
//            reader.readLine();  //skip first line of file
//            reader.readLine();  //skip second line of file
            String mline5;

            ArrayList<DataPoint> arrDataPoint5=new ArrayList<>();
            while ((mline5 = reader5.readLine()) != null) {
                valXY5 = mline5.split(",");
                X5val = Double.parseDouble(valXY5[0]);
                Y5val = Double.parseDouble(valXY5[1]);
                DataPoint dp5 = new DataPoint(X5val, Y5val);
                arrDataPoint5.add(dp5);
            }
            DataPoint[] listDp5 = new DataPoint[arrDataPoint5.size()];
            for(int i=0;i<arrDataPoint5.size();i++){
                listDp5[i]=arrDataPoint5.get(i);
            }
            PointsGraphSeries<DataPoint> series5 = new PointsGraphSeries<>(listDp5);
            scatter.addSeries(series5);
            series5.setColor(Color.YELLOW);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader6 = null;
        try {
            File GraphFile6 = new File(getFilesDir()+"/graph-series6.csv");
            FileInputStream fis6 = new FileInputStream(GraphFile6);
            DataInputStream in6 = new DataInputStream(fis6);
            reader6 = new BufferedReader(new InputStreamReader(in6));
            // comment - otherwise it ignores first two lines (here, the csv file is intended to exist without headers)
//            reader.readLine();  //skip first line of file
//            reader.readLine();  //skip second line of file
            String mline6;

            ArrayList<DataPoint> arrDataPoint6=new ArrayList<>();
            while ((mline6 = reader6.readLine()) != null) {
                valXY6 = mline6.split(",");
                X6val = Double.parseDouble(valXY6[0]);
                Y6val = Double.parseDouble(valXY6[1]);
                DataPoint dp6 = new DataPoint(X6val, Y6val);
                arrDataPoint6.add(dp6);
            }
            DataPoint[] listDp6 = new DataPoint[arrDataPoint6.size()];
            for(int i=0;i<arrDataPoint6.size();i++){
                listDp6[i]=arrDataPoint6.get(i);
            }
            PointsGraphSeries<DataPoint> series6 = new PointsGraphSeries<>(listDp6);
            scatter.addSeries(series6);
            series6.setColor(Color.BLUE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader7 = null;
        try {
            File GraphFile7 = new File(getFilesDir()+"/graph-series7.csv");
            FileInputStream fis7 = new FileInputStream(GraphFile7);
            DataInputStream in7 = new DataInputStream(fis7);
            reader7 = new BufferedReader(new InputStreamReader(in7));
            // comment - otherwise it ignores first two lines (here, the csv file is intended to exist without headers)
//            reader.readLine();  //skip first line of file
//            reader.readLine();  //skip second line of file
            String mline7;

            ArrayList<DataPoint> arrDataPoint7=new ArrayList<>();
            while ((mline7 = reader7.readLine()) != null) {
                valXY7 = mline7.split(",");
                X7val = Double.parseDouble(valXY7[0]);
                Y7val = Double.parseDouble(valXY7[1]);
                DataPoint dp7 = new DataPoint(X7val, Y7val);
                arrDataPoint7.add(dp7);
            }
            DataPoint[] listDp7 = new DataPoint[arrDataPoint7.size()];
            for(int i=0;i<arrDataPoint7.size();i++){
                listDp7[i]=arrDataPoint7.get(i);
            }
            PointsGraphSeries<DataPoint> series7 = new PointsGraphSeries<>(listDp7);
            scatter.addSeries(series7);
            series7.setColor(Color.BLACK);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader8 = null;
        try {
            File GraphFile8 = new File(getFilesDir()+"/graph-series8.csv");
            FileInputStream fis8 = new FileInputStream(GraphFile8);
            DataInputStream in8 = new DataInputStream(fis8);
            reader8 = new BufferedReader(new InputStreamReader(in8));
            // comment - otherwise it ignores first two lines (here, the csv file is intended to exist without headers)
//            reader.readLine();  //skip first line of file
//            reader.readLine();  //skip second line of file
            String mline8;

            ArrayList<DataPoint> arrDataPoint8=new ArrayList<>();
            while ((mline8 = reader8.readLine()) != null) {
                valXY8 = mline8.split(",");
                X8val = Double.parseDouble(valXY8[0]);
                Y8val = Double.parseDouble(valXY8[1]);
                DataPoint dp8 = new DataPoint(X8val, Y8val);
                arrDataPoint8.add(dp8);
            }
            DataPoint[] listDp8 = new DataPoint[arrDataPoint8.size()];
            for(int i=0;i<arrDataPoint8.size();i++){
                listDp8[i]=arrDataPoint8.get(i);
            }
            PointsGraphSeries<DataPoint> series8 = new PointsGraphSeries<>(listDp8);
            scatter.addSeries(series8);
            series8.setColor(Color.MAGENTA);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader9 = null;
        try {
            File GraphFile9 = new File(getFilesDir()+"/graph-series9.csv");
            FileInputStream fis9 = new FileInputStream(GraphFile9);
            DataInputStream in9 = new DataInputStream(fis9);
            reader9 = new BufferedReader(new InputStreamReader(in9));
            // comment - otherwise it ignores first two lines (here, the csv file is intended to exist without headers)
//            reader.readLine();  //skip first line of file
//            reader.readLine();  //skip second line of file
            String mline9;

            ArrayList<DataPoint> arrDataPoint9=new ArrayList<>();
            while ((mline9 = reader9.readLine()) != null) {
                valXY9 = mline9.split(",");
                X9val = Double.parseDouble(valXY9[0]);
                Y9val = Double.parseDouble(valXY9[1]);
                DataPoint dp9 = new DataPoint(X9val, Y9val);
                arrDataPoint9.add(dp9);
            }
            DataPoint[] listDp9 = new DataPoint[arrDataPoint9.size()];
            for(int i=0;i<arrDataPoint9.size();i++){
                listDp9[i]=arrDataPoint9.get(i);
            }
            PointsGraphSeries<DataPoint> series9 = new PointsGraphSeries<>(listDp9);
            scatter.addSeries(series9);
            series9.setColor(Color.CYAN);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader10 = null;
        try {
            File GraphFile10 = new File(getFilesDir()+"/graph-series10.csv");
            FileInputStream fis10 = new FileInputStream(GraphFile10);
            DataInputStream in10 = new DataInputStream(fis10);
            reader10 = new BufferedReader(new InputStreamReader(in10));
            // comment - otherwise it ignores first two lines (here, the csv file is intended to exist without headers)
//            reader.readLine();  //skip first line of file
//            reader.readLine();  //skip second line of file
            String mline10;

            ArrayList<DataPoint> arrDataPoint10=new ArrayList<>();
            while ((mline10 = reader10.readLine()) != null) {
                valXY10 = mline10.split(",");
                X10val = Double.parseDouble(valXY10[0]);
                Y10val = Double.parseDouble(valXY10[1]);
                DataPoint dp10 = new DataPoint(X10val, Y10val);
                arrDataPoint10.add(dp10);
            }
            DataPoint[] listDp10 = new DataPoint[arrDataPoint10.size()];
            for(int i=0;i<arrDataPoint10.size();i++){
                listDp10[i]=arrDataPoint10.get(i);
            }
            PointsGraphSeries<DataPoint> series10 = new PointsGraphSeries<>(listDp10);
            scatter.addSeries(series10);
            series10.setColor(Color.LTGRAY);
        } catch (IOException e) {
            e.printStackTrace();
        }

        scatter.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
        scatter.getViewport().setScrollable(true);  // activate horizontal scrolling
        scatter.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
        scatter.getViewport().setScrollableY(true);  // activate vertical scrolling

    }

}
