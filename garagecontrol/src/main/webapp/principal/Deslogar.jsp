<%
	session.invalidate();
	RequestDispatcher redirecionar = request.getRequestDispatcher("/user.jsp");
	redirecionar.forward(request, response);

%>
