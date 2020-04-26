package dl.ws3;

import javax.ws.rs.core.Application;
import io.swagger.jaxrs.config.BeanConfig;
import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("resources")
public class SwaggerApplication extends Application {

    public SwaggerApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/ws3/resources");
        beanConfig.setResourcePackage(SampleResource.class.getPackage().getName());
        beanConfig.setTitle("NExT, Swagger API");
        beanConfig.setScan(true);
    }

}
