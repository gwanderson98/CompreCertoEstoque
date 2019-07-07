package model.javabean;



public class JuncaoEstoqueProduto {
	private int idEstoque;
	private int quantidade;
	private String nome;
	private String codProduto;
	private int idProduto;
	
	public JuncaoEstoqueProduto(int idEstoque, int quantidade, String nome, String codProduto,int idProduto) {
		super();
		this.idEstoque = idEstoque;
		this.quantidade = quantidade;
		this.nome = nome;
		this.codProduto = codProduto;
		this.idProduto = idProduto;
	}
	
	public JuncaoEstoqueProduto(int quantidade, String nome, String codProduto) {
		super();
		this.quantidade = quantidade;
		this.nome = nome;
		this.codProduto = codProduto;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	

}
