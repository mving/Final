package modelo;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	private int numero;
	private Materia materia;
	private List<Nota> notas;
	
	public Curso(Materia materia) {
		this.materia = materia;
		this.notas = new ArrayList<Nota>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	public void agregarNotaAlumno(Alumno alumno, String tipoExamen, boolean asistencia, String nota){
		Nota auxNota = new Nota(alumno, this, tipoExamen, asistencia, nota);
		notas.add(auxNota);	
	}

	public boolean soyElCurso(int nroCurso) {
		return this.numero == nroCurso;
	}

	public boolean aprobo(Alumno alumno) {
		for(Nota nota : notas) {
			if(nota.esFinal() && nota.esDelAlumno(alumno));
		}
		return false;
	}

	public List<Nota> getNotasAlumno(Alumno alumno) {
		List<Nota> resultado = new ArrayList<Nota>();
		for(Nota nota : notas)
			if(nota.esDelAlumno(alumno))
				resultado.add(nota);
		return resultado;
	}

	public boolean esDeLaMateria(Materia materia) {
		return this.materia.soyLaMateria(materia.getCodMateria());
	}
}
