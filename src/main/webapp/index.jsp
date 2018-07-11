<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
</head>
<body>
<h1>Ejemplo de servicios REST con JAX-RS protegidos con token JWT</h1>
<h2>Cómo probar la aplicación</h2>
Recomendamos el uso de alguna aplicación como la extensión Postman de Chrome (https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop)
<ul>
<li>
URL para obtener el token JWT: <a href="http://localhost:8080/DemoWeb/rest/usuario/login?user=test&password=test">http://localhost:8080/DemoWeb/rest/usuario/login?user=test&password=test</a> <br/>
Usuario normal: test / test<br/>
Usuario con rol administrador: admin / admin<br/>
El token viene de vuelta en la cabecera Authorization de la respuesta.
</li>
<li>
Invocar la API (usuario normal): (GET) <a hrel="http://localhost:8080/DemoWeb/rest/pelicula/1">http://localhost:8080/DemoWeb/rest/pelicula/1</a>
</li>
<li>
Invocar la API (usuario administrador): (PUT) http://localhost:8080/DemoWeb/rest/pelicula/
</li>
</ul>
El token debe ir en la cabecera Authorization de la petición a la API.
</body>
</html>