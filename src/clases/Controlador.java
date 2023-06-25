package clases;

public class Controlador {
	private Duende[] duendes = new Duende[9]; // Arreglo para almacenar los duendes
	private Reno[] renos = new Reno[9]; // Arreglo para almacenar los renos
	private PapaNoel pN = new PapaNoel(); // Instancia de PapaNoel
	private int numeroReno = -1;
	private int numeroDuende = -1;
	private int numeroAleatorio = -1;
	
	public void controlador(){
		for(int indice = 1; indice<10; indice++){
			duendes[indice-1] = new Duende(indice, pN); // Crear duendes y asignarles una instancia de PapaNoel
			renos[indice-1] = new Reno(indice, pN); // Crear renos y asignarles una instancia de PapaNoel
		}
		
		for(int indice = 0; indice<100; indice++){
			numeroAleatorio = (int) (Math.random() * 9); // Generar un número aleatorio entre 0 y 8 (incluyendo ambos)
			if(numeroAleatorio%2 == 0){
				numeroReno = (int) (Math.random() * 8);
				Thread hiloReno = new Thread(renos[numeroReno]);
				hiloReno.start();// Iniciar un hilo para el reno
			} else {
				numeroDuende = (int) (Math.random() * 2);
				Thread hiloDuende = new Thread(duendes[numeroDuende]);
				hiloDuende.start();// Iniciar un hilo para el duende
			}
		}
	}
}
