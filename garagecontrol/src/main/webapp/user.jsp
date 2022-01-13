<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Usuario"%>
<%@ page import="Dao.DaoUsuario"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Usuario> user = (ArrayList<Usuario>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Área Restrita</title>
<link rel="icon" href="imagens/clienteIcon.png">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header id="navbar">
		<img src="img/carro2.png" alt="carro1">
		<h2>Área Restrita</h2>
		<nav>
			<ul id="navbar-list">
				
				<li><a href="index.html">Home</a></li>
				
			</ul>
		</nav>
	</header>

	<div id="teste">
		<h3>Usuário</h3>
	</div>
	
	<div class="Box">
	<img src="img/proj1.jpg" class="fundo2">
	<br>
		<form id="form2" name="frmUsuario" action="readUser">
		<br><br><br><br><br><br><br><br><br>
		<h1>Bem vindo, à Garage Control</h1>
		<h4>Não é revendedor? Cadastre-se</h4><br>
		<input name="usuLogin" value="" placeholder="Digite o login" class="Caixa4" />
		<br>
		<input name="usuSenha" value=""	placeholder="Digite a senha" class="Caixa4" />
		<br>
		<input type="submit" value="Entrar" class="Botao9" onclick="valida()">			
	</form>
	</div>
	<script src="scripts/confirma.js"></script>
	
	</body>
	</html>