package com.sannikov.dto;

import com.sannikov.model.Card;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;

@EqualsAndHashCode
public class TransferDto {

    private final Card[] cards;

    public TransferDto(Card c1, Card c2, Card c3) {
        this.cards = new Card[]{c1, c2, c3};
    }

    public Card[] getCards() {
        return cards;
    }
}
