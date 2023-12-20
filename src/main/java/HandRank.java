import java.util.List;

public class HandRank {

    // Pair
    private static void isPair(Hand hand){
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
    private static void isTwoPair(Hand hand){
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
                    } else if (pairNumber != cards.get(i).getNumber()) {
                        hand.setHigherRank(2);
                    }
                }
            }
        }
    }

    // Three of a kind

    private static void isThreeOfAKind(Hand hand) {
        List<Card> cards = hand.getHand();

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(cards.get(i).getNumber() == cards.get(j).getNumber() && cards.get(k).getNumber() == cards.get(j).getNumber() && i != j && k != j && i != k) {
                        hand.setHigherRank(3);
                    }
                }
            }
        }
    }

    // Straight

    private static void isStraight(Hand hand) {
        List<Card> cards = hand.getHand();
        boolean start = false;
        boolean straight = true;
        int rank = 0;
        for(int i = 1; i < 14; i++) {
            boolean in = false;
            for(int j = 0; j < 5; j++) {
                if (cards.get(j).getNumber() == i % 13 + 1) {
                    in = true;
                    break;
                }
            }
            if(!start && in){
                start = true;
                rank++;
            }
            else if(rank > 4) break;
            else if(start && !in) {
                straight = false;
                break;
            } else if(in){
                rank++;
            }
        }
        if(straight) hand.setHigherRank(4);
    }

    // Flush

    private static void isFlush(Hand hand) {
        List<Card> cards = hand.getHand();
        String kind = cards.get(0).getColor();
        boolean flush = true;
        for(int i = 1; i < 5; i++) {
            if (!cards.get(i).getColor().equals(kind)) {
                flush = false;
                break;
            }
        }
        if(flush){
            hand.setHigherRank(5);
        }
    }

    // Full house

    private static void isFullHouse(Hand hand) {
        List<Card> cards = hand.getHand();

        int threeNumber = -1;

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(cards.get(i).getNumber() == cards.get(j).getNumber() && cards.get(k).getNumber() == cards.get(j).getNumber() && i != j && k != j && i != k) {
                        threeNumber = cards.get(i).getNumber();
                    }
                }
            }
        }

        if(threeNumber == -1) return;

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(cards.get(i).getNumber() == cards.get(j).getNumber() && j!=i && cards.get(i).getNumber() != threeNumber) {
                    hand.setHigherRank(6);
                }
            }
        }
    }

    // Four of a kind

    private static void isFourOfAKind(Hand hand) {
        List<Card> cards = hand.getHand();

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    for(int l = 0; l < 5; l++) {
                        if(cards.get(i).getNumber() == cards.get(j).getNumber() && cards.get(k).getNumber() == cards.get(j).getNumber() && cards.get(l).getNumber() == cards.get(j).getNumber() && i != j && k != j && l != j && i != k && l != i && k != l) {
                            hand.setHigherRank(7);
                        }
                    }
                }
            }
        }
    }

    // Straight Flush

    private static void isStraightFlush(Hand hand) {
        List<Card> cards = hand.getHand();
        boolean start = false;
        boolean straight = true;
        boolean flush = true;
        String color = cards.get(0).getColor();
        int rank = 0;
        for(int i = 1; i < 14; i++) {
            boolean in = false;
            for(int j = 0; j < 5; j++) {
                if (cards.get(j).getNumber() == i % 13 + 1) {
                    if(!cards.get(j).getColor().equals(color)) flush = false;
                    in = true;
                    break;
                }
            }
            if(!start && in){
                start = true;
                rank++;
            }
            else if(rank > 4) break;
            else if(start && !in) {
                straight = false;
                break;
            } else if (in){
                rank++;
            }
        }
        if(straight && flush) hand.setHigherRank(8);
    }

    public static void setHandRank(Hand hand) {
        hand.setHigherRank(0);
        isPair(hand);
        isTwoPair(hand);
        isThreeOfAKind(hand);
        isStraight(hand);
        isFlush(hand);
        isFullHouse(hand);
        isFourOfAKind(hand);
        isStraightFlush(hand);
    }
}
