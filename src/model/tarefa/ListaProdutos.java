package model.tarefa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProdutoDAO;
import model.javabean.Produto;

public class ListaProdutos implements Tarefa{
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Produto> lista = new ProdutoDAO().listarTodos();
		request.setAttribute("produtos", lista);
		return "listaProdutos";
	}
}
