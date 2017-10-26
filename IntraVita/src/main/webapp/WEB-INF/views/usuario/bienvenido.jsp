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
	<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
 	<jsp:useBean id="usuarioConectado" scope="session" class="com.intravita.proyectointranet.modelo.Usuario"></jsp:useBean>
 
 	<!--  
	 	<p>El nombre es: <jsp:getProperty name="usuarioConectado" property="nombre"/></p>
	 	<p>El email es: <jsp:getProperty name="usuarioConectado" property="email"/></p>
	-->
	<div class="row bg-primary">
		<div class="col-md-5 col-md-offset-1">
			<h1>
				<img src="https://www.google.es/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=0ahUKEwjsmL-WgYzXAhVC1xoKHVCBC-0QjBwIBA&url=https%3A%2F%2F0.gravatar.com%2Favatar%2F39ed65b29c37c5cf7f2861748f886a32%3Fs%3D128%26d%3Didenticon%26r%3DG&psig=AOvVaw2dTI6apPP8UfUsnp855VCZ&ust=1509028967551401" width="64px" height="64px" class="img-circle"> INTRAVITA
			</h1>
		</div>
		
		<div class="col-md-2 col-md-offset-4">
				<button type="button" class="btn btn-primary btn-md"  style="border-width: 10px;">?</button>
		</div>
	</div>
	
	
	<div class="row">
		<div class="col-md-5 col-md-offset-1">
			<h3>
				<jsp:getProperty name="usuarioConectado" property="nombre"/>
			</h3>
		</div>

		<br/>

		<div class="col-md-1 col-md-offset-4">
			<form action="logout" method="GET">
				<button class="btn btn-danger btn-block btn-md login" type="submit">Desconexion</button>
			</form>	
			<br/>
			<form action="" method="GET">
				<button class="btn btn-primary btn-block btn-md login" type="submit">Cambiar Rol</button>
			</form>					
		</div>
	</div>
	
	
	 <form action="crearPublicacion" method="post" id="formlogin">
    	<div class="row">
	 		<div class="col-md-8 col-md-offset-2">
			  <label for="comment">Realizar publicación</label>
			  <textarea name="txtIntroducirTexto" placeholder="¿Qué tal el día?" class="form-control" rows="5" id="comment"></textarea>
			</div>  
		</div>
		
		<br/>
		
		<div class="row">
			<div class="col-md-2 col-md-offset-8">
				<button class="btn btn-primary btn-block login" formaction="crearPublicacionPrivada" type="submit">Guardar en borradores</button>
				<button class="btn btn-primary btn-block login" type="submit">Enviar</button>
			</div>	  
		</div>
	</form>
	
	<br/>
	
	<form action="listarPublicacion" method="post">
		<button class="btn btn-info btn-block login" type="submit" style="background-color:yellow;">Mostrar Publicaciones</button>
	</form>
	<div class="row">
		${publicaciones}
	</div>
	
	<div class="row">
		<h1> Esto es para el copiright</h1>
	</div>
	

</body>
</html>