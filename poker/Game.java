package poker;

import java.util.*;

import poker.cards.Card;
import poker.enums.Rank;
import poker.enums.Suit;
import poker.enums.WinningCombinations;

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

        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));

        List<Card> cards = new ArrayList<>(Arrays.asList(new Card(Suit.HEARTS, Rank.FOUR),
                new Card(Suit.HEARTS, Rank.FIVE),
                new Card(Suit.HEARTS, Rank.SIX),
                new Card(Suit.HEARTS, Rank.SEVEN),
                new Card(Suit.HEARTS, Rank.EIGHT))
        );

        System.out.println(WinningCombinations.FLASH.check(cards));


    }
}
