package com.example.samir.entregavel3.Model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.samir.entregavel3.Fragments.FragmentoUmImagemFragment;
import com.example.samir.entregavel3.MainActivity;
import com.example.samir.entregavel3.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageViewSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageViewSplash = findViewById(R.id.splash);

        imageViewSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump();
            }
        });

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        }, 5000);
    }

    private void jump() {
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        finish();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
