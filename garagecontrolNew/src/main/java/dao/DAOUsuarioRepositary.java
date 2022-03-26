package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnectionBanco;
import model.ModelUsuario;

public class DAOUsuarioRepositary {

	private Connection connection;

	public DAOUsuarioRepositary() {

		connection = SingleConnectionBanco.getConnection();
	}

	public ModelUsuario gravarUsuario(ModelUsuario objeto, Long userLogado) throws SQLException {

		if (objeto.isNovo()) {

			String sql = "INSERT INTO USERS(USE_NOME, USE_EMAIL, USE_LOGIN, USE_SENHA, USUARIO_ID, USE_PERFIL, USE_SEXO, "
					+ "USE_CPF, USE_CEP, USE_LOGRADOURO, USE_NUMERO, USE_COMPLEMENTO, USE_BAIRRO, USE_CIDADE, USE_UF)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setString(1, objeto.getNome());
			stm.setString(2, objeto.getEmail());
			stm.setString(3, objeto.getLogin());
			stm.setString(4, objeto.getSenha());
			stm.setLong(5, userLogado); // USUARIO_ID
			stm.setString(6, objeto.getPerfil());
			stm.setString(7, objeto.getSexo());
			
			stm.setString(8, objeto.getCpf());
			stm.setString(9, objeto.getCep());
			stm.setString(10, objeto.getLogradouro());
			stm.setString(11, objeto.getNumero());
			stm.setString(12, objeto.getComplemento());
			stm.setString(13, objeto.getBairro());
			stm.setString(14, objeto.getCidade());
			stm.setString(15, objeto.getUf());
			
			stm.execute();
			connection.commit();
				
				if (objeto.getFotoUser() != null && !objeto.getFotoUser().isEmpty()) {
					sql = "UPDATE USERS SET USE_FOTOUSER = ?, USE_EXTFOTOUSER = ? WHERE USE_LOGIN = ?";
					stm = connection.prepareStatement(sql);
					stm.setString(1, objeto.getFotoUser());
					stm.setString(2, objeto.getExtensaoFotoUser());
					stm.setString(3, objeto.getLogin());
					
					stm.executeUpdate();
					connection.commit();
				}

		} else {
			
			String sql = "UPDATE USERS SET USE_NOME = ?, USE_EMAIL = ?, USE_LOGIN = ?, USE_SENHA = ?, USE_PERFIL = ?, USE_SEXO = ?, "
					+ "USE_CPF = ?, USE_CEP = ?, USE_LOGRADOURO = ?, USE_NUMERO = ?, USE_COMPLEMENTO = ?, USE_BAIRRO = ?, "
					+ "USE_CIDADE = ?, USE_UF = ? WHERE USE_ID = " + objeto.getId() + ";";

			PreparedStatement stmUp = connection.prepareStatement(sql);

			stmUp.setString(1, objeto.getNome());
			stmUp.setString(2, objeto.getEmail());		
			stmUp.setString(3, objeto.getLogin());
			stmUp.setString(4, objeto.getSenha());
			stmUp.setString(5, objeto.getPerfil());
			stmUp.setString(6, objeto.getSexo());
			
			stmUp.setString(7, objeto.getCpf());
			stmUp.setString(8, objeto.getCep());
			stmUp.setString(9, objeto.getLogradouro());
			stmUp.setString(10, objeto.getNumero());
			stmUp.setString(11, objeto.getComplemento());
			stmUp.setString(12, objeto.getBairro());
			stmUp.setString(13, objeto.getCidade());
			stmUp.setString(14, objeto.getUf());

			stmUp.executeUpdate();
			connection.commit();
			

			if (objeto.getFotoUser() != null && !objeto.getFotoUser().isEmpty()) {
				sql = "UPDATE USERS SET USE_FOTOUSER = ?, USE_EXTFOTOUSER = ? WHERE USE_ID = ?";
				stmUp = connection.prepareStatement(sql);
				stmUp.setString(1, objeto.getFotoUser());
				stmUp.setString(2, objeto.getExtensaoFotoUser());
				stmUp.setLong(3, objeto.getId());
				
				stmUp.executeUpdate();
				connection.commit();
			}
		}

		return this.consultaUsuario(objeto.getLogin(), userLogado);
	}
	
public List<ModelUsuario> consultaUsuarioListPaginada(Long userLogado, Integer offset) throws SQLException{
		
		List<ModelUsuario> retorno = new ArrayList<ModelUsuario>();
		
		String sql = "SELECT * FROM USERS WHERE USE_ADMIN = '0' AND USUARIO_ID = " + userLogado + " ORDER BY USE_NOME LIMIT 5 OFFSET " + offset + ";";
		
		PreparedStatement stm = connection.prepareStatement(sql);
		
		ResultSet rs = stm.executeQuery();
		
		while (rs.next()) {
			ModelUsuario modelUsuario = new ModelUsuario();
			modelUsuario.setId(rs.getLong("USE_ID"));
			modelUsuario.setNome(rs.getString("USE_NOME"));
			modelUsuario.setEmail(rs.getString("USE_EMAIL"));
			modelUsuario.setPerfil(rs.getString("USE_PERFIL"));
			modelUsuario.setLogin(rs.getString("USE_LOGIN"));
			modelUsuario.setUserAdmin(rs.getBoolean("USE_ADMIN"));
			modelUsuario.setSexo(rs.getString("USE_SEXO"));
			
			retorno.add(modelUsuario);
		}
		
		return retorno;
	}

public int totalPagina(Long userLogado) throws SQLException {
	
	String sql = "SELECT COUNT(1) AS TOTAL FROM USERS WHERE USUARIO_ID = " + userLogado;
	
	PreparedStatement stm = connection.prepareStatement(sql);
	
	ResultSet rs = stm.executeQuery();
	
	rs.next();
	
	Double cadastros = rs.getDouble("total");
	
	Double porPagina = 5.0;
	
	Double pagina = cadastros / porPagina;
	
	Double resto = pagina % 2;
	
	if(resto > 0) {
		pagina ++;
	}
	
	return pagina.intValue();
	
}

	
public List<ModelUsuario> consultaUsuarioLista(Long userLogado) throws SQLException{
		
		List<ModelUsuario> retorno = new ArrayList<ModelUsuario>();
		
		String sql = "SELECT * FROM USERS WHERE USE_ADMIN = '0' AND USUARIO_ID = " + userLogado + " LIMIT 5;";
		PreparedStatement stm = connection.prepareStatement(sql);
		
		ResultSet rs = stm.executeQuery();
		
		while (rs.next()) {
			ModelUsuario modelUsuario = new ModelUsuario();
			modelUsuario.setId(rs.getLong("USE_ID"));
			modelUsuario.setNome(rs.getString("USE_NOME"));
			modelUsuario.setEmail(rs.getString("USE_EMAIL"));
			modelUsuario.setPerfil(rs.getString("USE_PERFIL"));
			modelUsuario.setLogin(rs.getString("USE_LOGIN"));
			modelUsuario.setUserAdmin(rs.getBoolean("USE_ADMIN"));
			modelUsuario.setSexo(rs.getString("USE_SEXO"));
			
			retorno.add(modelUsuario);
		}
		
		return retorno;
	}

	
	public List<ModelUsuario> consultaUsuarioList(String nome, Long userLogado) throws SQLException{
		
		List<ModelUsuario> retorno = new ArrayList<ModelUsuario>();
		
		String sql = "SELECT * FROM USERS WHERE UPPER(USE_NOME) LIKE UPPER(?) AND USE_ADMIN = '0' AND USUARIO_ID = ? LIMIT 5;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setString(1, "%" + nome + "%");
		stm.setLong(2, userLogado);
		
		ResultSet rs = stm.executeQuery();
		
		while (rs.next()) {
			ModelUsuario modelUsuario = new ModelUsuario();
			modelUsuario.setId(rs.getLong("USE_ID"));
			modelUsuario.setNome(rs.getString("USE_NOME"));
			modelUsuario.setEmail(rs.getString("USE_EMAIL"));
			modelUsuario.setLogin(rs.getString("USE_LOGIN"));
			modelUsuario.setUserAdmin(rs.getBoolean("USE_ADMIN"));
			modelUsuario.setPerfil(rs.getString("USE_PERFIL"));
			modelUsuario.setSexo(rs.getString("USE_SEXO"));
			retorno.add(modelUsuario);
		}
		
		return retorno;
	}

	public ModelUsuario consultaUsuario(String login) throws SQLException {

		ModelUsuario modelUsuario = new ModelUsuario();

		String sql = "SELECT * FROM USERS WHERE UPPER(USE_LOGIN) = UPPER('" + login + "') AND USE_ADMIN = '0';";

		PreparedStatement stm = connection.prepareStatement(sql);

		ResultSet rs = stm.executeQuery();

		while (rs.next()) { /* Se tem resultado */

			modelUsuario.setId(rs.getLong("USE_ID"));
			modelUsuario.setNome(rs.getString("USE_NOME"));
			modelUsuario.setEmail(rs.getString("USE_EMAIL"));
			modelUsuario.setLogin(rs.getString("USE_LOGIN"));
			modelUsuario.setSenha(rs.getString("USE_SENHA"));
			modelUsuario.setUserAdmin(rs.getBoolean("USE_ADMIN"));
			modelUsuario.setPerfil(rs.getString("USE_PERFIL"));
			modelUsuario.setSexo(rs.getString("USE_SEXO"));
			
			modelUsuario.setCpf(rs.getString("USE_CPF"));
			modelUsuario.setCep(rs.getString("USE_CEP"));
			modelUsuario.setLogradouro(rs.getString("USE_LOGRADOURO"));
			modelUsuario.setNumero(rs.getString("USE_NUMERO"));
			modelUsuario.setComplemento(rs.getString("USE_COMPLEMENTO"));
			modelUsuario.setBairro(rs.getString("USE_BAIRRO"));
			modelUsuario.setCidade(rs.getString("USE_CIDADE"));
			modelUsuario.setUf(rs.getString("USE_UF"));
		}

		return modelUsuario;
	}
	
	
	public ModelUsuario consultaUsuarioLogado(String login) throws SQLException {

		ModelUsuario modelUsuario = new ModelUsuario();

		String sql = "SELECT * FROM USERS WHERE UPPER(USE_LOGIN) = UPPER('" + login + "');";

		PreparedStatement stm = connection.prepareStatement(sql);

		ResultSet rs = stm.executeQuery();

		while (rs.next()) { /* Se tem resultado */

			modelUsuario.setId(rs.getLong("USE_ID"));
			modelUsuario.setNome(rs.getString("USE_NOME"));
			modelUsuario.setEmail(rs.getString("USE_EMAIL"));
			modelUsuario.setLogin(rs.getString("USE_LOGIN"));
			modelUsuario.setSenha(rs.getString("USE_SENHA"));
			modelUsuario.setUserAdmin(rs.getBoolean("USE_ADMIN"));
			modelUsuario.setPerfil(rs.getString("USE_PERFIL"));
			modelUsuario.setSexo(rs.getString("USE_SEXO"));
			modelUsuario.setFotoUser(rs.getString("USE_FOTOUSER"));
			
			modelUsuario.setCpf(rs.getString("USE_CPF"));
			modelUsuario.setCep(rs.getString("USE_CEP"));
			modelUsuario.setLogradouro(rs.getString("USE_LOGRADOURO"));
			modelUsuario.setNumero(rs.getString("USE_NUMERO"));
			modelUsuario.setComplemento(rs.getString("USE_COMPLEMENTO"));
			modelUsuario.setBairro(rs.getString("USE_BAIRRO"));
			modelUsuario.setCidade(rs.getString("USE_CIDADE"));
			modelUsuario.setUf(rs.getString("USE_UF"));
		}

		return modelUsuario;
	}
	
	
	public ModelUsuario consultaUsuario(String login, Long userLogado) throws SQLException {

		ModelUsuario modelUsuario = new ModelUsuario();

		String sql = "SELECT * FROM USERS WHERE UPPER(USE_LOGIN) = UPPER('" + login + "') AND USE_ADMIN = '0' AND USUARIO_ID = " + userLogado + ";";

		PreparedStatement stm = connection.prepareStatement(sql);

		ResultSet rs = stm.executeQuery();

		while (rs.next()) { /* Se tem resultado */

			modelUsuario.setId(rs.getLong("USE_ID"));
			modelUsuario.setNome(rs.getString("USE_NOME"));
			modelUsuario.setEmail(rs.getString("USE_EMAIL"));
			modelUsuario.setLogin(rs.getString("USE_LOGIN"));
			modelUsuario.setSenha(rs.getString("USE_SENHA"));
			modelUsuario.setUserAdmin(rs.getBoolean("USE_ADMIN"));
			modelUsuario.setPerfil(rs.getString("USE_PERFIL"));
			modelUsuario.setSexo(rs.getString("USE_SEXO"));
			modelUsuario.setFotoUser(rs.getString("USE_FOTOUSER"));
			
			modelUsuario.setCpf(rs.getString("USE_CPF"));
			modelUsuario.setCep(rs.getString("USE_CEP"));
			modelUsuario.setLogradouro(rs.getString("USE_LOGRADOURO"));
			modelUsuario.setNumero(rs.getString("USE_NUMERO"));
			modelUsuario.setComplemento(rs.getString("USE_COMPLEMENTO"));
			modelUsuario.setBairro(rs.getString("USE_BAIRRO"));
			modelUsuario.setCidade(rs.getString("USE_CIDADE"));
			modelUsuario.setUf(rs.getString("USE_UF"));
		}

		return modelUsuario;
	}
	
	public ModelUsuario consultaUsuarioID(String id, Long userLogado) throws SQLException {

		ModelUsuario modelUsuario = new ModelUsuario();

		String sql = "SELECT * FROM USERS WHERE USE_ID = ? AND USE_ADMIN = '0' AND USUARIO_ID = ?;";

		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setLong(1, Long.parseLong(id));
		stm.setLong(2, userLogado);

		ResultSet rs = stm.executeQuery();

		while (rs.next()) { /* Se tem resultado */

			modelUsuario.setId(rs.getLong("USE_ID"));
			modelUsuario.setNome(rs.getString("USE_NOME"));
			modelUsuario.setEmail(rs.getString("USE_EMAIL"));
			modelUsuario.setLogin(rs.getString("USE_LOGIN"));
			modelUsuario.setSenha(rs.getString("USE_SENHA"));
			modelUsuario.setUserAdmin(rs.getBoolean("USE_ADMIN"));
			modelUsuario.setPerfil(rs.getString("USE_PERFIL"));
			modelUsuario.setSexo(rs.getString("USE_SEXO"));
			modelUsuario.setFotoUser(rs.getString("USE_FOTOUSER"));
			modelUsuario.setExtensaoFotoUser(rs.getString("USE_EXTFOTOUSER"));
			
			modelUsuario.setCpf(rs.getString("USE_CPF"));
			modelUsuario.setCep(rs.getString("USE_CEP"));
			modelUsuario.setLogradouro(rs.getString("USE_LOGRADOURO"));
			modelUsuario.setNumero(rs.getString("USE_NUMERO"));
			modelUsuario.setComplemento(rs.getString("USE_COMPLEMENTO"));
			modelUsuario.setBairro(rs.getString("USE_BAIRRO"));
			modelUsuario.setCidade(rs.getString("USE_CIDADE"));
			modelUsuario.setUf(rs.getString("USE_UF"));
		}

		return modelUsuario;
	}

	public boolean validarLogin(String login) throws SQLException {

		String sql = "SELECT COUNT(1) > 0 AS EXISTE FROM USERS WHERE UPPER(USE_LOGIN) = UPPER('" + login + "')";

		PreparedStatement stm = connection.prepareStatement(sql);

		ResultSet rs = stm.executeQuery();

		if (rs.next()) {
			return rs.getBoolean("EXISTE");
		}

		return false;
	}
	
	public void deletarUser(String idUser) throws SQLException {
		String sql = "DELETE FROM USERS WHERE USE_ID = ? AND USE_ADMIN = '0';";
		PreparedStatement stm = connection.prepareStatement(sql);
		
		stm.setLong(1, Long.parseLong(idUser));
		stm.executeUpdate();
		connection.commit();
	}

}
