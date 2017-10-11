Feature: Logeo al sistema


@Scenario1
Scenario: Login exitoso con credenciales validas
	Given Usuario en pagina de login
	When Pone nombre de usuario y password validos
	Then Entrada al sistema

@Scenario2
Scenario: Login fallido por credenciales invalidas
	Given Usuario en pagina de login
	When Pone nombre de usuario y/o password invalidos
	Then Mensaje de error
	
@Scenario3
Scenario: Login fallido por usuario inexistente
	Given Usuario en pagina de login
	When Pone nombre de usuario inexistente
	Then Mensaje de error