package model;

public class Grid {
    public int width, height;
    public int tilesYetHidden, numberOfMines;
    public Tile[][] tiles;
    
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
    
    public Grid(String staticGrid) {
        // static initialiser for non-random grids, received as a String parameter
        // - this is for testing, not for actual games
        this.width = 0;
        this.height = 0;
        this.numberOfMines = 0;
        this.tiles = new Tile[width][height];
    }
    
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
