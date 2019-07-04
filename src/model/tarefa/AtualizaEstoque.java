package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EstoqueDAO;
import model.dao.ProdutoDAO;
import model.javabean.Estoque;
import model.javabean.Produto;

public class AtualizaEstoque implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String retorno = "index";
		switch (request.getMethod()) {
		case "GET":
			retorno = exibeFormEstoque(request);
			break;
		case "POST":
			retorno = atualizaRegistroEstoque(request);
			break;
		}
			return retorno;
		}
		private String atualizaRegistroEstoque(HttpServletRequest request) {
			Estoque estoque = new Estoque(Integer.parseInt(request.getParameter("id_estoque")),Integer.parseInt(request.getParameter("quantidadeMinima")), Integer.parseInt(request.getParameter("quantidade")));
			new EstoqueDAO().atualizar(estoque);
			return "listaProdutos";
		}
	
		private String exibeFormEstoque(HttpServletRequest request) {
			Estoque estoque = (Estoque) new EstoqueDAO().recuperarPorId(Integer.parseInt(request.getParameter("Id_estoque")));
			request.setAttribute("entidade",estoque);
			return "atualizaEstoque";
		}

}
