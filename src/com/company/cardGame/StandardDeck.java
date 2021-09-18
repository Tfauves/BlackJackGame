package com.company.cardGame;

import java.util.ArrayList;
import java.util.List;

public class StandardDeck {
    private final List<Card> deck = new ArrayList<>();
    private final String[] SUITS = {"\u2664", "\u2665", "\u2666", "\u2667"
    };
    public final int[] FACE_VALUE = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
    };

    public StandardDeck() {
        for (String suit : SUITS) {
            for (int faceValue : FACE_VALUE) {
                deck.add(new PlayingCard(suit, faceValue));
            }
        }
    }





}
