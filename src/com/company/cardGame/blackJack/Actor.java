package com.company.cardGame.blackJack;

public interface Actor {
    String getName();
    int HIT = 1;
    int STAND = 2;
    int DOUBLE = 3;
    int SPLIT = 4;
    int QUIT = 0;

    int getBalance();
    int getBet();
    int getAction(Hand hand);
}
