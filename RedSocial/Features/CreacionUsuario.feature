

Feature: Creacion de un nuevo usuario

@Scenario1
Scenario: Creacion correcta de cuenta
	Given Usuario en pagina de "creacion"
	When "Nombre" correcto
		And "email" correcto
		And "password" y "passwordConf" coinciden
	Then Mensaje de "validacion" 
		And insertar usuario en base de datos
	

@Scenario2
Scenario: Creacion incorrecta de cuenta
	Given Usuario en pagina de "creacion"
	When "password" y "passwordConf" no coinciden
	Then Mensaje de "error"