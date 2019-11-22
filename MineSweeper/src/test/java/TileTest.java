import model.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TileTest {
    Tile tile;
    
    public TileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tile = new Tile(6,6);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void initialisesCorrectly() {
        assertEquals(false, tile.containsMine());
        assertEquals(false, tile.isExposed());
        assertEquals(false, tile.isFlagged());
        assertEquals(0, tile.getNeighborsContainingMine());
    }
    
    @Test
    public void flagsAndUnflags() {
        tile.flag();
        assertEquals(true, tile.isFlagged());
        tile.unflag();
        assertEquals(false, tile.isFlagged());
    }
    
    @Test
    public void exposesAndExplodesCorrectly() {
        Tile tile1 = new Tile(1,1);
        Tile tile2 = new Tile(2,1);
        Tile tile3 = new Tile(3,1);
        tile2.placeMine();
        
        assertEquals(false, tile1.isExposed());
        assertEquals(false, tile1.exposeMayExplode());
        assertEquals(true, tile1.isExposed());
        
        assertEquals(false, tile2.isExposed());
        assertEquals(true, tile2.exposeMayExplode());
        assertEquals(true, tile2.isExposed());
        
        assertEquals(false, tile3.isExposed());
    }
}
