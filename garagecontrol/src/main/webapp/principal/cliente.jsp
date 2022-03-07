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
<title>Clientes</title>
<link rel="icon" href="imagens/clienteIcon.png">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<% 
		String usuLogin = (String) session.getAttribute("usuLogin");
		if (usuLogin == null){
			response.sendRedirect("user.jsp");
		} else {
			out.print("Usuário logado: " + usuLogin + "<br/>");
		}
	
	%>
	<header id="navbar">
		<img src="img/carro2.png" alt="carro1">
		<h2>GARAGE CONTROL</h2>
		<nav>
			<ul id="navbar-list">
				
				<li><a href="Logger">Sistema</a></li>
				<li><a href="client">Clientes</a></li>
				<li><a href="Deslogar">Deslogar</a></li>
			</ul>
		</nav>
	</header>

	<div id="teste">
		<h3>Clientes</h3>
	</div>
	<br>
	<form method="get" action="read">
		<a href="Logger" class="Botao4"> Voltar </a> <a href="novo"
			class="Botao3">+Novo cliente</a> <input id="box" type="text"
			name="pesNome" value=""
			placeholder="Digite o nome aqui para pesquisar" class="Caixa1" /> <input
			type="submit" value="Pesquisar" class="Botao5"> <a
			href="report" class="Botao6">Relatório</a>
	</form>
	<table id="tabela">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>RG</th>
				<th>CPF</th>
				<th>Data Nascimento</th>
				<th>CEP</th>
				<th>Telefone</th>
				<th>Rua</th>
				<th>Número</th>
				<th>Bairro</th>
				<th>Cidade</th>
				<th>Estado</th>
				<th>Complemento</th>
				<th>Data Cadastro</th>
				<th>Status</th>
				<th>Edição</th>
				<th>Exclusão</th>
		</thead>
		<%
		for (int i = 0; i < lista.size(); i++) {
		%>
		<tr>
			<td><%=lista.get(i).getPES_COD()%></td>
			<td><%=lista.get(i).getPES_NOME()%></td>
			<td><%=lista.get(i).getPES_RG()%></td>
			<td><%=lista.get(i).getPES_CPF()%></td>
			<td><%=lista.get(i).getPES_DTNASCIMENTO()%></td>
			<td><%=lista.get(i).getPES_CEP()%></td>
			<td><%=lista.get(i).getPES_TEL()%></td>
			<td><%=lista.get(i).getPES_RUA()%></td>
			<td><%=lista.get(i).getPES_NUM()%></td>
			<td><%=lista.get(i).getPES_BAI()%></td>
			<td><%=lista.get(i).getPES_CID()%></td>
			<td><%=lista.get(i).getPES_UF()%></td>
			<td><%=lista.get(i).getPES_COMP()%></td>
			<td><%=lista.get(i).getPES_DTCADASTRO()%></td>
			<td><%=lista.get(i).getPES_STATUS()%></td>
			<td><a href="select?PES_COD=<%=lista.get(i).getPES_COD()%>"
				class="Botao">Editar</a></td>
			<td><a
				href="javascript: confirmar(<%=lista.get(i).getPES_COD()%>)"
				class="Botao2">Excluir</a></td>
		</tr>
		<%
		}
		%>
		<tbody>


		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>