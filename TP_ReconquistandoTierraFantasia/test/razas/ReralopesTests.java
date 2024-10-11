package razas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReralopesTests {

	@Test
	public void saludInicial() {
	    Reralopes reralopes = new Reralopes();
	    assertEquals(53, reralopes.getSalud());
	}
	
	
	@Test
	//Al recibir un ataque, el contador de ataques potenciados se reinicia a 0
	public void recibirAtaque() {
	    Reralopes reralopes = new Reralopes();
	    
	    reralopes.descansar();  // Esto incrementa cantAtaquesPotenciados a 3
	    reralopes.recibirAtaque(10);  // Recibe un ataque
	    
	    assertEquals(0, reralopes.getCantAtaquesPotenciados());  // El contador de ataques potenciados debería ser 0
	}
	
	@Test
	//Al descansar, cantAtaquesPotenciados se establece en 3
	public void descansar() {
	    Reralopes reralopes = new Reralopes();
	    reralopes.descansar();
	    
	    assertEquals(3, reralopes.getCantAtaquesPotenciados());  // Debería tener 3 ataques potenciados
	}
	
	/**
	@Test
	//De 4 ataques, 2 fallan
	public void ataqueFalla() {
	    Reralopes reralopes = new Reralopes();
	    Wrives enemigo = new Wrives();  

	    int ataquesFallidos = 0;
	    for (int i = 0; i < 4; i++) {
	        reralopes.atacar(enemigo);
	        // Simula fallo basado en el comportamiento aleatorio
	        if (enemigo.getSalud() == enemigo.getSaludMaxima()) {
	            ataquesFallidos++;
	        }
	    }

	    assertEquals(2, ataquesFallidos);  // Debería fallar 2 de cada 4 ataques
	}
	**/
	
	
	
	/**
	 * 

@Test
//Verificamos que el ataque normal hace el daño base (27 puntos), y el ataque potenciado (después de descansar) hace el doble de daño (54 puntos).

public void ataquePotenciado() {
    Reralopes reralopes = new Reralopes();
    Unidad enemigo = new Unidad();  // Ajusta según tu implementación de Unidad

    // Ataque normal
    int saludInicial = enemigo.getSalud();
    reralopes.atacar(enemigo);
    assertEquals(saludInicial - 27, enemigo.getSalud());

    // Potenciar ataques al descansar
    reralopes.descansar();
    
    // Ataque potenciado
    reralopes.atacar(enemigo);
    assertEquals(saludInicial - 27 - 54, enemigo.getSalud());  // 27 (ataque normal) + 54 (ataque potenciado)
}



@Test
//Verificamos que después de 3 ataques potenciados, los ataques vuelven a su valor normal.

public void ataquesPotenciadosSeAgotan() {
    Reralopes reralopes = new Reralopes();
    Unidad enemigo = new Unidad();  // Ajusta según la implementación de Unidad

    reralopes.descansar();  // Gana 3 ataques potenciados
    
    // Primer ataque potenciado
    reralopes.atacar(enemigo);
    assertEquals(2, reralopes.getCantAtaquesPotenciados());

    // Segundo ataque potenciado
    reralopes.atacar(enemigo);
    assertEquals(1, reralopes.getCantAtaquesPotenciados());

    // Tercer ataque potenciado
    reralopes.atacar(enemigo);
    assertEquals(0, reralopes.getCantAtaquesPotenciados());

    // Cuarto ataque (debería ser ataque normal)
    int saludAntesDelUltimoAtaque = enemigo.getSalud();
    reralopes.atacar(enemigo);
    assertEquals(saludAntesDelUltimoAtaque - 27, enemigo.getSalud());  // Debería hacer el daño normal
}
	 */
}