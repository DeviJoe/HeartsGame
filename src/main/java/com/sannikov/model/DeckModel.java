package com.sannikov.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@EqualsAndHashCode
public class DeckModel {

    @Getter @Setter
    private int size;

    @Getter
    private LinkedList<Card> deck;

    public DeckModel(int size) {
        deck = new LinkedList<>();
        this.size = size;
    }
}
