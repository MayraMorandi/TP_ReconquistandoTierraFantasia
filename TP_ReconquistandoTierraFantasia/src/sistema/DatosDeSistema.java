package sistema;

public class DatosDeSistema {

	private int[][] mapa;
	private Pueblo[] pueblos;
	private int puebloInicial;
	private int puebloFinal;

	public DatosDeSistema(int[][] mapa, Pueblo[] pueblos, int puebloInicial, int puebloFinal) {
		this.mapa = mapa;
		this.pueblos = pueblos;
		this.puebloInicial = puebloInicial;
		this.puebloFinal = puebloFinal;
	}

	public int[][] getMapa() {
		return mapa;
	}

	public Pueblo[] getPueblos() {
		return pueblos;
	}

	public int getPuebloInicial() {
		return puebloInicial;
	}

	public void setPuebloInicial(int puebloInicial) {
		this.puebloInicial = puebloInicial;
	}

	public int getPuebloFinal() {
		return puebloFinal;
	}

	public void setPuebloFinal(int puebloFinal) {
		this.puebloFinal = puebloFinal;
	}
}
