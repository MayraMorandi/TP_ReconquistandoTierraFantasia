package sistema;

public class Pueblo {

	private int id;
	private int cantidadGuerreros;
	private String raza;
	private String condicion;

	public Pueblo(int id, int cantidadGuerreros, String raza, String condicion) {
		this.id = id;
		this.cantidadGuerreros = cantidadGuerreros;
		this.raza = raza;
		this.condicion = condicion;
	}

	// Getters
	public int getId() {
		return id;
	}

	public int getCantidadGuerreros() {
		return cantidadGuerreros;
	}

	public String getRaza() {
		return raza;
	}

	public String getCondicion() {
		return condicion;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setCantidadGuerreros(int cantidadGuerreros) {
		this.cantidadGuerreros = cantidadGuerreros;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
}
