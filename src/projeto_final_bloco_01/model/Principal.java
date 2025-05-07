package projeto_final_bloco_01.model;

import java.text.NumberFormat;

public abstract class Principal {

	// Classe de mídia de vídeo
	private int numeroSerie;
	private String nome;
	private String generos;
	private int anoLancamento;
	private int tipo;
	private float valor;
	
	public Principal (int numeroSerie, String nome, String generos, int anoLancamento, int tipo, float valor) {
		this.numeroSerie = numeroSerie;
		this.nome = nome;
		this.generos = generos;
		this.anoLancamento = anoLancamento;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public int getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(int id) {
		this.numeroSerie = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGeneros() {
		return generos;
	}
	public void setGeneros(String generos) {
		this.generos = generos;
	}
	public int getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public void visualizar() {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		String tipo = "";
		
		switch(this.tipo) {
			case 1 -> tipo = "DVD";
			//case 2 -> tipo = "Fita VHS";
			default -> tipo = "Inválido";
		}
		
		System.out.println("****************************************************");
		System.out.println("                INFORMAÇÕES DA MÍDIA                ");
		System.out.println("****************************************************");
		System.out.println("Número de série: " + this.numeroSerie);
		System.out.println("Nome da mídia: " + this.nome);
		System.out.println("Gêneros: " + this.generos);
		System.out.println("Ano de lançamento: " + this.anoLancamento);
		System.out.println("Tipo de mídia: " + tipo);
		System.out.println("Valor de aluguel: " + nfMoeda.format(this.valor));
	}
}
