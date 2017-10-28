<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel administrador</title>
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
				<strong></strong><h1 style="color: white; font-family: Verdana; font-size:60px;"><em><strong>  <img src="http://www.emprender-facil.com/wp-content/uploads/2014/09/La-red-social-LinkedIn-para-tu-negocio-texto1.png" style="width:64px; height:64px;" class="img-circle"> IntraVita</strong></em></h1></strong>
			</div>
			
			<div class="col-md-2 col-md-offset-4">
					<button type="button" class="btn btn-primary btn-md"  style="border-width: 10px;">?</button>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-5 col-md-offset-1">
				<h3>
					nombre administrador
				</h3>
			</div>
			<div class="col-md-1 col-md-offset-4">
				<br>
				<form action="logout" method="GET">
					<button class="btn btn-danger btn-block btn-md login" type="submit">Salir</button>
				</form>	
				
				<br/>
				
				<button class="btn btn-primary btn-block btn-md login" type="submit">Cambiar Rol</button>
			</div>
		</div>


	
	<form action="promover" method="post">
	   <div class="row">
	 		<div class="col-md-10 col-md-offset-1 ">
	 			<label for="usr">Usuario:</label>
				<input name="txtNombre" type="text" class="form-control" id="usr" placeholder="usuario">
				<br>
			</div>  
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-2">
				<button class="btn btn-success btn-block login" type="submit">Promover</button>
			</div>	  

			<div class="col-md-2 col-md-offset-1">
				<button class="btn btn-danger btn-block login" name="degradar" type="submit" formaction="degradar">Degradar</button>
			</div>	  

			<div class="col-md-2 col-md-offset-1">
				<button class="btn btn-danger btn-block login" type="submit" formaction="borrar">Borrar</button>
			</div>	  
		</div>
	</form>	
	<br>
	<div class="row">
		<div class="col-md-12">
			<t><h2><b>${alerta}</b></h2></t>
		</div>
	</div>
	<br>
    <form action="listarUsuario" method="post">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-body">
						<button class="btn btn-info btn-block login" type="submit">Actualizar Lista</button>
						
						<div class="row">
							<div class="col-md-6">
								<div class="col-md-12">
									<div class="panel panel-default">
										<div class="panel-body">
											<h3>Usuarios</h3>
											${usuarios}
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="col-md-12">
									<div class="panel panel-default">
										<div class="panel-body">
											<h3>Administradores</h3>
											${administradores}
										</div>
									</div>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>	  
		</div>
	</form>
	
	
	<div class="panel-footer">
		<h5>© Copyright 2017 IntraVita. Todos los derechos reservados.</h5>
	</div>
	
</body>
</html>