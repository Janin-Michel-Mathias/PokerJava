import org.junit.*;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PokerTest {
    @Test
    public void createCard() {
        Card c = new Card(1, "S");
        assertEquals(Card.class, c.getClass());
    }
    @Test
    public void getNumber() {
        Card c = new Card(1, "S");
        assertEquals(c.getNumber(), 1);
    }

    @Test
    public void getSign() {
        Card c = new Card(1, "S");
        assertEquals(c.getColor(), "S");
    }

    @Test
    public void getHand() {
        Hand h = new Hand(new Deck());
        assertNotEquals(h, null);
    }

    @Test
    public void highCard() {
        Card c = new Card(1, "S");
        assertEquals(c.getColor(), "S");
    }

    @Test
    public void noRank() {
        List<Card> deckCards = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            deckCards.add(new Card(i + 1, "S"));
        }
        deckCards.add(new Card(6, "D"));
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getRank(), HandRank.HIGH_CARD);
    }

    @Test
    public void pair() {
        List<Card> deckCards = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            deckCards.add(new Card(i + 1, "S"));
        }
        deckCards.add(new Card(1, "D"));
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getRank(), HandRank.PAIR);
    }

    @Test
    public void twoPairs() {
        List<Card> deckCards = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            deckCards.add(new Card(i + 1, "S"));
        }
        deckCards.add(new Card(1, "D"));
        deckCards.add(new Card(2, "D"));
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getRank(), HandRank.TWO_PAIR);
    }

    @Test
    public void threeOfAKind() {
        List<Card> deckCards = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            deckCards.add(new Card(i + 1, "S"));
        }
        deckCards.add(new Card(1, "D"));
        deckCards.add(new Card(1, "H"));
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getRank(), HandRank.THREE_OF_A_KIND);
    }

    @Test
    public void straight() {
        List<Card> deckCards = new ArrayList<>();

        for(int i = 1; i < 5; i++) {
            deckCards.add(new Card(i + 1, "S"));
        }
        deckCards.add(new Card(6, "D"));
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getRank(), HandRank.STRAIGHT);
    }

    @Test
    public void flush() {
        List<Card> deckCards = new ArrayList<>();

        for(int i = 1; i < 5; i++) {
            deckCards.add(new Card(i+1, "S"));
        }

        deckCards.add(new Card(7, "S"));
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getRank(), HandRank.FLUSH);
    }

    @Test
    public void fullHouse() {
        List<Card> deckCards = new ArrayList<>();

        deckCards.add(new Card(7, "H"));
        deckCards.add(new Card(7, "D"));
        deckCards.add(new Card(7, "S"));
        deckCards.add(new Card(2, "D"));
        deckCards.add(new Card(2, "S"));
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getRank(), HandRank.FULL_HOUSE);
    }

    @Test
    public void fourOfAKind() {
        List<Card> deckCards = new ArrayList<>();

        deckCards.add(new Card(7, "H"));
        deckCards.add(new Card(7, "D"));
        deckCards.add(new Card(7, "S"));
        deckCards.add(new Card(7, "C"));
        deckCards.add(new Card(2, "S"));
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getRank(), HandRank.FOUR_OF_A_KIND);
    }

    @Test
    public void straightFlush() {
        List<Card> deckCards = new ArrayList<>();
        for(int i = 1; i < 6; i++) {
            deckCards.add(new Card(i+1, "S"));
        }
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getRank(), HandRank.STRAIGHT_FLUSH);
    }

    @Test
    public void compareHandsEquality() {
        List<Card> deckCards = new ArrayList<>();
        List<Card> deckCards2 = new ArrayList<>();
        for(int i = 1; i < 6; i++) {
            deckCards.add(new Card(i+1, "S"));
        }

        for(int i = 1; i < 6; i++) {
            deckCards2.add(new Card(i+1, "D"));
        }
        Deck d = new Deck(deckCards);
        Deck d2 = new Deck(deckCards2);
        Hand h = new Hand(d);
        Hand h2 = new Hand(d2);
        assertEquals(CompareHands.compare(h, h2), null);
    }

    @Test
    public void compareHandsDifferentRanks() {
        List<Card> deckCards = new ArrayList<>();
        List<Card> deckCards2 = new ArrayList<>();
        for(int i = 1; i < 6; i++) {
            deckCards.add(new Card(i+1, "S"));
        }

        for(int i = 1; i < 5; i++) {
            deckCards2.add(new Card(i+1, "D"));
        }
        deckCards2.add(new Card(2, "C"));
        Deck d = new Deck(deckCards);
        Deck d2 = new Deck(deckCards2);
        Hand h = new Hand(d);
        Hand h2 = new Hand(d2);

        assertEquals(CompareHands.compare(h, h2), h);
    }

    @Test
    public void compareHandsSameRanksNoEquality() {
        List<Card> deckCards = new ArrayList<>();
        List<Card> deckCards2 = new ArrayList<>();
        for(int i = 1; i < 6; i++) {
            deckCards.add(new Card(i+1, "S"));
        }

        for(int i = 2; i < 7; i++) {
            deckCards2.add(new Card(i+1, "D"));
        }

        Deck d = new Deck(deckCards);
        Deck d2 = new Deck(deckCards2);
        Hand h = new Hand(d);
        Hand h2 = new Hand(d2);

        assertEquals(CompareHands.compare(h, h2), h2);
    }


}

