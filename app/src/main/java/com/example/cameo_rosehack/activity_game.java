package com.example.cameo_rosehack;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.example.cameo_rosehack.state.ACTION;
import static com.example.cameo_rosehack.state.END;
import static com.example.cameo_rosehack.state.INIT;
import static com.example.cameo_rosehack.state.PLAYER1;
import static com.example.cameo_rosehack.state.PLAYER2;
import static com.example.cameo_rosehack.state.TIMER;


enum state{INIT, PLAYER1, PLAYER2, TIMER, ACTION, END}

public class Deck{
    private List<Card> cards;

    public Deck(){
        cards = new ArrayList<>(54);
        populateDeck();
    }

    public void populateDeck(){
        for(int i = 0; i < 13; i++) {
            cards.add(new Card('S', i + 1));
            cards.add(new Card('C', i + 1));
        }
        for(int i = 0; i < 12; i++) {
            cards.add(new Card('H', i + 1));
            cards.add(new Card('D', i + 1));
        }
        cards.add(new Card('H', -1));
        cards.add(new Card('D', -1));
        cards.add(new Card('J', 0));
        cards.add(new Card('J', 0));
    }

    public void shuffleDeck(){

    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}

public class activity_game extends AppCompatActivity {
    /*
    cards:
    0: jorker
    1 - 13: heart
    14 - 26: spade
    27 - 39: dia
    40 - 52: club
    53: jorker
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

       /* Button[] cards_opponent = {
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

    public void DealCardsToPlayers(){

    }

    // Play Game
    void Play() {
        switch (state) {                // Transition Actions
            case INIT:                  // Start state
                state = PLAYER1;        // Go to PLAYER1 state
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

        switch (state) {                // state Actions
            case INIT:                  // Start state
                Deck draw = new Deck();
                draw.shuffleDeck();
                DealCardsToPlayers();

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
    }
}
