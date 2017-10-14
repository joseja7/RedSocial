<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Esto es la pantalla REGISTRAT</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">

	
	<form action="bienvenido" method="get"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<!--<form action="anadir.do" method="post"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--> 
	
		<div class="row">
			<label for="usr">Usuario:</label>
			<input type="text" class="form-control" id="usr" name="txtUssuarioNombre" onFocus="if(this.value!='')this.value=''"/>
		</div>
		<div class="form-group">
		  	<label for="pwd">Contraseña:</label>
		  	<input type="password" class="form-control" id="pwd" name="txtUsuarioClave">
		</div>
		<div class="form-group">
		  	<label for="pwd1">Confirmar Contraseña:</label>
		  	<input type="password" class="form-control" id="pwd1" name="txtUsuarioClave1">
		</div>		
		<div class="row">
			<button type="submit" class="btn btn-primary btn-md" value="Registrar">Registrar</button>	
		</div>
	</form>
	</div>

</body>



</html>