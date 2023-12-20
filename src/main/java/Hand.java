import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<Card>();
    private int rank;
    private Card higherCard;

    Hand(Deck deck) {
        for(int i = 0; i < 5; i++) {
            cards.add(deck.getoneCard());
        }
        setHigherCard();
        HandRank.setHandRank(this);
    }

    public List<Card> getHand() {
        return cards;
    }

    public void setHigherRank(int rank) {
        this.rank = rank;
    }

    private void setHigherCard(){
        higherCard = cards.get(0);
        if(higherCard.getNumber() == 1){
            this.higherCard = higherCard;
            return;
        }
        for(int i  = 1; i < 5; i++) {
            if(cards.get(i).getNumber() == 1) {
                this.higherCard = cards.get(i);
                return;
            }

            if(cards.get(i).getNumber() > higherCard.getNumber()) {
                higherCard = cards.get(i);
            }
        }
    }

    public Card getHigherCard(int i) {
        return higherCard;
    }

    public int getRank() {
        return rank;
    }
}