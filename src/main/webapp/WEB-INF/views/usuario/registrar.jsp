<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  <% // inicio  %>
<html>


<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registro</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> <% // bien  %>

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> <% // perfecto  %>
		
		
</head>

<body style="background-color: #2CC8E7;">

<style>
.boton {
  padding: 15px 35px;
  font-size: 18px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #166EE7;
  border: none;
  border-radius: 10px;
  box-shadow: 0 3px #999;
}

.boton:hover {background-color: #21DD27}

.b:active {
  background-color: #21DD27;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

spam {
    padding: 20px;
    color: #3629D3;
    margin-left: 12px;
	font-weight: bold;
	font-size: 20px;
}

</style>





	<div class="row bg-primary">
		<div class="col-md-5 col-md-offset-1">
			<strong></strong><h1 style="color: white; font-family: Verdana; font-size:60px;"><em><strong>  
				<img src="http://www.emprender-facil.com/wp-content/uploads/2014/09/La-red-social-LinkedIn-para-tu-negocio-texto1.png" style="width:64px; height:64px;" class="img-circle";> 
				IntraVita
			</strong></em></h1></strong>
		</div>
		
		<div class="col-md-2 col-md-offset-4">
				<button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#miModal" style="border-width: 10px;"><strong>?</strong></button>
		</div>
	</div>
	
	<div class="modal fade" id="miModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Ayuda</h4>
					</div>
					<div class="modal-body">
						Ayuda de la p�gina de registro
					</div>
				</div>
			</div>
		</div>

	<div class="row">
		<div class="col-md-1 col-md-offset-10">
			<br>
			<form action="irLogin" method="GET">
				<button class="btn btn-danger btn-block btn-md login" type="submit">Volver</button> <% // bien  %>
			</form>	
					
		<br/>
		</div>
	</div>


	<form action="registrar" method="POST"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<label for="usr" style="color:white; font-size:15px;">Usuario:</label>
				<input type="text" class="form-control" id="usr" name="txtUsuarioNombre" placeholder="usuario" onFocus="if(this.value!='')this.value=''"/>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<label for="email" style="color:white; font-size:15px">Email:</label>
				<input type="text" class="form-control" id="email" name="txtEmail" placeholder="@alu.uclm.es""/>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<label for="pwd" style="color:white; font-size:15px">Contrase�a:</label>
		  		<input type="password" class="form-control" id="pwd" name="txtUsuarioClave" placeholder="password">
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
			  	<label for="pwd1" style="color:white; font-size:15px">Confirmar Contrase�a:</label> <% // bien  %>
			  	<input type="password" class="form-control" id="pwd1" name="txtUsuarioClave1" placeholder="confirmacion password">	
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<label for="usr" style="color:white; font-size:15px">�Cual es tu mejor amigo/a de la infancia?</label>
				<input name="txtRespuesta" type="text" class="form-control" id="usr" placeholder="respuesta" onFocus="if(this.value!='')this.value=''">
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
			<label for="imagen" style="color:white; font-size:15px">Avatar:</label>
			<label class="control-label" style="color:white; font-size:15px">Select File</label>
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
			<div class="col-md-2 col-md-offset-5">
				<button type="submit" class="boton btn-info btn-block" value="Registrar">Registrar</button>	
			</div>
		</div>		
	</form>

	<br>
	
	<div class="row">
		<div class="col-md-12">
			<t><spam><em>${alerta}</em></spam></t>
		</div>
	</div>

	
	<div class="panel-footer">
		<h5>� Copyright 2017 IntraVita. Todos los derechos reservados.</h5> <% // fin  %>
	</div>


</body>

</html>