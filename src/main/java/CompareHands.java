public class CompareHands {
    //recois deux mains et retourne la meilleure, une hand est composé de son Ranks et de sa carte la plus haute
    public Hand compare(Hand hand1, Hand hand2) {
        if (hand1.getRank() > hand2.getRank()) {
            return hand1;
        } else if (hand1.getRank() < hand2.getRank()) {
            return hand2;
        } else {
            int i = 0;
            if (hand1.getHigherCard(i).getNumber() > hand2.getHigherCard(i).getNumber()) {
                return hand1;
            } else if (hand1.getHigherCard(i).getNumber() < hand2.getHigherCard(i).getNumber()) {
                return hand2;
            }
            while (hand1.getHigherCard(i).getNumber() == hand2.getHigherCard(i).getNumber()) {
                i++;
                if (i == 5) {
                    return null;
                }
                if (hand1.getHigherCard(i).getNumber() > hand2.getHigherCard(i).getNumber()) {
                    return hand1;
                } else if (hand1.getHigherCard(i).getNumber() < hand2.getHigherCard(i).getNumber()) {
                    return hand2;
                }
            }
        }
    }
}
