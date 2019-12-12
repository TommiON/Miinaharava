package ui;

import model.Grid;
import model.Tile;
import engine.GameController;
import engine.Move;
import engine.MoveResolver;
import javafx.scene.control.Button;

public class TileDisplayManager {
    Grid grid;
    GameController controller;
    
    public TileDisplayManager(Grid grid, GameController controller) {
        this.grid = grid;
        this.controller = controller;
    }
    
    public Button getTile(int x, int y) {
        Tile tile = grid.getTile(x, y);
        String label = defineLabel(tile);
     
        Button tileButton = new Button(label);
        tileButton.setPrefSize(50, 50);
        tileButton.setMinSize(50, 50);
        tileButton.setMaxSize(50, 50);
        
        tileButton.setOnAction((event) -> {
            int result = MoveResolver.resolve(grid, new Move(x, y, false));
            String newLabel = defineLabel(tile);
            tileButton.setText(newLabel);
            controller.newRound(result);
        });
        
        return tileButton;
    }
    
    private String defineLabel(Tile tile) {
        if (!tile.isExposed()) {
            return " ";
        } else if (tile.containsMine()) {
            return "M";
        } else {
            return Integer.toString(tile.getNeighborsContainingMine());
        }
    }
}
