public class Main {
    public static void main(String[] args) {
        //crée le deck de la classe Deck, deux mains avec gethand, les affiche et les compare

        Deck deck = new Deck();
        Hand hand1 = new Hand(deck);
        Hand hand2 = new Hand(deck);

        System.out.println(hand1.getHand());
        System.out.println(hand2.getHand());

        CompareHands compare = new CompareHands();
        System.out.println(compare.compare(hand1, hand2));

    }
}
