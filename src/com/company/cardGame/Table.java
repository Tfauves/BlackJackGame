package com.company.cardGame;

import com.company.actors.Dealer;

import java.util.List;

public class Table {
    private List hands;
    private List actors;
    private Dealer dealer;

    public Table(List hands, List actors, Dealer dealer) {
        this.hands = hands;
        this.actors = actors;
        this. dealer = dealer;
    }


    public void displayBets() {

    }

    public void displayTable() {

    }

    public void removePlayer() {

    }

    public List getActors() {
        return actors;
    }

    public void setActors(List actors) {
        this.actors = actors;
    }
}
