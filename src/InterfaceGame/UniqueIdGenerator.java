package InterfaceGame;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class UniqueIdGenerator {
    private static final AtomicLong counterlong = new AtomicLong(1);
    private static final AtomicInteger counterInt = new AtomicInteger(1);
    
    public static long generateUniqueIdLong() {
        return counterlong.getAndIncrement();
    }
    
    public static int generateUniqueIdInt() {
        return counterInt.getAndIncrement();
    }
    
}