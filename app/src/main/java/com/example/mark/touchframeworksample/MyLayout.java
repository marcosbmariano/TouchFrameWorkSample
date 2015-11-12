package com.example.mark.touchframeworksample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import android.widget.RelativeLayout;

/**
 * Created by mark on 11/12/15.
 */
public class MyLayout extends RelativeLayout {
    public static final String TAG ="MYLAYOUT";
    private Paint paint;



    public MyLayout(Context context){
        super(context);
        init();
    }

    public MyLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }

    //this method should be called by every constructor
    public void init(){
        paint = new Paint();
        paint.setAntiAlias(true);
        //a ViewGroup sub class did not call its on Drawn method
        //so disable this call by setting setWillNotDraw to false
        setWillNotDraw(false);
    }

    // all the views and activity have this method and when a action is detected it is passed
    // from the  the Activity to its childs until it is intercepeted by onInterceptTouchEvent
    // or it is handled by a view(the view returns true if the MotionEvent was consumed or false otherwise)
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean isEventConsumed;
        //there is many more actions, those cited here are just the basic ones
        switch (ev.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MyLayout dispatchTouchEvent DOWN");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MyLayout dispatchTouchEvent MOVE");
                break;

            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MyLayout dispatchTouchEvent UP");
                break;

            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MyLayout dispatchTouchEvent CANCEL");
                break;
        }

        isEventConsumed = super.dispatchTouchEvent(ev);

        Log.d(TAG,"MyLayout dispatchTouchEvent RETURNS " + isEventConsumed);
        return isEventConsumed;
    }

    /*
    The onInterceptTouchEvent() method is called whenever a touch event is detected on the surface
    of a ViewGroup, including on the surface of its children. If onInterceptTouchEvent() returns
    true, the MotionEvent is intercepted, meaning it will be not be passed on to the child,
    but rather to the onTouchEvent() method of the parent.
    */

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean isEventConsumed;
        switch (ev.getActionMasked()){

            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MyLayout onInterceptTouchEvent DOWN");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MyLayout onInterceptTouchEvent MOVE");
                //isntead of calling super, only in case of MOVE this method
                //will return true, so the ACTION_MOVE will be intercepted by this
                //layout onTouchEvent and will be consumed by it;
                return true;
               // break;

            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MyLayout onInterceptTouchEvent UP");
                break;

            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MyLayout onInterceptTouchEvent CANCEL");
                break;
        }
        isEventConsumed = super.onInterceptTouchEvent(ev);

        Log.d(TAG,"MyLayout onInterceptTouchEvent RETURNS " + isEventConsumed);

        return isEventConsumed;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean isEventConsumed;

        switch (event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MyLayout onTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MyLayout onTouchEvent MOVE");
                return true;

                //break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MyLayout onTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MyLayout onTouchEvent CANCEL");
                break;
        }
        isEventConsumed = super.onTouchEvent(event);
        Log.d(TAG,"MyLayout onTouchEvent RETURNS " + isEventConsumed);

        return isEventConsumed;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.GRAY);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);
    }
}











































//