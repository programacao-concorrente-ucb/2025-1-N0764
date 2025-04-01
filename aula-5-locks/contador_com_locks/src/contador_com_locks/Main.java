package contador_com_locks;

import java.util.ArrayList;
import java.util.concurrent.locks.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Lock trava = new ReentrantLock();
		
		Contador cont = new Contador(0);
		
		ArrayList<Incrementador> incs = new ArrayList<Incrementador>();
		for(int i = 0;i < 50;i++) {
			incs.add(new Incrementador(cont, trava));
		}
		
		for(Incrementador inc: incs) {
			inc.start();
		}
		
		
		for(Incrementador inc: incs) {
			inc.join();
		}
		
		System.out.println("Valor final: " + cont.getValor() );
	}


}
