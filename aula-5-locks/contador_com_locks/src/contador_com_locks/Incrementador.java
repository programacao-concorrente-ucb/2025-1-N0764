package contador_com_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Incrementador extends Thread {
	private Contador contador;
	private Lock trava;
	
	public Incrementador(Contador contador, Lock trava) {
		this.contador = contador;
		this.trava = trava;
	}
	
	public void run() {
		try {
			trava.lock();
			System.out.println(this.getName() + " entrou na seção crítica");
			
			System.out.println(this.getName() + " incrementando contador...");
			this.contador.incrementaValor();
			System.out.println(this.getName() + " saiu da seção crítica.");
			
		} finally {
			trava.unlock();
		}
	}

}
