package clases;

public class Reno implements Runnable{
	private int numeroReno;
	private PapaNoel duenio;
	
	//--------------------------
	public void run(){
		this.duenio.incrementarRenos(); // Incrementar el contador de renos en PapaNoel
	}
	//--------------------------
	public Reno(int numeroReno, PapaNoel duenio) {
		super();
		this.numeroReno = numeroReno;
		this.duenio = duenio;
	}

	public int getNumeroReno() {
		return numeroReno;
	}
	public void setNumeroReno(int numeroReno) {
		this.numeroReno = numeroReno;
	}

	public PapaNoel getDuenio() {
		return duenio;
	}
	public void setDuenio(PapaNoel duenio) {
		this.duenio = duenio;
	}	
}
