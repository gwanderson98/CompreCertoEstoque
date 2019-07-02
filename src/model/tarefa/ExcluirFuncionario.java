package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FuncionarioDAO;

public class ExcluirFuncionario implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String CPF = request.getParameter("CPF");
		new FuncionarioDAO().excluir(CPF);
		return "index";
	}

}
