package contador_com_threads;

public class Contador {
	private int valor;
	
	public Contador(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void incrementarValor() {
		this.valor++;
	}
	
}
