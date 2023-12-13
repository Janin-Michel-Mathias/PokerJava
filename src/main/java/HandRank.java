import java.util.HashMap;
import java.util.List;

public class HandRank {

    // Pair
    public void isPair(Hand hand){
        List<Card> cards = hand.getHand();
        int highestRank = 0;

        for (int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(cards.get(i).getNumber() == cards.get(j).getNumber() && i!=j){
                    hand.setHigherRank(1);
                }
            }
        }
    }

    // Two Pain
    public void isTwoPair(Hand hand){
        List<Card> cards = hand.getHand();
        int highestRank = 0;
        int pairCount = 0;
        int pairNumber = 0;

        for (int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(cards.get(i).getNumber() == cards.get(j).getNumber() && i!=j){
                    if(pairNumber == 0){
                        pairNumber = cards.get(i).getNumber();
                        pairCount++;
                    } else if (cards.get(i).getNumber() == cards.get(j).getNumber() && i!=j) {

                    }
                }
            }
        }
    }

    // Three of a kind

    // Straight

    // Flush

    // Full house

    // Four of a kind
}
