package produtor_consumidor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.*;

public class Main {
	private static int NUM_CONSUMIDORES = 3;
	private static int NUM_PRODUTORES = 2;
	
	
	public static void main(String[] args) {
		Queue<Integer> fila = new LinkedList<Integer>();
		Lock trava = new ReentrantLock();
		Buffer itens = new Buffer(fila, trava, trava.newCondition(), trava.newCondition());
		
		
		for(int i = 0; i < NUM_PRODUTORES;i++) {
			new Produtor(itens, "Produtor " + (i+1)).start();
		}
		
		
		for(int i = 0; i < NUM_CONSUMIDORES;i++) {
			new Consumidor(itens, "Consumidor " + (i+1)).start();
		}
	}

}
