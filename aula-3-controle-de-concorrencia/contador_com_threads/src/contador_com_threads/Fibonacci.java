package contador_com_threads;

public class Fibonacci {
	long getNumFibonacci(long n) {
		if(n == 0) {
			return 0;
		}
			
		if(n == 1) {
			return 1;
		}
		
		return this.getNumFibonacci(n-1) + this.getNumFibonacci(n-2);
	}
}
