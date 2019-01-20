package com.example.cameo_rosehack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

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
