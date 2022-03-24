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

			String sql = "INSERT INTO USERS(USE_NOME, USE_EMAIL, USE_LOGIN, USE_SENHA, USUARIO_ID, USE_PERFIL, USE_SEXO) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setString(1, objeto.getNome());
			stm.setString(2, objeto.getEmail());
			stm.setString(3, objeto.getLogin());
			stm.setString(4, objeto.getSenha());
			stm.setLong(5, userLogado); // USUARIO_ID
			stm.setString(6, objeto.getPerfil());
			stm.setString(7, objeto.getSexo());
			
			stm.execute();
			connection.commit();

		} else {
			String sql = "UPDATE USERS SET USE_NOME = ?, USE_EMAIL = ?, USE_LOGIN = ?, USE_SENHA = ?, USE_PERFIL = ?, USE_SEXO = ? WHERE USE_ID = "
					+ objeto.getId() + ";";

			PreparedStatement stmUp = connection.prepareStatement(sql);

			stmUp.setString(1, objeto.getNome());
			stmUp.setString(2, objeto.getEmail());		
			stmUp.setString(3, objeto.getLogin());
			stmUp.setString(4, objeto.getSenha());
			stmUp.setString(5, objeto.getPerfil());
			stmUp.setString(6, objeto.getSexo());

			stmUp.executeUpdate();
			connection.commit();
		}

		return this.consultaUsuario(objeto.getLogin(), userLogado);
	}
	
public List<ModelUsuario> consultaUsuarioLista(Long userLogado) throws SQLException{
		
		List<ModelUsuario> retorno = new ArrayList<ModelUsuario>();
		
		String sql = "SELECT * FROM USERS WHERE USE_ADMIN = '0' AND USUARIO_ID = " + userLogado + ";";
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
		
		String sql = "SELECT * FROM USERS WHERE UPPER(USE_NOME) LIKE UPPER(?) AND USE_ADMIN = '0' AND USUARIO_ID = ?;";
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
