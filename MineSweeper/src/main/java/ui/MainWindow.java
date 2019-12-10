package ui;

import engine.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Grid;

public class MainWindow extends Application {
    static Grid grid;
    static GameController controller;
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Miinaharava");
        
        BorderPane masterLayout = new BorderPane();
        
        GridDisplayManager gridDisplayManager = new GridDisplayManager(grid, controller);
        GridPane gridDisplay = gridDisplayManager.getGrid();
        masterLayout.setCenter(gridDisplay);
        
        FlowPane statusElement = StatusDisplayManager.updateStatus(false, false, 0);
        masterLayout.setBottom(statusElement);
        
        Scene scene = new Scene(masterLayout);
         
        stage.setScene(scene);
       
        stage.show();
    }
    
    public void run(Grid grid, GameController controller) {
        this.grid = grid;
        this.controller = controller;
        launch(MainWindow.class);
    }
    
}
