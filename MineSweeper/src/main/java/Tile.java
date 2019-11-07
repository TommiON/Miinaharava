public class Tile {
    private final int xPosition, yPosition;
    private boolean isExposed;
    private boolean containsMine;
    private int neighborsContainingMine;
    
    public Tile(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.containsMine = false;
        this.isExposed = false;
        this.neighborsContainingMine = 0;
    }
    
    public boolean isExposed() {
        return this.isExposed;
    }
    
    public void expose() {
        this.isExposed = true;
        if(this.containsMine) {
            // BOOM! Game over!
        }
    }
    
    public boolean containsMine() {
        return this.containsMine;
    }
    
    public void placeMine() {
        this.containsMine = true;
    }
}
