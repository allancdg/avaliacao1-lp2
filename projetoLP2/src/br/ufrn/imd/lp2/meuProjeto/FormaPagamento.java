package br.ufrn.imd.lp2.meuProjeto;

abstract class FormaPagamento {
	
	public abstract void pagamento(Vendedor vendedor, Comprador compra, double valor_total);
	
	public boolean vencimento() {
		boolean vencido = false;
		
		if (vencido) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
