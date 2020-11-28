package com.sannikov.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Card {

    @Getter
    private final CardValue value;
    @Getter
    private final Suit suit;

    public Card(CardValue value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

}
