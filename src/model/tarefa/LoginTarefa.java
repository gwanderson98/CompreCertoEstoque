package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FuncionarioDAO;
import model.dao.UsuarioDAO;
import model.javabean.Funcionario;
import model.javabean.Usuario;

public class LoginTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Funcionario funcionario = new FuncionarioDAO().busca(email, senha);

		if (funcionario != null) {
			request.getSession().setAttribute("funcionario", funcionario);
			return "index";
		} else {
			request.setAttribute("erro", "Nome de usuário/senha errado. Tente novamente.");
			return "index";
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tarefa Login";
	}
}
