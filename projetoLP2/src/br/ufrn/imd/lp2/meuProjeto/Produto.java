package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;

public class Produto {
	private String nome;
	private double preco_unitario;
	
	public Produto() {} //Construtor padrao
	public Produto( String nome, double preco_unitario) { //Construtor parametrizado
		this.nome = nome;
		this.preco_unitario = preco_unitario;
	}
	
	//Setters
	//----
	
	//Getters
	public String getNome() {
		return nome;
	}
	public double getPreco_unitario() {
		return preco_unitario;
	}
	//INICIO Metodos auxiliares
	//Metodo para mostrar informaçoes
	public String toString() { 
		String retorno = "Nome: " + this.nome;
		retorno += "\nPreço Unitario: " + this.preco_unitario;
		return retorno;
	}
	
	public Produto cadastrar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("CADASTRAMENTO DE PRODUTO");
		System.out.println("NOME: ");
		nome = entrada.nextLine();
		System.out.println("PRE�O UNIT�RIO: ");
		preco_unitario = entrada.nextDouble();
		
		Produto novo_produto = new Produto(nome, preco_unitario);
		entrada.close();
		return novo_produto;
	}
	
}
