package com.sannikov.service;

import com.sannikov.dto.TransferDto;

/**
 * Код, отвечающий за ход игры
 */
public interface GameContext {

    /**
     * Получение текущего номера карты
     */
    int getRound();

    /**
     * Четверым игрокам раздаются по 13 карт
     */
    void initialize();

    /**
     * Фаза обмена картами в игре: каждый игрок передает 3 любые карты одному из партнеров
     */
    void changeFaze(TransferDto p1, TransferDto p2, TransferDto p3, TransferDto p4);

    /**
     * Розыгрыш 13 взяток
     */
    void bribe();

    /**
     * Изменение количества очков у игроков после взятки
     */
    void updateScoreOnPlayers();

    /**
     * Проверка, есть ли у кого-то из игроков 100 очков
     */
    boolean isWin();
}
