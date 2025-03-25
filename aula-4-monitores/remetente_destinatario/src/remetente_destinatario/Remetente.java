package remetente_destinatario;

import java.util.concurrent.ThreadLocalRandom;

public class Remetente extends Thread {
	private Pacote pacote;
	private String[] mensagens;

	public Remetente(Pacote pacote, String[] mensagens) {
		this.pacote = pacote;
		this.mensagens = mensagens;
	}
	
	public void run() {
		for(String mensagem: mensagens) {
			this.pacote.enviar(mensagem, this.getName());
			
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
