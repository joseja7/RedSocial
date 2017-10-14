

Feature: Creacion de un nuevo usuario

@Scenario1
Scenario: Creacion correcta de cuenta
	Given Usuario en pagina de creacion
	When "Nombre" correcto
		And "password" y "passwordConf" coinciden
	Then Mensaje de validacion y usuario insertado
	

@Scenario2
Scenario: Creacion incorrecta de cuenta
	Given Usuario en pagina de creacion
	When "password" y "passwordConf" no coinciden
	Then Mensaje de error2