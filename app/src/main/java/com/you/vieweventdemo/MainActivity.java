package com.you.vieweventdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MyButton";
    private MyButton mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (MyButton) findViewById(R.id.myButton);

        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "onTouch: Action_down");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "onTouch: Action_move");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "onTouch: Action_up");
                        break;
                }
                return false;
            }
        });
    }
}
