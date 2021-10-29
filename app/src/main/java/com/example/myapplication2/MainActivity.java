package com.example.myapplication2;

import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class  MainActivity extends AppCompatActivity {

    TextView text1,text2;
    Button btn;
    Animation atg,btgone,btgtwo;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        btn = findViewById(R.id.btn);
        image =findViewById(R.id.photo);
        //load Animation
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo);
        image.startAnimation(atg);
        text1.startAnimation(btgone);
        text2.startAnimation(btgone);
        btn.startAnimation(btgtwo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,StopWatch.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        //import font
        Typeface a = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface b = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface c = Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");

        text1.setTypeface(c);
        text2.setTypeface(a);
        btn.setTypeface(b);
    }

}