import model.Tile;
import model.Grid;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GridTest {
    Grid grid;
    
    public GridTest() {
        
    }
    
    @Before
    public void setUp() {
        grid = new Grid(9, 9, 10);
    }
    
    @Test
    public void initialisesWithCorrectAmountOfMines() {
        int minesFound = 0;
        for(int x = 0; x < 9; x++) {
            for(int y = 0; y < 9; y++) {
                if(grid.getTile(x, y).containsMine()) {
                    minesFound++;
                }
            }
        }
        assertEquals(10, minesFound);
    }
    
    @Test
    public void calculatesMinedNeighborsCorrectly_atCoordinates3_4() {
        // test hard-coded grid position x=3, y=4
        int localMineCalculation = 0;
        if(grid.getTile(2,3).containsMine()) {
            localMineCalculation++;
        }
        if(grid.getTile(3,3).containsMine()) {
            localMineCalculation++;
        }
        if(grid.getTile(4,3).containsMine()) {
            localMineCalculation++;
        }
        if(grid.getTile(2,4).containsMine()) {
            localMineCalculation++;
        }
        if(grid.getTile(4,4).containsMine()) {
            localMineCalculation++;
        }
        if(grid.getTile(2,5).containsMine()) {
            localMineCalculation++;
        }
        if(grid.getTile(3,5).containsMine()) {
            localMineCalculation++;
        }
        if(grid.getTile(4,5).containsMine()) {
            localMineCalculation++;
        }
        
        assertEquals(localMineCalculation, grid.getTile(3,4).getNeighborsContainingMine());
    }
    
    @Test
    public void calculatesMinedNeighborsCorrectly_atUpperLeftCorner() {
        // test hard-coded grid position x=0, y=0
        int localMineCalculation = 0;
        if(grid.getTile(1,0).containsMine()) {
            localMineCalculation++;
        }
        if(grid.getTile(0,1).containsMine()) {
            localMineCalculation++;
        }
        if(grid.getTile(1,1).containsMine()) {
            localMineCalculation++;
        }
        
        assertEquals(localMineCalculation, grid.getTile(0,0).getNeighborsContainingMine());
    }
    
    @Test
    public void printsCorrectly() {
        String hiddenGrid = grid.toString(false);
        System.out.println(hiddenGrid);
         // length should be 9*9 + 9 end-of-line characters
        assertEquals(90, hiddenGrid.length());
        
        String exposedGrid = grid.toString(true);
        System.out.println(exposedGrid);
        assertEquals(90, exposedGrid.length());
    }
}
