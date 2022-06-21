package Utilidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConexion {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConexion(){
	Connection conn =null;
	String database="champion";
	String url = "jdbc:mysql://localhost:3306/"+database+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String user = "root";
	String password = "root";
	try {
		conn = DriverManager.getConnection(url, user,password);
		} catch
		(SQLException e) {
		e.printStackTrace();
		}
		return conn;
		}

}
