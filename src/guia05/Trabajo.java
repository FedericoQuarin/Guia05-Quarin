package guia05;

import java.time.LocalDate;

public class Trabajo implements Contratable {
	private LocalDate fechaARealizar, fechaFin;
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


	// GETTER fechaARealizar
	public LocalDate getFechaARealizar() {
		return this.fechaARealizar;
	}


	
	// Asigna un trabajador que se encargara de realizar el trabajo
	public void asignarRealizador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
	
	// Costo del trabajo a realizar
	// Si no tiene el trabajo un trabajador asignado y el servicio es estandar, da error de puntero nulo
	public double costo() {
		double costo = this.servicio.costo();
		
		if (this.servicio instanceof ServicioEstandar) costo += this.trabajador.comision();
		
		if (this.urgente) costo *= 1.50;
		
		return costo;
	}
	
	public void finalizar(LocalDate fechaFinalizacion) {
		this.fechaFin = fechaFinalizacion;
	}

	// Devuelve true si el trabajo tiene una fecha de fin
	public boolean finalizado() {
		return this.fechaFin != null;
	}

	// Devuelve true si el oficio pasado por parametro coincide con el oficio correspondiente al servicio a realizar
	public boolean tieneOficioNecesario(Oficio oficio) {
		return this.servicio.coincideOficio(oficio);
	}


	@Override
	public boolean esAlquilerNoDevuelto() {
		return false;
	}


	public void estado() {
		System.out.println("trabajo");
	}
	
}
