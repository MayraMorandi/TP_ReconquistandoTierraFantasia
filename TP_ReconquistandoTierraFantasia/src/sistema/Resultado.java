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

    // Setters
    public void setFactible(boolean factible) {
        this.factible = factible;
    }

    public void setCantidadGuerrerosVivos(int cantidadGuerrerosVivos) {
        this.cantidadGuerrerosVivos = cantidadGuerrerosVivos;
    }

    public void setTiempoTranscurrido(int tiempoTranscurrido) {
        this.tiempoTranscurrido = tiempoTranscurrido;
    }
}
