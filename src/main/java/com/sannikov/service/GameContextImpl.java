package com.sannikov.service;

import com.sannikov.dto.TransferDto;
import com.sannikov.model.Card;
import com.sannikov.model.CardValue;
import com.sannikov.model.Suit;

import java.util.HashSet;
import java.util.Set;

public class GameContextImpl implements GameContext {

    DeckService deck = new DeckServiceImpl(52);

    GameStackService stack = new GameStackServiceImpl();

    private final PlayerService player1 = new PlayerServiceImpl();
    private final PlayerService player2 = new PlayerServiceImpl();
    private final PlayerService player3 = new PlayerServiceImpl();
    private final PlayerService player4 = new PlayerServiceImpl();

    private int round;

    private boolean isFirstRound = true;
    private boolean isFirstStep = true;
    private int count;
    // игрок с которого начинается раунд
    private PlayerService startPlayer;
    // игрок, который осуществляет ход
    private PlayerService currentPlayer;

    @Override
    public int getRound() {
        return round;
    }

    private Set<PlayerService> createSetOfPlayers() {
        Set<PlayerService> playerSet = new HashSet<>();
        playerSet.add(player1);
        playerSet.add(player2);
        playerSet.add(player3);
        playerSet.add(player4);
        return playerSet;
    }

    @Override
    public void initialize() {

        // todo можно вынести куда-нибудь в другое место
        deck.shuffle();
        deck.shuffle(9864546);
        deck.shuffle();
        deck.shuffle(654654635);

        Set<PlayerService> playerSet = createSetOfPlayers();

        for (PlayerService currentPlayer : playerSet) {
            for (int i = 0; i < 13; i++) {
                currentPlayer.addCard(deck.getCard());
            }
        }
    }

    @Override
    public void changeFaze(TransferDto p1, TransferDto p2, TransferDto p3, TransferDto p4) {
        ChangeFazeEnum faze = ChangeFazeEnum.getEnumFromRound(round);

        switch (faze) {
            default -> {
            }
            case CLOCKWISE -> {
                player1.transferCard(player4, p1.getCards());
                player2.transferCard(player1, p2.getCards());
                player3.transferCard(player2, p3.getCards());
                player4.transferCard(player3, p4.getCards());
            }
            case CROSSWISE -> {
                player1.transferCard(player3, p1.getCards());
                player2.transferCard(player4, p2.getCards());
                player3.transferCard(player1, p3.getCards());
                player4.transferCard(player2, p4.getCards());
            }
            case COUNTERCLOCKWISE -> {
                player1.transferCard(player2, p1.getCards());
                player2.transferCard(player3, p2.getCards());
                player3.transferCard(player3, p3.getCards());
                player4.transferCard(player1, p4.getCards());
            }
        }
    }

    /*
    1) Определить игрока, который ходит
    2) Определить для него запрещенные карты (те, с которых он не может ходить)
    3) Запросить у него ход - игрок выбирает карту, которую кинет в стек
    4) Записать значение текущего игрока следующему игроку.
     */
    public void transaction(Card card) {
        if (isFirstStep) currentPlayer = defineCurrentPlayer();
        if (card.getSuit() == Suit.CLUBS && isFirstStep) throw new RuntimeException("Пришедшая карта запрещена");
        isFirstStep = false;
        stack.add(card);
        count++;
        count %= 4;

        switch (count) {
            case (0) -> currentPlayer = player1;
            case (1) -> currentPlayer = player2;
            case (2) -> currentPlayer = player3;
            case (3) -> currentPlayer = player4;
        }
    }

    private PlayerService findWith2Club() {
        Set<PlayerService> playerSet = createSetOfPlayers();

        for (PlayerService player : playerSet) {
            for (Card card : player.getHand()) {
                if (card.getSuit() == Suit.CLUBS && card.getValue() == CardValue.TWO) return player;
            }
        }
        return null;
    }

    private PlayerService defineCurrentPlayer() {
        if (isFirstRound) {
            startPlayer = findWith2Club();
            isFirstRound = false;
        }
        return startPlayer;
    }


    @Override
    public void updateScoreOnPlayers(PlayerService player) {
        int score = 0;

        if (stack.convertToList().contains(new Card(CardValue.TWO, Suit.HEARTS)) &&
                stack.convertToList().contains(new Card(CardValue.THREE, Suit.HEARTS)) &&
                stack.convertToList().contains(new Card(CardValue.FOUR, Suit.HEARTS)) &&
                stack.convertToList().contains(new Card(CardValue.FIVE, Suit.HEARTS)) &&
                stack.convertToList().contains(new Card(CardValue.SIX, Suit.HEARTS)) &&
                stack.convertToList().contains(new Card(CardValue.JACK, Suit.HEARTS)) &&
                stack.convertToList().contains(new Card(CardValue.QUEEN, Suit.HEARTS)) &&
                stack.convertToList().contains(new Card(CardValue.KING, Suit.HEARTS)) &&
                stack.convertToList().contains(new Card(CardValue.ACE, Suit.HEARTS)) &&
                stack.convertToList().contains(new Card(CardValue.QUEEN, Suit.CLUBS))) {

            Set<PlayerService> playerSet = createSetOfPlayers();

            for (PlayerService pl : playerSet) {
                if (pl.equals(player)) continue;
                pl.setScore(26);
                return;
            }

        }

        for (Card card : stack.convertToList()) {
            if (card.getSuit() == Suit.CLUBS && card.getValue() == CardValue.QUEEN) score += 13;
            if (card.getSuit() == Suit.HEARTS) score += 1;
        }

        player.setScore(score);
    }

    @Override
    public boolean isWin() {
        Set<PlayerService> playerSet = createSetOfPlayers();
        for (PlayerService player : playerSet) {
            if (player.getScore() >= 100) return true;
        }
        return false;
    }
}
