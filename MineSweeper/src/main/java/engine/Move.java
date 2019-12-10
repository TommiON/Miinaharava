package engine;

/**
 * This class models a single "move" i.e. player action during the game
 */
public class Move {
    private final int x;
    private final int y;
    private final boolean flagging;
    
    /**
     * Constructor
     * @param x coordinate x of the move
     * @param y coordinate y  of the move
     * @param flagging boolean indicating whether a flag is placed in this move
     */
    public Move(int x, int y, boolean flagging) {
        this.x = x;
        this.y = y;
        this.flagging = flagging;
    }
    
    /**
     * @return x-coordinate of the move
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * 
     * @return y-coordinate of the move
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * 
     * @return true if flag is placed, false otherwise
     */
    public boolean isFlagging() {
        return this.flagging;
    }
}
