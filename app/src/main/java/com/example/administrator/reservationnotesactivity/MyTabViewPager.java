package com.example.administrator.reservationnotesactivity;

import android.content.Context;
import android.support.annotation.Px;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/8/24.
 */

/**
 * 定制ViewPager，目的是为了设置Tab能否滑动
 */

public class MyTabViewPager extends ViewPager {

    private Boolean isCanScroll = false;   //ViewPager能否滑动，初始值为false

    public MyTabViewPager(Context context) {
        super(context);
    }

    public MyTabViewPager(Context context, AttributeSet attributeSet) {

        super(context, attributeSet);
    }


    public void setCanScroll(Boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    @Override
    public void scrollTo(@Px int x, @Px int y) {
        super.scrollTo(x, y);
    }


    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, false);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if (isCanScroll) {
            return super.onTouchEvent(ev);
        } else {
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isCanScroll) {
            return super.onInterceptTouchEvent(ev);
        } else {
            return false;
        }
    }

}
