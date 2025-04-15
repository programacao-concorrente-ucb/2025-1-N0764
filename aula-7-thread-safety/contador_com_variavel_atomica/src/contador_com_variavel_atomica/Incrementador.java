package contador_com_variavel_atomica;

public class Incrementador extends Thread {
	public Contador cont;
	
	public Incrementador(Contador cont) {
		this.cont = cont;
	}
	
	public void run() {
		cont.incrementa();
	}
	
}
