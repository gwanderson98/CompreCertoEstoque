package model.javabean;

import java.util.Calendar;
import java.util.List;

public class Operacao {
	private char tipo;
	private Calendar data;
	private List<ItemOperacao> operacao;
	
	public Operacao(char tipo, Calendar data) {
		super();
		this.tipo = tipo;
		this.data = data;
	}
	
    public void imprimir() {
    	System.out.println("Data/Hora atual: "+this.data.getTime());
        System.out.println("Ano: "+this.data.get(Calendar.YEAR));
        System.out.println("Mês: "+this.data.get(Calendar.MONTH));
        System.out.println("Dia do Mês: "+this.data.get(Calendar.DAY_OF_MONTH));
    }
    

}
