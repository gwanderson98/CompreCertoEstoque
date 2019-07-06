package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProdutoDAO;

public class ExcluirProduto implements Tarefa {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idProduto = request.getParameter("Id_produto");
		new ProdutoDAO().excluir(idProduto);
		return "listaProdutos";
	}

}
