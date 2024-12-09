package com.bansal.seller_app;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splashscreen extends AppCompatActivity {
    ImageView ivApplogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashscreen);
        getWindow().setNavigationBarColor(ContextCompat.getColor(Splashscreen.this,R.color.white));
        getWindow().setStatusBarColor(ContextCompat.getColor(Splashscreen.this,R.color.white));

        ivApplogo = findViewById(R.id.ivApplogo);
        animateSplashScreen();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splashscreen.this,LoginActivity.class);
                startActivity(i);
            }
        },6000);



    }

    private void animateSplashScreen() {
        ObjectAnimator logoAnimator = ObjectAnimator.ofFloat(ivApplogo, "scaleX", 0f, 1f);
        logoAnimator.setDuration(1000);
        logoAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        logoAnimator.start();

        ObjectAnimator logoAnimatorY = ObjectAnimator.ofFloat(ivApplogo, "scaleY", 0f, 1f);
        logoAnimatorY.setDuration(1000);
        logoAnimatorY.setInterpolator(new AccelerateDecelerateInterpolator());
        logoAnimatorY.start();
    }
}