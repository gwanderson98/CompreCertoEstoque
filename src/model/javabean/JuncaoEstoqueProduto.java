package model.javabean;



public class JuncaoEstoqueProduto {
	private int idEstoque;
	private int quantidade;
	private String nome;
	private String codProduto;
	private int quantidadeMinima;
	private int idProduto;
	
	public JuncaoEstoqueProduto(int idEstoque, int quantidade, String nome, String codProduto,int quantidadeMinima,int idProduto) {
		super();
		this.idEstoque = idEstoque;
		this.quantidade = quantidade;
		this.nome = nome;
		this.codProduto = codProduto;
		this.idProduto = idProduto;
		this.quantidadeMinima = quantidadeMinima;
	}
	
	public JuncaoEstoqueProduto(int quantidade, String nome, String codProduto,int quantidadeMinima) {
		super();
		this.quantidade = quantidade;
		this.nome = nome;
		this.codProduto = codProduto;
		this.quantidadeMinima = quantidadeMinima;
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

	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}
	
	

}
