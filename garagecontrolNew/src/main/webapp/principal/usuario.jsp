<%@page import="model.ModelUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">


<jsp:include page="head.jsp"></jsp:include>

<body>
	<!-- Pre-loader start -->

	<jsp:include page="theme-loader.jsp"></jsp:include>

	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<jsp:include page="navbar.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="navbarmainmenu.jsp"></jsp:include>

					<div class="pcoded-content">
						<!-- Page-header start -->

						<jsp:include page="page-header.jsp"></jsp:include>

						<!-- Page-header end -->
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">
										<div class="row">
											<div class="col-sm-12">
												<!-- Basic Form Inputs card start -->
												<div class="card">
													<div class="card-block">
														<h4 class="sub-title">Cadastro de Usuário</h4>

														<form class="form-material" enctype="multipart/form-data"
															action="<%=request.getContextPath()%>/ServletUsuarioController"
															method="post" id="formUser">

															<input type="hidden" name="acao" id="acao" value="">

															<div class="form-group form-default form-static-label">
																<input type="text" name="id" id="id"
																	class="form-control" readonly="readonly"
																	value="${modelUsuario.id }" autofocus="autofocus">
																<span class="form-bar"></span> <label
																	class="float-label">Id:</label>
															</div>
															
															<div class="form-group form-default input-group mb-4">
																<div class="input-group-prepend">
																<c:if test="${modelUsuario.fotoUser != '' && modelUsuario.fotoUser != null}">
																	<a href="<%= request.getContextPath()%>/ServletUsuarioController?acao=downloadFoto&id=${modelUsuario.id}">
																	<img alt="Imagem User" id="fotoembase64" src="${modelUsuario.fotoUser}" width="70px">
																	</a>
																</c:if>
																	<c:if test="${modelUsuario.fotoUser == '' || modelUsuario.fotoUser == null}">
																		<img alt="Imagem User" id="fotoembase64" src="assets/images/faq_man.png" width="70px">
																	</c:if>
																</div>
																<input type="file" id="fileFoto" name="fileFoto" accept="image/*" 
																onchange="visualizarImg('fotoembase64', 'fileFoto')" class="form-control-file" style="margin-top: 15px; margin-left: 5px" >
															</div>
															
															<div class="form-group form-default">
																<input type="text" name="nome" id="nome"
																	class="form-control" required=""
																	value="${modelUsuario.nome }"> <span
																	class="form-bar"></span> <label class="float-label">Nome:</label>
															</div>
															<div class="form-group form-default">
																<input type="email" name="email" id="email"
																	class="form-control" required="" autocomplete="off"
																	value="${modelUsuario.email }">
																	<span class="form-bar"></span> <label class="float-label">E-mail:</label>
															</div>
														<div class="form-group form-default">
															<select class="form-control"
																aria-label="Default select example" name="perfil">
															  <option disabled="disabled">[Selecione o Perfil]</option>
															  <option value="ADMIN" <%
															  
															  ModelUsuario modelUsuario = (ModelUsuario) request.getAttribute("modelUsuario");
															  
															  if (modelUsuario != null && modelUsuario.getPerfil().equals("ADMIN")){
																  out.print(" ");
																  	out.print("selected=\"selected\"");
																  out.print(" ");
															  } %>>Admin</option>
															  
															  
															  <option value="GERENCIA" <%
															  modelUsuario = (ModelUsuario) request.getAttribute("modelUsuario");
															  
															  if (modelUsuario != null && modelUsuario.getPerfil().equals("GERENCIA")){
																  out.print(" ");
																  	out.print("selected=\"selected\"");
																  out.print(" ");
															  } %>>Gerência</option>
															  
															  
															  <option value="USUARIO" <%
															  modelUsuario = (ModelUsuario) request.getAttribute("modelUsuario");
															  
															  if (modelUsuario != null && modelUsuario.getPerfil().equals("USUARIO")){
																  out.print(" ");
																  	out.print("selected=\"selected\"");
																  out.print(" ");
															  } %>>Usuário</option>
															</select>
																	<span class="form-bar"></span>
																	<label class="float-label">Perfil:</label>
															</div>
														<div class="form-group form-default">
															    <input type="text" name="cpf" id="cpf"
																class="form-control" required="" autocomplete="off"
																value="${modelUsuario.cpf }"> <span
																class="form-bar"></span> <label class="float-label">CPF:</label>
														</div>
														<div class="form-group form-default">
																<input onblur="pesquisaCep()" type="text" name="cep" id="cep"
																class="form-control" required="" autocomplete="off"
																value="${modelUsuario.cep }"> <span
																class="form-bar"></span> <label class="float-label">CEP:</label>
														</div>
														<div class="form-group form-default">
																<input type="text" name="logradouro" id="logradouro"
																class="form-control" required="" autocomplete="off"
																value="${modelUsuario.logradouro }"> <span
																class="form-bar"></span> <label class="float-label">Logradouro:</label>
														</div>
														<div class="form-group form-default">
															    <input type="text" name="numero" id="numero"
																class="form-control" required="" autocomplete="off"
																value="${modelUsuario.numero }"> <span
																class="form-bar"></span> <label class="float-label">Número:</label>
														</div>
														<div class="form-group form-default">
															    <input type="text" name="complemento" id="complemento"
																class="form-control" required="" autocomplete="off"
																value="${modelUsuario.complemento }"> <span
																class="form-bar"></span> <label class="float-label">Complemento:</label>
														</div>
														<div class="form-group form-default">
															    <input type="text" name="bairro" id="bairro"
																class="form-control" required="" autocomplete="off"
																value="${modelUsuario.bairro }"> <span
																class="form-bar"></span> <label class="float-label">Bairro:</label>
														</div>
														<div class="form-group form-default">
															    <input type="text" name="cidade" id="cidade"
																class="form-control" required="" autocomplete="off"
																value="${modelUsuario.cidade }"> <span
																class="form-bar"></span> <label class="float-label">Cidade:</label>
														</div>
														<div class="form-group form-default">
															    <input type="text" name="uf" id="uf"
																class="form-control" required="" autocomplete="off"
																value="${modelUsuario.uf }"> <span
																class="form-bar"></span> <label class="float-label">UF:</label>
														</div>
								<% /*================================================================================================*/ %>												
															<div class="form-group form-default">
																<input type="text" name="login" id="login"
																	class="form-control" required="" autocomplete="off"
																	value="${modelUsuario.login }"> <span
																	class="form-bar"></span> <label class="float-label">Login:</label>
															</div>
															<div class="form-group form-default">
																<input type="password" name="senha" id="senha"
																	class="form-control" required="" autocomplete="off"
																	value="${modelUsuario.senha }"> <span
																	class="form-bar"></span> <label class="float-label">Senha:</label>
															</div>
																<div class="form-group form-default">
																<input type="radio" name="sexo" checked="checked" value="MASCULINO"
																
																<%
																modelUsuario = (ModelUsuario) request.getAttribute("modelUsuario");
																
																 if (modelUsuario != null && modelUsuario.getPerfil().equals("MASCULINO")){
																	  out.print(" ");
																	  	out.print("checked=\"checked\"");
																	  out.print(" ");
																  }
																%>
																>Masculino</>
																
																<input type="radio" name="sexo" value="FEMININO"
																<%
																modelUsuario = (ModelUsuario) request.getAttribute("modelUsuario");
																
																 if (modelUsuario != null && modelUsuario.getPerfil().equals("FEMININO")){
																	  out.print(" ");
																	  	out.print("checked=\"checked\"");
																	  out.print(" ");
																  }
																%>
																>Feminino</>	
																</div>
															
															<button type="button"
																class="btn btn-primary waves-effect waves-light"
																onclick="limparForm()">Novo</button>
															<button class="btn btn-success waves-effect waves-light">Salvar</button>
															<button type="button"
																class="btn btn-danger waves-effect waves-light"
																onclick="criarDeleteComAjax()">Excluir</button>
																<c:if test="${modelUsuario.id > 0}">
																	<a href="<%= request.getContextPath() %>/ServletTelefone?idUser=${modelUsuario.id}"
																 			class="btn btn-primary waves-effect waves-light">Telefone</a>
																 </c:if>
															<button type="button" class="btn btn-secondary"
																data-toggle="modal" data-target="#ModalUsuario">Localizar
																Usuário</button>
														</form>
													</div>
												</div>
											</div>
											<span>${msg}</span> <br>
											<br>
											<div style="height: 300px; width: 100%; overflow: scroll">
												<table class="table" id="tabelaUsuarioView">
													<thead>
														<tr>
															<th scope="col">ID</th>
															<th scope="col">Nome</th>
															<th scope="col">Ver</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items='${modelUsuarios }' var='ml'>
															<tr>
																<td><c:out value="${ml.id }"></c:out></td>
																<td><c:out value="${ml.nome }"></c:out></td>
																<td><a class="btn btn-info"
																	href="<%= request.getContextPath() %>/ServletUsuarioController?acao=buscarEditar&id=${ml.id }">Ver</a></td>
															</tr>

														</c:forEach>


													</tbody>
												</table>
											</div>
											
											<nav aria-label="Page navigation example">
											  <ul class="pagination">
											    
											    <%
											    int totalPagina = (int) request.getAttribute("totalPagina");
											    for (int p = 0; p< totalPagina; p++){
											    	String url = request.getContextPath() + "/ServletUsuarioController?acao=paginar&pagina=" + (p * 5);
											    	out.print("<li class=\"page-item\"><a class=\"page-link\" href=\""+ url +"\">"+ (p + 1) +"</a></li>");
											    }
											    
											    %>
											    
											    											    
											  </ul>
											</nav>
											
										</div>
									</div>
									<!-- Page-body end -->
								</div>
								<div id="styleSelector"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="ModalUsuario" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Pesquisa de
						Usuário</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<div class="input-group mb-3">
						<input type="text" class="form-control"
							placeholder="Inserir o nome" aria-label="nome" id="nomeBusca"
							aria-describedby="basic-addon2">
						<div class="input-group-append">
							<button class="btn btn-success" type="button"
								onclick="buscarUsuario()">Buscar</button>
						</div>
					</div>
					<div style="height: 300px; overflow: scroll">
						<table class="table" id="tabelaUsuario">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Nome</th>
									<th scope="col">Ver</th>
								</tr>
							</thead>
							<tbody>



							</tbody>
						</table>
					</div>
					<nav aria-label="Page navigation example">
					<ul class="pagination" id="ulPaginacaoUserAjax">
					</ul>
					</nav>
					
					<br> <span id="totalUsuario"></span>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="javascriptfile.jsp"></jsp:include>
	<script type="text/javascript">
	
	function pesquisaCep(){
		var cep = $("#cep").val();
		
		$.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {
			
			if (!("erro" in dados)){
				$("#cep").val(dados.cep);
				$("#logradouro").val(dados.logradouro);
				$("#bairro").val(dados.bairro);
				$("#cidade").val(dados.localidade);
				$("#uf").val(dados.uf);
				
			}
			
		});
	}
	
	function visualizarImg(fotoembase64, fileFoto){
		
		var preview = document.getElementById(fotoembase64); // campo img html
		var fileUser = document.getElementById(fileFoto).files[0];
		var reader = new FileReader();
		reader.onloadend = function (){
		preview.src = reader.result; // Carrega foto na tela
			
		};
		
		if (fileUser){
			reader.readAsDataURL(fileUser); // preview da imagem
		} else {
			preview.src= '';
		}
	}
	
		function verEditar(id) {

			var urlAction = document.getElementById('formUser').action;
			window.location.href = urlAction + '?acao=buscarEditar&id=' + id;
		}
		
		function buscaUserPagAjax(url){
						
			var urlAction = document.getElementById('formUser').action;
			var nomeBusca = document.getElementById('nomeBusca').value;
			
			$.ajax(
					{
						method : "get",
						url : urlAction,
						data : url,
						success : function(response, textStatus, xhr) {

							var json = JSON.parse(response);

							$('#tabelaUsuario > tbody > tr').remove();
							$('#ulPaginacaoUserAjax > li').remove();

							for (var p = 0; p < json.length; p++) {
								$('#tabelaUsuario > tbody')
										.append(
												'<tr> <td>'
														+ json[p].id
														+ '</td> <td>'
														+ json[p].nome
														+ '</td><td><button onclick="verEditar('
														+ json[p].id
														+ ')" type="button" class="btn btn-info">Ver</button></td></tr>')
							}
							document.getElementById('totalUsuario').textContent = 'Resultados: ' + json.length;
							
							var totalPagina = xhr.getResponseHeader("totalPagina");
							
							for (var p = 0; p < totalPagina; p++){
								
								var url = 'nomeBusca=' + nomeBusca + '&acao=buscaUserAjaxPage&pagina=' + (p * 5);
								
								$('#ulPaginacaoUserAjax').append('<li class="page-item"><a class="page-link" href="#" onclick="buscaUserPagAjax(\'' + url + '\')">' + (p + 1) + '</a></li>');
							}
						}

					}).fail(
					function(xhr, status, errorThrown) {
						alert('Erro ao buscar usuário por nome: '
								+ xhr.responseText);
					});
			
		}

		function buscarUsuario() {
			var nomeBusca = document.getElementById('nomeBusca').value;

			if (nomeBusca != null && nomeBusca != '' && nomeBusca.trim != '') { /* Validando que tem que ter valor pra buscar no banco*/

				var urlAction = document.getElementById('formUser').action;

				$.ajax(
								{

									method : "get",
									url : urlAction,
									data : "nomeBusca=" + nomeBusca + '&acao=buscarUserAjax',
									success : function(response, textStatus, xhr) {

										var json = JSON.parse(response);

										$('#tabelaUsuario > tbody > tr').remove();
										$("#ulPaginacaoUserAjax > li").remove();

										for (var p = 0; p < json.length; p++) {
											$('#tabelaUsuario > tbody')
													.append(
															'<tr> <td>'
																	+ json[p].id
																	+ '</td> <td>'
																	+ json[p].nome
																	+ '</td><td><button onclick="verEditar('
																	+ json[p].id
																	+ ')" type="button" class="btn btn-info">Ver</button></td></tr>')
										}
										document.getElementById('totalUsuario').textContent = 'Resultados: '
												+ json.length;
										
										var totalPagina = xhr.getResponseHeader("totalPagina");
										
										for (var p = 0; p  < totalPagina; p++){
											var url = 'nomeBusca=' + nomeBusca + '&acao=buscaUserAjaxPage&pagina=' + (p * 5);
											$("#ulPaginacaoUserAjax").append('<li class="page-item"><a class="page-link" href="#" onclick="buscaUserPagAjax(\'' + url + '\')">' + (p + 1) + '</a></li>');
										}
									}

								}).fail(
								function(xhr, status, errorThrown) {
									alert('Erro ao buscar usuário por nome: '
											+ xhr.responseText);
								});

			}
		}

		function criarDeleteComAjax() {
			if (confirm('Deseja realmente excluir os dados?')) {

				var urlAction = document.getElementById('formUser').action;
				var idUser = document.getElementById('id').value;

				$.ajax({

					method : "get",
					url : urlAction,
					data : "id=" + idUser + '&acao=deletarajax',
					success : function(response) {

						limparForm();
						alert(response);
					}

				}).fail(
						function(xhr, status, errorThrown) {
							alert('Erro ao deletar usuário por id: '
									+ xhr.responseText);
						});
			}
		}

		function criarDelete() {

			if (confirm('Deseja realmente excluir os dados?')) {

				document.getElementById("formUser").method = 'get';
				document.getElementById("acao").value = 'deletar';
				document.getElementById("formUser").submit();
			}
		}

		function limparForm() {
			var elementos = document.getElementById("formUser").elements;

			for (p = 0; p < elementos.length; p++) {
				elementos[p].value = '';
			}
		}
	</script>

</body>

</html>