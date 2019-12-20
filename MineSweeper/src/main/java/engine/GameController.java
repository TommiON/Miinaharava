package engine;

import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Grid;
import model.Timing;
import ui.MainWindow;

/**
 * This class was the "main loop" of the application,
 * responsible for enforcing the outcome of a game, and also updating the timer
 */
public class GameController {
    MainWindow window;
    Grid grid;
    Timing timing;
    // private Timer timer;
  
    /**
     * constructor
     * @param window gets the application MainWindow as a dependency injection 
     * TODO: refactor to handle stuff currently in main.java
     */
    
    /*
    public GameController(Grid grid, MainWindow window) {
        // ClockTick clock = new ClockTick(this);
        
        // this.timer = new Timer();
        // this.timer.schedule(clock, 1000, 1000);
    }
    */
    
    public void run() {
        grid = new Grid(9, 9, 10);
        timing = new Timing();
        window = new MainWindow();
        window.init(grid, this);
        window.run();
    }
    
    /**
     * This method is called after each user action in the GUI
     * @param resultFromMove int value received from MoveResolver, inidicating what happened when a tile was exposed
     * 0 = continues, 1 = game won, 2 = game lost, 3 = special value for wilfully cancelled game
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
     
        // TODO: Timing functionality here (call in intervals of one second)
    }
    
    public void startNewGame() {
        grid = new Grid(9, 9, 10);
        timing = new Timing();
        window.init(grid, this);
        window.buildGrid();
    }
    
    /*
    public void waitForAWhile() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
    public void proceedOneSecond() {
        System.out.println("Clock tick..." + timing.getElapsedTime());
        // window.updateStatusMessageAndGrid(false, false, timing.getElapsedTime());
    }
}
