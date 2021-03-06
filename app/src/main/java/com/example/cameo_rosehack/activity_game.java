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

    private boolean IsP1Turn;
    private boolean IsP2Turn; // TODO: set IsP2Turn = true when P2 is playing. Do the same for P1.

    private boolean timerIsOn;
    private boolean timerDone;

    private boolean CardDrawn;
    private boolean IsReadyToDraw;

    private boolean FlipBottomCard;
    private boolean BottomCardFlipped;
    MyCountDownTimer1 myCountDownTimer1;
    MyCountDownTimer2 myCountDownTimer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games);


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
        timerDone = false;
        CardDrawn = false;
        IsReadyToDraw = false;

        FlipBottomCard = false;
        BottomCardFlipped = false;

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
    

    //TODO: implement these four functions :)
    void LookAtBottomCard() {
        FlipBottomCard = true;
        // do something
        /*
        1. you make a player click bottom two card
        2. when either of the two cards is clicked, make it visible
        3. after the player clicked the card again, make it fipped (backside)
        done.
         */




    }



    void LookAtTopCard() {
        // do something
    }

    void SwapCardWithDeck() {
        // do something
    }

    void GiveOpponentCard() {
        // give opponent card
    }

    void action() {
        Card CurCard;
        if (IsP1Turn) {
            CurCard = p1cards.get(p1cards.size() - 1);
        } else {
            CurCard = p2cards.get(p2cards.size() - 1);
        }

        if (CurCard.getNum() == 7 || CurCard.getNum() == 8) {
            LookAtBottomCard();
        } else if (CurCard.getNum() == 9 || CurCard.getNum() == 10) {
            LookAtTopCard();
        } else if (CurCard.getNum() == 11 || CurCard.getNum() == 12) {
            SwapCardWithDeck();
        } else if (CurCard.getNum() == 13 && (CurCard.getSuit() == 'c' || CurCard.getSuit() == 's')) {
            GiveOpponentCard();
        }

        return;
    }

    private void StartTimer() {
        timerIsOn = true;
        startTimer1();
        startTimer2();
    }

    private void DrawCard() {
        if (!IsReadyToDraw) return;
        IsReadyToDraw = false;
        List<Card> tempList = draw.getCards();
        Random randomIndex = new Random();
        int randomNumber = randomIndex.nextInt(draw.size());
        Card toDisplay = draw.getCards().get(randomNumber);
        tempList.remove(randomNumber);

        if (IsP1Turn) {
            int player1Display = getResources().getIdentifier(String.valueOf(toDisplay.getSuit()) + toDisplay.getNum(), "drawable", getPackageName());
            p1display.setBackgroundResource(player1Display);
            p1cards.add(toDisplay);
        } else {
            int player2Display = getResources().getIdentifier(String.valueOf(toDisplay.getSuit()) + toDisplay.getNum(), "drawable", getPackageName());
            p2display.setBackgroundResource(player1Display);
            p2cards.add(toDisplay);
        }
        CardDrawn = true;
    }

    void play() {

        Boolean isTrue = true;
        while (isTrue) {

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DrawCard();
                }
            }); // draw card

            p1display.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StartTimer();
                }
            });



            btt_p1_c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btt_p1_c1.getVisibility() == View.VISIBLE) {
                        if (timerIsOn) {
                            timerIsOn = false;
                            btt_p1_c1.setVisibility(View.INVISIBLE);
                            p1cards.set(0,null);
                            action();
                        }
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

                            p1cards.set(1, null);
                            action();
                        }
                        if (CardDrawn && IsP1Turn) { // when player decided to swap a card
                            p1cards.set(1, p1cards.get(p1cards.size() - 1));
                            Card toDisplay = p1cards.remove(p1cards.size() - 1);
                            CardDrawn = false;
                            int display = getResources().getIdentifier(String.valueOf(toDisplay.getSuit()) + toDisplay.getNum(), "drawable", getPackageName());
                            p1display.setBackgroundResource(display);
                            IsP2Turn = true;
                            IsP1Turn = false;
                            IsReadyToDraw = true;
                            p1cards.set(1,null);
                            action();
                        }
                    }
                }
            });
            btt_p1_c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btt_p1_c3.getVisibility() == View.VISIBLE) {
                        if (timerIsOn) {
                            timerIsOn = false;
                            btt_p1_c3.setVisibility(View.INVISIBLE);
                            p1cards.set(2, null);
                            action();
                        }
                                if (FlipBottomCard && IsP1Turn) {
                                    FlipBottomCard = false;
                                    BottomCardFlipped = true;
                                    int display = getResources().getIdentifier(String.valueOf(p1cards.get(2).getSuit()) + p1cards.get(2).getNum(), "drawable", getPackageName());
                                    btt_p1_c3.setBackgroundResource(display);
                                }
                                if (BottomCardFlipped) {
                            BottomCardFlipped = false;
                                    btt_p1_c3.setBackgroundResource(R.drawable.card);
                                }
                    }
                }
            });

            btt_p1_c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btt_p1_c4.getVisibility() == View.VISIBLE) {
                        if (timerIsOn) {
                            timerIsOn = false;
                            btt_p1_c4.setVisibility(View.INVISIBLE);
                            p1cards.set(3, null);
                            action();
                        }
                        if (FlipBottomCard && IsP1Turn) {
                            FlipBottomCard = false;
                            BottomCardFlipped = true;
                            int display = getResources().getIdentifier(String.valueOf(p1cards.get(3).getSuit()) + p1cards.get(3).getNum(), "drawable", getPackageName());
                            btt_p1_c4.setBackgroundResource(display);
                        }
                        if (BottomCardFlipped) {
                            BottomCardFlipped = false;
                            btt_p1_c4.setBackgroundResource(R.drawable.card);
                        }
                    }
                }
            });

            btt_p1_c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerIsOn) {
                        // if card exists here
                        timerIsOn = false;
                        // somehow delete card
                        if (btt_p1_c5.getVisibility() == View.VISIBLE) {
                            if (timerIsOn) {
                                timerIsOn = false;
                                btt_p1_c5.setVisibility(View.INVISIBLE);
                                p1cards.set(4, null);
                                action();
                            }
                        }
                    }
                }
            }
            });


            btt_p1_c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btt_p1_c6.getVisibility() == View.VISIBLE) {
                        if (timerIsOn) {
                            timerIsOn = false;
                            btt_p1_c6.setVisibility(View.INVISIBLE);
                            p1cards.set(5, null);
                            action();
                        }
                    }
                }
            });

            btt_p2_c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btt_p2_c1.getVisibility() == View.VISIBLE) {
                        if (timerIsOn) {
                            timerIsOn = false;
                            btt_p2_c1.setVisibility(View.INVISIBLE);
                            p2cards.set(0, null);
                            action();
                        }
                    }
                }
            });

            btt_p2_c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btt_p2_c2.getVisibility() == View.VISIBLE) {
                        if (timerIsOn) {
                            timerIsOn = false;
                            btt_p2_c2.setVisibility(View.INVISIBLE);
                            p2cards.set(1, null);
                            action();
                        }
                    }
                }
            });
            btt_p2_c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btt_p2_c3.getVisibility() == View.VISIBLE) {
                        if (timerIsOn) {
                            timerIsOn = false;
                            btt_p2_c3.setVisibility(View.INVISIBLE);
                            p2cards.set(2, null);
                            action();
                        }

                        if (FlipBottomCard && IsP1Turn) {
                            FlipBottomCard = false;
                            BottomCardFlipped = true;
                            int display = getResources().getIdentifier(String.valueOf(p1cards.get(2).getSuit()) + p1cards.get(2).getNum(), "drawable", getPackageName());
                            btt_p2_c3.setBackgroundResource(display);
                        }
                        if (BottomCardFlipped) {
                            BottomCardFlipped = false;
                            btt_p2_c3.setBackgroundResource(R.drawable.card);
                        }
                    }
                }
            });
            btt_p2_c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btt_p2_c4.getVisibility() == View.VISIBLE) {
                        if (timerIsOn) {
                            timerIsOn = false;
                            btt_p2_c4.setVisibility(View.INVISIBLE);
                            p2cards.set(3, null);
                            action();
                        }
                        if (FlipBottomCard && IsP1Turn) {
                            FlipBottomCard = false;
                            BottomCardFlipped = true;
                            int display = getResources().getIdentifier(String.valueOf(p1cards.get(3).getSuit()) + p1cards.get(3).getNum(), "drawable", getPackageName());
                            btt_p2_c4.setBackgroundResource(display);
                        }
                        if (BottomCardFlipped) {
                            BottomCardFlipped = false;
                            btt_p2_c4.setBackgroundResource(R.drawable.card);
                        }
                    }
                }
            });
            btt_p2_c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btt_p2_c5.getVisibility() == View.VISIBLE) {
                        if (timerIsOn) {
                            timerIsOn = false;
                            btt_p2_c5.setVisibility(View.INVISIBLE);
                            p2cards.set(4, null);
                            action();
                        }
                    }
                }
            });

            btt_p2_c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btt_p2_c6.getVisibility() == View.VISIBLE) {
                        if (timerIsOn) {
                            timerIsOn = false;
                            btt_p2_c6.setVisibility(View.INVISIBLE);
                            p2cards.set(5, null);
                            action();
                        }
                    }
                }
            });
        }

    private void GameEnd() {

        Intent intent = new Intent(this, end_game.class);

        int player1Total = 0;
        for (int i = 0; i < p1cards.size(); ++i) {
            Card curCard = p1cards.get(i);
            int value = curCard.getNum();
            if (curCard.getNum() == 13 && (curCard.getSuit() == 'h' || curCard.getSuit() == 'd')) {
                value = -1;
            }
            player1Total += value;
            intent.putExtra(key1, player1Total);
        }

        int player2Total = 0;
        for (int i = 0; i < p2cards.size(); ++i) {
            Card curCard = p2cards.get(i);
            int value = curCard.getNum();
            if (curCard.getNum() == 13 && (curCard.getSuit() == 'h' || curCard.getSuit() == 'd')) {
                value = -1;
            }
            player2Total += value;
            intent.putExtra(key2, player2Total);
        }
        startActivity(intent);

        //use intent here because we want to move to end_game activity
    }

    private void startTimer1() {

        myCountDownTimer1 = new MyCountDownTimer1(5000, 1000);
        myCountDownTimer1.start();
    }

    private void startTimer2() {
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
            if (timerIsOn) {
                timerIsOn = false;
                action();
            }
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
}