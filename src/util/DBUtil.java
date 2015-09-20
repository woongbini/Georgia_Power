package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//모든 DAO가 공통적으로 사용되는 코드들로만 구성된 유틸클래스
public class DBUtil {
	// driver 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//오라클써봤으니 MySQL로 연동ㄱㄱ염
			//Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 재사용 코드 -> 간결화
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","testing","1234");
		//return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","admin01","4321");
		//return DriverManager.getConnection("Mysql@127.0.0.1:3306","root","1234");
	}

	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
