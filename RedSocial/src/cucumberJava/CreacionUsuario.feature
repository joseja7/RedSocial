

Feature: Creacion de un nuevo usuario

@Scenario1
Scenario: Creacion correcta de cuenta
	Given Usuario en pagina de creacion
	When Nombre correcto
		And email correcto
		And ambas password coinciden
	Then Mensaje de validacion 
		And insertar usuario en base de datos
	

@Scenario2
Scenario: Creacion incorrecta de cuenta
	Given Usuario en pagina de creacion
	When Password1 y Password2 no coinciden
	Then Mensaje de error