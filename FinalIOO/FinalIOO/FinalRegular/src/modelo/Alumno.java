package modelo;

import java.util.ArrayList;
import java.util.List;
import view.AlumnoView;

public class Alumno {

	private static int generador = 0;
	private int legajo;
	private String nombre;
	private List<Curso> cursos;
	
	public Alumno(String nombre){
		Alumno.generador++;
		this.legajo = generador;
		this.nombre = nombre;
		cursos = new ArrayList<Curso>();
	}
 
	public List<Materia> aprobadas(){
		List<Materia> aprobadas = new ArrayList<Materia>();
		for(Curso curso : cursos)
			if(curso.aprobo(this))
			{
				aprobadas.add(curso.getMateria());
			}
		return aprobadas;
	}
	
	public int getLegajo() {
		return legajo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void agregarCurso(Curso curso) { //Agrega el curso recibido a los cursos del alumno
		this.cursos.add(curso);
	}
	
	public List<Nota> getNotas() {
		List<Nota> resultado = new ArrayList<Nota>();
		for(Curso curso : cursos)
			resultado.addAll(curso.getNotasAlumno(this));
		return resultado;
	}

	public boolean soyElAlumno(int nroLegajo) {
		return this.legajo == nroLegajo;
	}
	
	public AlumnoView toView() { //Devuelve el alumno convertido a alumno view
		return new AlumnoView(legajo,nombre);
	}
}
