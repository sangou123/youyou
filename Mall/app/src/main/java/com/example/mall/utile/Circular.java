package com.example.mall.utile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class Circular extends View {
    private Paint mPaint1;

    private Paint mPaint2;

    private Paint mPaint3;

    private Paint mPaintText;
    public Circular(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint1 = new Paint();
        mPaint1.setAntiAlias(true);
        mPaint1.setColor(Color.GRAY);
        // mPaint1.setColor(Color.GREEN);
        //  设置样式为，空心的，这样那园环就出来了
        mPaint1.setStyle(Paint.Style.STROKE);
        // 设置那个圆环的粗细
        mPaint1.setStrokeWidth(30);

        mPaint2 = new Paint();
        mPaint2.setAntiAlias(true);
        mPaint2.setColor(Color.WHITE);
        // mPaint2.setColor(Color.RED);
        //  设置样式为，空心的，这样那园环就出来了
        mPaint2.setStyle(Paint.Style.STROKE);
        // 设置那个圆环的粗细
        mPaint2.setStrokeWidth(40);

        mPaint3 = new Paint();
        mPaint3.setAntiAlias(true);
        mPaint3.setColor(Color.GRAY);
        // mPaint3.setColor(Color.BLUE);
        //  设置样式为，空心的，这样那园环就出来了
        mPaint3.setStyle(Paint.Style.STROKE);
        // 设置那个圆环的粗细
        mPaint3.setStrokeWidth(40);

        mPaintText = new Paint();
        mPaintText.setAntiAlias(true);
        mPaintText.setColor(Color.BLACK);
        mPaintText.setTextSize(24);
    }

    

    private int w;
    private int h;

    private final int MOVE_VALUE = 88;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        w = MeasureSpec.getSize(widthMeasureSpec);
        h = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 定义一个区域
        // 左边，上边，都给0
        // 右边与下边都给200
        RectF rectF = new RectF(200, 20, 156, 356);

        /*canvas.drawArc(rectF, 0, 241.2f, false, mPaint1);
        canvas.drawArc(rectF, 241.2f, 10, false, mPaint2);*/

        // useCenter：false  代表不花圆心

        // canvas.drawArc(rectF, 此值是开始点, 此值并不是从开始点到此值点 它会记录之前的值自动进行累加,false, mPaint1);

        // 360 * 0.67 = 241.2
       // canvas.drawArc(rectF, 0 - MOVE_VALUE, 241.2f, false, mPaint1);
        canvas.drawArc(rectF, 90f, 360, false, mPaint1);

        // 360 * 0.23
        //canvas.drawArc(rectF, 241.2f - MOVE_VALUE, 82.0f, false, mPaint2);

        // 360 * 0.10
      //  canvas.drawArc(rectF, 241.2f + 82.0f - MOVE_VALUE, 36, false, mPaint3);

//        canvas.drawText("67%", canvas.getWidth() - 70, (canvas.getHeight() / 2) + 80, mPaintText);
//
//        canvas.drawText("23%", 5, (canvas.getHeight() / 2) - 26, mPaintText);
//
//        canvas.drawText("10%", 116, 34, mPaintText);

        // draw();
    }

    // 可以实现缓慢加载绘制的效果，但没有实际意义，就全部去除了

    /*private int countI;

    private void draw() {
        countI++;
        if (countI < 120) {
            SystemClock.sleep(18);
            invalidate();
        }
    }*/


}
