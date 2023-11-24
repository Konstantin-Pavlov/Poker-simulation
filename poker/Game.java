package poker;

import java.util.OptionalInt;
import java.util.Random;

import poker.hand.Hand;
import poker.helper.Helper;
import poker.helper.WinningCombinations;

public class Game {
    public static Random random = new Random();

    public static void main(String[] args) {
        Helper helper = new Helper();
        Hand hand = new Hand();
        hand.dealingCards();
        hand.showHand();
        helper.askToChangeCards(hand);
        hand.showHand();
        if (new WinningCombinations().isFlash(hand.handCards)) {
            System.out.println("Flash!");
        }
    }
}
