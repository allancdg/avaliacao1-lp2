package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;

public class Produto {
	private int codigo=0;
	private String nome;
	private double preco_unitario;
	
	public Produto() {} //Construtor padr�o
	public Produto( String nome, double preco_unitario) { //Construtor parametrizado
		this.codigo++;
		this.nome = nome;
		this.preco_unitario = preco_unitario;
	}
	
	//Setters
	//----
	
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
