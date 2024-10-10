package sistema;

public class Resultado {
	
	
	private boolean factible;
	private int cantidadGuerrerosVivos;
	private int tiempoTranscurrido;
	
	public Resultado(boolean factible, int cantidadGuerrerosVivos, int tiempoTranscurrido) {
		this.factible = factible;
		this.cantidadGuerrerosVivos = cantidadGuerrerosVivos;
		this.tiempoTranscurrido = tiempoTranscurrido;
	}
	
	
	// Getters
    public boolean isFactible() {
        return factible;
    }

    public int getCantidadGuerrerosVivos() {
        return cantidadGuerrerosVivos;
    }

    public int getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }
}
