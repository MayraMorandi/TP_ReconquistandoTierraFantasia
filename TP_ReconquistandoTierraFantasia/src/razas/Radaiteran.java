package razas;

public class Radaiteran extends Unidad {
	private int cantAtaques = 0;
	
	public Radaiteran () {
		nombre = "Radaiteran";
		metodoAtaque = "Shurikens";
		saludMaxima = 36;
		salud = 36;
		rangoMin = 17;
		rangoMax = 41;
		ataque = 56;
	}
	
	@Override
	public void descansar() {};
	
	@Override
	public void atacar (Unidad otro) {
		otro.recibirAtaque(ataque + 3 * cantAtaques);
		cantAtaques++;
	}
}