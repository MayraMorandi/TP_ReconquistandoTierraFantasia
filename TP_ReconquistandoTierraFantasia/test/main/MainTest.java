package main;

import static org.junit.Assert.*;

import org.junit.Test;
import sistema.DatosDeSistema;
import sistema.Pueblo;
import sistema.Resultado;

public class MainTest {

	@Test
	//El ejercito es capaz de completar el camino
	public void reconquistaFactible() {
		int[][] mapa = {{0, 1},
						{1, 0}};
		Pueblo[] pueblos = new Pueblo[2];
		pueblos[0] = new Pueblo(10, "Wrives", "propio");
		pueblos[1] = new Pueblo(1, "Reralopes", "enemigo");
		DatosDeSistema DDS = new DatosDeSistema(mapa, pueblos, 0, 1);
		Resultado resultado;
		
		resultado = Main.reconquistar(DDS);
		
		assertEquals(resultado.getCantidadGuerrerosVivos(), 10);
		assertEquals(resultado.getTiempoTranscurrido(), 2);
		assertTrue(resultado.isFactible());
	}
	
	@Test
	//No existe un camino entre el pueblo inicial y el final
	public void sinCamino() {
		int[][] mapa = {{0, 0},
						{0, 0}};
		Pueblo[] pueblos = new Pueblo[2];
		pueblos[0] = new Pueblo(10, "Wrives", "propio");
		pueblos[1] = new Pueblo(1, "Reralopes", "enemigo");
		DatosDeSistema DDS = new DatosDeSistema(mapa, pueblos, 0, 1);
		Resultado resultado;
		
		resultado = Main.reconquistar(DDS);
		
		assertFalse(resultado.isFactible());
	}
	
	@Test
	//El ejercito propio es derrotado en el camino
	public void ejercitoDerrotado() {
		int[][] mapa = {{0, 1},
						{1, 0}};
		Pueblo[] pueblos = new Pueblo[2];
		pueblos[0] = new Pueblo(10, "Wrives", "propio");
		pueblos[1] = new Pueblo(100, "Reralopes", "enemigo");
		DatosDeSistema DDS = new DatosDeSistema(mapa, pueblos, 0, 1);
		Resultado resultado;
		
		resultado = Main.reconquistar(DDS);
		
		assertFalse(resultado.isFactible());
	}
	
	@Test
	//El ejercito propio es derrotado en el camino mas corto
	//aunque exista otro camino factible
	public void caminoMasCortoNoFactible() {
		int[][] mapa = {{0, 1, 4},
						{1, 0, 1},
						{4, 1, 0}};
		Pueblo[] pueblos = new Pueblo[3];
		pueblos[0] = new Pueblo(10, "Wrives", "propio");
		pueblos[1] = new Pueblo(100, "Reralopes", "enemigo");
		pueblos[2] = new Pueblo(10, "Wrives", "aliado");
		DatosDeSistema DDS = new DatosDeSistema(mapa, pueblos, 0, 2);
		Resultado resultado;
		
		resultado = Main.reconquistar(DDS);
		
		assertFalse(resultado.isFactible());
		System.out.println();
	}
}
