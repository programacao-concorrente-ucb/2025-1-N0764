package contador_com_locks;

import java.util.ArrayList;
import java.util.concurrent.locks.*;

public class MainComTryLock {

	public static void main(String[] args) throws InterruptedException {
		Lock trava = new ReentrantLock();
		
		Contador cont = new Contador(0);
		
		ArrayList<IncrementadorComTryLock> incs = new ArrayList<IncrementadorComTryLock>();

		for(int i = 0;i < 10;i++) {
			incs.add(new IncrementadorComTryLock(cont, trava));
		}
		
		for(IncrementadorComTryLock inc: incs) {
			inc.start();
		}
		
		
		for(IncrementadorComTryLock inc: incs) {
			inc.join();
		}
		
		System.out.println("Valor final: " + cont.getValor() );
	}


}
