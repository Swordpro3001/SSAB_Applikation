package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class StartPage_Page2 extends Vibration_Page1 {
    private Button startButton;
    private Button buttonB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage_page2);

        startButton = findViewById(R.id.button1);
        // buttonB = findViewById();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation slideUp = AnimationUtils.loadAnimation(StartPage_Page2.this, R.anim.move_up);
                startButton.startAnimation(slideUp);

                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        buttonB.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}
                });
            }
        });
    }
}