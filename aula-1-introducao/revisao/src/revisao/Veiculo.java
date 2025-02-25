package revisao;

public abstract class Veiculo {
	private int numRodas;
	private String cor;
	private String nomeMotor;
	private int numLugares;
	private String marca;
	private int capacidadeTanque;
	private int quantCombustivel;
	private int velocidadeAtual;
	
	public Veiculo(int numRodas, String cor, String nomeMotor, int numLugares, String marca, int capacidadeTanque) {
		this.numRodas = numRodas;
		this.cor = cor;
		this.nomeMotor = nomeMotor;
		this.numLugares = numLugares;
		this.marca = marca;
		this.capacidadeTanque = capacidadeTanque;
	}
	
	public int getNumRodas() {
		return numRodas;
	}
	public void setNumRodas(int numRodas) {
		this.numRodas = numRodas;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMotor() {
		return nomeMotor;
	}
	public void setMotor(String nomeMotor) {
		this.nomeMotor = nomeMotor;
	}
	public int getNumLugares() {
		return numLugares;
	}
	public void setNumLugares(int numLugares) {
		this.numLugares = numLugares;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void encherTanque(int quantCombustivel) {
		for(int i = 0;
			this.quantCombustivel < this.capacidadeTanque;
			i++) {
			this.quantCombustivel++;
			System.out.println(i + " litros colocados");
		}
	}
	
	public void acelerar() {
		this.setVelocidadeAtual(this.getVelocidadeAtual() + 5);
	}
	public int getVelocidadeAtual() {
		return velocidadeAtual;
	}
	public void setVelocidadeAtual(int velocidadeAtual) {
		this.velocidadeAtual = velocidadeAtual;
	}
	
	
	
	
}
