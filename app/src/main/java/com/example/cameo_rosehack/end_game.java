package com.example.cameo_rosehack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class end_game extends AppCompatActivity {

    int player1Total;
    int player2Total;


    private String key1 = "SaveKey1";
    private String key2 = "SaveKey2";

    private TextView resulttext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);

        Intent an = getIntent();
        Bundle b = an.getExtras();

        player1Total = (int)b.get(key1);
        player2Total = (int)b.get(key2);

        if (player2Total > player1Total)
        {
            resulttext.setText("Player 1 won!\n" + Integer.toString(player1Total));
        }
        else if (player1Total > player2Total)
        {
            resulttext.setText("Player 2 won!\n" + Integer.toString(player2Total));
        }
        else
        {
            resulttext.setText("Tie!");
        }

    }
    //access the array from activity_game using intent intent
    //need to know: how many cards are left at the end
    //              : the values & suits of the cards
    //add values
}
