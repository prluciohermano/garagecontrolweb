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

@WebFilter(urlPatterns = {"/principal/*"}) /*Intercepta todas as requisições que vierem do projeto ou mapeamento */
public class FilterAutentication implements Filter {

	public FilterAutentication() {
        System.out.println("Filter Autenticou");
    }
	/* Encerra os processos quando o servidor é parado */
	public void destroy() {
		
	}
	/* Intercepta as requisições e as respostas no sistema*/
	/* validação e autenticação*/
	/* dar commit e rolback de transações do banco*/
	/* validadar e redirecionar as páginas*/
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
				
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
		}
		
		chain.doFilter(request, response);
	}

	/* Inicia os processos ou recursos do projeot quando o servidor iniciar a conexão com o banco.*/
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
