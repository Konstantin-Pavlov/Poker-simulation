package poker.deck;

import java.util.Random;

import poker.cards.Card;
import poker.enums.Suit;

public class Deck {
    private static Random random = new Random();
    private String[] ranks;
    private Suit[] suits;
    private static Card[] cards;

    public void printDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public void genereitNewDeck() {
        // счетчик для заполнения массива cards
        int cardCounter = 0;

        // получение упорядоченных массивов с ранками карт и мастями
        ranks = getRanksArray();
        suits = getSuitsArray();

        // перемешивание упорядоченных массивов с ранками карт и мастями
        shuffleArray(ranks);
        shuffleArray(suits);

        // создание массива с картами
        cards = new Card[52];

        // заполнение массива cards случайными картами
        for (Suit suit : suits) {
            for (String rank : ranks) {
                cards[cardCounter++] = new Card(suit, rank);
            }
        }

        shuffleArray(cards);
    }

    private Suit[] getSuitsArray() {
        // Создаем массив типа Suit с мастями
        return new Suit[] { Suit.HEARTS, Suit.PIKES, Suit.CLOVES, Suit.TILES };

    }

    private String[] getRanksArray() {
        // Создаем массив с рангами от 2 до A
        return new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
    }

    // используется алгоритм Фишера-Йейтса для случайного перемешиванияэлементовмассива
    // тип Object (родитель всех остальных классов) поэтому в аргументах может бытьлюбой тип
    public void shuffleArray(Object[] array) {
        int n = array.length;

        for (int i = n - 1; i > 0; i--) {
            // Генерируем случайный индекс от 0 до i (включительно)
            int j = (int) (Math.random() * (i + 1));

            // Обмениваем значения элементов с индексами i и j
            var temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public Card getRandomCard() {
        int choice = random.nextInt(cards.length);
        return cards[choice];
    }
    public void returnCard(Card card){
        card.setAvalible(true);
    }

}
