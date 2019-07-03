package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FuncionarioDAO;
import model.javabean.Funcionario;

public class AtualizarProduto implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String retorno = "index";
		switch (request.getMethod()) {
		case "GET":
			retorno = exibeForm(request);
			break;
		case "POST":
			retorno = atualizaRegistro(request);
			break;
		}
			return retorno;
		}
		private String atualizaRegistro(HttpServletRequest request) {
			Funcionario funcionario = new Funcionario(request.getParameter("telefone"), request.getParameter("CPF"), request.getParameter("senha"), request.getParameter("nomeFuncionario"), request.getParameter("email"));
			new FuncionarioDAO().atualizar(funcionario);
			return "index";
		}
	
		private String exibeForm(HttpServletRequest request) {
			Funcionario funcionario = (Funcionario) new FuncionarioDAO().recuperarPorId(request.getParameter("CPF"));
			request.setAttribute("entidade",funcionario);
			return "atualizaFuncionario";
		}

}
