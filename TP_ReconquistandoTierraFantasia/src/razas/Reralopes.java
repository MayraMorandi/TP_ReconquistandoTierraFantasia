package razas;

public class Reralopes extends Unidad {
	private int cantAtaquePotenciado = 0;
	
	public Reralopes () {
		saludMaxima = 53;
		salud = 53;
		rangoMin = 5;
		rangoMax = 46;
		danio = 27;
	}
	
	@Override
	public void recibirDanio (int danio) {
		super.recibirDanio(danio);
		cantAtaquePotenciado = 0;
	}
	
	@Override
	public void descansar () {
		cantAtaquePotenciado = 3;
	}
	
	@Override
	public void atacar (Unidad otro) {
		if(cantAtaquePotenciado == 0)
			otro.recibirDanio(danio);
		else {
			otro.recibirDanio(danio*2);
			cantAtaquePotenciado--;
		}
	}
}
