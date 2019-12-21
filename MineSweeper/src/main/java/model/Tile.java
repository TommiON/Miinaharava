package model;

/**
 * This class models a single tile in the grid and provides functionality that concerns a single tile
 */
public class Tile {
    private boolean isExposed, containsMine, isFlagged;
    private int neighborsContainingMine;
    public int x, y;
    
    /**
     * constructor method
     * @param x the x-coordinate of the new Tile
     * @param y the y-coordinate of the new Tile
     */
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.containsMine = false;
        this.isExposed = false;
        this.isFlagged = false;
        this.neighborsContainingMine = 0;
    }
    
    /**
     * 
     * @return true if exposed, false otherwise
     */
    public boolean isExposed() {
        return this.isExposed;
    }
    
    /**
     * 
     * @return true if EXPLOSION, otherwise false
     */
    public boolean exposeMayExplode() {
        if (this.isFlagged) {
            return false;
        }
        this.isExposed = true;
        if (this.containsMine) {
            return true;
        }
        return false;
    }
    
    /**
     * This method is used in the end-game to expose all tiles, including flagged ones
     */
    public void forceExpose() {
        this.isExposed = true;
    }
    
    /**
     * @return true if the tile is mined, false otherwise
     */
    public boolean containsMine() {
        return this.containsMine;
    }
    
    /**
     * places a mine in this tile, i.e sets containsMine=true
     */
    public void placeMine() {
        this.containsMine = true;
    }
    
    /**
     * 
     * @return true if a flag has been placed in this tile, false otherwise
     */
    public boolean isFlagged() {
        return this.isFlagged;
    }
    
    /**
     * Places a flag if the tile is unglagged, or takes it back to unexposed initial status if there is a flag
     */
    public void placeOrRemoveFlag() {
        if (this.isFlagged) {
            this.isExposed = false;
            this.isFlagged = false;
        } else {
            this.isFlagged = true;
        }
    }
    
    /**
     * 
     * @return number of adjacent tiles that contain a mine
     */
    public int getNeighborsContainingMine() {
        return this.neighborsContainingMine;
    }
    
    /**
     * sets a value indicating how many of the neighboring tiles contain a mine
     * @param numberOfMinedNeighbors number of adjacent tiles that contain a mine
     */
    public void setNeighborsContainingMine(int numberOfMinedNeighbors) {
        this.neighborsContainingMine = numberOfMinedNeighbors;
    }
}
