package br.ufrn.imd.lp2.meuProjeto;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public class Programa {

	//INICIANDO O SCANNER
	Scanner entrada = new Scanner(System.in);
	
	//INICIALIZANDO UM OBJETO DATA
	LocalDateTime myDateObj = LocalDateTime.now();
    
	//DATA E HORA PARA APRESENTAÇAO
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
   
    //DATA PARA SER UTILIZADO NA VALIDADE DO BOLETO
	DateTimeFormatter apenasData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String dataFormatada = myDateObj.format(apenasData);
    
	//COLECOES DE OBJETOS PRINCIPAIS
	private Set<Comprador> compradores;					
	private Set<Vendedor> vendedores;
	
	
	
	//CONSTRUTOR PADRAO
	public Programa() {
		this.compradores = new HashSet<>();					
		this.vendedores = new HashSet<>();
	}
	
	
	
	//FUNÇAO PARA INSERIR OBJETOS NOS SETS
	public void inicializador() {
		//CONJUNTOS DE OBJETOS
		Comprador andre = new Comprador("ANDRE TRIGUEIRO", "111.222.333-44", 10000.00);
		Vendedor allan = new Vendedor("ALLAN CHRISTIAN", "12.345.678/0001-00", 20000.00);
		Produto saida = new Produto(0, "BOTAO DE SAIDA", 00.00); //este objeto não é utilizado, medida provisoria
		Produto tv_teste = new Produto(1, "TV TELINHA", 1000.00);
		
		//INSERCAO DE OBJETOS PARA TESTES
		compradores.add(andre);
		vendedores.add(allan);
		allan.addProduto(saida);
		allan.addProduto(tv_teste);
	}

	
	
	//MENU DE COMPRADORES
	private void menuCompradores() {
		int entrada_int_compradores=0;
		do {
			//MENU ESPECIFICO DE COMPRADORES
			System.out.println("\n->> MENU PRINCIPAL COMPRADORES");					
			System.out.println("1 - CADASTRAR NOVO COMPRADOR");
			System.out.println("2 - LISTAR TODOS OS COMPRADORES");
			System.out.println("3 - BUSCAR E ACESSAR POR CPF");
			System.out.println("4 - VOLTAR");
			System.out.println("DIGITE A OPCAO DESEJADA: ");
			entrada_int_compradores = Integer.parseInt(entrada.nextLine());
			
			//OPCAO 01 - CADASTRAR NOVO COMPRADOR
			if(entrada_int_compradores == 1) {
				System.out.println("#CADASTRAMENTO DE COMPRADOR");
				System.out.println("NOME: ");
				String nome_aux = entrada.nextLine();
				System.out.println("CPF: ");
				String CPF_aux = entrada.nextLine();
				System.out.println("SALDO INICIAL: ");
				double saldo_conta_aux;
				saldo_conta_aux = Double.parseDouble(entrada.nextLine());
		
				Comprador novo_comprador = new Comprador(nome_aux, CPF_aux, saldo_conta_aux);
				
				boolean teste_duplicado = false;
				//FOR EACH PARA RODAR NA LISTA DE COMPRADORES
				for(Comprador comprador_aux : compradores) {
					if(comprador_aux.equals(novo_comprador)) {
						teste_duplicado = true;
					}
				}
				//RESULTADO DO TESTE DUPLICADO
				if (teste_duplicado) {
					System.out.println("O CPF informado ja esta cadastrado.");
				}
				else {
					compradores.add(novo_comprador);
					System.out.println("CADASTRO REALIZADO!");
				}
			}
			
			//OPCAO 03 - LISTAR TODOS OS COMPRADORES
			else if(entrada_int_compradores == 2){
				System.out.println("LISTAGEM DE COMPRADORES CADASTRADOS: ");
				for(Comprador comprador_aux : compradores){
					System.out.println(comprador_aux.toString() + "\n");
				}
			}
			
			//OPCAO 04 - BUSCAR E ACESSAR POR CPF
			else if(entrada_int_compradores == 3){
				System.out.println("FORMATO DE BUSCA -> 123.456.789-00 ");
				System.out.println("DIGITE O CPF QUE DESEJA BUSCAR: ");
				String entrada_string_compradores;
				entrada_string_compradores = entrada.nextLine();

				boolean teste = true;
				//FOR EACH PERCORRENDO O CONJUNTO DE COMPRADORES E CONFERINDO SE O CPF INFORMADO FOI ENCONTRADO
				for(Comprador comprador_aux : compradores){
					if(comprador_aux.getCPF().equals(entrada_string_compradores)){
						System.out.println("CPF ENCONTRADO.\nINFORMACOES: ");
						System.out.println(comprador_aux.toString());
						subMenuComprador(comprador_aux);
						teste = false;
					}
				}
				if (teste) { 
					System.out.println("Este CPF nao foi encontrado.");
				}
			}
			else if(entrada_int_compradores == 4){
				System.out.println("RETORNANDO AO MENU PRINCIPAL!");
			}
			else {System.out.println("OPCAO INVALIDA! ");}
		} while (entrada_int_compradores != 4);		//FIM DO MENU SECUNDARIOS DE COMPRADORES	
	}
	
	//SUBMENU DE COMPRADORES
	private void subMenuComprador(Comprador comprador){
		int opcao;
		System.out.println("\n#MENU OPERACIONAL DO COMPRADOR " + comprador.getNome()) ;
		System.out.println("1 - INFORMACOES DO COMPRADOR");
		System.out.println("2 - LISTAR VALORES A PAGAR");
		System.out.println("3 - LISTAR COMPRAS REALIZADAS");
		System.out.println("4 - VOLTAR");
		opcao = Integer.parseInt(entrada.nextLine());

		if(opcao == 1) {
			System.out.println(comprador.toString());
		}
		else if(opcao == 2){
			double soma_valores_pagar = 0.0;
			
			System.out.println("VALORES A PAGAR: ");
			for(Double valores: comprador.getValores_pagar()){
				System.out.println("R$" + valores);
				soma_valores_pagar += valores;
			}
			System.out.println("Total: R$"+ soma_valores_pagar);
		}
		else if(opcao == 3){
			System.out.println("COMPRAS REALIZADAS: ");
			for(double compras: comprador.getCompras_realizadas()){
				System.out.println("R$" + compras);
			}
		}
		else if(opcao == 4) {
			System.out.println("RETORNANDO AO MENU PRINCIPAL!");
		}
		else {
			System.out.println("OPCAO INVALIDA! ");
		}
	}

	
	
	//MENU DE VENDEDORES
	private void menuVendedores() {
		int entrada_int_vendedores = 0;
		//MENU ESPECIFICO DE VENDEDORES
		do {
			System.out.println("\n->> MENU PRINCIPAL VENDEDORES");					
			System.out.println("1 - CADASTRAR NOVO VENDEDOR");
			System.out.println("2 - LISTAR TODOS OS VENDEDORES");
			System.out.println("3 - BUSCAR E ACESSAR POR CNPJ");
			System.out.println("4 - VOLTAR");
			System.out.println("DIGITE A OPCAO DESEJADA: ");
			entrada_int_vendedores = Integer.parseInt(entrada.nextLine());
			
			//OPCAO 1 - CADASTRAR NOVO VENDEDOR
			if(entrada_int_vendedores == 1){
				System.out.println("\n#CADASTRAMENTO DE VENDEDOR");
				System.out.println("NOME: ");
				String nome_aux = entrada.nextLine();
				System.out.println("CNPJ: ");
				String CNPJ_aux = entrada.nextLine();
				System.out.println("SALDO INICIAL: ");
				double saldo_conta_aux;
				saldo_conta_aux = Double.parseDouble(entrada.nextLine());

				Vendedor vendedor = new Vendedor(nome_aux, CNPJ_aux, saldo_conta_aux);

				boolean teste_duplicado = false;
				
				for(Vendedor vendedor_aux : vendedores) {
					if(vendedor_aux.equals(vendedor)) {
						teste_duplicado = true;
					}
				}
				
				if (teste_duplicado) {
					System.out.println("O CNPJ informado ja esta cadastrado.");
				}
				else {
					vendedores.add(vendedor);
				}
			}
			//OPCAO 2 - LISTAR TODOS OS VENDEDORES
			else if(entrada_int_vendedores == 2){
				System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
				for(Vendedor vendedor_aux : vendedores){
					System.out.println(vendedor_aux.toString());
					System.out.println(" ");
				}
			}
			//OPCAO 3 - BUSCAR E ACESSAR POR CNPJ
			else if(entrada_int_vendedores == 3){
				System.out.println("FORMATO DE BUSCA -> 12.345.678/0001-00 ");
				System.out.println("DIGITE O CNPJ QUE DESEJA BUSCAR: ");
				String entrada_string_vendedores;
				entrada_string_vendedores = entrada.nextLine();
				
				boolean teste = true;
				for(Vendedor vendedor_aux : vendedores){
					if(vendedor_aux.getCNPJ().equals(entrada_string_vendedores)){
						System.out.println("CNPJ ENCONTRADO. INFORMACOES: \n");
						System.out.println(vendedor_aux.toString());
						teste = false;
						subMenuVendedor(vendedor_aux);
					}
				}						
				if (teste) { 
					System.out.println("Este CNPJ nao foi encontrado.");
				}
			}
			//OPCAO 4 - VOLTAR
			else if(entrada_int_vendedores == 4){ 
				System.out.println("RETORNANDO AO MENU PRINCIPAL! ");
			}
			else {
				System.out.println("OPCAO INVALIDA! ");
			}
		}while(entrada_int_vendedores != 5);
	}
	
	//SUBMENU DE VENDEDORES
	private void subMenuVendedor(Vendedor vendedor){
		int opcao;
		do{
			System.out.println("\n#MENU OPERACIONAL DO VENDEDOR " + vendedor.getNome());
			System.out.println("1 - INFORMACOES DO VENDEDOR");
			System.out.println("2 - CADASTRAR PRODUTOS");
			System.out.println("3 - CATALOGO DE PRODUTOS");
			System.out.println("4 - LISTAR VALORES A RECEBER");
			System.out.println("5 - LISTAR VENDAS REALIZADAS");
			System.out.println("6 - VOLTAR");
			System.out.println("DIGITE A OPCAO DESEJADA: ");
			opcao = Integer.parseInt(entrada.nextLine());
			
			if(opcao == 1) {
				vendedor.toString();
			}
			
			else if(opcao == 2){
				List<Produto> catalogo_produtos = vendedor.getCatalogo_produtos(); 

				int ID_aux = catalogo_produtos.size();
				ID_aux++;
				
				Produto novo_produto = cadastrarProduto(ID_aux);
				vendedor.addProduto(novo_produto);
			}
			
			else if(opcao == 3){
				List<Produto> catalogo_produtos = vendedor.getCatalogo_produtos(); 
				
				System.out.println("CATALOGO DE PRODUTOS");
				for (Produto produto_aux : catalogo_produtos) {
					System.out.println(produto_aux.toString() + "\n");					
				}
			}
			
			else if(opcao == 4){
				//double soma_valores_receber = 0.0;
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

	
	
	//CADASTRO DE PRODUTOS
	private Produto cadastrarProduto(int ID) {		
		System.out.println("CADASTRAMENTO DE PRODUTO");
		System.out.println("NOME: ");
		String nome_aux = entrada.nextLine();
		System.out.println("PRECO UNITARIO: ");
		double preco_unitario_aux = Double.parseDouble(entrada.nextLine());

		Produto novo_produto = new Produto(ID, nome_aux, preco_unitario_aux);
		return novo_produto;
	}
	
	
	
	//MENU COMPRA E VENDA
	private void menuCompraVenda() {
		String entrada_string_venda_vendedor;
		String entrada_string_compra_comprador;
		//int entrada_int_menu_pagamento = 0;
		int entrada_int_simnao = 0;
		int entrada_int_simnao_v = 0;

		double valor_total = 0;
		boolean comprando = true;
		int opcao_comprando = 0;

		Comprador comprador_venda = new Comprador();
		Vendedor vendedor_venda = new Vendedor();
		
		boolean teste_comprador = true;
		boolean teste_vendedor = true;

		System.out.println("\t>> VENDA DE PRODUTO <<");
	
		System.out.println("LISTA DE COMPRADORES CADASTRADOS: ");
		for(Comprador comprador_aux : compradores){
			System.out.println(comprador_aux.toString());
			System.out.println(" ");
		}
		
		System.out.println("COMPRADOR ESTÁ CADASTRADO?");
		System.out.println("1 - SIM");
		System.out.println("2 - NAO");
		entrada_int_simnao = Integer.parseInt(entrada.nextLine());

		if (entrada_int_simnao == 1) {
			System.out.println("DIGITE O CPF DO COMPRADOR");
			entrada_string_compra_comprador = entrada.nextLine();
			
			//FOR EACH PERCORRENDO O CONJUNTO DE COMPRADORES E CONFERINDO SE O CPF INFORMADO FOI ENCONTRADO					
			for(Comprador comprador_aux : compradores){
				if(comprador_aux.getCPF().equals(entrada_string_compra_comprador)){
					comprador_venda = comprador_aux;
					System.out.println("COMPRADOR: " + comprador_venda.getNome() + " foi selecionado!\n");
					teste_comprador = false;
				}
			}
			if (teste_comprador) { 
				System.out.println("Este CPF nao foi encontrado.");
			}
		}
		else if (entrada_int_simnao == 2) {
			System.out.println("CADASTRE O COMPRADOR NO MENU ANTERIOR!");
			return;
		}
		else {
			System.out.println("OPÇAO NAO ENCONTRADA!");
			return;
		}
		
		System.out.println("LISTAGEM DE VENDEDORES CADASTRADOS: ");
		for(Vendedor vendedor_aux : vendedores){
			System.out.println(vendedor_aux.toString());
			System.out.println(" ");
		}
		
		System.out.println("VENDEDOR ESTÁ CADASTRADO?");
		System.out.println("1 - SIM");
		System.out.println("2 - NAO");
		entrada_int_simnao_v = Integer.parseInt(entrada.nextLine());
		
		if (entrada_int_simnao_v == 1) {
			System.out.println("DIGITE O CNPJ DE UM VENDEDOR: ");
			entrada_string_venda_vendedor = entrada.nextLine();
			
			//FOR EACH PERCORRENDO O CONJUNTO DE COMPRADORES E CONFERINDO SE O CPF INFORMADO FOI ENCONTRADO					
			for(Vendedor vendedor_aux : vendedores){
				if(vendedor_aux.getCNPJ().equals(entrada_string_venda_vendedor)){
					vendedor_venda = vendedor_aux;
					System.out.println("VENDEDOR: " + vendedor_venda.getNome() + ", foi selecionado!\n");
					teste_vendedor = false;
				}
			}
			if (teste_vendedor) { 
				System.out.println("Este CNPJ nao foi encontrado.");
			}
		}
		else if (entrada_int_simnao == 2) {
			System.out.println("CADASTRE O COMPRADOR NO MENU ANTERIOR!");
			return;
		}
		else {
			System.out.println("OPÇAO NAO ENCONTRADA!");
			return;
		}
		
		//COMPRADOR E VENDEDOR SELECIONADOS
		System.out.println("REALIZANDO VENDA ENTRE:"
						+ "\nCOMPRADOR: " + comprador_venda.getNome() 
						+ "\tSALDO: R$" + comprador_venda.getSaldo()
						+ "\nVENDEDOR: " + vendedor_venda.getNome());
		
		System.out.println(">> CATALOGO DE PRODUTOS <<");
		for (Produto produto_aux : vendedor_venda.getCatalogo_produtos()) {
			System.out.println(produto_aux.toString());
		}

		
		List<Produto> carrinho = new ArrayList<Produto>();
		List<Produto> lista_produto_aux = new ArrayList<Produto>();
		Produto produto_selecionado = new Produto();
		
		// COMEÇO DO PROCESSO DE VENDA
		do{	
			System.out.println("\n[PRESSIONE 0 QUANDO ENCESSAR AS COMPRAS]"
							 + "\nDIGITE O ID DO PRODUTO:");
			opcao_comprando = Integer.parseInt(entrada.nextLine());
			
			if(opcao_comprando != 0) {
				int quantidade = 0;
				System.out.println("\nQUANTIDADE: ");
				quantidade = Integer.parseInt(entrada.nextLine());
				
				for( int i = 0 ; i < quantidade ; i++) {
					lista_produto_aux = vendedor_venda.getCatalogo_produtos();

					produto_selecionado = lista_produto_aux.get(opcao_comprando);
					
					carrinho.add(produto_selecionado);

					valor_total += produto_selecionado.getPreco_unitario();
					
					vendedor_venda.setVendas_realizada(valor_total);	//Armazena o valor da venda no vendedor
					comprador_venda.setCompras_realizadas(valor_total);	//Armazena o valor da venda no comprador
				}
			}
			else { 
				System.out.println("OPÇAO NAO ENCONTRADA!");
				comprando = false;
			}
		} while(comprando);
		// FIM DO PROCESSO DE VENDA
					
		//IMPRESSAO DOS ITENS SELECIONADOS E VALOR FINAL
		System.out.println("EXTRATO: ");
		for(Produto produto_aux : carrinho) {
			System.out.println(produto_aux.toString());
		}
		System.out.println("\nVALOR FINAL: R$" + valor_total + "\n\n\n");
		
		//FORMA DE PAGAMENTO
		System.out.println("\n\n\t\t>>> PAGAMENTO <<<");
		
		//MENU PAGAMENTO
		System.out.println("ESCOLHA UMA FORMA DE PAGAMENTO: ");
		System.out.println("1 - PIX");
		System.out.println("2 - BOLETO");
		System.out.println("3 - DEBITO");
		System.out.println("4 - CREDITO");
		System.out.println("0 - CANCELAR TRANSAÇAO E VOLTAR AO MENU ANTERIOR");

		int entrada_int_pagamento = 0;
		boolean pagando = true;
		
		entrada_int_pagamento = Integer.parseInt(entrada.nextLine());

		do {
			if(entrada_int_pagamento == 1) {
				Pix pagamento_pix = new Pix();
				pagamento_pix.pagamento(vendedor_venda, comprador_venda, valor_total);
				pagando = false;
			}
			else if(entrada_int_pagamento == 2) {
				Boleto pagamento_boleto = new Boleto();
				String data_vendedor;
				
				System.out.println("VENDEDOR > INSIRA A DATA DO BOLETO NO FORMATO dd/mm/aaaa: ");
				data_vendedor = entrada.nextLine();
				
				if (pagamento_boleto.vencimento(dataFormatada, data_vendedor)) { 
						pagamento_boleto.pagamento(vendedor_venda, comprador_venda, valor_total);
						pagando = false;
				}
				else {
					System.out.println("O BOLETO ESTÁ VENCIDO. ESCOLHA OUTRA FORMA DE PAGAMENTO!");
				}
			}
			else if(entrada_int_pagamento == 3) {
				Debito pagamento_debito = new Debito();
				pagamento_debito.pagamento(vendedor_venda, comprador_venda, valor_total);
				pagando = false;
			}
			else if(entrada_int_pagamento == 4) {
				Credito pagamento_credito = new Credito();
				pagamento_credito.pagamento(vendedor_venda, comprador_venda, valor_total);
				pagando = false;
			}
			else if(entrada_int_pagamento == 0) {
				System.out.println("CANCELANDO TRANSAÇAO!");
				pagando = false;
			}
			else {
				System.out.println("OPÇAO INVALIDA!");
			}
		} while(pagando);
	}

	
	
	//OPÇOES DO MENU PRINCIPAL
	public void escolheOPcao(OpcoesMenu opcao) {
		if(opcao == OpcoesMenu.COMPRADORES) {
			menuCompradores();
		}
		else if(opcao == OpcoesMenu.VENDEDORES) {
			menuVendedores();
		}
		else if(opcao == OpcoesMenu.COMPRAVENDA) {
			menuCompraVenda();
		}
		else {
			System.out.println("OPÇAO INVALIDA!" + "\n");
		}
	}

	//MENUS PRINCIPAL
	public void menus() {
		
	    //INTRODUÇAO
		System.out.println("SEJA BEM VINDO! - " + formattedDate + "\n");
		
		//INICIANDO O MENU PRINCIPAL
		int entrada_int_main = 0;	//Variavel responsavel por receber a opcao do Menu Principal
		do {
			//MENU PRIMARIO - MENU PRINCIPAL
			System.out.println("\n->> MENU PRINCIPAL");		
			System.out.println("1 - COMPRADORES");
			System.out.println("2 - VENDEDORES");
			System.out.println("3 - COMPRA/VENDA");
			System.out.println("0... - SAIR DO PROGRAMA");
			System.out.println("DIGITE A OPCAO DESEJADA: ");
			entrada_int_main = Integer.parseInt(entrada.nextLine());
			
			
			//MENU SECUNDARIO - COMPRADORES
			if(entrada_int_main == 1) {	
				escolheOPcao(OpcoesMenu.COMPRADORES);
			}
			
			//MENU SECUNDARIO - VENDEDORES
			else if (entrada_int_main == 2) {
				escolheOPcao(OpcoesMenu.VENDEDORES);
			}
			
			//MENU SECUNDARIO - COMPRA/VENDA
			else if (entrada_int_main == 3) {
				escolheOPcao(OpcoesMenu.COMPRAVENDA);
			}
			
		} while (entrada_int_main != 0); // FIM DO MENU PRINCIPAL	

		//FINALIZANDO O SCANNER
		entrada.close();
		
	    //FINALIZAÇAO
		System.out.println("\n\nOBRIGADO!");
	}
}
