package example.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

import javax.cache.*;
import javax.cache.configuration.*;

/**
 * Redis test
 *
 */
public class App 
{

  public void redisson() {
    MutableConfiguration<String, String> config = new MutableConfiguration<>();

    System.out.println("debug: edburns: obtaining reference to cache");
    CacheManager manager = Caching.getCachingProvider().getCacheManager();
    Cache<String, String> cache = manager.createCache("namedCache", config);

    String now = "" + System.currentTimeMillis();
    System.out.println("debug: edburns: storing value in cache: now: " + now);

    cache.put("now", now);
    System.out.println("debug: edburns: retrieving value from cache");
    System.out.println("now: " + System.currentTimeMillis() + " then: " + cache.get("now"));
    return;
  }
  
  public static void main( String[] args ) {
    App app = new App();
    app.redisson();
    System.exit(0);
  }
}
