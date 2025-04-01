package produtor_consumidor;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buffer {
	static private Integer CAPACIDADE_MAX = 20;
	private Queue<Integer> buffer;
	private Lock trava;
	
	
	
	private Condition podeInserirItens;
	private Condition podeRetirarItens;
	
	public Buffer(Queue<Integer> buffer, 
			      Lock trava,
			      Condition podeInserirItens,
			      Condition podeRetirarItens) {
		
		
		this.buffer = buffer;
		this.trava = trava;
		this.podeInserirItens = podeInserirItens;
		this.podeRetirarItens = podeRetirarItens;
	}
	
	public void adicionar(Integer item) {
		this.trava.lock();		
		
		while(this.buffer.size() == CAPACIDADE_MAX) {
			try {
				this.podeInserirItens.await();
			} catch (InterruptedException e) {
				System.out.println("ERRO: Thread foi interrompida!");
			}
		}
		
		System.out.println("Adicionando item " + item);
		this.buffer.add(item);
		this.podeRetirarItens.signalAll();
		this.trava.unlock();
	}
	
	
	public void retirar() {
		this.trava.lock();
		
		while(this.buffer.size() == 0) {
			try {
				this.podeRetirarItens.await();
			} catch (InterruptedException e) {
				System.out.println("ERRO: Thread foi interrompida!");
			}
		}
		
		Integer item = this.buffer.remove();
		System.out.println("Item retirado: " + item);
		this.podeInserirItens.signalAll();
		this.trava.unlock();
	}
	
}
