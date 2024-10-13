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
    
    public void getResultado() {
    	if(factible) {
    		System.out.println("Esta misión es factible!");
    		System.out.println("Cantidad de guerreros vivos: " + cantidadGuerrerosVivos + " guerreros");
    		System.out.println("Tiempo transcurrido: " + tiempoTranscurrido + " días");
    	}
    	else
    		System.out.println("Esta misión NO es factible!");
    }
}
