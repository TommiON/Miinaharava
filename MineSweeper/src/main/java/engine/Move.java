package engine;

public class Move {
    private final int x;
    private final int y;
    private final boolean flagging;
    
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
