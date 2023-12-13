import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<Card>();

    Hand(Deck deck) {
        for(int i = 0; i < 5; i++) {
            cards.add(deck.getoneCard());
        }
    }

    public List<Card> getHand() {
        return cards;
    }

}
