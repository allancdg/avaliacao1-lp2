package br.ufrn.imd.lp2.meuProjeto;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Pessoa {
	private String CNPJ;
	private Set<Double> valores_receber = new HashSet<>();
	private Set<Double> vendas_realizadas = new HashSet<>(); 			
	private List<Produto> catalogo_produtos = new ArrayList<Produto>(); 			
	
	public Vendedor() {} //Construtor padrao
	public Vendedor(String nome, String CNPJ, double saldo_conta) { //Construtor parametrizado
		super(nome, saldo_conta);
		this.CNPJ = CNPJ;
	}
	public Vendedor(String nome, String CNPJ){
		super(nome);
		this.CNPJ = CNPJ;
	}
	
	//Setters
	public void setVendas_realizada(double valor){
		this.vendas_realizadas.add(valor);
	}
	
	public void setValores_receber(double valor) {
		this.valores_receber.add(valor);
	}
	
	//Getters
	public String getCNPJ() {
		return CNPJ;
	}
	
	public Set<Double> getValores_receber() {
		return valores_receber;
	}
	
	public Set<Double> getVendas_realizadas() {
		return vendas_realizadas;
	}
	
	public List<Produto> getCatalogo_produtos(){
		return catalogo_produtos;
	}
	
	//INICIO Metodos auxiliares
	//Metodo para mostrar informaçoes
	public String toString() { 
		String retorno = "Nome: " + super.nome;
		retorno += "\nCNPJ: " + this.CNPJ;
		retorno += "\nSaldo em conta: " + super.saldo_conta;
		return retorno;
	}
	
	//Metodo para comparar os CNPJS
	public boolean equals(Object other) {
		if (other == null || !other.getClass().equals(Vendedor.class)) {
			return false;
		} 
	 	Vendedor otherVendedores = (Vendedor) other;
		return otherVendedores.CNPJ.equals(this.CNPJ);
	}
	
	//Metodo auxiliar do HashCode
	public int hashCode() { 
		return this.CNPJ.hashCode();
	}
	//FIM dos auxiliares
	  
	//INICIO Funcoes de Menus
	//Menu de cadastramento
	public Vendedor cadastrar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("\n#CADASTRAMENTO DE VENDEDOR");
		System.out.println("NOME: ");
		String nome_aux = entrada.nextLine();
		System.out.println("CNPJ: ");
		String CNPJ_aux = entrada.nextLine();
		System.out.println("SALDO INICIAL: ");
		double saldo_conta_aux;
		saldo_conta_aux = entrada.nextDouble();

		Vendedor vendedor = new Vendedor(nome_aux, CNPJ_aux, saldo_conta_aux);

		return vendedor;
	}
	
	//Menu de navegacao
	public void menu(){
		Scanner entrada = new Scanner(System.in);
		int opcao;
		do{
			System.out.println("\n#MENU OPERACIONAL DO VENDEDOR " + nome);
			System.out.println("1 - INFORMACOES DO VENDEDOR");
			System.out.println("2 - CADASTRAR PRODUTOS");
			System.out.println("3 - CATALOGO DE PRODUTOS");
			System.out.println("4 - LISTAR VALORES A RECEBER");
			System.out.println("5 - LISTAR VENDAS REALIZADAS");
			System.out.println("6 - VOLTAR");
			System.out.println("DIGITE A OPCAO DESEJADA: ");
			opcao = entrada.nextInt();
			
			if(opcao == 1) {
				toString();
			}
			
			else if(opcao == 2){
				Produto novo_produto = new Produto();
				catalogo_produtos.add(novo_produto.cadastrar());
			}
			
			else if(opcao == 3){
				System.out.println("CATALOGO DE PRODUTOS");
				for (Produto produto_aux : catalogo_produtos) {
					System.out.println(produto_aux.toString() + "\n");					
				}
			}
			
			else if(opcao == 4){
				double soma_valores_receber = 0.0;
				System.out.println("VALORES A RECEBER: ");
//				for(int count=0; count < valores_receber.size(); count ++){
//					System.out.println("R$"+valores_receber.get(count));
//					soma_valores_receber += valores_receber.get(count);
//				}
//				System.out.println("Total: R$"+ soma_valores_receber);
			}
			
			else if(opcao == 5){
				System.out.println("VENDAS REALIZADAS: ");
//				for(int count=0; count < vendas.size(); count ++){
//					System.out.println("Item: " + vendas.get(count).getNome() + "; R$" + vendas.get(count).getPreco_unitario());
//				}
			}
			
			else if(opcao == 6){ }
			else {System.out.println("OPCAO INVALIDA! ");}
		}while(opcao != 6);
	}
}