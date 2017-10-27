<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recuperar Credenciales</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link REL=StyleSheet HREF="css/login.css" TYPE="text/css" MEDIA=screen>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>

	<div class="row bg-primary">
		<div class="col-md-5 col-md-offset-1">
			<h1 style="color: white; font-family: Verdana; font-size:40px;">
				<img src="https://www.google.es/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=0ahUKEwjsmL-WgYzXAhVC1xoKHVCBC-0QjBwIBA&url=https%3A%2F%2F0.gravatar.com%2Favatar%2F39ed65b29c37c5cf7f2861748f886a32%3Fs%3D128%26d%3Didenticon%26r%3DG&psig=AOvVaw2dTI6apPP8UfUsnp855VCZ&ust=1509028967551401" width="64px" height="64px" class="img-circle"> INTRAVITA
			</h1>
		</div>
		
		<div class="col-md-2 col-md-offset-4">
				<button type="button" class="btn btn-primary btn-md"  style="border-width: 10px;">?</button>
		</div>
	</div>
	

	<div class="row">
		<div class="col-md-1 col-md-offset-10">
			<br>
			<form action="irBienvenido" method="GET">
				<button class="btn btn-danger btn-block btn-md login" type="submit">Volver</button>
			</form>	
					
		<br/>
		</div>
	</div>

	<form action="borrarCuenta" method="post">
		<div class="row">
		 	<div class="col-md-8 col-md-offset-2">
		 		<label for="usr">Password:</label>
				<input name="txtUsuarioPwd" type="password" class="form-control" id="usr" placeholder="password">
				<br>
			</div>  
		</div>
		
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<label for="usr">¿Cual es tu mejor amigo/a de la infancia?</label>
				<input name="txtRespuesta" type="text" class="form-control" id="usr" placeholder="respuesta">
				<br>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-1 col-md-offset-9">
				<button class="btn btn-info btn-block" type="submit" value="borrar">Borrar</button>
			</div>	  
		</div>
	<br>
	</form>
	
	<div class="panel-footer">
		<h5>© Copyright 2017 IntraVita. Todos los derechos reservados.</h5>
	</div>
	
</body>
</html>