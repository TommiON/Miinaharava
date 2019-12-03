package model;

import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.SECONDS;

public class Timing {
    private LocalDateTime start;
    
    public Timing() {
        start = LocalDateTime.now();
    }
    
    public long getElapsedTime() {
        LocalDateTime current = LocalDateTime.now();
        return SECONDS.between(start, current);
    }   
}
