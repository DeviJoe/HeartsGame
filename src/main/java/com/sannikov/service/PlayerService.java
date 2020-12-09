package com.sannikov.service;

import com.sannikov.model.Card;

import java.util.List;

public interface PlayerService {

    boolean addCard(Card card);

    boolean transferCard(PlayerService player, Card... card);

    boolean deleteCard(Card card);

    /**
     * Устанавливат новый счет игрока
     * @param deltaScore значение, НА которое происходит изменение
     * @return текущее значение счета после изменения
     */
    int setScore(int deltaScore);

    int getScore();

    List<Card> getHand();
}
