package com.example.qq.linegraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    CreateLineGraph lineGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lineGraph = new CreateLineGraph(getApplicationContext());
        setContentView(lineGraph);
    }
}
