package guia05;

public class Oficio {
	private String nombreOficio;

    
    // CONSTRUCTOR
    public Oficio(String nombreOficio) {
        this.nombreOficio = nombreOficio;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Oficio other = (Oficio) obj;
        if (this.nombreOficio == null) {
            if (other.nombreOficio != null)
                return false;
        } else if (!nombreOficio.equals(other.nombreOficio))
            return false;
        return true;
    }


    // GETTER nombreOficio
    

}
