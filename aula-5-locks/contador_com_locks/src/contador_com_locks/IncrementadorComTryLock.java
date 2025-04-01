package contador_com_locks;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class IncrementadorComTryLock extends Thread {
	private Contador contador;
	private Lock trava;
	
	public IncrementadorComTryLock(Contador contador, Lock trava2) {
		this.contador = contador;
		this.trava = trava2;
	}
	
	public void run() {
	
			boolean travada = false;
			try {
				travada = trava.tryLock(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(travada) {
				
				System.out.println(this.getName() + " entrou na seção crítica");
				try {
					Thread.sleep(ThreadLocalRandom.current().nextInt(4000, 5000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.getName() + " incrementando contador...");
				this.contador.incrementaValor();
				System.out.println(this.getName() + " saindo da seção crítica");
				trava.unlock();
				
			} else {
				System.out.println(this.getName() + " não adquiriu trava em 5 s...");
			}

	}

}
