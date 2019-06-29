package model.javabean;

public class ItemOperacao {
	private int quantidadeProduto;
	private Produto produto;
	
	public ItemOperacao(int quantidadeProduto, Produto produto) {
		super();
		this.quantidadeProduto = quantidadeProduto;
		this.produto = produto;
	}
	

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
