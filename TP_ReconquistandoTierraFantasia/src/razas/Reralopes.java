package razas;

public class Reralopes extends Unidad {
	private int cantAtaquesPotenciados = 0, cantAtaques = 0;

	public Reralopes() {
		nombre = "Reralopes";
		metodoAtaque = "Catapulta";
		saludMaxima = 53;
		salud = 53;
		rangoMin = 5;
		rangoMax = 46;
		ataque = 27;
	}

	public int getCantAtaquesPotenciados() {
		return cantAtaquesPotenciados;
	}

	@Override
	public void recibirAtaque(int danio) {
		super.recibirAtaque(danio);
		cantAtaquesPotenciados = 0;
	}

	@Override
	public void descansar() {
		cantAtaquesPotenciados = 3;
	}

	@Override
	public void atacar(Unidad otro) {
		// Si la cantidad de ataques realizados es 1 o 3, el ataque falla (2 de cada 4
		// veces)
		if (cantAtaques == 1 || cantAtaques == 3) {
			// El ataque falla
			if (cantAtaquesPotenciados != 0) {
				cantAtaquesPotenciados--;
			}
		} else {
			// El ataque acierta
			if (cantAtaquesPotenciados == 0)
				otro.recibirAtaque(ataque);
			else {
				otro.recibirAtaque(ataque * 2);
				cantAtaquesPotenciados--;
			}
		}

		cantAtaques++;
	}

	public void setCantAtaques(int cant) {
		cantAtaques = cant;
	}
}
