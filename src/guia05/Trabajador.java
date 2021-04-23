package guia05;

import java.util.List;

import guia05.exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trabajador {
	private String nombre;
	private String email;
	private double comision;
	private Oficio oficio;
	private List<Trabajo> trabajos;	//Trabajos que el trabajador debe realizar y/o ya realiz�
	
	// CONSTRUCTOR
	public Trabajador(String nombre, String email, double comision, Oficio oficio) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.comision = comision;
		this.oficio = oficio;
		this.trabajos = new ArrayList<>();
	}
	
	
	// Devuelve la comision del trabajador
	public double comision(){
		return this.comision;
	}


	// Permite agregar trabajos a un trabajador
	public void agregarTrabajo(Trabajo trabajo) throws OficioNoCoincideException, AgendaOcupadaException{
		if (!trabajo.tieneOficioNecesario(this.oficio)) throw new OficioNoCoincideException("El trabajador no tiene el oficio requerido para el trabajo");
		if (this.tieneTrabajoAgendado(trabajo.getFechaARealizar())) throw new AgendaOcupadaException("El trabajador tiene otro trabajo agendado para dicho dia");

		this.trabajos.add(trabajo);
		
		trabajo.asignarRealizador(this);
	}


	// Comprueba si el trabajador tiene otro trabajo agendado para cierto dia
	private boolean tieneTrabajoAgendado(LocalDate fecha) {
		boolean retorno = false;

		for (Trabajo t : trabajos) {
			if (t.getFechaARealizar().equals(fecha)) {
				retorno = true;
				break;
			}
		}
		return retorno;
	}

}