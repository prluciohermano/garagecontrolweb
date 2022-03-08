package filter;

import java.io.IOException;

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

@WebFilter(urlPatterns = {"/principal/*"}) /*Intercepta todas as requisi��es que vierem do projeto ou mapeamento */
public class FilterAutentication implements Filter {

	public FilterAutentication() {
        System.out.println("Filter Autenticou");
    }
	/* Encerra os processos quando o servidor � parado */
	public void destroy() {
		
	}
	/* Intercepta as requisi��es e as respostas no sistema*/
	/* valida��o e autentica��o*/
	/* dar commit e rolback de transa��es do banco*/
	/* validadar e redirecionar as p�ginas*/
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
				
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		String usuarioLogado = (String) session.getAttribute("usuLogin");
		
		String urlParaAutenticar = req.getServletPath(); /* Url que est� sendo acessada*/
		System.out.println(urlParaAutenticar);
		
		if (usuarioLogado == null && !urlParaAutenticar.equalsIgnoreCase("LoginController")) { //N�o est� logado
			System.out.println("Filter loginController");
			
			RequestDispatcher redireciona = request.getRequestDispatcher("/user.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "Aten��o, �rea restrita! Necess�rio fazer o login.");
			redireciona.forward(request, response);
			return; /*Para a execu��o e redireciona o login*/
		}
		
		chain.doFilter(request, response);
	}

	/* Inicia os processos ou recursos do projeot quando o servidor iniciar a conex�o com o banco.*/
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
