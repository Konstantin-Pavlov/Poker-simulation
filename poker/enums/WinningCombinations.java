package poker.enums;

import poker.cards.Card;
import poker.enums.Suit;

import java.util.List;


// для сравнения юзать компаратор?
public enum WinningCombinations {

    FLASH {
        @Override
        public boolean check(List<Card> handCards) {
            return handCards.stream().allMatch(card -> card.getSuit() == handCards.getFirst().getSuit());
        }
    };

    public abstract boolean check(List<Card> handCards);
}
