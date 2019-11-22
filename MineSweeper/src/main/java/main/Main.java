package main;

import model.Grid;
import engine.GameRound;
import ui.TextUI;

// mvn compile exec:java -Dexec.mainClass=Main.Main

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(9, 9, 10);
        GameRound gameround = new GameRound(grid);
        gameround.run();
    }
}
