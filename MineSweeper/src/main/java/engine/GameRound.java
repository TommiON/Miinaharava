package engine;

import model.Grid;
import model.Timer;
import ui.TextUI;

public class GameRound {
    private boolean gameWon;
    private boolean gameLost;
    private int turn;
    static Grid grid;
    TextUI ui;
    
    public GameRound(Grid grid) {
        gameWon = false;
        gameLost = false;
        turn = 0;
        this.grid = grid;
        ui = new TextUI();
    }
    
    public void run() {
        ui.welcome();
        
        Timer timer = new Timer();
        
        while (!gameWon && !gameLost) {
            ui.printGrid(grid, false);
            // open grid printed for testing purposes...
            ui.printGrid(grid, true);
            
            Move nextMove = ui.getNextMove(grid);
            int result = MoveResolver.resolve(grid, nextMove);
            
            if (result == 2) {
                gameLost = true;
                ui.printGrid(grid, true);
                ui.gameLost();
            }
            
            if (result == 1) {
                gameWon = true;
                ui.printGrid(grid, true);
                ui.gameWon();
            }
            
            System.out.println("Aikaa kului: " + timer.getElapsedTime() + " sekuntia");
            
            turn++;
        }
    }
    
}
