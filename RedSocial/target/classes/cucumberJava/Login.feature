Feature: Logeo al sistema


@Scenario1
Scenario: Login exitoso con credenciales validas
	Given Usuario en pagina de "login"
	When Pone nombre de "usuario" y "password" validos
	Then llegamos a la pagina inicial y un "mensaje" de bienvenida

@Scenario2
Scenario: Login fallido por credenciales invalidas
	Given Usuario en pagina de "login"
	When Pone nombre de "usuario" y/o "password" invalidos
	Then Mensaje de "error"
	