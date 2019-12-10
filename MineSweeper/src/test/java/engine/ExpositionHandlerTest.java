package engine;

import engine.Move;
import engine.MoveResolver;
import model.Grid;
import model.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExpositionHandlerTest {
    Grid grid;
    
    @Before
    public void setUp() {
        String initGrid=    "112M2M100\n" +
                            "2M3122210\n" +
                            "3M4101M10\n" +
                            "2MM112210\n" +
                            "12211M211\n" +
                            "1100112M1\n" +
                            "M10000111\n" +
                            "110000000\n" +
                            "000000000";
        
        grid = new Grid(initGrid);
        
        Move move = new Move(0, 8, false);
        int result = MoveResolver.resolve(grid, move);
    }
    
    @Test
    public void revealsAdjacentToZeros() {
        Tile testTile = grid.getTile(0, 7);
        assertTrue(testTile.isExposed());
    }
    
    @Test
    public void doesNotRevealNonAdjacents() {
        Tile testTile = grid.getTile(7, 0);
        assertFalse(testTile.isExposed());
    }
}
