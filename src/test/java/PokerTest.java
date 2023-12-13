import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;

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
    public void getHighCard() {
        List<Card> deckCards = new ArrayList<Card>() {{
            new Card(1,"S");
            new Card(2,"S");
            new Card(3,"S");
            new Card(4,"S");
            new Card(5,"S");
        }};
        Deck d = new Deck(deckCards);
        Hand h = new Hand(d);
        assertEquals();
    }

    @Test
    public void highCard() {
        Card c = new Card(1, "S");
        assertEquals(c.getColor(), "S");
    }

}

