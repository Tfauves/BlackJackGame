package com.company.cardGame.blackJack;
import com.company.cardGame.actors.Dealer;
import com.company.cardGame.actors.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;
import com.company.cardGame.util.Console;

import java.util.ArrayList;
import java.util.List;

public class Table {
    List<Hand> hands = new ArrayList<>();
    Hand dealer = new Hand(new Dealer());
    Deck deck;
    public static final int BUST_VALUE = 21;
    private int playerCount = 0;

    public Table() {
        playerCount = Console.getInt("How many players?", 1, 6, "invalid input");
        for (int count = 0; count < playerCount; count++) {
            Player newPlayer = new Player("Player" + (count + 1) + ": ");
            hands.add(new Hand(newPlayer));
        }
    }

    public void playGame() {
        while (true) {
            playRound();
        }
    }

    public void playRound() {
        deck = new StandardDeck();
        deck.shuffle();
        getBets();
        deal();
        displayTable();
        playerTurns();
        while(turn(dealer));
        displayTable();
        endRound();
    }

    private void getBets() {
        for (Hand player : hands) {
            player.placeBet();
        }
    }

    private void playerTurns() {
        for (int count = 0; count < hands.size(); count++) {
            Hand player = hands.get(count);
            while (true) {
                if (!turn(player)) break;
            }
            System.out.println(player.displayHand());
            Console.getString("ENTER to start next turn", false);
        }
    }

    private void endRound() {
        for (Hand player : hands) {
            determineWinner(player);
            System.out.println(player.getBalance());
        }
        while (hands.size() > playerCount) {
            hands.remove(hands.size() - 1);
        }
    }

    private void displayTable() {
        StringBuilder output = new StringBuilder();
        output.append(dealer.getName() + " ").append(dealer.displayHand()).append("\n");
        for (Hand player : hands) {
        output.append(player.getName() + " ").append(player.displayHand());
        }
        System.out.println(output);
    }

    private void deal() {
        for (int count = 0; count < 2; count++) {
            // list of hands
            dealer.addCard(deck.draw());
            for (Hand player : hands) {
            player.addCard(deck.draw());
            }
        }
    }

    private void determineWinner(Hand player) {
        if (player.getValue() > BUST_VALUE) {
            System.out.println("Player Busted");
            return;
        }
        if (player.getValue() > dealer.getValue() || dealer.getValue() > BUST_VALUE) {
            System.out.println("Player Wins");
            player.payOut(Hand.NORMAL_PAY);
            return;
        }
        if (player.getValue() == dealer.getValue()) {
            System.out.println("Push");
            player.payOut(Hand.PUSH_PAY);
            return;
        }
        System.out.println("Dealer Wins");
    }

    private boolean turn(Hand activeHand) {
        System.out.println(dealer.getName() + " " + dealer.displayHand());
        System.out.println(activeHand.getName());
        int action = activeHand.getAction();
        return switch (action) {
            case Actor.QUIT -> quit();
            case Actor.HIT -> hit(activeHand);
            case Actor.STAND -> stand(activeHand);
            case Actor.DOUBLE -> doubleDown(activeHand);
            case Actor.SPLIT -> split(activeHand);
            default -> false;
        };
    }

    private boolean quit() {
        System.exit(0);
        return false;
    }

    private boolean hit(Hand activeHand) {
        activeHand.addCard(deck.draw());
        System.out.println("Hit me");
        if (activeHand.getValue() > BUST_VALUE) {
            System.out.println("Busted");
            return false;
        }
        return true;
    }

    private boolean stand(Hand activeHand) {
        System.out.println("Waves Hand");
        return false;
    }

    private boolean doubleDown(Hand activeHand) {
        activeHand.doubleBet();
        System.out.println("Double Down");
        hit(activeHand);
        stand(activeHand);
        return false;
    }

    private boolean split(Hand activeHand) {
        System.out.println("two hands");
        activeHand.doubleBet();
        Hand newHand = activeHand.splitHand();
        activeHand.addCard(deck.draw());
        newHand.addCard(deck.draw());
        hands.add(newHand);

        return true;
    }
}