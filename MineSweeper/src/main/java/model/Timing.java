/**
 * provides functionality for timing the game
 */

package model;

import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.SECONDS;

public class Timing {
    private LocalDateTime start;
    
    /**
     * constructor, starts measuring a new timespan
     */
    public Timing() {
        start = LocalDateTime.now();
    }
    
    /**
     * returns elapsed time
     */
    public long getElapsedTime() {
        LocalDateTime current = LocalDateTime.now();
        return SECONDS.between(start, current);
    }   
}
