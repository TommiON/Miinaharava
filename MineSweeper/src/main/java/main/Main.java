package main;

import engine.GameController;
import model.Grid;  
import java.awt.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import ui.MainWindow;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(9, 9, 10); 
        GameController controller = new GameController();
        MainWindow window = new MainWindow();
        window.run(grid, controller);
    }
}
