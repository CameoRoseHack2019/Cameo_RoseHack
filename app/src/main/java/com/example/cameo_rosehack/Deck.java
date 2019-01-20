package com.example.cameo_rosehack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public int size(){
        return cards.size();
    }
    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }
    public List<Card> getCards() {
        return cards;
    }
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}

