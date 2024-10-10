package razas;

import java.util.ArrayList;
import java.util.List;

public class Ejercito {
	private List<Unidad> aliado = new ArrayList<>(),
						propio = new ArrayList<>();

	//crea el ejercito del el pueblo propio
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
	
	//agrega unidades de los pueblos aliados
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
	
	//devuelve la primera unidad aliada, 
	//si no hay unidades aliadas, devuelve la primera unidad propia
	public Unidad primeroFormado() {
		if(this.sinEjercitoAliado())
			return propio.get(0);
		
		return aliado.get(0);
	}
	
	//la primera unidad del ejercito ataca al otro ejercito
	public void atacar(Ejercito otro) {
		otro.recibirAtaque(this.primeroFormado().getAtaque());
	}
	
	//la primera unidad recibe danio
	//si la unidad se desmaya, la remueve del ejercito
	public void recibirAtaque(int danio) {
		this.primeroFormado().recibirAtaque(danio);
		
		if(this.primeroFormado().isDesmayado()) {
			if(this.sinEjercitoAliado())
				propio.remove(0);
			else
				aliado.remove(0);
		}
	}
	
	//devuelve la cantidad de unidades totales del ejercito
	public int cantidadGuerrerosVivos() {
		return aliado.size() + propio.size();
	}
	
	//cada unidad del ejercito descansa
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
	
	//mientras haya unidades, el ejercito ataca al otro ejercito y viceversa
	//devuelve false si el ejercito propio perdio
	//devuelve true si gano
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
	
	//devuelve si el ejercito propio no tiene unidades
	public boolean sinEjercitoPropio () {
		return  this.propio.isEmpty();
	}
	
	//devuelve si el ejercito aliado no tiene unidades
	public boolean sinEjercitoAliado () {
		return this.aliado.isEmpty();
	}
}
