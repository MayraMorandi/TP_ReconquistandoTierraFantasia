package sistema;

public class Resultado {
	
	
	private int cantidadGuerreros;
	private String raza;
	private String condicion;
	
	public Resultado(int cantidadGuerreros, String raza, String condicion) {
		this.cantidadGuerreros = cantidadGuerreros;
		this.raza = raza;
		this.condicion = condicion;
	}
	
	
	// Getters
    public int getCantidadGuerreros() {
        return cantidadGuerreros;
    }

    public int getRaza() {
        return raza;
    }

    public int getCondicion() {
        return condicion;
    }

    // Setters
    public void setCantidadGuerreros(int cantidadGuerreros) {
        this.cantidadGuerreros = cantidadGuerreros;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }
}
