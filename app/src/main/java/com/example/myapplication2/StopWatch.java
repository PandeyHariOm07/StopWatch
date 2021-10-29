package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatch extends AppCompatActivity {
Button btnStart,btnStop;
ImageView icanchor;
Animation roundingalone;
Chronometer timerHere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        icanchor = findViewById(R.id.anchor);
        timerHere = findViewById(R.id.timerHere);

        btnStop.setAlpha(0);
        roundingalone = AnimationUtils.loadAnimation(this,R.anim.round);

        Typeface Medium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        btnStart.setTypeface(Medium);
        btnStop.setTypeface(Medium);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(roundingalone);
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.clearAnimation();
                btnStart.animate().alpha(1).setDuration(300).start();
                btnStop.animate().alpha(0).setDuration(300).start();
                timerHere.stop();
            }
        });
    }
}