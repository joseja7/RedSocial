
Feature: Usuario quiere borrar su cuenta

@Scenario1
Scenario: Borrado exitoso de cuenta
	Given Usuario en pagina de borrado
	When "password" y "passwordConf" coinciden y son validos
	Then Mensaje de exito y delete del usuario
	
@Scenario2
Scenario: Borrado fallido de cuenta
	Given Usuario en pagina de 
	When "password" y "passwordConf" no coinciden o son invalidos
	Then Mensaje de error y cancelacion del borrado