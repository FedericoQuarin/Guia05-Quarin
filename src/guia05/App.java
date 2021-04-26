package guia05;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import guia05.exceptions.AgendaOcupadaException;
import guia05.exceptions.AlquilerNoEntregadoException;
import guia05.exceptions.OficioNoCoincideException;

public class App {

	public static void main(String[] args) {
		
		pruebaEj8();

	}

	public static void pruebaEj8() {
		Oficio plomero = new Oficio("Plomero");
		Oficio carpintero = new Oficio("Carpintero");

		Servicio serv1 = new ServicioEstandar(plomero, "Arreglo", 1000);
		Servicio serv2 = new ServicioEstandar(carpintero, "Fabricacion puertas y ventanas", 1000);

		Trabajo trabajo1 = new Trabajo(serv1, LocalDate.of(2021, 4, 28), false);
		Trabajo trabajo2 = new Trabajo(serv2, LocalDate.of(2021, 4, 30), true);
		Trabajo trabajo3 = new Trabajo(serv2, LocalDate.of(2021, 4, 27), true);

		Herramienta martillo = new Herramienta("Martillo", 150);
		Herramienta taladro = new Herramienta("Taladro", 300);
		Herramienta destornillador = new Herramienta("Destornillador", 200);

		Alquiler alq1 = new Alquiler(martillo, LocalDate.of(2021, 4, 28), LocalDate.of(2021, 5, 10));
		Alquiler alq2 = new Alquiler(taladro, LocalDate.of(2021, 4, 25), LocalDate.of(2021, 5, 1));
		Alquiler alq3 = new Alquiler(destornillador, LocalDate.of(2021, 4, 29), LocalDate.of(2021, 5, 15));
		Alquiler alq4 = new Alquiler(destornillador, LocalDate.of(2021, 5, 17), LocalDate.of(2021, 5, 20));
		Alquiler alq5 = new Alquiler(martillo, LocalDate.of(2021, 5, 17), LocalDate.of(2021, 5, 20));

		alq1.devolverHerramienta(LocalDate.of(2021, 5, 11));

		Usuario user = new Usuario();

		try {
			user.contratar(trabajo1);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println("Limite superado");
		}

		try {
			user.contratar(alq1);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println("Limite superado");
		}

		try {
			user.contratar(alq2);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println("Limite superado");
		}

		try {
			user.contratar(alq3);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println("Limite superado");
		}

		try {
			user.contratar(trabajo2);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println("Limite superado");
		}

		try {
			user.contratar(alq4);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println("Limite superado");
		}
		
		try {
			user.contratar(alq5);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println("Limite superado");
		}

		alq4.devolverHerramienta(LocalDate.now());

		try {
			user.contratar(alq5);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println("Limite superado");
		}

		try {
			user.contratar(trabajo3);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println("Limite superado");
		}

	}



	

	/*public static void primeraPrueba() {
		//Pruebas ej 4
		
		Oficio plomero = new Oficio("Plomero");
		
		
		Servicio s1 = new ServicioEstandar(plomero, 1000);
		Servicio s2 = new ServicioPersonalizado(plomero, 1000, 100, 500);
		
		LocalDate fechaHoy = LocalDate.now();
		
		Trabajador trab1 = new Trabajador("Pepe", "pepe@gmail.com", 1000, plomero);
		
		Trabajo t1 = new Trabajo(s1, fechaHoy, true);
		t1.asignarRealizador(trab1);
		
		System.out.println(t1.costo());
		
		
		
		//Pruebas ej 5
		
		Herramienta martillo = new Herramienta("Martillo", 100);
				
		LocalDate fecha1 = LocalDate.of(2021, 4, 1);
		LocalDate fecha2 = LocalDate.of(2021, 4, 20);
		LocalDate fecha3 = LocalDate.of(2021, 4, 17);
		
		
		Alquiler alq1 = new Alquiler(martillo, fecha1, fecha3);
		
		System.out.println("alq1 debe pagar: " + alq1.costo());
		System.out.println("alq1 en mora? " + alq1.enMora());
		
		alq1.devolverHerramienta(fecha2);

		System.out.println("alq1 debe pagar: " + alq1.costo());
		System.out.println("alq1 en mora? " + alq1.enMora());
		
		
		
		Alquiler alq2 = new Alquiler(martillo, fecha1, fecha2);
		
		System.out.println("alq2 debe pagar: " + alq2.costo());
		System.out.println("alq2 en mora? " + alq2.enMora());
		
		alq2.devolverHerramienta(fecha3);

		System.out.println("alq2 debe pagar: " + alq2.costo());
		System.out.println("alq2 en mora? " + alq2.enMora());
		

		// Pruebas ej 7

		Oficio gasista = new Oficio("Gasista");

		Servicio s3 = new ServicioEstandar(gasista, 1000);

		Trabajo t2 = new Trabajo(s3, LocalDate.now(), true);
		Trabajo t3 = new Trabajo(s2, LocalDate.now(), false);

		try {
			trab1.agregarTrabajo(t2);
			System.out.println("Trabajo agregado con exito");
		}
		catch (OficioNoCoincideException exc) {
			System.out.println("El trabajador no tiene el oficio necesario para realizar este trabajo");
		}
		catch (AgendaOcupadaException exc) {
			System.out.println("El trabajador ya tiene un trabajo asignado el mismo dia");
		}

		try {
			trab1.agregarTrabajo(t3);
			System.out.println("Trabajo agregado con exito");
		}
		catch (OficioNoCoincideException exc) {
			System.out.println("El trabajador no tiene el oficio necesario para realizar este trabajo");
		}
		catch (AgendaOcupadaException exc) {
			System.out.println("El trabajador ya tiene un trabajo asignado el mismo dia");
		}

		try {
			trab1.agregarTrabajo(t3);
			System.out.println("Trabajo agregado con exito");
		}
		catch (OficioNoCoincideException exc) {
			System.out.println("El trabajador no tiene el oficio necesario para realizar este trabajo");
		}
		catch (AgendaOcupadaException exc) {
			System.out.println("El trabajador ya tiene un trabajo asignado el mismo dia");
		}


		// pruebas 8
		Trabajo trabajo1 = new Trabajo(s1, LocalDate.now(), false);

		Usuario user = new Usuario();

		try {
			user.contratar(trabajo1);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
		}

		try {
			user.contratar(alq1);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
		}

		try {
			user.contratar(alq2);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
		}

		Alquiler alq3 = new Alquiler(martillo, fecha1, LocalDate.now());
		Alquiler alq4 = new Alquiler(martillo, fecha1, LocalDate.of(2022, 1, 1));
		Alquiler alq5 = new Alquiler(new Herramienta("Taladro", 500), fecha1, LocalDate.of(2022, 1, 1));

		try {
			user.contratar(alq3);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
		}

		try {
			user.contratar(alq4);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
		}
		
		try {
			user.contratar(alq5);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
		}

		System.out.println(user.getContrataciones());
	}*/

}
