package com.sannikov.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode
public class PlayerModel {

    @Getter
    private final List<Card> hand;


    public PlayerModel() {
        this.hand = new LinkedList<>();
    }

}
