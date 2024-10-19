package dijkstra;

import static org.junit.Assert.*;

import org.junit.Test;

public class DijkstraTest {

	@Test
	// Devuelve un vector con el coste de llegar de un nodo a otro del camino mas
	// corto
	// desde un nodo al resto y los predecesores del nodo de la posicion de vector
	public void resolver() {
		int[][] grafo = { { 0, 7, 3, 0 }, { 0, 0, 0, 2 }, { 0, 2, 0, 8 }, { 0, 0, 0, 0 } }, resultado,
				resultadoEsperado = { { 0, 5, 3, 7 }, { -1, 2, 0, 1 } };

		resultado = Dijkstra.resolver(grafo, 0);

		assertArrayEquals(resultadoEsperado, resultado);

		int[][] resultadoEsperado0 = { { Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 2 }, { -1, -1, -1, 1 } };

		resultado = Dijkstra.resolver(grafo, 1);

		assertArrayEquals(resultadoEsperado0, resultado);

		int[][] resultadoEsperado1 = { { Integer.MAX_VALUE, 2, 0, 4 }, { -1, 2, -1, 1 } };

		resultado = Dijkstra.resolver(grafo, 2);

		assertArrayEquals(resultadoEsperado1, resultado);

		int[][] resultadoEsperado2 = { { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 },
				{ -1, -1, -1, -1 } };

		resultado = Dijkstra.resolver(grafo, 3);

		assertArrayEquals(resultadoEsperado2, resultado);
	}

	@Test
	// Devuelve los nodos por los que hay que pasar desde el nodo inicial
	// hasta el nodo final en el orden por el que se pasa por cada uno
	public void devolverCamino() {
		int[] predecesores = { -1, 2, 0, 1 }, resultado, resultadoEsperado = { 0, 2, 1, 3 };

		resultado = Dijkstra.devolverCamino(predecesores, 3);

		assertArrayEquals(resultadoEsperado, resultado);

		int[] resultadoEsperado0 = { 0, 2 };

		resultado = Dijkstra.devolverCamino(predecesores, 2);

		assertArrayEquals(resultadoEsperado0, resultado);

		int[] resultadoEsperado1 = { 0, 2, 1 };

		resultado = Dijkstra.devolverCamino(predecesores, 1);

		assertArrayEquals(resultadoEsperado1, resultado);
	}
}
