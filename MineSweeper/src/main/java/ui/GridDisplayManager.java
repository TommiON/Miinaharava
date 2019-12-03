package ui;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.Grid;

public class GridDisplayManager {
    Grid grid;
    GridPane displayGrid;
    
    public GridDisplayManager(Grid grid) {
        this.grid = grid;
        displayGrid = new GridPane();
    }
    
    public GridPane getGrid() {
        for(int y = 1; y <= grid.height; y++) {
            for(int x = 1; x <= grid.width; x++) {
                displayGrid.add(new Button("*"), x, y);
            }
        }
        return displayGrid;
    }
}
