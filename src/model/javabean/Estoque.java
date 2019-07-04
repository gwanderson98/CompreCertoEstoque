package model.javabean;

public class Estoque {
	private int Id_estoque;
	private int quantidade;
	private int Id_produto;
	private int quantidadeMinima;
	
	public Estoque(int Id_estoque, int quantidade, int Id_produto, int quantidadeMinima) {
		super();
		this.Id_estoque = Id_estoque;
		this.quantidade = quantidade;
		this.Id_produto = Id_produto;
		this.quantidadeMinima = quantidadeMinima;
	}

	public Estoque( int quantidadeMinima, int quantidade) {
		this.quantidade = quantidade;
		this.quantidadeMinima = quantidadeMinima;
	}


	public Estoque(int Id_estoque, int quantidadeMinima, int quantidade) {
		this.Id_estoque = Id_estoque;
		this.quantidadeMinima = quantidadeMinima;
		this.quantidade = quantidade;
	}

	public int getId_estoque() {
		return Id_estoque;
	}	

	public void setId_estoque(int id_estoque) {
		Id_estoque = id_estoque;
	}


	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getId_produto() {
		return Id_produto;
	}
	public void setId_Produto(int Id_produto) {
		this.Id_produto = Id_produto;
	}

	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}
	
	
}
