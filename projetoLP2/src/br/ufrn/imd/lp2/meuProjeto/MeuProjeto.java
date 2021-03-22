package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class MeuProjeto {
	
	public static void main (String[] args) {
		menus();
	}
	
	public static void menus() {
		//COLECOES DE OBJETOS PRINCIPAIS
		Set<Comprador> compradores = new HashSet<>();					
		Set<Vendedor> vendedores = new HashSet<>();						
		
		//INSERCAO DE OBJETOS PARA TESTES
//		Comprador andre = new Comprador("ANDRE TRIGUEIRO", "111.222.333-44", 10000.00);
//		Vendedor allan = new Vendedor("ALLAN CHRISTIAN", "12.345.678/0001-00", 20000.00);
//		compradores.add(andre);
//		vendedores.add(allan);
		
		//INICIANDO O SCANNER
		Scanner entrada = new Scanner(System.in);
		int entrada_int_main = 0;	//Variavel responsavel por receber a opcao do Menu Principal
		do {
			//MENU PRIMARIO - MENU PRINCIPAL
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
					System.out.println("5 - VOLTAR");
					System.out.println("DIGITE A OPCAO DESEJADA: ");
					entrada_int_compradores = Integer.parseInt(entrada.nextLine());
					
					//OPCAO 01 - CADASTRAR NOVO COMPRADOR
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
					
					//OPCAO 02 - APAGAR COMPRADOR JA CADASTRADO
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
						//PERCORRENDO COMPRADORES ATÃ‰ ACHAR O SELECIONADO			
						for(Comprador comprador_aux : compradores){
							if(comprador_aux.getCPF().equals(entrada_CPF_comprador)){
								System.out.println(comprador_aux.toString());
								compradores.remove(comprador_aux);
								System.out.println("Comprador deletado!");
							}
						}						
					}
					
					//OPCAO 03 - LISTAR TODOS OS COMPRADORES
					else if(entrada_int_compradores == 3){
						System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
						for(Comprador comprador_aux : compradores){
							System.out.println(comprador_aux.toString());
							System.out.println(" ");
						}
					}
					
					//OPCAO 04 - BUSCAR E ACESSAR POR CPF
					else if(entrada_int_compradores == 4){
						System.out.println("FORMATO DE BUSCA -> 123.456.789-00 ");
						System.out.println("DIGITE O CPF QUE DESEJA BUSCAR: ");
						String entrada_string_compradores;
						entrada_string_compradores = entrada.nextLine();

						boolean teste = true;
						//FOR EACH PERCORRENDO O CONJUNTO DE COMPRADORES E CONFERINDO SE O CPF INFORMADO FOI ENCONTRADO
						for(Comprador comprador_aux : compradores){
							if(comprador_aux.getCPF().equals(entrada_string_compradores)){
								System.out.println("CPF ENCONTRADO.\nINFORMACOES: ");
								System.out.println(comprador_aux.toString());
								comprador_aux.menu(comprador_aux);
								teste = false;
							}
						}
						if (teste) { 
							System.out.println("Este CPF nao foi encontrado.");
						}
					}
					else if(entrada_int_compradores == 5){ }
					else {System.out.println("OPCAO INVALIDA! ");}
				} while (entrada_int_compradores != 5);		//FIM DO MENU SECUNDARIOS DE COMPRADORES	
			}
			
			//MENU SECUNDARIO - VENDEDORES
			else if (entrada_int_main == 2) {
				int entrada_int_vendedores = 0;
				//MENU ESPECIFICO DE VENDEDORES
				do {
					System.out.println("\n->> MENU PRINCIPAL VENDEDORES");					
					System.out.println("1 - CADASTRAR NOVO VENDEDOR");
					System.out.println("2 - APAGAR VENDEDOR");
					System.out.println("3 - LISTAR TODOS OS VENDEDORES");
					System.out.println("4 - BUSCAR E ACESSAR POR CNPJ");
					System.out.println("5 - VOLTAR");
					System.out.println("DIGITE A OPCAO DESEJADA: ");
					entrada_int_vendedores = Integer.parseInt(entrada.nextLine());
					//OPCAO 1 - CADASTRAR NOVO VENDEDOR
					if(entrada_int_vendedores == 1){
						Vendedor novo_vendedor = new Vendedor();
						novo_vendedor = novo_vendedor.cadastrar();
						
						boolean teste_duplicado = false;
						
						for(Vendedor vendedor_aux : vendedores) {
							if(vendedor_aux.equals(novo_vendedor)) {
								teste_duplicado = true;
							}
						}
						
						if (teste_duplicado) {
							System.out.println("O CNPJ informado ja esta cadastrado.");
						}
						else {
							vendedores.add(novo_vendedor);
						}
					}
					//OPCAO 2 - APAGAR VENDEDOR
					else if(entrada_int_vendedores == 2){ System.out.println("OPCAO EM DESENVOLVIMENTO"); }
					//OPCAO 3 - LISTAR TODOS OS VENDEDORES
					else if(entrada_int_vendedores == 3){
						System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
						for(Vendedor vendedor_aux : vendedores){
							System.out.println(vendedor_aux.toString());
							System.out.println(" ");
						}
					}
					//OPCAO 4 - BUSCAR E ACESSAR POR CNPJ
					else if(entrada_int_vendedores == 4){
						System.out.println("FORMATO DE BUSCA -> 12.345.678/0001-00 ");
						System.out.println("DIGITE O CNPJ QUE DESEJA BUSCAR: ");
						String entrada_string_vendedores;
						entrada_string_vendedores = entrada.nextLine();
						
						boolean teste = true;
						for(Vendedor vendedor_aux : vendedores){
							if(vendedor_aux.getCNPJ().equals(entrada_string_vendedores)){
								System.out.println("CNPJ ENCONTRADO. INFORMACOES: \n");
								System.out.println(vendedor_aux.toString());
								teste = false;
								vendedor_aux.menu();
							}
						}						
						if (teste) { 
							System.out.println("Este CNPJ nao foi encontrado.");
						}
					}
					//OPCAO 5 - VOLTAR
					else if(entrada_int_vendedores == 5){ }
					else {System.out.println("OPCAO INVALIDA! ");}
				}while(entrada_int_vendedores != 5);
			}
			
			//MENU SECUNDARIO - COMPRA/VENDA
			else if (entrada_int_main == 3) {
				String entrada_string_compra_comprador;
				String entrada_string_venda_vendedor;
				int entrada_int_menu_pagamento = 0;
				Comprador comprador_venda = new Comprador();
				Vendedor vendedor_venda = new Vendedor();
				boolean teste = true;
				
				System.out.println("\t\t>> VENDA <<");
			
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
				for(Comprador comprador_aux : compradores){
					System.out.println(comprador_aux.toString());
					System.out.println(" ");
				}
				
				// COMEÇO DO | WHILE  -> REPETIÇÃO ENQUANTO NÃO DIGITAR UM CPF QUE LOCALIZE UM COMPRADOR
				do{
					System.out.println("DIGITE O CPF REFERENTE AO COMPRADOR DESTA VENDA: ");
					entrada_string_compra_comprador = entrada.nextLine();
					
					//FOR EACH PERCORRENDO O CONJUNTO DE COMPRADORES E CONFERINDO SE O CPF INFORMADO FOI ENCONTRADO					
					for(Comprador comprador_aux : compradores){
						if(comprador_aux.getCPF().equals(entrada_string_compra_comprador)){
							comprador_venda = comprador_aux;
							System.out.println("Comprador: " + comprador_aux.getNome() + ", foi selecionado!\n\n");
							teste = false;
						}
					}
					if (teste) { 
						System.out.println("Este CPF nao foi encontrado.");
					}
				} while(teste == true);
				// FIM DO | WHILE  -> REPETIÇÃO ENQUANTO NÃO DIGITAR UM CPF QUE LOCALIZE UM COMPRADOR
				
				System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
				for(Vendedor vendedor_aux : vendedores){
					System.out.println(vendedor_aux.toString());
					System.out.println(" ");
				}
				
				teste = true;
				// COMEÇO DO | WHILE  -> REPETIÇÃO ENQUANTO NÃO DIGITAR UM CNPJ QUE LOCALIZE UM VENDEDOR
				do{
					System.out.println("DIGITE O CNPJ REFERENTE AO VENDEDOR DESTA VENDA: ");
					entrada_string_venda_vendedor = entrada.nextLine();
					
					//FOR EACH PERCORRENDO O CONJUNTO DE COMPRADORES E CONFERINDO SE O CPF INFORMADO FOI ENCONTRADO					
					for(Vendedor vendedor_aux : vendedores){
						if(vendedor_aux.getCNPJ().equals(entrada_string_venda_vendedor)){
							vendedor_venda = vendedor_aux;
							System.out.println("Comprador: " + vendedor_aux.getNome() + ", foi selecionado!\n\n");
							teste = false;
						}
					}
					if (teste) { 
						System.out.println("Este CNPJ nao foi encontrado.");
					}
				} while(teste == true);
				// FIM DO | WHILE  -> REPETIÇÃO ENQUANTO NÃO DIGITAR UM CNPJ QUE LOCALIZE UM VENDEDOR
				
				System.out.println("REALIZANDO COMPRA/VENDA ENTRE:\nComprador: " + comprador_venda.getNome() + "\nVendedor: " + vendedor_venda.getNome());
				System.out.println(">> CATALOGO DE PRODUTOS <<");
				int id = 1;
				for (Produto produto_aux : vendedor_venda.getCatalogo_produtos()) {
					System.out.println( "ID: " + id + "\n" + produto_aux.toString());
					id++;
				}
				
				teste = true;
				List<Produto> produtos_compra = new ArrayList<Produto>();
				double valor_total=0;
				// COMEÇO DO PROCESSO DE VENDA
				do{
					id = 1;
					int i=0;
					int qtd=0;
					
					System.out.println("\nDIGITE O ID DO ITEM A COMPRAR: [0 - PROSSEGUIR PARA PAGAMENTO]");
					id = Integer.parseInt(entrada.nextLine());
					if(id != 0) {
						System.out.println("\nQUANTIDADE: ");
						qtd = Integer.parseInt(entrada.nextLine());
						
						for(i=0; i<qtd; i++) {
							produtos_compra.add(vendedor_venda.getCatalogo_produtos().get(id-1));
							valor_total += vendedor_venda.getCatalogo_produtos().get(id-1).getPreco_unitario();
						}
					}else { 
						vendedor_venda.setVendas_realizada(valor_total);	//Armazena o valor da venda no vendedor
						comprador_venda.setCompras_realizadas(valor_total);	//Armazena o valor da venda no comprador
						teste = false;
					}
				} while (teste == true);
				// FIM DO PROCESSO DE VENDA
							
				// COMECO DO PROCESSO DE PAGAMENTO
				//IMPRESSAO DOS ITENS SELECIONADOS E VALOR FINAL
				System.out.println("Extrato: ");
				for(Produto produto_aux : produtos_compra) {
					System.out.println( "ITEM: " + id + "\n" + produto_aux.toString());
					id++;
				}
				System.out.println("\nVALOR FINAL: R$" + valor_total + "\n\n\n");
				teste = true;
				do{
					System.out.println("OPCOES DE PAGAMENTO:\n1 - PIX\n2 - BOLETO\n3 - DEBITO\n4 - CREDITO\n0 - CANCELAMENTO DA COMPRA\nESCOLHA A OPCAO DE PAGAMENTO: ");
					entrada_int_menu_pagamento = Integer.parseInt(entrada.nextLine());
					
					if(entrada_int_menu_pagamento == 1) {
						if(vendedor_venda.getSaldo() - valor_total >= 0) {
							comprador_venda.setSaldo(vendedor_venda.getSaldo() - valor_total);
							vendedor_venda.setSaldo(vendedor_venda.getSaldo()+valor_total);
							
							comprador_venda.setCompras_realizadas(valor_total);
							vendedor_venda.setVendas_realizada(valor_total);
						}						
						System.out.println("\nPAGAMENTO REALIZADO VIA PIX\n");
						teste = false;					
					}
					
					else if(entrada_int_menu_pagamento == 2) {
						//A SER IMPLEMENTADO
						System.out.println("\nSISTEMA DE BOLETO ESTÁ FORA DO AR!\n");
					}
					
					else if(entrada_int_menu_pagamento == 3) {
						if(vendedor_venda.getSaldo() - valor_total >= 0) {
							comprador_venda.setSaldo(comprador_venda.getSaldo() - valor_total);
							vendedor_venda.setSaldo(vendedor_venda.getSaldo()+valor_total*0.97);
							
							comprador_venda.setCompras_realizadas(valor_total);
							vendedor_venda.setVendas_realizada(valor_total);
						}						
						System.out.println("\nPAGAMENTO REALIZADO VIA DÉBITO\nTAXA DO CARTÃO: 3%\nVALOR DO CARTÃO: R$" + valor_total*0.97);
						teste = false;	
					}
					
					else if(entrada_int_menu_pagamento == 4) {
						comprador_venda.setValores_pagar(valor_total);
						vendedor_venda.setValores_receber(valor_total*0.95);
						
						comprador_venda.setCompras_realizadas(valor_total);
						comprador_venda.setValores_pagar(valor_total);
						vendedor_venda.setVendas_realizada(valor_total);
						vendedor_venda.setValores_receber(valor_total);
						
						System.out.println("\nPAGAMENTO REALIZADO VIA CREDITO\nTAXA DO CARTÃO: 5%\nVALOR DO CARTÃO: R$" + valor_total*0.95);
						teste = false;	
					}
					
					else if(entrada_int_menu_pagamento == 0) {
						teste = false;
					}
					
					else { System.out.println("\nOPCAO INVALIDA!\n"); }
					
				} while(teste == true);
			}
			//MENU SECUNDARIO - NUMERO INFORMADO NAO CORRESPONDE A NENHUMA OPCAO
		} while (entrada_int_main != 0); // FIM DO MENU PRINCIPAL
		//FINALIZANDO O SCANNER
		entrada.close();													
	}
}	