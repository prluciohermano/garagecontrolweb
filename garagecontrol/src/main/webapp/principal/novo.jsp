<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Clientes"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Clientes> lista = (ArrayList<Clientes>) request.getAttribute("clientes");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Novo Cliente</title>
<link rel="icon" href="imagens/clienteIconNovo.png">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<% 
		String users = (String) session.getAttribute("usuLogin");
		if (users == null){
			response.sendRedirect("user.jsp");
		} else {
			out.print("Usuário logado: " + users + "<br/>");
		}
	
	%>
<header id="navbar">
        <img src="img/carro2.png" alt="carro1">
        <h2>GARAGE CONTROL</h2>
	<nav>
            <ul id="navbar-list">
           	    <li><a href="index.html">Home</a></li>
                <li><a href="client">Clientes</a></li>
                <li><a href="Deslogar">Deslogar</a></li>
            </ul>
        </nav>
    </header>
	<div id="teste">
	<h3>Novo Cliente</h3>
	</div>
	<h4>Preencha os campos</h4>
	<form id="form1" name="frmCliente" action="insert">
		<table>
			<tr>
				<td><input type="text" name="nome" placeholder="Nome"
					class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="rg" placeholder="RG"
					class="Caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="cpf" placeholder="CPF"
					class="Caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="dtnasc" placeholder="Data Nascimento" 
					class="Caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="cep" placeholder="CEP"
					class="Caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" placeholder="Fone"
					class="Caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="rua" placeholder="Rua"
					class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="num" placeholder="Número"
					class="Caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="bai" placeholder="Bairro"
					class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="cid" placeholder="Cidade"
					class="Caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="uf" placeholder="Estado"
					class="Caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="comp" placeholder="Complemento"
					class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="dtcad" placeholder="Data Cadastro"
					class="Caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="status" placeholder="Status"
					class="Caixa2"></td>
			</tr>
		</table>
		<a href="client" class="Botao4"> Voltar </a>
		<input type="button" value="Adicionar" class="Botao7" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>