package Chap7.Prob1;

public class Card {

    private Rank rank;
    private Suit suit;

    public Card(Rank r, Suit c) {
        this.rank = r;
        this.suit = c;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

}
