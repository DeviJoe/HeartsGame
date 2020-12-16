package com.sannikov.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public class PlayerModel {


    private final List<Card> hand = new LinkedList<>();

    private int score;

    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
