package guia05;

public class ServicioEstandar extends Servicio {
	private double montoFijo;
	
	
	// CONSTRUCTOR
	public ServicioEstandar(Oficio oficio, String descripcion, double montoFijo) {
		super(oficio, descripcion);
		this.montoFijo = montoFijo;
	}
	
	
	// Funcion que devuelve el costo total del servicio
	public double costo() {
		return this.montoFijo;
	}
}
