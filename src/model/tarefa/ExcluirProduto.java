package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProdutoDAO;

public class ExcluirProduto implements Tarefa {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String Id_produto = request.getParameter("Id_produto");
		new ProdutoDAO().excluir(Id_produto);
		return "listaProdutos";
	}

}
