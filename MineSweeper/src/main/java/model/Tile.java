/**
 * This class models a single tile in the grid and provides functionality
 * that concerns a single tile
 */

package model;

public class Tile {
    private boolean isExposed, containsMine, isFlagged;
    private int neighborsContainingMine;
    public int x, y;
    
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.containsMine = false;
        this.isExposed = false;
        this.isFlagged = false;
        this.neighborsContainingMine = 0;
    }
    
    public boolean isExposed() {
        return this.isExposed;
    }
    
    public boolean exposeMayExplode() {
        // returns true if EXPLOSION, otherwise false
        this.isExposed = true;
        if (this.containsMine) {
            return true;
        }
        return false;
    }
    
    public boolean containsMine() {
        return this.containsMine;
    }
    
    /**
     * places a mine in this tile, i.e sets containsMine=true
     */
    public void placeMine() {
        this.containsMine = true;
    }
    
    public boolean isFlagged() {
        return this.isFlagged;
    }
    
    public void flag() {
        this.isFlagged = true;
    }
    
    public void unflag() {
        this.isFlagged = false;
    }
    
    public int getNeighborsContainingMine() {
        return this.neighborsContainingMine;
    }
    
    /**
     * sets a value indicating how many of the neighboring tiles contain a mine
     * @param numberOfMinedNeighbors 
     */
    public void setNeighborsContainingMine(int numberOfMinedNeighbors) {
        this.neighborsContainingMine = numberOfMinedNeighbors;
    }
}
