package model.tarefa;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class FabricaDeTarefa {

	static Map<String, Tarefa> tarefas = new HashMap<String, Tarefa>();
	static {
		tarefas.put("POST/login", new LoginTarefa());
		tarefas.put("GET/logout", new LogoutTarefa());
		tarefas.put("GET/exibeFormCadastroUsuario", new ExibeFormCadastroUsuarioTarefa());
		tarefas.put("POST/cadastrarUsuario", new CadastrarUsuarioTarefa());
		tarefas.put("GET/listarFuncionarioTodos", new ListarTodosFuncionarios());
		tarefas.put("POST/cadastrarFuncionario", new CadastrarFuncionario());
		Tarefa t = new AtualizaUsuarioTarefa();
		tarefas.put("GET/atualizar", t);
		tarefas.put("POST/atualizar", t);
		tarefas.put("GET/excluir", new ExcluirUsuarioTarefa());
		tarefas.put("POST/cadastrarProduto",new CadastrarProduto());
		
		tarefas.put("GET/atualizar", new AtualizarFuncionario());
		tarefas.put("POST/atualizar",new AtualizarFuncionario());
	}

	public static Tarefa getTarefa(HttpServletRequest request) {
		Tarefa tarefa = tarefas.get(request.getMethod() + request.getPathInfo());
		if (tarefa != null)
			return tarefa;
		else
			return new NULLTarefa();
	}
}
