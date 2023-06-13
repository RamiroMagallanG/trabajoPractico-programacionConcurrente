package clases;

public class Controlador {
	private Duende[] duendes = new Duende[9];
	private Reno[] renos = new Reno[9];
	private PapaNoel pN = new PapaNoel();
	private int numeroReno = -1;
	private int numeroDuende = -1;
	private int numeroAleatorio = -1;
	
	public void controlador(){
		for(int indice = 1; indice<10; indice++){
			duendes[indice-1] = new Duende(indice, pN);
			renos[indice-1] = new Reno(indice, pN);
		}
		
		for(int indice = 0; indice<100; indice++){
			numeroAleatorio = (int) (Math.random() * 10) + 1;
			if(numeroAleatorio%2 == 0){
				numeroReno = (int) (Math.random() * 8);
				Thread hiloReno = new Thread(renos[numeroReno]);
				hiloReno.start();
			} else {
				numeroDuende = (int) (Math.random() * 2);
				Thread hiloDuende = new Thread(duendes[numeroDuende]);
				hiloDuende.start();
			}
		}
	}
}
