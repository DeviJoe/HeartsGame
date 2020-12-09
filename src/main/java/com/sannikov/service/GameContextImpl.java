package com.sannikov.service;

import com.sannikov.dto.TransferDto;

import java.util.HashSet;
import java.util.Set;

public class GameContextImpl implements GameContext {

    DeckService deck = new DeckServiceImpl(52);

    private final PlayerService player1 = new PlayerServiceImpl();
    private final PlayerService player2 = new PlayerServiceImpl();
    private final PlayerService player3 = new PlayerServiceImpl();
    private final PlayerService player4 = new PlayerServiceImpl();

    private int round;

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

    @Override
    public void bribe() {

    }

    @Override
    public void updateScoreOnPlayers() {

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
