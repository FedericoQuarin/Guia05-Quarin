package guia05;

import java.time.LocalDate;

import guia05.exceptions.*;

public class App {

	public static void main(String[] args) {
		
		//pruebaEj4();
		//pruebaEj5();
		//pruebaEj6();
		//pruebaEj7();
		//pruebaEj8();

	}

	public static void pruebaEj4() {
		System.out.println("%%%%%%%%%%%% Prueba ejercicio 4 %%%%%%%%%%%%");
		Oficio plomero = new Oficio("Plomero");

		Servicio serv1 = new ServicioEstandar(plomero, "Reparacion", 1000);
		Servicio serv2 = new ServicioPersonalizado(plomero, "Instalacion cañerias hogar", 5000, 2000, 500);

		Trabajo trabEstandarUrgente = new Trabajo(serv1, LocalDate.of(2021, 5, 10), true);
		Trabajo trabEstandarNoUrgente = new Trabajo(serv1, LocalDate.of(2021, 5, 11), false);
		Trabajo trabPersonalizadoUrgente = new Trabajo(serv2, LocalDate.of(2021, 5, 12), true);
		Trabajo trabPersonalizadoNoUrgente = new Trabajo(serv2, LocalDate.of(2021, 5, 13), false);
		
		Trabajador trabajador = new Trabajador("Pepe", "pepe14@yahoo.com.ar", plomero, 0.1);

		// Se intenta calcular el costo de un trabajo sin un trabajador asignado, entonces se lanza la excepcion
		try {
			trabEstandarUrgente.costo();
		}
		catch (TrabajadorNoAsignadoException exc) {
			System.out.println(exc.getMessage());
		}

		// Se asignan los trabajos al trabajador. En otras pruebas se examina mejor el metodo agregarTrabajo
		try {
			trabajador.agregarTrabajo(trabEstandarUrgente);
			trabajador.agregarTrabajo(trabEstandarNoUrgente);
			trabajador.agregarTrabajo(trabPersonalizadoUrgente);
			trabajador.agregarTrabajo(trabPersonalizadoNoUrgente);
		} 
		catch (OficioNoCoincideException exc) {
			System.out.println(exc.getMessage());
		}
		catch (AgendaOcupadaException exc) {
			System.out.println(exc.getMessage());
		}

		// ACLARACION: Da errores en los decimales
		try {
			System.out.println("Costo trabajo estandar no urgente: " + trabEstandarNoUrgente.costo());
			System.out.println("Costo trabajo estandar urgente: " + trabEstandarUrgente.costo());
			System.out.println("Costo trabajo personalizado no urgente: " + trabPersonalizadoNoUrgente.costo());
			System.out.println("Costo trabajo personalizado urgente: " + trabPersonalizadoUrgente.costo());
		}
		catch (TrabajadorNoAsignadoException exc) {
			System.out.println(exc.getMessage());
		}

	}

	public static void pruebaEj5() {
		System.out.println("%%%%%%%%%%%% Prueba ejercicio 5 %%%%%%%%%%%%");
		Herramienta martillo = new Herramienta("Martillo", 100);
		Herramienta taladro = new Herramienta("Taladro", 200);
		
		Alquiler alq1 = new Alquiler(martillo, LocalDate.of(2021, 4, 17), LocalDate.of(2021, 4, 28));
		
		// El alquiler aun no se devolvio, se deberia devolver el 28 de abril pero aun no fue devuelto entonces se muestra en mora
		System.out.println("alq1 debe pagar: " + alq1.costo());
		System.out.println("alq1 en mora? " + alq1.enMora());
		

		// Se devuelve el 30 de abril, pero la fecha de devolucion es pasado el dia en que se debia devolver, entonces esta en mora
		alq1.devolverHerramienta(LocalDate.of(2021, 4, 30));

		System.out.println("alq1 debe pagar: " + alq1.costo());
		System.out.println("alq1 en mora? " + alq1.enMora());
		
		
		
		// La herramienta aun no se devolvio, pero la fecha de fin del alquiler todavia no llego (al momento de hacer el TP al menos)
		Alquiler alq2 = new Alquiler(taladro, LocalDate.of(2021, 4, 18), LocalDate.of(2021, 5, 28));
		
		System.out.println("alq2 debe pagar: " + alq2.costo());
		System.out.println("alq2 en mora? " + alq2.enMora());
		
		// Se devuelve la herramienta antes del dia de fin del alquiler, entonces no esta en mora
		alq2.devolverHerramienta(LocalDate.of(2021, 4, 27));

		System.out.println("alq2 debe pagar: " + alq2.costo());
		System.out.println("alq2 en mora? " + alq2.enMora());
	}

	public static void pruebaEj6() {
		System.out.println("%%%%%%%%%%%% Prueba ejercicio 6 %%%%%%%%%%%%");
		Oficio electricista = new Oficio("Electricista");
		Servicio servicio = new ServicioPersonalizado(electricista, "Instalacion electrica", 1000, 1000, 100);
		Trabajo trabajo = new Trabajo(servicio, LocalDate.of(2021, 5, 1), false);

		Herramienta herr1 = new Herramienta("Taladro", 500);
		Alquiler alq1 = new Alquiler(herr1, LocalDate.of(2021, 5, 1), LocalDate.of(2021, 5, 11));

		// Ni el trabajo ni el alquiler fueron finalizados
		System.out.println("Trabajo finalizado? " + trabajo.finalizado());
		System.out.println("Alquiler finalizado? " + alq1.finalizado());

		// Se finaliza el trabajo
		trabajo.finalizar(LocalDate.of(2021, 5, 2));
		System.out.println("Trabajo finalizado? " + trabajo.finalizado());

		// Se finaliza el alquiler
		alq1.devolverHerramienta(LocalDate.of(2021, 5, 12));
		System.out.println("Alquiler finalizado? " + alq1.finalizado());


	}

	public static void pruebaEj7() {
		System.out.println("%%%%%%%%%%%% Prueba ejercicio 7 %%%%%%%%%%%%");

		Oficio gasista = new Oficio("Gasista");
		Oficio plomero = new Oficio("Plomero");

		Servicio s1 = new ServicioEstandar(gasista, "Arreglo perdida", 1000);
		Servicio s2 = new ServicioPersonalizado(gasista, "Instalacion cañerias de gas", 1000, 1000, 100);
		Servicio s3 = new ServicioEstandar(plomero, "Arreglo perdida", 1000);

		Trabajo t1 = new Trabajo(s1, LocalDate.now(), true);
		Trabajo t2 = new Trabajo(s2, LocalDate.now(), true);
		Trabajo t3 = new Trabajo(s3, LocalDate.of(2021, 5, 29), false);
		Trabajo t4 = new Trabajo(s1, LocalDate.of(2021, 5, 29), false);

		Trabajador trabajador = new Trabajador("Pepe", "pepe@gmail.com", gasista, 0.1);


		// Se intenta asignar el trabajo 3 al trabajador pero no es de su mismo oficio
		try {
			trabajador.agregarTrabajo(t3);
			System.out.println("Trabajo agregado con exito");
		}
		catch (OficioNoCoincideException exc) {
			System.out.println("El trabajador no tiene el oficio necesario para realizar este trabajo");
		}
		catch (AgendaOcupadaException exc) {
			System.out.println("El trabajador ya tiene un trabajo asignado el mismo dia");
		}


		// Se intenta asignar el trabajo 1 y no hay ningun problema
		try {
			trabajador.agregarTrabajo(t1);
			System.out.println("Trabajo agregado con exito");
		}
		catch (OficioNoCoincideException exc) {
			System.out.println("El trabajador no tiene el oficio necesario para realizar este trabajo");
		}
		catch (AgendaOcupadaException exc) {
			System.out.println("El trabajador ya tiene un trabajo asignado el mismo dia");
		}


		// Se intenta asignar el trabajo 2 y es el mismo dia que el trabajo 1, entonces se lanza la excepcion
		try {
			trabajador.agregarTrabajo(t2);
			System.out.println("Trabajo agregado con exito");
		}
		catch (OficioNoCoincideException exc) {
			System.out.println("El trabajador no tiene el oficio necesario para realizar este trabajo");
		}
		catch (AgendaOcupadaException exc) {
			System.out.println("El trabajador ya tiene un trabajo asignado el mismo dia");
		}


		// Se intenta agregar el trabajo 4 y no hay problemas
		try {
			trabajador.agregarTrabajo(t4);
			System.out.println("Trabajo agregado con exito");
		}
		catch (OficioNoCoincideException exc) {
			System.out.println("El trabajador no tiene el oficio necesario para realizar este trabajo");
		}
		catch (AgendaOcupadaException exc) {
			System.out.println("El trabajador ya tiene un trabajo asignado el mismo dia");
		}
	}

	public static void pruebaEj8() {
		System.out.println("%%%%%%%%%%%% Prueba ejercicio 8 %%%%%%%%%%%%");
		Oficio plomero = new Oficio("Plomero");
		Oficio carpintero = new Oficio("Carpintero");

		Servicio serv1 = new ServicioEstandar(plomero, "Arreglo", 1000);
		Servicio serv2 = new ServicioEstandar(carpintero, "Fabricacion puertas y ventanas", 1000);

		Trabajo trabajo1 = new Trabajo(serv1, LocalDate.of(2021, 4, 28), false);
		Trabajo trabajo2 = new Trabajo(serv2, LocalDate.of(2021, 4, 30), true);

		Herramienta martillo = new Herramienta("Martillo", 150);
		Herramienta taladro = new Herramienta("Taladro", 300);
		Herramienta destornillador = new Herramienta("Destornillador", 200);

		Alquiler alq1 = new Alquiler(martillo, LocalDate.of(2021, 4, 28), LocalDate.of(2021, 5, 10));
		Alquiler alq2 = new Alquiler(taladro, LocalDate.of(2021, 4, 25), LocalDate.of(2021, 5, 1));
		Alquiler alq3 = new Alquiler(destornillador, LocalDate.of(2021, 4, 29), LocalDate.of(2021, 5, 15));
		Alquiler alq4 = new Alquiler(destornillador, LocalDate.of(2021, 5, 17), LocalDate.of(2021, 5, 20));
		Alquiler alq5 = new Alquiler(martillo, LocalDate.of(2021, 5, 17), LocalDate.of(2021, 5, 20));

		Usuario user = new Usuario("pepe33@gmail.com");

		// El usuario contrata un servicio
		try {
			user.contratar(trabajo1);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
		}


		// El usuario alquila tres herramientas sin devolverlas
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

		try {
			user.contratar(alq3);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
		}

		// Ahora no puede contratar alquileres pero si trabajos
		try {
			user.contratar(alq4);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
		}

		try {
			user.contratar(trabajo2);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
		}

		// Devuelve una herramienta. Ahora ya puede contratar un alquiler
		alq1.devolverHerramienta(LocalDate.of(2021, 5, 11));
		

		try {
			user.contratar(alq4);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
		}


		// Como vuelve a superar el limite, ya no puede contratar un alquiler

		try {
			user.contratar(alq5);
			System.out.println("Contratacion exitosa");
		}
		catch (AlquilerNoEntregadoException exc) {
			System.out.println(exc.getMessage());
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
