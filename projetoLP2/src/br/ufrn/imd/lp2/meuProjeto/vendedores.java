package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class vendedores {
	
	private String nome;
	private String cnpj;
	private double saldo_conta;
	private List<Double> valores_receber = new ArrayList<>();
	private List<Double> vendas = new ArrayList<>();/*Mudar para List<produtos> e,
	caso necessário, receber os valores através do produto vendido*/
	private List<produtos> catalogo_produtos = new ArrayList<>();	
	
	public vendedores() {}	//Construtor padrão
	public vendedores(String nome, String cnpj) { //Construtor parametrizado
		this.nome = nome;
		this.cnpj = cnpj;
		this.saldo_conta = 0.0;
	}
	
	//Setters
	//---
	
	//Getters
	public String getNome() {
		return nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public double getSaldo_conta() {
		return saldo_conta;
	}
	public List<Double> getValores_receber() {
		return valores_receber;
	}
	public List<Double> getVendas() {
		return vendas;
	}
	public List<produtos> getCatalogo_produtos() {
		return catalogo_produtos;
	}	
	
	public vendedores cadastrar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("CADASTRAMENTO DE VENDEDOR");
		System.out.println("NOME: ");
		entrada.nextLine(); // Limpando buffer do teclado
		nome = entrada.nextLine();
		System.out.println("CNPJ: ");
		entrada.nextLine(); // Limpando buffer do teclado
		cnpj = entrada.nextLine();
		
		vendedores vendedor = new vendedores(nome, cnpj);
		entrada.close();
		return vendedor;
	}
	
	public void operar(){
		
	}
}