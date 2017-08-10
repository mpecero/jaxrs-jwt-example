package es.infointernet.rest.services;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import es.infointernet.rest.filter.RestSecurityFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Path("/usuario")
public class UsuarioResource {
 
    @GET
    @Path("/login")
    public Response authenticateUser(@QueryParam("user") String user,
    		@QueryParam("password") String password) {
        try {
 
            // Aquí iría el código de validación del usuario y contraseñas proporcionados,
        	// por ejemplo validándolo contra una base de datos...
            //authenticate(user, password);
        	
            // Si todo es correcto, generamos el token
            String token = issueToken(user);
 
            // Devolvemos el token en la cabecera "Authorization". 
            // Se podría devolver también en la respuesta directamente.
            return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
 
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
 
    private String issueToken(String login) {
    	//Calculamos la fecha de expiración del token
    	Date issueDate = new Date();
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(issueDate);
    	calendar.add(Calendar.MINUTE, 60);
        Date expireDate = calendar.getTime();
        
		//Creamos el token
        String jwtToken = Jwts.builder()
        		.claim("rol", "a,b,c")
                .setSubject(login)
                .setIssuer("http://www.infointernet.es")
                .setIssuedAt(issueDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, RestSecurityFilter.KEY)
                .compact();
        return jwtToken;
    }
}
