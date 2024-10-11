package razas;

public class Reralopes extends Unidad {
	private int cantAtaquesPotenciados = 0,
			cantAtaques = 0;
	
	public Reralopes () {
		nombre = "Reralopes";
		metodoAtaque = "Catapulta";
		saludMaxima = 53;
		salud = 53;
		rangoMin = 5;
		rangoMax = 46;
		ataque = 27;
<<<<<<< Updated upstream
=======
	}
	
	public int getCantAtaquesPotenciados () {
		return cantAtaquesPotenciados;
>>>>>>> Stashed changes
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
<<<<<<< HEAD
		// Si la cantidad de ataques realizados es 1 o 3, el ataque falla (2 de cada 4 veces)
        if (cantAtaques == 1 || cantAtaques == 3) {
=======
		Random random = new Random();
		
<<<<<<< Updated upstream
		// Generar un n�mero entre 0 y 3 (4 posibles valores)
        int resultado = random.nextInt(4);

        // Si el n�mero es 0 o 1, el ataque falla (2 de cada 4 veces)
=======
		// Se genera un numero entre 0 y 3 (4 posibles valores)
        int resultado = random.nextInt(4);

        // Si el numero es 0 o 1, el ataque falla (2 de cada 4 veces)
>>>>>>> Stashed changes
        if (resultado == 0 || resultado == 1) {
>>>>>>> 3edf59be4b9a99f94f63b4c1cab814bb1826e806
            // El ataque falla
        	if(cantAtaquesPotenciados != 0) {
        		cantAtaquesPotenciados--;
        	}
        } else {
            // El ataque acierta
        	if(cantAtaquesPotenciados == 0)
    			otro.recibirAtaque(ataque);
    		else {
    			otro.recibirAtaque(ataque*2);
    			cantAtaquesPotenciados--;
    		}
        }
        
        cantAtaques++;
	}
	
	public void setCantAtaques (int cant) {
		cantAtaques = cant;
	}
}
