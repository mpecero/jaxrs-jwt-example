package es.infointernet.rest.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("rest")
public class Application extends ResourceConfig {
    public Application() {
        packages("es.infointernet.rest");
        register(JacksonFeature.class);
        register(RolesAllowedDynamicFeature.class);
    }
}
