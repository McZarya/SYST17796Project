/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import static blackjack.CardTrick.userHand;
import static blackjack.CardTrick.userSum;
import java.util.Random;

/**
 *
 * @author Chris
 */
/**
 * Ola Al Jarrah A class that models playing card Objects. Cards have a value
 * (note that Ace = 1, Jack -11, Queen =12, King = 13) A suit (clubs, hearts,
 * spades, diamonds). There are 52 cards in a deck, no jokers. This code is to
 * be used in ICE1. When you create your own branch, add your name as a
 * modifier.
 *
 * @modifier Shushil Neupane
 */
public class Card {

    private String suit; //clubs, spades, diamonds, hearts
    private int value;//1-13

    public static final String[] SUITS = {"Hearts", "Diamonds", "Spades", "Clubs"};

    /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    public Card randomCard() {
        //calculate user hand
        Card rand = new Card();
        rand.setSuit(SUITS[0 + (int)(Math.random() * ((3 - 0) + 1))]);
        rand.setValue(1 + (int)(Math.random() * ((11 - 1) + 1)));
        return rand;

    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

}
