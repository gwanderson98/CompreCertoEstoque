
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../styles/style.css">
	<link rel="stylesheet" href="../styles/tachyons.css">
	<link rel="stylesheet" href="../styles/suits.css">
<title>Esqueci Senha</title>
</head>
<body>
	<div class="diagram-project pt32">
		<a href="login" class="black pt10 f16 no-underline">Voltar</a>
	</div>
	<div class="diagram-project pt32">
		<h1 class="blue-title f36">Esqueci Senha</h1>
	</div>
	<div class="diagram-project w-100 flex flex-column justify-center items-center">
	<div class="pointer pb16"><img src="../images/logo.svg" alt="Compre Certo Estoque"/></div>
		<form action="/comprecertoestoque/frontcontroller/atualizarSenha" method="POST" class="w-34 flex flex-column items-center">
				<div class="flex w-100 flex-column pb16">
					<label for="email" class="mine-shaft f14 pb4">Email</label>
					<input name="email" id="email" class="pa16 bl br bt bb b--light-silver br3">
				</div>
				<div class="flex w-100 flex-column pb16">
					<label for="senha" class="mine-shaft f14 pb4">Senha</label>
					<input type="password" name="senha" id="senha" class="pa16 bl br bt bb b--light-silver br3">
				</div>
				<div class="flex w-100 flex-column pb16">
					<label for="confSenha" class="mine-shaft f14 pb4">Confirmar senha</label>
					<input type="password" name="confSenha" id="confSenha" class="pa16 bl br bt bb b--light-silver br3">
				</div>
			<input type="submit" value="Atualizar" class="input-reset w-70 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">
		</form>
		</div>
</body>
</html>