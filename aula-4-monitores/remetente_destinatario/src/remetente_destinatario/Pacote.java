package remetente_destinatario;

public class Pacote {
	private String mensagem;
	// sendoEnviado == true => estou enviando a mensagem
	
	// sendoEnviado == false => estou recebendo a mensagem
	private boolean sendoEnviado = true;
	
	public Pacote() {}
	
	public synchronized void enviar(String mensagem, String nomeThread) {
		// enquanto o pacote está sendo recebido
		// ou seja, enquanto o recebimento está acontecendo
		
		// a thread do envio ESPERA
		
		while(!sendoEnviado) {
			// espero
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.mensagem = mensagem;
		System.out.println(
				"Mensagem " + " '" + this.mensagem + "' " + 
		" foi enviada pela " + nomeThread);
		this.sendoEnviado = false;
		notify();
		
	}
	
	public synchronized String receber() {
		// enquanto mensagem está sendo enviada
		// espero
		while(sendoEnviado) {
			// espero
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Mensagem recebida: " + this.mensagem);
		this.sendoEnviado = true;
		notify();
		
		return this.mensagem;
	}
}
