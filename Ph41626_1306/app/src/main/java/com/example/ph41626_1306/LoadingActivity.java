package com.example.ph41626_1306;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class LoadingActivity extends AppCompatActivity {

    LinearLayout item_alpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        item_alpha = findViewById(R.id.item_alpha);


        Animation animation = AnimationUtils.loadAnimation(LoadingActivity.this,R.anim.alpha);
        item_alpha.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoadingActivity.this,MainActivity.class));
                finish();
            }
        },3000);
    }
}