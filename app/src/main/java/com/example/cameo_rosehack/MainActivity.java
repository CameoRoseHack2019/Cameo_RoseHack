package com.example.cameo_rosehack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import static com.example.cameo_rosehack.state.ACTION;
import static com.example.cameo_rosehack.state.END;
import static com.example.cameo_rosehack.state.INIT;
import static com.example.cameo_rosehack.state.PLAYER1;
import static com.example.cameo_rosehack.state.PLAYER2;
import static com.example.cameo_rosehack.state.TIMER;

// The different states that the game will be in at all times from start to finish.
enum state{INIT, PLAYER1, PLAYER2, TIMER, ACTION, END;}

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
        for(i = 0; i < 12; i++) {
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

    public void start(View view){
        Intent intent = new Intent( this, activity_game.class);
        startActivity(intent);
    }
}
