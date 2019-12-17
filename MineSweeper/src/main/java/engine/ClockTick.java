package engine;

import java.util.TimerTask;

/**
 * An object conforming to TimerTask interface, used to execute a timer task
 */
public class ClockTick extends TimerTask {
    GameController controller;

    ClockTick(GameController c) {
        controller = c;
    }
    
    /**
     * This method is called every time the timer launches, providing the timing pulse
     */
    @Override
    public void run() {
        controller.proceedOneSecond();
    }
}
