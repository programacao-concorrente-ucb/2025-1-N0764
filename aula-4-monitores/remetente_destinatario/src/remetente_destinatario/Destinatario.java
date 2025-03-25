package remetente_destinatario;

import java.util.concurrent.ThreadLocalRandom;

public class Destinatario extends Thread {
	private Pacote pacote;

	public Destinatario(Pacote pacote) {
		this.pacote = pacote;
	}
	
	public void run() {
		while(true) {
			String mensagem = pacote.receber();
			
			if(mensagem == "FIM") {
				break;
			}
			
			int numAleat = ThreadLocalRandom.
					current().nextInt(2000, 7000);
			try {
				Thread.sleep(numAleat);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
