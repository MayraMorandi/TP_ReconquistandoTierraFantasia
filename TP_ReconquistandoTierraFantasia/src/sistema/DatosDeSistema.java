package sistema;

import java.util.List;

public class DatosDeSistema {
	
	private int[][] mapa;
	private int cantidadPueblos;
	private List<Pueblo> pueblos;
	private int puebloInicial;
	private int puebloFinal;
	
	
	public DatosDeSistema(int[][] mapa, int cantidadPueblos, List<Pueblo> pueblos, int puebloInicial, int puebloFinal) {
		this.mapa = mapa;
		this.cantidadPueblos = cantidadPueblos;
		this.pueblos = pueblos;
		this.puebloInicial = puebloInicial;
		this.puebloFinal = puebloFinal;
	}


	public int[][] getMapa() {
		return mapa;
	}


	public void setMapa(int[][] mapa) {
		this.mapa = mapa;
	}


	public int getCantidadPueblos() {
		return cantidadPueblos;
	}


	public void setCantidadPueblos(int cantidadPueblos) {
		this.cantidadPueblos = cantidadPueblos;
	}


	public List<Pueblo> getPueblos() {
		return pueblos;
	}


	public void setPueblos(List<Pueblo> pueblos) {
		this.pueblos = pueblos;
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
