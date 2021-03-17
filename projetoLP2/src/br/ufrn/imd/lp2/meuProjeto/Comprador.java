package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Comprador extends Pessoa {
	private Set<Double> valores_pagar = new HashSet<>();			
	private Set<Produto> compras_realizadas = new HashSet<>(); 			
	
	public Comprador() {} //Construtor padrao
	public Comprador(String nome, String CPF, double saldo_conta) { //Construtor parametrizado
		super(nome, CPF, saldo_conta);
	}
	
	//Setters
	//----
		
	//Getters
	public Set<Double> getValores_pagar() {
		return valores_pagar;
	}	
	public Set<Produto> getCompras_realizadas() {
		return compras_realizadas;
	}	

	//INICIO Metodos auxiliares

	//Metodo para mostrar informaçoes
	public String toString() { 
		String retorno = "Nome: " + super.nome;
		retorno += "\n CPF: " + super.CPF;
		retorno += "\nSaldo em conta: " + super.saldo_conta;
		return retorno;
	}
	
	//Metodo para comparar os CPFS
	public boolean equals(Object other) {
		if (other == null || !other.getClass().equals(Comprador.class)) {
			return false;
		} 
	 	Comprador otherCompradores = (Comprador) other;
		return otherCompradores.CPF.equals(this.CPF);
	}
	
	//Metodo auxiliar do HashCode
	public int hashCode() { 
		return this.CPF.hashCode();
	}
	//FIM dos auxiliares
	  
	//INICIO Funções de Menus
	//Menu de cadastramento
	public Comprador cadastrar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("CADASTRAMENTO DE COMPRADOR");
		System.out.println("NOME: ");
		String nome_aux = entrada.nextLine();
		System.out.println("CPF: ");
		String CPF_aux = entrada.nextLine();
		System.out.println("SALDO INICIAL: ");
		double saldo_conta_aux = entrada.nextDouble();

		Comprador comprador = new Comprador(nome_aux, CPF_aux, saldo_conta_aux);
		entrada.close();

		return comprador;
	}

	//Menu de navegaçao
	public void menu(){
		Scanner entrada = new Scanner(System.in);
		int opcao;
		System.out.println("MENU OPERACIONAL DO COMPRADOR " + getNome()) ;
		System.out.println("1 - INFORMAÇOES DO COMPRADOR");
		System.out.println("2 - LISTAR VALORES A PAGAR");
		System.out.println("3 - LISTAR COMPRAS REALIZADAS");
		System.out.println("4 - VOLTAR");
		opcao = entrada.nextInt();
		
		if(opcao == 1) {
			System.out.println(toString());
		}
		else if(opcao == 2){
			double soma_valores_pagar = 0.0;
			System.out.println("VALORES A PAGAR: ");
			for(Double valores: this.valores_pagar){
				System.out.println("R$" + valores);
				soma_valores_pagar += valores;
			}
			System.out.println("Total: R$"+ soma_valores_pagar);
		}
		else if(opcao == 3){
			System.out.println("COMPRAS REALIZADAS: ");
			for(Produto produtos_comprados: this.compras_realizadas){
				System.out.println(produtos_comprados.toString());
			}
		}		
		entrada.close();
	}
	//Fim dos menus
}