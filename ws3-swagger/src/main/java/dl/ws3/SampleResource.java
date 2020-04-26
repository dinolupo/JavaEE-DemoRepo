package dl.ws3;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.json.*;
import javax.ws.rs.Produces;

@Path("/sample")
@Api(value="Sample REST API description")
@Produces("application/json")
public class SampleResource {

    private static int counter = 0;

    @GET
    @Path("/getInfo")
    @ApiOperation(value = "Sample Api Operation Description...",
            notes = "Sample notes that describes the api",
            response = JsonObject.class,
            responseContainer = "List")
    public JsonObject getInfo() {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("counter", counter++);
        return objectBuilder.build();
    }

}

