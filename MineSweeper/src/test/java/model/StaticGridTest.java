package model;

import model.Grid;
import model.Tile;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StaticGridTest {
    Grid staticGrid;
    
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
        
        staticGrid = new Grid(initGrid);
    }
    
    @Test
    public void initialisesCorrectly() {
        Tile upperLeft = staticGrid.getTile(0, 0);
        Tile xTwoYThree = staticGrid.getTile(2, 3);
        
        assertEquals(1, upperLeft.getNeighborsContainingMine());
        assertFalse(upperLeft.containsMine());
        assertTrue(xTwoYThree.containsMine());
    }
}
