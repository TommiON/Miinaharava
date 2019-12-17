package engine;

import java.util.Timer;
import model.Grid;
import model.Timing;
import ui.MainWindow;

/**
 * This class was the "main loop" of the application,
 * responsible for enforcing the outcome of a game, and also updating the timer
 */
public class GameController {
    private MainWindow window;
    private Grid grid;
    private Timing timing;
    private Timer timer;
  
    /**
     * constructor
     * @param window gets the application MainWindow as a dependency injection 
     * TODO: refactor to handle stuff currently in main.java
     */
    public GameController(Grid grid, MainWindow window) {
        this.grid = grid;
        this.window = window;
        this.timing = new Timing();
        
        ClockTick clock = new ClockTick(this);
        
        this.timer = new Timer();
        this.timer.schedule(clock, 1000, 1000);
    }
    
    /**
     * This method is called after each user action in the GUI
     * @param resultFromMove int value received from MoveResolver, inidicating what happened when a tile was exposed
     * 0 = continues, 1 = game won, 2 = game lost
     */
    public void newRound(int resultFromMove) {
        if (resultFromMove == 1) {
            grid.exposeAll();
            window.updateStatus(true, false, timing.getElapsedTime());
             // TODO: handle endgame
        }
        
        if (resultFromMove == 2) {
            grid.exposeAll();
            window.updateStatus(false, true, timing.getElapsedTime());
            // TODO: handle endgame
        }
        
        window.updateStatus(false, false, timing.getElapsedTime());
                
        // TODO: Timing functionality here (call in intervals of one second)
    }
    
    public void proceedOneSecond() {
        System.out.println("Clock tick..." + timing.getElapsedTime());
        // window.updateStatus(false, false, timing.getElapsedTime());
    }
}
