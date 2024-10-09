package razas;

public class Reralopes extends Unidad {
	private int cantAtaquePotenciado = 0;
	
	public Reralopes () {
		saludMaxima = 53;
		salud = 53;
		rangoMin = 5;
		rangoMax = 46;
		daño = 27;
	}
	
	@Override
	public void recibirDaño (int daño) {
		super.recibirDaño(daño);
		cantAtaquePotenciado = 0;
	}
	
	@Override
	public void descansar () {
		cantAtaquePotenciado = 3;
	}
	
	@Override
	public void atacar (Unidad otro) {
		if(cantAtaquePotenciado == 0)
			otro.recibirDaño(daño);
		else {
			otro.recibirDaño(daño*2);
			cantAtaquePotenciado--;
		}
	}
}
