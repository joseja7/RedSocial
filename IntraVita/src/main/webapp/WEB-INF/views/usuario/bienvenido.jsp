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
 	<jsp:useBean id="usuarioConectado" scope="session" class="com.intravita.proyectointranet.modelo.Usuario"></jsp:useBean>
 
 	<!--  
	 	<p>El nombre es: <jsp:getProperty name="usuarioConectado" property="nombre"/></p>
	 	<p>El email es: <jsp:getProperty name="usuarioConectado" property="email"/></p>
	-->
	<div class="row">
		<div class="col-md-5 col-md-offset-1">
			<h1>
				Bienvenido <jsp:getProperty name="usuarioConectado" property="nombre"/>
			</h1>
		</div>
		<div class="col-md-4 col-md-offset-2">
			<form action="" method="GET">
				<button class="btn btn-primary btn-block login" type="submit">Cambiar Rol</button>
			</form>				
			<form action="logout" method="GET">
				<button class="btn btn-danger btn-block login" type="submit">Desconexion</button>
			</form>		
		</div>
	</div>
	
	 <form action="crearPublicacion" method="post" id="formlogin">
    	<div class="row">
	 		<div class="col-md-8 col-md-offset-2">
			  <label for="comment">Mensaje:</label>
			  <textarea name="txtIntroducirTexto" placeholder="¿Qué tal el día?" class="form-control" rows="5" id="comment"></textarea>
			</div>  
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<button class="btn btn-info btn-block login" type="submit">Enviar</button>
			</div>	  
		</div>
	</form>
	
	<form action="listarPublicacion" method="post">
		<button class="btn btn-info btn-block login" type="submit">Ver Publicaciones</button>
	</form>
	<div class="col-md-8 col-md-offset-2">
		${publicaciones}
	</div>

</body>
</html>