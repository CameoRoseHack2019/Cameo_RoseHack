package com.example.cameo_rosehack;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.cameo_rosehack.state.ACTION;
import static com.example.cameo_rosehack.state.END;
import static com.example.cameo_rosehack.state.INIT;
import static com.example.cameo_rosehack.state.PLAYER1;
import static com.example.cameo_rosehack.state.PLAYER2;
import static com.example.cameo_rosehack.state.TIMER;


enum state{INIT, PLAYER1, PLAYER2, TIMER, ACTION, END}

public class activity_game extends AppCompatActivity {
    Button button7;
    Button button9;
    Button button6;
    Button button8;
    Button btt_p1_c1;
    Button btt_p1_c2;
    Button btt_p1_c3;
    Button btt_p1_c4;
    Button btt_p1_c5;
    Button btt_p1_c6;
    Button btt_p2_c1;
    Button btt_p2_c2;
    Button btt_p2_c3;
    Button btt_p2_c4;
    Button btt_p2_c5;
    Button btt_p2_c6;
    Button btt_deck1;
    Button btt_deck2;
    Button btt_discard1;
    Button btt_discard2;
    Button p1display;
    Button p2display;

    /*
    cards:
    0: joker
    1 - 13: heart
    14 - 26: spade
    27 - 39: dia
    40 - 52: club
    53: joker
     */
   /* private int[] cards =
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
            };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games);
        button7 = (Button)findViewById(R.id.button7);
        button9 = (Button)findViewById(R.id.button9);
        button6 = (Button)findViewById(R.id.button6);
        button8 = (Button)findViewById(R.id.button8);
        btt_p1_c1 = (Button)findViewById(R.id.btt_p1_c1);
        btt_p1_c2 = (Button)findViewById(R.id.btt_p1_c2);
        btt_p1_c3 = (Button)findViewById(R.id.btt_p1_c3);
        btt_p1_c4 = (Button)findViewById(R.id.btt_p1_c4);
        btt_p1_c5 = (Button)findViewById(R.id.btt_p1_c5);
        btt_p1_c6 = (Button)findViewById(R.id.btt_p1_c6);
        btt_p2_c1 = (Button)findViewById(R.id.btt_p2_c1);
        btt_p2_c2 = (Button)findViewById(R.id.btt_p2_c2);
        btt_p2_c3 = (Button)findViewById(R.id.btt_p2_c3);
        btt_p2_c4 = (Button)findViewById(R.id.btt_p2_c4);
        btt_p2_c6 = (Button)findViewById(R.id.btt_p2_c6);
        btt_p2_c5 = (Button)findViewById(R.id.btt_p2_c5);
        btt_deck1 = (Button)findViewById(R.id.btt_deck1);
        btt_deck2 = (Button)findViewById(R.id.btt_deck2);
        btt_discard1 = (Button)findViewById(R.id.btt_discard1);
        btt_discard2 = (Button)findViewById(R.id.btt_discard2);
        p1display = (Button)findViewById(R.id.p1display);
        p2display = (Button)findViewById(R.id.p2display);

       /* Button[] cards_opponent = {

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
    }*/

        //protected void drawCard(int cardNum)
        //{
        //    text.setVisibility(View.INVISIBLE);
        //    middle.setVisibility(View.VISIBLE);
        //    middle.setBackgroundResource(cards[cardNum]);
        //}

    }

    public void DealCardsToPlayers(Deck d) {
        List<Card> p1cards = new ArrayList<>(4);
        ArrayList<Card> tempList1 = d.getCards();
        p1cards.add(tempList1.remove());
        p1cards.add(tempList1.remove());
        p1cards.add(tempList1.remove());
        p1cards.add(tempList1.remove());


        List<Card> p2cards;
        List<Card> tempList2 = d.getCards();
        p2cards.add(tempList2.remove());
        p2cards.add(tempList2.remove());
        p2cards.add(tempList2.remove());
        p2cards.add(tempList2.remove());
    }

    // Play Game
    void Play(state S) {
        switch (S) {                // Transition Actions
            case INIT:                  // Start state
                S = PLAYER1;        // Go to PLAYER1 state
                break;

            case PLAYER1:               // PLAYER1 state

                break;

            case PLAYER2:               // PLAYER2 state

                break;

            case TIMER:                 // TIMER state

                break;

            case ACTION:                // ACTION state

                break;

            case END:                   // END state;

                break;
        }

        switch (S) {                // state Actions
            case INIT:                  // Start state
                final Deck draw = new Deck();
                draw.shuffleDeck();
                DealCardsToPlayers(draw);

                break;

            case PLAYER1:               // PLAYER1 state

                button7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<> tempList = new List<>;
                        Random randomIndex = new Random();
                        int randomNumber = randomIndex.nextInt();

                    }
                });
                break;

            case PLAYER2:               // PLAYER2 state

                break;

            case TIMER:                 // TIMER state

                break;

            case ACTION:                // ACTION state

                break;

            case END:                   // END state;

                break;
        }
    }
}
