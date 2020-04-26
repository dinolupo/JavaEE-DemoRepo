package dl.cache

import org.scalatest._

class CacheSpec extends FlatSpec {

  "cache" should "contain default config" in {
    assert(Cache.cache.contains("default"))
  }

  "cache" should "insert value" in {
    Cache.cache.put("a", "b")
    assert(Cache.cache.contains("a"))
  }

}
