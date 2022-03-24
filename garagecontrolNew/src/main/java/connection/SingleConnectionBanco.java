package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnectionBanco {
	//private static final String DRIVER = "com.mysql.cj.jdbc2.optional.MysqlConnectionPoolDataSource";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://luciohermano.mysql.dbaas.com.br:3306/luciohermano";
	//private static final String URL = "jdbc:mysql://127.0.0.1:3306/luciohermano?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "luciohermano";
	private static final String PASSWORD = "Lucio#2022";
	private static Connection connection;
			
	static {
		getConnection();
	}
	
	
	public SingleConnectionBanco() {/*quando tiver um instancia vai conectar*/
		getConnection();
	}
	public static Connection getConnection() {
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);	
			connection.setAutoCommit(false);	
			
			if (connection == null) {
				return getConnection();
			}
			
		}catch (ClassNotFoundException e) {
			System.out.println("Deu ruimmm" + e);
			e.printStackTrace();/*Mostrar qualquer erro no momento de conectar*/
			
		}catch (SQLException e) {
			System.out.println("Deu ruimmm 2" + e);
			e.printStackTrace();/*Mostrar qualquer erro no momento de conectar*/
			
		}
		return connection;
	}
	
}
