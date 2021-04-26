package guia05;

import java.util.List;
import java.util.ArrayList;
import guia05.exceptions.AlquilerNoEntregadoException;

public class Usuario {
	private List<Contratable> contrataciones;

	public Usuario() {
		super();
		this.contrataciones = new ArrayList<>();
	}

	public void contratar(Contratable contratable) throws AlquilerNoEntregadoException{
		int contador = 0;

		for (Contratable e : contrataciones) {
			if (e.esAlquilerNoDevuelto()) contador++;
		}

		if (contador > 2) throw new AlquilerNoEntregadoException("El usuario superó el limite de alquileres no devueltos permitido");

		contrataciones.add(contratable);
	}

	public List<Contratable> getContrataciones() {
		return this.contrataciones;
	}
}
