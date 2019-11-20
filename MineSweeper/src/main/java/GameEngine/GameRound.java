package GameEngine;

import DataModel.Grid;
import UserInterface.TextUI;

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
        
        while(!gameWon && !gameLost) {
            
            ui.printGrid(grid, false);
            Move nextMove = ui.getNextMove(grid);
            int result = MoveResolver.resolve(grid, nextMove);
            
            if(result == 2) {
                gameLost = true;
                ui.gameOver();
                ui.printGrid(grid, true);
            }
            
            turn++;
        }
    }
    
}
