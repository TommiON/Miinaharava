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
    
    public void setNeighborsContainingMine(int numberOfMinedNeighbors) {
        this.neighborsContainingMine = numberOfMinedNeighbors;
    }
}
