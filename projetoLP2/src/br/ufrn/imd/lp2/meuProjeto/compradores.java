package br.ufrn.imd.lp2.meuProjeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class compradores {
	private String nome;
	private String cpf;
	private double saldo_conta;
	private List<Double> valores_pagar = new ArrayList<>();
	private List<Double> compras = new ArrayList<>(); /*Mudar para List<produtos> e,
	caso necessário, receber os valores através do produto comprado*/
	
	public compradores() {} //Construtor padrão
	public compradores(String nome, String cpf, double saldo_conta) { //Construtor parametrizado
		this.nome = nome;
		this.cpf = cpf;
		this.saldo_conta = saldo_conta;
	}
	
	//Setters
	//----
		
	//Getters
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public double getSaldo_conta() {
		return saldo_conta;
	}
	public List<Double> getValores_pagar() {
		return valores_pagar;
	}	
	public List<Double> getCompras() {
		return compras;
	}	

	public compradores cadastrar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("CADASTRAMENTO DE COMPRADOR");
		System.out.println("NOME: ");
		nome = entrada.nextLine();
		System.out.println("CPF: ");
		cpf = entrada.nextLine();
		System.out.println("SALDO INICIAL: ");
		saldo_conta = entrada.nextDouble();
		
		compradores comprador = new compradores(nome, cpf, saldo_conta);
		entrada.close();
		return comprador;
	}
	
	public void menu(){
		
	}
}
