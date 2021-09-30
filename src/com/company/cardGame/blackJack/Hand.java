package com.company.cardGame.blackJack;


import com.company.cardGame.deck.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int bet = 0;
    private Actor holder;

    public static final int PUSH_PAY = 0;
    public static final int NORMAL_PAY = 1;

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
//    public void checkPair(Hand hand, Deck cardDeck) {
//        boolean hasPair = false;
//        for (Card card : cards) {
//            if (card.getRank() == card.getRank()) {
//                hasPair = true;
//            }
//        }
//        if (hasPair && holder.getBalance() >= bet) {
//            hand.addCard(cardDeck.draw());
//            hand.getHolder().setBalance(hand.getHolder().getBalance() - hand.betAmount());
//            System.out.println(hand.getHolder().getName() +
//            "'s bet: " + hand.betAmount() +
//            " | Current balance: " + hand.getHolder().getBalance()
//            );
//
//            System.out.println("Split");
//        } else {
//            holder.getAction(hand);
//        }
//
//    }

    public String displayHand() {
        StringBuilder outPut = new StringBuilder();
        for (Card card : cards) {
            outPut.append(card.display()).append(" ");
        }

        return outPut.toString().trim();
    }

    public int getValue() {
        int score = 0;
        boolean hasAce11 = false;
        for (Card card : cards) {
            int value = card.getRank();
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

 public int getAction() {
        return holder.getAction(this);
 }

    public int getSize() {
        return cards.size();
    }

    public int getBet() {
        return bet;
    }

    public void placeBet() {
        bet = holder.getBalance();
    }

    public String getName() {
        return holder.getName();
    }

    public boolean canSplit() {return cards.get(0).getRank() == cards.get(1).getRank();}

    public void doubleBet() {
        bet *= 2;
    }

    public void payOut(int type) {
        switch (type) {
            case PUSH_PAY -> holder.getBalance();
            case NORMAL_PAY -> holder.addBalance(bet * 2);
        }
    }

}
