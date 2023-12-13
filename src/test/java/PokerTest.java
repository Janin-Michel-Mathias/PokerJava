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

}

