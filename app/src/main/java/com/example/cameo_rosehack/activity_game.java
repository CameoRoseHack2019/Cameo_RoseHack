package com.example.cameo_rosehack;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

import java.util.ArrayList;
import android.content.Intent;
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
    List<Card> player1Cards = new ArrayList<>(4);
    List<Card> player2Cards = new ArrayList<>(4);
    Deck draw = new Deck();
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

    TextView TimerText1;
    TextView TimerText2;

    private String key1 = "SaveKey1";
    private String key2 = "SaveKey2";

    public List<Card> discard;
    public List<Card> p1cards;
    public List<Card> p2cards;

    private boolean timerIsOn;
    MyCountDownTimer1 myCountDownTimer1;
    MyCountDownTimer2 myCountDownTimer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games);
        draw.shuffleDeck();
        button7 = (Button) findViewById(R.id.button7);
        button9 = (Button) findViewById(R.id.button9);
        button6 = (Button) findViewById(R.id.button6);
        button8 = (Button) findViewById(R.id.button8);
        btt_p1_c1 = (Button) findViewById(R.id.btt_p1_c1);
        btt_p1_c2 = (Button) findViewById(R.id.btt_p1_c2);
        btt_p1_c3 = (Button) findViewById(R.id.btt_p1_c3);
        btt_p1_c4 = (Button) findViewById(R.id.btt_p1_c4);
        btt_p1_c5 = (Button) findViewById(R.id.btt_p1_c5);
        btt_p1_c6 = (Button) findViewById(R.id.btt_p1_c6);
        btt_p2_c1 = (Button) findViewById(R.id.btt_p2_c1);
        btt_p2_c2 = (Button) findViewById(R.id.btt_p2_c2);
        btt_p2_c3 = (Button) findViewById(R.id.btt_p2_c3);
        btt_p2_c4 = (Button) findViewById(R.id.btt_p2_c4);
        btt_p2_c6 = (Button) findViewById(R.id.btt_p2_c6);
        btt_p2_c5 = (Button) findViewById(R.id.btt_p2_c5);
        btt_deck1 = (Button) findViewById(R.id.btt_deck1);
        btt_deck2 = (Button) findViewById(R.id.btt_deck2);
        btt_discard1 = (Button) findViewById(R.id.btt_discard1);
        btt_discard2 = (Button) findViewById(R.id.btt_discard2);
        p1display = (Button) findViewById(R.id.p1display);
        p2display = (Button) findViewById(R.id.p2display);
        TimerText1 = (TextView) findViewById(R.id.timer1);
        TimerText2 = (TextView) findViewById(R.id.timer2);
        timerIsOn = false;

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
    

    void play(){

        Boolean isTrue = true;
        while(   isTrue    ) {

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<Card> tempList = draw.getCards();
                    Random randomIndex = new Random();
                    int randomNumber = randomIndex.nextInt(draw.size());
                    Card toDisplay = draw.getCards().get(randomNumber);
                    tempList.remove(randomNumber);
                    int player1Display = getResources().getIdentifier(String.valueOf(toDisplay.getSuit()) + toDisplay.getNum(), "drawable", getPackageName());
                    p1display.setBackgroundResource(player1Display);
                    p1cards.add(toDisplay);
                }
            });

            p1display.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!timerIsOn){
                        timerIsOn = true;
                        startTimer1();
                        startTimer2();
                        return;
                    }




                    if (p1cards.get(p1cards.size() - 1).getNum() == 7 ||p1cards.get(p1cards.size() - 1).getNum() == 8)
                    {
                        // look at bottom car
                    }
                    else if(p1cards.get(p1cards.size() - 1).getNum() == 9 ||p1cards.get(p1cards.size() - 1).getNum() == 10)
                    {
                        // look at top card
                    }
                    else if (p1cards.get(p1cards.size() - 1).getNum() == 11 ||p1cards.get(p1cards.size() - 1).getNum() == 12)
                    {
                        // swap one of my card with deck
                    }
                    else if (p1cards.get(p1cards.size() - 1).getNum() == 13 && (p1cards.get(p1cards.size() - 1).getSuit() == 'c' || p1cards.get(p1cards.size() - 1).getSuit() == 's' )
                    {
                        // give opponent card
                    }

                }


            });

                    //  P1 CARD =======================================================

            btt_p1_c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerIsOn) {
                        timerIsOn = false;
                        // somehow delete card
                    }
                }
            });
            btt_p1_c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btt_p1_c2.getVisibility() == View.VISIBLE) {
                        if (timerIsOn) {
                            timerIsOn = false;
                            btt_p1_c2.setVisibility(View.INVISIBLE);
                            p1cards.set(1,null);
                        }
                        // TODO: Do the same for all the card buttons!!!!
                    }
                }
            });
            btt_p1_c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerIsOn) {
                        // if card exists herr
                        timerIsOn = false;
                        // somehow delete card
                    }
                }
            });
            btt_p1_c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerIsOn) {
                        // if card exists here
                        timerIsOn = false;
                        // somehow delete card
                    }
                }
            });
            btt_p1_c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerIsOn) {
                        // if card exists here
                        /timerIsOn = false;
                        // somehow delete card
                    }
                }
            });
            btt_p1_c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerIsOn) {
                        // if card exists here
                        timerIsOn = false;
                        // somehow delete card
                    }
                }
            });

            btt_p2_c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerIsOn) {
                        // if card exists here
                        timerIsOn = false;
                        // somehow delete card
                    }
                }
            });

            btt_p2_c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // if card exists here
                    if (timerIsOn) {
                        timerIsOn = false;
                        // somehow delete card
                    }
                }
            });
            btt_p2_c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerIsOn) {
                        timerIsOn = false;
                        // somehow delete card
                    }
                }
            });
            btt_p2_c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerIsOn) {
                        timerIsOn = false;
                        // somehow delete card
                    }
                }
            });
            btt_p2_c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerIsOn) {
                        timerIsOn = false;
                        // somehow delete card
                    }
                }
            });
            btt_p2_c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerIsOn) {
                        timerIsOn = false;
                        // somehow delete card
                    }
                }
            });
        }
    }

    private void GameEnd()
    {

        Intent intent = new Intent( this , end_game.class);

        int player1Total = 0;
        for (int i = 0; i < p1cards.size(); ++i)
        {
            Card curCard = p1cards.get(i);
            int value = curCard.getNum();
            if (curCard.getNum() == 13 && (curCard.getSuit() == 'h' || curCard.getSuit() == 'd'))
            {
                value = -1;
            }
            player1Total += value;
            intent.putExtra(key1, player1Total);
        }

        int player2Total = 0;
        for (int i = 0; i < p2cards.size(); ++i)
        {
            Card curCard = p2cards.get(i);
            int value = curCard.getNum();
            if (curCard.getNum() == 13 && (curCard.getSuit() == 'h' || curCard.getSuit() == 'd'))
            {
                value = -1;
            }
            player2Total += value;
            intent.putExtra(key2, player2Total);
        }
        startActivity(intent);

        //use intent here because we want to move to end_game activity
    }

    private void startTimer1()
    {

        myCountDownTimer1 = new MyCountDownTimer1(5000, 1000);
        myCountDownTimer1.start();
    }
    private void startTimer2()
    {
        myCountDownTimer2 = new MyCountDownTimer2(5000, 1000);
        myCountDownTimer2.start();
    }
    public class MyCountDownTimer1 extends CountDownTimer {

            public MyCountDownTimer1(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override
            public void onTick(long millisUntilFinished) {
                TimerText1.setText("seconds: " + millisUntilFinished / 1000);

            }
            @Override
            public void onFinish() {
                timerIsOn = false;
                TimerText1.setText("Finished!");
            }
    }
    public class MyCountDownTimer2 extends CountDownTimer {

        public MyCountDownTimer2(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            TimerText2.setText("seconds: " + millisUntilFinished / 1000);

        }
        @Override
        public void onFinish() {
            TimerText2.setText("Finished!");
        }
    }