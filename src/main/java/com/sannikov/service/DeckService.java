package com.sannikov.service;

import com.sannikov.model.Card;

public interface DeckService  {

    /**
     * Тасование колоды
     */
    void shuffle();

    /**
     * Получение карты с колоды
     * @return карта с верхушки колоды
     */
    Card getCard();

    /**
     * Тасует колоду с заданным параметром рандома
     * @param randomSeed параметр рандома
     */
    void shuffle(int randomSeed);
}
