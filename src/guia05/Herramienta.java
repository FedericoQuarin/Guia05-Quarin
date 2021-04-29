package guia05;

public class Herramienta {
	private String nombre;
	private double costoPorDia;
	private boolean alquilada;
	
	// CONSTRUCTOR
	public Herramienta(String nombre, double costoPorDia) {
		super();
		this.nombre = nombre;
		this.costoPorDia = costoPorDia;
		this.alquilada = false;
	}
	
	
	// GETTER costoPorDia
	
	public double costoPorDia() {
		return this.costoPorDia;
	}


}
