package br.ufrn.imd.lp2.meuProjeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class compradores {
	private String nome;
	private String cpf;
	private double saldo_conta;
	private List<Double> valores_pagar = new ArrayList<>();			//Faltando implementar compra/venda
	private List<produtos> compras = new ArrayList<>(); 			//Faltando implementar compra/venda
	
	public compradores() {} //Construtor padrão
	public compradores(String nome, String cpf, double saldo_conta) { //Construtor parametrizado
		this.nome = nome;
		this.cpf = cpf;
		this.saldo_conta = saldo_conta;
	}
	
	//Setters
	//----
		
	//Getters
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public double getSaldo_conta() {
		return saldo_conta;
	}
	public List<Double> getValores_pagar() {
		return valores_pagar;
	}	
	public List<produtos> getCompras() {
		return compras;
	}	

	public compradores cadastrar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("CADASTRAMENTO DE COMPRADOR");
		System.out.println("NOME: ");
		nome = entrada.nextLine();
		System.out.println("CPF: ");
		cpf = entrada.nextLine();
		System.out.println("SALDO INICIAL: ");
		saldo_conta = entrada.nextDouble();
		
		compradores comprador = new compradores(nome, cpf, saldo_conta);
		entrada.close();
		return comprador;
	}
	
	public void show_info(){
		System.out.println(nome + " " + cpf + " "  + "R$"+ saldo_conta);
	}
	
	public void menu(){
		Scanner entrada = new Scanner(System.in);
		int opcao;
		System.out.println("MENU OPERACIONAL DO COMPRADOR " + nome);
		System.out.println("1 - INFORMAÇÕES DO COMPRADOR");
		System.out.println("2 - LISTAR VALORES A PAGAR");
		System.out.println("3 - LISTAR COMPRAS");
		System.out.println("4... - VOLTAR");
		opcao = entrada.nextInt();
		
		if(opcao == 1) {
			System.out.println("NOME / CPF / SALDO");
			show_info();
		}
		else if(opcao == 2){
			double soma_valores_pagar = 0.0;
			System.out.println("VALORES A PAGAR: ");
			for(int count=0; count < valores_pagar.size(); count ++){
				System.out.println("R$"+valores_pagar.get(count));
				soma_valores_pagar += valores_pagar.get(count);
			}
			System.out.println("Total: R$"+ soma_valores_pagar);
		}
		else if(opcao == 3){
			System.out.println("Compras realizadas: ");
			for(int count=0; count < compras.size(); count ++){
				System.out.println("Item: " + compras.get(count).getNome() + "; Valor: R$" + compras.get(count).getPreco_unitario());
			}
		}
		entrada.close();
	}
}
