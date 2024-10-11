package razas;

import static org.junit.Assert.*;

import org.junit.Test;

public class NortaichianTest {

	@Test
	// Ataca normalmente y no se cura
	public void atacarConSaludMaxima() {
		Nortaichian nortaichian = new Nortaichian ();
		Nortaichian enemigo = new Nortaichian() ;
		
		nortaichian.atacar(enemigo);
		
		assertEquals(66, nortaichian.getSalud());
		assertEquals(48, enemigo.getSalud());
	}
	
	@Test
	// Ataca herido, por lo que realiza el doble de danio y se cura un 4% de la vida actual
	public void atacarEnfurecidoHerido() {
		Nortaichian nortaichian = new Nortaichian ();
		Nortaichian enemigo = new Nortaichian() ;
		
		// Se enfurece al recibir danio
		enemigo.atacar(nortaichian);
		nortaichian.atacar(enemigo);
		
		assertEquals(49, nortaichian.getSalud());
		assertEquals(30, enemigo.getSalud());
	}

	@Test
	// Recupera toda la salud al descansar
	public void descansar() {
		Nortaichian nortaichian = new Nortaichian ();

		nortaichian.setSalud(1);
		nortaichian.descansar();
		
		assertEquals(66, nortaichian.getSalud());
	}
	
	@Test
	// No ataca hasta que pasen dos turnos
	public void estadoPiedraAtacar() {
		Nortaichian nortaichian = new Nortaichian ();
		Nortaichian enemigo = new Nortaichian() ;

		// Obtiene dos turnos de estado piedra
		nortaichian.descansar();
		
		nortaichian.atacar(enemigo);
		nortaichian.atacar(enemigo);
		nortaichian.atacar(enemigo);
		
		//realiza un unico ataque
		assertEquals(48, enemigo.getSalud());
	}
	
	@Test
	// Recibe la mitad de danio hasta que pasen dos turnos
	public void estadoPiedraRecibirAtaque() {
		Nortaichian nortaichian = new Nortaichian ();
		Nortaichian enemigo = new Nortaichian() ;

		// Obtiene dos turnos de estado piedra
		nortaichian.descansar();
		
		enemigo.atacar(nortaichian);
		
		// Recibe la mitad de danio
		assertEquals(57, nortaichian.getSalud());
		
		enemigo.atacar(nortaichian);
		
		// Recibe la mitad de danio
		assertEquals(48, nortaichian.getSalud());
		
		enemigo.atacar(nortaichian);
		
		// Recibe danio normalmente
		assertEquals(30, nortaichian.getSalud());
	}
}
