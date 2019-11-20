package GameEngine;

public class Move {
    private int x;
    private int y;
    private boolean flagging;
    
    public Move(int x, int y, boolean flagging) {
        this.x = x;
        this.y = y;
        this.flagging = flagging;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public boolean isFlagging() {
        return this.flagging;
    }
}
