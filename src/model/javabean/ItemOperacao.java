package model.javabean;

public class ItemOperacao {
	private int idItemOpereacao;
	private int idOperacaoFk;
	private int idProdutoFk;
	private int QuantidadeProduto;
	
	public ItemOperacao(int idItemOpereacao,int idOperacaoFk , int idProdutoFk,int quantidadeProduto) {
		super();
		this.idItemOpereacao = idItemOpereacao;
		this.idOperacaoFk = idOperacaoFk;
		this.idProdutoFk = idProdutoFk;
		this.QuantidadeProduto = quantidadeProduto;
	}
	
	public int getIdItemOpereacao() {
		return idItemOpereacao;
	}
	public void setIdItemOpereacao(int idItemOpereacao) {
		idItemOpereacao = idItemOpereacao;
	}
	public int getIdOperacaoFk() {
		return idOperacaoFk;
	}
	public void setIdOperacaoFk(int idOperacaoFk) {
		idOperacaoFk = idOperacaoFk;
	}
	public int getIdProdutoFk() {
		return idProdutoFk;
	}
	public void setIdProdutoFk(int idProdutoFk) {
		idProdutoFk = idProdutoFk;
	}
	public int getQuantidadeProduto() {
		return QuantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		QuantidadeProduto = quantidadeProduto;
	}
}
