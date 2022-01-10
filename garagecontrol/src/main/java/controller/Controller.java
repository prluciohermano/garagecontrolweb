package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/read", "/report",
		"/printer" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans cliente = new JavaBeans();
	boolean achou = false;

	public Controller() {

		System.out.println("Novo Servlet");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) { // direciona para a página principal
			clientes(request, response);

		} else if (action.equals("/insert")) { // direciona para a página Inserir novo Cliente
			novoCliente(request, response);

		} else if (action.equals("/select")) { // direciona para a página selecionarr novo Cliente
			listarCliente(request, response);

		} else if (action.equals("/update")) { // direciona para a página Editar novo Cliente
			editarCliente(request, response);

		} else if (action.equals("/delete")) { // direciona para a página deletar um Cliente
			removerCliente(request, response);

		} else if (action.equals("/read")) { // direciona para a página pesquisar um Cliente
			pesquisarCliente(request, response);

		} else if (action.equals("/report")) { // direciona para a página gerar relatório de clientes
			gerarRelatorio(request, response);

		} else if (action.equals("/printer")) { // direciona para a página imprimir ficha do cliente
			imprimirCliente(request, response);

		} else {
			// System.out.println(action);
			response.sendRedirect("index.html"); // volta para a página principal
		}

	}

	// Listar clientes

	protected void clientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<JavaBeans> lista = dao.listarClientes();

		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cliente.jsp");
		rd.forward(request, response);
	}

	// Novo cliente

	protected void novoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cliente.setPES_NOME(request.getParameter("nome"));
		cliente.setPES_RG(request.getParameter("rg"));
		cliente.setPES_CPF(request.getParameter("cpf"));
		cliente.setPES_DTNASCIMENTO(request.getParameter("dtnasc"));
		cliente.setPES_CEP(request.getParameter("cep"));
		cliente.setPES_TEL(request.getParameter("fone"));
		cliente.setPES_RUA(request.getParameter("rua"));
		cliente.setPES_NUM(request.getParameter("num"));
		cliente.setPES_BAI(request.getParameter("bai"));
		cliente.setPES_CID(request.getParameter("cid"));
		cliente.setPES_UF(request.getParameter("uf"));
		cliente.setPES_COMP(request.getParameter("comp"));
		cliente.setPES_STATUS(request.getParameter("status"));
		cliente.setPES_DTCADASTRO(request.getParameter("dtcad"));

		dao.inserirCliente(cliente);

		response.sendRedirect("main");
	}

	// Listar cliente

	protected void listarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String PES_COD = request.getParameter("PES_COD");

		cliente.setPES_COD(Integer.parseInt(PES_COD));

		dao.selecionarCliente(cliente);

		request.setAttribute("idcli", cliente.getPES_COD());
		request.setAttribute("nome", cliente.getPES_NOME());
		request.setAttribute("rg", cliente.getPES_RG());
		request.setAttribute("cpf", cliente.getPES_CPF());
		request.setAttribute("dtnasc", cliente.getPES_DTNASCIMENTO());
		request.setAttribute("cep", cliente.getPES_CEP());
		request.setAttribute("fone", cliente.getPES_TEL());
		request.setAttribute("rua", cliente.getPES_RUA());
		request.setAttribute("num", cliente.getPES_NUM());
		request.setAttribute("bai", cliente.getPES_BAI());
		request.setAttribute("cid", cliente.getPES_CID());
		request.setAttribute("uf", cliente.getPES_UF());
		request.setAttribute("comp", cliente.getPES_COMP());
		request.setAttribute("dtcad", cliente.getPES_DTCADASTRO());
		request.setAttribute("status", cliente.getPES_STATUS());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	// Editar cliente

	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getParameter("idcli"));

		cliente.setPES_COD(Integer.parseInt(request.getParameter("idcli")));
		cliente.setPES_NOME(request.getParameter("nome"));
		cliente.setPES_RG(request.getParameter("rg"));
		cliente.setPES_CPF(request.getParameter("cpf"));
		cliente.setPES_DTNASCIMENTO(request.getParameter("dtnasc"));
		cliente.setPES_CEP(request.getParameter("cep"));
		cliente.setPES_TEL(request.getParameter("fone"));
		cliente.setPES_RUA(request.getParameter("rua"));
		cliente.setPES_NUM(request.getParameter("num"));
		cliente.setPES_BAI(request.getParameter("bai"));
		cliente.setPES_CID(request.getParameter("cid"));
		cliente.setPES_UF(request.getParameter("uf"));
		cliente.setPES_COMP(request.getParameter("comp"));
		cliente.setPES_DTCADASTRO(request.getParameter("dtcad"));
		cliente.setPES_STATUS(request.getParameter("status"));

		dao.alterarCliente(cliente);

		response.sendRedirect("main");
	}

	// Remover um cliente

	protected void removerCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String PES_COD = request.getParameter("idcli");

		cliente.setPES_COD(Integer.parseInt(PES_COD));

		dao.deletarCliente(cliente);
		response.sendRedirect("main");
	}

	protected void pesquisarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cliNome = request.getParameter("pesNome");

		for (JavaBeans p : dao.pesquisaCliente(cliNome)) {

			request.setAttribute("idcli", p.getPES_COD());
			request.setAttribute("nome", p.getPES_NOME());
			request.setAttribute("rg", p.getPES_RG());
			request.setAttribute("cpf", p.getPES_CPF());
			request.setAttribute("dtnasc", p.getPES_DTNASCIMENTO());
			request.setAttribute("cep", p.getPES_CEP());
			request.setAttribute("fone", p.getPES_TEL());
			request.setAttribute("rua", p.getPES_RUA());
			request.setAttribute("num", p.getPES_NUM());
			request.setAttribute("bai", p.getPES_BAI());
			request.setAttribute("cid", p.getPES_CID());
			request.setAttribute("uf", p.getPES_UF());
			request.setAttribute("comp", p.getPES_COMP());
			request.setAttribute("dtcad", p.getPES_DTCADASTRO());
			request.setAttribute("status", p.getPES_STATUS());
		}

		RequestDispatcher rd = request.getRequestDispatcher("read.jsp");
		rd.forward(request, response);
	}

	// Gerar relatório em PDF

	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Document documento = new Document();

		try {
			response.setContentType("application/pdf");

			response.addHeader("Content-Disposition", "inline; filename=" + "Clientes.pdf");

			PdfWriter.getInstance(documento, response.getOutputStream());

			documento.open();

			documento.add(new Paragraph("Lista de Clientes: "));
			documento.add(new Paragraph(" "));

			ArrayList<JavaBeans> lista = dao.listarClientes();

			for (int i = 0; i < lista.size(); i++) {

				documento.add(new Paragraph(
						"ID: " + lista.get(i).getPES_COD() + " ----------------------------------------------"));
				documento.add(new Paragraph("Nome: " + lista.get(i).getPES_NOME()));
				documento.add(new Paragraph("RG: " + lista.get(i).getPES_RG()));
				documento.add(new Paragraph("CPF: " + lista.get(i).getPES_CPF()));
				documento.add(new Paragraph("Data Nascimento: " + lista.get(i).getPES_DTNASCIMENTO()));
				documento.add(new Paragraph("CEP: " + lista.get(i).getPES_CEP()));
				documento.add(new Paragraph("Telefone: " + lista.get(i).getPES_TEL()));
				documento.add(new Paragraph("Rua: " + lista.get(i).getPES_RUA()));
				documento.add(new Paragraph("Número: " + lista.get(i).getPES_NUM()));
				documento.add(new Paragraph("Bairro: " + lista.get(i).getPES_BAI()));
				documento.add(new Paragraph("Cidade: " + lista.get(i).getPES_CID()));
				documento.add(new Paragraph("UF: " + lista.get(i).getPES_UF()));
				documento.add(new Paragraph("Complemento: " + lista.get(i).getPES_COMP()));
				documento.add(new Paragraph("Data Cadastro: " + lista.get(i).getPES_DTCADASTRO()));
				documento.add(new Paragraph("Status: " + lista.get(i).getPES_STATUS()));
				documento.add(new Paragraph(" "));

			}
			documento.close();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	// Imprimir a ficha do cliente em PDF

	protected void imprimirCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		Document documento = new Document();

		try {
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "Clientes.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());

			documento.open();
			
			documento.add(new Paragraph("Garage Control System v. 1.0"));
			documento.add(new Paragraph(" "));
			documento.add(new Paragraph("Ficha do Cliente:"));
			documento.add(new Paragraph("--------------------------------------------------------------------------------------------------------------"));
			documento.add(new Paragraph(" "));

			int cliCod = Integer.parseInt(request.getParameter("idcli"));

			DAO dao = new DAO();
			
				for (JavaBeans p : dao.buscarCliente(cliCod)) {

				documento.add(new Paragraph("-ID: " + p.getPES_COD()));
				documento.add(new Paragraph("-Nome: " + p.getPES_NOME()));
				documento.add(new Paragraph("-RG: " + p.getPES_RG()));
				documento.add(new Paragraph("-CPF: " + p.getPES_CPF()));
				documento.add(new Paragraph("-Data Nascimento: " + p.getPES_DTNASCIMENTO()));
				documento.add(new Paragraph("-CEP: " + p.getPES_CEP()));
				documento.add(new Paragraph("-Telefone: " + p.getPES_TEL()));
				documento.add(new Paragraph("-Rua: " + p.getPES_RUA()));
				documento.add(new Paragraph("-Número: " + p.getPES_NUM()));
				documento.add(new Paragraph("-Bairro: " + p.getPES_BAI()));
				documento.add(new Paragraph("-Cidade: " + p.getPES_CID()));
				documento.add(new Paragraph("-UF: " + p.getPES_UF()));
				documento.add(new Paragraph("-Complemento: " + p.getPES_COMP()));
				documento.add(new Paragraph("-Data Cadastro: " + p.getPES_DTCADASTRO()));
				documento.add(new Paragraph("-Status: " + p.getPES_STATUS()));
				documento.add(new Paragraph(" "));
				documento.add(new Paragraph("Fim do arquivo. "));

			}
			
			documento.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	private int[] buscarCliente(int cliCod) {
		// TODO Auto-generated method stub
		return null;
	}
}
