package archivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import sistema.*;
import sistema.DatosDeSistema;

public class Archivo {

	public static DatosDeSistema leerDatosEntrada(String pathArchivo) throws FileNotFoundException, IOException {
		// Se setean las variables que necesito
		File archivo = new File(pathArchivo);
		int cantidadDePueblos;
		int puebloInicial;
		int puebloFinal;
		int[][] matrizAdyacencia;
		Pueblo[] pueblos;

		// Se verifica si el archivo existe
		if (archivo.exists() && archivo.isFile()) {

			// Leer el archivo usando Scanner
			try (Scanner lector = new Scanner(archivo)) {
				// Leer la cantidad de pueblos
				cantidadDePueblos = Integer.parseInt(lector.nextLine());

				pueblos = new Pueblo[cantidadDePueblos];
				
				// Leer los datos de los pueblos
				for (int i = 0; i < cantidadDePueblos; i++) {
					String[] datosPueblo = lector.nextLine().split(" ");
					int id = Integer.parseInt(datosPueblo[0]) - 1;
					int habitantes = Integer.parseInt(datosPueblo[1]);
					String raza = datosPueblo[2];
					String relacion = datosPueblo[3];
					pueblos[id] = new Pueblo(habitantes, raza, relacion);
				}

				// Leer el pueblo inicial y final
				String[] datosInicioFinal = lector.nextLine().split(" -> ");
				puebloInicial = Integer.parseInt(datosInicioFinal[0]) - 1;// Restar 1 para convertir a indice de matriz
				puebloFinal = Integer.parseInt(datosInicioFinal[1]) - 1;

				matrizAdyacencia = new int[cantidadDePueblos][cantidadDePueblos];

				// Inicializar la matriz de adyacencia con un valor que represente "sin
				// conexion"

				// Leer las distancias entre pueblos y llenar la matriz de adyacencia
				while (lector.hasNextLine()) {
					String[] datosCamino = lector.nextLine().split(" ");
					int origen = Integer.parseInt(datosCamino[0]) - 1; // Restar 1 para convertir a indice de matriz
																		// (0 basado)
					int destino = Integer.parseInt(datosCamino[1]) - 1;
					int distancia = Integer.parseInt(datosCamino[2]);

					// Asignar la distancia en la matriz de adyacencia
					matrizAdyacencia[origen][destino] = distancia;
					matrizAdyacencia[destino][origen] = distancia; // Si es un grafo no dirigido, esto es necesario
				}

				DatosDeSistema datos = new DatosDeSistema(matrizAdyacencia, pueblos, puebloInicial, puebloFinal);
				return datos;

			} catch (FileNotFoundException e) {
				throw new FileNotFoundException("Error: El archivo no se pudo encontrar.");
			}

		} else {
			throw new FileNotFoundException("El archivo no existe o no es un archivo v�lido.");
		}

	}

	public static void guardarResultado(String pathArchivo, Resultado resultado) {
		try (FileWriter writer = new FileWriter(pathArchivo)) {
			if (resultado.isFactible()) {

				writer.write("Esta misión es factible!\n");

				writer.write("Cantidad de guerreros vivos: " + resultado.getCantidadGuerrerosVivos() + " guerreros\n");

				writer.write("Tiempo transcurrido: " + resultado.getTiempoTranscurrido() + " días\n");

			} else {

				writer.write("Esta misión no es factible.\n");

			}
		} catch (IOException e) {
			System.out.println("Error al guardar el archivo: " + e.getMessage());
		}
	}

}
