package com.company.cardGame.blackJack;
import com.company.cardGame.actors.Dealer;
import com.company.cardGame.actors.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;
import com.company.cardGame.util.Console;

import java.util.ArrayList;
import java.util.List;

public class Table {
    Hand player = new Hand(new Player("player"));
    List<Hand> hands = new ArrayList<>();
    List<Actor> players = new ArrayList<>();
    Hand dealer = new Hand(new Dealer());
    Deck deck;
    int BUST_VALUE = 21;
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



    private void displayTable() {
        StringBuilder output = new StringBuilder();
        output.append(dealer.getName() + " ").append(dealer.displayHand()).append("\n");
        output.append(player.getName() + " ").append(player.displayHand());
        System.out.println(output);
    }

    private void deal() {
        for (int count = 0; count < 2; count++) {
            // list of hands
            dealer.addCard(deck.draw());
            player.addCard(deck.draw());
        }
    }

    private void determineWinner() {
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
        int action = activeHand.getAction();
        return switch (action) {
            case Actor.QUIT -> stand(activeHand);
            case Actor.HIT -> hit(activeHand);
            case Actor.STAND -> stand(activeHand);
            case Actor.DOUBLE -> doubleDown(activeHand);
            case Actor.SPLIT -> split(activeHand);
            default -> false;
        };
    }

    private boolean hit(Hand activeHand) {
        // TODO: hit
        activeHand.addCard(deck.draw());
        System.out.println("Hit me");
        if (activeHand.getValue() > BUST_VALUE) {
            System.out.println("Busted");
            return false;
        }
        return true;
    }

    private boolean stand(Hand activeHand) {
        // TODO: stand
        System.out.println("Waves Hand");
        return false;
    }

    private boolean doubleDown(Hand activeHand) {
        // TODO: double
        activeHand.doubleBet();
        System.out.println("Double Down");
        hit(activeHand);
        stand(activeHand);
        return false;

    }

    private boolean split(Hand activeHand) {
        System.out.println("two hands");
        return doubleDown(activeHand);
    }
}