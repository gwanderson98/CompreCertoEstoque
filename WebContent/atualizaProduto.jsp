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
	<h1>Atualiza Produto</h1>
	<hr>
	<form action="/comprecertoestoque/frontcontroller/atualizarLoja" method="POST">
		<input type="hidden" name="IdProduto" value="${juncao.getIdProduto()}">
		<input type="hidden" name="IdEstoque" value="${juncao.getIdEstoque()}">
		Produto :<input name="Nome" value="${juncao.getNome()}"> 
		Codigo Produto: <input name="CodProduto" value="${juncao.getCodProduto()}">	
		Quantidade: <input name="Quantidade" value="${juncao.getQuantidade()}">
		Quantidade Minima: <input name="QuantidadeMinima" value="${juncao.getQuantidadeMinima()}">
		<input type="submit" value="Atualizar">
	</form>
</body>
</html>