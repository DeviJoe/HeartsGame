package com.sannikov.dto;

import com.sannikov.model.Card;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class PlayerCardDto {
    @Getter
    private Card card;

    public PlayerCardDto(Card card) {
        this.card = card;
    }
}
