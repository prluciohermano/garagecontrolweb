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

				List<ModelUsuario> modelUsuarios = daoUsuarioRepositary.consultaUsuarioLista(super.getUserLogado(request));
				request.setAttribute("modelUsuarios", modelUsuarios);

				request.setAttribute("msg", "Exclu�do com sucesso!");
				request.setAttribute("totalPagina", daoUsuarioRepositary.totalPagina(this.getUserLogado(request)));
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

				request.setAttribute("msg", "Usu�rio em edi��o");
				request.setAttribute("modelUsuario", modelUsuario);
				request.setAttribute("totalPagina", daoUsuarioRepositary.totalPagina(this.getUserLogado(request)));
				request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);

			} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("listarUser")) {

				List<ModelUsuario> modelUsuarios = daoUsuarioRepositary
						.consultaUsuarioLista(super.getUserLogado(request));

				request.setAttribute("msg", "Usu�rios carregados");
				request.setAttribute("modelUsuarios", modelUsuarios);
				request.setAttribute("totalPagina", daoUsuarioRepositary.totalPagina(this.getUserLogado(request)));
				request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);
				
			} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("downloadFoto")) {
				String idUser = request.getParameter("id");
				
				ModelUsuario modelUsuario = daoUsuarioRepositary.consultaUsuarioID(idUser, super.getUserLogado(request));
				
				if(modelUsuario.getFotoUser() != null && !modelUsuario.getFotoUser().isEmpty()) {
					
					response.setHeader("Content-Disposition", "attachment;filename=fotoUsuario." + modelUsuario.getExtensaoFotoUser());
					response.getOutputStream().write(new Base64().decodeBase64(modelUsuario.getFotoUser().split("\\,")[1]));
				}
				
			} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("paginar")) {
				Integer offset = Integer.parseInt(request.getParameter("pagina"));
				
				List<ModelUsuario> modelUsuarios = daoUsuarioRepositary.consultaUsuarioListPaginada(this.getUserLogado(request), offset);
				
				request.setAttribute("modelUsuarios", modelUsuarios);
				request.setAttribute("totalPagina", daoUsuarioRepositary.totalPagina(this.getUserLogado(request)));
				request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);
				
			} else {
				List<ModelUsuario> modelUsuarios = daoUsuarioRepositary.consultaUsuarioLista(super.getUserLogado(request));
				request.setAttribute("modelUsuarios", modelUsuarios);
				request.setAttribute("totalPagina", daoUsuarioRepositary.totalPagina(this.getUserLogado(request)));
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
			String msg = "Opera��o realizada com sucesso!";

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String perfil = request.getParameter("perfil");
			String sexo = request.getParameter("sexo");
			
			String cpf = request.getParameter("cpf");
			String cep = request.getParameter("cep");
			String logradouro = request.getParameter("logradouro");
			String numero = request.getParameter("numero");
			String complemento = request.getParameter("complemento");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String uf = request.getParameter("uf");

			ModelUsuario modelUsuario = new ModelUsuario();
			
			modelUsuario.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			modelUsuario.setNome(nome);
			modelUsuario.setEmail(email);
			modelUsuario.setLogin(login);
			modelUsuario.setSenha(senha);
			modelUsuario.setPerfil(perfil);
			modelUsuario.setSexo(sexo);
			
			modelUsuario.setCpf(cpf);
			modelUsuario.setCep(cep);
			modelUsuario.setLogradouro(logradouro);
			modelUsuario.setNumero(numero);
			modelUsuario.setComplemento(complemento);
			modelUsuario.setBairro(bairro);
			modelUsuario.setCidade(cidade);
			modelUsuario.setUf(uf);

			if (ServletFileUpload.isMultipartContent(request)) {
				Part part = request.getPart("fileFoto"); // Pega foto da tela
				
				if (part.getSize() >0) {
					byte[] foto = IOUtils.toByteArray(part.getInputStream()); // Converte imagem para Byte
					String imagemBase64 = "data:image/" + part.getContentType().split("\\/")[1] + ";base64," + new Base64().encodeBase64String(foto);
					
					modelUsuario.setFotoUser(imagemBase64);
					modelUsuario.setExtensaoFotoUser(part.getContentType().split("\\/")[1]);
				}
			}

			if (daoUsuarioRepositary.validarLogin(modelUsuario.getLogin()) && modelUsuario.getId() == null) {
				
				msg = "J� existe usu�rio com o mesmo login, informe outro login";
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
			request.setAttribute("totalPagina", daoUsuarioRepositary.totalPagina(this.getUserLogado(request)));
			request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
		}
	}

}
