package ui;

import engine.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Grid;

public class MainWindow extends Application {
    static Grid grid;
    static GameController controller;
    static Label statusText;
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Miinaharava");
        
        BorderPane masterLayout = new BorderPane();
        
        GridDisplayManager gridDisplayManager = new GridDisplayManager(grid, controller);
        GridPane gridDisplay = gridDisplayManager.getGrid();
        masterLayout.setCenter(gridDisplay);
        
        statusText = new Label("");
        statusText.setFont(new Font("Arial", 22));
        masterLayout.setBottom(statusText);
        
        Scene scene = new Scene(masterLayout);
         
        stage.setScene(scene);
       
        stage.show();
    }
    
    public void run(Grid grid, GameController controller) {
        this.grid = grid;
        this.controller = controller;
        launch(MainWindow.class);
    }
    
    public void updateStatus(boolean won, boolean lost, long time) {
        if(lost) {
            statusText.setText("Kuolit! Aikaa kului " + time + " sekuntia");
        }
        if(won) {
            statusText.setText("Voitit! Aikaa kului " + time + " sekuntia");
        }
    }   
}
