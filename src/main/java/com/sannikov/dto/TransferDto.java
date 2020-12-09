package com.sannikov.dto;

import com.sannikov.model.Card;
import lombok.Getter;

import java.util.Arrays;

public class TransferDto {

    @Getter
    private final Card[] cards;

    public TransferDto(Card c1, Card c2, Card c3) {
        this.cards = new Card[]{c1, c2, c3};
    }
}
