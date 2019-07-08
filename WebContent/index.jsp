<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="../styles/style.css">
	<link rel="stylesheet" href="../styles/tachyons.css">
	<link rel="stylesheet" href="../styles/suits.css">
	<title>Home - Compre Certo Estoque</title>
</head>

<body>

	<c:choose>
<c:when test="${usuario != NULL}">
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
      <div class="pt72 diagram-project">
      	<h1 class="pt42 blue-title f36">Home</h1>
      </div>
      <div class="pt32 diagram-project">
      	<div class="flex justify-between w-100 pb32">
	      	<a href="listarProdutos" value="Produtos" class="no-underline db input-reset w-40 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">Produtos</a>
	      	<a href="exibeFormCadastroProduto" value="Cadastrar produto" class="no-underline db input-reset w-40 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">Cadastrar produto</a>
      	</div>
      	<div class="flex justify-between w-100 pb32">
	      	<a href="listarFuncionarioTodos" value="Funcionários" class="no-underline db input-reset w-40 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">Funcionários</a>
	      	<a href="exibeFormCadastroFuncionario" value="Cadastrar Funcionário" class="no-underline db input-reset w-40 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">Cadastrar Funcionário</a>
      	</div>
      	<div class="flex justify-between w-100 pb32">
	      	<a href="mostrarEstoque" value="Estoque" class="no-underline db input-reset w-40 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">Estoque</a>
	      	<a href="exibeFormCadastroEstoque" value="Cadastrar no Estoque" class="no-underline db input-reset w-40 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">Cadastrar no Estoque</a>
      	</div>
      </div>
		</c:when>

		<c:otherwise>
			<c:if test="${erro != NULL}">${erro}</c:if>
			<div class="flex justify-center w-100 vh-100">
				<form action="/comprecertoestoque/frontcontroller/login" method="post" class="w-34 flex flex-column items-center justify-center ">
					<img src="../images/logo.svg" alt="Compre Certo Estoque" class="pb72"/>
					<div class="flex w-100 flex-column pb16">
						<label class="mine-shaft f14 pb4" for="user-login">Usuário</label>
						<input name="usuario" id="user-login" class="pa16 bl br bt bb b--light-silver br3" placeholder="Email">
					</div>
					<div class="flex w-100 flex-column pb16 pt32">
						<label class="mine-shaft f14 pb4" for="user-senha">Senha:</label>
						<input type="password" name="senha" id="user-senha" class="pa16 bl br bt bb b--light-silver br3" placeholder="Senha" >
					</div>
					<div class="flex justify-between items-center pt32 w-100">
						<a href="" class="link light-silver b">Esqueci minha senha</a>
						<input type="submit" value="Logar" class="input-reset w-60 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">
					</div>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
</body>

</html>