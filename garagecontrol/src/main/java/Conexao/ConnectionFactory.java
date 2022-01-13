package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://luciohermano.mysql.dbaas.com.br:3306/luciohermano?characterEncoding=utf-8";
	//private String url = "jdbc:mysql://127.0.0.1:3306/luciohermano?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "luciohermano";
	private static final String PASSWORD = "Lucio#2022";

	public static Connection getConnection() {
		Connection con = null;
		
		try {
			
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			return con;
			
		} catch (Exception e) {
			System.out.println("Erro na conexão " + e.getMessage());
			return null;
		}
		
		
	}
	
	public void closeConnection(Connection con) {
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro:" + ex);
            }
        }
    }
    
        public void closeConnection(Connection con, PreparedStatement stm) {
        if (stm != null){
            try {
                stm.close();
            } catch (SQLException ex) {
                System.out.println("Erro:" + ex);
            }
        }
              closeConnection(con);
    }
        
        public void closeConnection(Connection con, PreparedStatement stm, ResultSet rs) {
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro:" + ex);
            }
        }
              closeConnection(con, stm);
    }

}
