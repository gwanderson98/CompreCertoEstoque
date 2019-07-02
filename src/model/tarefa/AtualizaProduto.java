package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FuncionarioDAO;
import model.dao.ProdutoDAO;
import model.javabean.Funcionario;
import model.javabean.Produto;

public class AtualizaProduto implements Tarefa{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String retorno = "index";
		switch (request.getMethod()) {
		case "GET":
			retorno = exibeFormProduct(request);
			break;
		case "POST":
			retorno = atualizaRegistroProduct(request);
			break;
		}
			return retorno;
		}
		private String atualizaRegistroProduct(HttpServletRequest request) {
			Produto produto = new Produto(request.getParameter("Id_produto"), request.getParameter("Nome"), request.getParameter("Cod_produto"));
			new ProdutoDAO().atualizar(produto);
			return "listaProdutos";
		}
	
		private String exibeFormProduct(HttpServletRequest request) {
			Produto produto = (Produto) new ProdutoDAO().recuperarPorId(request.getParameter("Id_produto"));
			request.setAttribute("entidade",produto);
			return "atualizaProduto";
		}

}
