<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Bienvenido/a</title>
</head>
<body>
<h1>
	BIENVENIDO A NUESTRA RED SOCIAL  
</h1>

<P> La hora del servidor es: ${serverTime}. </P>

<div class="container">

	<form action="irLogin" method="get"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<!--<form action="anadir.do" method="post"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--> 
		<div class="row">
			<button type="submit" class="btn btn-primary btn-md" value="Entrar">Entrar</button>	
		</div>
	</form>
	
	<form action="irRegistrar" method="get"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<!--<form action="anadir.do" method="post"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--> 
		<div class="row">
			<button type="submit" class="btn btn-primary btn-md" value="Registrar">Registrar</button>	
		</div>
	</form>
</div>

</body>
</html>