package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;

public class produtos {
	private int codigo=0;
	private String nome;
	private double preco_unitario;
	
	public produtos() {} //Construtor padrão
	public produtos( String nome, double preco_unitario) { //Construtor parametrizado
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
	
	public produtos cadastrar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("CADASTRAMENTO DE PRODUTO");
		System.out.println("NOME: ");
		nome = entrada.nextLine();
		System.out.println("PREÇO UNITÁRIO: ");
		preco_unitario = entrada.nextDouble();
		
		produtos novo_produto = new produtos(nome, preco_unitario);
		entrada.close();
		return novo_produto;
	}
	
}
