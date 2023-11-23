package poker;

import java.util.Random;

import poker.hand.Hand;
import poker.helper.Helper;

public class Game {
    public static Random random = new Random();

    public static void main(String[] args) {
//        Deck deck = new Deck();
//        deck.genereitNewDeck();
//        deck.printDeck();

        // Hand hand = new Hand();
        // hand.dealingCards();
        // hand.showHand();

        Helper helper = new Helper();
        helper.askToChangeCards();
        

    }
}
