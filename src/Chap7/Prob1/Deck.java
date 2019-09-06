package Chap7.Prob1;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    private LinkedList<Card> cards;

    public Deck() {
        cards = new LinkedList<>();
        addDeck();
    }

    public Card drawCard() {
        return cards.removeFirst();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void addDeck() {
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }
}
