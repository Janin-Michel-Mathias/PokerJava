import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<Card>();
    private int rank;


    Hand(Deck deck) {
        for(int i = 0; i < 5; i++) {
            cards.add(deck.getoneCard());
        }
        List<Card> sortedCards = new ArrayList<Card>(cards);
        int index = 0;
        for(int i = 13; i > 0; i--) {
            for(int j = 0; j < 5; j++) {
                if(cards.get(j).getNumber() == i%13 + 1) {
                    sortedCards.set(index, cards.get(j));
                    index++;
                }
            }
        }
        cards = sortedCards;
        HandRank.setHandRank(this);
    }

    public List<Card> getHand() {
        return cards;
    }

    public void setHigherRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}