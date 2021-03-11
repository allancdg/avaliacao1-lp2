package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;

public class cadastramento {
	public void cadastrar() {
		int entrada_int;
		
		System.out.println("MENU DE CADASTRAMENTO");
		System.out.println("1 - COMPRADOR");
		System.out.println("2 - VENDEDOR");
		System.out.println("3 - PRODUTO");
		System.out.println("4... - SAIR");
		System.out.println("DIGITE A OPÇÃO DESEJADA: ");		
		Scanner entrada = new Scanner(System.in);
		entrada_int = entrada.nextInt();
		
		if(entrada_int == 1) {
			System.out.println("CADASTRAMENTO DE COMPRADOR");
			System.out.println("NOME: ");
			entrada.nextLine(); // Limpando buffer do teclado
			String nome = entrada.nextLine();
			System.out.println("CPF: ");
			entrada.nextLine(); // Limpando buffer do teclado
			String cpf = entrada.nextLine();
			
			compradores comprador = new compradores(nome, cpf);
			
		} else if(entrada_int == 2) {
			System.out.println("CADASTRAMENTO DE VENDEDOR");
			System.out.println("NOME: ");
			entrada.nextLine(); // Limpando buffer do teclado
			String nome = entrada.nextLine();
			System.out.println("CNPJ: ");
			entrada.nextLine(); // Limpando buffer do teclado
			String cnpj = entrada.nextLine();
			
			vendedores vendedor = new vendedores(nome, cnpj);
			
		} else if(entrada_int == 3) {
			System.out.println("CADASTRAMENTO DE PRODUTOS");
			/*LISTAR VENDEDORES CADASTRADOS
			 * ESCOLHER O VENDEDOR
			 * CADASTRAR O PRODUTO (CÓDIGO ABAIXO)
			 */
			
			System.out.println("CODIGO: ");
			int codigo = entrada.nextInt();
			System.out.println("NOME: ");
			entrada.nextLine(); // Limpando buffer do teclado
			String nome = entrada.nextLine();
			System.out.println("PREÇO UNITÁRIO: ");
			double preco_unitario = entrada.nextDouble();
			
			produtos produto = new produtos(codigo, nome, preco_unitario);
		}
	}
}
