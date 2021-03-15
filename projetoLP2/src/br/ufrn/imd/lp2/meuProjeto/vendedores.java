package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class vendedores {
	
	private String nome;
	private String cnpj;
	private double saldo_conta;
	private ArrayList<Double> valores_receber = new ArrayList<>();
	private ArrayList<Double> vendas = new ArrayList<>();/*Mudar para List<produtos> e,
	caso necessário, receber os valores através do produto vendido*/
	private ArrayList<produtos> catalogo_produtos = new ArrayList<>();	
	
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
		nome = entrada.nextLine();
		System.out.println("CNPJ: ");
		cnpj = entrada.nextLine();
		
		vendedores vendedor = new vendedores(nome, cnpj);
		entrada.close();
		return vendedor;
	}
	
	public void menu(){
		Scanner entrada = new Scanner(System.in);
		int opcao;
		System.out.println("MENU OPERACIONAL DO VENDEDOR " + nome);
		System.out.println("1 - CADASTRAR PRODUTOS");
		System.out.println("2 - INFORMAÇÕES COMPLETAS");
		System.out.println("3... - VOLTAR");
		opcao = entrada.nextInt();
		
		if(opcao == 1) {
			produtos novo_produto = new produtos();
			catalogo_produtos.add(novo_produto.cadastrar());
		}		
		entrada.close();
	}
}