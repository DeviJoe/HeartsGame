package com.sannikov.service;

import com.sannikov.dumpy.CardNotFoundException;
import com.sannikov.model.Card;
import com.sannikov.model.CardValue;
import com.sannikov.model.DeckModel;
import com.sannikov.model.Suit;

import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DeckServiceImpl implements DeckService {

    private final DeckModel deck;

    public DeckServiceImpl(int size) {
        deck = new DeckModel(size);
        generateDeck();
    }

    private void generateDeck() {
        Suit[] suits = Suit.values();
        CardValue[] cardValue = CardValue.values();

        for (Suit suit : suits) {
            for (CardValue value : cardValue) {
                addCard(new Card(value, suit));
            }
        }
    }

    private void addCard(Card card) {
        deck.getDeck().add(card);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(deck.getDeck());
    }

    @Override
    public void shuffle(int randomSeed) {
        Collections.shuffle(deck.getDeck(), new Random(randomSeed));
    }

    @Override
    public Card getCard() {
        if (deck.getSize() != 0) {
            Card card = deck.getDeck().get(0);
            deck.setSize(deck.getSize() - 1);
            deck.getDeck().remove(0);
            return card;
        } else throw new CardNotFoundException("В колоде нет карт!");
    }
}
