package archivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import sistema.*;
import sistema.DatosDeSistema;

public class Archivo {

	public static DatosDeSistema leerDatosEntrada(String pathArchivo) throws FileNotFoundException, IOException {
		// Seteo las variables que necesito
		File archivo = new File(pathArchivo);
		int cantidadDePueblos;
		int puebloInicial;
		int puebloFinal;
		int[][] matrizAdyacencia;
		List<Pueblo> pueblos = new ArrayList<>();

		// Verificar si el archivo existe
		if (archivo.exists() && archivo.isFile()) {

			// Leer el archivo usando Scanner
			try (Scanner lector = new Scanner(archivo)) {
				// Leer la cantidad de pueblos
				cantidadDePueblos = Integer.parseInt(lector.nextLine());

				// Leer los datos de los pueblos
				for (int i = 0; i < cantidadDePueblos; i++) {
					String[] datosPueblo = lector.nextLine().split(" ");
					int id = Integer.parseInt(datosPueblo[0]) - 1;
					int habitantes = Integer.parseInt(datosPueblo[1]);
					String raza = datosPueblo[2];
					String relacion = datosPueblo[3];
					pueblos.add(new Pueblo(id, habitantes, raza, relacion));
				}

				// Leer el pueblo inicial y final
				String[] datosInicioFinal = lector.nextLine().split(" -> ");
				puebloInicial = Integer.parseInt(datosInicioFinal[0]);
				puebloFinal = Integer.parseInt(datosInicioFinal[1]);

				matrizAdyacencia = new int[cantidadDePueblos][cantidadDePueblos];

				// Inicializar la matriz de adyacencia con un valor que represente "sin
				// conexión"
				for (int i = 0; i < cantidadDePueblos; i++) {
					Arrays.fill(matrizAdyacencia[i], 0);
				}

				// Leer las distancias entre pueblos y llenar la matriz de adyacencia
				while (lector.hasNextLine()) {
					String[] datosCamino = lector.nextLine().split(" ");
					int origen = Integer.parseInt(datosCamino[0]) - 1; // Restar 1 para convertir a índice de matriz (0
																		// basado)
					int destino = Integer.parseInt(datosCamino[1]) - 1;
					int distancia = Integer.parseInt(datosCamino[2]);

					// Asignar la distancia en la matriz de adyacencia
					matrizAdyacencia[origen][destino] = distancia;
					matrizAdyacencia[destino][origen] = distancia; // Si es un grafo no dirigido, esto es necesario
				}
				
				DatosDeSistema datos = new DatosDeSistema(matrizAdyacencia, cantidadDePueblos, pueblos, puebloInicial, puebloFinal);
				return datos;

			} catch (FileNotFoundException e) {
				throw new FileNotFoundException("Error: El archivo no se pudo encontrar.");
			}

		} else {
			throw new FileNotFoundException("El archivo no existe o no es un archivo válido.");
		}

	}
	
	public static void guardarResultado(String pathArchivo, Resultado resultado) {
		try (FileWriter writer = new FileWriter(pathArchivo)) {
            if (resultado.isFactible()) {
                // Escribir que es factible
                writer.write("Es factible.\n");
                // Escribir cuántos guerreros llegarían hasta el final
                writer.write("Cantidad de guerreros vivos: " + resultado.getCantidadGuerrerosVivos() + "\n");
                // Escribir el tiempo transcurrido
                writer.write("Tiempo transcurrido: " + resultado.getTiempoTranscurrido() + " unidades de tiempo\n");
            } else {
                // Escribir que no es factible
                writer.write("No es factible.\n");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

}
