package com.sannikov.service;

import com.sannikov.model.Card;
import com.sannikov.model.PlayerModel;

import java.util.List;

public class PlayerServiceImpl implements PlayerService {

    PlayerModel player = new PlayerModel();

    @Override
    public boolean addCard(Card card) {
        return player.getHand().add(card);
    }

    @Override
    public boolean transferCard(PlayerService innerPlayer, Card... card) {
        if (card.length != 3) return false;
        for (Card currentCard : card) {
            if (player.getHand().contains(currentCard)) {
                innerPlayer.addCard(currentCard);
                deleteCard(currentCard);

            }
        }
        return true;
    }

    @Override
    public boolean deleteCard(Card card) {
        return player.getHand().remove(card);
    }

    @Override
    public int setScore(int deltaScore) {
        player.setScore(player.getScore() + deltaScore);
        return player.getScore();
    }

    @Override
    public int getScore() {
        return player.getScore();
    }

    @Override
    public List<Card> getHand() {
        return player.getHand();
    }


}
