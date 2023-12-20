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
    public void getHighCardAce() {
        List<Card> deckCards = new ArrayList<>();

        for(int i = 2; i < 6; i++ ) {
            deckCards.add(new Card(i, "S"));
        }
        Card higherCard = new Card(1, "S");
        deckCards.add(higherCard);
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getHigherCard(0), higherCard);
    }

    @Test
    public void getHighCard() {
        List<Card> deckCards = new ArrayList<>();

        for(int i = 2; i < 6; i++ ) {
            deckCards.add(new Card(i, "S"));
        }
        Card higherCard = new Card(7, "S");
        deckCards.add(higherCard);
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getHigherCard(0), higherCard);
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
        assertEquals(h.getRank(), 0);
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
        assertEquals(h.getRank(), 1);
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
        assertEquals(h.getRank(), 2);
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
        assertEquals(h.getRank(), 3);
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
        assertEquals(h.getRank(), 4);
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
        assertEquals(h.getRank(), 5);
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
        assertEquals(h.getRank(), 6);
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
        assertEquals(h.getRank(), 7);
    }

    @Test
    public void straightFlush() {
        List<Card> deckCards = new ArrayList<>();
        for(int i = 1; i < 6; i++) {
            deckCards.add(new Card(i+1, "S"));
        }
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals(h.getRank(), 8);
    }


}

