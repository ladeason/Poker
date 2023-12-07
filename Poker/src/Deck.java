import java.util.Collections;
import java.util.Stack;

public class Deck {

    private final Stack<Card> cards;

    public Deck() {
        cards = new Stack<>();

        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                cards.push(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.pop();
    }
}
