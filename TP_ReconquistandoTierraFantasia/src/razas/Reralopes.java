package razas;

import java.util.Random;

public class Reralopes extends Unidad {
	private int cantAtaquesPotenciados = 0;
	
	public Reralopes (boolean aliado) {
		nombre = "Reralopes";
		metodoAtaque = "Catapulta";
		saludMaxima = 53;
		salud = 53;
		rangoMin = 5;
		rangoMax = 46;
		ataque = 27;
		this.aliado = aliado;
	}
	
	@Override
	public void recibirAtaque (int danio) {
		super.recibirAtaque(danio);
		cantAtaquesPotenciados = 0;
	}
	
	@Override
	public void descansar () {
		cantAtaquesPotenciados = 3;
	}
	
	@Override
	public void atacar (Unidad otro) {
		Random random = new Random();
		
		// Generar un número entre 0 y 3 (4 posibles valores)
        int resultado = random.nextInt(4);

        // Si el número es 0 o 1, el ataque falla (2 de cada 4 veces)
        if (resultado == 0 || resultado == 1) {
            // El ataque falla
        } else {
            // El ataque acierta
        	if(cantAtaquesPotenciados == 0)
    			otro.recibirAtaque(ataque);
    		else {
    			otro.recibirAtaque(ataque*2);
    			cantAtaquesPotenciados--;
    		}
        }
        
		
	}
}
