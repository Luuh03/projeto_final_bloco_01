package projeto_final_bloco_01.model;

public class Estendida extends Principal {

	// Classe de DVD
	private String bluray;

	public Estendida(int numeroSerie, String nome, String generos, int anoLancamento, int tipo, float valor, String bluray) {
		super(numeroSerie, nome, generos, anoLancamento, tipo, valor);
		this.setBluray(bluray);
	}

	public String getBluray() {
		return bluray;
	}

	public void setBluray(String bluray) {
		this.bluray = bluray;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("É Blu-Ray: " + this.bluray);
	}
}
