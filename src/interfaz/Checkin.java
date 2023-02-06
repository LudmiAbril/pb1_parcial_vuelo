package interfaz;

import java.util.Scanner;

import dominio.Pasajero;
import dominio.Vuelo;

public class Checkin {

	public static void main(String[] args) {
		
		System.out.println("Bienvenido ");
		int CantidadPasajero = 192;
		Vuelo vuelo = new Vuelo("Buenos Aires", "Bariloche", CantidadPasajero);
		int opcion = 0;
		do {
		opcion = seleccionarOpcion();
		switch (opcion) {
		case 1:
		registrarPasajero(vuelo);
		break;
		case 2:
		elegirAsiento(vuelo);
		break;
		case 3:
		listarPasajeros(vuelo);
		break;
		case 9: System.out.println("adios!");
		break;
		default:
		System.out.println("Opción Invalida");
		break;
		}
		} while (opcion != 9);

	}
	
	private static int seleccionarOpcion() {
		Scanner teclado = new Scanner(System.in);
		int opcionSeleccionada=0;
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println("1 - Registrar pasajero");
		System.out.println("2 - Elegir Asiento");
		System.out.println("3 - Listar pasajeros");
		System.out.println("9 - Salir");
		System.out.println("************************");
		System.out.println("Ingrese una opcion");
		opcionSeleccionada = teclado.nextInt();
		return opcionSeleccionada;
		}
	
	public static void registrarPasajero(Vuelo actual) {
		/*
		* Interfaz de usuario encargada de cargar un pasajero al vuelo. Debe
		ingresar los datos necesarios e informar por pantalla el resultado de la operación
		*/
		Scanner teclado = new Scanner(System.in);
		String nombre, apellido;
		int dni;
		System.out.println("ingrese el nombre del pasajero");
		nombre=teclado.next();
		System.out.println("ingrese el apellido del pasajero");
		apellido=teclado.next();
		System.out.println("ingrese el dni");
		dni=teclado.nextInt();
		Pasajero pasajero=new Pasajero(dni,nombre,apellido);
		
		if(actual.agregarPasajero(pasajero)) {
			System.out.println("se registro el pasajero");
		}else {
			System.out.println("no se pudo registrar el pasajero");
		}
		
		
	}
	
	private static void elegirAsiento(Vuelo actual) {
		/*
		* Interfaz de usuario encargada de gestionar la asignación de asientos en
		el vuelo. Debe permitir el ingreso de los datos y mostrar por pantalla el
		resultado de la operación
		*/
		Scanner teclado = new Scanner(System.in);
		int dni, fila, columna;
		Pasajero pasajeroASentar;
		
   System.out.println("ingrese le dni del pasajero");
   dni=teclado.nextInt();
   System.out.println("ingrese la fila");
   fila=teclado.nextInt();
   System.out.println("ingrese la columna");
   columna=teclado.nextInt();
   pasajeroASentar=actual.buscarPasajero(dni);
   
   if(pasajeroASentar!=null && actual.asignarAsiento(pasajeroASentar, fila, columna)) {
	   System.out.println("se asigno el asiento");
   }else {
	   System.out.println("error al asignar el asiento");
   }
}

	private static void listarPasajeros(Vuelo actual) {
		actual.ordenarListaDePasajerosPorDNI();
		Pasajero lista[]=actual.getPasajeros();
		
		for(int i=0;i<lista.length;i++) {
			if(lista[i]!=null) {
				System.out.println(lista[i].toString());
			}
		}
		/*
		* Se debe mostrar la lista de pasajeros registrados para éste vuelo
		ordenados por DNI
		*/
		}
}
