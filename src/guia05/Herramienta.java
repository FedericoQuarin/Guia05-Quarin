package guia05;

public class Herramienta {
	private String nombre;
	private double costoPorDia;
	private Boolean alquilado;	//Indica si la herramienta se ha alquilado y aun no se ha devuelto
	
	// CONSTRUCTOR
	public Herramienta(String nombre, float costoPorDia) {
		super();
		this.nombre = nombre;
		this.costoPorDia = costoPorDia;
		this.alquilado = false;
	}
	
	
	// GETTER costoPorDia
	
	public double costoPorDia() {
		return this.costoPorDia;
	}
}
