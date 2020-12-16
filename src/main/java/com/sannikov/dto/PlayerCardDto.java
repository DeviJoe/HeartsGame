package com.sannikov.dto;

import com.sannikov.model.Card;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;


public class PlayerCardDto {

    private Card card;

    public PlayerCardDto(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCardDto that = (PlayerCardDto) o;
        return Objects.equals(card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card);
    }
}
