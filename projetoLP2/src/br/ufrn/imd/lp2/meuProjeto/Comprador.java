package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Comprador extends Pessoa {
	private String CPF;
	private Set<Double> valores_pagar = new HashSet<>();			
	private Set<Double> compras_realizadas = new HashSet<>(); 			
	
	public Comprador() {} //Construtor padrao
	public Comprador(String nome, String CPF, double saldo_conta) { //Construtor parametrizado
		super(nome, saldo_conta);
		this.CPF = CPF;
	}
	public Comprador(String nome, String CPF){
		super(nome);
		this.CPF = CPF;
	}
	
	//Setters
	public void setValores_pagar(double valor){
		this.valores_pagar.add(valor);
	}
	
	public void setCompras_realizadas(double valor){
		this.compras_realizadas.add(valor);
	}
		
	//Getters
	
	public String getCPF() {
		return CPF;
	}
	public Set<Double> getValores_pagar() {
		return valores_pagar;
	}	
	public Set<Double> getCompras_realizadas() {
		return compras_realizadas;
	}	

	//INICIO Metodos auxiliares

	//Metodo para mostrar informaçoes
	public String toString() { 
		String retorno = "Nome: " + super.nome;
		retorno += "\nCPF: " + this.CPF;
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
	  
	//INICIO Funcoes de Menus
	//Menu de cadastramento
	public Comprador cadastrar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("#CADASTRAMENTO DE COMPRADOR");
		System.out.println("NOME: ");
		String nome_aux = entrada.nextLine();
		System.out.println("CPF: ");
		String CPF_aux = entrada.nextLine();
		System.out.println("SALDO INICIAL: ");
		double saldo_conta_aux;
		saldo_conta_aux = entrada.nextDouble();

		Comprador comprador = new Comprador(nome_aux, CPF_aux, saldo_conta_aux);

		return comprador;
	}

	//Menu de navegaçao
	public void menu(Comprador comprador){
		Scanner entrada = new Scanner(System.in);
		int opcao;
		System.out.println("\n#MENU OPERACIONAL DO COMPRADOR " + getNome()) ;
		System.out.println("1 - INFORMACOES DO COMPRADOR");
		System.out.println("2 - LISTAR VALORES A PAGAR");
		System.out.println("3 - LISTAR COMPRAS REALIZADAS");
		System.out.println("4 - VOLTAR");
		opcao = entrada.nextInt();
		entrada.nextLine(); //Limpeza de buffer
		
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
			for(double compras: this.compras_realizadas){
				System.out.println("R$" + compras);
			}
		}		
		//entrada.close();
	}
	//Fim dos menus
}
