package main;

import model.Grid;
import engine.GameRound;    
import java.awt.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import ui.MainWindow;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(9, 9, 10);
        GameRound gameround = new GameRound(grid);
        
        MainWindow window = new MainWindow();
        // window.run(grid);
        
        gameround.run();
    }
}
