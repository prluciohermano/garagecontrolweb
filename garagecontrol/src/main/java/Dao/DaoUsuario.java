package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Conexao.ConnectionFactory;
import model.Usuario;

public class DaoUsuario {
	
	private Connection con = null;

//----------------------- BUSCAR USUÁRIOS -------------------------------\\

	public ArrayList<Usuario> listarUsuario() {
		con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
        ResultSet rs = null;
		
		ArrayList<Usuario> usuarios = new ArrayList<>();

		String sql = "SELECT * FROM USUARIO";

		try {
			
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				int USU_COD = rs.getInt(1);
				String USU_USUARIO = rs.getString(2);
				String USU_LOG = rs.getString(3);
				String USU_SEN = rs.getString(4);
				String USU_PER = rs.getString(5);
				
				usuarios.add(new Usuario(USU_COD, USU_USUARIO, USU_LOG, USU_SEN, USU_PER));
			}
			con.close();
			return usuarios;
			
		} catch (Exception e) {
			System.out.println("Erro lendo usuários: " + e);
		}
		return null;
	}



}
