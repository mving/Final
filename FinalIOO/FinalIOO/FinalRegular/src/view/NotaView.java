package view;

public class NotaView {
	
	public NotaView() {}
	
	public NotaView(String nombreMateria, String codMateria, String tipoExamen, String nota) {
		this.nombreMateria = nombreMateria;
		this.codMateria = codMateria;
		this.tipoExamen = tipoExamen;
		this.nota = nota;
	}
	
	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public String getCodMateria() {
		return codMateria;
	}

	public void setCodMateria(String codMateria) {
		this.codMateria = codMateria;
	}

	public String getTipoExamen() {
		return tipoExamen;
	}

	public void setTipoExamen(String tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	private String nombreMateria;
	private String codMateria;
	private String tipoExamen;
	private String nota;
	
	public String toString() { //Define como se va a ver en la interfaz
		return (codMateria+" - "+nombreMateria+" - "+tipoExamen+" - Nota: "+nota);
	}

}
