package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EstoqueDAO;
import model.dao.JuncaoEstoqueProdutoDAO;
import model.dao.ProdutoDAO;
import model.javabean.Estoque;
import model.javabean.JuncaoEstoqueProduto;
import model.javabean.Produto;

public class AtualizarLoja implements Tarefa {

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
			JuncaoEstoqueProduto juncao = new JuncaoEstoqueProduto(Integer.parseInt(request.getParameter("IdEstoque")),
					Integer.parseInt(request.getParameter("Quantidade")), request.getParameter("Nome"), request.getParameter("CodProduto"),
					Integer.parseInt(request.getParameter("QuantidadeMinima")), Integer.parseInt(request.getParameter("IdProduto")));
			new JuncaoEstoqueProdutoDAO().atualizar(juncao);
			return "index";
		}
	
		private String exibeFormProduct(HttpServletRequest request) {
			Produto produto = (Produto) new ProdutoDAO().recuperarPorId(request.getParameter("IdProduto"));
			Estoque estoque = (Estoque) new EstoqueDAO().recuperarPorId(request.getParameter("IdEstoque"));
			JuncaoEstoqueProduto juncao = new JuncaoEstoqueProduto(estoque.getIdEstoque(), estoque.getQuantidade(), 
					produto.getNome(), produto.getCodProduto(),
					estoque.getQuantidadeMinima() ,produto.getIdProduto());
			request.setAttribute("juncao",juncao);
			return "atualizaProduto";
		}

}
