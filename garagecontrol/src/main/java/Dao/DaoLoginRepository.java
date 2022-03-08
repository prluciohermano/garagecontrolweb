package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Conexao.ConnectionFactory;
import model.ModelLogin;

public class DaoLoginRepository {

	private Connection con;
	
	public DaoLoginRepository() {	
	}
	
	public boolean validarAutentication(ModelLogin modelLogin) throws Exception {
		
		con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM USUARIO WHERE USU_LOG = ? AND USU_SENHA = ?";
		
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, modelLogin.getLogin());
		stm.setString(2, modelLogin.getSenha());
		
		ResultSet rs = stm.executeQuery();
		
		if (rs.next()) {
			return true;
		}	
		return false;
	}
}