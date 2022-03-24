package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.primefaces.shaded.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAOUsuarioRepositary;
import model.ModelUsuario;

@MultipartConfig
@WebServlet(urlPatterns = { "/ServletUsuarioController" })
public class ServletUsuarioController extends ServletGenericUtil {

	private static final long serialVersionUID = 1L;

	private DAOUsuarioRepositary daoUsuarioRepositary = new DAOUsuarioRepositary();

	public ServletUsuarioController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String acao = request.getParameter("acao");

			if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletar")) {

				String idUser = request.getParameter("id");
				daoUsuarioRepositary.deletarUser(idUser);

				List<ModelUsuario> modelUsuarios = daoUsuarioRepositary
						.consultaUsuarioLista(super.getUserLogado(request));
				request.setAttribute("modelUsuarios", modelUsuarios);

				request.setAttribute("msg", "Excluído com sucesso!");
				request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);

			} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletarajax")) {

				String idUser = request.getParameter("id");
				daoUsuarioRepositary.deletarUser(idUser);
				response.getWriter().write("Excluido com sucesso!");

			} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarUserAjax")) {

				String nomeBusca = request.getParameter("nomeBusca");

				List<ModelUsuario> dadosJsonUser = daoUsuarioRepositary.consultaUsuarioList(nomeBusca,
						super.getUserLogado(request));

				ObjectMapper mapper = new ObjectMapper();

				String json = mapper.writeValueAsString(dadosJsonUser);

				response.getWriter().write(json);

			} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarEditar")) {
				String id = request.getParameter("id");

				ModelUsuario modelUsuario = daoUsuarioRepositary.consultaUsuarioID(id, super.getUserLogado(request));

				List<ModelUsuario> modelUsuarios = daoUsuarioRepositary
						.consultaUsuarioLista(super.getUserLogado(request));
				request.setAttribute("modelUsuarios", modelUsuarios);

				request.setAttribute("msg", "Usuário em edição");
				request.setAttribute("modelUsuario", modelUsuario);
				request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);

			} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("listarUser")) {

				List<ModelUsuario> modelUsuarios = daoUsuarioRepositary
						.consultaUsuarioLista(super.getUserLogado(request));

				request.setAttribute("msg", "Usuários carregados");
				request.setAttribute("modelUsuarios", modelUsuarios);
				request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);

			} else {
				List<ModelUsuario> modelUsuarios = daoUsuarioRepositary
						.consultaUsuarioLista(super.getUserLogado(request));
				request.setAttribute("modelUsuarios", modelUsuarios);

				request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String msg = "Operação realizada com sucesso!";

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String perfil = request.getParameter("perfil");
			String sexo = request.getParameter("sexo");

			ModelUsuario modelUsuario = new ModelUsuario();
			modelUsuario.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			modelUsuario.setNome(nome);
			modelUsuario.setEmail(email);
			modelUsuario.setLogin(login);
			modelUsuario.setSenha(senha);
			modelUsuario.setPerfil(perfil);
			modelUsuario.setSexo(sexo);

			if (ServletFileUpload.isMultipartContent(request)) {
				Part part = request.getPart("fileFoto"); // Pega foto da tela
				byte[] foto = IOUtils.toByteArray(part.getInputStream()); // Converte imagem para Byte
				String imagemBase64 = new Base64().encodeBase64String(foto);
				System.out.println(imagemBase64);
			}

			if (daoUsuarioRepositary.validarLogin(modelUsuario.getLogin()) && modelUsuario.getId() == null) {
				msg = "Já existe usuário com o mesmo login, informe outro login";
			} else {
				if (modelUsuario.isNovo()) {
					msg = "Gravado com sucesso!";
				} else {
					msg = "Atualizado com sucesso!";
				}
				modelUsuario = daoUsuarioRepositary.gravarUsuario(modelUsuario, super.getUserLogado(request));
			}

			List<ModelUsuario> modelUsuarios = daoUsuarioRepositary.consultaUsuarioLista(super.getUserLogado(request));
			request.setAttribute("modelUsuarios", modelUsuarios);
			request.setAttribute("msg", msg);
			request.setAttribute("modelUsuario", modelUsuario);
			request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
		}
	}

}
