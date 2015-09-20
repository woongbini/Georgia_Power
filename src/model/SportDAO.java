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
		// select = query문장의 객체 결과
		ResultSet rset = null;
		ArrayList<SportDTO> data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from sports_category where sport_code = ?");
			// table 존재할 경우 무조건 정상반환, 데이터 존재 유무는 매소드 통해서 검증 필수
			pstmt.setInt(1,sport_code);
			rset = pstmt.executeQuery();

			/* boolean next() : 해당 위치상의 행이 존재할 경우 true반환, 없을 경우 false */
			data = new ArrayList<SportDTO>(); // 실제 쓰일 때 바로 위에 객체 생성해주기
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
