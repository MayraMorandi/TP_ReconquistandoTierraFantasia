package razas;

public class Radaiteran extends Unidad {
	private int cantAtaques = 0;
	
	public Radaiteran () {
		saludMaxima = 36;
		salud = 36;
		rangoMin = 17;
		rangoMax = 41;
		daño = 56;
	}
	
	@Override
	public void descansar() {};
	
	@Override
	public void atacar (Unidad otro) {
		otro.recibirDaño(daño + 3 * cantAtaques);
		cantAtaques++;
	}
}