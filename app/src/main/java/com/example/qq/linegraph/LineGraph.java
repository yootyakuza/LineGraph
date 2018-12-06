package com.example.qq.linegraph;


import java.util.Arrays;
import java.util.Collections;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class LineGraph extends View {

    private Integer[] visitorsList;
    private Integer[] actionList;
    private int viewHeight;
    private int viewWidth;
    private int xInterval;
    private int yMax;

    public LineGraph(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }

    public LineGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Calculate Dimensions
        viewHeight = getHeight();
        viewWidth = getWidth();
        xInterval = (viewWidth - 10) / 23;
        yMax = Collections.max(Arrays.asList(actionList));
        int strokeWidth = 3;

        //Paint
        Paint fillPaint = new Paint();
        fillPaint.setAntiAlias(true);
        fillPaint.setColor(Color.GRAY);

        Paint strokePaint = new Paint();
        strokePaint.setAntiAlias(true);
        strokePaint.setStyle(Style.STROKE);
        strokePaint.setStrokeWidth(strokeWidth);
        strokePaint.setColor(Color.parseColor("#F77300"));

        //Draw Line For Actions
        Path actionFillPath = new Path();
        actionFillPath.moveTo(5, viewHeight - 5);
        Path actionStrokePath = new Path();

        float[] yPoints = new float[48];
        int xIncrementer = 5;
        int yIncrementer = 0;

        for (int i = 0; i < actionList.length; i++) {
            int pValue = (actionList[i] * 100) / yMax;
            int yValue = (viewHeight - 5) - ((pValue * (viewHeight - 10)) / 100);
            actionFillPath.lineTo(xIncrementer, yValue);

            if (i == 0) {
                actionStrokePath.moveTo(xIncrementer, yValue);
            } else {
                actionStrokePath.lineTo(xIncrementer, yValue);
            }

            yPoints[yIncrementer] = xIncrementer;
            yIncrementer += 1;
            yPoints[yIncrementer] = yValue;
            yIncrementer += 1;

            xIncrementer += xInterval;
        }
        canvas.drawPath(actionFillPath, fillPaint);
        canvas.drawPath(actionStrokePath, strokePaint);
        fillPaint.setColor(Color.parseColor("#F77300"));
        for (int j = 0; j < yPoints.length; j += 2) {
            canvas.drawCircle(yPoints[j], yPoints[j + 1], strokeWidth, fillPaint);
        }

        //Draw Line For Visitors
        actionStrokePath.reset();
        xIncrementer = 5;
        yIncrementer = 0;
        for (int i = 0; i < visitorsList.length; i++) {
            int pValue = (visitorsList[i] * 100) / yMax;
            int yValue = (viewHeight - 5) - ((pValue * (viewHeight - 10)) / 100);
            if (i == 0) {
                actionStrokePath.moveTo(xIncrementer, yValue);
            } else {
                actionStrokePath.lineTo(xIncrementer, yValue);
            }

            yPoints[yIncrementer] = xIncrementer;
            yIncrementer += 1;
            yPoints[yIncrementer] = yValue;
            yIncrementer += 1;

            xIncrementer += xInterval;
        }
        strokePaint.setColor(Color.parseColor("#0075EB"));
        fillPaint.setColor(Color.parseColor("#0075EB"));
        canvas.drawPath(actionStrokePath, strokePaint);
        for (int j = 0; j < yPoints.length; j += 2) {
            canvas.drawCircle(yPoints[j], yPoints[j + 1], strokeWidth, fillPaint);
        }
    }

    public void setData(Integer[] visitors, Integer[] actions) {
        visitorsList = visitors;
        actionList = actions;
    }
}
