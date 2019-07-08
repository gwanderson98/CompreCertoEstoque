package model.tarefa;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class FabricaDeTarefa {

	static Map<String, Tarefa> tarefas = new HashMap<String, Tarefa>();
	static {
		//usuario (disponibilizado pelo professor)
		tarefas.put("POST/login", new LoginTarefa());
		tarefas.put("GET/logout", new LogoutTarefa());
		//produto
		tarefas.put("GET/exibeFormCadastroProduto", new ExibeFormCadastroProduto());
		tarefas.put("POST/cadastrarProduto",new CadastrarProduto());
		tarefas.put("GET/listarProdutos", new ListarProdutos());
		tarefas.put("GET/atualizarProduto", new AtualizarProduto());
		tarefas.put("POST/atualizarProduto", new AtualizarProduto());
		tarefas.put("GET/excluirProduto", new ExcluirProduto());
		//funcionario
		tarefas.put("GET/listarFuncionarioTodos", new ListarTodosFuncionarios());
		tarefas.put("POST/cadastrarFuncionario", new CadastrarFuncionario());
		tarefas.put("GET/exibeFormCadastroFuncionario", new ExibeFormCadastroFuncionario());
		tarefas.put("GET/excluirFuncionario", new ExcluirFuncionario());
		tarefas.put("GET/atualizarFuncionario", new AtualizarFuncionario());
		tarefas.put("POST/atualizarFuncionario",new AtualizarFuncionario());
		tarefas.put("GET/exibeInformacoesFuncionario", new ExibeInformacoesFuncionario());
		
		//estoque
		tarefas.put("GET/exibeFormCadastroEstoque", new ExibeFormCadastroEstoque());
		tarefas.put("POST/inserirEstoque", new InserirEstoque());
		tarefas.put("GET/mostrarEstoque", new MostraEstoque());
		tarefas.put("GET/atualizarEstoque", new AtualizaEstoque());
		tarefas.put("POST/atualizarEstoque", new AtualizaEstoque());
		tarefas.put("GET/excluirEstoque", new ExcluiEstoque());
		tarefas.put("GET/produtosLoja", new ProdutosLoja());
		
		//Loja
		tarefas.put("GET/excluirLoja", new ExcluirLoja());
		tarefas.put("GET/atualizarLoja", new AtualizarLoja());
		tarefas.put("POST/atualizarLoja", new AtualizarLoja());
	}

	public static Tarefa getTarefa(HttpServletRequest request) {
		Tarefa tarefa = tarefas.get(request.getMethod() + request.getPathInfo());
		if (tarefa != null)
			return tarefa;
		else
			return new NULLTarefa();
	}
}
