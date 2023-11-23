package poker.hand;

import poker.cards.Card;
import poker.deck.Deck;

public class Hand {
    Card[] handCards = new Card[5];
    Deck deck = new Deck();


    public void dealingCards() {
        deck.genereitNewDeck();
        int counter = 0;
        while (counter < 5) {
            Card card = deck.getRandomCard();
            if (card.isAvalible()) {
                handCards[counter] = card;
                card.setAvalible(false);
                counter++;
            }
        }

    }

    public void showHand() {
        int i = 0;
        for (; i < handCards.length - 1; i++) {
            System.out.printf("%-15d|",i);
        }
        System.out.printf("%-15d\n",i);

        for (i = 0; i < handCards.length - 1; i++) {
            System.out.printf("%-15s|", handCards[i]);
        }
        System.out.printf("%-15s\n", handCards[i]);
    }
}

