package ui;

import javafx.scene.control.Button;
import model.Grid;
import model.Tile;

public class TileDisplayManager {
    Grid grid;
    
    public TileDisplayManager(Grid grid) {
        this.grid = grid;
    }
    
    public Button getTile(int x, int y) {
        // temporary implementation, return everything exposed
        
        Tile tile = grid.getTile(x, y);
        String label;
        
        if (tile.containsMine()) {
            label = "M";
        } else {
            label = Integer.toString(tile.getNeighborsContainingMine());
        }
        return new Button(label);
    }
    
    
}
