package servlets;

import java.io.Serializable;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DAOUsuarioRepository;
import model.ModelTelefone;
import model.ModelUsuario;

public class ServletGenericUtil extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private DAOUsuarioRepository daoUsuarioRepository = new DAOUsuarioRepository();
	
	public Long getUserLogado(HttpServletRequest request) throws SQLException {
		
		HttpSession session = request.getSession();
		
		String userLogado = (String) session.getAttribute("usuario");
		
		return daoUsuarioRepository.consultaUsuarioLogado(userLogado).getId();
		
	}
	
	public ModelUsuario getUserLogadoObjct(HttpServletRequest request) throws SQLException {
		
		HttpSession session = request.getSession();
		
		String userLogado = (String) session.getAttribute("usuario");
		
		return daoUsuarioRepository.consultaUsuarioLogado(userLogado);
		
	}

}
