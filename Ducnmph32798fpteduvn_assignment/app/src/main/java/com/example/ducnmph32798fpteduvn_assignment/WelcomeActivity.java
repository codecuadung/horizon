package com.example.ducnmph32798fpteduvn_assignment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ivLogo = findViewById(R.id.imageView);

        AnimationDrawable animationDrawable = new AnimationDrawable();
        ivLogo.setBackground(animationDrawable);

        // Kiểm tra ivLogo.getBackground() != null trước khi gọi phương thức
        if (ivLogo.getBackground() != null) {
            AnimationDrawable anim =
                    (AnimationDrawable) ivLogo.getBackground();
            anim.setEnterFadeDuration(2000);
            anim.setExitFadeDuration(4000);
        }

        animationDrawable.start();

        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this,
                        LoginActivity.class));
                finish();
            }
        });
    }
}