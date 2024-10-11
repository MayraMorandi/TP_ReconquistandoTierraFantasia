package razas;

import java.util.ArrayList;
import java.util.List;

public class Ejercito {
	private List<Unidad> aliado = new ArrayList<>(),
						propio = new ArrayList<>();

	//Se crea el ejercito del el pueblo propio
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
	
	//Se agregan unidades de los pueblos aliados
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
	
	//Se devuelve la primera unidad aliada, 
	//Si no hay unidades aliadas, devuelve la primera unidad propia
	public Unidad primeroFormado() {
		if(this.sinEjercitoAliado())
			return propio.get(0);
		
		return aliado.get(0);
	}
	
	//La primera unidad del ejercito ataca al otro ejercito
	private void atacar(Ejercito otro) {
		this.primeroFormado().atacar(otro.primeroFormado());
		otro.recibirAtaque();
	}
	
	//La primera unidad recibe danio
	//Si la unidad se desmaya, la remueve del ejercito
	private void recibirAtaque() {
		if(this.primeroFormado().isDesmayado()) {
			if(this.sinEjercitoAliado())
				propio.remove(0);
			else
				aliado.remove(0);
		}
	}
	
	//Se devuelve la cantidad de unidades totales del ejercito
	public int cantidadGuerrerosVivos() {
		return aliado.size() + propio.size();
	}
	
	//Cada unidad del ejercito descansa
	public void descansar() {
		for(Unidad u : aliado) {
			u.descansar();
		}
	}
	
	public void reorganizar () {
		Unidad aux;
		
		if(aliado.isEmpty()) {
			aux = propio.remove(0);
			propio.add(aux);;
		}
		else {
			aux = aliado.remove(0);
			aliado.add(aux);
		}
	}
	
	//Mientras haya unidades, el ejercito ataca al otro ejercito y viceversa
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
	
	//Devuelve si el ejercito propio no tiene unidades
	public boolean sinEjercitoPropio () {
		return  this.propio.isEmpty();
	}
	
	//Devuelve si el ejercito aliado no tiene unidades
	public boolean sinEjercitoAliado () {
		return this.aliado.isEmpty();
	}
}
