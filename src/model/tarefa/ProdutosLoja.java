package model.tarefa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.javabean.*;
import model.dao.*;


public class ProdutosLoja implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<JuncaoEstoqueProduto> juncao = new JuncaoEstoqueProdutoDAO().listarTodos();
		request.setAttribute("juncao", juncao);
		return "produtosLoja";
	}

}
