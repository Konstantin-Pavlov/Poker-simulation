package poker;

import java.util.OptionalInt;
import java.util.Random;

import poker.cards.Card;
import poker.enums.Rank;
import poker.enums.Suit;
import poker.hand.Hand;
import poker.helper.Helper;
import poker.helper.WinningCombinations;

public class Game {
    public static Random random = new Random();

    public static void main(String[] args) {
/*        Helper helper = new Helper();
        Hand hand = new Hand();
        hand.dealingCards();
        hand.showHand();
        helper.askToChangeCards(hand);
        hand.showHand();
        if (new WinningCombinations().isFlash(hand.handCards)) {
            System.out.println("Flash!");
        }*/

        Card[] cards = new Card[]{new Card(Suit.HEARTS, Rank.FOUR),
                new Card(Suit.HEARTS, Rank.FIVE),
                new Card(Suit.HEARTS, Rank.SIX),
                new Card(Suit.HEARTS, Rank.SEVEN),
                new Card(Suit.HEARTS, Rank.EIGHT)
        };
        System.out.println(new WinningCombinations().isFlash(cards));


    }
}
