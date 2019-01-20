package com.example.cameo_rosehack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
<<<<<<< HEAD
//import java.util.Timer;
=======
>>>>>>> master

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
<<<<<<< HEAD

    public void start(View view){
        Intent intent = new Intent( this, countDown.class);
=======
    public void start(View view){
        Intent intent = new Intent( this, activity_game.class);
>>>>>>> master
        startActivity(intent);
    }
}
