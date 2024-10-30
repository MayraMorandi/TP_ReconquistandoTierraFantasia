package sistema;

public class Pueblo {

	private int cantidadGuerreros;
	private String raza;
	private String condicion;

	public Pueblo(int cantidadGuerreros, String raza, String condicion) {
		this.cantidadGuerreros = cantidadGuerreros;
		this.raza = raza;
		this.condicion = condicion;
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
