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
    MutableConfiguration<String, String> config = new MutableConfiguration<>();

    var manager = Caching.getCachingProvider().getCacheManager();
    Cache<String, String> cache = manager.createCache("namedCache", config);

    var t = LocalTime.now();

    var now = "" + System.currentTimeMillis();

    cache.put("now", now);
    System.out.println("now: " + System.currentTimeMillis() + " then: " + cache.get("now"));
    return;
  }
  
  public static void main( String[] args ) {
    new App().redisson();
    System.exit(0);
  }
}
