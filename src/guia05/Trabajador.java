package guia05;

import java.util.List;
import java.util.ArrayList;

public class Trabajador {
	private String nombre;
	private String email;
	private double costoHora;
	private double comision;
	private List<Trabajo> trabajos;	//Trabajos que el trabajador debe realizar y/o ya realizó
	
	// COnstructor
	public Trabajador(String nombre, String email, double costoHora, double comision) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.costoHora = costoHora;
		this.comision = comision;
		this.trabajos = new ArrayList<>();
	}
}
