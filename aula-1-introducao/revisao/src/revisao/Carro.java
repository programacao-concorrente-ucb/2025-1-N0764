package revisao;

public class Carro extends Veiculo {
	private int velocidadeMax;
	public Carro(int numRodas, String cor, 
			String motor, int numLugares, 
			String marca, int capacidadeTanque,
			int velocidadeMax) {
		super(numRodas, cor, motor, 
				numLugares, marca, 
				capacidadeTanque);
		this.velocidadeMax = velocidadeMax;
	}

	
	public void acelerar() {
		if(this.getVelocidadeAtual() <= this.velocidadeMax - 10) {
			this.setVelocidadeAtual(this.getVelocidadeAtual() + 10);
			System.out.println("Vel. atual: " + this.getVelocidadeAtual() + " km/h");
		} else {
			System.out.println("Já está na vel. máx!");
		}
	}
	
}
