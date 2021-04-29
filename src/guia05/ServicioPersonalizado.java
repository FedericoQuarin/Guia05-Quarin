package guia05;

public class ServicioPersonalizado extends Servicio {
	private double costoPresupuestado;
	private double costoMateriales;
	private double costoTransporte;
	
	
	// CONSTRUCTOR
	public ServicioPersonalizado(Oficio oficio, String descripcion, double costoPresupuestado, double costoMateriales, double costoTransporte) {
		super(oficio, descripcion);
		this.costoPresupuestado = costoPresupuestado;
		this.costoMateriales = costoMateriales;
		this.costoTransporte = costoTransporte;
	}
	
	
	// Funcion que devuelve el costo total del servicio. No se utiliza la comision del trabajador para servicios personalizados
	// pero lo paso por parametro para poder utilizar el polimorfismo
	public double costo(double comisionTrabajador) {
		return this.costoPresupuestado + this.costoMateriales + this.costoTransporte;
	}
}
