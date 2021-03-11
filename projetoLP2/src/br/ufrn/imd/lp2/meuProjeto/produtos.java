package br.ufrn.imd.lp2.meuProjeto;

public class produtos {
	private int codigo;
	private String nome;
	private double preco_unitario;
	
	public produtos() {} //Construtor padrão
	public produtos(int codigo, String nome, double preco_unitario) { //Construtor parametrizado
		this.codigo = codigo;
		this.nome = nome;
		this.preco_unitario = preco_unitario;
	}
	
	//Getters
	public int getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public double getPreco_unitario() {
		return preco_unitario;
	}
	
	//Setters
}
