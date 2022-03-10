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
import Dao.DaoCliente;
import Dao.DaoProduto;
import Dao.DaoUsuario;
import model.Clientes;
import model.Produto;
import model.Usuario;

@WebServlet(urlPatterns = {"/productController", "/novoProduto", "/product", "/LoggerProduct", "/insertProduct", "/selectProduct", "/updateProduct", "/deleteProduct", "/readProduct", "/reportProduct",
"/printerProduct" })
public class productController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection con = null;
	DaoProduto dao = new DaoProduto();
	Produto produto = new Produto();
	static boolean bandeira = true;
	boolean achou = false;
	
    public productController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		con = ConnectionFactory.getConnection();

		String action3 = request.getServletPath();
		System.out.println(action3);
			
		if (action3.equals("/novoProduto")) { // direciona para a p�gina principal
			RequestDispatcher rd = request.getRequestDispatcher("/principal/novoProduto.jsp");
			rd.forward(request, response);
			//response.sendRedirect("/novo");
			
		} else if (action3.equals("/LoggerProduct")) { // direciona para a p�gina principal
			RequestDispatcher rd = request.getRequestDispatcher("/principal/Logger.jsp");
			rd.forward(request, response);
			//response.sendRedirect("/Logger");
			
		} else if (action3.equals("/product")) { // direciona para a p�gina principal
			produtos(request, response);

		} else if (action3.equals("/insertProduct")) { // direciona para a p�gina Inserir novo Cliente
			novoProduto(request, response);

		} else if (action3.equals("/selectProduct")) { // direciona para a p�gina selecionarr novo Cliente
			listarProduto(request, response);

		} else if (action3.equals("/updateProduct")) { // direciona para a p�gina Editar novo Cliente
			editarProduto(request, response);

		} else if (action3.equals("/deleteProduct")) { // direciona para a p�gina deletar um Cliente
			removerProduto(request, response);

		} else if (action3.equals("/readProduct")) { // direciona para a p�gina pesquisar um Cliente
			pesquisarProduto(request, response);

		} else if (action3.equals("/reportProduct")) { // direciona para a p�gina gerar relat�rio de clientes
			gerarRelProduto(request, response);

		} else if (action3.equals("/printerProduct")) { // direciona para a p�gina imprimir ficha do cliente
			imprimirProduto(request, response);

		} else {
			response.sendRedirect("/principal/user.jsp"); // volta para a p�gina principal
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	private void imprimirProduto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void gerarRelProduto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void pesquisarProduto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void removerProduto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void editarProduto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listarProduto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void novoProduto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void produtos(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ArrayList<Produto> produtos = dao.BuscarProduto();
		//System.out.println(produtos.toString());
		request.setAttribute("produtos", produtos);
		RequestDispatcher rd = request.getRequestDispatcher("/principal/product.jsp");
		rd.forward(request, response);
		
	}

}
