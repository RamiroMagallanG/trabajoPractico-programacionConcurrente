package clases;

public class PapaNoel {
	private int contadorReno;
	private int contadorDuende;
	private boolean dormido;
	
	//--------------------------
	public void despertar(){
		this.dormido = false;
		if(this.contadorReno==9){
			System.out.println("REPARTIR REGALOS.");
			this.contadorReno = 0;
			notifyAll();
		} else {
			if(this.contadorDuende == 3){
				System.out.println("AYUDAR DUENDE.");
				this.contadorDuende = 0;
				notifyAll();
			}
		}
		this.dormido = true;
	}
	public synchronized void incrementarRenos(){
		this.contadorReno++;
		if(this.contadorReno==9){
			while(!this.dormido){
				try{
					wait();
				} catch(InterruptedException e) {
					e.toString();
				}
			}
			despertar();
		}
	}
	public synchronized void incrementarDuendes(){
		this.contadorDuende++;
		if(this.contadorDuende==3){
			while(!this.dormido){
				try{
					wait();
				} catch(InterruptedException e) {
					e.toString();
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

	public boolean isdormido() {
		return dormido;
	}
	public void setdormido(boolean dormido) {
		this.dormido = dormido;
	}
}
