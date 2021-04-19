package br.ufrn.imd.lp2.meuProjeto;

public class Produto {
	
	//ATRIBUTOS
	private int ID;
	private String nome;
	private double preco_unitario;
	
	//CONSTRUTOR PADRAO
	public Produto() {} 
	
	//CONSTRUTOR PARAMETRIZADO
	public Produto(int ID, String nome, double preco_unitario) {
	    this.ID = ID;
		this.nome = nome;
		this.preco_unitario = preco_unitario;
	}
	
	//Setters
	//----
	
	//Getters
	public int getID() {
		return ID;
	}
	public String getNome() {
		return nome;
	}
	public double getPreco_unitario() {
		return preco_unitario;
	}
	
	//METODOS AUXILIARES
	public String toString() { //metodo para mostrar informacoes
		String retorno = "\nID: " + this.ID;
		retorno += "\nNome: " + this.nome;
		retorno += "\nPreco Unitario: R$" + this.preco_unitario;
		return retorno;
	}
}
