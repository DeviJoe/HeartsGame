package com.sannikov.service;

import com.sannikov.model.Card;

import java.util.Iterator;

public class PlayerServiceImpl implements PlayerService {
    @Override
    public void addCard(Card card) {

    }

    @Override
    public void transferCard(PlayerService player, Card card) {

    }

    @Override
    public Iterator<Card> iterator() {
        return new Iterator<Card>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Card next() {
                return null;
            }
        };
    }
}
