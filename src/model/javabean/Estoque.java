package model.javabean;

public class Estoque {
	private int idEstoque;
	private int quantidade;
	private int idProduto;
	private int quantidadeMinima;
	
	public Estoque(int idEstoque, int quantidade, int idProduto, int quantidadeMinima) {
		super();
		this.idEstoque = idEstoque;
		this.quantidade = quantidade;
		this.idProduto = idProduto;
		this.quantidadeMinima = quantidadeMinima;
	}

	public Estoque(int quantidadeMinima, int quantidade) {
		this.quantidade = quantidade;
		this.quantidadeMinima = quantidadeMinima;
	}


	public Estoque(int idProduto, int quantidadeMinima, int quantidade) {
		this.idProduto = idProduto;
		this.quantidadeMinima = quantidadeMinima;
		this.quantidade = quantidade;
	}

	public int getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}
	
	
}
