package com.company.cardGame.deck;

import com.company.cardGame.util.Console;

public class CheatDeck implements Deck {

    public final String[] SUIT = {"\u2664", "\u2665", "\u2666", "\u2667"
    };
    public final int[] FACE_VALUE = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
    };

    public void shuffle() {}

    @Override
    public Card deal() {
        int faceValue = Console.getInt(1, 13, "enter a number 1-13", "invalid entry");
        int suit = Console.getInt(1, 4, "1. \u2664 | 2. \u2665 | 3. \u2666 | 4. \u2667", "invalid entry");
        return new PlayingCard(SUIT[suit - 1], faceValue);
    }
}
