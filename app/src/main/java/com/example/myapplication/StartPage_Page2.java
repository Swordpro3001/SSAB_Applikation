package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.TransitionManager;

public class StartPage_Page2 extends AppCompatActivity {

    private Button button1, button2, button3;
    private boolean isExpanded = false;
    private ConstraintSet expandedConstraintSet = new ConstraintSet();
    private ConstraintSet collapsedConstraintSet = new ConstraintSet();
    private ConstraintLayout constraintLayout;
    private Animation slideUpAnimation, slideDownAnimation;
    private Animation slideOutFadeInAnimation, fadeOutSlideInAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage_page2);

        constraintLayout = findViewById(R.id.linearLayout);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        collapsedConstraintSet.clone(constraintLayout);
        expandedConstraintSet.clone(constraintLayout);

        slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        slideOutFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_and_fade_in);
        fadeOutSlideInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out_and_slide_in);

        // Set the top margin higher for both sets
        int marginTop = 50; // Adjust this value as needed
        collapsedConstraintSet.setMargin(R.id.button1, ConstraintSet.TOP, marginTop);
        expandedConstraintSet.setMargin(R.id.button1, ConstraintSet.TOP, marginTop - 500);

        expandedConstraintSet.setVisibility(R.id.button2, ConstraintSet.VISIBLE);
        expandedConstraintSet.setVisibility(R.id.button3, ConstraintSet.VISIBLE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
    }

    private void toggle() {
        TransitionManager.beginDelayedTransition(constraintLayout);

        if (isExpanded) {
            collapsedConstraintSet.applyTo(constraintLayout);
            button2.startAnimation(fadeOutSlideInAnimation);
            button3.startAnimation(fadeOutSlideInAnimation);
            button1.setText("Start");
        } else {
            expandedConstraintSet.applyTo(constraintLayout);
            button2.startAnimation(fadeOutSlideInAnimation);
            button3.startAnimation(fadeOutSlideInAnimation);
            button1.setText("Stop");
        }

        isExpanded = !isExpanded;
    }
}