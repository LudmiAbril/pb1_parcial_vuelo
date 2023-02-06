package dominio;

public class Vuelo {
	private final int CANTIDAD_DE_FILAS = 32;
	private final int CANTIDAD_DE_ASIENTOS_POR_FILA = 6;
	private String origen;
	private String destino;
	private Pasajero[] pasajeros;
	private Pasajero[][] asientos;
	
	public Vuelo(String origen, String destino, int cantidadPasajeros) {
		this.origen = origen;
		this.destino = destino;
		this.pasajeros=new Pasajero[cantidadPasajeros];
		this.asientos=new Pasajero[CANTIDAD_DE_FILAS][CANTIDAD_DE_ASIENTOS_POR_FILA];
	}

	public boolean agregarPasajero(Pasajero pasajero) {
		for(int i=0;i<pasajeros.length;i++) {
			if(pasajeros[i]==null) {
				pasajeros[i]=pasajero;
				return true;
			}
		} return false;
		
		
		/*
		* Incorpora un nuevo pasajero a la lista de pasajeros del vuelo.
		Devuelve true si se pudo agregar o false si la capacidad del vuelo se
		encuentra completa.
		*/
		}

	public boolean verificarDisponibilidadAsiento(int fila, int columna) {
		if(asientos[fila][columna]==null) {
			return true;
		} return false;
		
		/*
		* Verifica si el asiento indicado se encuentra disponible.
		*/
		}
	
	public Pasajero buscarPasajero(int dni) {
		for(int i=0;i<pasajeros.length;i++) {
			if(pasajeros[i]!=null && pasajeros[i].getDni()==dni) {
				return pasajeros[i];
			}
		} return null;
		
		
		/*
		* Busca un pasajero en la lista de pasajeros a partir del DNI. Si no
		lo encuentra devuelve null.
		*/
		}
	
	public boolean asignarAsiento(Pasajero pasajero, int fila, int columna) {
		if(verificarDisponibilidadAsiento(fila,columna)) {
			asientos[fila][columna]=pasajero;
			return true;
		} return false;
		/*
		* Asigna el asiento al pasajero recibido por parámetro. Devuelve
		true si lo pudo asignar o false en caso que el asiento no se encuentre disponible.
		*/
		}
	
	public void ordenarListaDePasajerosPorDNI() {
		Pasajero aux;
		for(int i=1;i<pasajeros.length;i++) {
			for(int j=0;j<pasajeros.length;j++) {
				if(pasajeros[j]!=null && pasajeros[j+1]!=null && pasajeros[j].getDni()>pasajeros[j+1].getDni()) {
					aux=pasajeros[j];
					pasajeros[j]=pasajeros[j+1];
					pasajeros[j+1]=aux;
				}
			}
		}
		
		/*
		* Ordena la lista de pasajeros por DNI.
		*/
		}

	public Pasajero[] getPasajeros() {
		return pasajeros;
		
		/*
		* Devuelve la lista de pasajeros
		*/

	}

	public String toString() {
		String asiento="**ASIENTOS**";
		int num=0;
		for(int f=0;f<asientos.length;f++) {
			for(int c=0;c<asientos.length;c++) {
				if(asientos[f][c]!=null) {
					asiento+="\n asiento: " + num + " O";
				}else { 
					asiento+="\n asiento: " + num + " L";
				}
				num++;
			}
		} return asiento;
		
		/*
		* Devuelve un mapa de los asientos del vuelo indicando por cada uno
		si se encuentra libre "L" u ocupado "O".
		*/
		}

	

}
