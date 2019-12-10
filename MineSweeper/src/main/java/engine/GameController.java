package engine;

import model.Timing;
import ui.MainWindow;

/**
 * This class was the "main loop" of the application,
 * responsible for enforcing the outcome of a game, and also updating the timer
 */
public class GameController {
    private Timing timing = new Timing();
    private MainWindow window;
    
    /**
     * constructor
     * @param window gets the application MainWindow as a dependency injection 
     */
    public GameController(MainWindow window) {
        this.window = window;
    }
    
    /**
     * This method is called after each user action in the GUI
     * @param resultFromMove int value received from MoveResolver, inidicating what happened when a tile was exposed
     * 0 = continues, 1 = game won, 2 = game lost
     */
    public void newRound(int resultFromMove) {
        if (resultFromMove == 1) {
            window.updateStatus(true, false, timing.getElapsedTime());
             // TODO: handle endgame
        }
        
        if (resultFromMove == 2) {
            window.updateStatus(false, true, timing.getElapsedTime());
            // TODO: handle endgame
        }
                
        // TODO: Timing functionality here (call in intervals of one second)
    }
}
