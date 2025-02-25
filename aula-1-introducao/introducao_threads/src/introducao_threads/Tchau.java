package introducao_threads;

public class Tchau extends Thread {
	public Tchau(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println("Thread atual: "+ Thread.currentThread().getName());
		System.out.println("Tchau!");
	}
}