package model.javabean;

import java.util.List;

public class Operacao {
	private int Id_operacao;
	private char tipo;
	private String data;
	private int Id_func_fk;
	private List<ItemOperacao> listaOperacao;
	
	public Operacao(int Id_operacao,char tipo, String data,int Id_func_fk) {
		super();
		this.Id_operacao = Id_operacao;
		this.tipo = tipo;
		this.data = data;
		this.Id_func_fk = Id_func_fk;
	}
	
	public int getId_operacao() {
		return Id_operacao;
	}

	public void setId_operacao(int id_operacao) {
		Id_operacao = id_operacao;
	}

	public int getId_func_fk() {
		return Id_func_fk;
	}

	public void setId_func_fk(int id_func_fk) {
		Id_func_fk = id_func_fk;
	}

	public void setListaItemOpercao(List<ItemOperacao> lista) {
		this.listaOperacao = lista;
	}

    public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<ItemOperacao> getListaOperacao() {
		return listaOperacao;
	}

	public static void setListaOperacao(List<ItemOperacao> listaOperacao) {
		listaOperacao = listaOperacao;
	}
}
