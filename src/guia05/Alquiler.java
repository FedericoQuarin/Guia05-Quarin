package guia05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler implements Contratable {
	private LocalDate diaInicio;
	private LocalDate diaFin;
	private LocalDate diaDevolucion;
	private Herramienta herramientaAlquilada;
	
	
	public void estado() {
		System.out.println(this);
		System.out.println("DiaInicio: " + diaInicio);
		System.out.println("DiaFin: " + diaFin);
		System.out.println("DiaDev: " + diaDevolucion);
	}

	// CONSTRUCTOR
	public Alquiler(Herramienta herramienta, LocalDate diaInicio, LocalDate diaFin) {
		super();
		this.herramientaAlquilada = herramienta;
		this.diaInicio = diaInicio;
		this.diaFin = diaFin;
	}
	
	
	// Se devuelve la herramienta
	public void devolverHerramienta(LocalDate fechaDevolucion){
		this.diaDevolucion = fechaDevolucion;
	}
	
	
	
	// Devuelve true si la fecha de devolucion es posterior a la fecha de fin del alquiler o 
	// si la fecha actual es posterior a la fecha de fin del alquiler
	
	public Boolean enMora() {
		Boolean enMora = false;
		
		if (diaDevolucion != null) {
			if (diaDevolucion.isAfter(diaFin)) enMora = true;
		}
		else {
			if (LocalDate.now().isAfter(diaFin)) enMora = true;
		}
		
		return enMora;
	}
	
	
	
	// Devuelve el costo de un alquiler
	
	public double costo() {
		long diasAlquilada;
		
		if (diaDevolucion == null) diasAlquilada = diaInicio.until(LocalDate.now(), ChronoUnit.DAYS);
		else diasAlquilada = diaInicio.until(diaDevolucion, ChronoUnit.DAYS);
		
		return diasAlquilada * herramientaAlquilada.costoPorDia();
	}

	
	// Devuelve true si se devolvio la herramienta
	public boolean finalizado() {
		boolean devuelta = false;
		
		if (diaDevolucion != null) devuelta = true;
		
		return devuelta;
	}
	

	@Override
	public boolean esAlquilerNoDevuelto() {
		return (!this.finalizado());
	}

	
}
