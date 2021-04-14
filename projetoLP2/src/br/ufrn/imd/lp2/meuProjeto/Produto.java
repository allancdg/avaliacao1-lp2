package br.ufrn.imd.lp2.meuProjeto;

public class Produto {
	
	//ATRIBUTOS
	private String ID;
	private String nome;
	private double preco_unitario;
	private String data_validade;
	
	//CONSTRUTOR PADRAO
	public Produto() {} 
	
	//CONSTRUTOR PARAMETRIZADO
	public Produto(String ID, String nome, double preco_unitario, String data_validade) {
	    this.ID = ID;
		this.nome = nome;
		this.preco_unitario = preco_unitario;
		this.data_validade = data_validade;
	}
	
	//Setters
	//----
	
	//Getters
	public String getID() {
		return ID;
	}
	public String getNome() {
		return nome;
	}
	public double getPreco_unitario() {
		return preco_unitario;
	}
	public String getData_Validade() {
		return data_validade;
	}
	
	//METODOS AUXILIARES
	public String toString() { //metodo para mostrar informacoes
		String retorno = "ID: " + this.ID;
		retorno += "Nome: " + this.nome;
		retorno += "\nPreco Unitario: R$" + this.preco_unitario;
		return retorno;
	}
}
