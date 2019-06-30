package model.javabean;

public class ItemOperacao {
	private int Id_item_opereacao;
	private int Id_operacao_fk;
	private int Id_produto_fk;
	private int QuantidadeProduto;
	
	public ItemOperacao(int Id_item_opereacao,int Id_operacao_fk , int Id_produto_fk,int quantidadeProduto) {
		super();
		this.Id_item_opereacao = Id_item_opereacao;
		this.Id_operacao_fk = Id_operacao_fk;
		this.Id_produto_fk = Id_produto_fk;
		this.QuantidadeProduto = quantidadeProduto;
	}
	
	public int getId_item_opereacao() {
		return Id_item_opereacao;
	}
	public void setId_item_opereacao(int id_item_opereacao) {
		Id_item_opereacao = id_item_opereacao;
	}
	public int getId_operacao_fk() {
		return Id_operacao_fk;
	}
	public void setId_operacao_fk(int id_operacao_fk) {
		Id_operacao_fk = id_operacao_fk;
	}
	public int getId_produto_fk() {
		return Id_produto_fk;
	}
	public void setId_produto_fk(int id_produto_fk) {
		Id_produto_fk = id_produto_fk;
	}
	public int getQuantidadeProduto() {
		return QuantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		QuantidadeProduto = quantidadeProduto;
	}
}
