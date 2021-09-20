package com.company.cardGame;

import com.company.actors.Actor;
import com.company.actors.Dealer;
import com.company.actors.Player;

import java.util.List;

public class Table {
    private List<Hand> hands;
    private List<Actor> actors;
    private Dealer dealer;

    public Table(List hands, List actors, Dealer dealer) {
        this.hands = hands;
        this.actors = actors;
        this. dealer = dealer;
    }


    public void displayBets() {

    }

    public void displayTable() {
      for (Actor player : actors) {
          System.out.println(player.getName());
      }

    }

    public void removePlayer() {

    }

    public List getActors() {
        return actors;
    }

    public void setActors(List actors) {
        this.actors = actors;
    }

    public Dealer getDealer() {
        return dealer;
    }
}
