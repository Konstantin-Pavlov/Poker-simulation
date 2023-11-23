package poker.enums;

public enum Suit {
    HEARTS("\u2660 (Hearts)"), TILES("\u2665 (Tiles)"), CLOVES("\u2666 (Cloves)"), PIKES("\u2663 (Pikes)");

    private final String cardSuit;

    Suit(String suit) {
        this.cardSuit = suit;
    }

    public String getCardSuit() {
        return cardSuit;
    }
}
