package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class MeuProjeto {
	
	public static void main (String[] args) {
		menus();
	}
	
	public static void menus() {
		//COLEÇOES DE OBJETOS PRINCIPAIS
		Set<Comprador> compradores = new HashSet<>();					
		Set<Vendedor> vendedores = new HashSet<>();						
		
		//INSERÇAO DE OBJETOS PARA TESTES
		Comprador andre = new Comprador("ANDRE TRIGUEIRO", "111.222.333-44", 10000.00);
		Vendedor allan = new Vendedor("ALLAN CHRISTIAN", "12.345.678./0001-00", 20000.00);
		compradores.add(andre);
		vendedores.add(allan);
		
		//INICIANDO O SCANNER
		Scanner entrada = new Scanner(System.in);
		int entrada_int_main = 0;	//Variavel responsavel por receber a opcao do Menu Principal
		do {
			//MENU PRINCIPAL
			System.out.println("->> MENU PRINCIPAL");		
			System.out.println("1 - COMPRADORES");
			System.out.println("2 - VENDEDORES");
			System.out.println("3 - COMPRA/VENDA");
			System.out.println("0... - SAIR DO PROGRAMA");
			System.out.println("DIGITE A OPCAO DESEJADA: ");
			entrada_int_main = Integer.parseInt(entrada.nextLine());
			
			//MENU SECUNDARIO - COMPRADORES
			if(entrada_int_main == 1) {	
				int entrada_int_compradores=0;
				do {
					//MENU ESPECIFICO DE COMPRADORES
					System.out.println("\n->> MENU PRINCIPAL COMPRADORES");					
					System.out.println("1 - CADASTRAR NOVO COMPRADOR");
					System.out.println("2 - APAGAR COMPRADOR");
					System.out.println("3 - LISTAR TODOS OS COMPRADORES");
					System.out.println("4 - BUSCAR E ACESSAR POR CPF");
					System.out.println("5... - VOLTAR");
					System.out.println("DIGITE A OPCAO DESEJADA: ");
					entrada_int_compradores = Integer.parseInt(entrada.nextLine());
					
					//OPÇAO 01 - CADASTRAR NOVO COMPRADOR
					if(entrada_int_compradores == 1) {
						Comprador novo_comprador = new Comprador();
						novo_comprador = novo_comprador.cadastrar();
						
						boolean teste_duplicado = false;
						//FOR EACH PARA RODAR NA LISTA DE COMPRADORES
						for(Comprador comprador_aux : compradores) {
							if(comprador_aux.equals(novo_comprador)) {
								teste_duplicado = true;
							}
						}
						//RESULTADO DO TESTE DUPLICADO
						if (teste_duplicado) {
							System.out.println("O CPF informado ja esta cadastrado.");
						}
						else {
							compradores.add(novo_comprador);
						}
					}
					
					//OPÇAO 02 - APAGAR COMPRADOR JA CADASTRADO
					else if(entrada_int_compradores == 2){
						//LISTA DE COMPRADORES
						System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
						for(Comprador comprador_aux : compradores){
							System.out.println(comprador_aux.toString());
							System.out.println(" ");
						}
						//ESCOLHENDO COMPRADOR A SER DELETADO
						System.out.println("DIGITE O CPF DO COMPRADOR A APAGAR: ");
						String entrada_CPF_comprador = entrada.nextLine();	
						//PERCORRENDO COMPRADORES ATÉ ACHAR O SELECIONADO			
						for(Comprador comprador_aux : compradores){
							if(comprador_aux.getCPF().equals(entrada_CPF_comprador)){
								System.out.println(comprador_aux.toString());
								compradores.remove(comprador_aux);
								System.out.println("Comprador deletado!");
							}
						}						
					}
					
					//OPÇAO 03 - LISTAR TODOS OS COMPRADORES
					else if(entrada_int_compradores == 3){
						System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
						for(Comprador comprador_aux : compradores){
							System.out.println(comprador_aux.toString());
							System.out.println(" ");
						}
					}
					
					//OPÇAO 04 - BUSCAR E ACESSAR POR CPF
					else if(entrada_int_compradores == 4){
						System.out.println("FORMATO DE BUSCA -> 123.456.789-00 ");
						System.out.println("DIGITE O CPF QUE DESEJA BUSCAR: ");
						String entrada_string_compradores;
						entrada_string_compradores = entrada.nextLine();

						boolean teste = true;
						//FOR EACH PERCORRENDO O CONJUNTO DE COMPRADORES E CONFERINDO SE O CPF INFORMADO FOI ENCONTRADO
						for(Comprador comprador_aux : compradores){
							if(comprador_aux.getCPF().equals(entrada_string_compradores)){
								System.out.println("CPF ENCONTRADO. INFORMAÇOES: ");
								System.out.println(comprador_aux.toString());
								comprador_aux.menu(comprador_aux);
								teste = false;
							}
						}						
						if (teste) { 
							System.out.println("Este CPF nao foi encontrado.");
						}
					}
				} while (entrada_int_compradores != 5);		//FIM DO MENU SECUNDARIOS DE COMPRADORES	
			}
			//MENU SECUNDARIO - VENDEDORES
			else if (entrada_int_main == 2) {
				
			}
			//MENU SECUNDARIO - COMPRA/VENDA
			else if (entrada_int_main == 3) {
				
			}
			//MENU SECUNDARIO - NUMERO INFORMADO NAO CORRESPONDE A NENHUMA OPÇAO
			else {
				System.out.println("O NUMERO INFORMADO NAO CORRESPONDE A NENHUMA OPÇAO!");
			}
		} while (entrada_int_main != 0); // FIM DO MENU PRINCIPAL
		//FINALIZANDO O SCANNER
		entrada.close();													
	}
}
		
			
			
			

//			
//			else if(entrada_int_main == 2) {
//				int entrada_int_vendedores=0;
//				while(entrada_int_vendedores < 5){
//					//INICIO do Menu de Vendedores
//					System.out.println("\n#MENU PRINCIPAL VENDEDORES");					
//					System.out.println("1 - CADASTRAR NOVO VENDEDOR");
//					System.out.println("2 - APAGAR VENDEDOR");
//					System.out.println("3 - LISTAR TODOS OS VENDEDORES");
//					System.out.println("4 - BUSCAR POR CNPJ");
//					System.out.println("5... - VOLTAR");
//					System.out.println("DIGITE A OPÇAO DESEJADA: ");
//					entrada_int_vendedores = entrada.nextInt();		
//					entrada.nextLine();
//					//FIM do Menu de Vendedores
//					
//					if(entrada_int_vendedores == 1) {
//						Vendedor novo_vendedor = new Vendedor();
//						novo_vendedor = novo_vendedor.cadastrar();
//						
//						boolean teste_duplicado = false;
//						
//						for(Vendedor vendedor_aux : vendedores) {
//							if(vendedor_aux.equals(novo_vendedor)) {
//								teste_duplicado = true;
//							}
//						}
//						
//						if (teste_duplicado) {
//							System.out.println("O CPF informado ja esta cadastrado.");
//						}
//						else {
//							vendedores.add(novo_vendedor);
//						}
//					}
//		
//					if(entrada_int_vendedores == 2){
//						System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
//						for(Vendedor vendedor_aux : vendedores){
//							System.out.println(vendedor_aux.toString());
//							System.out.println(" ");
//						}
//							
//						System.out.println("DIGITE O CPF DO VENDEDOR A APAGAR: " );
//						String entrada_CNPJ_vendedores;
//						entrada_CNPJ_vendedores = entrada.nextLine();				
//						for(Vendedor vendedor_aux : vendedores){
//							if(vendedor_aux.getCNPJ().equals(entrada_CNPJ_vendedores)){
//								vendedores.remove(vendedor_aux);
//								System.out.println("Comprador deletado!");
//							}
//						}								
//						//return to default value before if^2
//						entrada_int_vendedores = 2;
//					}	
//		
//					if(entrada_int_vendedores == 3) {
//						System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
//						for(Vendedor vendedor_aux : vendedores){
//							System.out.println(vendedor_aux.toString());
//							System.out.println(" ");
//						}
//					}
//					
//					if(entrada_int_vendedores == 4){
//						System.out.println("FORMATO DE BUSCA -> 12.345.678./0001-00 ");
//						System.out.println("DIGITE O CNPJ QUE DESEJA BUSCAR: ");
//						String entrada_string_vendedores;
//						entrada_string_vendedores = entrada.nextLine();
//						
//						boolean teste = true;
//						for(Vendedor vendedor_aux : vendedores){
//							if(vendedor_aux.getCNPJ().equals(entrada_string_vendedores)){
//								System.out.println("CNPJ ENCONTRADO. INFORMAÇOES: ");
//								System.out.println(vendedor_aux.toString());
//								teste = false;
//								vendedor_aux.menu();
//							}
//						}						
//						if (teste) { 
//							System.out.println("Este CNPJ nao foi encontrado.");
//						}
//					}		