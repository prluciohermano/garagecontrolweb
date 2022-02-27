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
	/*
		String usuario = (String) session.getAttribute("usuLogin");
		if (usuario == null){
			response.sendRedirect("user.jsp");
		} else {
			out.print("Bem vindo, " + usuario + " <br/>");
		}
		*/
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
                <li><a href="Deslogar.jsp">Deslogar</a></li>
            </ul>
        </nav>
    </header>
    <!-- fim navbar -->
    <main>
        <!-- banner início -->
        <div id="main-banner">
            <div id="banner-info">
               <!--   <p>Controle de Pátio</p> -->
            </div>
        </div>
       <!-- banner fim -->
        <!-- about inicio -->
        <section id="about-section">
            <h2>Controle total de carros no pátio</h2>
            <p>A vantagem é o controle de tudo a respeito da compra, venda, despesas, <br> lucro e tempo que o carro fica parado na garagem. <br> O sistema vai controlar o tempo que o carro fica na garagem, as despesas de manutenção, o custo final do carro,
                a margem de lucro e o estoque de carros naquela garagem. Nosso software não irá fazer vendas e nem emitir nota fiscal. <br> Somente controle de estoque no pátio

            </p>
        </section>
        <!-- about fim -->
    </main>
    <!-- skills inicio -->
    <section id="skills-section">
        <div class="container">
            <div class="skills-container">
                <img src="img/Computador.jpg" alt="Computador">
                <h3>Computadores</h3>
                <p>Desenvolvido para todas as plataformas de computadores</p>
                <p class="subtitle">Plataformas disponíveis:</p>
                <p>Windows, Linux, MAC OS</p>
                <p class="subtitle">Pacote completo:</p>
                <p>Controle, manutenção e disponibilidade</p>
            </div>
            <div class="skills-container central">
                <img src="img/Dispositivos.jpg" alt="dispositivo">
                <h3>Dispositivos móveis</h3>
                <p>Controle através de todos os dispositivos móveis</p>
                <p class="subtitle">Tipos de dispositivos:</p>
                <p>Celulares, Tablets, Ipads e muito mais.</p>
            </div>
            <div class="skills-container">
                <img src="img/API.jpg" alt="API">
                <h3>API de Integração</h3>
                <p>Com API de integração aos softwares existentes no mercado</p>
                <p class="subtitle">Serviços de Cloud:</p>
                <p>Serviço e servidores na nuvem para evitar altos custos de manutenção</p>
                <p class="subtitle">Possibilidades:</p>
                <p>conexão e integração total para quem já possui sistema de vendas</p>
            </div>
        </div>
    </section>
    <!-- skills fim -->
    <!-- jobs inicio -->
    <section id="jobs-section">
        <h2>Veja nossa plataforma Garage Control:</h2>
        <p>Aqui estão os detalhes do sistema que irá impactar o seu negócio, para ver mais <a href="#">clique aqui.</a></p>
        <div class="job-container">
            <div class="job-box proj1"></div>
            <div class="job-box proj2"></div>
            <div class="job-box proj3"></div>
        </div>
        <div class="job-container">
            <div class="job-box proj4"></div>
            <div class="job-box proj5"></div>
            <div class="job-box proj6"></div>
        </div>
    </section>
    <!-- jobs fim -->
    <!-- footer inicio -->
    <footer>
        <h2>Me mande uma mensagem</h2>
        <p>Caso queira falar sobre o projeto, contratar o serviço para sua empresa, ou falar conosco...</p>
        <img src="img/carro2.png" alt="Perfil carro2">
        <form action="email" method="get" name="teste">
            <input type="text" name="name" placeholder="Seu nome">
            <input type="email" name="email" placeholder="Seu e-mail">
            <textarea name="msg" placeholder="Digite uma mensagem"></textarea>
            <input type="submit" value="Enviar">
        </form>
        <p>Desenvolvido por <span class="detail">Lúcio Hermano Batista</span>
            <br> Análise e Desenvolvimento de Sistemas - UNIGOIÁS
        </p>
    </footer>
    <!-- footer fim -->
	
</body>
</html>