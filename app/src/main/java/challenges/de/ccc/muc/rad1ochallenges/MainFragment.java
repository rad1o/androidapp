package challenges.de.ccc.muc.rad1ochallenges;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.PercentFormatter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

/**
 * Created by Nicolas on 30.07.2015.
 */
public  class MainFragment extends Fragment implements
        OnChartValueSelectedListener {


    private PieChart mChart;
    private float[] yData = { 30, 20};
    private String[] xData = { "Completed", "Remaining"};
    public ImageView profileImage;


    public MainFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);



    }

    public void setDiagrammData(float[]yData){
        this.yData = yData;
    }

    public float[] getDiagrammData(){
        return yData;
    }

    public void updateDiagramm(){
        setData();
    }


    private void setData() {



        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < yData.length; i++)
            yVals1.add(new Entry(yData[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xData.length; i++)
            xVals.add(xData[i]);

        // create pie data set
        PieDataSet dataSet = new PieDataSet(yVals1, "Challenges");




        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.rgb(0, 150, 136));
        colors.add(Color.rgb(244, 67, 54));


        //colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        //data.setValueTypeface(tf);
        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex);
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mChart = (PieChart) rootView.findViewById(R.id.pieMain);
        mChart.setUsePercentValues(true);
        mChart.setDescription("");

        mChart.setDragDecelerationFrictionCoef(0.95f);

        //tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");

        //mChart.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf"));

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColorTransparent(true);

        mChart.setTransparentCircleColor(Color.WHITE);


        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);



        // add a selection listener
        mChart.setOnChartValueSelectedListener(this);

        mChart.setCenterText("Challenges Complete \n"+Math.round(yData[0])+" of "+( Math.round(yData[0]+yData[1])));

        setData();

        mChart.animateY(1500, Easing.EasingOption.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(getActivity()));
        profileImage = (ImageView) rootView.findViewById(R.id.imageView);
        imageLoader.displayImage("http://www.ride-on.info/tl_files/bilder_ron_user/profilbilder/member_6350.jpg", profileImage);
        return rootView;
    }
}