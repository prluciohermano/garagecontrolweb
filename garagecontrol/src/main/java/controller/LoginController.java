package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelLogin;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/principal/LoginController", "/LoginController"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String login = request.getParameter("usuLogin");
		String senha = request.getParameter("usuSenha");
		String url = request.getParameter("url");
		
		String action = request.getServletPath();
		System.out.println(action);
		
		if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
		
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			
			if (modelLogin.getLogin().equalsIgnoreCase("admin")
					&& modelLogin.getSenha().equalsIgnoreCase("admin")) {
			
			request.getSession().setAttribute("usuLogin", modelLogin.getLogin());
			
			if(url == null || url.equals("null")) {
				url = "/principal/Logger.jsp";
			}
			
			RequestDispatcher redirecionar = request.getRequestDispatcher(url);
			redirecionar.forward(request, response);
			//response.sendRedirect("/LoginController");
			
			} else {
				RequestDispatcher redirecionar = request.getRequestDispatcher("/user.jsp");
				request.setAttribute("msg", "Informe o login e senha corretamente");
				redirecionar.forward(request, response);
				
			}
			
		} else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("/user.jsp");
			request.setAttribute("msg", "Informe o login e senha corretamente");
			redirecionar.forward(request, response);
		}
	}
}
