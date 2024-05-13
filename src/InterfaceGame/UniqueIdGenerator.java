package InterfaceGame;
import java.util.concurrent.atomic.AtomicLong;

public class UniqueIdGenerator {
    private static final AtomicLong counter = new AtomicLong(1);

    public static long generateUniqueId() {
        return counter.getAndIncrement();
    }
    
}