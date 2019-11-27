package model;

import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.SECONDS;

public class Timer {
    private LocalDateTime start;
    
    public Timer() {
        start = LocalDateTime.now();
    }
    
    public long getElapsedTime() {
        LocalDateTime current = LocalDateTime.now();
        return SECONDS.between(start, current);
    }   
}
