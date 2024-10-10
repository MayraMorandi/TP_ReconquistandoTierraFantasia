package Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import sistema.DatosDeSistema;
import sistema.Pueblo;
import sistema.Resultado;
import archivo.Archivo;
import razas.Ejercito;
import Dijkstra.Dijkstra;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		DatosDeSistema Entrada;
		
		Entrada = Archivo.leerDatosEntrada("C:\\Users\\marce\\OneDrive\\Escritorio\\Programación avanzada\\TP_ReconquistandoTierraFantasia-master\\Archivo.txt");
		
		Archivo.guardarResultado("C:\\Users\\marce\\OneDrive\\Escritorio\\Programación avanzada\\TP_ReconquistandoTierraFantasia-master\\ArchivoR.txt", 
				reconquistar(Entrada));
	}

	public static Resultado reconquistar (DatosDeSistema Entrada) {
		int[][] mapa = Entrada.getMapa(),
				resultado;
		List<Pueblo> pueblos = Entrada.getPueblos();
		int inicio = Entrada.getPuebloInicial(),
			fin = Entrada.getPuebloFinal(),
			kilometros = 0;
		int[] camino;
		Ejercito ejercito;
		Pueblo aux;
		
		//encuentro el camino mas corto desde el pueblo inicial al resto de pueblos
		resultado = Dijkstra.resolver(mapa, inicio);
		
		//busco el camino mas corto entre el pueblo inicial al pueblo final
		camino = Dijkstra.devolverCamino(resultado[1], fin);
		
		//compruebo si hay un camino entre los dos pueblos
		if(camino == null) {
			return new Resultado(false, 0, 0);
		}
		
		//creo el ejercito del pueblo inicial
		aux = pueblos.get(inicio);
		ejercito = new Ejercito(aux.getRaza(), aux.getCantidadGuerreros());
		
		for(int i = 1; i < camino.length; i++) {
			//sumo los kilometros a recorrer desde el pueblo actual al siguiente
			kilometros += resultado[0][camino[i]];
				
			//obtengo el siguiente pueblo
			aux = pueblos.get(camino[i]);
			
			//si es aliado, el ejercito descansa y se suma la mitad del pueblo
			if(aux.getCondicion() == "aliado") {
				ejercito.descansar();
				ejercito.agregarGuerreros(aux.getRaza(), aux.getCantidadGuerreros() / 2);
			}
			//si es enemigo, el ejercito batalla contra el pueblo
			else {
				if(!ejercito.batalla(new Ejercito(aux.getRaza(), aux.getCantidadGuerreros())))
					return new Resultado(false, 0, 0);
			}
		}
		
		//si los kilometros recorridos son multiplo de 10, devuelvo la division
		if(kilometros % 10 == 0) {
			return new Resultado(true, ejercito.cantidadGuerrerosVivos(), kilometros / 10);
		}
		
		//si los kilometros recorridos no son multiplo de 10, 
		//utilizo la funcion Math.ceil porque siempre redondea hacia arriba aunque sea multiplo de 10
		return new Resultado(true, ejercito.cantidadGuerrerosVivos(), (int) Math.ceil((double) kilometros / 10));
	}
}