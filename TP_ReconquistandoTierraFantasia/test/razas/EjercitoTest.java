package razas;

import static org.junit.Assert.*;

import org.junit.Test;

public class EjercitoTest {

	@Test
	//inicializo el ejercito con una unidad cada raza
	public void constructorEjercitoPropio() {
		Ejercito ejercito = new Ejercito("Wrives", 1);
		
		assertEquals("Wrives", ejercito.primeroFormado().getNombre());
		
		Ejercito ejercito0 = new Ejercito("Reralopes", 1);
		
		assertEquals("Reralopes", ejercito0.primeroFormado().getNombre());
		
		Ejercito ejercito1 = new Ejercito("Radaiteran", 1);
		
		assertEquals("Radaiteran", ejercito1.primeroFormado().getNombre());
		
		Ejercito ejercito2 = new Ejercito("Nortaichian", 1);
		
		assertEquals("Nortaichian", ejercito2.primeroFormado().getNombre());
	}
	
	@Test
	//Devuelve la primera unidad agregada al ejercito aliado
	//En caso de que no haya, devuelve el primero del ejercito propio
	public void primeroFormado() {
		Ejercito ejercito = new Ejercito("Wrives", 1);

		assertEquals("Wrives", ejercito.primeroFormado().getNombre());
		
		ejercito.agregarGuerreros("Reralopes", 1);
		ejercito.agregarGuerreros("Radaiteran", 1);
		
		assertEquals("Reralopes", ejercito.primeroFormado().getNombre());
	}

	@Test
	//Agrego una unidad de cada raza al ejercito aliado
	public void constructorEjercitoAliado() {
		Ejercito ejercito = new Ejercito("Wrives", 1);
		ejercito.agregarGuerreros("Wrives", 1);
		assertEquals("Wrives", ejercito.primeroFormado().getNombre());
		
		Ejercito ejercito0 = new Ejercito("Reralopes", 1);
		ejercito0.agregarGuerreros("Reralopes", 1);
		assertEquals("Reralopes", ejercito0.primeroFormado().getNombre());
		
		Ejercito ejercito1 = new Ejercito("Radaiteran", 1);
		ejercito1.agregarGuerreros("Radaiteran", 1);
		assertEquals("Radaiteran", ejercito1.primeroFormado().getNombre());
		
		Ejercito ejercito2 = new Ejercito("Nortaichian", 1);
		ejercito2.agregarGuerreros("Nortaichian", 1);
		assertEquals("Nortaichian", ejercito2.primeroFormado().getNombre());
	}
	
	@Test
	//La primera unidad formada del ejercito ataca a la primera unidad formada del otro ejercito
	//hasta que uno de los ejercitos no tenga unidades
	//si el ejercito que llama al metodo pierde, devuelve false, si gana, devuelve true
	public void batalla() {
		Ejercito ejercito = new Ejercito("Wrives", 1);
		Ejercito enemigo = new Ejercito("Radaiteran", 10);
		boolean resultado;
		
		resultado = ejercito.batalla(enemigo);
		
		assertFalse(resultado);
		
		Ejercito ejercito0 = new Ejercito("Radaiteran", 50);
		
		resultado = ejercito0.batalla(enemigo);
		
		assertTrue(resultado);
	}
	
	@Test
	//Devuelve la cantidad total de unidades del ejercito
	public void cantidadGuerrerosVivos() {
		Ejercito ejercito = new Ejercito("Wrives", 50);
		ejercito.agregarGuerreros("Reralopes", 50);
		
		assertEquals(100, ejercito.cantidadGuerrerosVivos());
	}
	
	@Test
	//La ultima unidad en recibir danio queda al final del ejercito
	public void reorganizar() {
		Ejercito ejercito = new Ejercito("Wrives", 5);
		
		Ejercito enemigo = new Ejercito("Nortaichian", 1);
		
		ejercito.batalla(enemigo);
		
		assertEquals(72, ejercito.primeroFormado().getSalud());
		
		ejercito.reorganizar();
		
		assertEquals(108, ejercito.primeroFormado().getSalud());
	}
}
