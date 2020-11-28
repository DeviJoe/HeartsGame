package com.sannikov.service;

import com.sannikov.model.Card;

public interface PlayerService extends Iterable<Card> {

    void addCard(Card card);

    void transferCard(PlayerService player, Card card);



}
