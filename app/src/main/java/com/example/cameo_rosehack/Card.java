package com.example.cameo_rosehack;

public class Card {
    private:
        char suit;
        int num;
    public:
        Card(){suit = 0; num = 0;};
        Card(char letter, int number) {suit = letter; num = number;};
}