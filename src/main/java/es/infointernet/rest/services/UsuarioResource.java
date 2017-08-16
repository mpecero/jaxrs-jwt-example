package es.infointernet.rest.services;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.naming.AuthenticationException;
import javax.ws.rs.GET;
import javax.ws.rs.NotAllowedException;
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
 
            // Aquí iría el código de validación del usuario y contraseñas,
        	// por ejemplo validándolo contra una base de datos...
            String roles = authenticate(user, password);
        	
            // Si todo es correcto, generamos el token
            String token = issueToken(user, roles);
 
            // Devolvemos el token en la cabecera "Authorization". 
            // Se podría devolver también en la respuesta directamente.
            return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
 
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
 
    private String issueToken(String login, String roles) {
    	//Calculamos la fecha de expiración del token
    	Date issueDate = new Date();
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(issueDate);
    	calendar.add(Calendar.MINUTE, 60);
        Date expireDate = calendar.getTime();
        
		//Creamos el token
        String jwtToken = Jwts.builder()
        		.claim("roles", roles)
                .setSubject(login)
                .setIssuer("http://www.infointernet.es")
                .setIssuedAt(issueDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, RestSecurityFilter.KEY)
                .compact();
        return jwtToken;
    }
    
    private String authenticate(String user, String password) throws AuthenticationException{
    	//Tenemos dos usuarios: 
    	//test -> rol de usuario
    	//admin -> rol de administrador
    	if("test".equals(user) && "test".equals(password)) {
    		return "USUARIO";
    	} else if("admin".equals(user) && "admin".equals(password)) {
    		return "ADMINISTRADOR";
    	} else {
    		throw new AuthenticationException();
    	}
    
    }
    
}
