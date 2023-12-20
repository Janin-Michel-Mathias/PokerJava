import java.util.List;

public class CompareHands {
    //recois deux mains et retourne la meilleure, une hand est composé de son Ranks et de sa carte la plus haute
    public static Hand compare(Hand hand1, Hand hand2) {

        if (hand1.getRank() > hand2.getRank()) {
            return hand1;
        } else if (hand1.getRank() < hand2.getRank()) {
            return hand2;
        } else {
            for(int i = 0; i < 5; i++) {
                if (hand1.getHand().get(i).getNumber() > hand2.getHand().get(i).getNumber()) {
                    return hand1;
                } else if (hand1.getHand().get(i).getNumber() < hand2.getHand().get(i).getNumber()) {
                    return hand2;
                }
            }
        }
        return null;
    }
}
