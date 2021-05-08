package example.demo;

import javax.cache.*;
import javax.cache.configuration.*;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.SECONDS;
import static java.lang.System.*;    

/**
 * Redis test
 *
 */
public class App 
{

  public void redisson(boolean removeFirst) {
    var manager = Caching.getCachingProvider().getCacheManager();
    Cache<String, LocalTime> cache =
      manager.createCache("namedCache", new MutableConfiguration()
                          .setStoreByValue(true)
                          .setTypes(String.class, LocalTime.class));

    if (removeFirst) {
      cache.remove("then");
    }
    cache.putIfAbsent("then", LocalTime.now());
    var now = LocalTime.now();
    out.printf("That was then: %s, this is now: %s.\n", cache.get("then"), now);
    out.printf("Elapsed time: %s seconds.\n",
               SECONDS.between(cache.get("then"), now));
    cache.close();
    return;
  }
  
  public static void main( String[] args ) {
    new App().redisson(args.length > 0);
    System.exit(0);
  }
}
