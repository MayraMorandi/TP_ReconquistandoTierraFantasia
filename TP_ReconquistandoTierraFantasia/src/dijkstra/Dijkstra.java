package dijkstra;

import java.util.Arrays;

public class Dijkstra {

	public static int[][] resolver(int[][] adyacencias, int inicial) {
		// Valido que la matriz de adyacencias sea cuadrada
		if (!esCuadrada(adyacencias)) {
			throw new IllegalArgumentException("La matriz de adyacencias debe ser cuadrada");
		}

		// Creo las variables auxiliares que necesito
		int tamano = adyacencias.length;
		int[] distancias = new int[tamano];
		int[] predecesores = new int[tamano];
		boolean[] visitados = new boolean[tamano];

		// Inicializar distancias a infinito y predecesores
		Arrays.fill(distancias, Integer.MAX_VALUE);
		Arrays.fill(predecesores, -1);

		// Para todo nodo directamente conectado al nodo inicial le pongo el valor del
		// camino directo
		for (int i = 0; i < tamano; i++) {
			if (adyacencias[inicial][i] != 0) {
				distancias[i] = adyacencias[inicial][i];
				predecesores[i] = inicial;
			}
		}

		// Establezco que la distacia del nodo inicial a si mismo es 0
		distancias[inicial] = 0;
		visitados[inicial] = true;

		// Mientras no esten todos visitados
		while (!todosVisitados(visitados)) {
			// Encontrar el nodo no visitado con la distancia minima
			int u = minDistancia(distancias, visitados);

			// Si no se encuentra ningun nodo alcanzable, romper el ciclo
			if (u == -1) {
				break; // Esto ocurre cuando no hay m�s nodos alcanzables
			}

			// Marcar el nodo como visitado
			visitados[u] = true;

			int otraDistancia;

			// Actualizar las distancias de los vecinos no visitados
			for (int v = 0; v < tamano; v++) {
				if (adyacencias[u][v] != 0) {
					otraDistancia = distancias[u] + adyacencias[u][v];

					if (!visitados[v] && otraDistancia < distancias[v]) {
						distancias[v] = otraDistancia;
						predecesores[v] = u;
					}
				}
			}
		}

		// Asigno los vectores a la matriz y los devuelvo
		int[][] vectores = new int[2][];
		vectores[0] = distancias;
		vectores[1] = predecesores;
		return vectores;
	}

	// Metodo auxiliar para ver si todos los nodos estan visitados
	private static boolean todosVisitados(boolean[] v) {
		for (boolean b : v) {
			if (b == false) {
				return false;
			}
		}
		return true;
	}

	// Metodo auxiliar para encontrar el nodo no visitado con la distancia minima
	private static int minDistancia(int[] distancias, boolean[] visitado) {
		int min = Integer.MAX_VALUE, minIndex = -1;

		for (int i = 0; i < distancias.length; i++) {
			if (!visitado[i] && distancias[i] < min) {
				min = distancias[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	// Metodo para validar si una matriz es cuadrada
	private static boolean esCuadrada(int[][] matriz) {
		// Verificar si la matriz no es nula y tiene al menos una fila
		if (matriz == null || matriz.length == 0) {
			return false;
		}

		// Obtener el numero de filas
		int numFilas = matriz.length;

		// Verificar que cada fila tenga la misma cantidad de columnas que el numero de
		// filas
		for (int[] fila : matriz) {
			if (fila.length != numFilas) {
				return false; // La matriz no es cuadrada
			}
		}

		return true; // La matriz es cuadrada
	}

	// devuelve el camino desde el nodo inicial hasta el nodo final mandado
	public static int[] devolverCamino(int[] v, int nodo) {
		int[] camino;
		int[] aux = new int[v.length];
		int i = 0;

		Arrays.fill(aux, -1);

		aux[i] = nodo;
		i++;

		while (v[nodo] != -1) {
			aux[i] = v[nodo];
			nodo = aux[i];
			i++;
		}

		if (i == 1 && aux[0] == nodo)
			return null;

		camino = new int[i];
		i = 0;

		for (int j = aux.length - 1; j >= 0; j--) {
			if (aux[j] != -1) {
				camino[i] = aux[j];
				i++;
			}
		}

		return camino;
	}
}
