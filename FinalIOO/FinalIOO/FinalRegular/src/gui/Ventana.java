package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Controlador;
import view.AlumnoView;
import view.NotaView;

public class Ventana extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo, lblAlumno, lblNotas;
	private JComboBox<AlumnoView> alumnos;
	private JComboBox<NotaView> notas;
	private JButton btnBorrar, btnSalir, btnBuscar;
	Container c;
	
	public Ventana() {
		configurar();
		asignarEventos();
		this.setSize(800,600);
		this.setVisible(true);
		this.setTitle("obtenerNotas");
	}
	
	public void configurar() {
		
		Container c = this.getContentPane();
		c.setLayout(null);
		
		lblTitulo = new JLabel("OBTENER NOTAS ALUMNO");
		lblAlumno = new JLabel("Alumno:");
		lblNotas = new JLabel("Notas:");
		lblTitulo.setBounds(300, 10, 200, 80);
		lblAlumno.setBounds(50, 100, 100, 80);
		lblNotas.setBounds(50, 200, 100, 80);
		alumnos = new JComboBox<AlumnoView>();
		ArrayList<AlumnoView> listadoAlumnos = Controlador.getinstancia().getAlumnos();
		for (AlumnoView a: listadoAlumnos) {
			alumnos.addItem(a);
		}
		alumnos.setBounds(400, 120, 300, 40);
		
		notas = new JComboBox<NotaView>();
		notas.setBounds(400, 220, 300, 40);

		btnBorrar = new JButton("Borrar");
		btnSalir = new JButton("Salir");
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(50, 450, 200, 40);
		btnBorrar.setBounds(300, 450, 200, 40);
		btnSalir.setBounds(550, 450, 200, 40);
		
		c.add(lblTitulo);
		c.add(lblAlumno);
		c.add(lblNotas);
		c.add(btnBorrar);
		c.add(btnSalir);
		c.add(alumnos);
		c.add(notas);
		c.add(btnBuscar);
	}
	
	public void asignarEventos() {
		
		ManejoBotones mb = new ManejoBotones();
		btnBuscar.addActionListener(mb);
		btnBorrar.addActionListener(mb);
		btnSalir.addActionListener(mb);
		
	}
	
	class ManejoBotones implements ActionListener{
		
		public ManejoBotones() {}

		@Override
		public void actionPerformed(ActionEvent boton) {
			if (boton.getSource().equals(btnSalir))
				System.exit(0);
			else if(boton.getSource().equals(btnBorrar)) {
				notas.removeAllItems();
				alumnos.setSelectedIndex(0);
			}
			else {
				AlumnoView alumno = (AlumnoView) alumnos.getSelectedItem();
				if (alumno!=null) {
					ArrayList<NotaView> listadoNotas = Controlador.getinstancia().getNotasView(alumno.getLegajo());
					for (NotaView n: listadoNotas)
						notas.addItem(n);
				}
			}
			
		}
	}

}
