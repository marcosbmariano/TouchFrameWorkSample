package com.example.mark.touchframeworksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyTextView mMTextView;
    TextView mAxisDisplay;
    public static final String TAG ="MAIN_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMyTextView();




    }

    private void setupMyTextView(){

        mAxisDisplay = (TextView)findViewById(R.id.axis_display);


        mMTextView = (MyTextView) findViewById(R.id.myTextView);
        mMTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "From TEXT", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void setmAxisDisplayText(float x, float y){
        mAxisDisplay.setText(" X position: " + x + " Y position " + y);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean isEventConsumed;
        float axisX =  ev.getAxisValue(MotionEvent.AXIS_X);
        float axisY =  ev.getAxisValue(MotionEvent.AXIS_Y);
        setmAxisDisplayText(axisX, axisY);


        //there is many more actions, those cited here are just the basic ones
        switch (ev.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MainActivity dispatchTouchEvent DOWN");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MainActivity dispatchTouchEvent MOVE");
                break;

            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MainActivity dispatchTouchEvent UP");
                break;

            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MainActivity dispatchTouchEvent CANCEL");
                break;
        }

        isEventConsumed = super.dispatchTouchEvent(ev);

        Log.d(TAG, "MyLayout dispatchTouchEvent RETURNS " + isEventConsumed);
        return isEventConsumed;
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean isEventConsumed;

        switch (event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MainActivity onTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MainActivity onTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MainActivity onTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MainActivity onTouchEvent CANCEL");
                break;
        }

        isEventConsumed = super.onTouchEvent(event);
        return isEventConsumed;
    }
}
