<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Pesquisar Cliente</title>
<link rel="icon" href="imagens/clienteIconNovo.png">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>

	<header id="navbar">
		<img src="img/carro2.png" alt="carro1">
		<h2>GARAGE CONTROL</h2>
		<nav>
			<ul id="navbar-list">
				<li><a href="index.html">Home</a></li>
				<li><a href="#">Sobre</a></li>
				<li><a href="#">Carros</a></li>
				<li><a href="client">Clientes</a></li>
				<li><a href="#">Contato</a></li>
			</ul>
		</nav>
	</header>
	<div id="teste">
	<h3>Pesquisar Cliente</h3>
	</div>
	<h4>Pesquisar cliente</h4>
	<form id="form1" name="frmCliente" action="printer">
		<table>
			<tr>
				<td><label>Código: </label>
				<input type="text" name="idcli" id="caixa3" readonly
					value="<%out.print(request.getAttribute("idcli"));%>"></td>
			</tr>
			<tr>
				<td><label>Nome: </label>
					<input type="text" name="nome" class="Caixa1"
						value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><label>RG: </label>
				<input type="text" name="rg" class="Caixa2"
					value="<%out.print(request.getAttribute("rg"));%>"></td>
			</tr>
			<tr>
				<td><label>CPF: </label>
				<input type="text" name="cpf" class="Caixa2"
					value="<%out.print(request.getAttribute("cpf"));%>"></td>
			</tr>
			<tr>
				<td><label>Nascimento: </label>
				<input type="text" name="dtnasc" class="Caixa2"
					value="<%out.print(request.getAttribute("dtnasc"));%>"></td>
			</tr>
			<tr>
				<td><label>CEP: </label>
				<input type="text" name="cep" class="Caixa2"
					value="<%out.print(request.getAttribute("cep"));%>"></td>
			</tr>
			<tr>
				<td><label>Telefone: </label>
				<input type="text" name="fone" class="Caixa2"
					value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td><label>Rua: </label>
				<input type="text" name="rua" class="Caixa1"
					value="<%out.print(request.getAttribute("rua"));%>"></td>
			</tr>
			<tr>
				<td><label>Número: </label>
				<input type="text" name="num" class="Caixa2"
					value="<%out.print(request.getAttribute("num"));%>"></td>
			</tr>
			<tr>
				<td><label>Bairro: </label>
				<input type="text" name="bai" class="Caixa1"
					value="<%out.print(request.getAttribute("bai"));%>"></td>
			</tr>
			<tr>
				<td><label>Cidade: </label>
				<input type="text" name="cid" class="Caixa2"
					value="<%out.print(request.getAttribute("cid"));%>"></td>
			</tr>
			<tr>
				<td><label>UF: </label>
				<input type="text" name="uf" class="Caixa2"
					value="<%out.print(request.getAttribute("uf"));%>"></td>
			</tr>
			<tr>
				<td><label>Complemento: </label>
				<input type="text" name="comp" class="Caixa1"
					value="<%out.print(request.getAttribute("comp"));%>"></td>
			</tr>
			<tr>
				<td><label>Cadastro: </label>
				<input type="text" name="dtcad" class="Caixa2"
					value="<%out.print(request.getAttribute("dtcad"));%>"></td>
			</tr>
			<tr>
				<td><label>Status: </label>
				<input type="text" name="status" class="Caixa2"
					value="<%out.print(request.getAttribute("status"));%>"></td>
			</tr>
		</table>
		<a href="client" class="Botao4"> Voltar </a>
		<input type="button" value="Imprimir Ficha" class="Botao8" onclick="validar()">
		<a href="printer"></a>
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>