package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.SportDTO;
import util.DBUtil;

public class SportDAO {
	
	public static ArrayList<SportDTO> getSport(int sport_code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// select = query������ ��ü ���
		ResultSet rset = null;
		ArrayList<SportDTO> data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from sports_category where sport_code = ?");
			// table ������ ��� ������ �����ȯ, ������ ���� ������ �żҵ� ���ؼ� ���� �ʼ�
			pstmt.setInt(1,sport_code);
			rset = pstmt.executeQuery();

			/* boolean next() : �ش� ��ġ���� ���� ������ ��� true��ȯ, ���� ��� false */
			data = new ArrayList<SportDTO>(); // ���� ���� �� �ٷ� ���� ��ü �������ֱ�
			if(rset.next()) {
				data.add(new SportDTO(rset.getInt(1),rset.getString(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}
	public static void main(String[] args){
		try {
			System.out.println(getSport(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
