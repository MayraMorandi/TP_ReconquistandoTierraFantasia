package razas;

import java.util.ArrayList;
import java.util.List;

public class Ejercito {

	private String nombre;
	private List<Unidad> unidades;

	public Ejercito(String raza, int cantidadSoldados, boolean aliado) {
		nombre = "Ejercito de " + raza;

		List<Unidad> unidades = new ArrayList<>();

		for (int i = 0; i < cantidadSoldados; i++) {
			switch (raza) {
			case "Wrives":
				unidades.add(new Wrives(aliado));
				break;
			case "Reralopes":
				unidades.add(new Reralopes(aliado));
				break;
			case "Radaiteran":
				unidades.add(new Radaiteran(aliado));
				break;
			case "Nortaichian":
				unidades.add(new Nortaichian(aliado));
				break;
			default:
				break;
			}
		}
	}
	
	public void agregarGuerreros(String raza, int cantidadSoldados) {

		for (int i = 0; i < cantidadSoldados; i++) {
			switch (raza) {
			case "Wrives":
				unidades.add(new Wrives(true));
				break;
			case "Reralopes":
				unidades.add(new Reralopes(true));
				break;
			case "Radaiteran":
				unidades.add(new Radaiteran(true));
				break;
			case "Nortaichian":
				unidades.add(new Nortaichian(true));
				break;
			default:
				break;
			}
		}
	}
	
	public Unidad primeroFormado() {
		return unidades.get(0);
	}
	
	public void atacar(Ejercito ejercito) {
		
		if(this.primeroFormado().isDesmayado()) {
			//Ordenar array
		}
		
		ejercito.recibirAtaque(this.primeroFormado().getAtaque());
	}
	
	public void recibirAtaque(int danio) {
		
		if(this.primeroFormado().isDesmayado()) {
			//Ordenar array
		}
		
		this.primeroFormado().recibirAtaque(danio);
	}
	
	public int cantidadGuerrerosVivos() {
		int cantidadGuerrerosVivos = 0;
		
		for (int i = 0; i < unidades.size(); i++) {
			if(!unidades.get(i).isDesmayado()) {
				cantidadGuerrerosVivos++;
			}
				
		}
		return cantidadGuerrerosVivos;
	}
	
	public void descansar() {
		for (int i = 0; i < unidades.size(); i++) {
			unidades.get(i).descansar();
		}
	}

}
