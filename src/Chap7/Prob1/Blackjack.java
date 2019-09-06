package Chap7.Prob1;

import java.util.ArrayList;

/* A simple class representing the card game of Blackjack.  We use our custom classes of Card and Deck
*  as well as enumerations Rank an Suit.  There are several intricacies to the game that have been
*  ignored for the sake of brevity here.  */
public class Blackjack {

    public class Player {
        // Current hand of the player.
        private ArrayList<Card> hand;
        // Indicates whether a player has folded.
        private boolean busted;
        // Indicates whether a player has chosen to stand.
        private boolean standing;
        // The score of the players current hand.
        private int score;

        public Player() {
            hand = new ArrayList<>();
            busted = false;
            standing = false;
            score = 0;
        }

        // Adds a card to the player's hand and calculates score.
        public void hit(Card card) {
            Rank currRank = card.getRank();
            /* Usually in Blackjack, the player gets to choose whether the Ace counts for 11 or 1.
            *  Here, we just make the largest choice they can make without busting. */
            if (currRank == Rank.ACE) {
                if (score <= 10) {
                    score += 11;
                } else {
                    score += 1;
                }
            // Handle face card values of 10.
            } else if (currRank == Rank.JACK || currRank == Rank.QUEEN || currRank == Rank.KING) {
                score += 10;
            } else {
                score += currRank.ordinal() + 1;
            }

            // Check if our score is 21.
            if (score == 21) {
                stand();
            }
        }

        public void stand() {
            standing = true;
        }

        public void bust() {
            busted = true;
        }

        public boolean isBusted() {
            return busted;
        }

        public boolean isStanding() {
            return standing;
        }

        public int getScore() {
            return score;
        }
    }

    private Deck deck;
    private Player[] players;

    // Creates a game of Blackjack with just one deck.
    public Blackjack(int numPlayers) {
        this(numPlayers, 1);
    }

    // Creates a game of Blackjack where multiple decks are placed together.
    public Blackjack(int numPlayers, int numDecks) {
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
        }

        deck = new Deck();
        for (int i = 1; i < numDecks; i++) {
            deck.addDeck();
        }
        // Shuffle so that the deck is not in order.
        deck.shuffle();
        // Immediately give each player two cards.
        deal();
        deal();
    }

    /* We deal cards to every player that has not chosen to stand or bust.  This is done at the beginning
    *  of each round. */
    public void deal() {
        for (Player player: players) {
            if (!player.busted && !player.standing) {
                player.hit(deck.drawCard());
            }
        }
    }

    /* Checks each players hands to see who has the closest score to 21, but not over that value.
    *  In Blackjack, normally there can be more than one winner but here we just simplify to have one.
    *  In the case that there is no winner, we just return null and it is assumed that the dealer wins. */
    public Player endGame() {
        Player winner = null;
        int winnerScore = 0;

        for (Player player: players) {
            if (!player.busted && player.getScore() > winnerScore) {
                winner = player;
                winnerScore = player.getScore();
            }
        }
        return winner;
    }
}
