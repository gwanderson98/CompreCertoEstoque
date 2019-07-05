package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FuncionarioDAO;
import model.javabean.Cargo;
import model.javabean.Funcionario;


public class CadastrarFuncionario implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recuperar os parametros do formulario
		
		Funcionario funcionario = new Funcionario(request.getParameter("telefone"), 
				request.getParameter("cpf"),
				request.getParameter("senha"),
				request.getParameter("nomeFuncionario"),
				request.getParameter("email")
				request.getParameter("cargo");
				);
		// enviar dados para o DAO persistir
		new FuncionarioDAO().salvar(funcionario);
		//retornar o nome da view
		request.setAttribute("msg", "parab�ns usuario cadastrado com sucesso");
		return "cadastroFuncionario";
	}

}
