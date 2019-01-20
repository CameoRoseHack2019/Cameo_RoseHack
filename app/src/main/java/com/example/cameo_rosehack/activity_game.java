package com.example.cameo_rosehack;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class activity_game extends AppCompatActivity
{
    private Button middle;
    private TextView text;
    /*
    cards:
    0: jorker
    1 - 13: heart
    14 - 26: spade
    27 - 39: dia
    40 - 52: club
    53: jorker
     */
    private int[] cards =
            {
                    R.drawable.black_joker,
                    R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7,
                    R.drawable.h8, R.drawable.h9, R.drawable.h10, R.drawable.h11, R.drawable.h12, R.drawable.h13,
                    R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5, R.drawable.s6, R.drawable.s7,
                    R.drawable.s8, R.drawable.s9, R.drawable.s10, R.drawable.s11, R.drawable.s12, R.drawable.s13,
                    R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7,
                    R.drawable.d8, R.drawable.d9, R.drawable.d10, R.drawable.d11, R.drawable.d12, R.drawable.d13,
                    R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7,
                    R.drawable.c8, R.drawable.c9, R.drawable.c10, R.drawable.c11, R.drawable.h12, R.drawable.c13,
                    R.drawable.red_joker
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games);

        middle = findViewById(R.id.button_middle);
        text = findViewById(R.id.text);

        Button[] cards_opponent = {
                (Button) findViewById(R.id.btt_p2_c1),
                (Button) findViewById(R.id.btt_p2_c2),
                (Button) findViewById(R.id.btt_p2_c3),
                (Button) findViewById(R.id.btt_p2_c4),
                (Button) findViewById(R.id.btt_p2_c5),
                (Button) findViewById(R.id.btt_p2_c6)
        };

        Button[] cards_player = {
                (Button) findViewById(R.id.btt_p1_c1),
                (Button) findViewById(R.id.btt_p1_c2),
                (Button) findViewById(R.id.btt_p1_c3),
                (Button) findViewById(R.id.btt_p1_c4),
                (Button) findViewById(R.id.btt_p1_c5),
                (Button) findViewById(R.id.btt_p1_c6)
        };
    }

    //protected void drawCard(int cardNum)
    //{
    //    text.setVisibility(View.INVISIBLE);
    //    middle.setVisibility(View.VISIBLE);
    //    middle.setBackgroundResource(cards[cardNum]);
    //}
}
