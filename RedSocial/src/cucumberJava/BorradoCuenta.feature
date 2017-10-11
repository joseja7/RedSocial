
Feature: Usuario quiere borrar su cuenta

@Scenario1
Scenario: Borrado exitoso de cuenta
	Given Usuario en pagina de borrado
	When Password1 y Password2 coinciden
	Then Mensaje de exito
		And Envio a la pagina de inicio
		And Delete usuario de la base de datos
	
@Scenario2
Scenario: Borrado fallido de cuenta
	Given Usuario en pagina de borrado
	When Password1 y Password2 no coinciden
	Then Mensaje de error