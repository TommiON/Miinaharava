package ui;

import engine.GameController;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.Grid;

public class GridDisplayManager {
    Grid grid;
    TileDisplayManager tileDisplayManager;
    GridPane gridDisplay;
   
    public GridDisplayManager(Grid grid, GameController controller) {
        this.grid = grid;
        tileDisplayManager = new TileDisplayManager(grid, controller);
        this.gridDisplay = new GridPane();
    }
    
    public GridPane getGrid() {
        for (int y = 0; y < grid.height; y++) {
            for (int x = 0; x < grid.width; x++) {
                // gridDisplay.add(new Button("x"), x, y);
                gridDisplay.add(tileDisplayManager.getTile(x, y), x, y);
            }
        }
        return gridDisplay;
    }
}
