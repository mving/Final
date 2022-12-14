package view;

public class AlumnoView {
	
	public AlumnoView() {}
	
	public AlumnoView(int legajo, String nombre) {
		this.legajo = legajo;
		this.nombre = nombre;
	}
	
	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private int legajo;
	private String nombre;
	
	public String toString() {	//Define como se va a ver en la interfaz
		return (String.valueOf(legajo)+" - "+nombre);
	}

}
