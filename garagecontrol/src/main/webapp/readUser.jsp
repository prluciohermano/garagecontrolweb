<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Usuario"%>
<%@ page import="Dao.DaoUsuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
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
		<h3>Recuperar a Senha</h3>
	</div>
	
	<div class="Box">
	<img src="img/esqueceuSenha.jpg" class="fundo2">
	<br>
		<form id="form2" name="frmUsuario" action="readUser" method="post">
		<br><br><br><br><br><br><br><br><br>
		<h1>Esqueceu sua senha?</h1>
		<h4>Informe seu e-mail para alterar sua senha.</h4><br>
		<input name="usuEmail" value="" placeholder="Digite o e-mail" class="Caixa4" autofocus/>
		<br>
		<br>
		<input type="submit" value="Entrar" class="Botao9" onclick="valida()">	
	</form>
	</div>
	<script src="scripts/confirma.js"></script>
	
	</body>
	</html>