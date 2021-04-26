package guia05;

public abstract class Servicio {
	protected Oficio oficio;	//Oficio que puede realizar el servicio
	protected String descripcion;

	
	// CONSTRUCTOR
	public Servicio(Oficio oficio, String descripcion) {
		super();
		this.oficio = oficio;
		this.descripcion = descripcion;
	}
	
	
	public abstract double costo();


	public Boolean coincideOficio(Oficio oficio) {
		return this.oficio.equals(oficio);
	}
}
