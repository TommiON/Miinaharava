package engine;

import model.Timing;

/**
 * This class is the "main loop" of the application,
 * responsible for enforcing the outcome of a game, and also updating the timer
 */
public class GameController {
    private Timing timing = new Timing();
    
    /**
     * This method is called after each user action in the GUI
     * @param resultFromMove int value received from MoveResolver, inidicating what happened when a tile was exposed
     */
    public void newRound(int resultFromMove) {
        if(resultFromMove == 1) {
            // handle endgame
            System.out.println("Won!");
            long elapsedTime = timing.getElapsedTime();
        }
        
        if(resultFromMove == 2) {
            // handle endgame
            System.out.println("Lost!");
            long elapsedTime = timing.getElapsedTime();
        }
        
        // TODO: Timing functionality here (call in intervals of one second)
    }
    
}
