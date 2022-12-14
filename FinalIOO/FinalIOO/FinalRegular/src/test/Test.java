package test;

import controlador.Controlador;
import gui.Ventana;

public class Test {

	public static void main(String[] args) {
		Controlador.getinstancia().pruebaCargaDatos();	//genera una carga de datos inicial para probar la interfaz
		new Ventana();

	}

}
