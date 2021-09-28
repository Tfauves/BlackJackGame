package com.company.cardGame.deck;

import com.company.cardGame.deck.Card;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.PlayingCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck implements Deck {
    private final List<Card> deck = new ArrayList<>();
    private final String[] SUIT = {"\u2664", "\u2665", "\u2666", "\u2667"
    };
    public final int[] FACE_VALUE = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
    };

    public StandardDeck() {
        for (String suit : SUIT) {
            for (int faceValue : FACE_VALUE) {
                deck.add(new PlayingCard(suit, faceValue));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card draw() {
        return deck.remove(deck.size() -1);
    }

    public List<Card> getDeck() {
        return deck;
    }


}
