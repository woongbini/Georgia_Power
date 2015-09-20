package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//��� DAO�� ���������� ���Ǵ� �ڵ��θ� ������ ��ƿŬ����
public class DBUtil {
	// driver �ε�
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//����Ŭ������� MySQL�� ����������
			//Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ���� �ڵ� -> ����ȭ
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
