package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EstoqueDAO;
import model.javabean.Estoque;

public class InserirEstoque implements Tarefa {
	Estoque id_estoque;
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//recupera os parametros do formulario
		Estoque estoque = new Estoque(Integer.parseInt(request.getParameter("quantidadeMinima")), Integer.parseInt(request.getParameter("quantidade")),request.getParameter("nomeProduto"));
		//envia dados para o estoque.DAO
		new EstoqueDAO().salvar(estoque);
		//retorna para a view
		request.setAttribute("msg", "parabéns item inserido com sucesso");
		return "inserirEstoque";
	}

}
