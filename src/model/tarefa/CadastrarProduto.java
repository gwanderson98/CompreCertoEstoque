package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProdutoDAO;
import model.javabean.Produto;

public class CadastrarProduto implements Tarefa {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recuperar os parametros do formulario
		Produto produto = new Produto(request.getParameter("id"), 
				request.getParameter("nome"),
				request.getParameter("cod_produto"));
		// enviar dados para o DAO persistir
		new ProdutoDAO().salvar(produto);
		//retornar o nome da view
		request.setAttribute("msg", "parab�ns usuario cadastrado com sucesso");
		return "cadastroUsuario";
	}
}
