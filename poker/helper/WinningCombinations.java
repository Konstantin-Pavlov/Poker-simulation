package poker.helper;

import poker.cards.Card;
import poker.enums.Suit;


// для сравнения юзать компаратор?
public class WinningCombinations {
    public boolean isFlash(Card[] handCards) {
        Suit currentSuit = handCards[0].getSuit();
        for (Card handCard : handCards) {
            if (handCard.getSuit() != currentSuit) {
                return false;
            }
        }
        return true;
    }
}
