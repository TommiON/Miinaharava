package ui;

import engine.GameController;
import model.Grid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * The main GUI class: builds and maintains the main window
 */
public class MainWindow extends Application {
    static Grid grid;
    static GameController controller;
    static Label statusText;
    static GridPane gridDisplay;
    static TileDisplayManager tileDisplayManager;
    static Button commandButton;
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Miinaharava");
        BorderPane masterLayout = new BorderPane();
        
        gridDisplay = new GridPane();
        buildGrid();
        masterLayout.setCenter(gridDisplay);
        
        statusText = new Label("");
        statusText.setFont(new Font("Arial", 22));
        masterLayout.setBottom(statusText);
        
        commandButton = new Button("Keskeytä peli");
        commandButton.setOnAction((event) -> {
            controller.applyNewMove(2);
        });
        masterLayout.setTop(commandButton);
        
        Scene scene = new Scene(masterLayout);
         
        stage.setScene(scene);
        stage.show();
    }
    
    public void run() {
        launch(MainWindow.class);
    }
    
    /**
     * inits the view, called every time a new game starts
     * @param grid grid to be displayed
     * @param controller the controller instance
     */
    public void init(Grid grid, GameController controller) {
        this.grid = grid;
        this.controller = controller;      
    }
    
    /**
     * builds the grid display according to grid data
     */
    public void buildGrid() {
        gridDisplay.getChildren().clear();
        tileDisplayManager = new TileDisplayManager(grid, controller);
        for (int y = 0; y < grid.height; y++) {
            for (int x = 0; x < grid.width; x++) {
                gridDisplay.add(tileDisplayManager.getTile(x, y), x, y);
            }
        }
    }
    
    /**
     * updates the grid view, called whenever the grid status changes according to user action
     */
    public void updateGridDisplay() {
        for (int y = 0; y < grid.height; y++) {
            for (int x = 0; x < grid.width; x++) {
                gridDisplay.add(tileDisplayManager.getTile(x, y), x, y);
            }
        }
    }
    
    /**
     * handles the status row at the bottom of the window
     * @param won true if game won, false otherwise
     * @param lost true if game lost, false otherwise
     * @param time elapsed time
     */
    public void updateStatusMessageAndGrid(boolean won, boolean lost, long time) {
        if (lost) {
            statusText.setText("Kuolit! Aikaa kului " + time / 60 + " minuuttia, " + time % 60 + " sekuntia");
        } else if (won) {
            statusText.setText("Voitit! Aikaa kului " + time / 60 + " minuuttia, " + time % 60 + " sekuntia");
        }
        
        if (lost || won) {
            commandButton.setText("Pelaa uusi peli");
            commandButton.setOnAction((event) -> {
                controller.startNewGame();
            });
        }
        
        updateGridDisplay();
    }   
}
