package com.example.ioc;

public class VendaProduto {
	/*
	 * PROBLEMA:
	 * 
	 * Nota-se que todo controle do objeto "log" esta em responsabilidade da classe
	 * Venda Produto, que não é o ideal. Pois, por exemplo, se precisarmos mudar o
	 * nome do arquivo que gravará o Log o certo é que essa responsabilidade não seja da classe de Vender produto.
	 */

	public void venderProdutoFormaErrada(Produto produto) {
		// Todo o código para a venda do produto...
		Log log = new Log("Arquivo.txt");
		log.grava(produto);
	}

	/*
	 * RESOLUÇÃO:
	 * 
	 * Para resolver isso utilizei a Injeção de Dependência pelo construtor. Mas, o
	 * que significa isso? 
	 * Criei um objeto local do tipo Log e instancio ele através
	 * do construtor local, dando assim, toda a responsabilidade para a própria
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
	 * CONCLUSÃO: Tinhamos um problema e precisávamos usar a Inversão de controle
	 * para poder resolver. Para aplicar a inversão de conrole usamos Injeção de
	 * Dependência pelo construtor.
	 */
}
