package com.example.cameo_rosehack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
// The different states that the game will be in at all times from start to finish.

// MainActivity
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void exit(View view ){
        finish();
    }
    public void start(View view){
        Intent intent = new Intent( this, activity_game.class);
        startActivity(intent);
    }
}
