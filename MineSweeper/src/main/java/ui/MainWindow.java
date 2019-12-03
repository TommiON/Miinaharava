package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Grid;

public class MainWindow extends Application {
    static Grid grid;
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Miinaharava");
        
        GridDisplayManager gridDisplayManager = new GridDisplayManager(grid);
        GridPane gridDisplay = gridDisplayManager.getGrid();
        
        Scene scene = new Scene(gridDisplay);
         
        stage.setScene(scene);
       
        stage.show();
    }
    
    public void run(Grid grid) {
        this.grid = grid;
        launch(MainWindow.class);
    }
    
}
