package model;

/**
 * This class initialises and manages the grid of tiles
 */
public class Grid {
    public int width, height;
    public int tilesYetHidden, numberOfMines;
    public Tile[][] tiles;
    
    /**
     * constructor
     * @param width x-width of the grid
     * @param height y-height of the grid
     * @param numberOfMines number of mines to be placed
     */
    public Grid(int width, int height, int numberOfMines) {
        this.width = width;
        this.height = height;
        this.numberOfMines = numberOfMines;
        this.tilesYetHidden = width * height;
        
        // create an empty grid
        this.tiles = new Tile[width][height];
        
        // internal helper variables
        int x, y;
        
        // initialize the grid with non-mined tiles
        for (x = 0; x < this.tiles.length; x++) {
            for (y = 0; y < this.tiles[0].length; y++) {
                this.tiles[x][y] = new Tile(x, y);
            }
        }
        
        // place mines randomly
        int minesPlaced = 0;
        x = 0;
        y = 0;
        double propabilityForAMine = (double) numberOfMines / (width * height);
        while (minesPlaced != numberOfMines) {
            double randomNumber = Math.random();
            if (randomNumber <= propabilityForAMine) {
                if (!tiles[x][y].containsMine()) {
                    tiles[x][y].placeMine();
                    minesPlaced++;
                }
            }
            x++;
            if (x == this.tiles.length) {
                x = 0;
                y++;
            }
            if (y == this.tiles[0].length) {
                x = 0;
                y = 0;
            }
        }
        
        // finally calculate the number of mined neighbors for each tile
        calculateMinedNeighbors();
    }
    
    /**
     * internal helper method to calculate number of surrounding mines for each tile
     */
    private void calculateMinedNeighbors() {
        int x, y;
        for (x = 0; x < this.tiles.length; x++) {
            for (y = 0; y < this.tiles[0].length; y++) {
                int minedNeighbors = 0;
                if (x > 0 && y > 0 && tiles[x - 1][y - 1].containsMine()) {
                    minedNeighbors++;
                }
                if (y > 0 && tiles[x][y - 1].containsMine()) {
                    minedNeighbors++;
                }
                if (y > 0 && x < tiles.length - 1 && tiles[x + 1][y - 1].containsMine()) {
                    minedNeighbors++;
                }
                if (x > 0 && tiles[x - 1][y].containsMine()) {
                    minedNeighbors++;
                }
                if (x < tiles.length - 1 && tiles[x + 1][y].containsMine()) {
                    minedNeighbors++;
                }
                if (x > 0 && y < tiles[0].length - 1 && tiles[x - 1][y + 1].containsMine()) {
                    minedNeighbors++;
                }
                if (y < tiles[0].length - 1 && tiles[x][y + 1].containsMine()) {
                    minedNeighbors++;
                }
                if (x < tiles.length - 1 && y < tiles[0].length - 1 && tiles[x + 1][y + 1].containsMine()) {
                    minedNeighbors++;
                }
                tiles[x][y].setNeighborsContainingMine(minedNeighbors);      
            }
        }   
    }
    
    /**
     * static initialiser for non-random grids, used for testing, not for actual games
     * @param staticGrid the grid to be used in String form (not validated, expected to be valid)
     */
    public Grid(String staticGrid) {
        this.tiles = new Tile[9][9];
        this.width = 9;
        this.height = 9;
        this.tilesYetHidden = 9 * 9;
        this.numberOfMines = 10;
        
        int index = 0;
        for (int x = 0; x < this.tiles.length; x++) {
            for (int y = 0; y < this.tiles[0].length; y++) {
                this.tiles[x][y] = new Tile(x, y);
                if (staticGrid.charAt(index) == 'M') {
                    tiles[x][y].placeMine();
                } else {
                    tiles[x][y].setNeighborsContainingMine(Character.getNumericValue(staticGrid.charAt(index)));
                }
                index++;
            }
        }
    }
    
    /**
     * String representation of the grid
     * @param allExposed true if the whole grid is to be exposed, false otherwise
     * @return the grid as a String
     */
    public String toString(boolean allExposed) {
        String output = "";
        
        if (allExposed) {
            for (int y = 0; y < tiles[0].length; y++) {
                for (int x = 0; x < tiles.length; x++) {
                    if (tiles[x][y].containsMine()) {
                        output = output + "M";
                    } else {
                        output = output + tiles[x][y].getNeighborsContainingMine();
                    }
                
                    if (x == tiles.length - 1) {
                        output = output + "\n";
                    }
                }
            }
        } else {
            for (int y = 0; y < tiles[0].length; y++) {
                for (int x = 0; x < tiles.length; x++) {
                    if (!tiles[x][y].isExposed() && !tiles[x][y].isFlagged()) {
                        output = output + "*";
                    } else if (tiles[x][y].containsMine() && !tiles[x][y].isFlagged()) {
                        output = output + "M";
                    } else if (tiles[x][y].isFlagged()) {
                        output = output + "F";
                    } else {
                        output = output + tiles[x][y].getNeighborsContainingMine();
                    }
                    
                    if (x == tiles.length - 1) {
                        output = output + "\n";
                    }
                }
            }
        }
        
        return output;
    }
    
    /**
     * return a Tile object at specified coordinates
     * @param x
     * @param y
     * @return 
     */
    public Tile getTile(int x, int y) {
        if (x < 0) {
            x = 0;
        }
        if (x > width - 1) {
            x = width - 1;
        }
        if (y < 0) {
            y = 0;
        }
        if (y > height - 1) {
            y = height - 1;
        }
        
        return this.tiles[x][y];
    }
}
