package com.you.vieweventdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * Created by youxuan on 2017/4/28 0028.
 */

public class LineView extends View {
    public static final String TAG ="LineView";
    private Paint mPaint;
    private float currentHeight = getMeasuredHeight();
    private float offset = 10;
    private int count = 10;
    private float mWidth =1000;
    private float mRectWidth = 50;
    private float mRectHeight = 2000;


    public LineView(Context context) {
        super(context);
        Log.d(TAG, "LineView: ");
        mPaint = new Paint();
        mPaint.setTextSize(50f);
        mPaint.setColor(Color.RED);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        
        super(context, attrs);
        Log.d(TAG, "LineView: ");
        mPaint = new Paint();
        mPaint.setTextSize(50f);
        mPaint.setColor(Color.RED);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Log.d(TAG, "LineView: ");
        mPaint = new Paint();
        mPaint.setTextSize(50f);
        mPaint.setColor(Color.RED);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < count; i++) {
            double random = Math.random();
            Log.d(TAG, "random: "+random);
            currentHeight = (float) (mRectHeight*random);
            Log.d(TAG, "onDraw: "+currentHeight);

            canvas.drawRect(
                    (float) (mWidth * 0.4 / 2 + mRectWidth * i + offset),
                    currentHeight,
                    (float)(mWidth * 0.4 / 2 + mRectWidth * (i + 1)),
                    getMeasuredHeight(), mPaint);
        }


       // canvas.drawRect(0,0,100,getMeasuredHeight(),mPaint);

      //  canvas.drawText("sdfidsf",100f,100f,mPaint);

        postInvalidateDelayed(300);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectHeight=getHeight();
        mRectWidth = (int)(mWidth*0.6/count);
        LinearGradient mline = new LinearGradient(
                0,0,mRectWidth,mRectHeight,Color.YELLOW,Color.BLUE, Shader.TileMode.CLAMP
        );
        mPaint.setShader(mline);

    }
}
