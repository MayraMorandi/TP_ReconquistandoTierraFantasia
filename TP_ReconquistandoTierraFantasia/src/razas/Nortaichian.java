package razas;

public class Nortaichian extends Unidad {
	private int enfurecido = 0,
				estadoPiedra = 0;
	
	public Nortaichian () {
		saludMaxima = 66;
		salud = 66;
		rangoMin = 16;
		rangoMax = 22;
		danio = 18;
	}

	@Override
	public void recibirDanio (int danio) {
		if(estadoPiedra == 0)
			super.recibirDanio(danio);
		else {
			super.recibirDanio(danio/2);
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
				otro.recibirDanio(danio);
			else {
				otro.recibirDanio(danio*2);
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
