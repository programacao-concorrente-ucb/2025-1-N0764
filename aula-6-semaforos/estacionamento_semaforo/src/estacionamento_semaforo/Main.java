package estacionamento_semaforo;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(10);
		System.out.println("Núm. de vagas livres: " + semaforo.availablePermits());

		for(int i = 0; i < 20;i++) {
			new Carro("Carro " + (i+1), semaforo).start();
		}
	}

}
