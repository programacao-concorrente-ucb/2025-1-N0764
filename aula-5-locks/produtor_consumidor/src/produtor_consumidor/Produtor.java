package produtor_consumidor;

import java.util.Random;

public class Produtor extends Thread {
	private Buffer buffer;
	
	public Produtor(Buffer buffer, String nome) {
		super(nome);
		this.buffer = buffer;
	}
	
	public void run() {
		int numItens = new Random().nextInt(5) + 1;
		
		System.out.println(this.getName() + " vai produzir " + numItens);
		
		for(int i = 0; i < numItens;i++) {
			this.produzir();
		}
		
		System.out.println(this.getName() + " terminou a produção...");
	}
	
	public void produzir() {
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			System.out.println("ERRO: Thread foi interrompida!");
		}
		
		int item = new Random().nextInt(100) + 1;
		this.buffer.adicionar(item);
	}
}
























