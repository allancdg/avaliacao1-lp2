package br.ufrn.imd.lp2.meuProjeto;

//OPÇOES MENU PRINCIPAL
public enum OpcoesMenu {
	COMPRADORES(1), VENDEDORES(2), COMPRAVENDA(3);
	
	private final int valor;
	
	//CONSTRUTOR PADRAO
	OpcoesMenu (int valorOpcao){
		valor = valorOpcao;
	}
	
	public int getValor() {
		return valor;
	}
}
