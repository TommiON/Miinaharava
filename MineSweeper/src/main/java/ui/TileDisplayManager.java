package ui;

import engine.Move;
import engine.MoveResolver;
import javafx.scene.control.Button;
import model.Grid;
import model.Tile;

public class TileDisplayManager {
    Grid grid;
    
    public TileDisplayManager(Grid grid) {
        this.grid = grid;
    }
    
    public Button getTile(int x, int y) {
        Tile tile = grid.getTile(x, y);
        String label;
        
        if (!tile.isExposed()) {
            label = " ";
        } else if (tile.containsMine()) {
            label = "M";
        } else {
            label = Integer.toString(tile.getNeighborsContainingMine());
        }
     
        Button tileButton = new Button(label);
        
        tileButton.setOnAction((event) -> {
            int result = MoveResolver.resolve(grid, new Move(x, y, false));  
        });
        
        return tileButton;
    }
    
    
}
