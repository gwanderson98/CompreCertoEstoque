package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProdutoDAO;
import model.javabean.Produto;

public class CadastrarProduto implements Tarefa {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recuperar os parametros do formulario
		Produto produto = new Produto(request.getParameter("nome"),
				request.getParameter("cod_produto"));
		// enviar dados para o DAO persistir
		new ProdutoDAO().salvar(produto);
		//retornar o nome da view
		request.setAttribute("msg", "parabéns produto cadastrado com sucesso");
		return "cadastroProduto";
	}
}
