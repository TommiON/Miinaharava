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

public class MoveResolverTest {
    
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
    }
    
    @Test
    public void placingFlagContinuesGame() {
        Move move = new Move(0, 0, true);
        int result = MoveResolver.resolve(grid, move);
        assertEquals(0, result);
    }
    
    @Test
    public void gameContinuesIfUnexposedEmptyTilesLeft() {
        Move move = new Move(0, 0, false);
        int result = MoveResolver.resolve(grid, move);
        // grid.tilesYetHidden > 0 at this point
        assertEquals(0, result);
    }
    
    @Test
    public void exposingMinedTileEndsGame() {
        Move move = new Move(0, 3, false);
        int result = MoveResolver.resolve(grid, move);
        assertEquals(2, result);
    }
    
    @Test
    public void gameWonWhenAllNonMinedExposed() {
        // simulates a situation when all non-mined tiles except one are succesfully exposed
        grid.tilesYetHidden -= 70;
        
        // expose the last tile
        Move move = new Move(0, 2, false);
        
        int result = MoveResolver.resolve(grid, move);
        assertEquals(1, result);
    }
}
