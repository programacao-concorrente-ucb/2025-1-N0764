package estacionamento_semaforo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Carro extends Thread {
	private Semaphore semaforo;
	
	public Carro(String name, Semaphore semaforo) {
		this.setName(name);
		this.semaforo = semaforo;
	}
	
	public void run() {
		try {
			semaforo.acquire();
			System.out.println(this.getName() + " entrou no estacionamento.");
			Thread.sleep(ThreadLocalRandom.current().nextInt(4000, 10000));
			System.out.println(this.getName() + " saindo do estacionamento");
			semaforo.release();
			System.out.println("Núm. de vagas livres: " + semaforo.availablePermits());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
