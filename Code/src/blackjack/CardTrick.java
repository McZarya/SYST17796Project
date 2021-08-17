/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author Chris, Matt, Denise, Michael
 */
/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * asks the user to pick a card and searches the array of cards for the match to
 * the user's card. To be used as starting code in ICE 1
 *
 * @author dancye
 */
public class CardTrick {

    public static int userSum = 0;
    public static int dealerSum = 0;
    public static Card[] userHand = new Card[2];
    public static Card[] dealerHand = new Card[2];
    public static Card hitCard = new Card();
    public static int dealerShowCard = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean turnOver = false;
        // calculate users first 2 cards
        Card firstUserCard = new Card();
        Card secondUserCard = new Card();
        userHand[0] = firstUserCard.randomCard();
        userHand[1] = secondUserCard.randomCard();

        // calculate dealers first 2 cards
        Card firstDealCard = new Card();
        Card secondDealCard = new Card();
        dealerHand[0] = firstDealCard.randomCard();
        dealerHand[1] = secondDealCard.randomCard();

        userSum = calcUserHand();
        System.out.println("You Show: " + userSum);
        System.out.println("");
        dealerSum = calcDealerFirstCard();
        System.out.println("Dealer Shows: " + dealerShowCard);

        // game calculations
        while (!turnOver) {
            if (userSum == 21) {
                // calculate dealers hand
                calcDealerFinalHand();
                if (dealerSum == 21) {
                    System.out.println("You and the dealer push! ");
                    turnOver = true;
                } else if (dealerSum != 21) {
                    System.out.println("You win!!!");
                    turnOver = true;
                }
            } else if (userSum > 21) {
                System.out.println("You bust!");
                turnOver = true;
            } else {
                while (userSum < 21 && turnOver == false) {
                    System.out.println("");
                    System.out.println("Hit(H) or Stand(S)");
                    String choice = input.next();
                    if (choice.equalsIgnoreCase("H")) {
                        hitCard(hitCard.randomCard());
                    } else if (choice.equalsIgnoreCase("S")) {
                        // calc dealer hand
                        calcDealerFinalHand();
                        // calcDealerFinalHand();
                        if (userSum == dealerSum) {
                            System.out.println("You and the dealer push!");
                            turnOver = true;

                        } else if (dealerSum > 21) {
                            System.out.println("You win!!!");
                            turnOver = true;

                        } else if (userSum > dealerSum) {
                            System.out.println("You Win!!! ");
                            turnOver = true;

                        } else if (dealerSum > userSum) {
                            System.out.println("You Lose!!! ");
                            turnOver = true;

                        }
                    }
                }
            }
        }
    }

    public static int calcUserHand() {
        // calculate user hand
        for (int i = 0; i < userHand.length; i++) {
            userSum += userHand[i].getValue();
            System.out.println(userHand[i].getValue() + " of " + userHand[i].getSuit());
        }
        return userSum;
    }

    public static int hitCard(Card hitCard) {
        // calculate user hand
        System.out.println(hitCard.getValue() + " of " + hitCard.getSuit());
        userSum += hitCard.getValue();
        System.out.println("You show: " + userSum);
        return userSum;
    }

    public static int hitCardDealer(Card hitCard) {
        // calculate user hand
        dealerSum += hitCard.getValue();
        System.out.println(hitCard.getValue() + " of " + hitCard.getSuit());
        return dealerSum;
    }

    public static int calcDealerFirstCard() {
        // calculate dealer hands
        dealerSum += dealerHand[0].getValue();
        System.out.println(dealerHand[0].getValue() + " of " + dealerHand[0].getSuit());
        return dealerShowCard = dealerHand[0].getValue();
    }

    public static int calcDealerFinalHand() {
        // calculate dealer hand
        dealerSum += dealerHand[1].getValue();
        System.out.println("Dealer has revealed: " + dealerHand[1].getValue() + " of " + dealerHand[1].getSuit());
        System.out.println("Dealer shows: " + dealerSum);

        while (dealerSum < 17) {
            System.out.println("Dealer is hitting another card!");
            hitCardDealer(hitCard.randomCard());
            dealerSum += hitCard.getValue();
            System.out.println("Dealer now has: " + dealerSum);
        }
        return dealerSum;

    }

}
