package introducao_threads;

public class Ola extends Thread {
	public Ola(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println("Thread atual: " + Thread.currentThread().getName());
		System.out.println("Ola!");
	}
}
