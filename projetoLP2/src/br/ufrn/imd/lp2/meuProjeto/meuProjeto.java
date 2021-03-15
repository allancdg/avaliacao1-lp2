package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;
import java.util.ArrayList;

public class meuProjeto {
	public static void main (String[] args) {		
		int entrada_int_main;													//Variável responsável por receber a opção do Menu Principal
		ArrayList<vendedores> vendedor = new ArrayList<>();						//Vector de vendedores (todos os vendedores cadastrados)	-> Modificar para vendedores[] vendedor = new vendedores[10];
		ArrayList<compradores> comprador = new ArrayList<>();					//Vector de compradores (todos os compradores cadastrados) 	-> Modificar para compradores[] comprador = new compradores[10];
		
		System.out.println("MENU PRINCIPAL");									//INICIO do Menu Principal
		System.out.println("1 - COMPRADORES");
		System.out.println("2 - VENDEDORES");
		System.out.println("3... - SAIR");
		System.out.println("DIGITE A OPÇÃO DESEJADA: ");		
		Scanner entrada = new Scanner(System.in);
		entrada_int_main = entrada.nextInt();									//FIM do Menu Principal
		
		if(entrada_int_main == 1) {												//INICIO das opções do Menu Principal
			int entrada_int_compradores;
				
			System.out.println("MENU PRINCIPAL COMPRADORES");					//INICIO do Menu de Compradores
			System.out.println("1 - ESCOLHER COMPRADOR PARA OPERAR");
			System.out.println("2 - CADASTRAR NOVO COMPRADOR");
			System.out.println("3 - APAGAR COMPRADOR");
			System.out.println("4 - LISTAR TODOS OS COMPRADORES");
			System.out.println("5... - SAIR");
			System.out.println("DIGITE A OPÇÃO DESEJADA: ");
			entrada_int_compradores = entrada.nextInt();						//FIM do Menu de Compradores
				
			if(entrada_int_compradores == 1) {									//INICIO das opções do Menu de Compradores
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: "); 
				System.out.println(comprador);
					
				System.out.println("DIGITE O NÚMERO DO COMPRADOR A OPERAR: " );
				entrada_int_compradores = entrada.nextInt();
					
				comprador.get(entrada_int_compradores).menu();
					
				//return to default value before if^2
				entrada_int_compradores = 1;
					
			}
			else if(entrada_int_compradores == 2) {
				compradores novo_comprador = new compradores();
				comprador.add(novo_comprador.cadastrar());
				
				for(int count=0; count < comprador.size()-1; count ++){			//For para checar se há algum comprador com o mesmo CPF
					if(novo_comprador.getCpf() == comprador.get(count).getCpf()){
						comprador.remove(novo_comprador);
					}
				}
			}
			else if(entrada_int_compradores == 3){
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: "); 
				System.out.println(comprador);
					
				System.out.println("DIGITE O NÚMERO DO COMPRADOR A APAGAR: " );
				entrada_int_compradores = entrada.nextInt();
				
				comprador.remove(entrada_int_compradores);
				
				//return to default value before if^2
				entrada_int_compradores = 3;
			}
			else if(entrada_int_compradores == 4) {
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: "); 
				System.out.println(comprador);
			}
		}																		//FIM das opções do Menu de Compradores
		else if(entrada_int_main == 2) {
			int entrada_int_vendedores;
			
			System.out.println("MENU PRINCIPAL VENDEDORES");					//INICIO do Menu de Vendedores
			System.out.println("1 - ESCOLHER VENDEDOR PARA OPERAR");
			System.out.println("2 - CADASTRAR NOVO VENDEDOR");
			System.out.println("3 - APAGAR VENDEDOR");
			System.out.println("4 - LISTAR TODOS OS VENDEDORES");
			System.out.println("5... - SAIR");
			System.out.println("DIGITE A OPÇÃO DESEJADA: ");
			entrada_int_vendedores = entrada.nextInt();							//FIM do Menu de Vendedores
				
			if(entrada_int_vendedores == 1) {									//INICIO das opções do Menu de Vendedores
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: "); 
				System.out.println(vendedor);
					
				System.out.println("DIGITE O NÚMERO DO COMPRADOR A OPERAR: " );
				entrada_int_vendedores = entrada.nextInt();
					
				vendedor.get(entrada_int_vendedores).menu();
					
				//return to default value before if^2
				entrada_int_vendedores = 1;
					
			}
			else if(entrada_int_vendedores == 2) {
				vendedores novo_vendedor = new vendedores();
				vendedor.add(novo_vendedor.cadastrar());
				
				for(int count=0; count < vendedor.size()-1; count ++) {			//For para checar se há algum vendedor com o mesmo CNPJ
					if(novo_vendedor.getCnpj() == vendedor.get(count).getCnpj()){
						vendedor.remove(novo_vendedor);
					}
				}
			}
			else if(entrada_int_vendedores == 3){
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: "); 
				System.out.println(vendedor);
					
				System.out.println("DIGITE O NÚMERO DO COMPRADOR A APAGAR: " );
				entrada_int_vendedores = entrada.nextInt();
				
				vendedor.remove(entrada_int_vendedores);
				
				//return to default value before if^2
				entrada_int_vendedores = 3;
			}
			else if(entrada_int_vendedores == 4) {
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: "); 
				System.out.println(vendedor);
			}
		}																	//FIM das opções do Menu de Vendedores
	entrada.close();														//Fecha a função Scanner entrada
	}
}
