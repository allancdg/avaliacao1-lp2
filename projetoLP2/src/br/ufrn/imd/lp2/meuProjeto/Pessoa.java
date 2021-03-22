package br.ufrn.imd.lp2.meuProjeto;

public class Pessoa {
	protected String nome;
	protected double saldo_conta;
	
	public Pessoa() {} //Construtor padrao
	public Pessoa(String nome, double saldo_conta) { //Construtor parametrizado
		this.nome = nome;
		this.saldo_conta = saldo_conta;
	}
	public Pessoa(String nome){
		this.nome = nome;
		this.saldo_conta = 0;
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
