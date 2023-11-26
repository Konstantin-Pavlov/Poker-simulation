package poker.enums;

import poker.cards.Card;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum WinningCombinations {

    FLASH_ROYAL {
        @Override
        public int getPriority() {
            return 1;
        }

        // 4 карты одного ранга
        @Override
        public boolean check(List<Card> handCards) {
            return validHandCards(handCards) && areAllTheSameSuitInHand(handCards) && areTheCardsInARow(handCards, true);
        }
    },
    STREET_FLASH {
        @Override
        public int getPriority() {
            return 2;
        }

        // 4 карты одного ранга
        @Override
        public boolean check(List<Card> handCards) {
            return validHandCards(handCards) && areAllTheSameSuitInHand(handCards) && areTheCardsInARow(handCards, false);
        }
    },

    CARE {
        @Override
        public int getPriority() {
            return 3;
        }

        // 4 карты одного ранга
        @Override
        public boolean check(List<Card> handCards) {
            return validHandCards(handCards) && numberOfSameRankInHand(handCards, 4, false);
        }
    },
    FULLHOUSE {
        @Override
        public int getPriority() {
            return 4;
        }

        // пять любых карт одной масти (suit)
        @Override
        public boolean check(List<Card> handCards) {
            return validHandCards(handCards) && numberOfSameRankInHand(handCards, 4, true);
        }
    },
    FLASH {
        @Override
        public int getPriority() {
            return 5;
        }

        // пять любых карт одной масти (suit)
        @Override
        public boolean check(List<Card> handCards) {
            return validHandCards(handCards) && areAllTheSameSuitInHand(handCards);
        }
    },
    STREET {
        @Override
        public int getPriority() {
            return 6;
        }

        @Override
        public boolean check(List<Card> handCards) {
            if (handCards.size() != 5) {
                return false; // Если в списке не 5 карт, то невозможно образовать стрит
            }

            // Сортируем список по рангу карты
            handCards.sort(Comparator.comparing(Card::getEnumRank));

            // Проверяем, что разница между рангами каждой карты и следующей карты равна 1
       /*     for (int i = 0; i < handCards.size() - 1; i++) {
                int currentRank = handCards.get(i).getEnumRank().ordinal();
                int nextRank = handCards.get(i + 1).getEnumRank().ordinal();
                if (nextRank - currentRank != 1) {
                    return false; // Если разница в ранге не равна 1, то это не стрит
                }
                return true;
            }*/

            // Если все карты имеют разницу в ранге, равную 1, то это стрит
            return IntStream.range(0, handCards.size() - 1)
                    .allMatch(i -> handCards.get(i + 1).getEnumRank().ordinal() - handCards.get(i).getEnumRank().ordinal() == 1);
        }
    };

    public abstract int getPriority();

    public abstract boolean check(List<Card> handCards);


    private static boolean validHandCards(List<Card> handCards) {
        if (handCards.isEmpty()) {
            System.err.println("card list is empty");
            return false;
        }
        if (handCards.contains(null)) {
            System.err.println("card list contains null");
            return false;
        }
        if (handCards.size() != 5) {
            System.err.println("card list length is not 5");
            return false;
        }
        return true;
    }

    private static boolean areAllTheSameSuitInHand(List<Card> handCards) {
        return handCards.stream().allMatch(card -> card.getSuit() == handCards.getFirst().getSuit());
    }

    private static boolean numberOfSameRankInHand(List<Card> handCards, long numberOfRanksToCheck, boolean fullHouseCase) {
        Map<Rank, Long> map = handCards.stream().collect(Collectors.groupingBy(Card::getEnumRank, Collectors.counting()));
        //long l = map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(1L);

        // три карты одного ранга и две другого ранга
        // например {FOUR=2, FIVE=3}, то есть размер map - 2
        if (fullHouseCase) {
            return map.size() == 2;
        }
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(1L).equals(numberOfRanksToCheck);
    }

    private static boolean areTheCardsInARow(List<Card> handCards, boolean flashRoyalCase) {
        // Сортируем список по рангу карты
        handCards.sort(Comparator.comparing(Card::getEnumRank));

        // если первая карта в отсортированной руке не десятка, то это не Royal flash
        if (flashRoyalCase && !handCards.getFirst().getEnumRank().equals(Rank.TEN)) {
            return false;
        }

        // Проверяем, что разница между рангами каждой карты и следующей карты равна 1
       /*     for (int i = 0; i < handCards.size() - 1; i++) {
                int currentRank = handCards.get(i).getEnumRank().ordinal();
                int nextRank = handCards.get(i + 1).getEnumRank().ordinal();
                if (nextRank - currentRank != 1) {
                    return false; // Если разница в ранге не равна 1, то это не стрит
                }
                return true;
            }*/

        // Если все карты имеют разницу в ранге, равную 1, то они идут подряд
        return IntStream.range(0, handCards.size() - 1)
                .allMatch(i -> handCards.get(i + 1).getEnumRank().ordinal() - handCards.get(i).getEnumRank().ordinal() == 1);
    }
}
