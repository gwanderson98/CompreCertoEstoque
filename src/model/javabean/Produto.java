package model.javabean;

import java.util.Calendar;

public class Produto {
	private String Nome;
	private String Cod_produto;
	private int Id_produto;
	
	public Produto(int Id_produto,String Nome, String Cod_produto) {
		super();
		this.Nome = Nome;
		this.Cod_produto = Cod_produto;
	}
	
	public Produto(String Nome, String Cod_produto) {
		super();
		this.Nome = Nome;
		this.Cod_produto = Cod_produto;
	}
	
	public int getId_produto() {
		return Id_produto;
	}

	public void setId_produto(int id_produto) {
		Id_produto = id_produto;
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
