
Feature: Usuario quiere desconectarse

@Scenario1
Scenario: Desconexion exitosa
	Given Usuario en pagina de "home"
	When Usuario selecciona "desconectar"
	Then Mensaje de "exito"
		And Envio a la pagina de "inicio"
	
