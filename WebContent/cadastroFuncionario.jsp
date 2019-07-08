<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Funcionario</title>
</head>
<body>
<h1>Arquitetura de referência</h1>
	<hr>
	<form action="/comprecertoestoque/frontcontroller/cadastrarFuncionario" method="post">
		telefone:<input name="telefone"> 
		CPF:<input name="cpf">
		senha: <input name="senha">
		nomeFuncionario: <input name="nomeFuncionario">
		email: <input name="email">
		<select name="cargo">
			<option value="1">Funcionario</option>
   			<option value="2">Administrador</option>
		</select>
		<input type="submit" value="ok">
	</form>
</html>