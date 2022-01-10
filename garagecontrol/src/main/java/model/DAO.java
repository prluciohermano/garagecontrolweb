package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://luciohermano.mysql.dbaas.com.br:3306/luciohermano?characterEncoding=utf-8";
	//private String url = "jdbc:mysql://127.0.0.1:3306/luciohermano?useTimezone=true&serverTimezone=UTC";
	private String user = "luciohermano";
	private String password = "Lucio#2022";

	public Connection conectar() {
		Connection con = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println("Erro na conexão " + e);
			return null;
		}
	}

	/** ------------ CREATE: INSERIR CLIENTE --------------- **/

	public void inserirCliente(JavaBeans cliente) {

		String create = "INSERT INTO PESSOA (PES_NOME, PES_RG, PES_CPF, PES_DTNASCIMENTO, PES_CEP, PES_TEL, "
				+ "PES_RUA, PES_NUM, PES_BAI, PES_CID, PES_UF, PES_COMP, PES_DTCADASTRO, PES_STATUS) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection con = conectar();

			PreparedStatement stm = con.prepareStatement(create);

			stm.setString(1, cliente.getPES_NOME().toUpperCase().trim());
			stm.setString(2, cliente.getPES_RG().toUpperCase().trim());
			stm.setString(3, cliente.getPES_CPF().toUpperCase().trim());
			stm.setString(4, cliente.getPES_DTNASCIMENTO().toUpperCase().trim());
			stm.setString(5, cliente.getPES_CEP().toUpperCase().trim());
			stm.setString(6, cliente.getPES_TEL().toUpperCase().trim());
			stm.setString(7, cliente.getPES_RUA().toUpperCase().trim());
			stm.setString(8, cliente.getPES_NUM().toUpperCase().trim());
			stm.setString(9, cliente.getPES_BAI().toUpperCase().trim());
			stm.setString(10, cliente.getPES_CID().toUpperCase().trim());
			stm.setString(11, cliente.getPES_UF().toUpperCase().trim());
			stm.setString(12, cliente.getPES_COMP().toUpperCase().trim());
			stm.setString(13, cliente.getPES_DTCADASTRO().trim());
			stm.setString(14, cliente.getPES_STATUS());

			int inserido = stm.executeUpdate();

			if (inserido > 0) {

			} else {
				System.out.println("Cliente não inserido, zé!");
			}

			con.close();

		} catch (Exception e) {
			System.out.println("Erro ao tentar inserir o cliente " + e);
		}
	}

	/** --------------- READ: LER CLIENTES --------------- **/

	public ArrayList<JavaBeans> listarClientes() {
		ArrayList<JavaBeans> clientes = new ArrayList<>();

		String read = "SELECT * FROM PESSOA ORDER BY PES_NOME";

		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(read);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				int PES_COD = rs.getInt(1);
				String PES_NOME = rs.getString(2);
				String PES_RG = rs.getString(3);
				String PES_CPF = rs.getString(4);
				String PES_DTNASCIMENTO = rs.getString(5);
				String PES_CEP = rs.getString(6);
				String PES_TEL = rs.getString(7);
				String PES_RUA = rs.getString(8);
				String PES_NUM = rs.getString(9);
				String PES_BAI = rs.getString(10);
				String PES_CID = rs.getString(11);
				String PES_UF = rs.getString(12);
				String PES_COMP = rs.getString(13);
				String PES_DTCADASTRO = rs.getString(14);
				String PES_STATUS = rs.getString(15);

				clientes.add(new JavaBeans(PES_COD, PES_NOME, PES_RG, PES_CPF, PES_DTNASCIMENTO, PES_CEP, PES_TEL,
						PES_RUA, PES_NUM, PES_BAI, PES_CID, PES_UF, PES_COMP, PES_DTCADASTRO, PES_STATUS));
			}
			con.close();
			return clientes;

		} catch (Exception e) {
			System.out.println("Erro lendo clientes: " + e);
		}
		return null;

	}

	/** --------------- SELECT: SELECIONAR UM CLIENTE --------------- **/

	public void selecionarCliente(JavaBeans cliente) {
		String read2 = "SELECT * FROM PESSOA WHERE PES_COD = ?";

		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(read2);
			stm.setInt(1, cliente.getPES_COD());
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				cliente.setPES_COD(Integer.valueOf(rs.getInt(1)));
				cliente.setPES_NOME(rs.getString(2));
				cliente.setPES_RG(rs.getString(3));
				cliente.setPES_CPF(rs.getString(4));
				cliente.setPES_DTNASCIMENTO(rs.getString(5));
				cliente.setPES_CEP(rs.getString(6));
				cliente.setPES_TEL(rs.getString(7));
				cliente.setPES_RUA(rs.getString(8));
				cliente.setPES_NUM(rs.getString(9));
				cliente.setPES_BAI(rs.getString(10));
				cliente.setPES_CID(rs.getString(11));
				cliente.setPES_UF(rs.getString(12));
				cliente.setPES_COMP(rs.getString(13));
				cliente.setPES_DTCADASTRO(rs.getString(14));
				cliente.setPES_STATUS(rs.getString(15));
			}

			con.close();

		} catch (Exception e) {
			System.out.println("Erro inserindo cliente" + e);
		}
	}
	
	/** --------------- SELECT: BUSCA UM CLIENTE POR CÓDIGO--------------- **/

	public List<JavaBeans> buscarCliente(int cliCod) {
		
		List<JavaBeans> clientes = new ArrayList<JavaBeans>();
		
		String read2 = "SELECT PES_COD, PES_NOME, PES_RG, PES_CPF, PES_DTNASCIMENTO, PES_CEP, PES_TEL, PES_RUA, PES_NUM, "
				+ "PES_BAI, PES_CID, PES_UF, PES_COMP, PES_DTCADASTRO, PES_STATUS FROM PESSOA WHERE PES_COD = " + cliCod;

		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(read2);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				JavaBeans cliente = new JavaBeans();
				cliente.setPES_COD(rs.getInt("PES_COD"));
				cliente.setPES_NOME(rs.getString("PES_NOME"));
				cliente.setPES_RG(rs.getString("PES_RG"));
				cliente.setPES_CPF(rs.getString("PES_CPF"));
				cliente.setPES_DTNASCIMENTO(rs.getString("PES_DTNASCIMENTO"));
				cliente.setPES_CEP(rs.getString("PES_CEP"));
				cliente.setPES_TEL(rs.getString("PES_TEL"));
				cliente.setPES_RUA(rs.getString("PES_RUA"));
				cliente.setPES_NUM(rs.getString("PES_NUM"));
				cliente.setPES_BAI(rs.getString("PES_BAI"));
				cliente.setPES_CID(rs.getString("PES_CID"));
				cliente.setPES_UF(rs.getString("PES_UF"));
				cliente.setPES_COMP(rs.getString("PES_COMP"));
				cliente.setPES_DTCADASTRO(rs.getString("PES_DTCADASTRO"));
				cliente.setPES_STATUS(rs.getString("PES_STATUS"));
				clientes.add(cliente);
			}

			con.close();

		} catch (Exception e) {
			System.out.println("Erro selecionando cliente" + e);
		}
		return clientes;
	}
	
	
	/** --------------- SELECT: SELECIONAR UM CLIENTE POR NOME --------------- **/

	public List<JavaBeans> pesquisaCliente(String cliente2) {
		
		String escolha = "SELECT PES_COD, PES_NOME, PES_RG, PES_CPF, PES_DTNASCIMENTO,"
                + "PES_CEP, PES_TEL, PES_RUA, PES_NUM, PES_BAI, PES_CID, PES_UF, PES_COMP, PES_DTCADASTRO,"
                + "PES_STATUS FROM PESSOA WHERE PES_NOME LIKE'%" + cliente2 + "%'";

		List<JavaBeans> pessoas = new ArrayList<>();
		
		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(escolha);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				JavaBeans pes = new JavaBeans();
				pes.setPES_COD(rs.getInt("PES_COD"));
				pes.setPES_NOME(rs.getString("PES_NOME"));
				pes.setPES_RG(rs.getString("PES_RG"));
				pes.setPES_CPF(rs.getString("PES_CPF"));
				pes.setPES_DTNASCIMENTO(rs.getString("PES_DTNASCIMENTO"));
				pes.setPES_CEP(rs.getString("PES_CEP"));
				pes.setPES_TEL(rs.getString("PES_TEL"));
				pes.setPES_RUA(rs.getString("PES_RUA"));
				pes.setPES_NUM(rs.getString("PES_NUM"));
				pes.setPES_BAI(rs.getString("PES_BAI"));
				pes.setPES_CID(rs.getString("PES_CID"));
				pes.setPES_UF(rs.getString("PES_UF"));
				pes.setPES_COMP(rs.getString("PES_COMP"));
				pes.setPES_DTCADASTRO(rs.getString("PES_DTCADASTRO"));
				pes.setPES_STATUS(rs.getString("PES_STATUS"));
				pessoas.add(pes);			
			}

			con.close();

		} catch (Exception e) {
			System.out.println("Erro pesquisand cliente" + e);
		}
		
		return pessoas;
	}

	/** ---------------- UPDATE: ALTERAR UM CLIENTE --------------- **/

	public void alterarCliente(JavaBeans cliente) {

		String edit = "UPDATE PESSOA SET PES_NOME = ?, PES_RG = ?, PES_CPF = ?, PES_DTNASCIMENTO = ?, PES_CEP = ?, "
				+ "PES_TEL = ?, PES_RUA = ?, PES_NUM = ?, PES_BAI = ?, PES_CID = ?, PES_UF = ?, PES_COMP = ?, "
				+ "PES_DTCADASTRO = ?, PES_STATUS = ? WHERE PES_COD = ?";

		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(edit);

			stm.setString(1, cliente.getPES_NOME());
			stm.setString(2, cliente.getPES_RG());
			stm.setString(3, cliente.getPES_CPF());
			stm.setString(4, cliente.getPES_DTNASCIMENTO());
			stm.setString(5, cliente.getPES_CEP());
			stm.setString(6, cliente.getPES_TEL());
			stm.setString(7, cliente.getPES_RUA());
			stm.setString(8, cliente.getPES_NUM());
			stm.setString(9, cliente.getPES_BAI());
			stm.setString(10, cliente.getPES_CID());
			stm.setString(11, cliente.getPES_UF());
			stm.setString(12, cliente.getPES_COMP());
			stm.setString(13, cliente.getPES_DTCADASTRO());
			stm.setString(14, cliente.getPES_STATUS());
			stm.setInt(15, cliente.getPES_COD());

			int alterado = stm.executeUpdate();

			if (alterado > 0) {
				// System.out.println("Cliente alterado com sucesso!");

			} else {
				System.out.println("Cliente não alterado, zé!");
			}
			con.close();

		} catch (Exception e) {
			System.out.println("Erro alterando cliente: " + e);
		}
	}

	public void deletarCliente(JavaBeans cliente) {

		String delete = "DELETE FROM PESSOA WHERE PES_COD = ?";

		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(delete);
			stm.setInt(1, cliente.getPES_COD());
			stm.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("Erro ao deletar um cliente: " + e);
		}
	}

	
}
