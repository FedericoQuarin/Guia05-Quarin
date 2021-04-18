package guia05;

public class ServicioPersonalizado extends Servicio {
	private double costoPresupuestado;
	private double costoMateriales;
	private double costoTransporte;
	
	
	// CONSTRUCTOR
	public ServicioPersonalizado(Oficio oficio, double costoPresupuestado, double costoMateriales, double costoTransporte) {
		super(oficio);
		this.costoPresupuestado = costoPresupuestado;
		this.costoMateriales = costoMateriales;
		this.costoTransporte = costoTransporte;
	}
	
	
	// Funcion que devuelve el costo total del servicio
	public double costo() {
		return this.costoPresupuestado + this.costoMateriales + this.costoTransporte;
	}
}
