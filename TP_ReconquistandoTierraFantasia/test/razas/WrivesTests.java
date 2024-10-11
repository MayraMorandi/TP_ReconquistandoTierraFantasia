package razas;

import static org.junit.Assert.*;

import org.junit.Test;

public class WrivesTests {
	
	@Test
	//Al recibir un ataque, la salud se reduzca por el doble del daño recibido
	public void recibirAtaque() {
	    Wrives wrives = new Wrives();
	    wrives.recibirAtaque(20);  // Recibe 20 de daño, pero debería aplicar 20 * 2
	    assertEquals(68, wrives.getSalud());  // Salud inicial 108 - 40
	}
	
	@Test
	//Al descansar, la salud y la salud máxima aumenten en 50
	public void descansars() {
	    Wrives wrives = new Wrives();
	    
	    wrives.descansar();
	    assertEquals(158, wrives.getSalud());  // Salud inicial 108 + 50
	    assertEquals(158, wrives.getSaludMaxima());  // Salud máxima aumentada en 50
	}
	
	@Test
	//No puede atacar si no ha sido atacado previamente, consideramos que el estado fueAtacado es importante
	public void ataqueAntesDeSerAtacado() {
	    Wrives wrives = new Wrives();
	    Reralopes enemigo = new Reralopes();
	    
	    int saludInicial = enemigo.getSalud();
	    
	    wrives.atacar(enemigo);  // No debería poder atacar
	    
	    assertEquals(saludInicial, enemigo.getSalud());  // Salud del enemigo no debe cambiar
	}
	
	@Test
	//No puede atacar si no ha sido atacado previamente, consideramos que el estado fueAtacado es importante
	public void ataqueDespuesDeDescansar() {
	    Wrives wrives = new Wrives();
	    Reralopes enemigo = new Reralopes();
	    
	    enemigo.atacar(wrives); // Puede atacar
	    
	    wrives.descansar(); // No debería poder atacar
	    
	    wrives.atacar(enemigo);  
	    
	    assertFalse(enemigo.isDesmayado());  // Salud del enemigo no debe cambiar
	}
	
	
	@Test
	//Cuando ataca, el tercer ataque hace el doble de daño
	public void ataque() {
	    Wrives wrives = new Wrives();
	    Reralopes enemigo = new Reralopes(); 
	    enemigo.setSalud(900);  // Para que sobreviva todos los ataques
	    wrives.recibirAtaque(10);  // Para habilitar que Wrives pueda atacar
	    
	    // Primer ataque (daño normal)
	    int saludInicial = enemigo.getSalud();
	    wrives.atacar(enemigo);
	    assertEquals(saludInicial - 113, enemigo.getSalud());

	    // Segundo ataque (daño normal)
	    wrives.atacar(enemigo);
	    assertEquals(saludInicial - 226, enemigo.getSalud());  // 113 + 113

	    // Tercer ataque (daño doble)
	    wrives.atacar(enemigo);
	    assertEquals(saludInicial - 452, enemigo.getSalud());  // 113 + 113 + 226
	}
	
	

}
