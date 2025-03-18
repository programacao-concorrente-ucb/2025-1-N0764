package contador_com_threads;

public class Incrementador extends Thread {
	private Contador cont;
	public Incrementador(Contador cont) {
		this.cont = cont;
	}
	
	public void run() {
		System.out.println("Executando thread " + this.getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			cont.incrementarValor();
			System.out.println("Incrementou");
	}
	
}
