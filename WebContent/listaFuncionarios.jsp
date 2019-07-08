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
<title>Lista de Funcionarios - Compre Certo Estoque</title>
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
	<div class="diagram-project pt32 flex justify-between items-center">
		<h1 class="pt72 blue-title f36">Lista de Funcionários</h1>
		<a href="exibeFormCadastroFuncionario" class="pt72 no-underline blue-title"><span class="f18 b blue-title">+   </span>Cadastrar Funcionário</a>
	</div>
<c:forEach var="f" items="${funcionarios}">
	<div class="diagram-project pb16">
        <div class="bl br bt bb b--light-silver flex br3 items-center pa12">
          <div class="w-10 pr16 br b--light-silver pb7 pt7">
            <div class="f10 light-silver">Nome</div>
            <div class="f16 mine-shaft truncate">${f.nomeFuncionario}</div>
          </div>
          <div class="w-30 pr16 pl16 br b--light-silver pb7 pt7">
            <div class="f10 light-silver">Email</div>
            <div class="f16 mine-shaft truncate">${f.email}</div>
          </div>
          <div class="w-15 pl16 pb7 pt7">
            <div class="f10 light-silver">Senha</div>
            <div class="f16 mine-shaft truncate">${f.senha}</div>
          </div>
          <div class="w-15 pl16 pb7 pt7 bl b--light-silver">
            <div class="f10 light-silver">Telefone</div>
            <div class="f16 mine-shaft truncate">${f.telefone}</div>
          </div>
          <div class="w-15 pl16 pb7 pt7">
            <div class="f10 light-silver">CPF</div>
            <div class="f16 mine-shaft">${f.CPF}</div>
          </div>
          <div class="flex w-15 justify-around pl16 bl b--light-silver">
            <div class="pointer"><a href="atualizarFuncionario?CPF=${f.CPF}"><img src="../images/edit.svg" alt="Editar"/></a></div>
            <div class="pointer"><a href="excluirFuncionario?CPF=${f.CPF}"><img src="../images/deleteItem.svg" alt="Deletar"/></a></div>
          </div>
        </div>
      </div>
</c:forEach>
</body>
</html>






