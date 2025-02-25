package introducao_threads;

public class Main {
	public static void main(String args[]) {
		Ola ola = new Ola("Thread Ola");
		Tchau tchau = new Tchau("Thread Tchau");
		// System.out.println(Thread.currentThread());
		ola.start();
		tchau.start();
	}
}
