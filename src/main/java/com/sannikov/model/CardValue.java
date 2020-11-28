package com.sannikov.model;

import lombok.Getter;

public enum CardValue {

    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    JACK(7),
    QUEEN(8),
    KING(9),
    ACE(10);

    @Getter
    private final int value;

    CardValue(int value) {
        this.value = value;
    }
}
