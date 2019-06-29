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
	<h1>Arquitetura de referência</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL}">
			<h1>Olá ${usuario.nome}</h1>
			<a href="logout">Logout</a>
			<a href="exibeFormCadastroUsuario">Cadastrar novo usuário</a>
			<a href="listarTodos">Listar Usuarios </a>
			<a href="listarFuncionarioTodos">Listar Funcionarios </a>
		</c:when>

		<c:otherwise>
			<c:if test="${erro != NULL}">${erro}</c:if>

			<form action="login" method="post">
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
			<th>Ações</th>
		</thead>
		<tbody>
			<c:forEach var="f" items="${funcionarios}">
				<tr>
					<td>${f.nomeFuncionario}</td>
					<td>${f.email}</td>
					<td>${f.senha}</td>
					<td><a href="atualizar?id=${f.id}">Atualizar</a><a href="excluir?id=${f.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>






