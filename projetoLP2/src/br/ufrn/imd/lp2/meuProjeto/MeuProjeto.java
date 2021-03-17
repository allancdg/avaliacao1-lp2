package br.ufrn.imd.lp2.meuProjeto;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class MeuProjeto {
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		String entrada_CPF_comprador;
		int entrada_int_vendedores=0;
		int entrada_int_compradores=0;
		int entrada_int_main=0;											//Variavel responsavel por receber a opcao do Menu Principal
		Set<Comprador> compradores = new HashSet<>();					
		Set<Vendedor> vendedores = new HashSet<>();						
		
		//INSERÇAO DE OBJETOS PARA TESTES
		Comprador andre = new Comprador("ANDRE TRIGUEIRO", "111.222.333-44", 10000.00);
		Vendedor allan = new Vendedor("ALLAN CHRISTIAN", "12.345.678./0001-00", 20000.00);
		compradores.add(andre);
		vendedores.add(allan);
		
		while(entrada_int_main < 5){
			//INICIO do Menu Principal
			System.out.println("MENU PRINCIPAL");		
			System.out.println("1 - COMPRADORES");
			System.out.println("2 - VENDEDORES");
			System.out.println("3 - PRODUTOS");
			System.out.println("4 - COMPRA/VENDA");
			System.out.println("5... - SAIR");
			System.out.println("DIGITE A OPCAO DESEJADA: ");
			entrada_int_main = entrada.nextInt();
			entrada.nextLine();
			//FIM do Menu Principal
			
			
			//INICIO opcoes do Menu Principal
			//INICIO do Menu de Compradores
			entrada_int_compradores = 0;
			if(entrada_int_main == 1) {	
				while(entrada_int_compradores < 5){
					System.out.println("MENU PRINCIPAL COMPRADORES");					
					System.out.println("1 - CADASTRAR NOVO COMPRADOR");
					System.out.println("2 - APAGAR COMPRADOR");
					System.out.println("3 - LISTAR TODOS OS COMPRADORES");
					System.out.println("4 - BUSCAR POR CPF");
					System.out.println("5... - VOLTAR");
					System.out.println("DIGITE A OPCAO DESEJADA: ");
					entrada_int_compradores = entrada.nextInt();
					entrada.nextLine();
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
					
					if(entrada_int_compradores == 2){ //apagar comprador
						System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
						for(Comprador comprador_aux : compradores){
							System.out.println(comprador_aux.toString());
							System.out.println(" ");
						}
						
						System.out.println("DIGITE O CPF DO COMPRADOR A APAGAR: ");
						//String entrada_CPF_comprador;
						entrada_CPF_comprador = entrada.nextLine();	
										
						for(Comprador comprador_aux : compradores){
							if(comprador_aux.getCPF().equals(entrada_CPF_comprador)){
								compradores.remove(comprador_aux);
								System.out.println("Comprador deletado!");
							}
						}						
						//return to default value before if^2
						entrada_int_compradores = 2;
					}
					
					if(entrada_int_compradores == 3){ //listar todos os compradores cadastrados
						System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
						for(Comprador comprador_aux : compradores){
							System.out.println(comprador_aux.toString());
							System.out.println(" ");
						}
					}
					
					if(entrada_int_compradores == 4){ //buscar comprador por CPF
						System.out.println("FORMATO DE BUSCA -> 123.456.789-00 ");
						System.out.println("DIGITE O CPF QUE DESEJA BUSCAR: ");
						String entrada_string_compradores;
						entrada_string_compradores = entrada.nextLine();
						System.out.println(entrada_string_compradores);
						boolean teste = true;
						for(Comprador comprador_aux : compradores){
							if(comprador_aux.getCPF().equals(entrada_string_compradores)){
								System.out.println("CPF ENCONTRADO. INFORMAÇOES: ");
								System.out.println(comprador_aux.toString());
								teste = false;
							}
						}						
						if (teste) { 
							System.out.println("Este CPF nao foi encontrado.");
						}
					}
					
					if(entrada_int_compradores == 5) { //listar compras realizadas
						//retorna ao menu anterior
					}
					
					if(entrada_int_compradores == 6) { //listar valores a pagar
						//retorna ao menu anterior
					}	
					
					//FIM das opcoes do Menu de Compradores
				}
			}
			
			else if(entrada_int_main == 2) {
				while(entrada_int_compradores < 8){
					//INICIO do Menu de Vendedores
					System.out.println("MENU PRINCIPAL VENDEDORES");					
					System.out.println("1 - CADASTRAR NOVO VENDEDOR");
					System.out.println("2 - APAGAR VENDEDOR");
					System.out.println("3 - LISTAR TODOS OS VENDEDORES");
					System.out.println("4 - BUSCAR POR CNPJ");
					System.out.println("5... - VOLTAR");
					System.out.println("DIGITE A OPÇAO DESEJADA: ");
					entrada_int_vendedores = entrada.nextInt();		
					entrada.nextLine();
					//FIM do Menu de Vendedores
					
					if(entrada_int_vendedores == 1) {
						Vendedor novo_vendedor = new Vendedor();
						novo_vendedor = novo_vendedor.cadastrar();
						
						boolean teste_duplicado = false;
						
						for(Vendedor vendedor_aux : vendedores) {
							if(vendedor_aux.equals(novo_vendedor)) {
								teste_duplicado = true;
							}
						}
						
						if (teste_duplicado) {
							System.out.println("O CPF informado ja esta cadastrado.");
						}
						else {
							vendedores.add(novo_vendedor);
						}
					}
		
					if(entrada_int_vendedores == 2){
						System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
						for(Vendedor vendedor_aux : vendedores){
							System.out.println(vendedor_aux.toString());
							System.out.println(" ");
						}
							
						System.out.println("DIGITE O CPF DO VENDEDOR A APAGAR: " );
						String entrada_CNPJ_vendedores;
						entrada_CNPJ_vendedores = entrada.nextLine();				
						for(Vendedor vendedor_aux : vendedores){
							if(vendedor_aux.getCNPJ().equals(entrada_CNPJ_vendedores)){
								vendedores.remove(vendedor_aux);
								System.out.println("Comprador deletado!");
							}
						}								
						//return to default value before if^2
						entrada_int_vendedores = 2;
					}	
		
					if(entrada_int_vendedores == 3) {
						System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
						for(Vendedor vendedor_aux : vendedores){
							System.out.println(vendedor_aux.toString());
							System.out.println(" ");
						}
					}
					
					if(entrada_int_vendedores == 4){
						System.out.println("FORMATO DE BUSCA -> 12.345.678./0001-00 ");
						System.out.println("DIGITE O CNPJ QUE DESEJA BUSCAR: ");
						String entrada_string_vendedores;
						entrada_string_vendedores = entrada.nextLine();
						
						boolean teste = true;
						for(Vendedor vendedor_aux : vendedores){
							if(vendedor_aux.getCNPJ().equals(entrada_string_vendedores)){
								System.out.println("CNPJ ENCONTRADO. INFORMAÇOES: ");
								System.out.println(vendedor_aux.toString());
								teste = false;
							}
						}						
						if (teste) { 
							System.out.println("Este CPF nao foi encontrado.");
						}
					}		
				}//FIM do While de leitura Vendedores			
			}//FIM do Menu Vendedores
			entrada.close(); //Fecha a funcao Scanner entrada													
		}//FIM do While de leitura Principal
	}
}