package com.example.cameo_rosehack;

public class Card {
    private char suit;
    private int num;

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Card(){suit = 0; num = 0;};
    public Card(char letter, int number) {suit = letter; num = number;};
}