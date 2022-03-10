<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Produto"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Produto> listaProduto = (ArrayList<Produto>) request.getAttribute("produtos");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Veículos</title>
<link rel="icon" href="imagens/clienteIcon.png">
<link rel="stylesheet" href="css/styles.css">
<!--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
-->
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
				
				<li><a href="Logger">Sistema</a></li>
				<li><a href="product">Veículos</a></li>
				<li><a href="Deslogar">Deslogar</a></li>
			</ul>
		</nav>
	</header>

	<div id="teste">
		<h3>Veículos</h3>
	</div>
	<br>
	<form method="get" action="readProduct">
		<a href="Logger" class="Botao4"> Voltar </a> <a href="novoProduct"
			class="Botao3">+Novo Veículo</a> <input id="box" type="text"
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
				<th>Placa</th>
				<th>Ano Fab</th>
				<th>Ano Modelo</th>
				<th>Cor</th>
				<th>Cap Kg</th>
				<th>Cap M³</th>
				<th>Tara</th>
				<th>Combustível</th>
				<th>Venc IPVA</th>
				<th>Venc Licenc</th>
				<th>Venc Seguro</th>
				<th>Acessórios</th>
				<th>Tipo</th>
				<th>Valor</th>
				<th>Imagem</th>
				<th>Categoria</th>
		</thead>
		<%
		for (int i = 0; i < listaProduto.size(); i++) {
		%>
		<tr>
			<td><%=listaProduto.get(i).getPRO_COD()%></td>
			<td><%=listaProduto.get(i).getPRO_NOME()%></td>
			<td><%=listaProduto.get(i).getPRO_PLA()%></td>
			<td><%=listaProduto.get(i).getPRO_ANF()%></td>
			<td><%=listaProduto.get(i).getPRO_ANM()%></td>
			<td><%=listaProduto.get(i).getPRO_COR()%></td>
			<td><%=listaProduto.get(i).getPRO_CPK()%></td>
			<td><%=listaProduto.get(i).getPRO_CPM()%></td>
			<td><%=listaProduto.get(i).getPRO_TAR()%></td>
			<td><%=listaProduto.get(i).getPRO_COM()%></td>
			<td><%=listaProduto.get(i).getPRO_VCI()%></td>
			<td><%=listaProduto.get(i).getPRO_VCL()%></td>
			<td><%=listaProduto.get(i).getPRO_VCD()%></td>
			<td><%=listaProduto.get(i).getPRO_ACE()%></td>
			<td><%=listaProduto.get(i).getPRO_TIP()%></td>
			<td><%=listaProduto.get(i).getPRO_VAL()%></td>
			<td><%=listaProduto.get(i).getPRO_IMG()%></td>
			<td><%=listaProduto.get(i).getPRO_CAT_NOME()%></td>
	
			<td><a href="select?PRO_COD=<%=listaProduto.get(i).getPRO_COD()%>"
				class="Botao">Editar</a></td>
			<td><a
				href="javascript: confirmar(<%=listaProduto.get(i).getPRO_COD()%>)"
				class="Botao2">Excluir</a></td>
		</tr>
		<%
		}
		%>
		<tbody>


		</tbody>
	
	</table>

	
	<script src="scripts/confirmador.js"></script>
	<!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	-->
</body>
</html>