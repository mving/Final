package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Curso;
import modelo.Materia;
import modelo.Nota;
import view.AlumnoView;
import view.NotaView;

public class Controlador {

	private static Controlador instancia;
	private List<Alumno> alumnos;
	private List<Materia> materias;
	private List<Curso> cursos;
	
	private Controlador(){
		alumnos = new ArrayList<Alumno>();
		materias = new ArrayList<Materia>();
		cursos = new ArrayList<Curso>();
	}
	
	public static Controlador getinstancia(){
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
	}
	
	public List<Materia> aprobadas(int nroLegajo){
		Alumno alumno = this.buscarPorLegajo(nroLegajo);
		if(alumno != null){
			return alumno.aprobadas();
		}
		JOptionPane.showMessageDialog(null, "El alumno no existe");
		return null;
	}

	public ArrayList<Nota> obtenerNotasAlumno(int nroLegajo){
		Alumno alumno = this.buscarPorLegajo(nroLegajo);
		if(alumno != null){
			return (ArrayList<Nota>) alumno.getNotas();
		}
		JOptionPane.showMessageDialog(null, "El alumno no existe");
		return null;
	}
	
	//Usa el metodo obtenerNotasAlumno pero devuelve una lista de notas view
	public ArrayList<NotaView> getNotasView(int nroLegajo){
		ArrayList<NotaView> resultado = new ArrayList<NotaView>();
		ArrayList<Nota> notas = this.obtenerNotasAlumno(nroLegajo);
		for (Nota n: notas)
			resultado.add(n.toView());
		return resultado;
	}
	
	public List<Curso> cursosDeUnaMateria(String codMateria){
		List<Curso> resultado = new ArrayList<Curso>();
		Materia materia = buscarPorCodigo(codMateria);
		for(Curso curso : cursos) {
			if(curso.esDeLaMateria(materia))
				resultado.add(curso);
		}
		return resultado;
	}
	
	public void agregarNotaDeAlumno(int nroLegajo, int nroCurso, String tipoExamen, boolean asistencia, String nota){
		Alumno alumno = this.buscarPorLegajo(nroLegajo);
		Curso curso = this.buscarCursoPorNuemro(nroCurso);
		if(curso != null && alumno != null){
			curso.agregarNotaAlumno(alumno, tipoExamen, asistencia, nota);
		}
	}
	
	public void agregarCurso(String codigo){
		Materia materia = this.buscarPorCodigo(codigo);
		if(materia != null){
			Curso curso = new Curso(materia);
			cursos.add(curso);
		}
	}
	
	private Curso buscarCursoPorNuemro(int nroCurso) {
		for(Curso curso : cursos)
			if(curso.soyElCurso(nroCurso))
				return curso;
		return null;
	}

	private Alumno buscarPorLegajo(int nroLegajo) {
		for(Alumno alumno : alumnos)
			if(alumno.soyElAlumno(nroLegajo))
				return alumno;
		return null;
	}
	
	private Materia buscarPorCodigo(String codigo) {
		for(Materia materia : materias)
			if(materia.soyLaMateria(codigo))
				return materia;
		return null;
	}
	
	//Devuelve todos los alumnos que hay en el negocio convertidos a alumno view
	public ArrayList<AlumnoView> getAlumnos(){
		ArrayList<AlumnoView> resultado = new ArrayList<AlumnoView>();
		for (Alumno a: alumnos)
			resultado.add(a.toView());
		return resultado;
	}
	
	/*Este método cumple la funcion de cargar datos para probar la interfaz pero no es un metodo perteneciente al controlador, por lo que no esta incluido en el DC.
	 * Si bien no es lo mas correcto que se encuentre en esta clase, fue lo mas sencillo porque contiene toda la informacion y es solo a modo de prueba
	 * */
	public void pruebaCargaDatos() {
		this.materias.add(new Materia("1","Programacion"));
		this.materias.add(new Materia("2","Estadistica"));
		this.materias.add(new Materia("3","Analisis Matematico"));
		this.materias.add(new Materia("4","IOO"));
		this.materias.add(new Materia("5","Requerimientos"));
		this.agregarCurso("1");
		this.agregarCurso("2");
		this.agregarCurso("3");
		this.agregarCurso("4");
		this.agregarCurso("5");
		cursos.get(0).setNumero(1);
		cursos.get(1).setNumero(2);
		cursos.get(2).setNumero(3);
		cursos.get(3).setNumero(4);
		cursos.get(4).setNumero(5);
		this.alumnos.add(new Alumno("Juan Perez"));
		this.alumnos.add(new Alumno("Sofia Lopez"));
		this.alumnos.add(new Alumno("Tomas Gonzalez"));
		alumnos.get(0).agregarCurso(cursos.get(0));
		alumnos.get(0).agregarCurso(cursos.get(4));
		alumnos.get(2).agregarCurso(cursos.get(1));
		alumnos.get(1).agregarCurso(cursos.get(3));
		alumnos.get(0).agregarCurso(cursos.get(2));	//En este caso se esta agregando al alumno 1 al curso 2 pero no se le asigna nota para verificar que no aparezca en la interfaz
		//Hasta acá hay cargados 5 cursos de 5 materias distintas y 3 alumnos
		
		//Agregamos notas para probar el funcionamiento:
		this.agregarNotaDeAlumno(1, 1, "Primer parcial", true, "8");
		this.agregarNotaDeAlumno(1, 5, "Final regular", true, "4");
		this.agregarNotaDeAlumno(3, 2, "Segundo parcial", true, "2");
		this.agregarNotaDeAlumno(2, 4, "TPO", true, "10");
	}
	
}
