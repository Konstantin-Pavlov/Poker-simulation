package poker.cards;

import poker.enums.Suit;

public  class Card {

    private Suit suit; // масть
    private String rank; // ранг  или значение карты
    private  boolean isAvalible;

    public Card(Suit suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.isAvalible = true;
    }

    public boolean isAvalible() {
        return isAvalible;
    }

    public void setAvalible(boolean available) {
        isAvalible = available;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + this.suit.getCardSuit();
    }
}
