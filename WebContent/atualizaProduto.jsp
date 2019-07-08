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
<title>Atualizar Produto</title>
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
	<div class="diagram-project pt32">
	<h1 class="pt72 blue-title f36">Atualizar Produto</h1>
	<div class="w-100 flex items-center justify-center">
		<form action="/comprecertoestoque/frontcontroller/atualizarProduto" method="POST" class="pt42 w-34 flex flex-column">
			<div class="flex w-100 flex-column pb16">
				<label class="mine-shaft f14 pb4" for="Id_produto">Id</label>
				<input disabled name="Id_produto" id="Id_produto" class="pa16 bl br bt bb b--light-silver br3" value="${entidade.getIdProduto()}">
			</div>
			<div class="flex w-100 flex-column pb16">
				<label class="mine-shaft f14 pb4" for="Nome">Nome</label>
				<input name="Nome" id="Nome" class="pa16 bl br bt bb b--light-silver br3" value="${entidade.getNome()}">
			</div>
			<div class="flex w-100 flex-column pb16">
				<label class="mine-shaft f14 pb4" for="Cod_produto">Código do produto</label>
				<input name="Cod_produto" id="Cod_produto" class="pa16 bl br bt bb b--light-silver br3" value="${entidade.getCodProduto()}">
			</div>
			<div class="flex justify-between items-center">
				<a href="listarProdutos" class="link light-silver b">Cancelar</a>
				<input type="submit" value="Salvar" class="input-reset w-70 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">
			</div>
		</form>
	</div>
	</div>
</body>
</html>