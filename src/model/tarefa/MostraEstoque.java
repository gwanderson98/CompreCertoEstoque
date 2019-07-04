package model.tarefa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EstoqueDAO;
import model.javabean.Estoque;

public class MostraEstoque implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Estoque> lista = new EstoqueDAO().listarTodos();
		request.setAttribute("estoque", lista);
		return "mostraEstoque";
	}

}
