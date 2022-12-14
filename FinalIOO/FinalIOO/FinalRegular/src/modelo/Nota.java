package modelo;

import view.NotaView;

public class Nota {
	
	private static int generador;
	private int itemNota;
	private Alumno alumno;
	private Curso curso;
	private String tipoExamen;
	private boolean asistencia;
	private String nota;
	
	public Nota(Alumno alumno, Curso curso, String tipoExamen, boolean asistencia, String nota) {
		Nota.generador++;
		this.itemNota = Nota.generador;
		this.alumno = alumno;
		this.curso = curso;
		this.tipoExamen = tipoExamen;
		this.asistencia = asistencia;
		this.nota = nota;
	}

	public int getItemNota() {
		return itemNota;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public Curso getCurso() {
		return curso;
	}
	public String getTipoExamen() {
		return tipoExamen;
	}
	public boolean getAsistencia() {
		return asistencia;
	}
	public String getNota() {
		return nota;
	}
	public boolean esFinal() {
		return this.asistencia && this.tipoExamen.equalsIgnoreCase("Final") && Integer.parseInt(this.nota) > 3;
	}
	public boolean esDelAlumno(Alumno alumno) {
		return this.alumno.soyElAlumno(alumno.getLegajo());
	}
	
	public NotaView toView() { //Devuelve la nota convertida a nota view
		return new NotaView(curso.getMateria().getDescripcion(),curso.getMateria().getCodMateria(),tipoExamen,nota);
	}
}
