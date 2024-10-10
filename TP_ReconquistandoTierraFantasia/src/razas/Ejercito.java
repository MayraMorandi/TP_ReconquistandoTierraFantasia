package razas;

import java.util.ArrayList;
import java.util.List;

public class Ejercito {
	private List<Unidad> aliado = new ArrayList<>(),
						propio = new ArrayList<>();

	public Ejercito(String raza, int cantidadSoldados) {
		for (int i = 0; i < cantidadSoldados; i++) {
			switch (raza) {
			case "Wrives":
				propio.add(new Wrives());
				break;
			case "Reralopes":
				propio.add(new Reralopes());
				break;
			case "Radaiteran":
				propio.add(new Radaiteran());
				break;
			case "Nortaichian":
				propio.add(new Nortaichian());
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
				aliado.add(new Wrives());
				break;
			case "Reralopes":
				aliado.add(new Reralopes());
				break;
			case "Radaiteran":
				aliado.add(new Radaiteran());
				break;
			case "Nortaichian":
				aliado.add(new Nortaichian());
				break;
			default:
				break;
			}
		}
	}
	
	public Unidad primeroFormado() {
		if(this.sinEjercitoAliado())
			return propio.get(0);
		
		return aliado.get(0);
	}
	
	public void atacar(Ejercito ejercito) {
		ejercito.recibirAtaque(this.primeroFormado().getAtaque());
	}
	
	public void recibirAtaque(int danio) {
		this.primeroFormado().recibirAtaque(danio);
		
		if(this.primeroFormado().isDesmayado()) {
			if(this.sinEjercitoAliado())
				propio.remove(0);
			else
				aliado.remove(0);
		}
	}
	
	public int cantidadGuerrerosVivos() {
		return aliado.size() + propio.size();
	}
	
	public void descansar() {
		for(Unidad u : aliado) {
			u.descansar();
		}
	}
	
	public void reorganizar () {
		Unidad aux;
		
		if(aliado.isEmpty()) {
			aux = propio.remove(0);
			propio.addLast(aux);;
		}
		else {
			aux = aliado.remove(0);
			aliado.addLast(aux);
		}
	}
	
	public boolean batalla (Ejercito otro) {
		while(!this.sinEjercitoPropio()) {
			this.atacar(otro);
			
			if(!otro.sinEjercitoPropio())
				otro.atacar(this);
			else
				break;
		}
		
		if(this.sinEjercitoPropio())
			return false;
		
		return true;
	}
	
	public boolean sinEjercitoPropio () {
		return  this.propio.isEmpty();
	}
	
	public boolean sinEjercitoAliado () {
		return this.aliado.isEmpty();
	}
}
