package br.ufrn.imd.lp2.meuProjeto;

import java.util.HashSet;
import java.util.Set;

public class Comprador extends Pessoa {
	
	//ATRIBUTOS
	private String CPF;
	private Set<Double> valores_pagar = new HashSet<>();			
	private Set<Double> compras_realizadas = new HashSet<>(); 			
	
	//CONSTRUTOR PADRAO
	public Comprador() {}

	//CONSTRUTOR PARAMETRIZADO
	public Comprador(String nome, String CPF, double saldo_conta) {
		super(nome, saldo_conta);
		this.CPF = CPF;
	}
	
	//Setters
	public void setCompra(double valor) {
		this.saldo_conta -= valor;
	}
	
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

	//METODOS AUXILIARES
	public String toString() { //metodo para mostrar informaçoes
		String retorno = "Nome: " + super.nome;
		retorno += "\nCPF: " + this.CPF;
		retorno += "\nSaldo em conta: " + super.saldo_conta;
		return retorno;
	}
	
	public boolean equals(Object other) { //metodo para comparar os CPFS
		if (other == null || !other.getClass().equals(Comprador.class)) {
			return false;
		} 
	 	Comprador otherCompradores = (Comprador) other;
		return otherCompradores.CPF.equals(this.CPF);
	}
	
	public int hashCode() { //Metodo auxiliar do HashCode
		return this.CPF.hashCode();
	}
}
