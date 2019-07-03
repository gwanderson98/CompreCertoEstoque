<h1>Arquitetura de referência</h1>
<hr>
<c:choose>
	<c:when test="${usuario != NULL}">
		<h1>Olá ${usuario.nome}</h1>
		<a href="logout">Logout</a>
		<a href="exibeFormCadastroFuncionario">Cadastrar novo Funcionario</a>
		<a href="listarFuncionarioTodos">Listar Funcionarios </a>
		<a href="exibeFormCadastroProduto">Cadastrar Produto</a>
		<a href="listarProdutos">Listar Produtos</a>
	</c:when>

	<c:otherwise>
		<c:if test="${erro != NULL}">${erro}</c:if>

		<form action="login" method="post">
			Usuario:<input name="usuario"> Senha:<input name="senha">
			<input type="submit" value="ok">
		</form>
	</c:otherwise>
</c:choose>