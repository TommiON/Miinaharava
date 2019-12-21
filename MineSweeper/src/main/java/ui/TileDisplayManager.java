package ui;

import model.Grid;
import model.Tile;
import engine.GameController;
import engine.Move;
import engine.MoveResolver;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * This class is responsible for managing the graphical appearance and behavior of individual Tiles
 */
public class TileDisplayManager {
    Grid grid;
    GameController controller;
    
    /**
     * constructor
     * @param grid the current playing Grid, fed in as a dependency injection
     * @param controller the Controller instance, fed in as a dependency injection
     */
    public TileDisplayManager(Grid grid, GameController controller) {
        this.grid = grid;
        this.controller = controller;
    }
    
    /**
     * returns the graphical representation of a single Tile
     * @param x x-coordinate of the desired Tile in the grid
     * @param y y-coordinate of the desired Tile in the grid
     * @return a Button object representing the Tile
     */
    public Button getTile(int x, int y) {
        Tile tile = grid.getTile(x, y);
        String label = defineLabel(tile);
        Button tileButton = new Button(label);
        tileButton.setPrefSize(50, 50);
        
        tileButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if (button == MouseButton.SECONDARY || event.isControlDown()) {
                    int result = MoveResolver.resolve(grid, new Move(x, y, true));
                    String newLabel = defineLabel(tile);
                    tileButton.setText(newLabel);
                    controller.applyNewMove(result);
                } else if (button == MouseButton.PRIMARY) {
                    int result = MoveResolver.resolve(grid, new Move(x, y, false));
                    String newLabel = defineLabel(tile);
                    tileButton.setText(newLabel);
                    controller.applyNewMove(result);
                }
            }
        });
        
        return tileButton;
    }
    
    private String defineLabel(Tile tile) {
        if (tile.isFlagged()) {
            return "#";
        } else if (!tile.isExposed()) {
            return " ";
        } else if (tile.containsMine()) {
            return "M";
        } else {
            return Integer.toString(tile.getNeighborsContainingMine());
        }
    }
}
