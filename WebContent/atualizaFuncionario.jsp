<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualizar Funcionario</title>
</head>
<body>
	<h1>Arquitetura de referência</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL}">
			<h1>Olá ${usuario.nome}</h1>
			<a href="logout">Logout</a>
			<a href="exibeFormCadastroUsuario">Cadastrar novo usuário</a>
			<a href="listarTodos">Listar todos</a>
			<a href="exibeFormCadastroProduto">Cadastrar Produto</a>
			<a href="listarProdutos">Listar Produtos</a>
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
	<c:if test="${!empty usuario }">
		<form action="/comprecertoestoque/frontcontroller/atualizarFuncionario" method="POST">
			<input type="hidden" name="CPF" value="${entidade.CPF}"> 
				telefone:<input name="telefone" value="${entidade.telefone}"> 
				CPF:<input name="CPF" value="${entidade.CPF}">
				senha: <input name="senha" value="${entidade.senha}">
				nomeFuncionario: <input name="nomeFuncionario" value="${entidade.nomeFuncionario}">
				email: <input name="email" value="${entidade.email}">
				<select name="cargo">
					<option value="0">Funcionario</option>
		   			<option value="1">Administrador</option>
				</select>
			<input type="submit" value="Atualizar">
		</form>
	</c:if>
</body>
</html>