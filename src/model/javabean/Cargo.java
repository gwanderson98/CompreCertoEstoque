package model.javabean;

public enum Cargo {
	Funcionario(1),
	Administrador(2);
	
	private int indice;
	
	Cargo(int x){
		this.indice = x;
	}
	
	public int getIndice() {
		return this.indice;
	}
}
