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
												<div class="card-block">
													<!-- Basic Form Inputs card start -->
													<h4 class="sub-title">Cadastro de Telefone</h4>

													<form class="form-material"
														action="<%=request.getContextPath()%>/ServletTelefone"
														method="post" id="formFone">

														<div class="form-group form-default form-static-label">
															<input type="text" name="id" id="id" class="form-control"
																readonly="readonly" value="${modelUsuario.id }">
															<span class="form-bar"></span> <label class="float-label">Id
																Usu�rio:</label>
														</div>
														<div class="form-group form-default form-static-label">
															<input readonly="readonly" type="text" name="nome"
																id="nome" class="form-control"
																value="${modelUsuario.nome }"> <span
																class="form-bar"></span> <label class="float-label">Nome:</label>
														</div>

														<div class="form-group form-default">
															<input type="text" name="numero" id="numero"
																class="form-control" required="required"> <span
																class="form-bar"></span> <label class="float-label">N�mero:</label>
														</div>
														<button class="btn btn-success waves-effect waves-light">Salvar</button>
													</form>
												</div>
											</div>
											<!-- Page-body end -->
										</div>
										<span id="msg">${msg}</span>

										<div style="height: 300px; width: 70%; overflow: scroll">
											<table class="table" id="tabelaUsuarioView">
												<thead>
													<tr>
														<th scope="col">Id Tel</th>
														<th scope="col">N�mero</th>
														<th scope="col">Excluir</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items='${modelTelefones}' var='f'>
														<tr>
															<td><c:out value="${f.tel_id}"></c:out></td>
															<td><c:out value="${f.tel_num}"></c:out></td>
															<td><a class="btn btn-info"
																href="<%= request.getContextPath() %>/ServletTelefone?acao=excluir&id=${f.tel_id}&userpai=${modelUsuario.id}">Excluir</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>

										<div id="styleSelector"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>




			<jsp:include page="javascriptfile.jsp"></jsp:include>
</body>

</html>