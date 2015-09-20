package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.ShowRateDTO;
import util.DBUtil;

public class ShowRateDAO {
	// submit->����
	public static int insertratedata(String names[], int yes_or_no[], String stars[]) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// db����
		int result = 0;
		int i = 0;

		try {
			con = DBUtil.getConnection();
			System.out.println("db���� ����");

			// ratings(nickname, �� data �ֱ�!
			pstmt = con.prepareStatement("insert into ratings values(?,?,?)");

			// ������ ���� - ? ǥ������� �� ����

			for (i = 0; i < stars.length; i++) {
				pstmt.setString(1, names[i]);
				pstmt.setInt(2, yes_or_no[i]);
				pstmt.setString(3, stars[i]);
				result = pstmt.executeUpdate();// DML���� ���� �޼ҵ�
				// System.out.println("i�� ��" + i);

			}

			// DB�� insert ����

			System.out.println("db���强��");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}

	// average ���ϱ�
	public static ArrayList<ShowRateDTO> averageData() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ShowRateDTO> data = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(
					"select nickname, avg(yes_or_no), avg(rate) from ratings group by nickname");
			// ���̺� ���� �� ��� ������ ���� ��ȯ, ������ ���� ������ �޼ҵ� ���ؼ� ���� �ʼ�
			rset = pstmt.executeQuery();

			System.out.println("average ��� ����");
			data = new ArrayList<ShowRateDTO>();
			while (rset.next()) {
				data.add(new ShowRateDTO(rset.getString(1), rset.getInt(2), rset.getInt(3)));
			}

			System.out.println("db���� ����");
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}

	public static void main(String[] args) {
		// insertDept(new DeptDTO()); //������ �Ǵ��� Ȯ��
		ArrayList<ShowRateDTO> data = null;
		try {
			data = ShowRateDAO.averageData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(data);
	}

}
