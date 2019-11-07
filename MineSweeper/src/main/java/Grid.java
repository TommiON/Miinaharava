public class Grid {
    private final int width, height, numberOfMines;
    private Tile[][] tiles;
    
    public Grid(int width, int height, int numberOfMines) {
        // TODO: delegate init phases to separate methods (10 row rule)?
        
        this.width = width;
        this.height = height;
        this.numberOfMines = numberOfMines;
        
        // create an empty grid
        this.tiles = new Tile[width][height];
        
        // initialize with non-mined tiles
        for(int x = 0; x < this.tiles.length; x++) {
            for(int y = 0; y < this.tiles[0].length; y++) {
                this.tiles[x][y] = new Tile();
            }
        }
        
        // place mines
        int minesPlaced = 0;
        int x = 0;
        int y = 0;
        
        double propabilityForAMine = (double) numberOfMines / (width * height);
        System.out.println("Miinan todennäköisyys / ruutu: " + propabilityForAMine);
        
        while(minesPlaced != numberOfMines) {
            double random = Math.random();
            
            if(random <= propabilityForAMine) {
                Tile currentTile = tiles[x][y];
                if(!currentTile.containsMine()) {
                    currentTile.placeMine();
                    minesPlaced++;
                }
            }
            
            x++;
            if(x == this.tiles.length) {
                x = 0;
                y++;
            }
            if(y == this.tiles[0].length) {
                x = 0;
                y = 0;
            }
        }
    }
}
