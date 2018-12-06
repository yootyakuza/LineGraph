package com.example.qq.linegraph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout containerLayout;
    private LineGraph lcChart;
    private Integer[] visitorList1 = {45, 87, 90, 50, 85, 122, 44, 123, 675, 234, 235, 22, 41, 0, 50, 85, 122, 44, 45, 23, 10, 22, 43, 0};
    private Integer[] actionList1 = {123, 96, 234, 55, 800, 890, 233, 123, 675, 234, 456, 22, 45, 0, 800, 890, 233, 123, 675, 234, 456, 22, 45, 0};
    private Integer[] visitorList2 = {50, 85, 122, 44, 45, 23, 10, 22, 43, 0, 45, 87, 90, 50, 85, 122, 44, 123, 675, 234, 235, 22, 41, 0};
    private Integer[] actionList2 = {800, 890, 233, 123, 675, 234, 456, 22, 45, 0, 123, 96, 234, 55, 800, 890, 233, 123, 675, 234, 456, 22, 45, 0};
    private int mode = 1;
    private Button two,draw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        containerLayout = findViewById(R.id.container_id);
        draw = findViewById(R.id.draw);
        two = findViewById(R.id.two);
        lcChart = new LineGraph(this);
        lcChart.setData(visitorList1, actionList1);
        containerLayout.addView(lcChart);

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mode == 1) {
                    lcChart.setData(visitorList2, actionList2);
                    mode = 2;
                } else {
                    lcChart.setData(visitorList1, actionList1);
                    mode = 1;
                }
                lcChart.invalidate();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
            }
        });

    }
}
