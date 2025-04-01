package produtor_consumidor;

import java.util.Random;

public class Consumidor extends Thread {
	private Buffer buffer;
	
	public Consumidor(Buffer buffer, String nome) {
		super(nome);
		this.buffer = buffer;
	}
	
	public void run() {
		
		int numItens = new Random().nextInt(3) + 1;
		System.out.println(this.getName() + " vai consumir " + numItens + " itens");
		for(int i = 0; i < numItens;i++) {
			this.consumir();
		}
		System.out.println(this.getName() + " terminou o consumo...");

	}
	
	public void consumir() {
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			System.out.println("ERRO: Thread foi interrompida!");
		}
		
		this.buffer.retirar();
	}
}
