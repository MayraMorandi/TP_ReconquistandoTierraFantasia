package razas;

public class Wrives extends Unidad {
	
	private int ataquesRealizados = 0;
	
	public Wrives () {
		saludMaxima = 108;
		salud = 108;
		rangoMin = 14;
		rangoMax = 28;
		danio = 113;
	}
	
	@Override
	public void recibirDanio (int danio) {
		super.recibirDanio(danio*2);
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
				otro.recibirDanio(danio);
			else {
				otro.recibirDanio(danio*2);
				ataquesRealizados = 0;
			}
			
			ataquesRealizados++;
		}
	}
}
