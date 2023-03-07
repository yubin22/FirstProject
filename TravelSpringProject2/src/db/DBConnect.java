package db;
/**
 * DBConnect
 * 필요한가...?
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private Connection con;
	
	public DBConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "";
			url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "c##scott";
			String password = "tiger";
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException ce) {
			
			System.out.println(ce.getMessage());
			//ce.printStackTrace();
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}
	
}
