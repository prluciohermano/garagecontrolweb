<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Usuario"%>
<%@ page import="Dao.DaoUsuario"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Garage Control</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/styles.css">
<link rel="icon" href="imagens/clienteIcon.png">
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
	<!-- navbar -->
    <header id="navbar">
        <img src="img/carro2.png" alt="carro1">
        <h2>GARAGE CONTROL</h2>
        <nav>
            <ul id="navbar-list">
            	<li><a href="#">Ordem Serviço</a></li>
                <li><a href="#">Veículos</a></li>
                <li><a href="client">Clientes</a></li>
                <li><a href="#">Usuários</a></li>
                <li><a href="user.jsp">Deslogar</a></li>
            </ul>
        </nav>
    </header>
        <div id="main-banner"></div>
    <footer>
        <p>Desenvolvido por <span class="detail">Lúcio Hermano Batista</span>
            <br> Análise e Desenvolvimento de Sistemas - UNIGOIÁS
        </p>
    </footer>
</body>
</html>