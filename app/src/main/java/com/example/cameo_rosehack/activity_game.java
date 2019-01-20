package com.example.cameo_rosehack;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import android.content.Intent;
import java.util.List;
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

    private String key1 = "SaveKey1";
    private String key2 = "SaveKey2";

    public List<Card> p1cards;
    public List<Card> p2cards;

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

        p1cards = new ArrayList<>(4);
        ArrayList<Card> tempList1 = new ArrayList<Card>(d.getCards());
        p1cards.add(tempList1.remove(0));
        p1cards.add(tempList1.remove(0));
        p1cards.add(tempList1.remove(0));
        p1cards.add(tempList1.remove(0));


        p2cards = new ArrayList<>(4);
        p2cards.add(tempList1.remove(0));
        p2cards.add(tempList1.remove(0));
        p2cards.add(tempList1.remove(0));
        p2cards.add(tempList1.remove(0));
    }

    // Play Game
    void Play() {
        switch (state) {                // Transition Actions
            case INIT:                  // Start state
                state = PLAYER1;        // Go to PLAYER1 state
                break;

            case PLAYER1:               // PLAYER1 state
                button9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        state = END;
                    }
                });
                break;

            case PLAYER2:               // PLAYER2 state
                button6.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        state = END;
                    }
                });
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
                DealCardsToPlayers(draw);

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

                //IStRUE = FALSE;
                break;
        }

        GameEnd();
    }


    private void GameEnd()
    {

        Intent intent = new Intent( this, end_game.class);

        for (int i = 0; i < p1cards.size(); ++i)
        {
            Card curCard = p1cards.get(i);
            int value = curCard.getNum();
            if (curCard.getNum() == 13 && (curCard.getSuit() == 'h' || curCard.getSuit() == 'd'))
            {
                value = -1;
            }
            intent.putExtra(key1 + String.valueOf(i), value);
        }

        for (int i = 0; i < p2cards.size(); ++i)
        {
            Card curCard = p2cards.get(i);
            int value = curCard.getNum();
            if (curCard.getNum() == 13 && (curCard.getSuit() == 'h' || curCard.getSuit() == 'd'))
            {
                value = -1;
            }
            intent.putExtra(key2 + String.valueOf(i), value);
        }

        startActivity(intent);
        //use intent here because we want to move to end_game activity
    }

}
