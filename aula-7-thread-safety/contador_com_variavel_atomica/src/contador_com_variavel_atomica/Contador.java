package contador_com_variavel_atomica;

import java.util.concurrent.atomic.AtomicInteger;

public class Contador {
	private AtomicInteger valor;
	
	public Contador(int i) {
		this.valor = new AtomicInteger();
		this.valor.set(i);
	}
	
	public void incrementa(){
		valor.incrementAndGet();
	}
	
	public int getValor() {
		return valor.get();
	}
}
