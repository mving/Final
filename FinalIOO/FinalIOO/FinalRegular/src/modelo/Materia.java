package modelo;

public class Materia {

	private String codMateria;
	private String descripcion;
	private boolean habilitada;
	
	public Materia(String codMateria, String descripcion) {
		this.codMateria = codMateria;
		this.descripcion = descripcion;
		this.habilitada = true;
	}

	public String getCodMateria() {
		return codMateria;
	}

	public void setCodMateria(String codMateria) {
		this.codMateria = codMateria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}

	public boolean soyLaMateria(String codigo) {
		return this.codMateria == codigo;
	}
}
