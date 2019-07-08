package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FuncionarioDAO;
import model.javabean.Funcionario;

public class AtualizaSenha implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String retorno = "index";
		switch (request.getMethod()) {
		case "GET":
			retorno = exibeForm(request, response);
			break;
		case "POST":
			retorno = atualizaRegistro(request);
			break;
		}
			return retorno;
		}
		private String atualizaRegistro(HttpServletRequest request) {
			Funcionario funcionario = new Funcionario(request.getParameter("email"), request.getParameter("senha"));
			new FuncionarioDAO().trocaSenha(funcionario.getEmail(),funcionario.getSenha());
			return "index";
		}
	
		public String exibeForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
			return "formTrocaSenha";
		}


}
