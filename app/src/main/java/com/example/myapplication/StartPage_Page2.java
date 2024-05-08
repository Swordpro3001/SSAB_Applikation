package com.example.myapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class StartPage_Page2 extends AppCompatActivity {

    private Button startButton, stopPauseButtonKlein;
    private Chronometer chronometer;
    private boolean isExpanded = false;
    private Animation slideUpAnimation, slideDownAnimation;
    private long pauseOffset = 0;
    private boolean isPlaying = false;
    private int zaehler = 0;

    private ImageView pause, fortfahren;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage_page2);

        startButton = findViewById(R.id.button1);
        chronometer = findViewById(R.id.chronometer);
        stopPauseButtonKlein = findViewById(R.id.fortfahrenpause);

        pause = findViewById(R.id.pause);
        fortfahren = findViewById(R.id.fortfahren);

        slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);

        // Initially hide the stop button and chronometer
        stopPauseButtonKlein.setVisibility(View.GONE);
        chronometer.setVisibility(View.GONE);

        pause.setVisibility(View.GONE);
        fortfahren.setVisibility(View.GONE);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleChronometer();
            }
        });

        stopPauseButtonKlein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImageViews();
                pauseChronometer();
                if(zaehler % 2 != 0){
                    startChronometer();
                }
                zaehler++;
            }
        });
    }

    private void toggleChronometer() {
        if (isExpanded) {
            startButton.setText("Start");
            startButton.startAnimation(slideDownAnimation);
            stopPauseButtonKlein.setVisibility(View.GONE);
            chronometer.setVisibility(View.GONE);
            pause.setVisibility(View.GONE);
            fortfahren.setVisibility(View.GONE);
            pauseChronometer();
        } else {
            startButton.setText("Stop");
            startButton.startAnimation(slideUpAnimation);
            stopPauseButtonKlein.setVisibility(View.VISIBLE);
            chronometer.setVisibility(View.VISIBLE);
            pause.setVisibility(View.VISIBLE);
            startChronometer();
        }
        isExpanded = !isExpanded;
    }

    private void startChronometer() {
        chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
        chronometer.start();
        isPlaying = true;
    }

    private void pauseChronometer() {
        chronometer.stop();
        pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
        isPlaying = false;
    }

    private void toggleImageViews() {
        // Umkehrung der Sichtbarkeit von pause und fortfahren
        int pauseVisibility = pause.getVisibility();
        int fortfahrenVisibility = fortfahren.getVisibility();

        pause.setVisibility(fortfahrenVisibility);
        fortfahren.setVisibility(pauseVisibility);
    }
}