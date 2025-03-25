package contador_com_monitor;

public class Incrementador extends Thread {

	private Contador cont;
	public Incrementador(Contador cont) {
		this.cont = cont;
	}
	
	public void run() {
		System.out.println("Thread " + this.getName() + " começou a execução");
		cont.incrementarValor();
		System.out.println("Thread " + this.getName() + " finalizou execução");

	}
	
}