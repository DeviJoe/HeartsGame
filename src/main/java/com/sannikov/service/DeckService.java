package com.sannikov.service;

import com.sannikov.model.Card;

public interface DeckService extends Iterable<Card> {

    /**
     * Тасование колоды
     */
    void shuffle();

    /**
     * Получение карты з колоды
     * @return карта с верхушки колоды
     */
    Card getCard();

    /**
     * Тасует колоду с заданным параметром рандома
     * @param randomSeed параметр рандома
     */
    void shuffle(int randomSeed);
}
