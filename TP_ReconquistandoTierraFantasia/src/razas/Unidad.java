package razas;

public abstract class Unidad {
	protected String nombre;
	protected String metodoAtaque;
	protected int saludMaxima, salud, rangoMin, rangoMax, ataque;
	protected boolean desmayado = false;

	public void recibirAtaque(int danio) {
		if (salud > danio)
			salud -= danio;
		else
			desmayarse();
	}

	public abstract void descansar();

	public void atacar(Unidad otro) {
		otro.recibirAtaque(ataque);
	}

	private void desmayarse() {
		desmayado = true;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMetodoAtaque() {
		return metodoAtaque;
	}

	public int getSaludMaxima() {
		return saludMaxima;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getRangoMin() {
		return rangoMin;
	}

	public int getRangoMax() {
		return rangoMax;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public boolean isDesmayado() {
		return desmayado;
	}
}
