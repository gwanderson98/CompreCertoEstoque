<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Funcionarios</title>
	<script>

	</script>
</head>
<body>
	<h1>Lista Produto</h1>
	<hr>
	
	<a href="/comprecertoestoque/frontcontroller/cadastrarProduto">Cadastrar Produto</a>
	<table border=1>
		<thead>
			<th>Produto</th>
			<th>Quantidade em estoque</th>
			<th>Quantidade Minima</th>
			<th>Ações</th>
		</thead>
		<tbody>
			<c:forEach var="j" items="${juncao}">
				<tr>
					<td>${j.getNome()}</td>
					<td>${j.getQuantidade()}</td>
					<td>${j.getQuantidade()}</td>
					<td><a href="atualizarEstoque?idEstoque=${j.getIdEstoque()}">Atualizar</a><a href="excluirEstoque?IdEstoque=${j.getIdEstoque()}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>






