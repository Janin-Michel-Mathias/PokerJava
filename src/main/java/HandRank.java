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

    private static int[] countNumbers(Hand hand) {
        int[] numbers = new int[14];
        for(int i = 0; i < 14; i++) {
            numbers[i] = 0;
        }
        for(int i = 0; i < 5; i++) {
            numbers[hand.getHand().get(i).getNumber()]++;
        }
        return numbers;
    }

    // Pair
    private static void isPair(Hand hand, int[] counts){
        for(int i = 0; i < 14; i++) {
            if(counts[i] == 2) {
                hand.setHigherRank(PAIR);
                break;
            }
        }
    }

    // Two Pain
    private static void isTwoPair(Hand hand, int[] counts){
        boolean firstPair = false;
        for(int i = 0; i < 14; i++) {
            if(!firstPair && counts[i] == 2) {
                firstPair = true;
            } else if(counts[i] == 2) {
                hand.setHigherRank(TWO_PAIR);
                break;
            }
        }
    }

    // Three of a kind

    private static void isThreeOfAKind(Hand hand, int[] counts) {
        for(int i = 0; i < 14; i++) {
            if(counts[i] == 3) {
                hand.setHigherRank(THREE_OF_A_KIND);
                break;
            }
        }
    }

    // Straight

    private static void isStraight(Hand hand, int[] counts) {
        for(int i = 1; i < 14; i++) {
            if(counts[i%13 + 1] == 1) {
                for(int j = i; j < i + 5; j++) {
                    if(counts[j%13 + 1] != 1)return;
                }
                hand.setHigherRank(STRAIGHT);
                return;
            }
        }
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

    private static void isFullHouse(Hand hand, int[] counts) {
        boolean three = false;
        boolean pair = false;
        for(int i = 0; i < 14; i++) {
            if(counts[i] == 3)three = true;
            if(counts[i] == 2)pair = true;
        }
        if(three && pair) hand.setHigherRank(FULL_HOUSE);
    }

    // Four of a kind

    private static void isFourOfAKind(Hand hand, int[] counts) {
        for(int i = 0; i < 14; i++) {
            if(counts[i] == 4) hand.setHigherRank(FOUR_OF_A_KIND);
        }
    }

    // Straight Flush

    private static void isStraightFlush(Hand hand, int[] counts) {
        String color = hand.getHand().get(0).getColor();
        for(int i = 0; i < 5; i++) {
            if(!hand.getHand().get(i).getColor().equals(color))return;
        }
        for(int i = 1; i < 14; i++) {
            if(counts[i%13 + 1] == 1) {
                for(int j = i; j < i + 5; j++) {
                    if(counts[j%13 + 1] != 1)return;
                }
                hand.setHigherRank(STRAIGHT_FLUSH);
            }
        }
    }

    public static void setHandRank(Hand hand) {
        int[] counts = countNumbers(hand);
        hand.setHigherRank(HIGH_CARD);
        isPair(hand, counts);
        isTwoPair(hand, counts);
        isThreeOfAKind(hand, counts);
        isStraight(hand, counts);
        isFlush(hand);
        isFullHouse(hand, counts);
        isFourOfAKind(hand, counts);
        isStraightFlush(hand, counts);
    }
}
