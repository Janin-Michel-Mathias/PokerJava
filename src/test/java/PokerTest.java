import org.junit.*;
import static org.junit.Assert.assertEquals;

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
}

