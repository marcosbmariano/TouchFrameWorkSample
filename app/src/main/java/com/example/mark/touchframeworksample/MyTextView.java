package com.example.mark.touchframeworksample;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by mark on 11/12/15.
 */
public class MyTextView extends TextView {
    public static final String TAG ="MY_TEXTVIEW";
    private Paint mPaint;

    public MyTextView(Context context){
        super(context);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }


    public MyTextView(Context context, AttributeSet attrs, int defStyleAttrs){
        super(context, attrs,defStyleAttrs);
        init();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean isEventConsumed;

        switch (event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "View dispatchTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "View dispatchTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "View dispatchTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "View dispatchTouchEvent DOWN");
                break;
        }

        isEventConsumed = super.dispatchTouchEvent(event);
        return isEventConsumed;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean isEventConsumed;

        switch (event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "View onTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "View onTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "View onTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "View onTouchEvent CANCEL");
                break;
        }

        isEventConsumed = super.onTouchEvent(event);
        return isEventConsumed;
    }

    //init must be always called by the constructors
    public void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

}
