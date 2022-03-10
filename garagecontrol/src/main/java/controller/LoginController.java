package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexao.ConnectionFactory;
import Dao.DaoLoginRepository;
import Dao.DaoUsuario;
import model.ModelLogin;
import model.Usuario;


/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/principal/LoginController", "/LoginController"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoUsuario daoUsu = new DaoUsuario();
	private Connection con;   
	private DaoLoginRepository daoLoginRepository = new DaoLoginRepository();
	
    public LoginController() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		con = ConnectionFactory.getConnection();
		String action = request.getServletPath();
		String login = request.getParameter("usuLogin");
		String senha = request.getParameter("usuSenha");
		String url = request.getParameter("url");
		System.out.println(action);
		System.out.println(login);
		System.out.println(senha);
		System.out.println(url);
		
		try {
			
			if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
				con = ConnectionFactory.getConnection();
				ModelLogin modelLogin = new ModelLogin();
				modelLogin.setLogin(login);
				modelLogin.setSenha(senha);
								
				if (daoLoginRepository.validarAutentication(modelLogin)) {
					
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
		
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
		}
	}
}
