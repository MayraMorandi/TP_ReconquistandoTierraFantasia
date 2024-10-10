package razas;

public class Wrives extends Unidad {

	private int ataquesRealizados = 0;
	private boolean fueAtacado = false;

	public Wrives() {
		nombre = "Wrives";
		metodoAtaque = "Magia";
		saludMaxima = 108;
		salud = 108;
		rangoMin = 14;
		rangoMax = 28;
		ataque = 113;
	}

	@Override
	public void recibirAtaque(int danio) {
		super.recibirAtaque(danio * 2);
		fueAtacado = true;
	}

	@Override
	public void descansar() {
		salud += 50;
		saludMaxima += 50;
		fueAtacado = false;
	}

	@Override
	public void atacar(Unidad otro) {
		if (fueAtacado) {
				if (ataquesRealizados < 2) {
					otro.recibirAtaque(ataque);
				} else {
					otro.recibirAtaque(ataque * 2);
					ataquesRealizados = 0;
				}

				ataquesRealizados++;
		}
	}
}
