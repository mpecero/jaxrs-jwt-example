package es.infointernet.rest.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@ApplicationPath("rest")
public class Application extends ResourceConfig {
    public Application() {
        packages("es.infointernet.rest");
       // register(JacksonJsonProvider.class);  // No need to register this provider if no special configuration is required.
        register(JacksonFeature.class);
    }
}
