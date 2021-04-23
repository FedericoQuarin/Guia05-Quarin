package guia05;

public abstract class Servicio {
	protected Oficio oficio;	//Oficio que puede realizar el servicio
	
	
	// CONSTRUCTOR
	public Servicio(Oficio oficio) {
		super();
		this.oficio = oficio;
	}
	
	
	public abstract double costo();


	public Boolean coincideOficio(Oficio oficio) {
		return this.oficio.equals(oficio);
	}
}
