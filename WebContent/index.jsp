<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Arquitetura de refer�ncia</title>
</head>
<body>
	<c:choose>
		<c:when test="${funcionario != NULL}">
		<div style="max-width=33%; float: left;"> 
			<ul>
			<p>Menu</p>
				<li>
					<a href="/comprecertoestoque/frontcontroller/login">HOME</a>
				</li>
				<li>
					<a href="/comprecertoestoque/frontcontroller/produtosLoja">Produtos</a>
				</li>
				<li>
					<a href="/comprecertoestoque/frontcontroller/parcerio">Parcerio</a>
				</li>
			</ul>
		</div>
		<div style="float: none;text-align: center;">
			<h1>Compre Certo</h1>
		</div>
		<div style="float: right;">
			<ul>
				<li>
				<li>
				</li>
					<a href="/comprecertoestoque/frontcontroller/exibeInformacoesFuncionario">Perfil</a>
					<a href="/comprecertoestoque/frontcontroller/logout">Logout</a>
				</li>
			</ul>
			<p>${funcionario.getNomeFuncionario()}</p>
			
			
		</div>
		</c:when>
		<c:otherwise>
			<h1>Compre Certo</h1>
			<hr>
			<form action="/comprecertoestoque/frontcontroller/login" method="post">
				Email:<input name="email"> <br>
				Senha:<input name="senha"> <br>
				<c:if test="${erro != NULL}">${erro}</c:if>
				<input type="submit" value="entrar">
			</form>
			<form action="/comprecertoestoque/frontcontroller/esqueciSenha" method="get">
				<input type="submit" value="Esqueci senha">
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>

