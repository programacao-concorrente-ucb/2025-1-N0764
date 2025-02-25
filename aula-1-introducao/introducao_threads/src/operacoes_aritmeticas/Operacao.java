package operacoes_aritmeticas;

public class Operacao extends Thread {
	private char op;
	private int v1;
	private int v2;
	
	public Operacao(String name, char op, int v1, int v2) {
		super(name);
		this.op = op;
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public void run() {
		switch(this.op) {
			case '+':
				System.out.println("v1 + v2 = " + (v1+v2));
				break;
			case '-':
				System.out.println("v1 - v2 = " + (v1-v2));
				break;
			case '*':
				System.out.println("v1 * v2 = " + (v1*v2));
				break;
			case '/':
				System.out.println("v1 / v2 = " + (v1/v2));
				break;
			default:
				System.out.println("Operação inválida!");
		}
	}
}
