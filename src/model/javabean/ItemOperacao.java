package model.javabean;

public class ItemOperacao {
	private int idItemOperacao;
	private int idOperacaoFk;
	private int idProdutoFk;
	private int QuantidadeProduto;
	
	public ItemOperacao(int idItemOperecao,int idOperacaoFk , int idProdutoFk,int quantidadeProduto) {
		super();
		this.idItemOperacao = idItemOperacao;
		this.idOperacaoFk = idOperacaoFk;
		this.idProdutoFk = idProdutoFk;
		this.QuantidadeProduto = quantidadeProduto;
	}
	
	public int getIdItemOperacao() {
		return idItemOperacao;
	}
	public void setIdItemOperacao(int idItemOpereacao) {
		this.idItemOperacao = idItemOperacao;
	}
	public int getIdOperacaoFk() {
		return idOperacaoFk;
	}
	public void setIdOperacaoFk(int idOperacaoFk) {
		this.idOperacaoFk = idOperacaoFk;
	}
	public int getIdProdutoFk() {
		return idProdutoFk;
	}
	public void setIdProdutoFk(int idProdutoFk) {
		this.idProdutoFk = idProdutoFk;
	}
	public int getQuantidadeProduto() {
		return QuantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		QuantidadeProduto = quantidadeProduto;
	}
}
