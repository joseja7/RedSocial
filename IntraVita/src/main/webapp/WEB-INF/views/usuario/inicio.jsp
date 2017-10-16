<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>


	<script src = " https://code.jquery.com/jquery.js "></script>
	<script src =
" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
	</script>
	<link rel = "stylesheet" href =
" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
	<title>Bienvenido/a</title>
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-4">
			<h1>
				<span class="glyphicon glyphicon-user"></span>BIENVENIDO
			</h1>	
		</div>
	
	</div>
	
	<div class="row">
		<P> La hora del servidor es: ${serverTime}. </P>
	</div>

	<div class="row">
		<div class="col-md-2">
		<form action="irLogin" method="get"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<!--<form action="anadir.do" method="post"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--> 
		
				<button type="submit" class="btn btn-info btn-block" value="Entrar">Entrar</button>	
		
		</form>
		</div>
		<div class="col-md-2">
		<form action="irRegistrar" method="get"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<!--<form action="anadir.do" method="post"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--> 
		
				<button type="submit" class="btn btn-info btn-block" value="Registrar">Registrar</button>	
		
		</form>
		</div>
	</div>
	
</div>

</body>
</html>