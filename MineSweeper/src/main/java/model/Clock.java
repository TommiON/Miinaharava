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
     * calculates and returns elapsed time at the moment of calling
     * @return elapsed time as a Long value
     */
    public long getElapsedTime() {
        LocalDateTime current = LocalDateTime.now();
        return SECONDS.between(start, current);
    }   
}
