package com.company.cardGame;

public class CheatDeck implements Deck {

    public final String[] SUIT = {"\u2664", "\u2665", "\u2666", "\u2667"
    };
    public final int[] FACE_VALUE = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
    };

    public void shuffle() {}

    @Override
    public Card deal() {
        int faceValue = Console.getInt()
        return Card(SUIT[suit - 1], faceValue);
    }
}
