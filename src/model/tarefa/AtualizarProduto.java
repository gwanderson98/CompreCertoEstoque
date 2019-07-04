package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProdutoDAO;
import model.javabean.Produto;

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
			Produto produto = new Produto(Integer.parseInt(request.getParameter("Id_produto")), request.getParameter("Nome"), request.getParameter("Cod_produto"));
			new ProdutoDAO().atualizar(produto);
			return "index";
		}
	
		private String exibeForm(HttpServletRequest request) {
			Produto produto = (Produto) new ProdutoDAO().recuperarPorId(Integer.parseInt(request.getParameter("Id_produto")));
			request.setAttribute("entidade",produto);
			return "atualizaProduto";
		}

}
