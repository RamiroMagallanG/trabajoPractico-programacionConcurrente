package clases;

public class Duende implements Runnable{
	private int numeroDuende;
	private PapaNoel duenio; 

	//--------------------------
	public void run(){
		this.duenio.incrementarDuendes(); // Incrementar el contador de duendes en PapaNoel
	}
	//--------------------------
	public Duende(int numeroDuende, PapaNoel duenio) {
		super();
		this.numeroDuende = numeroDuende;
		this.duenio = duenio;
	}

	public int getNumeroDuende() {
		return numeroDuende;
	}
	public void setNumeroDuende(int numeroDuende) {
		this.numeroDuende = numeroDuende;
	}

	public PapaNoel getDuenio() {
		return duenio;
	}
	public void setDuenio(PapaNoel duenio) {
		this.duenio = duenio;
	}
}
