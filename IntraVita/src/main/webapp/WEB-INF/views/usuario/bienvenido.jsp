<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1> AQUI ESTA EL INICIO DE NUESTRA RED SOCIAL</h1>
	<p>Datos del usuario conectado:</p>
 		<jsp:useBean id="usuarioConectado" scope="session" class="com.intravita.proyectointranet.modelo.Usuario"></jsp:useBean>
 
 	
 	<p>El nombre es: <jsp:getProperty name="usuarioConectado" property="nombre"/></p>
 	<p>El email es: <jsp:getProperty name="usuarioConectado" property="email"/></p>
	
	
	
	<form action="irCrearPublicacion" method="get">
		<button class="btn btn-info btn-block login" type="submit">Crear Publicación</button>
	</form>
	
	<form action="irVerPublicaciones" method="get">
		<button class="btn btn-info btn-block login" type="submit">Ver Publicaciones</button>
	</form>
	
	<form action="logout" method="GET">
		<button class="btn btn-info btn-block login" type="submit">DESCONEXION</button>
	</form>
</body>
</html>