package razas;

public abstract class Unidad {
	protected int saludMaxima,
				salud,
				rangoMin,
				rangoMax,
				danio;
	protected boolean desmayado = false;
	
	public void anio (int danio) {
		if(salud > danio)
			salud -= danio;
		else
			desmayado = true;
	}
	
	public abstract void descansar();
	
	public void atacar (Unidad otro) {
		otro.recibirDanio(danio);
	}

	public void recibirDanio(int danio) {
		
	}
}

