package model.javabean;

import java.util.Calendar;

public class Produto {
	private Calendar data;
	private String nome;
	private String cod_produto;
	
	
	
	public Produto(Calendar data, String nome, String cod_produto) {
		super();
		this.data = data;
		this.nome = nome;
		this.cod_produto = cod_produto;
	}
	
	
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
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
