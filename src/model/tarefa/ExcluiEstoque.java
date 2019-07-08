package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EstoqueDAO;

public class ExcluiEstoque implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idEstoque = request.getParameter("IdEstoque");
		new EstoqueDAO().excluir(idEstoque);
		return "index";
		
	}

}
