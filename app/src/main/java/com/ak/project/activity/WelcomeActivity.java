package com.ak.project.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.ak.project.R;

public class WelcomeActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    TextView txt_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_welcome);

        txt_status = findViewById(R.id.txt_status);
        lottieAnimationView = findViewById(R.id.animationView);
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                txt_status.setVisibility(View.VISIBLE);

            }
        });
    }
}