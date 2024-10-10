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
		
		resultado = Dijkstra.resolver(mapa, inicio);
		camino = Dijkstra.devolverCamino(resultado[1], fin);
		
		if(camino == null) {
			return new Resultado(false, 0, 0);
		}
		
		aux = pueblos.get(inicio);
		ejercito = new Ejercito(aux.getRaza(), aux.getCantidadGuerreros());
		
		for(int i = 1; i < camino.length; i++) {
			kilometros += resultado[0][camino[i]];
				
			aux = pueblos.get(camino[i]);
				
			if(aux.getCondicion() == "aliado") {
				ejercito.agregarGuerreros(aux.getRaza(), aux.getCantidadGuerreros() / 2);
			}
			else {
				if(!ejercito.batalla(new Ejercito(aux.getRaza(), aux.getCantidadGuerreros())))
					return new Resultado(false, 0, 0);
			}
		}
		
		if(kilometros % 10 == 0) {
			return new Resultado(true, ejercito.cantidadGuerrerosVivos(), kilometros / 10);
		}
		
		return new Resultado(true, ejercito.cantidadGuerrerosVivos(), (int) Math.ceil((double) kilometros / 10));
	}
}