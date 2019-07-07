<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Funcionarios</title>
</head>
<body>
	<h1>Arquitetura de referï¿½ncia</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL}">
			<h1>Olï¿½ ${usuario.nome}</h1>
		<a href="logout">Logout</a>
		<a href="exibeFormCadastroFuncionario">Cadastrar novo Funcionario</a>
		<a href="listarFuncionarioTodos">Listar Funcionarios </a>
		<a href="exibeFormCadastroProduto">Cadastrar Produto</a>
		<a href="listarProdutos">Listar Produtos</a>
		<a href="exibeFormCadastroEstoque">Inserir no Estoque</a>
		<a href="mostrarEstoque">Mostrar Estoque</a>
		</c:when>

		<c:otherwise>
			<c:if test="${erro != NULL}">${erro}</c:if>

			<form action="/comprecertoestoque/frontcontroller/login" method="post">
				Usuario:<input name="usuario"> Senha:<input name="senha">
				<input type="submit" value="ok">
			</form>
		</c:otherwise>
	</c:choose>
	<hr>
	<table border=1>
		<thead>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Senha</th>
			<th>Telefone</th>
			<th>CPF</th>
			<th>Ações</th>
		</thead>
		<tbody>
			<c:forEach var="f" items="${funcionarios}">
				<tr>
					<td>${f.getNomeFuncionario()}</td>
					<td>${f.getEmail()}</td>
					<td>${f.getSenha()}</td>
					<td>${f.getTelefone()}</td>
					<td>${f.getCpf()}</td>
					<td><a href="atualizarFuncionario?CPF=${f.getCpf()}">Atualizar</a><a href="excluirFuncionario?CPF=${f.getCpf()}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>






