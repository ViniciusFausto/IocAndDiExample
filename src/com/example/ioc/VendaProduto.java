package com.example.ioc;

public class VendaProduto {
	/*
	 * PROBLEMA:
	 * 
	 * Nota-se que todo controle do objeto "log" esta em responsabilidade da classe
	 * Venda Produto, que n�o � o ideal. Pois, por exemplo, se precisarmos mudar o
	 * nome do arquivo que gravar� o Log o certo � que essa responsabilidade n�o seja da classe de Vender produto.
	 */

	public void venderProdutoFormaErrada(Produto produto) {
		// Todo o c�digo para a venda do produto...
		Log log = new Log("Arquivo.txt");
		log.grava(produto);
	}

	/*
	 * RESOLU��O:
	 * 
	 * Para resolver isso utilizei a Inje��o de Depend�ncia pelo construtor. Mas, o
	 * que significa isso? 
	 * Criei um objeto local do tipo Log e instancio ele atrav�s
	 * do construtor local, dando assim, toda a responsabilidade para a pr�pria
	 * classe log de controlar essa dependencia.
	 */

	private Log log;

	public  VendaProduto(Log logVenda) {
		this.log = logVenda;
	}

	public void venderProdutoFormaCerta(Produto produto) {
		log.grava(produto);
	}
	
	/*
	 * CONCLUS�O: Tinhamos um problema e precis�vamos usar a Invers�o de controle
	 * para poder resolver. Para aplicar a invers�o de conrole usamos Inje��o de
	 * Depend�ncia pelo construtor.
	 */
}
