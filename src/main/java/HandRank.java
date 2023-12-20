import java.util.List;

public class HandRank {

    public static final int HIGH_CARD = 0;
    public static final int PAIR = 1;
    public static final int TWO_PAIR = 2;
    public static final int THREE_OF_A_KIND = 3;
    public static final int STRAIGHT = 4;
    public static final int FLUSH = 5;
    public static final int FULL_HOUSE = 6;
    public static final int FOUR_OF_A_KIND = 7;
    public static final int STRAIGHT_FLUSH = 8;

    // Pair
    private static void isPair(Hand hand){
        List<Card> cards = hand.getHand();
        int highestRank = 0;

        for (int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(cards.get(i).getNumber() == cards.get(j).getNumber() && i!=j){
                    hand.setHigherRank(PAIR);
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
                        hand.setHigherRank(TWO_PAIR);
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
                        hand.setHigherRank(THREE_OF_A_KIND);
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
        if(straight) hand.setHigherRank(STRAIGHT);
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
            hand.setHigherRank(FLUSH);
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
                    hand.setHigherRank(FULL_HOUSE);
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
                            hand.setHigherRank(FOUR_OF_A_KIND);
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
        if(straight && flush) hand.setHigherRank(STRAIGHT_FLUSH);
    }

    public static void setHandRank(Hand hand) {
        hand.setHigherRank(HIGH_CARD);
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
