<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link REL=StyleSheet HREF="css/login.css" TYPE="text/css" MEDIA=screen>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<h1>
				Bienvenido a IntraVita
			</h1>
		</div>
	</div>
    <form action="login" method="post">
    	<div class="row">
	 		<div class="col-md-8 col-md-offset-2">
	 			<label for="usr">Usuario:</label>
				<input name="txtUsuarioNombre" type="text" class="form-control" id="usr" placeholder="usuario" onFocus="if(this.value!='')this.value=''">
			</div>  
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<label for="pwd">Contraseña:</label>
				<input type="password" name="txtUsuarioClave" class="form-control" id="pwd" placeholder="password">
			</div>	  
		</div>
				<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<button class="btn btn-info btn-block login" type="submit">Login</button>
			</div>	  
		</div>
	</form>	
	<br>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<form action="irRegistrar" method="get"><button class="btn btn-info btn-block login" type="submit">Registrar</button></form>
		</div>
	</div>
	<br>
	
	<%--
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<form action="irRecuperarCredenciales" method="get"><button class="btn btn-info btn-block login" type="submit">¿Olvido su contraseña?</button></form>
		</div>
	</div>
	--%>
	
	<a href="#" onclick="enviar()">¿Olvido su contraseña?</a>

	<script language="JavaScript" type="text/javascript">
		alert("${alerta}");
	</script>

</div>




</body>
</html>