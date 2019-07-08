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
<title>Atualizar Funcionário - Compre Certo Estoque</title>
</head>
<body>
      <div class="pt16 fixed bg-white w-100 top-0 header-nav">
        <div class="flex justify-between diagram-project">
          <div class="flex items-center justify-center pointer pb16 menu-dpw">
            <img src="../images/menu.svg" alt="menu" class="pr10 menuIcon" id="menuIcon"/>
            <span>Menu</span>
            <div id='menu' class="absolute br3 menu">
              <div class="flex flex-column">
                <div><a href="listarProdutos">Produtos</a></div>
                <div><a href="exibeFormCadastroProduto">Cadastrar Produto</a></div>
                <div><a href="listarFuncionarioTodos">Funcionários</a></div>
                <div><a href="exibeFormCadastroFuncionario">Cadastrar Funcionário</a></div>
                <div><a href="mostrarEstoque">Estoque</a></div>
                <div><a href="exibeFormCadastroEstoque">Cadastrar no Estoque</a></div>
              </div>
            </div>
          </div>
          <div class="pointer pb16"><img src="../images/logo.svg" alt="Compre Certo Estoque"/></div>
          <div class="flex items-center justify-center pointer pb16 menu-dpwUser">
            <img src="../images/user.svg" alt="user" class="pa10"/>
            <span>${usuario.nome}</span>
            <img src="../images/arrow.svg" alt="\/" class="pl10"/>
            <div id='menuUser' class="absolute br3 menuUser">
              <div class="flex flex-column">
                <div><a href="logout">Sair</a></div>
              </div>
            </div>
          </div>
        </div>
      </div>
	<div class="diagram-project pt72">
		<h1 class="pt32 blue-title f36">Atualizar Funcionário</h1>
	</div>
	<c:if test="${!empty funcionario }">
		<div class="w-100 diagram-project flex items-center justify-center">
			<form action="/comprecertoestoque/frontcontroller/atualizarFuncionario" method="POST" class="w-34 flex flex-column">
				<input type="hidden" name="CPF" value="${entidade.CPF}">
					<div class="flex w-100 flex-column pb16">
						<label for="nomeFuncionario" class="mine-shaft f14 pb4">Nome</label>
						<input name="nomeFuncionario" id="nomeFuncionario" class="pa16 bl br bt bb b--light-silver br3" value="${entidade.nomeFuncionario}">
					</div>
					<div class="flex w-100 flex-column pb16">
						<label for="email" class="mine-shaft f14 pb4">Email</label>
						<input name="email" id="email" class="pa16 bl br bt bb b--light-silver br3" value="${entidade.email}">
					</div>
					<div class="flex w-100 flex-column pb16">
						<label for="senha" class="mine-shaft f14 pb4">Senha</label>
						<input name="senha" id="senha" class="pa16 bl br bt bb b--light-silver br3" value="${entidade.senha}">
					</div>
					<div class="flex w-100 flex-column pb16">
						<label for="telefone" class="mine-shaft f14 pb4">Telefone</label>
						<input name="telefone" id="telefone" class="pa16 bl br bt bb b--light-silver br3" value="${entidade.telefone}">
					</div>
					<div class="flex w-100 flex-column pb16">
						<label for="CPF" class="mine-shaft f14 pb4">CPF</label>
						<input name="CPF" id="CPF" class="pa16 bl br bt bb b--light-silver br3" value="${entidade.CPF}">
					</div>
					<select name="cargo" class="pa16 bl br bt bb b--light-silver br3">
						<option value="0">Funcionario</option>
			   			<option value="1">Administrador</option>
					</select>
					<div class="flex justify-between items-center pt32">
						<a href="listarFuncionarioTodos" class="link light-silver b">Cancelar</a>
						<input type="submit" value="Salvar" class="input-reset w-70 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">
					</div>
			</form>
		</div>
	</c:if>
</body>
</html>