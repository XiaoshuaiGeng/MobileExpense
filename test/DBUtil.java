package comp311;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	static String ip = "remotemysql.com";
	static int port = 3306;
	//static String database = "hutubill";
	static String database = "1upG4O4v3S";
	static String encoding = "verifyServerCertificate=false&useSSL=false";
	static String loginName = "1upG4O4v3S";
	static String password = "dl71eRA0sD";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public static Connection getConn() {

		String url = String.format("jdbc:mysql://%s:%d/%s?%s", ip, port, database, encoding);
		try {
			return DriverManager.getConnection(url, loginName, password);
			//return DriverManager.getConnection("jdbc:mysql://137.207.76.172/geng115_MobileExpense","geng115_MobileExpense","123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}