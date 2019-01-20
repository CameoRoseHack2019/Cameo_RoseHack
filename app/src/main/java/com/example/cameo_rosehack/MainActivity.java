package com.example.cameo_rosehack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


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
                drawCard(40);
            }

        });
        cards_player[1].setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                drawCard(24);
            }

        });
        cards_player[2].setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                drawCard(32);
            }

        });
        cards_player[3].setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                drawCard(14);
            }

        });
    }

    protected void drawCard(int cardNum)
    {
        text.setVisibility(View.INVISIBLE);
        middle.setVisibility(View.VISIBLE);
        middle.setBackgroundResource(cards[cardNum]);
//        switch(cardNum)
//        {
//            case 1: middle.setBackgroundResource(R.drawable.h1); break;
//            case 2: middle.setBackgroundResource(R.drawable.h2); break;
//            case 3: middle.setBackgroundResource(R.drawable.h3); break;
//            case 4: middle.setBackgroundResource(R.drawable.h4); break;
//            case 5: middle.setBackgroundResource(R.drawable.h5); break;
//            case 6: middle.setBackgroundResource(R.drawable.h6); break;
//            case 7: middle.setBackgroundResource(R.drawable.h7); break;
//            case 8: middle.setBackgroundResource(R.drawable.h8); break;
//            case 9: middle.setBackgroundResource(R.drawable.h9); break;
//            case 10: middle.setBackgroundResource(R.drawable.h10); break;
//            case 11: middle.setBackgroundResource(R.drawable.h11); break;
//            case 12: middle.setBackgroundResource(R.drawable.h12); break;
//            case 13: middle.setBackgroundResource(R.drawable.h13); break;
//        }
    }
}
