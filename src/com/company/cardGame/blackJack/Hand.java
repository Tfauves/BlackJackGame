package com.company.cardGame.blackJack;


import com.company.cardGame.deck.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int bet = 0;
    private Actor holder;

    public Hand(Actor holder) {
        this.holder = holder;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

// matts pair method
//    public int checkPair() {
//        for (int i = 0; i < cards.size(); i++) {
//            int pairs = 0;
//            for (int j = i + 1; j < cards.size(); j++) {
//                if (cards.get(i).getValue() == cards.get(j).getValue()) {
//                    pairs++;
//                }
//            }
//            if (pairs > 0) {
//                return 1;
//            }
//        }
//
//        return 0;
//    }

    //my check pair
    public void checkPair() {
        boolean hasPair = false;
        for (Card card : cards) {
            if (card.getFaceValue() == card.getFaceValue()) {
                hasPair = true;
            }
        }
        if (hasPair) {

            System.out.println("pair");
        }
    }


    public int betAmount() {
        return bet;
    }

    public String displayHand() {
        String outPut = "";
        for (Card card : cards) {
            outPut += card.display() + " ";
        }
        return outPut.toString().trim();
    }

    public int getValue() {
        int score = 0;
        boolean hasAce11 = false;
        for (Card card : cards) {
            int value = card.getFaceValue();
            switch (value) {
                case 1 -> {
                    value = score + 11 > 21 ? 1 : 11;
                    if (value == 11) {
                        hasAce11 = true;
                    }
                    score += value;
                }
                case 11, 12, 13 -> score += 10;
                default -> score += value;
            }
            if (score > 21 && hasAce11) {
                score -= 10;
                hasAce11 = false;
            }
        }
        return score;
    }

    public Actor getHolder() {
        return holder;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

}
