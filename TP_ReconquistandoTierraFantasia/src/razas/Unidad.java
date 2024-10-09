package razas;

public abstract class Unidad {
	protected int saludMaxima,
				salud,
				rangoMin,
				rangoMax,
				daño;
	protected boolean desmayado = false;
	
	public void recibirDaño (int daño) {
		if(salud > daño)
			salud -= daño;
		else
			desmayado = true;
	}
	
	public abstract void descansar();
	
	public void atacar (Unidad otro) {
		otro.recibirDaño(daño);
	}
}

