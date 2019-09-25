package com.example.betweenanim;

import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.ScaleAnimation;

public class MainActivity extends AppCompatActivity {

    View demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demo = findViewById(R.id.demo);

        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleAnimation();
            }
        });
    }

    private void scaleAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 1.4f, 1f, 1.4f);
        scaleAnimation.setDuration(500);
        scaleAnimation.setFillAfter(true);
        demo.startAnimation(scaleAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.4f, 1f, 1.4f, 1f);
                scaleAnimation.setDuration(500);
                scaleAnimation.setFillAfter(true);
                demo.startAnimation(scaleAnimation);
            }
        }, 1500);
    }
}
