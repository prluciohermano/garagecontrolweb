package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Conexao.ConnectionFactory;

@WebFilter(urlPatterns = {"/principal/*"}) /*Intercepta todas as requisições que vierem do projeto ou mapeamento */
public class FilterAutentication implements Filter {

	Connection con = null;
	
	public FilterAutentication() {
        System.out.println("Filter Autenticou");
    }
	/* Encerra os processos quando o servidor é parado */
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* Intercepta as requisições e as respostas no sistema*/
	/* validação e autenticação*/
	/* dar commit e rolback de transações do banco*/
	/* validadar e redirecionar as páginas*/
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
	
			String usuarioLogado = (String) session.getAttribute("usuLogin");
			
			String urlParaAutenticar = req.getServletPath(); /* Url que está sendo acessada*/
			System.out.println(urlParaAutenticar);
			
			if (usuarioLogado == null && !urlParaAutenticar.equalsIgnoreCase("LoginController")) { //Não está logado
				System.out.println("Filter loginController");
				
				RequestDispatcher redireciona = request.getRequestDispatcher("/user.jsp?url=" + urlParaAutenticar);
				request.setAttribute("msg", "Atenção, Área restrita! Necessário fazer o login.");
				redireciona.forward(request, response);
				return; /*Para a execução e redireciona o login*/
			} else {
				chain.doFilter(request, response);
			}
			con.commit(); /* Deu certo então comita as laterações no banco */
			
		} catch (Exception e) {
			e.printStackTrace();
			
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
	}

	/* Inicia os processos ou recursos do projeot quando o servidor iniciar a conexão com o banco.*/
	public void init(FilterConfig fConfig) throws ServletException {
		con = ConnectionFactory.getConnection();
	}

}
