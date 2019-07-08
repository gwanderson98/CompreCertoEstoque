package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.*;
import model.javabean.*;

public class CadastrarProduto implements Tarefa {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recuperar os parametros do formulario
		JuncaoEstoqueProduto estoque = new JuncaoEstoqueProduto(Integer.parseInt(request.getParameter("quantidade")),
				request.getParameter("nome"),request.getParameter("codProduto"),Integer.parseInt(request.getParameter("quantidadeMinima")));
		// enviar dados para o DAO persistir
		new JuncaoEstoqueProdutoDAO().salvar(estoque);
		//retornar o nome da view
		request.setAttribute("msg", "parabéns produto cadastrado com sucesso");
		return "cadastroProduto";
	}
}
