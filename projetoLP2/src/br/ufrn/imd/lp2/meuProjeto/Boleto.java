package br.ufrn.imd.lp2.meuProjeto;

public class Boleto extends FormaPagamento {

	//METODO DE PAGAMENTO
	@Override
	public void pagamento(Vendedor vendedor, Comprador comprador, double valor_total) {
		System.out.println("VOCE SELECIONOU O PAGAMENTO POR: " + "BOLETO");
		System.out.println("INFO: " + "O PAGAMENTO É INSTANTANEO!"
									+ "\nSERÁ DESCONTADO UMA TAXA DE 5% PELO SERVIÇO!");

		System.out.println("VENDEDOR: " + vendedor.getNome());
		System.out.println("SALDO ANTERIOR: " + vendedor.getSaldo());
		vendedor.setPagamentoVista(valor_total, 0.05);
		System.out.println("NOVO SALDO: " + vendedor.getSaldo());

		System.out.println("\n----------------------------\n");

		System.out.println("COMPRADOR: " + comprador.getNome());
		System.out.println("SALDO ANTERIOR: " + comprador.getSaldo());
		comprador.setCompra(valor_total);
		System.out.println("NOVO SALDO: " + comprador.getSaldo());
	}
	
	public boolean vencimento(String data_atual, String data_boleto) {
		if (data_atual == data_boleto) {
			return false;
		}
		else {
			return true;
		}
	}
}
