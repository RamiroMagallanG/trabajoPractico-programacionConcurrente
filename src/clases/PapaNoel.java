package clases;

public class PapaNoel {
	private int contadorReno;
	private int contadorDuende;
	private boolean dormido;
	
	//--------------------------
	public void despertar(){
		this.dormido = false;
		if(this.contadorReno==9){
			System.out.println("************************** SANTA CLAUS DESPERTO Y VA A REPARTIR LOS REGALOS.");
			this.contadorReno = 0;
			synchronized(this) {
				notifyAll();// Despertar a todos los hilos que están esperando en este objeto PapaNoel
			}
		} else {
			if(this.contadorDuende == 3){
				System.out.println("************************** SANTA CLAUS DESPERTO Y VA A AYUDAR A LOS DUENDES.");
				this.contadorDuende = 0;
				synchronized(this) {
					notifyAll();// Despertar a todos los hilos que están esperando en este objeto PapaNoel
				}	
			}
		}
		this.dormido = true;
	}
	public synchronized void incrementarRenos(){
		this.contadorReno++;
		System.out.println("Reno vuelve de vacaciones!");
		if(this.contadorReno==9){
			while(!this.dormido){
				try{
					wait(); // Poner en espera a los hilos hasta que sean despertados por el método despertar()
				} catch(InterruptedException e) {
					e.printStackTrace(); // Imprimir información de la excepción
				}
			}
			despertar();
		}
	}
	public synchronized void incrementarDuendes(){
		this.contadorDuende++;
		System.out.println("Duende necesita ayuda!");
		if(this.contadorDuende==3){
			while(!this.dormido){
				try{
					wait();// Poner en espera a los hilos hasta que sean despertados por el método despertar()
				} catch(InterruptedException e) {
					e.printStackTrace(); // Imprimir información de la excepción
				}
			}
			despertar();
		}
	}
	//--------------------------
	public PapaNoel() {
		super();
		this.contadorReno = 0;
		this.contadorDuende = 0;
		this.dormido = true;
	}
	
	public int getContadorReno() {
		return contadorReno;
	}
	public void setContadorReno(int contadorReno) {
		this.contadorReno = contadorReno;
	}

	public int getContadorDuende() {
		return contadorDuende;
	}
	public void setContadorDuende(int contadorDuende) {
		this.contadorDuende = contadorDuende;
	}

	public boolean isDormido() {
		return dormido;
	}
	public void setDormido(boolean dormido) {
		this.dormido = dormido;
	}
}
