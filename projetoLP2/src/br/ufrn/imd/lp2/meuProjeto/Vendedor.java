package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Vendedor {
	
	private String nome;
	private String cnpj;
	private double saldo_conta;
	private ArrayList<Double> valores_receber = new ArrayList<>();			//Faltando implementar compra/venda
	private ArrayList<Produto> vendas = new ArrayList<>();					//Faltando implementar compra/venda
	private ArrayList<Produto> catalogo_produtos = new ArrayList<>();	
	
	public Vendedor() {}	//Construtor padr�o
	public Vendedor(String nome, String cnpj) { //Construtor parametrizado
		this.nome = nome;
		this.cnpj = cnpj;
		this.saldo_conta = 0.0;
	}
	
	//Setters
	//---
	
	//Getters
	public String getNome() {
		return nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public double getSaldo_conta() {
		return saldo_conta;
	}
	public List<Double> getValores_receber() {
		return valores_receber;
	}
	public List<Produto> getVendas() {
		return vendas;
	}
	public List<Produto> getCatalogo_produtos() {
		return catalogo_produtos;
	}	
	
	public Vendedor cadastrar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("CADASTRAMENTO DE VENDEDOR");
		System.out.println("NOME: ");
		nome = entrada.nextLine();
		System.out.println("CNPJ: ");
		cnpj = entrada.nextLine();
		
		Vendedor vendedor = new Vendedor(nome, cnpj);
		entrada.close();
		return vendedor;
	}
	
	public void show_info(){
		System.out.println(nome + " " + cnpj + " " + "R$" + saldo_conta);	
	}
	
	public void menu(){
		Scanner entrada = new Scanner(System.in);
		int opcao;
		System.out.println("MENU OPERACIONAL DO VENDEDOR " + nome);
		System.out.println("1 - CADASTRAR PRODUTOS");
		System.out.println("2 - INFORMA��ES DO VENDEDOR");
		System.out.println("3 - LISTAR VALORES A RECEBER");
		System.out.println("4 - LISTAR VENDAS");
		System.out.println("5 - CATALOGO DE PRODUTOS");
		System.out.println("6... - VOLTAR");
		opcao = entrada.nextInt();
		
		if(opcao == 1) {
			Produto novo_produto = new Produto();
			catalogo_produtos.add(novo_produto.cadastrar());
		}
		else if(opcao == 2){
			System.out.println("INFORMA��ES DO VENDEDOR: ");
			System.out.println("NOME / CNPJ / SALDO");
			show_info();
		}
		else if(opcao == 3){
			double soma_valores_receber = 0.0;
			System.out.println("VALORES A RECEBER: ");
			for(int count=0; count < valores_receber.size(); count ++){
				System.out.println("R$"+valores_receber.get(count));
				soma_valores_receber += valores_receber.get(count);
			}
			System.out.println("Total: R$"+ soma_valores_receber);
		}
		else if(opcao == 4){
			System.out.println("VENDAS REALIZADAS: ");
			for(int count=0; count < vendas.size(); count ++){
				System.out.println("Item: " + vendas.get(count).getNome() + "; R$" + vendas.get(count).getPreco_unitario());
			}
		}
		else if(opcao == 5){
			System.out.println("CATALOGO DE PRODUTOS: ");
			for(int count=0; count < catalogo_produtos.size(); count ++){
				System.out.println("Cod.: " + catalogo_produtos.get(count).getCodigo() + "; Item: " + catalogo_produtos.get(count).getNome() + "; R$" + catalogo_produtos.get(count).getPreco_unitario());
			}
		}
		entrada.close();
	}
}