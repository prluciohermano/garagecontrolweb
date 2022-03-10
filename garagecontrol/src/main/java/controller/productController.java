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
			
		if (action3.equals("/novoProduto")) { // direciona para a página principal
			RequestDispatcher rd = request.getRequestDispatcher("/principal/novoProduto.jsp");
			rd.forward(request, response);
			//response.sendRedirect("/novo");
			
		} else if (action3.equals("/LoggerProduct")) { // direciona para a página principal
			RequestDispatcher rd = request.getRequestDispatcher("/principal/Logger.jsp");
			rd.forward(request, response);
			//response.sendRedirect("/Logger");
			
		} else if (action3.equals("/product")) { // direciona para a página principal
			produtos(request, response);

		} else if (action3.equals("/insertProduct")) { // direciona para a página Inserir novo Cliente
			novoProduto(request, response);

		} else if (action3.equals("/selectProduct")) { // direciona para a página selecionarr novo Cliente
			listarProduto(request, response);

		} else if (action3.equals("/updateProduct")) { // direciona para a página Editar novo Cliente
			editarProduto(request, response);

		} else if (action3.equals("/deleteProduct")) { // direciona para a página deletar um Cliente
			removerProduto(request, response);

		} else if (action3.equals("/readProduct")) { // direciona para a página pesquisar um Cliente
			pesquisarProduto(request, response);

		} else if (action3.equals("/reportProduct")) { // direciona para a página gerar relatório de clientes
			gerarRelProduto(request, response);

		} else if (action3.equals("/printerProduct")) { // direciona para a página imprimir ficha do cliente
			imprimirProduto(request, response);

		} else {
			response.sendRedirect("/principal/user.jsp"); // volta para a página principal
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
