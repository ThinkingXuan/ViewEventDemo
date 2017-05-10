package com.you.vieweventdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.Toast;

/**
 * Created by youxuan on 2017/5/8 0008.
 */

public class dropView extends View{
    int lastX;
    int lastY;
    Scroller scroller;

    public dropView(Context context) {
        super(context);
    }

    public dropView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    public dropView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scroller = new Scroller(context);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
               // Toast.makeText(getContext(), "down", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //方法一
//                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
                //方法二
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
                //方法三
//                ViewGroup.MarginLayoutParams param = (ViewGroup.MarginLayoutParams) getLayoutParams();
//                param.leftMargin = getLeft()+offsetX;
//                param.topMargin = getTop() + offsetY;
//                setLayoutParams(param);
                //方法四
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;

            case MotionEvent.ACTION_UP:
                View viewgroup = (View) getParent();
                scroller.startScroll(viewgroup.getScrollX(),viewgroup.getScrollY(),-viewgroup.getScrollX(),-viewgroup.getScrollY(),1000);
                invalidate();
                break;
        }
        //他自己进行处理,不要交给上级
        return true;
    }


    @Override
    public void computeScroll() {
        super.computeScroll();
        //判断Scroller是否执行完毕
        if (scroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(scroller.getCurrX(),scroller.getCurrY());
            invalidate();
        }
    }
}
