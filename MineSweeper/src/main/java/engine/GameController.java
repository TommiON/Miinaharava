package engine;

import model.Grid;
import model.Clock;
import ui.MainWindow;

/**
 * This class was the "main loop" of the application,
 * responsible for enforcing the outcome of a game, and also updating the timer
 */
public class GameController {
    MainWindow window;
    Grid grid;
    Clock timing;
    int gridWidth, gridHeight, numberOfMines;
    
    /**
     * Constructor to instantiate the Controller with necessary initial data
     * @param gridWidth number of play tiles in x-direction
     * @param gridHeight number of play tiles in y-direction
     * @param numberOfMines number of mines to be placed randomly around the grid
     */
    public GameController(int gridWidth, int gridHeight, int numberOfMines) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.numberOfMines = numberOfMines;
    }
    
    /**
     * Starts the first round, initiates the build-up of GUI
     */
    public void run() {
        grid = new Grid(gridWidth, gridHeight, numberOfMines);
        timing = new Clock();
        window = new MainWindow();
        window.init(grid, this);
        window.run();
    }
    
    /**
     * Starts the subsequent rounds of game (difference to run() method is that GUI already exists and is not initiated again
     */
    public void startNewGame() {
        grid = new Grid(gridWidth, gridHeight, numberOfMines);
        timing = new Clock();
        window.init(grid, this);
        window.buildGrid();
    }
    
    /**
     * This method is called after each user action in the GUI
     * @param resultFromMove int value received from MoveResolver, inidicating what happened when a tile was exposed
     * 0 = continues, 1 = game won, 2 = game lost, 3 = special value for force-cancelled game
     */
    public void applyNewMove(int resultFromMove) {
        if (resultFromMove == 1) {
            grid.exposeAll();
            window.updateStatusMessageAndGrid(true, false, timing.getElapsedTime());
        }
        
        if (resultFromMove == 2) {
            grid.exposeAll();
            window.updateStatusMessageAndGrid(false, true, timing.getElapsedTime());
        }
        
        if (resultFromMove == 0) {
            window.updateStatusMessageAndGrid(false, false, timing.getElapsedTime());
        }
        
        if (resultFromMove == 3) {
            startNewGame();
        }
    }
}
