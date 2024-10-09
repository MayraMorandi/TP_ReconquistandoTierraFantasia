package razas;

public class Wrives extends Unidad {
	//
	private int ataquesRealizados = 0;
	
	public Wrives () {
		saludMaxima = 108;
		salud = 108;
		rangoMin = 14;
		rangoMax = 28;
		daño = 113;
	}
	
	@Override
	public void recibirDaño (int daño) {
		super.recibirDaño(daño*2);
	}
	
	@Override
	public void descansar () {
		salud += 50;
		saludMaxima += 50;
	}
	
	@Override
	public void atacar (Unidad otro) {
		if(salud < saludMaxima) {
			if(ataquesRealizados < 2)
				otro.recibirDaño(daño);
			else {
				otro.recibirDaño(daño*2);
				ataquesRealizados = 0;
			}
			
			ataquesRealizados++;
		}
	}
}
