package guia05;

import java.util.List;
import java.util.ArrayList;
import guia05.exceptions.AlquilerNoEntregadoException;

public class Usuario {
	private String email;
	private List<Contratable> contrataciones;

	public Usuario(String email) {
		super();
		this.email = email;
		this.contrataciones = new ArrayList<>();
	}


	// Permite contratar un Contratable si se cumplen las condiciones dadas
	public void contratar(Contratable contratable) throws AlquilerNoEntregadoException{
		int contador = 0;

		for (Contratable e : contrataciones) {
			if (e.esAlquilerNoDevuelto()) contador++;
		}

		if (contador > 2 && contratable instanceof Alquiler) throw new AlquilerNoEntregadoException("El usuario superó el limite de alquileres no devueltos permitido");

		contrataciones.add(contratable);
	}

	public List<Contratable> getContrataciones() {
		return this.contrataciones;
	}
}
