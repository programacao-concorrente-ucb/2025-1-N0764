package remetente_destinatario;

public class Main {
	public static void main(String[] args) {
		String[] mensagens = {
				"Primeira mensagem",
				"Segunda",
				"Mó sono",
				"Vamo pra casa!",
				"FIM"
		};
		
		Pacote pacote = new Pacote();
		Remetente rem = new Remetente(pacote, mensagens);
		Destinatario dest = new Destinatario(pacote);
		
		rem.start();
		dest.start();
	}
}
