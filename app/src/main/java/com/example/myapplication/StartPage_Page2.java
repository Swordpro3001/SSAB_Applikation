package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class StartPage_Page2 extends AppCompatActivity {

    private Button button1, button2, fortfahrenpause;
    private ImageView pause, fortfahren;
    private boolean isExpanded = false;
    private Animation slideUpAnimation, slideDownAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage_page2);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        fortfahrenpause = findViewById(R.id.fortfahrenpause);

        pause = findViewById(R.id.pause);
        fortfahren = findViewById(R.id.fortfahren);

        slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);

        pause.setVisibility(View.GONE);
        fortfahren.setVisibility(View.GONE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
        fortfahrenpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImageViews();
            }
        });
    }

    private void toggle() {
        if (isExpanded) {
            button1.setText("Start");
            button1.startAnimation(slideDownAnimation);
            button2.setVisibility(View.GONE);
            fortfahrenpause.setVisibility(View.GONE);
            pause.setVisibility(View.GONE);
            fortfahren.setVisibility(View.GONE);

        } else {
            button1.setText("Stop");
            button1.startAnimation(slideUpAnimation);
            button2.setVisibility(View.VISIBLE);
            fortfahrenpause.setVisibility(View.VISIBLE);
            pause.setVisibility(View.VISIBLE);
        }
        isExpanded = !isExpanded;
    }
    private void toggleImageViews() {
        // Umkehrung der Sichtbarkeit von pause und fortfahren
        int pauseVisibility = pause.getVisibility();
        int fortfahrenVisibility = fortfahren.getVisibility();

        pause.setVisibility(fortfahrenVisibility);
        fortfahren.setVisibility(pauseVisibility);
    }
}
