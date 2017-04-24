package com.you.vieweventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by youxuan on 2017/4/24 0024.
 */

public class MyButton extends Button {

    public static final String TAG = MyButton.class.getSimpleName();


    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchEvent: Action_down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouchEvent: Action_move");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "onTouchEvent: Action_up");
                break;
        }
        return super.onTouchEvent(event);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "dispatchTouchEvent: Action_down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "dispatchTouchEvent: Action_move");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "dispatchTouchEvent: Action_up");
                break;
        }
        return super.dispatchTouchEvent(event);
    }
}
