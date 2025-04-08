package jantar_filosofos;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

class Filosofo extends Thread {

	private Prato prato;
	private Semaphore semaforoJantar;
	private Lock garfoEsq;
	private Lock garfoDir;
	private String name;

	public Filosofo(String name, Prato prato, Semaphore semaforoJantar, Lock garfoEsq, Lock garfoDir) {
		super(name);
		this.garfoEsq = garfoEsq;
		this.garfoDir = garfoDir;
		this.prato = prato;
		this.semaforoJantar = semaforoJantar;
	}

	// ...
	public void run() {
		while (this.prato.temMacarrao()) {
			// Tentando adquirir semáforo
			try {
				System.out.println(this.getName() + " tentando adquirir semáforo!");

				this.semaforoJantar.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Tentar adquirir garfo da esquerda
			if (this.garfoEsq.tryLock()) {
				System.out.println(this.getName() + " pegou garfo da esquerda!");

				try {
					// Tentar adquirir garfo da direita
					if (this.garfoDir.tryLock()) {
						System.out.println(this.getName() + " pegou garfo da direita!");

						try {
							// Ambos os garfos foram adquiridos. Pode comer!
							System.out.println(this.getName() + " comendo macarrão...");
							this.prato.comer();
						} finally {
							// Liberar garfo da direita
							this.garfoDir.unlock();
							System.out.println(this.getName() + " liberou garfo da direita!");

						}
					}
				} finally {
					// Liberar garfo da esquerda
					this.garfoEsq.unlock();
					System.out.println(this.getName() + " liberou garfo da esquerda!");

				}
				// liberando semáforo
				this.semaforoJantar.release();
			}
            this.pensar();

		}
	}

	public void pensar() {
		try {
			System.out.println(this.getName() + " pensando...");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");

		}
	}
}
