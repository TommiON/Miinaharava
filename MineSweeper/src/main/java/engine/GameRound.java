package engine;

import model.Grid;
import model.Clock;
import ui.TextUI;

/**
 * The class for looping and controlling the game flow
 * Useful only with TextUI, obsolete with graphcal ui
 * Replaced with GameController class in the graphical version of the project
 */
public class GameRound {
    private boolean gameWon;
    private boolean gameLost;
    private int turn;
    static Grid grid;
    TextUI ui;
    
    /**
     * @param grid the grid to be worked on, dependency-injected
     */
    public GameRound(Grid grid) {
        gameWon = false;
        gameLost = false;
        turn = 0;
        this.grid = grid;
        ui = new TextUI();
        ui.welcome();
    }
    
    /**
     * starts a game, will continue until game either lost or won
     */
    public void run() {
        Clock timing = new Clock();
                
        while (!gameWon && !gameLost) {
            ui.printGrid(grid, false);
            
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
            
            System.out.println("Aikaa kului: " + timing.getElapsedTime() + " sekuntia");
            
            turn++;
        }
    }
}