package com.you.vieweventdemo;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by youxuan on 2017/5/9 0009.
 */

public class DragViewGroup extends FrameLayout{

    private ViewDragHelper mDragHelper;
    private View mMenuView;
    private View mMainView;

    private int mWidth;


    public DragViewGroup(@NonNull Context context) {
        super(context);
        initView();
    }

    public DragViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    public DragViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mDragHelper = ViewDragHelper.create(this,mCallback);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mMainView = getChildAt(1);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = mMenuView.getMeasuredWidth();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //将触摸时间传递给ViewDragHelper
        mDragHelper.processTouchEvent(ev);
        return true;
    }

    private ViewDragHelper.Callback mCallback = new ViewDragHelper.Callback() {

        //何时开始检测触摸事件
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            //如果当前触摸的child是mMainView时开始检测
            return mMainView == child;
        }

        //处理水平事件
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }

        //返回0  不处理垂直事件
        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }

        //拖动结束后调用

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild,xvel,yvel);
            if (mMainView.getLeft()<500){
                //关闭菜单
                mDragHelper.smoothSlideViewTo(mMainView,0,0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }else{
                //打开菜单
                mDragHelper.smoothSlideViewTo(mMainView,300,0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }
        }
    };

    @Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }
}
