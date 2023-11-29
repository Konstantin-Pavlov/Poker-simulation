package poker.cards;

import poker.enums.Rank;
import poker.enums.Suit;

public class Card {
    private final Suit suit; // масть
    private final Rank rank;
    private boolean isAvailable;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.isAvailable = true;
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

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + this.suit.getCardSuit();
    }
}
