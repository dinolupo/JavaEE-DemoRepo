package ws2

import dl.cache._
import javax.json.{Json, JsonObject}
import javax.ws.rs.core.{MediaType, Response}
import javax.ws.rs.{GET, PUT, Path, PathParam}

@Path("cache")
class CacheResource {

  def getCacheJSon(): JsonObject = {
    val resBuilder = Json.createObjectBuilder
    Cache.cache.foreach(a => {
      resBuilder.add(a._1, a._2)
    })
    resBuilder.build()
  }

  @GET
  @Path("/")
  def show():Response = {
    System.out.println("WS2 =====> show called")
    Response.ok(getCacheJSon(),MediaType.APPLICATION_JSON).build()
  }

  @PUT
  @Path("/{key}")
  def put(@PathParam("key") key:String) = {
    System.out.printf("WS2 =====> adding %s\n", key)
    Cache.cache.put(key, key)
    Response.ok(getCacheJSon(), MediaType.APPLICATION_JSON).build()
  }

}
