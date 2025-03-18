package contador_com_threads;

public class MainComStackOverflow {
	public static void main(String args[]) {
		long n = 100000;
		System.out.println("Fibonacci[" + n + "] = " + 
		new Fibonacci().getNumFibonacci(n));
	}
}
