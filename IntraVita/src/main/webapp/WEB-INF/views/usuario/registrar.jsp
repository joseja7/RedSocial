<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Esto es la pantalla REGISTRAR</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		
</head>

<body>
<div class="container">
	<div class="row">
	</div>
	<form action="registrar" method="POST"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<label for="usr">Usuario:</label>
				<input type="text" class="form-control" id="usr" name="txtUsuarioNombre" placeholder="usuario" onFocus="if(this.value!='')this.value=''"/>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<label for="email">Email:</label>
				<input type="text" class="form-control" id="email" name="txtEmail" placeholder="@alu.uclm.es""/>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<label for="pwd">Contraseña:</label>
		  		<input type="password" class="form-control" id="pwd" name="txtUsuarioClave" placeholder="password">
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
			  	<label for="pwd1">Confirmar Contraseña:</label>
			  	<input type="password" class="form-control" id="pwd1" name="txtUsuarioClave1" placeholder="confirmacion password">	
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
			<label for="imagen">Avatar:</label>
			<label class="control-label">Select File</label>
			<input id="input-b5" name="input-b5[]" type="file" multiple>
			
			<script>
				$(document).on('ready', function() {
				    $("#input-b5").fileinput({showCaption: false});
				});
			</script>
			
			<br>
			<img src="input-b5" width="128px" height="128px" class="img-circle">
			</div>
		</div>
		
		<br>
		<br>
		
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<button type="submit" class="btn btn-info btn-block" value="Registrar">Registrar</button>	
			</div>
		</div>		
	</form>

	<br>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<form action="irLogin" method="get"><button class="btn btn-info btn-block login" type="submit">Login</button></form>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<t><h2><b>${alerta}</b></h2></t>
		</div>
	</div>
	
	
	
</div>

</body>



</html>