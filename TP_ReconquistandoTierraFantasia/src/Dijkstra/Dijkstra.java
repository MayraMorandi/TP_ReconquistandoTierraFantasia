package dijkstra;
import java.util.Arrays;

public class Dijkstra {
	
	public static int[][] resolver(int[][] adyacencias, int[] nodos, int inicial) {
		//Valido que la matriz de adyacencias sea cuadrada
		if(!esCuadrada(adyacencias)) {
			throw new IllegalArgumentException("La matriz de adyacencias debe ser cuadrada");
		}
		
		//Creo las variables auxiliares que necesito
		int[] distancias = new int[adyacencias.length];
		int[] predecesores = new int[adyacencias.length];
		boolean[] visitados = new boolean[adyacencias.length];
		
		// Inicializar distancias a infinito y predecesores
        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(predecesores, -1);
		
		//Para todo nodo directamente conectado al nodo inicial le pongo el valor del camino directo
		for (int i = 0; i < adyacencias.length; i++) {
			if(adyacencias[inicial][i] != 0) {
				distancias[i] = adyacencias[inicial][i];
				predecesores[i] = inicial;
			}
		}
		
		//Establezco que la distacia del nodo inicial a si mismo es 0
		distancias[inicial] = 0;
		visitados[inicial] = true;
		
		//Mientras no esten todos visitados
		while(!todosVisitados(visitados)) {
			// Encontrar el nodo no visitado con la distancia mínima
            int u = minDistancia(distancias, visitados);

            // Si no se encuentra ningún nodo alcanzable, romper el ciclo
            if (u == -1) {
                break; // Esto ocurre cuando no hay más nodos alcanzables
            }
            
            // Marcar el nodo como visitado
            visitados[u] = true;
            
         // Actualizar las distancias de los vecinos no visitados
            for (int v = 0; v < adyacencias.length; v++) {
                if (!visitados[v] && adyacencias[u][v] != 0 && distancias[u] != 0 && distancias[u] + adyacencias[u][v] < distancias[v]) {
                    distancias[v] = distancias[u] + adyacencias[u][v];
                    predecesores[v] = u;
                }
            }
		}
		
		//Asigno los vectores a la matriz y los devuelvo
		int[][] vectores = new int[2][adyacencias.length]; 
		vectores[0] = distancias;
		vectores[1] = predecesores;
		return vectores;
	}
	
	//Metodo auxiliar para ver si todos los nodos estan visitados
	private static boolean todosVisitados(boolean[] v) {
		for (int i = 0; i < v.length; i++) {
			if(v[i] == false) {
				return false;
			}
		}
		return true;
	}
	
	// Método auxiliar para encontrar el nodo no visitado con la distancia mínima
    public static int minDistancia(int[] distancias, boolean[] visitado) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int i = 0; i < distancias.length; i++) {
            if (!visitado[i] && distancias[i] < min) {
                min = distancias[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    // Método para validar si una matriz es cuadrada
    public static boolean esCuadrada(int[][] matriz) {
        // Verificar si la matriz no es nula y tiene al menos una fila
        if (matriz == null || matriz.length == 0) {
            return false;
        }

        // Obtener el número de filas
        int numFilas = matriz.length;

        // Verificar que cada fila tenga la misma cantidad de columnas que el número de filas
        for (int[] fila : matriz) {
            if (fila.length != numFilas) {
                return false; // La matriz no es cuadrada
            }
        }

        return true; // La matriz es cuadrada
    }
    
    public static String devolverCamino(int[] v, int nodo) {
    	String camino = "";
    	int[] aux = new int[v.length];
    	int i = 0;
    	
    	Arrays.fill(aux, -1);
    	
    	aux[i] = nodo;
    	i++;
    	
    	while(v[nodo] != -1) {
    		aux[i] = v[nodo];
    		nodo = aux[i];
    		i++;
    	}
    	
    	for (int j = aux.length-1; j >= 0; j--) {
			if(aux[j] != -1) {
				if(j != 0) {
					camino += aux[j] + " -> ";
				}else {
					camino += aux[j];
				}
			}
		}
    	
    	return camino;
    }
    
    public static String devolverCaminoInverso(int[] v, int nodo) {
    	String camino = "";
    	int[] aux = new int[v.length];
    	int i = 0;
    	
    	Arrays.fill(aux, -1);
    	
    	aux[i] = nodo;
    	i++;
    	
    	while(v[nodo] != -1) {
    		aux[i] = v[nodo];
    		nodo = aux[i];
    		i++;
    	}
    	
    	for (int j = 0; j < i; j++) {
			if(aux[j] != -1) {
				if(j != i-1) {
					camino += (aux[j] + 1) + " -> ";
				}else {
					camino += (aux[j] + 1);
				}
			}
		}
    	
    	return camino;
    }

}
