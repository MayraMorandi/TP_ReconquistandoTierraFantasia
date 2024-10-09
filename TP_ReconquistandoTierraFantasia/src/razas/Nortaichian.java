package razas;

public class Nortaichian extends Unidad {
	private int enfurecido = 0,
				estadoPiedra = 0;
	
	public Nortaichian () {
		saludMaxima = 66;
		salud = 66;
		rangoMin = 16;
		rangoMax = 22;
		daño = 18;
	}

	@Override
	public void recibirDaño (int daño) {
		if(estadoPiedra == 0)
			super.recibirDaño(daño);
		else {
			super.recibirDaño(daño/2);
			estadoPiedra--;
		}
			
		enfurecido = 2;
	}
	
	@Override
	public void descansar () {
		salud = saludMaxima;
		estadoPiedra = 2;
	}
	
	@Override
	public void atacar (Unidad otro) {
		if(estadoPiedra == 0) {
			if(enfurecido == 0)
				otro.recibirDaño(daño);
			else {
				otro.recibirDaño(daño*2);
				enfurecido--;
			}
			
			salud += salud * 4 / 100;
			
			if(salud > saludMaxima)
				salud = saludMaxima;
		}
		else
			estadoPiedra--;
	}
}
