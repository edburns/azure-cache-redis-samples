package example.demo;

import javax.cache.*;
import javax.cache.configuration.*;

import java.time.LocalTime;

/**
 * Redis test
 *
 */
public class App 
{

  public void redisson() {
    var now = LocalTime.now();
    var manager = Caching.getCachingProvider().getCacheManager();
    Cache<String, LocalTime> cache =
      manager.createCache("namedCache", new MutableConfiguration()
                          .setStoreByValue(true)
                          .setTypes(String.class, LocalTime.class));
    
    cache.put("then", now);
    System.out.println("That was then: " + cache.get("then") +
                       ", this is now: " + LocalTime.now() + ".");
    cache.close();
    return;
  }
  
  public static void main( String[] args ) {
    new App().redisson();
    System.exit(0);
  }
}
