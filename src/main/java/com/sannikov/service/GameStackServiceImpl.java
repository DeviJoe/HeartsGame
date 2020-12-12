package com.sannikov.service;

import com.sannikov.model.Card;

import java.util.Collections;
import java.util.List;

public class GameStackServiceImpl implements GameStackService {

    List<Card> list;

    @Override
    public boolean add(Card card) {
        list.add(card);
        return compareWithFirst(card);
    }

    @Override
    public boolean compareWithFirst(Card card) {
        return card.equals(list.get(0));
    }

    @Override
    public List<Card> convertToList() {
        return list;
    }
}
