package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnectionBanco;
import model.ModelTelefone;

public class DAOTelefoneRepository {
	
	private Connection connection;
	private DAOUsuarioRepository daoUsuarioRepository = new DAOUsuarioRepository();
	
	public DAOTelefoneRepository() {
		connection = SingleConnectionBanco.getConnection();
		
		}
	
	public void gravaTelefone(ModelTelefone modelTelefone) throws SQLException {
		
		String sql = "INSERT INTO TELEFONE (TEL_NUM, USER_PAI_ID, USER_CAD_ID) VALUES (?, ?, ?)";
		
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setString(1, modelTelefone.getTel_num());
		stm.setLong(2, modelTelefone.getUser_pai_id().getId());
		stm.setLong(3, modelTelefone.getUser_cad_id().getId());
		
		stm.execute();
		connection.commit();
		
	}

	public void deleteFone (Long id) throws SQLException {
		String sql = "DELETE FROM TELEFONE WHERE TEL_ID = ?";
		
		PreparedStatement stm = connection.prepareStatement(sql);
		
		stm.setLong(1, id);
		
		stm.executeUpdate();
		connection.commit();
	}
	
	public List<ModelTelefone> listFone(Long idUserPai) throws SQLException{
		
		List<ModelTelefone> retorno = new ArrayList<ModelTelefone>();
		
		String sql = "SELECT * FROM TELEFONE WHERE USER_PAI_ID = ?";
		PreparedStatement stm = connection.prepareStatement(sql);
		
		stm.setLong(1, idUserPai);
		
		ResultSet rs = stm.executeQuery();
		
		while (rs.next()) {
			
			ModelTelefone modelTelefone = new ModelTelefone();
			
			modelTelefone.setTel_id(rs.getLong("TEL_ID"));
			modelTelefone.setTel_num(rs.getString("TEL_NUM"));
			modelTelefone.setUser_cad_id(daoUsuarioRepository.consultaUsuarioId(rs.getLong("USER_CAD_ID")));
			modelTelefone.setUser_pai_id(daoUsuarioRepository.consultaUsuarioId(rs.getLong("USER_PAI_ID")));
			
			retorno.add(modelTelefone);
		}
		
		
		return retorno;
		
	}
	
	public boolean existeFone(String fone, Long idUser) throws SQLException {
		
		String sql = "SELECT COUNT(1) > 0 FROM TELEFONE WHERE USER_PAI_ID = ? AND TEL_NUM = ? ";
		
		PreparedStatement stm = connection.prepareStatement(sql);
		
		stm.setLong(1, idUser);
		stm.setString(2, fone);
		
		ResultSet rs = stm.executeQuery();
		
		rs.next();
		
		return rs.getBoolean("existe");
		
	}
}
