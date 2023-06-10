package cz.p;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SpectrumDFTB extends Dftb {

    String valXY[];
    Double Xval;
    Double Yval;
    GraphView graph;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);

//        GraphView graph = (GraphView) findViewById(R.id.graph);
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
//        });
//        graph.addSeries(series);


        GraphView graph = (GraphView) findViewById(R.id.graph);

        BufferedReader reader = null;
        try {
//            reader = new BufferedReader(new InputStreamReader(getAssets().open("plot/excel_data_abp.csv")));
            File GraphFile = new File(getFilesDir()+"/spectrum.csv");
            FileInputStream fis = new FileInputStream(GraphFile);
            DataInputStream in = new DataInputStream(fis);
            reader = new BufferedReader(new InputStreamReader(in));
            reader.readLine();  //skip first line of file
            reader.readLine();  //skip second line of file
            String mline;

            ArrayList<DataPoint> arrDataPoint=new ArrayList<>();
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
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(listDp);
            graph.addSeries(series);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        graph.getViewport().setXAxisBoundsManual(true);
//        graph.getViewport().setMinX(0);
//        graph.getViewport().setMaxX(1);

//        graph.getViewport().setScrollable(true); // enables horizontal scrolling
//        graph.getViewport().setScrollableY(true); // enables vertical scrolling

        graph.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
        graph.getViewport().setScrollable(true);  // activate horizontal scrolling
        graph.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
        graph.getViewport().setScrollableY(true);  // activate vertical scrolling

    }
}
