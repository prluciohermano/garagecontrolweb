package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOTelefoneRepository;
import dao.DAOUsuarioRepository;
import model.ModelTelefone;
import model.ModelUsuario;

@WebServlet("/ServletTelefone")
public class ServletTelefone extends ServletGenericUtil {
	private static final long serialVersionUID = 1L;

	private DAOUsuarioRepository daoUsuarioRepository = new DAOUsuarioRepository();
	
	private DAOTelefoneRepository daoTelefoneRepository = new DAOTelefoneRepository();

	public ServletTelefone() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			String acao = request.getParameter("acao");
			
			if (acao != null && !acao.isEmpty() && acao.equals("excluir")) {
				
				String idFone = request.getParameter("id");
				
				daoTelefoneRepository.deleteFone(Long.parseLong(idFone));				

				String userPai = request.getParameter("userpai");
				
				ModelUsuario modelUsuario = daoUsuarioRepository.consultaUsuarioId(Long.parseLong(userPai));
				
				List<ModelTelefone> modelTelefones = daoTelefoneRepository.listFone(modelUsuario.getId());
				request.setAttribute("modelTelefones", modelTelefones);

				request.setAttribute("modelUsuario", modelUsuario);
				request.getRequestDispatcher("principal/telefone.jsp").forward(request, response);
				
				return;
			}
			
			
			

			String idUser = request.getParameter("idUser");

			if (idUser != null && !idUser.isEmpty()) {

				ModelUsuario modelUsuario = daoUsuarioRepository.consultaUsuarioId(Long.parseLong(idUser));
				
				List<ModelTelefone> modelTelefones = daoTelefoneRepository.listFone(modelUsuario.getId());
				request.setAttribute("modelTelefones", modelTelefones);

				request.setAttribute("modelUsuario", modelUsuario);
				request.getRequestDispatcher("principal/telefone.jsp").forward(request, response);

			} else {
				List<ModelUsuario> modelUsuarios = daoUsuarioRepository.consultaUsuarioLista(super.getUserLogado(request));
				request.setAttribute("modelUsuarios", modelUsuarios);
				request.setAttribute("totalPagina", daoUsuarioRepository.totalPagina(this.getUserLogado(request)));
				request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			String user_pai_id = request.getParameter("id");
			String tel_num = request.getParameter("numero");
			
			ModelTelefone modelTelefone = new ModelTelefone();
			
			modelTelefone.setTel_num(tel_num);
			modelTelefone.setUser_pai_id(daoUsuarioRepository.consultaUsuarioId(Long.parseLong(user_pai_id)));
			modelTelefone.setUser_cad_id(super.getUserLogadoObjct(request));
			
			daoTelefoneRepository.gravaTelefone(modelTelefone);
			
			List<ModelTelefone> modelTelefones = daoTelefoneRepository.listFone(Long.parseLong(user_pai_id));
			
			ModelUsuario modelUsuario = daoUsuarioRepository.consultaUsuarioId(Long.parseLong(user_pai_id));
			
			request.setAttribute("modelUsuario", modelUsuario);
			request.setAttribute("modelTelefones", modelTelefones);
			request.setAttribute("msg", "Salvo com sucesso!");
			request.getRequestDispatcher("principal/telefone.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
