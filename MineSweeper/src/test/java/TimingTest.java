import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.util.TimerTask;
import model.Timing;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimingTest {
    Timing timing;
    
    @Test
    public void measuresTimeCorrectly() {
        timing = new Timing();
        
        LocalDateTime testTimingStart = LocalDateTime.now();
        for(int i = 0; i < 1000000; i++) {
            // waste some time
        }
        LocalDateTime testTimingEnd = LocalDateTime.now();
        
        long actualTime = timing.getElapsedTime();
        long testTime = SECONDS.between(testTimingStart, testTimingEnd);
        
        assertEquals(testTime, actualTime);
    }
}
