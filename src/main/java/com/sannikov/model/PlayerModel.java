package com.sannikov.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode
public class PlayerModel {

    @Getter
    private final List<Card> hand = new LinkedList<>();

    @Getter @Setter
    private int score;
}
