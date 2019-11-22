import engine.Move;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoveTest {
    Move move;
    
    public MoveTest() {
    }
   
    @Before
    public void setUp() {
        move = new Move(1,1, false);
    }
    
    @Test
    public void initialisesCorrectly() {
        assertEquals(1, move.getX());
        assertEquals(1, move.getY());
        assertEquals(false, move.isFlagging());
    }   
}
