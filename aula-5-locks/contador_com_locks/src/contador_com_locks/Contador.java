package contador_com_locks;

public class Contador {
	private int valor;
	
	public Contador(int valor) {
		this.setValor(valor);
	}
	
	
	public void incrementaValor() {
		setValor(getValor() + 1);
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}
}
