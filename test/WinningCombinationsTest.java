package test;

import org.junit.Test;
import org.junit.Assert;

import poker.cards.Card;
import poker.enums.Rank;
import poker.enums.Suit;
import poker.enums.WinningCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningCombinationsTest {

    @Test
    public void isFlashRoyal() {
        List<Card> cards = new ArrayList<>(Arrays.asList(
                new Card(Suit.CLOVES, Rank.ACE),
                new Card(Suit.CLOVES, Rank.QUEEN),
                new Card(Suit.CLOVES, Rank.JACK),
                new Card(Suit.CLOVES, Rank.KING),
                new Card(Suit.CLOVES, Rank.TEN))
        );
        Assert.assertTrue(WinningCombinations.FLASH_ROYAL.check(cards));
    }
    @Test
    public void isFlash() {
        List<Card> cards = new ArrayList<>(Arrays.asList(
                new Card(Suit.CLOVES, Rank.FOUR),
                new Card(Suit.CLOVES, Rank.FIVE),
                new Card(Suit.CLOVES, Rank.SIX),
                new Card(Suit.CLOVES, Rank.SEVEN),
                new Card(Suit.CLOVES, Rank.EIGHT))
        );
        Assert.assertTrue(WinningCombinations.FLASH.check(cards));
    }

    @Test
    public void isCare() {
        List<Card> cards = new ArrayList<>(Arrays.asList(
                new Card(Suit.TILES, Rank.QUEEN),
                new Card(Suit.PIKES, Rank.QUEEN),
                new Card(Suit.CLOVES, Rank.SIX),
                new Card(Suit.TILES, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.QUEEN))
        );
        Assert.assertTrue(WinningCombinations.CARE.check(cards));
    }

    @Test
    public void isStreet() {
        List<Card> cards = new ArrayList<>(Arrays.asList(
                new Card(Suit.TILES, Rank.SIX),
                new Card(Suit.PIKES, Rank.FIVE),
                new Card(Suit.CLOVES, Rank.FOUR),
                new Card(Suit.TILES, Rank.EIGHT),
                new Card(Suit.HEARTS, Rank.SEVEN))
        );
        Assert.assertTrue(WinningCombinations.STREET.check(cards));
    }
}