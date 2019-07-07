package model.javabean;

import java.util.Calendar;

public class Produto {
	private String nome;
	private String codProduto;
	private int idProduto;
	
	public Produto(int idProduto,String nome, String codProduto) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.codProduto = codProduto;
	}
	
	public Produto(String nome, String codProduto) {
		super();
		this.nome = nome;
		this.codProduto = codProduto;
	}
	
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		idProduto = idProduto;
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
	
	
}
