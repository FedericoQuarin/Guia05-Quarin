package guia05;

import java.time.LocalDate;

public class Trabajo {
	private LocalDate fechaARealizar;
	private Boolean urgente;
	private Trabajador trabajador;	//Trabajador que se encarga de realizar el trabajo
	private Servicio servicio;	//Servicio que se realizara en el trabajo
	
	
	// CONSTRUCTOR
	public Trabajo(Servicio servicio, LocalDate fechaARealizar, Boolean urgente) {
		super();
		this.servicio = servicio;
		this.fechaARealizar = fechaARealizar;
		this.urgente = urgente;
	}
	
	// Asigna un trabajador que se encargara de realizar el trabajo
	public void asignarRealizador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
	
	// Costo del trabajo a realizar
	// Si no tiene el trabajo un trabajador asignado y el servicio es estandar, da error de puntero nulo
	public double costo() {
		double costo = servicio.costo();
		
		if (servicio instanceof ServicioEstandar) costo += trabajador.comision();
		
		if (urgente) costo *= 1.50;
		
		return costo;
		
		
		
	}
}
