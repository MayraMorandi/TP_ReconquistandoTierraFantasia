package razas;

import static org.junit.Assert.*;

import org.junit.Test;

public class RadaiteranTest {

	@Test
	// Cada vez que ataca hace 3 más de danio
	public void atacar() {
		Radaiteran radaiteran = new Radaiteran();
		Nortaichian enemigo = new Nortaichian();
		int saludActual;

		enemigo.setSalud(1000);

		saludActual = enemigo.getSalud();

		radaiteran.atacar(enemigo);

		assertEquals(saludActual - 56, enemigo.getSalud());

		saludActual = enemigo.getSalud();

		radaiteran.atacar(enemigo);

		assertEquals(saludActual - 59, enemigo.getSalud());

		saludActual = enemigo.getSalud();

		radaiteran.atacar(enemigo);

		assertEquals(saludActual - 62, enemigo.getSalud());
	}

}
