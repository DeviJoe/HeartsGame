package com.sannikov.service;

import com.sannikov.model.Card;

import java.util.List;
import java.util.Stack;

public interface GameStackService {

    /**
     * Добавляет карту во взятку
     * @param card карта игрока
     * @return true - если игра все еще продолжается, false - если пришел туз и игру надо завершить
     */
    boolean add(Card card);

    /**
     * Проводит сравнения карты с первой картой
     * @param card карта игрока
     * @return true - если карты совпали, false - если нет
     */
    boolean compareWithFirst(Card card);

    /**
     * Конвертирует стек в лист карт
     */
    List<Card> convertToList();


}
