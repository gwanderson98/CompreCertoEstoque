package model.tarefa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FuncionarioDAO;
import model.javabean.Funcionario;

public class ListarTodosFuncionarios implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Funcionario> lista = new FuncionarioDAO().listarTodos();
		request.setAttribute("funcionarios", lista);
		return "listaFuncionarios";
	}

}
