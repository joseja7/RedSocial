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
	<form action="borrarCuenta" method="post">
	 	<div class="col-md-8 col-md-offset-2">
	 		<label for="usr">Password:</label>
			<input name="txtUsuarioPwd" type="password" class="form-control" id="usr" placeholder="password">
		</div>  
		
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<label for="usr">¿Cual es tu mejor amigo/a de la infancia?</label>
				<input name="txtRespuesta" type="text" class="form-control" id="usr" placeholder="respuesta">
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<button class="btn btn-info btn-block" type="submit" value="borrar">Borrar cuenta</button>
			</div>	  
		</div>
	<br>
	</form>
	<script language="JavaScript" type="text/javascript">
		alert("${alerta}");
	</script>
	
</body>
</html>