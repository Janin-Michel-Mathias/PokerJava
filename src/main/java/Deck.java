import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> deck = new ArrayList<Card>();
    private Card[] hand;

    Deck() {
        for (String color : new String[] {"S", "H", "D", "C"}) {
            for (int number = 1; number <= 13; number++) {
                deck.add(new Card(number, color));
            }
        }
    }

    public Card getoneCard() {
        int index = (int) (Math.random() * 52);
        Card card = deck.get(index);
        deck.remove(index);
        return card;
    }

    public Card[] getHand() {
        //Pick card to make the hand, delete the cards frome the deck
        hand = new Card[5];
        for (int i = 0; i < 5; i++) {
            hand[i] = getoneCard();
        }
        return hand;
    }
}
