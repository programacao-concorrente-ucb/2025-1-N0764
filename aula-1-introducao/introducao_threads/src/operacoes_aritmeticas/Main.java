package operacoes_aritmeticas;

public class Main {
	public static void main(String args[]) {
		int v1 = 10;
		int v2 = 32;
		Operacao soma = new Operacao("soma", '+', v1, v2);
		Operacao sub = new Operacao("soma", '-', v1, v2);
		Operacao div = new Operacao("soma", '/', v1, v2);
		Operacao mult = new Operacao("soma", '*', v1, v2);
		
		soma.start();
		sub.start();
		mult.start();
		div.start();
		
	}
}
