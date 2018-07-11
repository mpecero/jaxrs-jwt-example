# jaxrs-jwt-example
Proyecto de ejemplo con un servicio REST hecho con JAX-RS y securizado con tokens JWT. En concreto se ha utilizado Jersey y JJWT respectivamente. También incluye autorización por roles.  

Más información del proyecto en: http://www.infointernet.es/internet-avanzado/java/securizar-servicios-rest-java-jax-rs-jwt/

# Cómo compilar
Para compilar y generar el war es necesario tener Maven instalado y ejecutar en el directorio donde tengamos el proyecto:  

$ mvn clean install  

Una vez terminada la construcción, el artefacto puede encontrarse en el directorio "target".

# Cómo desplegarlo

Copia el artefacto (DemoWeb.war) a la carpeta de despliegue de tu servidor, por ejemplo Tomcat.

# Cómo probarlo

Recomendamos el uso de alguna aplicación como la extensión Postman de Chrome (https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop)

* URL para obtener el token JWT: http://localhost:8080/DemoWeb/rest/usuario/login?user=test&password=test  
  Usuario normal: test / test  
  Usuario con rol administrador: admin / admin  
  El token viene de vuelta en la cabecera Authorization de la respuesta.  

* Invocar la API (usuario normal): (GET) http://localhost:8080/DemoWeb/rest/pelicula/1
* Invocar la API (usuario administrador): (PUT) http://localhost:8080/DemoWeb/rest/pelicula/

El token debe ir en la cabecera Authorization de la petición a la API.
