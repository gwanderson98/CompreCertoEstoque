package model.javabean;

import java.util.Calendar;

public class Produto {
	private String Id_produto;
	private String Nome;
	private String Cod_produto;
	
	
	
	public Produto(String Id_produto, String Nome, String Cod_produto) {
		super();
		this.Id_produto = Id_produto;
		this.Nome = Nome;
		this.Cod_produto = Cod_produto;
	}
	
	
	public String getId() {
		return Id_produto;
	}
	public void setId(String Id_produto) {
		this.Id_produto = Id_produto;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public String getCod_produto() {
		return Cod_produto;
	}
	public void setCod_produto(String Cod_produto) {
		this.Cod_produto = Cod_produto;
	}
	
	
}
