package com.sannikov.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

public class DeckModel {


    private int size;

    private LinkedList<Card> deck;

    public DeckModel(int size) {
        deck = new LinkedList<>();
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public LinkedList<Card> getDeck() {
        return deck;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
