package model.javabean;

public class Funcionario {
	private String telefone;
	private String CPF;
	private String senha;
	private String nomeFuncionario;
	private String email;
	private Cargo cargo;
	
	public Funcionario(String telefone, String CPF, String senha, String nomeFuncionario, String email) {
		super();
		this.telefone = telefone;
		this.CPF = CPF;
		this.senha = senha;
		this.nomeFuncionario = nomeFuncionario;
		this.email = email;
	//	this.cargo = cargo;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCPF() {
		return this.CPF;
	}
	public void setCPF(String cPF) {
		this.CPF = cPF;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
}
