package controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

@WebServlet(urlPatterns = {"/EmailController", "/usuEmail"})
public class EmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmailController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		if (action.equals("/EmailController") ) {
			System.out.println("ENVIAR E-MAIL");
			Locale.setDefault(new Locale("pt", "BR"));

			String nomeEmail = request.getParameter("name");
			String endEmail = request.getParameter("email");
			String msgEmail = request.getParameter("msg");
			
			if (!nomeEmail.equals("") && !endEmail.equals("") && !msgEmail.equals("")) {
				String meuEmail = "prluciohermano@gmail.com";
				String minhaSenha = "618Lucio618";
				
				SimpleEmail email = new SimpleEmail();
				email.setHostName("smtp.gmail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
				email.setSSLOnConnect(true);
				
				try {
					response.setCharacterEncoding("UTf-8");
					email.setFrom(endEmail);
					email.setSubject(nomeEmail);
					email.setMsg("Ol�, eu sou o " + nomeEmail + "\n\nMeu e-mail �: " + endEmail + "\n\n" + "Mensagem: " + msgEmail);
					email.addTo("danrleybatista@hotmail.com");
					email.send();
					response.setCharacterEncoding("UTf-8");
					System.out.println("Email foi enviado com sucesso");
					nomeEmail = null;
					endEmail = null;
					msgEmail = null;
							
						} catch (Exception e) {
							e.printStackTrace();
						}
				response.getWriter().print("E-mail enviado com sucesso");
				RequestDispatcher rd = request.getRequestDispatcher("/principal/email.jsp");
				rd.forward(request, response);
				response.getWriter().print("E-mail enviado com sucesso");
				//response.sendRedirect("/Logger");
				//response.sendRedirect("index.html");
				} else {
					response.sendRedirect("index.html");
				}
		}
		
		//String action = request.getServletPath();
		if (action.equals("/usuEmail") ) {
			System.out.println("E-mail de Recupera��o");
			Locale.setDefault(new Locale("pt", "BR"));

			String nomeEmail = request.getParameter("usuMail");
						
			if (!nomeEmail.equals("") && !nomeEmail.equals(null)) {
				String meuEmail = "prluciohermano@gmail.com";
				String minhaSenha = "618Lucio618";
				
				SimpleEmail email = new SimpleEmail();
				email.setHostName("smtp.gmail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
				email.setSSLOnConnect(true);
				
				try {
					request.setAttribute("msg2", "Enviando recupera��o de senha!");
					response.setCharacterEncoding("UTf-8");
					email.setFrom(meuEmail);
					email.setSubject("Senha do seu login");
					email.setMsg("Ol�, " + nomeEmail + "\n\nSua senha �: " + "Teste de Senha" + "\n\n" + "Mensagem: Essa � sua senha cadastrada!");
					email.addTo(nomeEmail);
					email.send();
					response.setCharacterEncoding("UTf-8");
					System.out.println("Email foi enviado com sucesso");
					nomeEmail = null;
							
						} catch (Exception e) {
							e.printStackTrace();
						}
				response.getWriter().print("E-mail enviado com sucesso");
				RequestDispatcher rd = request.getRequestDispatcher("/principal/email.jsp");
				rd.forward(request, response);
				response.getWriter().print("E-mail enviado com sucesso");
				//response.sendRedirect("/Logger");
				//response.sendRedirect("index.html");
				} else {
					
					RequestDispatcher redirecionar = request.getRequestDispatcher("/principal/forgot.jsp");
					request.setAttribute("msg", "Informe corretamente o e-mail!");
					//request.setAttribute("msg2", "Enviando recupera��o de senha!");
					redirecionar.forward(request, response);
					//response.sendRedirect("forgot");
				}
		//doGet(request, response);
	}
}
}