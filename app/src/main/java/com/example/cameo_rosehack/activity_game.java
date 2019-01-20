package com.example.cameo_rosehack;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.Display;
import android.widget.Button;
import android.widget.TextView;

public class activity_game extends AppCompatActivity
{


    private Button middle;
    private TextView text;

    private int[] value_opponent; // like int[0] = 13 if the first card of the opponent is King.
    private int[] value_player;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        middle = findViewById(R.id.button_middle);
        text = findViewById(R.id.text);

       Button[] cards_opponent = {
                (Button) findViewById(R.id.button_c1_opp),
                (Button) findViewById(R.id.button_c2_opp),
                (Button) findViewById(R.id.button_c3_opp),
                (Button) findViewById(R.id.button_c4_opp),
                (Button) findViewById(R.id.button_c5_opp),
                (Button) findViewById(R.id.button_c6_opp),
                (Button) findViewById(R.id.button_c7_opp),
                (Button) findViewById(R.id.button_c8_opp)
        };

        Button[] cards_player = {
                (Button) findViewById(R.id.button_c1),
                (Button) findViewById(R.id.button_c2),
                (Button) findViewById(R.id.button_c3),
                (Button) findViewById(R.id.button_c4),
                (Button) findViewById(R.id.button_c5),
                (Button) findViewById(R.id.button_c6),
                (Button) findViewById(R.id.button_c7),
                (Button) findViewById(R.id.button_c8)
        };

        cards_player[0].setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                test();
            }

        });
    }

    protected void test()
    {
        middle.setBackgroundResource(R.drawable.card); // idk how to change background :(
    }
    protected void drawCard(int cardNum)
    {
        text.setVisibility(View.INVISIBLE);
        middle.setVisibility(View.VISIBLE);
        //middle.setBackgroundResource(R.drawable."dia7.png"); // idk how to change background :(
    }
}
