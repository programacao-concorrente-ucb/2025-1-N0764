package contador_com_monitor;


public class Main {
	public static void main(String args[]) {
		int numRep = 1;
		while(true) {
			// objeto compartilhado entre threads
			Contador cont = new Contador(0);
			
			Incrementador inc1 = new Incrementador(cont);
			Incrementador inc2 = new Incrementador(cont);
			Incrementador inc3 = new Incrementador(cont);
			
			inc1.start();
			inc2.start();
			inc3.start();
			
			// espero as threads terminarem
			try {
				inc1.join();
				inc2.join();
				inc3.join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			
			// Mostro o valor final
			System.out.println("Valor do contador: " + cont.getValor());

			numRep++;
			if(cont.getValor() != 3) {
				System.out.println(numRep + " execuções para dar errado...");
				break;
			}
		}
	}
}
