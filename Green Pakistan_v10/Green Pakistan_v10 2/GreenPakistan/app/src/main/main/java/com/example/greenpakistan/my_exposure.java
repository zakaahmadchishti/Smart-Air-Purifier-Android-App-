package com.example.greenpakistan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.SingleValueDataSet;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.CircularGauge;
import com.anychart.core.cartesian.series.Area;
import com.anychart.core.ui.Crosshair;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.MarkerType;
import com.anychart.enums.ScaleStackMode;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.text.HAlign;

import java.util.ArrayList;
import java.util.List;

public class my_exposure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_exposure);
        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_Bar));

        CircularGauge circularGauge = AnyChart.circular();
        circularGauge.fill("#fff")
                .stroke(null)
                .padding(0, 0, 0, 0)
                .margin(30, 30, 30, 30);
        circularGauge.startAngle(0)
                .sweepAngle(360);

        double currentValue = 40.2D;
        circularGauge.data(new SingleValueDataSet(new Double[] { currentValue }));

        circularGauge.axis(0)
                .startAngle(-150)
                .radius(80)
                .sweepAngle(300)
                .width(3)
                .ticks("{ type: 'line', length: 4, position: 'outside' }");

        circularGauge.axis(0).labels().position("outside");

        circularGauge.axis(0).scale()
                .minimum(0)
                .maximum(140);

        circularGauge.axis(0).scale()
                .ticks("{interval: 10}")
                .minorTicks("{interval: 10}");

        circularGauge.needle(0)
                .stroke(null)
                .startRadius("6%")
                .endRadius("38%")
                .startWidth("2%")
                .endWidth(0);

        circularGauge.cap()
                .radius("4%")
                .enabled(true)
                .stroke(null);

        circularGauge.label(0)
                .text("<span style=\"font-size: 25\">Green Pakistan</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER);
        circularGauge.label(0)
                .anchor(Anchor.CENTER_TOP)
                .offsetY(100)
                .padding(50, 18, 0, 0);

        circularGauge.label(1)
                .text("<span style=\"font-size: 20\">" + currentValue + "</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER);
        circularGauge.label(1)
                .anchor(Anchor.CENTER_TOP)
                .offsetY(-100)
                .padding(5, 10, 0, 0)
                .background("{fill: 'none', stroke: '#c1c1c1', corners: 3, cornerType: 'ROUND'}");

        circularGauge.range(0,
                "{\n" +
                        "    from: 0,\n" +
                        "    to: 25,\n" +
                        "    position: 'inside',\n" +
                        "    fill: 'green 0.5',\n" +
                        "    stroke: '1 #000',\n" +
                        "    startSize: 6,\n" +
                        "    endSize: 6,\n" +
                        "    radius: 80,\n" +
                        "    zIndex: 1\n" +
                        "  }");

        circularGauge.range(1,
                "{\n" +
                        "    from: 80,\n" +
                        "    to: 140,\n" +
                        "    position: 'inside',\n" +
                        "    fill: 'red 0.5',\n" +
                        "    stroke: '1 #000',\n" +
                        "    startSize: 6,\n" +
                        "    endSize: 6,\n" +
                        "    radius: 80,\n" +
                        "    zIndex: 1\n" +
                        "  }");

        anyChartView.setChart(circularGauge);
    }
}