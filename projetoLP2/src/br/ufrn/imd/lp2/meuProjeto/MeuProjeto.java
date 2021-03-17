package br.ufrn.imd.lp2.meuProjeto;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class MeuProjeto {
	public static void main (String[] args) {		
		int entrada_int_main;											//Variavel responsavel por receber a opcao do Menu Principal
		Set<Comprador> compradores = new HashSet<>();					
		//Set<Vendedor> vendedores = new HashSet<>();						
		
		//INSERÇAO DE OBJETOS PARA TESTES
		Comprador andre = new Comprador("ANDRE TRIGUEIRO", "111.222.333-44", 10000.00);
		//Vendedor allan = new Vendedor("ALLAN CHRISTIAN", "222.333.444-55", 20000.00);
		compradores.add(andre);
		
		//INICIO do Menu Principal
		System.out.println("MENU PRINCIPAL");		
		System.out.println("1 - COMPRADORES");
		System.out.println("2 - VENDEDORES");
		System.out.println("3 - PRODUTOS");
		System.out.println("4 - COMPRA/VENDA");
		System.out.println("5... - SAIR");
		System.out.println("DIGITE A OPCAO DESEJADA: ");		
		Scanner entrada = new Scanner(System.in);
		entrada_int_main = entrada.nextInt();									
		//FIM do Menu Principal
		
		
		//INICIO opcoes do Menu Principal
		//INICIO do Menu de Compradores
		if(entrada_int_main == 1) {												
			int entrada_int_compradores;				
			System.out.println("MENU PRINCIPAL COMPRADORES");					
			System.out.println("1 - CADASTRAR NOVO COMPRADOR");
			System.out.println("2 - APAGAR COMPRADOR");
			System.out.println("3 - LISTAR TODOS OS COMPRADORES");
			System.out.println("4 - BUSCAR POR CPF");
			System.out.println("5 - LISTAR COMPRAS REALIZADAS");
			System.out.println("6 - VALORES A PAGAR");
			System.out.println("7... - VOLTAR");
			System.out.println("DIGITE A OPÇAO DESEJADA: ");
			entrada_int_compradores = entrada.nextInt();						
		//FIM do Menu de Compradores
			
		//INICIO opcoes do Menu Compradores
			if(entrada_int_compradores == 1) { //cadastrar novo comprador
				Comprador novo_comprador = new Comprador();
				novo_comprador = novo_comprador.cadastrar();
				
				boolean teste_duplicado = false;
				
				for(Comprador comprador_aux : compradores) {
					if(comprador_aux.equals(novo_comprador)) {
						teste_duplicado = true;
					}
				}
				
				if (teste_duplicado) {
					System.out.println("O CPF informado ja esta cadastrado.");
				}
				else {
					compradores.add(novo_comprador);
				}
			}
			else if(entrada_int_compradores == 2){ //apagar comprador
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
				for(Comprador comprador_aux : compradores){
					System.out.println(comprador_aux.toString());
					System.out.println(" ");
				}
					
				System.out.println("DIGITE O CPF DO COMPRADOR A APAGAR: ");
				String entrada_CPF_comprador;
				entrada_CPF_comprador = entrada.nextLine();
								
				for(Comprador comprador_aux : compradores){
					if(comprador_aux.getCPF() == entrada_CPF_comprador) {
						compradores.remove(comprador_aux);
					}
				}			
				
				//return to default value before if^2
				entrada_int_compradores = 2;
			}
			else if(entrada_int_compradores == 3){ //listar todos os compradores cadastrados
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
				for(Comprador comprador_aux : compradores){
					System.out.println(comprador_aux.toString());
					System.out.println(" ");
				}
			}
			else if(entrada_int_compradores == 4){ //buscar comprador por CPF
				System.out.println("FORMATO DE BUSCA -> 123.456.789-00 ");
				System.out.println("DIGITE O CPF QUE DESEJA BUSCAR: ");
				String entrada_string_compradores;
				entrada_string_compradores = entrada.nextLine();
				
				boolean teste = true;
				for(Comprador comprador_aux : compradores){
					if(comprador_aux.getCPF() == entrada_string_compradores) {
						System.out.println("CPF ENCONTRADO. INFORMAÇOES: ");
						System.out.println(comprador_aux.toString());
						teste = false;
					}
				}
				
				if (teste) { 
					System.out.println("Este CPF nao foi encontrado.");
				}
			}
			else if(entrada_int_compradores == 5) { //listar compras realizadas
				//retorna ao menu anterior
			}
			else if(entrada_int_compradores == 6) { //listar valores a pagar
				//retorna ao menu anterior
			}
			else if(entrada_int_compradores == 7) { //voltar o menu
				//retorna ao menu anterior
			}
			else {
				System.out.println("O numero informado nao corresponde a nenhuma opçao!");
			}																
			//FIM das opcoes do Menu de Compradores
		}
//		else if(entrada_int_main == 2) {
//			int entrada_int_vendedores;
//			
//			//INICIO do Menu de Vendedores
//			System.out.println("MENU PRINCIPAL VENDEDORES");					
//			System.out.println("1 - CADASTRAR NOVO VENDEDOR");
//			System.out.println("2 - APAGAR VENDEDOR");
//			System.out.println("3 - LISTAR TODOS OS VENDEDOR");
//			System.out.println("4 - BUSCAR POR CPF");
//			System.out.println("5 - LISTAR VENDAS REALIZADAS");
//			System.out.println("6 - VALORES A RECEBER");
//			System.out.println("7 - CATALOGO DE PRODUTOS");
//			System.out.println("8... - VOLTAR");
//			System.out.println("DIGITE A OPÇAO DESEJADA: ");
//			entrada_int_vendedores = entrada.nextInt();							
//			//FIM do Menu de Vendedores
//			
//			if(entrada_int_vendedores == 1) {
//				Vendedor novo_vendedor = new Vendedor();
//				vendedores.add(novo_vendedor.cadastrar());
//				
//				for(Vendedor vendedor_aux : vendedores) {
//					vendedor_aux.equals(novo_vendedor);
//				}
//			}
//			else if(entrada_int_vendedores == 2){
//				System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
//				for(Vendedor vendedor_aux : vendedores){
//					System.out.println(vendedor_aux.toString());
//					System.out.println(" ");
//				}
//					
//				System.out.println("DIGITE O CPF DO VENDEDOR A APAGAR: " );
//				entrada_int_vendedores = entrada.nextInt();				
//				compradores.remove(entrada_int_vendedores);
//				
//				//return to default value before if^2
//				entrada_int_vendedores = 2;
//			}
//			else if(entrada_int_vendedores == 3) {
//				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
//				for(Vendedor vendedor_aux : vendedores){
//					System.out.println(vendedor_aux.toString());
//					System.out.println(" ");
//				}
//			}
//			else if(entrada_int_vendedores == 4){
//				System.out.println("FORMATO DE BUSCA -> 12.345.678./0001-00 ");
//				System.out.println("DIGITE O CNPJ QUE DESEJA BUSCAR: ");
//				String entrada_string_vendedores;
//				entrada_string_vendedores = entrada.nextLine();
//				
//				for(int count=0; count < vendedor.size(); count ++){
//					if(vendedor.get(count).getCnpj() == entrada_string_vendedores){
//						vendedor.get(count).show_info(); 
//					}
//				}
//			}
//			else if(entrada_int_vendedores == 5){
//				System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
//				System.out.println("ID / NOME / CNPJ / SALDO");
//				for(int count=0; count < vendedor.size(); count ++){
//					System.out.println(count);
//					vendedor.get(count).show_info(); 
//				}
//				System.out.println("DIGITE O N�MERO DO VENDEDOR A OPERAR: " );
//				entrada_int_vendedores = entrada.nextInt();
//				
//				vendedor.get(entrada_int_vendedores).menu();
//												
//				//return to default value before if^2
//				entrada_int_vendedores = 5;
//			}
//		}																	
		//FIM das opcoes do Menu de Vendedores
	entrada.close();														//Fecha a funcao Scanner entrada
	}
}
