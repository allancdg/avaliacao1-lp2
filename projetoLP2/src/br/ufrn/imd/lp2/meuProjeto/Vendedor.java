package br.ufrn.imd.lp2.meuProjeto;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Pessoa {
	
	//ATRIBUTOS
	private String CNPJ;
	private Set<Double> valores_receber = new HashSet<>();
	private Set<Double> vendas_realizadas = new HashSet<>(); 			
	private List<Produto> catalogo_produtos = new ArrayList<Produto>(); 			
	
	//CONSTRUTOR PADRAO
	public Vendedor() {}
	
	//CONSTRUTOR PARAMETRIZADO
	public Vendedor(String nome, String CNPJ, double saldo_conta) {
		super(nome, saldo_conta);
		this.CNPJ = CNPJ;
	}
	
	//Setters
	public void setVendas_realizada(double valor){
		this.vendas_realizadas.add(valor);
	}
	
	public void setValores_receber(double valor) {
		this.valores_receber.add(valor);
	}
	
	public void addProduto (Produto novo_produto) {
		this.catalogo_produtos.add(novo_produto);
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
	
	//METODOS AUXILIARES
	public String toString() { //metodo para mostrar informaçoes
		String retorno = "Nome: " + super.nome;
		retorno += "\nCNPJ: " + this.CNPJ;
		retorno += "\nSaldo em conta: " + super.saldo_conta;
		return retorno;
	}
	
	public boolean equals(Object other) { //metodo para comparar os CNPJS
		if (other == null || !other.getClass().equals(Vendedor.class)) {
			return false;
		} 
	 	Vendedor otherVendedores = (Vendedor) other;
		return otherVendedores.CNPJ.equals(this.CNPJ);
	}
	
	public int hashCode() {	//metodo auxiliar do HashCode
		return this.CNPJ.hashCode();
	}
}