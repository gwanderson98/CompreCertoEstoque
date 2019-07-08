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
<title>Atualizar Estoque - Compre Certo Estoque</title>
</head>
<body>
      <div class="pt16 fixed bg-white w-100 top-0 header-nav">
        <div class="flex justify-between diagram-project">
          <div class="flex items-center justify-center pointer pb16 menu-dpw" tabindex="1">
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
          <div class="pointer pb16"><img src="../images/logo.svg" alt="Compre Certo Estoque" tabindex="2"/></div>
          <div class="flex items-center justify-center pointer pb16 menu-dpwUser" tabindex="3">
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
		<h1 class="pt32 blue-title f36">Atualizar Estoque</h1>
	</div>
	<div class="w-100 flex justify-center">
		<form action="/comprecertoestoque/frontcontroller/atualizarEstoque" method="POST" class="w-34">
			<div class="flex w-100 flex-column pb16">
				<label for="id_estoque" class="mine-shaft f14 pb4 dn">Id Estoque</label>
				<input name="idEstoque" id="id_estoque" class="pa16 bl br bt bb b--light-silver br3 dn" value="${estoque.getIdEstoque()}">
			</div>
			<div class="flex w-100 flex-column pb16">
				<label for="id_estoque" class="mine-shaft f14 pb4">Nome Produto</label>
				<input name="nomeProduto" id="nomeProduto" class="pa16 bl br bt bb b--light-silver br3" value="${estoque.getNomeProduto()}">
			</div>
			<div class="flex w-100 flex-column pb16">
				<label for="qnt" class="mine-shaft f14 pb4">Quantidade</label>
				<input name="quantidade" id="qnt" class="pa16 bl br bt bb b--light-silver br3" value="${estoque.getQuantidade()}">
			</div>
			<div class="flex w-100 flex-column pb16">
				<label for="qnt_minima" class="mine-shaft f14 pb4">Quantidade Mínima</label>
				<input name="quantidadeMinima" id="qnt_minima" class="pa16 bl br bt bb b--light-silver br3" value="${estoque.getQuantidadeMinima()}">
			</div>
			<div class="flex justify-between items-center pt32">
				<a href="listarFuncionarioTodos" class="link light-silver b">Cancelar</a>
				<input type="submit" value="Salvar" class="input-reset w-70 br3 pa16 button-ok white pointer b" style="background-color:#3A3DA5">
			</div>
		</form>
	</div>
</body>
</html>