<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../styles/style.css">
	<link rel="stylesheet" href="../styles/tachyons.css">
	<link rel="stylesheet" href="../styles/suits.css">
<title>Cadastro de Produto em Estoque - Compre Certo Estoque</title>
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
		</c:when>

		<c:otherwise>
			<c:if test="${erro != NULL}">${erro}</c:if>

			<form action="login" method="post">
				Usuario:<input name="usuario"> Senha:<input name="senha">
				<input type="submit" value="ok">
			</form>
		</c:otherwise>
	</c:choose>
	<div class="diagram-project pt72">
		<h1 class="pt32 blue-title f36">Cadastar Estoque</h1>
	</div>
	${msg}
	<div class="flex justify-center w-100">
		<form action="/comprecertoestoque/frontcontroller/inserirEstoque" method="POST" class="w-34">
			<div class="flex w-100 flex-column pb16">
				<label for="qnt" class="mine-shaft f14 pb4">Quantidade</label>
				<input name="quantidade" id="qnt" class="pa16 bl br bt bb b--light-silver br3" placeholder="Quantidade do produto">
			</div>
			<div class="flex w-100 flex-column pb16">
				<label for="quant_min" class="mine-shaft f14 pb4">Quantidade mínima</label>
				<input name="quantidadeMinima" id="quant_min" class="pa16 bl br bt bb b--light-silver br3" placeholder="Quantidade mínima de produto">
			</div>
			<div class="flex justify-between items-center pt32">
				<a href="mostrarEstoque" class="link light-silver b">Cancelar</a>
				<input type="submit" value="salvar" class="input-reset w-70 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">
			</div>
		</form>
	</div>
</body>
</html>