package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class StartPage_Page2 extends AppCompatActivity {
    // asdjklasjdklasjdkljasdlkjsalkdasjdlksajdjasdljkasdlkjasd
    private Button button1, button2, button3;
    private boolean isExpanded = false;
    private Animation slideUpAnimation, slideDownAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage_page2);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
    }

    private void toggle() {
        if (isExpanded) {
            button1.setText("Start");
            button1.startAnimation(slideDownAnimation);
            button2.setVisibility(View.GONE);
            button3.setVisibility(View.GONE);
        } else {
            button1.setText("Stop");
            button1.startAnimation(slideUpAnimation);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
        }
        isExpanded = !isExpanded;
    }
}
