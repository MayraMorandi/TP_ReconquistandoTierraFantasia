package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import sistema.DatosDeSistema;
import sistema.Pueblo;
import sistema.Resultado;
import archivo.Archivo;
import dijkstra.Dijkstra;
import razas.Ejercito;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		DatosDeSistema entrada;
		
//		entrada = Archivo.leerDatosEntrada("src/resources/Entrada/EntradaEjemplo.txt");
//		
//		Archivo.guardarResultado("src/resources/Salida/Resultado.txt", 
//				reconquistar(entrada));
		
		
		// Menu para seleccionar archivo
		
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		
		String[] archivos = {"EntradaEjemplo.txt", "EntradaSinCamino.txt", "Entrada5Pueblos.txt", "Entrada6Pueblos.txt", "Entrada8Pueblos.txt", "Entrada10Pueblos.txt"};
		
		System.out.println("Reconquistando la Tierra de Fantasia");
		
		do {
			
			System.out.println("\nSeleccione un archivo: ");
			for(int i=0; i<archivos.length; i++) {
				System.out.println((i+1) + ". " + archivos[i]);
			}
			
			System.out.println("0. Salir\n");
			
			opcion = scanner.nextInt();
			scanner.nextLine();
			
			if(opcion > 0 && opcion <= archivos.length) {
				
				entrada = Archivo.leerDatosEntrada("src/resources/Entrada/" + archivos[opcion-1]);
				Resultado res = reconquistar(entrada);
				Archivo.guardarResultado("src/resources/Salida/" + archivos[opcion-1], res);
				
				System.out.println("\nSe proceso el " + archivos[opcion-1]);
				
				System.out.println("\nResultado:");
				res.getResultado();
				
			} else if (opcion != 0) {
                System.out.println("Opción no válida. Por favor, ingrese una opción entre 1 y " + archivos.length + ", o 0 para salir.");
            }
			
		} while (opcion != 0);
		
		System.out.println("Fin de programa");
		scanner.close();
		
	}

	public static Resultado reconquistar (DatosDeSistema entrada) {
		int[][] mapa = entrada.getMapa(),
				resultado;
		List<Pueblo> pueblos = entrada.getPueblos();
		int inicio = entrada.getPuebloInicial(),
			fin = entrada.getPuebloFinal();
		int[] camino;
		Ejercito ejercito;
		Pueblo aux;
		
		//Se busca el camino mas corto desde el pueblo inicial al resto de pueblos
		resultado = Dijkstra.resolver(mapa, inicio);
		
		//Se busca el camino mas corto entre el pueblo inicial al pueblo final
		camino = Dijkstra.devolverCamino(resultado[1], fin);

		if(camino != null) {
			for(int i=0; i<camino.length; i++) 
			System.out.println("pueblo: " + (camino[i]+1));
		}
		
		//Se comprueba si hay un camino entre los dos pueblos
		if(camino == null) {
			return new Resultado(false, 0, 0);
		}
		
		//Guardo la cantidad de kilometros a recorrer en el viaje
		int kilometros = resultado[0][fin];
		
		//Se crea el ejercito del pueblo inicial
		aux = pueblos.get(inicio);
		ejercito = new Ejercito(aux.getRaza(), aux.getCantidadGuerreros());
		
		for(int i = 0; i < camino.length; i++) {
			if(inicio != camino[i]) {	
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
				
				//Aumento los kilometros para que se tome como un dia entero
				kilometros += 10;
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