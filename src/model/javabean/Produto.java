package model.javabean;

import java.util.Calendar;

public class Produto {
	private int id;
	private String nome;
	private String cod_produto;
	
	
	
	public Produto(int id, String nome, String cod_produto) {
		super();
		this.id = id;
		this.nome = nome;
		this.cod_produto = cod_produto;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(String cod_produto) {
		this.cod_produto = cod_produto;
	}
	
	
}
