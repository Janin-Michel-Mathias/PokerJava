public class Deck {
    private Card[] cards;
    Deck() {
        cards = new Card[52];
        int i = 0;
        for (String color : new String[] {"S", "H", "D", "C"}) {
            for (int number = 1; number <= 13; number++) {
                cards[i++] = new Card(number, color);
            }
        }
    }

    public Card[] getoneCard() {
        Card[] card = new Card[1];
        int index = (int) (Math.random() * 52);
        while (cards[index] == null) {
            index = (int) (Math.random() * 52);
        }
        card[0] = cards[index];
        cards[index] = null;
        return card;
    }

    public Card[] getHand() {
        //Pick card to make the hand, delete the cards frome the deck
        Card[] hand = new Card[5];
        for (int i = 0; i < 5; i++) {
            int index = (int) (Math.random() * 52);
            while (cards[index] == null) {
                index = (int) (Math.random() * 52);
            }
            hand[i] = cards[index];
            cards[index] = null;
        }
        return hand;
    }
}
