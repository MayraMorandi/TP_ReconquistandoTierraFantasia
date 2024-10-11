package razas;

import java.util.ArrayList;
import java.util.List;

public class Ejercito {
	private List<Unidad> aliado = new ArrayList<>(),
						propio = new ArrayList<>();

<<<<<<< Updated upstream
	//crea el ejercito del el pueblo propio
=======
	//Se crea el ejercito del el pueblo propio
>>>>>>> Stashed changes
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
	
<<<<<<< Updated upstream
	//agrega unidades de los pueblos aliados
=======
	//Se agregan unidades de los pueblos aliados
>>>>>>> Stashed changes
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
	
<<<<<<< Updated upstream
	//devuelve la primera unidad aliada, 
	//si no hay unidades aliadas, devuelve la primera unidad propia
=======
	//Se devuelve la primera unidad aliada, 
	//Si no hay unidades aliadas, devuelve la primera unidad propia
>>>>>>> Stashed changes
	public Unidad primeroFormado() {
		if(this.sinEjercitoAliado())
			return propio.get(0);
		
		return aliado.get(0);
	}
	
<<<<<<< Updated upstream
	//la primera unidad del ejercito ataca al otro ejercito
	public void atacar(Ejercito otro) {
		otro.recibirAtaque(this.primeroFormado().getAtaque());
	}
	
	//la primera unidad recibe danio
	//si la unidad se desmaya, la remueve del ejercito
	public void recibirAtaque(int danio) {
		this.primeroFormado().recibirAtaque(danio);
		
=======
	//La primera unidad del ejercito ataca al otro ejercito
<<<<<<< HEAD
	private void atacar(Ejercito otro) {
		this.primeroFormado().atacar(otro.primeroFormado());
		otro.recibirAtaque();
=======
	public void atacar(Ejercito otro) {
		otro.recibirAtaque(this.primeroFormado().getAtaque());
>>>>>>> 3edf59be4b9a99f94f63b4c1cab814bb1826e806
	}
	
	//La primera unidad recibe danio
	//Si la unidad se desmaya, la remueve del ejercito
<<<<<<< HEAD
	private void recibirAtaque() {
=======
	public void recibirAtaque(int danio) {
		this.primeroFormado().recibirAtaque(danio);
		
>>>>>>> 3edf59be4b9a99f94f63b4c1cab814bb1826e806
>>>>>>> Stashed changes
		if(this.primeroFormado().isDesmayado()) {
			if(this.sinEjercitoAliado())
				propio.remove(0);
			else
				aliado.remove(0);
		}
<<<<<<< Updated upstream
	}
	
	//devuelve la cantidad de unidades totales del ejercito
	public int cantidadGuerrerosVivos() {
		return aliado.size() + propio.size();
	}
	
	//cada unidad del ejercito descansa
=======
	}
	
	//Se devuelve la cantidad de unidades totales del ejercito
	public int cantidadGuerrerosVivos() {
		return aliado.size() + propio.size();
	}
	
	//Cada unidad del ejercito descansa
>>>>>>> Stashed changes
	public void descansar() {
		for(Unidad u : aliado) {
			u.descansar();
		}
	}
	
	public void reorganizar () {
		Unidad aux;
		
		if(aliado.isEmpty()) {
			aux = propio.remove(0);
<<<<<<< Updated upstream
			propio.addLast(aux);;
		}
		else {
			aux = aliado.remove(0);
			aliado.addLast(aux);
		}
	}
	
	//mientras haya unidades, el ejercito ataca al otro ejercito y viceversa
=======
			propio.add(aux);;
		}
		else {
			aux = aliado.remove(0);
			aliado.add(aux);
		}
	}
	
	//Mientras haya unidades, el ejercito ataca al otro ejercito y viceversa
>>>>>>> Stashed changes
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
	
<<<<<<< Updated upstream
	//devuelve si el ejercito propio no tiene unidades
=======
	//Devuelve si el ejercito propio no tiene unidades
>>>>>>> Stashed changes
	public boolean sinEjercitoPropio () {
		return  this.propio.isEmpty();
	}
	
<<<<<<< Updated upstream
	//devuelve si el ejercito aliado no tiene unidades
=======
	//Devuelve si el ejercito aliado no tiene unidades
>>>>>>> Stashed changes
	public boolean sinEjercitoAliado () {
		return this.aliado.isEmpty();
	}
}
