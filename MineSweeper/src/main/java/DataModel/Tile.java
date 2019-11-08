package DataModel;

public class Tile {
    private boolean isExposed, containsMine, isFlagged;
    private int neighborsContainingMine;
    
    public Tile() {
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
        if(this.containsMine) {
            return true;
            // BOOM! Game over!
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
        if(numberOfMinedNeighbors > 8) {
            numberOfMinedNeighbors = 8;
        }
        // does this make sense, propably not?
        this.neighborsContainingMine = numberOfMinedNeighbors;
    }
}
