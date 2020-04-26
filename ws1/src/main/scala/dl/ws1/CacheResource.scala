package dl.ws1

import javax.ws.rs.{GET, PUT, Path, PathParam}
import dl.cache._
import javax.json.{Json, JsonObject, JsonObjectBuilder}
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

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
    System.out.println("WS1 =====> show called")
    Response.ok(getCacheJSon(),MediaType.APPLICATION_JSON).build()
  }

  @PUT
  @Path("/{key}")
  def put(@PathParam("key") key:String) = {
    System.out.printf("WS1 =====> adding %s\n", key)
    Cache.cache.put(key, key)
    Response.ok(getCacheJSon(), MediaType.APPLICATION_JSON).build()
  }

}
