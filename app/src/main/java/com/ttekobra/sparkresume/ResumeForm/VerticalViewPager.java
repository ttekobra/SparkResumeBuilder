package com.ttekobra.sparkresume.ResumeForm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VerticalViewPager extends ViewPager {

    public VerticalViewPager(@NonNull Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPageTransformer(true, new VerticalPage());
        setOverScrollMode(OVER_SCROLL_NEVER);

    }

    private MotionEvent getIntercambioXY(MotionEvent mv) {
        float width = getWidth();
        float height = getHeight();

        float newX = (mv.getY() / height) * width;
        float newY = (mv.getX() / width) * height;

        mv.setLocation(newX, newY);

        return mv;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = super.onInterceptTouchEvent(getIntercambioXY(ev));
        getIntercambioXY(ev);
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(getIntercambioXY(ev));
    }

    private class VerticalPage implements ViewPager.PageTransformer {

        @Override
        public void transformPage(@NonNull View view, float v) {
            if (v < -1) {
                view.setAlpha(0);
            } else if (v <= 1) {
                view.setAlpha(1);
                view.setTranslationX(view.getWidth() * -v);
                float yPosition = v * view.getHeight();
                view.setTranslationY(yPosition);
            } else {
                view.setAlpha(0);
            }
        }
    }
}
