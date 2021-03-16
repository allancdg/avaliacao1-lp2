package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;
import java.util.ArrayList;

public class meuProjeto {
	public static void main (String[] args) {		
		int entrada_int_main;													//Vari�vel respons�vel por receber a op��o do Menu Principal
		ArrayList<vendedores> vendedor = new ArrayList<>();						//Vector de vendedores (todos os vendedores cadastrados)	-> Modificar para vendedores[] vendedor = new vendedores[10];
		ArrayList<compradores> comprador = new ArrayList<>();					//Vector de compradores (todos os compradores cadastrados) 	-> Modificar para compradores[] comprador = new compradores[10];
		
		System.out.println("MENU PRINCIPAL");									//INICIO do Menu Principal
		System.out.println("1 - COMPRADORES");
		System.out.println("2 - VENDEDORES");
		System.out.println("3 - COMPRA/VENDA");
		System.out.println("4... - SAIR");
		System.out.println("DIGITE A OP��O DESEJADA: ");		
		Scanner entrada = new Scanner(System.in);
		entrada_int_main = entrada.nextInt();									//FIM do Menu Principal
		
		if(entrada_int_main == 1) {												//INICIO das op��es do Menu Principal
			int entrada_int_compradores;				
			System.out.println("MENU PRINCIPAL COMPRADORES");					//INICIO do Menu de Compradores
			System.out.println("1 - CADASTRAR NOVO COMPRADOR");
			System.out.println("2 - APAGAR COMPRADOR");
			System.out.println("3 - LISTAR TODOS OS COMPRADORES");
			System.out.println("4 - BUSCAR POR CPF");
			System.out.println("5... - VOLTAR");
			System.out.println("DIGITE A OP��O DESEJADA: ");
			entrada_int_compradores = entrada.nextInt();						//FIM do Menu de Compradores
				
			if(entrada_int_compradores == 1) {
				compradores novo_comprador = new compradores();
				comprador.add(novo_comprador.cadastrar());
				
				for(int count=0; count < comprador.size()-1; count ++){			//For para checar se h� algum comprador com o mesmo CPF
					if(novo_comprador.getCpf() == comprador.get(count).getCpf()){
						comprador.remove(novo_comprador);
					}
				}
			}
			else if(entrada_int_compradores == 2){
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
				System.out.println("ID / NOME / CPF / SALDO");
				for(int count=0; count < comprador.size(); count ++){
					System.out.println(count);
					comprador.get(count).show_info(); 
				}
					
				System.out.println("DIGITE O N�MERO DO COMPRADOR A APAGAR: " );
				entrada_int_compradores = entrada.nextInt();				
				comprador.remove(entrada_int_compradores);
				
				//return to default value before if^2
				entrada_int_compradores = 2;
			}
			else if(entrada_int_compradores == 3){
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
				System.out.println("ID / NOME / CPF / SALDO");
				for(int count=0; count < comprador.size(); count ++){
					System.out.println(count);
					comprador.get(count).show_info(); 
				}
			}
			else if(entrada_int_compradores == 4){
				System.out.println("FORMATO DE BUSCA -> 123.456.789-00 ");
				System.out.println("DIGITE O CPF QUE DESEJA BUSCAR: ");
				String entrada_string_compradores;
				entrada_string_compradores = entrada.nextLine();
				
				for(int count=0; count < comprador.size(); count ++){
					if(comprador.get(count).getCpf() == entrada_string_compradores){
						comprador.get(count).show_info(); 
					}
				}
			}
			else if(entrada_int_compradores == 5){
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
				System.out.println("ID / NOME / CPF");
				for(int count=0; count < comprador.size(); count ++){
					System.out.println(count);
					comprador.get(count).show_info(); 
				}
				System.out.println("DIGITE O N�MERO DO COMPRADOR A OPERAR: " );
				entrada_int_compradores = entrada.nextInt();
				
				comprador.get(entrada_int_compradores).menu();
				
				//return to default value before if^2
				entrada_int_compradores = 5;
			}																	//FIM das op��es do Menu de Compradores
		}
		else if(entrada_int_main == 2) {
			int entrada_int_vendedores;
			
			System.out.println("MENU PRINCIPAL VENDEDORES");					//INICIO do Menu de Vendedores
			System.out.println("1 - CADASTRAR NOVO VENDEDOR");
			System.out.println("2 - APAGAR VENDEDOR");
			System.out.println("3 - LISTAR TODOS OS VENDEDORES");
			System.out.println("4 - OPERAR VENDEDOR");
			System.out.println("5... - SAIR");
			System.out.println("DIGITE A OP��O DESEJADA: ");
			entrada_int_vendedores = entrada.nextInt();							//FIM do Menu de Vendedores
				
			if(entrada_int_vendedores == 1) {
				vendedores novo_vendedor = new vendedores();
				vendedor.add(novo_vendedor.cadastrar());
				
				for(int count=0; count < vendedor.size()-1; count ++) {			//For para checar se h� algum vendedor com o mesmo CNPJ
					if(novo_vendedor.getCnpj() == vendedor.get(count).getCnpj()){
						vendedor.remove(novo_vendedor);
					}
				}
			}
			else if(entrada_int_vendedores == 2){
				System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
				System.out.println("ID / NOME / CNPJ / SALDO");
				for(int count=0; count < vendedor.size(); count ++){
					System.out.println(count);
					vendedor.get(count).show_info(); 
				}
					
				System.out.println("DIGITE O N�MERO DO VENDEDOR A APAGAR: " );
				entrada_int_vendedores = entrada.nextInt();
								
				vendedor.remove(entrada_int_vendedores);
				
				//return to default value before if^2
				entrada_int_vendedores = 2;
			}
			else if(entrada_int_vendedores == 3) {
				System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
				System.out.println("ID / NOME / CNPJ / SALDO");
				for(int count=0; count < vendedor.size(); count ++){
					System.out.println(count);
					vendedor.get(count).show_info(); 
				}
			}
			else if(entrada_int_vendedores == 4){
				System.out.println("FORMATO DE BUSCA -> 12.345.678./0001-00 ");
				System.out.println("DIGITE O CNPJ QUE DESEJA BUSCAR: ");
				String entrada_string_vendedores;
				entrada_string_vendedores = entrada.nextLine();
				
				for(int count=0; count < vendedor.size(); count ++){
					if(vendedor.get(count).getCnpj() == entrada_string_vendedores){
						vendedor.get(count).show_info(); 
					}
				}
			}
			else if(entrada_int_vendedores == 5){
				System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
				System.out.println("ID / NOME / CNPJ / SALDO");
				for(int count=0; count < vendedor.size(); count ++){
					System.out.println(count);
					vendedor.get(count).show_info(); 
				}
				System.out.println("DIGITE O N�MERO DO VENDEDOR A OPERAR: " );
				entrada_int_vendedores = entrada.nextInt();
				
				vendedor.get(entrada_int_vendedores).menu();
												
				//return to default value before if^2
				entrada_int_vendedores = 5;
			}
		}																	//FIM das op��es do Menu de Vendedores
	entrada.close();														//Fecha a fun��o Scanner entrada
	}
}
