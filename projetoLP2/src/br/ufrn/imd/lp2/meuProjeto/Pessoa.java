package br.ufrn.imd.lp2.meuProjeto;

//CLASSE ABSTRATA PESSOA
public class Pessoa {
	
	//ATRIBUTOS
	protected String nome;
	protected double saldo_conta;
	
	//CONSTRUTOR PADRAO
	public Pessoa() {}
	
	//CONSTRUTOR PARAMETRIZADO
	public Pessoa(String nome, double saldo_conta) {
		this.nome = nome;
		this.saldo_conta = saldo_conta;
	}
	
	//Setters
	public void setSaldo(double valor){
		this.saldo_conta = valor;
	}
	
	//Getters
	public String getNome() {
		return nome;
	}
	
	public Double getSaldo() {
		return saldo_conta;
	}
	
}
