package com.example.cameo_rosehack;

//import android.app.Activity;
import android.os.Bundle;
//import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;

public class countDown extends AppCompatActivity {

    Button buttonStart;
    TextView textCounter;

    MyCountDownTimer myCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time);

        buttonStart = (Button)findViewById(R.id.button);
        textCounter = (TextView)findViewById(R.id.textView);

        buttonStart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                myCountDownTimer = new MyCountDownTimer(5000, 1000);
                myCountDownTimer.start();
            }
        });

    }
    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            textCounter.setText("Seconds: " + millisUntilFinished / 1000);

        }
        @Override
        public void onFinish() {
            textCounter.setText("Finished!");
        }


    }}


