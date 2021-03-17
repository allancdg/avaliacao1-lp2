package br.ufrn.imd.lp2.meuProjeto;

public class Pessoa {
	protected String nome;
	protected String CPF;
	protected double saldo_conta;
	
	public Pessoa() {} //Construtor padrao
	public Pessoa(String nome, String CPF, double saldo_conta) { //Construtor parametrizado
		this.nome = nome;
		this.CPF = CPF;
		this.saldo_conta = saldo_conta;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public Double getSaldo() {
		return saldo_conta;
	}
}
