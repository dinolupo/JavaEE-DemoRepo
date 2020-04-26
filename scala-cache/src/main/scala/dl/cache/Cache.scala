package dl.cache

import scala.collection.mutable

/**
 * Simple Scala cache example to be used by ws1 and ws2 to demonstrate the ClassLoading
 * isolation of the Application Servers (e.g.: Wildfly)
 */
object Cache {
  val cache:mutable.HashMap[String,String] = mutable.HashMap("default" -> "default config")
}

