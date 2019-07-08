package model.javabean;

public class Funcionario {
	private int id;
	private String telefone;
	private String cpf;
	private String senha;
	private String nomeFuncionario;
	private String email;
	private int cargo;
	
	
	public Funcionario(int id, String telefone, String cpf, String senha, String nomeFuncionario, String email,int cargo) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.cpf = cpf;
		this.senha = senha;
		this.nomeFuncionario = nomeFuncionario;
		this.email = email;
		this.cargo = cargo;
	}

	public Funcionario(String telefone, String cpf, String senha, String nomeFuncionario, String email, int cargo) {
		super();
		this.telefone = telefone;
		this.cpf = cpf;
		this.senha = senha;
		this.nomeFuncionario = nomeFuncionario;
		this.email = email;
		this.cargo = cargo;
	}
	
	public Funcionario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Funcionario(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}	
}
