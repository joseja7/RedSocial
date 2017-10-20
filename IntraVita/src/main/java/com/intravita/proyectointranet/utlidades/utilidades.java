package com.intravita.proyectointranet.utlidades;

public class utilidades {
	public static String extensionEmail="@alu.uclm.es";
	/**
	 * @method comprobacion de credenciales validas para el registro
	 * @param nombre
	 * @param email
	 * @param pwd1
	 * @param pwd2
	 * @return 
	 * @throws Exception 
	 */
	public static void credencialesValidas(String nombre, String email, String pwd1, String pwd2) throws Exception {
		if(nombre.equals("") ||email.equals("")|| pwd1.equals("")|| pwd2.equals(""))
			throw new Exception ("Por favor rellene todos los campos");
		comprobacionNombre(nombre);

		if(email.length()<=extensionEmail.length())
			throw new Exception("Email invalido");
		String extension=email.substring(email.length()-extensionEmail.length(), email.length());
		
		if(!extension.equals(extensionEmail))
			throw new Exception("Email invalido");
		
		if(!pwd1.equals(pwd2))
			throw new Exception("No coinciden las password");
		seguridadPassword(pwd1);
		
	}
	public static void comprobacionNombre(String nombre) throws Exception{
		if(!nombre.contains("."))
			throw new Exception("Formato nombre invalido");	
		int posicion=nombre.indexOf('.');
		int posicion2=nombre.lastIndexOf('.');
		if(posicion!=posicion2)
			throw new Exception("Formato nombre invalido");
	}
	public static void seguridadPassword(String pwd) throws Exception{
		if(pwd.length()<8)
			throw new Exception("Password poco segura (minimo 8 caracteres, con numeros y letras)");
		boolean caracter=false;
		boolean numero=false;
		char c;
		for(int i=0; i<pwd.length(); i++) {
			c=pwd.charAt(i);
			if(!numero) {
				numero=Character.isDigit(c);
			}
			if(!caracter) {
				caracter=Character.isLetter(c);
			}
		}
		if(!caracter || !numero)
			throw new Exception("Password poco segura (minimo 8 caracteres, con numeros y letras)");
	}
}
