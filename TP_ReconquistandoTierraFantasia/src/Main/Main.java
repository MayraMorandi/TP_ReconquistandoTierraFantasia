package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import sistema.DatosDeSistema;
import sistema.Pueblo;
import sistema.Resultado;
import archivo.Archivo;
import dijkstra.Dijkstra;
import razas.Ejercito;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		DatosDeSistema entrada;
		
		entrada = Archivo.leerDatosEntrada("src/resources/Entrada/EntradaDerrota.txt");
		
		Archivo.guardarResultado("src/resources/Salida/Resultado2.txt", 
				reconquistar(entrada));
	}

	public static Resultado reconquistar (DatosDeSistema entrada) {
		int[][] mapa = entrada.getMapa(),
				resultado;
		List<Pueblo> pueblos = entrada.getPueblos();
		int inicio = entrada.getPuebloInicial(),
			fin = entrada.getPuebloFinal(),
			kilometros = 0;
		int[] camino;
		Ejercito ejercito;
		Pueblo aux;
		
		//Se busca el camino mas corto desde el pueblo inicial al resto de pueblos
		resultado = Dijkstra.resolver(mapa, inicio);
		
		//Se busca el camino mas corto entre el pueblo inicial al pueblo final
		camino = Dijkstra.devolverCamino(resultado[1], fin);
		
		//Se comprueba si hay un camino entre los dos pueblos
		if(camino == null) {
			return new Resultado(false, 0, 0);
		}
		
		//Se crea el ejercito del pueblo inicial
		aux = pueblos.get(inicio);
		ejercito = new Ejercito(aux.getRaza(), aux.getCantidadGuerreros());
		
		for(int i = 0; i < camino.length; i++) {
			if(inicio != camino[i]) {
				//Se suman los kilometros a recorrer desde el pueblo actual al siguiente
				kilometros += resultado[0][camino[i]];
					
				//Se obtienen el siguiente pueblo
				aux = pueblos.get(camino[i]);
				
				//Si es aliado, el ejercito descansa y se suma la mitad del pueblo
				if(aux.getCondicion().compareTo("aliado") == 0) {
					ejercito.descansar();
					ejercito.agregarGuerreros(aux.getRaza(), aux.getCantidadGuerreros() / 2);
				}
				//Si es enemigo, el ejercito batalla contra el pueblo
				else {
					if(!ejercito.batalla(new Ejercito(aux.getRaza(), aux.getCantidadGuerreros())))
						return new Resultado(false, 0, 0);
				}
			}
		}
		
		//Si los kilometros recorridos son multiplo de 10, devuelvo la division
		if(kilometros % 10 == 0) {
			return new Resultado(true, ejercito.cantidadGuerrerosVivos(), kilometros / 10);
		}
		
		//Si los kilometros recorridos no son multiplo de 10, 
		//Utilizo la funcion Math.ceil porque siempre redondea hacia arriba aunque sea multiplo de 10
		return new Resultado(true, ejercito.cantidadGuerrerosVivos(), (int) Math.ceil((double) kilometros / 10));
	}
}