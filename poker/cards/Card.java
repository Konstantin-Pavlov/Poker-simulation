package poker.cards;

import poker.enums.Rank;
import poker.enums.Suit;

public  class Card {

    private Suit suit; // масть
    private String rank; // ранг или значение карты

    private Rank enumRank;
    private  boolean isAvailable;

    public Card(Suit suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.isAvailable = true;
    }

    public Card(Suit suit, Rank enumRank) {
        this.suit = suit;
        this.enumRank = enumRank;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getEnumRank() {
        return enumRank;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + this.suit.getCardSuit();
    }
}
