package com.example.qq.linegraph;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

@SuppressLint("DrawAllocation")
public class CreateLineGraph extends View {

    int x0;
    int y0;
    int xEnd;
    int yEnd;

    public CreateLineGraph(Context context) {
        super(context);
    }

    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        x0 = (canvas.getWidth()) / 10;
        y0 = (canvas.getHeight()) / 10 * 9;
        xEnd = canvas.getWidth();
        yEnd = 0 + (canvas.getHeight() / 10);

        // draw x axis
        Rect x_axis = new Rect();
        x_axis.set(x0, y0, xEnd, y0 + 5);
        Paint x_axis_color = new Paint();
        x_axis_color.setColor(Color.RED);
        canvas.drawRect(x_axis, x_axis_color);

        // draw y axis
        Rect y_axis = new Rect();
        y_axis.set(x0, yEnd, x0 + 5, y0);
        Paint y_axis_color = new Paint();
        y_axis_color.setColor(Color.RED);
        canvas.drawRect(y_axis, y_axis_color);

        // draw data
        Paint point_color = new Paint();
        point_color.setColor(Color.GREEN);

        canvas.drawCircle(x0, y0, 3, point_color);
        canvas.drawCircle(x0 + 10, y0 - 260, 3, point_color);
        canvas.drawCircle(x0 + 20, y0 - 290, 3, point_color);
        canvas.drawCircle(x0 + 30, y0 - 240, 3, point_color);
        canvas.drawCircle(x0 + 40, y0 - 120, 3, point_color);
        canvas.drawCircle(x0 + 50, y0 - 130, 3, point_color);
        canvas.drawCircle(x0 + 60, y0 - 80, 3, point_color);
        canvas.drawCircle(x0 + 70, y0 - 50, 3, point_color);
        canvas.drawCircle(x0 + 80, y0 - 450, 3, point_color);

        // draw line
        Paint line_color = new Paint();
        line_color.setColor(Color.BLUE);

        canvas.drawLine(x0, y0, x0 + 10, y0 - 260, line_color);
        canvas.drawLine(x0 + 10, y0 - 260, x0 + 20, y0 - 290, line_color);

        // start draw
        invalidate();

        //LineChartInCanvas
        //step 0 : draw x-axis, y-axis
        //step 1 : draw round points on specific x,y position
        //step 2 : draw a line to connect those points
        //step 3 : use database to change points, and effect line.
        //step 4 : let chart use Y-money, X-date
        //step 5 : let X-date can go infinite future
        //step 6 : use calculation to get future data
        //step 7 : combine calculation and database
        //test
        //finish
    }
}
